package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscription;

public final class FlowableFromObservable<T> extends Flowable<T> {
    public final Observable d;

    public static class SubscriberObserver<T> implements Observer<T>, Subscription {
        public final FlowableSubscriber c;
        public Disposable d;

        public SubscriberObserver(FlowableSubscriber flowableSubscriber) {
            this.c = flowableSubscriber;
        }

        public final void cancel() {
            this.d.dispose();
        }

        public final void onComplete() {
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            this.c.onNext(obj);
        }

        public final void onSubscribe(Disposable disposable) {
            this.d = disposable;
            this.c.onSubscribe(this);
        }

        public final void request(long j) {
        }
    }

    public FlowableFromObservable(Observable observable) {
        this.d = observable;
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.subscribe(new SubscriberObserver(flowableSubscriber));
    }
}
