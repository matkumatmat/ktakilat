package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzfd extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzfd zzi;
    private int zzb;
    private int zzd;
    private zzmn zze = zzme.zzcv();
    private zzmn zzf = zzme.zzcv();
    private boolean zzg;
    private boolean zzh;

    static {
        zzfd zzfd = new zzfd();
        zzi = zzfd;
        zzme.zzcp(zzfd.class, zzfd);
    }

    private zzfd() {
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final List zzc() {
        return this.zze;
    }

    public final int zzd() {
        return this.zze.size();
    }

    public final zzfn zze(int i) {
        return (zzfn) this.zze.get(i);
    }

    public final List zzf() {
        return this.zzf;
    }

    public final int zzg() {
        return this.zzf.size();
    }

    public final zzff zzh(int i) {
        return (zzff) this.zzf.get(i);
    }

    public final /* synthetic */ void zzi(int i, zzfn zzfn) {
        zzfn.getClass();
        zzmn zzmn = this.zze;
        if (!zzmn.zza()) {
            this.zze = zzme.zzcw(zzmn);
        }
        this.zze.set(i, zzfn);
    }

    public final /* synthetic */ void zzj(int i, zzff zzff) {
        zzff.getClass();
        zzmn zzmn = this.zzf;
        if (!zzmn.zza()) {
            this.zzf = zzme.zzcw(zzmn);
        }
        this.zzf.set(i, zzff);
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzb", "zzd", "zze", zzfn.class, "zzf", zzff.class, "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzfd();
        } else {
            if (i2 == 4) {
                return new zzfc((byte[]) null);
            }
            if (i2 == 5) {
                return zzi;
            }
            throw null;
        }
    }
}
