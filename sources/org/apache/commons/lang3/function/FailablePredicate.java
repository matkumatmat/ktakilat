package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
public interface FailablePredicate<T, E extends Throwable> {
    public static final FailablePredicate FALSE = new g8(10);
    public static final FailablePredicate TRUE = new g8(11);

    FailablePredicate<T, E> and(FailablePredicate<? super T, E> failablePredicate);

    FailablePredicate<T, E> negate();

    FailablePredicate<T, E> or(FailablePredicate<? super T, E> failablePredicate);

    boolean test(T t) throws Throwable;
}
