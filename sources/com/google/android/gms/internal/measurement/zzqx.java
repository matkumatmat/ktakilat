package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzqx implements Supplier {
    private static final zzqx zza = new zzqx();
    private final Supplier zzb = Suppliers.ofInstance(new zzqz());

    @SideEffectFree
    public static boolean zza() {
        return zza.get().zza();
    }

    /* renamed from: zzb */
    public final zzqy get() {
        return (zzqy) this.zzb.get();
    }
}
