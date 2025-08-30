package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/channels/BufferOverflow;", "", "SUSPEND", "DROP_OLDEST", "DROP_LATEST", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public enum BufferOverflow {
    ;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: kotlinx.coroutines.channels.BufferOverflow[]} */
    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Enum, kotlinx.coroutines.channels.BufferOverflow] */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.lang.Enum, kotlinx.coroutines.channels.BufferOverflow] */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.lang.Enum, kotlinx.coroutines.channels.BufferOverflow] */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 2
            r1 = 1
            r2 = 0
            kotlinx.coroutines.channels.BufferOverflow r3 = new kotlinx.coroutines.channels.BufferOverflow
            java.lang.String r4 = "SUSPEND"
            r3.<init>(r4, r2)
            SUSPEND = r3
            kotlinx.coroutines.channels.BufferOverflow r4 = new kotlinx.coroutines.channels.BufferOverflow
            java.lang.String r5 = "DROP_OLDEST"
            r4.<init>(r5, r1)
            DROP_OLDEST = r4
            kotlinx.coroutines.channels.BufferOverflow r5 = new kotlinx.coroutines.channels.BufferOverflow
            java.lang.String r6 = "DROP_LATEST"
            r5.<init>(r6, r0)
            DROP_LATEST = r5
            r6 = 3
            kotlinx.coroutines.channels.BufferOverflow[] r6 = new kotlinx.coroutines.channels.BufferOverflow[r6]
            r6[r2] = r3
            r6[r1] = r4
            r6[r0] = r5
            c = r6
            kotlin.enums.EnumEntries r0 = kotlin.enums.EnumEntriesKt.a(r6)
            d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferOverflow.<clinit>():void");
    }

    @NotNull
    public static EnumEntries<BufferOverflow> getEntries() {
        return d;
    }
}
