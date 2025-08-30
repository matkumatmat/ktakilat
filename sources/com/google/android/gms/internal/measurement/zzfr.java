package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzfr extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzfr zzh;
    private int zzb;
    private int zzd;
    private String zze = "";
    private boolean zzf;
    private zzmn zzg = zzme.zzcv();

    static {
        zzfr zzfr = new zzfr();
        zzh = zzfr;
        zzme.zzcp(zzfr.class, zzfr);
    }

    private zzfr() {
    }

    public static zzfr zzh() {
        return zzh;
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final boolean zzb() {
        return (this.zzb & 2) != 0;
    }

    public final String zzc() {
        return this.zze;
    }

    public final boolean zzd() {
        return (this.zzb & 4) != 0;
    }

    public final boolean zze() {
        return this.zzf;
    }

    public final List zzf() {
        return this.zzg;
    }

    public final int zzg() {
        return this.zzg.size();
    }

    public final int zzj() {
        int zza = zzfq.zza(this.zzd);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzb", "zzd", zzfp.zza, "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzfr();
        } else {
            if (i2 == 4) {
                return new zzfo((byte[]) null);
            }
            if (i2 == 5) {
                return zzh;
            }
            throw null;
        }
    }
}
