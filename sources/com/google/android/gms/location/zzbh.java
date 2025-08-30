package com.google.android.gms.location;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzay;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzbh implements RemoteCall {
    private final LocationSettingsRequest zza;

    public zzbh(LocationSettingsRequest locationSettingsRequest) {
        this.zza = locationSettingsRequest;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzay) obj).zza(this.zza, (BaseImplementation.ResultHolder<LocationSettingsResult>) new SettingsClient.zza((TaskCompletionSource) obj2), (String) null);
    }
}
