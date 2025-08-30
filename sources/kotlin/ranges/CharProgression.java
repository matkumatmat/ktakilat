package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\f\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00032\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/ranges/CharProgression;", "", "", "e", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CharProgression implements Iterable<Character>, KMappedMarker {
    @NotNull
    public static final Companion e = new Companion((DefaultConstructorMarker) null);
    public final char c = ((char) ProgressionUtilKt.a(1, 0, 1));
    public final int d = 1;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/ranges/CharProgression$Companion;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof CharProgression) {
            if (!isEmpty() || !((CharProgression) obj).isEmpty()) {
                CharProgression charProgression = (CharProgression) obj;
                charProgression.getClass();
                if (!(this.c == charProgression.c && this.d == charProgression.d)) {
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
        return ((this.c + 31) * 31) + this.d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x000e A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEmpty() {
        /*
            r4 = this;
            int r0 = r4.d
            r1 = 0
            r2 = 1
            char r3 = r4.c
            if (r0 <= 0) goto L_0x0010
            int r0 = kotlin.jvm.internal.Intrinsics.f(r2, r3)
            if (r0 <= 0) goto L_0x0017
        L_0x000e:
            r1 = 1
            goto L_0x0017
        L_0x0010:
            int r0 = kotlin.jvm.internal.Intrinsics.f(r2, r3)
            if (r0 >= 0) goto L_0x0017
            goto L_0x000e
        L_0x0017:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.CharProgression.isEmpty():boolean");
    }

    public final Iterator iterator() {
        return new CharProgressionIterator(this.c, this.d);
    }

    public String toString() {
        StringBuilder sb;
        char c2 = this.c;
        int i = this.d;
        if (i > 0) {
            sb.append(c2);
            sb.append(" step ");
            sb.append(i);
        } else {
            sb = new StringBuilder("\u0001 downTo ");
            sb.append(c2);
            sb.append(" step ");
            sb.append(-i);
        }
        return sb.toString();
    }
}
