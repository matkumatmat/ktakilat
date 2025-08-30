package androidx.datastore.core.okio;

import androidx.datastore.core.WriteScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.FileSystem;
import okio.Path;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H@¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/datastore/core/okio/OkioWriteScope;", "T", "Landroidx/datastore/core/okio/OkioReadScope;", "Landroidx/datastore/core/WriteScope;", "fileSystem", "Lokio/FileSystem;", "path", "Lokio/Path;", "serializer", "Landroidx/datastore/core/okio/OkioSerializer;", "(Lokio/FileSystem;Lokio/Path;Landroidx/datastore/core/okio/OkioSerializer;)V", "writeData", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core-okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOkioStorage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OkioStorage.kt\nandroidx/datastore/core/okio/OkioWriteScope\n+ 2 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,230:1\n66#2:231\n52#2,5:232\n66#2:237\n52#2,21:238\n60#2,10:259\n57#2,2:269\n71#2,2:271\n*S KotlinDebug\n*F\n+ 1 OkioStorage.kt\nandroidx/datastore/core/okio/OkioWriteScope\n*L\n214#1:231\n214#1:232,5\n215#1:237\n215#1:238,21\n214#1:259,10\n214#1:269,2\n214#1:271,2\n*E\n"})
public final class OkioWriteScope<T> extends OkioReadScope<T> implements WriteScope<T> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OkioWriteScope(@NotNull FileSystem fileSystem, @NotNull Path path, @NotNull OkioSerializer<T> okioSerializer) {
        super(fileSystem, path, okioSerializer);
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(okioSerializer, "serializer");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: okio.FileHandle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: okio.FileHandle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: okio.FileHandle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: okio.FileHandle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: okio.FileHandle} */
    /* JADX WARNING: type inference failed for: r1v1, types: [okio.FileHandle] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0077 A[SYNTHETIC, Splitter:B:26:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0095 A[Catch:{ all -> 0x0089, all -> 0x008e }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a2 A[SYNTHETIC, Splitter:B:47:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object writeData(T r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.okio.OkioWriteScope$writeData$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.datastore.core.okio.OkioWriteScope$writeData$1 r0 = (androidx.datastore.core.okio.OkioWriteScope$writeData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.okio.OkioWriteScope$writeData$1 r0 = new androidx.datastore.core.okio.OkioWriteScope$writeData$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r9 = r0.L$2
            java.io.Closeable r9 = (java.io.Closeable) r9
            java.lang.Object r1 = r0.L$1
            okio.FileHandle r1 = (okio.FileHandle) r1
            java.lang.Object r0 = r0.L$0
            java.io.Closeable r0 = (java.io.Closeable) r0
            kotlin.ResultKt.b(r10)     // Catch:{ all -> 0x0034 }
            goto L_0x0070
        L_0x0034:
            r10 = move-exception
            goto L_0x0083
        L_0x0036:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003e:
            kotlin.ResultKt.b(r10)
            r8.checkClose()
            okio.FileSystem r10 = r8.getFileSystem()
            okio.Path r2 = r8.getPath()
            okio.FileHandle r10 = r10.openReadWrite(r2)
            r5 = 0
            okio.Sink r2 = okio.FileHandle.sink$default(r10, r5, r3, r4)     // Catch:{ all -> 0x00a3 }
            okio.BufferedSink r2 = okio.Okio.buffer((okio.Sink) r2)     // Catch:{ all -> 0x00a3 }
            androidx.datastore.core.okio.OkioSerializer r5 = r8.getSerializer()     // Catch:{ all -> 0x007f }
            r0.L$0 = r10     // Catch:{ all -> 0x007f }
            r0.L$1 = r10     // Catch:{ all -> 0x007f }
            r0.L$2 = r2     // Catch:{ all -> 0x007f }
            r0.label = r3     // Catch:{ all -> 0x007f }
            java.lang.Object r9 = r5.writeTo(r9, r2, r0)     // Catch:{ all -> 0x007f }
            if (r9 != r1) goto L_0x006d
            return r1
        L_0x006d:
            r0 = r10
            r1 = r0
            r9 = r2
        L_0x0070:
            r1.flush()     // Catch:{ all -> 0x0034 }
            kotlin.Unit r10 = kotlin.Unit.f696a     // Catch:{ all -> 0x0034 }
            if (r9 == 0) goto L_0x007d
            r9.close()     // Catch:{ all -> 0x007b }
            goto L_0x007d
        L_0x007b:
            r9 = move-exception
            goto L_0x0093
        L_0x007d:
            r9 = r4
            goto L_0x0093
        L_0x007f:
            r9 = move-exception
            r0 = r10
            r10 = r9
            r9 = r2
        L_0x0083:
            if (r9 == 0) goto L_0x0091
            r9.close()     // Catch:{ all -> 0x0089 }
            goto L_0x0091
        L_0x0089:
            r9 = move-exception
            kotlin.ExceptionsKt.a(r10, r9)     // Catch:{ all -> 0x008e }
            goto L_0x0091
        L_0x008e:
            r9 = move-exception
            r10 = r0
            goto L_0x00a4
        L_0x0091:
            r9 = r10
            r10 = r4
        L_0x0093:
            if (r9 != 0) goto L_0x00a2
            kotlin.jvm.internal.Intrinsics.c(r10)     // Catch:{ all -> 0x008e }
            kotlin.Unit r9 = kotlin.Unit.f696a     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x00b1
            r0.close()     // Catch:{ all -> 0x00a0 }
            goto L_0x00b1
        L_0x00a0:
            r4 = move-exception
            goto L_0x00b1
        L_0x00a2:
            throw r9     // Catch:{ all -> 0x008e }
        L_0x00a3:
            r9 = move-exception
        L_0x00a4:
            if (r10 == 0) goto L_0x00ae
            r10.close()     // Catch:{ all -> 0x00aa }
            goto L_0x00ae
        L_0x00aa:
            r10 = move-exception
            kotlin.ExceptionsKt.a(r9, r10)
        L_0x00ae:
            r7 = r4
            r4 = r9
            r9 = r7
        L_0x00b1:
            if (r4 != 0) goto L_0x00b9
            kotlin.jvm.internal.Intrinsics.c(r9)
            kotlin.Unit r9 = kotlin.Unit.f696a
            return r9
        L_0x00b9:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioWriteScope.writeData(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
