package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003HA¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/internal/NamedDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "", "time", "", "delay", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NamedDispatcher extends CoroutineDispatcher implements Delay {
    public final /* synthetic */ Delay c;
    public final CoroutineDispatcher d;
    public final String e;

    public NamedDispatcher(CoroutineDispatcher coroutineDispatcher, String str) {
        Delay delay;
        if (coroutineDispatcher instanceof Delay) {
            delay = (Delay) coroutineDispatcher;
        } else {
            delay = null;
        }
        this.c = delay == null ? DefaultExecutorKt.f766a : delay;
        this.d = coroutineDispatcher;
        this.e = str;
    }

    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        this.d.dispatch(coroutineContext, runnable);
    }

    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        this.d.dispatchYield(coroutineContext, runnable);
    }

    public final void h(long j, CancellableContinuationImpl cancellableContinuationImpl) {
        this.c.h(j, cancellableContinuationImpl);
    }

    public final boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return this.d.isDispatchNeeded(coroutineContext);
    }

    public final DisposableHandle m(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return this.c.m(j, runnable, coroutineContext);
    }

    public final String toString() {
        return this.e;
    }
}
