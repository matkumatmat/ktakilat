package kotlin.text;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/text/LinesIterator;", "", "", "State", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class LinesIterator implements Iterator<String>, KMappedMarker {
    public final String c;
    public int d;
    public int e;
    public int f;
    public int g;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"Lkotlin/text/LinesIterator$State;", "", "", "UNKNOWN", "I", "HAS_NEXT", "EXHAUSTED", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class State {
    }

    public LinesIterator(String str) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        this.c = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0041, code lost:
        r1 = r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasNext() {
        /*
            r9 = this;
            int r0 = r9.d
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x000a
            if (r0 != r2) goto L_0x0009
            r1 = 1
        L_0x0009:
            return r1
        L_0x000a:
            int r0 = r9.g
            r3 = 2
            if (r0 >= 0) goto L_0x0012
            r9.d = r3
            return r1
        L_0x0012:
            java.lang.String r0 = r9.c
            int r1 = r0.length()
            int r4 = r9.e
            int r5 = r0.length()
        L_0x001e:
            if (r4 >= r5) goto L_0x0043
            char r6 = r0.charAt(r4)
            r7 = 13
            r8 = 10
            if (r6 == r8) goto L_0x002f
            if (r6 == r7) goto L_0x002f
            int r4 = r4 + 1
            goto L_0x001e
        L_0x002f:
            if (r6 != r7) goto L_0x0040
            int r1 = r4 + 1
            int r5 = r0.length()
            if (r1 >= r5) goto L_0x0040
            char r0 = r0.charAt(r1)
            if (r0 != r8) goto L_0x0040
            goto L_0x0041
        L_0x0040:
            r3 = 1
        L_0x0041:
            r1 = r4
            goto L_0x0044
        L_0x0043:
            r3 = -1
        L_0x0044:
            r9.d = r2
            r9.g = r3
            r9.f = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.LinesIterator.hasNext():boolean");
    }

    public final Object next() {
        if (hasNext()) {
            this.d = 0;
            int i = this.f;
            int i2 = this.e;
            this.e = this.g + i;
            return this.c.subSequence(i2, i).toString();
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
