package com.google.android.gms.internal.measurement;

public final class zzgv extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzgv zzi;
    private int zzb;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";
    private int zzg;
    private String zzh = "";

    static {
        zzgv zzgv = new zzgv();
        zzi = zzgv;
        zzme.zzcp(zzgv.class, zzgv);
    }

    private zzgv() {
    }

    public static zzgv zze() {
        return zzi;
    }

    public final String zza() {
        return this.zzd;
    }

    public final String zzb() {
        return this.zze;
    }

    public final int zzc() {
        return this.zzg;
    }

    public final String zzd() {
        return this.zzh;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003\u0005ဈ\u0004", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzgv();
        } else {
            if (i2 == 4) {
                return new zzgu((byte[]) null);
            }
            if (i2 == 5) {
                return zzi;
            }
            throw null;
        }
    }
}
