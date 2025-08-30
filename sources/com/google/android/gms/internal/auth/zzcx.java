package com.google.android.gms.internal.auth;

import android.util.Log;
import javax.annotation.Nullable;

final class zzcx extends zzdc {
    public zzcx(zzcz zzcz, String str, Double d, boolean z) {
        super(zzcz, str, d, true, (zzdb) null);
    }

    @Nullable
    public final /* synthetic */ Object zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            StringBuilder t = e.t("Invalid double value for ", this.zzc, ": ");
            t.append((String) obj);
            Log.e("PhenotypeFlag", t.toString());
            return null;
        }
    }
}
