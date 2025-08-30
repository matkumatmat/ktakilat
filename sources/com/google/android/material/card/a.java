package com.google.android.material.card;

import android.animation.ValueAnimator;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialCardViewHelper f234a;

    public /* synthetic */ a(MaterialCardViewHelper materialCardViewHelper) {
        this.f234a = materialCardViewHelper;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f234a.lambda$animateCheckedIcon$0(valueAnimator);
    }
}
