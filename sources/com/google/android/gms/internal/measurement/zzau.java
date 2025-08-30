package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzau extends zzav {
    public zzau() {
        this.zza.add(zzbk.BITWISE_AND);
        this.zza.add(zzbk.BITWISE_LEFT_SHIFT);
        this.zza.add(zzbk.BITWISE_NOT);
        this.zza.add(zzbk.BITWISE_OR);
        this.zza.add(zzbk.BITWISE_RIGHT_SHIFT);
        this.zza.add(zzbk.BITWISE_UNSIGNED_RIGHT_SHIFT);
        this.zza.add(zzbk.BITWISE_XOR);
    }

    public final zzao zza(String str, zzg zzg, List list) {
        zzah zzah;
        zzbk zzbk = zzbk.ADD;
        switch (zzh.zze(str).ordinal()) {
            case 4:
                zzah = new zzah(Double.valueOf((double) (zzh.zzg(zzg.zza((zzao) ba.i(zzbk.BITWISE_AND, 2, list, 0)).zzd().doubleValue()) & zzh.zzg(zzg.zza((zzao) list.get(1)).zzd().doubleValue()))));
                break;
            case 5:
                zzah = new zzah(Double.valueOf((double) (zzh.zzg(zzg.zza((zzao) ba.i(zzbk.BITWISE_LEFT_SHIFT, 2, list, 0)).zzd().doubleValue()) << ((int) (zzh.zzh(zzg.zza((zzao) list.get(1)).zzd().doubleValue()) & 31)))));
                break;
            case 6:
                zzah = new zzah(Double.valueOf((double) (~zzh.zzg(zzg.zza((zzao) ba.i(zzbk.BITWISE_NOT, 1, list, 0)).zzd().doubleValue()))));
                break;
            case 7:
                zzah = new zzah(Double.valueOf((double) (zzh.zzg(zzg.zza((zzao) ba.i(zzbk.BITWISE_OR, 2, list, 0)).zzd().doubleValue()) | zzh.zzg(zzg.zza((zzao) list.get(1)).zzd().doubleValue()))));
                break;
            case 8:
                zzah = new zzah(Double.valueOf((double) (zzh.zzg(zzg.zza((zzao) ba.i(zzbk.BITWISE_RIGHT_SHIFT, 2, list, 0)).zzd().doubleValue()) >> ((int) (zzh.zzh(zzg.zza((zzao) list.get(1)).zzd().doubleValue()) & 31)))));
                break;
            case 9:
                zzah = new zzah(Double.valueOf((double) (zzh.zzh(zzg.zza((zzao) ba.i(zzbk.BITWISE_UNSIGNED_RIGHT_SHIFT, 2, list, 0)).zzd().doubleValue()) >>> ((int) (zzh.zzh(zzg.zza((zzao) list.get(1)).zzd().doubleValue()) & 31)))));
                break;
            case 10:
                zzah = new zzah(Double.valueOf((double) (zzh.zzg(zzg.zza((zzao) ba.i(zzbk.BITWISE_XOR, 2, list, 0)).zzd().doubleValue()) ^ zzh.zzg(zzg.zza((zzao) list.get(1)).zzd().doubleValue()))));
                break;
            default:
                return zzb(str);
        }
        return zzah;
    }
}
