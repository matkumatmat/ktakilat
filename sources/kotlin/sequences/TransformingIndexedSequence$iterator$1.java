package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010(\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"kotlin/sequences/TransformingIndexedSequence$iterator$1", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransformingIndexedSequence$iterator$1 implements Iterator<Object>, KMappedMarker {
    public int c;
    public final /* synthetic */ TransformingIndexedSequence d;

    public TransformingIndexedSequence$iterator$1(TransformingIndexedSequence transformingIndexedSequence) {
        this.d = transformingIndexedSequence;
        transformingIndexedSequence.getClass();
        throw null;
    }

    public final boolean hasNext() {
        throw null;
    }

    public final Object next() {
        this.d.getClass();
        int i = this.c;
        this.c = i + 1;
        if (i < 0) {
            CollectionsKt.C();
            throw null;
        }
        throw null;
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
