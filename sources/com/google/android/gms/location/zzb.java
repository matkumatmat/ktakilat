package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzay;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzb implements RemoteCall {
    private final long zza;
    private final PendingIntent zzb;

    public zzb(long j, PendingIntent pendingIntent) {
        this.zza = j;
        this.zzb = pendingIntent;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzay) obj).zza(this.zza, this.zzb);
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
