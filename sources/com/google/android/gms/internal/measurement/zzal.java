package com.google.android.gms.internal.measurement;

import com.google.common.annotations.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class zzal implements zzao, zzak {
    @VisibleForTesting
    final Map zza = new HashMap();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzal)) {
            return false;
        }
        return this.zza.equals(((zzal) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        Map map = this.zza;
        if (!map.isEmpty()) {
            for (String str : map.keySet()) {
                sb.append(String.format("%s: %s,", new Object[]{str, map.get(str)}));
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        sb.append("}");
        return sb.toString();
    }

    public final List zzb() {
        return new ArrayList(this.zza.keySet());
    }

    public final String zzc() {
        return "[object Object]";
    }

    public zzao zzcA(String str, zzg zzg, List list) {
        if ("toString".equals(str)) {
            return new zzas(toString());
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
        return a.b(this.zza);
    }

    public final boolean zzj(String str) {
        return this.zza.containsKey(str);
    }

    public final zzao zzk(String str) {
        Map map = this.zza;
        if (map.containsKey(str)) {
            return (zzao) map.get(str);
        }
        return zzao.zzf;
    }

    public final void zzm(String str, zzao zzao) {
        if (zzao == null) {
            this.zza.remove(str);
        } else {
            this.zza.put(str, zzao);
        }
    }

    public final zzao zzt() {
        zzal zzal = new zzal();
        for (Map.Entry entry : this.zza.entrySet()) {
            if (entry.getValue() instanceof zzak) {
                zzal.zza.put((String) entry.getKey(), (zzao) entry.getValue());
            } else {
                zzal.zza.put((String) entry.getKey(), ((zzao) entry.getValue()).zzt());
            }
        }
        return zzal;
    }
}
