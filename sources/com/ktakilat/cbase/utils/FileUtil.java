package com.ktakilat.cbase.utils;

import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;

public final class FileUtil {
    public static String a(Context context, Uri uri) {
        String str;
        try {
            if (uri.getScheme().equals(FirebaseAnalytics.Param.CONTENT)) {
                str = MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri));
            } else {
                str = MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uri.getPath())).toString());
            }
            if (str != null && !str.isEmpty()) {
                return ".".concat(str);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063 A[Catch:{ all -> 0x00b4, all -> 0x00b9, all -> 0x004d, all -> 0x0052, all -> 0x0068 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006f A[Catch:{ all -> 0x00b4, all -> 0x00b9, all -> 0x004d, all -> 0x0052, all -> 0x0068 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a2 A[Catch:{ all -> 0x00b4, all -> 0x00b9, all -> 0x004d, all -> 0x0052, all -> 0x0068 }, LOOP:0: B:43:0x009b->B:45:0x00a2, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00a6 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(android.content.Context r12, android.net.Uri r13) {
        /*
            java.lang.String r0 = "image_picker"
            r1 = 0
            android.content.ContentResolver r2 = r12.getContentResolver()     // Catch:{ IOException | SecurityException -> 0x00c9 }
            java.io.InputStream r2 = r2.openInputStream(r13)     // Catch:{ IOException | SecurityException -> 0x00c9 }
            java.util.UUID r3 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x0068 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0068 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0068 }
            java.io.File r5 = r12.getCacheDir()     // Catch:{ all -> 0x0068 }
            r4.<init>(r5, r3)     // Catch:{ all -> 0x0068 }
            r4.mkdir()     // Catch:{ all -> 0x0068 }
            r4.deleteOnExit()     // Catch:{ all -> 0x0068 }
            android.content.ContentResolver r6 = r12.getContentResolver()     // Catch:{ all -> 0x0068 }
            java.lang.String r3 = "_display_name"
            java.lang.String[] r8 = new java.lang.String[]{r3}     // Catch:{ all -> 0x0068 }
            r10 = 0
            r11 = 0
            r9 = 0
            r7 = r13
            android.database.Cursor r3 = r6.query(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0068 }
            r5 = 0
            if (r3 == 0) goto L_0x0057
            boolean r6 = r3.moveToFirst()     // Catch:{ all -> 0x004d }
            if (r6 == 0) goto L_0x0057
            int r6 = r3.getColumnCount()     // Catch:{ all -> 0x004d }
            r7 = 1
            if (r6 >= r7) goto L_0x0045
            goto L_0x0057
        L_0x0045:
            java.lang.String r6 = r3.getString(r5)     // Catch:{ all -> 0x004d }
            r3.close()     // Catch:{ all -> 0x0068 }
            goto L_0x005d
        L_0x004d:
            r12 = move-exception
            r3.close()     // Catch:{ all -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r13 = move-exception
            r12.addSuppressed(r13)     // Catch:{ all -> 0x0068 }
        L_0x0056:
            throw r12     // Catch:{ all -> 0x0068 }
        L_0x0057:
            if (r3 == 0) goto L_0x005c
            r3.close()     // Catch:{ all -> 0x0068 }
        L_0x005c:
            r6 = r1
        L_0x005d:
            java.lang.String r12 = a(r12, r13)     // Catch:{ all -> 0x0068 }
            if (r6 != 0) goto L_0x006f
            if (r12 != 0) goto L_0x006a
            java.lang.String r12 = ".jpg"
            goto L_0x006a
        L_0x0068:
            r12 = move-exception
            goto L_0x00be
        L_0x006a:
            java.lang.String r6 = r0.concat(r12)     // Catch:{ all -> 0x0068 }
            goto L_0x008d
        L_0x006f:
            if (r12 == 0) goto L_0x008d
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
            r13.<init>()     // Catch:{ all -> 0x0068 }
            r0 = 46
            int r0 = r6.lastIndexOf(r0)     // Catch:{ all -> 0x0068 }
            if (r0 >= 0) goto L_0x007f
            goto L_0x0083
        L_0x007f:
            java.lang.String r6 = r6.substring(r5, r0)     // Catch:{ all -> 0x0068 }
        L_0x0083:
            r13.append(r6)     // Catch:{ all -> 0x0068 }
            r13.append(r12)     // Catch:{ all -> 0x0068 }
            java.lang.String r6 = r13.toString()     // Catch:{ all -> 0x0068 }
        L_0x008d:
            java.io.File r12 = new java.io.File     // Catch:{ all -> 0x0068 }
            r12.<init>(r4, r6)     // Catch:{ all -> 0x0068 }
            java.io.FileOutputStream r13 = new java.io.FileOutputStream     // Catch:{ all -> 0x0068 }
            r13.<init>(r12)     // Catch:{ all -> 0x0068 }
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x00b4 }
        L_0x009b:
            int r3 = r2.read(r0)     // Catch:{ all -> 0x00b4 }
            r4 = -1
            if (r3 == r4) goto L_0x00a6
            r13.write(r0, r5, r3)     // Catch:{ all -> 0x00b4 }
            goto L_0x009b
        L_0x00a6:
            r13.flush()     // Catch:{ all -> 0x00b4 }
            java.lang.String r12 = r12.getPath()     // Catch:{ all -> 0x00b4 }
            r13.close()     // Catch:{ all -> 0x0068 }
            r2.close()     // Catch:{ IOException | SecurityException -> 0x00c9 }
            return r12
        L_0x00b4:
            r12 = move-exception
            r13.close()     // Catch:{ all -> 0x00b9 }
            goto L_0x00bd
        L_0x00b9:
            r13 = move-exception
            r12.addSuppressed(r13)     // Catch:{ all -> 0x0068 }
        L_0x00bd:
            throw r12     // Catch:{ all -> 0x0068 }
        L_0x00be:
            if (r2 == 0) goto L_0x00c8
            r2.close()     // Catch:{ all -> 0x00c4 }
            goto L_0x00c8
        L_0x00c4:
            r13 = move-exception
            r12.addSuppressed(r13)     // Catch:{ IOException | SecurityException -> 0x00c9 }
        L_0x00c8:
            throw r12     // Catch:{ IOException | SecurityException -> 0x00c9 }
        L_0x00c9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.cbase.utils.FileUtil.b(android.content.Context, android.net.Uri):java.lang.String");
    }
}
