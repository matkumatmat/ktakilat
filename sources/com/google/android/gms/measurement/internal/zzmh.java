package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class zzmh implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzr zzb;
    final /* synthetic */ zznk zzc;

    public zzmh(zznk zznk, AtomicReference atomicReference, zzr zzr) {
        this.zza = atomicReference;
        this.zzb = zzr;
        Objects.requireNonNull(zznk);
        this.zzc = zznk;
    }

    public final void run() {
        AtomicReference atomicReference;
        AtomicReference atomicReference2 = this.zza;
        synchronized (atomicReference2) {
            try {
                zznk zznk = this.zzc;
                zzib zzib = zznk.zzu;
                if (!zzib.zzd().zzl().zzo(zzjj.ANALYTICS_STORAGE)) {
                    zzib.zzaV().zzh().zza("Analytics storage consent denied; will not get app instance id");
                    zznk.zzu.zzj().zzR((String) null);
                    zzib.zzd().zze.zzb((String) null);
                    atomicReference2.set((Object) null);
                    atomicReference2.notify();
                    return;
                }
                zzga zzZ = zznk.zzZ();
                if (zzZ == null) {
                    zzib.zzaV().zzb().zza("Failed to get app instance id");
                    atomicReference2.notify();
                    return;
                }
                zzr zzr = this.zzb;
                Preconditions.checkNotNull(zzr);
                atomicReference2.set(zzZ.zzm(zzr));
                String str = (String) atomicReference2.get();
                if (str != null) {
                    zznk.zzu.zzj().zzR(str);
                    zzib.zzd().zze.zzb(str);
                }
                zznk.zzV();
                atomicReference = this.zza;
                atomicReference.notify();
            } catch (RemoteException e) {
                try {
                    this.zzc.zzu.zzaV().zzb().zzb("Failed to get app instance id", e);
                    atomicReference = this.zza;
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}
