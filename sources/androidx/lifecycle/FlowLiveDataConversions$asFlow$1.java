package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", i = {0, 1, 2}, l = {107, 112, 113, 115}, m = "invokeSuspend", n = {"observer", "observer", "observer"}, s = {"L$0", "L$0", "L$0"})
public final class FlowLiveDataConversions$asFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ LiveData<T> $this_asFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowLiveDataConversions$asFlow$1(LiveData<T> liveData, Continuation<? super FlowLiveDataConversions$asFlow$1> continuation) {
        super(2, continuation);
        this.$this_asFlow = liveData;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(ProducerScope producerScope, Object obj) {
        producerScope.z(obj);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowLiveDataConversions$asFlow$1 flowLiveDataConversions$asFlow$1 = new FlowLiveDataConversions$asFlow$1(this.$this_asFlow, continuation);
        flowLiveDataConversions$asFlow$1.L$0 = obj;
        return flowLiveDataConversions$asFlow$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0088 A[Catch:{ all -> 0x002c }, RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r9.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r1 == 0) goto L_0x003e
            if (r1 == r5) goto L_0x0036
            if (r1 == r4) goto L_0x002e
            if (r1 == r3) goto L_0x0024
            if (r1 == r2) goto L_0x001b
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x001b:
            java.lang.Object r0 = r9.L$0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlin.ResultKt.b(r10)
            goto L_0x00b0
        L_0x0024:
            java.lang.Object r1 = r9.L$0
            androidx.lifecycle.Observer r1 = (androidx.lifecycle.Observer) r1
            kotlin.ResultKt.b(r10)     // Catch:{ all -> 0x002c }
            goto L_0x0089
        L_0x002c:
            r10 = move-exception
            goto L_0x008f
        L_0x002e:
            java.lang.Object r1 = r9.L$0
            androidx.lifecycle.Observer r1 = (androidx.lifecycle.Observer) r1
            kotlin.ResultKt.b(r10)     // Catch:{ all -> 0x002c }
            goto L_0x007e
        L_0x0036:
            java.lang.Object r1 = r9.L$0
            androidx.lifecycle.Observer r1 = (androidx.lifecycle.Observer) r1
            kotlin.ResultKt.b(r10)
            goto L_0x0064
        L_0x003e:
            kotlin.ResultKt.b(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.channels.ProducerScope r10 = (kotlinx.coroutines.channels.ProducerScope) r10
            androidx.lifecycle.a r1 = new androidx.lifecycle.a
            r1.<init>(r10)
            kotlinx.coroutines.scheduling.DefaultScheduler r10 = kotlinx.coroutines.Dispatchers.f767a
            kotlinx.coroutines.MainCoroutineDispatcher r10 = kotlinx.coroutines.internal.MainDispatcherLoader.f801a
            kotlinx.coroutines.MainCoroutineDispatcher r10 = r10.t()
            androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1 r7 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1
            androidx.lifecycle.LiveData<T> r8 = r9.$this_asFlow
            r7.<init>(r8, r1, r6)
            r9.L$0 = r1
            r9.label = r5
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.d(r7, r10, r9)
            if (r10 != r0) goto L_0x0064
            return r0
        L_0x0064:
            kotlinx.coroutines.scheduling.DefaultScheduler r10 = kotlinx.coroutines.Dispatchers.f767a     // Catch:{ all -> 0x002c }
            kotlinx.coroutines.MainCoroutineDispatcher r10 = kotlinx.coroutines.internal.MainDispatcherLoader.f801a     // Catch:{ all -> 0x002c }
            kotlinx.coroutines.MainCoroutineDispatcher r10 = r10.t()     // Catch:{ all -> 0x002c }
            androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2 r5 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2     // Catch:{ all -> 0x002c }
            androidx.lifecycle.LiveData<T> r7 = r9.$this_asFlow     // Catch:{ all -> 0x002c }
            r5.<init>(r7, r1, r6)     // Catch:{ all -> 0x002c }
            r9.L$0 = r1     // Catch:{ all -> 0x002c }
            r9.label = r4     // Catch:{ all -> 0x002c }
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.d(r5, r10, r9)     // Catch:{ all -> 0x002c }
            if (r10 != r0) goto L_0x007e
            return r0
        L_0x007e:
            r9.L$0 = r1     // Catch:{ all -> 0x002c }
            r9.label = r3     // Catch:{ all -> 0x002c }
            kotlin.coroutines.intrinsics.CoroutineSingletons r10 = kotlinx.coroutines.DelayKt.a(r9)     // Catch:{ all -> 0x002c }
            if (r10 != r0) goto L_0x0089
            return r0
        L_0x0089:
            kotlin.KotlinNothingValueException r10 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x002c }
            r10.<init>()     // Catch:{ all -> 0x002c }
            throw r10     // Catch:{ all -> 0x002c }
        L_0x008f:
            kotlinx.coroutines.scheduling.DefaultScheduler r3 = kotlinx.coroutines.Dispatchers.f767a
            kotlinx.coroutines.MainCoroutineDispatcher r3 = kotlinx.coroutines.internal.MainDispatcherLoader.f801a
            kotlinx.coroutines.MainCoroutineDispatcher r3 = r3.t()
            kotlinx.coroutines.NonCancellable r4 = kotlinx.coroutines.NonCancellable.c
            kotlin.coroutines.CoroutineContext r3 = r3.plus(r4)
            androidx.lifecycle.FlowLiveDataConversions$asFlow$1$3 r4 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$3
            androidx.lifecycle.LiveData<T> r5 = r9.$this_asFlow
            r4.<init>(r5, r1, r6)
            r9.L$0 = r10
            r9.label = r2
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.d(r4, r3, r9)
            if (r1 != r0) goto L_0x00af
            return r0
        L_0x00af:
            r0 = r10
        L_0x00b0:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.FlowLiveDataConversions$asFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super T> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowLiveDataConversions$asFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.f696a);
    }
}
