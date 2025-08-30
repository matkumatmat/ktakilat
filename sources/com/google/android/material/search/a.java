package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import com.google.android.material.internal.FadeThroughDrawable;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f236a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i) {
        this.f236a = i;
        this.b = obj;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f236a) {
            case 0:
                ((View) this.b).setAlpha(0.0f);
                return;
            case 1:
                ((DrawerArrowDrawable) this.b).setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
                return;
            default:
                ((FadeThroughDrawable) this.b).setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
                return;
        }
    }
}
