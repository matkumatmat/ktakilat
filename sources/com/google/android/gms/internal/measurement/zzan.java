package com.google.android.gms.internal.measurement;

import com.google.common.annotations.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzan extends zzai implements zzak {
    @VisibleForTesting
    protected final List zza;
    @VisibleForTesting
    protected final List zzb;
    @VisibleForTesting
    protected zzg zzc;

    private zzan(zzan zzan) {
        super(zzan.zzd);
        ArrayList arrayList = new ArrayList(zzan.zza.size());
        this.zza = arrayList;
        arrayList.addAll(zzan.zza);
        ArrayList arrayList2 = new ArrayList(zzan.zzb.size());
        this.zzb = arrayList2;
        arrayList2.addAll(zzan.zzb);
        this.zzc = zzan.zzc;
    }

    public final zzao zza(zzg zzg, List list) {
        zzg zzc2 = this.zzc.zzc();
        int i = 0;
        while (true) {
            List list2 = this.zza;
            if (i >= list2.size()) {
                break;
            }
            if (i < list.size()) {
                zzc2.zzf((String) list2.get(i), zzg.zza((zzao) list.get(i)));
            } else {
                zzc2.zzf((String) list2.get(i), zzao.zzf);
            }
            i++;
        }
        for (zzao zzao : this.zzb) {
            zzao zza2 = zzc2.zza(zzao);
            if (zza2 instanceof zzap) {
                zza2 = zzc2.zza(zzao);
            }
            if (zza2 instanceof zzag) {
                return ((zzag) zza2).zzb();
            }
        }
        return zzao.zzf;
    }

    public final zzao zzt() {
        return new zzan(this);
    }

    public zzan(String str, List list, List list2, zzg zzg) {
        super(str);
        this.zza = new ArrayList();
        this.zzc = zzg;
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.zza.add(((zzao) it.next()).zzc());
            }
        }
        this.zzb = new ArrayList(list2);
    }
}
