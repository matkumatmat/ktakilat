package androidx.lifecycle;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.lifecycle.BlockRunner$cancel$1", f = "CoroutineLiveData.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
public final class BlockRunner$cancel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BlockRunner<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BlockRunner$cancel$1(BlockRunner<T> blockRunner, Continuation<? super BlockRunner$cancel$1> continuation) {
        super(2, continuation);
        this.this$0 = blockRunner;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BlockRunner$cancel$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            long access$getTimeoutInMs$p = this.this$0.timeoutInMs;
            this.label = 1;
            if (DelayKt.b(access$getTimeoutInMs$p, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i == 1) {
            ResultKt.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!this.this$0.liveData.hasActiveObservers()) {
            Job access$getRunningJob$p = this.this$0.runningJob;
            if (access$getRunningJob$p != null) {
                access$getRunningJob$p.c((CancellationException) null);
            }
            this.this$0.runningJob = null;
        }
        return Unit.f696a;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((BlockRunner$cancel$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f696a);
    }
}
