package rx.observers;

import java.util.concurrent.atomic.AtomicReference;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.plugins.RxJavaHooks;

public abstract class AsyncCompletableSubscriber implements CompletableSubscriber, Subscription {
    static final Unsubscribed UNSUBSCRIBED = new Unsubscribed();
    private final AtomicReference<Subscription> upstream = new AtomicReference<>();

    public static final class Unsubscribed implements Subscription {
        public boolean isUnsubscribed() {
            return true;
        }

        public void unsubscribe() {
        }
    }

    public final void clear() {
        this.upstream.set(UNSUBSCRIBED);
    }

    public final boolean isUnsubscribed() {
        if (this.upstream.get() == UNSUBSCRIBED) {
            return true;
        }
        return false;
    }

    public void onStart() {
    }

    public final void onSubscribe(Subscription subscription) {
        AtomicReference<Subscription> atomicReference = this.upstream;
        while (!atomicReference.compareAndSet((Object) null, subscription)) {
            if (atomicReference.get() != null) {
                subscription.unsubscribe();
                if (this.upstream.get() != UNSUBSCRIBED) {
                    RxJavaHooks.onError(new IllegalStateException("Subscription already set!"));
                    return;
                }
                return;
            }
        }
        onStart();
    }

    public final void unsubscribe() {
        Subscription andSet;
        Subscription subscription = this.upstream.get();
        Unsubscribed unsubscribed = UNSUBSCRIBED;
        if (subscription != unsubscribed && (andSet = this.upstream.getAndSet(unsubscribed)) != null && andSet != unsubscribed) {
            andSet.unsubscribe();
        }
    }
}
