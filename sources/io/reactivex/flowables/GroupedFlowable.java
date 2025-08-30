package io.reactivex.flowables;

import io.reactivex.Flowable;

public abstract class GroupedFlowable<K, T> extends Flowable<T> {
    public final Object d;

    public GroupedFlowable(Object obj) {
        this.d = obj;
    }
}
