package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/sequences/ConstrainedOnceSequence;", "T", "Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConstrainedOnceSequence<T> implements Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference f734a;

    public ConstrainedOnceSequence(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.f734a = new AtomicReference(sequence);
    }

    public final Iterator iterator() {
        Sequence sequence = (Sequence) this.f734a.getAndSet((Object) null);
        if (sequence != null) {
            return sequence.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
