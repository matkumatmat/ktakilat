package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1 = {"kotlinx/coroutines/internal/SystemPropsKt__SystemPropsKt", "kotlinx/coroutines/internal/SystemPropsKt__SystemProps_commonKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
public final class SystemPropsKt {
    public static final int a() {
        return SystemPropsKt__SystemPropsKt.f806a;
    }

    public static final long b(long j, long j2, long j3, String str) {
        String c = c(str);
        if (c == null) {
            return j;
        }
        Long P = StringsKt.P(c);
        if (P != null) {
            long longValue = P.longValue();
            if (j2 <= longValue && longValue <= j3) {
                return longValue;
            }
            throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + longValue + '\'').toString());
        }
        throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + c + '\'').toString());
    }

    public static final String c(String str) {
        int i = SystemPropsKt__SystemPropsKt.f806a;
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static int d(String str, int i, int i2, int i3, int i4) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return (int) b((long) i, (long) i2, (long) i3, str);
    }
}
