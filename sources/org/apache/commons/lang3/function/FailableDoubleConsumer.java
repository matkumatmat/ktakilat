package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
public interface FailableDoubleConsumer<E extends Throwable> {
    public static final FailableDoubleConsumer NOP = new x2(11);

    void accept(double d) throws Throwable;

    FailableDoubleConsumer<E> andThen(FailableDoubleConsumer<E> failableDoubleConsumer);
}
