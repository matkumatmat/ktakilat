package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

final class AutoValue_OutputSurfaceConfiguration extends OutputSurfaceConfiguration {
    private final OutputSurface imageAnalysisOutputSurface;
    private final OutputSurface imageCaptureOutputSurface;
    private final OutputSurface postviewOutputSurface;
    private final OutputSurface previewOutputSurface;

    public AutoValue_OutputSurfaceConfiguration(OutputSurface outputSurface, OutputSurface outputSurface2, @Nullable OutputSurface outputSurface3, @Nullable OutputSurface outputSurface4) {
        if (outputSurface != null) {
            this.previewOutputSurface = outputSurface;
            if (outputSurface2 != null) {
                this.imageCaptureOutputSurface = outputSurface2;
                this.imageAnalysisOutputSurface = outputSurface3;
                this.postviewOutputSurface = outputSurface4;
                return;
            }
            throw new NullPointerException("Null imageCaptureOutputSurface");
        }
        throw new NullPointerException("Null previewOutputSurface");
    }

    public boolean equals(Object obj) {
        OutputSurface outputSurface;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OutputSurfaceConfiguration)) {
            return false;
        }
        OutputSurfaceConfiguration outputSurfaceConfiguration = (OutputSurfaceConfiguration) obj;
        if (this.previewOutputSurface.equals(outputSurfaceConfiguration.getPreviewOutputSurface()) && this.imageCaptureOutputSurface.equals(outputSurfaceConfiguration.getImageCaptureOutputSurface()) && ((outputSurface = this.imageAnalysisOutputSurface) != null ? outputSurface.equals(outputSurfaceConfiguration.getImageAnalysisOutputSurface()) : outputSurfaceConfiguration.getImageAnalysisOutputSurface() == null)) {
            OutputSurface outputSurface2 = this.postviewOutputSurface;
            if (outputSurface2 == null) {
                if (outputSurfaceConfiguration.getPostviewOutputSurface() == null) {
                    return true;
                }
            } else if (outputSurface2.equals(outputSurfaceConfiguration.getPostviewOutputSurface())) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public OutputSurface getImageAnalysisOutputSurface() {
        return this.imageAnalysisOutputSurface;
    }

    @NonNull
    public OutputSurface getImageCaptureOutputSurface() {
        return this.imageCaptureOutputSurface;
    }

    @Nullable
    public OutputSurface getPostviewOutputSurface() {
        return this.postviewOutputSurface;
    }

    @NonNull
    public OutputSurface getPreviewOutputSurface() {
        return this.previewOutputSurface;
    }

    public int hashCode() {
        int i;
        int hashCode = (((this.previewOutputSurface.hashCode() ^ 1000003) * 1000003) ^ this.imageCaptureOutputSurface.hashCode()) * 1000003;
        OutputSurface outputSurface = this.imageAnalysisOutputSurface;
        int i2 = 0;
        if (outputSurface == null) {
            i = 0;
        } else {
            i = outputSurface.hashCode();
        }
        int i3 = (hashCode ^ i) * 1000003;
        OutputSurface outputSurface2 = this.postviewOutputSurface;
        if (outputSurface2 != null) {
            i2 = outputSurface2.hashCode();
        }
        return i3 ^ i2;
    }

    public String toString() {
        return "OutputSurfaceConfiguration{previewOutputSurface=" + this.previewOutputSurface + ", imageCaptureOutputSurface=" + this.imageCaptureOutputSurface + ", imageAnalysisOutputSurface=" + this.imageAnalysisOutputSurface + ", postviewOutputSurface=" + this.postviewOutputSurface + "}";
    }
}
