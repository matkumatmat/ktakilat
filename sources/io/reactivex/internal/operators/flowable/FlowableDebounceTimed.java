package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableDebounceTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
        private static final long serialVersionUID = 6812032969491025141L;
        public final Object c;
        public final long d;
        public final DebounceTimedSubscriber e;
        public final AtomicBoolean f = new AtomicBoolean();

        public DebounceEmitter(Object obj, long j, DebounceTimedSubscriber debounceTimedSubscriber) {
            this.c = obj;
            this.d = j;
            this.e = debounceTimedSubscriber;
        }

        public final void a() {
            if (this.f.compareAndSet(false, true)) {
                DebounceTimedSubscriber debounceTimedSubscriber = this.e;
                if (this.d != debounceTimedSubscriber.e) {
                    return;
                }
                if (debounceTimedSubscriber.get() != 0) {
                    throw null;
                }
                debounceTimedSubscriber.cancel();
                throw null;
            }
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        public final boolean isDisposed() {
            if (get() == DisposableHelper.DISPOSED) {
                return true;
            }
            return false;
        }

        public final void run() {
            a();
        }
    }

    public static final class DebounceTimedSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -9102637559663639004L;
        public Subscription c;
        public Disposable d;
        public volatile long e;
        public boolean f;

        public final void cancel() {
            this.c.cancel();
            throw null;
        }

        public final void onComplete() {
            if (!this.f) {
                this.f = true;
                Disposable disposable = this.d;
                if (disposable != null) {
                    DisposableHelper.dispose((DebounceEmitter) disposable);
                }
                DebounceEmitter debounceEmitter = (DebounceEmitter) disposable;
                if (debounceEmitter != null) {
                    debounceEmitter.a();
                }
                throw null;
            }
        }

        public final void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.b(th);
                return;
            }
            this.f = true;
            Disposable disposable = this.d;
            if (disposable != null) {
                DisposableHelper.dispose((DebounceEmitter) disposable);
            }
            throw null;
        }

        public final void onNext(Object obj) {
            if (!this.f) {
                long j = this.e + 1;
                this.e = j;
                Disposable disposable = this.d;
                if (disposable != null) {
                    DisposableHelper.dispose((DebounceEmitter) disposable);
                }
                this.d = new DebounceEmitter(obj, j, this);
                throw null;
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                throw null;
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.a(this, j);
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        throw null;
    }
}
