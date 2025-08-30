package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class ObservableInternalHelper {

    public static final class BufferedReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        public final Observable c;
        public final int d;

        public BufferedReplayCallable(Observable observable, int i) {
            this.c = observable;
            this.d = i;
        }

        public final Object call() {
            return this.c.replay(this.d);
        }
    }

    public static final class BufferedTimedReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        public final Observable c;
        public final int d;
        public final long e;
        public final TimeUnit f;
        public final Scheduler g;

        public BufferedTimedReplayCallable(int i, long j, Observable observable, Scheduler scheduler, TimeUnit timeUnit) {
            this.c = observable;
            this.d = i;
            this.e = j;
            this.f = timeUnit;
            this.g = scheduler;
        }

        public final Object call() {
            return this.c.replay(this.d, this.e, this.f, this.g);
        }
    }

    public static final class FlatMapIntoIterable<T, U> implements Function<T, ObservableSource<U>> {
        public final Function c;

        public FlatMapIntoIterable(Function function) {
            this.c = function;
        }

        public final Object apply(Object obj) {
            Object apply = this.c.apply(obj);
            ObjectHelper.b(apply, "The mapper returned a null Iterable");
            return new ObservableFromIterable((Iterable) apply);
        }
    }

    public static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {
        public final BiFunction c;
        public final Object d;

        public FlatMapWithCombinerInner(Object obj, BiFunction biFunction) {
            this.c = biFunction;
            this.d = obj;
        }

        public final Object apply(Object obj) {
            return this.c.apply(this.d, obj);
        }
    }

    public static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, ObservableSource<R>> {
        public final BiFunction c;
        public final Function d;

        public FlatMapWithCombinerOuter(Function function, BiFunction biFunction) {
            this.c = biFunction;
            this.d = function;
        }

        public final Object apply(Object obj) {
            Object apply = this.d.apply(obj);
            ObjectHelper.b(apply, "The mapper returned a null ObservableSource");
            return new ObservableMap((ObservableSource) apply, new FlatMapWithCombinerInner(obj, this.c));
        }
    }

    public static final class ItemDelayFunction<T, U> implements Function<T, ObservableSource<T>> {
        public final Function c;

        public ItemDelayFunction(Function function) {
            this.c = function;
        }

        public final Object apply(Object obj) {
            Object apply = this.c.apply(obj);
            ObjectHelper.b(apply, "The itemDelay returned a null ObservableSource");
            return new ObservableTake((ObservableSource) apply, 1).map(Functions.h(obj)).defaultIfEmpty(obj);
        }
    }

    public enum MapToInt implements Function<Object, Object> {
        ;

        public final Object apply(Object obj) {
            return 0;
        }
    }

    public static final class ObserverOnComplete<T> implements Action {
        public final Observer c;

        public ObserverOnComplete(Observer observer) {
            this.c = observer;
        }

        public final void run() {
            this.c.onComplete();
        }
    }

    public static final class ObserverOnError<T> implements Consumer<Throwable> {
        public final Observer c;

        public ObserverOnError(Observer observer) {
            this.c = observer;
        }

        public final void accept(Object obj) {
            this.c.onError((Throwable) obj);
        }
    }

    public static final class ObserverOnNext<T> implements Consumer<T> {
        public final Observer c;

        public ObserverOnNext(Observer observer) {
            this.c = observer;
        }

        public final void accept(Object obj) {
            this.c.onNext(obj);
        }
    }

    public static final class ReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        public final Observable c;

        public ReplayCallable(Observable observable) {
            this.c = observable;
        }

        public final Object call() {
            return this.c.replay();
        }
    }

    public static final class ReplayFunction<T, R> implements Function<Observable<T>, ObservableSource<R>> {
        public final Function c;
        public final Scheduler d;

        public ReplayFunction(Function function, Scheduler scheduler) {
            this.c = function;
            this.d = scheduler;
        }

        public final Object apply(Object obj) {
            Object apply = this.c.apply((Observable) obj);
            ObjectHelper.b(apply, "The selector returned a null ObservableSource");
            return Observable.wrap((ObservableSource) apply).observeOn(this.d);
        }
    }

    public static final class SimpleBiGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        public final BiConsumer c;

        public SimpleBiGenerator(BiConsumer biConsumer) {
            this.c = biConsumer;
        }

        public final Object apply(Object obj, Object obj2) {
            this.c.accept(obj, (Emitter) obj2);
            return obj;
        }
    }

    public static final class SimpleGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        public final Consumer c;

        public SimpleGenerator(Consumer consumer) {
            this.c = consumer;
        }

        public final Object apply(Object obj, Object obj2) {
            this.c.accept((Emitter) obj2);
            return obj;
        }
    }

    public static final class TimedReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        public final Observable c;
        public final long d;
        public final TimeUnit e;
        public final Scheduler f;

        public TimedReplayCallable(Observable observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.c = observable;
            this.d = j;
            this.e = timeUnit;
            this.f = scheduler;
        }

        public final Object call() {
            return this.c.replay(this.d, this.e, this.f);
        }
    }

    public static final class ZipIterableFunction<T, R> implements Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> {
        public final Function c;

        public ZipIterableFunction(Function function) {
            this.c = function;
        }

        public final Object apply(Object obj) {
            return Observable.zipIterable((List) obj, this.c, false, Observable.bufferSize());
        }
    }

    public static Function a(Function function) {
        return new FlatMapIntoIterable(function);
    }

    public static Function b(Function function, BiFunction biFunction) {
        return new FlatMapWithCombinerOuter(function, biFunction);
    }

    public static Function c(Function function) {
        return new ItemDelayFunction(function);
    }

    public static Action d(Observer observer) {
        return new ObserverOnComplete(observer);
    }

    public static Consumer e(Observer observer) {
        return new ObserverOnError(observer);
    }

    public static Consumer f(Observer observer) {
        return new ObserverOnNext(observer);
    }

    public static Callable g(int i, long j, Observable observable, Scheduler scheduler, TimeUnit timeUnit) {
        return new BufferedTimedReplayCallable(i, j, observable, scheduler, timeUnit);
    }

    public static Callable h(Observable observable) {
        return new ReplayCallable(observable);
    }

    public static Callable i(Observable observable, int i) {
        return new BufferedReplayCallable(observable, i);
    }

    public static Callable j(Observable observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new TimedReplayCallable(observable, j, timeUnit, scheduler);
    }

    public static Function k(Function function, Scheduler scheduler) {
        return new ReplayFunction(function, scheduler);
    }

    public static BiFunction l(BiConsumer biConsumer) {
        return new SimpleBiGenerator(biConsumer);
    }

    public static BiFunction m(Consumer consumer) {
        return new SimpleGenerator(consumer);
    }

    public static Function n(Function function) {
        return new ZipIterableFunction(function);
    }
}
