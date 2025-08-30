package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00032\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/ranges/IntProgression;", "", "", "f", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class IntProgression implements Iterable<Integer>, KMappedMarker {
    @NotNull
    public static final Companion f = new Companion((DefaultConstructorMarker) null);
    public final int c;
    public final int d;
    public final int e;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/ranges/IntProgression$Companion;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public IntProgression(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i3 != Integer.MIN_VALUE) {
            this.c = i;
            this.d = ProgressionUtilKt.a(i, i2, i3);
            this.e = i3;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        r3 = (kotlin.ranges.IntProgression) r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof kotlin.ranges.IntProgression
            if (r0 == 0) goto L_0x0029
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L_0x0013
            r0 = r3
            kotlin.ranges.IntProgression r0 = (kotlin.ranges.IntProgression) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0027
        L_0x0013:
            kotlin.ranges.IntProgression r3 = (kotlin.ranges.IntProgression) r3
            int r0 = r3.c
            int r1 = r2.c
            if (r1 != r0) goto L_0x0029
            int r0 = r2.d
            int r1 = r3.d
            if (r0 != r1) goto L_0x0029
            int r0 = r2.e
            int r3 = r3.e
            if (r0 != r3) goto L_0x0029
        L_0x0027:
            r3 = 1
            goto L_0x002a
        L_0x0029:
            r3 = 0
        L_0x002a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.IntProgression.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.c * 31) + this.d) * 31) + this.e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000c A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEmpty() {
        /*
            r5 = this;
            int r0 = r5.e
            r1 = 0
            r2 = 1
            int r3 = r5.d
            int r4 = r5.c
            if (r0 <= 0) goto L_0x000e
            if (r4 <= r3) goto L_0x0011
        L_0x000c:
            r1 = 1
            goto L_0x0011
        L_0x000e:
            if (r4 >= r3) goto L_0x0011
            goto L_0x000c
        L_0x0011:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.IntProgression.isEmpty():boolean");
    }

    public final Iterator iterator() {
        return new IntProgressionIterator(this.c, this.d, this.e);
    }

    public String toString() {
        StringBuilder sb;
        int i = this.d;
        int i2 = this.c;
        int i3 = this.e;
        if (i3 > 0) {
            sb.append(i2);
            sb.append("..");
            sb.append(i);
            sb.append(" step ");
            sb.append(i3);
        } else {
            sb = new StringBuilder();
            sb.append(i2);
            sb.append(" downTo ");
            sb.append(i);
            sb.append(" step ");
            sb.append(-i3);
        }
        return sb.toString();
    }
}
