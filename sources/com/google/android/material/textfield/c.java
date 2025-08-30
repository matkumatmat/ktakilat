package com.google.android.material.textfield;

import android.animation.ValueAnimator;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f241a;
    public final /* synthetic */ EndIconDelegate b;

    public /* synthetic */ c(EndIconDelegate endIconDelegate, int i) {
        this.f241a = i;
        this.b = endIconDelegate;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f241a) {
            case 0:
                ((ClearTextEndIconDelegate) this.b).lambda$getAlphaAnimator$3(valueAnimator);
                return;
            case 1:
                ((ClearTextEndIconDelegate) this.b).lambda$getScaleAnimator$4(valueAnimator);
                return;
            default:
                ((DropdownMenuEndIconDelegate) this.b).lambda$getAlphaAnimator$6(valueAnimator);
                return;
        }
    }
}
