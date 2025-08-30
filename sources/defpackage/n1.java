package defpackage;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.BufferedChannelKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;

/* renamed from: n1  reason: default package */
public final /* synthetic */ class n1 implements Function3 {
    public final /* synthetic */ Object c;
    public final /* synthetic */ BufferedChannel d;
    public final /* synthetic */ SelectInstance e;

    public /* synthetic */ n1(Object obj, BufferedChannel bufferedChannel, SelectInstance selectInstance) {
        this.c = obj;
        this.d = bufferedChannel;
        this.e = selectInstance;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Throwable th = (Throwable) obj;
        CoroutineContext coroutineContext = (CoroutineContext) obj3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = BufferedChannel.f;
        Symbol symbol = BufferedChannelKt.l;
        Object obj4 = this.c;
        if (obj4 != symbol) {
            OnUndeliveredElementKt.a(this.d.d, obj4, this.e.getContext());
        }
        return Unit.f696a;
    }
}
