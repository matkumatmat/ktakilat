package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.ResolutionInfo;

final class AutoValue_ResolutionInfo_ResolutionInfoInternal extends ResolutionInfo.ResolutionInfoInternal {
    private final Rect cropRect;
    private final Size resolution;
    private final int rotationDegrees;

    public static final class Builder extends ResolutionInfo.ResolutionInfoInternal.Builder {
        private Rect cropRect;
        private Size resolution;
        private Integer rotationDegrees;

        public ResolutionInfo.ResolutionInfoInternal build() {
            String str;
            if (this.resolution == null) {
                str = " resolution";
            } else {
                str = "";
            }
            if (this.cropRect == null) {
                str = e.l(str, " cropRect");
            }
            if (this.rotationDegrees == null) {
                str = e.l(str, " rotationDegrees");
            }
            if (str.isEmpty()) {
                return new AutoValue_ResolutionInfo_ResolutionInfoInternal(this.resolution, this.cropRect, this.rotationDegrees.intValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }

        public ResolutionInfo.ResolutionInfoInternal.Builder setCropRect(Rect rect) {
            if (rect != null) {
                this.cropRect = rect;
                return this;
            }
            throw new NullPointerException("Null cropRect");
        }

        public ResolutionInfo.ResolutionInfoInternal.Builder setResolution(Size size) {
            if (size != null) {
                this.resolution = size;
                return this;
            }
            throw new NullPointerException("Null resolution");
        }

        public ResolutionInfo.ResolutionInfoInternal.Builder setRotationDegrees(int i) {
            this.rotationDegrees = Integer.valueOf(i);
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResolutionInfo.ResolutionInfoInternal)) {
            return false;
        }
        ResolutionInfo.ResolutionInfoInternal resolutionInfoInternal = (ResolutionInfo.ResolutionInfoInternal) obj;
        if (!this.resolution.equals(resolutionInfoInternal.getResolution()) || !this.cropRect.equals(resolutionInfoInternal.getCropRect()) || this.rotationDegrees != resolutionInfoInternal.getRotationDegrees()) {
            return false;
        }
        return true;
    }

    @NonNull
    public Rect getCropRect() {
        return this.cropRect;
    }

    @NonNull
    public Size getResolution() {
        return this.resolution;
    }

    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    public int hashCode() {
        return ((((this.resolution.hashCode() ^ 1000003) * 1000003) ^ this.cropRect.hashCode()) * 1000003) ^ this.rotationDegrees;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ResolutionInfoInternal{resolution=");
        sb.append(this.resolution);
        sb.append(", cropRect=");
        sb.append(this.cropRect);
        sb.append(", rotationDegrees=");
        return ba.q(sb, "}", this.rotationDegrees);
    }

    private AutoValue_ResolutionInfo_ResolutionInfoInternal(Size size, Rect rect, int i) {
        this.resolution = size;
        this.cropRect = rect;
        this.rotationDegrees = i;
    }
}
