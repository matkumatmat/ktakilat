package kotlin.collections;

import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.IntProgression;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__ReversedViewsKt extends CollectionsKt__MutableCollectionsKt {
    public static final void b(List list, int i) {
        if (i < 0 || i > CollectionsKt.n(list)) {
            StringBuilder t = ba.t(i, "Element index ", " must be in range [");
            t.append(new IntProgression(0, CollectionsKt.n(list), 1));
            t.append("].");
            throw new IndexOutOfBoundsException(t.toString());
        }
        CollectionsKt.n(list);
    }

    public static final void c(List list, int i) {
        if (i < 0 || i > list.size()) {
            StringBuilder t = ba.t(i, "Position index ", " must be in range [");
            t.append(new IntProgression(0, list.size(), 1));
            t.append("].");
            throw new IndexOutOfBoundsException(t.toString());
        }
        list.size();
    }
}
