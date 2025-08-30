package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzv extends zzai {
    private final zzz zza;

    public zzv(zzz zzz) {
        super("internal.registerCallback");
        this.zza = zzz;
    }

    public final zzao zza(zzg zzg, List list) {
        int i;
        zzh.zza(this.zzd, 3, list);
        String zzc = zzg.zza((zzao) list.get(0)).zzc();
        zzao zza2 = zzg.zza((zzao) list.get(1));
        if (zza2 instanceof zzan) {
            zzao zza3 = zzg.zza((zzao) list.get(2));
            if (zza3 instanceof zzal) {
                zzal zzal = (zzal) zza3;
                if (zzal.zzj("type")) {
                    String zzc2 = zzal.zzk("type").zzc();
                    if (zzal.zzj("priority")) {
                        i = zzh.zzg(zzal.zzk("priority").zzd().doubleValue());
                    } else {
                        i = 1000;
                    }
                    this.zza.zza(zzc, i, (zzan) zza2, zzc2);
                    return zzao.zzf;
                }
                throw new IllegalArgumentException("Undefined rule type");
            }
            throw new IllegalArgumentException("Invalid callback params");
        }
        throw new IllegalArgumentException("Invalid callback type");
    }
}
