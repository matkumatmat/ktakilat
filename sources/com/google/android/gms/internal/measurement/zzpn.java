package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzpn implements Supplier {
    private static final zzpn zza = new zzpn();
    private final Supplier zzb = Suppliers.ofInstance(new zzpp());

    @SideEffectFree
    public static boolean zza() {
        zza.get().zza();
        return true;
    }

    @SideEffectFree
    public static boolean zzb() {
        return zza.get().zzb();
    }

    @SideEffectFree
    public static boolean zzc() {
        return zza.get().zzc();
    }

    /* renamed from: zzd */
    public final zzpo get() {
        return (zzpo) this.zzb.get();
    }
}
