package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/ranges/CharProgressionIterator;", "Lkotlin/collections/CharIterator;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CharProgressionIterator extends CharIterator {
    public final int c;
    public final int d;
    public boolean e;
    public int f;

    public CharProgressionIterator(char c2, int i) {
        this.c = i;
        this.d = c2;
        boolean z = false;
        if (i <= 0 ? Intrinsics.f(1, c2) >= 0 : Intrinsics.f(1, c2) <= 0) {
            z = true;
        }
        this.e = z;
        this.f = z ? 1 : c2;
    }

    public final char a() {
        int i = this.f;
        if (i != this.d) {
            this.f = this.c + i;
        } else if (this.e) {
            this.e = false;
        } else {
            throw new NoSuchElementException();
        }
        return (char) i;
    }

    public final boolean hasNext() {
        return this.e;
    }
}
