package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,407:1\n14#2:408\n14#2:410\n1#3:409\n54#4,5:411\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1\n*L\n212#1:408\n215#1:410\n222#1:411,5\n*E\n"})
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {215, 415}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "timeoutMillis", "downstream", "values", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
final class FlowKt__DelayKt$debounceInternal$1 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<Object>, Continuation<? super Unit>, Object> {
    public Ref.ObjectRef c;
    public Ref.LongRef d;
    public int e;
    public /* synthetic */ Object f;
    public /* synthetic */ Object g;

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        FlowCollector flowCollector = (FlowCollector) obj2;
        Continuation continuation = (Continuation) obj3;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r9.e
            r2 = 0
            if (r1 == 0) goto L_0x0080
            r3 = 2
            r4 = 1
            if (r1 == r4) goto L_0x0023
            if (r1 != r3) goto L_0x001b
            kotlin.jvm.internal.Ref$ObjectRef r1 = r9.c
            java.lang.Object r4 = r9.g
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            java.lang.Object r5 = r9.f
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            kotlin.ResultKt.b(r10)
            goto L_0x006c
        L_0x001b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0023:
            kotlin.jvm.internal.Ref$LongRef r1 = r9.d
            kotlin.jvm.internal.Ref$ObjectRef r4 = r9.c
            java.lang.Object r5 = r9.g
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            java.lang.Object r6 = r9.f
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            kotlin.ResultKt.b(r10)
            r4.element = r2
            r10 = r1
            r1 = r4
            r4 = r5
            r5 = r6
        L_0x0038:
            kotlinx.coroutines.selects.SelectImplementation r6 = new kotlinx.coroutines.selects.SelectImplementation
            kotlin.coroutines.CoroutineContext r7 = r9.getContext()
            r6.<init>(r7)
            T r7 = r1.element
            if (r7 == 0) goto L_0x004f
            long r7 = r10.element
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1 r10 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1
            r10.<init>(r2, r1, r5)
            kotlinx.coroutines.selects.OnTimeoutKt.a(r6, r7, r10)
        L_0x004f:
            kotlinx.coroutines.selects.SelectClause1 r10 = r4.b()
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2 r7 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2
            r7.<init>(r2, r1, r5)
            r6.j(r10, r7)
            r9.f = r5
            r9.g = r4
            r9.c = r1
            r9.d = r2
            r9.e = r3
            java.lang.Object r10 = r6.g(r9)
            if (r10 != r0) goto L_0x006c
            return r0
        L_0x006c:
            T r10 = r1.element
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.flow.internal.NullSurrogateKt.c
            if (r10 == r6) goto L_0x007d
            kotlin.jvm.internal.Ref$LongRef r10 = new kotlin.jvm.internal.Ref$LongRef
            r10.<init>()
            T r6 = r1.element
            if (r6 != 0) goto L_0x007c
            goto L_0x0038
        L_0x007c:
            throw r2
        L_0x007d:
            kotlin.Unit r10 = kotlin.Unit.f696a
            return r10
        L_0x0080:
            kotlin.ResultKt.b(r10)
            java.lang.Object r10 = r9.f
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            java.lang.Object r10 = r9.g
            kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
