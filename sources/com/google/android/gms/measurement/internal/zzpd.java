package com.google.android.gms.measurement.internal;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;

@VisibleForTesting
final class zzpd {
    private final zzpf zza;
    private int zzb = 1;
    private long zzc = zzd();

    public zzpd(zzpf zzpf) {
        this.zza = zzpf;
    }

    private final long zzd() {
        zzpf zzpf = this.zza;
        Preconditions.checkNotNull(zzpf);
        long longValue = ((Long) zzfx.zzu.zzb((Object) null)).longValue();
        long longValue2 = ((Long) zzfx.zzv.zzb((Object) null)).longValue();
        for (int i = 1; i < this.zzb; i++) {
            longValue += longValue;
            if (longValue >= longValue2) {
                break;
            }
        }
        return Math.min(longValue, longValue2) + zzpf.zzaZ().currentTimeMillis();
    }

    public final void zza() {
        this.zzb++;
        this.zzc = zzd();
    }

    public final boolean zzb() {
        if (this.zza.zzaZ().currentTimeMillis() >= this.zzc) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ long zzc() {
        return this.zzc;
    }
}
