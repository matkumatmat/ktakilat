package io.reactivex.internal.util;

import io.reactivex.functions.BiFunction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class MergerBiFunction<T> implements BiFunction<List<T>, List<T>, List<T>> {
    public final Object apply(Object obj, Object obj2) {
        Object obj3;
        Object obj4;
        List list = (List) obj;
        List list2 = (List) obj2;
        int size = list2.size() + list.size();
        if (size == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(size);
        Iterator it = list.iterator();
        Iterator it2 = list2.iterator();
        if (it.hasNext()) {
            obj3 = it.next();
        } else {
            obj3 = null;
        }
        if (it2.hasNext()) {
            obj4 = it2.next();
        } else {
            obj4 = null;
        }
        if (obj3 == null || obj4 == null) {
            if (obj3 != null) {
                arrayList.add(obj3);
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            } else {
                arrayList.add(obj4);
                while (it2.hasNext()) {
                    arrayList.add(it2.next());
                }
            }
            return arrayList;
        }
        throw null;
    }
}
