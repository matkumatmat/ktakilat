package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class MaybeMergeArray<T> extends Flowable<T> {

    public static final class ClqSimpleQueue<T> extends ConcurrentLinkedQueue<T> implements SimpleQueueWithConsumerIndex<T> {
        private static final long serialVersionUID = -4025173261791142821L;
        public int c;

        public final boolean offer(Object obj) {
            throw null;
        }

        public final Object poll() {
            Object poll = super.poll();
            if (poll != null) {
                this.c++;
            }
            return poll;
        }
    }

    public static final class MergeMaybeObserver<T> extends BasicIntQueueSubscription<T> implements MaybeObserver<T> {
        private static final long serialVersionUID = -660395290758764731L;
        public volatile boolean c;

        public final void cancel() {
            if (!this.c) {
                this.c = true;
                throw null;
            }
        }

        public final void clear() {
            throw null;
        }

        public final boolean isEmpty() {
            throw null;
        }

        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onSubscribe(Disposable disposable) {
            throw null;
        }

        public final void onSuccess(Object obj) {
            throw null;
        }

        public final Object poll() {
            throw null;
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.a((AtomicLong) null, j);
                throw null;
            }
        }

        public final int requestFusion(int i) {
            return (i & 2) != 0 ? 2 : 0;
        }
    }

    public static final class MpscFillOnceSimpleQueue<T> extends AtomicReferenceArray<T> implements SimpleQueueWithConsumerIndex<T> {
        private static final long serialVersionUID = -7969063454040569579L;
        public int c;

        public final void clear() {
            Object obj;
            int i = this.c;
            if (i == length()) {
                obj = null;
            } else {
                obj = get(i);
                obj.getClass();
                this.c = i + 1;
                lazySet(i, (Object) null);
            }
            if (obj != null) {
                throw null;
            }
        }

        public final boolean isEmpty() {
            throw null;
        }

        public final boolean offer(Object obj) {
            ObjectHelper.b(obj, "value is null");
            throw null;
        }

        public final Object poll() {
            int i = this.c;
            if (i == length()) {
                return null;
            }
            Object obj = get(i);
            obj.getClass();
            this.c = i + 1;
            lazySet(i, (Object) null);
            return obj;
        }
    }

    public interface SimpleQueueWithConsumerIndex<T> extends SimpleQueue<T> {
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        throw null;
    }
}
