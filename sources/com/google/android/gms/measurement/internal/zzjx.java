package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzjx implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzli zzb;

    public zzjx(zzli zzli, boolean z) {
        this.zza = z;
        Objects.requireNonNull(zzli);
        this.zzb = zzli;
    }

    public final void run() {
        zzli zzli = this.zzb;
        zzib zzib = zzli.zzu;
        boolean zzB = zzib.zzB();
        boolean zzA = zzib.zzA();
        boolean z = this.zza;
        zzib.zzz(z);
        if (zzA == z) {
            zzib.zzaV().zzk().zzb("Default data collection state already set to", Boolean.valueOf(z));
        }
        if (zzib.zzB() == zzB || zzib.zzB() != zzib.zzA()) {
            zzib.zzaV().zzh().zzc("Default data collection is different than actual status", Boolean.valueOf(z), Boolean.valueOf(zzB));
        }
        zzli.zzak();
    }
}
