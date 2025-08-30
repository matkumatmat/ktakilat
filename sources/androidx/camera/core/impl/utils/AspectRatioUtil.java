package androidx.camera.core.impl.utils;

import android.graphics.RectF;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.core.util.Preconditions;
import java.util.Comparator;

public final class AspectRatioUtil {
    private static final int ALIGN16 = 16;
    public static final Rational ASPECT_RATIO_16_9 = new Rational(16, 9);
    public static final Rational ASPECT_RATIO_3_4 = new Rational(3, 4);
    public static final Rational ASPECT_RATIO_4_3 = new Rational(4, 3);
    public static final Rational ASPECT_RATIO_9_16 = new Rational(9, 16);

    public static final class CompareAspectRatiosByMappingAreaInFullFovAspectRatioSpace implements Comparator<Rational> {
        private final Rational mFullFovRatio;
        private final Rational mTargetRatio;
        private final RectF mTransformedMappingArea;

        public CompareAspectRatiosByMappingAreaInFullFovAspectRatioSpace(@NonNull Rational rational, @Nullable Rational rational2) {
            this.mTargetRatio = rational;
            this.mFullFovRatio = rational2 == null ? new Rational(4, 3) : rational2;
            this.mTransformedMappingArea = getTransformedMappingArea(rational);
        }

        private float getMappingAreaSize(RectF rectF) {
            return rectF.height() * rectF.width();
        }

        private float getOverlappingAreaSize(RectF rectF, RectF rectF2) {
            float f;
            float f2;
            if (rectF.width() < rectF2.width()) {
                f = rectF.width();
            } else {
                f = rectF2.width();
            }
            if (rectF.height() < rectF2.height()) {
                f2 = rectF.height();
            } else {
                f2 = rectF2.height();
            }
            return f * f2;
        }

        private RectF getTransformedMappingArea(Rational rational) {
            if (rational.floatValue() == this.mFullFovRatio.floatValue()) {
                return new RectF(0.0f, 0.0f, (float) this.mFullFovRatio.getNumerator(), (float) this.mFullFovRatio.getDenominator());
            }
            if (rational.floatValue() > this.mFullFovRatio.floatValue()) {
                return new RectF(0.0f, 0.0f, (float) this.mFullFovRatio.getNumerator(), (((float) rational.getDenominator()) * ((float) this.mFullFovRatio.getNumerator())) / ((float) rational.getNumerator()));
            }
            return new RectF(0.0f, 0.0f, (((float) rational.getNumerator()) * ((float) this.mFullFovRatio.getDenominator())) / ((float) rational.getDenominator()), (float) this.mFullFovRatio.getDenominator());
        }

        private boolean isMappingAreaCovered(RectF rectF, RectF rectF2) {
            if (rectF.width() < rectF2.width() || rectF.height() < rectF2.height()) {
                return false;
            }
            return true;
        }

        public int compare(Rational rational, Rational rational2) {
            if (rational.equals(rational2)) {
                return 0;
            }
            RectF transformedMappingArea = getTransformedMappingArea(rational);
            RectF transformedMappingArea2 = getTransformedMappingArea(rational2);
            boolean isMappingAreaCovered = isMappingAreaCovered(transformedMappingArea, this.mTransformedMappingArea);
            boolean isMappingAreaCovered2 = isMappingAreaCovered(transformedMappingArea2, this.mTransformedMappingArea);
            if (isMappingAreaCovered && isMappingAreaCovered2) {
                return (int) Math.signum(getMappingAreaSize(transformedMappingArea) - getMappingAreaSize(transformedMappingArea2));
            }
            if (isMappingAreaCovered) {
                return -1;
            }
            if (isMappingAreaCovered2) {
                return 1;
            }
            return -((int) Math.signum(getOverlappingAreaSize(transformedMappingArea, this.mTransformedMappingArea) - getOverlappingAreaSize(transformedMappingArea2, this.mTransformedMappingArea)));
        }
    }

    private AspectRatioUtil() {
    }

    public static boolean hasMatchingAspectRatio(@NonNull Size size, @Nullable Rational rational) {
        return hasMatchingAspectRatio(size, rational, SizeUtil.RESOLUTION_VGA);
    }

    private static boolean isPossibleMod16FromAspectRatio(@NonNull Size size, @NonNull Rational rational) {
        int width = size.getWidth();
        int height = size.getHeight();
        Rational rational2 = new Rational(rational.getDenominator(), rational.getNumerator());
        int i = width % 16;
        if (i == 0 && height % 16 == 0) {
            if (ratioIntersectsMod16Segment(Math.max(0, height - 16), width, rational) || ratioIntersectsMod16Segment(Math.max(0, width - 16), height, rational2)) {
                return true;
            }
            return false;
        } else if (i == 0) {
            return ratioIntersectsMod16Segment(height, width, rational);
        } else {
            if (height % 16 == 0) {
                return ratioIntersectsMod16Segment(width, height, rational2);
            }
            return false;
        }
    }

    private static boolean ratioIntersectsMod16Segment(int i, int i2, Rational rational) {
        boolean z;
        if (i2 % 16 == 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        double numerator = ((double) (rational.getNumerator() * i)) / ((double) rational.getDenominator());
        if (numerator <= ((double) Math.max(0, i2 - 16)) || numerator >= ((double) (i2 + 16))) {
            return false;
        }
        return true;
    }

    public static boolean hasMatchingAspectRatio(@NonNull Size size, @Nullable Rational rational, @NonNull Size size2) {
        if (rational == null) {
            return false;
        }
        if (rational.equals(new Rational(size.getWidth(), size.getHeight()))) {
            return true;
        }
        if (SizeUtil.getArea(size) >= SizeUtil.getArea(size2)) {
            return isPossibleMod16FromAspectRatio(size, rational);
        }
        return false;
    }
}
