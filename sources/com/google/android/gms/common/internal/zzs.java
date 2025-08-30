package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zzh;
import java.util.HashMap;
import java.util.concurrent.Executor;

final class zzs extends GmsClientSupervisor {
    /* access modifiers changed from: private */
    public final HashMap zzb = new HashMap();
    /* access modifiers changed from: private */
    public final Context zzc;
    /* access modifiers changed from: private */
    public volatile Handler zzd;
    private final zzq zze;
    /* access modifiers changed from: private */
    public final ConnectionTracker zzf;
    private final long zzg;
    /* access modifiers changed from: private */
    public final long zzh;
    @Nullable
    private volatile Executor zzi;

    public zzs(Context context, Looper looper, @Nullable Executor executor) {
        zzq zzq = new zzq(this, (zzr) null);
        this.zze = zzq;
        this.zzc = context.getApplicationContext();
        this.zzd = new zzh(looper, zzq);
        this.zzf = ConnectionTracker.getInstance();
        this.zzg = 5000;
        this.zzh = 300000;
        this.zzi = executor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006d, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.common.ConnectionResult zza(com.google.android.gms.common.internal.zzo r6, android.content.ServiceConnection r7, java.lang.String r8, @androidx.annotation.Nullable java.util.concurrent.Executor r9) {
        /*
            r5 = this;
            java.lang.String r0 = "Trying to bind a GmsServiceConnection that was already connected before.  config="
            java.lang.String r1 = "ServiceConnection must not be null"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7, r1)
            java.util.HashMap r1 = r5.zzb
            monitor-enter(r1)
            java.util.HashMap r2 = r5.zzb     // Catch:{ all -> 0x0017 }
            java.lang.Object r2 = r2.get(r6)     // Catch:{ all -> 0x0017 }
            com.google.android.gms.common.internal.zzp r2 = (com.google.android.gms.common.internal.zzp) r2     // Catch:{ all -> 0x0017 }
            if (r9 != 0) goto L_0x0019
            java.util.concurrent.Executor r9 = r5.zzi     // Catch:{ all -> 0x0017 }
            goto L_0x0019
        L_0x0017:
            r6 = move-exception
            goto L_0x0084
        L_0x0019:
            if (r2 != 0) goto L_0x002d
            com.google.android.gms.common.internal.zzp r2 = new com.google.android.gms.common.internal.zzp     // Catch:{ all -> 0x0017 }
            r2.<init>(r5, r6)     // Catch:{ all -> 0x0017 }
            r2.zze(r7, r7, r8)     // Catch:{ all -> 0x0017 }
            com.google.android.gms.common.ConnectionResult r7 = com.google.android.gms.common.internal.zzp.zzd(r2, r8, r9)     // Catch:{ all -> 0x0017 }
            java.util.HashMap r8 = r5.zzb     // Catch:{ all -> 0x0017 }
            r8.put(r6, r2)     // Catch:{ all -> 0x0017 }
            goto L_0x005a
        L_0x002d:
            android.os.Handler r3 = r5.zzd     // Catch:{ all -> 0x0017 }
            r4 = 0
            r3.removeMessages(r4, r6)     // Catch:{ all -> 0x0017 }
            boolean r3 = r2.zzh(r7)     // Catch:{ all -> 0x0017 }
            if (r3 != 0) goto L_0x006e
            r2.zze(r7, r7, r8)     // Catch:{ all -> 0x0017 }
            int r6 = r2.zza()     // Catch:{ all -> 0x0017 }
            r0 = 1
            r3 = 0
            if (r6 == r0) goto L_0x004e
            r7 = 2
            if (r6 == r7) goto L_0x0049
        L_0x0047:
            r7 = r3
            goto L_0x005a
        L_0x0049:
            com.google.android.gms.common.ConnectionResult r7 = com.google.android.gms.common.internal.zzp.zzd(r2, r8, r9)     // Catch:{ all -> 0x0017 }
            goto L_0x005a
        L_0x004e:
            android.content.ComponentName r6 = r2.zzb()     // Catch:{ all -> 0x0017 }
            android.os.IBinder r8 = r2.zzc()     // Catch:{ all -> 0x0017 }
            r7.onServiceConnected(r6, r8)     // Catch:{ all -> 0x0017 }
            goto L_0x0047
        L_0x005a:
            boolean r6 = r2.zzj()     // Catch:{ all -> 0x0017 }
            if (r6 == 0) goto L_0x0064
            com.google.android.gms.common.ConnectionResult r6 = com.google.android.gms.common.ConnectionResult.RESULT_SUCCESS     // Catch:{ all -> 0x0017 }
            monitor-exit(r1)     // Catch:{ all -> 0x0017 }
            return r6
        L_0x0064:
            if (r7 != 0) goto L_0x006c
            com.google.android.gms.common.ConnectionResult r7 = new com.google.android.gms.common.ConnectionResult     // Catch:{ all -> 0x0017 }
            r6 = -1
            r7.<init>(r6)     // Catch:{ all -> 0x0017 }
        L_0x006c:
            monitor-exit(r1)     // Catch:{ all -> 0x0017 }
            return r7
        L_0x006e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0017 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0017 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0017 }
            r8.<init>(r0)     // Catch:{ all -> 0x0017 }
            r8.append(r6)     // Catch:{ all -> 0x0017 }
            java.lang.String r6 = r8.toString()     // Catch:{ all -> 0x0017 }
            r7.<init>(r6)     // Catch:{ all -> 0x0017 }
            throw r7     // Catch:{ all -> 0x0017 }
        L_0x0084:
            monitor-exit(r1)     // Catch:{ all -> 0x0017 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzs.zza(com.google.android.gms.common.internal.zzo, android.content.ServiceConnection, java.lang.String, java.util.concurrent.Executor):com.google.android.gms.common.ConnectionResult");
    }

    public final void zzb(zzo zzo, ServiceConnection serviceConnection, String str) {
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzb) {
            try {
                zzp zzp = (zzp) this.zzb.get(zzo);
                if (zzp == null) {
                    String zzo2 = zzo.toString();
                    throw new IllegalStateException("Nonexistent connection status for service config: " + zzo2);
                } else if (zzp.zzh(serviceConnection)) {
                    zzp.zzf(serviceConnection, str);
                    if (zzp.zzi()) {
                        this.zzd.sendMessageDelayed(this.zzd.obtainMessage(0, zzo), this.zzg);
                    }
                } else {
                    String zzo3 = zzo.toString();
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + zzo3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzi(@Nullable Executor executor) {
        synchronized (this.zzb) {
            this.zzi = executor;
        }
    }

    public final void zzj(Looper looper) {
        synchronized (this.zzb) {
            this.zzd = new zzh(looper, this.zze);
        }
    }
}
