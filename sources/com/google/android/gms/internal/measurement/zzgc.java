package com.google.android.gms.internal.measurement;

public final class zzgc extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzgc zzf;
    private int zzb;
    private String zzd = "";
    private String zze = "";

    static {
        zzgc zzgc = new zzgc();
        zzf = zzgc;
        zzme.zzcp(zzgc.class, zzgc);
    }

    private zzgc() {
    }

    public final String zza() {
        return this.zzd;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzb", "zzd", "zze"});
        } else if (i2 == 3) {
            return new zzgc();
        } else {
            if (i2 == 4) {
                return new zzgb((byte[]) null);
            }
            if (i2 == 5) {
                return zzf;
            }
            throw null;
        }
    }
}
