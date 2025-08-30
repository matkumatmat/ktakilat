package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;

public final class TestScheduler extends Scheduler {

    public final class TestWorker extends Scheduler.Worker {
        public volatile boolean c;

        public final class QueueRemove implements Runnable {
            public final void run() {
                throw null;
            }
        }

        public TestWorker() {
        }

        public final long a(TimeUnit timeUnit) {
            return TestScheduler.this.b(timeUnit);
        }

        public final Disposable b(Runnable runnable) {
            if (this.c) {
                return EmptyDisposable.INSTANCE;
            }
            TestScheduler.this.getClass();
            throw null;
        }

        public final Disposable c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.c) {
                return EmptyDisposable.INSTANCE;
            }
            TestScheduler.this.getClass();
            timeUnit.toNanos(j);
            TestScheduler.this.getClass();
            throw null;
        }

        public final void dispose() {
            this.c = true;
        }

        public final boolean isDisposed() {
            return this.c;
        }
    }

    public static final class TimedRunnable implements Comparable<TimedRunnable> {
        public final int compareTo(Object obj) {
            TimedRunnable timedRunnable = (TimedRunnable) obj;
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }

    public final Scheduler.Worker a() {
        return new TestWorker();
    }

    public final long b(TimeUnit timeUnit) {
        return timeUnit.convert(0, TimeUnit.NANOSECONDS);
    }
}
