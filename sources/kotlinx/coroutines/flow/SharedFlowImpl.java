package kotlinx.coroutines.flow;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.internal.Symbol;

@SourceDebugExtension({"SMAP\nSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowImpl\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n+ 7 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 8 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,746:1\n27#2:747\n27#2:750\n27#2:769\n27#2:773\n27#2:782\n27#2:793\n27#2:804\n16#3:748\n16#3:751\n16#3:770\n16#3:774\n16#3:783\n16#3:794\n16#3:805\n326#4:749\n1#5:752\n91#6,2:753\n93#6,2:756\n95#6:759\n91#6,2:775\n93#6,2:778\n95#6:781\n91#6,2:797\n93#6,2:800\n95#6:803\n13346#7:755\n13347#7:758\n13346#7:777\n13347#7:780\n13346#7:799\n13347#7:802\n351#8,9:760\n360#8,2:771\n351#8,9:784\n360#8,2:795\n*S KotlinDebug\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowImpl\n*L\n366#1:747\n406#1:750\n500#1:769\n521#1:773\n641#1:782\n676#1:793\n704#1:804\n366#1:748\n406#1:751\n500#1:770\n521#1:774\n641#1:783\n676#1:794\n704#1:805\n388#1:749\n468#1:753,2\n468#1:756,2\n468#1:759\n544#1:775,2\n544#1:778,2\n544#1:781\n691#1:797,2\n691#1:800,2\n691#1:803\n468#1:755\n468#1:758\n544#1:777\n544#1:780\n691#1:799\n691#1:802\n498#1:760,9\n498#1:771,2\n675#1:784,9\n675#1:795,2\n*E\n"})
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006:\u0001\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "Emitter", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class SharedFlowImpl<T> extends AbstractSharedFlow<SharedFlowSlot> implements MutableSharedFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    public Object[] f;
    public long g;
    public long i;
    public int j;
    public int k;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "Lkotlinx/coroutines/DisposableHandle;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Emitter implements DisposableHandle {
        public final SharedFlowImpl c;
        public final long d;
        public final Object e;
        public final CancellableContinuationImpl f;

        public Emitter(SharedFlowImpl sharedFlowImpl, long j, Object obj, CancellableContinuationImpl cancellableContinuationImpl) {
            this.c = sharedFlowImpl;
            this.d = j;
            this.e = obj;
            this.f = cancellableContinuationImpl;
        }

        public final void dispose() {
            SharedFlowImpl sharedFlowImpl = this.c;
            synchronized (sharedFlowImpl) {
                if (this.d >= sharedFlowImpl.m()) {
                    Object[] objArr = sharedFlowImpl.f;
                    Intrinsics.c(objArr);
                    long j = this.d;
                    if (objArr[((int) j) & (objArr.length - 1)] == this) {
                        SharedFlowKt.a(objArr, j, SharedFlowKt.f785a);
                        sharedFlowImpl.h();
                        Unit unit = Unit.f696a;
                    }
                }
            }
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f784a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                kotlinx.coroutines.channels.BufferOverflow[] r0 = kotlinx.coroutines.channels.BufferOverflow.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.DROP_LATEST     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f784a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.WhenMappings.<clinit>():void");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0099 A[Catch:{ all -> 0x00aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ae A[Catch:{ all -> 0x00aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static kotlin.coroutines.intrinsics.CoroutineSingletons i(kotlinx.coroutines.flow.SharedFlowImpl r8, kotlinx.coroutines.flow.FlowCollector r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.SharedFlowImpl$collect$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.flow.SharedFlowImpl$collect$1 r0 = (kotlinx.coroutines.flow.SharedFlowImpl$collect$1) r0
            int r1 = r0.j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.j = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.SharedFlowImpl$collect$1 r0 = new kotlinx.coroutines.flow.SharedFlowImpl$collect$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.g
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.j
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x005d
            if (r2 == r5) goto L_0x004d
            if (r2 == r4) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            kotlinx.coroutines.Job r8 = r0.f
            kotlinx.coroutines.flow.SharedFlowSlot r9 = r0.e
            kotlinx.coroutines.flow.FlowCollector r2 = r0.d
            kotlinx.coroutines.flow.SharedFlowImpl r5 = r0.c
        L_0x0031:
            kotlin.ResultKt.b(r10)     // Catch:{ all -> 0x0035 }
            goto L_0x0049
        L_0x0035:
            r8 = move-exception
            goto L_0x00cd
        L_0x0038:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0040:
            kotlinx.coroutines.Job r8 = r0.f
            kotlinx.coroutines.flow.SharedFlowSlot r9 = r0.e
            kotlinx.coroutines.flow.FlowCollector r2 = r0.d
            kotlinx.coroutines.flow.SharedFlowImpl r5 = r0.c
            goto L_0x0031
        L_0x0049:
            r10 = r2
            r2 = r8
            r8 = r5
            goto L_0x0091
        L_0x004d:
            kotlinx.coroutines.flow.SharedFlowSlot r9 = r0.e
            kotlinx.coroutines.flow.FlowCollector r8 = r0.d
            kotlinx.coroutines.flow.SharedFlowImpl r2 = r0.c
            kotlin.ResultKt.b(r10)     // Catch:{ all -> 0x0059 }
            r10 = r8
            r8 = r2
            goto L_0x0085
        L_0x0059:
            r8 = move-exception
            r5 = r2
            goto L_0x00cd
        L_0x005d:
            kotlin.ResultKt.b(r10)
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot r10 = r8.c()
            kotlinx.coroutines.flow.SharedFlowSlot r10 = (kotlinx.coroutines.flow.SharedFlowSlot) r10
            boolean r2 = r9 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector     // Catch:{ all -> 0x0080 }
            if (r2 == 0) goto L_0x0082
            r2 = r9
            kotlinx.coroutines.flow.SubscribedFlowCollector r2 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r2     // Catch:{ all -> 0x0080 }
            r0.c = r8     // Catch:{ all -> 0x0080 }
            r0.d = r9     // Catch:{ all -> 0x0080 }
            r0.e = r10     // Catch:{ all -> 0x0080 }
            r0.j = r5     // Catch:{ all -> 0x0080 }
            java.lang.Object r2 = r2.a(r0)     // Catch:{ all -> 0x0080 }
            if (r2 != r1) goto L_0x0082
            return r1
        L_0x007c:
            r5 = r8
            r8 = r9
            r9 = r10
            goto L_0x00cd
        L_0x0080:
            r9 = move-exception
            goto L_0x007c
        L_0x0082:
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0085:
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()     // Catch:{ all -> 0x00aa }
            kotlinx.coroutines.Job$Key r5 = kotlinx.coroutines.Job.Key.c     // Catch:{ all -> 0x00aa }
            kotlin.coroutines.CoroutineContext$Element r2 = r2.get(r5)     // Catch:{ all -> 0x00aa }
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2     // Catch:{ all -> 0x00aa }
        L_0x0091:
            java.lang.Object r5 = r8.r(r9)     // Catch:{ all -> 0x00aa }
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.flow.SharedFlowKt.f785a     // Catch:{ all -> 0x00aa }
            if (r5 != r6) goto L_0x00ae
            r0.c = r8     // Catch:{ all -> 0x00aa }
            r0.d = r10     // Catch:{ all -> 0x00aa }
            r0.e = r9     // Catch:{ all -> 0x00aa }
            r0.f = r2     // Catch:{ all -> 0x00aa }
            r0.j = r4     // Catch:{ all -> 0x00aa }
            java.lang.Object r5 = r8.g(r9, r0)     // Catch:{ all -> 0x00aa }
            if (r5 != r1) goto L_0x0091
            return r1
        L_0x00aa:
            r10 = move-exception
            r5 = r8
            r8 = r10
            goto L_0x00cd
        L_0x00ae:
            if (r2 == 0) goto L_0x00bc
            boolean r6 = r2.isActive()     // Catch:{ all -> 0x00aa }
            if (r6 == 0) goto L_0x00b7
            goto L_0x00bc
        L_0x00b7:
            java.util.concurrent.CancellationException r10 = r2.g()     // Catch:{ all -> 0x00aa }
            throw r10     // Catch:{ all -> 0x00aa }
        L_0x00bc:
            r0.c = r8     // Catch:{ all -> 0x00aa }
            r0.d = r10     // Catch:{ all -> 0x00aa }
            r0.e = r9     // Catch:{ all -> 0x00aa }
            r0.f = r2     // Catch:{ all -> 0x00aa }
            r0.j = r3     // Catch:{ all -> 0x00aa }
            java.lang.Object r5 = r10.emit(r5, r0)     // Catch:{ all -> 0x00aa }
            if (r5 != r1) goto L_0x0091
            return r1
        L_0x00cd:
            r5.f(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.i(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):kotlin.coroutines.intrinsics.CoroutineSingletons");
    }

    public final Flow a(CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        return SharedFlowKt.b(this, coroutineContext, i2, bufferOverflow);
    }

    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        return i(this, flowCollector, continuation);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot, kotlinx.coroutines.flow.SharedFlowSlot, java.lang.Object] */
    public final AbstractSharedFlowSlot d() {
        ? obj = new Object();
        obj.f786a = -1;
        return obj;
    }

    public final AbstractSharedFlowSlot[] e() {
        return new SharedFlowSlot[2];
    }

    public final Object emit(Object obj, Continuation continuation) {
        Emitter emitter;
        if (o(obj)) {
            return Unit.f696a;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(continuation));
        cancellableContinuationImpl.q();
        Continuation[] continuationArr = AbstractSharedFlowKt.f790a;
        synchronized (this) {
            try {
                if (p(obj)) {
                    Result.Companion companion = Result.Companion;
                    cancellableContinuationImpl.resumeWith(Result.m16constructorimpl(Unit.f696a));
                    continuationArr = l(continuationArr);
                    emitter = null;
                } else {
                    Emitter emitter2 = new Emitter(this, ((long) (this.j + this.k)) + m(), obj, cancellableContinuationImpl);
                    k(emitter2);
                    this.k++;
                    emitter = emitter2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (emitter != null) {
            CancellableContinuationKt.a(cancellableContinuationImpl, emitter);
        }
        for (Continuation continuation2 : continuationArr) {
            if (continuation2 != null) {
                Result.Companion companion2 = Result.Companion;
                continuation2.resumeWith(Result.m16constructorimpl(Unit.f696a));
            }
        }
        Object p = cancellableContinuationImpl.p();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (p == coroutineSingletons) {
            Intrinsics.checkNotNullParameter(continuation, TypedValues.AttributesType.S_FRAME);
        }
        if (p != coroutineSingletons) {
            p = Unit.f696a;
        }
        if (p == coroutineSingletons) {
            return p;
        }
        return Unit.f696a;
    }

    public final Object g(SharedFlowSlot sharedFlowSlot, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(continuation));
        cancellableContinuationImpl.q();
        synchronized (this) {
            if (q(sharedFlowSlot) < 0) {
                sharedFlowSlot.b = cancellableContinuationImpl;
            } else {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m16constructorimpl(Unit.f696a));
            }
            Unit unit = Unit.f696a;
        }
        Object p = cancellableContinuationImpl.p();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (p == coroutineSingletons) {
            Intrinsics.checkNotNullParameter(continuation, TypedValues.AttributesType.S_FRAME);
        }
        if (p == coroutineSingletons) {
            return p;
        }
        return Unit.f696a;
    }

    public final void h() {
        Object[] objArr = this.f;
        Intrinsics.c(objArr);
        while (this.k > 0) {
            long m = m();
            int i2 = this.j;
            int i3 = this.k;
            if (objArr[(objArr.length - 1) & ((int) ((m + ((long) (i2 + i3))) - 1))] == SharedFlowKt.f785a) {
                this.k = i3 - 1;
                SharedFlowKt.a(objArr, m() + ((long) (this.j + this.k)), (Object) null);
            } else {
                return;
            }
        }
    }

    public final void j() {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        Object[] objArr = this.f;
        Intrinsics.c(objArr);
        SharedFlowKt.a(objArr, m(), (Object) null);
        this.j--;
        long m = m() + 1;
        if (this.g < m) {
            this.g = m;
        }
        if (this.i < m) {
            if (!(this.d == 0 || (abstractSharedFlowSlotArr = this.c) == null)) {
                for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                    if (abstractSharedFlowSlot != null) {
                        SharedFlowSlot sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot;
                        long j2 = sharedFlowSlot.f786a;
                        if (j2 >= 0 && j2 < m) {
                            sharedFlowSlot.f786a = m;
                        }
                    }
                }
            }
            this.i = m;
        }
    }

    public final void k(Object obj) {
        int i2 = this.j + this.k;
        Object[] objArr = this.f;
        if (objArr == null) {
            objArr = n(0, 2, (Object[]) null);
        } else if (i2 >= objArr.length) {
            objArr = n(i2, objArr.length * 2, objArr);
        }
        SharedFlowKt.a(objArr, m() + ((long) i2), obj);
    }

    /* JADX WARNING: type inference failed for: r12v6, types: [java.lang.Object[], java.lang.Object] */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        r4 = (kotlinx.coroutines.flow.SharedFlowSlot) r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.coroutines.Continuation[] l(kotlin.coroutines.Continuation[] r12) {
        /*
            r11 = this;
            int r0 = r12.length
            int r1 = r11.d
            if (r1 == 0) goto L_0x0044
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r1 = r11.c
            if (r1 == 0) goto L_0x0044
            int r2 = r1.length
            r3 = 0
        L_0x000b:
            if (r3 >= r2) goto L_0x0044
            r4 = r1[r3]
            if (r4 == 0) goto L_0x0041
            kotlinx.coroutines.flow.SharedFlowSlot r4 = (kotlinx.coroutines.flow.SharedFlowSlot) r4
            kotlinx.coroutines.CancellableContinuationImpl r5 = r4.b
            if (r5 != 0) goto L_0x0018
            goto L_0x0041
        L_0x0018:
            long r6 = r11.q(r4)
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 < 0) goto L_0x0041
            int r6 = r12.length
            if (r0 < r6) goto L_0x0036
            int r6 = r12.length
            r7 = 2
            int r6 = r6 * 2
            int r6 = java.lang.Math.max(r7, r6)
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r12, r6)
            java.lang.String r6 = "copyOf(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r6)
        L_0x0036:
            r6 = r12
            kotlin.coroutines.Continuation[] r6 = (kotlin.coroutines.Continuation[]) r6
            int r7 = r0 + 1
            r6[r0] = r5
            r0 = 0
            r4.b = r0
            r0 = r7
        L_0x0041:
            int r3 = r3 + 1
            goto L_0x000b
        L_0x0044:
            kotlin.coroutines.Continuation[] r12 = (kotlin.coroutines.Continuation[]) r12
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.l(kotlin.coroutines.Continuation[]):kotlin.coroutines.Continuation[]");
    }

    public final long m() {
        return Math.min(this.i, this.g);
    }

    public final Object[] n(int i2, int i3, Object[] objArr) {
        if (i3 > 0) {
            Object[] objArr2 = new Object[i3];
            this.f = objArr2;
            if (objArr == null) {
                return objArr2;
            }
            long m = m();
            for (int i4 = 0; i4 < i2; i4++) {
                long j2 = ((long) i4) + m;
                SharedFlowKt.a(objArr2, j2, objArr[((int) j2) & (objArr.length - 1)]);
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow");
    }

    public final boolean o(Object obj) {
        int i2;
        boolean z;
        Continuation[] continuationArr = AbstractSharedFlowKt.f790a;
        synchronized (this) {
            if (p(obj)) {
                continuationArr = l(continuationArr);
                z = true;
            } else {
                z = false;
            }
        }
        for (Continuation continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m16constructorimpl(Unit.f696a));
            }
        }
        return z;
    }

    public final boolean p(Object obj) {
        if (this.d == 0) {
            k(obj);
            int i2 = this.j + 1;
            this.j = i2;
            if (i2 > 1) {
                j();
            }
            this.i = m() + ((long) this.j);
            return true;
        } else if (this.j < Integer.MAX_VALUE || this.i > this.g) {
            k(obj);
            int i3 = this.j + 1;
            this.j = i3;
            if (i3 > Integer.MAX_VALUE) {
                j();
            }
            long m = m() + ((long) this.j);
            long j2 = this.g;
            if (((int) (m - j2)) > 1) {
                s(j2 + 1, this.i, m() + ((long) this.j), m() + ((long) this.j) + ((long) this.k));
            }
            return true;
        } else {
            int[] iArr = WhenMappings.f784a;
            throw null;
        }
    }

    public final long q(SharedFlowSlot sharedFlowSlot) {
        long j2 = sharedFlowSlot.f786a;
        if (j2 < m() + ((long) this.j)) {
            return j2;
        }
        return -1;
    }

    public final Object r(SharedFlowSlot sharedFlowSlot) {
        Object obj;
        Continuation[] continuationArr = AbstractSharedFlowKt.f790a;
        synchronized (this) {
            try {
                long q = q(sharedFlowSlot);
                if (q < 0) {
                    obj = SharedFlowKt.f785a;
                } else {
                    long j2 = sharedFlowSlot.f786a;
                    Object[] objArr = this.f;
                    Intrinsics.c(objArr);
                    Object obj2 = objArr[((int) q) & (objArr.length - 1)];
                    if (obj2 instanceof Emitter) {
                        obj2 = ((Emitter) obj2).e;
                    }
                    sharedFlowSlot.f786a = q + 1;
                    Object obj3 = obj2;
                    continuationArr = t(j2);
                    obj = obj3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Continuation continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m16constructorimpl(Unit.f696a));
            }
        }
        return obj;
    }

    public final void s(long j2, long j3, long j4, long j5) {
        long min = Math.min(j3, j2);
        for (long m = m(); m < min; m++) {
            Object[] objArr = this.f;
            Intrinsics.c(objArr);
            SharedFlowKt.a(objArr, m, (Object) null);
        }
        this.g = j2;
        this.i = j3;
        this.j = (int) (j4 - min);
        this.k = (int) (j5 - j4);
    }

    public final Continuation[] t(long j2) {
        int i2;
        long j3;
        Continuation[] continuationArr;
        long j4;
        long j5;
        Symbol symbol;
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        long j6 = this.i;
        Continuation[] continuationArr2 = AbstractSharedFlowKt.f790a;
        if (j2 > j6) {
            return continuationArr2;
        }
        long m = m();
        long j7 = ((long) this.j) + m;
        int i3 = 0;
        if (!(this.d == 0 || (abstractSharedFlowSlotArr = this.c) == null)) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                if (abstractSharedFlowSlot != null) {
                    long j8 = ((SharedFlowSlot) abstractSharedFlowSlot).f786a;
                    if (j8 >= 0 && j8 < j7) {
                        j7 = j8;
                    }
                }
            }
        }
        if (j7 <= this.i) {
            return continuationArr2;
        }
        long m2 = m() + ((long) this.j);
        if (this.d > 0) {
            i2 = Math.min(this.k, Integer.MAX_VALUE - ((int) (m2 - j7)));
        } else {
            i2 = this.k;
        }
        long j9 = ((long) this.k) + m2;
        Symbol symbol2 = SharedFlowKt.f785a;
        int i4 = 1;
        if (i2 > 0) {
            Continuation[] continuationArr3 = new Continuation[i2];
            Object[] objArr = this.f;
            Intrinsics.c(objArr);
            long j10 = m2;
            while (true) {
                j3 = j7;
                if (m2 >= j9) {
                    j4 = j10;
                    continuationArr = continuationArr3;
                    break;
                }
                Object obj = objArr[((int) m2) & (objArr.length - i4)];
                if (obj != symbol2) {
                    Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    Emitter emitter = (Emitter) obj;
                    int i5 = i3 + 1;
                    continuationArr3[i3] = emitter.f;
                    SharedFlowKt.a(objArr, m2, symbol2);
                    symbol = symbol2;
                    long j11 = j10;
                    SharedFlowKt.a(objArr, j11, emitter.e);
                    j10 = j11 + 1;
                    if (i5 >= i2) {
                        continuationArr = continuationArr3;
                        j4 = j10;
                        break;
                    }
                    i3 = i5;
                } else {
                    symbol = symbol2;
                    long j12 = j10;
                }
                m2++;
                j7 = j3;
                symbol2 = symbol;
                i4 = 1;
            }
        } else {
            j3 = j7;
            continuationArr = continuationArr2;
            j4 = m2;
        }
        int i6 = (int) (j4 - m);
        if (this.d == 0) {
            j5 = j4;
        } else {
            j5 = j3;
        }
        s(Math.max(this.g, j4 - ((long) Math.min(1, i6))), j5, j4, j9);
        h();
        if (continuationArr.length == 0) {
            return continuationArr;
        }
        return l(continuationArr);
    }
}
