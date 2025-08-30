package coil3.size;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcoil3/size/Precision;", "", "EXACT", "INEXACT", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public enum Precision {
    ;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: coil3.size.Precision[]} */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Enum, coil3.size.Precision] */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.lang.Enum, coil3.size.Precision] */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            r1 = 0
            coil3.size.Precision r2 = new coil3.size.Precision
            java.lang.String r3 = "EXACT"
            r2.<init>(r3, r1)
            EXACT = r2
            coil3.size.Precision r3 = new coil3.size.Precision
            java.lang.String r4 = "INEXACT"
            r3.<init>(r4, r0)
            INEXACT = r3
            r4 = 2
            coil3.size.Precision[] r4 = new coil3.size.Precision[r4]
            r4[r1] = r2
            r4[r0] = r3
            c = r4
            kotlin.enums.EnumEntries r0 = kotlin.enums.EnumEntriesKt.a(r4)
            d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.size.Precision.<clinit>():void");
    }

    @NotNull
    public static EnumEntries<Precision> getEntries() {
        return d;
    }
}
