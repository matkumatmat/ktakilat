package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

final class zzr extends zzs {
    public zzr(int i, int i2, Bundle bundle) {
        super(i, i2, bundle);
    }

    public final void zza(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            zzd((Object) null);
        } else {
            zzc(new zzt(4, "Invalid response to one way request", (Throwable) null));
        }
    }

    public final boolean zzb() {
        return true;
    }
}
