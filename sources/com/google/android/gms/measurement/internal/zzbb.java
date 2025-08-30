package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

public final class zzbb {
    final String zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final zzbe zzf;

    public zzbb(zzib zzib, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzbe zzbe;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = true == TextUtils.isEmpty(str) ? null : str;
        this.zzd = j;
        this.zze = j2;
        if (j2 != 0 && j2 > j) {
            zzib.zzaV().zze().zzb("Event created with reverse previous/current timestamps. appId", zzgt.zzl(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzbe = new zzbe(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzib.zzaV().zzb().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object zzE = zzib.zzk().zzE(next, bundle2.get(next));
                    if (zzE == null) {
                        zzib.zzaV().zze().zzb("Param value can't be null", zzib.zzl().zzb(next));
                        it.remove();
                    } else {
                        zzib.zzk().zzM(bundle2, next, zzE);
                    }
                }
            }
            zzbe = new zzbe(bundle2);
        }
        this.zzf = zzbe;
    }

    public final String toString() {
        String zzbe = this.zzf.toString();
        String str = this.zza;
        int length = String.valueOf(str).length();
        String str2 = this.zzb;
        StringBuilder sb = new StringBuilder(length + 22 + String.valueOf(str2).length() + 10 + zzbe.length() + 1);
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        return e.q(sb, "', params=", zzbe, "}");
    }

    public final zzbb zza(zzib zzib, long j) {
        return new zzbb(zzib, this.zzc, this.zza, this.zzb, this.zzd, j, this.zzf);
    }

    private zzbb(zzib zzib, String str, String str2, String str3, long j, long j2, zzbe zzbe) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzbe);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = true == TextUtils.isEmpty(str) ? null : str;
        this.zzd = j;
        this.zze = j2;
        if (j2 != 0 && j2 > j) {
            zzib.zzaV().zze().zzc("Event created with reverse previous/current timestamps. appId, name", zzgt.zzl(str2), zzgt.zzl(str3));
        }
        this.zzf = zzbe;
    }
}
