package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzpt implements Supplier {
    private static final zzpt zza = new zzpt();
    private final Supplier zzb = Suppliers.ofInstance(new zzpv());

    @SideEffectFree
    public static boolean zza() {
        return zza.get().zza();
    }

    /* renamed from: zzb */
    public final zzpu get() {
        return (zzpu) this.zzb.get();
    }
}
