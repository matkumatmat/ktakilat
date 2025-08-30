package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import java.util.Objects;

final class zzkf extends zzay {
    final /* synthetic */ zzli zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzkf(zzli zzli, zzjf zzjf) {
        super(zzjf);
        Objects.requireNonNull(zzli);
        this.zza = zzli;
    }

    @WorkerThread
    public final void zza() {
        zzli zzli = this.zza;
        if (zzli.zzu.zzI()) {
            zzli.zzao().zzb(2000);
        }
    }
}
