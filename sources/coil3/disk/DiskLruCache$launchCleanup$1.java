package coil3.disk;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.disk.DiskLruCache$launchCleanup$1", f = "DiskLruCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DiskLruCache$launchCleanup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ DiskLruCache c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DiskLruCache$launchCleanup$1(DiskLruCache diskLruCache, Continuation continuation) {
        super(2, continuation);
        this.c = diskLruCache;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new DiskLruCache$launchCleanup$1(this.c, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((DiskLruCache$launchCleanup$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f696a);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:19|20) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:7|8|9|10|11|12|13|(1:15)(1:16)|(1:18)) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r5.s = true;
        r5.n = okio.Okio.buffer(okio.Okio.blackhole());
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0018 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0029 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:10:0x0018=Splitter:B:10:0x0018, B:12:0x001a=Splitter:B:12:0x001a, B:25:0x003b=Splitter:B:25:0x003b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            kotlin.ResultKt.b(r5)
            coil3.disk.DiskLruCache r5 = r4.c
            java.lang.Object r0 = r5.k
            monitor-enter(r0)
            boolean r1 = r5.p     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x003b
            boolean r1 = r5.q     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0013
            goto L_0x003b
        L_0x0013:
            r1 = 1
            r5.m()     // Catch:{ IOException -> 0x0018 }
            goto L_0x001a
        L_0x0018:
            r5.r = r1     // Catch:{ all -> 0x0039 }
        L_0x001a:
            int r2 = r5.m     // Catch:{ IOException -> 0x0029 }
            r3 = 2000(0x7d0, float:2.803E-42)
            if (r2 < r3) goto L_0x0022
            r2 = 1
            goto L_0x0023
        L_0x0022:
            r2 = 0
        L_0x0023:
            if (r2 == 0) goto L_0x0035
            r5.q()     // Catch:{ IOException -> 0x0029 }
            goto L_0x0035
        L_0x0029:
            r5.s = r1     // Catch:{ all -> 0x0039 }
            okio.Sink r1 = okio.Okio.blackhole()     // Catch:{ all -> 0x0039 }
            okio.BufferedSink r1 = okio.Okio.buffer((okio.Sink) r1)     // Catch:{ all -> 0x0039 }
            r5.n = r1     // Catch:{ all -> 0x0039 }
        L_0x0035:
            monitor-exit(r0)
            kotlin.Unit r5 = kotlin.Unit.f696a
            return r5
        L_0x0039:
            r5 = move-exception
            goto L_0x003f
        L_0x003b:
            kotlin.Unit r5 = kotlin.Unit.f696a     // Catch:{ all -> 0x0039 }
            monitor-exit(r0)
            return r5
        L_0x003f:
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.disk.DiskLruCache$launchCleanup$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
