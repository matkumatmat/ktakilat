package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzo;
import java.util.Map;
import java.util.Objects;

final class zzhn implements zzo {
    final /* synthetic */ String zza;
    final /* synthetic */ zzhs zzb;

    public zzhn(zzhs zzhs, String str) {
        this.zza = str;
        Objects.requireNonNull(zzhs);
        this.zzb = zzhs;
    }

    public final String zza(String str) {
        Map map = (Map) this.zzb.zzD().get(this.zza);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
