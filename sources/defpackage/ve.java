package defpackage;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* renamed from: ve  reason: default package */
public final /* synthetic */ class ve implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SideSheetBehavior f361a;
    public final /* synthetic */ ViewGroup.MarginLayoutParams b;
    public final /* synthetic */ int c;
    public final /* synthetic */ View d;

    public /* synthetic */ ve(SideSheetBehavior sideSheetBehavior, ViewGroup.MarginLayoutParams marginLayoutParams, int i, View view) {
        this.f361a = sideSheetBehavior;
        this.b = marginLayoutParams;
        this.c = i;
        this.d = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view = this.d;
        this.f361a.lambda$getCoplanarFinishAnimatorUpdateListener$1(this.b, this.c, view, valueAnimator);
    }
}
