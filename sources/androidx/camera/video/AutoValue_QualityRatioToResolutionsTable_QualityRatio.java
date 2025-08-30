package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.camera.video.QualityRatioToResolutionsTable;

final class AutoValue_QualityRatioToResolutionsTable_QualityRatio extends QualityRatioToResolutionsTable.QualityRatio {
    private final int aspectRatio;
    private final Quality quality;

    public AutoValue_QualityRatioToResolutionsTable_QualityRatio(Quality quality2, int i) {
        if (quality2 != null) {
            this.quality = quality2;
            this.aspectRatio = i;
            return;
        }
        throw new NullPointerException("Null quality");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QualityRatioToResolutionsTable.QualityRatio)) {
            return false;
        }
        QualityRatioToResolutionsTable.QualityRatio qualityRatio = (QualityRatioToResolutionsTable.QualityRatio) obj;
        if (!this.quality.equals(qualityRatio.getQuality()) || this.aspectRatio != qualityRatio.getAspectRatio()) {
            return false;
        }
        return true;
    }

    public int getAspectRatio() {
        return this.aspectRatio;
    }

    @NonNull
    public Quality getQuality() {
        return this.quality;
    }

    public int hashCode() {
        return ((this.quality.hashCode() ^ 1000003) * 1000003) ^ this.aspectRatio;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("QualityRatio{quality=");
        sb.append(this.quality);
        sb.append(", aspectRatio=");
        return ba.q(sb, "}", this.aspectRatio);
    }
}
