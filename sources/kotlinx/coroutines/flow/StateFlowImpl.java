package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006R\u0011\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0004¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "Lkotlinx/atomicfu/AtomicRef;", "", "_state", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStateFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowImpl\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 6 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,433:1\n14#2:434\n14#2:442\n27#3:435\n27#3:439\n16#4:436\n16#4:440\n13346#5,2:437\n326#6:441\n*S KotlinDebug\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowImpl\n*L\n320#1:434\n401#1:442\n329#1:435\n357#1:439\n329#1:436\n357#1:440\n353#1:437,2\n390#1:441\n*E\n"})
final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;
    public int f;

    public StateFlowImpl(Object obj) {
        this._state$volatile = obj;
    }

    public final Flow a(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        if (((i < 0 || i >= 2) && i != -2) || bufferOverflow != BufferOverflow.DROP_OLDEST) {
            return SharedFlowKt.b(this, coroutineContext, i, bufferOverflow);
        }
        return this;
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Incorrect type for immutable var: ssa=androidx.datastore.core.State, code=java.lang.Object, for r3v0, types: [androidx.datastore.core.State] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(java.lang.Object r2, java.lang.Object r3) {
        /*
            r1 = this;
            kotlinx.coroutines.internal.Symbol r0 = kotlinx.coroutines.flow.internal.NullSurrogateKt.f791a
            if (r2 != 0) goto L_0x0005
            r2 = r0
        L_0x0005:
            if (r3 != 0) goto L_0x0008
            r3 = r0
        L_0x0008:
            boolean r2 = r1.g(r2, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.b(java.lang.Object, androidx.datastore.core.State):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: kotlinx.coroutines.flow.StateFlowSlot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: kotlinx.coroutines.flow.StateFlowImpl} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a8 A[Catch:{ all -> 0x003c }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c0 A[Catch:{ all -> 0x003c }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c2 A[Catch:{ all -> 0x003c }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d5 A[Catch:{ all -> 0x003c }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d6 A[Catch:{ all -> 0x003c }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e6 A[Catch:{ all -> 0x003c }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e7 A[Catch:{ all -> 0x003c }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector r11, kotlin.coroutines.Continuation r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof kotlinx.coroutines.flow.StateFlowImpl$collect$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            kotlinx.coroutines.flow.StateFlowImpl$collect$1 r0 = (kotlinx.coroutines.flow.StateFlowImpl$collect$1) r0
            int r1 = r0.k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.k = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.StateFlowImpl$collect$1 r0 = new kotlinx.coroutines.flow.StateFlowImpl$collect$1
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.i
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.k
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x006a
            if (r2 == r6) goto L_0x005a
            if (r2 == r5) goto L_0x0047
            if (r2 != r4) goto L_0x003f
            java.lang.Object r11 = r0.g
            kotlinx.coroutines.Job r2 = r0.f
            java.lang.Object r6 = r0.e
            kotlinx.coroutines.flow.StateFlowSlot r6 = (kotlinx.coroutines.flow.StateFlowSlot) r6
            kotlinx.coroutines.flow.FlowCollector r7 = r0.d
            java.lang.Object r8 = r0.c
            kotlinx.coroutines.flow.StateFlowImpl r8 = (kotlinx.coroutines.flow.StateFlowImpl) r8
            kotlin.ResultKt.b(r12)     // Catch:{ all -> 0x003c }
            goto L_0x00a0
        L_0x003c:
            r11 = move-exception
            goto L_0x00fa
        L_0x003f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0047:
            java.lang.Object r11 = r0.g
            kotlinx.coroutines.Job r2 = r0.f
            java.lang.Object r6 = r0.e
            kotlinx.coroutines.flow.StateFlowSlot r6 = (kotlinx.coroutines.flow.StateFlowSlot) r6
            kotlinx.coroutines.flow.FlowCollector r7 = r0.d
            java.lang.Object r8 = r0.c
            kotlinx.coroutines.flow.StateFlowImpl r8 = (kotlinx.coroutines.flow.StateFlowImpl) r8
            kotlin.ResultKt.b(r12)     // Catch:{ all -> 0x003c }
            goto L_0x00d7
        L_0x005a:
            java.lang.Object r11 = r0.e
            r6 = r11
            kotlinx.coroutines.flow.StateFlowSlot r6 = (kotlinx.coroutines.flow.StateFlowSlot) r6
            kotlinx.coroutines.flow.FlowCollector r11 = r0.d
            java.lang.Object r2 = r0.c
            r8 = r2
            kotlinx.coroutines.flow.StateFlowImpl r8 = (kotlinx.coroutines.flow.StateFlowImpl) r8
            kotlin.ResultKt.b(r12)     // Catch:{ all -> 0x003c }
            goto L_0x0091
        L_0x006a:
            kotlin.ResultKt.b(r12)
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot r12 = r10.c()
            kotlinx.coroutines.flow.StateFlowSlot r12 = (kotlinx.coroutines.flow.StateFlowSlot) r12
            boolean r2 = r11 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector     // Catch:{ all -> 0x008d }
            if (r2 == 0) goto L_0x008f
            r2 = r11
            kotlinx.coroutines.flow.SubscribedFlowCollector r2 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r2     // Catch:{ all -> 0x008d }
            r0.c = r10     // Catch:{ all -> 0x008d }
            r0.d = r11     // Catch:{ all -> 0x008d }
            r0.e = r12     // Catch:{ all -> 0x008d }
            r0.k = r6     // Catch:{ all -> 0x008d }
            java.lang.Object r2 = r2.a(r0)     // Catch:{ all -> 0x008d }
            if (r2 != r1) goto L_0x008f
            return r1
        L_0x0089:
            r8 = r10
            r6 = r12
            goto L_0x00fa
        L_0x008d:
            r11 = move-exception
            goto L_0x0089
        L_0x008f:
            r8 = r10
            r6 = r12
        L_0x0091:
            kotlin.coroutines.CoroutineContext r12 = r0.getContext()     // Catch:{ all -> 0x003c }
            kotlinx.coroutines.Job$Key r2 = kotlinx.coroutines.Job.Key.c     // Catch:{ all -> 0x003c }
            kotlin.coroutines.CoroutineContext$Element r12 = r12.get(r2)     // Catch:{ all -> 0x003c }
            kotlinx.coroutines.Job r12 = (kotlinx.coroutines.Job) r12     // Catch:{ all -> 0x003c }
            r7 = r11
            r2 = r12
            r11 = r3
        L_0x00a0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = g     // Catch:{ all -> 0x003c }
            java.lang.Object r12 = r12.get(r8)     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x00b4
            boolean r9 = r2.isActive()     // Catch:{ all -> 0x003c }
            if (r9 == 0) goto L_0x00af
            goto L_0x00b4
        L_0x00af:
            java.util.concurrent.CancellationException r11 = r2.g()     // Catch:{ all -> 0x003c }
            throw r11     // Catch:{ all -> 0x003c }
        L_0x00b4:
            if (r11 == 0) goto L_0x00bc
            boolean r9 = r11.equals(r12)     // Catch:{ all -> 0x003c }
            if (r9 != 0) goto L_0x00d7
        L_0x00bc:
            kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.flow.internal.NullSurrogateKt.f791a     // Catch:{ all -> 0x003c }
            if (r12 != r11) goto L_0x00c2
            r11 = r3
            goto L_0x00c3
        L_0x00c2:
            r11 = r12
        L_0x00c3:
            r0.c = r8     // Catch:{ all -> 0x003c }
            r0.d = r7     // Catch:{ all -> 0x003c }
            r0.e = r6     // Catch:{ all -> 0x003c }
            r0.f = r2     // Catch:{ all -> 0x003c }
            r0.g = r12     // Catch:{ all -> 0x003c }
            r0.k = r5     // Catch:{ all -> 0x003c }
            java.lang.Object r11 = r7.emit(r11, r0)     // Catch:{ all -> 0x003c }
            if (r11 != r1) goto L_0x00d6
            return r1
        L_0x00d6:
            r11 = r12
        L_0x00d7:
            java.util.concurrent.atomic.AtomicReference r12 = r6.f789a     // Catch:{ all -> 0x003c }
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.flow.StateFlowKt.f788a     // Catch:{ all -> 0x003c }
            java.lang.Object r12 = r12.getAndSet(r9)     // Catch:{ all -> 0x003c }
            kotlin.jvm.internal.Intrinsics.c(r12)     // Catch:{ all -> 0x003c }
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.flow.StateFlowKt.b     // Catch:{ all -> 0x003c }
            if (r12 != r9) goto L_0x00e7
            goto L_0x00a0
        L_0x00e7:
            r0.c = r8     // Catch:{ all -> 0x003c }
            r0.d = r7     // Catch:{ all -> 0x003c }
            r0.e = r6     // Catch:{ all -> 0x003c }
            r0.f = r2     // Catch:{ all -> 0x003c }
            r0.g = r11     // Catch:{ all -> 0x003c }
            r0.k = r4     // Catch:{ all -> 0x003c }
            java.lang.Object r12 = r6.c(r0)     // Catch:{ all -> 0x003c }
            if (r12 != r1) goto L_0x00a0
            return r1
        L_0x00fa:
            r8.f(r6)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final AbstractSharedFlowSlot d() {
        return new StateFlowSlot();
    }

    public final AbstractSharedFlowSlot[] e() {
        return new StateFlowSlot[2];
    }

    public final Object emit(Object obj, Continuation continuation) {
        setValue(obj);
        return Unit.f696a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002f, code lost:
        r11 = (kotlinx.coroutines.flow.StateFlowSlot[]) r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0031, code lost:
        if (r11 == null) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0033, code lost:
        r1 = r11.length;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0035, code lost:
        if (r2 >= r1) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0037, code lost:
        r4 = r11[r2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0039, code lost:
        if (r4 == null) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003b, code lost:
        r4 = r4.f789a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003d, code lost:
        r5 = r4.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0041, code lost:
        if (r5 != null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0044, code lost:
        r6 = kotlinx.coroutines.flow.StateFlowKt.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0046, code lost:
        if (r5 != r6) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0049, code lost:
        r7 = kotlinx.coroutines.flow.StateFlowKt.f788a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004b, code lost:
        if (r5 != r7) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0051, code lost:
        if (r4.compareAndSet(r5, r6) == false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0058, code lost:
        if (r4.get() == r5) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x005f, code lost:
        if (r4.compareAndSet(r5, r7) == false) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0061, code lost:
        r4 = kotlin.Result.Companion;
        ((kotlinx.coroutines.CancellableContinuationImpl) r5).resumeWith(kotlin.Result.m16constructorimpl(kotlin.Unit.f696a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0073, code lost:
        if (r4.get() == r5) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0076, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0078, code lost:
        monitor-enter(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r11 = r9.f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x007b, code lost:
        if (r11 != r10) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x007d, code lost:
        r9.f = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0080, code lost:
        monitor-exit(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0081, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r10 = r9.c;
        r1 = kotlin.Unit.f696a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0088, code lost:
        monitor-exit(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0089, code lost:
        r8 = r11;
        r11 = r10;
        r10 = r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean g(java.lang.Object r10, java.lang.Object r11) {
        /*
            r9 = this;
            r0 = 1
            monitor-enter(r9)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = g     // Catch:{ all -> 0x0013 }
            java.lang.Object r2 = r1.get(r9)     // Catch:{ all -> 0x0013 }
            r3 = 0
            if (r10 == 0) goto L_0x0016
            boolean r10 = kotlin.jvm.internal.Intrinsics.a(r2, r10)     // Catch:{ all -> 0x0013 }
            if (r10 != 0) goto L_0x0016
            monitor-exit(r9)
            return r3
        L_0x0013:
            r10 = move-exception
            goto L_0x0095
        L_0x0016:
            boolean r10 = kotlin.jvm.internal.Intrinsics.a(r2, r11)     // Catch:{ all -> 0x0013 }
            if (r10 == 0) goto L_0x001e
            monitor-exit(r9)
            return r0
        L_0x001e:
            r1.set(r9, r11)     // Catch:{ all -> 0x0013 }
            int r10 = r9.f     // Catch:{ all -> 0x0013 }
            r11 = r10 & 1
            if (r11 != 0) goto L_0x008f
            int r10 = r10 + r0
            r9.f = r10     // Catch:{ all -> 0x0013 }
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r11 = r9.c     // Catch:{ all -> 0x0013 }
            kotlin.Unit r1 = kotlin.Unit.f696a     // Catch:{ all -> 0x0013 }
            monitor-exit(r9)
        L_0x002f:
            kotlinx.coroutines.flow.StateFlowSlot[] r11 = (kotlinx.coroutines.flow.StateFlowSlot[]) r11
            if (r11 == 0) goto L_0x0078
            int r1 = r11.length
            r2 = 0
        L_0x0035:
            if (r2 >= r1) goto L_0x0078
            r4 = r11[r2]
            if (r4 == 0) goto L_0x0076
            java.util.concurrent.atomic.AtomicReference r4 = r4.f789a
        L_0x003d:
            java.lang.Object r5 = r4.get()
            if (r5 != 0) goto L_0x0044
            goto L_0x0076
        L_0x0044:
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.flow.StateFlowKt.b
            if (r5 != r6) goto L_0x0049
            goto L_0x0076
        L_0x0049:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.flow.StateFlowKt.f788a
            if (r5 != r7) goto L_0x005b
        L_0x004d:
            boolean r7 = r4.compareAndSet(r5, r6)
            if (r7 == 0) goto L_0x0054
            goto L_0x0076
        L_0x0054:
            java.lang.Object r7 = r4.get()
            if (r7 == r5) goto L_0x004d
            goto L_0x003d
        L_0x005b:
            boolean r6 = r4.compareAndSet(r5, r7)
            if (r6 == 0) goto L_0x006f
            kotlinx.coroutines.CancellableContinuationImpl r5 = (kotlinx.coroutines.CancellableContinuationImpl) r5
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            kotlin.Unit r4 = kotlin.Unit.f696a
            java.lang.Object r4 = kotlin.Result.m16constructorimpl(r4)
            r5.resumeWith(r4)
            goto L_0x0076
        L_0x006f:
            java.lang.Object r6 = r4.get()
            if (r6 == r5) goto L_0x005b
            goto L_0x003d
        L_0x0076:
            int r2 = r2 + r0
            goto L_0x0035
        L_0x0078:
            monitor-enter(r9)
            int r11 = r9.f     // Catch:{ all -> 0x0082 }
            if (r11 != r10) goto L_0x0084
            int r10 = r10 + r0
            r9.f = r10     // Catch:{ all -> 0x0082 }
            monitor-exit(r9)
            return r0
        L_0x0082:
            r10 = move-exception
            goto L_0x008d
        L_0x0084:
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r10 = r9.c     // Catch:{ all -> 0x0082 }
            kotlin.Unit r1 = kotlin.Unit.f696a     // Catch:{ all -> 0x0082 }
            monitor-exit(r9)
            r8 = r11
            r11 = r10
            r10 = r8
            goto L_0x002f
        L_0x008d:
            monitor-exit(r9)
            throw r10
        L_0x008f:
            int r10 = r10 + 2
            r9.f = r10     // Catch:{ all -> 0x0013 }
            monitor-exit(r9)
            return r0
        L_0x0095:
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.g(java.lang.Object, java.lang.Object):boolean");
    }

    public final Object getValue() {
        Symbol symbol = NullSurrogateKt.f791a;
        Object obj = g.get(this);
        if (obj == symbol) {
            return null;
        }
        return obj;
    }

    public final void setValue(Object obj) {
        if (obj == null) {
            obj = NullSurrogateKt.f791a;
        }
        g((Object) null, obj);
    }
}
