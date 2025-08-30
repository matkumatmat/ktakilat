package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

final class zzs extends zzai {
    final boolean zza;
    final boolean zzb;
    final /* synthetic */ zzt zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzs(zzt zzt, boolean z, boolean z2) {
        super("log");
        Objects.requireNonNull(zzt);
        this.zzc = zzt;
        this.zza = z;
        this.zzb = z2;
    }

    public final zzao zza(zzg zzg, List list) {
        int i;
        zzh.zzb("log", 1, list);
        if (list.size() == 1) {
            zzt zzt = this.zzc;
            String zzc2 = zzg.zza((zzao) list.get(0)).zzc();
            boolean z = this.zza;
            boolean z2 = this.zzb;
            zzt.zzb().zza(3, zzc2, Collections.emptyList(), z, z2);
            return zzao.zzf;
        }
        int zzg2 = zzh.zzg(zzg.zza((zzao) list.get(0)).zzd().doubleValue());
        if (zzg2 == 2) {
            i = 4;
        } else if (zzg2 == 3) {
            i = 1;
        } else if (zzg2 == 5) {
            i = 5;
        } else if (zzg2 != 6) {
            i = 3;
        } else {
            i = 2;
        }
        String zzc3 = zzg.zza((zzao) list.get(1)).zzc();
        if (list.size() == 2) {
            zzt zzt2 = this.zzc;
            boolean z3 = this.zza;
            boolean z4 = this.zzb;
            zzt2.zzb().zza(i, zzc3, Collections.emptyList(), z3, z4);
            return zzao.zzf;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 2; i2 < Math.min(list.size(), 5); i2++) {
            arrayList.add(zzg.zza((zzao) list.get(i2)).zzc());
        }
        zzt zzt3 = this.zzc;
        zzt3.zzb().zza(i, zzc3, arrayList, this.zza, this.zzb);
        return zzao.zzf;
    }
}
