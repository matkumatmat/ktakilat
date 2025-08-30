package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;

public final class ImmediateScheduler extends Scheduler {
    public static final ImmediateScheduler INSTANCE = new ImmediateScheduler();

    private ImmediateScheduler() {
    }

    public Scheduler.Worker createWorker() {
        return new InnerImmediateScheduler();
    }

    public final class InnerImmediateScheduler extends Scheduler.Worker implements Subscription {
        final BooleanSubscription innerSubscription = new BooleanSubscription();

        public InnerImmediateScheduler() {
        }

        public boolean isUnsubscribed() {
            return this.innerSubscription.isUnsubscribed();
        }

        public Subscription schedule(Action0 action0, long j, TimeUnit timeUnit) {
            return schedule(new SleepingAction(action0, this, timeUnit.toMillis(j) + ImmediateScheduler.this.now()));
        }

        public void unsubscribe() {
            this.innerSubscription.unsubscribe();
        }

        public Subscription schedule(Action0 action0) {
            action0.call();
            return Subscriptions.unsubscribed();
        }
    }
}
