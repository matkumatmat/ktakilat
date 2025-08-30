package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.operators.OnSubscribeTimeoutTimedWithFallback;
import rx.internal.producers.ProducerArbiter;
import rx.internal.subscriptions.SequentialSubscription;
import rx.plugins.RxJavaHooks;

public final class OnSubscribeTimeoutSelectorWithFallback<T, U, V> implements Observable.OnSubscribe<T> {
    final Observable<? extends T> fallback;
    final Observable<U> firstTimeoutIndicator;
    final Func1<? super T, ? extends Observable<V>> itemTimeoutIndicator;
    final Observable<T> source;

    public static final class TimeoutMainSubscriber<T> extends Subscriber<T> {
        final Subscriber<? super T> actual;
        final ProducerArbiter arbiter = new ProducerArbiter();
        long consumed;
        final Observable<? extends T> fallback;
        final AtomicLong index = new AtomicLong();
        final Func1<? super T, ? extends Observable<?>> itemTimeoutIndicator;
        final SequentialSubscription task;
        final SequentialSubscription upstream;

        public final class TimeoutConsumer extends Subscriber<Object> {
            boolean done;
            final long idx;

            public TimeoutConsumer(long j) {
                this.idx = j;
            }

            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    TimeoutMainSubscriber.this.onTimeout(this.idx);
                }
            }

            public void onError(Throwable th) {
                if (!this.done) {
                    this.done = true;
                    TimeoutMainSubscriber.this.onTimeoutError(this.idx, th);
                    return;
                }
                RxJavaHooks.onError(th);
            }

            public void onNext(Object obj) {
                if (!this.done) {
                    this.done = true;
                    unsubscribe();
                    TimeoutMainSubscriber.this.onTimeout(this.idx);
                }
            }
        }

        public TimeoutMainSubscriber(Subscriber<? super T> subscriber, Func1<? super T, ? extends Observable<?>> func1, Observable<? extends T> observable) {
            this.actual = subscriber;
            this.itemTimeoutIndicator = func1;
            this.fallback = observable;
            SequentialSubscription sequentialSubscription = new SequentialSubscription();
            this.task = sequentialSubscription;
            this.upstream = new SequentialSubscription(this);
            add(sequentialSubscription);
        }

        public void onCompleted() {
            if (this.index.getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.task.unsubscribe();
                this.actual.onCompleted();
            }
        }

        public void onError(Throwable th) {
            if (this.index.getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.task.unsubscribe();
                this.actual.onError(th);
                return;
            }
            RxJavaHooks.onError(th);
        }

        public void onNext(T t) {
            long j = this.index.get();
            if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
                long j2 = j + 1;
                if (this.index.compareAndSet(j, j2)) {
                    Subscription subscription = (Subscription) this.task.get();
                    if (subscription != null) {
                        subscription.unsubscribe();
                    }
                    this.actual.onNext(t);
                    this.consumed++;
                    try {
                        Observable observable = (Observable) this.itemTimeoutIndicator.call(t);
                        if (observable != null) {
                            TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j2);
                            if (this.task.replace(timeoutConsumer)) {
                                observable.subscribe(timeoutConsumer);
                                return;
                            }
                            return;
                        }
                        throw new NullPointerException("The itemTimeoutIndicator returned a null Observable");
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        unsubscribe();
                        this.index.getAndSet(LocationRequestCompat.PASSIVE_INTERVAL);
                        this.actual.onError(th);
                    }
                }
            }
        }

        public void onTimeout(long j) {
            if (this.index.compareAndSet(j, LocationRequestCompat.PASSIVE_INTERVAL)) {
                unsubscribe();
                if (this.fallback == null) {
                    this.actual.onError(new TimeoutException());
                    return;
                }
                long j2 = this.consumed;
                if (j2 != 0) {
                    this.arbiter.produced(j2);
                }
                OnSubscribeTimeoutTimedWithFallback.FallbackSubscriber fallbackSubscriber = new OnSubscribeTimeoutTimedWithFallback.FallbackSubscriber(this.actual, this.arbiter);
                if (this.upstream.replace(fallbackSubscriber)) {
                    this.fallback.subscribe(fallbackSubscriber);
                }
            }
        }

        public void onTimeoutError(long j, Throwable th) {
            if (this.index.compareAndSet(j, LocationRequestCompat.PASSIVE_INTERVAL)) {
                unsubscribe();
                this.actual.onError(th);
                return;
            }
            RxJavaHooks.onError(th);
        }

        public void setProducer(Producer producer) {
            this.arbiter.setProducer(producer);
        }

        public void startFirst(Observable<?> observable) {
            if (observable != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0);
                if (this.task.replace(timeoutConsumer)) {
                    observable.subscribe((Subscriber<? super Object>) timeoutConsumer);
                }
            }
        }
    }

    public OnSubscribeTimeoutSelectorWithFallback(Observable<T> observable, Observable<U> observable2, Func1<? super T, ? extends Observable<V>> func1, Observable<? extends T> observable3) {
        this.source = observable;
        this.firstTimeoutIndicator = observable2;
        this.itemTimeoutIndicator = func1;
        this.fallback = observable3;
    }

    public void call(Subscriber<? super T> subscriber) {
        TimeoutMainSubscriber timeoutMainSubscriber = new TimeoutMainSubscriber(subscriber, this.itemTimeoutIndicator, this.fallback);
        subscriber.add(timeoutMainSubscriber.upstream);
        subscriber.setProducer(timeoutMainSubscriber.arbiter);
        timeoutMainSubscriber.startFirst(this.firstTimeoutIndicator);
        this.source.subscribe(timeoutMainSubscriber);
    }
}
