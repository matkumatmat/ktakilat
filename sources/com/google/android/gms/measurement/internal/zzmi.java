package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcu;
import java.util.Objects;

final class zzmi implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ zzcu zzb;
    final /* synthetic */ zznk zzc;

    public zzmi(zznk zznk, zzr zzr, zzcu zzcu) {
        this.zza = zzr;
        this.zzb = zzcu;
        Objects.requireNonNull(zznk);
        this.zzc = zznk;
    }

    public final void run() {
        zzcu zzcu;
        zzpo zzk;
        String str = null;
        try {
            zznk zznk = this.zzc;
            zzib zzib = zznk.zzu;
            if (!zzib.zzd().zzl().zzo(zzjj.ANALYTICS_STORAGE)) {
                zzib.zzaV().zzh().zza("Analytics storage consent denied; will not get app instance id");
                zznk.zzu.zzj().zzR((String) null);
                zzib.zzd().zze.zzb((String) null);
            } else {
                zzga zzZ = zznk.zzZ();
                if (zzZ == null) {
                    zzib.zzaV().zzb().zza("Failed to get app instance id");
                } else {
                    zzr zzr = this.zza;
                    Preconditions.checkNotNull(zzr);
                    str = zzZ.zzm(zzr);
                    if (str != null) {
                        zznk.zzu.zzj().zzR(str);
                        zzib.zzd().zze.zzb(str);
                    }
                    zznk.zzV();
                    zznk zznk2 = this.zzc;
                    zzcu = this.zzb;
                    zzk = zznk2.zzu.zzk();
                    zzk.zzal(zzcu, str);
                }
            }
            zzk = zzib.zzk();
            zzcu = this.zzb;
        } catch (RemoteException e) {
            this.zzc.zzu.zzaV().zzb().zzb("Failed to get app instance id", e);
        } catch (Throwable th) {
            zznk zznk3 = this.zzc;
            zznk3.zzu.zzk().zzal(this.zzb, (String) null);
            throw th;
        }
        zzk.zzal(zzcu, str);
    }
}
