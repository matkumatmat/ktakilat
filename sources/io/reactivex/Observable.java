package io.reactivex;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.observers.ForEachWhileObserver;
import io.reactivex.internal.observers.FutureObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.flowable.FlowableFromObservable;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest;
import io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableConcatMapSingle;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle;
import io.reactivex.internal.operators.observable.BlockingObservableIterable;
import io.reactivex.internal.operators.observable.BlockingObservableLatest;
import io.reactivex.internal.operators.observable.BlockingObservableMostRecent;
import io.reactivex.internal.operators.observable.BlockingObservableNext;
import io.reactivex.internal.operators.observable.ObservableAllSingle;
import io.reactivex.internal.operators.observable.ObservableAmb;
import io.reactivex.internal.operators.observable.ObservableAnySingle;
import io.reactivex.internal.operators.observable.ObservableBlockingSubscribe;
import io.reactivex.internal.operators.observable.ObservableBuffer;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary;
import io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableBufferExactBoundary;
import io.reactivex.internal.operators.observable.ObservableBufferTimed;
import io.reactivex.internal.operators.observable.ObservableCache;
import io.reactivex.internal.operators.observable.ObservableCollectSingle;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableConcatMapEager;
import io.reactivex.internal.operators.observable.ObservableConcatWithCompletable;
import io.reactivex.internal.operators.observable.ObservableConcatWithMaybe;
import io.reactivex.internal.operators.observable.ObservableConcatWithSingle;
import io.reactivex.internal.operators.observable.ObservableCountSingle;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableDebounce;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.internal.operators.observable.ObservableDefer;
import io.reactivex.internal.operators.observable.ObservableDelay;
import io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther;
import io.reactivex.internal.operators.observable.ObservableDematerialize;
import io.reactivex.internal.operators.observable.ObservableDetach;
import io.reactivex.internal.operators.observable.ObservableDistinct;
import io.reactivex.internal.operators.observable.ObservableDistinctUntilChanged;
import io.reactivex.internal.operators.observable.ObservableDoAfterNext;
import io.reactivex.internal.operators.observable.ObservableDoFinally;
import io.reactivex.internal.operators.observable.ObservableDoOnEach;
import io.reactivex.internal.operators.observable.ObservableDoOnLifecycle;
import io.reactivex.internal.operators.observable.ObservableElementAtMaybe;
import io.reactivex.internal.operators.observable.ObservableElementAtSingle;
import io.reactivex.internal.operators.observable.ObservableEmpty;
import io.reactivex.internal.operators.observable.ObservableError;
import io.reactivex.internal.operators.observable.ObservableFilter;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.observable.ObservableFlatMapMaybe;
import io.reactivex.internal.operators.observable.ObservableFlatMapSingle;
import io.reactivex.internal.operators.observable.ObservableFlattenIterable;
import io.reactivex.internal.operators.observable.ObservableFromArray;
import io.reactivex.internal.operators.observable.ObservableFromCallable;
import io.reactivex.internal.operators.observable.ObservableFromFuture;
import io.reactivex.internal.operators.observable.ObservableFromIterable;
import io.reactivex.internal.operators.observable.ObservableFromPublisher;
import io.reactivex.internal.operators.observable.ObservableFromUnsafeSource;
import io.reactivex.internal.operators.observable.ObservableGenerate;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.operators.observable.ObservableHide;
import io.reactivex.internal.operators.observable.ObservableIgnoreElements;
import io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable;
import io.reactivex.internal.operators.observable.ObservableInternalHelper;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableIntervalRange;
import io.reactivex.internal.operators.observable.ObservableJoin;
import io.reactivex.internal.operators.observable.ObservableJust;
import io.reactivex.internal.operators.observable.ObservableLastMaybe;
import io.reactivex.internal.operators.observable.ObservableLastSingle;
import io.reactivex.internal.operators.observable.ObservableLift;
import io.reactivex.internal.operators.observable.ObservableMap;
import io.reactivex.internal.operators.observable.ObservableMapNotification;
import io.reactivex.internal.operators.observable.ObservableMaterialize;
import io.reactivex.internal.operators.observable.ObservableMergeWithCompletable;
import io.reactivex.internal.operators.observable.ObservableMergeWithMaybe;
import io.reactivex.internal.operators.observable.ObservableMergeWithSingle;
import io.reactivex.internal.operators.observable.ObservableNever;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservableOnErrorNext;
import io.reactivex.internal.operators.observable.ObservableOnErrorReturn;
import io.reactivex.internal.operators.observable.ObservablePublish;
import io.reactivex.internal.operators.observable.ObservablePublishSelector;
import io.reactivex.internal.operators.observable.ObservableRange;
import io.reactivex.internal.operators.observable.ObservableRangeLong;
import io.reactivex.internal.operators.observable.ObservableReduceMaybe;
import io.reactivex.internal.operators.observable.ObservableReduceSeedSingle;
import io.reactivex.internal.operators.observable.ObservableReduceWithSingle;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import io.reactivex.internal.operators.observable.ObservableRepeat;
import io.reactivex.internal.operators.observable.ObservableRepeatUntil;
import io.reactivex.internal.operators.observable.ObservableRepeatWhen;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.operators.observable.ObservableRetryBiPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryWhen;
import io.reactivex.internal.operators.observable.ObservableSampleTimed;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.ObservableScan;
import io.reactivex.internal.operators.observable.ObservableScanSeed;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle;
import io.reactivex.internal.operators.observable.ObservableSerialized;
import io.reactivex.internal.operators.observable.ObservableSingleMaybe;
import io.reactivex.internal.operators.observable.ObservableSingleSingle;
import io.reactivex.internal.operators.observable.ObservableSkip;
import io.reactivex.internal.operators.observable.ObservableSkipLast;
import io.reactivex.internal.operators.observable.ObservableSkipLastTimed;
import io.reactivex.internal.operators.observable.ObservableSkipUntil;
import io.reactivex.internal.operators.observable.ObservableSkipWhile;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableSwitchIfEmpty;
import io.reactivex.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.internal.operators.observable.ObservableTake;
import io.reactivex.internal.operators.observable.ObservableTakeLast;
import io.reactivex.internal.operators.observable.ObservableTakeLastOne;
import io.reactivex.internal.operators.observable.ObservableTakeLastTimed;
import io.reactivex.internal.operators.observable.ObservableTakeUntil;
import io.reactivex.internal.operators.observable.ObservableTakeUntilPredicate;
import io.reactivex.internal.operators.observable.ObservableTakeWhile;
import io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed;
import io.reactivex.internal.operators.observable.ObservableThrottleLatest;
import io.reactivex.internal.operators.observable.ObservableTimeInterval;
import io.reactivex.internal.operators.observable.ObservableTimeout;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.internal.operators.observable.ObservableTimer;
import io.reactivex.internal.operators.observable.ObservableToList;
import io.reactivex.internal.operators.observable.ObservableToListSingle;
import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn;
import io.reactivex.internal.operators.observable.ObservableUsing;
import io.reactivex.internal.operators.observable.ObservableWindow;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableWindowTimed;
import io.reactivex.internal.operators.observable.ObservableWithLatestFrom;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany;
import io.reactivex.internal.operators.observable.ObservableZip;
import io.reactivex.internal.operators.observable.ObservableZipIterable;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.observers.SafeObserver;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.Timed;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

public abstract class Observable<T> implements ObservableSource<T> {

