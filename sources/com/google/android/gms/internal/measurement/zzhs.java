package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzhs extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzhs zzi;
    private int zzb;
    private zzmn zzd = zzme.zzcv();
    private String zze = "";
    private long zzf;
    private long zzg;
    private int zzh;

    static {
        zzhs zzhs = new zzhs();
        zzi = zzhs;
        zzme.zzcp(zzhs.class, zzhs);
    }

    private zzhs() {
    }

    public static zzhr zzk() {
        return (zzhr) zzi.zzck();
    }

    private final void zzv() {
        zzmn zzmn = this.zzd;
        if (!zzmn.zza()) {
            this.zzd = zzme.zzcw(zzmn);
        }
    }

    public final List zza() {
        return this.zzd;
    }

    public final int zzb() {
        return this.zzd.size();
    }

    public final zzhw zzc(int i) {
        return (zzhw) this.zzd.get(i);
    }

    public final String zzd() {
        return this.zze;
    }

    public final boolean zze() {
        return (this.zzb & 2) != 0;
    }

    public final long zzf() {
        return this.zzf;
    }

    public final boolean zzg() {
        return (this.zzb & 4) != 0;
    }

    public final long zzh() {
        return this.zzg;
    }

    public final boolean zzi() {
        return (this.zzb & 8) != 0;
    }

    public final int zzj() {
        return this.zzh;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzb", "zzd", zzhw.class, "zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzhs();
        } else {
            if (i2 == 4) {
                return new zzhr((byte[]) null);
            }
            if (i2 == 5) {
                return zzi;
            }
            throw null;
        }
    }

    public final /* synthetic */ void zzm(int i, zzhw zzhw) {
        zzhw.getClass();
        zzv();
        this.zzd.set(i, zzhw);
    }

    public final /* synthetic */ void zzn(zzhw zzhw) {
        zzhw.getClass();
        zzv();
        this.zzd.add(zzhw);
    }

    public final /* synthetic */ void zzo(Iterable iterable) {
        zzv();
        zzkr.zzce(iterable, this.zzd);
    }

    public final /* synthetic */ void zzp() {
        this.zzd = zzme.zzcv();
    }

    public final /* synthetic */ void zzq(int i) {
        zzv();
        this.zzd.remove(i);
    }

    public final /* synthetic */ void zzr(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    public final /* synthetic */ void zzs(long j) {
        this.zzb |= 2;
        this.zzf = j;
    }

    public final /* synthetic */ void zzt(long j) {
        this.zzb |= 4;
        this.zzg = j;
    }
}
