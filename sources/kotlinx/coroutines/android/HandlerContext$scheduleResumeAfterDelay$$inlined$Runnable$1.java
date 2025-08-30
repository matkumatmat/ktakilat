package kotlinx.coroutines.android;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n+ 2 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerContext\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,13:1\n141#2:14\n142#2:16\n1#3:15\n*E\n"})
public final class HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1 implements Runnable {
    public final /* synthetic */ CancellableContinuationImpl c;
    public final /* synthetic */ HandlerContext d;

    public HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1(CancellableContinuationImpl cancellableContinuationImpl, HandlerContext handlerContext) {
        this.c = cancellableContinuationImpl;
        this.d = handlerContext;
    }

    public final void run() {
        this.c.A(this.d, Unit.f696a);
    }
}
