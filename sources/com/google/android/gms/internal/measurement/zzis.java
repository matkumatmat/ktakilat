package com.google.android.gms.internal.measurement;

public final class zzis extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzis zzg;
    private int zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzis zzis = new zzis();
        zzg = zzis;
        zzme.zzcp(zzis.class, zzis);
    }

    private zzis() {
    }

    public static zzil zzb() {
        return (zzil) zzg.zzck();
    }

    public static zzis zzc() {
        return zzg;
    }

    public final zzin zza() {
        zzin zzb2 = zzin.zzb(this.zze);
        return zzb2 == null ? zzin.CLIENT_UPLOAD_ELIGIBILITY_UNKNOWN : zzb2;
    }

    public final /* synthetic */ void zzd(zzin zzin) {
        this.zze = zzin.zza();
        this.zzb |= 2;
    }

    public final int zzf() {
        int zza = zzir.zza(this.zzd);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzg() {
        int zza = zzip.zza(this.zzf);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final /* synthetic */ void zzh(int i) {
        this.zzd = i - 1;
        this.zzb |= 1;
    }

    public final /* synthetic */ void zzi(int i) {
        this.zzf = i - 1;
        this.zzb |= 4;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzb", "zzd", zziq.zza, "zze", zzim.zza, "zzf", zzio.zza});
        } else if (i2 == 3) {
            return new zzis();
        } else {
            if (i2 == 4) {
                return new zzil((byte[]) null);
            }
            if (i2 == 5) {
                return zzg;
            }
            throw null;
        }
    }
}
