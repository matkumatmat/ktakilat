package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzmk implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ zznk zzb;

    public zzmk(zznk zznk, zzr zzr) {
        this.zza = zzr;
        Objects.requireNonNull(zznk);
        this.zzb = zznk;
    }

    public final void run() {
        zznk zznk = this.zzb;
        zzga zzZ = zznk.zzZ();
        if (zzZ == null) {
            e.C(zznk.zzu, "Failed to send app backgrounded");
            return;
        }
        try {
            zzr zzr = this.zza;
            Preconditions.checkNotNull(zzr);
            zzZ.zzA(zzr);
            zznk.zzV();
        } catch (RemoteException e) {
            this.zzb.zzu.zzaV().zzb().zzb("Failed to send app backgrounded to the service", e);
        }
    }
}
