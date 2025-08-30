package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010(\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"kotlin/sequences/FilteringSequence$iterator$1", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilteringSequence$iterator$1 implements Iterator<Object>, KMappedMarker {
    public final Iterator c;
    public int d = -1;
    public Object e;
    public final /* synthetic */ FilteringSequence f;

    public FilteringSequence$iterator$1(FilteringSequence filteringSequence) {
        this.f = filteringSequence;
        TransformingSequence transformingSequence = filteringSequence.f737a;
        transformingSequence.getClass();
        this.c = new TransformingSequence$iterator$1(transformingSequence);
    }

    public final void a() {
        Object next;
        FilteringSequence filteringSequence;
        do {
            Iterator it = this.c;
            if (it.hasNext()) {
                next = it.next();
                filteringSequence = this.f;
            } else {
                this.d = 0;
                return;
            }
        } while (((Boolean) filteringSequence.c.invoke(next)).booleanValue() != filteringSequence.b);
        this.e = next;
        this.d = 1;
    }

    public final boolean hasNext() {
        if (this.d == -1) {
            a();
        }
        if (this.d == 1) {
            return true;
        }
        return false;
    }

    public final Object next() {
        if (this.d == -1) {
            a();
        }
        if (this.d != 0) {
            Object obj = this.e;
            this.e = null;
            this.d = -1;
            return obj;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
