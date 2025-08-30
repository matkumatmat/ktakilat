package kotlinx.coroutines.tasks;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.JobSupport;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001R\u0011\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016X\u0005R\u000b\u0010\u0006\u001a\u00020\u00058\u0016X\u0005R\u000b\u0010\u0007\u001a\u00020\u00058\u0016X\u0005R\u000b\u0010\b\u001a\u00020\u00058\u0016X\u0005R\u000f\u0010\n\u001a\u0006\u0012\u0002\b\u00030\t8\u0016X\u0005R\u0011\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b8\u0016X\u0005R\u000b\u0010\u000e\u001a\u00020\r8\u0016X\u0005R\r\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0016X\u0005¨\u0006\u0010"}, d2 = {"kotlinx/coroutines/tasks/TasksKt$asDeferredImpl$3", "Lkotlinx/coroutines/Deferred;", "Lkotlin/sequences/Sequence;", "Lkotlinx/coroutines/Job;", "children", "", "isActive", "isCancelled", "isCompleted", "Lkotlin/coroutines/CoroutineContext$Key;", "key", "Lkotlinx/coroutines/selects/SelectClause1;", "onAwait", "Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "parent", "kotlinx-coroutines-play-services"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TasksKt$asDeferredImpl$3 implements Deferred<Object> {
    public final void c(CancellationException cancellationException) {
        throw null;
    }

    public final Object d() {
        throw null;
    }

    public final Object e(ContinuationImpl continuationImpl) {
        throw null;
    }

    public final DisposableHandle f(boolean z, boolean z2, Function1 function1) {
        throw null;
    }

    public final Object fold(Object obj, Function2 function2) {
        throw null;
    }

    public final CancellationException g() {
        throw null;
    }

    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        throw null;
    }

    public final CoroutineContext.Key getKey() {
        throw null;
    }

    public final boolean isActive() {
        throw null;
    }

    public final boolean isCancelled() {
        throw null;
    }

    public final ChildHandle j(JobSupport jobSupport) {
        throw null;
    }

    public final Object k(Continuation continuation) {
        throw null;
    }

    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        throw null;
    }

    public final DisposableHandle p(Function1 function1) {
        throw null;
    }

    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        throw null;
    }

    public final boolean start() {
        throw null;
    }

    public final boolean y() {
        throw null;
    }
}
