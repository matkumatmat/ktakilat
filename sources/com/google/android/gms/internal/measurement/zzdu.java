package com.google.android.gms.internal.measurement;

import androidx.annotation.BinderThread;
import java.util.Objects;

final class zzdu extends zzcw {
    final /* synthetic */ Runnable zza;

    public zzdu(zzdv zzdv, Runnable runnable) {
        this.zza = runnable;
        Objects.requireNonNull(zzdv);
    }

    @BinderThread
    public final void zze() {
        this.zza.run();
    }
}
