package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzib extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzib zzh;
    private int zzb;
    private zzmn zzd = zzme.zzcv();
    private String zze = "";
    private String zzf = "";
    private int zzg;

    static {
        zzib zzib = new zzib();
        zzh = zzib;
        zzme.zzcp(zzib.class, zzib);
    }

    private zzib() {
    }

    public static zzhz zzh() {
        return (zzhz) zzh.zzck();
    }

    public static zzhz zzi(zzib zzib) {
        zzma zzck = zzh.zzck();
        zzck.zzbd(zzib);
        return (zzhz) zzck;
    }

    private final void zzr() {
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

    public final zzid zzc(int i) {
        return (zzid) this.zzd.get(i);
    }

    public final boolean zzd() {
        return (this.zzb & 1) != 0;
    }

    public final String zze() {
        return this.zze;
    }

    public final boolean zzf() {
        return (this.zzb & 2) != 0;
    }

    public final String zzg() {
        return this.zzf;
    }

    public final /* synthetic */ void zzj(int i, zzid zzid) {
        zzid.getClass();
        zzr();
        this.zzd.set(i, zzid);
    }

    public final /* synthetic */ void zzk(zzid zzid) {
        zzid.getClass();
        zzr();
        this.zzd.add(zzid);
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzh, "\u0004\u0004\u0000\u0001\u0001\t\u0004\u0000\u0001\u0000\u0001\u001b\u0007ဈ\u0000\bဈ\u0001\t᠌\u0002", new Object[]{"zzb", "zzd", zzid.class, "zze", "zzf", "zzg", zzia.zza});
        } else if (i2 == 3) {
            return new zzib();
        } else {
            if (i2 == 4) {
                return new zzhz((byte[]) null);
            }
            if (i2 == 5) {
                return zzh;
            }
            throw null;
        }
    }

    public final /* synthetic */ void zzm(Iterable iterable) {
        zzr();
        zzkr.zzce(iterable, this.zzd);
    }

    public final /* synthetic */ void zzn() {
        this.zzd = zzme.zzcv();
    }

    public final /* synthetic */ void zzo(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    public final /* synthetic */ void zzp(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zzf = str;
    }
}
