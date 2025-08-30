package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableDebounce<T, U> extends AbstractFlowableWithUpstream<T, T> {

    public static final class DebounceSubscriber<T, U> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 6725975399620862591L;
        public final SerializedSubscriber c;
        public Subscription d;
        public final AtomicReference e = new AtomicReference();
        public volatile long f;
        public boolean g;

        public static final class DebounceInnerSubscriber<T, U> extends DisposableSubscriber<U> {
            public boolean d;

            public final void a() {
                throw null;
            }

            public final void onComplete() {
                if (!this.d) {
                    this.d = true;
                    a();
                }
            }

            public final void onError(Throwable th) {
                if (this.d) {
                    RxJavaPlugins.b(th);
                } else {
                    this.d = true;
                    throw null;
                }
            }

            public final void onNext(Object obj) {
                if (!this.d) {
                    this.d = true;
                    dispose();
                    a();
                }
            }
        }

        public DebounceSubscriber(SerializedSubscriber serializedSubscriber) {
            this.c = serializedSubscriber;
        }

        public final void cancel() {
            this.d.cancel();
            DisposableHelper.dispose(this.e);
        }

        public final void onComplete() {
            if (!this.g) {
                this.g = true;
                AtomicReference atomicReference = this.e;
                Disposable disposable = (Disposable) atomicReference.get();
                if (!DisposableHelper.isDisposed(disposable)) {
                    ((DebounceInnerSubscriber) disposable).a();
                    DisposableHelper.dispose(atomicReference);
                    this.c.onComplete();
                }
            }
        }

        public final void onError(Throwable th) {
            DisposableHelper.dispose(this.e);
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (!this.g) {
                this.f++;
                Disposable disposable = (Disposable) this.e.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                try {
                    throw null;
                } catch (Throwable th) {
                    Exceptions.a(th);
                    cancel();
                    this.c.onError(th);
                }
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                this.c.onSubscribe(this);
                subscription.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.a(this, j);
            }
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new DebounceSubscriber(new SerializedSubscriber(flowableSubscriber)));
    }
}
