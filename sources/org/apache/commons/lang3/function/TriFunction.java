package org.apache.commons.lang3.function;

import java.util.function.Function;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    <W> TriFunction<T, U, V, W> andThen(Function<? super R, ? extends W> function);

    R apply(T t, U u, V v);
}
