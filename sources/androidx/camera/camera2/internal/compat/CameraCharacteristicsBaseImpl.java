package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCharacteristics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import java.util.Collections;
import java.util.Set;

class CameraCharacteristicsBaseImpl implements CameraCharacteristicsCompat.CameraCharacteristicsCompatImpl {
    @NonNull
    protected final CameraCharacteristics mCameraCharacteristics;

    public CameraCharacteristicsBaseImpl(@NonNull CameraCharacteristics cameraCharacteristics) {
        this.mCameraCharacteristics = cameraCharacteristics;
    }

    @Nullable
    public <T> T get(@NonNull CameraCharacteristics.Key<T> key) {
        return this.mCameraCharacteristics.get(key);
    }

    @NonNull
    public Set<String> getPhysicalCameraIds() {
        return Collections.emptySet();
    }

    @NonNull
    public CameraCharacteristics unwrap() {
        return this.mCameraCharacteristics;
    }
}
