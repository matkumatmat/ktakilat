package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzff extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzff zzl;
    private int zzb;
    private int zzd;
    private String zze = "";
    private zzmn zzf = zzme.zzcv();
    private boolean zzg;
    private zzfl zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    static {
        zzff zzff = new zzff();
        zzl = zzff;
        zzme.zzcp(zzff.class, zzff);
    }

    private zzff() {
    }

    public static zzfe zzn() {
        return (zzfe) zzl.zzck();
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zze;
    }

    public final List zzd() {
        return this.zzf;
    }

    public final int zze() {
        return this.zzf.size();
    }

    public final zzfh zzf(int i) {
        return (zzfh) this.zzf.get(i);
    }

    public final boolean zzg() {
        return (this.zzb & 8) != 0;
    }

    public final zzfl zzh() {
        zzfl zzfl = this.zzh;
        if (zzfl == null) {
            return zzfl.zzj();
        }
        return zzfl;
    }

    public final boolean zzi() {
        return this.zzi;
    }

    public final boolean zzj() {
        return this.zzj;
    }

    public final boolean zzk() {
        return (this.zzb & 64) != 0;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzl, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzb", "zzd", "zze", "zzf", zzfh.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i2 == 3) {
            return new zzff();
        } else {
            if (i2 == 4) {
                return new zzfe((byte[]) null);
            }
            if (i2 == 5) {
                return zzl;
            }
            throw null;
        }
    }

    public final boolean zzm() {
        return this.zzk;
    }

    public final /* synthetic */ void zzo(String str) {
        this.zzb |= 2;
        this.zze = str;
    }

    public final /* synthetic */ void zzp(int i, zzfh zzfh) {
        zzfh.getClass();
        zzmn zzmn = this.zzf;
        if (!zzmn.zza()) {
            this.zzf = zzme.zzcw(zzmn);
        }
        this.zzf.set(i, zzfh);
    }
}
