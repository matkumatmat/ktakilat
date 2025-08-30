package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class zzai implements zzao, zzak {
    protected final String zzd;
    protected final Map zze = new HashMap();

    public zzai(String str) {
        this.zzd = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzai)) {
            return false;
        }
        zzai zzai = (zzai) obj;
        String str = this.zzd;
        if (str != null) {
            return str.equals(zzai.zzd);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzd;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public abstract zzao zza(zzg zzg, List list);

    public final String zzc() {
        return this.zzd;
    }

    public final zzao zzcA(String str, zzg zzg, List list) {
        if ("toString".equals(str)) {
            return new zzas(this.zzd);
        }
        return a.a(this, new zzas(str), zzg, list);
    }

    public final Double zzd() {
        return Double.valueOf(Double.NaN);
    }

    public final Boolean zze() {
        return Boolean.TRUE;
    }

    public final Iterator zzf() {
        return a.b(this.zze);
    }

    public final String zzg() {
        return this.zzd;
    }

    public final boolean zzj(String str) {
        return this.zze.containsKey(str);
    }

    public final zzao zzk(String str) {
        Map map = this.zze;
        if (map.containsKey(str)) {
            return (zzao) map.get(str);
        }
        return zzao.zzf;
    }

    public final void zzm(String str, zzao zzao) {
        if (zzao == null) {
            this.zze.remove(str);
        } else {
            this.zze.put(str, zzao);
        }
    }

    public zzao zzt() {
        return this;
    }
}
