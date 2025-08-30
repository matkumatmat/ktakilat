package com.google.android.material.color;

import androidx.annotation.RequiresApi;

@RequiresApi(30)
final class ColorResourcesLoaderCreator {
    private static final String TAG = "ColorResLoaderCreator";

    private ColorResourcesLoaderCreator() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0042, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004b, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004c, code lost:
        if (r5 != null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0052, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r3.addSuppressed(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x005b, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r5.addSuppressed(r2);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:9:0x0014, B:19:0x0027, B:21:0x002e, B:34:0x004e, B:40:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0064 A[SYNTHETIC, Splitter:B:49:0x0064] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.loader.ResourcesLoader create(@androidx.annotation.NonNull android.content.Context r5, @androidx.annotation.NonNull java.util.Map<java.lang.Integer, java.lang.Integer> r6) {
        /*
            java.lang.String r0 = "ColorResLoaderCreator"
            r1 = 0
            byte[] r5 = com.google.android.material.color.ColorResourcesTableCreator.create(r5, r6)     // Catch:{ Exception -> 0x001d }
            int r6 = r5.length     // Catch:{ Exception -> 0x001d }
            int r6 = r5.length     // Catch:{ Exception -> 0x001d }
            if (r6 != 0) goto L_0x000c
            return r1
        L_0x000c:
            java.io.FileDescriptor r6 = android.system.Os.memfd_create("temp.arsc", 0)     // Catch:{ all -> 0x0060 }
            if (r6 != 0) goto L_0x0022
            java.lang.String r5 = "Cannot create memory file descriptor."
            android.util.Log.w(r0, r5)     // Catch:{ all -> 0x0020 }
            if (r6 == 0) goto L_0x001f
            android.system.Os.close(r6)     // Catch:{ Exception -> 0x001d }
            goto L_0x001f
        L_0x001d:
            r5 = move-exception
            goto L_0x0068
        L_0x001f:
            return r1
        L_0x0020:
            r5 = move-exception
            goto L_0x0062
        L_0x0022:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0020 }
            r2.<init>(r6)     // Catch:{ all -> 0x0020 }
            r2.write(r5)     // Catch:{ all -> 0x0042 }
            android.os.ParcelFileDescriptor r5 = android.os.ParcelFileDescriptor.dup(r6)     // Catch:{ all -> 0x0042 }
            defpackage.n.p()     // Catch:{ all -> 0x004b }
            android.content.res.loader.ResourcesLoader r3 = defpackage.n.e()     // Catch:{ all -> 0x004b }
            android.content.res.loader.ResourcesProvider r4 = android.content.res.loader.ResourcesProvider.loadFromTable(r5, (android.content.res.loader.AssetsProvider) null)     // Catch:{ all -> 0x004b }
            r3.addProvider(r4)     // Catch:{ all -> 0x004b }
            if (r5 == 0) goto L_0x0044
            r5.close()     // Catch:{ all -> 0x0042 }
            goto L_0x0044
        L_0x0042:
            r5 = move-exception
            goto L_0x0057
        L_0x0044:
            r2.close()     // Catch:{ all -> 0x0020 }
            android.system.Os.close(r6)     // Catch:{ Exception -> 0x001d }
            return r3
        L_0x004b:
            r3 = move-exception
            if (r5 == 0) goto L_0x0056
            r5.close()     // Catch:{ all -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r5 = move-exception
            r3.addSuppressed(r5)     // Catch:{ all -> 0x0042 }
        L_0x0056:
            throw r3     // Catch:{ all -> 0x0042 }
        L_0x0057:
            r2.close()     // Catch:{ all -> 0x005b }
            goto L_0x005f
        L_0x005b:
            r2 = move-exception
            r5.addSuppressed(r2)     // Catch:{ all -> 0x0020 }
        L_0x005f:
            throw r5     // Catch:{ all -> 0x0020 }
        L_0x0060:
            r5 = move-exception
            r6 = r1
        L_0x0062:
            if (r6 == 0) goto L_0x0067
            android.system.Os.close(r6)     // Catch:{ Exception -> 0x001d }
        L_0x0067:
            throw r5     // Catch:{ Exception -> 0x001d }
        L_0x0068:
            java.lang.String r6 = "Failed to create the ColorResourcesTableCreator."
            android.util.Log.e(r0, r6, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.ColorResourcesLoaderCreator.create(android.content.Context, java.util.Map):android.content.res.loader.ResourcesLoader");
    }
}
