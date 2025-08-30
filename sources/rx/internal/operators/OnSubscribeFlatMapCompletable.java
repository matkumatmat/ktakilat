package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.util.ExceptionsUtils;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public final class OnSubscribeFlatMapCompletable<T> implements Observable.OnSubscribe<T> {
    final boolean delayErrors;
    final Func1<? super T, ? extends Completable> mapper;
    final int maxConcurrency;
    final Observable<T> source;

    public static final class FlatMapCompletableSubscriber<T> extends Subscriber<T> {
        final Subscriber<? super T> actual;
        final boolean delayErrors;
        final AtomicReference<Throwable> errors = new AtomicReference<>();
        final Func1<? super T, ? extends Completable> mapper;
        final int maxConcurrency;
        final CompositeSubscription set = new CompositeSubscription();
        final AtomicInteger wip = new AtomicInteger(1);

        public final class InnerSubscriber extends AtomicReference<Subscription> implements CompletableSubscriber, Subscription {
            private static final long serialVersionUID = -8588259593722659900L;

            public InnerSubscriber() {
            }

            public boolean isUnsubscribed() {
                if (get() == this) {
                    return true;
                }
                return false;
            }

            public void onCompleted() {
                FlatMapCompletableSubscriber.this.innerComplete(this);
            }

            public void onError(Throwable th) {
                FlatMapCompletableSubscriber.this.innerError(this, th);
            }

            public void onSubscribe(Subscription subscription) {
                if (!compareAndSet((Object) null, subscription)) {
                    subscription.unsubscribe();
                    if (get() != this) {
                        RxJavaHooks.onError(new IllegalStateException("Subscription already set!"));
                    }
                }
            }

            public void unsubscribe() {
                Subscription subscription = (Subscription) getAndSet(this);
                if (subscription != null && subscription != this) {
                    subscription.unsubscribe();
                }
            }
        }

        public FlatMapCompletableSubscriber(Subscriber<? super T> subscriber, Func1<? super T, ? extends Completable> func1, boolean z, int i) {
            long j;
            this.actual = subscriber;
            this.mapper = func1;
            this.delayErrors = z;
            this.maxConcurrency = i;
            if (i != Integer.MAX_VALUE) {
                j = (long) i;
            } else {
                j = LocationRequestCompat.PASSIVE_INTERVAL;
            }
            request(j);
        }

        public boolean done() {
            if (this.wip.decrementAndGet() != 0) {
                return false;
            }
            Throwable terminate = ExceptionsUtils.terminate(this.errors);
            if (terminate != null) {
                this.actual.onError(terminate);
                return true;
            }
            this.actual.onCompleted();
            return true;
        }

        public void innerComplete(FlatMapCompletableSubscriber<T>.InnerSubscriber innerSubscriber) {
            this.set.remove(innerSubscriber);
            if (!done() && this.maxConcurrency != Integer.MAX_VALUE) {
                request(1);
            }
        }

        public void innerError(FlatMapCompletableSubscriber<T>.InnerSubscriber innerSubscriber, Throwable th) {
            this.set.remove(innerSubscriber);
            if (this.delayErrors) {
                ExceptionsUtils.addThrowable(this.errors, th);
                if (!done() && this.maxConcurrency != Integer.MAX_VALUE) {
                    request(1);
                    return;
                }
                return;
            }
            this.set.unsubscribe();
            unsubscribe();
            AtomicReference<Throwable> atomicReference = this.errors;
            while (!atomicReference.compareAndSet((Object) null, th)) {
                if (atomicReference.get() != null) {
                    RxJavaHooks.onError(th);
                    return;
                }
            }
            this.actual.onError(ExceptionsUtils.terminate(this.errors));
        }

        public void onCompleted() {
            done();
        }

        public void onError(Throwable th) {
            if (this.delayErrors) {
                ExceptionsUtils.addThrowable(this.errors, th);
                onCompleted();
                return;
            }
            this.set.unsubscribe();
            AtomicReference<Throwable> atomicReference = this.errors;
            while (!atomicReference.compareAndSet((Object) null, th)) {
                if (atomicReference.get() != null) {
                    RxJavaHooks.onError(th);
                    return;
                }
            }
            this.actual.onError(ExceptionsUtils.terminate(this.errors));
        }

        public void onNext(T t) {
            try {
                Completable completable = (Completable) this.mapper.call(t);
                if (completable != null) {
                    InnerSubscriber innerSubscriber = new InnerSubscriber();
                    this.set.add(innerSubscriber);
                    this.wip.getAndIncrement();
                    completable.unsafeSubscribe((CompletableSubscriber) innerSubscriber);
                    return;
                }
                throw new NullPointerException("The mapper returned a null Completable");
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                unsubscribe();
                onError(th);
            }
        }
    }

    public OnSubscribeFlatMapCompletable(Observable<T> observable, Func1<? super T, ? extends Completable> func1, boolean z, int i) {
        if (func1 == null) {
            throw new NullPointerException("mapper is null");
        } else if (i > 0) {
            this.source = observable;
            this.mapper = func1;
            this.delayErrors = z;
            this.maxConcurrency = i;
        } else {
            throw new IllegalArgumentException(ba.k(i, "maxConcurrency > 0 required but it was "));
        }
    }

    public void call(Subscriber<? super T> subscriber) {
        FlatMapCompletableSubscriber flatMapCompletableSubscriber = new FlatMapCompletableSubscriber(subscriber, this.mapper, this.delayErrors, this.maxConcurrency);
        subscriber.add(flatMapCompletableSubscriber);
        subscriber.add(flatMapCompletableSubscriber.set);
        this.source.unsafeSubscribe(flatMapCompletableSubscriber);
    }
}
