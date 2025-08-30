package com.google.android.gms.internal.auth;

import android.os.Build;
import android.os.UserManager;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.GuardedBy;

public final class zzcc {
    @GuardedBy("DirectBootUtils.class")
    private static UserManager zza;
    private static volatile boolean zzb = (!zzb());

    private zzcc() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0041, code lost:
        r8 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zza(android.content.Context r8) {
        /*
            boolean r0 = zzb()
            r1 = 0
            if (r0 == 0) goto L_0x005e
            boolean r0 = zzb
            if (r0 == 0) goto L_0x000c
            goto L_0x005e
        L_0x000c:
            java.lang.Class<com.google.android.gms.internal.auth.zzcc> r0 = com.google.android.gms.internal.auth.zzcc.class
            monitor-enter(r0)
            boolean r2 = zzb     // Catch:{ all -> 0x0015 }
            if (r2 == 0) goto L_0x0017
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            goto L_0x005e
        L_0x0015:
            r8 = move-exception
            goto L_0x005c
        L_0x0017:
            r2 = 1
            r3 = 1
        L_0x0019:
            r4 = 2
            r5 = 0
            if (r3 > r4) goto L_0x0041
            android.os.UserManager r4 = zza     // Catch:{ all -> 0x0015 }
            if (r4 != 0) goto L_0x0029
            java.lang.Object r4 = r8.getSystemService(android.os.UserManager.class)     // Catch:{ all -> 0x0015 }
            android.os.UserManager r4 = (android.os.UserManager) r4     // Catch:{ all -> 0x0015 }
            zza = r4     // Catch:{ all -> 0x0015 }
        L_0x0029:
            android.os.UserManager r4 = zza     // Catch:{ all -> 0x0015 }
            if (r4 != 0) goto L_0x002f
            r8 = 1
            goto L_0x0054
        L_0x002f:
            boolean r6 = r4.isUserUnlocked()     // Catch:{ NullPointerException -> 0x0043 }
            if (r6 != 0) goto L_0x003f
            android.os.UserHandle r6 = android.os.Process.myUserHandle()     // Catch:{ NullPointerException -> 0x0043 }
            boolean r8 = r4.isUserRunning(r6)     // Catch:{ NullPointerException -> 0x0043 }
            if (r8 != 0) goto L_0x0041
        L_0x003f:
            r8 = 1
            goto L_0x0050
        L_0x0041:
            r8 = 0
            goto L_0x0050
        L_0x0043:
            r4 = move-exception
            java.lang.String r6 = "DirectBootUtils"
            java.lang.String r7 = "Failed to check if user is unlocked."
            android.util.Log.w(r6, r7, r4)     // Catch:{ all -> 0x0015 }
            zza = r5     // Catch:{ all -> 0x0015 }
            int r3 = r3 + 1
            goto L_0x0019
        L_0x0050:
            if (r8 == 0) goto L_0x0054
            zza = r5     // Catch:{ all -> 0x0015 }
        L_0x0054:
            if (r8 == 0) goto L_0x0058
            zzb = r2     // Catch:{ all -> 0x0015 }
        L_0x0058:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            if (r8 != 0) goto L_0x005e
            return r2
        L_0x005c:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r8
        L_0x005e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzcc.zza(android.content.Context):boolean");
    }

    @ChecksSdkIntAtLeast(api = 24)
    public static boolean zzb() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
