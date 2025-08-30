package com.google.android.gms.internal.measurement;

public final class zzgt extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzgt zzf;
    private int zzb;
    private String zzd = "";
    private String zze = "";

    static {
        zzgt zzgt = new zzgt();
        zzf = zzgt;
        zzme.zzcp(zzgt.class, zzgt);
    }

    private zzgt() {
    }

    public final String zza() {
        return this.zzd;
    }

    public final String zzb() {
        return this.zze;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzb", "zzd", "zze"});
        } else if (i2 == 3) {
            return new zzgt();
        } else {
            if (i2 == 4) {
                return new zzgs((byte[]) null);
            }
            if (i2 == 5) {
                return zzf;
            }
            throw null;
        }
    }
}
