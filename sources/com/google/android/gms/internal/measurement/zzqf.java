package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzqf implements Supplier {
    private static final zzqf zza = new zzqf();
    private final Supplier zzb = Suppliers.ofInstance(new zzqh());

    @SideEffectFree
    public static boolean zza() {
        return zza.get().zza();
    }

    /* renamed from: zzb */
    public final zzqg get() {
        return (zzqg) this.zzb.get();
    }
}
