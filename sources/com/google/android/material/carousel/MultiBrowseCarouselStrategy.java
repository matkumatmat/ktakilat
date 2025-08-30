package com.google.android.material.carousel;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

public final class MultiBrowseCarouselStrategy extends CarouselStrategy {
    private static final int[] MEDIUM_COUNTS = {1, 0};
    private static final int[] MEDIUM_COUNTS_COMPACT = {0};
    private static final int[] SMALL_COUNTS = {1};
    private final boolean forceCompactArrangement;

    public MultiBrowseCarouselStrategy() {
        this(false);
    }

    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        int[] iArr;
        float containerHeight = (float) carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = (float) carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f = (float) (layoutParams.topMargin + layoutParams.bottomMargin);
        float measuredHeight = (float) view.getMeasuredHeight();
        if (carousel.isHorizontal()) {
            f = (float) (layoutParams.leftMargin + layoutParams.rightMargin);
            measuredHeight = (float) view.getMeasuredWidth();
        }
        float f2 = f;
        float smallSizeMin = CarouselStrategyHelper.getSmallSizeMin(view.getContext()) + f2;
        float smallSizeMax = CarouselStrategyHelper.getSmallSizeMax(view.getContext()) + f2;
        float min = Math.min(measuredHeight + f2, containerHeight);
        float clamp = MathUtils.clamp((measuredHeight / 3.0f) + f2, CarouselStrategyHelper.getSmallSizeMin(view.getContext()) + f2, CarouselStrategyHelper.getSmallSizeMax(view.getContext()) + f2);
        float f3 = (min + clamp) / 2.0f;
        int[] iArr2 = SMALL_COUNTS;
        if (this.forceCompactArrangement) {
            iArr = MEDIUM_COUNTS_COMPACT;
        } else {
            iArr = MEDIUM_COUNTS;
        }
        int[] iArr3 = iArr;
        int max = (int) Math.max(1.0d, Math.floor((double) (((containerHeight - (((float) CarouselStrategyHelper.maxValue(iArr3)) * f3)) - (((float) CarouselStrategyHelper.maxValue(iArr2)) * smallSizeMax)) / min)));
        int ceil = (int) Math.ceil((double) (containerHeight / min));
        int i = (ceil - max) + 1;
        int[] iArr4 = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr4[i2] = ceil - i2;
        }
        return CarouselStrategyHelper.createLeftAlignedKeylineState(view.getContext(), f2, containerHeight, Arrangement.findLowestCostArrangement(containerHeight, clamp, smallSizeMin, smallSizeMax, iArr2, f3, iArr3, min, iArr4));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MultiBrowseCarouselStrategy(boolean z) {
        this.forceCompactArrangement = z;
    }
}
