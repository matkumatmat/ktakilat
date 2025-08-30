package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/channels/TickerMode;", "", "FIXED_PERIOD", "FIXED_DELAY", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@ObsoleteCoroutinesApi
public enum TickerMode {
    ;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: kotlinx.coroutines.channels.TickerMode[]} */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Enum, kotlinx.coroutines.channels.TickerMode] */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.lang.Enum, kotlinx.coroutines.channels.TickerMode] */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            r1 = 0
            kotlinx.coroutines.channels.TickerMode r2 = new kotlinx.coroutines.channels.TickerMode
            java.lang.String r3 = "FIXED_PERIOD"
            r2.<init>(r3, r1)
            FIXED_PERIOD = r2
            kotlinx.coroutines.channels.TickerMode r3 = new kotlinx.coroutines.channels.TickerMode
            java.lang.String r4 = "FIXED_DELAY"
            r3.<init>(r4, r0)
            FIXED_DELAY = r3
            r4 = 2
            kotlinx.coroutines.channels.TickerMode[] r4 = new kotlinx.coroutines.channels.TickerMode[r4]
            r4[r1] = r2
            r4[r0] = r3
            c = r4
            kotlin.enums.EnumEntries r0 = kotlin.enums.EnumEntriesKt.a(r4)
            d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerMode.<clinit>():void");
    }

    @NotNull
    public static EnumEntries<TickerMode> getEntries() {
        return d;
    }
}
