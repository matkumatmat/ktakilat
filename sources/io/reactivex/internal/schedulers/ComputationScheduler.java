package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ComputationScheduler extends Scheduler implements SchedulerMultiWorkerSupport {
    public static final FixedSchedulerPool e;
    public static final RxThreadFactory f;
    public static final int g;
    public static final PoolWorker i;
    public final AtomicReference d;

    public static final class EventLoopWorker extends Scheduler.Worker {
        public final ListCompositeDisposable c;
        public final CompositeDisposable d;
        public final ListCompositeDisposable e;
        public final PoolWorker f;
        public volatile boolean g;

        /* JADX WARNING: type inference failed for: r3v1, types: [io.reactivex.internal.disposables.ListCompositeDisposable, io.reactivex.disposables.Disposable, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.disposables.CompositeDisposable, io.reactivex.disposables.Disposable, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r1v0, types: [io.reactivex.internal.disposables.ListCompositeDisposable, java.lang.Object] */
        public EventLoopWorker(PoolWorker poolWorker) {
            this.f = poolWorker;
            ? obj = new Object();
            this.c = obj;
            ? obj2 = new Object();
            this.d = obj2;
            ? obj3 = new Object();
            this.e = obj3;
            obj3.b(obj);
            obj3.b(obj2);
        }

        public final Disposable b(Runnable runnable) {
            if (this.g) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f.e(runnable, 0, TimeUnit.MILLISECONDS, this.c);
        }

        public final Disposable c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.g) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f.e(runnable, j, timeUnit, this.d);
        }

        public final void dispose() {
            if (!this.g) {
                this.g = true;
                this.e.dispose();
            }
        }

        public final boolean isDisposed() {
            return this.g;
        }
    }

    public static final class FixedSchedulerPool implements SchedulerMultiWorkerSupport {
        public final int c;
        public final PoolWorker[] d;
        public long e;

        public FixedSchedulerPool(int i, RxThreadFactory rxThreadFactory) {
            this.c = i;
            this.d = new PoolWorker[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.d[i2] = new NewThreadWorker(rxThreadFactory);
            }
        }

        public final PoolWorker a() {
            int i = this.c;
            if (i == 0) {
                return ComputationScheduler.i;
            }
            long j = this.e;
            this.e = 1 + j;
            return this.d[(int) (j % ((long) i))];
        }
    }

    public static final class PoolWorker extends NewThreadWorker {
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [io.reactivex.internal.schedulers.ComputationScheduler$PoolWorker, io.reactivex.internal.schedulers.NewThreadWorker] */
    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int intValue = Integer.getInteger("rx2.computation-threads", 0).intValue();
        if (intValue > 0 && intValue <= availableProcessors) {
            availableProcessors = intValue;
        }
        g = availableProcessors;
        ? newThreadWorker = new NewThreadWorker(new RxThreadFactory("RxComputationShutdown"));
        i = newThreadWorker;
        newThreadWorker.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f = rxThreadFactory;
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(0, rxThreadFactory);
        e = fixedSchedulerPool;
        for (PoolWorker dispose : fixedSchedulerPool.d) {
            dispose.dispose();
        }
    }

    public ComputationScheduler() {
        AtomicReference atomicReference;
        RxThreadFactory rxThreadFactory = f;
        FixedSchedulerPool fixedSchedulerPool = e;
        this.d = new AtomicReference(fixedSchedulerPool);
        FixedSchedulerPool fixedSchedulerPool2 = new FixedSchedulerPool(g, rxThreadFactory);
        do {
            atomicReference = this.d;
            if (atomicReference.compareAndSet(fixedSchedulerPool, fixedSchedulerPool2)) {
                return;
            }
        } while (atomicReference.get() == fixedSchedulerPool);
        for (PoolWorker dispose : fixedSchedulerPool2.d) {
            dispose.dispose();
        }
    }

    public final Scheduler.Worker a() {
        return new EventLoopWorker(((FixedSchedulerPool) this.d.get()).a());
    }

    public final Disposable d(Runnable runnable, long j, TimeUnit timeUnit) {
        Future future;
        PoolWorker a2 = ((FixedSchedulerPool) this.d.get()).a();
        a2.getClass();
        ObjectHelper.b(runnable, "run is null");
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(runnable);
        ScheduledExecutorService scheduledExecutorService = a2.c;
        if (j <= 0) {
            try {
                future = scheduledExecutorService.submit(scheduledDirectTask);
            } catch (RejectedExecutionException e2) {
                RxJavaPlugins.b(e2);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            future = scheduledExecutorService.schedule(scheduledDirectTask, j, timeUnit);
        }
        scheduledDirectTask.setFuture(future);
        return scheduledDirectTask;
    }

    public final Disposable e(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future future;
        PoolWorker a2 = ((FixedSchedulerPool) this.d.get()).a();
        a2.getClass();
        if (j2 <= 0) {
            ScheduledExecutorService scheduledExecutorService = a2.c;
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
            scheduledDirectPeriodicTask.setFuture(a2.c.scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e3) {
            RxJavaPlugins.b(e3);
            return EmptyDisposable.INSTANCE;
        }
    }
}
