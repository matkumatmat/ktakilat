package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

final class InstantPeriodicTask implements Callable<Void>, Disposable {
    public static final FutureTask i = new FutureTask(Functions.b, (Object) null);
    public final Runnable c;
    public final AtomicReference d = new AtomicReference();
    public final AtomicReference e = new AtomicReference();
    public final ScheduledExecutorService f;
    public Thread g;

    public InstantPeriodicTask(Runnable runnable, ScheduledExecutorService scheduledExecutorService) {
        this.c = runnable;
        this.f = scheduledExecutorService;
    }

    public final void a(Future future) {
        boolean z;
        while (true) {
            AtomicReference atomicReference = this.e;
            Future future2 = (Future) atomicReference.get();
            if (future2 == i) {
                if (this.g != Thread.currentThread()) {
                    z = true;
                } else {
                    z = false;
                }
                future.cancel(z);
                return;
            }
            while (true) {
                if (!atomicReference.compareAndSet(future2, future)) {
                    if (atomicReference.get() != future2) {
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final Object call() {
        boolean z;
        this.g = Thread.currentThread();
        try {
            this.c.run();
            Future submit = this.f.submit(this);
            loop0:
            while (true) {
                AtomicReference atomicReference = this.d;
                Future future = (Future) atomicReference.get();
                if (future == i) {
                    if (this.g != Thread.currentThread()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    submit.cancel(z);
                } else {
                    while (true) {
                        if (atomicReference.compareAndSet(future, submit)) {
                            break loop0;
                        } else if (atomicReference.get() != future) {
                        }
                    }
                }
            }
            this.g = null;
        } catch (Throwable th) {
            this.g = null;
            RxJavaPlugins.b(th);
        }
        return null;
    }

    public final void dispose() {
        boolean z;
        AtomicReference atomicReference = this.e;
        FutureTask futureTask = i;
        Future future = (Future) atomicReference.getAndSet(futureTask);
        boolean z2 = false;
        if (!(future == null || future == futureTask)) {
            if (this.g != Thread.currentThread()) {
                z = true;
            } else {
                z = false;
            }
            future.cancel(z);
        }
        Future future2 = (Future) this.d.getAndSet(futureTask);
        if (future2 != null && future2 != futureTask) {
            if (this.g != Thread.currentThread()) {
                z2 = true;
            }
            future2.cancel(z2);
        }
    }

    public final boolean isDisposed() {
        if (this.e.get() == i) {
            return true;
        }
        return false;
    }
}
