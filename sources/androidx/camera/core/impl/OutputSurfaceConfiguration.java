package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class OutputSurfaceConfiguration {
    @NonNull
    public static OutputSurfaceConfiguration create(@NonNull OutputSurface outputSurface, @NonNull OutputSurface outputSurface2, @Nullable OutputSurface outputSurface3, @Nullable OutputSurface outputSurface4) {
        return new AutoValue_OutputSurfaceConfiguration(outputSurface, outputSurface2, outputSurface3, outputSurface4);
    }

    @Nullable
    public abstract OutputSurface getImageAnalysisOutputSurface();

    @NonNull
    public abstract OutputSurface getImageCaptureOutputSurface();

    @Nullable
    public abstract OutputSurface getPostviewOutputSurface();

    @NonNull
    public abstract OutputSurface getPreviewOutputSurface();
}
