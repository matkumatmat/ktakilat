package com.google.android.gms.measurement.internal;

public enum zzji {
    STORAGE(zzjj.AD_STORAGE, zzjj.ANALYTICS_STORAGE),
    DMA(zzjj.AD_USER_DATA);
    
    private final zzjj[] zzc;

    private zzji(zzjj... zzjjArr) {
        this.zzc = zzjjArr;
    }

    public final zzjj[] zza() {
        return this.zzc;
    }
}
