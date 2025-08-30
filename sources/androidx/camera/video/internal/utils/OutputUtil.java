package androidx.camera.video.internal.utils;

import androidx.annotation.NonNull;
import java.io.File;

public final class OutputUtil {
    private static final String TAG = "OutputUtil";

    private OutputUtil() {
    }

    public static boolean createParentFolder(@NonNull File file) {
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return false;
        }
        if (parentFile.exists()) {
            return parentFile.isDirectory();
        }
        return parentFile.mkdirs();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getAbsolutePathFromUri(@androidx.annotation.NonNull android.content.ContentResolver r8, @androidx.annotation.NonNull android.net.Uri r9, @androidx.annotation.NonNull java.lang.String r10) {
        /*
            java.lang.String r0 = "Failed in getting absolute path for Uri "
            r1 = 0
            java.lang.String[] r4 = new java.lang.String[]{r10}     // Catch:{ RuntimeException -> 0x002e, all -> 0x002c }
            r6 = 0
            r7 = 0
            r5 = 0
            r2 = r8
            r3 = r9
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ RuntimeException -> 0x002e, all -> 0x002c }
            if (r8 != 0) goto L_0x0018
            if (r8 == 0) goto L_0x0017
            r8.close()
        L_0x0017:
            return r1
        L_0x0018:
            int r10 = r8.getColumnIndexOrThrow(r10)     // Catch:{ RuntimeException -> 0x002a }
            r8.moveToFirst()     // Catch:{ RuntimeException -> 0x002a }
            java.lang.String r9 = r8.getString(r10)     // Catch:{ RuntimeException -> 0x002a }
            r8.close()
            return r9
        L_0x0027:
            r9 = move-exception
            r1 = r8
            goto L_0x0057
        L_0x002a:
            r10 = move-exception
            goto L_0x0030
        L_0x002c:
            r9 = move-exception
            goto L_0x0057
        L_0x002e:
            r10 = move-exception
            r8 = r1
        L_0x0030:
            java.lang.String r2 = "OutputUtil"
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0027 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0027 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0027 }
            r3.<init>(r0)     // Catch:{ all -> 0x0027 }
            r3.append(r9)     // Catch:{ all -> 0x0027 }
            java.lang.String r9 = " with Exception "
            r3.append(r9)     // Catch:{ all -> 0x0027 }
            r3.append(r10)     // Catch:{ all -> 0x0027 }
            java.lang.String r9 = r3.toString()     // Catch:{ all -> 0x0027 }
            androidx.camera.core.Logger.e(r2, r9)     // Catch:{ all -> 0x0027 }
            if (r8 == 0) goto L_0x0056
            r8.close()
        L_0x0056:
            return r1
        L_0x0057:
            if (r1 == 0) goto L_0x005c
            r1.close()
        L_0x005c:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.utils.OutputUtil.getAbsolutePathFromUri(android.content.ContentResolver, android.net.Uri, java.lang.String):java.lang.String");
    }
}
