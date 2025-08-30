package com.google.android.gms.cloudmessaging;

import android.os.Handler;

public final /* synthetic */ class zzm implements Handler.Callback {
    public final /* synthetic */ zzp zza;

    public /* synthetic */ zzm(zzp zzp) {
        this.zza = zzp;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        r5 = r5.getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        if (r5.getBoolean("unsupported", false) == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        r3.zzc(new com.google.android.gms.cloudmessaging.zzt(4, "Not supported by GmsCore", (java.lang.Throwable) null));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004f, code lost:
        r3.zza(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r5) {
        /*
            r4 = this;
            java.lang.String r0 = "Received response for unknown request: "
            java.lang.String r1 = "MessengerIpcClient"
            int r2 = r5.arg1
            r3 = 3
            android.util.Log.isLoggable(r1, r3)
            com.google.android.gms.cloudmessaging.zzp r1 = r4.zza
            monitor-enter(r1)
            android.util.SparseArray r3 = r1.zze     // Catch:{ all -> 0x002a }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x002a }
            com.google.android.gms.cloudmessaging.zzs r3 = (com.google.android.gms.cloudmessaging.zzs) r3     // Catch:{ all -> 0x002a }
            if (r3 != 0) goto L_0x002c
            java.lang.String r5 = "MessengerIpcClient"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
            r3.<init>(r0)     // Catch:{ all -> 0x002a }
            r3.append(r2)     // Catch:{ all -> 0x002a }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x002a }
            android.util.Log.w(r5, r0)     // Catch:{ all -> 0x002a }
            monitor-exit(r1)     // Catch:{ all -> 0x002a }
            goto L_0x0052
        L_0x002a:
            r5 = move-exception
            goto L_0x0054
        L_0x002c:
            android.util.SparseArray r0 = r1.zze     // Catch:{ all -> 0x002a }
            r0.remove(r2)     // Catch:{ all -> 0x002a }
            r1.zzf()     // Catch:{ all -> 0x002a }
            monitor-exit(r1)     // Catch:{ all -> 0x002a }
            android.os.Bundle r5 = r5.getData()
            java.lang.String r0 = "unsupported"
            r1 = 0
            boolean r0 = r5.getBoolean(r0, r1)
            if (r0 == 0) goto L_0x004f
            java.lang.String r5 = "Not supported by GmsCore"
            com.google.android.gms.cloudmessaging.zzt r0 = new com.google.android.gms.cloudmessaging.zzt
            r1 = 4
            r2 = 0
            r0.<init>(r1, r5, r2)
            r3.zzc(r0)
            goto L_0x0052
        L_0x004f:
            r3.zza(r5)
        L_0x0052:
            r5 = 1
            return r5
        L_0x0054:
            monitor-exit(r1)     // Catch:{ all -> 0x002a }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.zzm.handleMessage(android.os.Message):boolean");
    }
}
