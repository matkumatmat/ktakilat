package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzr;
import java.util.List;
import java.util.Objects;

final class zzhm implements zzr {
    final /* synthetic */ zzhs zza;

    public zzhm(zzhs zzhs) {
        Objects.requireNonNull(zzhs);
        this.zza = zzhs;
    }

    public final void zza(int i, String str, List list, boolean z, boolean z2) {
        zzgr zzgr;
        int i2 = i - 1;
        if (i2 == 0) {
            zzgr = this.zza.zzu.zzaV().zzj();
        } else if (i2 != 1) {
            if (i2 == 3) {
                zzgr = this.zza.zzu.zzaV().zzk();
            } else if (i2 != 4) {
                zzgr = this.zza.zzu.zzaV().zzi();
            } else if (z) {
                zzgr = this.zza.zzu.zzaV().zzf();
            } else if (!z2) {
                zzgr = this.zza.zzu.zzaV().zzh();
            } else {
                zzgr = this.zza.zzu.zzaV().zze();
            }
        } else if (z) {
            zzgr = this.zza.zzu.zzaV().zzc();
        } else if (!z2) {
            zzgr = this.zza.zzu.zzaV().zzd();
        } else {
            zzgr = this.zza.zzu.zzaV().zzb();
        }
        int size = list.size();
        if (size == 1) {
            zzgr.zzb(str, list.get(0));
        } else if (size == 2) {
            zzgr.zzc(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzgr.zza(str);
        } else {
            zzgr.zzd(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
