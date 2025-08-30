package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

public final class zzoi {
    private static final zzoi zza = new zzoi(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzoi(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzoi zza() {
        return zza;
    }

    public static zzoi zzb() {
        return new zzoi(0, new int[8], new Object[8], true);
    }

    public static zzoi zzc(zzoi zzoi, zzoi zzoi2) {
        int i = zzoi.zzb + zzoi2.zzb;
        int[] copyOf = Arrays.copyOf(zzoi.zzc, i);
        System.arraycopy(zzoi2.zzc, 0, copyOf, zzoi.zzb, zzoi2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzoi.zzd, i);
        System.arraycopy(zzoi2.zzd, 0, copyOf2, zzoi.zzb, zzoi2.zzb);
        return new zzoi(i, copyOf, copyOf2, true);
    }

    private final void zzm(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = (i2 / 2) + i2;
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzoi)) {
            return false;
        }
        zzoi zzoi = (zzoi) obj;
        int i = this.zzb;
        if (i == zzoi.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzoi.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzoi.zzd;
                    int i3 = this.zzb;
                    int i4 = 0;
                    while (i4 < i3) {
                        if (objArr[i4].equals(objArr2[i4])) {
                            i4++;
                        }
                    }
                    return true;
                } else if (iArr[i2] != iArr2[i2]) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = ((i2 * 31) + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final void zzd() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    public final void zze() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzf(zzou zzou) throws IOException {
        for (int i = 0; i < this.zzb; i++) {
            zzou.zzv(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzg(zzou zzou) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzou.zzc(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzou.zzj(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzou.zzn(i4, (zzlg) obj);
                } else if (i3 == 3) {
                    zzou.zzt(i4);
                    ((zzoi) obj).zzg(zzou);
                    zzou.zzu(i4);
                } else if (i3 == 5) {
                    zzou.zzk(i4, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(new zzmp("Protocol message tag had invalid wire type."));
                }
            }
        }
    }

    public final int zzh() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int zzz = zzll.zzz(8);
            int zzz2 = zzll.zzz(this.zzc[i3] >>> 3) + zzll.zzz(16);
            int zzz3 = zzll.zzz(24);
            int zzc2 = ((zzlg) this.zzd[i3]).zzc();
            i2 += zzz + zzz + zzz2 + ba.c(zzc2, zzc2, zzz3);
        }
        this.zze = i2;
        return i2;
    }

    public final int zzi() {
        int zzz;
        int zzA;
        int zzz2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.zzd[i3]).getClass();
                    zzz2 = zzll.zzz(i5 << 3) + 8;
                } else if (i6 == 2) {
                    int zzz3 = zzll.zzz(i5 << 3);
                    int zzc2 = ((zzlg) this.zzd[i3]).zzc();
                    i2 = zzll.zzz(zzc2) + zzc2 + zzz3 + i2;
                } else if (i6 == 3) {
                    int zzz4 = zzll.zzz(i5 << 3);
                    zzz = zzz4 + zzz4;
                    zzA = ((zzoi) this.zzd[i3]).zzi();
                } else if (i6 == 5) {
                    ((Integer) this.zzd[i3]).getClass();
                    zzz2 = zzll.zzz(i5 << 3) + 4;
                } else {
                    throw new IllegalStateException(new zzmp("Protocol message tag had invalid wire type."));
                }
                i2 = zzz2 + i2;
            } else {
                int i7 = i5 << 3;
                long longValue = ((Long) this.zzd[i3]).longValue();
                zzz = zzll.zzz(i7);
                zzA = zzll.zzA(longValue);
            }
            i2 = zzA + zzz + i2;
        }
        this.zze = i2;
        return i2;
    }

    public final void zzj(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zznn.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    public final void zzk(int i, Object obj) {
        zze();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    public final zzoi zzl(zzoi zzoi) {
        if (zzoi.equals(zza)) {
            return this;
        }
        zze();
        int i = this.zzb + zzoi.zzb;
        zzm(i);
        System.arraycopy(zzoi.zzc, 0, this.zzc, this.zzb, zzoi.zzb);
        System.arraycopy(zzoi.zzd, 0, this.zzd, this.zzb, zzoi.zzb);
        this.zzb = i;
        return this;
    }

    private zzoi() {
        this(0, new int[8], new Object[8], true);
    }
}
