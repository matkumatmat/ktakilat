package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzay;
import com.google.android.gms.location.ActivityRecognitionClient;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zze implements RemoteCall {
    private final PendingIntent zza;

    public zze(PendingIntent pendingIntent) {
        this.zza = pendingIntent;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzay) obj).zza(this.zza, (BaseImplementation.ResultHolder<Status>) new ActivityRecognitionClient.zza((TaskCompletionSource) obj2));
    }
}
