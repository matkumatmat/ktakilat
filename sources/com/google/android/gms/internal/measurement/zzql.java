package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzql implements Supplier {
    private static final zzql zza = new zzql();
    private final Supplier zzb = Suppliers.ofInstance(new zzqn());

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

    @SideEffectFree
    public static boolean zzd() {
        return zza.get().zzd();
    }

    @SideEffectFree
    public static boolean zze() {
        return zza.get().zze();
    }

    @SideEffectFree
    public static boolean zzf() {
        return zza.get().zzf();
    }

    @SideEffectFree
    public static boolean zzg() {
        return zza.get().zzg();
    }

    @SideEffectFree
    public static boolean zzh() {
        return zza.get().zzh();
    }

    @SideEffectFree
    public static boolean zzi() {
        return zza.get().zzi();
    }

    /* renamed from: zzj */
    public final zzqm get() {
        return (zzqm) this.zzb.get();
    }
}
