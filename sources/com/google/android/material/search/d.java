package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.material.shape.MaterialShapeDrawable;

public final /* synthetic */ class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialShapeDrawable f238a;
    public final /* synthetic */ View b;

    public /* synthetic */ d(View view, MaterialShapeDrawable materialShapeDrawable) {
        this.f238a = materialShapeDrawable;
        this.b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        SearchBarAnimationHelper.lambda$getExpandedViewBackgroundUpdateListener$1(this.f238a, this.b, valueAnimator);
    }
}
