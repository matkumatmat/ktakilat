package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import java.util.Objects;

final class zznz {
    @VisibleForTesting
    protected long zza;
    @VisibleForTesting
    protected long zzb;
    final /* synthetic */ zzob zzc;
    private final zzay zzd;

    public zznz(zzob zzob) {
        Objects.requireNonNull(zzob);
        this.zzc = zzob;
        this.zzd = new zzny(this, zzob.zzu);
        long elapsedRealtime = zzob.zzu.zzaZ().elapsedRealtime();
        this.zza = elapsedRealtime;
        this.zzb = elapsedRealtime;
    }

    @WorkerThread
    public final void zza(long j) {
        this.zzc.zzg();
        this.zzd.zzd();
        this.zza = j;
        this.zzb = j;
    }

    @WorkerThread
    public final void zzb(long j) {
        this.zzd.zzd();
    }

    public final void zzc() {
        this.zzd.zzd();
        long elapsedRealtime = this.zzc.zzu.zzaZ().elapsedRealtime();
        this.zza = elapsedRealtime;
        this.zzb = elapsedRealtime;
    }

    @WorkerThread
    public final boolean zzd(boolean z, boolean z2, long j) {
        zzob zzob = this.zzc;
        zzob.zzg();
        zzob.zzb();
        if (zzob.zzu.zzB()) {
            zzib zzib = zzob.zzu;
            zzib.zzd().zzk.zzb(zzib.zzaZ().currentTimeMillis());
        }
        long j2 = j - this.zza;
        if (z || j2 >= 1000) {
            if (!z2) {
                j2 = j - this.zzb;
                this.zzb = j;
            }
            zzib zzib2 = zzob.zzu;
            zzib2.zzaV().zzk().zzb("Recording user engagement, ms", Long.valueOf(j2));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j2);
            zzib zzib3 = zzob.zzu;
            zzpo.zzav(zzib3.zzs().zzh(!zzib2.zzc().zzv()), bundle, true);
            if (!z2) {
                zzib3.zzj().zzF("auto", "_e", bundle);
            }
            this.zza = j;
            zzay zzay = this.zzd;
            zzay.zzd();
            zzay.zzb(((Long) zzfx.zzaq.zzb((Object) null)).longValue());
            return true;
        }
        zzob.zzu.zzaV().zzk().zzb("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
        return false;
    }
}
