package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

public final class zzhr extends zzma implements zznm {
    private zzhr() {
        throw null;
    }

    public final List zza() {
        return Collections.unmodifiableList(((zzhs) this.zza).zza());
    }

    public final int zzb() {
        return ((zzhs) this.zza).zzb();
    }

    public final zzhw zzc(int i) {
        return ((zzhs) this.zza).zzc(i);
    }

    public final zzhr zzd(int i, zzhw zzhw) {
        zzaX();
        ((zzhs) this.zza).zzm(i, zzhw);
        return this;
    }

    public final zzhr zze(int i, zzhv zzhv) {
        zzaX();
        ((zzhs) this.zza).zzm(i, (zzhw) zzhv.zzbc());
        return this;
    }

    public final zzhr zzf(zzhw zzhw) {
        zzaX();
        ((zzhs) this.zza).zzn(zzhw);
        return this;
    }

    public final zzhr zzg(zzhv zzhv) {
        zzaX();
        ((zzhs) this.zza).zzn((zzhw) zzhv.zzbc());
        return this;
    }

    public final zzhr zzh(Iterable iterable) {
        zzaX();
        ((zzhs) this.zza).zzo(iterable);
        return this;
    }

    public final zzhr zzi() {
        zzaX();
        ((zzhs) this.zza).zzp();
        return this;
    }

    public final zzhr zzj(int i) {
        zzaX();
        ((zzhs) this.zza).zzq(i);
        return this;
    }

    public final String zzk() {
        return ((zzhs) this.zza).zzd();
    }

    public final zzhr zzl(String str) {
        zzaX();
        ((zzhs) this.zza).zzr(str);
        return this;
    }

    public final boolean zzm() {
        return ((zzhs) this.zza).zze();
    }

    public final long zzn() {
        return ((zzhs) this.zza).zzf();
    }

    public final zzhr zzo(long j) {
        zzaX();
        ((zzhs) this.zza).zzs(j);
        return this;
    }

    public final long zzp() {
        return ((zzhs) this.zza).zzh();
    }

    public final zzhr zzq(long j) {
        zzaX();
        ((zzhs) this.zza).zzt(j);
        return this;
    }

    public /* synthetic */ zzhr(byte[] bArr) {
        super(zzhs.zzi);
    }
}
