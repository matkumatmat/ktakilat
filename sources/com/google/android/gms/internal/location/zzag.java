package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.location.zzbe;

final class zzag extends zzaf {
    private final /* synthetic */ zzbe zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzag(zzae zzae, GoogleApiClient googleApiClient, zzbe zzbe) {
        super(googleApiClient);
        this.zza = zzbe;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzay) anyClient).zza(this.zza, (BaseImplementation.ResultHolder<Status>) this);
    }
}
