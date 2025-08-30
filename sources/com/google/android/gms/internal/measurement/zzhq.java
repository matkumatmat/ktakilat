package com.google.android.gms.internal.measurement;

public final class zzhq extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzhq zzf;
    private int zzb;
    private int zzd;
    private long zze;

    static {
        zzhq zzhq = new zzhq();
        zzf = zzhq;
        zzme.zzcp(zzhq.class, zzhq);
    }

    private zzhq() {
    }

    public static zzhp zze() {
        return (zzhp) zzf.zzck();
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final boolean zzc() {
        return (this.zzb & 2) != 0;
    }

    public final long zzd() {
        return this.zze;
    }

    public final /* synthetic */ void zzf(int i) {
        this.zzb |= 1;
        this.zzd = i;
    }

    public final /* synthetic */ void zzg(long j) {
        this.zzb |= 2;
        this.zze = j;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzb", "zzd", "zze"});
        } else if (i2 == 3) {
            return new zzhq();
        } else {
            if (i2 == 4) {
                return new zzhp((byte[]) null);
            }
            if (i2 == 5) {
                return zzf;
            }
            throw null;
        }
    }
}
