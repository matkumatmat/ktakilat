package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzqr implements Supplier {
    private static final zzqr zza = new zzqr();
    private final Supplier zzb = Suppliers.ofInstance(new zzqt());

    @SideEffectFree
    public static boolean zza() {
        return zza.get().zza();
    }

    /* renamed from: zzb */
    public final zzqs get() {
        return (zzqs) this.zzb.get();
    }
}
