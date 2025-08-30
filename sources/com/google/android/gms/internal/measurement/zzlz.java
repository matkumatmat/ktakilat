package com.google.android.gms.internal.measurement;

final class zzlz implements zznj {
    private static final zzlz zza = new zzlz();

    private zzlz() {
    }

    public static zzlz zza() {
        return zza;
    }

    public final boolean zzb(Class cls) {
        return zzme.class.isAssignableFrom(cls);
    }

    public final zzni zzc(Class cls) {
        Class<zzme> cls2 = zzme.class;
        if (cls2.isAssignableFrom(cls)) {
            try {
                return (zzni) zzme.zzco(cls.asSubclass(cls2)).zzl(3, (Object) null, (Object) null);
            } catch (Exception e) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
    }
}
