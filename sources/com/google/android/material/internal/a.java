package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.material.internal.MultiViewUpdateListener;

public final /* synthetic */ class a implements MultiViewUpdateListener.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f235a;

    public /* synthetic */ a(int i) {
        this.f235a = i;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator, View view) {
        switch (this.f235a) {
            case 0:
                MultiViewUpdateListener.setTranslationX(valueAnimator, view);
                return;
            case 1:
                MultiViewUpdateListener.setScale(valueAnimator, view);
                return;
            case 2:
                MultiViewUpdateListener.setTranslationY(valueAnimator, view);
                return;
            default:
                MultiViewUpdateListener.setAlpha(valueAnimator, view);
                return;
        }
    }
}
