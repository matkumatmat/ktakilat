package kotlin;

import kotlin.enums.EnumEntries;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/LazyThreadSafetyMode;", "", "SYNCHRONIZED", "PUBLICATION", "NONE", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum LazyThreadSafetyMode {
    ;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: kotlin.LazyThreadSafetyMode[]} */
    /* JADX WARNING: type inference failed for: r3v0, types: [kotlin.LazyThreadSafetyMode, java.lang.Enum] */
    /* JADX WARNING: type inference failed for: r4v1, types: [kotlin.LazyThreadSafetyMode, java.lang.Enum] */
    /* JADX WARNING: type inference failed for: r5v1, types: [kotlin.LazyThreadSafetyMode, java.lang.Enum] */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 2
            r1 = 1
            r2 = 0
            kotlin.LazyThreadSafetyMode r3 = new kotlin.LazyThreadSafetyMode
            java.lang.String r4 = "SYNCHRONIZED"
            r3.<init>(r4, r2)
            SYNCHRONIZED = r3
            kotlin.LazyThreadSafetyMode r4 = new kotlin.LazyThreadSafetyMode
            java.lang.String r5 = "PUBLICATION"
            r4.<init>(r5, r1)
            PUBLICATION = r4
            kotlin.LazyThreadSafetyMode r5 = new kotlin.LazyThreadSafetyMode
            java.lang.String r6 = "NONE"
            r5.<init>(r6, r0)
            NONE = r5
            r6 = 3
            kotlin.LazyThreadSafetyMode[] r6 = new kotlin.LazyThreadSafetyMode[r6]
            r6[r2] = r3
            r6[r1] = r4
            r6[r0] = r5
            c = r6
            kotlin.enums.EnumEntries r0 = kotlin.enums.EnumEntriesKt.a(r6)
            d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.LazyThreadSafetyMode.<clinit>():void");
    }

    @NotNull
    public static EnumEntries<LazyThreadSafetyMode> getEntries() {
        return d;
    }
}
