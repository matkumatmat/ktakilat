package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.LocationSettingsResult;

final class zzaz extends zzaq {
    private BaseImplementation.ResultHolder<LocationSettingsResult> zza;

    public zzaz(BaseImplementation.ResultHolder<LocationSettingsResult> resultHolder) {
        boolean z;
        if (resultHolder != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "listener can't be null.");
        this.zza = resultHolder;
    }

    public final void zza(LocationSettingsResult locationSettingsResult) throws RemoteException {
        this.zza.setResult(locationSettingsResult);
        this.zza = null;
    }
}
