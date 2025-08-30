package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzlm implements zzou {
    private final zzll zza;

    private zzlm(zzll zzll) {
        byte[] bArr = zzmo.zzb;
        this.zza = zzll;
        zzll.zza = this;
    }

    public static zzlm zza(zzll zzll) {
        zzlm zzlm = zzll.zza;
        if (zzlm != null) {
            return zzlm;
        }
        return new zzlm(zzll);
    }

    public final void zzA(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzmz) {
            zzmz zzmz = (zzmz) list;
            if (z) {
                zzll zzll = this.zza;
                zzll.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzmz.size(); i4++) {
                    zzmz.zzc(i4);
                    i3 += 8;
                }
                zzll.zzr(i3);
                while (i2 < zzmz.size()) {
                    zzll.zzu(zzmz.zzc(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzmz.size()) {
                this.zza.zzf(i, zzmz.zzc(i2));
                i2++;
            }
        } else if (z) {
            zzll zzll2 = this.zza;
            zzll2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).getClass();
                i5 += 8;
            }
            zzll2.zzr(i5);
            while (i2 < list.size()) {
                zzll2.zzu(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzf(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public final void zzB(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzlx) {
            zzlx zzlx = (zzlx) list;
            if (z) {
                zzll zzll = this.zza;
                zzll.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzlx.size(); i4++) {
                    zzlx.zze(i4);
                    i3 += 4;
                }
                zzll.zzr(i3);
                while (i2 < zzlx.size()) {
                    zzll.zzs(Float.floatToRawIntBits(zzlx.zze(i2)));
                    i2++;
                }
                return;
            }
            while (i2 < zzlx.size()) {
                this.zza.zzd(i, Float.floatToRawIntBits(zzlx.zze(i2)));
                i2++;
            }
        } else if (z) {
            zzll zzll2 = this.zza;
            zzll2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Float) list.get(i6)).getClass();
                i5 += 4;
            }
            zzll2.zzr(i5);
            while (i2 < list.size()) {
                zzll2.zzs(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzd(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
        }
    }

    public final void zzC(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzln) {
            zzln zzln = (zzln) list;
            if (z) {
                zzll zzll = this.zza;
                zzll.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzln.size(); i4++) {
                    zzln.zze(i4);
                    i3 += 8;
                }
                zzll.zzr(i3);
                while (i2 < zzln.size()) {
                    zzll.zzu(Double.doubleToRawLongBits(zzln.zze(i2)));
                    i2++;
                }
                return;
            }
            while (i2 < zzln.size()) {
                this.zza.zzf(i, Double.doubleToRawLongBits(zzln.zze(i2)));
                i2++;
            }
        } else if (z) {
            zzll zzll2 = this.zza;
            zzll2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Double) list.get(i6)).getClass();
                i5 += 8;
            }
            zzll2.zzr(i5);
            while (i2 < list.size()) {
                zzll2.zzu(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzf(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
        }
    }

    public final void zzD(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzmf) {
            zzmf zzmf = (zzmf) list;
            if (z) {
                zzll zzll = this.zza;
                zzll.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzmf.size(); i4++) {
                    i3 += zzll.zzA((long) zzmf.zzf(i4));
                }
                zzll.zzr(i3);
                while (i2 < zzmf.size()) {
                    zzll.zzq(zzmf.zzf(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzmf.size()) {
                this.zza.zzb(i, zzmf.zzf(i2));
                i2++;
            }
        } else if (z) {
            zzll zzll2 = this.zza;
            zzll2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzll.zzA((long) ((Integer) list.get(i6)).intValue());
            }
            zzll2.zzr(i5);
            while (i2 < list.size()) {
                zzll2.zzq(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzb(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzE(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzkx) {
            zzkx zzkx = (zzkx) list;
            if (z) {
                zzll zzll = this.zza;
                zzll.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzkx.size(); i4++) {
                    zzkx.zze(i4);
                    i3++;
                }
                zzll.zzr(i3);
                while (i2 < zzkx.size()) {
                    zzll.zzp(zzkx.zze(i2) ? (byte) 1 : 0);
                    i2++;
                }
                return;
            }
            while (i2 < zzkx.size()) {
                this.zza.zzg(i, zzkx.zze(i2));
                i2++;
            }
        } else if (z) {
            zzll zzll2 = this.zza;
            zzll2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Boolean) list.get(i6)).getClass();
                i5++;
            }
            zzll2.zzr(i5);
            while (i2 < list.size()) {
                zzll2.zzp(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : 0);
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzg(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
        }
    }

    public final void zzF(int i, List list) throws IOException {
        int i2 = 0;
        if (list instanceof zzmw) {
            zzmw zzmw = (zzmw) list;
            while (i2 < list.size()) {
                Object zzc = zzmw.zzc();
                if (zzc instanceof String) {
                    this.zza.zzh(i, (String) zzc);
                } else {
                    this.zza.zzi(i, (zzlg) zzc);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzh(i, (String) list.get(i2));
            i2++;
        }
    }

    public final void zzG(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzi(i, (zzlg) list.get(i2));
        }
    }

    public final void zzH(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzmf) {
            zzmf zzmf = (zzmf) list;
            if (z) {
                zzll zzll = this.zza;
                zzll.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzmf.size(); i4++) {
                    i3 += zzll.zzz(zzmf.zzf(i4));
                }
                zzll.zzr(i3);
                while (i2 < zzmf.size()) {
                    zzll.zzr(zzmf.zzf(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzmf.size()) {
                this.zza.zzc(i, zzmf.zzf(i2));
                i2++;
            }
        } else if (z) {
            zzll zzll2 = this.zza;
            zzll2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzll.zzz(((Integer) list.get(i6)).intValue());
            }
            zzll2.zzr(i5);
            while (i2 < list.size()) {
                zzll2.zzr(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzc(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzI(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzmf) {
            zzmf zzmf = (zzmf) list;
            if (z) {
                zzll zzll = this.zza;
                zzll.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzmf.size(); i4++) {
                    zzmf.zzf(i4);
                    i3 += 4;
                }
                zzll.zzr(i3);
                while (i2 < zzmf.size()) {
                    zzll.zzs(zzmf.zzf(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzmf.size()) {
                this.zza.zzd(i, zzmf.zzf(i2));
                i2++;
            }
        } else if (z) {
            zzll zzll2 = this.zza;
            zzll2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).getClass();
                i5 += 4;
            }
            zzll2.zzr(i5);
            while (i2 < list.size()) {
                zzll2.zzs(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzd(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzJ(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzmz) {
            zzmz zzmz = (zzmz) list;
            if (z) {
                zzll zzll = this.zza;
                zzll.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzmz.size(); i4++) {
                    zzmz.zzc(i4);
                    i3 += 8;
                }
                zzll.zzr(i3);
                while (i2 < zzmz.size()) {
                    zzll.zzu(zzmz.zzc(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzmz.size()) {
                this.zza.zzf(i, zzmz.zzc(i2));
                i2++;
            }
        } else if (z) {
            zzll zzll2 = this.zza;
            zzll2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).getClass();
                i5 += 8;
            }
            zzll2.zzr(i5);
            while (i2 < list.size()) {
                zzll2.zzu(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzf(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public final void zzK(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzmf) {
            zzmf zzmf = (zzmf) list;
            if (z) {
                zzll zzll = this.zza;
                zzll.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzmf.size(); i4++) {
                    int zzf = zzmf.zzf(i4);
                    i3 += zzll.zzz((zzf >> 31) ^ (zzf + zzf));
                }
                zzll.zzr(i3);
                while (i2 < zzmf.size()) {
                    int zzf2 = zzmf.zzf(i2);
                    zzll.zzr((zzf2 >> 31) ^ (zzf2 + zzf2));
                    i2++;
                }
                return;
            }
            while (i2 < zzmf.size()) {
                zzll zzll2 = this.zza;
                int zzf3 = zzmf.zzf(i2);
                zzll2.zzc(i, (zzf3 >> 31) ^ (zzf3 + zzf3));
                i2++;
            }
        } else if (z) {
            zzll zzll3 = this.zza;
            zzll3.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                int intValue = ((Integer) list.get(i6)).intValue();
                i5 += zzll.zzz((intValue >> 31) ^ (intValue + intValue));
            }
            zzll3.zzr(i5);
            while (i2 < list.size()) {
                int intValue2 = ((Integer) list.get(i2)).intValue();
                zzll3.zzr((intValue2 >> 31) ^ (intValue2 + intValue2));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                zzll zzll4 = this.zza;
                int intValue3 = ((Integer) list.get(i2)).intValue();
                zzll4.zzc(i, (intValue3 >> 31) ^ (intValue3 + intValue3));
                i2++;
            }
        }
    }

    public final void zzL(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzmz) {
            zzmz zzmz = (zzmz) list;
            if (z) {
                zzll zzll = this.zza;
                zzll.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzmz.size(); i4++) {
                    long zzc = zzmz.zzc(i4);
                    i3 += zzll.zzA((zzc >> 63) ^ (zzc + zzc));
                }
                zzll.zzr(i3);
                while (i2 < zzmz.size()) {
                    long zzc2 = zzmz.zzc(i2);
                    zzll.zzt((zzc2 >> 63) ^ (zzc2 + zzc2));
                    i2++;
                }
                return;
            }
            while (i2 < zzmz.size()) {
                zzll zzll2 = this.zza;
                long zzc3 = zzmz.zzc(i2);
                zzll2.zze(i, (zzc3 >> 63) ^ (zzc3 + zzc3));
                i2++;
            }
        } else if (z) {
            zzll zzll3 = this.zza;
            zzll3.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                long longValue = ((Long) list.get(i6)).longValue();
                i5 += zzll.zzA((longValue >> 63) ^ (longValue + longValue));
            }
            zzll3.zzr(i5);
            while (i2 < list.size()) {
                long longValue2 = ((Long) list.get(i2)).longValue();
                zzll3.zzt((longValue2 >> 63) ^ (longValue2 + longValue2));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                zzll zzll4 = this.zza;
                long longValue3 = ((Long) list.get(i2)).longValue();
                zzll4.zze(i, (longValue3 >> 63) ^ (longValue3 + longValue3));
                i2++;
            }
        }
    }

    public final void zzM(int i, zznd zznd, Map map) throws IOException {
        for (Map.Entry entry : map.entrySet()) {
            zzll zzll = this.zza;
            zzll.zza(i, 2);
            zzll.zzr(zzne.zzc(zznd, entry.getKey(), entry.getValue()));
            zzne.zzb(zzll, zznd, entry.getKey(), entry.getValue());
        }
    }

    public final void zzb(int i, int i2) throws IOException {
        this.zza.zzd(i, i2);
    }

    public final void zzc(int i, long j) throws IOException {
        this.zza.zze(i, j);
    }

    public final void zzd(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    public final void zze(int i, float f) throws IOException {
        this.zza.zzd(i, Float.floatToRawIntBits(f));
    }

    public final void zzf(int i, double d) throws IOException {
        this.zza.zzf(i, Double.doubleToRawLongBits(d));
    }

    public final void zzg(int i, int i2) throws IOException {
        this.zza.zzb(i, i2);
    }

    public final void zzh(int i, long j) throws IOException {
        this.zza.zze(i, j);
    }

    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzb(i, i2);
    }

    public final void zzj(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzd(i, i2);
    }

    public final void zzl(int i, boolean z) throws IOException {
        this.zza.zzg(i, z);
    }

    public final void zzm(int i, String str) throws IOException {
        this.zza.zzh(i, str);
    }

    public final void zzn(int i, zzlg zzlg) throws IOException {
        this.zza.zzi(i, zzlg);
    }

    public final void zzo(int i, int i2) throws IOException {
        this.zza.zzc(i, i2);
    }

    public final void zzp(int i, int i2) throws IOException {
        this.zza.zzc(i, (i2 >> 31) ^ (i2 + i2));
    }

    public final void zzq(int i, long j) throws IOException {
        this.zza.zze(i, (j >> 63) ^ (j + j));
    }

    public final void zzr(int i, Object obj, zznw zznw) throws IOException {
        this.zza.zzl(i, (zznl) obj, zznw);
    }

    public final void zzs(int i, Object obj, zznw zznw) throws IOException {
        zzll zzll = this.zza;
        zzll.zza(i, 3);
        zznw.zzf((zznl) obj, zzll.zza);
        zzll.zza(i, 4);
    }

    @Deprecated
    public final void zzt(int i) throws IOException {
        this.zza.zza(i, 3);
    }

    @Deprecated
    public final void zzu(int i) throws IOException {
        this.zza.zza(i, 4);
    }

    public final void zzv(int i, Object obj) throws IOException {
        if (obj instanceof zzlg) {
            this.zza.zzn(i, (zzlg) obj);
        } else {
            this.zza.zzm(i, (zznl) obj);
        }
    }

    public final void zzw(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzmf) {
            zzmf zzmf = (zzmf) list;
            if (z) {
                zzll zzll = this.zza;
                zzll.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzmf.size(); i4++) {
                    i3 += zzll.zzA((long) zzmf.zzf(i4));
                }
                zzll.zzr(i3);
                while (i2 < zzmf.size()) {
                    zzll.zzq(zzmf.zzf(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzmf.size()) {
                this.zza.zzb(i, zzmf.zzf(i2));
                i2++;
            }
        } else if (z) {
            zzll zzll2 = this.zza;
            zzll2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzll.zzA((long) ((Integer) list.get(i6)).intValue());
            }
            zzll2.zzr(i5);
            while (i2 < list.size()) {
                zzll2.zzq(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzb(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzx(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzmf) {
            zzmf zzmf = (zzmf) list;
            if (z) {
                zzll zzll = this.zza;
                zzll.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzmf.size(); i4++) {
                    zzmf.zzf(i4);
                    i3 += 4;
                }
                zzll.zzr(i3);
                while (i2 < zzmf.size()) {
                    zzll.zzs(zzmf.zzf(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzmf.size()) {
                this.zza.zzd(i, zzmf.zzf(i2));
                i2++;
            }
        } else if (z) {
            zzll zzll2 = this.zza;
            zzll2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).getClass();
                i5 += 4;
            }
            zzll2.zzr(i5);
            while (i2 < list.size()) {
                zzll2.zzs(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzd(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzy(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzmz) {
            zzmz zzmz = (zzmz) list;
            if (z) {
                zzll zzll = this.zza;
                zzll.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzmz.size(); i4++) {
                    i3 += zzll.zzA(zzmz.zzc(i4));
                }
                zzll.zzr(i3);
                while (i2 < zzmz.size()) {
                    zzll.zzt(zzmz.zzc(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzmz.size()) {
                this.zza.zze(i, zzmz.zzc(i2));
                i2++;
            }
        } else if (z) {
            zzll zzll2 = this.zza;
            zzll2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzll.zzA(((Long) list.get(i6)).longValue());
            }
            zzll2.zzr(i5);
            while (i2 < list.size()) {
                zzll2.zzt(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zze(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public final void zzz(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzmz) {
            zzmz zzmz = (zzmz) list;
            if (z) {
                zzll zzll = this.zza;
                zzll.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzmz.size(); i4++) {
                    i3 += zzll.zzA(zzmz.zzc(i4));
                }
                zzll.zzr(i3);
                while (i2 < zzmz.size()) {
                    zzll.zzt(zzmz.zzc(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzmz.size()) {
                this.zza.zze(i, zzmz.zzc(i2));
                i2++;
            }
        } else if (z) {
            zzll zzll2 = this.zza;
            zzll2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzll.zzA(((Long) list.get(i6)).longValue());
            }
            zzll2.zzr(i5);
            while (i2 < list.size()) {
                zzll2.zzt(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zze(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }
}
