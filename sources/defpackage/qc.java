package defpackage;

import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* renamed from: qc  reason: default package */
public final /* synthetic */ class qc implements LifecycleEventObserver {
    public final /* synthetic */ MenuHostHelper c;
    public final /* synthetic */ Lifecycle.State d;
    public final /* synthetic */ MenuProvider e;

    public /* synthetic */ qc(MenuHostHelper menuHostHelper, Lifecycle.State state, MenuProvider menuProvider) {
        this.c = menuHostHelper;
        this.d = state;
        this.e = menuProvider;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.c.lambda$addMenuProvider$1(this.d, this.e, lifecycleOwner, event);
    }
}
