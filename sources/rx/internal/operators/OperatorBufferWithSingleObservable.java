package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.observers.SerializedSubscriber;
import rx.observers.Subscribers;

public final class OperatorBufferWithSingleObservable<T, TClosing> implements Observable.Operator<List<T>, T> {
    final Func0<? extends Observable<? extends TClosing>> bufferClosingSelector;
    final int initialCapacity;

    public final class BufferingSubscriber extends Subscriber<T> {
        final Subscriber<? super List<T>> child;
        List<T> chunk;
        boolean done;

        public BufferingSubscriber(Subscriber<? super List<T>> subscriber) {
            this.child = subscriber;
            this.chunk = new ArrayList(OperatorBufferWithSingleObservable.this.initialCapacity);
        }

        public void emit() {
            synchronized (this) {
                try {
                    if (!this.done) {
                        List<T> list = this.chunk;
                        this.chunk = new ArrayList(OperatorBufferWithSingleObservable.this.initialCapacity);
                        try {
                            this.child.onNext(list);
                        } catch (Throwable th) {
                            while (true) {
                                throw th;
                            }
                        }
                    }
                } finally {
                    while (true) {
                    }
                }
            }
        }

        public void onCompleted() {
            try {
                synchronized (this) {
                    if (!this.done) {
                        this.done = true;
                        List<T> list = this.chunk;
                        this.chunk = null;
                        this.child.onNext(list);
                        this.child.onCompleted();
                        unsubscribe();
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwOrReport(th, (Observer<?>) this.child);
            }
        }

        public void onError(Throwable th) {
            synchronized (this) {
                try {
                    if (!this.done) {
                        this.done = true;
                        this.chunk = null;
                        this.child.onError(th);
                        unsubscribe();
                    }
                } catch (Throwable th2) {
                    while (true) {
                        throw th2;
                    }
                }
            }
        }

        public void onNext(T t) {
            synchronized (this) {
                try {
                    if (!this.done) {
                        this.chunk.add(t);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public OperatorBufferWithSingleObservable(Func0<? extends Observable<? extends TClosing>> func0, int i) {
        this.bufferClosingSelector = func0;
        this.initialCapacity = i;
    }

    public Subscriber<? super T> call(Subscriber<? super List<T>> subscriber) {
        try {
            Observable observable = (Observable) this.bufferClosingSelector.call();
            final BufferingSubscriber bufferingSubscriber = new BufferingSubscriber(new SerializedSubscriber(subscriber));
            AnonymousClass2 r2 = new Subscriber<TClosing>() {
                public void onCompleted() {
                    bufferingSubscriber.onCompleted();
                }

                public void onError(Throwable th) {
                    bufferingSubscriber.onError(th);
                }

                public void onNext(TClosing tclosing) {
                    bufferingSubscriber.emit();
                }
            };
            subscriber.add(r2);
            subscriber.add(bufferingSubscriber);
            observable.unsafeSubscribe(r2);
            return bufferingSubscriber;
        } catch (Throwable th) {
            Exceptions.throwOrReport(th, (Observer<?>) subscriber);
            return Subscribers.empty();
        }
    }

    public OperatorBufferWithSingleObservable(final Observable<? extends TClosing> observable, int i) {
        this.bufferClosingSelector = new Func0<Observable<? extends TClosing>>() {
            public Observable<? extends TClosing> call() {
                return observable;
            }
        };
        this.initialCapacity = i;
    }
}
