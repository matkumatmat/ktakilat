package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

final class zzol extends zzon {
    public zzol(Unsafe unsafe) {
        super(unsafe);
    }

    public final void zza(Object obj, long j, byte b) {
        if (zzoo.zzb) {
            zzoo.zzD(obj, j, b);
        } else {
            zzoo.zzE(obj, j, b);
        }
    }

    public final boolean zzb(Object obj, long j) {
        if (zzoo.zzb) {
            return zzoo.zzu(obj, j);
        }
        return zzoo.zzv(obj, j);
    }

    public final void zzc(Object obj, long j, boolean z) {
        if (zzoo.zzb) {
            zzoo.zzD(obj, j, r3 ? (byte) 1 : 0);
        } else {
            zzoo.zzE(obj, j, r3 ? (byte) 1 : 0);
        }
    }

    public final float zzd(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    public final void zze(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    public final double zzf(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    public final void zzg(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }
}
