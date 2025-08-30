package com.google.android.gms.internal.measurement;

public final class zziu extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zziu zzj;
    private int zzb;
    private long zzd;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private float zzh;
    private double zzi;

    static {
        zziu zziu = new zziu();
        zzj = zziu;
        zzme.zzcp(zziu.class, zziu);
    }

    private zziu() {
    }

    public static zzit zzm() {
        return (zzit) zzj.zzck();
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final long zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zze;
    }

    public final boolean zzd() {
        return (this.zzb & 4) != 0;
    }

    public final String zze() {
        return this.zzf;
    }

    public final boolean zzf() {
        return (this.zzb & 8) != 0;
    }

    public final long zzg() {
        return this.zzg;
    }

    public final boolean zzh() {
        return (this.zzb & 16) != 0;
    }

    public final float zzi() {
        return this.zzh;
    }

    public final boolean zzj() {
        return (this.zzb & 32) != 0;
    }

    public final double zzk() {
        return this.zzi;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zziu();
        } else {
            if (i2 == 4) {
                return new zzit((byte[]) null);
            }
            if (i2 == 5) {
                return zzj;
            }
            throw null;
        }
    }

    public final /* synthetic */ void zzn(long j) {
        this.zzb |= 1;
        this.zzd = j;
    }

    public final /* synthetic */ void zzo(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zze = str;
    }

    public final /* synthetic */ void zzp(String str) {
        str.getClass();
        this.zzb |= 4;
        this.zzf = str;
    }

    public final /* synthetic */ void zzq() {
        this.zzb &= -5;
        this.zzf = zzj.zzf;
    }

    public final /* synthetic */ void zzr(long j) {
        this.zzb |= 8;
        this.zzg = j;
    }

    public final /* synthetic */ void zzs() {
        this.zzb &= -9;
        this.zzg = 0;
    }

    public final /* synthetic */ void zzt(double d) {
        this.zzb |= 32;
        this.zzi = d;
    }

    public final /* synthetic */ void zzu() {
        this.zzb &= -33;
        this.zzi = 0.0d;
    }
}
