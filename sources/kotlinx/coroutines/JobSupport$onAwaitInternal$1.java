package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class JobSupport$onAwaitInternal$1 extends FunctionReferenceImpl implements Function3<JobSupport, SelectInstance<?>, Object, Unit> {
    static {
        new JobSupport$onAwaitInternal$1();
    }

    public JobSupport$onAwaitInternal$1() {
        super(3, JobSupport.class, "onAwaitInternalRegFunc", "onAwaitInternalRegFunc(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        JobSupport jobSupport = (JobSupport) obj;
        SelectInstance selectInstance = (SelectInstance) obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = JobSupport.c;
        jobSupport.getClass();
        while (true) {
            Object obj4 = JobSupport.c.get(jobSupport);
            if (obj4 instanceof Incomplete) {
                if (jobSupport.k0(obj4) >= 0) {
                    selectInstance.a(JobKt.c(jobSupport, true, new JobSupport.SelectOnAwaitCompletionHandler(selectInstance)));
                    break;
                }
            } else {
                if (!(obj4 instanceof CompletedExceptionally)) {
                    obj4 = JobSupportKt.a(obj4);
                }
                selectInstance.e(obj4);
            }
        }
        return Unit.f696a;
    }
}
