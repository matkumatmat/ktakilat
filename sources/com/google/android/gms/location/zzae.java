package com.google.android.gms.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzay;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzae implements RemoteCall {
    private final Location zza;

    public zzae(Location location) {
        this.zza = location;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzay) obj).zza(this.zza);
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
