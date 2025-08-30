package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzik extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzik zzf;
    private int zzb;
    private int zzd;
    private zzmm zze = zzme.zzct();

    static {
        zzik zzik = new zzik();
        zzf = zzik;
        zzme.zzcp(zzik.class, zzik);
    }

    private zzik() {
    }

    public static zzij zzf() {
        return (zzij) zzf.zzck();
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final List zzc() {
        return this.zze;
    }

    public final int zzd() {
        return this.zze.size();
    }

    public final long zze(int i) {
        return this.zze.zzc(i);
    }

    public final /* synthetic */ void zzg(int i) {
        this.zzb |= 1;
        this.zzd = i;
    }

    public final /* synthetic */ void zzh(Iterable iterable) {
        zzmm zzmm = this.zze;
        if (!zzmm.zza()) {
            this.zze = zzme.zzcu(zzmm);
        }
        zzkr.zzce(iterable, this.zze);
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzb", "zzd", "zze"});
        } else if (i2 == 3) {
            return new zzik();
        } else {
            if (i2 == 4) {
                return new zzij((byte[]) null);
            }
            if (i2 == 5) {
                return zzf;
            }
            throw null;
        }
    }
}
