package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.schedulers.NewThreadWorker;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.TimeUnit;

public abstract class Scheduler {
    public static final long c = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public static final class DisposeTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        public final Runnable c;
        public final Worker d;
        public Thread e;

        public DisposeTask(Runnable runnable, Worker worker) {
            this.c = runnable;
            this.d = worker;
        }

        public final void dispose() {
            if (this.e == Thread.currentThread()) {
                Worker worker = this.d;
                if (worker instanceof NewThreadWorker) {
                    NewThreadWorker newThreadWorker = (NewThreadWorker) worker;
                    if (!newThreadWorker.d) {
                        newThreadWorker.d = true;
                        newThreadWorker.c.shutdown();
                        return;
                    }
                    return;
                }
            }
            this.d.dispose();
        }

        public final boolean isDisposed() {
            return this.d.isDisposed();
        }

        public final void run() {
            this.e = Thread.currentThread();
            try {
                this.c.run();
            } finally {
                dispose();
                this.e = null;
            }
        }
    }

    public static final class PeriodicDirectTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        public final Runnable c;
        public final Worker d;
        public volatile boolean e;

        public PeriodicDirectTask(Runnable runnable, Worker worker) {
            this.c = runnable;
            this.d = worker;
        }

        public final void dispose() {
            this.e = true;
            this.d.dispose();
        }

        public final boolean isDisposed() {
            return this.e;
        }

        public final void run() {
            if (!this.e) {
                try {
                    this.c.run();
                } catch (Throwable th) {
                    Exceptions.a(th);
                    this.d.dispose();
                    throw ExceptionHelper.c(th);
                }
            }
        }
    }

    public static abstract class Worker implements Disposable {

        public final class PeriodicTask implements Runnable, SchedulerRunnableIntrospection {
            public final Runnable c;
            public final SequentialDisposable d;
            public final long e;
            public long f;
            public long g;
            public long i;

            public PeriodicTask(long j2, Runnable runnable, long j3, SequentialDisposable sequentialDisposable, long j4) {
                this.c = runnable;
                this.d = sequentialDisposable;
                this.e = j4;
                this.g = j3;
                this.i = j2;
            }

            public final void run() {
                long j2;
                this.c.run();
                SequentialDisposable sequentialDisposable = this.d;
                if (!sequentialDisposable.isDisposed()) {
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    Worker worker = Worker.this;
                    long a2 = worker.a(timeUnit);
                    long j3 = Scheduler.c;
                    long j4 = this.g;
                    long j5 = this.e;
                    if (a2 + j3 < j4 || a2 >= j4 + j5 + j3) {
                        j2 = a2 + j5;
                        long j6 = this.f + 1;
                        this.f = j6;
                        this.i = j2 - (j5 * j6);
                    } else {
                        long j7 = this.i;
                        long j8 = this.f + 1;
                        this.f = j8;
                        j2 = (j8 * j5) + j7;
                    }
                    this.g = a2;
                    sequentialDisposable.replace(worker.c(this, j2 - a2, timeUnit));
                }
            }
        }

        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public Disposable b(Runnable runnable) {
            return c(runnable, 0, TimeUnit.NANOSECONDS);
        }

        public abstract Disposable c(Runnable runnable, long j, TimeUnit timeUnit);

        public Disposable d(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            long j3 = j;
            TimeUnit timeUnit2 = timeUnit;
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            long nanos = timeUnit2.toNanos(j2);
            long a2 = a(TimeUnit.NANOSECONDS);
            SequentialDisposable sequentialDisposable3 = sequentialDisposable;
            PeriodicTask periodicTask = r0;
            PeriodicTask periodicTask2 = new PeriodicTask(timeUnit2.toNanos(j3) + a2, runnable, a2, sequentialDisposable2, nanos);
            Disposable c = c(periodicTask, j3, timeUnit2);
            if (c == EmptyDisposable.INSTANCE) {
                return c;
            }
            sequentialDisposable3.replace(c);
            return sequentialDisposable2;
        }
    }

    public abstract Worker a();

    public long b(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public Disposable c(Runnable runnable) {
        return d(runnable, 0, TimeUnit.NANOSECONDS);
    }

    public Disposable d(Runnable runnable, long j, TimeUnit timeUnit) {
        Worker a2 = a();
        ObjectHelper.b(runnable, "run is null");
        DisposeTask disposeTask = new DisposeTask(runnable, a2);
        a2.c(disposeTask, j, timeUnit);
        return disposeTask;
    }

    public Disposable e(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Worker a2 = a();
        PeriodicDirectTask periodicDirectTask = new PeriodicDirectTask(runnable, a2);
        Disposable d = a2.d(periodicDirectTask, j, j2, timeUnit);
        if (d == EmptyDisposable.INSTANCE) {
            return d;
        }
        return periodicDirectTask;
    }
}
