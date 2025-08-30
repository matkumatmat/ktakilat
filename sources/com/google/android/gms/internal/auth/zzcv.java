package com.google.android.gms.internal.auth;

import android.util.Log;
import javax.annotation.Nullable;

final class zzcv extends zzdc {
    public zzcv(zzcz zzcz, String str, Long l, boolean z) {
        super(zzcz, str, l, true, (zzdb) null);
    }

    @Nullable
    public final /* synthetic */ Object zza(Object obj) {
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            StringBuilder t = e.t("Invalid long value for ", this.zzc, ": ");
            t.append((String) obj);
            Log.e("PhenotypeFlag", t.toString());
            return null;
        }
    }
}
