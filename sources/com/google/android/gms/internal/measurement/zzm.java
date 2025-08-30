package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Objects;

final class zzm extends zzai {
    final /* synthetic */ zzo zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzm(zzn zzn, String str, zzo zzo) {
        super("getValue");
        this.zza = zzo;
        Objects.requireNonNull(zzn);
    }

    public final zzao zza(zzg zzg, List list) {
        zzh.zza("getValue", 2, list);
        zzao zza2 = zzg.zza((zzao) list.get(0));
        zzao zza3 = zzg.zza((zzao) list.get(1));
        String zza4 = this.zza.zza(zza2.zzc());
        if (zza4 != null) {
            return new zzas(zza4);
        }
        return zza3;
    }
}
