package androidx.datastore.core;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0016JX\u0010\u0015\u001a\u0002H\u0016\"\u0004\b\u0001\u0010\u00162B\u0010\u0017\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0018¢\u0006\u0002\b H@¢\u0006\u0002\u0010!J=\u0010\"\u001a\u00020\u000b2-\u0010\u0017\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001f0#¢\u0006\u0002\b H@¢\u0006\u0002\u0010%J\f\u0010&\u001a\u00020\u000b*\u00020\u0004H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/datastore/core/FileStorageConnection;", "T", "Landroidx/datastore/core/StorageConnection;", "file", "Ljava/io/File;", "serializer", "Landroidx/datastore/core/Serializer;", "coordinator", "Landroidx/datastore/core/InterProcessCoordinator;", "onClose", "Lkotlin/Function0;", "", "(Ljava/io/File;Landroidx/datastore/core/Serializer;Landroidx/datastore/core/InterProcessCoordinator;Lkotlin/jvm/functions/Function0;)V", "closed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getCoordinator", "()Landroidx/datastore/core/InterProcessCoordinator;", "transactionMutex", "Lkotlinx/coroutines/sync/Mutex;", "checkNotClosed", "close", "readScope", "R", "block", "Lkotlin/Function3;", "Landroidx/datastore/core/ReadScope;", "", "Lkotlin/ParameterName;", "name", "locked", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeScope", "Lkotlin/Function2;", "Landroidx/datastore/core/WriteScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createParentDirectories", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFileStorage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileStorage.kt\nandroidx/datastore/core/FileStorageConnection\n+ 2 Closeable.kt\nandroidx/datastore/core/CloseableKt\n+ 3 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,208:1\n38#2,23:209\n38#2,23:240\n120#3,8:232\n129#3:263\n1#4:264\n*S KotlinDebug\n*F\n+ 1 FileStorage.kt\nandroidx/datastore/core/FileStorageConnection\n*L\n100#1:209,23\n117#1:240,23\n114#1:232,8\n114#1:263\n*E\n"})
public final class FileStorageConnection<T> implements StorageConnection<T> {
    @NotNull
    private final AtomicBoolean closed = new AtomicBoolean(false);
    @NotNull
    private final InterProcessCoordinator coordinator;
    @NotNull
    private final File file;
    @NotNull
    private final Function0<Unit> onClose;
    @NotNull
    private final Serializer<T> serializer;
    @NotNull
    private final Mutex transactionMutex = MutexKt.a();

    public FileStorageConnection(@NotNull File file2, @NotNull Serializer<T> serializer2, @NotNull InterProcessCoordinator interProcessCoordinator, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(file2, "file");
        Intrinsics.checkNotNullParameter(serializer2, "serializer");
        Intrinsics.checkNotNullParameter(interProcessCoordinator, "coordinator");
        Intrinsics.checkNotNullParameter(function0, "onClose");
        this.file = file2;
        this.serializer = serializer2;
        this.coordinator = interProcessCoordinator;
        this.onClose = function0;
    }

    private final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("StorageConnection has already been disposed.");
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

    public void close() {
        this.closed.set(true);
        this.onClose.invoke();
    }

