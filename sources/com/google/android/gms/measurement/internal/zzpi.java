package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzis;
import java.util.Map;

public final class zzpi {
    private final long zza;
    private final zzib zzb;
    private final String zzc;
    private final Map zzd;
    private final zzlr zze;
    private final long zzf;
    private final long zzg;
    private final long zzh;
    private final int zzi;

    public /* synthetic */ zzpi(long j, zzib zzib, String str, Map map, zzlr zzlr, long j2, long j3, long j4, int i, byte[] bArr) {
        this.zza = j;
        this.zzb = zzib;
        this.zzc = str;
        this.zzd = map;
        this.zze = zzlr;
        this.zzf = j2;
        this.zzg = j3;
        this.zzh = j4;
        this.zzi = i;
    }

    public final zzos zza() {
        return new zzos(this.zzc, this.zzd, this.zze, (zzis) null);
    }

    public final zzol zzb() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.zzd.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        long j = this.zza;
        zzib zzib = this.zzb;
        String str = this.zzc;
        zzlr zzlr = this.zze;
        long j2 = this.zzg;
        return new zzol(j, zzib.zzcc(), str, bundle, zzlr.zza(), j2, "");
    }

    public final long zzc() {
        return this.zza;
    }

    @Nullable
    public final zzib zzd() {
        return this.zzb;
    }

    public final String zze() {
        return this.zzc;
    }

    public final zzlr zzf() {
        return this.zze;
    }

    public final long zzg() {
        return this.zzf;
    }

    public final long zzh() {
        return this.zzh;
    }

    public final int zzi() {
        return this.zzi;
    }
}
