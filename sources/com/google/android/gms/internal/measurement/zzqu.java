package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzqu implements Supplier {
    private static final zzqu zza = new zzqu();
    private final Supplier zzb = Suppliers.ofInstance(new zzqw());

    @SideEffectFree
    public static boolean zza() {
        zza.get().zza();
        return true;
    }

    @SideEffectFree
    public static boolean zzb() {
        return zza.get().zzb();
    }

    /* renamed from: zzc */
    public final zzqv get() {
        return (zzqv) this.zzb.get();
    }
}
