package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;

public final class RefCountSubscription implements Subscription {
    static final State EMPTY_STATE = new State(false, 0);
    private final Subscription actual;
    final AtomicReference<State> state = new AtomicReference<>(EMPTY_STATE);

    public static final class InnerSubscription extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 7005765588239987643L;
        final RefCountSubscription parent;

        public InnerSubscription(RefCountSubscription refCountSubscription) {
            this.parent = refCountSubscription;
        }

        public boolean isUnsubscribed() {
            if (get() != 0) {
                return true;
            }
            return false;
        }

        public void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.parent.unsubscribeAChild();
            }
        }
    }

    public static final class State {
        final int children;
        final boolean isUnsubscribed;

        public State(boolean z, int i) {
            this.isUnsubscribed = z;
            this.children = i;
        }

        public State addChild() {
            return new State(this.isUnsubscribed, this.children + 1);
        }

        public State removeChild() {
            return new State(this.isUnsubscribed, this.children - 1);
        }

        public State unsubscribe() {
            return new State(true, this.children);
        }
    }

    public RefCountSubscription(Subscription subscription) {
        if (subscription != null) {
            this.actual = subscription;
            return;
        }
        throw new IllegalArgumentException("s");
    }

    private void unsubscribeActualIfApplicable(State state2) {
        if (state2.isUnsubscribed && state2.children == 0) {
            this.actual.unsubscribe();
        }
    }

    public Subscription get() {
        AtomicReference<State> atomicReference = this.state;
        while (true) {
            State state2 = atomicReference.get();
            if (state2.isUnsubscribed) {
                return Subscriptions.unsubscribed();
            }
            State addChild = state2.addChild();
            while (true) {
                if (atomicReference.compareAndSet(state2, addChild)) {
                    return new InnerSubscription(this);
                }
                if (atomicReference.get() != state2) {
                }
            }
        }
    }

    public boolean isUnsubscribed() {
        return this.state.get().isUnsubscribed;
    }

    public void unsubscribe() {
        AtomicReference<State> atomicReference = this.state;
        while (true) {
            State state2 = atomicReference.get();
            if (!state2.isUnsubscribed) {
                State unsubscribe = state2.unsubscribe();
                while (true) {
                    if (atomicReference.compareAndSet(state2, unsubscribe)) {
                        unsubscribeActualIfApplicable(unsubscribe);
                        return;
                    } else if (atomicReference.get() != state2) {
                    }
                }
            } else {
                return;
            }
        }
    }

    public void unsubscribeAChild() {
        AtomicReference<State> atomicReference = this.state;
        while (true) {
            State state2 = atomicReference.get();
            State removeChild = state2.removeChild();
            while (true) {
                if (atomicReference.compareAndSet(state2, removeChild)) {
                    unsubscribeActualIfApplicable(removeChild);
                    return;
                } else if (atomicReference.get() != state2) {
                }
            }
        }
    }
}
