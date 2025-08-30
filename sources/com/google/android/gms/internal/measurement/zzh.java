package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzh {
    public static void zza(String str, int i, List list) {
        if (list.size() != i) {
            int size = list.size();
            throw new IllegalArgumentException(str + " operation requires " + i + " parameters found " + size);
        }
    }

    public static void zzb(String str, int i, List list) {
        if (list.size() < i) {
            int size = list.size();
            throw new IllegalArgumentException(str + " operation requires at least " + i + " parameters found " + size);
        }
    }

    public static void zzc(String str, int i, List list) {
        if (list.size() > i) {
            int size = list.size();
            throw new IllegalArgumentException(str + " operation requires at most " + i + " parameters found " + size);
        }
    }

    public static boolean zzd(zzao zzao) {
        if (zzao == null) {
            return false;
        }
        Double zzd = zzao.zzd();
        if (zzd.isNaN() || zzd.doubleValue() < 0.0d || !zzd.equals(Double.valueOf(Math.floor(zzd.doubleValue())))) {
            return false;
        }
        return true;
    }

    public static zzbk zze(String str) {
        zzbk zzbk = null;
        if (str != null && !str.isEmpty()) {
            zzbk = zzbk.zza(Integer.parseInt(str));
        }
        if (zzbk != null) {
            return zzbk;
        }
        throw new IllegalArgumentException(e.B("Unsupported commandId ", str));
    }

    public static boolean zzf(zzao zzao, zzao zzao2) {
        if (!zzao.getClass().equals(zzao2.getClass())) {
            return false;
        }
        if ((zzao instanceof zzat) || (zzao instanceof zzam)) {
            return true;
        }
        if (zzao instanceof zzah) {
            if (Double.isNaN(zzao.zzd().doubleValue()) || Double.isNaN(zzao2.zzd().doubleValue())) {
                return false;
            }
            return zzao.zzd().equals(zzao2.zzd());
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
    }

    public static int zzg(double d) {
        int i;
        int i2;
        if (Double.isNaN(d) || Double.isInfinite(d) || d == 0.0d) {
            return 0;
        }
        if (i > 0) {
            i2 = 1;
        } else {
            i2 = -1;
        }
        return (int) ((long) ((((double) i2) * Math.floor(Math.abs(d))) % 4.294967296E9d));
    }

    public static long zzh(double d) {
        return ((long) zzg(d)) & 4294967295L;
    }

    public static double zzi(double d) {
        int i;
        int i2;
        if (Double.isNaN(d)) {
            return 0.0d;
        }
        if (Double.isInfinite(d) || d == 0.0d || i == 0) {
            return d;
        }
        if (i > 0) {
            i2 = 1;
        } else {
            i2 = -1;
        }
        return ((double) i2) * Math.floor(Math.abs(d));
    }

    public static Object zzj(zzao zzao) {
        if (zzao.zzg.equals(zzao)) {
            return null;
        }
        if (zzao.zzf.equals(zzao)) {
            return "";
        }
        if (zzao instanceof zzal) {
            return zzk((zzal) zzao);
        }
        if (zzao instanceof zzae) {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((zzae) zzao).iterator();
            while (it.hasNext()) {
                Object zzj = zzj((zzao) it.next());
                if (zzj != null) {
                    arrayList.add(zzj);
                }
            }
            return arrayList;
        } else if (!zzao.zzd().isNaN()) {
            return zzao.zzd();
        } else {
            return zzao.zzc();
        }
    }

    public static Map zzk(zzal zzal) {
        HashMap hashMap = new HashMap();
        for (String str : zzal.zzb()) {
            Object zzj = zzj(zzal.zzk(str));
            if (zzj != null) {
                hashMap.put(str, zzj);
            }
        }
        return hashMap;
    }

    public static int zzl(zzg zzg) {
        int zzg2 = zzg(zzg.zzh("runtime.counter").zzd().doubleValue() + 1.0d);
        if (zzg2 <= 1000000) {
            zzg.zze("runtime.counter", new zzah(Double.valueOf((double) zzg2)));
            return zzg2;
        }
        throw new IllegalStateException("Instructions allowed exceeded");
    }
}
