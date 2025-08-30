package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzcd implements SharedPreferences {
    private final Map zza = new HashMap();
    private final Set zzb = new HashSet();

    private final Object zzc(String str, Object obj) {
        Object obj2 = this.zza.get(str);
        if (obj2 != null) {
            return obj2;
        }
        return obj;
    }

    public final boolean contains(String str) {
        return this.zza.containsKey(str);
    }

    public final SharedPreferences.Editor edit() {
        return new zzcc(this, (byte[]) null);
    }

    public final Map getAll() {
        return this.zza;
    }

    public final boolean getBoolean(String str, boolean z) {
        return ((Boolean) zzc(str, Boolean.valueOf(z))).booleanValue();
    }

    public final float getFloat(String str, float f) {
        return ((Float) zzc(str, Float.valueOf(f))).floatValue();
    }

    public final int getInt(String str, int i) {
        return ((Integer) zzc(str, Integer.valueOf(i))).intValue();
    }

    public final long getLong(String str, long j) {
        return ((Long) zzc(str, Long.valueOf(j))).longValue();
    }

    public final String getString(String str, String str2) {
        return (String) zzc(str, str2);
    }

    public final Set getStringSet(String str, Set set) {
        return (Set) zzc(str, set);
    }

    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.zzb.add(onSharedPreferenceChangeListener);
    }

    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.zzb.remove(onSharedPreferenceChangeListener);
    }

    public final /* synthetic */ Map zza() {
        return this.zza;
    }

    public final /* synthetic */ Set zzb() {
        return this.zzb;
    }
}
