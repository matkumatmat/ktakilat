package androidx.camera.core.streamsharing;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.ForwardingCameraInfo;
import androidx.camera.core.impl.utils.TransformUtils;
import java.util.UUID;

public class VirtualCameraInfo extends ForwardingCameraInfo {
    private final String mVirtualCameraId;
    private int mVirtualCameraRotationDegrees;

    public VirtualCameraInfo(@NonNull CameraInfoInternal cameraInfoInternal) {
        super(cameraInfoInternal);
        this.mVirtualCameraId = "virtual-" + cameraInfoInternal.getCameraId() + "-" + UUID.randomUUID().toString();
    }

    @NonNull
    public String getCameraId() {
        return this.mVirtualCameraId;
    }

    public int getSensorRotationDegrees() {
        return getSensorRotationDegrees(0);
    }

    public void setVirtualCameraRotationDegrees(int i) {
        this.mVirtualCameraRotationDegrees = i;
    }

    public int getSensorRotationDegrees(int i) {
        return TransformUtils.within360(super.getSensorRotationDegrees(i) - this.mVirtualCameraRotationDegrees);
    }
}
