package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

final class zzpb {
    zzid zza;
    List zzb;
    List zzc;
    long zzd;
    final /* synthetic */ zzpf zze;

    public /* synthetic */ zzpb(zzpf zzpf, byte[] bArr) {
        Objects.requireNonNull(zzpf);
        this.zze = zzpf;
    }

    private static final long zzb(zzhs zzhs) {
        return ((zzhs.zzf() / 1000) / 60) / 60;
    }

    public final boolean zza(long j, zzhs zzhs) {
        Preconditions.checkNotNull(zzhs);
        if (this.zzc == null) {
            this.zzc = new ArrayList();
        }
        if (this.zzb == null) {
            this.zzb = new ArrayList();
        }
        if (!this.zzc.isEmpty() && zzb((zzhs) this.zzc.get(0)) != zzb(zzhs)) {
            return false;
        }
        long zzcn = this.zzd + ((long) zzhs.zzcn());
        zzpf zzpf = this.zze;
        if (!zzpf.zzd().zzp((String) null, zzfx.zzbe)) {
            zzpf.zzd();
            if (zzcn >= ((long) zzal.zzG())) {
                return false;
            }
        } else if (!this.zzc.isEmpty()) {
            zzpf.zzd();
            if (zzcn >= ((long) zzal.zzG())) {
                return false;
            }
        }
        this.zzd = zzcn;
        this.zzc.add(zzhs);
        this.zzb.add(Long.valueOf(j));
        int size = this.zzc.size();
        zzpf.zzd();
        if (size >= Math.max(1, ((Integer) zzfx.zzj.zzb((Object) null)).intValue())) {
            return false;
        }
        return true;
    }
}
