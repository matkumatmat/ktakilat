package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;

final /* synthetic */ class zzkm implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final /* synthetic */ zzkn zza;

    public /* synthetic */ zzkm(zzkn zzkn) {
        this.zza = zzkn;
    }

    public final /* synthetic */ void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.zza.zzc(sharedPreferences, str);
    }
}
