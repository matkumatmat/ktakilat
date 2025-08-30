package com.google.android.gms.internal.measurement;

import android.net.Uri;
import com.google.common.base.Function;
import javax.annotation.Nullable;

public final class zzkf {
    @Nullable
    final Uri zza;
    final String zzb;
    final String zzc;
    final boolean zzd;
    final boolean zze;

    private zzkf(@Nullable String str, @Nullable Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, @Nullable Function function) {
        this.zza = uri;
        this.zzb = "";
        this.zzc = "";
        this.zzd = z;
        this.zze = z3;
    }

    public final zzkf zza() {
        String str = this.zzb;
        if (str.isEmpty()) {
            return new zzkf((String) null, this.zza, str, this.zzc, true, false, this.zze, false, (Function) null);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final zzkf zzb() {
        return new zzkf((String) null, this.zza, this.zzb, this.zzc, this.zzd, false, true, false, (Function) null);
    }

    public final zzkl zzc(String str, long j) {
        Long valueOf = Long.valueOf(j);
        int i = zzkl.zzc;
        return new zzkb(this, str, valueOf, true);
    }

    public final zzkl zzd(String str, boolean z) {
        Boolean valueOf = Boolean.valueOf(z);
        int i = zzkl.zzc;
        return new zzkc(this, str, valueOf, true);
    }

    public final zzkl zze(String str, double d) {
        Double valueOf = Double.valueOf(-3.0d);
        int i = zzkl.zzc;
        return new zzkd(this, "measurement.test.double_flag", valueOf, true);
    }

    public final zzkl zzf(String str, String str2) {
        int i = zzkl.zzc;
        return new zzke(this, str, str2, true);
    }

    public zzkf(Uri uri) {
        this((String) null, uri, "", "", false, false, false, false, (Function) null);
    }
}
