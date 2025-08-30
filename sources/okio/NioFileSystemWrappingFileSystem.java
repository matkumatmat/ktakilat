package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00172\u0006\u0010\u0012\u001a\u00020\bH\u0016J \u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0018\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\"H\u0016J\f\u0010#\u001a\u00020$*\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lokio/NioFileSystemWrappingFileSystem;", "Lokio/NioSystemFileSystem;", "nioFileSystem", "Ljava/nio/file/FileSystem;", "(Ljava/nio/file/FileSystem;)V", "appendingSink", "Lokio/Sink;", "file", "Lokio/Path;", "mustExist", "", "atomicMove", "", "source", "target", "canonicalize", "path", "createDirectory", "dir", "mustCreate", "createSymlink", "delete", "list", "", "throwOnFailure", "listOrNull", "metadataOrNull", "Lokio/FileMetadata;", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "sink", "Lokio/Source;", "toString", "", "resolve", "Ljava/nio/file/Path;", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nNioFileSystemWrappingFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NioFileSystemWrappingFileSystem.kt\nokio/NioFileSystemWrappingFileSystem\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,192:1\n1620#2,3:193\n1#3:196\n37#4,2:197\n37#4,2:199\n37#4,2:201\n*S KotlinDebug\n*F\n+ 1 NioFileSystemWrappingFileSystem.kt\nokio/NioFileSystemWrappingFileSystem\n*L\n77#1:193,3\n104#1:197,2\n125#1:199,2\n138#1:201,2\n*E\n"})
public final class NioFileSystemWrappingFileSystem extends NioSystemFileSystem {
    @NotNull
    private final FileSystem nioFileSystem;

    public NioFileSystemWrappingFileSystem(@NotNull FileSystem fileSystem) {
        Intrinsics.checkNotNullParameter(fileSystem, "nioFileSystem");
        this.nioFileSystem = fileSystem;
    }

    private final Path resolve(Path path) {
        Path p = this.nioFileSystem.getPath(path.toString(), new String[0]);
        Intrinsics.checkNotNullExpressionValue(p, "getPath(...)");
        return p;
    }

    @NotNull
    public Sink appendingSink(@NotNull Path path, boolean z) {
        Intrinsics.checkNotNullParameter(path, "file");
        ListBuilder listBuilder = new ListBuilder(0, 1, (DefaultConstructorMarker) null);
        listBuilder.add(StandardOpenOption.APPEND);
        if (!z) {
            listBuilder.add(StandardOpenOption.CREATE);
        }
        Intrinsics.checkNotNullParameter(listBuilder, "builder");
        List build = listBuilder.build();
        Path resolve = resolve(path);
        StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) build.toArray(new StandardOpenOption[0]);
        OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
        OutputStream newOutputStream = Files.newOutputStream(resolve, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(newOutputStream, "newOutputStream(...)");
        return Okio.sink(newOutputStream);
    }

