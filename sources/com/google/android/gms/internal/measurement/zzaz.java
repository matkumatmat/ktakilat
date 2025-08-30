package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Comparator;

final class zzaz implements Comparator {
    final /* synthetic */ zzai zza;
    final /* synthetic */ zzg zzb;

    public zzaz(zzai zzai, zzg zzg) {
        this.zza = zzai;
        this.zzb = zzg;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzao zzao = (zzao) obj;
        zzao zzao2 = (zzao) obj2;
        if (zzao instanceof zzat) {
            if (!(zzao2 instanceof zzat)) {
                return 1;
            }
            return 0;
        } else if (zzao2 instanceof zzat) {
            return -1;
        } else {
            zzai zzai = this.zza;
            if (zzai == null) {
                return zzao.zzc().compareTo(zzao2.zzc());
            }
            return (int) zzh.zzi(zzai.zza(this.zzb, Arrays.asList(new zzao[]{zzao, zzao2})).zzd().doubleValue());
        }
    }
}
