package com.google.android.gms.internal.measurement;

public final class zzfh extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzfh zzh;
    private int zzb;
    private zzfr zzd;
    private zzfl zze;
    private boolean zzf;
    private String zzg = "";

    static {
        zzfh zzfh = new zzfh();
        zzh = zzfh;
        zzme.zzcp(zzfh.class, zzfh);
    }

    private zzfh() {
    }

    public static zzfh zzi() {
        return zzh;
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final zzfr zzb() {
        zzfr zzfr = this.zzd;
        if (zzfr == null) {
            return zzfr.zzh();
        }
        return zzfr;
    }

    public final boolean zzc() {
        return (this.zzb & 2) != 0;
    }

    public final zzfl zzd() {
        zzfl zzfl = this.zze;
        if (zzfl == null) {
            return zzfl.zzj();
        }
        return zzfl;
    }

    public final boolean zze() {
        return (this.zzb & 4) != 0;
    }

    public final boolean zzf() {
        return this.zzf;
    }

    public final boolean zzg() {
        return (this.zzb & 8) != 0;
    }

    public final String zzh() {
        return this.zzg;
    }

    public final /* synthetic */ void zzj(String str) {
        this.zzb |= 8;
        this.zzg = str;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzfh();
        } else {
            if (i2 == 4) {
                return new zzfg((byte[]) null);
            }
            if (i2 == 5) {
                return zzh;
            }
            throw null;
        }
    }
}
