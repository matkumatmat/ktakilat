package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import org.apache.commons.lang3.time.DateUtils;

final class zzof {
    private final Clock zza;
    private long zzb;

    public zzof(Clock clock) {
        Preconditions.checkNotNull(clock);
        this.zza = clock;
    }

    public final void zza() {
        this.zzb = this.zza.elapsedRealtime();
    }

    public final void zzb() {
        this.zzb = 0;
    }

    public final boolean zzc(long j) {
        if (this.zzb != 0 && this.zza.elapsedRealtime() - this.zzb < DateUtils.MILLIS_PER_HOUR) {
            return false;
        }
        return true;
    }
}
