package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class zzkg implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzli zzb;

    public zzkg(zzli zzli, long j) {
        this.zza = j;
        Objects.requireNonNull(zzli);
        this.zzb = zzli;
    }

    public final void run() {
        zzli zzli = this.zzb;
        zzli.zzg();
        zzli.zzb();
        zzib zzib = zzli.zzu;
        zzib.zzaV().zzj().zza("Resetting analytics data (FE)");
        zzib zzib2 = zzli.zzu;
        zzob zzh = zzib2.zzh();
        zzh.zzg();
        zzh.zzb.zzc();
        zzib2.zzv().zzi();
        boolean z = !zzli.zzu.zzB();
        zzhg zzd = zzib.zzd();
        zzd.zzc.zzb(this.zza);
        zzib zzib3 = zzd.zzu;
        if (!TextUtils.isEmpty(zzib3.zzd().zzq.zza())) {
            zzd.zzq.zzb((String) null);
        }
        zzd.zzk.zzb(0);
        zzd.zzl.zzb(0);
        if (!zzib3.zzc().zzt()) {
            zzd.zzn(z);
        }
        zzd.zzr.zzb((String) null);
        zzd.zzs.zzb(0);
        zzd.zzt.zzb((Bundle) null);
        zzib2.zzt().zzB();
        zzib2.zzh().zza.zza();
        zzli.zzc = z;
        zzib2.zzt().zzC(new AtomicReference());
    }
}
