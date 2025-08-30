package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzlq {
    static final zzlq zza = new zzlq(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzlq zzd;
    private final Map zze;

    public zzlq() {
        this.zze = new HashMap();
    }

    public static zzlq zza() {
        zzlq zzlq = zzd;
        if (zzlq != null) {
            return zzlq;
        }
        synchronized (zzlq.class) {
            try {
                zzlq zzlq2 = zzd;
                if (zzlq2 != null) {
                    return zzlq2;
                }
                int i = zznt.zza;
                zzlq zzb2 = zzly.zzb(zzlq.class);
                zzd = zzb2;
                return zzb2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzmd zzb(zznl zznl, int i) {
        return (zzmd) this.zze.get(new zzlp(zznl, i));
    }

    public zzlq(boolean z) {
        this.zze = Collections.emptyMap();
    }
}
