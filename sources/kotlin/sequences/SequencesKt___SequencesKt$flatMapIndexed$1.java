package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class SequencesKt___SequencesKt$flatMapIndexed$1 extends FunctionReferenceImpl implements Function1<Iterable<Object>, Iterator<Object>> {
    static {
        new SequencesKt___SequencesKt$flatMapIndexed$1();
    }

    public SequencesKt___SequencesKt$flatMapIndexed$1() {
        super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    public final Object invoke(Object obj) {
        Iterable iterable = (Iterable) obj;
        Intrinsics.checkNotNullParameter(iterable, "p0");
        return iterable.iterator();
    }
}
