package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Segment;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b@\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003\u0001\u0004\u0001\u0004\u0018\u00010\u0003¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/internal/SegmentOrClosed;", "Lkotlinx/coroutines/internal/Segment;", "S", "", "value", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class SegmentOrClosed<S extends Segment<S>> {
    public static final Segment a(Object obj) {
        if (obj != ConcurrentLinkedListKt.f793a) {
            return (Segment) obj;
        }
        throw new IllegalStateException("Does not contain segment");
    }

    public static final boolean b(Object obj) {
        if (obj == ConcurrentLinkedListKt.f793a) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SegmentOrClosed)) {
            return false;
        }
        ((SegmentOrClosed) obj).getClass();
        if (!Intrinsics.a((Object) null, (Object) null)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "SegmentOrClosed(value=null)";
    }
}
