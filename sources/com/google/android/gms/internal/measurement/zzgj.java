package com.google.android.gms.internal.measurement;

public final class zzgj extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzgj zzh;
    private int zzb;
    private String zzd = "";
    private boolean zze;
    private boolean zzf;
    private int zzg;

    static {
        zzgj zzgj = new zzgj();
        zzh = zzgj;
        zzme.zzcp(zzgj.class, zzgj);
    }

    private zzgj() {
    }

    public final String zza() {
        return this.zzd;
    }

    public final boolean zzb() {
        return (this.zzb & 2) != 0;
    }

    public final boolean zzc() {
        return this.zze;
    }

    public final boolean zzd() {
        return (this.zzb & 4) != 0;
    }

    public final boolean zze() {
        return this.zzf;
    }

    public final boolean zzf() {
        return (this.zzb & 8) != 0;
    }

    public final int zzg() {
        return this.zzg;
    }

    public final /* synthetic */ void zzh(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zzd = str;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzgj();
        } else {
            if (i2 == 4) {
                return new zzgi((byte[]) null);
            }
            if (i2 == 5) {
                return zzh;
            }
            throw null;
        }
    }
}
