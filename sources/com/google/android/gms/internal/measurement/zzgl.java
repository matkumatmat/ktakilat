package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgl extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzgl zzu;
    private int zzb;
    private long zzd;
    private String zze = "";
    private int zzf;
    private zzmn zzg = zzme.zzcv();
    private zzmn zzh = zzme.zzcv();
    private zzmn zzi = zzme.zzcv();
    private String zzj = "";
    private boolean zzk;
    private zzmn zzl = zzme.zzcv();
    private zzmn zzm = zzme.zzcv();
    private String zzn = "";
    private String zzo = "";
    private zzgf zzp;
    private zzgp zzq;
    private zzgv zzr;
    private zzgr zzs;
    private zzgn zzt;

    static {
        zzgl zzgl = new zzgl();
        zzu = zzgl;
        zzme.zzcp(zzgl.class, zzgl);
    }

    private zzgl() {
    }

    public static zzgk zzr() {
        return (zzgk) zzu.zzck();
    }

    public static zzgl zzs() {
        return zzu;
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final long zzb() {
        return this.zzd;
    }

    public final boolean zzc() {
        return (this.zzb & 2) != 0;
    }

    public final String zzd() {
        return this.zze;
    }

    public final List zze() {
        return this.zzg;
    }

    public final int zzf() {
        return this.zzh.size();
    }

    public final zzgj zzg(int i) {
        return (zzgj) this.zzh.get(i);
    }

    public final List zzh() {
        return this.zzi;
    }

    public final List zzi() {
        return this.zzl;
    }

    public final int zzj() {
        return this.zzl.size();
    }

    public final List zzk() {
        return this.zzm;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzu, "\u0004\u0011\u0000\u0001\u0001\u0013\u0011\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005\u000eဈ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011ဉ\t\u0012ဉ\n\u0013ဉ\u000b", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", zzgt.class, "zzh", zzgj.class, "zzi", zzfd.class, "zzj", "zzk", "zzl", zzja.class, "zzm", zzgh.class, "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt"});
        } else if (i2 == 3) {
            return new zzgl();
        } else {
            if (i2 == 4) {
                return new zzgk((byte[]) null);
            }
            if (i2 == 5) {
                return zzu;
            }
            throw null;
        }
    }

    public final String zzm() {
        return this.zzn;
    }

    public final boolean zzn() {
        return (this.zzb & 128) != 0;
    }

    public final zzgf zzo() {
        zzgf zzgf = this.zzp;
        if (zzgf == null) {
            return zzgf.zzg();
        }
        return zzgf;
    }

    public final boolean zzp() {
        return (this.zzb & 512) != 0;
    }

    public final zzgv zzq() {
        zzgv zzgv = this.zzr;
        if (zzgv == null) {
            return zzgv.zze();
        }
        return zzgv;
    }

    public final /* synthetic */ void zzt(int i, zzgj zzgj) {
        zzgj.getClass();
        zzmn zzmn = this.zzh;
        if (!zzmn.zza()) {
            this.zzh = zzme.zzcw(zzmn);
        }
        this.zzh.set(i, zzgj);
    }

    public final /* synthetic */ void zzu() {
        this.zzi = zzme.zzcv();
    }

    public final /* synthetic */ void zzv() {
        this.zzl = zzme.zzcv();
    }
}
