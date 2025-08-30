package kotlin.reflect;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/KVariance;", "", "INVARIANT", "IN", "OUT", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SinceKotlin(version = "1.1")
public enum KVariance {
    ;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: kotlin.reflect.KVariance[]} */
    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Enum, kotlin.reflect.KVariance] */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.lang.Enum, kotlin.reflect.KVariance] */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.lang.Enum, kotlin.reflect.KVariance] */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 2
            r1 = 1
            r2 = 0
            kotlin.reflect.KVariance r3 = new kotlin.reflect.KVariance
            java.lang.String r4 = "INVARIANT"
            r3.<init>(r4, r2)
            INVARIANT = r3
            kotlin.reflect.KVariance r4 = new kotlin.reflect.KVariance
            java.lang.String r5 = "IN"
            r4.<init>(r5, r1)
            IN = r4
            kotlin.reflect.KVariance r5 = new kotlin.reflect.KVariance
            java.lang.String r6 = "OUT"
            r5.<init>(r6, r0)
            OUT = r5
            r6 = 3
            kotlin.reflect.KVariance[] r6 = new kotlin.reflect.KVariance[r6]
            r6[r2] = r3
            r6[r1] = r4
            r6[r0] = r5
            c = r6
            kotlin.enums.EnumEntries r0 = kotlin.enums.EnumEntriesKt.a(r6)
            d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.KVariance.<clinit>():void");
    }

    @NotNull
    public static EnumEntries<KVariance> getEntries() {
        return d;
    }
}
