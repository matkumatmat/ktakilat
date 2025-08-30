package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zznp implements zznw {
    private final zznl zza;
    private final zzoh zzb;
    private final boolean zzc;
    private final zzlr zzd;

    private zznp(zzoh zzoh, zzlr zzlr, zznl zznl) {
        this.zzb = zzoh;
        this.zzc = zznl instanceof zzmb;
        this.zzd = zzlr;
        this.zza = zznl;
    }

    public static zznp zzg(zzoh zzoh, zzlr zzlr, zznl zznl) {
        return new zznp(zzoh, zzlr, zznl);
    }

    public final Object zza() {
        zznl zznl = this.zza;
        if (zznl instanceof zzme) {
            return ((zzme) zznl).zzch();
        }
        return zznl.zzcC().zzbf();
    }

    public final boolean zzb(Object obj, Object obj2) {
        if (!((zzme) obj).zzc.equals(((zzme) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzmb) obj).zzb.equals(((zzmb) obj2).zzb);
        }
        return true;
    }

    public final int zzc(Object obj) {
        int hashCode = ((zzme) obj).zzc.hashCode();
        if (this.zzc) {
            return (hashCode * 53) + ((zzmb) obj).zzb.zza.hashCode();
        }
        return hashCode;
    }

    public final void zzd(Object obj, Object obj2) {
        zzny.zzD(this.zzb, obj, obj2);
        if (this.zzc) {
            zzny.zzC(this.zzd, obj, obj2);
        }
    }

    public final int zze(Object obj) {
        int zzh = ((zzme) obj).zzc.zzh();
        if (this.zzc) {
            return zzh + ((zzmb) obj).zzb.zzg();
        }
        return zzh;
    }

    public final void zzf(Object obj, zzou zzou) throws IOException {
        Iterator zzc2 = ((zzmb) obj).zzb.zzc();
        while (zzc2.hasNext()) {
            Map.Entry entry = (Map.Entry) zzc2.next();
            zzlu zzlu = (zzlu) entry.getKey();
            if (zzlu.zzc() != zzot.MESSAGE || zzlu.zzd() || zzlu.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (entry instanceof zzms) {
                zzou.zzv(zzlu.zza(), ((zzms) entry).zza().zzc());
            } else {
                zzou.zzv(zzlu.zza(), entry.getValue());
            }
        }
        ((zzme) obj).zzc.zzf(zzou);
    }

    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzkv zzkv) throws IOException {
        zzme zzme = (zzme) obj;
        if (zzme.zzc == zzoi.zza()) {
            zzme.zzc = zzoi.zzb();
        }
        zzmb zzmb = (zzmb) obj;
        throw null;
    }

    public final void zzj(Object obj) {
        this.zzb.zzb(obj);
        this.zzd.zza(obj);
    }

    public final boolean zzk(Object obj) {
        return ((zzmb) obj).zzb.zze();
    }
}
