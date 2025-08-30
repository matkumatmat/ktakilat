package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract /* synthetic */ class a {
    public static zzao a(zzak zzak, zzao zzao, zzg zzg, List list) {
        if (zzak.zzj(zzao.zzc())) {
            zzao zzk = zzak.zzk(zzao.zzc());
            if (zzk instanceof zzai) {
                return ((zzai) zzk).zza(zzg, list);
            }
            throw new IllegalArgumentException(e.l(zzao.zzc(), " is not a function"));
        } else if ("hasOwnProperty".equals(zzao.zzc())) {
            zzh.zza("hasOwnProperty", 1, list);
            if (zzak.zzj(zzg.zza((zzao) list.get(0)).zzc())) {
                return zzao.zzk;
            }
            return zzao.zzl;
        } else {
            throw new IllegalArgumentException(e.B("Object has no function ", zzao.zzc()));
        }
    }

    public static Iterator b(Map map) {
        return new zzaj(map.keySet().iterator());
    }
}
