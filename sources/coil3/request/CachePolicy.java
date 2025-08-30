package coil3.request;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\r\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcoil3/request/CachePolicy;", "", "", "c", "Z", "getReadEnabled", "()Z", "readEnabled", "d", "getWriteEnabled", "writeEnabled", "ENABLED", "READ_ONLY", "WRITE_ONLY", "DISABLED", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public enum CachePolicy {
    ENABLED(true, true),
    READ_ONLY(true, false),
    WRITE_ONLY(false, true),
    DISABLED(false, false);
    
    public final boolean c;
    public final boolean d;

    static {
        CachePolicy[] cachePolicyArr;
        f = EnumEntriesKt.a(cachePolicyArr);
    }

    /* access modifiers changed from: public */
    CachePolicy(boolean z, boolean z2) {
        this.c = z;
        this.d = z2;
    }

    @NotNull
    public static EnumEntries<CachePolicy> getEntries() {
        return f;
    }

    public final boolean getReadEnabled() {
        return this.c;
    }

    public final boolean getWriteEnabled() {
        return this.d;
    }
}
