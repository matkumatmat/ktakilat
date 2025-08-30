package com.google.android.gms.internal.measurement;

final class zzbt extends zzbz {
    private String zza;
    private byte zzb;
    private int zzc;
    private int zzd;

    public final zzbz zza(String str) {
        this.zza = "";
        return this;
    }

    public final zzbz zzb(boolean z) {
        this.zzb = 1;
        return this;
    }

    public final zzca zzc() {
        if (this.zzb == 1 && this.zza != null && this.zzc != 0 && this.zzd != 0) {
            return new zzbu(this.zza, false, this.zzc, (zzbr) null, (zzbs) null, this.zzd, (byte[]) null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" fileOwner");
        }
        if (this.zzb == 0) {
            sb.append(" hasDifferentDmaOwner");
        }
        if (this.zzc == 0) {
            sb.append(" fileChecks");
        }
        if (this.zzd == 0) {
            sb.append(" filePurpose");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    public final zzbz zzd(int i) {
        this.zzc = i;
        return this;
    }

    public final zzbz zze(int i) {
        this.zzd = 1;
        return this;
    }
}
