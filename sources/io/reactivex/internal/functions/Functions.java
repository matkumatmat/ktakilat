package io.reactivex.internal.functions;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Notification;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
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
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscription;

public final class Functions {

    /* renamed from: a  reason: collision with root package name */
    public static final Function f662a = new Object();
    public static final Runnable b = new Object();
    public static final Action c = new Object();
    public static final Consumer d = new Object();
    public static final Consumer e = new Object();
    public static final Predicate f = new Object();
    public static final Predicate g = new Object();
    public static final Callable h = new Object();
    public static final Comparator i = new Object();

    public static final class ActionConsumer<T> implements Consumer<T> {
        public final Action c;

        public ActionConsumer(Action action) {
            this.c = action;
        }

        public final void accept(Object obj) {
            this.c.run();
        }
    }

    public static final class Array2Func<T1, T2, R> implements Function<Object[], R> {
        public final BiFunction c;

        public Array2Func(BiFunction biFunction) {
            this.c = biFunction;
        }

        public final Object apply(Object obj) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 2) {
                return this.c.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    public static final class Array3Func<T1, T2, T3, R> implements Function<Object[], R> {
        public final Function3 c;

        public Array3Func(Function3 function3) {
            this.c = function3;
        }

        public final Object apply(Object obj) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 3) {
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                return this.c.apply();
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    public static final class Array4Func<T1, T2, T3, T4, R> implements Function<Object[], R> {
        public final Function4 c;

        public Array4Func(Function4 function4) {
            this.c = function4;
        }

        public final Object apply(Object obj) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 4) {
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                Object obj5 = objArr[3];
                return this.c.apply();
            }
            throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
        }
    }

    public static final class Array5Func<T1, T2, T3, T4, T5, R> implements Function<Object[], R> {
        public final Function5 c;

        public Array5Func(Function5 function5) {
            this.c = function5;
        }

