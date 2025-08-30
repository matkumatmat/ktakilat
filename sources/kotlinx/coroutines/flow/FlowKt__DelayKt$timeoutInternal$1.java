package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.OnTimeoutKt;
import kotlinx.coroutines.selects.SelectImplementation;

@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1\n+ 2 WhileSelect.kt\nkotlinx/coroutines/selects/WhileSelectKt\n+ 3 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,407:1\n27#2:408\n28#2:414\n54#3,5:409\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1\n*L\n392#1:408\n392#1:414\n392#1:409,5\n*E\n"})
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downStream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1", f = "Delay.kt", i = {0, 0}, l = {413}, m = "invokeSuspend", n = {"downStream", "values"}, s = {"L$0", "L$1"})
final class FlowKt__DelayKt$timeoutInternal$1 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<Object>, Continuation<? super Unit>, Object> {
    public long c;
    public int d;
    public /* synthetic */ Object e;
    public /* synthetic */ Object f;

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        FlowCollector flowCollector = (FlowCollector) obj2;
        Continuation continuation = (Continuation) obj3;
        throw null;
    }

    public final Object invokeSuspend(Object obj) {
        boolean z;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.d;
        if (i == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.e;
            FlowCollector flowCollector = (FlowCollector) this.f;
            Duration.d.getClass();
            throw null;
        } else if (i == 1) {
            long j = this.c;
            ReceiveChannel receiveChannel = (ReceiveChannel) this.f;
            FlowCollector flowCollector2 = (FlowCollector) this.e;
            ResultKt.b(obj);
            while (((Boolean) obj).booleanValue()) {
                SelectImplementation selectImplementation = new SelectImplementation(getContext());
                selectImplementation.j(receiveChannel.b(), new FlowKt__DelayKt$timeoutInternal$1$1$1(flowCollector2, (Continuation) null));
                FlowKt__DelayKt$timeoutInternal$1$1$2 flowKt__DelayKt$timeoutInternal$1$1$2 = new FlowKt__DelayKt$timeoutInternal$1$1$2(j, (Continuation) null);
                Duration.Companion companion = Duration.d;
                long j2 = 0;
                if (j > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    long f2 = Duration.f(j, DurationKt.d(999999, DurationUnit.NANOSECONDS));
                    if ((((int) f2) & 1) != 1 || Duration.e(f2)) {
                        j2 = Duration.g(f2, DurationUnit.MILLISECONDS);
                    } else {
                        j2 = f2 >> 1;
                    }
                } else if (z) {
                    throw new NoWhenBranchMatchedException();
                }
                OnTimeoutKt.a(selectImplementation, j2, flowKt__DelayKt$timeoutInternal$1$1$2);
                this.e = flowCollector2;
                this.f = receiveChannel;
                this.c = j;
                this.d = 1;
                obj = selectImplementation.g(this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.f696a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
