package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzcu;
import java.util.Objects;

final class zzmo implements Runnable {
    final /* synthetic */ zzbg zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcu zzc;
    final /* synthetic */ zznk zzd;

    public zzmo(zznk zznk, zzbg zzbg, String str, zzcu zzcu) {
        this.zza = zzbg;
        this.zzb = str;
        this.zzc = zzcu;
        Objects.requireNonNull(zznk);
        this.zzd = zznk;
    }

    public final void run() {
        zzcu zzcu;
        zzpo zzk;
        byte[] bArr = null;
        try {
            zznk zznk = this.zzd;
            zzga zzZ = zznk.zzZ();
            if (zzZ == null) {
                zzib zzib = zznk.zzu;
                zzib.zzaV().zzb().zza("Discarding data. Failed to send event to service to bundle");
                zzk = zzib.zzk();
                zzcu = this.zzc;
                zzk.zzao(zzcu, bArr);
            }
            bArr = zzZ.zzk(this.zza, this.zzb);
            zznk.zzV();
            zznk zznk2 = this.zzd;
            zzcu = this.zzc;
            zzk = zznk2.zzu.zzk();
            zzk.zzao(zzcu, bArr);
        } catch (RemoteException e) {
            this.zzd.zzu.zzaV().zzb().zzb("Failed to send event to the service to bundle", e);
        } catch (Throwable th) {
            zznk zznk3 = this.zzd;
            zznk3.zzu.zzk().zzao(this.zzc, bArr);
            throw th;
        }
    }
}
