package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ExecutorScheduler extends Scheduler {
    public static final Scheduler d = Schedulers.f684a;

    public final class DelayedDispose implements Runnable {
        public final DelayedRunnable c;

        public DelayedDispose(DelayedRunnable delayedRunnable) {
            this.c = delayedRunnable;
        }

        public final void run() {
            DelayedRunnable delayedRunnable = this.c;
            delayedRunnable.d.replace(ExecutorScheduler.this.c(delayedRunnable));
        }
    }

    public static final class DelayedRunnable extends AtomicReference<Runnable> implements Runnable, Disposable, SchedulerRunnableIntrospection {
        private static final long serialVersionUID = -4101336210206799084L;
        public final SequentialDisposable c = new SequentialDisposable();
        public final SequentialDisposable d = new SequentialDisposable();

        public DelayedRunnable(Runnable runnable) {
            super(runnable);
        }

        public final void dispose() {
            if (getAndSet((Object) null) != null) {
                this.c.dispose();
                this.d.dispose();
            }
        }

        public final boolean isDisposed() {
            if (get() == null) {
                return true;
            }
            return false;
        }

        public final void run() {
            SequentialDisposable sequentialDisposable = this.d;
            SequentialDisposable sequentialDisposable2 = this.c;
            Runnable runnable = (Runnable) get();
            if (runnable != null) {
                try {
                    runnable.run();
                    lazySet((Object) null);
                    DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                    sequentialDisposable2.lazySet(disposableHelper);
                    sequentialDisposable.lazySet(disposableHelper);
                } catch (Throwable th) {
                    lazySet((Object) null);
                    sequentialDisposable2.lazySet(DisposableHelper.DISPOSED);
                    sequentialDisposable.lazySet(DisposableHelper.DISPOSED);
                    throw th;
                }
            }
        }
    }

    public static final class ExecutorWorker extends Scheduler.Worker implements Runnable {
        public final MpscLinkedQueue c = new MpscLinkedQueue();
        public volatile boolean d;
        public final AtomicInteger e = new AtomicInteger();
        public final CompositeDisposable f = new Object();

        public static final class BooleanRunnable extends AtomicBoolean implements Runnable, Disposable {
            private static final long serialVersionUID = -2421395018820541164L;
            public final Runnable c;

            public BooleanRunnable(Runnable runnable) {
                this.c = runnable;
            }

            public final void dispose() {
                lazySet(true);
            }

            public final boolean isDisposed() {
                return get();
            }

            public final void run() {
                if (!get()) {
                    try {
                        this.c.run();
                    } finally {
                        lazySet(true);
                    }
                }
            }
        }

        public final class SequentialDispose implements Runnable {
            public final SequentialDisposable c;
            public final Runnable d;

            public SequentialDispose(SequentialDisposable sequentialDisposable, Runnable runnable) {
                this.c = sequentialDisposable;
                this.d = runnable;
            }

            public final void run() {
                this.c.replace(ExecutorWorker.this.b(this.d));
            }
        }

        public final Disposable b(Runnable runnable) {
            if (this.d) {
                return EmptyDisposable.INSTANCE;
            }
            BooleanRunnable booleanRunnable = new BooleanRunnable(runnable);
            this.c.offer(booleanRunnable);
            if (this.e.getAndIncrement() != 0) {
                return booleanRunnable;
            }
            throw null;
        }

        public final Disposable c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return b(runnable);
            }
            if (this.d) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new SequentialDispose(sequentialDisposable2, runnable), this.f);
            this.f.b(scheduledRunnable);
            scheduledRunnable.setFuture(new DisposeOnCancel(ExecutorScheduler.d.d(scheduledRunnable, j, timeUnit)));
            sequentialDisposable.replace(scheduledRunnable);
            return sequentialDisposable2;
        }

        public final void dispose() {
            if (!this.d) {
                this.d = true;
                this.f.dispose();
                if (this.e.getAndIncrement() == 0) {
                    this.c.clear();
                }
            }
        }

        public final boolean isDisposed() {
            return this.d;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
            r1 = r3.e.addAndGet(-r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
            if (r1 != 0) goto L_0x0003;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
            if (r3.d == false) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            r0.clear();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r3 = this;
                io.reactivex.internal.queue.MpscLinkedQueue r0 = r3.c
                r1 = 1
            L_0x0003:
                boolean r2 = r3.d
                if (r2 == 0) goto L_0x000b
                r0.clear()
                return
            L_0x000b:
                java.lang.Object r2 = r0.poll()
                java.lang.Runnable r2 = (java.lang.Runnable) r2
                if (r2 != 0) goto L_0x0025
                boolean r2 = r3.d
                if (r2 == 0) goto L_0x001b
                r0.clear()
                return
            L_0x001b:
                java.util.concurrent.atomic.AtomicInteger r2 = r3.e
                int r1 = -r1
                int r1 = r2.addAndGet(r1)
                if (r1 != 0) goto L_0x0003
                return
            L_0x0025:
                r2.run()
                boolean r2 = r3.d
                if (r2 == 0) goto L_0x000b
                r0.clear()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.schedulers.ExecutorScheduler.ExecutorWorker.run():void");
        }
    }

    public final Scheduler.Worker a() {
        return new ExecutorWorker();
    }

    public final Disposable c(Runnable runnable) {
        ObjectHelper.b(runnable, "run is null");
        try {
            new ExecutorWorker.BooleanRunnable(runnable);
            throw null;
        } catch (RejectedExecutionException e) {
            RxJavaPlugins.b(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    public final Disposable d(Runnable runnable, long j, TimeUnit timeUnit) {
        ObjectHelper.b(runnable, "run is null");
        DelayedRunnable delayedRunnable = new DelayedRunnable(runnable);
        delayedRunnable.c.replace(d.d(new DelayedDispose(delayedRunnable), j, timeUnit));
        return delayedRunnable;
    }
}
