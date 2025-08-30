package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public final class zzgp {
    private static zzgp zza;
    private final zzib zzb;
    private final TelemetryLoggingClient zzc;
    private final AtomicLong zzd = new AtomicLong(-1);

    private zzgp(Context context, zzib zzib) {
        this.zzc = TelemetryLogging.getClient(context, TelemetryLoggingOptions.builder().setApi("measurement:api").build());
        this.zzb = zzib;
    }

    public static zzgp zza(zzib zzib) {
        if (zza == null) {
            zza = new zzgp(zzib.zzaY(), zzib);
        }
        return zza;
    }

    public final synchronized void zzb(int i, int i2, long j, long j2, int i3) {
        synchronized (this) {
            long elapsedRealtime = this.zzb.zzaZ().elapsedRealtime();
            AtomicLong atomicLong = this.zzd;
            if (atomicLong.get() != -1) {
                if (elapsedRealtime - atomicLong.get() <= 1800000) {
                    return;
                }
            }
            this.zzc.log(new TelemetryData(0, Arrays.asList(new MethodInvocation[]{new MethodInvocation(36301, i2, 0, j, j2, (String) null, (String) null, 0, i3)}))).addOnFailureListener(new zzgo(this, elapsedRealtime));
        }
    }

    public final /* synthetic */ void zzc(long j, Exception exc) {
        this.zzd.set(j);
    }
}
