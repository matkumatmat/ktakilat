package com.google.android.gms.measurement.internal;

abstract class zzje extends zzjd {
    private boolean zza;

    public zzje(zzib zzib) {
        super(zzib);
        this.zzu.zzF();
    }

    public abstract boolean zza();

    public void zzba() {
    }

    public final boolean zzv() {
        return this.zza;
    }

    public final void zzw() {
        if (!zzv()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzx() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zza()) {
            this.zzu.zzG();
            this.zza = true;
        }
    }

    public final void zzy() {
        if (!this.zza) {
            zzba();
            this.zzu.zzG();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
