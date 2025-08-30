package dagger.internal;

import dagger.Lazy;

public final class InstanceFactory<T> implements Factory<T>, Lazy<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Object f648a;

    public InstanceFactory(Object obj) {
        this.f648a = obj;
    }

    public final Object get() {
        return this.f648a;
    }
}
