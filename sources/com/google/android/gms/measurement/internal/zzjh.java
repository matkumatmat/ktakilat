package com.google.android.gms.measurement.internal;

public enum zzjh {
    UNINITIALIZED("uninitialized"),
    POLICY("eu_consent_policy"),
    DENIED("denied"),
    GRANTED("granted");
    
    private final String zze;

    private zzjh(String str) {
        this.zze = str;
    }

    public final String toString() {
        return this.zze;
    }
}
