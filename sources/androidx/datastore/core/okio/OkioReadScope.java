package androidx.datastore.core.okio;

import androidx.datastore.core.ReadScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.FileSystem;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0004J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u000e\u0010\u0015\u001a\u00028\u0000H@¢\u0006\u0002\u0010\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Landroidx/datastore/core/okio/OkioReadScope;", "T", "Landroidx/datastore/core/ReadScope;", "fileSystem", "Lokio/FileSystem;", "path", "Lokio/Path;", "serializer", "Landroidx/datastore/core/okio/OkioSerializer;", "(Lokio/FileSystem;Lokio/Path;Landroidx/datastore/core/okio/OkioSerializer;)V", "closed", "Landroidx/datastore/core/okio/AtomicBoolean;", "getFileSystem", "()Lokio/FileSystem;", "getPath", "()Lokio/Path;", "getSerializer", "()Landroidx/datastore/core/okio/OkioSerializer;", "checkClose", "", "close", "readData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core-okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOkioStorage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OkioStorage.kt\nandroidx/datastore/core/okio/OkioReadScope\n+ 2 Okio.kt\nokio/Okio__OkioKt\n+ 3 FileSystem.kt\nokio/FileSystem\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,230:1\n66#2:231\n52#2,5:233\n60#2,10:239\n57#2,2:249\n71#2,2:251\n66#2:253\n52#2,5:255\n60#2,10:261\n57#2,2:271\n71#2,2:273\n67#3:232\n68#3:238\n67#3:254\n68#3:260\n1#4:275\n*S KotlinDebug\n*F\n+ 1 OkioStorage.kt\nandroidx/datastore/core/okio/OkioReadScope\n*L\n177#1:231\n177#1:233,5\n177#1:239,10\n177#1:249,2\n177#1:251,2\n187#1:253\n187#1:255,5\n187#1:261,10\n187#1:271,2\n187#1:273,2\n177#1:232\n177#1:238\n187#1:254\n187#1:260\n*E\n"})
public class OkioReadScope<T> implements ReadScope<T> {
    @NotNull
    private final AtomicBoolean closed = new AtomicBoolean(false);
    @NotNull
    private final FileSystem fileSystem;
    @NotNull
    private final Path path;
    @NotNull
    private final OkioSerializer<T> serializer;

