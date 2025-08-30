package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.graphics.Rect;

public final /* synthetic */ class e implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchViewAnimationHelper f239a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;
    public final /* synthetic */ Rect d;

    public /* synthetic */ e(SearchViewAnimationHelper searchViewAnimationHelper, float f, float f2, Rect rect) {
        this.f239a = searchViewAnimationHelper;
        this.b = f;
        this.c = f2;
        this.d = rect;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f239a.lambda$getRootViewAnimator$2(this.b, this.c, this.d, valueAnimator);
    }
}
