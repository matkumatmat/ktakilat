package androidx.camera.core.internal.utils;

public final class VideoUtil {
    private static final String TAG = "VideoUtil";

    private VideoUtil() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005f  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getAbsolutePathFromUri(@androidx.annotation.NonNull android.content.ContentResolver r9, @androidx.annotation.NonNull android.net.Uri r10) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String r1 = "Failed in getting absolute path for Uri "
            r2 = 0
            java.lang.String[] r5 = new java.lang.String[]{r0}     // Catch:{ RuntimeException -> 0x002f }
            r7 = 0
            r8 = 0
            r6 = 0
            r3 = r9
            r4 = r10
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ RuntimeException -> 0x002f }
            java.lang.Object r9 = androidx.core.util.Preconditions.checkNotNull(r2)     // Catch:{ RuntimeException -> 0x002f }
            android.database.Cursor r9 = (android.database.Cursor) r9     // Catch:{ RuntimeException -> 0x002f }
            int r0 = r9.getColumnIndexOrThrow(r0)     // Catch:{ RuntimeException -> 0x002a, all -> 0x0027 }
            r9.moveToFirst()     // Catch:{ RuntimeException -> 0x002a, all -> 0x0027 }
            java.lang.String r10 = r9.getString(r0)     // Catch:{ RuntimeException -> 0x002a, all -> 0x0027 }
            r9.close()
            return r10
        L_0x0027:
            r10 = move-exception
            r2 = r9
            goto L_0x005d
        L_0x002a:
            r0 = move-exception
            r2 = r9
            goto L_0x0030
        L_0x002d:
            r10 = move-exception
            goto L_0x005d
        L_0x002f:
            r0 = move-exception
        L_0x0030:
            java.lang.String r9 = "VideoUtil"
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x002d }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x002d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x005b }
            r3.<init>(r1)     // Catch:{ all -> 0x005b }
            r3.append(r10)     // Catch:{ all -> 0x005b }
            java.lang.String r10 = " with Exception "
            r3.append(r10)     // Catch:{ all -> 0x005b }
            r3.append(r0)     // Catch:{ all -> 0x005b }
            java.lang.String r10 = r3.toString()     // Catch:{ all -> 0x005b }
            androidx.camera.core.Logger.e(r9, r10)     // Catch:{ all -> 0x002d }
            java.lang.String r9 = ""
            if (r2 == 0) goto L_0x0058
            r2.close()
        L_0x0058:
            return r9
        L_0x0059:
            r10 = r9
            goto L_0x005d
        L_0x005b:
            r9 = move-exception
            goto L_0x0059
        L_0x005d:
            if (r2 == 0) goto L_0x0062
            r2.close()
        L_0x0062:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.internal.utils.VideoUtil.getAbsolutePathFromUri(android.content.ContentResolver, android.net.Uri):java.lang.String");
    }
}
