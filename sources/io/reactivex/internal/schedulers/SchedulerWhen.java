package io.reactivex.internal.schedulers;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@Experimental
public class SchedulerWhen extends Scheduler implements Disposable {
    public static final Disposable d = new Object();
    public static final EmptyDisposable e = EmptyDisposable.INSTANCE;

    public static final class CreateWorkerFunction implements Function<ScheduledAction, Completable> {

        public final class WorkerCompletable extends Completable {
            public final ScheduledAction c;

            public WorkerCompletable(CreateWorkerFunction createWorkerFunction, ScheduledAction scheduledAction) {
                this.c = scheduledAction;
            }

            public final void c(CompletableObserver completableObserver) {
                completableObserver.onSubscribe(this.c);
                throw null;
            }
        }

        public final Object apply(Object obj) {
            return new WorkerCompletable(this, (ScheduledAction) obj);
        }
    }

    public static class DelayedAction extends ScheduledAction {
        public final Runnable c;

        public DelayedAction(Runnable runnable, long j, TimeUnit timeUnit) {
            this.c = runnable;
        }
    }

    public static class ImmediateAction extends ScheduledAction {
        public final Runnable c;

        public ImmediateAction(Runnable runnable) {
            this.c = runnable;
        }
    }

    public static class OnCompletedAction implements Runnable {
        public final void run() {
            try {
                throw null;
            } catch (Throwable unused) {
                throw null;
            }
        }
    }

    public static final class QueueWorker extends Scheduler.Worker {
        public final Disposable b(Runnable runnable) {
            new ImmediateAction(runnable);
            throw null;
        }

        public final Disposable c(Runnable runnable, long j, TimeUnit timeUnit) {
            new DelayedAction(runnable, j, timeUnit);
            throw null;
        }

        public final void dispose() {
            throw null;
        }

        public final boolean isDisposed() {
            throw null;
        }
    }

    public static abstract class ScheduledAction extends AtomicReference<Disposable> implements Disposable {
        public ScheduledAction() {
            super(SchedulerWhen.d);
        }

        public final void dispose() {
            Disposable disposable;
            EmptyDisposable emptyDisposable = SchedulerWhen.e;
            do {
                disposable = (Disposable) get();
                if (disposable == SchedulerWhen.e) {
                    return;
                }
            } while (!compareAndSet(disposable, emptyDisposable));
            if (disposable != SchedulerWhen.d) {
                disposable.dispose();
            }
        }

        public final boolean isDisposed() {
            return ((Disposable) get()).isDisposed();
        }
    }

    public static final class SubscribedDisposable implements Disposable {
        public final void dispose() {
        }

        public final boolean isDisposed() {
            return false;
        }
    }

    public final Scheduler.Worker a() {
        throw null;
    }

    public final void dispose() {
        throw null;
    }

    public final boolean isDisposed() {
        throw null;
    }
}
