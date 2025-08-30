package androidx.camera.extensions.internal;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.ImageCaptureConfig;

public class ImageCaptureConfigProvider implements ConfigProvider<ImageCaptureConfig> {
    private final VendorExtender mVendorExtender;

    public ImageCaptureConfigProvider(@NonNull VendorExtender vendorExtender) {
        this.mVendorExtender = vendorExtender;
    }

    public void updateBuilderConfig(@NonNull ImageCapture.Builder builder, @NonNull VendorExtender vendorExtender) {
        builder.setSupportedResolutions(vendorExtender.getSupportedCaptureOutputResolutions());
        builder.setHighResolutionDisabled(true);
    }

    @NonNull
    public ImageCaptureConfig getConfig() {
        ImageCapture.Builder builder = new ImageCapture.Builder();
        updateBuilderConfig(builder, this.mVendorExtender);
        return builder.getUseCaseConfig();
    }
}
