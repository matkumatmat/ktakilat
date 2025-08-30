package defpackage;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import com.google.android.material.internal.ExpandCollapseAnimationHelper;

/* renamed from: t6  reason: default package */
public final /* synthetic */ class t6 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f358a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ t6(int i, Object obj, Object obj2) {
        this.f358a = i;
        this.b = obj;
        this.c = obj2;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f358a) {
            case 0:
                ((ExpandCollapseAnimationHelper) this.b).lambda$getExpandCollapseAnimator$0((Rect) this.c, valueAnimator);
                return;
            default:
                ((ViewPropertyAnimatorUpdateListener) this.b).onAnimationUpdate((View) this.c);
                return;
        }
    }
}
