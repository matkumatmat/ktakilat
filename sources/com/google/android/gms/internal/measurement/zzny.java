package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

final class zzny {
    public static final /* synthetic */ int zza = 0;
    private static final zzoh zzb = new zzoj();

    static {
        int i = zznt.zza;
    }

    public static zzoh zzA() {
        return zzb;
    }

    public static boolean zzB(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || !obj.equals(obj2)) {
            return false;
        }
        return true;
    }

    public static void zzC(zzlr zzlr, Object obj, Object obj2) {
        if (!((zzmb) obj2).zzb.zza.isEmpty()) {
            zzmb zzmb = (zzmb) obj;
            throw null;
        }
    }

    public static void zzD(zzoh zzoh, Object obj, Object obj2) {
        zzme zzme = (zzme) obj;
        zzoi zzoi = zzme.zzc;
        zzoi zzoi2 = ((zzme) obj2).zzc;
        if (!zzoi.zza().equals(zzoi2)) {
            if (zzoi.zza().equals(zzoi)) {
                zzoi = zzoi.zzc(zzoi, zzoi2);
            } else {
                zzoi.zzl(zzoi2);
            }
        }
        zzme.zzc = zzoi;
    }

    public static Object zzE(Object obj, int i, int i2, Object obj2, zzoh zzoh) {
        if (obj2 == null) {
            obj2 = zzoh.zza(obj);
        }
        ((zzoi) obj2).zzk(i << 3, Long.valueOf((long) i2));
        return obj2;
    }

    public static void zza(int i, List list, zzou zzou, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzou.zzC(i, list, z);
        }
    }

    public static void zzb(int i, List list, zzou zzou, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzou.zzB(i, list, z);
        }
    }

    public static void zzc(int i, List list, zzou zzou, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzou.zzy(i, list, z);
        }
    }

    public static void zzd(int i, List list, zzou zzou, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzou.zzz(i, list, z);
        }
    }

    public static void zze(int i, List list, zzou zzou, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzou.zzL(i, list, z);
        }
    }

    public static void zzf(int i, List list, zzou zzou, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzou.zzA(i, list, z);
        }
    }

    public static void zzg(int i, List list, zzou zzou, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzou.zzJ(i, list, z);
        }
    }

    public static void zzh(int i, List list, zzou zzou, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzou.zzw(i, list, z);
        }
    }

    public static void zzi(int i, List list, zzou zzou, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzou.zzH(i, list, z);
        }
    }

    public static void zzj(int i, List list, zzou zzou, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzou.zzK(i, list, z);
        }
    }

    public static void zzk(int i, List list, zzou zzou, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzou.zzx(i, list, z);
        }
    }

    public static void zzl(int i, List list, zzou zzou, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzou.zzI(i, list, z);
        }
    }

    public static void zzm(int i, List list, zzou zzou, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzou.zzD(i, list, z);
        }
    }

    public static void zzn(int i, List list, zzou zzou, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzou.zzE(i, list, z);
        }
    }

    public static int zzo(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzmz) {
            zzmz zzmz = (zzmz) list;
            i = 0;
            while (i2 < size) {
                i += zzll.zzA(zzmz.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzll.zzA(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzp(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzmz) {
            zzmz zzmz = (zzmz) list;
            i = 0;
            while (i2 < size) {
                i += zzll.zzA(zzmz.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzll.zzA(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzq(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzmz) {
            zzmz zzmz = (zzmz) list;
            i = 0;
            while (i2 < size) {
                long zzc = zzmz.zzc(i2);
                i += zzll.zzA((zzc >> 63) ^ (zzc + zzc));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i3 = i + zzll.zzA((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    public static int zzr(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzmf) {
            zzmf zzmf = (zzmf) list;
            i = 0;
            while (i2 < size) {
                i += zzll.zzA((long) zzmf.zzf(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzll.zzA((long) ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzs(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzmf) {
            zzmf zzmf = (zzmf) list;
            i = 0;
            while (i2 < size) {
                i += zzll.zzA((long) zzmf.zzf(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzll.zzA((long) ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzt(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzmf) {
            zzmf zzmf = (zzmf) list;
            i = 0;
            while (i2 < size) {
                i += zzll.zzz(zzmf.zzf(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzll.zzz(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzu(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzmf) {
            zzmf zzmf = (zzmf) list;
            i = 0;
            while (i2 < size) {
                int zzf = zzmf.zzf(i2);
                i += zzll.zzz((zzf >> 31) ^ (zzf + zzf));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i3 = i + zzll.zzz((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    public static int zzv(List list) {
        return list.size() * 4;
    }

    public static int zzw(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzll.zzz(i << 3) + 4) * size;
    }

    public static int zzx(List list) {
        return list.size() * 8;
    }

    public static int zzy(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzll.zzz(i << 3) + 8) * size;
    }

    public static int zzz(int i, Object obj, zznw zznw) {
        int i2 = i << 3;
        if (obj instanceof zzmv) {
            int zzz = zzll.zzz(i2);
            int zzb2 = ((zzmv) obj).zzb();
            return ba.c(zzb2, zzb2, zzz);
        }
        return zzll.zzD((zznl) obj, zznw) + zzll.zzz(i2);
    }
}
