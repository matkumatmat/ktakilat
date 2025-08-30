package org.apache.commons.lang3.function;

import java.lang.Throwable;

public interface FailableLongUnaryOperator<E extends Throwable> {
    public static final FailableLongUnaryOperator NOP = new g8(6);

    FailableLongUnaryOperator<E> andThen(FailableLongUnaryOperator<E> failableLongUnaryOperator);

    long applyAsLong(long j) throws Throwable;

    FailableLongUnaryOperator<E> compose(FailableLongUnaryOperator<E> failableLongUnaryOperator);
}
