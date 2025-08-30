package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.Iterator;

public final class FlowableFromIterable<T> extends Flowable<T> {

    public static abstract class BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        public Iterator c;
        public volatile boolean d;
        public boolean e;

        public abstract void a();

        public abstract void b(long j);

        public final void cancel() {
            this.d = true;
        }

        public final void clear() {
            this.c = null;
        }

        public final boolean isEmpty() {
            Iterator it = this.c;
            if (it == null || !it.hasNext()) {
                return true;
            }
            return false;
        }

        public final Object poll() {
            Iterator it = this.c;
            if (it == null) {
                return null;
            }
            if (!this.e) {
                this.e = true;
            } else if (!it.hasNext()) {
                return null;
            }
            Object next = this.c.next();
            ObjectHelper.b(next, "Iterator.next() returned a null value");
            return next;
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j) && BackpressureHelper.a(this, j) == 0) {
                if (j == LocationRequestCompat.PASSIVE_INTERVAL) {
                    a();
                } else {
                    b(j);
                }
            }
        }

        public final int requestFusion(int i) {
            return i & 1;
        }
    }

    public static final class IteratorConditionalSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;

        public final void a() {
            Iterator it = this.c;
            if (!this.d) {
                try {
                    Object next = it.next();
                    if (!this.d) {
                        next.getClass();
                        throw null;
                    }
                } catch (Throwable th) {
                    Exceptions.a(th);
                    throw null;
                }
            }
        }

        public final void b(long j) {
            Iterator it = this.c;
            while (0 == j) {
                j = get();
                if (0 == j) {
                    j = addAndGet(-0);
                    if (j == 0) {
                        return;
                    }
                }
            }
            if (!this.d) {
                try {
                    Object next = it.next();
                    if (!this.d) {
                        next.getClass();
                        throw null;
                    }
                } catch (Throwable th) {
                    Exceptions.a(th);
                    throw null;
                }
            }
        }
    }

    public static final class IteratorSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;

        public final void a() {
            Iterator it = this.c;
            if (!this.d) {
                try {
                    Object next = it.next();
                    if (!this.d) {
                        next.getClass();
                        throw null;
                    }
                } catch (Throwable th) {
                    Exceptions.a(th);
                    throw null;
                }
            }
        }

        public final void b(long j) {
            Iterator it = this.c;
            while (0 == j) {
                j = get();
                if (0 == j) {
                    j = addAndGet(-0);
                    if (j == 0) {
                        return;
                    }
                }
            }
            if (!this.d) {
                try {
                    Object next = it.next();
                    if (!this.d) {
                        next.getClass();
                        throw null;
                    }
                } catch (Throwable th) {
                    Exceptions.a(th);
                    throw null;
                }
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        try {
            throw null;
        } catch (Throwable th) {
            Exceptions.a(th);
            EmptySubscription.error(th, flowableSubscriber);
        }
    }
}
