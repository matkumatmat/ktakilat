package com.google.android.gms.internal.measurement;

public final class zzhy extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzhy zzg;
    private int zzb;
    private String zzd = "";
    private String zze = "";
    private zzhc zzf;

    static {
        zzhy zzhy = new zzhy();
        zzg = zzhy;
        zzme.zzcp(zzhy.class, zzhy);
    }

    private zzhy() {
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zzb", "zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzhy();
        } else {
            if (i2 == 4) {
                return new zzhx((byte[]) null);
            }
            if (i2 == 5) {
                return zzg;
            }
            throw null;
        }
    }
}
