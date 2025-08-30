package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzpz implements Supplier {
    private static final zzpz zza = new zzpz();
    private final Supplier zzb = Suppliers.ofInstance(new zzqb());

    @SideEffectFree
    public static boolean zza() {
        return zza.get().zza();
    }

    /* renamed from: zzb */
    public final zzqa get() {
        return (zzqa) this.zzb.get();
    }
}
