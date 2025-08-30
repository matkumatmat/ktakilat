package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;

abstract class zzg extends zzf {
    private boolean zza;

    public zzg(zzib zzib) {
        super(zzib);
        this.zzu.zzF();
    }

    public final boolean zza() {
        return this.zza;
    }

    public final void zzb() {
        if (!zza()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzc() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zze()) {
            this.zzu.zzG();
            this.zza = true;
        }
    }

    public final void zzd() {
        if (!this.zza) {
            zzf();
            this.zzu.zzG();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public abstract boolean zze();

    @WorkerThread
    public void zzf() {
    }
}
