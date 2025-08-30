package defpackage;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;

/* renamed from: m1  reason: default package */
public final /* synthetic */ class m1 implements Function3 {
    public final /* synthetic */ Function1 c;
    public final /* synthetic */ Object d;

    public /* synthetic */ m1(Function1 function1, Object obj) {
        this.c = function1;
        this.d = obj;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Throwable th = (Throwable) obj;
        AtomicLongFieldUpdater atomicLongFieldUpdater = BufferedChannel.f;
        OnUndeliveredElementKt.a(this.c, this.d, (CoroutineContext) obj3);
        return Unit.f696a;
    }
}
