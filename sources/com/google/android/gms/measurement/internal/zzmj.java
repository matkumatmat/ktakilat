package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Objects;

final class zzmj implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ zznk zzb;

    public zzmj(zznk zznk, zzr zzr, boolean z) {
        this.zza = zzr;
        Objects.requireNonNull(zznk);
        this.zzb = zznk;
    }

    public final void run() {
        zznk zznk = this.zzb;
        zzga zzZ = zznk.zzZ();
        if (zzZ == null) {
            e.w(zznk.zzu, "Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzr zzr = this.zza;
            Preconditions.checkNotNull(zzr);
            zzib zzib = zznk.zzu;
            zzal zzc = zzib.zzc();
            zzfw zzfw = zzfx.zzbc;
            if (zzc.zzp((String) null, zzfw)) {
                zznk.zzm(zzZ, (AbstractSafeParcelable) null, zzr);
            }
            zzZ.zzg(zzr);
            zznk.zzu.zzm().zzo();
            zzib.zzc().zzp((String) null, zzfw);
            zznk.zzm(zzZ, (AbstractSafeParcelable) null, zzr);
            zznk.zzV();
        } catch (RemoteException e) {
            this.zzb.zzu.zzaV().zzb().zzb("Failed to send app launch to the service", e);
        }
    }
}
