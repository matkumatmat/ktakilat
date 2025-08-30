package androidx.camera.core.imagecapture;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.imagecapture.TakePictureManager;

final class AutoValue_TakePictureManager_CaptureError extends TakePictureManager.CaptureError {
    private final ImageCaptureException imageCaptureException;
    private final int requestId;

    public AutoValue_TakePictureManager_CaptureError(int i, ImageCaptureException imageCaptureException2) {
        this.requestId = i;
        if (imageCaptureException2 != null) {
            this.imageCaptureException = imageCaptureException2;
            return;
        }
        throw new NullPointerException("Null imageCaptureException");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TakePictureManager.CaptureError)) {
            return false;
        }
        TakePictureManager.CaptureError captureError = (TakePictureManager.CaptureError) obj;
        if (this.requestId != captureError.getRequestId() || !this.imageCaptureException.equals(captureError.getImageCaptureException())) {
            return false;
        }
        return true;
    }

    @NonNull
    public ImageCaptureException getImageCaptureException() {
        return this.imageCaptureException;
    }

    public int getRequestId() {
        return this.requestId;
    }

    public int hashCode() {
        return ((this.requestId ^ 1000003) * 1000003) ^ this.imageCaptureException.hashCode();
    }

    public String toString() {
        return "CaptureError{requestId=" + this.requestId + ", imageCaptureException=" + this.imageCaptureException + "}";
    }
}
