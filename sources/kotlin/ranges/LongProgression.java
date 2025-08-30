package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00032\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/ranges/LongProgression;", "", "", "c", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class LongProgression implements Iterable<Long>, KMappedMarker {
    @NotNull
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/ranges/LongProgression$Companion;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof LongProgression) {
            if (!isEmpty() || !((LongProgression) obj).isEmpty()) {
                ((LongProgression) obj).getClass();
                if (!(0 == 0 && 0 == 0)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j = (long) 31;
        return (int) ((((0 ^ (0 >>> 32)) + j) * j) + (0 ^ (0 >>> 32)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0012 A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEmpty() {
        /*
            r11 = this;
            r0 = 0
            r2 = 0
            r4 = 0
            r5 = 1
            r6 = 0
            r8 = 1
            int r10 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 <= 0) goto L_0x0014
            if (r0 <= 0) goto L_0x0017
        L_0x0012:
            r4 = 1
            goto L_0x0017
        L_0x0014:
            if (r0 >= 0) goto L_0x0017
            goto L_0x0012
        L_0x0017:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.LongProgression.isEmpty():boolean");
    }

    public final Iterator iterator() {
        return new LongProgressionIterator(0, 0);
    }

    public String toString() {
        StringBuilder sb;
        if (0 > 0) {
            sb.append(0);
            sb.append(" step ");
            sb.append(0);
        } else {
            sb = new StringBuilder("1 downTo ");
            sb.append(0);
            sb.append(" step ");
            sb.append(-0);
        }
        return sb.toString();
    }
}
