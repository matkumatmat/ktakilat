package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzrd implements Supplier {
    private static final zzrd zza = new zzrd();
    private final Supplier zzb = Suppliers.ofInstance(new zzrf());

    @SideEffectFree
    public static boolean zza() {
        return zza.get().zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return zza.get().zzb();
    }

    /* renamed from: zzc */
    public final zzre get() {
        return (zzre) this.zzb.get();
    }
}
