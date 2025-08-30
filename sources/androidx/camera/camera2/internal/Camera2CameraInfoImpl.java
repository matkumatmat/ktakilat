package androidx.camera.camera2.internal;

import android.annotation.SuppressLint;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.annotation.FloatRange;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.params.DynamicRangesCompat;
import androidx.camera.camera2.internal.compat.quirk.CameraQuirks;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ZslDisablerQuirk;
import androidx.camera.camera2.internal.compat.workaround.FlashAvailabilityChecker;
import androidx.camera.camera2.interop.Camera2CameraInfo;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraState;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ExperimentalZeroShutterLag;
import androidx.camera.core.ExposureState;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.Logger;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.DynamicRanges;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;

@OptIn(markerClass = {ExperimentalCamera2Interop.class})
public final class Camera2CameraInfoImpl implements CameraInfoInternal {
    private static final String TAG = "Camera2CameraInfo";
    @GuardedBy("mLock")
    @Nullable
    private Camera2CameraControlImpl mCamera2CameraControlImpl;
    private final Camera2CameraInfo mCamera2CameraInfo;
    @NonNull
    private final EncoderProfilesProvider mCamera2EncoderProfilesProvider;
    @GuardedBy("mLock")
    @Nullable
    private List<Pair<CameraCaptureCallback, Executor>> mCameraCaptureCallbacks = null;
    private final CameraCharacteristicsCompat mCameraCharacteristicsCompat;
    private final String mCameraId;
    @NonNull
    private final CameraManagerCompat mCameraManager;
    @NonNull
    private final Quirks mCameraQuirks;
    @NonNull
    private final RedirectableLiveData<CameraState> mCameraStateLiveData;
    private final Object mLock = new Object();
    @Nullable
    private Set<CameraInfo> mPhysicalCameraInfos;
    @GuardedBy("mLock")
    @Nullable
    private RedirectableLiveData<Integer> mRedirectTorchStateLiveData = null;
    @GuardedBy("mLock")
    @Nullable
    private RedirectableLiveData<ZoomState> mRedirectZoomStateLiveData = null;

    public static class RedirectableLiveData<T> extends MediatorLiveData<T> {
        private final T mInitialValue;
        private LiveData<T> mLiveDataSource;

        public RedirectableLiveData(T t) {
            this.mInitialValue = t;
        }

        public <S> void addSource(@NonNull LiveData<S> liveData, @NonNull Observer<? super S> observer) {
            throw new UnsupportedOperationException();
        }

        public T getValue() {
            LiveData<T> liveData = this.mLiveDataSource;
            if (liveData == null) {
                return this.mInitialValue;
            }
            return liveData.getValue();
        }

        public void redirectTo(@NonNull LiveData<T> liveData) {
            LiveData<T> liveData2 = this.mLiveDataSource;
            if (liveData2 != null) {
                super.removeSource(liveData2);
            }
            this.mLiveDataSource = liveData;
            super.addSource(liveData, new o(this));
        }
    }

    public Camera2CameraInfoImpl(@NonNull String str, @NonNull CameraManagerCompat cameraManagerCompat) throws CameraAccessExceptionCompat {
        String str2 = (String) Preconditions.checkNotNull(str);
        this.mCameraId = str2;
        this.mCameraManager = cameraManagerCompat;
        CameraCharacteristicsCompat cameraCharacteristicsCompat = cameraManagerCompat.getCameraCharacteristicsCompat(str2);
        this.mCameraCharacteristicsCompat = cameraCharacteristicsCompat;
        this.mCamera2CameraInfo = new Camera2CameraInfo(this);
        Quirks quirks = CameraQuirks.get(str, cameraCharacteristicsCompat);
        this.mCameraQuirks = quirks;
        this.mCamera2EncoderProfilesProvider = new Camera2EncoderProfilesProvider(str, quirks);
        this.mCameraStateLiveData = new RedirectableLiveData<>(CameraState.create(CameraState.Type.CLOSED));
    }

    private void logDeviceInfo() {
        logDeviceLevel();
    }

