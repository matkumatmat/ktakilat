package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzov implements Supplier {
    private static final zzov zza = new zzov();
    private final Supplier zzb = Suppliers.ofInstance(new zzox());

    @SideEffectFree
    public static boolean zza() {
        return zza.get().zza();
    }

    /* renamed from: zzb */
    public final zzow get() {
        return (zzow) this.zzb.get();
    }
}
