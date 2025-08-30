package androidx.camera.core.imagecapture;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.CameraCaptureCallback;
import java.util.List;
import java.util.concurrent.Executor;

final class AutoValue_TakePictureRequest extends TakePictureRequest {
    private final Executor appExecutor;
    private final int captureMode;
    private final Rect cropRect;
    private final ImageCapture.OnImageCapturedCallback inMemoryCallback;
    private final int jpegQuality;
    private final ImageCapture.OnImageSavedCallback onDiskCallback;
    private final ImageCapture.OutputFileOptions outputFileOptions;
    private final int rotationDegrees;
    private final Matrix sensorToBufferTransform;
    private final List<CameraCaptureCallback> sessionConfigCameraCaptureCallbacks;

    public AutoValue_TakePictureRequest(Executor executor, @Nullable ImageCapture.OnImageCapturedCallback onImageCapturedCallback, @Nullable ImageCapture.OnImageSavedCallback onImageSavedCallback, @Nullable ImageCapture.OutputFileOptions outputFileOptions2, Rect rect, Matrix matrix, int i, int i2, int i3, List<CameraCaptureCallback> list) {
        if (executor != null) {
            this.appExecutor = executor;
            this.inMemoryCallback = onImageCapturedCallback;
            this.onDiskCallback = onImageSavedCallback;
            this.outputFileOptions = outputFileOptions2;
            if (rect != null) {
                this.cropRect = rect;
                if (matrix != null) {
                    this.sensorToBufferTransform = matrix;
                    this.rotationDegrees = i;
                    this.jpegQuality = i2;
                    this.captureMode = i3;
                    if (list != null) {
                        this.sessionConfigCameraCaptureCallbacks = list;
                        return;
                    }
                    throw new NullPointerException("Null sessionConfigCameraCaptureCallbacks");
                }
                throw new NullPointerException("Null sensorToBufferTransform");
            }
            throw new NullPointerException("Null cropRect");
        }
        throw new NullPointerException("Null appExecutor");
    }

    public boolean equals(Object obj) {
        ImageCapture.OnImageCapturedCallback onImageCapturedCallback;
        ImageCapture.OnImageSavedCallback onImageSavedCallback;
        ImageCapture.OutputFileOptions outputFileOptions2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TakePictureRequest)) {
            return false;
        }
        TakePictureRequest takePictureRequest = (TakePictureRequest) obj;
        if (!this.appExecutor.equals(takePictureRequest.getAppExecutor()) || ((onImageCapturedCallback = this.inMemoryCallback) != null ? !onImageCapturedCallback.equals(takePictureRequest.getInMemoryCallback()) : takePictureRequest.getInMemoryCallback() != null) || ((onImageSavedCallback = this.onDiskCallback) != null ? !onImageSavedCallback.equals(takePictureRequest.getOnDiskCallback()) : takePictureRequest.getOnDiskCallback() != null) || ((outputFileOptions2 = this.outputFileOptions) != null ? !outputFileOptions2.equals(takePictureRequest.getOutputFileOptions()) : takePictureRequest.getOutputFileOptions() != null) || !this.cropRect.equals(takePictureRequest.getCropRect()) || !this.sensorToBufferTransform.equals(takePictureRequest.getSensorToBufferTransform()) || this.rotationDegrees != takePictureRequest.getRotationDegrees() || this.jpegQuality != takePictureRequest.getJpegQuality() || this.captureMode != takePictureRequest.getCaptureMode() || !this.sessionConfigCameraCaptureCallbacks.equals(takePictureRequest.getSessionConfigCameraCaptureCallbacks())) {
            return false;
        }
        return true;
    }

    @NonNull
    public Executor getAppExecutor() {
        return this.appExecutor;
    }

    public int getCaptureMode() {
        return this.captureMode;
    }

    @NonNull
    public Rect getCropRect() {
        return this.cropRect;
    }

    @Nullable
    public ImageCapture.OnImageCapturedCallback getInMemoryCallback() {
        return this.inMemoryCallback;
    }

    @IntRange(from = 1, to = 100)
    public int getJpegQuality() {
        return this.jpegQuality;
    }

    @Nullable
    public ImageCapture.OnImageSavedCallback getOnDiskCallback() {
        return this.onDiskCallback;
    }

    @Nullable
    public ImageCapture.OutputFileOptions getOutputFileOptions() {
        return this.outputFileOptions;
    }

    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    @NonNull
    public Matrix getSensorToBufferTransform() {
        return this.sensorToBufferTransform;
    }

    @NonNull
    public List<CameraCaptureCallback> getSessionConfigCameraCaptureCallbacks() {
        return this.sessionConfigCameraCaptureCallbacks;
    }

    public int hashCode() {
        int i;
        int i2;
        int hashCode = (this.appExecutor.hashCode() ^ 1000003) * 1000003;
        ImageCapture.OnImageCapturedCallback onImageCapturedCallback = this.inMemoryCallback;
        int i3 = 0;
        if (onImageCapturedCallback == null) {
            i = 0;
        } else {
            i = onImageCapturedCallback.hashCode();
        }
        int i4 = (hashCode ^ i) * 1000003;
        ImageCapture.OnImageSavedCallback onImageSavedCallback = this.onDiskCallback;
        if (onImageSavedCallback == null) {
            i2 = 0;
        } else {
            i2 = onImageSavedCallback.hashCode();
        }
        int i5 = (i4 ^ i2) * 1000003;
        ImageCapture.OutputFileOptions outputFileOptions2 = this.outputFileOptions;
        if (outputFileOptions2 != null) {
            i3 = outputFileOptions2.hashCode();
        }
        return ((((((((((((i5 ^ i3) * 1000003) ^ this.cropRect.hashCode()) * 1000003) ^ this.sensorToBufferTransform.hashCode()) * 1000003) ^ this.rotationDegrees) * 1000003) ^ this.jpegQuality) * 1000003) ^ this.captureMode) * 1000003) ^ this.sessionConfigCameraCaptureCallbacks.hashCode();
    }

    public String toString() {
        return "TakePictureRequest{appExecutor=" + this.appExecutor + ", inMemoryCallback=" + this.inMemoryCallback + ", onDiskCallback=" + this.onDiskCallback + ", outputFileOptions=" + this.outputFileOptions + ", cropRect=" + this.cropRect + ", sensorToBufferTransform=" + this.sensorToBufferTransform + ", rotationDegrees=" + this.rotationDegrees + ", jpegQuality=" + this.jpegQuality + ", captureMode=" + this.captureMode + ", sessionConfigCameraCaptureCallbacks=" + this.sessionConfigCameraCaptureCallbacks + "}";
    }
}
