package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

final class zzha extends BroadcastReceiver {
    private final zzpf zza;
    private boolean zzb;
    private boolean zzc;

    public zzha(zzpf zzpf) {
        Preconditions.checkNotNull(zzpf);
        this.zza = zzpf;
    }

    @MainThread
    public final void onReceive(Context context, Intent intent) {
        zzpf zzpf = this.zza;
        zzpf.zzu();
        String action = intent.getAction();
        zzpf.zzaV().zzk().zzb("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zzb2 = zzpf.zzi().zzb();
            if (this.zzc != zzb2) {
                this.zzc = zzb2;
                zzpf.zzaW().zzj(new zzgz(this, zzb2));
                return;
            }
            return;
        }
        zzpf.zzaV().zze().zzb("NetworkBroadcastReceiver received unknown action", action);
    }

    @WorkerThread
    public final void zza() {
        zzpf zzpf = this.zza;
        zzpf.zzu();
        zzpf.zzaW().zzg();
        if (!this.zzb) {
            zzpf.zzaY().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.zzc = zzpf.zzi().zzb();
            zzpf.zzaV().zzk().zzb("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzc));
            this.zzb = true;
        }
    }

    @WorkerThread
    public final void zzb() {
        zzpf zzpf = this.zza;
        zzpf.zzu();
        zzpf.zzaW().zzg();
        zzpf.zzaW().zzg();
        if (this.zzb) {
            zzpf.zzaV().zzk().zza("Unregistering connectivity change receiver");
            this.zzb = false;
            this.zzc = false;
            try {
                zzpf.zzaY().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.zza.zzaV().zzb().zzb("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public final /* synthetic */ zzpf zzc() {
        return this.zza;
    }
}
