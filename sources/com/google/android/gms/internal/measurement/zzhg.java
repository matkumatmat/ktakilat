package com.google.android.gms.internal.measurement;

public final class zzhg extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzhg zzh;
    private int zzb;
    private int zzd;
    private zzii zze;
    private zzii zzf;
    private boolean zzg;

    static {
        zzhg zzhg = new zzhg();
        zzh = zzhg;
        zzme.zzcp(zzhg.class, zzhg);
    }

    private zzhg() {
    }

    public static zzhf zzh() {
        return (zzhf) zzh.zzck();
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final zzii zzc() {
        zzii zzii = this.zze;
        if (zzii == null) {
            return zzii.zzj();
        }
        return zzii;
    }

    public final boolean zzd() {
        return (this.zzb & 4) != 0;
    }

    public final zzii zze() {
        zzii zzii = this.zzf;
        if (zzii == null) {
            return zzii.zzj();
        }
        return zzii;
    }

    public final boolean zzf() {
        return (this.zzb & 8) != 0;
    }

    public final boolean zzg() {
        return this.zzg;
    }

    public final /* synthetic */ void zzi(int i) {
        this.zzb |= 1;
        this.zzd = i;
    }

    public final /* synthetic */ void zzj(zzii zzii) {
        zzii.getClass();
        this.zze = zzii;
        this.zzb |= 2;
    }

    public final /* synthetic */ void zzk(zzii zzii) {
        this.zzf = zzii;
        this.zzb |= 4;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzhg();
        } else {
            if (i2 == 4) {
                return new zzhf((byte[]) null);
            }
            if (i2 == 5) {
                return zzh;
            }
            throw null;
        }
    }

    public final /* synthetic */ void zzm(boolean z) {
        this.zzb |= 8;
        this.zzg = z;
    }
}