    public OkioReadScope(@NotNull FileSystem fileSystem2, @NotNull Path path2, @NotNull OkioSerializer<T> okioSerializer) {
        Intrinsics.checkNotNullParameter(fileSystem2, "fileSystem");
        Intrinsics.checkNotNullParameter(path2, "path");
        Intrinsics.checkNotNullParameter(okioSerializer, "serializer");
        this.fileSystem = fileSystem2;
        this.path = path2;
        this.serializer = okioSerializer;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0070 A[SYNTHETIC, Splitter:B:29:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008f A[Catch:{ FileNotFoundException -> 0x0088 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0093 A[Catch:{ FileNotFoundException -> 0x0088 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bf A[SYNTHETIC, Splitter:B:57:0x00bf] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> java.lang.Object readData$suspendImpl(androidx.datastore.core.okio.OkioReadScope<T> r7, kotlin.coroutines.Continuation<? super T> r8) {
        /*
            boolean r0 = r8 instanceof androidx.datastore.core.okio.OkioReadScope$readData$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.datastore.core.okio.OkioReadScope$readData$1 r0 = (androidx.datastore.core.okio.OkioReadScope$readData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.okio.OkioReadScope$readData$1 r0 = new androidx.datastore.core.okio.OkioReadScope$readData$1
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
            goto L_0x00bd
        L_0x0030:
            r8 = move-exception
            goto L_0x00c9
        L_0x0033:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003b:
            java.lang.Object r7 = r0.L$1
            java.io.Closeable r7 = (java.io.Closeable) r7
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.okio.OkioReadScope r2 = (androidx.datastore.core.okio.OkioReadScope) r2
            kotlin.ResultKt.b(r8)     // Catch:{ all -> 0x0047 }
            goto L_0x006e
        L_0x0047:
            r8 = move-exception
            goto L_0x007d
        L_0x0049:
            kotlin.ResultKt.b(r8)
            r7.checkClose()
            okio.FileSystem r8 = r7.fileSystem     // Catch:{ FileNotFoundException -> 0x0094 }
            okio.Path r2 = r7.path     // Catch:{ FileNotFoundException -> 0x0094 }
            okio.Source r8 = r8.source(r2)     // Catch:{ FileNotFoundException -> 0x0094 }
            okio.BufferedSource r8 = okio.Okio.buffer((okio.Source) r8)     // Catch:{ FileNotFoundException -> 0x0094 }
            androidx.datastore.core.okio.OkioSerializer<T> r2 = r7.serializer     // Catch:{ all -> 0x0078 }
            r0.L$0 = r7     // Catch:{ all -> 0x0078 }
            r0.L$1 = r8     // Catch:{ all -> 0x0078 }
            r0.label = r4     // Catch:{ all -> 0x0078 }
            java.lang.Object r2 = r2.readFrom(r8, r0)     // Catch:{ all -> 0x0078 }
            if (r2 != r1) goto L_0x006a
            return r1
        L_0x006a:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L_0x006e:
            if (r7 == 0) goto L_0x0076
            r7.close()     // Catch:{ all -> 0x0074 }
            goto L_0x0076
        L_0x0074:
            r7 = move-exception
            goto L_0x008d
        L_0x0076:
            r7 = r5
            goto L_0x008d
        L_0x0078:
            r2 = move-exception
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L_0x007d:
            if (r7 == 0) goto L_0x008b
            r7.close()     // Catch:{ all -> 0x0083 }
            goto L_0x008b
        L_0x0083:
            r7 = move-exception
            kotlin.ExceptionsKt.a(r8, r7)     // Catch:{ FileNotFoundException -> 0x0088 }
            goto L_0x008b
        L_0x0088:
            r7 = r2
            goto L_0x0095
        L_0x008b:
            r7 = r8
            r8 = r5
        L_0x008d:
            if (r7 != 0) goto L_0x0093
            kotlin.jvm.internal.Intrinsics.c(r8)     // Catch:{ FileNotFoundException -> 0x0088 }
            goto L_0x00e4
        L_0x0093:
            throw r7     // Catch:{ FileNotFoundException -> 0x0088 }
        L_0x0094:
        L_0x0095:
            okio.FileSystem r8 = r7.fileSystem
            okio.Path r2 = r7.path
            boolean r8 = r8.exists(r2)
            if (r8 == 0) goto L_0x00dd
            okio.FileSystem r8 = r7.fileSystem
            okio.Path r2 = r7.path
            okio.Source r8 = r8.source(r2)
            okio.BufferedSource r8 = okio.Okio.buffer((okio.Source) r8)
            androidx.datastore.core.okio.OkioSerializer<T> r7 = r7.serializer     // Catch:{ all -> 0x00c5 }
            r0.L$0 = r8     // Catch:{ all -> 0x00c5 }
            r0.L$1 = r5     // Catch:{ all -> 0x00c5 }
            r0.label = r3     // Catch:{ all -> 0x00c5 }
            java.lang.Object r7 = r7.readFrom(r8, r0)     // Catch:{ all -> 0x00c5 }
            if (r7 != r1) goto L_0x00ba
            return r1
        L_0x00ba:
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x00bd:
            if (r7 == 0) goto L_0x00d6
            r7.close()     // Catch:{ all -> 0x00c3 }
            goto L_0x00d6
        L_0x00c3:
            r5 = move-exception
            goto L_0x00d6
        L_0x00c5:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x00c9:
            if (r7 == 0) goto L_0x00d3
            r7.close()     // Catch:{ all -> 0x00cf }
            goto L_0x00d3
        L_0x00cf:
            r7 = move-exception
            kotlin.ExceptionsKt.a(r8, r7)
        L_0x00d3:
            r6 = r5
            r5 = r8
            r8 = r6
        L_0x00d6:
            if (r5 != 0) goto L_0x00dc
            kotlin.jvm.internal.Intrinsics.c(r8)
            goto L_0x00e4
        L_0x00dc:
            throw r5
        L_0x00dd:
            androidx.datastore.core.okio.OkioSerializer<T> r7 = r7.serializer
            java.lang.Object r7 = r7.getDefaultValue()
            r8 = r7
        L_0x00e4:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioReadScope.readData$suspendImpl(androidx.datastore.core.okio.OkioReadScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void checkClose() {
        if (this.closed.get()) {
            throw new IllegalStateException("This scope has already been closed.");
        }
    }

    public void close() {
        this.closed.set(true);
    }

    @NotNull
    public final FileSystem getFileSystem() {
        return this.fileSystem;
    }

    @NotNull
    public final Path getPath() {
        return this.path;
    }

    @NotNull
    public final OkioSerializer<T> getSerializer() {
        return this.serializer;
    }

    @Nullable
    public Object readData(@NotNull Continuation<? super T> continuation) {
        return readData$suspendImpl(this, continuation);
    }
}
