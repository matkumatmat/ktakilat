package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;

public final class zzjm {
    @GuardedBy("DirectBootUtils.class")
    @Nullable
    private static UserManager zza;
    private static volatile boolean zzb = (!zza());

    private zzjm() {
    }

    @ChecksSdkIntAtLeast(api = 24)
    public static boolean zza() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean zzb(Context context) {
        if (!zza() || zzd(context)) {
            return false;
        }
        return true;
    }

    public static boolean zzc(Context context) {
        if (!zza() || zzd(context)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0051, code lost:
        return r5;
     */
    @androidx.annotation.RequiresApi(24)
    @android.annotation.TargetApi(24)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean zzd(android.content.Context r7) {
        /*
            boolean r0 = zzb
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.Class<com.google.android.gms.internal.measurement.zzjm> r0 = com.google.android.gms.internal.measurement.zzjm.class
            monitor-enter(r0)
            boolean r2 = zzb     // Catch:{ all -> 0x000f }
            if (r2 == 0) goto L_0x0011
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r1
        L_0x000f:
            r7 = move-exception
            goto L_0x0052
        L_0x0011:
            r2 = 1
        L_0x0012:
            r3 = 2
            r4 = 0
            r5 = 0
            if (r2 > r3) goto L_0x0048
            android.os.UserManager r3 = zza     // Catch:{ all -> 0x000f }
            if (r3 != 0) goto L_0x0023
            java.lang.Object r3 = r7.getSystemService(android.os.UserManager.class)     // Catch:{ all -> 0x000f }
            android.os.UserManager r3 = (android.os.UserManager) r3     // Catch:{ all -> 0x000f }
            zza = r3     // Catch:{ all -> 0x000f }
        L_0x0023:
            android.os.UserManager r3 = zza     // Catch:{ all -> 0x000f }
            if (r3 != 0) goto L_0x0029
            r5 = 1
            goto L_0x004c
        L_0x0029:
            boolean r6 = r3.isUserUnlocked()     // Catch:{ NullPointerException -> 0x003b }
            if (r6 != 0) goto L_0x0039
            android.os.UserHandle r6 = android.os.Process.myUserHandle()     // Catch:{ NullPointerException -> 0x003b }
            boolean r7 = r3.isUserRunning(r6)     // Catch:{ NullPointerException -> 0x003b }
            if (r7 != 0) goto L_0x0048
        L_0x0039:
            r5 = 1
            goto L_0x0048
        L_0x003b:
            r3 = move-exception
            java.lang.String r5 = "DirectBootUtils"
            java.lang.String r6 = "Failed to check if user is unlocked."
            android.util.Log.w(r5, r6, r3)     // Catch:{ all -> 0x000f }
            zza = r4     // Catch:{ all -> 0x000f }
            int r2 = r2 + 1
            goto L_0x0012
        L_0x0048:
            if (r5 == 0) goto L_0x004c
            zza = r4     // Catch:{ all -> 0x000f }
        L_0x004c:
            if (r5 == 0) goto L_0x0050
            zzb = r1     // Catch:{ all -> 0x000f }
        L_0x0050:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r5
        L_0x0052:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjm.zzd(android.content.Context):boolean");
    }
}
