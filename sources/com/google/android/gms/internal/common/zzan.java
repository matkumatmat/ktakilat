package com.google.android.gms.internal.common;

import java.util.Iterator;
import org.jspecify.annotations.NullMarked;

@NullMarked
public abstract class zzan implements Iterator {
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
