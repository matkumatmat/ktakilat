package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func1;

public final class OperatorMapNotification<T, R> implements Observable.Operator<R, T> {
    final Func0<? extends R> onCompleted;
    final Func1<? super Throwable, ? extends R> onError;
    final Func1<? super T, ? extends R> onNext;

    public static final class MapNotificationSubscriber<T, R> extends Subscriber<T> {
        static final long COMPLETED_FLAG = Long.MIN_VALUE;
        static final long REQUESTED_MASK = Long.MAX_VALUE;
        final Subscriber<? super R> actual;
        final AtomicLong missedRequested = new AtomicLong();
        final Func0<? extends R> onCompleted;
        final Func1<? super Throwable, ? extends R> onError;
        final Func1<? super T, ? extends R> onNext;
        long produced;
        final AtomicReference<Producer> producer = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        R value;

        public MapNotificationSubscriber(Subscriber<? super R> subscriber, Func1<? super T, ? extends R> func1, Func1<? super Throwable, ? extends R> func12, Func0<? extends R> func0) {
            this.actual = subscriber;
            this.onNext = func1;
            this.onError = func12;
            this.onCompleted = func0;
        }

        public void accountProduced() {
            long j = this.produced;
            if (j != 0 && this.producer.get() != null) {
                BackpressureUtils.produced(this.requested, j);
            }
        }

        public void onCompleted() {
            accountProduced();
            try {
                this.value = this.onCompleted.call();
            } catch (Throwable th) {
                Exceptions.throwOrReport(th, (Observer<?>) this.actual);
            }
            tryEmit();
        }

        public void onError(Throwable th) {
            accountProduced();
            try {
                this.value = this.onError.call(th);
            } catch (Throwable th2) {
                Exceptions.throwOrReport(th2, (Observer<?>) this.actual, (Object) th);
            }
            tryEmit();
        }

        public void onNext(T t) {
            try {
                this.produced++;
                this.actual.onNext(this.onNext.call(t));
            } catch (Throwable th) {
                Exceptions.throwOrReport(th, (Observer<?>) this.actual, (Object) t);
            }
        }

        public void requestInner(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException(e.j(j, "n >= 0 required but it was "));
            } else if (i != 0) {
                while (true) {
                    long j2 = this.requested.get();
                    if ((j2 & COMPLETED_FLAG) != 0) {
                        long j3 = Long.MAX_VALUE & j2;
                        if (this.requested.compareAndSet(j2, COMPLETED_FLAG | BackpressureUtils.addCap(j3, j))) {
                            if (j3 == 0) {
                                if (!this.actual.isUnsubscribed()) {
                                    this.actual.onNext(this.value);
                                }
                                if (!this.actual.isUnsubscribed()) {
                                    this.actual.onCompleted();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    } else {
                        if (this.requested.compareAndSet(j2, BackpressureUtils.addCap(j2, j))) {
                            AtomicReference<Producer> atomicReference = this.producer;
                            Producer producer2 = atomicReference.get();
                            if (producer2 != null) {
                                producer2.request(j);
                                return;
                            }
                            BackpressureUtils.getAndAddRequest(this.missedRequested, j);
                            Producer producer3 = atomicReference.get();
                            if (producer3 != null) {
                                long andSet = this.missedRequested.getAndSet(0);
                                if (andSet != 0) {
                                    producer3.request(andSet);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }

        public void setProducer(Producer producer2) {
            AtomicReference<Producer> atomicReference = this.producer;
            while (!atomicReference.compareAndSet((Object) null, producer2)) {
                if (atomicReference.get() != null) {
                    throw new IllegalStateException("Producer already set!");
                }
            }
            long andSet = this.missedRequested.getAndSet(0);
            if (andSet != 0) {
                producer2.request(andSet);
            }
        }

        public void tryEmit() {
            long j;
            do {
                j = this.requested.get();
                if ((j & COMPLETED_FLAG) != 0) {
                    return;
                }
            } while (!this.requested.compareAndSet(j, COMPLETED_FLAG | j));
            if (j != 0 || this.producer.get() == null) {
                if (!this.actual.isUnsubscribed()) {
                    this.actual.onNext(this.value);
                }
                if (!this.actual.isUnsubscribed()) {
                    this.actual.onCompleted();
                }
            }
        }
    }

    public OperatorMapNotification(Func1<? super T, ? extends R> func1, Func1<? super Throwable, ? extends R> func12, Func0<? extends R> func0) {
        this.onNext = func1;
        this.onError = func12;
        this.onCompleted = func0;
    }

    public Subscriber<? super T> call(Subscriber<? super R> subscriber) {
        final MapNotificationSubscriber mapNotificationSubscriber = new MapNotificationSubscriber(subscriber, this.onNext, this.onError, this.onCompleted);
        subscriber.add(mapNotificationSubscriber);
        subscriber.setProducer(new Producer() {
            public void request(long j) {
                mapNotificationSubscriber.requestInner(j);
            }
        });
        return mapNotificationSubscriber;
    }
}
