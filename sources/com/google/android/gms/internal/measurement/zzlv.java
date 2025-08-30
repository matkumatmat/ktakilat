package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzlv {
    private static final zzlv zzd = new zzlv(true);
    final zzod zza = new zznz();
    private boolean zzb;
    private boolean zzc;

    private zzlv() {
    }

    public static zzlv zza() {
        return zzd;
    }

    public static void zzf(zzll zzll, zzos zzos, int i, Object obj) throws IOException {
        if (zzos != zzos.GROUP) {
            zzll.zza(i, zzos.zzb());
            zzot zzot = zzot.INT;
            switch (zzos.ordinal()) {
                case 0:
                    zzll.zzu(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                    return;
                case 1:
                    zzll.zzs(Float.floatToRawIntBits(((Float) obj).floatValue()));
                    return;
                case 2:
                    zzll.zzt(((Long) obj).longValue());
                    return;
                case 3:
                    zzll.zzt(((Long) obj).longValue());
                    return;
                case 4:
                    zzll.zzq(((Integer) obj).intValue());
                    return;
                case 5:
                    zzll.zzu(((Long) obj).longValue());
                    return;
                case 6:
                    zzll.zzs(((Integer) obj).intValue());
                    return;
                case 7:
                    zzll.zzp(((Boolean) obj).booleanValue() ? (byte) 1 : 0);
                    return;
                case 8:
                    if (obj instanceof zzlg) {
                        zzll.zzj((zzlg) obj);
                        return;
                    } else {
                        zzll.zzx((String) obj);
                        return;
                    }
                case 9:
                    ((zznl) obj).zzcB(zzll);
                    return;
                case 10:
                    zzll.zzo((zznl) obj);
                    return;
                case 11:
                    if (obj instanceof zzlg) {
                        zzll.zzj((zzlg) obj);
                        return;
                    }
                    byte[] bArr = (byte[]) obj;
                    zzll.zzk(bArr, 0, bArr.length);
                    return;
                case 12:
                    zzll.zzr(((Integer) obj).intValue());
                    return;
                case 13:
                    if (obj instanceof zzmi) {
                        zzll.zzq(((zzmi) obj).zza());
                        return;
                    } else {
                        zzll.zzq(((Integer) obj).intValue());
                        return;
                    }
                case 14:
                    zzll.zzs(((Integer) obj).intValue());
                    return;
                case 15:
                    zzll.zzu(((Long) obj).longValue());
                    return;
                case 16:
                    int intValue = ((Integer) obj).intValue();
                    zzll.zzr((intValue >> 31) ^ (intValue + intValue));
                    return;
                case 17:
                    long longValue = ((Long) obj).longValue();
                    zzll.zzt((longValue >> 63) ^ (longValue + longValue));
                    return;
                default:
                    return;
            }
        } else {
            zznl zznl = (zznl) obj;
            zzmo.zzd(zznl);
            zzll.zza(i, 3);
            zznl.zzcB(zzll);
            zzll.zza(i, 4);
        }
    }

    public static int zzh(zzos zzos, int i, Object obj) {
        int zzz = zzll.zzz(i << 3);
        if (zzos == zzos.GROUP) {
            zzmo.zzd((zznl) obj);
            zzz += zzz;
        }
        return zzz + zzi(zzos, obj);
    }

    public static int zzi(zzos zzos, Object obj) {
        int zzc2;
        int zzz;
        zzos zzos2 = zzos.DOUBLE;
        zzot zzot = zzot.INT;
        switch (zzos.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                int i = zzll.zzb;
                return 8;
            case 1:
                ((Float) obj).getClass();
                int i2 = zzll.zzb;
                return 4;
            case 2:
                return zzll.zzA(((Long) obj).longValue());
            case 3:
                return zzll.zzA(((Long) obj).longValue());
            case 4:
                return zzll.zzA((long) ((Integer) obj).intValue());
            case 5:
                ((Long) obj).getClass();
                int i3 = zzll.zzb;
                return 8;
            case 6:
                ((Integer) obj).getClass();
                int i4 = zzll.zzb;
                return 4;
            case 7:
                ((Boolean) obj).getClass();
                int i5 = zzll.zzb;
                return 1;
            case 8:
                if (obj instanceof zzlg) {
                    int i6 = zzll.zzb;
                    zzc2 = ((zzlg) obj).zzc();
                    zzz = zzll.zzz(zzc2);
                    break;
                } else {
                    return zzll.zzB((String) obj);
                }
            case 9:
                return ((zznl) obj).zzcn();
            case 10:
                if (obj instanceof zzmu) {
                    int i7 = zzll.zzb;
                    zzc2 = ((zzmu) obj).zzb();
                    zzz = zzll.zzz(zzc2);
                    break;
                } else {
                    return zzll.zzC((zznl) obj);
                }
            case 11:
                if (!(obj instanceof zzlg)) {
                    int i8 = zzll.zzb;
                    zzc2 = ((byte[]) obj).length;
                    zzz = zzll.zzz(zzc2);
                    break;
                } else {
                    int i9 = zzll.zzb;
                    zzc2 = ((zzlg) obj).zzc();
                    zzz = zzll.zzz(zzc2);
                    break;
                }
            case 12:
                return zzll.zzz(((Integer) obj).intValue());
            case 13:
                if (obj instanceof zzmi) {
                    return zzll.zzA((long) ((zzmi) obj).zza());
                }
                return zzll.zzA((long) ((Integer) obj).intValue());
            case 14:
                ((Integer) obj).getClass();
                int i10 = zzll.zzb;
                return 4;
            case 15:
                ((Long) obj).getClass();
                int i11 = zzll.zzb;
                return 8;
            case 16:
                int intValue = ((Integer) obj).intValue();
                return zzll.zzz((intValue >> 31) ^ (intValue + intValue));
            case 17:
                long longValue = ((Long) obj).longValue();
                return zzll.zzA((longValue >> 63) ^ (longValue + longValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return zzz + zzc2;
    }

    public static int zzj(zzlu zzlu, Object obj) {
        zzos zzb2 = zzlu.zzb();
        int zza2 = zzlu.zza();
        if (!zzlu.zzd()) {
            return zzh(zzb2, zza2, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i = 0;
        if (!zzlu.zze()) {
            int i2 = 0;
            while (i < size) {
                i2 += zzh(zzb2, zza2, list.get(i));
                i++;
            }
            return i2;
        } else if (list.isEmpty()) {
            return 0;
        } else {
            int i3 = 0;
            while (i < size) {
                i3 += zzi(zzb2, list.get(i));
                i++;
            }
            return zzll.zzz(i3) + zzll.zzz(zza2 << 3) + i3;
        }
    }

    private static boolean zzk(Map.Entry entry) {
        zzlu zzlu = (zzlu) entry.getKey();
        if (zzlu.zzc() != zzot.MESSAGE) {
            return true;
        }
        if (!zzlu.zzd()) {
            return zzl(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!zzl(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzl(Object obj) {
        if (obj instanceof zznm) {
            return ((zznm) obj).zzcD();
        }
        if (obj instanceof zzmu) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzm(Map.Entry entry) {
        int i;
        int zzz;
        int zzC;
        zzlu zzlu = (zzlu) entry.getKey();
        Object value = entry.getValue();
        if (zzlu.zzc() != zzot.MESSAGE || zzlu.zzd() || zzlu.zze()) {
            return zzj(zzlu, value);
        }
        if (value instanceof zzmu) {
            int zza2 = ((zzlu) entry.getKey()).zza();
            int zzz2 = zzll.zzz(8);
            i = zzz2 + zzz2;
            zzz = zzll.zzz(zza2) + zzll.zzz(16);
            int zzz3 = zzll.zzz(24);
            int zzb2 = ((zzmu) value).zzb();
            zzC = ba.c(zzb2, zzb2, zzz3);
        } else {
            int zza3 = ((zzlu) entry.getKey()).zza();
            int zzz4 = zzll.zzz(8);
            i = zzz4 + zzz4;
            zzz = zzll.zzz(zza3) + zzll.zzz(16);
            zzC = zzll.zzC((zznl) value) + zzll.zzz(24);
        }
        return i + zzz + zzC;
    }

    private static final void zzn(zzlu zzlu, Object obj) {
        boolean z;
        zzos zzb2 = zzlu.zzb();
        byte[] bArr = zzmo.zzb;
        obj.getClass();
        zzos zzos = zzos.DOUBLE;
        zzot zzot = zzot.INT;
        switch (zzb2.zza().ordinal()) {
            case 0:
                z = obj instanceof Integer;
                break;
            case 1:
                z = obj instanceof Long;
                break;
            case 2:
                z = obj instanceof Float;
                break;
            case 3:
                z = obj instanceof Double;
                break;
            case 4:
                z = obj instanceof Boolean;
                break;
            case 5:
                z = obj instanceof String;
                break;
            case 6:
                if ((obj instanceof zzlg) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzmi)) {
                    return;
                }
            case 8:
                if ((obj instanceof zznl) || (obj instanceof zzmu)) {
                    return;
                }
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzlu.zza()), zzlu.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzlv zzlv = new zzlv();
        zzod zzod = this.zza;
        int zzc2 = zzod.zzc();
        for (int i = 0; i < zzc2; i++) {
            Map.Entry zzd2 = zzod.zzd(i);
            zzlv.zzd((zzlu) ((zzoa) zzd2).zza(), zzd2.getValue());
        }
        for (Map.Entry entry : zzod.zze()) {
            zzlv.zzd((zzlu) entry.getKey(), entry.getValue());
        }
        zzlv.zzc = this.zzc;
        return zzlv;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzlv)) {
            return false;
        }
        return this.zza.equals(((zzlv) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzb) {
            zzod zzod = this.zza;
            int zzc2 = zzod.zzc();
            for (int i = 0; i < zzc2; i++) {
                Object value = zzod.zzd(i).getValue();
                if (value instanceof zzme) {
                    ((zzme) value).zzcj();
                }
            }
            for (Map.Entry value2 : zzod.zze()) {
                Object value3 = value2.getValue();
                if (value3 instanceof zzme) {
                    ((zzme) value3).zzcj();
                }
            }
            zzod.zza();
            this.zzb = true;
        }
    }

    public final Iterator zzc() {
        zzod zzod = this.zza;
        if (zzod.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzc) {
            return new zzmt(zzod.entrySet().iterator());
        }
        return zzod.entrySet().iterator();
    }

    public final void zzd(zzlu zzlu, Object obj) {
        if (!zzlu.zzd()) {
            zzn(zzlu, obj);
        } else if (obj instanceof List) {
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzn(zzlu, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzmu) {
            this.zzc = true;
        }
        this.zza.put(zzlu, obj);
    }

    public final boolean zze() {
        zzod zzod = this.zza;
        int zzc2 = zzod.zzc();
        for (int i = 0; i < zzc2; i++) {
            if (!zzk(zzod.zzd(i))) {
                return false;
            }
        }
        for (Map.Entry zzk : zzod.zze()) {
            if (!zzk(zzk)) {
                return false;
            }
        }
        return true;
    }

    public final int zzg() {
        zzod zzod = this.zza;
        int zzc2 = zzod.zzc();
        int i = 0;
        for (int i2 = 0; i2 < zzc2; i2++) {
            i += zzm(zzod.zzd(i2));
        }
        for (Map.Entry zzm : zzod.zze()) {
            i += zzm(zzm);
        }
        return i;
    }

    private zzlv(boolean z) {
        zzb();
        zzb();
    }
}
