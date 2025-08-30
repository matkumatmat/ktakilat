package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Incomplete;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class JobNode extends LockFreeLinkedListNode implements DisposableHandle, Incomplete {
    public JobSupport f;

    public final NodeList a() {
        return null;
    }

    public final void dispose() {
        JobSupport j = j();
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = JobSupport.c;
            Object obj = atomicReferenceFieldUpdater.get(j);
            if (obj instanceof JobNode) {
                if (obj == this) {
                    Empty empty = JobSupportKt.g;
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(j, obj, empty)) {
                            if (atomicReferenceFieldUpdater.get(j) != obj) {
                            }
                        } else {
                            return;
                        }
                    }
                } else {
                    return;
                }
            } else if ((obj instanceof Incomplete) && ((Incomplete) obj).a() != null) {
                i();
                return;
            } else {
                return;
            }
        }
    }

    public Job getParent() {
        return j();
    }

    public final boolean isActive() {
        return true;
    }

    public final JobSupport j() {
        JobSupport jobSupport = this.f;
        if (jobSupport != null) {
            return jobSupport;
        }
        Intrinsics.k("job");
        throw null;
    }

    public abstract boolean k();

    public abstract void l(Throwable th);

    public final String toString() {
        return getClass().getSimpleName() + '@' + DebugStringsKt.a(this) + "[job@" + DebugStringsKt.a(j()) + ']';
    }
}
