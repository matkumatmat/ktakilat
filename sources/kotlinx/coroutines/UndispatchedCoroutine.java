package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/UndispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "", "threadLocalIsSet", "Z", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCoroutineContext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContext.kt\nkotlinx/coroutines/UndispatchedCoroutine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,310:1\n1#2:311\n103#3,13:312\n*S KotlinDebug\n*F\n+ 1 CoroutineContext.kt\nkotlinx/coroutines/UndispatchedCoroutine\n*L\n265#1:312,13\n*E\n"})
public final class UndispatchedCoroutine<T> extends ScopeCoroutine<T> {
    public final ThreadLocal g;
    private volatile boolean threadLocalIsSet;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public UndispatchedCoroutine(kotlin.coroutines.Continuation r3, kotlin.coroutines.CoroutineContext r4) {
        /*
            r2 = this;
            kotlinx.coroutines.UndispatchedMarker r0 = kotlinx.coroutines.UndispatchedMarker.c
            kotlin.coroutines.CoroutineContext$Element r1 = r4.get(r0)
            if (r1 != 0) goto L_0x000d
            kotlin.coroutines.CoroutineContext r0 = r4.plus(r0)
            goto L_0x000e
        L_0x000d:
            r0 = r4
        L_0x000e:
            r2.<init>(r3, r0)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.g = r0
            kotlin.coroutines.CoroutineContext r3 = r3.getContext()
            kotlin.coroutines.ContinuationInterceptor$Key r0 = kotlin.coroutines.ContinuationInterceptor.b
            kotlin.coroutines.CoroutineContext$Element r3 = r3.get(r0)
            boolean r3 = r3 instanceof kotlinx.coroutines.CoroutineDispatcher
            if (r3 != 0) goto L_0x0031
            r3 = 0
            java.lang.Object r3 = kotlinx.coroutines.internal.ThreadContextKt.c(r4, r3)
            kotlinx.coroutines.internal.ThreadContextKt.a(r4, r3)
            r2.s0(r4, r3)
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.UndispatchedCoroutine.<init>(kotlin.coroutines.Continuation, kotlin.coroutines.CoroutineContext):void");
    }

    public final void H(Object obj) {
        if (this.threadLocalIsSet) {
            Pair pair = (Pair) this.g.get();
            if (pair != null) {
                ThreadContextKt.a((CoroutineContext) pair.component1(), pair.component2());
            }
            this.g.remove();
        }
        Object a2 = CompletionStateKt.a(obj);
        Continuation continuation = this.f;
        CoroutineContext context = continuation.getContext();
        UndispatchedCoroutine undispatchedCoroutine = null;
        Object c = ThreadContextKt.c(context, undispatchedCoroutine);
        if (c != ThreadContextKt.f807a) {
            undispatchedCoroutine = CoroutineContextKt.c(continuation, context, c);
        }
        try {
            this.f.resumeWith(a2);
            Unit unit = Unit.f696a;
        } finally {
            if (undispatchedCoroutine == null || undispatchedCoroutine.r0()) {
                ThreadContextKt.a(context, c);
            }
        }
    }

    public final boolean r0() {
        boolean z;
        if (!this.threadLocalIsSet || this.g.get() != null) {
            z = false;
        } else {
            z = true;
        }
        this.g.remove();
        return !z;
    }

    public final void s0(CoroutineContext coroutineContext, Object obj) {
        this.threadLocalIsSet = true;
        this.g.set(new Pair(coroutineContext, obj));
    }
}
