package kotlin.io;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", "WalkState", "DirectoryState", "FileTreeWalkIterator", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileTreeWalk implements Sequence<File> {

    /* renamed from: a  reason: collision with root package name */
    public final File f708a;
    public final FileWalkDirection b;
    public final Function1 c;
    public final Function1 d;
    public final Function2 e;
    public final int f;

    @SourceDebugExtension({"SMAP\nFileTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTreeWalk.kt\nkotlin/io/FileTreeWalk$DirectoryState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,273:1\n1#2:274\n*E\n"})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\"\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/io/FileTreeWalk$DirectoryState;", "Lkotlin/io/FileTreeWalk$WalkState;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class DirectoryState extends WalkState {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DirectoryState(File file) {
            super(file);
            Intrinsics.checkNotNullParameter(file, "rootDir");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;", "Lkotlin/collections/AbstractIterator;", "Ljava/io/File;", "BottomUpDirectoryState", "TopDownDirectoryState", "SingleFileState", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class FileTreeWalkIterator extends AbstractIterator<File> {
        public final ArrayDeque e;

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$BottomUpDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class BottomUpDirectoryState extends DirectoryState {
            public boolean b;
            public File[] c;
            public int d;
            public boolean e;
            public final /* synthetic */ FileTreeWalkIterator f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public BottomUpDirectoryState(FileTreeWalkIterator fileTreeWalkIterator, File file) {
                super(file);
                Intrinsics.checkNotNullParameter(file, "rootDir");
                this.f = fileTreeWalkIterator;
            }

            public final File a() {
                boolean z = this.e;
                FileTreeWalkIterator fileTreeWalkIterator = this.f;
                File file = this.f710a;
                if (!z && this.c == null) {
                    Function1 function1 = FileTreeWalk.this.c;
                    if (function1 != null && !((Boolean) function1.invoke(file)).booleanValue()) {
                        return null;
                    }
                    File[] listFiles = file.listFiles();
                    this.c = listFiles;
                    if (listFiles == null) {
                        Function2 function2 = FileTreeWalk.this.e;
                        if (function2 != null) {
                            function2.invoke(file, new AccessDeniedException(this.f710a, (File) null, "Cannot list files in a directory", 2, (DefaultConstructorMarker) null));
                        }
                        this.e = true;
                    }
                }
                File[] fileArr = this.c;
                if (fileArr != null && this.d < fileArr.length) {
                    Intrinsics.c(fileArr);
                    int i = this.d;
                    this.d = i + 1;
                    return fileArr[i];
                } else if (!this.b) {
                    this.b = true;
                    return file;
                } else {
                    Function1 function12 = FileTreeWalk.this.d;
                    if (function12 != null) {
                        function12.invoke(file);
                    }
                    return null;
                }
            }
        }

        @SourceDebugExtension({"SMAP\nFileTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTreeWalk.kt\nkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,273:1\n1#2:274\n*E\n"})
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState;", "Lkotlin/io/FileTreeWalk$WalkState;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class SingleFileState extends WalkState {
            public boolean b;

            public final File a() {
                if (this.b) {
                    return null;
                }
                this.b = true;
                return this.f710a;
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class TopDownDirectoryState extends DirectoryState {
            public boolean b;
            public File[] c;
            public int d;
            public final /* synthetic */ FileTreeWalkIterator e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public TopDownDirectoryState(FileTreeWalkIterator fileTreeWalkIterator, File file) {
                super(file);
                Intrinsics.checkNotNullParameter(file, "rootDir");
                this.e = fileTreeWalkIterator;
            }

            public final File a() {
                Function2 function2;
                boolean z = this.b;
                FileTreeWalkIterator fileTreeWalkIterator = this.e;
                File file = this.f710a;
                if (!z) {
                    Function1 function1 = FileTreeWalk.this.c;
                    if (function1 != null && !((Boolean) function1.invoke(file)).booleanValue()) {
                        return null;
                    }
                    this.b = true;
                    return file;
                }
                File[] fileArr = this.c;
                if (fileArr == null || this.d < fileArr.length) {
                    if (fileArr == null) {
                        File[] listFiles = file.listFiles();
                        this.c = listFiles;
                        if (listFiles == null && (function2 = FileTreeWalk.this.e) != null) {
                            function2.invoke(file, new AccessDeniedException(this.f710a, (File) null, "Cannot list files in a directory", 2, (DefaultConstructorMarker) null));
                        }
                        File[] fileArr2 = this.c;
                        if (fileArr2 == null || fileArr2.length == 0) {
                            Function1 function12 = FileTreeWalk.this.d;
                            if (function12 != null) {
                                function12.invoke(file);
                            }
                            return null;
                        }
                    }
                    File[] fileArr3 = this.c;
                    Intrinsics.c(fileArr3);
                    int i = this.d;
                    this.d = i + 1;
                    return fileArr3[i];
                }
                Function1 function13 = FileTreeWalk.this.d;
                if (function13 != null) {
                    function13.invoke(file);
                }
                return null;
            }
        }

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f709a;

            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            static {
                /*
                    kotlin.io.FileWalkDirection[] r0 = kotlin.io.FileWalkDirection.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    kotlin.io.FileWalkDirection r1 = kotlin.io.FileWalkDirection.TOP_DOWN     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    kotlin.io.FileWalkDirection r1 = kotlin.io.FileWalkDirection.BOTTOM_UP     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    f709a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FileTreeWalk.FileTreeWalkIterator.WhenMappings.<clinit>():void");
            }
        }

        public FileTreeWalkIterator() {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.e = arrayDeque;
            if (FileTreeWalk.this.f708a.isDirectory()) {
                arrayDeque.push(b(FileTreeWalk.this.f708a));
            } else if (FileTreeWalk.this.f708a.isFile()) {
                File file = FileTreeWalk.this.f708a;
                Intrinsics.checkNotNullParameter(file, "rootFile");
                arrayDeque.push(new WalkState(file));
            } else {
                this.c = 2;
            }
        }

        public final void a() {
            File file;
            File a2;
            while (true) {
                ArrayDeque arrayDeque = this.e;
                WalkState walkState = (WalkState) arrayDeque.peek();
                if (walkState == null) {
                    file = null;
                    break;
                }
                a2 = walkState.a();
                if (a2 == null) {
                    arrayDeque.pop();
                } else if (a2.equals(walkState.f710a) || !a2.isDirectory() || arrayDeque.size() >= FileTreeWalk.this.f) {
                    file = a2;
                } else {
                    arrayDeque.push(b(a2));
                }
            }
            file = a2;
            if (file != null) {
                this.d = file;
                this.c = 1;
                return;
            }
            this.c = 2;
        }

        public final DirectoryState b(File file) {
            int i = WhenMappings.f709a[FileTreeWalk.this.b.ordinal()];
            if (i == 1) {
                return new TopDownDirectoryState(this, file);
            }
            if (i == 2) {
                return new BottomUpDirectoryState(this, file);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\"\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/io/FileTreeWalk$WalkState;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class WalkState {

        /* renamed from: a  reason: collision with root package name */
        public final File f710a;

        public WalkState(File file) {
            Intrinsics.checkNotNullParameter(file, "root");
            this.f710a = file;
        }

        public abstract File a();
    }

    public FileTreeWalk(File file, FileWalkDirection fileWalkDirection, Function1 function1, Function1 function12, Function2 function2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        fileWalkDirection = (i2 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection;
        i = (i2 & 32) != 0 ? Integer.MAX_VALUE : i;
        this.f708a = file;
        this.b = fileWalkDirection;
        this.c = function1;
        this.d = function12;
        this.e = function2;
        this.f = i;
    }

    public final Iterator iterator() {
        return new FileTreeWalkIterator();
    }
}
