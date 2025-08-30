package com.google.android.gms.common;

import android.util.Log;
import androidx.annotation.NonNull;
import javax.annotation.Nullable;

class zzw {
    private static final zzw zze = new zzw(true, 3, 1, (String) null, (Throwable) null);
    final boolean zza;
    @Nullable
    final String zzb;
    @Nullable
    final Throwable zzc;
    final int zzd;

    private zzw(boolean z, int i, int i2, @Nullable String str, @Nullable Throwable th) {
        this.zza = z;
        this.zzd = i;
        this.zzb = str;
        this.zzc = th;
    }

    @Deprecated
    public static zzw zzb() {
        return zze;
    }

    public static zzw zzc(@NonNull String str) {
        return new zzw(false, 1, 5, str, (Throwable) null);
    }

    public static zzw zzd(@NonNull String str, @NonNull Throwable th) {
        return new zzw(false, 1, 5, str, th);
    }

    public static zzw zzf(int i) {
        return new zzw(true, i, 1, (String) null, (Throwable) null);
    }

    public static zzw zzg(int i, int i2, @NonNull String str, @Nullable Throwable th) {
        return new zzw(false, i, i2, str, th);
    }

    @Nullable
    public String zza() {
        return this.zzb;
    }

    public final void zze() {
        if (!this.zza && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (this.zzc != null) {
                zza();
            } else {
                zza();
            }
        }
    }

    public /* synthetic */ zzw(boolean z, int i, int i2, String str, Throwable th, zzv zzv) {
        this(false, 1, 5, (String) null, (Throwable) null);
    }
}
