package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzrg implements Supplier {
    private static final zzrg zza = new zzrg();
    private final Supplier zzb = Suppliers.ofInstance(new zzri());

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
    public final zzrh get() {
        return (zzrh) this.zzb.get();
    }
}