    @NotNull
    public InterProcessCoordinator getCoordinator() {
        return this.coordinator;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007a, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0086, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        kotlin.ExceptionsKt.a(r10, r1);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:31:0x0079, B:36:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0079 A[SYNTHETIC, Splitter:B:31:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <R> java.lang.Object readScope(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.datastore.core.ReadScope<T>, ? super java.lang.Boolean, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super R> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.FileStorageConnection$readScope$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.datastore.core.FileStorageConnection$readScope$1 r0 = (androidx.datastore.core.FileStorageConnection$readScope$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.FileStorageConnection$readScope$1 r0 = new androidx.datastore.core.FileStorageConnection$readScope$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r4) goto L_0x0034
            boolean r9 = r0.Z$0
            java.lang.Object r1 = r0.L$1
            androidx.datastore.core.Closeable r1 = (androidx.datastore.core.Closeable) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.FileStorageConnection r0 = (androidx.datastore.core.FileStorageConnection) r0
            kotlin.ResultKt.b(r10)     // Catch:{ all -> 0x0032 }
            goto L_0x0069
        L_0x0032:
            r10 = move-exception
            goto L_0x0082
        L_0x0034:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003c:
            kotlin.ResultKt.b(r10)
            r8.checkNotClosed()
            kotlinx.coroutines.sync.Mutex r10 = r8.transactionMutex
            boolean r10 = r10.a(r3)
            androidx.datastore.core.FileReadScope r2 = new androidx.datastore.core.FileReadScope     // Catch:{ all -> 0x008b }
            java.io.File r5 = r8.file     // Catch:{ all -> 0x008b }
            androidx.datastore.core.Serializer<T> r6 = r8.serializer     // Catch:{ all -> 0x008b }
            r2.<init>(r5, r6)     // Catch:{ all -> 0x008b }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r10)     // Catch:{ all -> 0x007c }
            r0.L$0 = r8     // Catch:{ all -> 0x007c }
            r0.L$1 = r2     // Catch:{ all -> 0x007c }
            r0.Z$0 = r10     // Catch:{ all -> 0x007c }
            r0.label = r4     // Catch:{ all -> 0x007c }
            java.lang.Object r9 = r9.invoke(r2, r5, r0)     // Catch:{ all -> 0x007c }
            if (r9 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r0 = r8
            r1 = r2
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0069:
            r1.close()     // Catch:{ all -> 0x006e }
            r1 = r3
            goto L_0x006f
        L_0x006e:
            r1 = move-exception
        L_0x006f:
            if (r1 != 0) goto L_0x0079
            if (r9 == 0) goto L_0x0078
            kotlinx.coroutines.sync.Mutex r9 = r0.transactionMutex
            r9.c(r3)
        L_0x0078:
            return r10
        L_0x0079:
            throw r1     // Catch:{ all -> 0x007a }
        L_0x007a:
            r10 = move-exception
            goto L_0x0090
        L_0x007c:
            r9 = move-exception
            r0 = r8
            r1 = r2
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0082:
            r1.close()     // Catch:{ all -> 0x0086 }
            goto L_0x008a
        L_0x0086:
            r1 = move-exception
            kotlin.ExceptionsKt.a(r10, r1)     // Catch:{ all -> 0x007a }
        L_0x008a:
            throw r10     // Catch:{ all -> 0x007a }
        L_0x008b:
            r9 = move-exception
            r0 = r8
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0090:
            if (r9 == 0) goto L_0x0097
            kotlinx.coroutines.sync.Mutex r9 = r0.transactionMutex
            r9.c(r3)
        L_0x0097:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileStorageConnection.readScope(kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ad A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bb A[SYNTHETIC, Splitter:B:37:0x00bb] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f8 A[SYNTHETIC, Splitter:B:52:0x00f8] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object writeScope(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.datastore.core.WriteScope<T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            java.lang.String r0 = "Unable to rename "
            boolean r1 = r12 instanceof androidx.datastore.core.FileStorageConnection$writeScope$1
            if (r1 == 0) goto L_0x0015
            r1 = r12
            androidx.datastore.core.FileStorageConnection$writeScope$1 r1 = (androidx.datastore.core.FileStorageConnection$writeScope$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x001a
        L_0x0015:
            androidx.datastore.core.FileStorageConnection$writeScope$1 r1 = new androidx.datastore.core.FileStorageConnection$writeScope$1
            r1.<init>(r10, r12)
        L_0x001a:
            java.lang.Object r12 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r3 = r1.label
            r4 = 2
            r5 = 1
            r6 = 0
            if (r3 == 0) goto L_0x005c
            if (r3 == r5) goto L_0x0049
            if (r3 != r4) goto L_0x0041
            java.lang.Object r11 = r1.L$3
            androidx.datastore.core.Closeable r11 = (androidx.datastore.core.Closeable) r11
            java.lang.Object r2 = r1.L$2
            java.io.File r2 = (java.io.File) r2
            java.lang.Object r3 = r1.L$1
            kotlinx.coroutines.sync.Mutex r3 = (kotlinx.coroutines.sync.Mutex) r3
            java.lang.Object r1 = r1.L$0
            androidx.datastore.core.FileStorageConnection r1 = (androidx.datastore.core.FileStorageConnection) r1
            kotlin.ResultKt.b(r12)     // Catch:{ all -> 0x003e }
            goto L_0x00b1
        L_0x003e:
            r12 = move-exception
            goto L_0x00fd
        L_0x0041:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0049:
            java.lang.Object r11 = r1.L$2
            kotlinx.coroutines.sync.Mutex r11 = (kotlinx.coroutines.sync.Mutex) r11
            java.lang.Object r3 = r1.L$1
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            java.lang.Object r5 = r1.L$0
            androidx.datastore.core.FileStorageConnection r5 = (androidx.datastore.core.FileStorageConnection) r5
            kotlin.ResultKt.b(r12)
            r9 = r3
            r3 = r11
            r11 = r9
            goto L_0x007a
        L_0x005c:
            kotlin.ResultKt.b(r12)
            r10.checkNotClosed()
            java.io.File r12 = r10.file
            r10.createParentDirectories(r12)
            kotlinx.coroutines.sync.Mutex r12 = r10.transactionMutex
            r1.L$0 = r10
            r1.L$1 = r11
            r1.L$2 = r12
            r1.label = r5
            java.lang.Object r3 = r12.d(r1)
            if (r3 != r2) goto L_0x0078
            return r2
        L_0x0078:
            r5 = r10
            r3 = r12
        L_0x007a:
            java.io.File r12 = new java.io.File     // Catch:{ all -> 0x00eb }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00eb }
            r7.<init>()     // Catch:{ all -> 0x00eb }
            java.io.File r8 = r5.file     // Catch:{ all -> 0x00eb }
            java.lang.String r8 = r8.getAbsolutePath()     // Catch:{ all -> 0x00eb }
            r7.append(r8)     // Catch:{ all -> 0x00eb }
            java.lang.String r8 = ".tmp"
            r7.append(r8)     // Catch:{ all -> 0x00eb }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00eb }
            r12.<init>(r7)     // Catch:{ all -> 0x00eb }
            androidx.datastore.core.FileWriteScope r7 = new androidx.datastore.core.FileWriteScope     // Catch:{ IOException -> 0x0106 }
            androidx.datastore.core.Serializer<T> r8 = r5.serializer     // Catch:{ IOException -> 0x0106 }
            r7.<init>(r12, r8)     // Catch:{ IOException -> 0x0106 }
            r1.L$0 = r5     // Catch:{ all -> 0x00f9 }
            r1.L$1 = r3     // Catch:{ all -> 0x00f9 }
            r1.L$2 = r12     // Catch:{ all -> 0x00f9 }
            r1.L$3 = r7     // Catch:{ all -> 0x00f9 }
            r1.label = r4     // Catch:{ all -> 0x00f9 }
            java.lang.Object r11 = r11.invoke(r7, r1)     // Catch:{ all -> 0x00f9 }
            if (r11 != r2) goto L_0x00ae
            return r2
        L_0x00ae:
            r2 = r12
            r1 = r5
            r11 = r7
        L_0x00b1:
            kotlin.Unit r12 = kotlin.Unit.f696a     // Catch:{ all -> 0x003e }
            r11.close()     // Catch:{ all -> 0x00b8 }
            r11 = r6
            goto L_0x00b9
        L_0x00b8:
            r11 = move-exception
        L_0x00b9:
            if (r11 != 0) goto L_0x00f8
            boolean r11 = r2.exists()     // Catch:{ IOException -> 0x00ed }
            if (r11 == 0) goto L_0x00f0
            java.io.File r11 = r1.file     // Catch:{ IOException -> 0x00ed }
            boolean r11 = androidx.datastore.core.FileMoves_androidKt.atomicMoveTo(r2, r11)     // Catch:{ IOException -> 0x00ed }
            if (r11 == 0) goto L_0x00ca
            goto L_0x00f0
        L_0x00ca:
            java.io.IOException r11 = new java.io.IOException     // Catch:{ IOException -> 0x00ed }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ed }
            r12.<init>(r0)     // Catch:{ IOException -> 0x00ed }
            r12.append(r2)     // Catch:{ IOException -> 0x00ed }
            java.lang.String r0 = " to "
            r12.append(r0)     // Catch:{ IOException -> 0x00ed }
            java.io.File r0 = r1.file     // Catch:{ IOException -> 0x00ed }
            r12.append(r0)     // Catch:{ IOException -> 0x00ed }
            java.lang.String r0 = ". This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file."
            r12.append(r0)     // Catch:{ IOException -> 0x00ed }
            java.lang.String r12 = r12.toString()     // Catch:{ IOException -> 0x00ed }
            r11.<init>(r12)     // Catch:{ IOException -> 0x00ed }
            throw r11     // Catch:{ IOException -> 0x00ed }
        L_0x00eb:
            r11 = move-exception
            goto L_0x0111
        L_0x00ed:
            r11 = move-exception
            r12 = r2
            goto L_0x0107
        L_0x00f0:
            kotlin.Unit r11 = kotlin.Unit.f696a     // Catch:{ all -> 0x00eb }
            r3.c(r6)
            kotlin.Unit r11 = kotlin.Unit.f696a
            return r11
        L_0x00f8:
            throw r11     // Catch:{ IOException -> 0x00ed }
        L_0x00f9:
            r11 = move-exception
            r2 = r12
            r12 = r11
            r11 = r7
        L_0x00fd:
            r11.close()     // Catch:{ all -> 0x0101 }
            goto L_0x0105
        L_0x0101:
            r11 = move-exception
            kotlin.ExceptionsKt.a(r12, r11)     // Catch:{ IOException -> 0x00ed }
        L_0x0105:
            throw r12     // Catch:{ IOException -> 0x00ed }
        L_0x0106:
            r11 = move-exception
        L_0x0107:
            boolean r0 = r12.exists()     // Catch:{ all -> 0x00eb }
            if (r0 == 0) goto L_0x0110
            r12.delete()     // Catch:{ all -> 0x00eb }
        L_0x0110:
            throw r11     // Catch:{ all -> 0x00eb }
        L_0x0111:
            r3.c(r6)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileStorageConnection.writeScope(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
