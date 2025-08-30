package com.google.android.gms.internal.auth;

import android.util.Base64;
import android.util.Log;
import java.io.IOException;

final class zzcy extends zzdc {
    final /* synthetic */ zzhy zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcy(zzcz zzcz, String str, Object obj, boolean z, zzhy zzhy) {
        super(zzcz, "getTokenRefactor__blocked_packages", obj, true, (zzdb) null);
        this.zza = zzhy;
    }

    public final Object zza(Object obj) {
        try {
            return zzhs.zzp(Base64.decode((String) obj, 3));
        } catch (IOException | IllegalArgumentException unused) {
            StringBuilder t = e.t("Invalid byte[] value for ", this.zzc, ": ");
            t.append((String) obj);
            Log.e("PhenotypeFlag", t.toString());
            return null;
        }
    }
}
