package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
public final class JobKt {
    public static final void a(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key.c);
        if (job != null && !job.isActive()) {
            throw job.g();
        }
    }

    public static final Job b(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key.c);
        if (job != null) {
            return job;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }

    public static final DisposableHandle c(Job job, boolean z, JobNode jobNode) {
        if (job instanceof JobSupport) {
            return ((JobSupport) job).Y(z, jobNode);
        }
        return job.f(jobNode.k(), z, new FunctionReferenceImpl(1, jobNode, JobNode.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0));
    }
}
