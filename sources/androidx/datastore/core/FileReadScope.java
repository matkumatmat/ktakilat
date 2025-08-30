package androidx.datastore.core;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0004J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u000e\u0010\u0011\u001a\u00028\u0000H@¢\u0006\u0002\u0010\u0012R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Landroidx/datastore/core/FileReadScope;", "T", "Landroidx/datastore/core/ReadScope;", "file", "Ljava/io/File;", "serializer", "Landroidx/datastore/core/Serializer;", "(Ljava/io/File;Landroidx/datastore/core/Serializer;)V", "closed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getFile", "()Ljava/io/File;", "getSerializer", "()Landroidx/datastore/core/Serializer;", "checkNotClosed", "", "close", "readData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFileStorage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileStorage.kt\nandroidx/datastore/core/FileReadScope\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,208:1\n1#2:209\n*E\n"})
public class FileReadScope<T> implements ReadScope<T> {
    @NotNull
    private final AtomicBoolean closed = new AtomicBoolean(false);
    @NotNull
    private final File file;
    @NotNull
    private final Serializer<T> serializer;

    public FileReadScope(@NotNull File file2, @NotNull Serializer<T> serializer2) {
        Intrinsics.checkNotNullParameter(file2, "file");
        Intrinsics.checkNotNullParameter(serializer2, "serializer");
        this.file = file2;
        this.serializer = serializer2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006d, code lost:
        r7 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0076, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        kotlin.io.CloseableKt.a(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007a, code lost:
        throw r4;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:28:0x0069, B:34:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> java.lang.Object readData$suspendImpl(androidx.datastore.core.FileReadScope<T> r7, kotlin.coroutines.Continuation<? super T> r8) {
        /*
            boolean r0 = r8 instanceof androidx.datastore.core.FileReadScope$readData$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.datastore.core.FileReadScope$readData$1 r0 = (androidx.datastore.core.FileReadScope$readData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.FileReadScope$readData$1 r0 = new androidx.datastore.core.FileReadScope$readData$1
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0049
            if (r2 == r4) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r7 = r0.L$0
            java.io.Closeable r7 = (java.io.Closeable) r7
            kotlin.ResultKt.b(r8)     // Catch:{ all -> 0x0030 }
            goto L_0x009d
        L_0x0030:
            r8 = move-exception
            goto L_0x00a5
        L_0x0033:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003b:
            java.lang.Object r7 = r0.L$1
            java.io.Closeable r7 = (java.io.Closeable) r7
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.FileReadScope r2 = (androidx.datastore.core.FileReadScope) r2
            kotlin.ResultKt.b(r8)     // Catch:{ all -> 0x0047 }
            goto L_0x0069
        L_0x0047:
            r8 = move-exception
            goto L_0x0075
        L_0x0049:
            kotlin.ResultKt.b(r8)
            r7.checkNotClosed()
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x007b }
            java.io.File r2 = r7.file     // Catch:{ FileNotFoundException -> 0x007b }
            r8.<init>(r2)     // Catch:{ FileNotFoundException -> 0x007b }
            androidx.datastore.core.Serializer<T> r2 = r7.serializer     // Catch:{ all -> 0x0070 }
            r0.L$0 = r7     // Catch:{ all -> 0x0070 }
            r0.L$1 = r8     // Catch:{ all -> 0x0070 }
            r0.label = r4     // Catch:{ all -> 0x0070 }
            java.lang.Object r2 = r2.readFrom(r8, r0)     // Catch:{ all -> 0x0070 }
            if (r2 != r1) goto L_0x0065
            return r1
        L_0x0065:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L_0x0069:
            kotlin.io.CloseableKt.a(r7, r5)     // Catch:{ FileNotFoundException -> 0x006d }
            goto L_0x00b1
        L_0x006d:
            r7 = r2
            goto L_0x007c
        L_0x0070:
            r2 = move-exception
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L_0x0075:
            throw r8     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r4 = move-exception
            kotlin.io.CloseableKt.a(r7, r8)     // Catch:{ FileNotFoundException -> 0x006d }
            throw r4     // Catch:{ FileNotFoundException -> 0x006d }
        L_0x007b:
        L_0x007c:
            java.io.File r8 = r7.file
            boolean r8 = r8.exists()
            if (r8 == 0) goto L_0x00ab
            java.io.FileInputStream r8 = new java.io.FileInputStream
            java.io.File r2 = r7.file
            r8.<init>(r2)
            androidx.datastore.core.Serializer<T> r7 = r7.serializer     // Catch:{ all -> 0x00a1 }
            r0.L$0 = r8     // Catch:{ all -> 0x00a1 }
            r0.L$1 = r5     // Catch:{ all -> 0x00a1 }
            r0.label = r3     // Catch:{ all -> 0x00a1 }
            java.lang.Object r7 = r7.readFrom(r8, r0)     // Catch:{ all -> 0x00a1 }
            if (r7 != r1) goto L_0x009a
            return r1
        L_0x009a:
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x009d:
            kotlin.io.CloseableKt.a(r7, r5)
            return r8
        L_0x00a1:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x00a5:
            throw r8     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            r0 = move-exception
            kotlin.io.CloseableKt.a(r7, r8)
            throw r0
        L_0x00ab:
            androidx.datastore.core.Serializer<T> r7 = r7.serializer
            java.lang.Object r8 = r7.getDefaultValue()
        L_0x00b1:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileReadScope.readData$suspendImpl(androidx.datastore.core.FileReadScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("This scope has already been closed.");
        }
    }

    public void close() {
        this.closed.set(true);
    }

    @NotNull
    public final File getFile() {
        return this.file;
    }

    @NotNull
    public final Serializer<T> getSerializer() {
        return this.serializer;
    }

    @Nullable
    public Object readData(@NotNull Continuation<? super T> continuation) {
        return readData$suspendImpl(this, continuation);
    }
}
