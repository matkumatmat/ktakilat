package com.google.android.gms.internal.auth;

final class zzdz extends zzec {
    private final int zzc;

    public zzdz(byte[] bArr, int i, int i2) {
        super(bArr);
        zzef.zzi(0, i2, bArr.length);
        this.zzc = i2;
    }

    public final byte zza(int i) {
        int i2 = this.zzc;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.zza[i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(ba.k(i, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(e.h(i, "Index > length: ", ", ", i2));
    }

    public final byte zzb(int i) {
        return this.zza[i];
    }

    public final int zzc() {
        return 0;
    }

    public final int zzd() {
        return this.zzc;
    }
}
