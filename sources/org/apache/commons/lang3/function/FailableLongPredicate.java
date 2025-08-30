package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
public interface FailableLongPredicate<E extends Throwable> {
    public static final FailableLongPredicate FALSE = new g8(1);
    public static final FailableLongPredicate TRUE = new g8(2);

    FailableLongPredicate<E> and(FailableLongPredicate<E> failableLongPredicate);

    FailableLongPredicate<E> negate();

    FailableLongPredicate<E> or(FailableLongPredicate<E> failableLongPredicate);

    boolean test(long j) throws Throwable;
}
