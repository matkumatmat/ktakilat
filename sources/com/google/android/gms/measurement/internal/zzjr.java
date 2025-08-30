package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdd;

public final class zzjr {
    final Context zza;
    @Nullable
    Boolean zzb;
    long zzc;
    @Nullable
    zzdd zzd;
    boolean zze = true;
    @Nullable
    final Long zzf;
    @Nullable
    String zzg;

    public zzjr(Context context, @Nullable zzdd zzdd, @Nullable Long l) {
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zza = applicationContext;
        this.zzf = l;
        if (zzdd != null) {
            this.zzd = zzdd;
            this.zze = zzdd.zzc;
            this.zzc = zzdd.zzb;
            this.zzg = zzdd.zze;
            Bundle bundle = zzdd.zzd;
            if (bundle != null) {
                this.zzb = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
