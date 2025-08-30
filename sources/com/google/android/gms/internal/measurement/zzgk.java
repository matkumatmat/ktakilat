package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

public final class zzgk extends zzma implements zznm {
    private zzgk() {
        throw null;
    }

    public final int zza() {
        return ((zzgl) this.zza).zzf();
    }

    public final zzgj zzb(int i) {
        return ((zzgl) this.zza).zzg(i);
    }

    public final zzgk zzc(int i, zzgi zzgi) {
        zzaX();
        ((zzgl) this.zza).zzt(i, (zzgj) zzgi.zzbc());
        return this;
    }

    public final List zzd() {
        return Collections.unmodifiableList(((zzgl) this.zza).zzh());
    }

    public final zzgk zze() {
        zzaX();
        ((zzgl) this.zza).zzu();
        return this;
    }

    public final zzgk zzf() {
        zzaX();
        ((zzgl) this.zza).zzv();
        return this;
    }

    public final List zzg() {
        return Collections.unmodifiableList(((zzgl) this.zza).zzk());
    }

    public final String zzh() {
        return ((zzgl) this.zza).zzm();
    }

    public /* synthetic */ zzgk(byte[] bArr) {
        super(zzgl.zzu);
    }
}
