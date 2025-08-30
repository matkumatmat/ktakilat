package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", i = {0}, l = {47}, m = "joinAll", n = {"$this$forEach$iv"}, s = {"L$0"})
final class AwaitKt$joinAll$1 extends ContinuationImpl {
    public Object[] c;
    public int d;
    public int e;
    public /* synthetic */ Object f;
    public int g;

    public final Object invokeSuspend(Object obj) {
        Job job;
        this.f = obj;
        int i = (this.g | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.g = i;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i == 0) {
            ResultKt.b(obj);
            throw null;
        } else if (i == 1) {
            int i2 = this.e;
            int i3 = this.d;
            Job[] jobArr = (Job[]) this.c;
            ResultKt.b(obj);
            do {
                i3++;
                if (i3 >= i2) {
                    return Unit.f696a;
                }
                job = jobArr[i3];
                this.c = jobArr;
                this.d = i3;
                this.e = i2;
                this.g = 1;
            } while (job.e(this) != coroutineSingletons);
            return coroutineSingletons;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
