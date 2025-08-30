package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/ChildHandleNode;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/ChildHandle;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ChildHandleNode extends JobNode implements ChildHandle {
    public final JobSupport g;

    public ChildHandleNode(JobSupport jobSupport) {
        this.g = jobSupport;
    }

    public final boolean b(Throwable th) {
        return j().N(th);
    }

    public final boolean k() {
        return true;
    }

    public final void l(Throwable th) {
        this.g.J(j());
    }
}
