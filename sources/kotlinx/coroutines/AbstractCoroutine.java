package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@InternalCoroutinesApi
public abstract class AbstractCoroutine<T> extends JobSupport implements Job, Continuation<T>, CoroutineScope {
    public final CoroutineContext e;

    public AbstractCoroutine(CoroutineContext coroutineContext, boolean z) {
        super(z);
        X((Job) coroutineContext.get(Job.Key.c));
        this.e = coroutineContext.plus(this);
    }

    public final String M() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    public final void W(CompletionHandlerException completionHandlerException) {
        CoroutineExceptionHandlerKt.a(this.e, completionHandlerException);
    }

    public final void g0(Object obj) {
        boolean z;
        if (obj instanceof CompletedExceptionally) {
            CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
            Throwable th = completedExceptionally.f764a;
            if (CompletedExceptionally.b.get(completedExceptionally) != 0) {
                z = true;
            } else {
                z = false;
            }
            p0(z, th);
            return;
        }
        q0(obj);
    }

    public final CoroutineContext getContext() {
        return this.e;
    }

    public final CoroutineContext getCoroutineContext() {
        return this.e;
    }

    public void q0(Object obj) {
    }

    public final void resumeWith(Object obj) {
        Throwable r0 = Result.m19exceptionOrNullimpl(obj);
        if (r0 != null) {
            obj = new CompletedExceptionally(false, r0);
        }
        Object b0 = b0(obj);
        if (b0 != JobSupportKt.b) {
            H(b0);
        }
    }

    public void p0(boolean z, Throwable th) {
    }
}
