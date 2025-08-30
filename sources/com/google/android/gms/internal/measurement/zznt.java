package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zznt {
    public static final /* synthetic */ int zza = 0;
    private static final zznt zzb = new zznt();
    private final zznx zzc = new zznc();
    private final ConcurrentMap zzd = new ConcurrentHashMap();

    private zznt() {
    }

    public static zznt zza() {
        return zzb;
    }

    public final zznw zzb(Class cls) {
        zzmo.zza(cls, "messageType");
        ConcurrentMap concurrentMap = this.zzd;
        zznw zznw = (zznw) concurrentMap.get(cls);
        if (zznw == null) {
            zznw = this.zzc.zza(cls);
            zzmo.zza(cls, "messageType");
            zznw zznw2 = (zznw) concurrentMap.putIfAbsent(cls, zznw);
            if (zznw2 != null) {
                return zznw2;
            }
        }
        return zznw;
    }
}
