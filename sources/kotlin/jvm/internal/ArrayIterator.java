package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/jvm/internal/ArrayIterator;", "T", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class ArrayIterator<T> implements Iterator<T>, KMappedMarker {
    public final Object[] c;
    public int d;

    public ArrayIterator(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "array");
        this.c = objArr;
    }

    public final boolean hasNext() {
        if (this.d < this.c.length) {
            return true;
        }
        return false;
    }

    public final Object next() {
        try {
            Object[] objArr = this.c;
            int i = this.d;
            this.d = i + 1;
            return objArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.d--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
