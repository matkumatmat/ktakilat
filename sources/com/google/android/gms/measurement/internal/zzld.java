package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;

final /* synthetic */ class zzld implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final /* synthetic */ zzli zza;

    public /* synthetic */ zzld(zzli zzli) {
        this.zza = zzli;
    }

    public final /* synthetic */ void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.zza.zzaf(sharedPreferences, str);
    }
}
