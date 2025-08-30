package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.util.SparseArray;
import java.util.List;

final /* synthetic */ class zzla implements Runnable {
    private final /* synthetic */ zzli zza;
    private final /* synthetic */ List zzb;

    public /* synthetic */ zzla(zzli zzli, List list) {
        this.zza = zzli;
        this.zzb = list;
    }

    public final /* synthetic */ void run() {
        zzli zzli = this.zza;
        zzli.zzg();
        if (Build.VERSION.SDK_INT >= 30) {
            List<zzog> list = this.zzb;
            SparseArray zzf = zzli.zzu.zzd().zzf();
            for (zzog zzog : list) {
                int i = zzog.zzc;
                if (!zzf.contains(i) || ((Long) zzf.get(i)).longValue() < zzog.zzb) {
                    zzli.zzy().add(zzog);
                }
            }
            zzli.zzz();
        }
    }
}
