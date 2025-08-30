package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzpw implements Supplier {
    private static final zzpw zza = new zzpw();
    private final Supplier zzb = Suppliers.ofInstance(new zzpy());

    @SideEffectFree
    public static boolean zza() {
        return zza.get().zza();
    }

    /* renamed from: zzb */
    public final zzpx get() {
        return (zzpx) this.zzb.get();
    }
}
