package com.google.android.gms.measurement.internal;

import android.content.Intent;
import androidx.annotation.WorkerThread;
import java.util.Objects;

final class zzox extends zzay {
    final /* synthetic */ zzpf zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzox(zzpf zzpf, zzjf zzjf) {
        super(zzjf);
        Objects.requireNonNull(zzpf);
        this.zza = zzpf;
    }

    @WorkerThread
    public final void zza() {
        zzpf zzpf = this.zza;
        zzpf.zzaW().zzg();
        String str = (String) zzpf.zzax().pollFirst();
        if (str != null) {
            zzpf.zzay(zzpf.zzaZ().elapsedRealtime());
            zzpf.zzaV().zzk().zzb("Sending trigger URI notification to app", str);
            Intent intent = new Intent();
            intent.setAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
            intent.setPackage(str);
            zzpf.zzaP(zzpf.zzaY(), intent);
        }
        zzpf.zzau();
    }
}
