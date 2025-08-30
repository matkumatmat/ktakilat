package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import java.util.Objects;

final class zzjw extends zzay {
    final /* synthetic */ zzli zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzjw(zzli zzli, zzjf zzjf) {
        super(zzjf);
        Objects.requireNonNull(zzli);
        this.zza = zzli;
    }

    @WorkerThread
    public final void zza() {
        this.zza.zzz();
    }
}
