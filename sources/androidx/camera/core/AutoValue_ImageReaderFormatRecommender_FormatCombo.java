package androidx.camera.core;

import androidx.camera.core.ImageReaderFormatRecommender;

final class AutoValue_ImageReaderFormatRecommender_FormatCombo extends ImageReaderFormatRecommender.FormatCombo {
    private final int imageAnalysisFormat;
    private final int imageCaptureFormat;

    public AutoValue_ImageReaderFormatRecommender_FormatCombo(int i, int i2) {
        this.imageCaptureFormat = i;
        this.imageAnalysisFormat = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageReaderFormatRecommender.FormatCombo)) {
            return false;
        }
        ImageReaderFormatRecommender.FormatCombo formatCombo = (ImageReaderFormatRecommender.FormatCombo) obj;
        if (this.imageCaptureFormat == formatCombo.imageCaptureFormat() && this.imageAnalysisFormat == formatCombo.imageAnalysisFormat()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.imageCaptureFormat ^ 1000003) * 1000003) ^ this.imageAnalysisFormat;
    }

    public int imageAnalysisFormat() {
        return this.imageAnalysisFormat;
    }

    public int imageCaptureFormat() {
        return this.imageCaptureFormat;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FormatCombo{imageCaptureFormat=");
        sb.append(this.imageCaptureFormat);
        sb.append(", imageAnalysisFormat=");
        return ba.q(sb, "}", this.imageAnalysisFormat);
    }
}
