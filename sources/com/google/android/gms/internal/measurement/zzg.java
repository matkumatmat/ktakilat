package com.google.android.gms.internal.measurement;

import com.google.common.annotations.VisibleForTesting;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzg {
    @VisibleForTesting
    public final zzg zza;
    @VisibleForTesting
    final zzaw zzb;
    @VisibleForTesting
    final Map zzc = new HashMap();
    @VisibleForTesting
    final Map zzd = new HashMap();

    public zzg(zzg zzg, zzaw zzaw) {
        this.zza = zzg;
        this.zzb = zzaw;
    }

    public final zzao zza(zzao zzao) {
        return this.zzb.zzb(this, zzao);
    }

    public final zzao zzb(zzae zzae) {
        zzao zzao = zzao.zzf;
        Iterator zzg = zzae.zzg();
        while (zzg.hasNext()) {
            zzao = this.zzb.zzb(this, zzae.zzl(((Integer) zzg.next()).intValue()));
            if (zzao instanceof zzag) {
                break;
            }
        }
        return zzao;
    }

    public final zzg zzc() {
        return new zzg(this, this.zzb);
    }

    public final boolean zzd(String str) {
        if (this.zzc.containsKey(str)) {
            return true;
        }
        zzg zzg = this.zza;
        if (zzg != null) {
            return zzg.zzd(str);
        }
        return false;
    }

    public final void zze(String str, zzao zzao) {
        zzg zzg;
        Map map = this.zzc;
        if (!map.containsKey(str) && (zzg = this.zza) != null && zzg.zzd(str)) {
            zzg.zze(str, zzao);
        } else if (!this.zzd.containsKey(str)) {
            if (zzao == null) {
                map.remove(str);
            } else {
                map.put(str, zzao);
            }
        }
    }

    public final void zzf(String str, zzao zzao) {
        if (!this.zzd.containsKey(str)) {
            if (zzao == null) {
                this.zzc.remove(str);
            } else {
                this.zzc.put(str, zzao);
            }
        }
    }

    public final void zzg(String str, zzao zzao) {
        zzf(str, zzao);
        this.zzd.put(str, Boolean.TRUE);
    }

    public final zzao zzh(String str) {
        Map map = this.zzc;
        if (map.containsKey(str)) {
            return (zzao) map.get(str);
        }
        zzg zzg = this.zza;
        if (zzg != null) {
            return zzg.zzh(str);
        }
        throw new IllegalArgumentException(e.l(str, " is not defined"));
    }
}
