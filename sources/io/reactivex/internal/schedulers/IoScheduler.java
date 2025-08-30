package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class IoScheduler extends Scheduler {
    public static final RxThreadFactory e;
    public static final RxThreadFactory f;
    public static final TimeUnit g = TimeUnit.SECONDS;
    public static final ThreadWorker i;
    public static final CachedWorkerPool j;
    public final AtomicReference d;

    public static final class CachedWorkerPool implements Runnable {
        public final long c;
        public final ConcurrentLinkedQueue d;
        public final CompositeDisposable e;
        public final ScheduledExecutorService f;
        public final ScheduledFuture g;
        public final RxThreadFactory i;

        /* JADX WARNING: type inference failed for: r8v4, types: [io.reactivex.disposables.CompositeDisposable, java.lang.Object] */
        public CachedWorkerPool(long j, TimeUnit timeUnit, RxThreadFactory rxThreadFactory) {
            long j2;
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService;
            if (timeUnit != null) {
                j2 = timeUnit.toNanos(j);
            } else {
                j2 = 0;
            }
            long j3 = j2;
            this.c = j3;
            this.d = new ConcurrentLinkedQueue();
            this.e = new Object();
            this.i = rxThreadFactory;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, IoScheduler.f);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j3, j3, TimeUnit.NANOSECONDS);
            } else {
                scheduledExecutorService = null;
                scheduledFuture = null;
            }
            this.f = scheduledExecutorService;
            this.g = scheduledFuture;
        }

        public final void run() {
            ConcurrentLinkedQueue concurrentLinkedQueue = this.d;
            if (!concurrentLinkedQueue.isEmpty()) {
                long nanoTime = System.nanoTime();
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    ThreadWorker threadWorker = (ThreadWorker) it.next();
                    if (threadWorker.e > nanoTime) {
                        return;
                    }
                    if (concurrentLinkedQueue.remove(threadWorker)) {
                        this.e.a(threadWorker);
                    }
                }
            }
        }
    }

    public static final class EventLoopWorker extends Scheduler.Worker {
        public final CompositeDisposable c;
        public final CachedWorkerPool d;
        public final ThreadWorker e;
        public final AtomicBoolean f = new AtomicBoolean();

        /* JADX WARNING: type inference failed for: r0v1, types: [io.reactivex.disposables.CompositeDisposable, java.lang.Object] */
        public EventLoopWorker(CachedWorkerPool cachedWorkerPool) {
            ThreadWorker threadWorker;
            ThreadWorker threadWorker2;
            this.d = cachedWorkerPool;
            this.c = new Object();
            if (cachedWorkerPool.e.d) {
                threadWorker = IoScheduler.i;
            } else {
                while (true) {
                    if (cachedWorkerPool.d.isEmpty()) {
                        threadWorker2 = new ThreadWorker(cachedWorkerPool.i);
                        cachedWorkerPool.e.b(threadWorker2);
                        break;
                    }
                    threadWorker2 = (ThreadWorker) cachedWorkerPool.d.poll();
                    if (threadWorker2 != null) {
                        break;
                    }
                }
                threadWorker = threadWorker2;
            }
            this.e = threadWorker;
        }

        public final Disposable c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.c.d) {
                return EmptyDisposable.INSTANCE;
            }
            return this.e.e(runnable, j, timeUnit, this.c);
        }

        public final void dispose() {
            if (this.f.compareAndSet(false, true)) {
                this.c.dispose();
                CachedWorkerPool cachedWorkerPool = this.d;
                cachedWorkerPool.getClass();
                long nanoTime = System.nanoTime() + cachedWorkerPool.c;
                ThreadWorker threadWorker = this.e;
                threadWorker.e = nanoTime;
                cachedWorkerPool.d.offer(threadWorker);
            }
        }

        public final boolean isDisposed() {
            return this.f.get();
        }
    }

    public static final class ThreadWorker extends NewThreadWorker {
        public long e = 0;

        public ThreadWorker(RxThreadFactory rxThreadFactory) {
            super(rxThreadFactory);
        }
    }

    static {
        ThreadWorker threadWorker = new ThreadWorker(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        i = threadWorker;
        threadWorker.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxCachedThreadScheduler", max);
        e = rxThreadFactory;
        f = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(0, (TimeUnit) null, rxThreadFactory);
        j = cachedWorkerPool;
        cachedWorkerPool.e.dispose();
        ScheduledFuture scheduledFuture = cachedWorkerPool.g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledExecutorService scheduledExecutorService = cachedWorkerPool.f;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }

    public IoScheduler() {
        AtomicReference atomicReference;
        RxThreadFactory rxThreadFactory = e;
        CachedWorkerPool cachedWorkerPool = j;
        this.d = new AtomicReference(cachedWorkerPool);
        CachedWorkerPool cachedWorkerPool2 = new CachedWorkerPool(60, g, rxThreadFactory);
        do {
            atomicReference = this.d;
            if (atomicReference.compareAndSet(cachedWorkerPool, cachedWorkerPool2)) {
                return;
            }
        } while (atomicReference.get() == cachedWorkerPool);
        cachedWorkerPool2.e.dispose();
        ScheduledFuture scheduledFuture = cachedWorkerPool2.g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledExecutorService scheduledExecutorService = cachedWorkerPool2.f;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }

    public final Scheduler.Worker a() {
        return new EventLoopWorker((CachedWorkerPool) this.d.get());
    }
}
