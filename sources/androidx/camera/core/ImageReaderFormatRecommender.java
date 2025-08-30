package androidx.camera.core;

import com.google.auto.value.AutoValue;

final class ImageReaderFormatRecommender {

    @AutoValue
    public static abstract class FormatCombo {
        public static FormatCombo create(int i, int i2) {
            return new AutoValue_ImageReaderFormatRecommender_FormatCombo(i, i2);
        }

        public abstract int imageAnalysisFormat();

        public abstract int imageCaptureFormat();
    }

    private ImageReaderFormatRecommender() {
    }

    public static FormatCombo chooseCombo() {
        return FormatCombo.create(256, 35);
    }
}
