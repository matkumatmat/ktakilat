package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;

final class zzpa implements zzpn {
    final /* synthetic */ zzpf zza;

    public zzpa(zzpf zzpf) {
        Objects.requireNonNull(zzpf);
        this.zza = zzpf;
    }

    public final void zza(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            zzpf zzpf = this.zza;
            if (zzpf.zzaw() != null) {
                zzpf.zzaw().zzaV().zzb().zzb("AppId not known when logging event", str2);
                return;
            }
            return;
        }
        this.zza.zzaW().zzj(new zzoz(this, str, str2, bundle));
    }
}
