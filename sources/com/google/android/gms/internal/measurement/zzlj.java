package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Locale;

final class zzlj extends zzll {
    private final byte[] zzc;
    private final int zzd;
    private int zze;

    public zzlj(byte[] bArr, int i, int i2) {
        super((byte[]) null);
        int length = bArr.length;
        if (((length - i2) | i2) >= 0) {
            this.zzc = bArr;
            this.zze = 0;
            this.zzd = i2;
            return;
        }
        Locale locale = Locale.US;
        throw new IllegalArgumentException(e.h(length, "Array range is invalid. Buffer.length=", ", offset=0, length=", i2));
    }

    public final void zza(int i, int i2) throws IOException {
        zzr((i << 3) | i2);
    }

    public final void zzb(int i, int i2) throws IOException {
        zzr(i << 3);
        zzq(i2);
    }

    public final void zzc(int i, int i2) throws IOException {
        zzr(i << 3);
        zzr(i2);
    }

    public final void zzd(int i, int i2) throws IOException {
        zzr((i << 3) | 5);
        zzs(i2);
    }

    public final void zze(int i, long j) throws IOException {
        zzr(i << 3);
        zzt(j);
    }

    public final void zzf(int i, long j) throws IOException {
        zzr((i << 3) | 1);
        zzu(j);
    }

    public final void zzg(int i, boolean z) throws IOException {
        zzr(i << 3);
        zzp(z ? (byte) 1 : 0);
    }

    public final void zzh(int i, String str) throws IOException {
        zzr((i << 3) | 2);
        zzx(str);
    }

    public final void zzi(int i, zzlg zzlg) throws IOException {
        zzr((i << 3) | 2);
        zzj(zzlg);
    }

    public final void zzj(zzlg zzlg) throws IOException {
        zzr(zzlg.zzc());
        zzlg.zzf(this);
    }

    public final void zzk(byte[] bArr, int i, int i2) throws IOException {
        zzr(i2);
        zzv(bArr, 0, i2);
    }

    public final void zzl(int i, zznl zznl, zznw zznw) throws IOException {
        zzr((i << 3) | 2);
        zzr(((zzkr) zznl).zzcd(zznw));
        zznw.zzf(zznl, this.zza);
    }

    public final void zzm(int i, zznl zznl) throws IOException {
        zzr(11);
        zzc(2, i);
        zzr(26);
        zzo(zznl);
        zzr(12);
    }

    public final void zzn(int i, zzlg zzlg) throws IOException {
        zzr(11);
        zzc(2, i);
        zzi(3, zzlg);
        zzr(12);
    }

    public final void zzo(zznl zznl) throws IOException {
        zzr(zznl.zzcn());
        zznl.zzcB(this);
    }

    public final void zzp(byte b) throws IOException {
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i = this.zze;
        try {
            int i2 = i + 1;
            try {
                this.zzc[i] = b;
                this.zze = i2;
            } catch (IndexOutOfBoundsException e) {
                indexOutOfBoundsException = e;
                i = i2;
                throw new zzlk((long) i, (long) this.zzd, 1, indexOutOfBoundsException);
            }
        } catch (IndexOutOfBoundsException e2) {
            indexOutOfBoundsException = e2;
            throw new zzlk((long) i, (long) this.zzd, 1, indexOutOfBoundsException);
        }
    }

    public final void zzq(int i) throws IOException {
        if (i >= 0) {
            zzr(i);
        } else {
            zzt((long) i);
        }
    }

    public final void zzr(int i) throws IOException {
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i2;
        int i3 = this.zze;
        while ((i & -128) != 0) {
            i2 = i3 + 1;
            this.zzc[i3] = (byte) (i | 128);
            i >>>= 7;
            i3 = i2;
        }
        try {
            i2 = i3 + 1;
            try {
                this.zzc[i3] = (byte) i;
                this.zze = i2;
            } catch (IndexOutOfBoundsException e) {
                indexOutOfBoundsException = e;
                i3 = i2;
                throw new zzlk((long) i3, (long) this.zzd, 1, indexOutOfBoundsException);
            }
        } catch (IndexOutOfBoundsException e2) {
            indexOutOfBoundsException = e2;
            throw new zzlk((long) i3, (long) this.zzd, 1, indexOutOfBoundsException);
        }
    }

