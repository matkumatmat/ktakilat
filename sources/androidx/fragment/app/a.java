package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ a(Object obj, int i, Object obj2, Object obj3) {
        this.c = i;
        this.d = obj;
        this.e = obj2;
        this.f = obj3;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                DefaultSpecialEffectsController$AnimationEffect$onCommit$1.onAnimationEnd$lambda$0((ViewGroup) this.d, (View) this.e, (DefaultSpecialEffectsController.AnimationEffect) this.f);
                return;
            case 1:
                DefaultSpecialEffectsController.TransitionEffect.createMergedTransition$lambda$12((SpecialEffectsController.Operation) this.d, (SpecialEffectsController.Operation) this.e, (DefaultSpecialEffectsController.TransitionEffect) this.f);
                return;
            default:
                DefaultSpecialEffectsController.TransitionEffect.createMergedTransition$lambda$13((FragmentTransitionImpl) this.d, (View) this.e, (Rect) this.f);
                return;
        }
    }
}
