package com.google.android.gms.internal.measurement;

import com.google.common.annotations.VisibleForTesting;
import java.util.Collections;
import java.util.TreeMap;

public final class zzz {
    @VisibleForTesting
    final TreeMap zza = new TreeMap();
    @VisibleForTesting
    final TreeMap zzb = new TreeMap();

    private static final int zzc(zzg zzg, zzan zzan, zzao zzao) {
        zzao zza2 = zzan.zza(zzg, Collections.singletonList(zzao));
        if (zza2 instanceof zzah) {
            return zzh.zzg(zza2.zzd().doubleValue());
        }
        return -1;
    }

    public final void zza(String str, int i, zzan zzan, String str2) {
        TreeMap treeMap;
        if ("create".equals(str2)) {
            treeMap = this.zzb;
        } else if ("edit".equals(str2)) {
            treeMap = this.zza;
        } else {
            throw new IllegalStateException("Unknown callback type: ".concat(String.valueOf(str2)));
        }
        if (treeMap.containsKey(Integer.valueOf(i))) {
            i = ((Integer) treeMap.lastKey()).intValue() + 1;
        }
        treeMap.put(Integer.valueOf(i), zzan);
    }

    public final void zzb(zzg zzg, zzab zzab) {
        zzl zzl = new zzl(zzab);
        TreeMap treeMap = this.zza;
        for (Integer num : treeMap.keySet()) {
            zzaa zzg2 = zzab.zzc().clone();
            int zzc = zzc(zzg, (zzan) treeMap.get(num), zzl);
            if (zzc == 2 || zzc == -1) {
                zzab.zzd(zzg2);
            }
        }
        TreeMap treeMap2 = this.zzb;
        for (Integer num2 : treeMap2.keySet()) {
            zzc(zzg, (zzan) treeMap2.get(num2), zzl);
        }
    }
}
