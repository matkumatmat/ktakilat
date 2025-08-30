package androidx.datastore.core.okio;

import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.StorageConnection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okio.FileSystem;
import okio.Path;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0016JX\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0001\u0010\u00182B\u0010\u0019\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001a¢\u0006\u0002\b\"H@¢\u0006\u0002\u0010#J=\u0010$\u001a\u00020\r2-\u0010\u0019\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0 \u0012\u0006\u0012\u0004\u0018\u00010!0%¢\u0006\u0002\b\"H@¢\u0006\u0002\u0010'R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Landroidx/datastore/core/okio/OkioStorageConnection;", "T", "Landroidx/datastore/core/StorageConnection;", "fileSystem", "Lokio/FileSystem;", "path", "Lokio/Path;", "serializer", "Landroidx/datastore/core/okio/OkioSerializer;", "coordinator", "Landroidx/datastore/core/InterProcessCoordinator;", "onClose", "Lkotlin/Function0;", "", "(Lokio/FileSystem;Lokio/Path;Landroidx/datastore/core/okio/OkioSerializer;Landroidx/datastore/core/InterProcessCoordinator;Lkotlin/jvm/functions/Function0;)V", "closed", "Landroidx/datastore/core/okio/AtomicBoolean;", "getCoordinator", "()Landroidx/datastore/core/InterProcessCoordinator;", "transactionMutex", "Lkotlinx/coroutines/sync/Mutex;", "checkNotClosed", "close", "readScope", "R", "block", "Lkotlin/Function3;", "Landroidx/datastore/core/ReadScope;", "", "Lkotlin/ParameterName;", "name", "locked", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeScope", "Lkotlin/Function2;", "Landroidx/datastore/core/WriteScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core-okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOkioStorage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OkioStorage.kt\nandroidx/datastore/core/okio/OkioStorageConnection\n+ 2 Closeable.kt\nandroidx/datastore/core/CloseableKt\n+ 3 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,230:1\n38#2,23:231\n38#2,23:262\n120#3,8:254\n129#3:285\n1#4:286\n*S KotlinDebug\n*F\n+ 1 OkioStorage.kt\nandroidx/datastore/core/okio/OkioStorageConnection\n*L\n112#1:231,23\n136#1:262,23\n129#1:254,8\n129#1:285\n*E\n"})
public final class OkioStorageConnection<T> implements StorageConnection<T> {
    @NotNull
    private final AtomicBoolean closed = new AtomicBoolean(false);
    @NotNull
    private final InterProcessCoordinator coordinator;
    @NotNull
    private final FileSystem fileSystem;
    @NotNull
    private final Function0<Unit> onClose;
    @NotNull
    private final Path path;
    @NotNull
    private final OkioSerializer<T> serializer;
    @NotNull
    private final Mutex transactionMutex = MutexKt.a();

    public OkioStorageConnection(@NotNull FileSystem fileSystem2, @NotNull Path path2, @NotNull OkioSerializer<T> okioSerializer, @NotNull InterProcessCoordinator interProcessCoordinator, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(fileSystem2, "fileSystem");
        Intrinsics.checkNotNullParameter(path2, "path");
        Intrinsics.checkNotNullParameter(okioSerializer, "serializer");
        Intrinsics.checkNotNullParameter(interProcessCoordinator, "coordinator");
        Intrinsics.checkNotNullParameter(function0, "onClose");
        this.fileSystem = fileSystem2;
        this.path = path2;
        this.serializer = okioSerializer;
        this.coordinator = interProcessCoordinator;
        this.onClose = function0;
    }

