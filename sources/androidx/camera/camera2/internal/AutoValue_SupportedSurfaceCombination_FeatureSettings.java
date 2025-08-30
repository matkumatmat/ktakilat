package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.SupportedSurfaceCombination;

final class AutoValue_SupportedSurfaceCombination_FeatureSettings extends SupportedSurfaceCombination.FeatureSettings {
    private final int cameraMode;
    private final boolean previewStabilizationOn;
    private final int requiredMaxBitDepth;
    private final boolean ultraHdrOn;

    public AutoValue_SupportedSurfaceCombination_FeatureSettings(int i, int i2, boolean z, boolean z2) {
        this.cameraMode = i;
        this.requiredMaxBitDepth = i2;
        this.previewStabilizationOn = z;
        this.ultraHdrOn = z2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SupportedSurfaceCombination.FeatureSettings)) {
            return false;
        }
        SupportedSurfaceCombination.FeatureSettings featureSettings = (SupportedSurfaceCombination.FeatureSettings) obj;
        if (this.cameraMode == featureSettings.getCameraMode() && this.requiredMaxBitDepth == featureSettings.getRequiredMaxBitDepth() && this.previewStabilizationOn == featureSettings.isPreviewStabilizationOn() && this.ultraHdrOn == featureSettings.isUltraHdrOn()) {
            return true;
        }
        return false;
    }

    public int getCameraMode() {
        return this.cameraMode;
    }

    public int getRequiredMaxBitDepth() {
        return this.requiredMaxBitDepth;
    }

    public int hashCode() {
        int i;
        int i2 = (((this.cameraMode ^ 1000003) * 1000003) ^ this.requiredMaxBitDepth) * 1000003;
        int i3 = 1237;
        if (this.previewStabilizationOn) {
            i = 1231;
        } else {
            i = 1237;
        }
        int i4 = (i2 ^ i) * 1000003;
        if (this.ultraHdrOn) {
            i3 = 1231;
        }
        return i4 ^ i3;
    }

    public boolean isPreviewStabilizationOn() {
        return this.previewStabilizationOn;
    }

    public boolean isUltraHdrOn() {
        return this.ultraHdrOn;
    }

    public String toString() {
        return "FeatureSettings{cameraMode=" + this.cameraMode + ", requiredMaxBitDepth=" + this.requiredMaxBitDepth + ", previewStabilizationOn=" + this.previewStabilizationOn + ", ultraHdrOn=" + this.ultraHdrOn + "}";
    }
}
