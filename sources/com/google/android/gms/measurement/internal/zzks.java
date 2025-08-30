package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import java.util.Objects;

final class zzks implements Runnable {
    final /* synthetic */ zzaz zza;
    final /* synthetic */ zzli zzb;

    public zzks(zzli zzli, zzaz zzaz) {
        this.zza = zzaz;
        Objects.requireNonNull(zzli);
        this.zzb = zzli;
    }

    public final void run() {
        zzli zzli = this.zzb;
        zzib zzib = zzli.zzu;
        zzhg zzd = zzib.zzd();
        zzib zzib2 = zzd.zzu;
        zzd.zzg();
        zzaz zzj = zzd.zzj();
        zzaz zzaz = this.zza;
        if (zzjk.zzu(zzaz.zzb(), zzj.zzb())) {
            SharedPreferences.Editor edit = zzd.zzd().edit();
            edit.putString("dma_consent_settings", zzaz.zze());
            edit.apply();
            zzib.zzaV().zzk().zzb("Setting DMA consent(FE)", zzaz);
            zzib zzib3 = zzli.zzu;
            if (zzib3.zzt().zzP()) {
                zzib3.zzt().zzl();
            } else {
                zzib3.zzt().zzj(false);
            }
        } else {
            zzib.zzaV().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzaz.zzb()));
        }
    }
}
