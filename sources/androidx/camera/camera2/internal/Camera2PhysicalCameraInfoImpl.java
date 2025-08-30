package androidx.camera.camera2.internal;

import android.annotation.SuppressLint;
import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.interop.Camera2CameraInfo;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraState;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ExperimentalZeroShutterLag;
import androidx.camera.core.ExposureState;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;
import java.util.Set;

@ExperimentalCamera2Interop
public class Camera2PhysicalCameraInfoImpl implements CameraInfo {
    @NonNull
    private final Camera2CameraInfo mCamera2CameraInfo = new Camera2CameraInfo(this);
    @NonNull
    private final CameraCharacteristicsCompat mCameraCharacteristicsCompat;
    @NonNull
    private final String mCameraId;

    public Camera2PhysicalCameraInfoImpl(@NonNull String str, @NonNull CameraManagerCompat cameraManagerCompat) throws CameraAccessExceptionCompat {
        this.mCameraId = str;
        this.mCameraCharacteristicsCompat = cameraManagerCompat.getCameraCharacteristicsCompat(str);
    }

    @NonNull
    public Camera2CameraInfo getCamera2CameraInfo() {
        return this.mCamera2CameraInfo;
    }

    @NonNull
    public CameraCharacteristicsCompat getCameraCharacteristicsCompat() {
        return this.mCameraCharacteristicsCompat;
    }

    @NonNull
    public String getCameraId() {
        return this.mCameraId;
    }

    @NonNull
    public CameraSelector getCameraSelector() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    @NonNull
    public LiveData<CameraState> getCameraState() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    @NonNull
    public ExposureState getExposureState() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    @NonNull
    public String getImplementationType() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    public float getIntrinsicZoomRatio() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
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

    @NonNull
    public Set<CameraInfo> getPhysicalCameraInfos() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    public int getSensorOrientation() {
        Integer num = (Integer) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.SENSOR_ORIENTATION);
        Preconditions.checkNotNull(num);
        return num.intValue();
    }

    public int getSensorRotationDegrees() {
        return getSensorRotationDegrees(0);
    }

    @NonNull
    public Set<Range<Integer>> getSupportedFrameRateRanges() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    @NonNull
    public LiveData<Integer> getTorchState() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    @NonNull
    public LiveData<ZoomState> getZoomState() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    public boolean hasFlashUnit() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    public boolean isFocusMeteringSupported(@NonNull FocusMeteringAction focusMeteringAction) {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    public boolean isLogicalMultiCameraSupported() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    public boolean isPrivateReprocessingSupported() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    @ExperimentalZeroShutterLag
    @SuppressLint({"NullAnnotationGroup"})
    public boolean isZslSupported() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    @NonNull
    public Set<DynamicRange> querySupportedDynamicRanges(@NonNull Set<DynamicRange> set) {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
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
}
