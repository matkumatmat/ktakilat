package kotlin.io;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/io/FileWalkDirection;", "", "TOP_DOWN", "BOTTOM_UP", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum FileWalkDirection {
    ;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: kotlin.io.FileWalkDirection[]} */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Enum, kotlin.io.FileWalkDirection] */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.lang.Enum, kotlin.io.FileWalkDirection] */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            r1 = 0
            kotlin.io.FileWalkDirection r2 = new kotlin.io.FileWalkDirection
            java.lang.String r3 = "TOP_DOWN"
            r2.<init>(r3, r1)
            TOP_DOWN = r2
            kotlin.io.FileWalkDirection r3 = new kotlin.io.FileWalkDirection
            java.lang.String r4 = "BOTTOM_UP"
            r3.<init>(r4, r0)
            BOTTOM_UP = r3
            r4 = 2
            kotlin.io.FileWalkDirection[] r4 = new kotlin.io.FileWalkDirection[r4]
            r4[r1] = r2
            r4[r0] = r3
            c = r4
            kotlin.enums.EnumEntries r0 = kotlin.enums.EnumEntriesKt.a(r4)
            d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FileWalkDirection.<clinit>():void");
    }

    @NotNull
    public static EnumEntries<FileWalkDirection> getEntries() {
        return d;
    }
}
