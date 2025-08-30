package androidx.camera.core.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ExperimentalImageCaptureOutputFormat;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.LayoutSettings;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Identifier;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.RestrictedCameraControl;
import androidx.camera.core.impl.RestrictedCameraInfo;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.streamsharing.StreamSharing;
import androidx.core.util.Preconditions;
import com.google.auto.value.AutoValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class CameraUseCaseAdapter implements Camera {
    private static final String TAG = "CameraUseCaseAdapter";
    @NonNull
    private final RestrictedCameraControl mAdapterCameraControl;
    @NonNull
    private final RestrictedCameraInfo mAdapterCameraInfo;
    @Nullable
    private final RestrictedCameraInfo mAdapterSecondaryCameraInfo;
    @GuardedBy("mLock")
    private final List<UseCase> mAppUseCases;
    @GuardedBy("mLock")
    private boolean mAttached;
    @GuardedBy("mLock")
    @NonNull
    private final CameraConfig mCameraConfig;
    @GuardedBy("mLock")
    private final CameraCoordinator mCameraCoordinator;
    private final CameraDeviceSurfaceManager mCameraDeviceSurfaceManager;
    @NonNull
    private final CameraInternal mCameraInternal;
    @GuardedBy("mLock")
    private final List<UseCase> mCameraUseCases;
    @GuardedBy("mLock")
    @NonNull
    private List<CameraEffect> mEffects;
    private final CameraId mId;
    @GuardedBy("mLock")
    private Config mInteropConfig;
    @NonNull
    private final LayoutSettings mLayoutSettings;
    private final Object mLock;
    @GuardedBy("mLock")
    @Nullable
    private UseCase mPlaceholderForExtensions;
    @Nullable
    private final CameraInternal mSecondaryCameraInternal;
    @NonNull
    private final LayoutSettings mSecondaryLayoutSettings;
    @GuardedBy("mLock")
    @Nullable
    private StreamSharing mStreamSharing;
    private final UseCaseConfigFactory mUseCaseConfigFactory;
    @GuardedBy("mLock")
    @Nullable
    private ViewPort mViewPort;

    public static final class CameraException extends Exception {
        public CameraException() {
        }

        public CameraException(@NonNull String str) {
            super(str);
        }

        public CameraException(@NonNull Throwable th) {
            super(th);
        }
    }

    @AutoValue
    public static abstract class CameraId {
        @NonNull
        public static CameraId create(@NonNull String str, @NonNull Identifier identifier) {
            return new AutoValue_CameraUseCaseAdapter_CameraId(str, identifier);
        }

        @NonNull
        public abstract Identifier getCameraConfigId();

        @NonNull
        public abstract String getCameraIdString();
    }

    public static class ConfigPair {
        UseCaseConfig<?> mCameraConfig;
        UseCaseConfig<?> mExtendedConfig;

        public ConfigPair(UseCaseConfig<?> useCaseConfig, UseCaseConfig<?> useCaseConfig2) {
            this.mExtendedConfig = useCaseConfig;
            this.mCameraConfig = useCaseConfig2;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CameraUseCaseAdapter(@androidx.annotation.NonNull androidx.camera.core.impl.CameraInternal r11, @androidx.annotation.NonNull androidx.camera.core.concurrent.CameraCoordinator r12, @androidx.annotation.NonNull androidx.camera.core.impl.CameraDeviceSurfaceManager r13, @androidx.annotation.NonNull androidx.camera.core.impl.UseCaseConfigFactory r14) {
        /*
            r10 = this;
            androidx.camera.core.impl.RestrictedCameraInfo r3 = new androidx.camera.core.impl.RestrictedCameraInfo
            androidx.camera.core.impl.CameraInfoInternal r0 = r11.getCameraInfoInternal()
            androidx.camera.core.impl.CameraConfig r1 = androidx.camera.core.impl.CameraConfigs.defaultConfig()
            r3.<init>(r0, r1)
            r4 = 0
            androidx.camera.core.LayoutSettings r6 = androidx.camera.core.LayoutSettings.DEFAULT
            r2 = 0
            r0 = r10
            r1 = r11
            r5 = r6
            r7 = r12
            r8 = r13
            r9 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.internal.CameraUseCaseAdapter.<init>(androidx.camera.core.impl.CameraInternal, androidx.camera.core.concurrent.CameraCoordinator, androidx.camera.core.impl.CameraDeviceSurfaceManager, androidx.camera.core.impl.UseCaseConfigFactory):void");
    }

    private void cacheInteropConfig() {
        synchronized (this.mLock) {
            CameraControlInternal cameraControlInternal = this.mCameraInternal.getCameraControlInternal();
            this.mInteropConfig = cameraControlInternal.getInteropConfig();
            cameraControlInternal.clearInteropConfig();
        }
    }

    public static Collection<UseCase> calculateCameraUseCases(@NonNull Collection<UseCase> collection, @Nullable UseCase useCase, @Nullable StreamSharing streamSharing) {
        ArrayList arrayList = new ArrayList(collection);
        if (useCase != null) {
            arrayList.add(useCase);
        }
        if (streamSharing != null) {
            arrayList.add(streamSharing);
            arrayList.removeAll(streamSharing.getChildren());
        }
        return arrayList;
    }

    @Nullable
    private UseCase calculatePlaceholderForExtensions(@NonNull Collection<UseCase> collection, @Nullable StreamSharing streamSharing) {
        UseCase useCase;
        synchronized (this.mLock) {
            try {
                ArrayList arrayList = new ArrayList(collection);
                if (streamSharing != null) {
                    arrayList.add(streamSharing);
                    arrayList.removeAll(streamSharing.getChildren());
                }
                if (isCoexistingPreviewImageCaptureRequired()) {
                    if (isExtraPreviewRequired(arrayList)) {
                        if (isPreview(this.mPlaceholderForExtensions)) {
                            useCase = this.mPlaceholderForExtensions;
                        } else {
                            useCase = createExtraPreview();
                        }
                    } else if (isExtraImageCaptureRequired(arrayList)) {
                        if (isImageCapture(this.mPlaceholderForExtensions)) {
                            useCase = this.mPlaceholderForExtensions;
                        } else {
                            useCase = createExtraImageCapture();
                        }
                    }
                }
                useCase = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return useCase;
    }

    @NonNull
    private static Matrix calculateSensorToBufferTransformMatrix(@NonNull Rect rect, @NonNull Size size) {
        boolean z;
        if (rect.width() <= 0 || rect.height() <= 0) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF rectF = new RectF(rect);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, (float) size.getWidth(), (float) size.getHeight()), rectF, Matrix.ScaleToFit.CENTER);
        matrix.invert(matrix);
        return matrix;
    }

    private Map<UseCase, StreamSpec> calculateSuggestedStreamSpecs(int i, @NonNull CameraInfoInternal cameraInfoInternal, @NonNull Collection<UseCase> collection, @NonNull Collection<UseCase> collection2, @NonNull Map<UseCase, ConfigPair> map) {
        Size size;
        Rect rect;
        boolean z;
        CameraInfoInternal cameraInfoInternal2 = cameraInfoInternal;
        ArrayList arrayList = new ArrayList();
        String cameraId = cameraInfoInternal.getCameraId();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Iterator<UseCase> it = collection2.iterator();
        while (true) {
            size = null;
            if (!it.hasNext()) {
                break;
            }
            UseCase next = it.next();
            AttachedSurfaceInfo create = AttachedSurfaceInfo.create(this.mCameraDeviceSurfaceManager.transformSurfaceConfig(i, cameraId, next.getImageFormat(), next.getAttachedSurfaceResolution()), next.getImageFormat(), next.getAttachedSurfaceResolution(), ((StreamSpec) Preconditions.checkNotNull(next.getAttachedStreamSpec())).getDynamicRange(), StreamSharing.getCaptureTypes(next), next.getAttachedStreamSpec().getImplementationOptions(), next.getCurrentConfig().getTargetFrameRate((Range<Integer>) null));
            arrayList.add(create);
            hashMap2.put(create, next);
            hashMap.put(next, next.getAttachedStreamSpec());
        }
        int i2 = i;
        if (!collection.isEmpty()) {
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = new HashMap();
            try {
                rect = this.mCameraInternal.getCameraControlInternal().getSensorRect();
            } catch (NullPointerException unused) {
                rect = null;
            }
            if (rect != null) {
                size = TransformUtils.rectToSize(rect);
            }
            SupportedOutputSizesSorter supportedOutputSizesSorter = new SupportedOutputSizesSorter(cameraInfoInternal2, size);
            Iterator<UseCase> it2 = collection.iterator();
            loop1:
            while (true) {
                z = false;
                while (true) {
                    if (!it2.hasNext()) {
                        break loop1;
                    }
                    UseCase next2 = it2.next();
                    ConfigPair configPair = map.get(next2);
                    UseCaseConfig<?> mergeConfigs = next2.mergeConfigs(cameraInfoInternal2, configPair.mExtendedConfig, configPair.mCameraConfig);
                    hashMap3.put(mergeConfigs, next2);
                    hashMap4.put(mergeConfigs, supportedOutputSizesSorter.getSortedSupportedOutputSizes(mergeConfigs));
                    if (next2.getCurrentConfig() instanceof PreviewConfig) {
                        PreviewConfig previewConfig = (PreviewConfig) next2.getCurrentConfig();
                        previewConfig.getClass();
                        if (qg.h(previewConfig) == 2) {
                            z = true;
                        }
                    }
                }
            }
            Pair<Map<UseCaseConfig<?>, StreamSpec>, Map<AttachedSurfaceInfo, StreamSpec>> suggestedStreamSpecs = this.mCameraDeviceSurfaceManager.getSuggestedStreamSpecs(i, cameraId, arrayList, hashMap4, z, hasVideoCapture(collection));
            for (Map.Entry entry : hashMap3.entrySet()) {
                hashMap.put((UseCase) entry.getValue(), (StreamSpec) ((Map) suggestedStreamSpecs.first).get(entry.getKey()));
            }
            for (Map.Entry entry2 : ((Map) suggestedStreamSpecs.second).entrySet()) {
                if (hashMap2.containsKey(entry2.getKey())) {
                    hashMap.put((UseCase) hashMap2.get(entry2.getKey()), (StreamSpec) entry2.getValue());
                }
            }
        }
        return hashMap;
    }

    private void checkUnsupportedFeatureCombinationAndThrow(@NonNull Collection<UseCase> collection) throws IllegalArgumentException {
        if (hasExtension()) {
            if (hasNonSdrConfig(collection)) {
                throw new IllegalArgumentException("Extensions are only supported for use with standard dynamic range.");
            } else if (hasUltraHdrImageCapture(collection)) {
                throw new IllegalArgumentException("Extensions are not supported for use with Ultra HDR image capture.");
            }
        }
        synchronized (this.mLock) {
            try {
                if (!this.mEffects.isEmpty()) {
                    if (hasUltraHdrImageCapture(collection)) {
                        throw new IllegalArgumentException("Ultra HDR image capture does not support for use with CameraEffect.");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private ImageCapture createExtraImageCapture() {
        return new ImageCapture.Builder().setTargetName("ImageCapture-Extra").build();
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [java.lang.Object, androidx.camera.core.Preview$SurfaceProvider] */
    private Preview createExtraPreview() {
        Preview build = new Preview.Builder().setTargetName("Preview-Extra").build();
        build.setSurfaceProvider(new Object());
        return build;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        return null;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.camera.core.streamsharing.StreamSharing createOrReuseStreamSharing(@androidx.annotation.NonNull java.util.Collection<androidx.camera.core.UseCase> r9, boolean r10) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.mLock
            monitor-enter(r0)
            java.util.Set r6 = r8.getStreamSharingChildren(r9, r10)     // Catch:{ all -> 0x001c }
            int r9 = r6.size()     // Catch:{ all -> 0x001c }
            r10 = 2
            r1 = 0
            if (r9 >= r10) goto L_0x0020
            boolean r9 = r8.hasExtension()     // Catch:{ all -> 0x001c }
            if (r9 == 0) goto L_0x001e
            boolean r9 = hasVideoCapture(r6)     // Catch:{ all -> 0x001c }
            if (r9 != 0) goto L_0x0020
            goto L_0x001e
        L_0x001c:
            r9 = move-exception
            goto L_0x004f
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            return r1
        L_0x0020:
            androidx.camera.core.streamsharing.StreamSharing r9 = r8.mStreamSharing     // Catch:{ all -> 0x001c }
            if (r9 == 0) goto L_0x0035
            java.util.Set r9 = r9.getChildren()     // Catch:{ all -> 0x001c }
            boolean r9 = r9.equals(r6)     // Catch:{ all -> 0x001c }
            if (r9 == 0) goto L_0x0035
            androidx.camera.core.streamsharing.StreamSharing r9 = r8.mStreamSharing     // Catch:{ all -> 0x001c }
            java.util.Objects.requireNonNull(r9)     // Catch:{ all -> 0x001c }
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            return r9
        L_0x0035:
            boolean r9 = isStreamSharingChildrenCombinationValid(r6)     // Catch:{ all -> 0x001c }
            if (r9 != 0) goto L_0x003d
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            return r1
        L_0x003d:
            androidx.camera.core.streamsharing.StreamSharing r9 = new androidx.camera.core.streamsharing.StreamSharing     // Catch:{ all -> 0x001c }
            androidx.camera.core.impl.CameraInternal r2 = r8.mCameraInternal     // Catch:{ all -> 0x001c }
            androidx.camera.core.impl.CameraInternal r3 = r8.mSecondaryCameraInternal     // Catch:{ all -> 0x001c }
            androidx.camera.core.LayoutSettings r4 = r8.mLayoutSettings     // Catch:{ all -> 0x001c }
            androidx.camera.core.LayoutSettings r5 = r8.mSecondaryLayoutSettings     // Catch:{ all -> 0x001c }
            androidx.camera.core.impl.UseCaseConfigFactory r7 = r8.mUseCaseConfigFactory     // Catch:{ all -> 0x001c }
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x001c }
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            return r9
        L_0x004f:
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.internal.CameraUseCaseAdapter.createOrReuseStreamSharing(java.util.Collection, boolean):androidx.camera.core.streamsharing.StreamSharing");
    }

    @NonNull
    public static CameraId generateCameraId(@NonNull RestrictedCameraInfo restrictedCameraInfo, @Nullable RestrictedCameraInfo restrictedCameraInfo2) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(restrictedCameraInfo.getCameraId());
        if (restrictedCameraInfo2 == null) {
            str = "";
        } else {
            str = restrictedCameraInfo2.getCameraId();
        }
        sb.append(str);
        return CameraId.create(sb.toString(), restrictedCameraInfo.getCameraConfig().getCompatibilityId());
    }

    private static UseCaseConfig<?> generateExtendedStreamSharingConfigFromPreview(@NonNull UseCaseConfigFactory useCaseConfigFactory, @NonNull StreamSharing streamSharing) {
        UseCaseConfig<?> defaultConfig = new Preview.Builder().build().getDefaultConfig(false, useCaseConfigFactory);
        if (defaultConfig == null) {
            return null;
        }
        MutableOptionsBundle from = MutableOptionsBundle.from(defaultConfig);
        from.removeOption(TargetConfig.OPTION_TARGET_CLASS);
        return streamSharing.getUseCaseConfigBuilder(from).getUseCaseConfig();
    }

    private int getCameraMode() {
        synchronized (this.mLock) {
            try {
                if (this.mCameraCoordinator.getCameraOperatingMode() == 2) {
                    return 1;
                }
                return 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static Map<UseCase, ConfigPair> getConfigs(@NonNull Collection<UseCase> collection, @NonNull UseCaseConfigFactory useCaseConfigFactory, @NonNull UseCaseConfigFactory useCaseConfigFactory2) {
        UseCaseConfig<?> useCaseConfig;
        HashMap hashMap = new HashMap();
        for (UseCase next : collection) {
            if (StreamSharing.isStreamSharing(next)) {
                useCaseConfig = generateExtendedStreamSharingConfigFromPreview(useCaseConfigFactory, (StreamSharing) next);
            } else {
                useCaseConfig = next.getDefaultConfig(false, useCaseConfigFactory);
            }
            hashMap.put(next, new ConfigPair(useCaseConfig, next.getDefaultConfig(true, useCaseConfigFactory2)));
        }
        return hashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: boolean} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getSharingTargets(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.mLock
            monitor-enter(r0)
            java.util.List<androidx.camera.core.CameraEffect> r1 = r7.mEffects     // Catch:{ all -> 0x002c }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x002c }
            r2 = 0
        L_0x000a:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x002c }
            r4 = 0
            if (r3 == 0) goto L_0x002e
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x002c }
            androidx.camera.core.CameraEffect r3 = (androidx.camera.core.CameraEffect) r3     // Catch:{ all -> 0x002c }
            int r5 = r3.getTargets()     // Catch:{ all -> 0x002c }
            int r5 = androidx.camera.core.processing.TargetUtils.getNumberOfTargets(r5)     // Catch:{ all -> 0x002c }
            r6 = 1
            if (r5 <= r6) goto L_0x000a
            if (r2 != 0) goto L_0x0025
            r4 = 1
        L_0x0025:
            java.lang.String r2 = "Can only have one sharing effect."
            androidx.core.util.Preconditions.checkState(r4, r2)     // Catch:{ all -> 0x002c }
            r2 = r3
            goto L_0x000a
        L_0x002c:
            r8 = move-exception
            goto L_0x003b
        L_0x002e:
            if (r2 != 0) goto L_0x0031
            goto L_0x0035
        L_0x0031:
            int r4 = r2.getTargets()     // Catch:{ all -> 0x002c }
        L_0x0035:
            if (r8 == 0) goto L_0x0039
            r4 = r4 | 3
        L_0x0039:
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            return r4
        L_0x003b:
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.internal.CameraUseCaseAdapter.getSharingTargets(boolean):int");
    }

    @NonNull
    private Set<UseCase> getStreamSharingChildren(@NonNull Collection<UseCase> collection, boolean z) {
        HashSet hashSet = new HashSet();
        int sharingTargets = getSharingTargets(z);
        for (UseCase next : collection) {
            Preconditions.checkArgument(!StreamSharing.isStreamSharing(next), "Only support one level of sharing for now.");
            if (next.isEffectTargetsSupported(sharingTargets)) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    private boolean hasExtension() {
        boolean z;
        synchronized (this.mLock) {
            if (this.mCameraConfig.getSessionProcessor((SessionProcessor) null) != null) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean hasImplementationOptionChanged(androidx.camera.core.impl.StreamSpec r4, androidx.camera.core.impl.SessionConfig r5) {
        /*
            androidx.camera.core.impl.Config r4 = r4.getImplementationOptions()
            androidx.camera.core.impl.Config r0 = r5.getImplementationOptions()
            java.util.Set r1 = r4.listOptions()
            int r1 = r1.size()
            androidx.camera.core.impl.Config r5 = r5.getImplementationOptions()
            java.util.Set r5 = r5.listOptions()
            int r5 = r5.size()
            r2 = 1
            if (r1 == r5) goto L_0x0020
            return r2
        L_0x0020:
            java.util.Set r5 = r4.listOptions()
            java.util.Iterator r5 = r5.iterator()
        L_0x0028:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0049
            java.lang.Object r1 = r5.next()
            androidx.camera.core.impl.Config$Option r1 = (androidx.camera.core.impl.Config.Option) r1
            boolean r3 = r0.containsOption(r1)
            if (r3 == 0) goto L_0x0048
            java.lang.Object r3 = r0.retrieveOption(r1)
            java.lang.Object r1 = r4.retrieveOption(r1)
            boolean r1 = java.util.Objects.equals(r3, r1)
            if (r1 != 0) goto L_0x0028
        L_0x0048:
            return r2
        L_0x0049:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.internal.CameraUseCaseAdapter.hasImplementationOptionChanged(androidx.camera.core.impl.StreamSpec, androidx.camera.core.impl.SessionConfig):boolean");
    }

    private static boolean hasNonSdrConfig(@NonNull Collection<UseCase> collection) {
        for (UseCase currentConfig : collection) {
            if (isNotSdr(currentConfig.getCurrentConfig().getDynamicRange())) {
                return true;
            }
        }
        return false;
    }

    @OptIn(markerClass = {ExperimentalImageCaptureOutputFormat.class})
    private static boolean hasUltraHdrImageCapture(@NonNull Collection<UseCase> collection) {
        for (UseCase next : collection) {
            if (isImageCapture(next)) {
                UseCaseConfig<?> currentConfig = next.getCurrentConfig();
                Config.Option<Integer> option = ImageCaptureConfig.OPTION_OUTPUT_FORMAT;
                if (currentConfig.containsOption(option) && ((Integer) Preconditions.checkNotNull((Integer) currentConfig.retrieveOption(option))).intValue() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasVideoCapture(@NonNull Collection<UseCase> collection) {
        for (UseCase isVideoCapture : collection) {
            if (isVideoCapture(isVideoCapture)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCoexistingPreviewImageCaptureRequired() {
        boolean z;
        synchronized (this.mLock) {
            z = true;
            if (this.mCameraConfig.getUseCaseCombinationRequiredRule() != 1) {
                z = false;
            }
        }
        return z;
    }

    private static boolean isExtraImageCaptureRequired(@NonNull Collection<UseCase> collection) {
        boolean z = false;
        boolean z2 = false;
        for (UseCase next : collection) {
            if (isPreview(next) || StreamSharing.isStreamSharing(next)) {
                z = true;
            } else if (isImageCapture(next)) {
                z2 = true;
            }
        }
        if (!z || z2) {
            return false;
        }
        return true;
    }

    private static boolean isExtraPreviewRequired(@NonNull Collection<UseCase> collection) {
        boolean z = false;
        boolean z2 = false;
        for (UseCase next : collection) {
            if (isPreview(next) || StreamSharing.isStreamSharing(next)) {
                z2 = true;
            } else if (isImageCapture(next)) {
                z = true;
            }
        }
        if (!z || z2) {
            return false;
        }
        return true;
    }

    private static boolean isImageCapture(@Nullable UseCase useCase) {
        return useCase instanceof ImageCapture;
    }

    private static boolean isNotSdr(@NonNull DynamicRange dynamicRange) {
        boolean z;
        boolean z2;
        if (dynamicRange.getBitDepth() == 10) {
            z = true;
        } else {
            z = false;
        }
        if (dynamicRange.getEncoding() == 1 || dynamicRange.getEncoding() == 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z || z2) {
            return true;
        }
        return false;
    }

    private static boolean isPreview(@Nullable UseCase useCase) {
        return useCase instanceof Preview;
    }

    public static boolean isStreamSharingChildrenCombinationValid(@NonNull Collection<UseCase> collection) {
        int[] iArr = {1, 2, 4};
        HashSet hashSet = new HashSet();
        for (UseCase next : collection) {
            int i = 0;
            while (true) {
                if (i < 3) {
                    int i2 = iArr[i];
                    if (next.isEffectTargetsSupported(i2)) {
                        if (hashSet.contains(Integer.valueOf(i2))) {
                            return false;
                        }
                        hashSet.add(Integer.valueOf(i2));
                    }
                    i++;
                }
            }
        }
        return true;
    }

    private static boolean isVideoCapture(@Nullable UseCase useCase) {
        if (useCase != null) {
            if (!useCase.getCurrentConfig().containsOption(UseCaseConfig.OPTION_CAPTURE_TYPE)) {
                Log.e(TAG, useCase + " UseCase does not have capture type.");
            } else if (useCase.getCurrentConfig().getCaptureType() == UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$createExtraPreview$0(Surface surface, SurfaceTexture surfaceTexture, SurfaceRequest.Result result) {
        surface.release();
        surfaceTexture.release();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$createExtraPreview$1(SurfaceRequest surfaceRequest) {
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(surfaceRequest.getResolution().getWidth(), surfaceRequest.getResolution().getHeight());
        surfaceTexture.detachFromGLContext();
        Surface surface = new Surface(surfaceTexture);
        surfaceRequest.provideSurface(surface, CameraXExecutors.directExecutor(), new q2(0, surface, surfaceTexture));
    }

    private void restoreInteropConfig() {
        synchronized (this.mLock) {
            try {
                if (this.mInteropConfig != null) {
                    this.mCameraInternal.getCameraControlInternal().addInteropConfig(this.mInteropConfig);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    private static List<CameraEffect> setEffectsOnUseCases(@NonNull List<CameraEffect> list, @NonNull Collection<UseCase> collection) {
        boolean z;
        ArrayList arrayList = new ArrayList(list);
        for (UseCase next : collection) {
            next.setEffect((CameraEffect) null);
            for (CameraEffect next2 : list) {
                if (next.isEffectTargetsSupported(next2.getTargets())) {
                    if (next.getEffect() == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Preconditions.checkState(z, next + " already has effect" + next.getEffect());
                    next.setEffect(next2);
                    arrayList.remove(next2);
                }
            }
        }
        return arrayList;
    }

    @VisibleForTesting
    public static void updateEffects(@NonNull List<CameraEffect> list, @NonNull Collection<UseCase> collection, @NonNull Collection<UseCase> collection2) {
        List<CameraEffect> effectsOnUseCases = setEffectsOnUseCases(list, collection);
        ArrayList arrayList = new ArrayList(collection2);
        arrayList.removeAll(collection);
        List<CameraEffect> effectsOnUseCases2 = setEffectsOnUseCases(effectsOnUseCases, arrayList);
        if (effectsOnUseCases2.size() > 0) {
            Logger.w(TAG, "Unused effects: " + effectsOnUseCases2);
        }
    }

    private void updateViewPortAndSensorToBufferMatrix(@NonNull Map<UseCase, StreamSpec> map, @NonNull Collection<UseCase> collection) {
        boolean z;
        synchronized (this.mLock) {
            try {
                if (this.mViewPort != null && !collection.isEmpty()) {
                    if (this.mCameraInternal.getCameraInfoInternal().getLensFacing() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Map<UseCase, Rect> calculateViewPortRects = ViewPorts.calculateViewPortRects(this.mCameraInternal.getCameraControlInternal().getSensorRect(), z, this.mViewPort.getAspectRatio(), this.mCameraInternal.getCameraInfoInternal().getSensorRotationDegrees(this.mViewPort.getRotation()), this.mViewPort.getScaleType(), this.mViewPort.getLayoutDirection(), map);
                    for (UseCase next : collection) {
                        next.setViewPortCropRect((Rect) Preconditions.checkNotNull(calculateViewPortRects.get(next)));
                    }
                }
                for (UseCase next2 : collection) {
                    next2.setSensorToBufferTransformMatrix(calculateSensorToBufferTransformMatrix(this.mCameraInternal.getCameraControlInternal().getSensorRect(), ((StreamSpec) Preconditions.checkNotNull(map.get(next2))).getResolution()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addUseCases(@NonNull Collection<UseCase> collection) throws CameraException {
        boolean z;
        synchronized (this.mLock) {
            try {
                this.mCameraInternal.setExtendedConfig(this.mCameraConfig);
                CameraInternal cameraInternal = this.mSecondaryCameraInternal;
                if (cameraInternal != null) {
                    cameraInternal.setExtendedConfig(this.mCameraConfig);
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet(this.mAppUseCases);
                linkedHashSet.addAll(collection);
                CameraInternal cameraInternal2 = this.mSecondaryCameraInternal;
                boolean z2 = false;
                if (cameraInternal2 != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (cameraInternal2 != null) {
                    z2 = true;
                }
                updateUseCases(linkedHashSet, z, z2);
            } catch (IllegalArgumentException e) {
                throw new CameraException((Throwable) e);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void attachUseCases() {
        synchronized (this.mLock) {
            try {
                if (!this.mAttached) {
                    if (!this.mCameraUseCases.isEmpty()) {
                        this.mCameraInternal.setExtendedConfig(this.mCameraConfig);
                        CameraInternal cameraInternal = this.mSecondaryCameraInternal;
                        if (cameraInternal != null) {
                            cameraInternal.setExtendedConfig(this.mCameraConfig);
                        }
                    }
                    this.mCameraInternal.attachUseCases(this.mCameraUseCases);
                    CameraInternal cameraInternal2 = this.mSecondaryCameraInternal;
                    if (cameraInternal2 != null) {
                        cameraInternal2.attachUseCases(this.mCameraUseCases);
                    }
                    restoreInteropConfig();
                    for (UseCase notifyState : this.mCameraUseCases) {
                        notifyState.notifyState();
                    }
                    this.mAttached = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void detachUseCases() {
        synchronized (this.mLock) {
            try {
                if (this.mAttached) {
                    this.mCameraInternal.detachUseCases(new ArrayList(this.mCameraUseCases));
                    CameraInternal cameraInternal = this.mSecondaryCameraInternal;
                    if (cameraInternal != null) {
                        cameraInternal.detachUseCases(new ArrayList(this.mCameraUseCases));
                    }
                    cacheInteropConfig();
                    this.mAttached = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public CameraControl getCameraControl() {
        return this.mAdapterCameraControl;
    }

    @NonNull
    public CameraId getCameraId() {
        return this.mId;
    }

    @NonNull
    public CameraInfo getCameraInfo() {
        return this.mAdapterCameraInfo;
    }

    @VisibleForTesting
    @NonNull
    public Collection<UseCase> getCameraUseCases() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mCameraUseCases);
        }
        return arrayList;
    }

    @NonNull
    public CameraConfig getExtendedConfig() {
        CameraConfig cameraConfig;
        synchronized (this.mLock) {
            cameraConfig = this.mCameraConfig;
        }
        return cameraConfig;
    }

    @Nullable
    public CameraInfo getSecondaryCameraInfo() {
        return this.mAdapterSecondaryCameraInfo;
    }

    @NonNull
    public List<UseCase> getUseCases() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mAppUseCases);
        }
        return arrayList;
    }

    public boolean isEquivalent(@NonNull CameraUseCaseAdapter cameraUseCaseAdapter) {
        return getCameraId().equals(cameraUseCaseAdapter.getCameraId());
    }

    public final /* synthetic */ boolean isUseCasesCombinationSupported(UseCase... useCaseArr) {
        return r1.b(this, useCaseArr);
    }

    public final /* synthetic */ boolean isUseCasesCombinationSupportedByFramework(UseCase... useCaseArr) {
        return r1.c(this, useCaseArr);
    }

    public void removeUseCases(@NonNull Collection<UseCase> collection) {
        boolean z;
        synchronized (this.mLock) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.mAppUseCases);
            linkedHashSet.removeAll(collection);
            CameraInternal cameraInternal = this.mSecondaryCameraInternal;
            boolean z2 = false;
            if (cameraInternal != null) {
                z = true;
            } else {
                z = false;
            }
            if (cameraInternal != null) {
                z2 = true;
            }
            updateUseCases(linkedHashSet, z, z2);
        }
    }

    public void setActiveResumingMode(boolean z) {
        this.mCameraInternal.setActiveResumingMode(z);
    }

    public void setEffects(@Nullable List<CameraEffect> list) {
        synchronized (this.mLock) {
            this.mEffects = list;
        }
    }

    public void setViewPort(@Nullable ViewPort viewPort) {
        synchronized (this.mLock) {
            this.mViewPort = viewPort;
        }
    }

    public void updateUseCases(@NonNull Collection<UseCase> collection) {
        updateUseCases(collection, false, false);
    }

    public boolean isUseCasesCombinationSupported(boolean z, @NonNull UseCase... useCaseArr) {
        Collection asList = Arrays.asList(useCaseArr);
        if (z) {
            asList = calculateCameraUseCases(asList, (UseCase) null, createOrReuseStreamSharing(asList, true));
        }
        Collection collection = asList;
        synchronized (this.mLock) {
            try {
                calculateSuggestedStreamSpecs(getCameraMode(), this.mCameraInternal.getCameraInfoInternal(), collection, Collections.emptyList(), getConfigs(collection, this.mCameraConfig.getUseCaseConfigFactory(), this.mUseCaseConfigFactory));
            } catch (IllegalArgumentException unused) {
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0105, code lost:
        r4 = r11.get(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateUseCases(@androidx.annotation.NonNull java.util.Collection<androidx.camera.core.UseCase> r20, boolean r21, boolean r22) {
        /*
            r19 = this;
            r7 = r19
            r8 = r20
            r9 = r22
            java.lang.Object r10 = r7.mLock
            monitor-enter(r10)
            r19.checkUnsupportedFeatureCombinationAndThrow(r20)     // Catch:{ all -> 0x0020 }
            r11 = 1
            if (r21 != 0) goto L_0x0023
            boolean r0 = r19.hasExtension()     // Catch:{ all -> 0x0020 }
            if (r0 == 0) goto L_0x0023
            boolean r0 = hasVideoCapture(r20)     // Catch:{ all -> 0x0020 }
            if (r0 == 0) goto L_0x0023
            r7.updateUseCases(r8, r11, r9)     // Catch:{ all -> 0x0020 }
            monitor-exit(r10)     // Catch:{ all -> 0x0020 }
            return
        L_0x0020:
            r0 = move-exception
            goto L_0x01ee
        L_0x0023:
            androidx.camera.core.streamsharing.StreamSharing r0 = r19.createOrReuseStreamSharing(r20, r21)     // Catch:{ all -> 0x0020 }
            androidx.camera.core.UseCase r12 = r7.calculatePlaceholderForExtensions(r8, r0)     // Catch:{ all -> 0x0020 }
            java.util.Collection r13 = calculateCameraUseCases(r8, r12, r0)     // Catch:{ all -> 0x0020 }
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x0020 }
            r14.<init>(r13)     // Catch:{ all -> 0x0020 }
            java.util.List<androidx.camera.core.UseCase> r1 = r7.mCameraUseCases     // Catch:{ all -> 0x0020 }
            r14.removeAll(r1)     // Catch:{ all -> 0x0020 }
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x0020 }
            r15.<init>(r13)     // Catch:{ all -> 0x0020 }
            java.util.List<androidx.camera.core.UseCase> r1 = r7.mCameraUseCases     // Catch:{ all -> 0x0020 }
            r15.retainAll(r1)     // Catch:{ all -> 0x0020 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x0020 }
            java.util.List<androidx.camera.core.UseCase> r1 = r7.mCameraUseCases     // Catch:{ all -> 0x0020 }
            r6.<init>(r1)     // Catch:{ all -> 0x0020 }
            r6.removeAll(r13)     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.CameraConfig r1 = r7.mCameraConfig     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.UseCaseConfigFactory r1 = r1.getUseCaseConfigFactory()     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.UseCaseConfigFactory r2 = r7.mUseCaseConfigFactory     // Catch:{ all -> 0x0020 }
            java.util.Map r5 = getConfigs(r14, r1, r2)     // Catch:{ all -> 0x0020 }
            java.util.Map r16 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0020 }
            int r2 = r19.getCameraMode()     // Catch:{ IllegalArgumentException -> 0x0096 }
            androidx.camera.core.impl.CameraInternal r1 = r7.mCameraInternal     // Catch:{ IllegalArgumentException -> 0x0096 }
            androidx.camera.core.impl.CameraInfoInternal r3 = r1.getCameraInfoInternal()     // Catch:{ IllegalArgumentException -> 0x0096 }
            r1 = r19
            r4 = r14
            r17 = r5
            r5 = r15
            r18 = r6
            r6 = r17
            java.util.Map r6 = r1.calculateSuggestedStreamSpecs(r2, r3, r4, r5, r6)     // Catch:{ IllegalArgumentException -> 0x0096 }
            androidx.camera.core.impl.CameraInternal r1 = r7.mSecondaryCameraInternal     // Catch:{ IllegalArgumentException -> 0x0096 }
            if (r1 == 0) goto L_0x0099
            int r2 = r19.getCameraMode()     // Catch:{ IllegalArgumentException -> 0x0096 }
            androidx.camera.core.impl.CameraInternal r1 = r7.mSecondaryCameraInternal     // Catch:{ IllegalArgumentException -> 0x0096 }
            java.util.Objects.requireNonNull(r1)     // Catch:{ IllegalArgumentException -> 0x0096 }
            androidx.camera.core.impl.CameraInternal r1 = (androidx.camera.core.impl.CameraInternal) r1     // Catch:{ IllegalArgumentException -> 0x0096 }
            androidx.camera.core.impl.CameraInfoInternal r3 = r1.getCameraInfoInternal()     // Catch:{ IllegalArgumentException -> 0x0096 }
            r1 = r19
            r4 = r14
            r5 = r15
            r11 = r6
            r6 = r17
            java.util.Map r16 = r1.calculateSuggestedStreamSpecs(r2, r3, r4, r5, r6)     // Catch:{ IllegalArgumentException -> 0x0096 }
        L_0x0093:
            r1 = r16
            goto L_0x009b
        L_0x0096:
            r0 = move-exception
            goto L_0x01d6
        L_0x0099:
            r11 = r6
            goto L_0x0093
        L_0x009b:
            r7.updateViewPortAndSensorToBufferMatrix(r11, r13)     // Catch:{ all -> 0x0020 }
            java.util.List<androidx.camera.core.CameraEffect> r2 = r7.mEffects     // Catch:{ all -> 0x0020 }
            updateEffects(r2, r13, r8)     // Catch:{ all -> 0x0020 }
            java.util.Iterator r2 = r18.iterator()     // Catch:{ all -> 0x0020 }
        L_0x00a7:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0020 }
            if (r3 == 0) goto L_0x00b9
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0020 }
            androidx.camera.core.UseCase r3 = (androidx.camera.core.UseCase) r3     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.CameraInternal r4 = r7.mCameraInternal     // Catch:{ all -> 0x0020 }
            r3.unbindFromCamera(r4)     // Catch:{ all -> 0x0020 }
            goto L_0x00a7
        L_0x00b9:
            androidx.camera.core.impl.CameraInternal r2 = r7.mCameraInternal     // Catch:{ all -> 0x0020 }
            r3 = r18
            r2.detachUseCases(r3)     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.CameraInternal r2 = r7.mSecondaryCameraInternal     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x00e9
            java.util.Iterator r2 = r3.iterator()     // Catch:{ all -> 0x0020 }
        L_0x00c8:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x0020 }
            if (r4 == 0) goto L_0x00df
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x0020 }
            androidx.camera.core.UseCase r4 = (androidx.camera.core.UseCase) r4     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.CameraInternal r5 = r7.mSecondaryCameraInternal     // Catch:{ all -> 0x0020 }
            java.util.Objects.requireNonNull(r5)     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.CameraInternal r5 = (androidx.camera.core.impl.CameraInternal) r5     // Catch:{ all -> 0x0020 }
            r4.unbindFromCamera(r5)     // Catch:{ all -> 0x0020 }
            goto L_0x00c8
        L_0x00df:
            androidx.camera.core.impl.CameraInternal r2 = r7.mSecondaryCameraInternal     // Catch:{ all -> 0x0020 }
            java.util.Objects.requireNonNull(r2)     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.CameraInternal r2 = (androidx.camera.core.impl.CameraInternal) r2     // Catch:{ all -> 0x0020 }
            r2.detachUseCases(r3)     // Catch:{ all -> 0x0020 }
        L_0x00e9:
            boolean r2 = r3.isEmpty()     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x0134
            java.util.Iterator r2 = r15.iterator()     // Catch:{ all -> 0x0020 }
        L_0x00f3:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0020 }
            if (r3 == 0) goto L_0x0134
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0020 }
            androidx.camera.core.UseCase r3 = (androidx.camera.core.UseCase) r3     // Catch:{ all -> 0x0020 }
            boolean r4 = r11.containsKey(r3)     // Catch:{ all -> 0x0020 }
            if (r4 == 0) goto L_0x00f3
            java.lang.Object r4 = r11.get(r3)     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.StreamSpec r4 = (androidx.camera.core.impl.StreamSpec) r4     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.Config r5 = r4.getImplementationOptions()     // Catch:{ all -> 0x0020 }
            if (r5 == 0) goto L_0x00f3
            androidx.camera.core.impl.SessionConfig r6 = r3.getSessionConfig()     // Catch:{ all -> 0x0020 }
            boolean r4 = hasImplementationOptionChanged(r4, r6)     // Catch:{ all -> 0x0020 }
            if (r4 == 0) goto L_0x00f3
            r3.updateSuggestedStreamSpecImplementationOptions(r5)     // Catch:{ all -> 0x0020 }
            boolean r4 = r7.mAttached     // Catch:{ all -> 0x0020 }
            if (r4 == 0) goto L_0x00f3
            androidx.camera.core.impl.CameraInternal r4 = r7.mCameraInternal     // Catch:{ all -> 0x0020 }
            r4.onUseCaseUpdated(r3)     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.CameraInternal r4 = r7.mSecondaryCameraInternal     // Catch:{ all -> 0x0020 }
            if (r4 == 0) goto L_0x00f3
            java.util.Objects.requireNonNull(r4)     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.CameraInternal r4 = (androidx.camera.core.impl.CameraInternal) r4     // Catch:{ all -> 0x0020 }
            r4.onUseCaseUpdated(r3)     // Catch:{ all -> 0x0020 }
            goto L_0x00f3
        L_0x0134:
            java.util.Iterator r2 = r14.iterator()     // Catch:{ all -> 0x0020 }
        L_0x0138:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0020 }
            if (r3 == 0) goto L_0x0193
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0020 }
            androidx.camera.core.UseCase r3 = (androidx.camera.core.UseCase) r3     // Catch:{ all -> 0x0020 }
            r4 = r17
            java.lang.Object r5 = r4.get(r3)     // Catch:{ all -> 0x0020 }
            androidx.camera.core.internal.CameraUseCaseAdapter$ConfigPair r5 = (androidx.camera.core.internal.CameraUseCaseAdapter.ConfigPair) r5     // Catch:{ all -> 0x0020 }
            java.util.Objects.requireNonNull(r5)     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.CameraInternal r6 = r7.mSecondaryCameraInternal     // Catch:{ all -> 0x0020 }
            if (r6 == 0) goto L_0x0177
            androidx.camera.core.impl.CameraInternal r9 = r7.mCameraInternal     // Catch:{ all -> 0x0020 }
            java.util.Objects.requireNonNull(r6)     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.CameraInternal r6 = (androidx.camera.core.impl.CameraInternal) r6     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.UseCaseConfig<?> r15 = r5.mExtendedConfig     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.UseCaseConfig<?> r5 = r5.mCameraConfig     // Catch:{ all -> 0x0020 }
            r3.bindToCamera(r9, r6, r15, r5)     // Catch:{ all -> 0x0020 }
            java.lang.Object r5 = r11.get(r3)     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.StreamSpec r5 = (androidx.camera.core.impl.StreamSpec) r5     // Catch:{ all -> 0x0020 }
            java.lang.Object r5 = androidx.core.util.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.StreamSpec r5 = (androidx.camera.core.impl.StreamSpec) r5     // Catch:{ all -> 0x0020 }
            java.lang.Object r6 = r1.get(r3)     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.StreamSpec r6 = (androidx.camera.core.impl.StreamSpec) r6     // Catch:{ all -> 0x0020 }
            r3.updateSuggestedStreamSpec(r5, r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0190
        L_0x0177:
            androidx.camera.core.impl.CameraInternal r6 = r7.mCameraInternal     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.UseCaseConfig<?> r9 = r5.mExtendedConfig     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.UseCaseConfig<?> r5 = r5.mCameraConfig     // Catch:{ all -> 0x0020 }
            r15 = 0
            r3.bindToCamera(r6, r15, r9, r5)     // Catch:{ all -> 0x0020 }
            java.lang.Object r5 = r11.get(r3)     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.StreamSpec r5 = (androidx.camera.core.impl.StreamSpec) r5     // Catch:{ all -> 0x0020 }
            java.lang.Object r5 = androidx.core.util.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.StreamSpec r5 = (androidx.camera.core.impl.StreamSpec) r5     // Catch:{ all -> 0x0020 }
            r3.updateSuggestedStreamSpec(r5, r15)     // Catch:{ all -> 0x0020 }
        L_0x0190:
            r17 = r4
            goto L_0x0138
        L_0x0193:
            boolean r1 = r7.mAttached     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x01a8
            androidx.camera.core.impl.CameraInternal r1 = r7.mCameraInternal     // Catch:{ all -> 0x0020 }
            r1.attachUseCases(r14)     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.CameraInternal r1 = r7.mSecondaryCameraInternal     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x01a8
            java.util.Objects.requireNonNull(r1)     // Catch:{ all -> 0x0020 }
            androidx.camera.core.impl.CameraInternal r1 = (androidx.camera.core.impl.CameraInternal) r1     // Catch:{ all -> 0x0020 }
            r1.attachUseCases(r14)     // Catch:{ all -> 0x0020 }
        L_0x01a8:
            java.util.Iterator r1 = r14.iterator()     // Catch:{ all -> 0x0020 }
        L_0x01ac:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x01bc
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0020 }
            androidx.camera.core.UseCase r2 = (androidx.camera.core.UseCase) r2     // Catch:{ all -> 0x0020 }
            r2.notifyState()     // Catch:{ all -> 0x0020 }
            goto L_0x01ac
        L_0x01bc:
            java.util.List<androidx.camera.core.UseCase> r1 = r7.mAppUseCases     // Catch:{ all -> 0x0020 }
            r1.clear()     // Catch:{ all -> 0x0020 }
            java.util.List<androidx.camera.core.UseCase> r1 = r7.mAppUseCases     // Catch:{ all -> 0x0020 }
            r1.addAll(r8)     // Catch:{ all -> 0x0020 }
            java.util.List<androidx.camera.core.UseCase> r1 = r7.mCameraUseCases     // Catch:{ all -> 0x0020 }
            r1.clear()     // Catch:{ all -> 0x0020 }
            java.util.List<androidx.camera.core.UseCase> r1 = r7.mCameraUseCases     // Catch:{ all -> 0x0020 }
            r1.addAll(r13)     // Catch:{ all -> 0x0020 }
            r7.mPlaceholderForExtensions = r12     // Catch:{ all -> 0x0020 }
            r7.mStreamSharing = r0     // Catch:{ all -> 0x0020 }
            monitor-exit(r10)     // Catch:{ all -> 0x0020 }
            return
        L_0x01d6:
            if (r21 != 0) goto L_0x01ed
            boolean r1 = r19.hasExtension()     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x01ed
            androidx.camera.core.concurrent.CameraCoordinator r1 = r7.mCameraCoordinator     // Catch:{ all -> 0x0020 }
            int r1 = r1.getCameraOperatingMode()     // Catch:{ all -> 0x0020 }
            r2 = 2
            if (r1 == r2) goto L_0x01ed
            r1 = 1
            r7.updateUseCases(r8, r1, r9)     // Catch:{ all -> 0x0020 }
            monitor-exit(r10)     // Catch:{ all -> 0x0020 }
            return
        L_0x01ed:
            throw r0     // Catch:{ all -> 0x0020 }
        L_0x01ee:
            monitor-exit(r10)     // Catch:{ all -> 0x0020 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.internal.CameraUseCaseAdapter.updateUseCases(java.util.Collection, boolean, boolean):void");
    }

    public CameraUseCaseAdapter(@NonNull CameraInternal cameraInternal, @Nullable CameraInternal cameraInternal2, @NonNull RestrictedCameraInfo restrictedCameraInfo, @Nullable RestrictedCameraInfo restrictedCameraInfo2, @NonNull LayoutSettings layoutSettings, @NonNull LayoutSettings layoutSettings2, @NonNull CameraCoordinator cameraCoordinator, @NonNull CameraDeviceSurfaceManager cameraDeviceSurfaceManager, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        this.mAppUseCases = new ArrayList();
        this.mCameraUseCases = new ArrayList();
        this.mEffects = Collections.emptyList();
        this.mLock = new Object();
        this.mAttached = true;
        this.mInteropConfig = null;
        this.mCameraInternal = cameraInternal;
        this.mSecondaryCameraInternal = cameraInternal2;
        this.mLayoutSettings = layoutSettings;
        this.mSecondaryLayoutSettings = layoutSettings2;
        this.mCameraCoordinator = cameraCoordinator;
        this.mCameraDeviceSurfaceManager = cameraDeviceSurfaceManager;
        this.mUseCaseConfigFactory = useCaseConfigFactory;
        CameraConfig cameraConfig = restrictedCameraInfo.getCameraConfig();
        this.mCameraConfig = cameraConfig;
        this.mAdapterCameraControl = new RestrictedCameraControl(cameraInternal.getCameraControlInternal(), cameraConfig.getSessionProcessor((SessionProcessor) null));
        this.mAdapterCameraInfo = restrictedCameraInfo;
        this.mAdapterSecondaryCameraInfo = restrictedCameraInfo2;
        this.mId = generateCameraId(restrictedCameraInfo, restrictedCameraInfo2);
    }
}
