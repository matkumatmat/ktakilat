package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzbh extends zzav {
    public zzbh() {
        this.zza.add(zzbk.ADD);
        this.zza.add(zzbk.DIVIDE);
        this.zza.add(zzbk.MODULUS);
        this.zza.add(zzbk.MULTIPLY);
        this.zza.add(zzbk.NEGATE);
        this.zza.add(zzbk.POST_DECREMENT);
        this.zza.add(zzbk.POST_INCREMENT);
        this.zza.add(zzbk.PRE_DECREMENT);
        this.zza.add(zzbk.PRE_INCREMENT);
        this.zza.add(zzbk.SUBTRACT);
    }

    public final zzao zza(String str, zzg zzg, List list) {
        zzbk zzbk = zzbk.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal == 0) {
            zzao zza = zzg.zza((zzao) ba.i(zzbk.ADD, 2, list, 0));
            zzao zza2 = zzg.zza((zzao) list.get(1));
            if ((zza instanceof zzak) || (zza instanceof zzas) || (zza2 instanceof zzak) || (zza2 instanceof zzas)) {
                return new zzas(String.valueOf(zza.zzc()).concat(String.valueOf(zza2.zzc())));
            }
            return new zzah(Double.valueOf(zza2.zzd().doubleValue() + zza.zzd().doubleValue()));
        } else if (ordinal == 21) {
            return new zzah(Double.valueOf(zzg.zza((zzao) ba.i(zzbk.DIVIDE, 2, list, 0)).zzd().doubleValue() / zzg.zza((zzao) list.get(1)).zzd().doubleValue()));
        } else {
            if (ordinal == 59) {
                zzao zza3 = zzg.zza((zzao) ba.i(zzbk.SUBTRACT, 2, list, 0));
                zzah zzah = new zzah(Double.valueOf(-zzg.zza((zzao) list.get(1)).zzd().doubleValue()));
                return new zzah(Double.valueOf(zzah.zzd().doubleValue() + zza3.zzd().doubleValue()));
            } else if (ordinal == 52 || ordinal == 53) {
                zzh.zza(str, 2, list);
                zzao zza4 = zzg.zza((zzao) list.get(0));
                zzg.zza((zzao) list.get(1));
                return zza4;
            } else if (ordinal == 55 || ordinal == 56) {
                zzh.zza(str, 1, list);
                return zzg.zza((zzao) list.get(0));
            } else {
                switch (ordinal) {
                    case 44:
                        return new zzah(Double.valueOf(zzg.zza((zzao) ba.i(zzbk.MODULUS, 2, list, 0)).zzd().doubleValue() % zzg.zza((zzao) list.get(1)).zzd().doubleValue()));
                    case 45:
                        return new zzah(Double.valueOf(zzg.zza((zzao) list.get(1)).zzd().doubleValue() * zzg.zza((zzao) ba.i(zzbk.MULTIPLY, 2, list, 0)).zzd().doubleValue()));
                    case 46:
                        return new zzah(Double.valueOf(-zzg.zza((zzao) ba.i(zzbk.NEGATE, 1, list, 0)).zzd().doubleValue()));
                    default:
                        return zzb(str);
                }
            }
        }
    }
}
