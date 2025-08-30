package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0015\u0010\u0004\u001a\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bH\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;", "count", "", "Lkotlin/ParameterName;", "name", "value"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {1, 2, 3}, l = {174, 176, 178, 179, 181}, m = "invokeSuspend", n = {"$this$transformLatest", "$this$transformLatest", "$this$transformLatest"}, s = {"L$0", "L$0", "L$0"})
final class StartedWhileSubscribed$command$1 extends SuspendLambda implements Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super Unit>, Object> {
    public int c;
    public /* synthetic */ FlowCollector d;
    public /* synthetic */ int e;
    public final /* synthetic */ StartedWhileSubscribed f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StartedWhileSubscribed$command$1(StartedWhileSubscribed startedWhileSubscribed, Continuation continuation) {
        super(3, continuation);
        this.f = startedWhileSubscribed;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int intValue = ((Number) obj2).intValue();
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1(this.f, (Continuation) obj3);
        startedWhileSubscribed$command$1.d = (FlowCollector) obj;
        startedWhileSubscribed$command$1.e = intValue;
        return startedWhileSubscribed$command$1.invokeSuspend(Unit.f696a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0078 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r8.c
            r2 = 0
            r4 = 5
            r5 = 2
            r6 = 1
            kotlinx.coroutines.flow.StartedWhileSubscribed r7 = r8.f
            if (r1 == 0) goto L_0x0045
            if (r1 == r6) goto L_0x0041
            if (r1 == r5) goto L_0x003b
            r5 = 3
            r6 = 4
            if (r1 == r5) goto L_0x0028
            if (r1 == r6) goto L_0x0022
            if (r1 != r4) goto L_0x001a
            goto L_0x0041
        L_0x001a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0022:
            kotlinx.coroutines.flow.FlowCollector r1 = r8.d
            kotlin.ResultKt.b(r9)
            goto L_0x006b
        L_0x0028:
            kotlinx.coroutines.flow.FlowCollector r1 = r8.d
            kotlin.ResultKt.b(r9)
            r7.getClass()
            r8.d = r1
            r8.c = r6
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.b(r2, r8)
            if (r9 != r0) goto L_0x006b
            return r0
        L_0x003b:
            kotlinx.coroutines.flow.FlowCollector r1 = r8.d
            kotlin.ResultKt.b(r9)
            goto L_0x0068
        L_0x0041:
            kotlin.ResultKt.b(r9)
            goto L_0x0079
        L_0x0045:
            kotlin.ResultKt.b(r9)
            kotlinx.coroutines.flow.FlowCollector r9 = r8.d
            int r1 = r8.e
            if (r1 <= 0) goto L_0x0059
            kotlinx.coroutines.flow.SharingCommand r1 = kotlinx.coroutines.flow.SharingCommand.START
            r8.c = r6
            java.lang.Object r9 = r9.emit(r1, r8)
            if (r9 != r0) goto L_0x0079
            return r0
        L_0x0059:
            r7.getClass()
            r8.d = r9
            r8.c = r5
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.b(r2, r8)
            if (r1 != r0) goto L_0x0067
            return r0
        L_0x0067:
            r1 = r9
        L_0x0068:
            r7.getClass()
        L_0x006b:
            kotlinx.coroutines.flow.SharingCommand r9 = kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE
            r2 = 0
            r8.d = r2
            r8.c = r4
            java.lang.Object r9 = r1.emit(r9, r8)
            if (r9 != r0) goto L_0x0079
            return r0
        L_0x0079:
            kotlin.Unit r9 = kotlin.Unit.f696a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedWhileSubscribed$command$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
