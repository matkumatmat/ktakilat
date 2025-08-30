package kotlinx.coroutines.stream;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002R\u000b\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/stream/StreamFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/atomicfu/AtomicBoolean;", "consumed", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class StreamFlow<T> implements Flow<T> {
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(StreamFlow.class, "consumed$volatile");
    private volatile /* synthetic */ int consumed$volatile;

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r6 = r7 instanceof kotlinx.coroutines.stream.StreamFlow$collect$1
            if (r6 == 0) goto L_0x0013
            r6 = r7
            kotlinx.coroutines.stream.StreamFlow$collect$1 r6 = (kotlinx.coroutines.stream.StreamFlow$collect$1) r6
            int r0 = r6.g
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L_0x0013
            int r0 = r0 - r1
            r6.g = r0
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.stream.StreamFlow$collect$1 r6 = new kotlinx.coroutines.stream.StreamFlow$collect$1
            r6.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r6.e
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r6.g
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x004d
            if (r1 != r3) goto L_0x0045
            java.util.Iterator r1 = r6.d
            kotlinx.coroutines.flow.FlowCollector r4 = r6.c
            kotlin.ResultKt.b(r7)     // Catch:{ all -> 0x0042 }
        L_0x002b:
            boolean r7 = r1.hasNext()     // Catch:{ all -> 0x0042 }
            if (r7 == 0) goto L_0x0044
            java.lang.Object r7 = r1.next()     // Catch:{ all -> 0x0042 }
            r6.c = r4     // Catch:{ all -> 0x0042 }
            r6.d = r1     // Catch:{ all -> 0x0042 }
            r6.g = r3     // Catch:{ all -> 0x0042 }
            java.lang.Object r7 = r4.emit(r7, r6)     // Catch:{ all -> 0x0042 }
            if (r7 != r0) goto L_0x002b
            return r0
        L_0x0042:
            r6 = r2
            goto L_0x0066
        L_0x0044:
            throw r2
        L_0x0045:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x004d:
            kotlin.ResultKt.b(r7)
            r6 = 0
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r7 = c
            boolean r6 = r7.compareAndSet(r5, r6, r3)
            if (r6 != 0) goto L_0x0061
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Stream.consumeAsFlow can be collected only once"
            r6.<init>(r7)
            throw r6
        L_0x0061:
            defpackage.ba.w()     // Catch:{ all -> 0x0065 }
            throw r2     // Catch:{ all -> 0x0065 }
        L_0x0065:
            r6 = r5
        L_0x0066:
            r6.getClass()
            defpackage.ba.w()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.stream.StreamFlow.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
