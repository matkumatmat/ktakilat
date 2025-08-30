package com.google.android.gms.measurement.internal;

abstract class zzor extends zzok {
    private boolean zza;

    public zzor(zzpf zzpf) {
        super(zzpf);
        this.zzg.zzad();
    }

    public final boolean zzax() {
        return this.zza;
    }

    public final void zzay() {
        if (!zzax()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzaz() {
        if (!this.zza) {
            zzbb();
            this.zzg.zzae();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public abstract boolean zzbb();
}
