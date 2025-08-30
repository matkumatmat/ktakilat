package dagger.internal;

import dagger.internal.AbstractMapFactory;
import java.util.Collections;
import java.util.Map;

public final class MapFactory<K, V> extends AbstractMapFactory<K, V, V> {

    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, V> {
    }

    static {
        Map emptyMap = Collections.emptyMap();
        if (emptyMap != null) {
            new InstanceFactory(emptyMap);
            return;
        }
        throw new NullPointerException("instance cannot be null");
    }

    public final Object get() {
        throw null;
    }
}
