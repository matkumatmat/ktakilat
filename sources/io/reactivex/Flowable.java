package io.reactivex;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.StrictSubscriber;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public abstract class Flowable<T> implements Publisher<T> {
    public static final int c = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public final void a(FlowableSubscriber flowableSubscriber) {
        ObjectHelper.b(flowableSubscriber, "s is null");
        try {
            b(flowableSubscriber);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.a(th);
            RxJavaPlugins.b(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public abstract void b(FlowableSubscriber flowableSubscriber);

    public final void d(Subscriber subscriber) {
        if (subscriber instanceof FlowableSubscriber) {
            a((FlowableSubscriber) subscriber);
            return;
        }
        ObjectHelper.b(subscriber, "s is null");
        a(new StrictSubscriber(subscriber));
    }
}
