package com.google.android.gms.internal.measurement;

public final class zzgp extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzgp zzg;
    private int zzb;
    private int zzd = 14;
    private int zze = 11;
    private int zzf = 60;

    static {
        zzgp zzgp = new zzgp();
        zzg = zzgp;
        zzme.zzcp(zzgp.class, zzgp);
    }

    private zzgp() {
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzb", "zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzgp();
        } else {
            if (i2 == 4) {
                return new zzgo((byte[]) null);
            }
            if (i2 == 5) {
                return zzg;
            }
            throw null;
        }
    }
}