        public final Object apply(Object obj) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 5) {
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                Object obj5 = objArr[3];
                Object obj6 = objArr[4];
                return this.c.apply();
            }
            throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
        }
    }

    public static final class Array6Func<T1, T2, T3, T4, T5, T6, R> implements Function<Object[], R> {
        public final Function6 c;

        public Array6Func(Function6 function6) {
            this.c = function6;
        }

        public final Object apply(Object obj) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 6) {
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                Object obj5 = objArr[3];
                Object obj6 = objArr[4];
                Object obj7 = objArr[5];
                return this.c.apply();
            }
            throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
        }
    }

    public static final class Array7Func<T1, T2, T3, T4, T5, T6, T7, R> implements Function<Object[], R> {
        public final Function7 c;

        public Array7Func(Function7 function7) {
            this.c = function7;
        }

        public final Object apply(Object obj) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 7) {
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                Object obj5 = objArr[3];
                Object obj6 = objArr[4];
                Object obj7 = objArr[5];
                Object obj8 = objArr[6];
                return this.c.apply();
            }
            throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
        }
    }

    public static final class Array8Func<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Function<Object[], R> {
        public final Function8 c;

        public Array8Func(Function8 function8) {
            this.c = function8;
        }

        public final Object apply(Object obj) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 8) {
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                Object obj5 = objArr[3];
                Object obj6 = objArr[4];
                Object obj7 = objArr[5];
                Object obj8 = objArr[6];
                Object obj9 = objArr[7];
                return this.c.apply();
            }
            throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
        }
    }

    public static final class Array9Func<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Function<Object[], R> {
        public final Function9 c;

        public Array9Func(Function9 function9) {
            this.c = function9;
        }

        public final Object apply(Object obj) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 9) {
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                Object obj5 = objArr[3];
                Object obj6 = objArr[4];
                Object obj7 = objArr[5];
                Object obj8 = objArr[6];
                Object obj9 = objArr[7];
                Object obj10 = objArr[8];
                return this.c.apply();
            }
            throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
        }
    }

    public static final class ArrayListCapacityCallable<T> implements Callable<List<T>> {
        public final int c;

        public ArrayListCapacityCallable(int i) {
            this.c = i;
        }

        public final Object call() {
            return new ArrayList(this.c);
        }
    }

    public static final class BooleanSupplierPredicateReverse<T> implements Predicate<T> {
        public final BooleanSupplier c;

        public BooleanSupplierPredicateReverse(BooleanSupplier booleanSupplier) {
            this.c = booleanSupplier;
        }

        public final boolean test(Object obj) {
            return !this.c.getAsBoolean();
        }
    }

    public static class BoundedConsumer implements Consumer<Subscription> {
        public final void accept(Object obj) {
            ((Subscription) obj).request((long) 0);
        }
    }

    public static final class CastToClass<T, U> implements Function<T, U> {
        public final Class c;

        public CastToClass(Class cls) {
            this.c = cls;
        }

        public final Object apply(Object obj) {
            return this.c.cast(obj);
        }
    }

    public static final class ClassFilter<T, U> implements Predicate<T> {
        public final Class c;

        public ClassFilter(Class cls) {
            this.c = cls;
        }

        public final boolean test(Object obj) {
            return this.c.isInstance(obj);
        }
    }

    public static final class EmptyAction implements Action {
        public final void run() {
        }

        public final String toString() {
            return "EmptyAction";
        }
    }

    public static final class EmptyConsumer implements Consumer<Object> {
        public final void accept(Object obj) {
        }

        public final String toString() {
            return "EmptyConsumer";
        }
    }

    public static final class EmptyLongConsumer implements LongConsumer {
    }

    public static final class EmptyRunnable implements Runnable {
        public final void run() {
        }

        public final String toString() {
            return "EmptyRunnable";
        }
    }

    public static final class EqualsPredicate<T> implements Predicate<T> {
        public final Object c;

        public EqualsPredicate(Object obj) {
            this.c = obj;
        }

        public final boolean test(Object obj) {
            return ObjectHelper.a(obj, this.c);
        }
    }

    public static final class ErrorConsumer implements Consumer<Throwable> {
        public final void accept(Object obj) {
            RxJavaPlugins.b((Throwable) obj);
        }
    }

    public static final class FalsePredicate implements Predicate<Object> {
        public final boolean test(Object obj) {
            return false;
        }
    }

    public static final class FutureAction implements Action {
        public final void run() {
            throw null;
        }
    }

    public enum HashSetCallable implements Callable<Set<Object>> {
        ;

        public final Object call() {
            return new HashSet();
        }
    }

    public static final class Identity implements Function<Object, Object> {
        public final Object apply(Object obj) {
            return obj;
        }

        public final String toString() {
            return "IdentityFunction";
        }
    }

    public static final class JustValue<T, U> implements Callable<U>, Function<T, U> {
        public final Object c;

        public JustValue(Object obj) {
            this.c = obj;
        }

        public final Object apply(Object obj) {
            return this.c;
        }

        public final Object call() {
            return this.c;
        }
    }

    public static final class ListSorter<T> implements Function<List<T>, List<T>> {
        public final Comparator c;

        public ListSorter(Comparator comparator) {
            this.c = comparator;
        }

        public final Object apply(Object obj) {
            List list = (List) obj;
            Collections.sort(list, this.c);
            return list;
        }
    }

    public static final class MaxRequestSubscription implements Consumer<Subscription> {
        public final void accept(Object obj) {
            ((Subscription) obj).request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    public enum NaturalComparator implements Comparator<Object> {
        ;

        public final int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    public static final class NaturalObjectComparator implements Comparator<Object> {
        public final int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    public static final class NotificationOnComplete<T> implements Action {
        public final Consumer c;

        public NotificationOnComplete(Consumer consumer) {
            this.c = consumer;
        }

        public final void run() {
            this.c.accept(Notification.b);
        }
    }

    public static final class NotificationOnError<T> implements Consumer<Throwable> {
        public final Consumer c;

        public NotificationOnError(Consumer consumer) {
            this.c = consumer;
        }

        public final void accept(Object obj) {
            this.c.accept(Notification.a((Throwable) obj));
        }
    }

    public static final class NotificationOnNext<T> implements Consumer<T> {
        public final Consumer c;

        public NotificationOnNext(Consumer consumer) {
            this.c = consumer;
        }

        public final void accept(Object obj) {
            ObjectHelper.b(obj, "value is null");
            this.c.accept(new Notification(obj));
        }
    }

    public static final class NullCallable implements Callable<Object> {
        public final Object call() {
            return null;
        }
    }

    public static final class OnErrorMissingConsumer implements Consumer<Throwable> {
        public final void accept(Object obj) {
            RxJavaPlugins.b(new OnErrorNotImplementedException((Throwable) obj));
        }
    }

    public static final class TimestampFunction<T> implements Function<T, Timed<T>> {
        public final TimeUnit c;
        public final Scheduler d;

        public TimestampFunction(TimeUnit timeUnit, Scheduler scheduler) {
            this.c = timeUnit;
            this.d = scheduler;
        }

        public final Object apply(Object obj) {
            Scheduler scheduler = this.d;
            TimeUnit timeUnit = this.c;
            return new Timed(obj, scheduler.b(timeUnit), timeUnit);
        }
    }

    public static final class ToMapKeySelector<K, T> implements BiConsumer<Map<K, T>, T> {

        /* renamed from: a  reason: collision with root package name */
        public final Function f663a;

        public ToMapKeySelector(Function function) {
            this.f663a = function;
        }

        public final void accept(Object obj, Object obj2) {
            ((Map) obj).put(this.f663a.apply(obj2), obj2);
        }
    }

    public static final class ToMapKeyValueSelector<K, V, T> implements BiConsumer<Map<K, V>, T> {

        /* renamed from: a  reason: collision with root package name */
        public final Function f664a;
        public final Function b;

        public ToMapKeyValueSelector(Function function, Function function2) {
            this.f664a = function;
            this.b = function2;
        }

        public final void accept(Object obj, Object obj2) {
            ((Map) obj).put(this.b.apply(obj2), this.f664a.apply(obj2));
        }
    }

    public static final class ToMultimapKeyValueSelector<K, V, T> implements BiConsumer<Map<K, Collection<V>>, T> {

        /* renamed from: a  reason: collision with root package name */
        public final Function f665a;
        public final Function b;
        public final Function c;

        public ToMultimapKeyValueSelector(Function function, Function function2, Function function3) {
            this.f665a = function;
            this.b = function2;
            this.c = function3;
        }

        public final void accept(Object obj, Object obj2) {
            Map map = (Map) obj;
            Object apply = this.c.apply(obj2);
            Collection collection = (Collection) map.get(apply);
            if (collection == null) {
                collection = (Collection) this.f665a.apply(apply);
                map.put(apply, collection);
            }
            collection.add(this.b.apply(obj2));
        }
    }

    public static final class TruePredicate implements Predicate<Object> {
        public final boolean test(Object obj) {
            return true;
        }
    }

    public static Consumer a(Action action) {
        return new ActionConsumer(action);
    }

    public static Function b(Class cls) {
        return new CastToClass(cls);
    }

    public static Callable c(int i2) {
        return new ArrayListCapacityCallable(i2);
    }

    public static Callable d() {
        return HashSetCallable.c;
    }

    public static Predicate e(Object obj) {
        return new EqualsPredicate(obj);
    }

    public static Predicate f(Class cls) {
        return new ClassFilter(cls);
    }

    public static Callable g(Object obj) {
        return new JustValue(obj);
    }

    public static Function h(Object obj) {
        return new JustValue(obj);
    }

    public static Function i(Comparator comparator) {
        return new ListSorter(comparator);
    }

    public static Comparator j() {
        return NaturalComparator.c;
    }

    public static Action k(Consumer consumer) {
        return new NotificationOnComplete(consumer);
    }

    public static Consumer l(Consumer consumer) {
        return new NotificationOnError(consumer);
    }

    public static Consumer m(Consumer consumer) {
        return new NotificationOnNext(consumer);
    }

    public static Predicate n(BooleanSupplier booleanSupplier) {
        return new BooleanSupplierPredicateReverse(booleanSupplier);
    }

    public static Function o(TimeUnit timeUnit, Scheduler scheduler) {
        return new TimestampFunction(timeUnit, scheduler);
    }

    public static Function p(BiFunction biFunction) {
        ObjectHelper.b(biFunction, "f is null");
        return new Array2Func(biFunction);
    }

    public static Function q(Function3 function3) {
        ObjectHelper.b(function3, "f is null");
        return new Array3Func(function3);
    }

    public static Function r(Function4 function4) {
        ObjectHelper.b(function4, "f is null");
        return new Array4Func(function4);
    }

    public static Function s(Function5 function5) {
        ObjectHelper.b(function5, "f is null");
        return new Array5Func(function5);
    }

    public static Function t(Function6 function6) {
        ObjectHelper.b(function6, "f is null");
        return new Array6Func(function6);
    }

    public static Function u(Function7 function7) {
        ObjectHelper.b(function7, "f is null");
        return new Array7Func(function7);
    }

    public static Function v(Function8 function8) {
        ObjectHelper.b(function8, "f is null");
        return new Array8Func(function8);
    }

    public static Function w(Function9 function9) {
        ObjectHelper.b(function9, "f is null");
        return new Array9Func(function9);
    }

    public static BiConsumer x(Function function) {
        return new ToMapKeySelector(function);
    }

    public static BiConsumer y(Function function, Function function2) {
        return new ToMapKeyValueSelector(function2, function);
    }

    public static BiConsumer z(Function function, Function function2, Function function3) {
        return new ToMultimapKeyValueSelector(function3, function2, function);
    }
}
