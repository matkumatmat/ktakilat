package kotlin.sequences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"kotlin/sequences/SequencesKt___SequencesKt$sortedWith$1", "Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SequencesKt___SequencesKt$sortedWith$1 implements Sequence<Object> {
    public final Iterator iterator() {
        ArrayList b = SequencesKt___SequencesKt.b();
        Intrinsics.checkNotNullParameter(b, "<this>");
        Intrinsics.checkNotNullParameter((Object) null, "comparator");
        if (b.size() > 1) {
            Collections.sort(b, (Comparator) null);
        }
        return b.iterator();
    }
}
