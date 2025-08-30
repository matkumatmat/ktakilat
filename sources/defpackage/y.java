package defpackage;

import android.animation.ValueAnimator;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.shape.MaterialShapeDrawable;

/* renamed from: y  reason: default package */
public final /* synthetic */ class y implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f367a;
    public final /* synthetic */ AppBarLayout b;
    public final /* synthetic */ MaterialShapeDrawable c;

    public /* synthetic */ y(AppBarLayout appBarLayout, MaterialShapeDrawable materialShapeDrawable, int i) {
        this.f367a = i;
        this.b = appBarLayout;
        this.c = materialShapeDrawable;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f367a) {
            case 0:
                this.b.lambda$initializeLiftOnScrollWithElevation$1(this.c, valueAnimator);
                return;
            default:
                this.b.lambda$initializeLiftOnScrollWithColor$0(this.c, valueAnimator);
                return;
        }
    }
}
