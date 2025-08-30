package androidx.camera.core.streamsharing;

import android.graphics.Rect;
import android.util.Pair;
import android.util.Size;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.concurrent.DualOutConfig;
import androidx.camera.core.processing.util.OutConfig;
import androidx.camera.core.streamsharing.StreamSharing;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class VirtualCameraAdapter implements UseCase.StateChangeCallback {
    @NonNull
    final Set<UseCase> mChildren;
    @NonNull
    final Map<UseCase, Boolean> mChildrenActiveState = new HashMap();
    @NonNull
    private final Set<UseCaseConfig<?>> mChildrenConfigs;
    @NonNull
    private final Map<UseCase, UseCaseConfig<?>> mChildrenConfigsMap;
    @NonNull
    final Map<UseCase, SurfaceEdge> mChildrenEdges = new HashMap();
    @NonNull
    private final Map<UseCase, VirtualCamera> mChildrenVirtualCameras = new HashMap();
    @NonNull
    private final CameraInternal mParentCamera;
    @NonNull
    private final CameraCaptureCallback mParentMetadataCallback = createCameraCaptureCallback();
    @NonNull
    private final ResolutionsMerger mResolutionsMerger;
    @Nullable
    private final CameraInternal mSecondaryParentCamera;
    @Nullable
    private ResolutionsMerger mSecondaryResolutionsMerger;
    @NonNull
    private final UseCaseConfigFactory mUseCaseConfigFactory;

    public VirtualCameraAdapter(@NonNull CameraInternal cameraInternal, @Nullable CameraInternal cameraInternal2, @NonNull Set<UseCase> set, @NonNull UseCaseConfigFactory useCaseConfigFactory, @NonNull StreamSharing.Control control) {
        this.mParentCamera = cameraInternal;
        this.mSecondaryParentCamera = cameraInternal2;
        this.mUseCaseConfigFactory = useCaseConfigFactory;
        this.mChildren = set;
        Map<UseCase, UseCaseConfig<?>> childrenConfigsMap = toChildrenConfigsMap(cameraInternal, set, useCaseConfigFactory);
        this.mChildrenConfigsMap = childrenConfigsMap;
        HashSet hashSet = new HashSet(childrenConfigsMap.values());
        this.mChildrenConfigs = hashSet;
        this.mResolutionsMerger = new ResolutionsMerger(cameraInternal, hashSet);
        if (cameraInternal2 != null) {
            this.mSecondaryResolutionsMerger = new ResolutionsMerger(cameraInternal2, hashSet);
        }
        for (UseCase next : set) {
            this.mChildrenActiveState.put(next, Boolean.FALSE);
            this.mChildrenVirtualCameras.put(next, new VirtualCamera(cameraInternal, this, control));
        }
    }

    @NonNull
    private OutConfig calculateOutConfig(@NonNull UseCase useCase, @NonNull ResolutionsMerger resolutionsMerger, @NonNull CameraInternal cameraInternal, @Nullable SurfaceEdge surfaceEdge, int i, boolean z) {
        int sensorRotationDegrees = cameraInternal.getCameraInfo().getSensorRotationDegrees(i);
        boolean isMirrored = TransformUtils.isMirrored(surfaceEdge.getSensorToBufferTransform());
        UseCaseConfig useCaseConfig = this.mChildrenConfigsMap.get(useCase);
        Objects.requireNonNull(useCaseConfig);
        Pair<Rect, Size> preferredChildSizePair = resolutionsMerger.getPreferredChildSizePair(useCaseConfig, surfaceEdge.getCropRect(), TransformUtils.getRotationDegrees(surfaceEdge.getSensorToBufferTransform()), z);
        int childRotationDegrees = getChildRotationDegrees(useCase, this.mParentCamera);
        VirtualCamera virtualCamera = this.mChildrenVirtualCameras.get(useCase);
        Objects.requireNonNull(virtualCamera);
        virtualCamera.setRotationDegrees(childRotationDegrees);
        int within360 = TransformUtils.within360((surfaceEdge.getRotationDegrees() + childRotationDegrees) - sensorRotationDegrees);
        return OutConfig.of(getChildTargetType(useCase), getChildFormat(useCase), (Rect) preferredChildSizePair.first, TransformUtils.rotateSize((Size) preferredChildSizePair.second, within360), within360, useCase.isMirroringRequired(cameraInternal) ^ isMirrored);
    }

    private static void forceSetProvider(@NonNull SurfaceEdge surfaceEdge, @NonNull DeferrableSurface deferrableSurface, @NonNull SessionConfig sessionConfig) {
        surfaceEdge.invalidate();
        try {
            surfaceEdge.setProvider(deferrableSurface);
        } catch (DeferrableSurface.SurfaceClosedException unused) {
            if (sessionConfig.getErrorListener() != null) {
                sessionConfig.getErrorListener().onError(sessionConfig, SessionConfig.SessionError.SESSION_ERROR_SURFACE_NEEDS_RESET);
            }
        }
    }

    private static int getChildFormat(@NonNull UseCase useCase) {
        if (useCase instanceof ImageCapture) {
            return 256;
        }
        return 34;
    }

    @IntRange(from = 0, to = 359)
    private int getChildRotationDegrees(@NonNull UseCase useCase, @NonNull CameraInternal cameraInternal) {
        return cameraInternal.getCameraInfo().getSensorRotationDegrees(((ImageOutputConfig) useCase.getCurrentConfig()).getTargetRotation(0));
    }

    @VisibleForTesting
    @Nullable
    public static DeferrableSurface getChildSurface(@NonNull UseCase useCase) {
        List<DeferrableSurface> list;
        boolean z;
        if (useCase instanceof ImageCapture) {
            list = useCase.getSessionConfig().getSurfaces();
        } else {
            list = useCase.getSessionConfig().getRepeatingCaptureConfig().getSurfaces();
        }
        if (list.size() <= 1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    private static int getChildTargetType(@NonNull UseCase useCase) {
        if (useCase instanceof Preview) {
            return 1;
        }
        if (useCase instanceof ImageCapture) {
            return 4;
        }
        return 2;
    }

    private static int getHighestSurfacePriority(Set<UseCaseConfig<?>> set) {
        int i = 0;
        for (UseCaseConfig<?> surfaceOccupancyPriority : set) {
            i = Math.max(i, surfaceOccupancyPriority.getSurfaceOccupancyPriority(0));
        }
        return i;
    }

    @NonNull
    private SurfaceEdge getUseCaseEdge(@NonNull UseCase useCase) {
        SurfaceEdge surfaceEdge = this.mChildrenEdges.get(useCase);
        Objects.requireNonNull(surfaceEdge);
        return surfaceEdge;
    }

    private boolean isUseCaseActive(@NonNull UseCase useCase) {
        Boolean bool = this.mChildrenActiveState.get(useCase);
        Objects.requireNonNull(bool);
        return bool.booleanValue();
    }

    public static void sendCameraCaptureResultToChild(@NonNull CameraCaptureResult cameraCaptureResult, @NonNull SessionConfig sessionConfig, int i) {
        for (CameraCaptureCallback onCaptureCompleted : sessionConfig.getRepeatingCameraCaptureCallbacks()) {
            onCaptureCompleted.onCaptureCompleted(i, new VirtualCameraCaptureResult(sessionConfig.getRepeatingCaptureConfig().getTagBundle(), cameraCaptureResult));
        }
    }

    @NonNull
    private static Map<UseCase, UseCaseConfig<?>> toChildrenConfigsMap(@NonNull CameraInternal cameraInternal, @NonNull Set<UseCase> set, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        HashMap hashMap = new HashMap();
        for (UseCase next : set) {
            hashMap.put(next, next.mergeConfigs(cameraInternal.getCameraInfoInternal(), (UseCaseConfig<?>) null, next.getDefaultConfig(true, useCaseConfigFactory)));
        }
        return hashMap;
    }

    public void bindChildren() {
        for (UseCase next : this.mChildren) {
            VirtualCamera virtualCamera = this.mChildrenVirtualCameras.get(next);
            Objects.requireNonNull(virtualCamera);
            next.bindToCamera(virtualCamera, (CameraInternal) null, (UseCaseConfig<?>) null, next.getDefaultConfig(true, this.mUseCaseConfigFactory));
        }
    }

    public CameraCaptureCallback createCameraCaptureCallback() {
        return new CameraCaptureCallback() {
            public void onCaptureCompleted(int i, @NonNull CameraCaptureResult cameraCaptureResult) {
                super.onCaptureCompleted(i, cameraCaptureResult);
                for (UseCase sessionConfig : VirtualCameraAdapter.this.mChildren) {
                    VirtualCameraAdapter.sendCameraCaptureResultToChild(cameraCaptureResult, sessionConfig.getSessionConfig(), i);
                }
            }
        };
    }

    @NonNull
    public Set<UseCase> getChildren() {
        return this.mChildren;
    }

    @NonNull
    public Map<UseCase, OutConfig> getChildrenOutConfigs(@NonNull SurfaceEdge surfaceEdge, int i, boolean z) {
        HashMap hashMap = new HashMap();
        for (UseCase next : this.mChildren) {
            hashMap.put(next, calculateOutConfig(next, this.mResolutionsMerger, this.mParentCamera, surfaceEdge, i, z));
        }
        return hashMap;
    }

    @NonNull
    public CameraCaptureCallback getParentMetadataCallback() {
        return this.mParentMetadataCallback;
    }

    public void mergeChildrenConfigs(@NonNull MutableConfig mutableConfig) {
        mutableConfig.insertOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, this.mResolutionsMerger.getMergedResolutions(mutableConfig));
        mutableConfig.insertOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(getHighestSurfacePriority(this.mChildrenConfigs)));
        DynamicRange resolveDynamicRange = DynamicRangeUtils.resolveDynamicRange(this.mChildrenConfigs);
        if (resolveDynamicRange != null) {
            mutableConfig.insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, resolveDynamicRange);
            for (UseCase next : this.mChildren) {
                if (next.getCurrentConfig().getVideoStabilizationMode() != 0) {
                    mutableConfig.insertOption(UseCaseConfig.OPTION_VIDEO_STABILIZATION_MODE, Integer.valueOf(next.getCurrentConfig().getVideoStabilizationMode()));
                }
                if (next.getCurrentConfig().getPreviewStabilizationMode() != 0) {
                    mutableConfig.insertOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE, Integer.valueOf(next.getCurrentConfig().getPreviewStabilizationMode()));
                }
            }
            return;
        }
        throw new IllegalArgumentException("Failed to merge child dynamic ranges, can not find a dynamic range that satisfies all children.");
    }

    public void notifyStateAttached() {
        for (UseCase next : this.mChildren) {
            next.onStateAttached();
            next.onCameraControlReady();
        }
    }

    public void notifyStateDetached() {
        for (UseCase onStateDetached : this.mChildren) {
            onStateDetached.onStateDetached();
        }
    }

    @MainThread
    public void onUseCaseActive(@NonNull UseCase useCase) {
        Threads.checkMainThread();
        if (!isUseCaseActive(useCase)) {
            this.mChildrenActiveState.put(useCase, Boolean.TRUE);
            DeferrableSurface childSurface = getChildSurface(useCase);
            if (childSurface != null) {
                forceSetProvider(getUseCaseEdge(useCase), childSurface, useCase.getSessionConfig());
            }
        }
    }

    @MainThread
    public void onUseCaseInactive(@NonNull UseCase useCase) {
        Threads.checkMainThread();
        if (isUseCaseActive(useCase)) {
            this.mChildrenActiveState.put(useCase, Boolean.FALSE);
            getUseCaseEdge(useCase).disconnect();
        }
    }

    @MainThread
    public void onUseCaseReset(@NonNull UseCase useCase) {
        DeferrableSurface childSurface;
        Threads.checkMainThread();
        SurfaceEdge useCaseEdge = getUseCaseEdge(useCase);
        if (isUseCaseActive(useCase) && (childSurface = getChildSurface(useCase)) != null) {
            forceSetProvider(useCaseEdge, childSurface, useCase.getSessionConfig());
        }
    }

    @MainThread
    public void onUseCaseUpdated(@NonNull UseCase useCase) {
        Threads.checkMainThread();
        if (isUseCaseActive(useCase)) {
            SurfaceEdge useCaseEdge = getUseCaseEdge(useCase);
            DeferrableSurface childSurface = getChildSurface(useCase);
            if (childSurface != null) {
                forceSetProvider(useCaseEdge, childSurface, useCase.getSessionConfig());
            } else {
                useCaseEdge.disconnect();
            }
        }
    }

    public void resetChildren() {
        Threads.checkMainThread();
        for (UseCase onUseCaseReset : this.mChildren) {
            onUseCaseReset(onUseCaseReset);
        }
    }

    public void setChildrenEdges(@NonNull Map<UseCase, SurfaceEdge> map) {
        this.mChildrenEdges.clear();
        this.mChildrenEdges.putAll(map);
        for (Map.Entry next : this.mChildrenEdges.entrySet()) {
            UseCase useCase = (UseCase) next.getKey();
            SurfaceEdge surfaceEdge = (SurfaceEdge) next.getValue();
            useCase.setViewPortCropRect(surfaceEdge.getCropRect());
            useCase.setSensorToBufferTransformMatrix(surfaceEdge.getSensorToBufferTransform());
            useCase.updateSuggestedStreamSpec(surfaceEdge.getStreamSpec(), (StreamSpec) null);
            useCase.notifyState();
        }
    }

    public void unbindChildren() {
        for (UseCase next : this.mChildren) {
            VirtualCamera virtualCamera = this.mChildrenVirtualCameras.get(next);
            Objects.requireNonNull(virtualCamera);
            next.unbindFromCamera(virtualCamera);
        }
    }

    @NonNull
    public Map<UseCase, DualOutConfig> getChildrenOutConfigs(@NonNull SurfaceEdge surfaceEdge, @NonNull SurfaceEdge surfaceEdge2, int i, boolean z) {
        HashMap hashMap = new HashMap();
        for (UseCase next : this.mChildren) {
            UseCase useCase = next;
            int i2 = i;
            boolean z2 = z;
            OutConfig calculateOutConfig = calculateOutConfig(useCase, this.mResolutionsMerger, this.mParentCamera, surfaceEdge, i2, z2);
            ResolutionsMerger resolutionsMerger = this.mSecondaryResolutionsMerger;
            CameraInternal cameraInternal = this.mSecondaryParentCamera;
            Objects.requireNonNull(cameraInternal);
            hashMap.put(next, DualOutConfig.of(calculateOutConfig, calculateOutConfig(useCase, resolutionsMerger, cameraInternal, surfaceEdge2, i2, z2)));
        }
        return hashMap;
    }
}
