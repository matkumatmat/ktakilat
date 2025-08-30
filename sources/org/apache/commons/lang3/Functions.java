package org.apache.commons.lang3;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.commons.lang3.Streams;
import org.apache.commons.lang3.function.FailableBooleanSupplier;

@Deprecated
public class Functions {

    @FunctionalInterface
    @Deprecated
    public interface FailableBiConsumer<O1, O2, T extends Throwable> {
        void accept(O1 o1, O2 o2) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailableBiFunction<O1, O2, R, T extends Throwable> {
        R apply(O1 o1, O2 o2) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailableBiPredicate<O1, O2, T extends Throwable> {
        boolean test(O1 o1, O2 o2) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailableCallable<R, T extends Throwable> {
        R call() throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailableConsumer<O, T extends Throwable> {
        void accept(O o) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailableFunction<I, R, T extends Throwable> {
        R apply(I i) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailablePredicate<I, T extends Throwable> {
        boolean test(I i) throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailableRunnable<T extends Throwable> {
        void run() throws Throwable;
    }

    @FunctionalInterface
    @Deprecated
    public interface FailableSupplier<R, T extends Throwable> {
        R get() throws Throwable;
    }

    public static <O1, O2, T extends Throwable> void accept(FailableBiConsumer<O1, O2, T> failableBiConsumer, O1 o1, O2 o2) {
        run(new g4(failableBiConsumer, 10, o1, o2));
    }

    public static <O1, O2, O, T extends Throwable> O apply(FailableBiFunction<O1, O2, O, T> failableBiFunction, O1 o1, O2 o2) {
        return get(new g4(failableBiFunction, 11, o1, o2));
    }

    public static <O1, O2> BiConsumer<O1, O2> asBiConsumer(FailableBiConsumer<O1, O2, ?> failableBiConsumer) {
        return new g7(failableBiConsumer, 1);
    }

    public static <O1, O2, O> BiFunction<O1, O2, O> asBiFunction(FailableBiFunction<O1, O2, O, ?> failableBiFunction) {
        return new e7(failableBiFunction, 1);
    }

    public static <O1, O2> BiPredicate<O1, O2> asBiPredicate(FailableBiPredicate<O1, O2, ?> failableBiPredicate) {
        return new b7(failableBiPredicate, 1);
    }

    public static <O> Callable<O> asCallable(FailableCallable<O, ?> failableCallable) {
        return new q1(failableCallable, 5);
    }

    public static <I> Consumer<I> asConsumer(FailableConsumer<I, ?> failableConsumer) {
        return new f0(failableConsumer, 2);
    }

    public static <I, O> Function<I, O> asFunction(FailableFunction<I, O, ?> failableFunction) {
        return new z5(failableFunction, 4);
    }

    public static <I> Predicate<I> asPredicate(FailablePredicate<I, ?> failablePredicate) {
        return new h7(failablePredicate, 1);
    }

    public static Runnable asRunnable(FailableRunnable<?> failableRunnable) {
        return new x0(failableRunnable, 24);
    }

    public static <O> Supplier<O> asSupplier(FailableSupplier<O, ?> failableSupplier) {
        return new d7(failableSupplier, 1);
    }

    public static <O, T extends Throwable> O call(FailableCallable<O, T> failableCallable) {
        failableCallable.getClass();
        return get(new k0(failableCallable, 26));
    }

    public static <O, T extends Throwable> O get(FailableSupplier<O, T> failableSupplier) {
        try {
            return failableSupplier.get();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    private static <T extends Throwable> boolean getAsBoolean(FailableBooleanSupplier<T> failableBooleanSupplier) {
        try {
            return failableBooleanSupplier.getAsBoolean();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static RuntimeException rethrow(Throwable th) {
        Objects.requireNonNull(th, "throwable");
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else if (th instanceof Error) {
            throw ((Error) th);
        } else if (th instanceof IOException) {
            l3.v();
            throw l3.h((IOException) th);
        } else {
            throw new UndeclaredThrowableException(th);
        }
    }

    public static <T extends Throwable> void run(FailableRunnable<T> failableRunnable) {
        try {
            failableRunnable.run();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <O> Streams.FailableStream<O> stream(Collection<O> collection) {
        return new Streams.FailableStream<>(collection.stream());
    }

    public static <O1, O2, T extends Throwable> boolean test(FailableBiPredicate<O1, O2, T> failableBiPredicate, O1 o1, O2 o2) {
        return getAsBoolean(new g4(failableBiPredicate, 12, o1, o2));
    }

    @SafeVarargs
    public static void tryWithResources(FailableRunnable<? extends Throwable> failableRunnable, FailableConsumer<Throwable, ? extends Throwable> failableConsumer, FailableRunnable<? extends Throwable>... failableRunnableArr) {
        if (failableConsumer == null) {
            failableConsumer = new g8(29);
        }
        if (failableRunnableArr != null) {
            for (FailableRunnable<? extends Throwable> requireNonNull : failableRunnableArr) {
                Objects.requireNonNull(requireNonNull, "runnable");
            }
        }
        try {
            failableRunnable.run();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        if (failableRunnableArr != null) {
            for (FailableRunnable<? extends Throwable> run : failableRunnableArr) {
                try {
                    run.run();
                } catch (Throwable th2) {
                    if (th == null) {
                        th = th2;
                    }
                }
            }
        }
        if (th != null) {
            try {
                failableConsumer.accept(th);
            } catch (Throwable th3) {
                throw rethrow(th3);
            }
        }
    }

    public static <O, T extends Throwable> void accept(FailableConsumer<O, T> failableConsumer, O o) {
        run(new t2(19, failableConsumer, o));
    }

    public static <I, O, T extends Throwable> O apply(FailableFunction<I, O, T> failableFunction, I i) {
        return get(new t2(18, failableFunction, i));
    }

    public static <O> Streams.FailableStream<O> stream(Stream<O> stream) {
        return new Streams.FailableStream<>(stream);
    }

    public static <O, T extends Throwable> boolean test(FailablePredicate<O, T> failablePredicate, O o) {
        return getAsBoolean(new t2(17, failablePredicate, o));
    }

    @SafeVarargs
    public static void tryWithResources(FailableRunnable<? extends Throwable> failableRunnable, FailableRunnable<? extends Throwable>... failableRunnableArr) {
        tryWithResources(failableRunnable, (FailableConsumer<Throwable, ? extends Throwable>) null, failableRunnableArr);
    }
}
