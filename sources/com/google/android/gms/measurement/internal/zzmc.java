package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class zzmc implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzr zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ zznk zzd;

    public zzmc(zznk zznk, AtomicReference atomicReference, zzr zzr, boolean z) {
        this.zza = atomicReference;
        this.zzb = zzr;
        this.zzc = z;
        Objects.requireNonNull(zznk);
        this.zzd = zznk;
    }

    public final void run() {
        AtomicReference atomicReference;
        AtomicReference atomicReference2 = this.zza;
        synchronized (atomicReference2) {
            try {
                zznk zznk = this.zzd;
                zzga zzZ = zznk.zzZ();
                if (zzZ == null) {
                    zznk.zzu.zzaV().zzb().zza("Failed to get all user properties; not connected to service");
                    atomicReference2.notify();
                    return;
                }
                zzr zzr = this.zzb;
                Preconditions.checkNotNull(zzr);
                atomicReference2.set(zzZ.zzj(zzr, this.zzc));
                zznk.zzV();
                atomicReference = this.zza;
                atomicReference.notify();
            } catch (RemoteException e) {
                try {
                    this.zzd.zzu.zzaV().zzb().zzb("Failed to get all user properties; remote exception", e);
                    atomicReference = this.zza;
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}
