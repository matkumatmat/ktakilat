package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class zzi {
    public static zzao zza(Object obj) {
        if (obj == null) {
            return zzao.zzg;
        }
        if (obj instanceof String) {
            return new zzas((String) obj);
        }
        if (obj instanceof Double) {
            return new zzah((Double) obj);
        }
        if (obj instanceof Long) {
            return new zzah(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new zzah(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new zzaf((Boolean) obj);
        }
        if (obj instanceof Map) {
            zzal zzal = new zzal();
            Map map = (Map) obj;
            for (Object next : map.keySet()) {
                zzao zza = zza(map.get(next));
                if (next != null) {
                    if (!(next instanceof String)) {
                        next = next.toString();
                    }
                    zzal.zzm((String) next, zza);
                }
            }
            return zzal;
        } else if (obj instanceof List) {
            zzae zzae = new zzae();
            for (Object zza2 : (List) obj) {
                zzae.zzn(zzae.zzh(), zza(zza2));
            }
            return zzae;
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    public static zzao zzb(zzje zzje) {
        if (zzje == null) {
            return zzao.zzf;
        }
        int zzj = zzje.zzj() - 1;
        if (zzj != 1) {
            if (zzj != 2) {
                if (zzj != 3) {
                    if (zzj == 4) {
                        List<zzje> zza = zzje.zza();
                        ArrayList arrayList = new ArrayList();
                        for (zzje zzb : zza) {
                            arrayList.add(zzb(zzb));
                        }
                        return new zzap(zzje.zzb(), arrayList);
                    }
                    throw new IllegalArgumentException("Unknown type found. Cannot convert entity");
                } else if (zzje.zze()) {
                    return new zzaf(Boolean.valueOf(zzje.zzf()));
                } else {
                    return new zzaf((Boolean) null);
                }
            } else if (zzje.zzg()) {
                return new zzah(Double.valueOf(zzje.zzh()));
            } else {
                return new zzah((Double) null);
            }
        } else if (zzje.zzc()) {
            return new zzas(zzje.zzd());
        } else {
            return zzao.zzm;
        }
    }
}
