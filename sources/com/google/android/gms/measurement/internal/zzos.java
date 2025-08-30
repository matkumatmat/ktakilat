package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzis;
import java.util.Collections;
import java.util.Map;

public final class zzos {
    private final String zza;
    private final Map zzb;
    private final zzlr zzc;
    private final zzis zzd;

    public zzos(String str, Map map, zzlr zzlr, zzis zzis) {
        this.zza = str;
        this.zzb = map;
        this.zzc = zzlr;
        this.zzd = zzis;
    }

    public final String zza() {
        return this.zza;
    }

    public final Map zzb() {
        Map map = this.zzb;
        if (map == null) {
            return Collections.emptyMap();
        }
        return map;
    }

    public final zzlr zzc() {
        return this.zzc;
    }

    public final zzis zzd() {
        return this.zzd;
    }
}
