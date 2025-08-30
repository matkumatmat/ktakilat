package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nDataStoreImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataStoreImpl.kt\nandroidx/datastore/core/DataStoreImpl$InitDataStore$doRun$initData$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,538:1\n1855#2,2:539\n120#3,10:541\n*S KotlinDebug\n*F\n+ 1 DataStoreImpl.kt\nandroidx/datastore/core/DataStoreImpl$InitDataStore$doRun$initData$1\n*L\n458#1:539,2\n461#1:541,10\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H@"}, d2 = {"<anonymous>", "Landroidx/datastore/core/Data;", "T"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1", f = "DataStoreImpl.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {437, 458, 546, 468}, m = "invokeSuspend", n = {"updateLock", "initializationComplete", "currentData", "updateLock", "initializationComplete", "currentData", "api", "initializationComplete", "currentData", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
public final class DataStoreImpl$InitDataStore$doRun$initData$1 extends SuspendLambda implements Function1<Continuation<? super Data<T>>, Object> {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;
    final /* synthetic */ DataStoreImpl<T>.InitDataStore this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$InitDataStore$doRun$initData$1(DataStoreImpl<T> dataStoreImpl, DataStoreImpl<T>.InitDataStore initDataStore, Continuation<? super DataStoreImpl$InitDataStore$doRun$initData$1> continuation) {
        super(1, continuation);
        this.this$0 = dataStoreImpl;
        this.this$1 = initDataStore;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new DataStoreImpl$InitDataStore$doRun$initData$1(this.this$0, this.this$1, continuation);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x010c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x010d  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r11.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r1 == 0) goto L_0x0061
            if (r1 == r5) goto L_0x004d
            if (r1 == r4) goto L_0x0035
            if (r1 == r3) goto L_0x0024
            if (r1 != r2) goto L_0x001c
            int r0 = r11.I$0
            java.lang.Object r1 = r11.L$0
            kotlin.ResultKt.b(r12)
            goto L_0x010f
        L_0x001c:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0024:
            java.lang.Object r1 = r11.L$2
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r3 = r11.L$1
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            java.lang.Object r4 = r11.L$0
            kotlin.jvm.internal.Ref$BooleanRef r4 = (kotlin.jvm.internal.Ref.BooleanRef) r4
            kotlin.ResultKt.b(r12)
            goto L_0x00e5
        L_0x0035:
            java.lang.Object r1 = r11.L$4
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r7 = r11.L$3
            androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1 r7 = (androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1) r7
            java.lang.Object r8 = r11.L$2
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r9 = r11.L$1
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref.BooleanRef) r9
            java.lang.Object r10 = r11.L$0
            kotlinx.coroutines.sync.Mutex r10 = (kotlinx.coroutines.sync.Mutex) r10
            kotlin.ResultKt.b(r12)
            goto L_0x00a7
        L_0x004d:
            java.lang.Object r1 = r11.L$3
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r7 = r11.L$2
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            java.lang.Object r8 = r11.L$1
            kotlin.jvm.internal.Ref$BooleanRef r8 = (kotlin.jvm.internal.Ref.BooleanRef) r8
            java.lang.Object r9 = r11.L$0
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            kotlin.ResultKt.b(r12)
            goto L_0x0086
        L_0x0061:
            kotlin.ResultKt.b(r12)
            kotlinx.coroutines.sync.MutexImpl r9 = kotlinx.coroutines.sync.MutexKt.a()
            kotlin.jvm.internal.Ref$BooleanRef r8 = new kotlin.jvm.internal.Ref$BooleanRef
            r8.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            androidx.datastore.core.DataStoreImpl<T> r12 = r11.this$0
            r11.L$0 = r9
            r11.L$1 = r8
            r11.L$2 = r1
            r11.L$3 = r1
            r11.label = r5
            java.lang.Object r12 = r12.readDataOrHandleCorruption(r5, r11)
            if (r12 != r0) goto L_0x0085
            return r0
        L_0x0085:
            r7 = r1
        L_0x0086:
            androidx.datastore.core.Data r12 = (androidx.datastore.core.Data) r12
            java.lang.Object r12 = r12.getValue()
            r1.element = r12
            androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1 r12 = new androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1
            androidx.datastore.core.DataStoreImpl<T> r1 = r11.this$0
            r12.<init>(r9, r8, r7, r1)
            androidx.datastore.core.DataStoreImpl<T>$InitDataStore r1 = r11.this$1
            java.util.List r1 = r1.initTasks
            if (r1 == 0) goto L_0x00ca
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r12
        L_0x00a7:
            boolean r12 = r1.hasNext()
            if (r12 == 0) goto L_0x00c6
            java.lang.Object r12 = r1.next()
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.L$0 = r10
            r11.L$1 = r9
            r11.L$2 = r8
            r11.L$3 = r7
            r11.L$4 = r1
            r11.label = r4
            java.lang.Object r12 = r12.invoke(r7, r11)
            if (r12 != r0) goto L_0x00a7
            return r0
        L_0x00c6:
            r7 = r8
            r4 = r9
            r1 = r10
            goto L_0x00cc
        L_0x00ca:
            r4 = r8
            r1 = r9
        L_0x00cc:
            androidx.datastore.core.DataStoreImpl<T>$InitDataStore r12 = r11.this$1
            r12.initTasks = r6
            r11.L$0 = r4
            r11.L$1 = r7
            r11.L$2 = r1
            r11.L$3 = r6
            r11.L$4 = r6
            r11.label = r3
            java.lang.Object r12 = r1.d(r11)
            if (r12 != r0) goto L_0x00e4
            return r0
        L_0x00e4:
            r3 = r7
        L_0x00e5:
            r4.element = r5     // Catch:{ all -> 0x011b }
            kotlin.Unit r12 = kotlin.Unit.f696a     // Catch:{ all -> 0x011b }
            r1.c(r6)
            T r1 = r3.element
            if (r1 == 0) goto L_0x00f5
            int r12 = r1.hashCode()
            goto L_0x00f6
        L_0x00f5:
            r12 = 0
        L_0x00f6:
            androidx.datastore.core.DataStoreImpl<T> r3 = r11.this$0
            androidx.datastore.core.InterProcessCoordinator r3 = r3.getCoordinator()
            r11.L$0 = r1
            r11.L$1 = r6
            r11.L$2 = r6
            r11.I$0 = r12
            r11.label = r2
            java.lang.Object r2 = r3.getVersion(r11)
            if (r2 != r0) goto L_0x010d
            return r0
        L_0x010d:
            r0 = r12
            r12 = r2
        L_0x010f:
            java.lang.Number r12 = (java.lang.Number) r12
            int r12 = r12.intValue()
            androidx.datastore.core.Data r2 = new androidx.datastore.core.Data
            r2.<init>(r1, r0, r12)
            return r2
        L_0x011b:
            r12 = move-exception
            r1.c(r6)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Data<T>> continuation) {
        return ((DataStoreImpl$InitDataStore$doRun$initData$1) create(continuation)).invokeSuspend(Unit.f696a);
    }
}
