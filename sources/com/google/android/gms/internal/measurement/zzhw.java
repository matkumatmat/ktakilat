package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzhw extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzhw zzj;
    private int zzb;
    private String zzd = "";
    private String zze = "";
    private long zzf;
    private float zzg;
    private double zzh;
    private zzmn zzi = zzme.zzcv();

    static {
        zzhw zzhw = new zzhw();
        zzj = zzhw;
        zzme.zzcp(zzhw.class, zzhw);
    }

    private zzhw() {
    }

    public static zzhv zzn() {
        return (zzhv) zzj.zzck();
    }

    private final void zzz() {
        zzmn zzmn = this.zzi;
        if (!zzmn.zza()) {
            this.zzi = zzme.zzcw(zzmn);
        }
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final String zzb() {
        return this.zzd;
    }

    public final boolean zzc() {
        return (this.zzb & 2) != 0;
    }

    public final String zzd() {
        return this.zze;
    }

    public final boolean zze() {
        return (this.zzb & 4) != 0;
    }

    public final long zzf() {
        return this.zzf;
    }

    public final boolean zzg() {
        return (this.zzb & 8) != 0;
    }

    public final float zzh() {
        return this.zzg;
    }

    public final boolean zzi() {
        return (this.zzb & 16) != 0;
    }

    public final double zzj() {
        return this.zzh;
    }

    public final List zzk() {
        return this.zzi;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzhw.class});
        } else if (i2 == 3) {
            return new zzhw();
        } else {
            if (i2 == 4) {
                return new zzhv((byte[]) null);
            }
            if (i2 == 5) {
                return zzj;
            }
            throw null;
        }
    }

    public final int zzm() {
        return this.zzi.size();
    }

    public final /* synthetic */ void zzo(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zzd = str;
    }

    public final /* synthetic */ void zzp(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zze = str;
    }

    public final /* synthetic */ void zzq() {
        this.zzb &= -3;
        this.zze = zzj.zze;
    }

    public final /* synthetic */ void zzr(long j) {
        this.zzb |= 4;
        this.zzf = j;
    }

    public final /* synthetic */ void zzs() {
        this.zzb &= -5;
        this.zzf = 0;
    }

    public final /* synthetic */ void zzt(double d) {
        this.zzb |= 16;
        this.zzh = d;
    }

    public final /* synthetic */ void zzu() {
        this.zzb &= -17;
        this.zzh = 0.0d;
    }

    public final /* synthetic */ void zzv(zzhw zzhw) {
        zzhw.getClass();
        zzz();
        this.zzi.add(zzhw);
    }

    public final /* synthetic */ void zzw(Iterable iterable) {
        zzz();
        zzkr.zzce(iterable, this.zzi);
    }

    public final /* synthetic */ void zzx() {
        this.zzi = zzme.zzcv();
    }
}
