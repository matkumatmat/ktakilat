package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/ranges/UIntProgressionIterator;", "", "Lkotlin/UInt;", "first", "last", "", "step", "<init>", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SinceKotlin(version = "1.3")
final class UIntProgressionIterator implements Iterator<UInt>, KMappedMarker {
    public final int c;
    public boolean d;
    public final int e;
    public int f;

    public UIntProgressionIterator(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this.c = i2;
        boolean z = false;
        if (i3 <= 0 ? Integer.compare(i ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ i2) >= 0 : Integer.compare(i ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ i2) <= 0) {
            z = true;
        }
        this.d = z;
        UInt.Companion companion = UInt.d;
        this.e = i3;
        this.f = !z ? i2 : i;
    }

    public final boolean hasNext() {
        return this.d;
    }

    public final Object next() {
        int i = this.f;
        if (i != this.c) {
            UInt.Companion companion = UInt.d;
            this.f = this.e + i;
        } else if (this.d) {
            this.d = false;
        } else {
            throw new NoSuchElementException();
        }
        return new UInt(i);
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
