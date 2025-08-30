package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
public interface FailableBiPredicate<T, U, E extends Throwable> {
    public static final FailableBiPredicate FALSE = new x2(8);
    public static final FailableBiPredicate TRUE = new x2(9);

    FailableBiPredicate<T, U, E> and(FailableBiPredicate<? super T, ? super U, E> failableBiPredicate);

    FailableBiPredicate<T, U, E> negate();

    FailableBiPredicate<T, U, E> or(FailableBiPredicate<? super T, ? super U, E> failableBiPredicate);

    boolean test(T t, U u) throws Throwable;
}
