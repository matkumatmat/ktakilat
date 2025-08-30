package androidx.camera.core.imagecapture;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.CaptureConfig;
import java.util.List;

public final class CameraRequest {
    private final TakePictureCallback mCallback;
    private final List<CaptureConfig> mCaptureConfigs;

    public CameraRequest(@NonNull List<CaptureConfig> list, @NonNull TakePictureCallback takePictureCallback) {
        this.mCaptureConfigs = list;
        this.mCallback = takePictureCallback;
    }

    @NonNull
    public List<CaptureConfig> getCaptureConfigs() {
        return this.mCaptureConfigs;
    }

    public boolean isAborted() {
        return this.mCallback.isAborted();
    }
}
