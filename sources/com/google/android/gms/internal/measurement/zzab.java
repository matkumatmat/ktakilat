package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzab {
    private zzaa zza;
    private zzaa zzb;
    private final List zzc;

    public zzab() {
        this.zza = new zzaa("", 0, (Map) null);
        this.zzb = new zzaa("", 0, (Map) null);
        this.zzc = new ArrayList();
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzab zzab = new zzab(this.zza.clone());
        for (zzaa zzg : this.zzc) {
            zzab.zzc.add(zzg.clone());
        }
        return zzab;
    }

    public final zzaa zza() {
        return this.zza;
    }

    public final void zzb(zzaa zzaa) {
        this.zza = zzaa;
        this.zzb = zzaa.clone();
        this.zzc.clear();
    }

    public final zzaa zzc() {
        return this.zzb;
    }

    public final void zzd(zzaa zzaa) {
        this.zzb = zzaa;
    }

    public final void zze(String str, long j, Map map) {
        HashMap hashMap = new HashMap();
        for (String str2 : map.keySet()) {
            hashMap.put(str2, zzaa.zzh(str2, this.zza.zze(str2), map.get(str2)));
        }
        this.zzc.add(new zzaa(str, j, hashMap));
    }

    public final List zzf() {
        return this.zzc;
    }

    public zzab(zzaa zzaa) {
        this.zza = zzaa;
        this.zzb = zzaa.clone();
        this.zzc = new ArrayList();
    }
}
