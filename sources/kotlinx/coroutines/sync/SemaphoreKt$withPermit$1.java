package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.sync.SemaphoreKt", f = "Semaphore.kt", i = {0, 0}, l = {81}, m = "withPermit", n = {"$this$withPermit", "action"}, s = {"L$0", "L$1"})
final class SemaphoreKt$withPermit$1<T> extends ContinuationImpl {
    public /* synthetic */ Object c;
    public int d;

    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        int i = this.d | Integer.MIN_VALUE;
        this.d = i;
        int i2 = SemaphoreKt.f823a;
        int i3 = i - Integer.MIN_VALUE;
        this.d = i3;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i3 == 0) {
            ResultKt.b(obj);
            this.d = 1;
            throw null;
        } else if (i3 == 1) {
            ResultKt.b(obj);
            throw null;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
