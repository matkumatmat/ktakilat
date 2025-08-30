package androidx.lifecycle;

import kotlinx.coroutines.channels.ProducerScope;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProducerScope f45a;

    public /* synthetic */ a(ProducerScope producerScope) {
        this.f45a = producerScope;
    }

    public final void onChanged(Object obj) {
        FlowLiveDataConversions$asFlow$1.invokeSuspend$lambda$0(this.f45a, obj);
    }
}
