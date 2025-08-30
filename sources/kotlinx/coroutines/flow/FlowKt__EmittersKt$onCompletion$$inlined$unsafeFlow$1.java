package kotlinx.coroutines.flow;

import androidx.datastore.core.DataStoreImpl$data$1$invokeSuspend$$inlined$map$1;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,108:1\n143#2,13:109\n156#2,6:123\n326#3:122\n*S KotlinDebug\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n155#1:122\n*E\n"})
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 implements Flow<Object> {
    public final /* synthetic */ DataStoreImpl$data$1$invokeSuspend$$inlined$map$1 c;
    public final /* synthetic */ Function3 d;

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(DataStoreImpl$data$1$invokeSuspend$$inlined$map$1 dataStoreImpl$data$1$invokeSuspend$$inlined$map$1, Function3 function3) {
        this.c = dataStoreImpl$data$1$invokeSuspend$$inlined$map$1;
        this.d = function3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector r9, kotlin.coroutines.Continuation r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.d
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0050
            if (r2 == r5) goto L_0x0044
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r9 = r0.f
            kotlinx.coroutines.flow.internal.SafeCollector r9 = (kotlinx.coroutines.flow.internal.SafeCollector) r9
            kotlin.ResultKt.b(r10)     // Catch:{ all -> 0x0032 }
            goto L_0x007c
        L_0x0032:
            r10 = move-exception
            goto L_0x0086
        L_0x0034:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003c:
            java.lang.Object r9 = r0.f
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            kotlin.ResultKt.b(r10)
            goto L_0x00a0
        L_0x0044:
            kotlinx.coroutines.flow.FlowCollector r9 = r0.g
            java.lang.Object r2 = r0.f
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 r2 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) r2
            kotlin.ResultKt.b(r10)     // Catch:{ all -> 0x004e }
            goto L_0x0063
        L_0x004e:
            r9 = move-exception
            goto L_0x008c
        L_0x0050:
            kotlin.ResultKt.b(r10)
            androidx.datastore.core.DataStoreImpl$data$1$invokeSuspend$$inlined$map$1 r10 = r8.c     // Catch:{ all -> 0x008a }
            r0.f = r8     // Catch:{ all -> 0x008a }
            r0.g = r9     // Catch:{ all -> 0x008a }
            r0.d = r5     // Catch:{ all -> 0x008a }
            java.lang.Object r10 = r10.collect(r9, r0)     // Catch:{ all -> 0x008a }
            if (r10 != r1) goto L_0x0062
            return r1
        L_0x0062:
            r2 = r8
        L_0x0063:
            kotlinx.coroutines.flow.internal.SafeCollector r10 = new kotlinx.coroutines.flow.internal.SafeCollector
            kotlin.coroutines.CoroutineContext r4 = r0.getContext()
            r10.<init>(r9, r4)
            kotlin.jvm.functions.Function3 r9 = r2.d     // Catch:{ all -> 0x0082 }
            r0.f = r10     // Catch:{ all -> 0x0082 }
            r0.g = r6     // Catch:{ all -> 0x0082 }
            r0.d = r3     // Catch:{ all -> 0x0082 }
            java.lang.Object r9 = r9.invoke(r10, r6, r0)     // Catch:{ all -> 0x0082 }
            if (r9 != r1) goto L_0x007b
            return r1
        L_0x007b:
            r9 = r10
        L_0x007c:
            r9.releaseIntercepted()
            kotlin.Unit r9 = kotlin.Unit.f696a
            return r9
        L_0x0082:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0086:
            r9.releaseIntercepted()
            throw r10
        L_0x008a:
            r9 = move-exception
            r2 = r8
        L_0x008c:
            kotlinx.coroutines.flow.ThrowingCollector r10 = new kotlinx.coroutines.flow.ThrowingCollector
            r10.<init>(r9)
            kotlin.jvm.functions.Function3 r2 = r2.d
            r0.f = r9
            r0.g = r6
            r0.d = r4
            java.lang.Object r10 = kotlinx.coroutines.flow.FlowKt__EmittersKt.a(r10, r2, r9, r0)
            if (r10 != r1) goto L_0x00a0
            return r1
        L_0x00a0:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
