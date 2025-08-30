package defpackage;

import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleController;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlinx.coroutines.Job;

/* renamed from: q3  reason: default package */
public final /* synthetic */ class q3 implements LifecycleEventObserver {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ q3(int i, Object obj, Object obj2) {
        this.c = i;
        this.d = obj;
        this.e = obj2;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (this.c) {
            case 0:
                ComponentActivity.addObserverForBackInvoker$lambda$7((OnBackPressedDispatcher) this.d, (ComponentActivity) this.e, lifecycleOwner, event);
                return;
            case 1:
                LifecycleController.observer$lambda$0((LifecycleController) this.d, (Job) this.e, lifecycleOwner, event);
                return;
            default:
                ((MenuHostHelper) this.d).lambda$addMenuProvider$0((MenuProvider) this.e, lifecycleOwner, event);
                return;
        }
    }
}
