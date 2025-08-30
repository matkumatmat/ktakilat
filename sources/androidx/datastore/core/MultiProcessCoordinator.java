package androidx.datastore.core;

import com.facebook.places.model.PlaceFields;
import java.io.File;
import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.apache.commons.lang3.time.DateUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 42\u00020\u0001:\u00014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\bH\u0002J\u000e\u0010\"\u001a\u00020#H@¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020#H@¢\u0006\u0002\u0010$J2\u0010&\u001a\u0002H'\"\u0004\b\u0000\u0010'2\u001c\u0010(\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0*\u0012\u0006\u0012\u0004\u0018\u00010+0)H@¢\u0006\u0002\u0010,J8\u0010-\u001a\u0002H'\"\u0004\b\u0000\u0010'2\"\u0010(\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020/\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0*\u0012\u0006\u0012\u0004\u0018\u00010+0.H@¢\u0006\u0002\u00100J:\u00101\u001a\u0002H'\"\u0004\b\u0000\u0010'2$\b\u0004\u0010(\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0*\u0012\u0006\u0012\u0004\u0018\u00010+0.HH¢\u0006\u0002\u00100J\f\u00102\u001a\u00020\u001d*\u00020\u0005H\u0002J\f\u00103\u001a\u00020\u001d*\u00020\u0005H\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0013\u0010\fR\u001b\u0010\u0016\u001a\u00020\u00118BX\u0002¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a*\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00065"}, d2 = {"Landroidx/datastore/core/MultiProcessCoordinator;", "Landroidx/datastore/core/InterProcessCoordinator;", "context", "Lkotlin/coroutines/CoroutineContext;", "file", "Ljava/io/File;", "(Lkotlin/coroutines/CoroutineContext;Ljava/io/File;)V", "LOCK_ERROR_MESSAGE", "", "LOCK_SUFFIX", "VERSION_SUFFIX", "getFile", "()Ljava/io/File;", "inMemoryMutex", "Lkotlinx/coroutines/sync/Mutex;", "lazySharedCounter", "Lkotlin/Lazy;", "Landroidx/datastore/core/SharedCounter;", "lockFile", "getLockFile", "lockFile$delegate", "Lkotlin/Lazy;", "sharedCounter", "getSharedCounter$delegate", "(Landroidx/datastore/core/MultiProcessCoordinator;)Ljava/lang/Object;", "getSharedCounter", "()Landroidx/datastore/core/SharedCounter;", "updateNotifications", "Lkotlinx/coroutines/flow/Flow;", "", "getUpdateNotifications", "()Lkotlinx/coroutines/flow/Flow;", "fileWithSuffix", "suffix", "getVersion", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementAndGetVersion", "lock", "T", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryLock", "Lkotlin/Function2;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withLazyCounter", "createIfNotExists", "createParentDirectories", "Companion", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMultiProcessCoordinator.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultiProcessCoordinator.android.kt\nandroidx/datastore/core/MultiProcessCoordinator\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 MutexUtils.kt\nandroidx/datastore/core/MutexUtilsKt\n*L\n1#1,205:1\n159#1,8:226\n159#1,8:234\n120#2,10:206\n32#3,10:216\n*S KotlinDebug\n*F\n+ 1 MultiProcessCoordinator.android.kt\nandroidx/datastore/core/MultiProcessCoordinator\n*L\n99#1:226,8\n106#1:234,8\n43#1:206,10\n60#1:216,10\n*E\n"})
public final class MultiProcessCoordinator implements InterProcessCoordinator {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final String DEADLOCK_ERROR_MESSAGE = "Resource deadlock would occur";
    /* access modifiers changed from: private */
    public static final long INITIAL_WAIT_MILLIS = 10;
    /* access modifiers changed from: private */
    public static final long MAX_WAIT_MILLIS = DateUtils.MILLIS_PER_MINUTE;
    @NotNull
    private final String LOCK_ERROR_MESSAGE = "fcntl failed: EAGAIN";
    /* access modifiers changed from: private */
    @NotNull
    public final String LOCK_SUFFIX = ".lock";
    /* access modifiers changed from: private */
    @NotNull
    public final String VERSION_SUFFIX = ".version";
    @NotNull
    private final CoroutineContext context;
    @NotNull
    private final File file;
    @NotNull
    private final Mutex inMemoryMutex = MutexKt.a();
    @NotNull
    private final Lazy<SharedCounter> lazySharedCounter = LazyKt.b(new MultiProcessCoordinator$lazySharedCounter$1(this));
    @NotNull
    private final Lazy lockFile$delegate = LazyKt.b(new MultiProcessCoordinator$lockFile$2(this));
    @NotNull
    private final Flow<Unit> updateNotifications;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH@¢\u0006\u0002\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/datastore/core/MultiProcessCoordinator$Companion;", "", "()V", "DEADLOCK_ERROR_MESSAGE", "", "INITIAL_WAIT_MILLIS", "", "MAX_WAIT_MILLIS", "getExclusiveFileLockWithRetryIfDeadlock", "Ljava/nio/channels/FileLock;", "lockFileStream", "Ljava/io/FileOutputStream;", "(Ljava/io/FileOutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0046 A[SYNTHETIC, Splitter:B:15:0x0046] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x007e  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object getExclusiveFileLockWithRetryIfDeadlock(java.io.FileOutputStream r13, kotlin.coroutines.Continuation<? super java.nio.channels.FileLock> r14) {
            /*
                r12 = this;
                boolean r0 = r14 instanceof androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1
                if (r0 == 0) goto L_0x0013
                r0 = r14
                androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 r0 = (androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 r0 = new androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1
                r0.<init>(r12, r14)
            L_0x0018:
                java.lang.Object r14 = r0.result
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L_0x0035
                if (r2 != r3) goto L_0x002d
                long r4 = r0.J$0
                java.lang.Object r13 = r0.L$0
                java.io.FileOutputStream r13 = (java.io.FileOutputStream) r13
                kotlin.ResultKt.b(r14)
                goto L_0x0078
            L_0x002d:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r14)
                throw r13
            L_0x0035:
                kotlin.ResultKt.b(r14)
                long r4 = androidx.datastore.core.MultiProcessCoordinator.INITIAL_WAIT_MILLIS
            L_0x003c:
                long r6 = androidx.datastore.core.MultiProcessCoordinator.MAX_WAIT_MILLIS
                java.lang.String r14 = "lockFileStream.getChanne…LUE, /* shared= */ false)"
                int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r2 > 0) goto L_0x007e
                java.nio.channels.FileChannel r6 = r13.getChannel()     // Catch:{ IOException -> 0x005a }
                r11 = 0
                r7 = 0
                r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                java.nio.channels.FileLock r2 = r6.lock(r7, r9, r11)     // Catch:{ IOException -> 0x005a }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r14)     // Catch:{ IOException -> 0x005a }
                return r2
            L_0x005a:
                r14 = move-exception
                java.lang.String r2 = r14.getMessage()
                if (r2 == 0) goto L_0x007d
                java.lang.String r6 = androidx.datastore.core.MultiProcessCoordinator.DEADLOCK_ERROR_MESSAGE
                boolean r2 = kotlin.text.StringsKt.n(r2, r6)
                if (r2 != r3) goto L_0x007d
                r0.L$0 = r13
                r0.J$0 = r4
                r0.label = r3
                java.lang.Object r14 = kotlinx.coroutines.DelayKt.b(r4, r0)
                if (r14 != r1) goto L_0x0078
                return r1
            L_0x0078:
                r14 = 2
                long r6 = (long) r14
                long r4 = r4 * r6
                goto L_0x003c
            L_0x007d:
                throw r14
            L_0x007e:
                java.nio.channels.FileChannel r6 = r13.getChannel()
                r11 = 0
                r7 = 0
                r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                java.nio.channels.FileLock r13 = r6.lock(r7, r9, r11)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.MultiProcessCoordinator.Companion.getExclusiveFileLockWithRetryIfDeadlock(java.io.FileOutputStream, kotlin.coroutines.Continuation):java.lang.Object");
        }

        private Companion() {
        }
    }

    public MultiProcessCoordinator(@NotNull CoroutineContext coroutineContext, @NotNull File file2) {
        Intrinsics.checkNotNullParameter(coroutineContext, PlaceFields.CONTEXT);
        Intrinsics.checkNotNullParameter(file2, "file");
        this.context = coroutineContext;
        this.file = file2;
        this.updateNotifications = MulticastFileObserver.Companion.observe(file2);
    }

    /* access modifiers changed from: private */
    public final void createIfNotExists(File file2) {
        createParentDirectories(file2);
        if (!file2.exists()) {
            file2.createNewFile();
        }
    }

    private final void createParentDirectories(File file2) {
        File parentFile = file2.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                throw new IOException("Unable to create parent directories of " + file2);
            }
        }
    }

    /* access modifiers changed from: private */
    public final File fileWithSuffix(String str) {
        return new File(this.file.getAbsolutePath() + str);
    }

    private final File getLockFile() {
        return (File) this.lockFile$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final SharedCounter getSharedCounter() {
        return (SharedCounter) this.lazySharedCounter.getValue();
    }

    private static Object getSharedCounter$delegate(MultiProcessCoordinator multiProcessCoordinator) {
        return multiProcessCoordinator.lazySharedCounter;
    }

    private final <T> Object withLazyCounter(Function2<? super SharedCounter, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        if (this.lazySharedCounter.isInitialized()) {
            return function2.invoke(getSharedCounter(), continuation);
        }
        return BuildersKt.d(new MultiProcessCoordinator$withLazyCounter$2(function2, this, (Continuation<? super MultiProcessCoordinator$withLazyCounter$2>) null), this.context, continuation);
    }

    @NotNull
    public final File getFile() {
        return this.file;
    }

    @NotNull
    public Flow<Unit> getUpdateNotifications() {
        return this.updateNotifications;
    }

    @Nullable
    public Object getVersion(@NotNull Continuation<? super Integer> continuation) {
        if (this.lazySharedCounter.isInitialized()) {
            return new Integer(getSharedCounter().getValue());
        }
        return BuildersKt.d(new MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1(this, (Continuation) null), this.context, continuation);
    }

    @Nullable
    public Object incrementAndGetVersion(@NotNull Continuation<? super Integer> continuation) {
        if (this.lazySharedCounter.isInitialized()) {
            return new Integer(getSharedCounter().incrementAndGetValue());
        }
        return BuildersKt.d(new MultiProcessCoordinator$incrementAndGetVersion$$inlined$withLazyCounter$1(this, (Continuation) null), this.context, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b9 A[SYNTHETIC, Splitter:B:43:0x00b9] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d7 A[SYNTHETIC, Splitter:B:58:0x00d7] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> java.lang.Object lock(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.MultiProcessCoordinator$lock$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.datastore.core.MultiProcessCoordinator$lock$1 r0 = (androidx.datastore.core.MultiProcessCoordinator$lock$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.MultiProcessCoordinator$lock$1 r0 = new androidx.datastore.core.MultiProcessCoordinator$lock$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x006e
            if (r2 == r5) goto L_0x005c
            if (r2 == r4) goto L_0x0046
            if (r2 != r3) goto L_0x003e
            java.lang.Object r9 = r0.L$2
            java.nio.channels.FileLock r9 = (java.nio.channels.FileLock) r9
            java.lang.Object r1 = r0.L$1
            java.io.Closeable r1 = (java.io.Closeable) r1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.b(r10)     // Catch:{ all -> 0x003b }
            goto L_0x00b7
        L_0x003b:
            r10 = move-exception
            goto L_0x00d5
        L_0x003e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0046:
            java.lang.Object r9 = r0.L$2
            java.io.Closeable r9 = (java.io.Closeable) r9
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            kotlin.ResultKt.b(r10)     // Catch:{ all -> 0x0056 }
            goto L_0x00a2
        L_0x0056:
            r10 = move-exception
            r1 = r9
            r0 = r2
        L_0x0059:
            r9 = r6
            goto L_0x00d5
        L_0x005c:
            java.lang.Object r9 = r0.L$2
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Object r5 = r0.L$0
            androidx.datastore.core.MultiProcessCoordinator r5 = (androidx.datastore.core.MultiProcessCoordinator) r5
            kotlin.ResultKt.b(r10)
            r10 = r9
            r9 = r2
            goto L_0x0083
        L_0x006e:
            kotlin.ResultKt.b(r10)
            kotlinx.coroutines.sync.Mutex r10 = r8.inMemoryMutex
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r5
            java.lang.Object r2 = r10.d(r0)
            if (r2 != r1) goto L_0x0082
            return r1
        L_0x0082:
            r5 = r8
        L_0x0083:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x00e1 }
            java.io.File r5 = r5.getLockFile()     // Catch:{ all -> 0x00e1 }
            r2.<init>(r5)     // Catch:{ all -> 0x00e1 }
            androidx.datastore.core.MultiProcessCoordinator$Companion r5 = Companion     // Catch:{ all -> 0x00d0 }
            r0.L$0 = r9     // Catch:{ all -> 0x00d0 }
            r0.L$1 = r10     // Catch:{ all -> 0x00d0 }
            r0.L$2 = r2     // Catch:{ all -> 0x00d0 }
            r0.label = r4     // Catch:{ all -> 0x00d0 }
            java.lang.Object r4 = r5.getExclusiveFileLockWithRetryIfDeadlock(r2, r0)     // Catch:{ all -> 0x00d0 }
            if (r4 != r1) goto L_0x009d
            return r1
        L_0x009d:
            r7 = r4
            r4 = r9
            r9 = r2
            r2 = r10
            r10 = r7
        L_0x00a2:
            java.nio.channels.FileLock r10 = (java.nio.channels.FileLock) r10     // Catch:{ all -> 0x0056 }
            r0.L$0 = r2     // Catch:{ all -> 0x00ca }
            r0.L$1 = r9     // Catch:{ all -> 0x00ca }
            r0.L$2 = r10     // Catch:{ all -> 0x00ca }
            r0.label = r3     // Catch:{ all -> 0x00ca }
            java.lang.Object r0 = r4.invoke(r0)     // Catch:{ all -> 0x00ca }
            if (r0 != r1) goto L_0x00b3
            return r1
        L_0x00b3:
            r1 = r9
            r9 = r10
            r10 = r0
            r0 = r2
        L_0x00b7:
            if (r9 == 0) goto L_0x00c0
            r9.release()     // Catch:{ all -> 0x00bd }
            goto L_0x00c0
        L_0x00bd:
            r9 = move-exception
            r10 = r0
            goto L_0x00db
        L_0x00c0:
            kotlin.io.CloseableKt.a(r1, r6)     // Catch:{ all -> 0x00c7 }
            r0.c(r6)
            return r10
        L_0x00c7:
            r9 = move-exception
            r10 = r0
            goto L_0x00e2
        L_0x00ca:
            r0 = move-exception
            r1 = r9
            r9 = r10
            r10 = r0
            r0 = r2
            goto L_0x00d5
        L_0x00d0:
            r9 = move-exception
            r0 = r10
            r1 = r2
            r10 = r9
            goto L_0x0059
        L_0x00d5:
            if (r9 == 0) goto L_0x00da
            r9.release()     // Catch:{ all -> 0x00bd }
        L_0x00da:
            throw r10     // Catch:{ all -> 0x00bd }
        L_0x00db:
            throw r9     // Catch:{ all -> 0x00dc }
        L_0x00dc:
            r0 = move-exception
            kotlin.io.CloseableKt.a(r1, r9)     // Catch:{ all -> 0x00e1 }
            throw r0     // Catch:{ all -> 0x00e1 }
        L_0x00e1:
            r9 = move-exception
        L_0x00e2:
            r10.c(r6)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.MultiProcessCoordinator.lock(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e0 A[SYNTHETIC, Splitter:B:60:0x00e0] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> java.lang.Object tryLock(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r19, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r20) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            r0 = r20
            boolean r3 = r0 instanceof androidx.datastore.core.MultiProcessCoordinator$tryLock$1
            if (r3 == 0) goto L_0x0019
            r3 = r0
            androidx.datastore.core.MultiProcessCoordinator$tryLock$1 r3 = (androidx.datastore.core.MultiProcessCoordinator$tryLock$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.label = r4
            goto L_0x001e
        L_0x0019:
            androidx.datastore.core.MultiProcessCoordinator$tryLock$1 r3 = new androidx.datastore.core.MultiProcessCoordinator$tryLock$1
            r3.<init>(r1, r0)
        L_0x001e:
            java.lang.Object r0 = r3.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r5 = r3.label
            r6 = 2
            r7 = 1
            r8 = 0
            if (r5 == 0) goto L_0x0058
            if (r5 == r7) goto L_0x004b
            if (r5 != r6) goto L_0x0043
            boolean r2 = r3.Z$0
            java.lang.Object r4 = r3.L$2
            java.nio.channels.FileLock r4 = (java.nio.channels.FileLock) r4
            java.lang.Object r5 = r3.L$1
            java.io.Closeable r5 = (java.io.Closeable) r5
            java.lang.Object r3 = r3.L$0
            kotlinx.coroutines.sync.Mutex r3 = (kotlinx.coroutines.sync.Mutex) r3
            kotlin.ResultKt.b(r0)     // Catch:{ all -> 0x0040 }
            goto L_0x00de
        L_0x0040:
            r0 = move-exception
            goto L_0x00f7
        L_0x0043:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x004b:
            boolean r2 = r3.Z$0
            java.lang.Object r3 = r3.L$0
            kotlinx.coroutines.sync.Mutex r3 = (kotlinx.coroutines.sync.Mutex) r3
            kotlin.ResultKt.b(r0)     // Catch:{ all -> 0x0055 }
            goto L_0x0074
        L_0x0055:
            r0 = move-exception
            goto L_0x0104
        L_0x0058:
            kotlin.ResultKt.b(r0)
            kotlinx.coroutines.sync.Mutex r5 = r1.inMemoryMutex
            boolean r9 = r5.a(r8)
            if (r9 != 0) goto L_0x007f
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x007a }
            r3.L$0 = r5     // Catch:{ all -> 0x007a }
            r3.Z$0 = r9     // Catch:{ all -> 0x007a }
            r3.label = r7     // Catch:{ all -> 0x007a }
            java.lang.Object r0 = r2.invoke(r0, r3)     // Catch:{ all -> 0x007a }
            if (r0 != r4) goto L_0x0072
            return r4
        L_0x0072:
            r3 = r5
            r2 = r9
        L_0x0074:
            if (r2 == 0) goto L_0x0079
            r3.c(r8)
        L_0x0079:
            return r0
        L_0x007a:
            r0 = move-exception
            r3 = r5
            r2 = r9
            goto L_0x0104
        L_0x007f:
            java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch:{ all -> 0x007a }
            java.io.File r0 = r18.getLockFile()     // Catch:{ all -> 0x007a }
            r10.<init>(r0)     // Catch:{ all -> 0x007a }
            r11 = 0
            java.nio.channels.FileChannel r12 = r10.getChannel()     // Catch:{ IOException -> 0x00a2 }
            r17 = 1
            r13 = 0
            r15 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.nio.channels.FileLock r0 = r12.tryLock(r13, r15, r17)     // Catch:{ IOException -> 0x00a2 }
            r12 = r0
            goto L_0x00c1
        L_0x009c:
            r0 = move-exception
            r3 = r5
            r4 = r8
            r2 = r9
            r5 = r10
            goto L_0x00f7
        L_0x00a2:
            r0 = move-exception
            java.lang.String r12 = r0.getMessage()     // Catch:{ all -> 0x009c }
            if (r12 == 0) goto L_0x00b2
            java.lang.String r13 = r1.LOCK_ERROR_MESSAGE     // Catch:{ all -> 0x009c }
            boolean r12 = kotlin.text.StringsKt.I(r12, r13, r11)     // Catch:{ all -> 0x009c }
            if (r12 != r7) goto L_0x00b2
            goto L_0x00c0
        L_0x00b2:
            java.lang.String r12 = r0.getMessage()     // Catch:{ all -> 0x009c }
            if (r12 == 0) goto L_0x00f6
            java.lang.String r13 = DEADLOCK_ERROR_MESSAGE     // Catch:{ all -> 0x009c }
            boolean r12 = kotlin.text.StringsKt.I(r12, r13, r11)     // Catch:{ all -> 0x009c }
            if (r12 != r7) goto L_0x00f6
        L_0x00c0:
            r12 = r8
        L_0x00c1:
            if (r12 == 0) goto L_0x00c4
            goto L_0x00c5
        L_0x00c4:
            r7 = 0
        L_0x00c5:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x00f0 }
            r3.L$0 = r5     // Catch:{ all -> 0x00f0 }
            r3.L$1 = r10     // Catch:{ all -> 0x00f0 }
            r3.L$2 = r12     // Catch:{ all -> 0x00f0 }
            r3.Z$0 = r9     // Catch:{ all -> 0x00f0 }
            r3.label = r6     // Catch:{ all -> 0x00f0 }
            java.lang.Object r0 = r2.invoke(r0, r3)     // Catch:{ all -> 0x00f0 }
            if (r0 != r4) goto L_0x00da
            return r4
        L_0x00da:
            r3 = r5
            r2 = r9
            r5 = r10
            r4 = r12
        L_0x00de:
            if (r4 == 0) goto L_0x00e7
            r4.release()     // Catch:{ all -> 0x00e4 }
            goto L_0x00e7
        L_0x00e4:
            r0 = move-exception
            r4 = r0
            goto L_0x00fd
        L_0x00e7:
            kotlin.io.CloseableKt.a(r5, r8)     // Catch:{ all -> 0x0055 }
            if (r2 == 0) goto L_0x00ef
            r3.c(r8)
        L_0x00ef:
            return r0
        L_0x00f0:
            r0 = move-exception
            r3 = r5
            r2 = r9
            r5 = r10
            r4 = r12
            goto L_0x00f7
        L_0x00f6:
            throw r0     // Catch:{ all -> 0x009c }
        L_0x00f7:
            if (r4 == 0) goto L_0x00fc
            r4.release()     // Catch:{ all -> 0x00e4 }
        L_0x00fc:
            throw r0     // Catch:{ all -> 0x00e4 }
        L_0x00fd:
            throw r4     // Catch:{ all -> 0x00fe }
        L_0x00fe:
            r0 = move-exception
            r6 = r0
            kotlin.io.CloseableKt.a(r5, r4)     // Catch:{ all -> 0x0055 }
            throw r6     // Catch:{ all -> 0x0055 }
        L_0x0104:
            if (r2 == 0) goto L_0x0109
            r3.c(r8)
        L_0x0109:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.MultiProcessCoordinator.tryLock(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
