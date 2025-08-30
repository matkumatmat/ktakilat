package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.Objects;

final class zzjj extends ContentObserver {
    final /* synthetic */ zzjl zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzjj(zzjl zzjl, Handler handler) {
        super((Handler) null);
        Objects.requireNonNull(zzjl);
        this.zza = zzjl;
    }

    public final void onChange(boolean z) {
        this.zza.zzb().set(true);
    }
}
