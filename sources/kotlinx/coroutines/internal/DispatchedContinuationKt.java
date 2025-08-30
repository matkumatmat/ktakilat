package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"kotlinx-coroutines-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDispatchedContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n+ 2 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,297:1\n277#1,5:305\n282#1,12:311\n294#1:379\n281#1:381\n282#1,12:383\n294#1:412\n207#2,7:298\n214#2,23:326\n237#2,2:359\n239#2:363\n217#2:364\n219#2:380\n1#3:310\n1#3:382\n1#3:413\n186#4,3:323\n189#4,14:365\n186#4,17:395\n186#4,17:414\n103#5,10:349\n114#5,2:361\n*S KotlinDebug\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n*L\n262#1:305,5\n262#1:311,12\n262#1:379\n267#1:381\n267#1:383,12\n267#1:412\n262#1:298,7\n262#1:326,23\n262#1:359,2\n262#1:363\n262#1:364\n262#1:380\n262#1:310\n267#1:382\n262#1:323,3\n262#1:365,14\n267#1:395,17\n293#1:414,17\n262#1:349,10\n262#1:361,2\n*E\n"})
public final class DispatchedContinuationKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Symbol f795a = new Symbol("UNDEFINED");
    public static final Symbol b = new Symbol("REUSABLE_CLAIMED");

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008d, code lost:
        if (r5.r0() != false) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a3, code lost:
        if (r5.r0() != false) goto L_0x00a5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void a(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.internal.DispatchedContinuation
            if (r0 == 0) goto L_0x00b2
            kotlinx.coroutines.internal.DispatchedContinuation r7 = (kotlinx.coroutines.internal.DispatchedContinuation) r7
            java.lang.Throwable r0 = kotlin.Result.m19exceptionOrNullimpl(r6)
            if (r0 != 0) goto L_0x000e
            r1 = r6
            goto L_0x0014
        L_0x000e:
            kotlinx.coroutines.CompletedExceptionally r1 = new kotlinx.coroutines.CompletedExceptionally
            r2 = 0
            r1.<init>(r2, r0)
        L_0x0014:
            kotlinx.coroutines.CoroutineDispatcher r0 = r7.f
            kotlin.coroutines.Continuation r2 = r7.g
            kotlin.coroutines.CoroutineContext r3 = r2.getContext()
            boolean r0 = r0.isDispatchNeeded(r3)
            r3 = 1
            if (r0 == 0) goto L_0x0032
            r7.i = r1
            r7.e = r3
            kotlin.coroutines.CoroutineContext r6 = r2.getContext()
            kotlinx.coroutines.CoroutineDispatcher r0 = r7.f
            r0.dispatch(r6, r7)
            goto L_0x00b5
        L_0x0032:
            kotlinx.coroutines.EventLoop r0 = kotlinx.coroutines.ThreadLocalEventLoop.a()
            boolean r4 = r0.z()
            if (r4 == 0) goto L_0x0045
            r7.i = r1
            r7.e = r3
            r0.u(r7)
            goto L_0x00b5
        L_0x0045:
            r0.w(r3)
            kotlin.coroutines.CoroutineContext r1 = r2.getContext()     // Catch:{ all -> 0x006c }
            kotlinx.coroutines.Job$Key r4 = kotlinx.coroutines.Job.Key.c     // Catch:{ all -> 0x006c }
            kotlin.coroutines.CoroutineContext$Element r1 = r1.get(r4)     // Catch:{ all -> 0x006c }
            kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x006e
            boolean r4 = r1.isActive()     // Catch:{ all -> 0x006c }
            if (r4 != 0) goto L_0x006e
            java.util.concurrent.CancellationException r6 = r1.g()     // Catch:{ all -> 0x006c }
            kotlin.Result$Failure r6 = kotlin.ResultKt.a(r6)     // Catch:{ all -> 0x006c }
            java.lang.Object r6 = kotlin.Result.m16constructorimpl(r6)     // Catch:{ all -> 0x006c }
            r7.resumeWith(r6)     // Catch:{ all -> 0x006c }
            goto L_0x0092
        L_0x006c:
            r6 = move-exception
            goto L_0x00a9
        L_0x006e:
            java.lang.Object r1 = r7.j     // Catch:{ all -> 0x006c }
            kotlin.coroutines.CoroutineContext r4 = r2.getContext()     // Catch:{ all -> 0x006c }
            java.lang.Object r1 = kotlinx.coroutines.internal.ThreadContextKt.c(r4, r1)     // Catch:{ all -> 0x006c }
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.internal.ThreadContextKt.f807a     // Catch:{ all -> 0x006c }
            if (r1 == r5) goto L_0x0081
            kotlinx.coroutines.UndispatchedCoroutine r5 = kotlinx.coroutines.CoroutineContextKt.c(r2, r4, r1)     // Catch:{ all -> 0x006c }
            goto L_0x0082
        L_0x0081:
            r5 = 0
        L_0x0082:
            r2.resumeWith(r6)     // Catch:{ all -> 0x009c }
            kotlin.Unit r6 = kotlin.Unit.f696a     // Catch:{ all -> 0x009c }
            if (r5 == 0) goto L_0x008f
            boolean r6 = r5.r0()     // Catch:{ all -> 0x006c }
            if (r6 == 0) goto L_0x0092
        L_0x008f:
            kotlinx.coroutines.internal.ThreadContextKt.a(r4, r1)     // Catch:{ all -> 0x006c }
        L_0x0092:
            boolean r6 = r0.C()     // Catch:{ all -> 0x006c }
            if (r6 != 0) goto L_0x0092
        L_0x0098:
            r0.t(r3)
            goto L_0x00b5
        L_0x009c:
            r6 = move-exception
            if (r5 == 0) goto L_0x00a5
            boolean r2 = r5.r0()     // Catch:{ all -> 0x006c }
            if (r2 == 0) goto L_0x00a8
        L_0x00a5:
            kotlinx.coroutines.internal.ThreadContextKt.a(r4, r1)     // Catch:{ all -> 0x006c }
        L_0x00a8:
            throw r6     // Catch:{ all -> 0x006c }
        L_0x00a9:
            r7.f(r6)     // Catch:{ all -> 0x00ad }
            goto L_0x0098
        L_0x00ad:
            r6 = move-exception
            r0.t(r3)
            throw r6
        L_0x00b2:
            r7.resumeWith(r6)
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.DispatchedContinuationKt.a(java.lang.Object, kotlin.coroutines.Continuation):void");
    }
}