    /* renamed from: io.reactivex.Observable$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f657a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.reactivex.BackpressureStrategy[] r0 = io.reactivex.BackpressureStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f657a = r0
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.DROP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f657a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.LATEST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f657a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.MISSING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f657a     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.ERROR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.Observable.AnonymousClass1.<clinit>():void");
        }
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> amb(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.b(iterable, "sources is null");
        return new ObservableAmb((ObservableSource[]) null, iterable);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> ambArray(ObservableSource<? extends T>... observableSourceArr) {
        ObjectHelper.b(observableSourceArr, "sources is null");
        int length = observableSourceArr.length;
        if (length == 0) {
            return empty();
        }
        if (length == 1) {
            return wrap(observableSourceArr[0]);
        }
        return new ObservableAmb(observableSourceArr, (Iterable) null);
    }

    public static int bufferSize() {
        return Flowable.c;
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatest(Function<? super Object[], ? extends R> function, int i, ObservableSource<? extends T>... observableSourceArr) {
        return combineLatest(observableSourceArr, function, i);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatestDelayError(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function) {
        return combineLatestDelayError(observableSourceArr, function, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concat(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.b(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(Functions.f662a, bufferSize(), false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concatArray(ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        if (observableSourceArr.length == 1) {
            return wrap(observableSourceArr[0]);
        }
        return new ObservableConcatMap(fromArray(observableSourceArr), Functions.f662a, bufferSize(), ErrorMode.BOUNDARY);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concatArrayDelayError(ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        if (observableSourceArr.length == 1) {
            return wrap(observableSourceArr[0]);
        }
        return concatDelayError(fromArray(observableSourceArr));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concatArrayEager(ObservableSource<? extends T>... observableSourceArr) {
        return concatArrayEager(bufferSize(), bufferSize(), observableSourceArr);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concatDelayError(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.b(iterable, "sources is null");
        return concatDelayError(fromIterable(iterable));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concatEager(observableSource, bufferSize(), bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> create(ObservableOnSubscribe<T> observableOnSubscribe) {
        ObjectHelper.b(observableOnSubscribe, "source is null");
        return new ObservableCreate(observableOnSubscribe);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> defer(Callable<? extends ObservableSource<? extends T>> callable) {
        ObjectHelper.b(callable, "supplier is null");
        return new ObservableDefer(callable);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> empty() {
        return ObservableEmpty.c;
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> error(Callable<? extends Throwable> callable) {
        ObjectHelper.b(callable, "errorSupplier is null");
        return new ObservableError(callable);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> fromArray(T... tArr) {
        ObjectHelper.b(tArr, "items is null");
        if (tArr.length == 0) {
            return empty();
        }
        if (tArr.length == 1) {
            return just(tArr[0]);
        }
        return new ObservableFromArray(tArr);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> fromCallable(Callable<? extends T> callable) {
        ObjectHelper.b(callable, "supplier is null");
        return new ObservableFromCallable(callable);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> fromFuture(Future<? extends T> future) {
        ObjectHelper.b(future, "future is null");
        return new ObservableFromFuture(future, 0, (TimeUnit) null);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> fromIterable(Iterable<? extends T> iterable) {
        ObjectHelper.b(iterable, "source is null");
        return new ObservableFromIterable(iterable);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public static <T> Observable<T> fromPublisher(Publisher<? extends T> publisher) {
        ObjectHelper.b(publisher, "publisher is null");
        return new ObservableFromPublisher(publisher);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> generate(Consumer<Emitter<T>> consumer) {
        ObjectHelper.b(consumer, "generator  is null");
        return generate(Functions.h, ObservableInternalHelper.m(consumer), Functions.d);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public static Observable<Long> interval(long j, long j2, TimeUnit timeUnit) {
        return interval(j, j2, timeUnit, Schedulers.b);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public static Observable<Long> intervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit) {
        return intervalRange(j, j2, j3, j4, timeUnit, Schedulers.b);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t) {
        ObjectHelper.b(t, "The item is null");
        return new ObservableJust(t);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).flatMap(Functions.f662a, false, i, i2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeArray(int i, int i2, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.f662a, false, i, i2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeArrayDelayError(int i, int i2, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.f662a, true, i, i2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.f662a, true);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> never() {
        return ObservableNever.c;
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Observable<Integer> range(int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException(ba.k(i2, "count >= 0 required but it was "));
        } else if (i2 == 0) {
            return empty();
        } else {
            if (i2 == 1) {
                return just(Integer.valueOf(i));
            }
            if (((long) i) + ((long) (i2 - 1)) <= 2147483647L) {
                return new ObservableRange(i, i2);
            }
            throw new IllegalArgumentException("Integer overflow");
        }
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Observable<Long> rangeLong(long j, long j2) {
        int i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException(e.j(j2, "count >= 0 required but it was "));
        } else if (i == 0) {
            return empty();
        } else {
            if (j2 == 1) {
                return just(Long.valueOf(j));
            }
            long j3 = (j2 - 1) + j;
            if (j <= 0 || j3 >= 0) {
                return new ObservableRangeLong(j, j2);
            }
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        return sequenceEqual(observableSource, observableSource2, ObjectHelper.f666a, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i) {
        ObjectHelper.b(observableSource, "sources is null");
        ObjectHelper.c(i, "bufferSize");
        return new ObservableSwitchMap(observableSource, Functions.f662a, i, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return switchOnNextDelayError(observableSource, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public static Observable<Long> timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, Schedulers.b);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> unsafeCreate(ObservableSource<T> observableSource) {
        ObjectHelper.b(observableSource, "source is null");
        if (!(observableSource instanceof Observable)) {
            return new ObservableFromUnsafeSource(observableSource);
        }
        throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, D> Observable<T> using(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer) {
        return using(callable, function, consumer, true);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> wrap(ObservableSource<T> observableSource) {
        ObjectHelper.b(observableSource, "source is null");
        if (observableSource instanceof Observable) {
            return (Observable) observableSource;
        }
        return new ObservableFromUnsafeSource(observableSource);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> zip(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        ObjectHelper.b(function, "zipper is null");
        ObjectHelper.b(iterable, "sources is null");
        return new ObservableZip((ObservableSource[]) null, iterable, function, bufferSize(), false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> zipArray(Function<? super Object[], ? extends R> function, boolean z, int i, ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        ObjectHelper.b(function, "zipper is null");
        ObjectHelper.c(i, "bufferSize");
        return new ObservableZip(observableSourceArr, (Iterable) null, function, i, z);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> zipIterable(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, boolean z, int i) {
        ObjectHelper.b(function, "zipper is null");
        ObjectHelper.b(iterable, "sources is null");
        ObjectHelper.c(i, "bufferSize");
        return new ObservableZip((ObservableSource[]) null, iterable, function, i, z);
    }

    public final ObservableDoOnEach a(Consumer consumer, Consumer consumer2, Action action, Action action2) {
        ObjectHelper.b(consumer, "onNext is null");
        ObjectHelper.b(consumer2, "onError is null");
        ObjectHelper.b(action, "onComplete is null");
        ObjectHelper.b(action2, "onAfterTerminate is null");
        return new ObservableDoOnEach(this, consumer, consumer2, action, action2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<Boolean> all(Predicate<? super T> predicate) {
        ObjectHelper.b(predicate, "predicate is null");
        return new ObservableAllSingle(this, predicate);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> ambWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.b(observableSource, "other is null");
        return ambArray(this, observableSource);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<Boolean> any(Predicate<? super T> predicate) {
        ObjectHelper.b(predicate, "predicate is null");
        return new ObservableAnySingle(this, predicate);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final <R> R as(@NonNull ObservableConverter<T, ? extends R> observableConverter) {
        ObjectHelper.b(observableConverter, "converter is null");
        return observableConverter.apply();
    }

    public final ObservableTimeoutTimed b(long j, TimeUnit timeUnit, Scheduler scheduler, ObservableSource observableSource) {
        ObjectHelper.b(timeUnit, "timeUnit is null");
        ObjectHelper.b(scheduler, "scheduler is null");
        return new ObservableTimeoutTimed(this, j, timeUnit, scheduler, observableSource);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.concurrent.CountDownLatch, io.reactivex.internal.observers.BlockingBaseObserver, io.reactivex.Observer] */
    @CheckReturnValue
    @SchedulerSupport("none")
    public final T blockingFirst() {
        ? countDownLatch = new CountDownLatch(1);
        subscribe(countDownLatch);
        T a2 = countDownLatch.a();
        if (a2 != null) {
            return a2;
        }
        throw new NoSuchElementException();
    }

