package androidx.core.content.res;

import androidx.annotation.NonNull;

final class ViewingConditions {
    static final ViewingConditions DEFAULT = make(CamUtils.WHITE_POINT_D65, (float) ((((double) CamUtils.yFromLStar(50.0f)) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
    private final float mAw;
    private final float mC;
    private final float mFl;
    private final float mFlRoot;
    private final float mN;
    private final float mNbb;
    private final float mNc;
    private final float mNcb;
    private final float[] mRgbD;
    private final float mZ;

    private ViewingConditions(float f, float f2, float f3, float f4, float f5, float f6, float[] fArr, float f7, float f8, float f9) {
        this.mN = f;
        this.mAw = f2;
        this.mNbb = f3;
        this.mNcb = f4;
        this.mC = f5;
        this.mNc = f6;
        this.mRgbD = fArr;
        this.mFl = f7;
        this.mFlRoot = f8;
        this.mZ = f9;
    }

    @NonNull
    public static ViewingConditions make(@NonNull float[] fArr, float f, float f2, float f3, boolean z) {
        float lerp;
        float f4;
        float f5 = f;
        float[][] fArr2 = CamUtils.XYZ_TO_CAM16RGB;
        float f6 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f7 = fArr[1];
        float f8 = fArr3[1] * f7;
        float f9 = fArr[2];
        float f10 = (fArr3[2] * f9) + f8 + (fArr3[0] * f6);
        float[] fArr4 = fArr2[1];
        float f11 = fArr4[1] * f7;
        float f12 = (fArr4[2] * f9) + f11 + (fArr4[0] * f6);
        float[] fArr5 = fArr2[2];
        float f13 = f6 * fArr5[0];
        float f14 = (f9 * fArr5[2]) + (f7 * fArr5[1]) + f13;
        float f15 = (f3 / 10.0f) + 0.8f;
        if (((double) f15) >= 0.9d) {
            lerp = CamUtils.lerp(0.59f, 0.69f, (f15 - 0.9f) * 10.0f);
        } else {
            lerp = CamUtils.lerp(0.525f, 0.59f, (f15 - 0.8f) * 10.0f);
        }
        float f16 = lerp;
        if (z) {
            f4 = 1.0f;
        } else {
            f4 = (1.0f - (((float) Math.exp((double) (((-f5) - 42.0f) / 92.0f))) * 0.2777778f)) * f15;
        }
        double d = (double) f4;
        if (d > 1.0d) {
            f4 = 1.0f;
        } else if (d < 0.0d) {
            f4 = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f10) * f4) + 1.0f) - f4, (((100.0f / f12) * f4) + 1.0f) - f4, (((100.0f / f14) * f4) + 1.0f) - f4};
        float f17 = 1.0f / ((5.0f * f5) + 1.0f);
        float f18 = f17 * f17 * f17 * f17;
        float f19 = 1.0f - f18;
        float cbrt = (0.1f * f19 * f19 * ((float) Math.cbrt(((double) f5) * 5.0d))) + (f18 * f5);
        float yFromLStar = CamUtils.yFromLStar(f2) / fArr[1];
        double d2 = (double) yFromLStar;
        float sqrt = ((float) Math.sqrt(d2)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d2, 0.2d));
        float f20 = f15;
        float[] fArr7 = {(float) Math.pow(((double) ((fArr6[0] * cbrt) * f10)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[1] * cbrt) * f12)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[2] * cbrt) * f14)) / 100.0d, 0.42d)};
        float f21 = fArr7[0];
        float f22 = (f21 * 400.0f) / (f21 + 27.13f);
        float f23 = fArr7[1];
        float f24 = (f23 * 400.0f) / (f23 + 27.13f);
        float f25 = fArr7[2];
        float[] fArr8 = {f22, f24, (400.0f * f25) / (f25 + 27.13f)};
        return new ViewingConditions(yFromLStar, ((fArr8[2] * 0.05f) + (fArr8[0] * 2.0f) + fArr8[1]) * pow, pow, pow, f16, f20, fArr6, cbrt, (float) Math.pow((double) cbrt, 0.25d), sqrt);
    }

    public float getAw() {
        return this.mAw;
    }

    public float getC() {
        return this.mC;
    }

    public float getFl() {
        return this.mFl;
    }

    public float getFlRoot() {
        return this.mFlRoot;
    }

    public float getN() {
        return this.mN;
    }

    public float getNbb() {
        return this.mNbb;
    }

    public float getNc() {
        return this.mNc;
    }

    public float getNcb() {
        return this.mNcb;
    }

    @NonNull
    public float[] getRgbD() {
        return this.mRgbD;
    }

    public float getZ() {
        return this.mZ;
    }
}
