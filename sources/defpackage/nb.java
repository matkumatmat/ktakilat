package defpackage;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import kotlinx.coroutines.flow.MutableStateFlow;

/* renamed from: nb  reason: default package */
public final /* synthetic */ class nb implements LifecycleEventObserver {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ nb(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (this.c) {
            case 0:
                Lifecycle._get_currentStateFlow_$lambda$0((MutableStateFlow) this.d, lifecycleOwner, event);
                return;
            default:
                SavedStateRegistry.performAttach$lambda$4((SavedStateRegistry) this.d, lifecycleOwner, event);
                return;
        }
    }
}
