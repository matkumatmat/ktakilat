package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzja extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzja zzf;
    private int zzb;
    private zzmn zzd = zzme.zzcv();
    private zziw zze;

    static {
        zzja zzja = new zzja();
        zzf = zzja;
        zzme.zzcp(zzja.class, zzja);
    }

    private zzja() {
    }

    public final List zza() {
        return this.zzd;
    }

    public final zziw zzb() {
        zziw zziw = this.zze;
        if (zziw == null) {
            return zziw.zzc();
        }
        return zziw;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzb", "zzd", zzje.class, "zze"});
        } else if (i2 == 3) {
            return new zzja();
        } else {
            if (i2 == 4) {
                return new zziz((byte[]) null);
            }
            if (i2 == 5) {
                return zzf;
            }
            throw null;
        }
    }
}
