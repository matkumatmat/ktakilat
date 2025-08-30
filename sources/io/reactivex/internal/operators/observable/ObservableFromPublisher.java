package io.reactivex.internal.operators.observable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class ObservableFromPublisher<T> extends Observable<T> {
    public final Publisher c;

    public static final class PublisherSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        public final Observer c;
        public Subscription d;

        public PublisherSubscriber(Observer observer) {
            this.c = observer;
        }

        public final void dispose() {
            this.d.cancel();
            this.d = SubscriptionHelper.CANCELLED;
        }

        public final boolean isDisposed() {
            if (this.d == SubscriptionHelper.CANCELLED) {
                return true;
            }
            return false;
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

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                this.c.onSubscribe(this);
                subscription.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }
    }

    public ObservableFromPublisher(Publisher publisher) {
        this.c = publisher;
    }

    public final void subscribeActual(Observer observer) {
        this.c.d(new PublisherSubscriber(observer));
    }
}
