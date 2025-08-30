package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zziw extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zziw zzd;
    private zzmn zzb = zzme.zzcv();

    static {
        zziw zziw = new zziw();
        zzd = zziw;
        zzme.zzcp(zziw.class, zziw);
    }

    private zziw() {
    }

    public static zziw zzc() {
        return zzd;
    }

    public final List zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzb.size();
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zziy.class});
        } else if (i2 == 3) {
            return new zziw();
        } else {
            if (i2 == 4) {
                return new zziv((byte[]) null);
            }
            if (i2 == 5) {
                return zzd;
            }
            throw null;
        }
    }
}
