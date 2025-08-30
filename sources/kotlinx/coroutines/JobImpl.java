package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableJob;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@PublishedApi
public class JobImpl extends JobSupport implements CompletableJob {
    public final boolean e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JobImpl(Job job) {
        super(true);
        ChildHandleNode childHandleNode;
        ChildHandleNode childHandleNode2;
        boolean z = true;
        X(job);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = JobSupport.d;
        ChildHandle childHandle = (ChildHandle) atomicReferenceFieldUpdater.get(this);
        if (childHandle instanceof ChildHandleNode) {
            childHandleNode = (ChildHandleNode) childHandle;
        } else {
            childHandleNode = null;
        }
        if (childHandleNode != null) {
            JobSupport j = childHandleNode.j();
            while (true) {
                if (!j.S()) {
                    ChildHandle childHandle2 = (ChildHandle) atomicReferenceFieldUpdater.get(j);
                    if (childHandle2 instanceof ChildHandleNode) {
                        childHandleNode2 = (ChildHandleNode) childHandle2;
                    } else {
                        childHandleNode2 = null;
                    }
                    if (childHandleNode2 == null) {
                        break;
                    }
                    j = childHandleNode2.j();
                } else {
                    break;
                }
            }
        }
        z = false;
        this.e = z;
    }

    public final boolean S() {
        return this.e;
    }

    public final boolean T() {
        return true;
    }
}
