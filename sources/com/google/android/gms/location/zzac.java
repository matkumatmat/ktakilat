package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzai;
import com.google.android.gms.internal.location.zzay;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzac implements RemoteCall {
    private final PendingIntent zza;

    public zzac(PendingIntent pendingIntent) {
        this.zza = pendingIntent;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzay) obj).zza(this.zza, (zzai) new FusedLocationProviderClient.zzd((TaskCompletionSource) obj2));
    }
}
