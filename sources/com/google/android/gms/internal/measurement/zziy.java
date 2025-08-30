package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zziy extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zziy zzf;
    private int zzb;
    private String zzd = "";
    private zzmn zze = zzme.zzcv();

    static {
        zziy zziy = new zziy();
        zzf = zziy;
        zzme.zzcp(zziy.class, zziy);
    }

    private zziy() {
    }

    public final String zza() {
        return this.zzd;
    }

    public final List zzb() {
        return this.zze;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzb", "zzd", "zze", zzje.class});
        } else if (i2 == 3) {
            return new zziy();
        } else {
            if (i2 == 4) {
                return new zzix((byte[]) null);
            }
            if (i2 == 5) {
                return zzf;
            }
            throw null;
        }
    }
}
