package com.google.android.gms.internal.auth;

import android.content.Context;
import javax.annotation.Nullable;

final class zzcd extends zzda {
    private final Context zza;
    private final zzdj zzb;

    public zzcd(Context context, @Nullable zzdj zzdj) {
        this.zza = context;
        this.zzb = zzdj;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzda) {
            zzda zzda = (zzda) obj;
            if (!this.zza.equals(zzda.zza()) || !this.zzb.equals(zzda.zzb())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
    }

    public final String toString() {
        return e.o("FlagsContext{context=", this.zza.toString(), ", hermeticFileOverrides=", this.zzb.toString(), "}");
    }

    public final Context zza() {
        return this.zza;
    }

    @Nullable
    public final zzdj zzb() {
        return this.zzb;
    }
}
