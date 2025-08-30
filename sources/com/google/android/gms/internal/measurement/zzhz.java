package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

public final class zzhz extends zzma implements zznm {
    private zzhz() {
        throw null;
    }

    public final List zza() {
        return Collections.unmodifiableList(((zzib) this.zza).zza());
    }

    public final int zzb() {
        return ((zzib) this.zza).zzb();
    }

    public final zzid zzc(int i) {
        return ((zzib) this.zza).zzc(i);
    }

    public final zzhz zzd(int i, zzic zzic) {
        zzaX();
        ((zzib) this.zza).zzj(i, (zzid) zzic.zzbc());
        return this;
    }

    public final zzhz zze(zzic zzic) {
        zzaX();
        ((zzib) this.zza).zzk((zzid) zzic.zzbc());
        return this;
    }

    public final zzhz zzf(Iterable iterable) {
        zzaX();
        ((zzib) this.zza).zzm(iterable);
        return this;
    }

    public final zzhz zzg() {
        zzaX();
        ((zzib) this.zza).zzn();
        return this;
    }

    public final String zzh() {
        return ((zzib) this.zza).zze();
    }

    public final zzhz zzi(String str) {
        zzaX();
        ((zzib) this.zza).zzo(str);
        return this;
    }

    public final zzhz zzj(String str) {
        zzaX();
        ((zzib) this.zza).zzp(str);
        return this;
    }

    public /* synthetic */ zzhz(byte[] bArr) {
        super(zzib.zzh);
    }
}
