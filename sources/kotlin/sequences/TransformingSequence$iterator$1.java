package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010(\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"kotlin/sequences/TransformingSequence$iterator$1", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransformingSequence$iterator$1 implements Iterator<Object>, KMappedMarker {
    public final Iterator c;
    public final /* synthetic */ TransformingSequence d;

    public TransformingSequence$iterator$1(TransformingSequence transformingSequence) {
        this.d = transformingSequence;
        this.c = transformingSequence.f743a.iterator();
    }

    public final boolean hasNext() {
        return this.c.hasNext();
    }

    public final Object next() {
        return this.d.b.invoke(this.c.next());
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
