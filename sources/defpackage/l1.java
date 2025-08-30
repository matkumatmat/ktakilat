package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.SemaphoreAndMutexImpl;
import kotlinx.coroutines.sync.b;

/* renamed from: l1  reason: default package */
public final /* synthetic */ class l1 implements Function3 {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ l1(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Object obj4 = this.d;
        switch (this.c) {
            case 0:
                AtomicLongFieldUpdater atomicLongFieldUpdater = BufferedChannel.f;
                return new n1(obj3, (BufferedChannel) obj4, (SelectInstance) obj);
            case 1:
                CoroutineContext coroutineContext = (CoroutineContext) obj3;
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = CancellableContinuationImpl.i;
                ((b) obj4).invoke((Throwable) obj);
                return Unit.f696a;
            default:
                Throwable th = (Throwable) obj;
                Unit unit = (Unit) obj2;
                CoroutineContext coroutineContext2 = (CoroutineContext) obj3;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = SemaphoreAndMutexImpl.c;
                ((SemaphoreAndMutexImpl) obj4).release();
                return Unit.f696a;
        }
    }
}
