package kotlinx.coroutines.internal;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/internal/Removed;", "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class Removed {

    /* renamed from: a  reason: collision with root package name */
    public final LockFreeLinkedListNode f803a;

    public Removed(LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.f803a = lockFreeLinkedListNode;
    }

    public final String toString() {
        return "Removed[" + this.f803a + ']';
    }
}
