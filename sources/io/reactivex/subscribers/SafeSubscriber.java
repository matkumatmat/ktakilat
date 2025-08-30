package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class SafeSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    public Subscription c;

    public final void cancel() {
        try {
            this.c.cancel();
        } catch (Throwable th) {
            Exceptions.a(th);
            RxJavaPlugins.b(th);
        }
    }

    public final void onComplete() {
    }

    public final void onError(Throwable th) {
        RxJavaPlugins.b(th);
    }

    public final void onNext(Object obj) {
    }

    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.c, subscription)) {
            this.c = subscription;
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                RxJavaPlugins.b(new CompositeException(th, th));
            }
        }
    }

    public final void request(long j) {
        try {
            this.c.request(j);
        } catch (Throwable th) {
            Exceptions.a(th);
            RxJavaPlugins.b(new CompositeException(th, th));
        }
    }
}
