package io.reactivex.internal.subscriptions;

import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public enum SubscriptionHelper implements Subscription {
    ;

    public static void deferredRequest(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, long j) {
        Subscription subscription = atomicReference.get();
        if (subscription != null) {
            subscription.request(j);
        } else if (validate(j)) {
            BackpressureHelper.a(atomicLong, j);
            Subscription subscription2 = atomicReference.get();
            if (subscription2 != null) {
                long andSet = atomicLong.getAndSet(0);
                if (andSet != 0) {
                    subscription2.request(andSet);
                }
            }
        }
    }

    public static boolean deferredSetOnce(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, Subscription subscription) {
        if (!setOnce(atomicReference, subscription)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0);
        if (andSet == 0) {
            return true;
        }
        subscription.request(andSet);
        return true;
    }

    public static boolean isCancelled(Subscription subscription) {
        if (subscription == CANCELLED) {
            return true;
        }
        return false;
    }

    public static boolean replace(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        while (true) {
            Subscription subscription2 = atomicReference.get();
            if (subscription2 != CANCELLED) {
                while (true) {
                    if (atomicReference.compareAndSet(subscription2, subscription)) {
                        return true;
                    }
                    if (atomicReference.get() != subscription2) {
                    }
                }
            } else if (subscription == null) {
                return false;
            } else {
                subscription.cancel();
                return false;
            }
        }
    }

    public static void reportMoreProduced(long j) {
        RxJavaPlugins.b(new ProtocolViolationException(e.j(j, "More produced than requested: ")));
    }

    public static void reportSubscriptionSet() {
        RxJavaPlugins.b(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean set(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        while (true) {
            Subscription subscription2 = atomicReference.get();
            if (subscription2 != CANCELLED) {
                while (true) {
                    if (atomicReference.compareAndSet(subscription2, subscription)) {
                        if (subscription2 == null) {
                            return true;
                        }
                        subscription2.cancel();
                        return true;
                    } else if (atomicReference.get() != subscription2) {
                    }
                }
            } else if (subscription == null) {
                return false;
            } else {
                subscription.cancel();
                return false;
            }
        }
    }

    public static boolean setOnce(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        ObjectHelper.b(subscription, "s is null");
        while (!atomicReference.compareAndSet((Object) null, subscription)) {
            if (atomicReference.get() != null) {
                subscription.cancel();
                if (atomicReference.get() == CANCELLED) {
                    return false;
                }
                reportSubscriptionSet();
                return false;
            }
        }
        return true;
    }

    public static boolean validate(Subscription subscription, Subscription subscription2) {
        if (subscription2 == null) {
            RxJavaPlugins.b(new NullPointerException("next is null"));
            return false;
        } else if (subscription == null) {
            return true;
        } else {
            subscription2.cancel();
            reportSubscriptionSet();
            return false;
        }
    }

    public void cancel() {
    }

    public void request(long j) {
    }

    public static boolean cancel(AtomicReference<Subscription> atomicReference) {
        Subscription andSet;
        Subscription subscription = atomicReference.get();
        SubscriptionHelper subscriptionHelper = CANCELLED;
        if (subscription == subscriptionHelper || (andSet = atomicReference.getAndSet(subscriptionHelper)) == subscriptionHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    public static boolean validate(long j) {
        if (j > 0) {
            return true;
        }
        RxJavaPlugins.b(new IllegalArgumentException(e.j(j, "n > 0 required but it was ")));
        return false;
    }

    public static boolean setOnce(AtomicReference<Subscription> atomicReference, Subscription subscription, long j) {
        if (!setOnce(atomicReference, subscription)) {
            return false;
        }
        subscription.request(j);
        return true;
    }
}
