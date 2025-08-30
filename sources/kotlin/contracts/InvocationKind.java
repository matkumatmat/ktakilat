package kotlin.contracts;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import kotlin.internal.ContractsDsl;
import org.jetbrains.annotations.NotNull;

@ExperimentalContracts
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/contracts/InvocationKind;", "", "AT_MOST_ONCE", "AT_LEAST_ONCE", "EXACTLY_ONCE", "UNKNOWN", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@ContractsDsl
public enum InvocationKind {
    ;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: kotlin.contracts.InvocationKind[]} */
    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Enum, kotlin.contracts.InvocationKind] */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.lang.Enum, kotlin.contracts.InvocationKind] */
    /* JADX WARNING: type inference failed for: r6v1, types: [java.lang.Enum, kotlin.contracts.InvocationKind] */
    /* JADX WARNING: type inference failed for: r7v1, types: [java.lang.Enum, kotlin.contracts.InvocationKind] */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 3
            r1 = 2
            r2 = 1
            r3 = 0
            kotlin.contracts.InvocationKind r4 = new kotlin.contracts.InvocationKind
            java.lang.String r5 = "AT_MOST_ONCE"
            r4.<init>(r5, r3)
            AT_MOST_ONCE = r4
            kotlin.contracts.InvocationKind r5 = new kotlin.contracts.InvocationKind
            java.lang.String r6 = "AT_LEAST_ONCE"
            r5.<init>(r6, r2)
            AT_LEAST_ONCE = r5
            kotlin.contracts.InvocationKind r6 = new kotlin.contracts.InvocationKind
            java.lang.String r7 = "EXACTLY_ONCE"
            r6.<init>(r7, r1)
            EXACTLY_ONCE = r6
            kotlin.contracts.InvocationKind r7 = new kotlin.contracts.InvocationKind
            java.lang.String r8 = "UNKNOWN"
            r7.<init>(r8, r0)
            UNKNOWN = r7
            r8 = 4
            kotlin.contracts.InvocationKind[] r8 = new kotlin.contracts.InvocationKind[r8]
            r8[r3] = r4
            r8[r2] = r5
            r8[r1] = r6
            r8[r0] = r7
            c = r8
            kotlin.enums.EnumEntries r0 = kotlin.enums.EnumEntriesKt.a(r8)
            d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.contracts.InvocationKind.<clinit>():void");
    }

    @NotNull
    public static EnumEntries<InvocationKind> getEntries() {
        return d;
    }
}