    public final void zzs(int i) throws IOException {
        int i2 = this.zze;
        try {
            byte[] bArr = this.zzc;
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >> 8);
            bArr[i2 + 2] = (byte) (i >> 16);
            bArr[i2 + 3] = (byte) (i >> 24);
            this.zze = i2 + 4;
        } catch (IndexOutOfBoundsException e) {
            throw new zzlk((long) i2, (long) this.zzd, 4, e);
        }
    }

    public final void zzt(long j) throws IOException {
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i;
        boolean zzH = zzll.zzd;
        int i2 = this.zze;
        if (!zzH || this.zzd - i2 < 10) {
            while ((j & -128) != 0) {
                int i3 = i2 + 1;
                try {
                    this.zzc[i2] = (byte) (((int) j) | 128);
                    j >>>= 7;
                    i2 = i3;
                } catch (IndexOutOfBoundsException e) {
                    indexOutOfBoundsException = e;
                    i2 = i3;
                    throw new zzlk((long) i2, (long) this.zzd, 1, indexOutOfBoundsException);
                }
            }
            try {
                i = i2 + 1;
            } catch (IndexOutOfBoundsException e2) {
                indexOutOfBoundsException = e2;
                throw new zzlk((long) i2, (long) this.zzd, 1, indexOutOfBoundsException);
            }
            try {
                this.zzc[i2] = (byte) ((int) j);
            } catch (IndexOutOfBoundsException e3) {
                indexOutOfBoundsException = e3;
                i2 = i;
                throw new zzlk((long) i2, (long) this.zzd, 1, indexOutOfBoundsException);
            }
        } else {
            while ((j & -128) != 0) {
                zzoo.zzp(this.zzc, (long) i2, (byte) (((int) j) | 128));
                j >>>= 7;
                i2++;
            }
            i = i2 + 1;
            zzoo.zzp(this.zzc, (long) i2, (byte) ((int) j));
        }
        this.zze = i;
    }

    public final void zzu(long j) throws IOException {
        int i = this.zze;
        try {
            byte[] bArr = this.zzc;
            bArr[i] = (byte) ((int) j);
            bArr[i + 1] = (byte) ((int) (j >> 8));
            bArr[i + 2] = (byte) ((int) (j >> 16));
            bArr[i + 3] = (byte) ((int) (j >> 24));
            bArr[i + 4] = (byte) ((int) (j >> 32));
            bArr[i + 5] = (byte) ((int) (j >> 40));
            bArr[i + 6] = (byte) ((int) (j >> 48));
            bArr[i + 7] = (byte) ((int) (j >> 56));
            this.zze = i + 8;
        } catch (IndexOutOfBoundsException e) {
            throw new zzlk((long) i, (long) this.zzd, 8, e);
        }
    }

    public final void zzv(byte[] bArr, int i, int i2) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zzc, this.zze, i2);
            this.zze += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new zzlk((long) this.zze, (long) this.zzd, i2, e);
        }
    }

    public final void zzw(byte[] bArr, int i, int i2) throws IOException {
        zzv(bArr, 0, i2);
    }

    public final void zzx(String str) throws IOException {
        int i = this.zze;
        try {
            int zzz = zzll.zzz(str.length() * 3);
            int zzz2 = zzll.zzz(str.length());
            if (zzz2 == zzz) {
                int i2 = i + zzz2;
                this.zze = i2;
                int zzc2 = zzor.zzc(str, this.zzc, i2, this.zzd - i2);
                this.zze = i;
                zzr((zzc2 - i) - zzz2);
                this.zze = zzc2;
                return;
            }
            zzr(zzor.zzb(str));
            byte[] bArr = this.zzc;
            int i3 = this.zze;
            this.zze = zzor.zzc(str, bArr, i3, this.zzd - i3);
        } catch (zzoq e) {
            this.zze = i;
            zzF(str, e);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzlk(e2);
        }
    }

    public final int zzy() {
        return this.zzd - this.zze;
    }
}
