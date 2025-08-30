package com.google.android.gms.measurement.internal;

import java.util.Objects;

final /* synthetic */ class zzu implements Runnable {
    private final /* synthetic */ zzib zza;

    public /* synthetic */ zzu(zzib zzib) {
        this.zza = zzib;
    }

    public final /* synthetic */ void run() {
        zzib zzib = this.zza;
        if (!zzib.zzk().zzS()) {
            e.C(zzib, "registerTrigger called but app not eligible");
            return;
        }
        zzib.zzj().zzv();
        zzli zzj = zzib.zzj();
        Objects.requireNonNull(zzj);
        new Thread(new zzv(zzj)).start();
    }
}
