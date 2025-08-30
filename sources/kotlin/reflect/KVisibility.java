package kotlin.reflect;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/KVisibility;", "", "PUBLIC", "PROTECTED", "INTERNAL", "PRIVATE", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SinceKotlin(version = "1.1")
public enum KVisibility {
    ;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: kotlin.reflect.KVisibility[]} */
    /* JADX WARNING: type inference failed for: r4v0, types: [kotlin.reflect.KVisibility, java.lang.Enum] */
    /* JADX WARNING: type inference failed for: r5v1, types: [kotlin.reflect.KVisibility, java.lang.Enum] */
    /* JADX WARNING: type inference failed for: r6v1, types: [kotlin.reflect.KVisibility, java.lang.Enum] */
    /* JADX WARNING: type inference failed for: r7v1, types: [kotlin.reflect.KVisibility, java.lang.Enum] */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 3
            r1 = 2
            r2 = 1
            r3 = 0
            kotlin.reflect.KVisibility r4 = new kotlin.reflect.KVisibility
            java.lang.String r5 = "PUBLIC"
            r4.<init>(r5, r3)
            PUBLIC = r4
            kotlin.reflect.KVisibility r5 = new kotlin.reflect.KVisibility
            java.lang.String r6 = "PROTECTED"
            r5.<init>(r6, r2)
            PROTECTED = r5
            kotlin.reflect.KVisibility r6 = new kotlin.reflect.KVisibility
            java.lang.String r7 = "INTERNAL"
            r6.<init>(r7, r1)
            INTERNAL = r6
            kotlin.reflect.KVisibility r7 = new kotlin.reflect.KVisibility
            java.lang.String r8 = "PRIVATE"
            r7.<init>(r8, r0)
            PRIVATE = r7
            r8 = 4
            kotlin.reflect.KVisibility[] r8 = new kotlin.reflect.KVisibility[r8]
            r8[r3] = r4
            r8[r2] = r5
            r8[r1] = r6
            r8[r0] = r7
            c = r8
            kotlin.enums.EnumEntries r0 = kotlin.enums.EnumEntriesKt.a(r8)
            d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.KVisibility.<clinit>():void");
    }

    @NotNull
    public static EnumEntries<KVisibility> getEntries() {
        return d;
    }
}
