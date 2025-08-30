package io.reactivex.internal.subscriptions;

import io.reactivex.annotations.Nullable;
import org.reactivestreams.Subscriber;

public class DeferredScalarSubscription<T> extends BasicIntQueueSubscription<T> {
    private static final long serialVersionUID = -2151279923272604993L;
    public final Subscriber c;
    public Object d;

    public DeferredScalarSubscription(Subscriber<? super T> subscriber) {
        this.c = subscriber;
    }

    public void cancel() {
        set(4);
        this.d = null;
    }

    public final void clear() {
        lazySet(32);
        this.d = null;
    }

    public final void complete(T t) {
        int i = get();
        do {
            Subscriber subscriber = this.c;
            if (i == 8) {
                this.d = t;
                lazySet(16);
                subscriber.onNext(t);
                if (get() != 4) {
                    subscriber.onComplete();
                    return;
                }
                return;
            } else if ((i & -3) == 0) {
                if (i == 2) {
                    lazySet(3);
                    subscriber.onNext(t);
                    if (get() != 4) {
                        subscriber.onComplete();
                        return;
                    }
                    return;
                }
                this.d = t;
                if (!compareAndSet(0, 1)) {
                    i = get();
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (i != 4);
        this.d = null;
    }

    public final boolean isCancelled() {
        if (get() == 4) {
            return true;
        }
        return false;
    }

    public final boolean isEmpty() {
        if (get() != 16) {
            return true;
        }
        return false;
    }

    public void onSuccess(Object obj) {
        complete(obj);
    }

    @Nullable
    public final T poll() {
        if (get() != 16) {
            return null;
        }
        lazySet(32);
        T t = this.d;
        this.d = null;
        return t;
    }

    public final void request(long j) {
        Object obj;
        if (SubscriptionHelper.validate(j)) {
            do {
                int i = get();
                if ((i & -2) == 0) {
                    if (i == 1) {
                        if (compareAndSet(1, 3) && (obj = this.d) != null) {
                            this.d = null;
                            Subscriber subscriber = this.c;
                            subscriber.onNext(obj);
                            if (get() != 4) {
                                subscriber.onComplete();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    public final int requestFusion(int i) {
        if ((i & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final boolean tryCancel() {
        if (getAndSet(4) != 4) {
            return true;
        }
        return false;
    }
}
