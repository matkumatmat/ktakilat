package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.TimeUnit;

public final class ImmediateThinScheduler extends Scheduler {
    public static final Scheduler.Worker d = new Object();
    public static final Disposable e;

    public static final class ImmediateThinWorker extends Scheduler.Worker {
        public final Disposable b(Runnable runnable) {
            runnable.run();
            return ImmediateThinScheduler.e;
        }

        public final Disposable c(Runnable runnable, long j, TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
        }

        public final Disposable d(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
        }

        public final void dispose() {
        }

        public final boolean isDisposed() {
            return false;
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Object, io.reactivex.Scheduler$Worker] */
    static {
        Disposable a2 = Disposables.a(Functions.b);
        e = a2;
        a2.dispose();
    }

    public final Scheduler.Worker a() {
        return d;
    }

    public final Disposable c(Runnable runnable) {
        runnable.run();
        return e;
    }

    public final Disposable d(Runnable runnable, long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }

    public final Disposable e(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }
}
