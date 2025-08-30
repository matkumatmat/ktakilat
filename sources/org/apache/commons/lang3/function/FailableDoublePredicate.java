package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
public interface FailableDoublePredicate<E extends Throwable> {
    public static final FailableDoublePredicate FALSE = new x2(13);
    public static final FailableDoublePredicate TRUE = new x2(14);

    FailableDoublePredicate<E> and(FailableDoublePredicate<E> failableDoublePredicate);

    FailableDoublePredicate<E> negate();

    FailableDoublePredicate<E> or(FailableDoublePredicate<E> failableDoublePredicate);

    boolean test(double d) throws Throwable;
}
