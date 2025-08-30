package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.TimeoutKt", f = "Timeout.kt", i = {0, 0, 0}, l = {101}, m = "withTimeoutOrNull", n = {"block", "coroutine", "timeMillis"}, s = {"L$0", "L$1", "J$0"})
final class TimeoutKt$withTimeoutOrNull$1<T> extends ContinuationImpl {
    public /* synthetic */ Object c;
    public int d;

    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        int i = (this.d | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.d = i;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i == 0) {
            ResultKt.b(obj);
            return null;
        } else if (i == 1) {
            try {
                ResultKt.b(obj);
                return obj;
            } catch (TimeoutCancellationException unused) {
                throw null;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
