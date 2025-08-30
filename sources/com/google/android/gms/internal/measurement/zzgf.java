package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgf extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzgf zzi;
    private int zzb;
    private zzmn zzd = zzme.zzcv();
    private zzmn zze = zzme.zzcv();
    private zzmn zzf = zzme.zzcv();
    private boolean zzg;
    private zzmn zzh = zzme.zzcv();

    static {
        zzgf zzgf = new zzgf();
        zzi = zzgf;
        zzme.zzcp(zzgf.class, zzgf);
    }

    private zzgf() {
    }

    public static zzgf zzg() {
        return zzi;
    }

    public final List zza() {
        return this.zzd;
    }

    public final List zzb() {
        return this.zze;
    }

    public final List zzc() {
        return this.zzf;
    }

    public final boolean zzd() {
        return (this.zzb & 1) != 0;
    }

    public final boolean zze() {
        return this.zzg;
    }

    public final List zzf() {
        return this.zzh;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            Class<zzfu> cls = zzfu.class;
            return zzme.zzcq(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဇ\u0000\u0005\u001b", new Object[]{"zzb", "zzd", cls, "zze", zzfw.class, "zzf", zzgc.class, "zzg", "zzh", cls});
        } else if (i2 == 3) {
            return new zzgf();
        } else {
            if (i2 == 4) {
                return new zzfs((byte[]) null);
            }
            if (i2 == 5) {
                return zzi;
            }
            throw null;
        }
    }
}
