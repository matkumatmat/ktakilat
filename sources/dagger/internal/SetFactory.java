package dagger.internal;

import java.util.Collections;
import java.util.Set;

public final class SetFactory<T> implements Factory<Set<T>> {

    public static final class Builder<T> {
    }

    static {
        Set emptySet = Collections.emptySet();
        if (emptySet != null) {
            new InstanceFactory(emptySet);
            return;
        }
        throw new NullPointerException("instance cannot be null");
    }

    public final Object get() {
        throw null;
    }
}
