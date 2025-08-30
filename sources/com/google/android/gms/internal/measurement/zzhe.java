package com.google.android.gms.internal.measurement;

public final class zzhe extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzhe zzk;
    private int zzb;
    private boolean zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;

    static {
        zzhe zzhe = new zzhe();
        zzk = zzhe;
        zzme.zzcp(zzhe.class, zzhe);
    }

    private zzhe() {
    }

    public static zzhd zzh() {
        return (zzhd) zzk.zzck();
    }

    public static zzhe zzi() {
        return zzk;
    }

    public final boolean zza() {
        return this.zzd;
    }

    public final boolean zzb() {
        return this.zze;
    }

    public final boolean zzc() {
        return this.zzf;
    }

    public final boolean zzd() {
        return this.zzg;
    }

    public final boolean zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return this.zzi;
    }

    public final boolean zzg() {
        return this.zzj;
    }

    public final /* synthetic */ void zzj(boolean z) {
        this.zzb |= 1;
        this.zzd = z;
    }

    public final /* synthetic */ void zzk(boolean z) {
        this.zzb |= 2;
        this.zze = z;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzk, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzhe();
        } else {
            if (i2 == 4) {
                return new zzhd((byte[]) null);
            }
            if (i2 == 5) {
                return zzk;
            }
            throw null;
        }
    }

    public final /* synthetic */ void zzm(boolean z) {
        this.zzb |= 4;
        this.zzf = z;
    }

    public final /* synthetic */ void zzn(boolean z) {
        this.zzb |= 8;
        this.zzg = z;
    }

    public final /* synthetic */ void zzo(boolean z) {
        this.zzb |= 16;
        this.zzh = z;
    }

    public final /* synthetic */ void zzp(boolean z) {
        this.zzb |= 32;
        this.zzi = z;
    }

    public final /* synthetic */ void zzq(boolean z) {
        this.zzb |= 64;
        this.zzj = z;
    }
}
