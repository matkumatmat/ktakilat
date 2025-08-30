package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4;
import androidx.fragment.app.SpecialEffectsController;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect e;

    public /* synthetic */ c(DefaultSpecialEffectsController.TransitionEffect transitionEffect, ViewGroup viewGroup) {
        this.c = 2;
        this.e = transitionEffect;
        this.d = viewGroup;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                DefaultSpecialEffectsController.TransitionEffect.onStart$lambda$6$lambda$5((SpecialEffectsController.Operation) this.d, this.e);
                return;
            case 1:
                DefaultSpecialEffectsController.TransitionEffect.onCommit$lambda$11$lambda$10((SpecialEffectsController.Operation) this.d, this.e);
                return;
            default:
                DefaultSpecialEffectsController$TransitionEffect$onStart$4.AnonymousClass2.invoke$lambda$2(this.e, (ViewGroup) this.d);
                return;
        }
    }

    public /* synthetic */ c(SpecialEffectsController.Operation operation, DefaultSpecialEffectsController.TransitionEffect transitionEffect, int i) {
        this.c = i;
        this.d = operation;
        this.e = transitionEffect;
    }
}
