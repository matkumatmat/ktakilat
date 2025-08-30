package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"kotlin/sequences/SequencesKt___SequencesKt$minus$1", "Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SequencesKt___SequencesKt$minus$1 implements Sequence<Object> {
    public final Iterator iterator() {
        a aVar = new a(new Ref.BooleanRef(), 7);
        Intrinsics.checkNotNullParameter((Object) null, "<this>");
        Intrinsics.checkNotNullParameter(aVar, "predicate");
        new FilteringSequence((TransformingSequence) null, true, aVar);
        throw null;
    }
}
