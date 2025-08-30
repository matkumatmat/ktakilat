package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {
    @CheckForNull
    private T nextOrNull;

    public AbstractSequentialIterator(@CheckForNull T t) {
        this.nextOrNull = t;
    }

    @CheckForNull
    public abstract T computeNext(T t);

    public final boolean hasNext() {
        if (this.nextOrNull != null) {
            return true;
        }
        return false;
    }

    public final T next() {
        T t = this.nextOrNull;
        if (t != null) {
            this.nextOrNull = computeNext(t);
            return t;
        }
        throw new NoSuchElementException();
    }
}
