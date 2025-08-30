package com.google.android.gms.internal.measurement;

import java.io.IOException;

class zzlf extends zzle {
    protected final byte[] zza;

    public zzlf(byte[] bArr) {
        super((byte[]) null);
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzlg) || zzc() != ((zzlg) obj).zzc()) {
            return false;
        }
        if (zzc() == 0) {
            return true;
        }
        if (!(obj instanceof zzlf)) {
            return obj.equals(this);
        }
        zzlf zzlf = (zzlf) obj;
        int zzi = zzi();
        int zzi2 = zzlf.zzi();
        if (zzi != 0 && zzi2 != 0 && zzi != zzi2) {
            return false;
        }
        int zzc = zzc();
        if (zzc > zzlf.zzc()) {
            int zzc2 = zzc();
            StringBuilder sb = new StringBuilder(String.valueOf(zzc).length() + 18 + String.valueOf(zzc2).length());
            sb.append("Length too large: ");
            sb.append(zzc);
            sb.append(zzc2);
            throw new IllegalArgumentException(sb.toString());
        } else if (zzc <= zzlf.zzc()) {
            byte[] bArr = this.zza;
            byte[] bArr2 = zzlf.zza;
            zzlf.zzd();
            int i = 0;
            int i2 = 0;
            while (i < zzc) {
                if (bArr[i] != bArr2[i2]) {
                    return false;
                }
                i++;
                i2++;
            }
            return true;
        } else {
            int zzc3 = zzlf.zzc();
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzc).length() + 27 + String.valueOf(zzc3).length());
            sb2.append("Ran off end of other: 0, ");
            sb2.append(zzc);
            sb2.append(", ");
            sb2.append(zzc3);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public byte zza(int i) {
        return this.zza[i];
    }

    public byte zzb(int i) {
        return this.zza[i];
    }

    public int zzc() {
        return this.zza.length;
    }

    public int zzd() {
        return 0;
    }

    public final zzlg zze(int i, int i2) {
        int zzj = zzlg.zzj(0, i2, zzc());
        if (zzj == 0) {
            return zzlg.zzb;
        }
        return new zzlb(this.zza, 0, zzj);
    }

    public final void zzf(zzky zzky) throws IOException {
        ((zzlj) zzky).zzv(this.zza, 0, zzc());
    }

    public final int zzg(int i, int i2, int i3) {
        return zzmo.zzc(i, this.zza, 0, i3);
    }
}
