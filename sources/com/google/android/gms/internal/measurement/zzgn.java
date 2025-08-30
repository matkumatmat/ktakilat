package com.google.android.gms.internal.measurement;

public final class zzgn extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzgn zzd;
    private zzmn zzb = zzme.zzcv();

    static {
        zzgn zzgn = new zzgn();
        zzd = zzgn;
        zzme.zzcp(zzgn.class, zzgn);
    }

    private zzgn() {
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new zzgn();
        } else {
            if (i2 == 4) {
                return new zzgm((byte[]) null);
            }
            if (i2 == 5) {
                return zzd;
            }
            throw null;
        }
    }
}
