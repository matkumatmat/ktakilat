package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcu;
import java.util.ArrayList;
import java.util.Objects;

final class zzmv implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzr zzc;
    final /* synthetic */ zzcu zzd;
    final /* synthetic */ zznk zze;

    public zzmv(zznk zznk, String str, String str2, zzr zzr, zzcu zzcu) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzr;
        this.zzd = zzcu;
        Objects.requireNonNull(zznk);
        this.zze = zznk;
    }

    public final void run() {
        zzcu zzcu;
        zzpo zzk;
        ArrayList arrayList = new ArrayList();
        try {
            zznk zznk = this.zze;
            zzga zzZ = zznk.zzZ();
            if (zzZ == null) {
                zzib zzib = zznk.zzu;
                zzib.zzaV().zzb().zzc("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                zzk = zzib.zzk();
                zzcu = this.zzd;
                zzk.zzar(zzcu, arrayList);
            }
            zzr zzr = this.zzc;
            Preconditions.checkNotNull(zzr);
            arrayList = zzpo.zzas(zzZ.zzr(this.zza, this.zzb, zzr));
            zznk.zzV();
            zznk zznk2 = this.zze;
            zzcu = this.zzd;
            zzk = zznk2.zzu.zzk();
            zzk.zzar(zzcu, arrayList);
        } catch (RemoteException e) {
            this.zze.zzu.zzaV().zzb().zzd("Failed to get conditional properties; remote exception", this.zza, this.zzb, e);
        } catch (Throwable th) {
            zznk zznk3 = this.zze;
            zznk3.zzu.zzk().zzar(this.zzd, arrayList);
            throw th;
        }
    }
}
