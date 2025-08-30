package com.google.common.collect;

import java.util.Comparator;

public final /* synthetic */ class c implements Comparator {
    public final /* synthetic */ Comparator c;

    public /* synthetic */ c(Comparator comparator) {
        this.c = comparator;
    }

    public final int compare(Object obj, Object obj2) {
        return this.c.compare(((PeekingIterator) obj).peek(), ((PeekingIterator) obj2).peek());
    }
}
