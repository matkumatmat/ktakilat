package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\nJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003HA¢\u0006\u0004\b\u0006\u0010\u0007R\u000b\u0010\t\u001a\u00020\b8\u0002X\u0004¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/internal/LimitedDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "", "time", "", "delay", "(J)V", "Lkotlinx/atomicfu/AtomicInt;", "runningWorkers", "Worker", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLimitedDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcher\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,135:1\n62#1,8:136\n62#1,8:144\n27#2:152\n27#2:154\n16#3:153\n16#3:155\n*S KotlinDebug\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcher\n*L\n44#1:136,8\n51#1:144,8\n75#1:152\n88#1:154\n75#1:153\n88#1:155\n*E\n"})
public final class LimitedDispatcher extends CoroutineDispatcher implements Delay {
    public static final /* synthetic */ AtomicIntegerFieldUpdater j = AtomicIntegerFieldUpdater.newUpdater(LimitedDispatcher.class, "runningWorkers$volatile");
    public final /* synthetic */ Delay c;
    public final CoroutineDispatcher d;
    public final int e;
    public final String f;
    public final LockFreeTaskQueue g;
    public final Object i;
    private volatile /* synthetic */ int runningWorkers$volatile;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/internal/LimitedDispatcher$Worker;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class Worker implements Runnable {
        public Runnable c;

        public Worker(Runnable runnable) {
            this.c = runnable;
        }

        public final void run() {
            int i = 0;
            while (true) {
                try {
                    this.c.run();
                } catch (Throwable th) {
                    CoroutineExceptionHandlerKt.a(EmptyCoroutineContext.INSTANCE, th);
                }
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = LimitedDispatcher.j;
                LimitedDispatcher limitedDispatcher = LimitedDispatcher.this;
                Runnable t = limitedDispatcher.t();
                if (t != null) {
                    this.c = t;
                    i++;
                    if (i >= 16) {
                        CoroutineDispatcher coroutineDispatcher = limitedDispatcher.d;
                        if (coroutineDispatcher.isDispatchNeeded(limitedDispatcher)) {
                            coroutineDispatcher.dispatch(limitedDispatcher, this);
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public LimitedDispatcher(CoroutineDispatcher coroutineDispatcher, int i2, String str) {
        Delay delay;
        if (coroutineDispatcher instanceof Delay) {
            delay = (Delay) coroutineDispatcher;
        } else {
            delay = null;
        }
        this.c = delay == null ? DefaultExecutorKt.f766a : delay;
        this.d = coroutineDispatcher;
        this.e = i2;
        this.f = str;
        this.g = new LockFreeTaskQueue();
        this.i = new Object();
    }

    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable t;
        this.g.a(runnable);
        if (j.get(this) < this.e && u() && (t = t()) != null) {
            this.d.dispatch(this, new Worker(t));
        }
    }

    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable t;
        this.g.a(runnable);
        if (j.get(this) < this.e && u() && (t = t()) != null) {
            this.d.dispatchYield(this, new Worker(t));
        }
    }

    public final void h(long j2, CancellableContinuationImpl cancellableContinuationImpl) {
        this.c.h(j2, cancellableContinuationImpl);
    }

    public final CoroutineDispatcher limitedParallelism(int i2, String str) {
        LimitedDispatcherKt.a(i2);
        if (i2 < this.e) {
            return super.limitedParallelism(i2, str);
        }
        if (str != null) {
            return new NamedDispatcher(this, str);
        }
        return this;
    }

    public final DisposableHandle m(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        return this.c.m(j2, runnable, coroutineContext);
    }

    public final Runnable t() {
        while (true) {
            Runnable runnable = (Runnable) this.g.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.i) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = j;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.g.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final String toString() {
        String str = this.f;
        if (str != null) {
            return str;
        }
        return this.d + ".limitedParallelism(" + this.e + ')';
    }

    public final boolean u() {
        synchronized (this.i) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = j;
            if (atomicIntegerFieldUpdater.get(this) >= this.e) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }
}
