package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/NonCancellable;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NonCancellable extends AbstractCoroutineContextElement implements Job {
    public static final NonCancellable c = new AbstractCoroutineContextElement(Job.Key.c);

    public final void c(CancellationException cancellationException) {
    }

    public final Object e(ContinuationImpl continuationImpl) {
        throw new UnsupportedOperationException("This job is always active");
    }

    public final DisposableHandle f(boolean z, boolean z2, Function1 function1) {
        return NonDisposableHandle.c;
    }

    public final CancellationException g() {
        throw new IllegalStateException("This job is always active");
    }

    public final boolean isActive() {
        return true;
    }

    public final boolean isCancelled() {
        return false;
    }

    public final ChildHandle j(JobSupport jobSupport) {
        return NonDisposableHandle.c;
    }

    public final DisposableHandle p(Function1 function1) {
        return NonDisposableHandle.c;
    }

    public final boolean start() {
        return false;
    }

    public final String toString() {
        return "NonCancellable";
    }

    public final boolean y() {
        throw null;
    }
}
