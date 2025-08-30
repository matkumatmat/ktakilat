package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u0005H@¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u0005H¤@¢\u0006\u0002\u0010\tJ\u000e\u0010\u000b\u001a\u00020\u0005H@¢\u0006\u0002\u0010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/datastore/core/RunOnce;", "", "()V", "didRun", "Lkotlinx/coroutines/CompletableDeferred;", "", "runMutex", "Lkotlinx/coroutines/sync/Mutex;", "awaitComplete", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doRun", "runIfNeeded", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDataStoreImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataStoreImpl.kt\nandroidx/datastore/core/RunOnce\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,538:1\n120#2,10:539\n*S KotlinDebug\n*F\n+ 1 DataStoreImpl.kt\nandroidx/datastore/core/RunOnce\n*L\n495#1:539,10\n*E\n"})
public abstract class RunOnce {
    @NotNull
    private final CompletableDeferred<Unit> didRun = CompletableDeferredKt.a();
    @NotNull
    private final Mutex runMutex = MutexKt.a();

    @Nullable
    public final Object awaitComplete(@NotNull Continuation<? super Unit> continuation) {
        Object k = this.didRun.k(continuation);
        if (k == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return k;
        }
        return Unit.f696a;
    }

    @Nullable
    public abstract Object doRun(@NotNull Continuation<? super Unit> continuation);

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0070 A[Catch:{ all -> 0x0076 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007a A[SYNTHETIC, Splitter:B:33:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object runIfNeeded(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.datastore.core.RunOnce$runIfNeeded$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.datastore.core.RunOnce$runIfNeeded$1 r0 = (androidx.datastore.core.RunOnce$runIfNeeded$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.RunOnce$runIfNeeded$1 r0 = new androidx.datastore.core.RunOnce$runIfNeeded$1
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x004a
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r1 = r0.L$1
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.RunOnce r0 = (androidx.datastore.core.RunOnce) r0
            kotlin.ResultKt.b(r7)     // Catch:{ all -> 0x0033 }
            goto L_0x0089
        L_0x0033:
            r7 = move-exception
            goto L_0x0094
        L_0x0035:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x003d:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r4 = r0.L$0
            androidx.datastore.core.RunOnce r4 = (androidx.datastore.core.RunOnce) r4
            kotlin.ResultKt.b(r7)
            r7 = r2
            goto L_0x0068
        L_0x004a:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.CompletableDeferred<kotlin.Unit> r7 = r6.didRun
            boolean r7 = r7.y()
            if (r7 == 0) goto L_0x0058
            kotlin.Unit r7 = kotlin.Unit.f696a
            return r7
        L_0x0058:
            kotlinx.coroutines.sync.Mutex r7 = r6.runMutex
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r2 = r7.d(r0)
            if (r2 != r1) goto L_0x0067
            return r1
        L_0x0067:
            r4 = r6
        L_0x0068:
            kotlinx.coroutines.CompletableDeferred<kotlin.Unit> r2 = r4.didRun     // Catch:{ all -> 0x0076 }
            boolean r2 = r2.y()     // Catch:{ all -> 0x0076 }
            if (r2 == 0) goto L_0x007a
            kotlin.Unit r0 = kotlin.Unit.f696a     // Catch:{ all -> 0x0076 }
            r7.c(r5)
            return r0
        L_0x0076:
            r0 = move-exception
            r1 = r7
            r7 = r0
            goto L_0x0094
        L_0x007a:
            r0.L$0 = r4     // Catch:{ all -> 0x0076 }
            r0.L$1 = r7     // Catch:{ all -> 0x0076 }
            r0.label = r3     // Catch:{ all -> 0x0076 }
            java.lang.Object r0 = r4.doRun(r0)     // Catch:{ all -> 0x0076 }
            if (r0 != r1) goto L_0x0087
            return r1
        L_0x0087:
            r1 = r7
            r0 = r4
        L_0x0089:
            kotlinx.coroutines.CompletableDeferred<kotlin.Unit> r7 = r0.didRun     // Catch:{ all -> 0x0033 }
            kotlin.Unit r0 = kotlin.Unit.f696a     // Catch:{ all -> 0x0033 }
            r7.s(r0)     // Catch:{ all -> 0x0033 }
            r1.c(r5)
            return r0
        L_0x0094:
            r1.c(r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.RunOnce.runIfNeeded(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
