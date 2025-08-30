package kotlin.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/internal/RequireKotlinVersionKind;", "", "LANGUAGE_VERSION", "COMPILER_VERSION", "API_VERSION", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SinceKotlin(version = "1.2")
public enum RequireKotlinVersionKind {
    ;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: kotlin.internal.RequireKotlinVersionKind[]} */
    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Enum, kotlin.internal.RequireKotlinVersionKind] */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.lang.Enum, kotlin.internal.RequireKotlinVersionKind] */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.lang.Enum, kotlin.internal.RequireKotlinVersionKind] */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 2
            r1 = 1
            r2 = 0
            kotlin.internal.RequireKotlinVersionKind r3 = new kotlin.internal.RequireKotlinVersionKind
            java.lang.String r4 = "LANGUAGE_VERSION"
            r3.<init>(r4, r2)
            LANGUAGE_VERSION = r3
            kotlin.internal.RequireKotlinVersionKind r4 = new kotlin.internal.RequireKotlinVersionKind
            java.lang.String r5 = "COMPILER_VERSION"
            r4.<init>(r5, r1)
            COMPILER_VERSION = r4
            kotlin.internal.RequireKotlinVersionKind r5 = new kotlin.internal.RequireKotlinVersionKind
            java.lang.String r6 = "API_VERSION"
            r5.<init>(r6, r0)
            API_VERSION = r5
            r6 = 3
            kotlin.internal.RequireKotlinVersionKind[] r6 = new kotlin.internal.RequireKotlinVersionKind[r6]
            r6[r2] = r3
            r6[r1] = r4
            r6[r0] = r5
            c = r6
            kotlin.enums.EnumEntries r0 = kotlin.enums.EnumEntriesKt.a(r6)
            d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.RequireKotlinVersionKind.<clinit>():void");
    }

    @NotNull
    public static EnumEntries<RequireKotlinVersionKind> getEntries() {
        return d;
    }
}
