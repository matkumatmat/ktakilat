package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzii extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzii zzg;
    private zzmm zzb = zzme.zzct();
    private zzmm zzd = zzme.zzct();
    private zzmn zze = zzme.zzcv();
    private zzmn zzf = zzme.zzcv();

    static {
        zzii zzii = new zzii();
        zzg = zzii;
        zzme.zzcp(zzii.class, zzii);
    }

    private zzii() {
    }

    public static zzih zzi() {
        return (zzih) zzg.zzck();
    }

    public static zzii zzj() {
        return zzg;
    }

    public final List zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzb.size();
    }

    public final List zzc() {
        return this.zzd;
    }

    public final int zzd() {
        return this.zzd.size();
    }

    public final List zze() {
        return this.zze;
    }

    public final int zzf() {
        return this.zze.size();
    }

    public final List zzg() {
        return this.zzf;
    }

    public final int zzh() {
        return this.zzf.size();
    }

    public final /* synthetic */ void zzk(Iterable iterable) {
        zzmm zzmm = this.zzb;
        if (!zzmm.zza()) {
            this.zzb = zzme.zzcu(zzmm);
        }
        zzkr.zzce(iterable, this.zzb);
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzg, "\u0004\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzb", "zzd", "zze", zzhq.class, "zzf", zzik.class});
        } else if (i2 == 3) {
            return new zzii();
        } else {
            if (i2 == 4) {
                return new zzih((byte[]) null);
            }
            if (i2 == 5) {
                return zzg;
            }
            throw null;
        }
    }

    public final /* synthetic */ void zzm() {
        this.zzb = zzme.zzct();
    }

    public final /* synthetic */ void zzn(Iterable iterable) {
        zzmm zzmm = this.zzd;
        if (!zzmm.zza()) {
            this.zzd = zzme.zzcu(zzmm);
        }
        zzkr.zzce(iterable, this.zzd);
    }

    public final /* synthetic */ void zzo() {
        this.zzd = zzme.zzct();
    }

    public final /* synthetic */ void zzp(Iterable iterable) {
        zzmn zzmn = this.zze;
        if (!zzmn.zza()) {
            this.zze = zzme.zzcw(zzmn);
        }
        zzkr.zzce(iterable, this.zze);
    }

    public final /* synthetic */ void zzq() {
        this.zze = zzme.zzcv();
    }

    public final /* synthetic */ void zzr(Iterable iterable) {
        zzmn zzmn = this.zzf;
        if (!zzmn.zza()) {
            this.zzf = zzme.zzcw(zzmn);
        }
        zzkr.zzce(iterable, this.zzf);
    }

    public final /* synthetic */ void zzs() {
        this.zzf = zzme.zzcv();
    }
}
