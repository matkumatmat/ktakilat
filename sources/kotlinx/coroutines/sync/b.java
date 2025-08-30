package kotlinx.coroutines.sync;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.sync.MutexImpl;

public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ MutexImpl c;
    public final /* synthetic */ MutexImpl.CancellableContinuationWithOwner d;

    public /* synthetic */ b(MutexImpl mutexImpl, MutexImpl.CancellableContinuationWithOwner cancellableContinuationWithOwner) {
        this.c = mutexImpl;
        this.d = cancellableContinuationWithOwner;
    }

    public final Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        this.d.getClass();
        this.c.c((Object) null);
        return Unit.f696a;
    }
}
