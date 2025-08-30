package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

final class zzu extends zzs {
    public zzu(int i, int i2, Bundle bundle) {
        super(i, i2, bundle);
    }

    public final void zza(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        zzd(bundle2);
    }

    public final boolean zzb() {
        return false;
    }
}
