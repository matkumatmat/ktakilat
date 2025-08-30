package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzk extends zzai {
    private final zzab zza;

    public zzk(zzab zzab) {
        super("internal.eventLogger");
        this.zza = zzab;
    }

    public final zzao zza(zzg zzg, List list) {
        Map map;
        zzh.zza(this.zzd, 3, list);
        String zzc = zzg.zza((zzao) list.get(0)).zzc();
        long zzi = (long) zzh.zzi(zzg.zza((zzao) list.get(1)).zzd().doubleValue());
        zzao zza2 = zzg.zza((zzao) list.get(2));
        if (zza2 instanceof zzal) {
            map = zzh.zzk((zzal) zza2);
        } else {
            map = new HashMap();
        }
        this.zza.zze(zzc, zzi, map);
        return zzao.zzf;
    }
}
