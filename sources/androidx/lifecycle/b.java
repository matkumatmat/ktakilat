package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlinx.coroutines.channels.ProducerScope;

public final /* synthetic */ class b implements LifecycleEventObserver {
    public final /* synthetic */ ProducerScope c;

    public /* synthetic */ b(ProducerScope producerScope) {
        this.c = producerScope;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        LifecycleKt$eventFlow$1.invokeSuspend$lambda$0(this.c, lifecycleOwner, event);
    }
}
