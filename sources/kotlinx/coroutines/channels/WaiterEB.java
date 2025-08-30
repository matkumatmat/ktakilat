package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.Waiter;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/channels/WaiterEB;", "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class WaiterEB {

    /* renamed from: a  reason: collision with root package name */
    public final Waiter f778a;

    public WaiterEB(Waiter waiter) {
        this.f778a = waiter;
    }

    public final String toString() {
        return "WaiterEB(" + this.f778a + ')';
    }
}
