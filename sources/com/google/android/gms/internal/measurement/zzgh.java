package com.google.android.gms.internal.measurement;

public final class zzgh extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzgh zzg;
    private int zzb;
    private String zzd = "";
    private zzmn zze = zzme.zzcv();
    private boolean zzf;

    static {
        zzgh zzgh = new zzgh();
        zzg = zzgh;
        zzme.zzcp(zzgh.class, zzgh);
    }

    private zzgh() {
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
            return zzme.zzcq(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zzb", "zzd", "zze", zzgr.class, "zzf"});
        } else if (i2 == 3) {
            return new zzgh();
        } else {
            if (i2 == 4) {
                return new zzgg((byte[]) null);
            }
            if (i2 == 5) {
                return zzg;
            }
            throw null;
        }
    }
}
