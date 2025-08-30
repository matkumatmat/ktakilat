package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzbb extends zzav {
    public zzbb() {
        this.zza.add(zzbk.AND);
        this.zza.add(zzbk.NOT);
        this.zza.add(zzbk.OR);
    }

    public final zzao zza(String str, zzg zzg, List list) {
        zzbk zzbk = zzbk.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal == 1) {
            zzao zza = zzg.zza((zzao) ba.i(zzbk.AND, 2, list, 0));
            if (zza.zze().booleanValue()) {
                return zzg.zza((zzao) list.get(1));
            }
            return zza;
        } else if (ordinal == 47) {
            return new zzaf(Boolean.valueOf(!zzg.zza((zzao) ba.i(zzbk.NOT, 1, list, 0)).zze().booleanValue()));
        } else {
            if (ordinal != 50) {
                return zzb(str);
            }
            zzao zza2 = zzg.zza((zzao) ba.i(zzbk.OR, 2, list, 0));
            if (!zza2.zze().booleanValue()) {
                return zzg.zza((zzao) list.get(1));
            }
            return zza2;
        }
    }
}
