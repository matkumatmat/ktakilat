package com.google.android.gms.internal.measurement;

final class zznc implements zznx {
    private static final zznj zzb = new zzna();
    private final zznj zza;

    public zznc() {
        zzlz zza2 = zzlz.zza();
        int i = zznt.zza;
        zznb zznb = new zznb(zza2, zzb);
        byte[] bArr = zzmo.zzb;
        this.zza = zznb;
    }

    public final zznw zza(Class cls) {
        zzlr zzlr;
        int i = zzny.zza;
        if (!zzme.class.isAssignableFrom(cls)) {
            int i2 = zznt.zza;
        }
        zzni zzc = this.zza.zzc(cls);
        if (!zzc.zza()) {
            int i3 = zznt.zza;
            zznq zza2 = zznr.zza();
            zzmx zza3 = zzmy.zza();
            zzoh zzA = zzny.zzA();
            if (zzc.zzc() - 1 != 1) {
                zzlr = zzlt.zza();
            } else {
                zzlr = null;
            }
            return zzno.zzl(cls, zzc, zza2, zza3, zzA, zzlr, zznh.zza());
        }
        int i4 = zznt.zza;
        return zznp.zzg(zzny.zzA(), zzlt.zza(), zzc.zzb());
    }
}
