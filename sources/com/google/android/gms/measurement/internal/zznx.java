package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import java.util.Objects;

final class zznx {
    final /* synthetic */ zzob zza;
    private zznw zzb;

    public zznx(zzob zzob) {
        Objects.requireNonNull(zzob);
        this.zza = zzob;
    }

    @WorkerThread
    public final void zza() {
        zzob zzob = this.zza;
        zzob.zzg();
        zznw zznw = this.zzb;
        if (zznw != null) {
            zzob.zzm().removeCallbacks(zznw);
        }
        zzib zzib = zzob.zzu;
        zzib.zzd().zzn.zzb(false);
        zzob.zzh(false);
        if (zzib.zzc().zzp((String) null, zzfx.zzaT)) {
            zzib zzib2 = zzob.zzu;
            if (zzib2.zzj().zzx()) {
                zzib.zzaV().zzk().zza("Retrying trigger URI registration in foreground");
                zzib2.zzj().zzz();
            }
        }
    }

    @WorkerThread
    public final void zzb(long j) {
        zzob zzob = this.zza;
        this.zzb = new zznw(this, zzob.zzu.zzaZ().currentTimeMillis(), j);
        zzob.zzm().postDelayed(this.zzb, 2000);
    }
}
