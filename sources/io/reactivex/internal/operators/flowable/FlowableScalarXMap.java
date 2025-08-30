package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;

public final class FlowableScalarXMap {

    public static final class ScalarXMapFlowable<T, R> extends Flowable<R> {
        public final void b(FlowableSubscriber flowableSubscriber) {
            try {
                throw null;
            } catch (Throwable th) {
                EmptySubscription.error(th, flowableSubscriber);
            }
        }
    }

    public static boolean a(Publisher publisher, FlowableSubscriber flowableSubscriber) {
        if (!(publisher instanceof Callable)) {
            return false;
        }
        try {
            if (((Callable) publisher).call() == null) {
                EmptySubscription.complete(flowableSubscriber);
                return true;
            }
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                EmptySubscription.error(th, flowableSubscriber);
                return true;
            }
        } catch (Throwable th2) {
            Exceptions.a(th2);
            EmptySubscription.error(th2, flowableSubscriber);
            return true;
        }
    }
}
