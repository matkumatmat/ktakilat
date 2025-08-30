package com.google.android.gms.internal.measurement;

import com.google.common.annotations.VisibleForTesting;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public final class zzw extends zzai {
    @VisibleForTesting
    final Map zza = new HashMap();
    private final zzj zzb;

    public zzw(zzj zzj) {
        super("require");
        this.zzb = zzj;
    }

    public final zzao zza(zzg zzg, List list) {
        zzao zzao;
        zzh.zza("require", 1, list);
        String zzc = zzg.zza((zzao) list.get(0)).zzc();
        Map map = this.zza;
        if (map.containsKey(zzc)) {
            return (zzao) map.get(zzc);
        }
        Map map2 = this.zzb.zza;
        if (map2.containsKey(zzc)) {
            try {
                zzao = (zzao) ((Callable) map2.get(zzc)).call();
            } catch (Exception unused) {
                throw new IllegalStateException("Failed to create API implementation: ".concat(String.valueOf(zzc)));
            }
        } else {
            zzao = zzao.zzf;
        }
        if (zzao instanceof zzai) {
            this.zza.put(zzc, (zzai) zzao);
        }
        return zzao;
    }
}
