package com.google.android.gms.internal.measurement;

final class zzlh extends zzli {
    private int zzb = 0;
    private int zzc;
    private int zzd = Integer.MAX_VALUE;

    public /* synthetic */ zzlh(byte[] bArr, int i, int i2, boolean z, byte[] bArr2) {
        super((byte[]) null);
    }

    public final int zza(int i) throws zzmq {
        int i2 = this.zzd;
        this.zzd = 0;
        int i3 = this.zzb + this.zzc;
        this.zzb = i3;
        if (i3 > 0) {
            this.zzc = i3;
            this.zzb = 0;
        } else {
            this.zzc = 0;
        }
        return i2;
    }
}
