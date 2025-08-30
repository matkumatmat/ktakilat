package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.common.base.Supplier;
import javax.annotation.Nullable;

final class zzjn extends zzkg {
    private final Context zza;
    @Nullable
    private final Supplier zzb;

    public zzjn(Context context, @Nullable Supplier supplier) {
        this.zza = context;
        this.zzb = supplier;
    }

    public final boolean equals(Object obj) {
        Supplier supplier;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzkg) {
            zzkg zzkg = (zzkg) obj;
            if (!this.zza.equals(zzkg.zza()) || ((supplier = this.zzb) != null ? !supplier.equals(zzkg.zzb()) : zzkg.zzb() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = this.zza.hashCode() ^ 1000003;
        Supplier supplier = this.zzb;
        if (supplier == null) {
            i = 0;
        } else {
            i = supplier.hashCode();
        }
        return (hashCode * 1000003) ^ i;
    }

    public final String toString() {
        String obj = this.zza.toString();
        int length = obj.length();
        String valueOf = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(length + 45 + valueOf.length() + 1);
        sb.append("FlagsContext{context=");
        sb.append(obj);
        sb.append(", hermeticFileOverrides=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }

    public final Context zza() {
        return this.zza;
    }

    @Nullable
    public final Supplier zzb() {
        return this.zzb;
    }
}