    public void atomicMove(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, TypedValues.AttributesType.S_TARGET);
        try {
            Intrinsics.checkNotNullExpressionValue(Files.move(resolve(path), resolve(path2), (CopyOption[]) Arrays.copyOf(new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING}, 2)), "move(...)");
        } catch (NoSuchFileException e) {
            throw new FileNotFoundException(e.getMessage());
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        }
    }

    @NotNull
    public Path canonicalize(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            Path.Companion companion = Path.Companion;
            java.nio.file.Path realPath = resolve(path).toRealPath(new LinkOption[0]);
            Intrinsics.checkNotNullExpressionValue(realPath, "toRealPath(...)");
            return Path.Companion.get$default(companion, realPath, false, 1, (Object) null);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(ba.s(path, "no such file: "));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0011, code lost:
        if (r0.isDirectory() == true) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void createDirectory(@org.jetbrains.annotations.NotNull okio.Path r4, boolean r5) {
        /*
            r3 = this;
            java.lang.String r0 = "dir"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            okio.FileMetadata r0 = r3.metadataOrNull(r4)
            r1 = 0
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.isDirectory()
            r2 = 1
            if (r0 != r2) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            if (r2 == 0) goto L_0x0031
            if (r5 != 0) goto L_0x001a
            goto L_0x0031
        L_0x001a:
            java.io.IOException r5 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            java.lang.String r4 = " already exists."
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r5.<init>(r4)
            throw r5
        L_0x0031:
            java.nio.file.Path r5 = r3.resolve(r4)     // Catch:{ IOException -> 0x0047 }
            java.nio.file.attribute.FileAttribute[] r0 = new java.nio.file.attribute.FileAttribute[r1]     // Catch:{ IOException -> 0x0047 }
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)     // Catch:{ IOException -> 0x0047 }
            java.nio.file.attribute.FileAttribute[] r0 = (java.nio.file.attribute.FileAttribute[]) r0     // Catch:{ IOException -> 0x0047 }
            java.nio.file.Path r5 = java.nio.file.Files.createDirectory(r5, r0)     // Catch:{ IOException -> 0x0047 }
            java.lang.String r0 = "createDirectory(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)     // Catch:{ IOException -> 0x0047 }
            return
        L_0x0047:
            r5 = move-exception
            if (r2 == 0) goto L_0x004b
            return
        L_0x004b:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "failed to create directory: "
            java.lang.String r4 = defpackage.ba.s(r4, r1)
            r0.<init>(r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.NioFileSystemWrappingFileSystem.createDirectory(okio.Path, boolean):void");
    }

    public void createSymlink(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullExpressionValue(Files.createSymbolicLink(resolve(path), resolve(path2), (FileAttribute[]) Arrays.copyOf(new FileAttribute[0], 0)), "createSymbolicLink(...)");
    }

    public void delete(@NotNull Path path, boolean z) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (!Thread.interrupted()) {
            java.nio.file.Path resolve = resolve(path);
            try {
                Files.delete(resolve);
            } catch (NoSuchFileException unused) {
                if (z) {
                    throw new FileNotFoundException(ba.s(path, "no such file: "));
                }
            } catch (IOException unused2) {
                if (Files.exists(resolve, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                    throw new IOException(ba.s(path, "failed to delete "));
                }
            }
        } else {
            throw new InterruptedIOException("interrupted");
        }
    }

    @NotNull
    public List<Path> list(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "dir");
        List<Path> list = list(path, true);
        Intrinsics.c(list);
        return list;
    }

    @Nullable
    public List<Path> listOrNull(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "dir");
        return list(path, false);
    }

    @Nullable
    public FileMetadata metadataOrNull(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return metadataOrNull(resolve(path));
    }

    @NotNull
    public FileHandle openReadOnly(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "file");
        try {
            FileChannel open = FileChannel.open(resolve(path), new OpenOption[]{StandardOpenOption.READ});
            Intrinsics.c(open);
            return new NioFileSystemFileHandle(false, open);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(ba.s(path, "no such file: "));
        }
    }

    @NotNull
    public FileHandle openReadWrite(@NotNull Path path, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(path, "file");
        if (!z || !z2) {
            ListBuilder listBuilder = new ListBuilder(0, 1, (DefaultConstructorMarker) null);
            listBuilder.add(StandardOpenOption.READ);
            listBuilder.add(StandardOpenOption.WRITE);
            if (z) {
                listBuilder.add(StandardOpenOption.CREATE_NEW);
            } else if (!z2) {
                listBuilder.add(StandardOpenOption.CREATE);
            }
            Intrinsics.checkNotNullParameter(listBuilder, "builder");
            List build = listBuilder.build();
            try {
                java.nio.file.Path resolve = resolve(path);
                StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) build.toArray(new StandardOpenOption[0]);
                FileChannel open = FileChannel.open(resolve, (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length));
                Intrinsics.c(open);
                return new NioFileSystemFileHandle(true, open);
            } catch (NoSuchFileException unused) {
                throw new FileNotFoundException(ba.s(path, "no such file: "));
            }
        } else {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
        }
    }

    @NotNull
    public Sink sink(@NotNull Path path, boolean z) {
        Intrinsics.checkNotNullParameter(path, "file");
        ListBuilder listBuilder = new ListBuilder(0, 1, (DefaultConstructorMarker) null);
        if (z) {
            listBuilder.add(StandardOpenOption.CREATE_NEW);
        }
        Intrinsics.checkNotNullParameter(listBuilder, "builder");
        List build = listBuilder.build();
        try {
            java.nio.file.Path resolve = resolve(path);
            StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) build.toArray(new StandardOpenOption[0]);
            OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
            OutputStream newOutputStream = Files.newOutputStream(resolve, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
            Intrinsics.checkNotNullExpressionValue(newOutputStream, "newOutputStream(...)");
            return Okio.sink(newOutputStream);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(ba.s(path, "no such file: "));
        }
    }

    @NotNull
    public Source source(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "file");
        try {
            InputStream newInputStream = Files.newInputStream(resolve(path), (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0));
            Intrinsics.checkNotNullExpressionValue(newInputStream, "newInputStream(...)");
            return Okio.source(newInputStream);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(ba.s(path, "no such file: "));
        }
    }

    @NotNull
    public String toString() {
        String f = Reflection.a(this.nioFileSystem.getClass()).f();
        Intrinsics.c(f);
        return f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        kotlin.io.CloseableKt.a(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<okio.Path> list(okio.Path r7, boolean r8) {
        /*
            r6 = this;
            java.nio.file.Path r0 = r6.resolve(r7)
            r1 = 0
            r2 = 0
            java.lang.String r3 = "*"
            java.lang.String r4 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r4)     // Catch:{ Exception -> 0x004d }
            java.lang.String r4 = "glob"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)     // Catch:{ Exception -> 0x004d }
            java.nio.file.DirectoryStream r3 = java.nio.file.Files.newDirectoryStream(r0, r3)     // Catch:{ Exception -> 0x004d }
            kotlin.jvm.internal.Intrinsics.c(r3)     // Catch:{ all -> 0x0046 }
            java.util.List r4 = kotlin.collections.CollectionsKt.D(r3)     // Catch:{ all -> 0x0046 }
            kotlin.io.CloseableKt.a(r3, r2)     // Catch:{ Exception -> 0x004d }
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Iterator r8 = r4.iterator()
        L_0x002b:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x0042
            java.lang.Object r0 = r8.next()
            java.nio.file.Path r0 = (java.nio.file.Path) r0
            okio.Path$Companion r3 = okio.Path.Companion
            r4 = 1
            okio.Path r0 = okio.Path.Companion.get$default((okio.Path.Companion) r3, (java.nio.file.Path) r0, (boolean) r1, (int) r4, (java.lang.Object) r2)
            r7.add(r0)
            goto L_0x002b
        L_0x0042:
            kotlin.collections.CollectionsKt.y(r7)
            return r7
        L_0x0046:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0048 }
        L_0x0048:
            r5 = move-exception
            kotlin.io.CloseableKt.a(r3, r4)     // Catch:{ Exception -> 0x004d }
            throw r5     // Catch:{ Exception -> 0x004d }
        L_0x004d:
            if (r8 == 0) goto L_0x0076
            java.nio.file.LinkOption[] r8 = new java.nio.file.LinkOption[r1]
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r1)
            java.nio.file.LinkOption[] r8 = (java.nio.file.LinkOption[]) r8
            boolean r8 = java.nio.file.Files.exists(r0, r8)
            if (r8 != 0) goto L_0x006a
            java.io.FileNotFoundException r8 = new java.io.FileNotFoundException
            java.lang.String r0 = "no such file: "
            java.lang.String r7 = defpackage.ba.s(r7, r0)
            r8.<init>(r7)
            throw r8
        L_0x006a:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r0 = "failed to list "
            java.lang.String r7 = defpackage.ba.s(r7, r0)
            r8.<init>(r7)
            throw r8
        L_0x0076:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.NioFileSystemWrappingFileSystem.list(okio.Path, boolean):java.util.List");
    }
}
