package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.sync.MutexImpl;

public final /* synthetic */ class a implements Function3 {
    public final /* synthetic */ MutexImpl c;
    public final /* synthetic */ MutexImpl.CancellableContinuationWithOwner d;

    public /* synthetic */ a(MutexImpl mutexImpl, MutexImpl.CancellableContinuationWithOwner cancellableContinuationWithOwner) {
        this.c = mutexImpl;
        this.d = cancellableContinuationWithOwner;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Throwable th = (Throwable) obj;
        Unit unit = (Unit) obj2;
        CoroutineContext coroutineContext = (CoroutineContext) obj3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = MutexImpl.h;
        this.d.getClass();
        MutexImpl mutexImpl = this.c;
        atomicReferenceFieldUpdater.set(mutexImpl, (Object) null);
        mutexImpl.c((Object) null);
        return Unit.f696a;
    }
}
