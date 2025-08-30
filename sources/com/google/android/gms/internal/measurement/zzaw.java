package com.google.android.gms.internal.measurement;

import com.google.common.annotations.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class zzaw {
    @VisibleForTesting
    final Map zza = new HashMap();
    final zzbi zzb = new zzbi();

    public zzaw() {
        zza(new zzau());
        zza(new zzax());
        zza(new zzay());
        zza(new zzbb());
        zza(new zzbg());
        zza(new zzbh());
        zza(new zzbj());
    }

    public final void zza(zzav zzav) {
        for (zzbk zzb2 : zzav.zza) {
            this.zza.put(zzb2.zzb().toString(), zzav);
        }
    }

    public final zzao zzb(zzg zzg, zzao zzao) {
        zzav zzav;
        zzh.zzl(zzg);
        if (!(zzao instanceof zzap)) {
            return zzao;
        }
        zzap zzap = (zzap) zzao;
        ArrayList zzg2 = zzap.zzg();
        String zzb2 = zzap.zzb();
        Map map = this.zza;
        if (map.containsKey(zzb2)) {
            zzav = (zzav) map.get(zzb2);
        } else {
            zzav = this.zzb;
        }
        return zzav.zza(zzb2, zzg, zzg2);
    }
}
