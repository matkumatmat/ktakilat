package com.google.android.material.carousel;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.R;
import com.google.android.material.carousel.KeylineState;

final class CarouselStrategyHelper {
    private CarouselStrategyHelper() {
    }

    public static KeylineState createLeftAlignedKeylineState(@NonNull Context context, float f, float f2, @NonNull Arrangement arrangement) {
        float f3;
        float extraSmallSize = getExtraSmallSize(context) + f;
        float f4 = extraSmallSize / 2.0f;
        float f5 = 0.0f - f4;
        float f6 = (arrangement.largeSize / 2.0f) + 0.0f;
        float f7 = arrangement.largeSize;
        float max = (((float) Math.max(0, arrangement.largeCount - 1)) * f7) + f6;
        float f8 = (f7 / 2.0f) + max;
        int i = arrangement.mediumCount;
        if (i > 0) {
            max = (arrangement.mediumSize / 2.0f) + f8;
        }
        if (i > 0) {
            f8 = (arrangement.mediumSize / 2.0f) + max;
        }
        if (arrangement.smallCount > 0) {
            f3 = (arrangement.smallSize / 2.0f) + f8;
        } else {
            f3 = max;
        }
        float f9 = f2 + f4;
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(extraSmallSize, f7, f);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(arrangement.smallSize, arrangement.largeSize, f);
        float childMaskPercentage3 = CarouselStrategy.getChildMaskPercentage(arrangement.mediumSize, arrangement.largeSize, f);
        KeylineState.Builder addKeylineRange = new KeylineState.Builder(arrangement.largeSize).addKeyline(f5, childMaskPercentage, extraSmallSize).addKeylineRange(f6, 0.0f, arrangement.largeSize, arrangement.largeCount, true);
        if (arrangement.mediumCount > 0) {
            addKeylineRange.addKeyline(max, childMaskPercentage3, arrangement.mediumSize);
        }
        int i2 = arrangement.smallCount;
        if (i2 > 0) {
            addKeylineRange.addKeylineRange(f3, childMaskPercentage2, arrangement.smallSize, i2);
        }
        addKeylineRange.addKeyline(f9, childMaskPercentage, extraSmallSize);
        return addKeylineRange.build();
    }

    public static float getExtraSmallSize(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_gone_size);
    }

    public static float getSmallSizeMax(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
    }

    public static float getSmallSizeMin(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
    }

    public static int maxValue(int[] iArr) {
        int i = Integer.MIN_VALUE;
        for (int i2 : iArr) {
            if (i2 > i) {
                i = i2;
            }
        }
        return i;
    }
}
