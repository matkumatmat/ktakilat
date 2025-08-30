package androidx.datastore.core;

import androidx.datastore.core.Message;
import androidx.datastore.core.UpdatingDataContextElement;
import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nDataStoreImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataStoreImpl.kt\nandroidx/datastore/core/DataStoreImpl\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,538:1\n120#2,10:539\n120#2,10:549\n*S KotlinDebug\n*F\n+ 1 DataStoreImpl.kt\nandroidx/datastore/core/DataStoreImpl\n*L\n130#1:539,10\n148#1:549,10\n*E\n"})
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 V*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002VWBn\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012?\b\u0002\u0010\u0005\u001a9\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00070\u0006\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u000e\u00103\u001a\u00020\rH@¢\u0006\u0002\u00104JG\u00105\u001a\u0002H6\"\u0004\b\u0001\u001062\u0006\u00107\u001a\u0002082\u001c\u00109\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H60\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0:H@\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010;J\u001c\u0010<\u001a\u00020\r2\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u000002H@¢\u0006\u0002\u0010>J\u000e\u0010?\u001a\u00020\rH@¢\u0006\u0002\u00104J\u000e\u0010@\u001a\u00020\rH@¢\u0006\u0002\u00104J\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000B2\u0006\u0010C\u001a\u000208H@¢\u0006\u0002\u0010DJ\u000e\u0010E\u001a\u00028\u0000H@¢\u0006\u0002\u00104J\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000G2\u0006\u00107\u001a\u000208H@¢\u0006\u0002\u0010DJ\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000B2\u0006\u0010C\u001a\u000208H@¢\u0006\u0002\u0010DJI\u0010I\u001a\u00028\u000021\u0010J\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(K\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00072\u0006\u0010L\u001a\u00020MH@¢\u0006\u0002\u0010NJA\u0010O\u001a\u00028\u000021\u0010J\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(K\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0007H@¢\u0006\u0002\u0010PJ \u0010Q\u001a\u00020\u00152\u0006\u0010R\u001a\u00028\u00002\u0006\u0010S\u001a\u000208H@¢\u0006\u0004\bT\u0010UR\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010&\u001a\f0'R\b\u0012\u0004\u0012\u00028\u00000\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R!\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000)8@X\u0002¢\u0006\f\u001a\u0004\b,\u0010-*\u0004\b*\u0010+R\u001a\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000)0/X\u0004¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000201X\u0004¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Landroidx/datastore/core/DataStoreImpl;", "T", "Landroidx/datastore/core/DataStore;", "storage", "Landroidx/datastore/core/Storage;", "initTasksList", "", "Lkotlin/Function2;", "Landroidx/datastore/core/InitializerApi;", "Lkotlin/ParameterName;", "name", "api", "Lkotlin/coroutines/Continuation;", "", "", "corruptionHandler", "Landroidx/datastore/core/CorruptionHandler;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/datastore/core/Storage;Ljava/util/List;Landroidx/datastore/core/CorruptionHandler;Lkotlinx/coroutines/CoroutineScope;)V", "collectorCounter", "", "collectorJob", "Lkotlinx/coroutines/Job;", "collectorMutex", "Lkotlinx/coroutines/sync/Mutex;", "coordinator", "Landroidx/datastore/core/InterProcessCoordinator;", "getCoordinator", "()Landroidx/datastore/core/InterProcessCoordinator;", "coordinator$delegate", "Lkotlin/Lazy;", "data", "Lkotlinx/coroutines/flow/Flow;", "getData", "()Lkotlinx/coroutines/flow/Flow;", "inMemoryCache", "Landroidx/datastore/core/DataStoreInMemoryCache;", "readAndInit", "Landroidx/datastore/core/DataStoreImpl$InitDataStore;", "storageConnection", "Landroidx/datastore/core/StorageConnection;", "getStorageConnection$datastore_core_release$delegate", "(Landroidx/datastore/core/DataStoreImpl;)Ljava/lang/Object;", "getStorageConnection$datastore_core_release", "()Landroidx/datastore/core/StorageConnection;", "storageConnectionDelegate", "Lkotlin/Lazy;", "writeActor", "Landroidx/datastore/core/SimpleActor;", "Landroidx/datastore/core/Message$Update;", "decrementCollector", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doWithWriteFileLock", "R", "hasWriteFileLock", "", "block", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleUpdate", "update", "(Landroidx/datastore/core/Message$Update;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementCollector", "readAndInitOrPropagateAndThrowFailure", "readDataAndUpdateCache", "Landroidx/datastore/core/State;", "requireLock", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readDataFromFileOrDefault", "readDataOrHandleCorruption", "Landroidx/datastore/core/Data;", "readState", "transformAndWrite", "transform", "t", "callerContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateData", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeData", "newData", "updateCache", "writeData$datastore_core_release", "(Ljava/lang/Object;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "InitDataStore", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DataStoreImpl<T> implements DataStore<T> {
    @NotNull
    private static final String BUG_MESSAGE = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private int collectorCounter;
    @Nullable
    private Job collectorJob;
    @NotNull
    private final Mutex collectorMutex;
    @NotNull
    private final Lazy coordinator$delegate;
    @NotNull
    private final CorruptionHandler<T> corruptionHandler;
    @NotNull
    private final Flow<T> data;
    /* access modifiers changed from: private */
    @NotNull
    public final DataStoreInMemoryCache<T> inMemoryCache;
    /* access modifiers changed from: private */
    @NotNull
    public final DataStoreImpl<T>.InitDataStore readAndInit;
    @NotNull
    private final CoroutineScope scope;
    /* access modifiers changed from: private */
    @NotNull
    public final Storage<T> storage;
    /* access modifiers changed from: private */
    @NotNull
    public final Lazy<StorageConnection<T>> storageConnectionDelegate;
    /* access modifiers changed from: private */
    @NotNull
    public final SimpleActor<Message.Update<T>> writeActor;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/datastore/core/DataStoreImpl$Companion;", "", "()V", "BUG_MESSAGE", "", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001BD\u0012=\u0010\u0002\u001a9\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00040\u0003¢\u0006\u0002\u0010\fJ\u000e\u0010\u000e\u001a\u00020\nH@¢\u0006\u0002\u0010\u000fRG\u0010\r\u001a;\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/datastore/core/DataStoreImpl$InitDataStore;", "Landroidx/datastore/core/RunOnce;", "initTasksList", "", "Lkotlin/Function2;", "Landroidx/datastore/core/InitializerApi;", "Lkotlin/ParameterName;", "name", "api", "Lkotlin/coroutines/Continuation;", "", "", "(Landroidx/datastore/core/DataStoreImpl;Ljava/util/List;)V", "initTasks", "doRun", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class InitDataStore extends RunOnce {
        /* access modifiers changed from: private */
        @Nullable
        public List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> initTasks;
        final /* synthetic */ DataStoreImpl<T> this$0;

        public InitDataStore(@NotNull DataStoreImpl dataStoreImpl, List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> list) {
            Intrinsics.checkNotNullParameter(list, "initTasksList");
            this.this$0 = dataStoreImpl;
            this.initTasks = CollectionsKt.D(list);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object doRun(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
            /*
                r6 = this;
                boolean r0 = r7 instanceof androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1
                if (r0 == 0) goto L_0x0013
                r0 = r7
                androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1 r0 = (androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1 r0 = new androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1
                r0.<init>(r6, r7)
            L_0x0018:
                java.lang.Object r7 = r0.result
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x003e
                if (r2 == r4) goto L_0x0036
                if (r2 != r3) goto L_0x002e
                java.lang.Object r0 = r0.L$0
                androidx.datastore.core.DataStoreImpl$InitDataStore r0 = (androidx.datastore.core.DataStoreImpl.InitDataStore) r0
                kotlin.ResultKt.b(r7)
                goto L_0x0069
            L_0x002e:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x0036:
                java.lang.Object r0 = r0.L$0
                androidx.datastore.core.DataStoreImpl$InitDataStore r0 = (androidx.datastore.core.DataStoreImpl.InitDataStore) r0
                kotlin.ResultKt.b(r7)
                goto L_0x007b
            L_0x003e:
                kotlin.ResultKt.b(r7)
                java.util.List<? extends kotlin.jvm.functions.Function2<? super androidx.datastore.core.InitializerApi<T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>> r7 = r6.initTasks
                if (r7 == 0) goto L_0x006c
                kotlin.jvm.internal.Intrinsics.c(r7)
                boolean r7 = r7.isEmpty()
                if (r7 == 0) goto L_0x004f
                goto L_0x006c
            L_0x004f:
                androidx.datastore.core.DataStoreImpl<T> r7 = r6.this$0
                androidx.datastore.core.InterProcessCoordinator r7 = r7.getCoordinator()
                androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1 r2 = new androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1
                androidx.datastore.core.DataStoreImpl<T> r4 = r6.this$0
                r5 = 0
                r2.<init>(r4, r6, r5)
                r0.L$0 = r6
                r0.label = r3
                java.lang.Object r7 = r7.lock(r2, r0)
                if (r7 != r1) goto L_0x0068
                return r1
            L_0x0068:
                r0 = r6
            L_0x0069:
                androidx.datastore.core.Data r7 = (androidx.datastore.core.Data) r7
                goto L_0x007d
            L_0x006c:
                androidx.datastore.core.DataStoreImpl<T> r7 = r6.this$0
                r0.L$0 = r6
                r0.label = r4
                r2 = 0
                java.lang.Object r7 = r7.readDataOrHandleCorruption(r2, r0)
                if (r7 != r1) goto L_0x007a
                return r1
            L_0x007a:
                r0 = r6
            L_0x007b:
                androidx.datastore.core.Data r7 = (androidx.datastore.core.Data) r7
            L_0x007d:
                androidx.datastore.core.DataStoreImpl<T> r0 = r0.this$0
                androidx.datastore.core.DataStoreInMemoryCache r0 = r0.inMemoryCache
                r0.tryUpdate(r7)
                kotlin.Unit r7 = kotlin.Unit.f696a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.InitDataStore.doRun(kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    public DataStoreImpl(@NotNull Storage<T> storage2, @NotNull List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> list, @NotNull CorruptionHandler<T> corruptionHandler2, @NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(storage2, "storage");
        Intrinsics.checkNotNullParameter(list, "initTasksList");
        Intrinsics.checkNotNullParameter(corruptionHandler2, "corruptionHandler");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        this.storage = storage2;
        this.corruptionHandler = corruptionHandler2;
        this.scope = coroutineScope;
        this.data = FlowKt.h(new DataStoreImpl$data$1(this, (Continuation<? super DataStoreImpl$data$1>) null));
        this.collectorMutex = MutexKt.a();
        this.inMemoryCache = new DataStoreInMemoryCache<>();
        this.readAndInit = new InitDataStore(this, list);
        this.storageConnectionDelegate = LazyKt.b(new DataStoreImpl$storageConnectionDelegate$1(this));
        this.coordinator$delegate = LazyKt.b(new DataStoreImpl$coordinator$2(this));
        this.writeActor = new SimpleActor<>(coroutineScope, new DataStoreImpl$writeActor$1(this), DataStoreImpl$writeActor$2.INSTANCE, new DataStoreImpl$writeActor$3(this, (Continuation<? super DataStoreImpl$writeActor$3>) null));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054 A[Catch:{ all -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object decrementCollector(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.datastore.core.DataStoreImpl$decrementCollector$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            androidx.datastore.core.DataStoreImpl$decrementCollector$1 r0 = (androidx.datastore.core.DataStoreImpl$decrementCollector$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.DataStoreImpl$decrementCollector$1 r0 = new androidx.datastore.core.DataStoreImpl$decrementCollector$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r1 = r0.L$1
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.DataStoreImpl r0 = (androidx.datastore.core.DataStoreImpl) r0
            kotlin.ResultKt.b(r5)
            goto L_0x004b
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0037:
            kotlin.ResultKt.b(r5)
            kotlinx.coroutines.sync.Mutex r5 = r4.collectorMutex
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r0 = r5.d(r0)
            if (r0 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r0 = r4
            r1 = r5
        L_0x004b:
            r5 = 0
            int r2 = r0.collectorCounter     // Catch:{ all -> 0x005e }
            int r2 = r2 + -1
            r0.collectorCounter = r2     // Catch:{ all -> 0x005e }
            if (r2 != 0) goto L_0x0060
            kotlinx.coroutines.Job r2 = r0.collectorJob     // Catch:{ all -> 0x005e }
            if (r2 == 0) goto L_0x005b
            r2.c(r5)     // Catch:{ all -> 0x005e }
        L_0x005b:
            r0.collectorJob = r5     // Catch:{ all -> 0x005e }
            goto L_0x0060
        L_0x005e:
            r0 = move-exception
            goto L_0x0068
        L_0x0060:
            kotlin.Unit r0 = kotlin.Unit.f696a     // Catch:{ all -> 0x005e }
            r1.c(r5)
            kotlin.Unit r5 = kotlin.Unit.f696a
            return r5
        L_0x0068:
            r1.c(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.decrementCollector(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final <R> Object doWithWriteFileLock(boolean z, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super R> continuation) {
        if (z) {
            return function1.invoke(continuation);
        }
        return getCoordinator().lock(new DataStoreImpl$doWithWriteFileLock$3(function1, (Continuation<? super DataStoreImpl$doWithWriteFileLock$3>) null), continuation);
    }

    /* access modifiers changed from: private */
    public final InterProcessCoordinator getCoordinator() {
        return (InterProcessCoordinator) this.coordinator$delegate.getValue();
    }

    private static Object getStorageConnection$datastore_core_release$delegate(DataStoreImpl<Object> dataStoreImpl) {
        return dataStoreImpl.storageConnectionDelegate;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object handleUpdate(androidx.datastore.core.Message.Update<T> r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.DataStoreImpl$handleUpdate$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.datastore.core.DataStoreImpl$handleUpdate$1 r0 = (androidx.datastore.core.DataStoreImpl$handleUpdate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.DataStoreImpl$handleUpdate$1 r0 = new androidx.datastore.core.DataStoreImpl$handleUpdate$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0054
            if (r2 == r5) goto L_0x004f
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.CompletableDeferred r9 = (kotlinx.coroutines.CompletableDeferred) r9
        L_0x002d:
            kotlin.ResultKt.b(r10)     // Catch:{ all -> 0x0032 }
            goto L_0x00ba
        L_0x0032:
            r10 = move-exception
            goto L_0x00dc
        L_0x0035:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003d:
            java.lang.Object r9 = r0.L$2
            kotlinx.coroutines.CompletableDeferred r9 = (kotlinx.coroutines.CompletableDeferred) r9
            java.lang.Object r2 = r0.L$1
            androidx.datastore.core.DataStoreImpl r2 = (androidx.datastore.core.DataStoreImpl) r2
            java.lang.Object r4 = r0.L$0
            androidx.datastore.core.Message$Update r4 = (androidx.datastore.core.Message.Update) r4
            kotlin.ResultKt.b(r10)     // Catch:{ all -> 0x0032 }
            r10 = r9
            r9 = r4
            goto L_0x00a2
        L_0x004f:
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.CompletableDeferred r9 = (kotlinx.coroutines.CompletableDeferred) r9
            goto L_0x002d
        L_0x0054:
            kotlin.ResultKt.b(r10)
            kotlinx.coroutines.CompletableDeferred r10 = r9.getAck()
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x007e }
            androidx.datastore.core.DataStoreInMemoryCache<T> r2 = r8.inMemoryCache     // Catch:{ all -> 0x007e }
            androidx.datastore.core.State r2 = r2.getCurrentState()     // Catch:{ all -> 0x007e }
            boolean r6 = r2 instanceof androidx.datastore.core.Data     // Catch:{ all -> 0x007e }
            if (r6 == 0) goto L_0x0083
            kotlin.jvm.functions.Function2 r2 = r9.getTransform()     // Catch:{ all -> 0x007e }
            kotlin.coroutines.CoroutineContext r9 = r9.getCallerContext()     // Catch:{ all -> 0x007e }
            r0.L$0 = r10     // Catch:{ all -> 0x007e }
            r0.label = r5     // Catch:{ all -> 0x007e }
            java.lang.Object r9 = r8.transformAndWrite(r2, r9, r0)     // Catch:{ all -> 0x007e }
            if (r9 != r1) goto L_0x007a
            return r1
        L_0x007a:
            r7 = r10
            r10 = r9
            r9 = r7
            goto L_0x00ba
        L_0x007e:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
            goto L_0x00dc
        L_0x0083:
            boolean r6 = r2 instanceof androidx.datastore.core.ReadException     // Catch:{ all -> 0x007e }
            if (r6 == 0) goto L_0x0088
            goto L_0x008a
        L_0x0088:
            boolean r5 = r2 instanceof androidx.datastore.core.UnInitialized     // Catch:{ all -> 0x007e }
        L_0x008a:
            if (r5 == 0) goto L_0x00cb
            androidx.datastore.core.State r5 = r9.getLastState()     // Catch:{ all -> 0x007e }
            if (r2 != r5) goto L_0x00bf
            r0.L$0 = r9     // Catch:{ all -> 0x007e }
            r0.L$1 = r8     // Catch:{ all -> 0x007e }
            r0.L$2 = r10     // Catch:{ all -> 0x007e }
            r0.label = r4     // Catch:{ all -> 0x007e }
            java.lang.Object r2 = r8.readAndInitOrPropagateAndThrowFailure(r0)     // Catch:{ all -> 0x007e }
            if (r2 != r1) goto L_0x00a1
            return r1
        L_0x00a1:
            r2 = r8
        L_0x00a2:
            kotlin.jvm.functions.Function2 r4 = r9.getTransform()     // Catch:{ all -> 0x007e }
            kotlin.coroutines.CoroutineContext r9 = r9.getCallerContext()     // Catch:{ all -> 0x007e }
            r0.L$0 = r10     // Catch:{ all -> 0x007e }
            r5 = 0
            r0.L$1 = r5     // Catch:{ all -> 0x007e }
            r0.L$2 = r5     // Catch:{ all -> 0x007e }
            r0.label = r3     // Catch:{ all -> 0x007e }
            java.lang.Object r9 = r2.transformAndWrite(r4, r9, r0)     // Catch:{ all -> 0x007e }
            if (r9 != r1) goto L_0x007a
            return r1
        L_0x00ba:
            java.lang.Object r10 = kotlin.Result.m16constructorimpl(r10)     // Catch:{ all -> 0x0032 }
            goto L_0x00e6
        L_0x00bf:
            java.lang.String r9 = "null cannot be cast to non-null type androidx.datastore.core.ReadException<T of androidx.datastore.core.DataStoreImpl.handleUpdate$lambda$2>"
            kotlin.jvm.internal.Intrinsics.d(r2, r9)     // Catch:{ all -> 0x007e }
            androidx.datastore.core.ReadException r2 = (androidx.datastore.core.ReadException) r2     // Catch:{ all -> 0x007e }
            java.lang.Throwable r9 = r2.getReadException()     // Catch:{ all -> 0x007e }
            throw r9     // Catch:{ all -> 0x007e }
        L_0x00cb:
            boolean r9 = r2 instanceof androidx.datastore.core.Final     // Catch:{ all -> 0x007e }
            if (r9 == 0) goto L_0x00d6
            androidx.datastore.core.Final r2 = (androidx.datastore.core.Final) r2     // Catch:{ all -> 0x007e }
            java.lang.Throwable r9 = r2.getFinalException()     // Catch:{ all -> 0x007e }
            throw r9     // Catch:{ all -> 0x007e }
        L_0x00d6:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x007e }
            r9.<init>()     // Catch:{ all -> 0x007e }
            throw r9     // Catch:{ all -> 0x007e }
        L_0x00dc:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            kotlin.Result$Failure r10 = kotlin.ResultKt.a(r10)
            java.lang.Object r10 = kotlin.Result.m16constructorimpl(r10)
        L_0x00e6:
            java.lang.Throwable r0 = kotlin.Result.m19exceptionOrNullimpl(r10)
            if (r0 != 0) goto L_0x00f0
            r9.s(r10)
            goto L_0x00f3
        L_0x00f0:
            r9.r(r0)
        L_0x00f3:
            kotlin.Unit r9 = kotlin.Unit.f696a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.handleUpdate(androidx.datastore.core.Message$Update, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0053 A[Catch:{ all -> 0x0062 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object incrementCollector(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.DataStoreImpl$incrementCollector$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.datastore.core.DataStoreImpl$incrementCollector$1 r0 = (androidx.datastore.core.DataStoreImpl$incrementCollector$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.DataStoreImpl$incrementCollector$1 r0 = new androidx.datastore.core.DataStoreImpl$incrementCollector$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r1 = r0.L$1
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.DataStoreImpl r0 = (androidx.datastore.core.DataStoreImpl) r0
            kotlin.ResultKt.b(r6)
            goto L_0x004b
        L_0x002f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0037:
            kotlin.ResultKt.b(r6)
            kotlinx.coroutines.sync.Mutex r6 = r5.collectorMutex
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r0 = r6.d(r0)
            if (r0 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r0 = r5
            r1 = r6
        L_0x004b:
            r6 = 0
            int r2 = r0.collectorCounter     // Catch:{ all -> 0x0062 }
            int r2 = r2 + r3
            r0.collectorCounter = r2     // Catch:{ all -> 0x0062 }
            if (r2 != r3) goto L_0x0064
            kotlinx.coroutines.CoroutineScope r2 = r0.scope     // Catch:{ all -> 0x0062 }
            androidx.datastore.core.DataStoreImpl$incrementCollector$2$1 r3 = new androidx.datastore.core.DataStoreImpl$incrementCollector$2$1     // Catch:{ all -> 0x0062 }
            r3.<init>(r0, r6)     // Catch:{ all -> 0x0062 }
            r4 = 3
            kotlinx.coroutines.Job r2 = kotlinx.coroutines.BuildersKt.b(r2, r6, r6, r3, r4)     // Catch:{ all -> 0x0062 }
            r0.collectorJob = r2     // Catch:{ all -> 0x0062 }
            goto L_0x0064
        L_0x0062:
            r0 = move-exception
            goto L_0x006c
        L_0x0064:
            kotlin.Unit r0 = kotlin.Unit.f696a     // Catch:{ all -> 0x0062 }
            r1.c(r6)
            kotlin.Unit r6 = kotlin.Unit.f696a
            return r6
        L_0x006c:
            r1.c(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.incrementCollector(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0069 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readAndInitOrPropagateAndThrowFailure(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 r0 = (androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 r0 = new androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0042
            if (r2 == r4) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            int r1 = r0.I$0
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.DataStoreImpl r0 = (androidx.datastore.core.DataStoreImpl) r0
            kotlin.ResultKt.b(r6)     // Catch:{ all -> 0x0030 }
            goto L_0x006a
        L_0x0030:
            r6 = move-exception
            goto L_0x0071
        L_0x0032:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x003a:
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.DataStoreImpl r2 = (androidx.datastore.core.DataStoreImpl) r2
            kotlin.ResultKt.b(r6)
            goto L_0x0055
        L_0x0042:
            kotlin.ResultKt.b(r6)
            androidx.datastore.core.InterProcessCoordinator r6 = r5.getCoordinator()
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r6.getVersion(r0)
            if (r6 != r1) goto L_0x0054
            return r1
        L_0x0054:
            r2 = r5
        L_0x0055:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            androidx.datastore.core.DataStoreImpl<T>$InitDataStore r4 = r2.readAndInit     // Catch:{ all -> 0x006d }
            r0.L$0 = r2     // Catch:{ all -> 0x006d }
            r0.I$0 = r6     // Catch:{ all -> 0x006d }
            r0.label = r3     // Catch:{ all -> 0x006d }
            java.lang.Object r6 = r4.runIfNeeded(r0)     // Catch:{ all -> 0x006d }
            if (r6 != r1) goto L_0x006a
            return r1
        L_0x006a:
            kotlin.Unit r6 = kotlin.Unit.f696a
            return r6
        L_0x006d:
            r0 = move-exception
            r1 = r6
            r6 = r0
            r0 = r2
        L_0x0071:
            androidx.datastore.core.DataStoreInMemoryCache<T> r0 = r0.inMemoryCache
            androidx.datastore.core.ReadException r2 = new androidx.datastore.core.ReadException
            r2.<init>(r6, r1)
            r0.tryUpdate(r2)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.readAndInitOrPropagateAndThrowFailure(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readDataAndUpdateCache(boolean r10, kotlin.coroutines.Continuation<? super androidx.datastore.core.State<T>> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$1 r0 = (androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$1 r0 = new androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$1
            r0.<init>(r9, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0056
            if (r2 == r5) goto L_0x0043
            if (r2 == r4) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r10 = r0.L$0
            androidx.datastore.core.DataStoreImpl r10 = (androidx.datastore.core.DataStoreImpl) r10
            kotlin.ResultKt.b(r11)
            goto L_0x00c1
        L_0x0032:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003a:
            java.lang.Object r10 = r0.L$0
            androidx.datastore.core.DataStoreImpl r10 = (androidx.datastore.core.DataStoreImpl) r10
            kotlin.ResultKt.b(r11)
            goto L_0x00a8
        L_0x0043:
            boolean r10 = r0.Z$0
            java.lang.Object r2 = r0.L$1
            androidx.datastore.core.State r2 = (androidx.datastore.core.State) r2
            java.lang.Object r5 = r0.L$0
            androidx.datastore.core.DataStoreImpl r5 = (androidx.datastore.core.DataStoreImpl) r5
            kotlin.ResultKt.b(r11)
            r8 = r11
            r11 = r10
            r10 = r5
            r5 = r2
            r2 = r8
            goto L_0x007a
        L_0x0056:
            kotlin.ResultKt.b(r11)
            androidx.datastore.core.DataStoreInMemoryCache<T> r11 = r9.inMemoryCache
            androidx.datastore.core.State r2 = r11.getCurrentState()
            boolean r11 = r2 instanceof androidx.datastore.core.UnInitialized
            if (r11 != 0) goto L_0x00db
            androidx.datastore.core.InterProcessCoordinator r11 = r9.getCoordinator()
            r0.L$0 = r9
            r0.L$1 = r2
            r0.Z$0 = r10
            r0.label = r5
            java.lang.Object r11 = r11.getVersion(r0)
            if (r11 != r1) goto L_0x0076
            return r1
        L_0x0076:
            r5 = r2
            r2 = r11
            r11 = r10
            r10 = r9
        L_0x007a:
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            boolean r6 = r5 instanceof androidx.datastore.core.Data
            if (r6 == 0) goto L_0x0089
            int r7 = r5.getVersion()
            goto L_0x008a
        L_0x0089:
            r7 = -1
        L_0x008a:
            if (r6 == 0) goto L_0x008f
            if (r2 != r7) goto L_0x008f
            return r5
        L_0x008f:
            r2 = 0
            if (r11 == 0) goto L_0x00ab
            androidx.datastore.core.InterProcessCoordinator r11 = r10.getCoordinator()
            androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$3 r3 = new androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$3
            r3.<init>(r10, r2)
            r0.L$0 = r10
            r0.L$1 = r2
            r0.label = r4
            java.lang.Object r11 = r11.lock(r3, r0)
            if (r11 != r1) goto L_0x00a8
            return r1
        L_0x00a8:
            kotlin.Pair r11 = (kotlin.Pair) r11
            goto L_0x00c3
        L_0x00ab:
            androidx.datastore.core.InterProcessCoordinator r11 = r10.getCoordinator()
            androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$4 r4 = new androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$4
            r4.<init>(r10, r7, r2)
            r0.L$0 = r10
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r11 = r11.tryLock(r4, r0)
            if (r11 != r1) goto L_0x00c1
            return r1
        L_0x00c1:
            kotlin.Pair r11 = (kotlin.Pair) r11
        L_0x00c3:
            java.lang.Object r0 = r11.component1()
            androidx.datastore.core.State r0 = (androidx.datastore.core.State) r0
            java.lang.Object r11 = r11.component2()
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x00da
            androidx.datastore.core.DataStoreInMemoryCache<T> r10 = r10.inMemoryCache
            r10.tryUpdate(r0)
        L_0x00da:
            return r0
        L_0x00db:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.readDataAndUpdateCache(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object readDataFromFileOrDefault(Continuation<? super T> continuation) {
        return StorageConnectionKt.readData(getStorageConnection$datastore_core_release(), continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0084, code lost:
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a5, code lost:
        if (r12 == null) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r2 = r12.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ac, code lost:
        r12 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ae, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00af, code lost:
        r3 = r6.getCoordinator();
        r0.L$0 = r6;
        r0.L$1 = r12;
        r0.Z$0 = r11;
        r0.I$0 = r2;
        r0.label = 2;
        r3 = r3.getVersion(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c2, code lost:
        if (r3 != r1) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c4, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c5, code lost:
        r8 = r2;
        r2 = r11;
        r11 = r8;
        r9 = r3;
        r3 = r12;
        r12 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r12 = ((java.lang.Number) r12).intValue();
        r3 = r2.getCoordinator();
        r6 = new androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2(r2, r12, (kotlin.coroutines.Continuation<? super androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2>) null);
        r0.L$0 = r2;
        r0.Z$0 = r11;
        r0.label = 4;
        r12 = r3.tryLock(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0107, code lost:
        if (r12 != r1) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0109, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0128, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0129, code lost:
        r6 = r12;
        r12 = r3;
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x012c, code lost:
        r3.element = r12;
        r12 = new kotlin.jvm.internal.Ref.IntRef();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        r3 = new androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3(r2, r7, r12, (kotlin.coroutines.Continuation<? super androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3>) null);
        r0.L$0 = r6;
        r0.L$1 = r2;
        r0.L$2 = r12;
        r0.L$3 = null;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0147, code lost:
        if (r7.doWithWriteFileLock(r11, r3, r0) == r1) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0149, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x014a, code lost:
        r11 = r12;
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x014c, code lost:
        r0 = r1.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0150, code lost:
        if (r0 != null) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0152, code lost:
        r5 = r0.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x015b, code lost:
        return new androidx.datastore.core.Data(r0, r5, r11.element);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x015c, code lost:
        r11 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x015d, code lost:
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x015e, code lost:
        kotlin.ExceptionsKt.a(r0, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0161, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        return (androidx.datastore.core.Data) r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        return new androidx.datastore.core.Data(r3, r11, ((java.lang.Number) r12).intValue());
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0128 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readDataOrHandleCorruption(boolean r11, kotlin.coroutines.Continuation<? super androidx.datastore.core.Data<T>> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$1 r0 = (androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$1 r0 = new androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$1
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            r4 = 0
            r5 = 0
            switch(r2) {
                case 0: goto L_0x0092;
                case 1: goto L_0x0087;
                case 2: goto L_0x0074;
                case 3: goto L_0x0069;
                case 4: goto L_0x005a;
                case 5: goto L_0x0040;
                case 6: goto L_0x002c;
                default: goto L_0x0024;
            }
        L_0x0024:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x002c:
            java.lang.Object r11 = r0.L$2
            kotlin.jvm.internal.Ref$IntRef r11 = (kotlin.jvm.internal.Ref.IntRef) r11
            java.lang.Object r1 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.CorruptionException r0 = (androidx.datastore.core.CorruptionException) r0
            kotlin.ResultKt.b(r12)     // Catch:{ all -> 0x003d }
            goto L_0x014c
        L_0x003d:
            r11 = move-exception
            goto L_0x015e
        L_0x0040:
            boolean r11 = r0.Z$0
            java.lang.Object r2 = r0.L$3
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r3 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            java.lang.Object r6 = r0.L$1
            androidx.datastore.core.CorruptionException r6 = (androidx.datastore.core.CorruptionException) r6
            java.lang.Object r7 = r0.L$0
            androidx.datastore.core.DataStoreImpl r7 = (androidx.datastore.core.DataStoreImpl) r7
            kotlin.ResultKt.b(r12)
            r8 = r3
            r3 = r2
            r2 = r8
            goto L_0x012c
        L_0x005a:
            boolean r11 = r0.Z$0
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.DataStoreImpl r2 = (androidx.datastore.core.DataStoreImpl) r2
            kotlin.ResultKt.b(r12)     // Catch:{ CorruptionException -> 0x0065 }
            goto L_0x010a
        L_0x0065:
            r12 = move-exception
            r7 = r2
            goto L_0x010e
        L_0x0069:
            boolean r11 = r0.Z$0
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.DataStoreImpl r2 = (androidx.datastore.core.DataStoreImpl) r2
            kotlin.ResultKt.b(r12)     // Catch:{ CorruptionException -> 0x0065 }
            goto L_0x00ed
        L_0x0074:
            int r11 = r0.I$0
            boolean r2 = r0.Z$0
            java.lang.Object r3 = r0.L$1
            java.lang.Object r6 = r0.L$0
            androidx.datastore.core.DataStoreImpl r6 = (androidx.datastore.core.DataStoreImpl) r6
            kotlin.ResultKt.b(r12)     // Catch:{ CorruptionException -> 0x0082 }
            goto L_0x00cb
        L_0x0082:
            r12 = move-exception
            r11 = r2
        L_0x0084:
            r7 = r6
            goto L_0x010e
        L_0x0087:
            boolean r11 = r0.Z$0
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.DataStoreImpl r2 = (androidx.datastore.core.DataStoreImpl) r2
            kotlin.ResultKt.b(r12)     // Catch:{ CorruptionException -> 0x0065 }
            r6 = r2
            goto L_0x00a5
        L_0x0092:
            kotlin.ResultKt.b(r12)
            if (r11 == 0) goto L_0x00da
            r0.L$0 = r10     // Catch:{ CorruptionException -> 0x00d7 }
            r0.Z$0 = r11     // Catch:{ CorruptionException -> 0x00d7 }
            r0.label = r3     // Catch:{ CorruptionException -> 0x00d7 }
            java.lang.Object r12 = r10.readDataFromFileOrDefault(r0)     // Catch:{ CorruptionException -> 0x00d7 }
            if (r12 != r1) goto L_0x00a4
            return r1
        L_0x00a4:
            r6 = r10
        L_0x00a5:
            if (r12 == 0) goto L_0x00ae
            int r2 = r12.hashCode()     // Catch:{ CorruptionException -> 0x00ac }
            goto L_0x00af
        L_0x00ac:
            r12 = move-exception
            goto L_0x0084
        L_0x00ae:
            r2 = 0
        L_0x00af:
            androidx.datastore.core.InterProcessCoordinator r3 = r6.getCoordinator()     // Catch:{ CorruptionException -> 0x00ac }
            r0.L$0 = r6     // Catch:{ CorruptionException -> 0x00ac }
            r0.L$1 = r12     // Catch:{ CorruptionException -> 0x00ac }
            r0.Z$0 = r11     // Catch:{ CorruptionException -> 0x00ac }
            r0.I$0 = r2     // Catch:{ CorruptionException -> 0x00ac }
            r7 = 2
            r0.label = r7     // Catch:{ CorruptionException -> 0x00ac }
            java.lang.Object r3 = r3.getVersion(r0)     // Catch:{ CorruptionException -> 0x00ac }
            if (r3 != r1) goto L_0x00c5
            return r1
        L_0x00c5:
            r8 = r2
            r2 = r11
            r11 = r8
            r9 = r3
            r3 = r12
            r12 = r9
        L_0x00cb:
            java.lang.Number r12 = (java.lang.Number) r12     // Catch:{ CorruptionException -> 0x0082 }
            int r12 = r12.intValue()     // Catch:{ CorruptionException -> 0x0082 }
            androidx.datastore.core.Data r7 = new androidx.datastore.core.Data     // Catch:{ CorruptionException -> 0x0082 }
            r7.<init>(r3, r11, r12)     // Catch:{ CorruptionException -> 0x0082 }
            goto L_0x010d
        L_0x00d7:
            r12 = move-exception
            r7 = r10
            goto L_0x010e
        L_0x00da:
            androidx.datastore.core.InterProcessCoordinator r12 = r10.getCoordinator()     // Catch:{ CorruptionException -> 0x00d7 }
            r0.L$0 = r10     // Catch:{ CorruptionException -> 0x00d7 }
            r0.Z$0 = r11     // Catch:{ CorruptionException -> 0x00d7 }
            r2 = 3
            r0.label = r2     // Catch:{ CorruptionException -> 0x00d7 }
            java.lang.Object r12 = r12.getVersion(r0)     // Catch:{ CorruptionException -> 0x00d7 }
            if (r12 != r1) goto L_0x00ec
            return r1
        L_0x00ec:
            r2 = r10
        L_0x00ed:
            java.lang.Number r12 = (java.lang.Number) r12     // Catch:{ CorruptionException -> 0x0065 }
            int r12 = r12.intValue()     // Catch:{ CorruptionException -> 0x0065 }
            androidx.datastore.core.InterProcessCoordinator r3 = r2.getCoordinator()     // Catch:{ CorruptionException -> 0x0065 }
            androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2 r6 = new androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2     // Catch:{ CorruptionException -> 0x0065 }
            r6.<init>(r2, r12, r4)     // Catch:{ CorruptionException -> 0x0065 }
            r0.L$0 = r2     // Catch:{ CorruptionException -> 0x0065 }
            r0.Z$0 = r11     // Catch:{ CorruptionException -> 0x0065 }
            r12 = 4
            r0.label = r12     // Catch:{ CorruptionException -> 0x0065 }
            java.lang.Object r12 = r3.tryLock(r6, r0)     // Catch:{ CorruptionException -> 0x0065 }
            if (r12 != r1) goto L_0x010a
            return r1
        L_0x010a:
            r7 = r12
            androidx.datastore.core.Data r7 = (androidx.datastore.core.Data) r7     // Catch:{ CorruptionException -> 0x0065 }
        L_0x010d:
            return r7
        L_0x010e:
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            androidx.datastore.core.CorruptionHandler<T> r3 = r7.corruptionHandler
            r0.L$0 = r7
            r0.L$1 = r12
            r0.L$2 = r2
            r0.L$3 = r2
            r0.Z$0 = r11
            r6 = 5
            r0.label = r6
            java.lang.Object r3 = r3.handleCorruption(r12, r0)
            if (r3 != r1) goto L_0x0129
            return r1
        L_0x0129:
            r6 = r12
            r12 = r3
            r3 = r2
        L_0x012c:
            r3.element = r12
            kotlin.jvm.internal.Ref$IntRef r12 = new kotlin.jvm.internal.Ref$IntRef
            r12.<init>()
            androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3 r3 = new androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3     // Catch:{ all -> 0x015c }
            r3.<init>(r2, r7, r12, r4)     // Catch:{ all -> 0x015c }
            r0.L$0 = r6     // Catch:{ all -> 0x015c }
            r0.L$1 = r2     // Catch:{ all -> 0x015c }
            r0.L$2 = r12     // Catch:{ all -> 0x015c }
            r0.L$3 = r4     // Catch:{ all -> 0x015c }
            r4 = 6
            r0.label = r4     // Catch:{ all -> 0x015c }
            java.lang.Object r11 = r7.doWithWriteFileLock(r11, r3, r0)     // Catch:{ all -> 0x015c }
            if (r11 != r1) goto L_0x014a
            return r1
        L_0x014a:
            r11 = r12
            r1 = r2
        L_0x014c:
            androidx.datastore.core.Data r12 = new androidx.datastore.core.Data
            T r0 = r1.element
            if (r0 == 0) goto L_0x0156
            int r5 = r0.hashCode()
        L_0x0156:
            int r11 = r11.element
            r12.<init>(r0, r5, r11)
            return r12
        L_0x015c:
            r11 = move-exception
            r0 = r6
        L_0x015e:
            kotlin.ExceptionsKt.a(r0, r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.readDataOrHandleCorruption(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object readState(boolean z, Continuation<? super State<T>> continuation) {
        return BuildersKt.d(new DataStoreImpl$readState$2(this, z, (Continuation<? super DataStoreImpl$readState$2>) null), this.scope.getCoroutineContext(), continuation);
    }

    /* access modifiers changed from: private */
    public final Object transformAndWrite(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        return getCoordinator().lock(new DataStoreImpl$transformAndWrite$2(this, coroutineContext, function2, (Continuation<? super DataStoreImpl$transformAndWrite$2>) null), continuation);
    }

    @NotNull
    public Flow<T> getData() {
        return this.data;
    }

    @NotNull
    public final StorageConnection<T> getStorageConnection$datastore_core_release() {
        return (StorageConnection) this.storageConnectionDelegate.getValue();
    }

    @Nullable
    public Object updateData(@NotNull Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        UpdatingDataContextElement updatingDataContextElement = (UpdatingDataContextElement) continuation.getContext().get(UpdatingDataContextElement.Companion.Key.INSTANCE);
        if (updatingDataContextElement != null) {
            updatingDataContextElement.checkNotUpdating(this);
        }
        return BuildersKt.d(new DataStoreImpl$updateData$2(this, function2, (Continuation<? super DataStoreImpl$updateData$2>) null), new UpdatingDataContextElement(updatingDataContextElement, this), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object writeData$datastore_core_release(T r12, boolean r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Integer> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof androidx.datastore.core.DataStoreImpl$writeData$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            androidx.datastore.core.DataStoreImpl$writeData$1 r0 = (androidx.datastore.core.DataStoreImpl$writeData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.DataStoreImpl$writeData$1 r0 = new androidx.datastore.core.DataStoreImpl$writeData$1
            r0.<init>(r11, r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            java.lang.Object r12 = r0.L$0
            kotlin.jvm.internal.Ref$IntRef r12 = (kotlin.jvm.internal.Ref.IntRef) r12
            kotlin.ResultKt.b(r14)
            goto L_0x0056
        L_0x002b:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0033:
            kotlin.ResultKt.b(r14)
            kotlin.jvm.internal.Ref$IntRef r14 = new kotlin.jvm.internal.Ref$IntRef
            r14.<init>()
            androidx.datastore.core.StorageConnection r2 = r11.getStorageConnection$datastore_core_release()
            androidx.datastore.core.DataStoreImpl$writeData$2 r10 = new androidx.datastore.core.DataStoreImpl$writeData$2
            r9 = 0
            r4 = r10
            r5 = r14
            r6 = r11
            r7 = r12
            r8 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            r0.L$0 = r14
            r0.label = r3
            java.lang.Object r12 = r2.writeScope(r10, r0)
            if (r12 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r12 = r14
        L_0x0056:
            int r12 = r12.element
            java.lang.Integer r13 = new java.lang.Integer
            r13.<init>(r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.writeData$datastore_core_release(java.lang.Object, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DataStoreImpl(Storage storage2, List list, CorruptionHandler corruptionHandler2, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storage2, (i & 2) != 0 ? EmptyList.INSTANCE : list, (i & 4) != 0 ? new NoOpCorruptionHandler() : corruptionHandler2, (i & 8) != 0 ? CoroutineScopeKt.a(Actual_jvmKt.ioDispatcher().plus(SupervisorKt.b())) : coroutineScope);
    }
}
