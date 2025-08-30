package com.google.android.gms.internal.measurement;

final class zznb implements zznj {
    private final zznj[] zza;

    public zznb(zznj... zznjArr) {
        this.zza = zznjArr;
    }

    public final boolean zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzni zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            zznj zznj = this.zza[i];
            if (zznj.zzb(cls)) {
                return zznj.zzc(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }
}
