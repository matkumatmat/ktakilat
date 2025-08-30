package io.reactivex.disposables;

import org.reactivestreams.Subscription;

final class SubscriptionDisposable extends ReferenceDisposable<Subscription> {
    private static final long serialVersionUID = -707001650852963139L;

    public final void a(Object obj) {
        ((Subscription) obj).cancel();
    }
}
