package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.plugins.RxJavaPlugins;

public final class FlowableDoOnEach<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class DoOnEachConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
        public final boolean c(Object obj) {
            if (this.f) {
                return false;
            }
            try {
                throw null;
            } catch (Throwable th) {
                a(th);
                return false;
            }
        }

        public final void onComplete() {
            if (!this.f) {
                try {
                    throw null;
                } catch (Throwable th) {
                    a(th);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.b(th);
                return;
            }
            this.f = true;
            try {
                throw null;
            } catch (Throwable th2) {
                Exceptions.a(th2);
                RxJavaPlugins.b(th2);
            }
        }

        public final void onNext(Object obj) {
            if (!this.f) {
                if (this.g != 0) {
                    this.c.onNext((Object) null);
                    return;
                }
                try {
                    throw null;
                } catch (Throwable th) {
                    a(th);
                }
            }
        }

        public final Object poll() {
            try {
                Object poll = this.e.poll();
                if (poll != null) {
                    try {
                        throw null;
                    } catch (Throwable th) {
                        throw new CompositeException(th, th);
                    }
                } else if (this.g != 1) {
                    return poll;
                } else {
                    throw null;
                }
            } catch (Throwable th2) {
                throw new CompositeException(th, th2);
            }
        }
    }

    public static final class DoOnEachSubscriber<T> extends BasicFuseableSubscriber<T, T> {
        public final void onComplete() {
            if (!this.f) {
                try {
                    throw null;
                } catch (Throwable th) {
                    a(th);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.b(th);
                return;
            }
            this.f = true;
            try {
                throw null;
            } catch (Throwable th2) {
                Exceptions.a(th2);
                RxJavaPlugins.b(th2);
            }
        }

        public final void onNext(Object obj) {
            if (!this.f) {
                if (this.g != 0) {
                    this.c.onNext((Object) null);
                    return;
                }
                try {
                    throw null;
                } catch (Throwable th) {
                    a(th);
                }
            }
        }

        public final Object poll() {
            try {
                Object poll = this.e.poll();
                if (poll != null) {
                    try {
                        throw null;
                    } catch (Throwable th) {
                        throw new CompositeException(th, th);
                    }
                } else if (this.g != 1) {
                    return poll;
                } else {
                    throw null;
                }
            } catch (Throwable th2) {
                throw new CompositeException(th, th2);
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        boolean z = flowableSubscriber instanceof ConditionalSubscriber;
        Flowable flowable = this.d;
        if (z) {
            flowable.a(new BasicFuseableConditionalSubscriber((ConditionalSubscriber) flowableSubscriber));
        } else {
            flowable.a(new BasicFuseableSubscriber(flowableSubscriber));
        }
    }
}
