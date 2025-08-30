package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;

public final class OperatorDelay<T> implements Observable.Operator<T, T> {
    final long delay;
    final Scheduler scheduler;
    final TimeUnit unit;

    public OperatorDelay(long j, TimeUnit timeUnit, Scheduler scheduler2) {
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        final Scheduler.Worker createWorker = this.scheduler.createWorker();
        subscriber.add(createWorker);
        return new Subscriber<T>(subscriber) {
            boolean done;

            public void onCompleted() {
                Scheduler.Worker worker = createWorker;
                AnonymousClass1 r1 = new Action0() {
                    public void call() {
                        AnonymousClass1 r0 = AnonymousClass1.this;
                        if (!r0.done) {
                            r0.done = true;
                            subscriber.onCompleted();
                        }
                    }
                };
                OperatorDelay operatorDelay = OperatorDelay.this;
                worker.schedule(r1, operatorDelay.delay, operatorDelay.unit);
            }

            public void onError(final Throwable th) {
                createWorker.schedule(new Action0() {
                    public void call() {
                        AnonymousClass1 r0 = AnonymousClass1.this;
                        if (!r0.done) {
                            r0.done = true;
                            subscriber.onError(th);
                            createWorker.unsubscribe();
                        }
                    }
                });
            }

            public void onNext(final T t) {
                Scheduler.Worker worker = createWorker;
                AnonymousClass3 r1 = new Action0() {
                    public void call() {
                        AnonymousClass1 r0 = AnonymousClass1.this;
                        if (!r0.done) {
                            subscriber.onNext(t);
                        }
                    }
                };
                OperatorDelay operatorDelay = OperatorDelay.this;
                worker.schedule(r1, operatorDelay.delay, operatorDelay.unit);
            }
        };
    }
}
