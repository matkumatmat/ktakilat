package androidx.camera.core;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class LayoutSettings {
    public static final LayoutSettings DEFAULT = new Builder().setAlpha(1.0f).setOffsetX(0.0f).setOffsetY(0.0f).setWidth(1.0f).setHeight(1.0f).build();
    private final float mAlpha;
    private final float mHeight;
    private final float mOffsetX;
    private final float mOffsetY;
    private final float mWidth;

    public static final class Builder {
        private float mAlpha = 1.0f;
        private float mHeight = 0.0f;
        private float mOffsetX = 0.0f;
        private float mOffsetY = 0.0f;
        private float mWidth = 0.0f;

        @NonNull
        public LayoutSettings build() {
            return new LayoutSettings(this.mAlpha, this.mOffsetX, this.mOffsetY, this.mWidth, this.mHeight);
        }

        @NonNull
        public Builder setAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            this.mAlpha = f;
            return this;
        }

        @NonNull
        public Builder setHeight(@FloatRange(from = -1.0d, to = 1.0d) float f) {
            this.mHeight = f;
            return this;
        }

        @NonNull
        public Builder setOffsetX(@FloatRange(from = -1.0d, to = 1.0d) float f) {
            this.mOffsetX = f;
            return this;
        }

        @NonNull
        public Builder setOffsetY(@FloatRange(from = -1.0d, to = 1.0d) float f) {
            this.mOffsetY = f;
            return this;
        }

        @NonNull
        public Builder setWidth(@FloatRange(from = -1.0d, to = 1.0d) float f) {
            this.mWidth = f;
            return this;
        }
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public float getOffsetX() {
        return this.mOffsetX;
    }

    public float getOffsetY() {
        return this.mOffsetY;
    }

    public float getWidth() {
        return this.mWidth;
    }

    private LayoutSettings(float f, float f2, float f3, float f4, float f5) {
        this.mAlpha = f;
        this.mOffsetX = f2;
        this.mOffsetY = f3;
        this.mWidth = f4;
        this.mHeight = f5;
    }
}
