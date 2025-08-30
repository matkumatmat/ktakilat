package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.Objects;

final class zzjo extends ContentObserver {
    final /* synthetic */ zzjq zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzjo(zzjq zzjq, Handler handler) {
        super((Handler) null);
        Objects.requireNonNull(zzjq);
        this.zza = zzjq;
    }

    public final void onChange(boolean z) {
        this.zza.zzc();
    }
}
