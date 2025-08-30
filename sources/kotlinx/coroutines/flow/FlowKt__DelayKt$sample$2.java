package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.selects.SelectImplementation;

@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2\n+ 2 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,407:1\n54#2,5:408\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2\n*L\n278#1:408,5\n*E\n"})
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", i = {0, 0, 0, 0}, l = {412}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "ticker"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class FlowKt__DelayKt$sample$2 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<Object>, Continuation<? super Unit>, Object> {
    public Ref.ObjectRef c;
    public ReceiveChannel d;
    public int e;
    public /* synthetic */ Object f;
    public /* synthetic */ Object g;

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        FlowCollector flowCollector = (FlowCollector) obj2;
        Continuation continuation = (Continuation) obj3;
        throw null;
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.e;
        if (i == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f;
            FlowCollector flowCollector = (FlowCollector) this.g;
            throw null;
        } else if (i == 1) {
            ReceiveChannel receiveChannel = this.d;
            Ref.ObjectRef objectRef = this.c;
            ReceiveChannel receiveChannel2 = (ReceiveChannel) this.g;
            FlowCollector flowCollector2 = (FlowCollector) this.f;
            ResultKt.b(obj);
            while (objectRef.element != NullSurrogateKt.c) {
                SelectImplementation selectImplementation = new SelectImplementation(getContext());
                selectImplementation.j(receiveChannel2.b(), new FlowKt__DelayKt$sample$2$1$1(objectRef, receiveChannel, (Continuation) null));
                selectImplementation.j(receiveChannel.a(), new FlowKt__DelayKt$sample$2$1$2((Continuation) null, objectRef, flowCollector2));
                this.f = flowCollector2;
                this.g = receiveChannel2;
                this.c = objectRef;
                this.d = receiveChannel;
                this.e = 1;
                if (selectImplementation.g(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.f696a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
