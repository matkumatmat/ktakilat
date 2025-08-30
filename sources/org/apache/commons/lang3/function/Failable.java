package org.apache.commons.lang3.function;

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
import org.apache.commons.lang3.stream.Streams;

public class Failable {
    private Failable() {
    }

    public static <T, U, E extends Throwable> void accept(FailableBiConsumer<T, U, E> failableBiConsumer, T t, U u) {
        run(new g4(failableBiConsumer, 7, t, u));
    }

    public static <T, U, R, E extends Throwable> R apply(FailableBiFunction<T, U, R, E> failableBiFunction, T t, U u) {
        return get(new g4(failableBiFunction, 8, t, u));
    }

    public static <E extends Throwable> double applyAsDouble(FailableDoubleBinaryOperator<E> failableDoubleBinaryOperator, double d, double d2) {
        return getAsDouble(new f7(failableDoubleBinaryOperator, d, d2));
    }

    public static <T, U> BiConsumer<T, U> asBiConsumer(FailableBiConsumer<T, U, ?> failableBiConsumer) {
        return new g7(failableBiConsumer, 0);
    }

    public static <T, U, R> BiFunction<T, U, R> asBiFunction(FailableBiFunction<T, U, R, ?> failableBiFunction) {
        return new e7(failableBiFunction, 0);
    }

    public static <T, U> BiPredicate<T, U> asBiPredicate(FailableBiPredicate<T, U, ?> failableBiPredicate) {
        return new b7(failableBiPredicate, 0);
    }

    public static <V> Callable<V> asCallable(FailableCallable<V, ?> failableCallable) {
        return new q1(failableCallable, 3);
    }

    public static <T> Consumer<T> asConsumer(FailableConsumer<T, ?> failableConsumer) {
        return new f0(failableConsumer, 1);
    }

    public static <T, R> Function<T, R> asFunction(FailableFunction<T, R, ?> failableFunction) {
        return new z5(failableFunction, 3);
    }

    public static <T> Predicate<T> asPredicate(FailablePredicate<T, ?> failablePredicate) {
        return new h7(failablePredicate, 0);
    }

    public static Runnable asRunnable(FailableRunnable<?> failableRunnable) {
        return new x0(failableRunnable, 19);
    }

    public static <T> Supplier<T> asSupplier(FailableSupplier<T, ?> failableSupplier) {
        return new d7(failableSupplier, 0);
    }

    public static <V, E extends Throwable> V call(FailableCallable<V, E> failableCallable) {
        failableCallable.getClass();
        return get(new k0(failableCallable, 18));
    }

    public static <T, E extends Throwable> T get(FailableSupplier<T, E> failableSupplier) {
        try {
            return failableSupplier.get();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E extends Throwable> boolean getAsBoolean(FailableBooleanSupplier<E> failableBooleanSupplier) {
        try {
            return failableBooleanSupplier.getAsBoolean();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E extends Throwable> double getAsDouble(FailableDoubleSupplier<E> failableDoubleSupplier) {
        try {
            return failableDoubleSupplier.getAsDouble();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E extends Throwable> int getAsInt(FailableIntSupplier<E> failableIntSupplier) {
        try {
            return failableIntSupplier.getAsInt();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E extends Throwable> long getAsLong(FailableLongSupplier<E> failableLongSupplier) {
        try {
            return failableLongSupplier.getAsLong();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E extends Throwable> short getAsShort(FailableShortSupplier<E> failableShortSupplier) {
        try {
            return failableShortSupplier.getAsShort();
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

    public static <E extends Throwable> void run(FailableRunnable<E> failableRunnable) {
        try {
            failableRunnable.run();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E> Streams.FailableStream<E> stream(Collection<E> collection) {
        return new Streams.FailableStream<>(collection.stream());
    }

    public static <T, U, E extends Throwable> boolean test(FailableBiPredicate<T, U, E> failableBiPredicate, T t, U u) {
        return getAsBoolean(new g4(failableBiPredicate, 6, t, u));
    }

    @SafeVarargs
    public static void tryWithResources(FailableRunnable<? extends Throwable> failableRunnable, FailableConsumer<Throwable, ? extends Throwable> failableConsumer, FailableRunnable<? extends Throwable>... failableRunnableArr) {
        if (failableConsumer == null) {
            failableConsumer = new x2(5);
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

    public static <T, E extends Throwable> void accept(FailableConsumer<T, E> failableConsumer, T t) {
        run(new t2(9, failableConsumer, t));
    }

    public static <T, R, E extends Throwable> R apply(FailableFunction<T, R, E> failableFunction, T t) {
        return get(new t2(10, failableFunction, t));
    }

    public static <T> Streams.FailableStream<T> stream(Stream<T> stream) {
        return new Streams.FailableStream<>(stream);
    }

    public static <T, E extends Throwable> boolean test(FailablePredicate<T, E> failablePredicate, T t) {
        return getAsBoolean(new t2(8, failablePredicate, t));
    }

    public static <E extends Throwable> void accept(FailableDoubleConsumer<E> failableDoubleConsumer, double d) {
        run(new c7(failableDoubleConsumer, d));
    }

    public static <E extends Throwable> void accept(FailableIntConsumer<E> failableIntConsumer, int i) {
        run(new g3((Object) failableIntConsumer, i));
    }

    public static <E extends Throwable> void accept(FailableLongConsumer<E> failableLongConsumer, long j) {
        run(new x1(failableLongConsumer, j));
    }

    @SafeVarargs
    public static void tryWithResources(FailableRunnable<? extends Throwable> failableRunnable, FailableRunnable<? extends Throwable>... failableRunnableArr) {
        tryWithResources(failableRunnable, (FailableConsumer<Throwable, ? extends Throwable>) null, failableRunnableArr);
    }
}
