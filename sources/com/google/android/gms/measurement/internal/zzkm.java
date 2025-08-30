package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;

final class zzkm implements zzpn {
    final /* synthetic */ zzli zza;

    public zzkm(zzli zzli) {
        Objects.requireNonNull(zzli);
        this.zza = zzli;
    }

    public final void zza(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzI("auto", "_err", bundle, str);
        } else {
            this.zza.zzB("auto", "_err", bundle);
        }
    }
}
