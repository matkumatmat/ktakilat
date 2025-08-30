package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.zzcn;

public final class zzob extends zzg {
    protected final zzoa zza = new zzoa(this);
    protected final zznz zzb = new zznz(this);
    protected final zznx zzc = new zznx(this);
    private Handler zzd;
    private boolean zze = true;

    public zzob(zzib zzib) {
        super(zzib);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: zzn */
    public final void zzj() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new zzcn(Looper.getMainLooper());
        }
    }

    public final boolean zze() {
        return false;
    }

    @WorkerThread
    public final void zzh(boolean z) {
        zzg();
        this.zze = z;
    }

    @WorkerThread
    public final boolean zzi() {
        zzg();
        return this.zze;
    }

    public final /* synthetic */ void zzk(long j) {
        zzg();
        zzj();
        zzib zzib = this.zzu;
        zzib.zzaV().zzk().zzb("Activity resumed, time", Long.valueOf(j));
        if (zzib.zzc().zzp((String) null, zzfx.zzaU)) {
            if (zzib.zzc().zzv() || this.zze) {
                this.zzb.zza(j);
            }
        } else if (zzib.zzc().zzv() || zzib.zzd().zzn.zza()) {
            this.zzb.zza(j);
        }
        this.zzc.zza();
        zzoa zzoa = this.zza;
        zzob zzob = zzoa.zza;
        zzob.zzg();
        if (zzob.zzu.zzB()) {
            zzoa.zzb(zzob.zzu.zzaZ().currentTimeMillis(), false);
        }
    }

    public final /* synthetic */ void zzl(long j) {
        zzg();
        zzj();
        zzib zzib = this.zzu;
        zzib.zzaV().zzk().zzb("Activity paused, time", Long.valueOf(j));
        this.zzc.zzb(j);
        if (zzib.zzc().zzv()) {
            this.zzb.zzb(j);
        }
    }

    public final /* synthetic */ Handler zzm() {
        return this.zzd;
    }
}
