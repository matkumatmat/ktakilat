package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.operators.OperatorDebounceWithTime;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

public final class OperatorDebounceWithSelector<T, U> implements Observable.Operator<T, T> {
    final Func1<? super T, ? extends Observable<U>> selector;

    public OperatorDebounceWithSelector(Func1<? super T, ? extends Observable<U>> func1) {
        this.selector = func1;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        final SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        return new Subscriber<T>(subscriber) {
            final Subscriber<?> self = this;
            final OperatorDebounceWithTime.DebounceState<T> state = new OperatorDebounceWithTime.DebounceState<>();

            public void onCompleted() {
                this.state.emitAndComplete(serializedSubscriber, this);
            }

            public void onError(Throwable th) {
                serializedSubscriber.onError(th);
                unsubscribe();
                this.state.clear();
            }

            public void onNext(T t) {
                try {
                    Observable observable = (Observable) OperatorDebounceWithSelector.this.selector.call(t);
                    final int next = this.state.next(t);
                    AnonymousClass1 r1 = new Subscriber<U>() {
                        public void onCompleted() {
                            AnonymousClass1 r0 = AnonymousClass1.this;
                            r0.state.emit(next, serializedSubscriber, r0.self);
                            unsubscribe();
                        }

                        public void onError(Throwable th) {
                            AnonymousClass1.this.self.onError(th);
                        }

                        public void onNext(U u) {
                            onCompleted();
                        }
                    };
                    serialSubscription.set(r1);
                    observable.unsafeSubscribe(r1);
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, (Observer<?>) this);
                }
            }

            public void onStart() {
                request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        };
    }
}
