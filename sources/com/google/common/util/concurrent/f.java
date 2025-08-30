package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Striped;

public final /* synthetic */ class f implements Supplier {
    public final /* synthetic */ int c;

    public /* synthetic */ f(int i) {
        this.c = i;
    }

    public final Object get() {
        switch (this.c) {
            case 0:
                return new Striped.WeakSafeReadWriteLock();
            default:
                return new Striped.PaddedLock();
        }
    }
}
