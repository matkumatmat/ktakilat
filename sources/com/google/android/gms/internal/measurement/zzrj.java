package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzrj implements Supplier {
    private static final zzrj zza = new zzrj();
    private final Supplier zzb = Suppliers.ofInstance(new zzrl());

    @SideEffectFree
    public static boolean zza() {
        return zza.get().zza();
    }

    /* renamed from: zzb */
    public final zzrk get() {
        return (zzrk) this.zzb.get();
    }
}
