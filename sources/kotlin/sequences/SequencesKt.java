package kotlin.sequences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"kotlin/sequences/SequencesKt__SequenceBuilderKt", "kotlin/sequences/SequencesKt__SequencesJVMKt", "kotlin/sequences/SequencesKt__SequencesKt", "kotlin/sequences/SequencesKt___SequencesJvmKt", "kotlin/sequences/SequencesKt___SequencesKt"}, k = 4, mv = {2, 1, 0}, xi = 49)
public final class SequencesKt extends SequencesKt___SequencesKt {
    public static ConstrainedOnceSequence c(Iterator it) {
        Intrinsics.checkNotNullParameter(it, "<this>");
        return d(new SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(it));
    }

    public static ConstrainedOnceSequence d(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        if (!(sequence instanceof ConstrainedOnceSequence)) {
            sequence = new ConstrainedOnceSequence(sequence);
        }
        return (ConstrainedOnceSequence) sequence;
    }

    public static Sequence e() {
        return EmptySequence.f736a;
    }

    public static Object f(FilteringSequence filteringSequence) {
        Intrinsics.checkNotNullParameter(filteringSequence, "<this>");
        FilteringSequence$iterator$1 filteringSequence$iterator$1 = new FilteringSequence$iterator$1(filteringSequence);
        if (!filteringSequence$iterator$1.hasNext()) {
            return null;
        }
        return filteringSequence$iterator$1.next();
    }

    public static ConstrainedOnceSequence g(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "nextFunction");
        return d(new GeneratorSequence(function0, new a(function0, 6)));
    }

    public static Sequence h(qd qdVar, Function1 function1) {
        Intrinsics.checkNotNullParameter(qdVar, "seedFunction");
        Intrinsics.checkNotNullParameter(function1, "nextFunction");
        return new GeneratorSequence(qdVar, function1);
    }

    public static Sequence i(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "nextFunction");
        if (obj == null) {
            return EmptySequence.f736a;
        }
        return new GeneratorSequence(new c(obj, 7), function1);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [kotlin.coroutines.Continuation, kotlin.sequences.SequenceBuilderIterator, java.util.Iterator, java.lang.Object] */
    public static Iterator j(Function2 function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        ? obj = new Object();
        obj.f = IntrinsicsKt.a(function2, obj, obj);
        return obj;
    }

    public static FilteringSequence k(Sequence sequence, Function1 function1) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        TransformingSequence transformingSequence = new TransformingSequence(sequence, function1);
        Intrinsics.checkNotNullParameter(transformingSequence, "<this>");
        return SequencesKt___SequencesKt.a(transformingSequence, new l4(3));
    }

    public static List l(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator it = sequence.iterator();
        if (!it.hasNext()) {
            return EmptyList.INSTANCE;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return CollectionsKt.s(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
