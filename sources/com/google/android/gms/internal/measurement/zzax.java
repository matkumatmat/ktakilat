package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzax extends zzav {
    public zzax() {
        this.zza.add(zzbk.EQUALS);
        this.zza.add(zzbk.GREATER_THAN);
        this.zza.add(zzbk.GREATER_THAN_EQUALS);
        this.zza.add(zzbk.IDENTITY_EQUALS);
        this.zza.add(zzbk.IDENTITY_NOT_EQUALS);
        this.zza.add(zzbk.LESS_THAN);
        this.zza.add(zzbk.LESS_THAN_EQUALS);
        this.zza.add(zzbk.NOT_EQUALS);
    }

    private static boolean zzc(zzao zzao, zzao zzao2) {
        int i;
        if (zzao instanceof zzak) {
            zzao = new zzas(zzao.zzc());
        }
        if (zzao2 instanceof zzak) {
            zzao2 = new zzas(zzao2.zzc());
        }
        if (!(zzao instanceof zzas) || !(zzao2 instanceof zzas)) {
            double doubleValue = zzao.zzd().doubleValue();
            double doubleValue2 = zzao2.zzd().doubleValue();
            if (Double.isNaN(doubleValue) || Double.isNaN(doubleValue2) || ((doubleValue == 0.0d && doubleValue2 == 0.0d) || ((i == 0 && doubleValue2 == 0.0d) || Double.compare(doubleValue, doubleValue2) >= 0))) {
                return false;
            }
            return true;
        } else if (zzao.zzc().compareTo(zzao2.zzc()) < 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean zzd(zzao zzao, zzao zzao2) {
        if (zzao.getClass().equals(zzao2.getClass())) {
            if ((zzao instanceof zzat) || (zzao instanceof zzam)) {
                return true;
            }
            if (zzao instanceof zzah) {
                if (Double.isNaN(zzao.zzd().doubleValue()) || Double.isNaN(zzao2.zzd().doubleValue()) || zzao.zzd().doubleValue() != zzao2.zzd().doubleValue()) {
                    return false;
                }
                return true;
            } else if (zzao instanceof zzas) {
                return zzao.zzc().equals(zzao2.zzc());
            } else {
                if (zzao instanceof zzaf) {
                    return zzao.zze().equals(zzao2.zze());
                }
                if (zzao == zzao2) {
                    return true;
                }
                return false;
            }
        } else if (((zzao instanceof zzat) || (zzao instanceof zzam)) && ((zzao2 instanceof zzat) || (zzao2 instanceof zzam))) {
            return true;
        } else {
            boolean z = zzao instanceof zzah;
            if (z && (zzao2 instanceof zzas)) {
                return zzd(zzao, new zzah(zzao2.zzd()));
            }
            boolean z2 = zzao instanceof zzas;
            if (z2 && (zzao2 instanceof zzah)) {
                return zzd(new zzah(zzao.zzd()), zzao2);
            }
            if (zzao instanceof zzaf) {
                return zzd(new zzah(zzao.zzd()), zzao2);
            }
            if (zzao2 instanceof zzaf) {
                return zzd(zzao, new zzah(zzao2.zzd()));
            }
            if ((z2 || z) && (zzao2 instanceof zzak)) {
                return zzd(zzao, new zzas(zzao2.zzc()));
            }
            if (!(zzao instanceof zzak) || (!(zzao2 instanceof zzas) && !(zzao2 instanceof zzah))) {
                return false;
            }
            return zzd(new zzas(zzao.zzc()), zzao2);
        }
    }

    private static boolean zze(zzao zzao, zzao zzao2) {
        if (zzao instanceof zzak) {
            zzao = new zzas(zzao.zzc());
        }
        if (zzao2 instanceof zzak) {
            zzao2 = new zzas(zzao2.zzc());
        }
        if (((!(zzao instanceof zzas) || !(zzao2 instanceof zzas)) && (Double.isNaN(zzao.zzd().doubleValue()) || Double.isNaN(zzao2.zzd().doubleValue()))) || zzc(zzao2, zzao)) {
            return false;
        }
        return true;
    }

    public final zzao zza(String str, zzg zzg, List list) {
        boolean z;
        boolean zzd;
        zzh.zza(zzh.zze(str).name(), 2, list);
        zzao zza = zzg.zza((zzao) list.get(0));
        zzao zza2 = zzg.zza((zzao) list.get(1));
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal != 23) {
            if (ordinal == 48) {
                zzd = zzd(zza, zza2);
            } else if (ordinal == 42) {
                z = zzc(zza, zza2);
            } else if (ordinal != 43) {
                switch (ordinal) {
                    case 37:
                        z = zzc(zza2, zza);
                        break;
                    case 38:
                        z = zze(zza2, zza);
                        break;
                    case 39:
                        z = zzh.zzf(zza, zza2);
                        break;
                    case 40:
                        zzd = zzh.zzf(zza, zza2);
                        break;
                    default:
                        return zzb(str);
                }
            } else {
                z = zze(zza, zza2);
            }
            z = !zzd;
        } else {
            z = zzd(zza, zza2);
        }
        if (z) {
            return zzao.zzk;
        }
        return zzao.zzl;
    }
}
