package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzet extends zzeq {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ Activity zzb;
    final /* synthetic */ zzfa zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzet(zzfa zzfa, Bundle bundle, Activity activity) {
        super(zzfa.zza, true);
        this.zza = bundle;
        this.zzb = activity;
        Objects.requireNonNull(zzfa);
        this.zzc = zzfa;
    }

    public final void zza() throws RemoteException {
        Bundle bundle;
        Bundle bundle2 = this.zza;
        if (bundle2 != null) {
            bundle = new Bundle();
            if (bundle2.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = bundle2.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        Activity activity = this.zzb;
        ((zzcr) Preconditions.checkNotNull(this.zzc.zza.zzQ())).onActivityCreatedByScionActivityInfo(zzdf.zza(activity), bundle, this.zzi);
    }
}
