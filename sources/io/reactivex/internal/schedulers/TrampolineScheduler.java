package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class TrampolineScheduler extends Scheduler {
    public static final TrampolineScheduler d = new Object();

    public static final class SleepingRunnable implements Runnable {
        public final Runnable c;
        public final TrampolineWorker d;
        public final long e;

        public SleepingRunnable(Runnable runnable, TrampolineWorker trampolineWorker, long j) {
            this.c = runnable;
            this.d = trampolineWorker;
            this.e = j;
        }

        public final void run() {
            if (!this.d.f) {
                long a2 = this.d.a(TimeUnit.MILLISECONDS);
                long j = this.e;
                if (j > a2) {
                    try {
                        Thread.sleep(j - a2);
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                        RxJavaPlugins.b(e2);
                        return;
                    }
                }
                if (!this.d.f) {
                    this.c.run();
                }
            }
        }
    }

    public static final class TimedRunnable implements Comparable<TimedRunnable> {
        public final Runnable c;
        public final long d;
        public final int e;
        public volatile boolean f;

        public TimedRunnable(Runnable runnable, Long l, int i) {
            this.c = runnable;
            this.d = l.longValue();
            this.e = i;
        }

        public final int compareTo(Object obj) {
            int i;
            TimedRunnable timedRunnable = (TimedRunnable) obj;
            int i2 = 0;
            int i3 = (this.d > timedRunnable.d ? 1 : (this.d == timedRunnable.d ? 0 : -1));
            if (i3 < 0) {
                i = -1;
            } else if (i3 > 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                return i;
            }
            int i4 = this.e;
            int i5 = timedRunnable.e;
            if (i4 < i5) {
                i2 = -1;
            } else if (i4 > i5) {
                i2 = 1;
            }
            return i2;
        }
    }

    public static final class TrampolineWorker extends Scheduler.Worker implements Disposable {
        public final PriorityBlockingQueue c = new PriorityBlockingQueue();
        public final AtomicInteger d = new AtomicInteger();
        public final AtomicInteger e = new AtomicInteger();
        public volatile boolean f;

        public final class AppendToQueueTask implements Runnable {
            public final TimedRunnable c;

            public AppendToQueueTask(TimedRunnable timedRunnable) {
                this.c = timedRunnable;
            }

            public final void run() {
                this.c.f = true;
                TrampolineWorker.this.c.remove(this.c);
            }
        }

        public final Disposable b(Runnable runnable) {
            return e(runnable, a(TimeUnit.MILLISECONDS));
        }

        public final Disposable c(Runnable runnable, long j, TimeUnit timeUnit) {
            long millis = timeUnit.toMillis(j) + a(TimeUnit.MILLISECONDS);
            return e(new SleepingRunnable(runnable, this, millis), millis);
        }

        public final void dispose() {
            this.f = true;
        }

        public final Disposable e(Runnable runnable, long j) {
            if (this.f) {
                return EmptyDisposable.INSTANCE;
            }
            TimedRunnable timedRunnable = new TimedRunnable(runnable, Long.valueOf(j), this.e.incrementAndGet());
            this.c.add(timedRunnable);
            if (this.d.getAndIncrement() != 0) {
                return Disposables.a(new AppendToQueueTask(timedRunnable));
            }
            int i = 1;
            while (!this.f) {
                TimedRunnable timedRunnable2 = (TimedRunnable) this.c.poll();
                if (timedRunnable2 == null) {
                    i = this.d.addAndGet(-i);
                    if (i == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!timedRunnable2.f) {
                    timedRunnable2.c.run();
                }
            }
            this.c.clear();
            return EmptyDisposable.INSTANCE;
        }

        public final boolean isDisposed() {
            return this.f;
        }
    }

    public final Scheduler.Worker a() {
        return new TrampolineWorker();
    }

    public final Disposable c(Runnable runnable) {
        runnable.run();
        return EmptyDisposable.INSTANCE;
    }

    public final Disposable d(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            ObjectHelper.b(runnable, "run is null");
            runnable.run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            RxJavaPlugins.b(e);
        }
        return EmptyDisposable.INSTANCE;
    }
}
