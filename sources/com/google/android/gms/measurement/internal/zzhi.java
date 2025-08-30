package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.MainThread;
import com.google.android.gms.internal.measurement.zzbp;
import com.google.android.gms.internal.measurement.zzbq;
import java.util.Objects;

public final class zzhi implements ServiceConnection {
    final /* synthetic */ zzhj zza;
    private final String zzb;

    public zzhi(zzhj zzhj, String str) {
        Objects.requireNonNull(zzhj);
        this.zza = zzhj;
        this.zzb = str;
    }

    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder != null) {
            try {
                zzbq zzb2 = zzbp.zzb(iBinder);
                if (zzb2 == null) {
                    this.zza.zza.zzaV().zze().zza("Install Referrer Service implementation was not found");
                    return;
                }
                zzib zzib = this.zza.zza;
                zzib.zzaV().zzk().zza("Install Referrer Service connected");
                zzib.zzaW().zzj(new zzhh(this, zzb2, this));
            } catch (RuntimeException e) {
                this.zza.zza.zzaV().zze().zzb("Exception occurred while calling Install Referrer API", e);
            }
        } else {
            e.C(this.zza.zza, "Install Referrer connection returned with null binder");
        }
    }

    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        this.zza.zza.zzaV().zzk().zza("Install Referrer Service disconnected");
    }

    public final /* synthetic */ String zza() {
        return this.zzb;
    }
}
