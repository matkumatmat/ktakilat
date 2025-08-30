package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDispatchedTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTask\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,208:1\n1#2:209\n103#3,10:210\n114#3,2:224\n206#4:220\n207#4:223\n57#5,2:221\n*S KotlinDebug\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTask\n*L\n83#1:210,10\n83#1:224,2\n96#1:220\n96#1:223\n96#1:221,2\n*E\n"})
public abstract class DispatchedTask<T> extends Task {
    public int e;

    public DispatchedTask(int i) {
        super(0, false);
        this.e = i;
    }

    public abstract Continuation c();

    public Throwable d(Object obj) {
        CompletedExceptionally completedExceptionally;
        if (obj instanceof CompletedExceptionally) {
            completedExceptionally = (CompletedExceptionally) obj;
        } else {
            completedExceptionally = null;
        }
        if (completedExceptionally != null) {
            return completedExceptionally.f764a;
        }
        return null;
    }

    public Object e(Object obj) {
        return obj;
    }

    public final void f(Throwable th) {
        CoroutineExceptionHandlerKt.a(c().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object g();

    public final void run() {
        CoroutineContext context;
        Object c;
        UndispatchedCoroutine undispatchedCoroutine;
        try {
            Continuation c2 = c();
            Intrinsics.d(c2, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) c2;
            Continuation continuation = dispatchedContinuation.g;
            Object obj = dispatchedContinuation.j;
            context = continuation.getContext();
            c = ThreadContextKt.c(context, obj);
            Job job = null;
            if (c != ThreadContextKt.f807a) {
                undispatchedCoroutine = CoroutineContextKt.c(continuation, context, c);
            } else {
                undispatchedCoroutine = null;
            }
            CoroutineContext context2 = continuation.getContext();
            Object g = g();
            Throwable d = d(g);
            if (d == null && DispatchedTaskKt.a(this.e)) {
                job = (Job) context2.get(Job.Key.c);
            }
            if (job != null && !job.isActive()) {
                CancellationException g2 = job.g();
                a(g2);
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m16constructorimpl(ResultKt.a(g2)));
            } else if (d != null) {
                Result.Companion companion2 = Result.Companion;
                continuation.resumeWith(Result.m16constructorimpl(ResultKt.a(d)));
            } else {
                Result.Companion companion3 = Result.Companion;
                continuation.resumeWith(Result.m16constructorimpl(e(g)));
            }
            Unit unit = Unit.f696a;
            if (undispatchedCoroutine != null) {
                if (!undispatchedCoroutine.r0()) {
                    return;
                }
            }
            ThreadContextKt.a(context, c);
        } catch (Throwable th) {
            f(th);
        }
    }

    public void a(CancellationException cancellationException) {
    }
}
