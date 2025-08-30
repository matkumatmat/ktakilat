package io.reactivex;

import io.reactivex.annotations.Experimental;

@Experimental
public interface ObservableConverter<T, R> {
    Object apply();
}
