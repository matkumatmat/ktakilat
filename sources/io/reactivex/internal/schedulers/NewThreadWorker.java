package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NewThreadWorker extends Scheduler.Worker implements Disposable {
    public final ScheduledExecutorService c;
    public volatile boolean d;

    public NewThreadWorker(RxThreadFactory rxThreadFactory) {
        boolean z = SchedulerPoolFactory.f679a;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, rxThreadFactory);
        if (SchedulerPoolFactory.f679a && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            SchedulerPoolFactory.d.put((ScheduledThreadPoolExecutor) newScheduledThreadPool, newScheduledThreadPool);
        }
        this.c = newScheduledThreadPool;
    }

    public final Disposable b(Runnable runnable) {
        return c(runnable, 0, (TimeUnit) null);
    }

    public final Disposable c(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.d) {
            return EmptyDisposable.INSTANCE;
        }
        return e(runnable, j, timeUnit, (DisposableContainer) null);
    }

    public final void dispose() {
        if (!this.d) {
            this.d = true;
            this.c.shutdownNow();
        }
    }

    public final ScheduledRunnable e(Runnable runnable, long j, TimeUnit timeUnit, DisposableContainer disposableContainer) {
        Future future;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(runnable, disposableContainer);
        if (disposableContainer != null && !disposableContainer.b(scheduledRunnable)) {
            return scheduledRunnable;
        }
        ScheduledExecutorService scheduledExecutorService = this.c;
        if (j <= 0) {
            try {
                future = scheduledExecutorService.submit(scheduledRunnable);
            } catch (RejectedExecutionException e) {
                if (disposableContainer != null) {
                    disposableContainer.a(scheduledRunnable);
                }
                RxJavaPlugins.b(e);
            }
        } else {
            future = scheduledExecutorService.schedule(scheduledRunnable, j, timeUnit);
        }
        scheduledRunnable.setFuture(future);
        return scheduledRunnable;
    }

    public final boolean isDisposed() {
        return this.d;
    }
}
