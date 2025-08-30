package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import java.util.Objects;

abstract class zzeq implements Runnable {
    final long zzh;
    final long zzi;
    final boolean zzj;
    final /* synthetic */ zzfb zzk;

    public zzeq(zzfb zzfb, boolean z) {
        Objects.requireNonNull(zzfb);
        this.zzk = zzfb;
        this.zzh = zzfb.zza.currentTimeMillis();
        this.zzi = zzfb.zza.elapsedRealtime();
        this.zzj = z;
    }

    public final void run() {
        if (this.zzk.zzP()) {
            zzb();
            return;
        }
        try {
            zza();
        } catch (Exception e) {
            this.zzk.zzN(e, false, this.zzj);
            zzb();
        }
    }

    public abstract void zza() throws RemoteException;

    public void zzb() {
    }
}
