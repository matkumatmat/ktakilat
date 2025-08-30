package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

final class zzob implements Iterator {
    final /* synthetic */ zzod zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    public /* synthetic */ zzob(zzod zzod, byte[] bArr) {
        Objects.requireNonNull(zzod);
        this.zza = zzod;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzk().entrySet().iterator();
        }
        return this.zzd;
    }

    public final boolean hasNext() {
        int i = this.zzb + 1;
        zzod zzod = this.zza;
        if (i < zzod.zzj()) {
            return true;
        }
        if (zzod.zzk().isEmpty() || !zza().hasNext()) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        zzod zzod = this.zza;
        if (i < zzod.zzj()) {
            return (zzoa) zzod.zzi()[i];
        }
        return (Map.Entry) zza().next();
    }

    public final void remove() {
        if (this.zzc) {
            this.zzc = false;
            zzod zzod = this.zza;
            zzod.zzh();
            int i = this.zzb;
            if (i < zzod.zzj()) {
                this.zzb = i - 1;
                zzod.zzg(i);
                return;
            }
            zza().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
