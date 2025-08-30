package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
public interface FailableIntPredicate<E extends Throwable> {
    public static final FailableIntPredicate FALSE = new x2(23);
    public static final FailableIntPredicate TRUE = new x2(24);

    FailableIntPredicate<E> and(FailableIntPredicate<E> failableIntPredicate);

    FailableIntPredicate<E> negate();

    FailableIntPredicate<E> or(FailableIntPredicate<E> failableIntPredicate);

    boolean test(int i) throws Throwable;
}
