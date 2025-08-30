package io.reactivex.internal.util;

import io.reactivex.functions.Function;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class SorterFunction<T> implements Function<List<T>, List<T>> {
    public final Object apply(Object obj) {
        List list = (List) obj;
        Collections.sort(list, (Comparator) null);
        return list;
    }
}
