package com.google.common.collect;

import com.google.common.collect.Table;
import java.util.Comparator;

public final /* synthetic */ class d implements Comparator {
    public final /* synthetic */ Comparator c;
    public final /* synthetic */ Comparator d;

    public /* synthetic */ d(Comparator comparator, Comparator comparator2) {
        this.c = comparator;
        this.d = comparator2;
    }

    public final int compare(Object obj, Object obj2) {
        return RegularImmutableTable.lambda$forCells$0(this.c, this.d, (Table.Cell) obj, (Table.Cell) obj2);
    }
}
