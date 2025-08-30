package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/sequences/FilteringSequence;", "T", "Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilteringSequence<T> implements Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    public final TransformingSequence f737a;
    public final boolean b;
    public final Function1 c;

    public FilteringSequence(TransformingSequence transformingSequence, boolean z, Function1 function1) {
        Intrinsics.checkNotNullParameter(transformingSequence, "sequence");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        this.f737a = transformingSequence;
        this.b = z;
        this.c = function1;
    }

    public final Iterator iterator() {
        return new FilteringSequence$iterator$1(this);
    }
}
