package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

public final class zzay extends zzav {
    public zzay() {
        this.zza.add(zzbk.APPLY);
        this.zza.add(zzbk.BLOCK);
        this.zza.add(zzbk.BREAK);
        this.zza.add(zzbk.CASE);
        this.zza.add(zzbk.DEFAULT);
        this.zza.add(zzbk.CONTINUE);
        this.zza.add(zzbk.DEFINE_FUNCTION);
        this.zza.add(zzbk.FN);
        this.zza.add(zzbk.IF);
        this.zza.add(zzbk.QUOTE);
        this.zza.add(zzbk.RETURN);
        this.zza.add(zzbk.SWITCH);
        this.zza.add(zzbk.TERNARY);
    }

    private static zzao zzc(zzg zzg, List list) {
        zzh.zzb(zzbk.FN.name(), 2, list);
        zzao zza = zzg.zza((zzao) list.get(0));
        zzao zza2 = zzg.zza((zzao) list.get(1));
        if (zza2 instanceof zzae) {
            List zzb = ((zzae) zza2).zzb();
            List arrayList = new ArrayList();
            if (list.size() > 2) {
                arrayList = list.subList(2, list.size());
            }
            return new zzan(zza.zzc(), zzb, arrayList, zzg);
        }
        throw new IllegalArgumentException(e.B("FN requires an ArrayValue of parameter names found ", zza2.getClass().getCanonicalName()));
    }

    public final zzao zza(String str, zzg zzg, List list) {
        zzao zzao;
        zzao zzao2;
        zzbk zzbk = zzbk.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal == 2) {
            zzao zza = zzg.zza((zzao) ba.i(zzbk.APPLY, 3, list, 0));
            String zzc = zzg.zza((zzao) list.get(1)).zzc();
            zzao zza2 = zzg.zza((zzao) list.get(2));
            if (!(zza2 instanceof zzae)) {
                throw new IllegalArgumentException(e.B("Function arguments for Apply are not a list found ", zza2.getClass().getCanonicalName()));
            } else if (!zzc.isEmpty()) {
                return zza.zzcA(zzc, zzg, ((zzae) zza2).zzb());
            } else {
                throw new IllegalArgumentException("Function name for apply is undefined");
            }
        } else if (ordinal == 15) {
            zzh.zza(zzbk.BREAK.name(), 0, list);
            return zzao.zzh;
        } else if (ordinal == 25) {
            return zzc(zzg, list);
        } else {
            if (ordinal == 41) {
                zzh.zzb(zzbk.IF.name(), 2, list);
                zzao zza3 = zzg.zza((zzao) list.get(0));
                zzao zza4 = zzg.zza((zzao) list.get(1));
                if (list.size() > 2) {
                    zzao = zzg.zza((zzao) list.get(2));
                } else {
                    zzao = null;
                }
                zzao zzao3 = zzao.zzf;
                if (zza3.zze().booleanValue()) {
                    zzao2 = zzg.zzb((zzae) zza4);
                } else if (zzao != null) {
                    zzao2 = zzg.zzb((zzae) zzao);
                } else {
                    zzao2 = zzao3;
                }
                if (true != (zzao2 instanceof zzag)) {
                    return zzao3;
                }
                return zzao2;
            } else if (ordinal == 54) {
                return new zzae(list);
            } else {
                if (ordinal != 57) {
                    if (ordinal != 19) {
                        if (ordinal == 20) {
                            zzh.zzb(zzbk.DEFINE_FUNCTION.name(), 2, list);
                            zzan zzan = (zzan) zzc(zzg, list);
                            if (zzan.zzg() == null) {
                                zzg.zze("", zzan);
                                return zzan;
                            }
                            zzg.zze(zzan.zzg(), zzan);
                            return zzan;
                        } else if (ordinal == 60) {
                            zzao zza5 = zzg.zza((zzao) ba.i(zzbk.SWITCH, 3, list, 0));
                            zzao zza6 = zzg.zza((zzao) list.get(1));
                            zzao zza7 = zzg.zza((zzao) list.get(2));
                            if (!(zza6 instanceof zzae)) {
                                throw new IllegalArgumentException("Malformed SWITCH statement, cases are not a list");
                            } else if (zza7 instanceof zzae) {
                                zzae zzae = (zzae) zza6;
                                zzae zzae2 = (zzae) zza7;
                                boolean z = false;
                                for (int i = 0; i < zzae.zzh(); i++) {
                                    if (z || zza5.equals(zzg.zza(zzae.zzl(i)))) {
                                        zzao zza8 = zzg.zza(zzae2.zzl(i));
                                        if (!(zza8 instanceof zzag)) {
                                            z = true;
                                        } else if (((zzag) zza8).zzg().equals("break")) {
                                            return zzao.zzf;
                                        } else {
                                            return zza8;
                                        }
                                    } else {
                                        z = false;
                                    }
                                }
                                if (zzae.zzh() + 1 == zzae2.zzh()) {
                                    zzao zza9 = zzg.zza(zzae2.zzl(zzae.zzh()));
                                    if (zza9 instanceof zzag) {
                                        String zzg2 = ((zzag) zza9).zzg();
                                        if (zzg2.equals("return") || zzg2.equals("continue")) {
                                            return zza9;
                                        }
                                    }
                                }
                                return zzao.zzf;
                            } else {
                                throw new IllegalArgumentException("Malformed SWITCH statement, case statements are not a list");
                            }
                        } else if (ordinal != 61) {
                            switch (ordinal) {
                                case 11:
                                    return zzg.zzc().zzb(new zzae(list));
                                case 12:
                                    zzh.zza(zzbk.BREAK.name(), 0, list);
                                    return zzao.zzi;
                                case 13:
                                    break;
                                default:
                                    return zzb(str);
                            }
                        } else if (zzg.zza((zzao) ba.i(zzbk.TERNARY, 3, list, 0)).zze().booleanValue()) {
                            return zzg.zza((zzao) list.get(1));
                        } else {
                            return zzg.zza((zzao) list.get(2));
                        }
                    }
                    if (list.isEmpty()) {
                        return zzao.zzf;
                    }
                    zzao zza10 = zzg.zza((zzao) list.get(0));
                    if (zza10 instanceof zzae) {
                        return zzg.zzb((zzae) zza10);
                    }
                    return zzao.zzf;
                } else if (list.isEmpty()) {
                    return zzao.zzj;
                } else {
                    return new zzag("return", zzg.zza((zzao) ba.i(zzbk.RETURN, 1, list, 0)));
                }
            }
        }
    }
}
