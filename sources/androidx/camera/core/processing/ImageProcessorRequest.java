package androidx.camera.core.processing;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageProcessor;
import androidx.camera.core.ImageProxy;

public class ImageProcessorRequest implements ImageProcessor.Request {
    @NonNull
    private final ImageProxy mImageProxy;
    private final int mOutputFormat;

    public ImageProcessorRequest(@NonNull ImageProxy imageProxy, int i) {
        this.mImageProxy = imageProxy;
        this.mOutputFormat = i;
    }

    @NonNull
    public ImageProxy getInputImage() {
        return this.mImageProxy;
    }

    public int getOutputFormat() {
        return this.mOutputFormat;
    }
}
