package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/InvokeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class InvokeOnCompletion extends JobNode {
    public final Function1 g;

    public InvokeOnCompletion(Function1 function1) {
        this.g = function1;
    }

    public final boolean k() {
        return false;
    }

    public final void l(Throwable th) {
        this.g.invoke(th);
    }
}
