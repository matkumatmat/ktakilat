package rx;

import androidx.core.location.LocationRequestCompat;
import rx.internal.util.SubscriptionList;

public abstract class Subscriber<T> implements Observer<T>, Subscription {
    private static final long NOT_SET = Long.MIN_VALUE;
    private Producer producer;
    private long requested;
    private final Subscriber<?> subscriber;
    private final SubscriptionList subscriptions;

    public Subscriber() {
        this((Subscriber<?>) null, false);
    }

    private void addToRequested(long j) {
        long j2 = this.requested;
        if (j2 == NOT_SET) {
            this.requested = j;
            return;
        }
        long j3 = j2 + j;
        if (j3 < 0) {
            this.requested = LocationRequestCompat.PASSIVE_INTERVAL;
        } else {
            this.requested = j3;
        }
    }

    public final void add(Subscription subscription) {
        this.subscriptions.add(subscription);
    }

    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    public void onStart() {
    }

    public final void request(long j) {
        if (j >= 0) {
            synchronized (this) {
                Producer producer2 = this.producer;
                if (producer2 != null) {
                    producer2.request(j);
                } else {
                    addToRequested(j);
                }
            }
        } else {
            throw new IllegalArgumentException(e.j(j, "number requested cannot be negative: "));
        }
    }

    public void setProducer(Producer producer2) {
        long j;
        Subscriber<?> subscriber2;
        boolean z;
        synchronized (this) {
            j = this.requested;
            this.producer = producer2;
            subscriber2 = this.subscriber;
            if (subscriber2 == null || j != NOT_SET) {
                z = false;
            } else {
                z = true;
            }
        }
        if (z) {
            subscriber2.setProducer(producer2);
        } else if (j == NOT_SET) {
            producer2.request(LocationRequestCompat.PASSIVE_INTERVAL);
        } else {
            producer2.request(j);
        }
    }

    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }

    public Subscriber(Subscriber<?> subscriber2) {
        this(subscriber2, true);
    }

    public Subscriber(Subscriber<?> subscriber2, boolean z) {
        this.requested = NOT_SET;
        this.subscriber = subscriber2;
        this.subscriptions = (!z || subscriber2 == null) ? new SubscriptionList() : subscriber2.subscriptions;
    }
}
