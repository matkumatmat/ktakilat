package kotlinx.coroutines;

import androidx.core.location.LocationRequestCompat;
import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u001e\b\u0002\u0010\u0002\u001a\u0004\b\u0000\u0010\u0000\"\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0003"}, d2 = {"T", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "Queue", "kotlinx-coroutines-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class EventLoop_commonKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Symbol f768a = new Symbol("REMOVED_TASK");
    public static final Symbol b = new Symbol("CLOSED_EMPTY");

    public static final long a(long j) {
        if (j <= 0) {
            return 0;
        }
        return j >= 9223372036854L ? LocationRequestCompat.PASSIVE_INTERVAL : 1000000 * j;
    }
}
