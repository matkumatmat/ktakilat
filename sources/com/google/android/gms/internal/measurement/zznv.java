package com.google.android.gms.internal.measurement;

final class zznv implements zzni {
    private final zznl zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    public zznv(zznl zznl, String str, Object[] objArr) {
        this.zza = zznl;
        this.zzb = str;
        this.zzc = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.zzd = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 1;
        int i2 = 13;
        while (true) {
            int i3 = i + 1;
            char charAt2 = str.charAt(i);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i2;
                i2 += 13;
                i = i3;
            } else {
                this.zzd = c | (charAt2 << i2);
                return;
            }
        }
    }

    public final boolean zza() {
        return (this.zzd & 2) == 2;
    }

    public final zznl zzb() {
        return this.zza;
    }

    public final int zzc() {
        int i = this.zzd;
        if ((i & 1) != 0) {
            return 1;
        }
        return (i & 4) == 4 ? 3 : 2;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final Object[] zze() {
        return this.zzc;
    }
}
