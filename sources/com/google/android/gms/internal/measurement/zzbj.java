package com.google.android.gms.internal.measurement;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Iterator;
import java.util.List;

public final class zzbj extends zzav {
    public zzbj() {
        this.zza.add(zzbk.ASSIGN);
        this.zza.add(zzbk.CONST);
        this.zza.add(zzbk.CREATE_ARRAY);
        this.zza.add(zzbk.CREATE_OBJECT);
        this.zza.add(zzbk.EXPRESSION_LIST);
        this.zza.add(zzbk.GET);
        this.zza.add(zzbk.GET_INDEX);
        this.zza.add(zzbk.GET_PROPERTY);
        this.zza.add(zzbk.NULL);
        this.zza.add(zzbk.SET_PROPERTY);
        this.zza.add(zzbk.TYPEOF);
        this.zza.add(zzbk.UNDEFINED);
        this.zza.add(zzbk.VAR);
    }

    public final zzao zza(String str, zzg zzg, List list) {
        zzao zza;
        zzao zza2;
        String str2;
        int i = 0;
        zzbk zzbk = zzbk.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal == 3) {
            zzao zza3 = zzg.zza((zzao) ba.i(zzbk.ASSIGN, 2, list, 0));
            if (!(zza3 instanceof zzas)) {
                throw new IllegalArgumentException(e.B("Expected string for assign var. got ", zza3.getClass().getCanonicalName()));
            } else if (zzg.zzd(zza3.zzc())) {
                zza = zzg.zza((zzao) list.get(1));
                zzg.zze(zza3.zzc(), zza);
            } else {
                throw new IllegalArgumentException(e.B("Attempting to assign undefined value ", zza3.zzc()));
            }
        } else if (ordinal == 14) {
            zzh.zzb(zzbk.CONST.name(), 2, list);
            if (list.size() % 2 == 0) {
                while (i < list.size() - 1) {
                    zzao zza4 = zzg.zza((zzao) list.get(i));
                    if (zza4 instanceof zzas) {
                        zzg.zzg(zza4.zzc(), zzg.zza((zzao) list.get(i + 1)));
                        i += 2;
                    } else {
                        throw new IllegalArgumentException(e.B("Expected string for const name. got ", zza4.getClass().getCanonicalName()));
                    }
                }
                return zzao.zzf;
            }
            throw new IllegalArgumentException(ba.k(list.size(), "CONST requires an even number of arguments, found "));
        } else if (ordinal == 24) {
            zzh.zzb(zzbk.EXPRESSION_LIST.name(), 1, list);
            zzao zzao = zzao.zzf;
            while (i < list.size()) {
                zzao = zzg.zza((zzao) list.get(i));
                if (!(zzao instanceof zzag)) {
                    i++;
                } else {
                    throw new IllegalStateException("ControlValue cannot be in an expression list");
                }
            }
            return zzao;
        } else if (ordinal == 33) {
            zzao zza5 = zzg.zza((zzao) ba.i(zzbk.GET, 1, list, 0));
            if (zza5 instanceof zzas) {
                return zzg.zzh(zza5.zzc());
            }
            throw new IllegalArgumentException(e.B("Expected string for get var. got ", zza5.getClass().getCanonicalName()));
        } else if (ordinal != 49) {
            if (ordinal == 58) {
                zzao zza6 = zzg.zza((zzao) ba.i(zzbk.SET_PROPERTY, 3, list, 0));
                zzao zza7 = zzg.zza((zzao) list.get(1));
                zza2 = zzg.zza((zzao) list.get(2));
                if (zza6 == zzao.zzf || zza6 == zzao.zzg) {
                    throw new IllegalStateException(e.n("Can't set property ", zza7.zzc(), " of ", zza6.zzc()));
                } else if ((zza6 instanceof zzae) && (zza7 instanceof zzah)) {
                    ((zzae) zza6).zzn(zza7.zzd().intValue(), zza2);
                } else if (zza6 instanceof zzak) {
                    ((zzak) zza6).zzm(zza7.zzc(), zza2);
                    return zza2;
                }
            } else if (ordinal != 17) {
                if (ordinal != 18) {
                    if (ordinal == 35 || ordinal == 36) {
                        zzao zza8 = zzg.zza((zzao) ba.i(zzbk.GET_PROPERTY, 2, list, 0));
                        zzao zza9 = zzg.zza((zzao) list.get(1));
                        if ((zza8 instanceof zzae) && zzh.zzd(zza9)) {
                            return ((zzae) zza8).zzl(zza9.zzd().intValue());
                        }
                        if (zza8 instanceof zzak) {
                            return ((zzak) zza8).zzk(zza9.zzc());
                        }
                        if (zza8 instanceof zzas) {
                            if ("length".equals(zza9.zzc())) {
                                zza2 = new zzah(Double.valueOf((double) zza8.zzc().length()));
                            } else if (zzh.zzd(zza9) && zza9.zzd().doubleValue() < ((double) zza8.zzc().length())) {
                                zza = new zzas(String.valueOf(zza8.zzc().charAt(zza9.zzd().intValue())));
                            }
                        }
                        return zzao.zzf;
                    }
                    switch (ordinal) {
                        case 62:
                            zzao zza10 = zzg.zza((zzao) ba.i(zzbk.TYPEOF, 1, list, 0));
                            if (zza10 instanceof zzat) {
                                str2 = "undefined";
                            } else if (zza10 instanceof zzaf) {
                                str2 = TypedValues.Custom.S_BOOLEAN;
                            } else if (zza10 instanceof zzah) {
                                str2 = "number";
                            } else if (zza10 instanceof zzas) {
                                str2 = TypedValues.Custom.S_STRING;
                            } else if (zza10 instanceof zzan) {
                                str2 = "function";
                            } else if ((zza10 instanceof zzap) || (zza10 instanceof zzag)) {
                                throw new IllegalArgumentException(String.format("Unsupported value type %s in typeof", new Object[]{zza10}));
                            } else {
                                str2 = "object";
                            }
                            zza2 = new zzas(str2);
                            break;
                        case 63:
                            zzh.zza(zzbk.UNDEFINED.name(), 0, list);
                            return zzao.zzf;
                        case 64:
                            zzh.zzb(zzbk.VAR.name(), 1, list);
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                zzao zza11 = zzg.zza((zzao) it.next());
                                if (zza11 instanceof zzas) {
                                    zzg.zzf(zza11.zzc(), zzao.zzf);
                                } else {
                                    throw new IllegalArgumentException(e.B("Expected string for var name. got ", zza11.getClass().getCanonicalName()));
                                }
                            }
                            return zzao.zzf;
                        default:
                            return zzb(str);
                    }
                } else if (list.isEmpty()) {
                    return new zzal();
                } else {
                    if (list.size() % 2 == 0) {
                        zzal zzal = new zzal();
                        while (i < list.size() - 1) {
                            zzao zza12 = zzg.zza((zzao) list.get(i));
                            zzao zza13 = zzg.zza((zzao) list.get(i + 1));
                            if ((zza12 instanceof zzag) || (zza13 instanceof zzag)) {
                                throw new IllegalStateException("Failed to evaluate map entry");
                            }
                            zzal.zzm(zza12.zzc(), zza13);
                            i += 2;
                        }
                        return zzal;
                    }
                    throw new IllegalArgumentException(ba.k(list.size(), "CREATE_OBJECT requires an even number of arguments, found "));
                }
            } else if (list.isEmpty()) {
                return new zzae();
            } else {
                zzae zzae = new zzae();
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    zzao zza14 = zzg.zza((zzao) it2.next());
                    if (!(zza14 instanceof zzag)) {
                        zzae.zzn(i, zza14);
                        i++;
                    } else {
                        throw new IllegalStateException("Failed to evaluate array element");
                    }
                }
                return zzae;
            }
            return zza2;
        } else {
            zzh.zza(zzbk.NULL.name(), 0, list);
            return zzao.zzg;
        }
        return zza;
    }
}
