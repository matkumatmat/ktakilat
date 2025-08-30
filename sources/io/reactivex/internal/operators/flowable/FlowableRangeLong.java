package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;

public final class FlowableRangeLong extends Flowable<Long> {

    public static abstract class BaseRangeSubscription extends BasicQueueSubscription<Long> {
        private static final long serialVersionUID = -2252972430506210021L;
        public long c = 0;
        public volatile boolean d;

        public abstract void a();

        public abstract void b(long j);

        public final void cancel() {
            this.d = true;
        }

        public final void clear() {
            this.c = 0;
        }

        public final boolean isEmpty() {
            if (this.c == 0) {
                return true;
            }
            return false;
        }

        public final Object poll() {
            long j = this.c;
            if (j == 0) {
                return null;
            }
            this.c = 1 + j;
            return Long.valueOf(j);
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

    public static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        public final ConditionalSubscriber e;

        public RangeConditionalSubscription(ConditionalSubscriber conditionalSubscriber) {
            this.e = conditionalSubscriber;
        }

        public final void a() {
            ConditionalSubscriber conditionalSubscriber = this.e;
            long j = this.c;
            while (j != 0) {
                if (!this.d) {
                    conditionalSubscriber.c(Long.valueOf(j));
                    j++;
                } else {
                    return;
                }
            }
            if (!this.d) {
                conditionalSubscriber.onComplete();
            }
        }

        public final void b(long j) {
            long j2 = this.c;
            ConditionalSubscriber conditionalSubscriber = this.e;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == j || j2 == 0) {
                        if (j2 != 0) {
                            j = get();
                            if (j3 == j) {
                                this.c = j2;
                                j = addAndGet(-j3);
                            }
                        } else if (!this.d) {
                            conditionalSubscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.d) {
                        if (conditionalSubscriber.c(Long.valueOf(j2))) {
                            j3++;
                        }
                        j2++;
                    } else {
                        return;
                    }
                }
            } while (j != 0);
        }
    }

    public static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        public final FlowableSubscriber e;

        public RangeSubscription(FlowableSubscriber flowableSubscriber) {
            this.e = flowableSubscriber;
        }

        public final void a() {
            FlowableSubscriber flowableSubscriber = this.e;
            long j = this.c;
            while (j != 0) {
                if (!this.d) {
                    flowableSubscriber.onNext(Long.valueOf(j));
                    j++;
                } else {
                    return;
                }
            }
            if (!this.d) {
                flowableSubscriber.onComplete();
            }
        }

        public final void b(long j) {
            long j2 = this.c;
            FlowableSubscriber flowableSubscriber = this.e;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == j || j2 == 0) {
                        if (j2 != 0) {
                            j = get();
                            if (j3 == j) {
                                this.c = j2;
                                j = addAndGet(-j3);
                            }
                        } else if (!this.d) {
                            flowableSubscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.d) {
                        flowableSubscriber.onNext(Long.valueOf(j2));
                        j3++;
                        j2++;
                    } else {
                        return;
                    }
                }
            } while (j != 0);
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        if (flowableSubscriber instanceof ConditionalSubscriber) {
            flowableSubscriber.onSubscribe(new RangeConditionalSubscription((ConditionalSubscriber) flowableSubscriber));
        } else {
            flowableSubscriber.onSubscribe(new RangeSubscription(flowableSubscriber));
        }
    }
}
