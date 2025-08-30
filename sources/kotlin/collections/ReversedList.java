package kotlin.collections;

import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/collections/ReversedList;", "T", "Lkotlin/collections/AbstractMutableList;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class ReversedList<T> extends AbstractMutableList<T> {
    public final void add(int i, Object obj) {
        CollectionsKt__ReversedViewsKt.c(this, i);
        throw null;
    }

    public final void clear() {
        throw null;
    }

    public final Object get(int i) {
        CollectionsKt__ReversedViewsKt.b(this, i);
        throw null;
    }

    public final int getSize() {
        throw null;
    }

    public final Iterator iterator() {
        CollectionsKt__ReversedViewsKt.c(this, 0);
        throw null;
    }

    public final ListIterator listIterator() {
        CollectionsKt__ReversedViewsKt.c(this, 0);
        throw null;
    }

    public final Object removeAt(int i) {
        CollectionsKt__ReversedViewsKt.b(this, i);
        throw null;
    }

    public final Object set(int i, Object obj) {
        CollectionsKt__ReversedViewsKt.b(this, i);
        throw null;
    }

    public final ListIterator listIterator(int i) {
        CollectionsKt__ReversedViewsKt.c(this, i);
        throw null;
    }
}
