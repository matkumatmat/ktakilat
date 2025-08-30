package okio.internal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1;
import okio.FileMetadata;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aF\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH@¢\u0006\u0002\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0000\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\nH\u0000\u001a\u001c\u0010\u0013\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0016\u001a\u00020\n*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0003*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000¨\u0006\u001c"}, d2 = {"collectRecursively", "", "Lkotlin/sequences/SequenceScope;", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "stack", "Lkotlin/collections/ArrayDeque;", "path", "followSymlinks", "", "postorder", "(Lkotlin/sequences/SequenceScope;Lokio/FileSystem;Lkotlin/collections/ArrayDeque;Lokio/Path;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commonCopy", "source", "target", "commonCreateDirectories", "dir", "mustCreate", "commonDeleteRecursively", "fileOrDirectory", "mustExist", "commonExists", "commonListRecursively", "Lkotlin/sequences/Sequence;", "commonMetadata", "Lokio/FileMetadata;", "symlinkTarget", "okio"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileSystem.kt\nokio/internal/-FileSystem\n+ 2 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,155:1\n52#2,4:156\n52#2,22:160\n60#2,10:182\n56#2,3:192\n71#2,3:195\n*S KotlinDebug\n*F\n+ 1 FileSystem.kt\nokio/internal/-FileSystem\n*L\n65#1:156,4\n66#1:160,22\n65#1:182,10\n65#1:192,3\n65#1:195,3\n*E\n"})
@JvmName(name = "-FileSystem")
/* renamed from: okio.internal.-FileSystem  reason: invalid class name */
public final class FileSystem {
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d1, code lost:
        if (r0 != false) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d3, code lost:
        if (r11 != 0) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d5, code lost:
        r6.addLast(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00dc, code lost:
        r11 = r10;
        r10 = r3;
        r14 = r1;
        r1 = r0;
        r0 = r2;
        r2 = r7.iterator();
        r7 = r6;
        r6 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x011b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x011c, code lost:
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x011d, code lost:
        r7.removeLast();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0120, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ea A[Catch:{ all -> 0x005a }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0114 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object collectRecursively(@org.jetbrains.annotations.NotNull kotlin.sequences.SequenceScope<? super okio.Path> r15, @org.jetbrains.annotations.NotNull okio.FileSystem r16, @org.jetbrains.annotations.NotNull kotlin.collections.ArrayDeque<okio.Path> r17, @org.jetbrains.annotations.NotNull okio.Path r18, boolean r19, boolean r20, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            r0 = r15
            r1 = r18
            r2 = r20
            r3 = r21
            boolean r4 = r3 instanceof okio.internal.FileSystem$collectRecursively$1
            if (r4 == 0) goto L_0x001a
            r4 = r3
            okio.internal.-FileSystem$collectRecursively$1 r4 = (okio.internal.FileSystem$collectRecursively$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L_0x001a
            int r5 = r5 - r6
            r4.label = r5
            goto L_0x001f
        L_0x001a:
            okio.internal.-FileSystem$collectRecursively$1 r4 = new okio.internal.-FileSystem$collectRecursively$1
            r4.<init>(r3)
        L_0x001f:
            java.lang.Object r3 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r6 = r4.label
            r7 = 1
            r8 = 3
            r9 = 2
            if (r6 == 0) goto L_0x007a
            if (r6 == r7) goto L_0x005d
            if (r6 == r9) goto L_0x003d
            if (r6 != r8) goto L_0x0035
            kotlin.ResultKt.b(r3)
            goto L_0x013b
        L_0x0035:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003d:
            boolean r0 = r4.Z$1
            boolean r1 = r4.Z$0
            java.lang.Object r2 = r4.L$4
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r6 = r4.L$3
            okio.Path r6 = (okio.Path) r6
            java.lang.Object r7 = r4.L$2
            kotlin.collections.ArrayDeque r7 = (kotlin.collections.ArrayDeque) r7
            java.lang.Object r10 = r4.L$1
            okio.FileSystem r10 = (okio.FileSystem) r10
            java.lang.Object r11 = r4.L$0
            kotlin.sequences.SequenceScope r11 = (kotlin.sequences.SequenceScope) r11
            kotlin.ResultKt.b(r3)     // Catch:{ all -> 0x005a }
            goto L_0x00e4
        L_0x005a:
            r0 = move-exception
            goto L_0x011d
        L_0x005d:
            boolean r0 = r4.Z$1
            boolean r1 = r4.Z$0
            java.lang.Object r2 = r4.L$3
            okio.Path r2 = (okio.Path) r2
            java.lang.Object r6 = r4.L$2
            kotlin.collections.ArrayDeque r6 = (kotlin.collections.ArrayDeque) r6
            java.lang.Object r7 = r4.L$1
            okio.FileSystem r7 = (okio.FileSystem) r7
            java.lang.Object r10 = r4.L$0
            kotlin.sequences.SequenceScope r10 = (kotlin.sequences.SequenceScope) r10
            kotlin.ResultKt.b(r3)
            r3 = r7
            r14 = r2
            r2 = r0
            r0 = r1
            r1 = r14
            goto L_0x00a3
        L_0x007a:
            kotlin.ResultKt.b(r3)
            if (r2 != 0) goto L_0x009a
            r4.L$0 = r0
            r3 = r16
            r4.L$1 = r3
            r6 = r17
            r4.L$2 = r6
            r4.L$3 = r1
            r10 = r19
            r4.Z$0 = r10
            r4.Z$1 = r2
            r4.label = r7
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = r15.a(r1, r4)
            if (r7 != r5) goto L_0x00a0
            return r5
        L_0x009a:
            r3 = r16
            r6 = r17
            r10 = r19
        L_0x00a0:
            r14 = r10
            r10 = r0
            r0 = r14
        L_0x00a3:
            java.util.List r7 = r3.listOrNull(r1)
            if (r7 != 0) goto L_0x00ab
            kotlin.collections.EmptyList r7 = kotlin.collections.EmptyList.INSTANCE
        L_0x00ab:
            r11 = r7
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r11 = r11.isEmpty()
            if (r11 != 0) goto L_0x0125
            r11 = 0
            r12 = r1
        L_0x00b6:
            if (r0 == 0) goto L_0x00cb
            boolean r13 = r6.contains(r12)
            if (r13 != 0) goto L_0x00bf
            goto L_0x00cb
        L_0x00bf:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "symlink cycle at "
            java.lang.String r1 = defpackage.ba.s(r1, r2)
            r0.<init>(r1)
            throw r0
        L_0x00cb:
            okio.Path r13 = symlinkTarget(r3, r12)
            if (r13 != 0) goto L_0x0121
            if (r0 != 0) goto L_0x00d5
            if (r11 != 0) goto L_0x0125
        L_0x00d5:
            r6.addLast(r12)
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x011b }
            r11 = r10
            r10 = r3
            r14 = r1
            r1 = r0
            r0 = r2
            r2 = r7
            r7 = r6
            r6 = r14
        L_0x00e4:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x005a }
            if (r3 == 0) goto L_0x0114
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x005a }
            okio.Path r3 = (okio.Path) r3     // Catch:{ all -> 0x005a }
            r4.L$0 = r11     // Catch:{ all -> 0x005a }
            r4.L$1 = r10     // Catch:{ all -> 0x005a }
            r4.L$2 = r7     // Catch:{ all -> 0x005a }
            r4.L$3 = r6     // Catch:{ all -> 0x005a }
            r4.L$4 = r2     // Catch:{ all -> 0x005a }
            r4.Z$0 = r1     // Catch:{ all -> 0x005a }
            r4.Z$1 = r0     // Catch:{ all -> 0x005a }
            r4.label = r9     // Catch:{ all -> 0x005a }
            r15 = r11
            r16 = r10
            r17 = r7
            r18 = r3
            r19 = r1
            r20 = r0
            r21 = r4
            java.lang.Object r3 = collectRecursively(r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x005a }
            if (r3 != r5) goto L_0x00e4
            return r5
        L_0x0114:
            r7.removeLast()
            r2 = r0
            r1 = r6
            r10 = r11
            goto L_0x0125
        L_0x011b:
            r0 = move-exception
            r7 = r6
        L_0x011d:
            r7.removeLast()
            throw r0
        L_0x0121:
            int r11 = r11 + 1
            r12 = r13
            goto L_0x00b6
        L_0x0125:
            if (r2 == 0) goto L_0x013e
            r0 = 0
            r4.L$0 = r0
            r4.L$1 = r0
            r4.L$2 = r0
            r4.L$3 = r0
            r4.L$4 = r0
            r4.label = r8
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = r10.a(r1, r4)
            if (r0 != r5) goto L_0x013b
            return r5
        L_0x013b:
            kotlin.Unit r0 = kotlin.Unit.f696a
            return r0
        L_0x013e:
            kotlin.Unit r0 = kotlin.Unit.f696a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.FileSystem.collectRecursively(kotlin.sequences.SequenceScope, okio.FileSystem, kotlin.collections.ArrayDeque, okio.Path, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0040 A[Catch:{ all -> 0x002e, all -> 0x0035, all -> 0x003a }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004b A[SYNTHETIC, Splitter:B:27:0x004b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void commonCopy(@org.jetbrains.annotations.NotNull okio.FileSystem r2, @org.jetbrains.annotations.NotNull okio.Path r3, @org.jetbrains.annotations.NotNull okio.Path r4) throws java.io.IOException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "target"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            okio.Source r3 = r2.source(r3)
            okio.Sink r2 = r2.sink(r4)     // Catch:{ all -> 0x003a }
            okio.BufferedSink r2 = okio.Okio.buffer((okio.Sink) r2)     // Catch:{ all -> 0x003a }
            r4 = 0
            long r0 = r2.writeAll(r3)     // Catch:{ all -> 0x002e }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x002e }
            if (r2 == 0) goto L_0x002c
            r2.close()     // Catch:{ all -> 0x002a }
            goto L_0x002c
        L_0x002a:
            r2 = move-exception
            goto L_0x003e
        L_0x002c:
            r2 = r4
            goto L_0x003e
        L_0x002e:
            r0 = move-exception
            if (r2 == 0) goto L_0x003c
            r2.close()     // Catch:{ all -> 0x0035 }
            goto L_0x003c
        L_0x0035:
            r2 = move-exception
            kotlin.ExceptionsKt.a(r0, r2)     // Catch:{ all -> 0x003a }
            goto L_0x003c
        L_0x003a:
            r2 = move-exception
            goto L_0x004c
        L_0x003c:
            r2 = r0
            r0 = r4
        L_0x003e:
            if (r2 != 0) goto L_0x004b
            r0.longValue()     // Catch:{ all -> 0x003a }
            if (r3 == 0) goto L_0x0057
            r3.close()     // Catch:{ all -> 0x0049 }
            goto L_0x0057
        L_0x0049:
            r4 = move-exception
            goto L_0x0057
        L_0x004b:
            throw r2     // Catch:{ all -> 0x003a }
        L_0x004c:
            if (r3 == 0) goto L_0x0056
            r3.close()     // Catch:{ all -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r3 = move-exception
            kotlin.ExceptionsKt.a(r2, r3)
        L_0x0056:
            r4 = r2
        L_0x0057:
            if (r4 != 0) goto L_0x005a
            return
        L_0x005a:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.FileSystem.commonCopy(okio.FileSystem, okio.Path, okio.Path):void");
    }

    public static final void commonCreateDirectories(@NotNull okio.FileSystem fileSystem, @NotNull Path path, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "dir");
        ArrayDeque arrayDeque = new ArrayDeque();
        Path path2 = path;
        while (path2 != null && !fileSystem.exists(path2)) {
            arrayDeque.addFirst(path2);
            path2 = path2.parent();
        }
        if (!z || !arrayDeque.isEmpty()) {
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                fileSystem.createDirectory((Path) it.next());
            }
            return;
        }
        throw new IOException(path + " already exists.");
    }

    /* JADX WARNING: type inference failed for: r3v3, types: [kotlin.coroutines.jvm.internal.RestrictedSuspendLambda, kotlin.jvm.functions.Function2] */
    public static final void commonDeleteRecursively(@NotNull okio.FileSystem fileSystem, @NotNull Path path, boolean z) throws IOException {
        boolean z2;
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "fileOrDirectory");
        FileSystem$commonDeleteRecursively$sequence$1 r0 = new FileSystem$commonDeleteRecursively$sequence$1(fileSystem, path, (Continuation<? super FileSystem$commonDeleteRecursively$sequence$1>) null);
        Intrinsics.checkNotNullParameter(r0, "block");
        Iterator j = SequencesKt.j(new SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1(r0).f740a);
        while (j.hasNext()) {
            Path path2 = (Path) j.next();
            if (!z || j.hasNext()) {
                z2 = false;
            } else {
                z2 = true;
            }
            fileSystem.delete(path2, z2);
        }
    }

    public static final boolean commonExists(@NotNull okio.FileSystem fileSystem, @NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        if (fileSystem.metadataOrNull(path) != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final Sequence<Path> commonListRecursively(@NotNull okio.FileSystem fileSystem, @NotNull Path path, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "dir");
        FileSystem$commonListRecursively$1 r0 = new FileSystem$commonListRecursively$1(path, fileSystem, z, (Continuation<? super FileSystem$commonListRecursively$1>) null);
        Intrinsics.checkNotNullParameter(r0, "block");
        return new SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1(r0);
    }

    @NotNull
    public static final FileMetadata commonMetadata(@NotNull okio.FileSystem fileSystem, @NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata metadataOrNull = fileSystem.metadataOrNull(path);
        if (metadataOrNull != null) {
            return metadataOrNull;
        }
        throw new FileNotFoundException(ba.s(path, "no such file: "));
    }

    @Nullable
    public static final Path symlinkTarget(@NotNull okio.FileSystem fileSystem, @NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        Path symlinkTarget = fileSystem.metadata(path).getSymlinkTarget();
        if (symlinkTarget == null) {
            return null;
        }
        Path parent = path.parent();
        Intrinsics.c(parent);
        return parent.resolve(symlinkTarget);
    }
}