    @SchedulerSupport("none")
    public final void blockingForEach(Consumer<? super T> consumer) {
        Iterator it = blockingIterable().iterator();
        while (it.hasNext()) {
            try {
                consumer.accept(it.next());
            } catch (Throwable th) {
                Exceptions.a(th);
                ((Disposable) it).dispose();
                throw ExceptionHelper.c(th);
            }
        }
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.concurrent.CountDownLatch, io.reactivex.internal.observers.BlockingBaseObserver, io.reactivex.Observer] */
    @CheckReturnValue
    @SchedulerSupport("none")
    public final T blockingLast() {
        ? countDownLatch = new CountDownLatch(1);
        subscribe(countDownLatch);
        T a2 = countDownLatch.a();
        if (a2 != null) {
            return a2;
        }
        throw new NoSuchElementException();
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Iterable<T> blockingLatest() {
        return new BlockingObservableLatest(this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Iterable<T> blockingMostRecent(T t) {
        return new BlockingObservableMostRecent(this, t);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Iterable<T> blockingNext() {
        return new BlockingObservableNext(this);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.util.concurrent.CountDownLatch, io.reactivex.MaybeObserver, io.reactivex.internal.observers.BlockingMultiObserver] */
    @CheckReturnValue
    @SchedulerSupport("none")
    public final T blockingSingle() {
        Maybe singleElement = singleElement();
        singleElement.getClass();
        ? countDownLatch = new CountDownLatch(1);
        singleElement.b(countDownLatch);
        T a2 = countDownLatch.a();
        if (a2 != null) {
            return a2;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.concurrent.CountDownLatch, io.reactivex.functions.Action, io.reactivex.internal.util.BlockingIgnoringReceiver, io.reactivex.functions.Consumer] */
    @SchedulerSupport("none")
    public final void blockingSubscribe() {
        ? countDownLatch = new CountDownLatch(1);
        Consumer consumer = Functions.d;
        LambdaObserver lambdaObserver = new LambdaObserver(consumer, countDownLatch, countDownLatch, consumer);
        subscribe(lambdaObserver);
        if (countDownLatch.getCount() != 0) {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                lambdaObserver.dispose();
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e);
            }
        }
        Throwable th = countDownLatch.c;
        if (th != null) {
            throw ExceptionHelper.c(th);
        }
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<List<T>> buffer(long j, long j2, TimeUnit timeUnit) {
        return buffer(j, j2, timeUnit, Schedulers.b, ArrayListSupplier.asCallable());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> cache() {
        return ObservableCache.c(this, 16);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> cacheWithInitialCapacity(int i) {
        return ObservableCache.c(this, i);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<U> cast(Class<U> cls) {
        ObjectHelper.b(cls, "clazz is null");
        return map(Functions.b(cls));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Single<U> collect(Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        ObjectHelper.b(callable, "initialValueSupplier is null");
        ObjectHelper.b(biConsumer, "collector is null");
        return new ObservableCollectSingle(this, callable, biConsumer);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Single<U> collectInto(U u, BiConsumer<? super U, ? super T> biConsumer) {
        ObjectHelper.b(u, "initialValue is null");
        return collect(Functions.g(u), biConsumer);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> compose(ObservableTransformer<? super T, ? extends R> observableTransformer) {
        ObjectHelper.b(observableTransformer, "composer is null");
        return wrap(observableTransformer.a(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMap(function, 2);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        return concatMapCompletable(function, 2);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function) {
        return concatMapCompletableDelayError(function, true, 2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMapDelayError(function, bufferSize(), true);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMapEager(function, Integer.MAX_VALUE, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z) {
        return concatMapEagerDelayError(function, Integer.MAX_VALUE, bufferSize(), z);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.b(function, "mapper is null");
        return new ObservableFlattenIterable(this, function);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return concatMapMaybe(function, 2);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return concatMapMaybeDelayError(function, true, 2);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return concatMapSingle(function, 2);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return concatMapSingleDelayError(function, true, 2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> concatWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.b(observableSource, "other is null");
        return concat(this, (Observable) observableSource);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<Boolean> contains(Object obj) {
        ObjectHelper.b(obj, "element is null");
        return any(Functions.e(obj));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<Long> count() {
        return new ObservableCountSingle(this);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> debounce(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit, Schedulers.b);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> defaultIfEmpty(T t) {
        ObjectHelper.b(t, "defaultItem is null");
        return switchIfEmpty(just(t));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, Schedulers.b, false);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, Schedulers.b);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <T2> Observable<T2> dematerialize() {
        return new ObservableDematerialize(this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> distinct() {
        return distinct(Functions.f662a, Functions.d());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> distinctUntilChanged() {
        return distinctUntilChanged(Functions.f662a);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doAfterNext(Consumer<? super T> consumer) {
        ObjectHelper.b(consumer, "onAfterNext is null");
        return new ObservableDoAfterNext(this, consumer);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doAfterTerminate(Action action) {
        ObjectHelper.b(action, "onFinally is null");
        Consumer consumer = Functions.d;
        return a(consumer, consumer, Functions.c, action);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doFinally(Action action) {
        ObjectHelper.b(action, "onFinally is null");
        return new ObservableDoFinally(this, action);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doOnComplete(Action action) {
        Consumer consumer = Functions.d;
        return a(consumer, consumer, action, Functions.c);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doOnDispose(Action action) {
        return doOnLifecycle(Functions.d, action);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doOnEach(Consumer<? super Notification<T>> consumer) {
        ObjectHelper.b(consumer, "consumer is null");
        return a(Functions.m(consumer), Functions.l(consumer), Functions.k(consumer), Functions.c);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doOnError(Consumer<? super Throwable> consumer) {
        Consumer consumer2 = Functions.d;
        Action action = Functions.c;
        return a(consumer2, consumer, action, action);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doOnLifecycle(Consumer<? super Disposable> consumer, Action action) {
        ObjectHelper.b(consumer, "onSubscribe is null");
        ObjectHelper.b(action, "onDispose is null");
        return new ObservableDoOnLifecycle(this, consumer, action);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doOnNext(Consumer<? super T> consumer) {
        Consumer consumer2 = Functions.d;
        Action action = Functions.c;
        return a(consumer, consumer2, action, action);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doOnSubscribe(Consumer<? super Disposable> consumer) {
        return doOnLifecycle(consumer, Functions.c);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doOnTerminate(Action action) {
        ObjectHelper.b(action, "onTerminate is null");
        return a(Functions.d, Functions.a(action), action, Functions.c);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> elementAt(long j) {
        if (j >= 0) {
            return new ObservableElementAtMaybe(this, j);
        }
        throw new IndexOutOfBoundsException(e.j(j, "index >= 0 required but it was "));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<T> elementAtOrError(long j) {
        if (j >= 0) {
            return new ObservableElementAtSingle(this, j, (Object) null);
        }
        throw new IndexOutOfBoundsException(e.j(j, "index >= 0 required but it was "));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> filter(Predicate<? super T> predicate) {
        ObjectHelper.b(predicate, "predicate is null");
        return new ObservableFilter(this, predicate);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<T> first(T t) {
        return elementAt(0, t);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> firstElement() {
        return elementAt(0);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<T> firstOrError() {
        return elementAtOrError(0);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return flatMap(function, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        return flatMapCompletable(function, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.b(function, "mapper is null");
        return new ObservableFlattenIterable(this, function);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return flatMapMaybe(function, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return flatMapSingle(function, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Disposable forEach(Consumer<? super T> consumer) {
        return subscribe(consumer);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Disposable forEachWhile(Predicate<? super T> predicate) {
        return forEachWhile(predicate, Functions.e, Functions.c);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K> Observable<GroupedObservable<K, T>> groupBy(Function<? super T, ? extends K> function) {
        return groupBy(function, Functions.f662a, false, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <TRight, TLeftEnd, TRightEnd, R> Observable<R> groupJoin(ObservableSource<? extends TRight> observableSource, Function<? super T, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super T, ? super Observable<TRight>, ? extends R> biFunction) {
        ObjectHelper.b(observableSource, "other is null");
        ObjectHelper.b(function, "leftEnd is null");
        ObjectHelper.b(function2, "rightEnd is null");
        ObjectHelper.b(biFunction, "resultSelector is null");
        return new ObservableGroupJoin(this, observableSource, function, function2, biFunction);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> hide() {
        return new ObservableHide(this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable ignoreElements() {
        return new ObservableIgnoreElementsCompletable(this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<Boolean> isEmpty() {
        return all(Functions.g);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <TRight, TLeftEnd, TRightEnd, R> Observable<R> join(ObservableSource<? extends TRight> observableSource, Function<? super T, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super T, ? super TRight, ? extends R> biFunction) {
        ObjectHelper.b(observableSource, "other is null");
        ObjectHelper.b(function, "leftEnd is null");
        ObjectHelper.b(function2, "rightEnd is null");
        ObjectHelper.b(biFunction, "resultSelector is null");
        return new ObservableJoin(this, observableSource, function, function2, biFunction);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<T> last(T t) {
        ObjectHelper.b(t, "defaultItem is null");
        return new ObservableLastSingle(this, t);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> lastElement() {
        return new ObservableLastMaybe(this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<T> lastOrError() {
        return new ObservableLastSingle(this, (Object) null);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> lift(ObservableOperator<? extends R, ? super T> observableOperator) {
        ObjectHelper.b(observableOperator, "onLift is null");
        return new ObservableLift(this, observableOperator);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> map(Function<? super T, ? extends R> function) {
        ObjectHelper.b(function, "mapper is null");
        return new ObservableMap(this, function);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Notification<T>> materialize() {
        return new ObservableMaterialize(this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> mergeWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.b(observableSource, "other is null");
        return merge(this, (Observable) observableSource);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> observeOn(Scheduler scheduler) {
        return observeOn(scheduler, false, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<U> ofType(Class<U> cls) {
        ObjectHelper.b(cls, "clazz is null");
        return filter(Functions.f(cls)).cast(cls);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> onErrorResumeNext(Function<? super Throwable, ? extends ObservableSource<? extends T>> function) {
        ObjectHelper.b(function, "resumeFunction is null");
        return new ObservableOnErrorNext(this, function, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> onErrorReturn(Function<? super Throwable, ? extends T> function) {
        ObjectHelper.b(function, "valueSupplier is null");
        return new ObservableOnErrorReturn(this, function);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> onErrorReturnItem(T t) {
        ObjectHelper.b(t, "item is null");
        return onErrorReturn(Functions.h(t));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> onExceptionResumeNext(ObservableSource<? extends T> observableSource) {
        ObjectHelper.b(observableSource, "next is null");
        return new ObservableOnErrorNext(this, Functions.h(observableSource), true);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> onTerminateDetach() {
        return new ObservableDetach(this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final ConnectableObservable<T> publish() {
        return ObservablePublish.d(this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> reduce(BiFunction<T, T, T> biFunction) {
        ObjectHelper.b(biFunction, "reducer is null");
        return new ObservableReduceMaybe(this, biFunction);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Single<R> reduceWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.b(callable, "seedSupplier is null");
        ObjectHelper.b(biFunction, "reducer is null");
        return new ObservableReduceWithSingle(this, callable, biFunction);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> repeat() {
        return repeat(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> repeatUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.b(booleanSupplier, "stop is null");
        return new ObservableRepeatUntil(this, booleanSupplier);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> repeatWhen(Function<? super Observable<Object>, ? extends ObservableSource<?>> function) {
        ObjectHelper.b(function, "handler is null");
        return new ObservableRepeatWhen(this, function);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final ConnectableObservable<T> replay() {
        return ObservableReplay.f(this, ObservableReplay.g);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> retry() {
        return retry(LocationRequestCompat.PASSIVE_INTERVAL, Functions.f);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> retryUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.b(booleanSupplier, "stop is null");
        return retry(LocationRequestCompat.PASSIVE_INTERVAL, Functions.n(booleanSupplier));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> retryWhen(Function<? super Observable<Throwable>, ? extends ObservableSource<?>> function) {
        ObjectHelper.b(function, "handler is null");
        return new ObservableRetryWhen(this, function);
    }

    @SchedulerSupport("none")
    public final void safeSubscribe(Observer<? super T> observer) {
        ObjectHelper.b(observer, "s is null");
        if (observer instanceof SafeObserver) {
            subscribe(observer);
        } else {
            subscribe(new SafeObserver(observer));
        }
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> sample(long j, TimeUnit timeUnit) {
        return sample(j, timeUnit, Schedulers.b);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> scan(BiFunction<T, T, T> biFunction) {
        ObjectHelper.b(biFunction, "accumulator is null");
        return new ObservableScan(this, biFunction);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> scanWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.b(callable, "seedSupplier is null");
        ObjectHelper.b(biFunction, "accumulator is null");
        return new ObservableScanSeed(this, callable, biFunction);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> serialize() {
        return new ObservableSerialized(this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> share() {
        ConnectableObservable publish = publish();
        publish.getClass();
        return new ObservableRefCount(publish);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<T> single(T t) {
        ObjectHelper.b(t, "defaultItem is null");
        return new ObservableSingleSingle(this, t);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> singleElement() {
        return new ObservableSingleMaybe(this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<T> singleOrError() {
        return new ObservableSingleSingle(this, (Object) null);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> skip(long j) {
        return j <= 0 ? this : new ObservableSkip(this, j);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:trampoline")
    public final Observable<T> skipLast(long j, TimeUnit timeUnit) {
        return skipLast(j, timeUnit, Schedulers.d, false, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<T> skipUntil(ObservableSource<U> observableSource) {
        ObjectHelper.b(observableSource, "other is null");
        return new ObservableSkipUntil(this, observableSource);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> skipWhile(Predicate<? super T> predicate) {
        ObjectHelper.b(predicate, "predicate is null");
        return new ObservableSkipWhile(this, predicate);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> sorted() {
        Observable observable;
        Single list = toList();
        list.getClass();
        if (list instanceof FuseToObservable) {
            observable = ((FuseToObservable) list).a();
        } else {
            observable = new SingleToObservable(list);
        }
        return observable.map(Functions.i(Functions.j())).flatMapIterable(Functions.f662a);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> startWith(Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> startWithArray(T... tArr) {
        Observable fromArray = fromArray(tArr);
        if (fromArray == empty()) {
            return this;
        }
        return concatArray(fromArray, this);
    }

    @SchedulerSupport("none")
    public final Disposable subscribe() {
        Consumer consumer = Functions.d;
        return subscribe(consumer, Functions.e, Functions.c, consumer);
    }

    public abstract void subscribeActual(Observer observer);

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> subscribeOn(Scheduler scheduler) {
        ObjectHelper.b(scheduler, "scheduler is null");
        return new ObservableSubscribeOn(this, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <E extends Observer<? super T>> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> switchIfEmpty(ObservableSource<? extends T> observableSource) {
        ObjectHelper.b(observableSource, "other is null");
        return new ObservableSwitchIfEmpty(this, observableSource);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return switchMap(function, bufferSize());
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final Completable switchMapCompletable(@NonNull Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.b(function, "mapper is null");
        return new ObservableSwitchMapCompletable(this, function, false);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final Completable switchMapCompletableDelayError(@NonNull Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.b(function, "mapper is null");
        return new ObservableSwitchMapCompletable(this, function, true);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return switchMapDelayError(function, bufferSize());
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final <R> Observable<R> switchMapMaybe(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.b(function, "mapper is null");
        return new ObservableSwitchMapMaybe(this, function, false);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final <R> Observable<R> switchMapMaybeDelayError(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.b(function, "mapper is null");
        return new ObservableSwitchMapMaybe(this, function, true);
    }

    @CheckReturnValue
    @Experimental
    @NonNull
    @SchedulerSupport("none")
    public final <R> Observable<R> switchMapSingle(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.b(function, "mapper is null");
        return new ObservableSwitchMapSingle(this, function, false);
    }

    @CheckReturnValue
    @Experimental
    @NonNull
    @SchedulerSupport("none")
    public final <R> Observable<R> switchMapSingleDelayError(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.b(function, "mapper is null");
        return new ObservableSwitchMapSingle(this, function, true);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> take(long j) {
        if (j >= 0) {
            return new ObservableTake(this, j);
        }
        throw new IllegalArgumentException(e.j(j, "count >= 0 required but it was "));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:trampoline")
    public final Observable<T> takeLast(long j, long j2, TimeUnit timeUnit) {
        return takeLast(j, j2, timeUnit, Schedulers.d, false, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<T> takeUntil(ObservableSource<U> observableSource) {
        ObjectHelper.b(observableSource, "other is null");
        return new ObservableTakeUntil(this, observableSource);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> takeWhile(Predicate<? super T> predicate) {
        ObjectHelper.b(predicate, "predicate is null");
        return new ObservableTakeWhile(this, predicate);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final TestObserver<T> test() {
        TestObserver<T> testObserver = new TestObserver<>();
        subscribe(testObserver);
        return testObserver;
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> throttleFirst(long j, TimeUnit timeUnit) {
        return throttleFirst(j, timeUnit, Schedulers.b);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> throttleLast(long j, TimeUnit timeUnit) {
        return sample(j, timeUnit);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> throttleLatest(long j, TimeUnit timeUnit) {
        return throttleLatest(j, timeUnit, Schedulers.b, false);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> throttleWithTimeout(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Timed<T>> timeInterval(TimeUnit timeUnit) {
        return timeInterval(timeUnit, Schedulers.b);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> timeout(long j, TimeUnit timeUnit) {
        return b(j, timeUnit, Schedulers.b, (ObservableSource) null);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Timed<T>> timestamp(TimeUnit timeUnit) {
        return timestamp(timeUnit, Schedulers.b);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> R to(Function<? super Observable<T>, R> function) {
        try {
            ObjectHelper.b(function, "converter is null");
            return function.apply(this);
        } catch (Throwable th) {
            Exceptions.a(th);
            throw ExceptionHelper.c(th);
        }
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public final Flowable<T> toFlowable(BackpressureStrategy backpressureStrategy) {
        FlowableFromObservable flowableFromObservable = new FlowableFromObservable(this);
        int i = AnonymousClass1.f657a[backpressureStrategy.ordinal()];
        if (i == 1) {
            return new FlowableOnBackpressureDrop(flowableFromObservable);
        }
        if (i == 2) {
            return new FlowableOnBackpressureLatest(flowableFromObservable);
        }
        if (i == 3) {
            return flowableFromObservable;
        }
        if (i == 4) {
            return new FlowableOnBackpressureError(flowableFromObservable);
        }
        int i2 = Flowable.c;
        ObjectHelper.c(i2, "bufferSize");
        return new FlowableOnBackpressureBuffer(flowableFromObservable, i2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Future<T> toFuture() {
        return (Future) subscribeWith(new FutureObserver());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<List<T>> toList() {
        return toList(16);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K> Single<Map<K, T>> toMap(Function<? super T, ? extends K> function) {
        ObjectHelper.b(function, "keySelector is null");
        return collect(HashMapSupplier.asCallable(), Functions.x(function));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K> Single<Map<K, Collection<T>>> toMultimap(Function<? super T, ? extends K> function) {
        return toMultimap(function, Functions.f662a, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<List<T>> toSortedList() {
        return toSortedList(Functions.i);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.b(scheduler, "scheduler is null");
        return new ObservableUnsubscribeOn(this, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<Observable<T>> window(long j, long j2, TimeUnit timeUnit) {
        return window(j, j2, timeUnit, Schedulers.b, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, R> Observable<R> withLatestFrom(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.b(observableSource, "other is null");
        ObjectHelper.b(biFunction, "combiner is null");
        return new ObservableWithLatestFrom(this, biFunction, observableSource);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, R> Observable<R> zipWith(Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.b(iterable, "other is null");
        ObjectHelper.b(biFunction, "zipper is null");
        return new ObservableZipIterable(this, iterable, biFunction);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return combineLatest(iterable, function, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatestDelayError(Function<? super Object[], ? extends R> function, int i, ObservableSource<? extends T>... observableSourceArr) {
        return combineLatestDelayError(observableSourceArr, function, i);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concatArrayEager(int i, int i2, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).concatMapEagerDelayError(Functions.f662a, i, i2, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i, int i2) {
        return wrap(observableSource).concatMapEager(Functions.f662a, i, i2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.f662a);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeArray(ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.f662a, observableSourceArr.length);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeArrayDelayError(ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.f662a, true, observableSourceArr.length);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).flatMap(Functions.f662a, true, i, i2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
        return sequenceEqual(observableSource, observableSource2, biPredicate, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i) {
        ObjectHelper.b(observableSource, "sources is null");
        ObjectHelper.c(i, "prefetch");
        return new ObservableSwitchMap(observableSource, Functions.f662a, i, true);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, D> Observable<T> using(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        ObjectHelper.b(callable, "resourceSupplier is null");
        ObjectHelper.b(function, "sourceSupplier is null");
        ObjectHelper.b(consumer, "disposer is null");
        return new ObservableUsing(callable, function, consumer, z);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Iterable<T> blockingIterable(int i) {
        ObjectHelper.c(i, "bufferSize");
        return new BlockingObservableIterable(this, i);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i) {
        ObjectHelper.b(function, "mapper is null");
        ObjectHelper.c(i, "prefetch");
        if (!(this instanceof ScalarCallable)) {
            return new ObservableConcatMap(this, function, i, ErrorMode.IMMEDIATE);
        }
        Object call = ((ScalarCallable) this).call();
        if (call == null) {
            return empty();
        }
        return ObservableScalarXMap.a(call, function);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> function, int i) {
        ObjectHelper.b(function, "mapper is null");
        ObjectHelper.c(i, "capacityHint");
        return new ObservableConcatMapCompletable(this, function, ErrorMode.IMMEDIATE, i);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function, boolean z) {
        return concatMapCompletableDelayError(function, z, 2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i, boolean z) {
        ObjectHelper.b(function, "mapper is null");
        ObjectHelper.c(i, "prefetch");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call == null) {
                return empty();
            }
            return ObservableScalarXMap.a(call, function);
        }
        return new ObservableConcatMap(this, function, i, z ? ErrorMode.END : ErrorMode.BOUNDARY);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> function, int i, int i2) {
        ObjectHelper.b(function, "mapper is null");
        ObjectHelper.c(i, "maxConcurrency");
        ObjectHelper.c(i2, "prefetch");
        return new ObservableConcatMapEager(this, function, ErrorMode.IMMEDIATE, i, i2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i, int i2, boolean z) {
        ObjectHelper.b(function, "mapper is null");
        ObjectHelper.c(i, "maxConcurrency");
        ObjectHelper.c(i2, "prefetch");
        return new ObservableConcatMapEager(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i, i2);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, int i) {
        ObjectHelper.b(function, "mapper is null");
        ObjectHelper.c(i, "prefetch");
        return new ObservableConcatMapMaybe(this, function, ErrorMode.IMMEDIATE, i);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        return concatMapMaybeDelayError(function, z, 2);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, int i) {
        ObjectHelper.b(function, "mapper is null");
        ObjectHelper.c(i, "prefetch");
        return new ObservableConcatMapSingle(this, function, ErrorMode.IMMEDIATE, i);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        return concatMapSingleDelayError(function, z, 2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K> Observable<T> distinct(Function<? super T, K> function) {
        return distinct(function, Functions.d());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K> Observable<T> distinctUntilChanged(Function<? super T, K> function) {
        ObjectHelper.b(function, "keySelector is null");
        return new ObservableDistinctUntilChanged(this, function, ObjectHelper.f666a);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z) {
        return flatMap(function, z, Integer.MAX_VALUE);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function, boolean z) {
        ObjectHelper.b(function, "mapper is null");
        return new ObservableFlatMapCompletableCompletable(this, function, z);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        ObjectHelper.b(function, "mapper is null");
        return new ObservableFlatMapMaybe(this, function, z);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        ObjectHelper.b(function, "mapper is null");
        return new ObservableFlatMapSingle(this, function, z);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer) {
        return forEachWhile(predicate, consumer, Functions.c);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K> Observable<GroupedObservable<K, T>> groupBy(Function<? super T, ? extends K> function, boolean z) {
        return groupBy(function, Functions.f662a, z, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> observeOn(Scheduler scheduler, boolean z) {
        return observeOn(scheduler, z, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> publish(Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        ObjectHelper.b(function, "selector is null");
        return new ObservablePublishSelector(this, function);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> repeat(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException(e.j(j, "times >= 0 required but it was "));
        } else if (i == 0) {
            return empty();
        } else {
            return new ObservableRepeat(this, j);
        }
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i, long j, TimeUnit timeUnit) {
        return replay(function, i, j, timeUnit, Schedulers.b);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        ObjectHelper.b(biPredicate, "predicate is null");
        return new ObservableRetryBiPredicate(this, biPredicate);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> skip(long j, TimeUnit timeUnit) {
        return skipUntil(timer(j, timeUnit));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> startWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.b(observableSource, "other is null");
        return concatArray(observableSource, this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Disposable subscribe(Consumer<? super T> consumer) {
        return subscribe(consumer, Functions.e, Functions.c, Functions.d);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i) {
        ObjectHelper.b(function, "mapper is null");
        ObjectHelper.c(i, "bufferSize");
        if (!(this instanceof ScalarCallable)) {
            return new ObservableSwitchMap(this, function, i, false);
        }
        Object call = ((ScalarCallable) this).call();
        if (call == null) {
            return empty();
        }
        return ObservableScalarXMap.a(call, function);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i) {
        ObjectHelper.b(function, "mapper is null");
        ObjectHelper.c(i, "bufferSize");
        if (!(this instanceof ScalarCallable)) {
            return new ObservableSwitchMap(this, function, i, true);
        }
        Object call = ((ScalarCallable) this).call();
        if (call == null) {
            return empty();
        }
        return ObservableScalarXMap.a(call, function);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> throttleLast(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return sample(j, timeUnit, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> throttleWithTimeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return debounce(j, timeUnit, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<List<T>> toList(int i) {
        ObjectHelper.c(i, "capacityHint");
        return new ObservableToListSingle(this, i);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<List<T>> toSortedList(Comparator<? super T> comparator) {
        ObjectHelper.b(comparator, "comparator is null");
        Single list = toList();
        Function i = Functions.i(comparator);
        list.getClass();
        return new SingleMap(list, i);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i) {
        ObjectHelper.b(iterable, "sources is null");
        ObjectHelper.b(function, "combiner is null");
        ObjectHelper.c(i, "bufferSize");
        return new ObservableCombineLatest((ObservableSource[]) null, iterable, function, i << 1, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatestDelayError(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function, int i) {
        ObjectHelper.c(i, "bufferSize");
        ObjectHelper.b(function, "combiner is null");
        if (observableSourceArr.length == 0) {
            return empty();
        }
        return new ObservableCombineLatest(observableSourceArr, (Iterable) null, function, i << 1, true);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concat(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concat(observableSource, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concatDelayError(observableSource, bufferSize(), true);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concatEager(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return concatEager(iterable, bufferSize(), bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> error(Throwable th) {
        ObjectHelper.b(th, "e is null");
        return error((Callable<? extends Throwable>) Functions.g(th));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        ObjectHelper.b(future, "future is null");
        ObjectHelper.b(timeUnit, "unit is null");
        return new ObservableFromFuture(future, j, timeUnit);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public static Observable<Long> interval(long j, TimeUnit timeUnit) {
        return interval(j, j, timeUnit, Schedulers.b);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public static Observable<Long> intervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, Scheduler scheduler) {
        long j5 = j2;
        long j6 = j3;
        TimeUnit timeUnit2 = timeUnit;
        Scheduler scheduler2 = scheduler;
        int i = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException(e.j(j5, "count >= 0 required but it was "));
        } else if (i == 0) {
            return empty().delay(j6, timeUnit2, scheduler2);
        } else {
            long j7 = (j5 - 1) + j;
            if (j <= 0 || j7 >= 0) {
                ObjectHelper.b(timeUnit2, "unit is null");
                ObjectHelper.b(scheduler2, "scheduler is null");
                return new ObservableIntervalRange(j, j7, Math.max(0, j6), Math.max(0, j4), timeUnit, scheduler);
            }
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t, T t2) {
        ObjectHelper.b(t, "The first item is null");
        ObjectHelper.b(t2, "The second item is null");
        return fromArray(t, t2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable, int i) {
        return fromIterable(iterable).flatMap(Functions.f662a, i);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, int i) {
        return fromIterable(iterable).flatMap(Functions.f662a, true, i);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        ObjectHelper.b(biPredicate, "isEqual is null");
        ObjectHelper.c(i, "bufferSize");
        return new ObservableSequenceEqualSingle(observableSource, observableSource2, biPredicate, i);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public static Observable<Long> timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.b(timeUnit, "unit is null");
        ObjectHelper.b(scheduler, "scheduler is null");
        return new ObservableTimer(Math.max(j, 0), timeUnit, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<List<T>> buffer(long j, TimeUnit timeUnit) {
        return buffer(j, timeUnit, Schedulers.b, Integer.MAX_VALUE);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function, boolean z, int i) {
        ObjectHelper.b(function, "mapper is null");
        ObjectHelper.c(i, "prefetch");
        return new ObservableConcatMapCompletable(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, int i) {
        ObjectHelper.b(function, "mapper is null");
        ObjectHelper.c(i, "prefetch");
        return concatMap(ObservableInternalHelper.a(function), i);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i) {
        ObjectHelper.b(function, "mapper is null");
        ObjectHelper.c(i, "prefetch");
        return new ObservableConcatMapMaybe(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z, int i) {
        ObjectHelper.b(function, "mapper is null");
        ObjectHelper.c(i, "prefetch");
        return new ObservableConcatMapSingle(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final Observable<T> concatWith(@NonNull SingleSource<? extends T> singleSource) {
        ObjectHelper.b(singleSource, "other is null");
        return new ObservableConcatWithSingle(this, singleSource);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<T> debounce(Function<? super T, ? extends ObservableSource<U>> function) {
        ObjectHelper.b(function, "debounceSelector is null");
        return new ObservableDebounce(this, function);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> delay(long j, TimeUnit timeUnit, boolean z) {
        return delay(j, timeUnit, Schedulers.b, z);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<T> delaySubscription(ObservableSource<U> observableSource) {
        ObjectHelper.b(observableSource, "other is null");
        return new ObservableDelaySubscriptionOther(this, observableSource);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K> Observable<T> distinct(Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        ObjectHelper.b(function, "keySelector is null");
        ObjectHelper.b(callable, "collectionSupplier is null");
        return new ObservableDistinct(this, function, callable);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z, int i) {
        return flatMap(function, z, i, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, V> Observable<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        ObjectHelper.b(function, "mapper is null");
        ObjectHelper.b(biFunction, "resultSelector is null");
        return flatMap(ObservableInternalHelper.a(function), biFunction, false, bufferSize(), bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer, Action action) {
        ObjectHelper.b(predicate, "onNext is null");
        ObjectHelper.b(consumer, "onError is null");
        ObjectHelper.b(action, "onComplete is null");
        ForEachWhileObserver forEachWhileObserver = new ForEachWhileObserver(predicate, consumer, action);
        subscribe(forEachWhileObserver);
        return forEachWhileObserver;
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return groupBy(function, function2, false, bufferSize());
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final Observable<T> mergeWith(@NonNull SingleSource<? extends T> singleSource) {
        ObjectHelper.b(singleSource, "other is null");
        return new ObservableMergeWithSingle(this, singleSource);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> observeOn(Scheduler scheduler, boolean z, int i) {
        ObjectHelper.b(scheduler, "scheduler is null");
        ObjectHelper.c(i, "bufferSize");
        return new ObservableObserveOn(this, scheduler, z, i);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> onErrorResumeNext(ObservableSource<? extends T> observableSource) {
        ObjectHelper.b(observableSource, "next is null");
        return onErrorResumeNext(Functions.h(observableSource));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Single<R> reduce(R r, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.b(r, "seed is null");
        ObjectHelper.b(biFunction, "reducer is null");
        return new ObservableReduceSeedSingle(this, r, biFunction);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> sample(long j, TimeUnit timeUnit, boolean z) {
        return sample(j, timeUnit, Schedulers.b, z);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> scan(R r, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.b(r, "seed is null");
        return scanWith(Functions.g(r), biFunction);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> skip(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return skipUntil(timer(j, timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:trampoline")
    public final Observable<T> skipLast(long j, TimeUnit timeUnit, boolean z) {
        return skipLast(j, timeUnit, Schedulers.d, z, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return subscribe(consumer, consumer2, Functions.c, Functions.d);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:trampoline")
    public final Observable<T> takeLast(long j, TimeUnit timeUnit) {
        return takeLast(j, timeUnit, Schedulers.d, false, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> takeUntil(Predicate<? super T> predicate) {
        ObjectHelper.b(predicate, "predicate is null");
        return new ObservableTakeUntilPredicate(this, predicate);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final TestObserver<T> test(boolean z) {
        TestObserver<T> testObserver = new TestObserver<>();
        if (z) {
            testObserver.dispose();
        }
        subscribe(testObserver);
        return testObserver;
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> throttleFirst(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.b(timeUnit, "unit is null");
        ObjectHelper.b(scheduler, "scheduler is null");
        return new ObservableThrottleFirstTimed(this, j, timeUnit, scheduler);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> throttleLatest(long j, TimeUnit timeUnit, boolean z) {
        return throttleLatest(j, timeUnit, Schedulers.b, z);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Timed<T>> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, Schedulers.b);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <V> Observable<T> timeout(Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource) {
        ObjectHelper.b(observableSource, "other is null");
        ObjectHelper.b(function, "itemTimeoutIndicator is null");
        return new ObservableTimeout(this, (ObservableSource) null, function, observableSource);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Timed<T>> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, Schedulers.b);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        ObjectHelper.b(function, "keySelector is null");
        ObjectHelper.b(function2, "valueSelector is null");
        return collect(HashMapSupplier.asCallable(), Functions.y(function, function2));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit) {
        return window(j, timeUnit, Schedulers.b, (long) LocationRequestCompat.PASSIVE_INTERVAL, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concat(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i) {
        ObjectHelper.b(observableSource, "sources is null");
        ObjectHelper.c(i, "prefetch");
        return new ObservableConcatMap(observableSource, Functions.f662a, i, ErrorMode.IMMEDIATE);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i, boolean z) {
        ObjectHelper.b(observableSource, "sources is null");
        ObjectHelper.c(i, "prefetch is null");
        return new ObservableConcatMap(observableSource, Functions.f662a, i, z ? ErrorMode.END : ErrorMode.BOUNDARY);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concatEager(Iterable<? extends ObservableSource<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).concatMapEagerDelayError(Functions.f662a, i, i2, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> merge(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        ObjectHelper.b(observableSource, "sources is null");
        return new ObservableFlatMap(observableSource, Functions.f662a, false, Integer.MAX_VALUE, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        ObjectHelper.b(observableSource, "sources is null");
        return new ObservableFlatMap(observableSource, Functions.f662a, true, Integer.MAX_VALUE, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return switchOnNext(observableSource, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> zip(ObservableSource<? extends ObservableSource<? extends T>> observableSource, Function<? super Object[], ? extends R> function) {
        ObjectHelper.b(function, "zipper is null");
        ObjectHelper.b(observableSource, "sources is null");
        return new ObservableToList(observableSource).flatMap(ObservableInternalHelper.n(function));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> distinctUntilChanged(BiPredicate<? super T, ? super T> biPredicate) {
        ObjectHelper.b(biPredicate, "comparer is null");
        return new ObservableDistinctUntilChanged(this, Functions.f662a, biPredicate);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z, int i, int i2) {
        ObjectHelper.b(function, "mapper is null");
        ObjectHelper.c(i, "maxConcurrency");
        ObjectHelper.c(i2, "bufferSize");
        if (!(this instanceof ScalarCallable)) {
            return new ObservableFlatMap(this, function, z, i, i2);
        }
        Object call = ((ScalarCallable) this).call();
        if (call == null) {
            return empty();
        }
        return ObservableScalarXMap.a(call, function);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z) {
        return groupBy(function, function2, z, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, long j, TimeUnit timeUnit) {
        return replay(function, j, timeUnit, Schedulers.b);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> retry(long j) {
        return retry(j, Functions.f);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> startWith(T t) {
        ObjectHelper.b(t, "item is null");
        return concatArray(just(t), this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        return subscribe(consumer, consumer2, action, Functions.d);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U extends Collection<? super T>> Single<U> toList(Callable<U> callable) {
        ObjectHelper.b(callable, "collectionSupplier is null");
        return new ObservableToListSingle(this, (Callable) callable);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <T1, T2, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, Function3<? super T, ? super T1, ? super T2, R> function3) {
        ObjectHelper.b(observableSource, "o1 is null");
        ObjectHelper.b(observableSource2, "o2 is null");
        ObjectHelper.b(function3, "combiner is null");
        return withLatestFrom((ObservableSource<?>[]) new ObservableSource[]{observableSource, observableSource2}, Functions.q(function3));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.b(observableSource, "other is null");
        return zip(this, observableSource, biFunction);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, S> Observable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer) {
        ObjectHelper.b(biConsumer, "generator  is null");
        return generate(callable, ObservableInternalHelper.l(biConsumer), Functions.d);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public static Observable<Long> interval(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.b(timeUnit, "unit is null");
        ObjectHelper.b(scheduler, "scheduler is null");
        return new ObservableInterval(Math.max(0, j), Math.max(0, j2), timeUnit, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<List<T>> buffer(long j, TimeUnit timeUnit, int i) {
        return buffer(j, timeUnit, Schedulers.b, i);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final Observable<T> concatWith(@NonNull MaybeSource<? extends T> maybeSource) {
        ObjectHelper.b(maybeSource, "other is null");
        return new ObservableConcatWithMaybe(this, maybeSource);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> debounce(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.b(timeUnit, "unit is null");
        ObjectHelper.b(scheduler, "scheduler is null");
        return new ObservableDebounceTimed(this, j, timeUnit, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<T> delay(Function<? super T, ? extends ObservableSource<U>> function) {
        ObjectHelper.b(function, "itemDelay is null");
        return flatMap(ObservableInternalHelper.c(function));
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> delaySubscription(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delaySubscription(timer(j, timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z, int i) {
        ObjectHelper.b(function, "keySelector is null");
        ObjectHelper.b(function2, "valueSelector is null");
        ObjectHelper.c(i, "bufferSize");
        return new ObservableGroupBy(this, function, function2, i, z);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final Observable<T> mergeWith(@NonNull MaybeSource<? extends T> maybeSource) {
        ObjectHelper.b(maybeSource, "other is null");
        return new ObservableMergeWithMaybe(this, maybeSource);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> retry(long j, Predicate<? super Throwable> predicate) {
        if (j >= 0) {
            ObjectHelper.b(predicate, "predicate is null");
            return new ObservableRetryPredicate(this, j, predicate);
        }
        throw new IllegalArgumentException(e.j(j, "times >= 0 required but it was "));
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> sample(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.b(timeUnit, "unit is null");
        ObjectHelper.b(scheduler, "scheduler is null");
        return new ObservableSampleTimed(this, j, timeUnit, scheduler, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> skipLast(int i) {
        if (i >= 0) {
            return i == 0 ? this : new ObservableSkipLast(this, i);
        }
        throw new IndexOutOfBoundsException(ba.k(i, "count >= 0 required but it was "));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Disposable> consumer3) {
        ObjectHelper.b(consumer, "onNext is null");
        ObjectHelper.b(consumer2, "onError is null");
        ObjectHelper.b(action, "onComplete is null");
        ObjectHelper.b(consumer3, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(consumer, consumer2, action, consumer3);
        subscribe(lambdaObserver);
        return lambdaObserver;
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:trampoline")
    public final Observable<T> takeLast(long j, TimeUnit timeUnit, boolean z) {
        return takeLast(j, timeUnit, Schedulers.d, z, bufferSize());
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("custom")
    public final Observable<T> throttleLatest(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return throttleLatest(j, timeUnit, scheduler, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return toMultimap(function, function2, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<List<T>> toSortedList(Comparator<? super T> comparator, int i) {
        ObjectHelper.b(comparator, "comparator is null");
        Single list = toList(i);
        Function i2 = Functions.i(comparator);
        list.getClass();
        return new SingleMap(list, i2);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit, long j2) {
        return window(j, timeUnit, Schedulers.b, j2, false);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public static <T> Observable<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.b(scheduler, "scheduler is null");
        return fromFuture(future, j, timeUnit).subscribeOn(scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t, T t2, T t3) {
        ObjectHelper.b(t, "The first item is null");
        ObjectHelper.b(t2, "The second item is null");
        ObjectHelper.b(t3, "The third item is null");
        return fromArray(t, t2, t3);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> merge(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i) {
        ObjectHelper.b(observableSource, "sources is null");
        ObjectHelper.c(i, "maxConcurrency");
        return new ObservableFlatMap(observableSource, Functions.f662a, false, i, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i) {
        ObjectHelper.b(observableSource, "sources is null");
        ObjectHelper.c(i, "maxConcurrency");
        return new ObservableFlatMap(observableSource, Functions.f662a, true, i, bufferSize());
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.concurrent.CountDownLatch, io.reactivex.internal.observers.BlockingBaseObserver, io.reactivex.Observer] */
    @CheckReturnValue
    @SchedulerSupport("none")
    public final T blockingFirst(T t) {
        ? countDownLatch = new CountDownLatch(1);
        subscribe(countDownLatch);
        T a2 = countDownLatch.a();
        return a2 != null ? a2 : t;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.concurrent.CountDownLatch, io.reactivex.internal.observers.BlockingBaseObserver, io.reactivex.Observer] */
    @CheckReturnValue
    @SchedulerSupport("none")
    public final T blockingLast(T t) {
        ? countDownLatch = new CountDownLatch(1);
        subscribe(countDownLatch);
        T a2 = countDownLatch.a();
        return a2 != null ? a2 : t;
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doOnEach(Observer<? super T> observer) {
        ObjectHelper.b(observer, "observer is null");
        return a(ObservableInternalHelper.f(observer), ObservableInternalHelper.e(observer), ObservableInternalHelper.d(observer), Functions.c);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final ConnectableObservable<T> replay(int i, long j, TimeUnit timeUnit) {
        return replay(i, j, timeUnit, Schedulers.b);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> sorted(Comparator<? super T> comparator) {
        Observable observable;
        ObjectHelper.b(comparator, "sortFunction is null");
        Single list = toList();
        list.getClass();
        if (list instanceof FuseToObservable) {
            observable = ((FuseToObservable) list).a();
        } else {
            observable = new SingleToObservable(list);
        }
        return observable.map(Functions.i(comparator)).flatMapIterable(Functions.f662a);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("custom")
    public final Observable<T> throttleLatest(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        ObjectHelper.b(timeUnit, "unit is null");
        ObjectHelper.b(scheduler, "scheduler is null");
        return new ObservableThrottleLatest(this, j, timeUnit, scheduler, z);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Timed<T>> timeInterval(Scheduler scheduler) {
        return timeInterval(TimeUnit.MILLISECONDS, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> timeout(long j, TimeUnit timeUnit, ObservableSource<? extends T> observableSource) {
        ObjectHelper.b(observableSource, "other is null");
        return b(j, timeUnit, Schedulers.b, observableSource);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Timed<T>> timestamp(Scheduler scheduler) {
        return timestamp(TimeUnit.MILLISECONDS, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, V>> callable) {
        ObjectHelper.b(function, "keySelector is null");
        ObjectHelper.b(function2, "valueSelector is null");
        ObjectHelper.b(callable, "mapSupplier is null");
        return collect(callable, Functions.y(function, function2));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        return zip(this, observableSource, biFunction, z);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatest(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function) {
        return combineLatest(observableSourceArr, function, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        return concatArray(observableSource, observableSource2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, S> Observable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer, Consumer<? super S> consumer) {
        ObjectHelper.b(biConsumer, "generator  is null");
        return generate(callable, ObservableInternalHelper.l(biConsumer), consumer);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.concurrent.CountDownLatch, io.reactivex.internal.observers.BlockingMultiObserver, io.reactivex.SingleObserver] */
    @CheckReturnValue
    @SchedulerSupport("none")
    public final T blockingSingle(T t) {
        Single single = single(t);
        single.getClass();
        ? countDownLatch = new CountDownLatch(1);
        single.b(countDownLatch);
        return countDownLatch.a();
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<List<T>> buffer(int i) {
        return buffer(i, i);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final Observable<T> concatWith(@NonNull CompletableSource completableSource) {
        ObjectHelper.b(completableSource, "other is null");
        return new ObservableConcatWithCompletable(this, completableSource);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delay(j, timeUnit, scheduler, false);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final Observable<T> mergeWith(@NonNull CompletableSource completableSource) {
        ObjectHelper.b(completableSource, "other is null");
        return new ObservableMergeWithCompletable(this, completableSource);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> takeLast(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(ba.k(i, "count >= 0 required but it was "));
        } else if (i == 0) {
            return new ObservableIgnoreElements(this);
        } else {
            if (i == 1) {
                return new ObservableTakeLastOne(this);
            }
            return new ObservableTakeLast(this, i);
        }
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Timed<T>> timeInterval(TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.b(timeUnit, "unit is null");
        ObjectHelper.b(scheduler, "scheduler is null");
        return new ObservableTimeInterval(this, timeUnit, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Timed<T>> timestamp(TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.b(timeUnit, "unit is null");
        ObjectHelper.b(scheduler, "scheduler is null");
        return map(Functions.o(timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit, long j2, boolean z) {
        return window(j, timeUnit, Schedulers.b, j2, z);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i) {
        return zip(this, observableSource, biFunction, z, i);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatest(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function, int i) {
        ObjectHelper.b(observableSourceArr, "sources is null");
        if (observableSourceArr.length == 0) {
            return empty();
        }
        ObjectHelper.b(function, "combiner is null");
        ObjectHelper.c(i, "bufferSize");
        return new ObservableCombineLatest(observableSourceArr, (Iterable) null, function, i << 1, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return combineLatestDelayError(iterable, function, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public static Observable<Long> interval(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return interval(j, j, timeUnit, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, int i) {
        return sequenceEqual(observableSource, observableSource2, ObjectHelper.f666a, i);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        return zipArray(Functions.p(biFunction), false, bufferSize(), observableSource, observableSource2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<List<T>> buffer(int i, int i2) {
        return buffer(i, i2, ArrayListSupplier.asCallable());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        ObjectHelper.b(timeUnit, "unit is null");
        ObjectHelper.b(scheduler, "scheduler is null");
        return new ObservableDelay(this, j, timeUnit, scheduler, z);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final ConnectableObservable<T> replay(long j, TimeUnit timeUnit) {
        return replay(j, timeUnit, Schedulers.b);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> sample(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        ObjectHelper.b(timeUnit, "unit is null");
        ObjectHelper.b(scheduler, "scheduler is null");
        return new ObservableSampleTimed(this, j, timeUnit, scheduler, z);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, Collection<V>>> callable, Function<? super K, ? extends Collection<? super V>> function3) {
        ObjectHelper.b(function, "keySelector is null");
        ObjectHelper.b(function2, "valueSelector is null");
        ObjectHelper.b(callable, "mapSupplier is null");
        ObjectHelper.b(function3, "collectionFactory is null");
        return collect(callable, Functions.z(function, function2, function3));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<List<T>> toSortedList(int i) {
        return toSortedList(Functions.i, i);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i) {
        ObjectHelper.b(iterable, "sources is null");
        ObjectHelper.b(function, "combiner is null");
        ObjectHelper.c(i, "bufferSize");
        return new ObservableCombineLatest((ObservableSource[]) null, iterable, function, i << 1, true);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public static <T> Observable<T> fromFuture(Future<? extends T> future, Scheduler scheduler) {
        ObjectHelper.b(scheduler, "scheduler is null");
        return fromFuture(future).subscribeOn(scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, S> Observable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction) {
        return generate(callable, biFunction, Functions.d);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        return fromArray(observableSource, observableSource2).flatMap(Functions.f662a, false, 2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        return fromArray(observableSource, observableSource2).flatMap(Functions.f662a, true, 2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U extends Collection<? super T>> Observable<U> buffer(int i, int i2, Callable<U> callable) {
        ObjectHelper.c(i, "count");
        ObjectHelper.c(i2, "skip");
        ObjectHelper.b(callable, "bufferSupplier is null");
        return new ObservableBuffer(this, i, i2, callable);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<T> elementAt(long j, T t) {
        if (j >= 0) {
            ObjectHelper.b(t, "defaultItem is null");
            return new ObservableElementAtSingle(this, j, t);
        }
        throw new IndexOutOfBoundsException(e.j(j, "index >= 0 required but it was "));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> take(long j, TimeUnit timeUnit) {
        return takeUntil(timer(j, timeUnit));
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler, ObservableSource<? extends T> observableSource) {
        ObjectHelper.b(observableSource, "other is null");
        return b(j, timeUnit, scheduler, observableSource);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Observable<T>> window(long j) {
        return window(j, j, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <T1, T2, T3, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, ObservableSource<T3> observableSource3, Function4<? super T, ? super T1, ? super T2, ? super T3, R> function4) {
        ObjectHelper.b(observableSource, "o1 is null");
        ObjectHelper.b(observableSource2, "o2 is null");
        ObjectHelper.b(observableSource3, "o3 is null");
        ObjectHelper.b(function4, "combiner is null");
        return withLatestFrom((ObservableSource<?>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3}, Functions.r(function4));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        ObjectHelper.b(observableSource3, "source3 is null");
        return concatArray(observableSource, observableSource2, observableSource3);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, S> Observable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        ObjectHelper.b(callable, "initialState is null");
        ObjectHelper.b(biFunction, "generator  is null");
        ObjectHelper.b(consumer, "disposeState is null");
        return new ObservableGenerate(callable, biFunction, consumer);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t, T t2, T t3, T t4) {
        ObjectHelper.b(t, "The first item is null");
        ObjectHelper.b(t2, "The second item is null");
        ObjectHelper.b(t3, "The third item is null");
        ObjectHelper.b(t4, "The fourth item is null");
        return fromArray(t, t2, t3, t4);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        ObjectHelper.b(function, "selector is null");
        return ObservableReplay.g(function, ObservableInternalHelper.h(this));
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> take(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return takeUntil(timer(j, timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Observable<T>> window(long j, long j2) {
        return window(j, j2, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        return zipArray(Functions.p(biFunction), z, bufferSize(), observableSource, observableSource2);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [io.reactivex.functions.Function, io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<V>>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.SchedulerSupport("none")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <U, V> io.reactivex.Observable<T> delay(io.reactivex.ObservableSource<U> r1, io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<V>> r2) {
        /*
            r0 = this;
            io.reactivex.Observable r1 = r0.delaySubscription(r1)
            io.reactivex.Observable r1 = r1.delay(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.Observable.delay(io.reactivex.ObservableSource, io.reactivex.functions.Function):io.reactivex.Observable");
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<T> sample(ObservableSource<U> observableSource) {
        ObjectHelper.b(observableSource, "sampler is null");
        return new ObservableSampleWithObservable(this, observableSource, false);
    }

    @SchedulerSupport("none")
    public final void subscribe(Observer<? super T> observer) {
        ObjectHelper.b(observer, "observer is null");
        try {
            subscribeActual(observer);
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

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return b(j, timeUnit, scheduler, (ObservableSource) null);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Observable<T>> window(long j, long j2, int i) {
        ObjectHelper.d(j, "count");
        ObjectHelper.d(j2, "skip");
        ObjectHelper.c(i, "bufferSize");
        return new ObservableWindow(this, j, j2, i);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        ObjectHelper.b(observableSource3, "source3 is null");
        return fromArray(observableSource, observableSource2, observableSource3).flatMap(Functions.f662a, false, 3);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        ObjectHelper.b(observableSource3, "source3 is null");
        return fromArray(observableSource, observableSource2, observableSource3).flatMap(Functions.f662a, true, 3);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
        ObjectHelper.b(function, "onNextMapper is null");
        ObjectHelper.b(function2, "onErrorMapper is null");
        ObjectHelper.b(callable, "onCompleteSupplier is null");
        return merge(new ObservableMapNotification(this, function, function2, callable));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i) {
        ObjectHelper.b(function, "selector is null");
        ObjectHelper.c(i, "bufferSize");
        return ObservableReplay.g(function, ObservableInternalHelper.i(this, i));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, V> Observable<T> timeout(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function) {
        ObjectHelper.b(observableSource, "firstTimeoutIndicator is null");
        ObjectHelper.b(function, "itemTimeoutIndicator is null");
        return new ObservableTimeout(this, observableSource, function, (ObservableSource) null);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer) {
        ObservableBlockingSubscribe.b(this, consumer, Functions.e, Functions.c);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U extends Collection<? super T>> Observable<U> buffer(int i, Callable<U> callable) {
        return buffer(i, i, callable);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<T> sample(ObservableSource<U> observableSource, boolean z) {
        ObjectHelper.b(observableSource, "sampler is null");
        return new ObservableSampleWithObservable(this, observableSource, z);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> skipLast(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return skipLast(j, timeUnit, scheduler, false, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<Map<K, Collection<V>>> callable) {
        return toMultimap(function, function2, callable, ArrayListSupplier.asFunction());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        return combineLatest(Functions.p(biFunction), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2});
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        ObjectHelper.b(observableSource3, "source3 is null");
        ObjectHelper.b(observableSource4, "source4 is null");
        return concatArray(observableSource, observableSource2, observableSource3, observableSource4);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z, int i) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        return zipArray(Functions.p(biFunction), z, i, observableSource, observableSource2);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        ObservableBlockingSubscribe.b(this, consumer, consumer2, Functions.c);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<List<T>> buffer(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return buffer(j, j2, timeUnit, scheduler, ArrayListSupplier.asCallable());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> retry(Predicate<? super Throwable> predicate) {
        return retry(LocationRequestCompat.PASSIVE_INTERVAL, predicate);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> skipLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return skipLast(j, timeUnit, scheduler, z, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5) {
        ObjectHelper.b(t, "The first item is null");
        ObjectHelper.b(t2, "The second item is null");
        ObjectHelper.b(t3, "The third item is null");
        ObjectHelper.b(t4, "The fourth item is null");
        ObjectHelper.b(t5, "The fifth item is null");
        return fromArray(t, t2, t3, t4, t5);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        ObservableBlockingSubscribe.b(this, consumer, consumer2, action);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final <U extends Collection<? super T>> Observable<U> buffer(long j, long j2, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable) {
        TimeUnit timeUnit2 = timeUnit;
        ObjectHelper.b(timeUnit2, "unit is null");
        Scheduler scheduler2 = scheduler;
        ObjectHelper.b(scheduler2, "scheduler is null");
        Callable<U> callable2 = callable;
        ObjectHelper.b(callable2, "bufferSupplier is null");
        return new ObservableBufferTimed(this, j, j2, timeUnit2, scheduler2, callable2, Integer.MAX_VALUE, false);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.b(function, "selector is null");
        ObjectHelper.c(i, "bufferSize");
        ObjectHelper.b(timeUnit, "unit is null");
        ObjectHelper.b(scheduler, "scheduler is null");
        return ObservableReplay.g(function, ObservableInternalHelper.g(i, j, this, scheduler, timeUnit));
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> skipLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i) {
        ObjectHelper.b(timeUnit, "unit is null");
        ObjectHelper.b(scheduler, "scheduler is null");
        ObjectHelper.c(i, "bufferSize");
        return new ObservableSkipLastTimed(this, j, timeUnit, scheduler, i << 1, z);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, V> Observable<T> timeout(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.b(observableSource, "firstTimeoutIndicator is null");
        ObjectHelper.b(observableSource2, "other is null");
        ObjectHelper.b(function, "itemTimeoutIndicator is null");
        return new ObservableTimeout(this, observableSource, function, observableSource2);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<Observable<T>> window(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return window(j, j2, timeUnit, scheduler, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, ObservableSource<T3> observableSource3, ObservableSource<T4> observableSource4, Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> function5) {
        ObjectHelper.b(observableSource, "o1 is null");
        ObjectHelper.b(observableSource2, "o2 is null");
        ObjectHelper.b(observableSource3, "o3 is null");
        ObjectHelper.b(observableSource4, "o4 is null");
        ObjectHelper.b(function5, "combiner is null");
        return withLatestFrom((ObservableSource<?>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4}, Functions.s(function5));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        ObjectHelper.b(observableSource3, "source3 is null");
        ObjectHelper.b(observableSource4, "source4 is null");
        return fromArray(observableSource, observableSource2, observableSource3, observableSource4).flatMap(Functions.f662a, false, 4);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        ObjectHelper.b(observableSource3, "source3 is null");
        ObjectHelper.b(observableSource4, "source4 is null");
        return fromArray(observableSource, observableSource2, observableSource3, observableSource4).flatMap(Functions.f662a, true, 4);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Observer<? super T> observer) {
        ObservableBlockingSubscribe.a(this, observer);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, Function<Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable, int i) {
        ObjectHelper.b(function, "onNextMapper is null");
        ObjectHelper.b(function2, "onErrorMapper is null");
        ObjectHelper.b(callable, "onCompleteSupplier is null");
        return merge(new ObservableMapNotification(this, function, function2, callable), i);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<Observable<T>> window(long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i) {
        ObjectHelper.d(j, "timespan");
        long j3 = j2;
        ObjectHelper.d(j3, "timeskip");
        int i2 = i;
        ObjectHelper.c(i2, "bufferSize");
        Scheduler scheduler2 = scheduler;
        ObjectHelper.b(scheduler2, "scheduler is null");
        TimeUnit timeUnit2 = timeUnit;
        ObjectHelper.b(timeUnit2, "unit is null");
        return new ObservableWindowTimed(this, j, j3, timeUnit2, scheduler2, LocationRequestCompat.PASSIVE_INTERVAL, i2, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        ObjectHelper.b(observableSource3, "source3 is null");
        return combineLatest(Functions.q(function3), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3});
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        ObjectHelper.b(observableSource3, "source3 is null");
        return zipArray(Functions.q(function3), false, bufferSize(), observableSource, observableSource2, observableSource3);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> takeLast(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return takeLast(j, j2, timeUnit, scheduler, false, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> takeLast(long j, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i) {
        ObjectHelper.b(timeUnit, "unit is null");
        ObjectHelper.b(scheduler, "scheduler is null");
        ObjectHelper.c(i, "bufferSize");
        if (j >= 0) {
            return new ObservableTakeLastTimed(this, j, j2, timeUnit, scheduler, i, z);
        }
        throw new IndexOutOfBoundsException(e.j(j, "count >= 0 required but it was "));
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<List<T>> buffer(long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        return buffer(j, timeUnit, scheduler, i, ArrayListSupplier.asCallable(), false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <V> Observable<T> timeout(Function<? super T, ? extends ObservableSource<V>> function) {
        ObjectHelper.b(function, "itemTimeoutIndicator is null");
        return new ObservableTimeout(this, (ObservableSource) null, function, (ObservableSource) null);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final <U extends Collection<? super T>> Observable<U> buffer(long j, TimeUnit timeUnit, Scheduler scheduler, int i, Callable<U> callable, boolean z) {
        ObjectHelper.b(timeUnit, "unit is null");
        Scheduler scheduler2 = scheduler;
        ObjectHelper.b(scheduler2, "scheduler is null");
        Callable<U> callable2 = callable;
        ObjectHelper.b(callable2, "bufferSupplier is null");
        int i2 = i;
        ObjectHelper.c(i2, "count");
        return new ObservableBufferTimed(this, j, j, timeUnit, scheduler2, callable2, i2, z);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i) {
        return flatMap(function, false, i, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        ObjectHelper.b(observableSource3, "source3 is null");
        ObjectHelper.b(observableSource4, "source4 is null");
        return combineLatest(Functions.r(function4), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4});
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6) {
        ObjectHelper.b(t, "The first item is null");
        ObjectHelper.b(t2, "The second item is null");
        ObjectHelper.b(t3, "The third item is null");
        ObjectHelper.b(t4, "The fourth item is null");
        ObjectHelper.b(t5, "The fifth item is null");
        ObjectHelper.b(t6, "The sixth item is null");
        return fromArray(t, t2, t3, t4, t5, t6);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        ObjectHelper.b(observableSource3, "source3 is null");
        ObjectHelper.b(observableSource4, "source4 is null");
        return zipArray(Functions.r(function4), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return flatMap(function, biFunction, false, bufferSize(), bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i, Scheduler scheduler) {
        ObjectHelper.b(function, "selector is null");
        ObjectHelper.b(scheduler, "scheduler is null");
        ObjectHelper.c(i, "bufferSize");
        return ObservableReplay.g(ObservableInternalHelper.k(function, scheduler), ObservableInternalHelper.i(this, i));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        return flatMap(function, biFunction, z, bufferSize(), bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return window(j, timeUnit, scheduler, (long) LocationRequestCompat.PASSIVE_INTERVAL, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> withLatestFrom(ObservableSource<?>[] observableSourceArr, Function<? super Object[], R> function) {
        ObjectHelper.b(observableSourceArr, "others is null");
        ObjectHelper.b(function, "combiner is null");
        return new ObservableWithLatestFromMany(this, (ObservableSource[]) observableSourceArr, (Function) function);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i) {
        return flatMap(function, biFunction, z, i, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit, Scheduler scheduler, long j2) {
        return window(j, timeUnit, scheduler, j2, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i, int i2) {
        ObjectHelper.b(function, "mapper is null");
        ObjectHelper.b(biFunction, "combiner is null");
        return flatMap(ObservableInternalHelper.b(function, biFunction), z, i, i2);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit, Scheduler scheduler, long j2, boolean z) {
        return window(j, timeUnit, scheduler, j2, z, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<List<T>> buffer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return buffer(j, timeUnit, scheduler, Integer.MAX_VALUE, ArrayListSupplier.asCallable(), false);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit, Scheduler scheduler, long j2, boolean z, int i) {
        int i2 = i;
        ObjectHelper.c(i2, "bufferSize");
        Scheduler scheduler2 = scheduler;
        ObjectHelper.b(scheduler2, "scheduler is null");
        TimeUnit timeUnit2 = timeUnit;
        ObjectHelper.b(timeUnit2, "unit is null");
        long j3 = j2;
        ObjectHelper.d(j3, "count");
        return new ObservableWindowTimed(this, j, j, timeUnit2, scheduler2, j3, i2, z);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> withLatestFrom(Iterable<? extends ObservableSource<?>> iterable, Function<? super Object[], R> function) {
        ObjectHelper.b(iterable, "others is null");
        ObjectHelper.b(function, "combiner is null");
        return new ObservableWithLatestFromMany(this, (Iterable) iterable, (Function) function);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        ObjectHelper.b(observableSource3, "source3 is null");
        ObjectHelper.b(observableSource4, "source4 is null");
        ObjectHelper.b(observableSource5, "source5 is null");
        return combineLatest(Functions.s(function5), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5});
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        ObjectHelper.b(observableSource3, "source3 is null");
        ObjectHelper.b(observableSource4, "source4 is null");
        ObjectHelper.b(observableSource5, "source5 is null");
        return zipArray(Functions.s(function5), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <TOpening, TClosing> Observable<List<T>> buffer(ObservableSource<? extends TOpening> observableSource, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> function) {
        return buffer(observableSource, function, ArrayListSupplier.asCallable());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <TOpening, TClosing, U extends Collection<? super T>> Observable<U> buffer(ObservableSource<? extends TOpening> observableSource, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> function, Callable<U> callable) {
        ObjectHelper.b(observableSource, "openingIndicator is null");
        ObjectHelper.b(function, "closingIndicator is null");
        ObjectHelper.b(callable, "bufferSupplier is null");
        return new ObservableBufferBoundary(this, observableSource, function, callable);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, int i) {
        return flatMap(function, biFunction, false, i, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.b(function, "selector is null");
        ObjectHelper.b(timeUnit, "unit is null");
        ObjectHelper.b(scheduler, "scheduler is null");
        return ObservableReplay.g(function, ObservableInternalHelper.j(this, j, timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        ObjectHelper.b(t, "The first item is null");
        ObjectHelper.b(t2, "The second item is null");
        ObjectHelper.b(t3, "The third item is null");
        ObjectHelper.b(t4, "The fourth item is null");
        ObjectHelper.b(t5, "The fifth item is null");
        ObjectHelper.b(t6, "The sixth item is null");
        ObjectHelper.b(t7, "The seventh item is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> takeLast(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return takeLast(j, timeUnit, scheduler, false, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> takeLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return takeLast(j, timeUnit, scheduler, z, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <B> Observable<Observable<T>> window(ObservableSource<B> observableSource) {
        return window(observableSource, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <B> Observable<List<T>> buffer(ObservableSource<B> observableSource) {
        return buffer(observableSource, ArrayListSupplier.asCallable());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
        ObjectHelper.b(function, "selector is null");
        ObjectHelper.b(scheduler, "scheduler is null");
        return ObservableReplay.g(ObservableInternalHelper.k(function, scheduler), ObservableInternalHelper.h(this));
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> takeLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i) {
        return takeLast(LocationRequestCompat.PASSIVE_INTERVAL, j, timeUnit, scheduler, z, i);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <B> Observable<Observable<T>> window(ObservableSource<B> observableSource, int i) {
        ObjectHelper.b(observableSource, "boundary is null");
        ObjectHelper.c(i, "bufferSize");
        return new ObservableWindowBoundary(this, observableSource, i);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        ObjectHelper.b(observableSource3, "source3 is null");
        ObjectHelper.b(observableSource4, "source4 is null");
        ObjectHelper.b(observableSource5, "source5 is null");
        ObjectHelper.b(observableSource6, "source6 is null");
        return combineLatest(Functions.t(function6), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6});
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        ObjectHelper.b(observableSource3, "source3 is null");
        ObjectHelper.b(observableSource4, "source4 is null");
        ObjectHelper.b(observableSource5, "source5 is null");
        ObjectHelper.b(observableSource6, "source6 is null");
        return zipArray(Functions.t(function6), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <B> Observable<List<T>> buffer(ObservableSource<B> observableSource, int i) {
        ObjectHelper.c(i, "initialCapacity");
        return buffer(observableSource, Functions.c(i));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <B, U extends Collection<? super T>> Observable<U> buffer(ObservableSource<B> observableSource, Callable<U> callable) {
        ObjectHelper.b(observableSource, "boundary is null");
        ObjectHelper.b(callable, "bufferSupplier is null");
        return new ObservableBufferExactBoundary(this, observableSource, callable);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, V> Observable<Observable<T>> window(ObservableSource<U> observableSource, Function<? super U, ? extends ObservableSource<V>> function) {
        return window(observableSource, function, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, V> Observable<Observable<T>> window(ObservableSource<U> observableSource, Function<? super U, ? extends ObservableSource<V>> function, int i) {
        ObjectHelper.b(observableSource, "openingIndicator is null");
        ObjectHelper.b(function, "closingIndicator is null");
        ObjectHelper.c(i, "bufferSize");
        return new ObservableWindowBoundarySelector(this, observableSource, function, i);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        ObjectHelper.b(t, "The first item is null");
        ObjectHelper.b(t2, "The second item is null");
        ObjectHelper.b(t3, "The third item is null");
        ObjectHelper.b(t4, "The fourth item is null");
        ObjectHelper.b(t5, "The fifth item is null");
        ObjectHelper.b(t6, "The sixth item is null");
        ObjectHelper.b(t7, "The seventh item is null");
        ObjectHelper.b(t8, "The eighth item is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final ConnectableObservable<T> replay(int i) {
        ObjectHelper.c(i, "bufferSize");
        return ObservableReplay.e(this, i);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <B> Observable<List<T>> buffer(Callable<? extends ObservableSource<B>> callable) {
        return buffer(callable, ArrayListSupplier.asCallable());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <B, U extends Collection<? super T>> Observable<U> buffer(Callable<? extends ObservableSource<B>> callable, Callable<U> callable2) {
        ObjectHelper.b(callable, "boundarySupplier is null");
        ObjectHelper.b(callable2, "bufferSupplier is null");
        return new ObservableBufferBoundarySupplier(this, callable, callable2);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final ConnectableObservable<T> replay(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.c(i, "bufferSize");
        ObjectHelper.b(timeUnit, "unit is null");
        ObjectHelper.b(scheduler, "scheduler is null");
        return ObservableReplay.d(i, j, this, scheduler, timeUnit);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        ObjectHelper.b(observableSource3, "source3 is null");
        ObjectHelper.b(observableSource4, "source4 is null");
        ObjectHelper.b(observableSource5, "source5 is null");
        ObjectHelper.b(observableSource6, "source6 is null");
        ObjectHelper.b(observableSource7, "source7 is null");
        return combineLatest(Functions.u(function7), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7});
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        ObjectHelper.b(observableSource3, "source3 is null");
        ObjectHelper.b(observableSource4, "source4 is null");
        ObjectHelper.b(observableSource5, "source5 is null");
        ObjectHelper.b(observableSource6, "source6 is null");
        ObjectHelper.b(observableSource7, "source7 is null");
        return zipArray(Functions.u(function7), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <B> Observable<Observable<T>> window(Callable<? extends ObservableSource<B>> callable) {
        return window(callable, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <B> Observable<Observable<T>> window(Callable<? extends ObservableSource<B>> callable, int i) {
        ObjectHelper.b(callable, "boundary is null");
        ObjectHelper.c(i, "bufferSize");
        return new ObservableWindowBoundarySupplier(this, callable, i);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final ConnectableObservable<T> replay(int i, Scheduler scheduler) {
        ObjectHelper.c(i, "bufferSize");
        return ObservableReplay.h(replay(i), scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final ConnectableObservable<T> replay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.b(timeUnit, "unit is null");
        ObjectHelper.b(scheduler, "scheduler is null");
        return ObservableReplay.d(Integer.MAX_VALUE, j, this, scheduler, timeUnit);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        ObjectHelper.b(t, "The first item is null");
        ObjectHelper.b(t2, "The second item is null");
        ObjectHelper.b(t3, "The third item is null");
        ObjectHelper.b(t4, "The fourth item is null");
        ObjectHelper.b(t5, "The fifth item is null");
        ObjectHelper.b(t6, "The sixth item is null");
        ObjectHelper.b(t7, "The seventh item is null");
        ObjectHelper.b(t8, "The eighth item is null");
        ObjectHelper.b(t9, "The ninth item is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        ObjectHelper.b(observableSource3, "source3 is null");
        ObjectHelper.b(observableSource4, "source4 is null");
        ObjectHelper.b(observableSource5, "source5 is null");
        ObjectHelper.b(observableSource6, "source6 is null");
        ObjectHelper.b(observableSource7, "source7 is null");
        ObjectHelper.b(observableSource8, "source8 is null");
        return combineLatest(Functions.v(function8), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8});
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        ObjectHelper.b(observableSource3, "source3 is null");
        ObjectHelper.b(observableSource4, "source4 is null");
        ObjectHelper.b(observableSource5, "source5 is null");
        ObjectHelper.b(observableSource6, "source6 is null");
        ObjectHelper.b(observableSource7, "source7 is null");
        ObjectHelper.b(observableSource8, "source8 is null");
        return zipArray(Functions.v(function8), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final ConnectableObservable<T> replay(Scheduler scheduler) {
        ObjectHelper.b(scheduler, "scheduler is null");
        return ObservableReplay.h(replay(), scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        ObjectHelper.b(t, "The first item is null");
        ObjectHelper.b(t2, "The second item is null");
        ObjectHelper.b(t3, "The third item is null");
        ObjectHelper.b(t4, "The fourth item is null");
        ObjectHelper.b(t5, "The fifth item is null");
        ObjectHelper.b(t6, "The sixth item is null");
        ObjectHelper.b(t7, "The seventh item is null");
        ObjectHelper.b(t8, "The eighth item is null");
        ObjectHelper.b(t9, "The ninth item is null");
        ObjectHelper.b(t10, "The tenth item is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9, t10);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, ObservableSource<? extends T9> observableSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        ObjectHelper.b(observableSource3, "source3 is null");
        ObjectHelper.b(observableSource4, "source4 is null");
        ObjectHelper.b(observableSource5, "source5 is null");
        ObjectHelper.b(observableSource6, "source6 is null");
        ObjectHelper.b(observableSource7, "source7 is null");
        ObjectHelper.b(observableSource8, "source8 is null");
        ObjectHelper.b(observableSource9, "source9 is null");
        return combineLatest(Functions.w(function9), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9});
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, ObservableSource<? extends T9> observableSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.b(observableSource, "source1 is null");
        ObjectHelper.b(observableSource2, "source2 is null");
        ObjectHelper.b(observableSource3, "source3 is null");
        ObjectHelper.b(observableSource4, "source4 is null");
        ObjectHelper.b(observableSource5, "source5 is null");
        ObjectHelper.b(observableSource6, "source6 is null");
        ObjectHelper.b(observableSource7, "source7 is null");
        ObjectHelper.b(observableSource8, "source8 is null");
        ObjectHelper.b(observableSource9, "source9 is null");
        return zipArray(Functions.w(function9), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9);
    }
}