    private final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("StorageConnection has already been disposed.");
        }
    }

    public void close() {
        this.closed.set(true);
        this.onClose.invoke();
    }

    @NotNull
    public InterProcessCoordinator getCoordinator() {
        return this.coordinator;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007c, code lost:
        r11 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0088, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        kotlin.ExceptionsKt.a(r11, r1);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:31:0x007b, B:36:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007b A[SYNTHETIC, Splitter:B:31:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <R> java.lang.Object readScope(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.datastore.core.ReadScope<T>, ? super java.lang.Boolean, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super R> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.datastore.core.okio.OkioStorageConnection$readScope$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            androidx.datastore.core.okio.OkioStorageConnection$readScope$1 r0 = (androidx.datastore.core.okio.OkioStorageConnection$readScope$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.okio.OkioStorageConnection$readScope$1 r0 = new androidx.datastore.core.okio.OkioStorageConnection$readScope$1
            r0.<init>(r9, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r4) goto L_0x0034
            boolean r10 = r0.Z$0
            java.lang.Object r1 = r0.L$1
            androidx.datastore.core.Closeable r1 = (androidx.datastore.core.Closeable) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.okio.OkioStorageConnection r0 = (androidx.datastore.core.okio.OkioStorageConnection) r0
            kotlin.ResultKt.b(r11)     // Catch:{ all -> 0x0032 }
            goto L_0x006b
        L_0x0032:
            r11 = move-exception
            goto L_0x0084
        L_0x0034:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003c:
            kotlin.ResultKt.b(r11)
            r9.checkNotClosed()
            kotlinx.coroutines.sync.Mutex r11 = r9.transactionMutex
            boolean r11 = r11.a(r3)
            androidx.datastore.core.okio.OkioReadScope r2 = new androidx.datastore.core.okio.OkioReadScope     // Catch:{ all -> 0x008d }
            okio.FileSystem r5 = r9.fileSystem     // Catch:{ all -> 0x008d }
            okio.Path r6 = r9.path     // Catch:{ all -> 0x008d }
            androidx.datastore.core.okio.OkioSerializer<T> r7 = r9.serializer     // Catch:{ all -> 0x008d }
            r2.<init>(r5, r6, r7)     // Catch:{ all -> 0x008d }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r11)     // Catch:{ all -> 0x007e }
            r0.L$0 = r9     // Catch:{ all -> 0x007e }
            r0.L$1 = r2     // Catch:{ all -> 0x007e }
            r0.Z$0 = r11     // Catch:{ all -> 0x007e }
            r0.label = r4     // Catch:{ all -> 0x007e }
            java.lang.Object r10 = r10.invoke(r2, r5, r0)     // Catch:{ all -> 0x007e }
            if (r10 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r0 = r9
            r1 = r2
            r8 = r11
            r11 = r10
            r10 = r8
        L_0x006b:
            r1.close()     // Catch:{ all -> 0x0070 }
            r1 = r3
            goto L_0x0071
        L_0x0070:
            r1 = move-exception
        L_0x0071:
            if (r1 != 0) goto L_0x007b
            if (r10 == 0) goto L_0x007a
            kotlinx.coroutines.sync.Mutex r10 = r0.transactionMutex
            r10.c(r3)
        L_0x007a:
            return r11
        L_0x007b:
            throw r1     // Catch:{ all -> 0x007c }
        L_0x007c:
            r11 = move-exception
            goto L_0x0092
        L_0x007e:
            r10 = move-exception
            r0 = r9
            r1 = r2
            r8 = r11
            r11 = r10
            r10 = r8
        L_0x0084:
            r1.close()     // Catch:{ all -> 0x0088 }
            goto L_0x008c
        L_0x0088:
            r1 = move-exception
            kotlin.ExceptionsKt.a(r11, r1)     // Catch:{ all -> 0x007c }
        L_0x008c:
            throw r11     // Catch:{ all -> 0x007c }
        L_0x008d:
            r10 = move-exception
            r0 = r9
            r8 = r11
            r11 = r10
            r10 = r8
        L_0x0092:
            if (r10 == 0) goto L_0x0099
            kotlinx.coroutines.sync.Mutex r10 = r0.transactionMutex
            r10.c(r3)
        L_0x0099:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioStorageConnection.readScope(kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x010d */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00be A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cd A[SYNTHETIC, Splitter:B:39:0x00cd] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ed A[SYNTHETIC, Splitter:B:51:0x00ed] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object writeScope(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.datastore.core.WriteScope<T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.datastore.core.okio.OkioStorageConnection$writeScope$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            androidx.datastore.core.okio.OkioStorageConnection$writeScope$1 r0 = (androidx.datastore.core.okio.OkioStorageConnection$writeScope$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.okio.OkioStorageConnection$writeScope$1 r0 = new androidx.datastore.core.okio.OkioStorageConnection$writeScope$1
            r0.<init>(r9, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x005e
            if (r2 == r5) goto L_0x0048
            if (r2 != r4) goto L_0x0040
            java.lang.Object r10 = r0.L$3
            androidx.datastore.core.Closeable r10 = (androidx.datastore.core.Closeable) r10
            java.lang.Object r1 = r0.L$2
            okio.Path r1 = (okio.Path) r1
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.okio.OkioStorageConnection r0 = (androidx.datastore.core.okio.OkioStorageConnection) r0
            kotlin.ResultKt.b(r11)     // Catch:{ all -> 0x003d }
            goto L_0x00c3
        L_0x003d:
            r11 = move-exception
            goto L_0x00f4
        L_0x0040:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0048:
            java.lang.Object r10 = r0.L$3
            kotlinx.coroutines.sync.Mutex r10 = (kotlinx.coroutines.sync.Mutex) r10
            java.lang.Object r2 = r0.L$2
            okio.Path r2 = (okio.Path) r2
            java.lang.Object r5 = r0.L$1
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            java.lang.Object r7 = r0.L$0
            androidx.datastore.core.okio.OkioStorageConnection r7 = (androidx.datastore.core.okio.OkioStorageConnection) r7
            kotlin.ResultKt.b(r11)
            r11 = r10
            r10 = r5
            goto L_0x0085
        L_0x005e:
            kotlin.ResultKt.b(r11)
            r9.checkNotClosed()
            okio.Path r11 = r9.path
            okio.Path r2 = r11.parent()
            if (r2 == 0) goto L_0x0112
            okio.FileSystem r11 = r9.fileSystem
            r11.createDirectories(r2, r3)
            kotlinx.coroutines.sync.Mutex r11 = r9.transactionMutex
            r0.L$0 = r9
            r0.L$1 = r10
            r0.L$2 = r2
            r0.L$3 = r11
            r0.label = r5
            java.lang.Object r5 = r11.d(r0)
            if (r5 != r1) goto L_0x0084
            return r1
        L_0x0084:
            r7 = r9
        L_0x0085:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fd }
            r5.<init>()     // Catch:{ all -> 0x00fd }
            okio.Path r8 = r7.path     // Catch:{ all -> 0x00fd }
            java.lang.String r8 = r8.name()     // Catch:{ all -> 0x00fd }
            r5.append(r8)     // Catch:{ all -> 0x00fd }
            java.lang.String r8 = ".tmp"
            r5.append(r8)     // Catch:{ all -> 0x00fd }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00fd }
            okio.Path r2 = r2.resolve((java.lang.String) r5)     // Catch:{ all -> 0x00fd }
            okio.FileSystem r5 = r7.fileSystem     // Catch:{ IOException -> 0x00ff }
            r5.delete(r2, r3)     // Catch:{ IOException -> 0x00ff }
            androidx.datastore.core.okio.OkioWriteScope r3 = new androidx.datastore.core.okio.OkioWriteScope     // Catch:{ IOException -> 0x00ff }
            okio.FileSystem r5 = r7.fileSystem     // Catch:{ IOException -> 0x00ff }
            androidx.datastore.core.okio.OkioSerializer<T> r8 = r7.serializer     // Catch:{ IOException -> 0x00ff }
            r3.<init>(r5, r2, r8)     // Catch:{ IOException -> 0x00ff }
            r0.L$0 = r7     // Catch:{ all -> 0x00ee }
            r0.L$1 = r11     // Catch:{ all -> 0x00ee }
            r0.L$2 = r2     // Catch:{ all -> 0x00ee }
            r0.L$3 = r3     // Catch:{ all -> 0x00ee }
            r0.label = r4     // Catch:{ all -> 0x00ee }
            java.lang.Object r10 = r10.invoke(r3, r0)     // Catch:{ all -> 0x00ee }
            if (r10 != r1) goto L_0x00bf
            return r1
        L_0x00bf:
            r1 = r2
            r10 = r3
            r0 = r7
            r2 = r11
        L_0x00c3:
            kotlin.Unit r11 = kotlin.Unit.f696a     // Catch:{ all -> 0x003d }
            r10.close()     // Catch:{ all -> 0x00ca }
            r10 = r6
            goto L_0x00cb
        L_0x00ca:
            r10 = move-exception
        L_0x00cb:
            if (r10 != 0) goto L_0x00ed
            okio.FileSystem r10 = r0.fileSystem     // Catch:{ IOException -> 0x00e0 }
            boolean r10 = r10.exists(r1)     // Catch:{ IOException -> 0x00e0 }
            if (r10 == 0) goto L_0x00e5
            okio.FileSystem r10 = r0.fileSystem     // Catch:{ IOException -> 0x00e0 }
            okio.Path r11 = r0.path     // Catch:{ IOException -> 0x00e0 }
            r10.atomicMove(r1, r11)     // Catch:{ IOException -> 0x00e0 }
            goto L_0x00e5
        L_0x00dd:
            r10 = move-exception
            r11 = r2
            goto L_0x010e
        L_0x00e0:
            r10 = move-exception
            r7 = r0
            r11 = r2
            r2 = r1
            goto L_0x0100
        L_0x00e5:
            kotlin.Unit r10 = kotlin.Unit.f696a     // Catch:{ all -> 0x00dd }
            r2.c(r6)
            kotlin.Unit r10 = kotlin.Unit.f696a
            return r10
        L_0x00ed:
            throw r10     // Catch:{ IOException -> 0x00e0 }
        L_0x00ee:
            r10 = move-exception
            r1 = r2
            r0 = r7
            r2 = r11
            r11 = r10
            r10 = r3
        L_0x00f4:
            r10.close()     // Catch:{ all -> 0x00f8 }
            goto L_0x00fc
        L_0x00f8:
            r10 = move-exception
            kotlin.ExceptionsKt.a(r11, r10)     // Catch:{ IOException -> 0x00e0 }
        L_0x00fc:
            throw r11     // Catch:{ IOException -> 0x00e0 }
        L_0x00fd:
            r10 = move-exception
            goto L_0x010e
        L_0x00ff:
            r10 = move-exception
        L_0x0100:
            okio.FileSystem r0 = r7.fileSystem     // Catch:{ all -> 0x00fd }
            boolean r0 = r0.exists(r2)     // Catch:{ all -> 0x00fd }
            if (r0 == 0) goto L_0x010d
            okio.FileSystem r0 = r7.fileSystem     // Catch:{ IOException -> 0x010d }
            r0.delete(r2)     // Catch:{ IOException -> 0x010d }
        L_0x010d:
            throw r10     // Catch:{ all -> 0x00fd }
        L_0x010e:
            r11.c(r6)
            throw r10
        L_0x0112:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "must have a parent path"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioStorageConnection.writeScope(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
