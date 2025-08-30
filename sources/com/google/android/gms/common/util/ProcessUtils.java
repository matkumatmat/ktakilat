package com.google.android.gms.common.util;

import android.os.Process;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.common.zzab;
import com.google.android.gms.internal.common.zzac;
import com.google.android.gms.internal.common.zzj;
import com.google.android.gms.internal.common.zzl;
import javax.annotation.Nullable;

@KeepForSdk
public class ProcessUtils {
    @Nullable
    private static String zza;
    private static int zzb;
    @Nullable
    private static Boolean zzc;

    private ProcessUtils() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getMyProcessName() {
        /*
            java.lang.String r0 = "/proc/"
            java.lang.String r1 = zza
            if (r1 != 0) goto L_0x0064
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L_0x0013
            java.lang.String r0 = android.app.Application.getProcessName()
            zza = r0
            goto L_0x0064
        L_0x0013:
            int r1 = zzb
            if (r1 != 0) goto L_0x001d
            int r1 = android.os.Process.myPid()
            zzb = r1
        L_0x001d:
            r2 = 0
            if (r1 > 0) goto L_0x0021
            goto L_0x0062
        L_0x0021:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0060, all -> 0x0055 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x0060, all -> 0x0055 }
            r3.append(r1)     // Catch:{ IOException -> 0x0060, all -> 0x0055 }
            java.lang.String r0 = "/cmdline"
            r3.append(r0)     // Catch:{ IOException -> 0x0060, all -> 0x0055 }
            java.lang.String r0 = r3.toString()     // Catch:{ IOException -> 0x0060, all -> 0x0055 }
            android.os.StrictMode$ThreadPolicy r1 = android.os.StrictMode.allowThreadDiskReads()     // Catch:{ IOException -> 0x0060, all -> 0x0055 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x0057 }
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ all -> 0x0057 }
            r4.<init>(r0)     // Catch:{ all -> 0x0057 }
            r3.<init>(r4)     // Catch:{ all -> 0x0057 }
            android.os.StrictMode.setThreadPolicy(r1)     // Catch:{ IOException -> 0x0060, all -> 0x0055 }
            java.lang.String r0 = r3.readLine()     // Catch:{ IOException -> 0x004e, all -> 0x0052 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ IOException -> 0x004e, all -> 0x0052 }
            java.lang.String r2 = r0.trim()     // Catch:{ IOException -> 0x004e, all -> 0x0052 }
        L_0x004e:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r3)
            goto L_0x0062
        L_0x0052:
            r0 = move-exception
            r2 = r3
            goto L_0x005c
        L_0x0055:
            r0 = move-exception
            goto L_0x005c
        L_0x0057:
            r0 = move-exception
            android.os.StrictMode.setThreadPolicy(r1)     // Catch:{ IOException -> 0x0060, all -> 0x0055 }
            throw r0     // Catch:{ IOException -> 0x0060, all -> 0x0055 }
        L_0x005c:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)
            throw r0
        L_0x0060:
            r3 = r2
            goto L_0x004e
        L_0x0062:
            zza = r2
        L_0x0064:
            java.lang.String r0 = zza
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.ProcessUtils.getMyProcessName():java.lang.String");
    }

    public static boolean zza() {
        Boolean bool = zzc;
        if (bool == null) {
            if (PlatformVersion.isAtLeastP()) {
                bool = Boolean.valueOf(Process.isIsolated());
            } else {
                try {
                    Object zza2 = zzl.zza(Process.class, "isIsolated", new zzj[0]);
                    Object[] objArr = new Object[0];
                    if (zza2 != null) {
                        bool = (Boolean) zza2;
                    } else {
                        throw new zzac(zzab.zza("expected a non-null reference", objArr));
                    }
                } catch (ReflectiveOperationException unused) {
                    bool = Boolean.FALSE;
                }
            }
            zzc = bool;
        }
        return bool.booleanValue();
    }
}
