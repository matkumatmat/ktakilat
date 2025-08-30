package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010(\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"kotlin/sequences/FlatteningSequence$iterator$1", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlatteningSequence$iterator$1 implements Iterator<Object>, KMappedMarker {
    public int c;

    public final boolean hasNext() {
        int i = this.c;
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return false;
        }
        throw null;
    }

    public final Object next() {
        int i = this.c;
        if (i == 2) {
            throw new NoSuchElementException();
        } else if (i == 0) {
            throw null;
        } else {
            this.c = 0;
            Intrinsics.c((Object) null);
            throw null;
        }
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
