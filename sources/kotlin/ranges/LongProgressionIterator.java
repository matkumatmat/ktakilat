package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.LongIterator;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/ranges/LongProgressionIterator;", "Lkotlin/collections/LongIterator;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LongProgressionIterator extends LongIterator {
    public final long c;
    public final long d;
    public boolean e;
    public long f;

    public LongProgressionIterator(long j, long j2) {
        this.c = j2;
        this.d = j;
        boolean z = false;
        int i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        int i2 = (1 > j ? 1 : (1 == j ? 0 : -1));
        if (i <= 0 ? i2 >= 0 : i2 <= 0) {
            z = true;
        }
        this.e = z;
        this.f = z ? 1 : j;
    }

    public final boolean hasNext() {
        return this.e;
    }

    public final long nextLong() {
        long j = this.f;
        if (j != this.d) {
            this.f = this.c + j;
        } else if (this.e) {
            this.e = false;
        } else {
            throw new NoSuchElementException();
        }
        return j;
    }
}
