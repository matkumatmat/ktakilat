package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IntProgressionIterator extends IntIterator {
    public final int c;
    public final int d;
    public boolean e;
    public int f;

    public IntProgressionIterator(int i, int i2, int i3) {
        this.c = i3;
        this.d = i2;
        boolean z = false;
        if (i3 <= 0 ? i >= i2 : i <= i2) {
            z = true;
        }
        this.e = z;
        this.f = !z ? i2 : i;
    }

    public final boolean hasNext() {
        return this.e;
    }

    public final int nextInt() {
        int i = this.f;
        if (i != this.d) {
            this.f = this.c + i;
        } else if (this.e) {
            this.e = false;
        } else {
            throw new NoSuchElementException();
        }
        return i;
    }
}