    private void logDeviceLevel() {
        String str;
        int supportedHardwareLevel = getSupportedHardwareLevel();
        if (supportedHardwareLevel == 0) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED";
        } else if (supportedHardwareLevel == 1) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_FULL";
        } else if (supportedHardwareLevel == 2) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY";
        } else if (supportedHardwareLevel == 3) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_3";
        } else if (supportedHardwareLevel != 4) {
            str = ba.k(supportedHardwareLevel, "Unknown value: ");
        } else {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL";
        }
        Logger.i(TAG, "Device Level: " + str);
    }

    public void addSessionCaptureCallback(@NonNull Executor executor, @NonNull CameraCaptureCallback cameraCaptureCallback) {
        synchronized (this.mLock) {
            try {
                Camera2CameraControlImpl camera2CameraControlImpl = this.mCamera2CameraControlImpl;
                if (camera2CameraControlImpl == null) {
                    if (this.mCameraCaptureCallbacks == null) {
                        this.mCameraCaptureCallbacks = new ArrayList();
                    }
                    this.mCameraCaptureCallbacks.add(new Pair(cameraCaptureCallback, executor));
                    return;
                }
                camera2CameraControlImpl.addSessionCameraCaptureCallback(executor, cameraCaptureCallback);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public Camera2CameraInfo getCamera2CameraInfo() {
        return this.mCamera2CameraInfo;
    }

    @NonNull
    public Object getCameraCharacteristics() {
        return this.mCameraCharacteristicsCompat.toCameraCharacteristics();
    }

    @NonNull
    public CameraCharacteristicsCompat getCameraCharacteristicsCompat() {
        return this.mCameraCharacteristicsCompat;
    }

    @NonNull
    public Map<String, CameraCharacteristics> getCameraCharacteristicsMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(this.mCameraId, this.mCameraCharacteristicsCompat.toCameraCharacteristics());
        for (String next : this.mCameraCharacteristicsCompat.getPhysicalCameraIds()) {
            if (!Objects.equals(next, this.mCameraId)) {
                try {
                    linkedHashMap.put(next, this.mCameraManager.getCameraCharacteristicsCompat(next).toCameraCharacteristics());
                } catch (CameraAccessExceptionCompat e) {
                    Logger.e(TAG, "Failed to get CameraCharacteristics for cameraId " + next, e);
                }
            }
        }
        return linkedHashMap;
    }

    @NonNull
    public String getCameraId() {
        return this.mCameraId;
    }

    @NonNull
    public Quirks getCameraQuirks() {
        return this.mCameraQuirks;
    }

    public final /* synthetic */ CameraSelector getCameraSelector() {
        return n2.a(this);
    }

    @NonNull
    public LiveData<CameraState> getCameraState() {
        return this.mCameraStateLiveData;
    }

    @NonNull
    public EncoderProfilesProvider getEncoderProfilesProvider() {
        return this.mCamera2EncoderProfilesProvider;
    }

    @NonNull
    public ExposureState getExposureState() {
        synchronized (this.mLock) {
            try {
                Camera2CameraControlImpl camera2CameraControlImpl = this.mCamera2CameraControlImpl;
                if (camera2CameraControlImpl == null) {
                    ExposureState defaultExposureState = ExposureControl.getDefaultExposureState(this.mCameraCharacteristicsCompat);
                    return defaultExposureState;
                }
                ExposureState exposureState = camera2CameraControlImpl.getExposureControl().getExposureState();
                return exposureState;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ CameraInfoInternal getImplementation() {
        return n2.b(this);
    }

    @NonNull
    public String getImplementationType() {
        if (getSupportedHardwareLevel() == 2) {
            return CameraInfo.IMPLEMENTATION_TYPE_CAMERA2_LEGACY;
        }
        return CameraInfo.IMPLEMENTATION_TYPE_CAMERA2;
    }

    @FloatRange(from = 0.0d, fromInclusive = false)
    public float getIntrinsicZoomRatio() {
        Integer num = (Integer) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING);
        if (num == null) {
            return 1.0f;
        }
        try {
            return ((float) FovUtil.getDeviceDefaultViewAngleDegrees(this.mCameraManager, num.intValue())) / ((float) FovUtil.focalLengthToViewAngleDegrees(FovUtil.getDefaultFocalLength(this.mCameraCharacteristicsCompat), FovUtil.getSensorHorizontalLength(this.mCameraCharacteristicsCompat)));
        } catch (Exception e) {
            Logger.e(TAG, "The camera is unable to provide necessary information to resolve its intrinsic zoom ratio with error: " + e);
            return 1.0f;
        }
    }

    public int getLensFacing() {
        boolean z;
        Integer num = (Integer) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING);
        if (num != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Unable to get the lens facing of the camera.");
        return LensFacingUtil.getCameraSelectorLensFacing(num.intValue());
    }

    @Nullable
    public Object getPhysicalCameraCharacteristics(@NonNull String str) {
        try {
            if (!this.mCameraCharacteristicsCompat.getPhysicalCameraIds().contains(str)) {
                return null;
            }
            return this.mCameraManager.getCameraCharacteristicsCompat(str).toCameraCharacteristics();
        } catch (CameraAccessExceptionCompat e) {
            Logger.e(TAG, "Failed to get CameraCharacteristics for cameraId " + str, e);
            return null;
        }
    }

    @NonNull
    public Set<CameraInfo> getPhysicalCameraInfos() {
        if (this.mPhysicalCameraInfos == null) {
            this.mPhysicalCameraInfos = new HashSet();
            for (String next : this.mCameraCharacteristicsCompat.getPhysicalCameraIds()) {
                try {
                    this.mPhysicalCameraInfos.add(new Camera2PhysicalCameraInfoImpl(next, this.mCameraManager));
                } catch (CameraAccessExceptionCompat e) {
                    Logger.e(TAG, "Failed to get CameraCharacteristics for cameraId " + next, e);
                    return Collections.emptySet();
                }
            }
        }
        return this.mPhysicalCameraInfos;
    }

    public int getSensorOrientation() {
        Integer num = (Integer) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.SENSOR_ORIENTATION);
        Preconditions.checkNotNull(num);
        return num.intValue();
    }

    public int getSensorRotationDegrees(int i) {
        int sensorOrientation = getSensorOrientation();
        int surfaceRotationToDegrees = CameraOrientationUtil.surfaceRotationToDegrees(i);
        boolean z = true;
        if (1 != getLensFacing()) {
            z = false;
        }
        return CameraOrientationUtil.getRelativeImageRotation(surfaceRotationToDegrees, sensorOrientation, z);
    }

    @NonNull
    public Set<DynamicRange> getSupportedDynamicRanges() {
        return DynamicRangesCompat.fromCameraCharacteristics(this.mCameraCharacteristicsCompat).getSupportedDynamicRanges();
    }

    @NonNull
    public Set<Range<Integer>> getSupportedFrameRateRanges() {
        Range[] rangeArr = (Range[]) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        if (rangeArr != null) {
            return new HashSet(Arrays.asList(rangeArr));
        }
        return Collections.emptySet();
    }

    public int getSupportedHardwareLevel() {
        Integer num = (Integer) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        Preconditions.checkNotNull(num);
        return num.intValue();
    }

    @NonNull
    public List<Size> getSupportedHighResolutions(int i) {
        Size[] highResolutionOutputSizes = this.mCameraCharacteristicsCompat.getStreamConfigurationMapCompat().getHighResolutionOutputSizes(i);
        if (highResolutionOutputSizes != null) {
            return Arrays.asList(highResolutionOutputSizes);
        }
        return Collections.emptyList();
    }

    @NonNull
    public Set<Integer> getSupportedOutputFormats() {
        int[] outputFormats = this.mCameraCharacteristicsCompat.getStreamConfigurationMapCompat().getOutputFormats();
        if (outputFormats == null) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (int valueOf : outputFormats) {
            hashSet.add(Integer.valueOf(valueOf));
        }
        return hashSet;
    }

    @NonNull
    public List<Size> getSupportedResolutions(int i) {
        Size[] outputSizes = this.mCameraCharacteristicsCompat.getStreamConfigurationMapCompat().getOutputSizes(i);
        if (outputSizes != null) {
            return Arrays.asList(outputSizes);
        }
        return Collections.emptyList();
    }

    @NonNull
    public Timebase getTimebase() {
        Integer num = (Integer) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.SENSOR_INFO_TIMESTAMP_SOURCE);
        Preconditions.checkNotNull(num);
        if (num.intValue() != 1) {
            return Timebase.UPTIME;
        }
        return Timebase.REALTIME;
    }

    @NonNull
    public LiveData<Integer> getTorchState() {
        synchronized (this.mLock) {
            try {
                Camera2CameraControlImpl camera2CameraControlImpl = this.mCamera2CameraControlImpl;
                if (camera2CameraControlImpl == null) {
                    if (this.mRedirectTorchStateLiveData == null) {
                        this.mRedirectTorchStateLiveData = new RedirectableLiveData<>(0);
                    }
                    RedirectableLiveData<Integer> redirectableLiveData = this.mRedirectTorchStateLiveData;
                    return redirectableLiveData;
                }
                RedirectableLiveData<Integer> redirectableLiveData2 = this.mRedirectTorchStateLiveData;
                if (redirectableLiveData2 != null) {
                    return redirectableLiveData2;
                }
                LiveData<Integer> torchState = camera2CameraControlImpl.getTorchControl().getTorchState();
                return torchState;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public LiveData<ZoomState> getZoomState() {
        synchronized (this.mLock) {
            try {
                Camera2CameraControlImpl camera2CameraControlImpl = this.mCamera2CameraControlImpl;
                if (camera2CameraControlImpl == null) {
                    if (this.mRedirectZoomStateLiveData == null) {
                        this.mRedirectZoomStateLiveData = new RedirectableLiveData<>(ZoomControl.getDefaultZoomState(this.mCameraCharacteristicsCompat));
                    }
                    RedirectableLiveData<ZoomState> redirectableLiveData = this.mRedirectZoomStateLiveData;
                    return redirectableLiveData;
                }
                RedirectableLiveData<ZoomState> redirectableLiveData2 = this.mRedirectZoomStateLiveData;
                if (redirectableLiveData2 != null) {
                    return redirectableLiveData2;
                }
                LiveData<ZoomState> zoomState = camera2CameraControlImpl.getZoomControl().getZoomState();
                return zoomState;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean hasFlashUnit() {
        CameraCharacteristicsCompat cameraCharacteristicsCompat = this.mCameraCharacteristicsCompat;
        Objects.requireNonNull(cameraCharacteristicsCompat);
        return FlashAvailabilityChecker.isFlashAvailable(new k0(cameraCharacteristicsCompat, 6));
    }

    public final /* synthetic */ boolean isCaptureProcessProgressSupported() {
        return n2.c(this);
    }

    public boolean isFocusMeteringSupported(@NonNull FocusMeteringAction focusMeteringAction) {
        synchronized (this.mLock) {
            try {
                Camera2CameraControlImpl camera2CameraControlImpl = this.mCamera2CameraControlImpl;
                if (camera2CameraControlImpl == null) {
                    return false;
                }
                boolean isFocusMeteringSupported = camera2CameraControlImpl.getFocusMeteringControl().isFocusMeteringSupported(focusMeteringAction);
                return isFocusMeteringSupported;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean isLogicalMultiCameraSupported() {
        return ZslUtil.isCapabilitySupported(this.mCameraCharacteristicsCompat, 11);
    }

    public final /* synthetic */ boolean isPostviewSupported() {
        return n2.d(this);
    }

    public boolean isPreviewStabilizationSupported() {
        int[] iArr = (int[]) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
        if (iArr != null) {
            for (int i : iArr) {
                if (i == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isPrivateReprocessingSupported() {
        return ZslUtil.isCapabilitySupported(this.mCameraCharacteristicsCompat, 4);
    }

    public boolean isVideoStabilizationSupported() {
        int[] iArr = (int[]) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
        if (iArr != null) {
            for (int i : iArr) {
                if (i == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @SuppressLint({"NullAnnotationGroup"})
    @OptIn(markerClass = {ExperimentalZeroShutterLag.class})
    public boolean isZslSupported() {
        if (Build.VERSION.SDK_INT < 23 || !isPrivateReprocessingSupported() || DeviceQuirks.get(ZslDisablerQuirk.class) != null) {
            return false;
        }
        return true;
    }

    public void linkWithCameraControl(@NonNull Camera2CameraControlImpl camera2CameraControlImpl) {
        synchronized (this.mLock) {
            try {
                this.mCamera2CameraControlImpl = camera2CameraControlImpl;
                RedirectableLiveData<ZoomState> redirectableLiveData = this.mRedirectZoomStateLiveData;
                if (redirectableLiveData != null) {
                    redirectableLiveData.redirectTo(camera2CameraControlImpl.getZoomControl().getZoomState());
                }
                RedirectableLiveData<Integer> redirectableLiveData2 = this.mRedirectTorchStateLiveData;
                if (redirectableLiveData2 != null) {
                    redirectableLiveData2.redirectTo(this.mCamera2CameraControlImpl.getTorchControl().getTorchState());
                }
                List<Pair<CameraCaptureCallback, Executor>> list = this.mCameraCaptureCallbacks;
                if (list != null) {
                    for (Pair next : list) {
                        this.mCamera2CameraControlImpl.addSessionCameraCaptureCallback((Executor) next.second, (CameraCaptureCallback) next.first);
                    }
                    this.mCameraCaptureCallbacks = null;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        logDeviceInfo();
    }

    @NonNull
    public Set<DynamicRange> querySupportedDynamicRanges(@NonNull Set<DynamicRange> set) {
        return DynamicRanges.findAllPossibleMatches(set, getSupportedDynamicRanges());
    }

    public void removeSessionCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback) {
        synchronized (this.mLock) {
            try {
                Camera2CameraControlImpl camera2CameraControlImpl = this.mCamera2CameraControlImpl;
                if (camera2CameraControlImpl == null) {
                    List<Pair<CameraCaptureCallback, Executor>> list = this.mCameraCaptureCallbacks;
                    if (list != null) {
                        Iterator<Pair<CameraCaptureCallback, Executor>> it = list.iterator();
                        while (it.hasNext()) {
                            if (it.next().first == cameraCaptureCallback) {
                                it.remove();
                            }
                        }
                        return;
                    }
                    return;
                }
                camera2CameraControlImpl.removeSessionCameraCaptureCallback(cameraCaptureCallback);
            } finally {
            }
        }
    }

    public void setCameraStateSource(@NonNull LiveData<CameraState> liveData) {
        this.mCameraStateLiveData.redirectTo(liveData);
    }

    public int getSensorRotationDegrees() {
        return getSensorRotationDegrees(0);
    }
}
