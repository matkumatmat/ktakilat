package com.google.common.collect;

import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Map;

public final /* synthetic */ class a implements Predicate {
    public final /* synthetic */ Predicate c;

    public /* synthetic */ a(Predicate predicate) {
        this.c = predicate;
    }

    public final boolean apply(Object obj) {
        return this.c.apply(Multisets.immutableEntry(((Map.Entry) obj).getKey(), ((Collection) ((Map.Entry) obj).getValue()).size()));
    }
}
