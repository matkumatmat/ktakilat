package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements Disposable, SchedulerRunnableIntrospection {
    public static final FutureTask e;
    public static final FutureTask f;
    private static final long serialVersionUID = 1811839108042568751L;
    public final Runnable c;
    public Thread d;

    static {
        Runnable runnable = Functions.b;
        e = new FutureTask(runnable, (Object) null);
        f = new FutureTask(runnable, (Object) null);
    }

    public AbstractDirectTask(Runnable runnable) {
        this.c = runnable;
    }

    public final void dispose() {
        FutureTask futureTask;
        boolean z;
        Future future = (Future) get();
        if (future != e && future != (futureTask = f) && compareAndSet(future, futureTask) && future != null) {
            if (this.d != Thread.currentThread()) {
                z = true;
            } else {
                z = false;
            }
            future.cancel(z);
        }
    }

    public final boolean isDisposed() {
        Future future = (Future) get();
        if (future == e || future == f) {
            return true;
        }
        return false;
    }

    public final void setFuture(Future<?> future) {
        Future future2;
        boolean z;
        do {
            future2 = (Future) get();
            if (future2 != e) {
                if (future2 == f) {
                    if (this.d != Thread.currentThread()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    future.cancel(z);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(future2, future));
    }
}
