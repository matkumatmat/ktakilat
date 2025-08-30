package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.io.FileTreeWalk;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"kotlin/io/FilesKt__FilePathComponentsKt", "kotlin/io/FilesKt__FileReadWriteKt", "kotlin/io/FilesKt__FileTreeWalkKt", "kotlin/io/FilesKt__UtilsKt"}, k = 4, mv = {2, 1, 0}, xi = 49)
public final class FilesKt extends FilesKt__UtilsKt {
    public static boolean b(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(file, "<this>");
        FileWalkDirection fileWalkDirection = FileWalkDirection.BOTTOM_UP;
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(fileWalkDirection, "direction");
        Intrinsics.checkNotNullParameter(file, "start");
        Intrinsics.checkNotNullParameter(fileWalkDirection, "direction");
        FileTreeWalk.FileTreeWalkIterator fileTreeWalkIterator = new FileTreeWalk.FileTreeWalkIterator();
        while (true) {
            boolean z = true;
            while (true) {
                if (!fileTreeWalkIterator.hasNext()) {
                    return z;
                }
                File file2 = (File) fileTreeWalkIterator.next();
                if (file2.delete() || !file2.exists()) {
                    if (z) {
                    }
                }
                z = false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0049, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
        kotlin.io.CloseableKt.a(r2, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(java.io.File r4) {
        /*
            java.nio.charset.Charset r0 = kotlin.text.Charsets.UTF_8
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)
            java.lang.String r2 = "charset"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.io.InputStreamReader r2 = new java.io.InputStreamReader
            java.io.FileInputStream r3 = new java.io.FileInputStream
            r3.<init>(r4)
            r2.<init>(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)     // Catch:{ all -> 0x0047 }
            java.io.StringWriter r4 = new java.io.StringWriter     // Catch:{ all -> 0x0047 }
            r4.<init>()     // Catch:{ all -> 0x0047 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)     // Catch:{ all -> 0x0047 }
            java.lang.String r0 = "out"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)     // Catch:{ all -> 0x0047 }
            r0 = 8192(0x2000, float:1.14794E-41)
            char[] r0 = new char[r0]     // Catch:{ all -> 0x0047 }
            int r1 = r2.read(r0)     // Catch:{ all -> 0x0047 }
        L_0x002e:
            if (r1 < 0) goto L_0x0039
            r3 = 0
            r4.write(r0, r3, r1)     // Catch:{ all -> 0x0047 }
            int r1 = r2.read(r0)     // Catch:{ all -> 0x0047 }
            goto L_0x002e
        L_0x0039:
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0047 }
            java.lang.String r0 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)     // Catch:{ all -> 0x0047 }
            r0 = 0
            kotlin.io.CloseableKt.a(r2, r0)
            return r4
        L_0x0047:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r0 = move-exception
            kotlin.io.CloseableKt.a(r2, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt.c(java.io.File):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        kotlin.io.CloseableKt.a(r1, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d(java.io.File r2, java.lang.String r3) {
        /*
            java.nio.charset.Charset r0 = kotlin.text.Charsets.UTF_8
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.lang.String r1 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            java.lang.String r1 = "charset"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.io.FileOutputStream r1 = new java.io.FileOutputStream
            r1.<init>(r2)
            kotlin.io.FilesKt__FileReadWriteKt.a(r1, r3, r0)     // Catch:{ all -> 0x0020 }
            kotlin.Unit r2 = kotlin.Unit.f696a     // Catch:{ all -> 0x0020 }
            r2 = 0
            kotlin.io.CloseableKt.a(r1, r2)
            return
        L_0x0020:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0022 }
        L_0x0022:
            r3 = move-exception
            kotlin.io.CloseableKt.a(r1, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt.d(java.io.File, java.lang.String):void");
    }
}
