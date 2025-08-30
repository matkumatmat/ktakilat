package org.reactivestreams;

import java.util.concurrent.Flow;

public final class FlowAdapters {

    public static final class FlowPublisherFromReactive<T> implements Flow.Publisher<T> {
        public final void subscribe(Flow.Subscriber subscriber) {
            throw null;
        }
    }

    public static final class FlowToReactiveProcessor<T, U> implements Flow.Processor<T, U> {
        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onNext(Object obj) {
            throw null;
        }

        public final void onSubscribe(Flow.Subscription subscription) {
            throw null;
        }

        public final void subscribe(Flow.Subscriber subscriber) {
            throw null;
        }
    }

    public static final class FlowToReactiveSubscriber<T> implements Flow.Subscriber<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Subscriber f840a;

        public FlowToReactiveSubscriber(Subscriber subscriber) {
            this.f840a = subscriber;
        }

        public final void onComplete() {
            this.f840a.onComplete();
        }

        public final void onError(Throwable th) {
            this.f840a.onError(th);
        }

        public final void onNext(Object obj) {
            this.f840a.onNext(obj);
        }

        public final void onSubscribe(Flow.Subscription subscription) {
            ReactiveToFlowSubscription reactiveToFlowSubscription;
            Subscriber subscriber = this.f840a;
            if (subscription == null) {
                reactiveToFlowSubscription = null;
            } else {
                reactiveToFlowSubscription = new ReactiveToFlowSubscription(subscription);
            }
            subscriber.onSubscribe(reactiveToFlowSubscription);
        }
    }

    public static final class FlowToReactiveSubscription implements Flow.Subscription {

        /* renamed from: a  reason: collision with root package name */
        public final Subscription f841a;

        public FlowToReactiveSubscription(Subscription subscription) {
            this.f841a = subscription;
        }

        public final void cancel() {
            this.f841a.cancel();
        }

        public final void request(long j) {
            this.f841a.request(j);
        }
    }

    public static final class ReactivePublisherFromFlow<T> implements Publisher<T> {
        public final void d(Subscriber subscriber) {
            Flow.Subscriber subscriber2;
            if (subscriber == null) {
                subscriber2 = null;
            } else {
                subscriber2 = new FlowToReactiveSubscriber(subscriber);
            }
            e.z(subscriber2);
            throw null;
        }
    }

    public static final class ReactiveToFlowProcessor<T, U> implements Processor<T, U> {
        public final void d(Subscriber subscriber) {
            Flow.Subscriber subscriber2;
            if (subscriber == null) {
                subscriber2 = null;
            } else {
                subscriber2 = new FlowToReactiveSubscriber(subscriber);
            }
            e.z(subscriber2);
            throw null;
        }

        public final void onComplete() {
            ba.w();
            throw null;
        }

        public final void onError(Throwable th) {
            e.y(th);
            throw null;
        }

        public final void onNext(Object obj) {
            e.x(obj);
            throw null;
        }

        public final void onSubscribe(Subscription subscription) {
            if (subscription != null) {
                new FlowToReactiveSubscription(subscription);
            }
            throw null;
        }
    }

    public static final class ReactiveToFlowSubscriber<T> implements Subscriber<T> {
        public final void onComplete() {
            throw null;
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onNext(Object obj) {
            throw null;
        }

        public final void onSubscribe(Subscription subscription) {
            throw null;
        }
    }

    public static final class ReactiveToFlowSubscription implements Subscription {
        public final Flow.Subscription c;

        public ReactiveToFlowSubscription(Flow.Subscription subscription) {
            this.c = subscription;
        }

        public final void cancel() {
            this.c.cancel();
        }

        public final void request(long j) {
            this.c.request(j);
        }
    }
}
