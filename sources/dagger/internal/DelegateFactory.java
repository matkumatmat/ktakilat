package dagger.internal;

public final class DelegateFactory<T> implements Factory<T> {
    public final Object get() {
        throw new IllegalStateException();
    }
}
