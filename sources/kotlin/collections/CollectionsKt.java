package kotlin.collections;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"kotlin/collections/CollectionsKt__CollectionsJVMKt", "kotlin/collections/CollectionsKt__CollectionsKt", "kotlin/collections/CollectionsKt__IterablesKt", "kotlin/collections/CollectionsKt__IteratorsJVMKt", "kotlin/collections/CollectionsKt__IteratorsKt", "kotlin/collections/CollectionsKt__MutableCollectionsJVMKt", "kotlin/collections/CollectionsKt__MutableCollectionsKt", "kotlin/collections/CollectionsKt__ReversedViewsKt", "kotlin/collections/CollectionsKt___CollectionsJvmKt", "kotlin/collections/CollectionsKt___CollectionsKt"}, k = 4, mv = {2, 1, 0}, xi = 49)
public final class CollectionsKt extends CollectionsKt___CollectionsKt {
    private CollectionsKt() {
    }

    public static List A(Iterable iterable, int i) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(ba.l(i, "Requested element count ", " is less than zero.").toString());
        } else if (i == 0) {
            return EmptyList.INSTANCE;
        } else {
            if (iterable instanceof Collection) {
                if (i >= ((Collection) iterable).size()) {
                    return D(iterable);
                }
                if (i == 1) {
                    return s(l(iterable));
                }
            }
            ArrayList arrayList = new ArrayList(i);
            int i2 = 0;
            for (Object add : iterable) {
                arrayList.add(add);
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return CollectionsKt__CollectionsKt.a(arrayList);
        }
    }

    public static void B(int i, Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "array");
        if (i < objArr.length) {
            objArr[i] = null;
        }
    }

    public static void C() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static List D(Iterable iterable) {
        ArrayList arrayList;
        Object obj;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        boolean z = iterable instanceof Collection;
        if (z) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return EmptyList.INSTANCE;
            }
            if (size != 1) {
                return E(collection);
            }
            if (iterable instanceof List) {
                obj = ((List) iterable).get(0);
            } else {
                obj = collection.iterator().next();
            }
            return s(obj);
        }
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (z) {
            arrayList = E((Collection) iterable);
        } else {
            ArrayList arrayList2 = new ArrayList();
            CollectionsKt___CollectionsKt.e(iterable, arrayList2);
            arrayList = arrayList2;
        }
        return CollectionsKt__CollectionsKt.a(arrayList);
    }

    public static ArrayList E(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return new ArrayList(collection);
    }

    public static LinkedHashSet F(Set set) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        if (set instanceof Collection) {
            return new LinkedHashSet(set);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        CollectionsKt___CollectionsKt.e(set, linkedHashSet);
        return linkedHashSet;
    }

    public static Set G(Iterable iterable) {
        Set set;
        Object obj;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return EmptySet.INSTANCE;
            }
            if (size != 1) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.c(collection.size()));
                CollectionsKt___CollectionsKt.e(iterable, linkedHashSet);
                return linkedHashSet;
            }
            if (iterable instanceof List) {
                obj = ((List) iterable).get(0);
            } else {
                obj = collection.iterator().next();
            }
            Set singleton = Collections.singleton(obj);
            Intrinsics.checkNotNullExpressionValue(singleton, "singleton(...)");
            return singleton;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        CollectionsKt___CollectionsKt.e(iterable, linkedHashSet2);
        Intrinsics.checkNotNullParameter(linkedHashSet2, "<this>");
        int size2 = linkedHashSet2.size();
        if (size2 == 0) {
            set = EmptySet.INSTANCE;
        } else if (size2 != 1) {
            return linkedHashSet2;
        } else {
            set = Collections.singleton(linkedHashSet2.iterator().next());
            Intrinsics.checkNotNullExpressionValue(set, "singleton(...)");
        }
        return set;
    }

    public static void f(Collection collection, Iterable iterable) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(iterable, MessengerShareContentUtility.ELEMENTS);
        if (iterable instanceof Collection) {
            collection.addAll((Collection) iterable);
            return;
        }
        for (Object add : iterable) {
            collection.add(add);
        }
    }

    public static void g(Collection collection, Object[] objArr) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(objArr, MessengerShareContentUtility.ELEMENTS);
        collection.addAll(ArraysKt.c(objArr));
    }

    public static int h(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return 10;
    }

    public static boolean i(Iterable iterable, Serializable serializable) {
        int i;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(serializable);
        }
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (!(iterable instanceof List)) {
            Iterator it = iterable.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                Object next = it.next();
                if (i2 < 0) {
                    C();
                    throw null;
                } else if (Intrinsics.a(serializable, next)) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
        } else {
            i = ((List) iterable).indexOf(serializable);
        }
        if (i >= 0) {
            return true;
        }
        return false;
    }

    public static List j(Iterable iterable) {
        ArrayList arrayList;
        Object obj;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size() - 1;
            if (size <= 0) {
                return EmptyList.INSTANCE;
            }
            if (size == 1) {
                Intrinsics.checkNotNullParameter(iterable, "<this>");
                if (iterable instanceof List) {
                    obj = q((List) iterable);
                } else {
                    Iterator it = iterable.iterator();
                    if (it.hasNext()) {
                        Object next = it.next();
                        while (it.hasNext()) {
                            next = it.next();
                        }
                        obj = next;
                    } else {
                        throw new NoSuchElementException("Collection is empty.");
                    }
                }
                return s(obj);
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    List list = (List) iterable;
                    int size2 = list.size();
                    for (int i = 1; i < size2; i++) {
                        arrayList.add(list.get(i));
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(1);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i2 = 0;
        for (Object next2 : iterable) {
            if (i2 >= 1) {
                arrayList.add(next2);
            } else {
                i2++;
            }
        }
        return CollectionsKt__CollectionsKt.a(arrayList);
    }

    public static ArrayList k(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(arrayList, "destination");
        for (Object next : iterable) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static Object l(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return m((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static Object m(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static int n(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.size() - 1;
    }

    public static String p(Iterable iterable, CharSequence charSequence, String str, String str2, Function1 function1, int i) {
        String str3;
        String str4;
        if ((i & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence2 = charSequence;
        if ((i & 2) != 0) {
            str3 = "";
        } else {
            str3 = str;
        }
        if ((i & 4) != 0) {
            str4 = "";
        } else {
            str4 = str2;
        }
        if ((i & 32) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(charSequence2, "separator");
        Intrinsics.checkNotNullParameter(str3, "prefix");
        Intrinsics.checkNotNullParameter(str4, "postfix");
        Intrinsics.checkNotNullParameter("...", "truncated");
        StringBuilder sb = new StringBuilder();
        CollectionsKt___CollectionsKt.d(iterable, sb, charSequence2, str3, str4, -1, "...", function1);
        return sb.toString();
    }

    public static Object q(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(n(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static Object r(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return e.f(list, 1);
    }

    public static List s(Object obj) {
        List singletonList = Collections.singletonList(obj);
        Intrinsics.checkNotNullExpressionValue(singletonList, "singletonList(...)");
        return singletonList;
    }

    public static List t(Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, MessengerShareContentUtility.ELEMENTS);
        if (objArr.length > 0) {
            return ArraysKt.c(objArr);
        }
        return EmptyList.INSTANCE;
    }

    public static ArrayList u(Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, MessengerShareContentUtility.ELEMENTS);
        if (objArr.length == 0) {
            return new ArrayList();
        }
        return new ArrayList(new ArrayAsCollection(objArr, true));
    }

    public static ArrayList v(Collection collection, Iterable iterable) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(iterable, MessengerShareContentUtility.ELEMENTS);
        if (iterable instanceof Collection) {
            Collection collection2 = (Collection) iterable;
            ArrayList arrayList = new ArrayList(collection2.size() + collection.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        f(arrayList2, iterable);
        return arrayList2;
    }

    public static ArrayList w(Collection collection, Object obj) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static void x(Set set, Function1 function1) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (!((Boolean) function1.invoke(it.next())).booleanValue()) {
                it.remove();
            }
        }
    }

    public static void y(ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
    }

    public static List z(Iterable iterable, Comparator comparator) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        boolean z = iterable instanceof Collection;
        if (z) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return D(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            Intrinsics.checkNotNullParameter(array, "<this>");
            Intrinsics.checkNotNullParameter(comparator, "comparator");
            if (array.length > 1) {
                Arrays.sort(array, comparator);
            }
            return ArraysKt.c(array);
        }
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (z) {
            arrayList = E((Collection) iterable);
        } else {
            ArrayList arrayList2 = new ArrayList();
            CollectionsKt___CollectionsKt.e(iterable, arrayList2);
            arrayList = arrayList2;
        }
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (arrayList.size() <= 1) {
            return arrayList;
        }
        Collections.sort(arrayList, comparator);
        return arrayList;
    }
}
