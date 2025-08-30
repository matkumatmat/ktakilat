package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzqc implements Supplier {
    private static final zzqc zza = new zzqc();
    private final Supplier zzb = Suppliers.ofInstance(new zzqe());

    @SideEffectFree
    public static boolean zza() {
        return zza.get().zza();
    }

    /* renamed from: zzb */
    public final zzqd get() {
        return (zzqd) this.zzb.get();
    }
}
