package kotlinx.coroutines.selects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;

@SourceDebugExtension({"SMAP\nSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,904:1\n1#2:905\n2632#3,3:906\n1863#3,2:918\n1863#3,2:926\n1863#3,2:928\n351#4,9:909\n360#4,2:920\n149#5,4:922\n*S KotlinDebug\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation\n*L\n529#1:906,3\n593#1:918,2\n749#1:926,2\n774#1:928,2\n569#1:909,9\n569#1:920,2\n734#1:922,4\n*E\n"})
@PublishedApi
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004:\u0001\bR\u0011\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0004¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/selects/SelectImplementation;", "R", "Lkotlinx/coroutines/CancelHandler;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstanceInternal;", "Lkotlinx/atomicfu/AtomicRef;", "", "state", "ClauseData", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class SelectImplementation<R> implements CancelHandler, SelectBuilder<R>, SelectInstanceInternal<R> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state$volatile");
    public final CoroutineContext c;
    public ArrayList d = new ArrayList(2);
    public Object e;
    public int f = -1;
    public Object g = SelectKt.e;
    private volatile /* synthetic */ Object state$volatile = SelectKt.b;

    @SourceDebugExtension({"SMAP\nSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation$ClauseData\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,904:1\n1#2:905\n*E\n"})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class ClauseData {

        /* renamed from: a  reason: collision with root package name */
        public final Object f819a;
        public final Function3 b;
        public final Function3 c;
        public final Symbol d;
        public final Function e;
        public final Function3 f;
        public Object g;
        public int h = -1;

        public ClauseData(Object obj, Function3 function3, Function3 function32, Symbol symbol, Function function, Function3 function33) {
            this.f819a = obj;
            this.b = function3;
            this.c = function32;
            this.d = symbol;
            this.e = function;
            this.f = function33;
        }

        public final void a() {
            DisposableHandle disposableHandle;
            Object obj = this.g;
            if (obj instanceof Segment) {
                ((Segment) obj).h(this.h, SelectImplementation.this.c);
                return;
            }
            if (obj instanceof DisposableHandle) {
                disposableHandle = (DisposableHandle) obj;
            } else {
                disposableHandle = null;
            }
            if (disposableHandle != null) {
                disposableHandle.dispose();
            }
        }
    }

    public SelectImplementation(CoroutineContext coroutineContext) {
        this.c = coroutineContext;
    }

    public final void a(DisposableHandle disposableHandle) {
        this.e = disposableHandle;
    }

    public final void b(Segment segment, int i2) {
        this.e = segment;
        this.f = i2;
    }

    public final boolean c(Object obj, Object obj2) {
        if (l(obj, obj2) == 0) {
            return true;
        }
        return false;
    }

    public final void d(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != SelectKt.c) {
                Symbol symbol = SelectKt.d;
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, symbol)) {
                        ArrayList<ClauseData> arrayList = this.d;
                        if (arrayList != null) {
                            for (ClauseData a2 : arrayList) {
                                a2.a();
                            }
                            this.g = SelectKt.e;
                            this.d = null;
                            return;
                        }
                        return;
                    } else if (atomicReferenceFieldUpdater.get(this) != obj) {
                    }
                }
            } else {
                return;
            }
        }
    }

    public final void e(Object obj) {
        this.g = obj;
    }

    public final Object f(ContinuationImpl continuationImpl) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i;
        Object obj = atomicReferenceFieldUpdater.get(this);
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        ClauseData clauseData = (ClauseData) obj;
        Object obj2 = this.g;
        ArrayList arrayList = this.d;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ClauseData clauseData2 = (ClauseData) it.next();
                if (clauseData2 != clauseData) {
                    clauseData2.a();
                }
            }
            atomicReferenceFieldUpdater.set(this, SelectKt.c);
            this.g = SelectKt.e;
            this.d = null;
        }
        Object invoke = clauseData.c.invoke(clauseData.f819a, clauseData.d, obj2);
        clauseData.getClass();
        Symbol symbol = SelectKt.f;
        Function function = clauseData.e;
        if (clauseData.d == symbol) {
            return ((Function1) function).invoke(continuationImpl);
        }
        return ((Function2) function).invoke(invoke, continuationImpl);
    }

    public Object g(Continuation continuation) {
        if (i.get(this) instanceof ClauseData) {
            return f((ContinuationImpl) continuation);
        }
        return h((ContinuationImpl) continuation);
    }

    public final CoroutineContext getContext() {
        return this.c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d6 A[PHI: r10 
      PHI: (r10v2 java.lang.Object) = (r10v3 java.lang.Object), (r10v1 java.lang.Object) binds: [B:48:0x00d3, B:10:0x0027] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(kotlin.coroutines.jvm.internal.ContinuationImpl r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1 r0 = (kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1 r0 = new kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1
            r0.<init>(r9, r10)
        L_0x0018:
            java.lang.Object r10 = r0.d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.f
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 == r5) goto L_0x0034
            if (r2 != r4) goto L_0x002c
            kotlin.ResultKt.b(r10)
            goto L_0x00d6
        L_0x002c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0034:
            kotlinx.coroutines.selects.SelectImplementation r2 = r0.c
            kotlin.ResultKt.b(r10)
            goto L_0x00cb
        L_0x003b:
            kotlin.ResultKt.b(r10)
            r0.c = r9
            r0.f = r5
            kotlinx.coroutines.CancellableContinuationImpl r10 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.b(r0)
            r10.<init>(r5, r2)
            r10.q()
        L_0x004e:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = i
            java.lang.Object r6 = r2.get(r9)
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.selects.SelectKt.b
            if (r6 != r7) goto L_0x0069
        L_0x0058:
            boolean r7 = r2.compareAndSet(r9, r6, r10)
            if (r7 == 0) goto L_0x0062
            r10.t(r9)
            goto L_0x00b5
        L_0x0062:
            java.lang.Object r7 = r2.get(r9)
            if (r7 == r6) goto L_0x0058
            goto L_0x004e
        L_0x0069:
            boolean r8 = r6 instanceof java.util.List
            if (r8 == 0) goto L_0x009a
        L_0x006d:
            boolean r8 = r2.compareAndSet(r9, r6, r7)
            if (r8 == 0) goto L_0x0093
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r2 = r6.iterator()
        L_0x0079:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x004e
            java.lang.Object r6 = r2.next()
            kotlinx.coroutines.selects.SelectImplementation$ClauseData r6 = r9.i(r6)
            kotlin.jvm.internal.Intrinsics.c(r6)
            r6.g = r3
            r7 = -1
            r6.h = r7
            r9.k(r6, r5)
            goto L_0x0079
        L_0x0093:
            java.lang.Object r8 = r2.get(r9)
            if (r8 == r6) goto L_0x006d
            goto L_0x004e
        L_0x009a:
            boolean r2 = r6 instanceof kotlinx.coroutines.selects.SelectImplementation.ClauseData
            if (r2 == 0) goto L_0x00d7
            kotlin.Unit r2 = kotlin.Unit.f696a
            kotlinx.coroutines.selects.SelectImplementation$ClauseData r6 = (kotlinx.coroutines.selects.SelectImplementation.ClauseData) r6
            java.lang.Object r5 = r9.g
            kotlin.jvm.functions.Function3 r7 = r6.f
            if (r7 == 0) goto L_0x00b1
            kotlinx.coroutines.internal.Symbol r6 = r6.d
            java.lang.Object r5 = r7.invoke(r9, r6, r5)
            kotlin.jvm.functions.Function3 r5 = (kotlin.jvm.functions.Function3) r5
            goto L_0x00b2
        L_0x00b1:
            r5 = r3
        L_0x00b2:
            r10.l(r2, r5)
        L_0x00b5:
            java.lang.Object r10 = r10.p()
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r10 != r2) goto L_0x00c2
            java.lang.String r5 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r5)
        L_0x00c2:
            if (r10 != r2) goto L_0x00c5
            goto L_0x00c7
        L_0x00c5:
            kotlin.Unit r10 = kotlin.Unit.f696a
        L_0x00c7:
            if (r10 != r1) goto L_0x00ca
            return r1
        L_0x00ca:
            r2 = r9
        L_0x00cb:
            r0.c = r3
            r0.f = r4
            java.lang.Object r10 = r2.f(r0)
            if (r10 != r1) goto L_0x00d6
            return r1
        L_0x00d6:
            return r10
        L_0x00d7:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "unexpected state: "
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.h(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: kotlinx.coroutines.selects.SelectImplementation$ClauseData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: kotlinx.coroutines.selects.SelectImplementation$ClauseData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: kotlinx.coroutines.selects.SelectImplementation$ClauseData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlinx.coroutines.selects.SelectImplementation$ClauseData} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.selects.SelectImplementation.ClauseData i(java.lang.Object r5) {
        /*
            r4 = this;
            java.util.ArrayList r0 = r4.d
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x001c
            java.lang.Object r2 = r0.next()
            r3 = r2
            kotlinx.coroutines.selects.SelectImplementation$ClauseData r3 = (kotlinx.coroutines.selects.SelectImplementation.ClauseData) r3
            java.lang.Object r3 = r3.f819a
            if (r3 != r5) goto L_0x000a
            r1 = r2
        L_0x001c:
            kotlinx.coroutines.selects.SelectImplementation$ClauseData r1 = (kotlinx.coroutines.selects.SelectImplementation.ClauseData) r1
            if (r1 == 0) goto L_0x0021
            return r1
        L_0x0021:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Clause with object "
            r1.<init>(r2)
            r1.append(r5)
            java.lang.String r5 = " is not found"
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            java.lang.String r5 = r5.toString()
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.i(java.lang.Object):kotlinx.coroutines.selects.SelectImplementation$ClauseData");
    }

    public void j(SelectClause1 selectClause1, Function2 function2) {
        k(new ClauseData(selectClause1.b(), selectClause1.a(), selectClause1.d(), (Symbol) null, function2, selectClause1.c()), false);
    }

    public final void k(ClauseData clauseData, boolean z) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i;
        if (!(atomicReferenceFieldUpdater.get(this) instanceof ClauseData)) {
            Object obj = clauseData.f819a;
            if (!z) {
                ArrayList<ClauseData> arrayList = this.d;
                Intrinsics.c(arrayList);
                if (!arrayList.isEmpty()) {
                    for (ClauseData clauseData2 : arrayList) {
                        if (clauseData2.f819a == obj) {
                            throw new IllegalStateException(("Cannot use select clauses on the same object: " + obj).toString());
                        }
                    }
                }
            }
            clauseData.b.invoke(obj, this, clauseData.d);
            if (this.g == SelectKt.e) {
                if (!z) {
                    ArrayList arrayList2 = this.d;
                    Intrinsics.c(arrayList2);
                    arrayList2.add(clauseData);
                }
                clauseData.g = this.e;
                clauseData.h = this.f;
                this.e = null;
                this.f = -1;
                return;
            }
            atomicReferenceFieldUpdater.set(this, clauseData);
        }
    }

    public final int l(Object obj, Object obj2) {
        Function3 function3;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof CancellableContinuation) {
                ClauseData i2 = i(obj);
                if (i2 != null) {
                    Function3 function32 = i2.f;
                    if (function32 != null) {
                        function3 = (Function3) function32.invoke(this, i2.d, obj2);
                    } else {
                        function3 = null;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj3, i2)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj3) {
                        }
                    }
                    CancellableContinuation cancellableContinuation = (CancellableContinuation) obj3;
                    this.g = obj2;
                    Function3 function33 = SelectKt.f820a;
                    Symbol i3 = cancellableContinuation.i(Unit.f696a, function3);
                    if (i3 == null) {
                        this.g = SelectKt.e;
                        return 2;
                    }
                    cancellableContinuation.F(i3);
                    return 0;
                }
                continue;
            } else if (Intrinsics.a(obj3, SelectKt.c) || (obj3 instanceof ClauseData)) {
                return 3;
            } else {
                if (Intrinsics.a(obj3, SelectKt.d)) {
                    return 2;
                }
                if (Intrinsics.a(obj3, SelectKt.b)) {
                    List s = CollectionsKt.s(obj);
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj3, s)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj3) {
                        }
                    }
                    return 1;
                } else if (obj3 instanceof List) {
                    ArrayList w = CollectionsKt.w((Collection) obj3, obj);
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj3, w)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj3) {
                        }
                    }
                    return 1;
                } else {
                    throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                }
            }
        }
    }
}
