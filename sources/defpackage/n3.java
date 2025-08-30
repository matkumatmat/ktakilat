package defpackage;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* renamed from: n3  reason: default package */
public final /* synthetic */ class n3 implements LifecycleEventObserver {
    public final /* synthetic */ int c;
    public final /* synthetic */ ComponentActivity d;

    public /* synthetic */ n3(ComponentActivity componentActivity, int i) {
        this.c = i;
        this.d = componentActivity;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (this.c) {
            case 0:
                ComponentActivity._init_$lambda$2(this.d, lifecycleOwner, event);
                return;
            default:
                ComponentActivity._init_$lambda$3(this.d, lifecycleOwner, event);
                return;
        }
    }
}
