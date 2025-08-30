package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleScheduler extends Scheduler {
    public static final RxThreadFactory e = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    public static final ScheduledExecutorService f;
    public final AtomicReference d;

    public static final class ScheduledWorker extends Scheduler.Worker {
        public final ScheduledExecutorService c;
        public final CompositeDisposable d = new Object();
        public volatile boolean e;

        /* JADX WARNING: type inference failed for: r1v1, types: [io.reactivex.disposables.CompositeDisposable, java.lang.Object] */
        public ScheduledWorker(ScheduledExecutorService scheduledExecutorService) {
            this.c = scheduledExecutorService;
        }

        public final Disposable c(Runnable runnable, long j, TimeUnit timeUnit) {
            Future future;
            if (this.e) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(runnable, this.d);
            this.d.b(scheduledRunnable);
            if (j <= 0) {
                try {
                    future = this.c.submit(scheduledRunnable);
                } catch (RejectedExecutionException e2) {
                    dispose();
                    RxJavaPlugins.b(e2);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = this.c.schedule(scheduledRunnable, j, timeUnit);
            }
            scheduledRunnable.setFuture(future);
            return scheduledRunnable;
        }

        public final void dispose() {
            if (!this.e) {
                this.e = true;
                this.d.dispose();
            }
        }

        public final boolean isDisposed() {
            return this.e;
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
    }

    public SingleScheduler() {
        AtomicReference atomicReference = new AtomicReference();
        this.d = atomicReference;
        boolean z = SchedulerPoolFactory.f679a;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, e);
        if (SchedulerPoolFactory.f679a && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            SchedulerPoolFactory.d.put((ScheduledThreadPoolExecutor) newScheduledThreadPool, newScheduledThreadPool);
        }
        atomicReference.lazySet(newScheduledThreadPool);
    }

    public final Scheduler.Worker a() {
        return new ScheduledWorker((ScheduledExecutorService) this.d.get());
    }

    public final Disposable d(Runnable runnable, long j, TimeUnit timeUnit) {
        Future future;
        ObjectHelper.b(runnable, "run is null");
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(runnable);
        AtomicReference atomicReference = this.d;
        if (j <= 0) {
            try {
                future = ((ScheduledExecutorService) atomicReference.get()).submit(scheduledDirectTask);
            } catch (RejectedExecutionException e2) {
                RxJavaPlugins.b(e2);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            future = ((ScheduledExecutorService) atomicReference.get()).schedule(scheduledDirectTask, j, timeUnit);
        }
        scheduledDirectTask.setFuture(future);
        return scheduledDirectTask;
    }

    public final Disposable e(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future future;
        AtomicReference atomicReference = this.d;
        if (j2 <= 0) {
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) atomicReference.get();
            InstantPeriodicTask instantPeriodicTask = new InstantPeriodicTask(runnable, scheduledExecutorService);
            if (j <= 0) {
                try {
                    future = scheduledExecutorService.submit(instantPeriodicTask);
                } catch (RejectedExecutionException e2) {
                    RxJavaPlugins.b(e2);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = scheduledExecutorService.schedule(instantPeriodicTask, j, timeUnit);
            }
            instantPeriodicTask.a(future);
            return instantPeriodicTask;
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(runnable);
        try {
            scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService) atomicReference.get()).scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e3) {
            RxJavaPlugins.b(e3);
            return EmptyDisposable.INSTANCE;
        }
    }
}
