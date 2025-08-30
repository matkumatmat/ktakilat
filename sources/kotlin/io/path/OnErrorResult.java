package kotlin.io.path;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.8")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/io/path/OnErrorResult;", "", "SKIP_SUBTREE", "TERMINATE", "kotlin-stdlib-jdk7"}, k = 1, mv = {2, 1, 0}, xi = 48)
@ExperimentalPathApi
public enum OnErrorResult {
    ;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: kotlin.io.path.OnErrorResult[]} */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Enum, kotlin.io.path.OnErrorResult] */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.lang.Enum, kotlin.io.path.OnErrorResult] */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            r1 = 0
            kotlin.io.path.OnErrorResult r2 = new kotlin.io.path.OnErrorResult
            java.lang.String r3 = "SKIP_SUBTREE"
            r2.<init>(r3, r1)
            SKIP_SUBTREE = r2
            kotlin.io.path.OnErrorResult r3 = new kotlin.io.path.OnErrorResult
            java.lang.String r4 = "TERMINATE"
            r3.<init>(r4, r0)
            TERMINATE = r3
            r4 = 2
            kotlin.io.path.OnErrorResult[] r4 = new kotlin.io.path.OnErrorResult[r4]
            r4[r1] = r2
            r4[r0] = r3
            c = r4
            kotlin.enums.EnumEntries r0 = kotlin.enums.EnumEntriesKt.a(r4)
            d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.OnErrorResult.<clinit>():void");
    }

    @NotNull
    public static EnumEntries<OnErrorResult> getEntries() {
        return d;
    }
}
