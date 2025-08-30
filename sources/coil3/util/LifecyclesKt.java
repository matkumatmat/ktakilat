package coil3.util;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nlifecycles.kt\nKotlin\n*S Kotlin\n*F\n+ 1 lifecycles.kt\ncoil3/util/LifecyclesKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,41:1\n351#2,11:42\n1#3:53\n*S KotlinDebug\n*F\n+ 1 lifecycles.kt\ncoil3/util/LifecyclesKt\n*L\n21#1:42,11\n*E\n"})
public final class LifecyclesKt {
    /* JADX WARNING: type inference failed for: r0v8, types: [kotlin.coroutines.jvm.internal.ContinuationImpl] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(androidx.lifecycle.Lifecycle r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            boolean r0 = r7 instanceof coil3.util.LifecyclesKt$awaitStarted$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            coil3.util.LifecyclesKt$awaitStarted$1 r0 = (coil3.util.LifecyclesKt$awaitStarted$1) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f = r1
            goto L_0x0018
        L_0x0013:
            coil3.util.LifecyclesKt$awaitStarted$1 r0 = new coil3.util.LifecyclesKt$awaitStarted$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.f
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.jvm.internal.Ref$ObjectRef r6 = r0.d
            androidx.lifecycle.Lifecycle r0 = r0.c
            kotlin.ResultKt.b(r7)     // Catch:{ all -> 0x002b }
            goto L_0x007e
        L_0x002b:
            r7 = move-exception
            goto L_0x008c
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            kotlin.ResultKt.b(r7)
            androidx.lifecycle.Lifecycle$State r7 = r6.getCurrentState()
            androidx.lifecycle.Lifecycle$State r2 = androidx.lifecycle.Lifecycle.State.STARTED
            boolean r7 = r7.isAtLeast(r2)
            if (r7 == 0) goto L_0x0047
            kotlin.Unit r6 = kotlin.Unit.f696a
            return r6
        L_0x0047:
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            r0.c = r6     // Catch:{ all -> 0x008a }
            r0.d = r7     // Catch:{ all -> 0x008a }
            r0.f = r3     // Catch:{ all -> 0x008a }
            kotlinx.coroutines.CancellableContinuationImpl r2 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch:{ all -> 0x008a }
            kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.b(r0)     // Catch:{ all -> 0x008a }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x008a }
            r2.q()     // Catch:{ all -> 0x008a }
            coil3.util.LifecyclesKt$awaitStarted$2$1 r3 = new coil3.util.LifecyclesKt$awaitStarted$2$1     // Catch:{ all -> 0x008a }
            r3.<init>(r2)     // Catch:{ all -> 0x008a }
            r7.element = r3     // Catch:{ all -> 0x008a }
            r6.addObserver(r3)     // Catch:{ all -> 0x008a }
            java.lang.Object r2 = r2.p()     // Catch:{ all -> 0x008a }
            if (r2 != r1) goto L_0x0079
            java.lang.String r3 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)     // Catch:{ all -> 0x008a }
            goto L_0x0079
        L_0x0074:
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
            goto L_0x008c
        L_0x0079:
            if (r2 != r1) goto L_0x007c
            return r1
        L_0x007c:
            r0 = r6
            r6 = r7
        L_0x007e:
            T r6 = r6.element
            androidx.lifecycle.LifecycleObserver r6 = (androidx.lifecycle.LifecycleObserver) r6
            if (r6 == 0) goto L_0x0087
            r0.removeObserver(r6)
        L_0x0087:
            kotlin.Unit r6 = kotlin.Unit.f696a
            return r6
        L_0x008a:
            r0 = move-exception
            goto L_0x0074
        L_0x008c:
            T r6 = r6.element
            androidx.lifecycle.LifecycleObserver r6 = (androidx.lifecycle.LifecycleObserver) r6
            if (r6 == 0) goto L_0x0095
            r0.removeObserver(r6)
        L_0x0095:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.util.LifecyclesKt.a(androidx.lifecycle.Lifecycle, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
