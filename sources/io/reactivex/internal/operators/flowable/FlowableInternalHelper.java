package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.List;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableInternalHelper {

    public static final class BufferedReplayCallable<T> implements Callable<ConnectableFlowable<T>> {
        public final Object call() {
            throw null;
        }
    }

    public static final class BufferedTimedReplay<T> implements Callable<ConnectableFlowable<T>> {
        public final Object call() {
            throw null;
        }
    }

    public static final class FlatMapIntoIterable<T, U> implements Function<T, Publisher<U>> {
        public final Object apply(Object obj) {
            throw null;
        }
    }

    public static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {
        public final Object apply(Object obj) {
            throw null;
        }
    }

    public static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, Publisher<R>> {
        public final Object apply(Object obj) {
            throw null;
        }
    }

    public static final class ItemDelayFunction<T, U> implements Function<T, Publisher<T>> {
        public final Object apply(Object obj) {
            throw null;
        }
    }

    public static final class ReplayCallable<T> implements Callable<ConnectableFlowable<T>> {
        public final Object call() {
            throw null;
        }
    }

    public static final class ReplayFunction<T, R> implements Function<Flowable<T>, Publisher<R>> {
        public final Object apply(Object obj) {
            Flowable flowable = (Flowable) obj;
            throw null;
        }
    }

    public enum RequestMax implements Consumer<Subscription> {
        ;

        public void accept(Subscription subscription) throws Exception {
            subscription.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    public static final class SimpleBiGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        public final Object apply(Object obj, Object obj2) {
            Emitter emitter = (Emitter) obj2;
            throw null;
        }
    }

    public static final class SimpleGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        public final Object apply(Object obj, Object obj2) {
            Emitter emitter = (Emitter) obj2;
            throw null;
        }
    }

    public static final class SubscriberOnComplete<T> implements Action {
        public final void run() {
            throw null;
        }
    }

    public static final class SubscriberOnError<T> implements Consumer<Throwable> {
        public final void accept(Object obj) {
            Throwable th = (Throwable) obj;
            throw null;
        }
    }

    public static final class SubscriberOnNext<T> implements Consumer<T> {
        public final void accept(Object obj) {
            throw null;
        }
    }

    public static final class TimedReplay<T> implements Callable<ConnectableFlowable<T>> {
        public final Object call() {
            throw null;
        }
    }

    public static final class ZipIterableFunction<T, R> implements Function<List<Publisher<? extends T>>, Publisher<? extends R>> {
        public final Object apply(Object obj) {
            List list = (List) obj;
            int i = Flowable.c;
            ObjectHelper.b((Object) null, "zipper is null");
            throw null;
        }
    }
}
