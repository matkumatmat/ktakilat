package com.google.android.gms.measurement.internal;

final /* synthetic */ class zznv implements Runnable {
    private final /* synthetic */ zznw zza;

    public /* synthetic */ zznv(zznw zznw) {
        this.zza = zznw;
    }

    public final /* synthetic */ void run() {
        long j;
        zznw zznw = this.zza;
        zzob zzob = zznw.zzc.zza;
        zzob.zzg();
        zzib zzib = zzob.zzu;
        zzib.zzaV().zzj().zza("Application going to the background");
        zzib.zzd().zzn.zzb(true);
        zzob.zzh(true);
        if (!zzib.zzc().zzv()) {
            long j2 = zznw.zzb;
            zznz zznz = zzob.zzb;
            zznz.zzd(false, false, j2);
            zznz.zzb(j2);
        }
        zzib.zzaV().zzi().zzb("Application backgrounded at: timestamp_millis", Long.valueOf(zznw.zza));
        zzib zzib2 = zzob.zzu;
        zzli zzj = zzib2.zzj();
        zzj.zzg();
        zzib zzib3 = zzj.zzu;
        zzj.zzb();
        zznk zzt = zzib3.zzt();
        zzt.zzg();
        zzt.zzb();
        if (!zzt.zzK() || zzt.zzu.zzk().zzah() >= 242600) {
            zzib3.zzt().zzF();
        }
        if (zzib.zzc().zzp((String) null, zzfx.zzaN)) {
            if (zzib.zzk().zzaa(zzib.zzaY().getPackageName(), zzib.zzc().zzz())) {
                j = 1000;
            } else {
                j = zzib.zzc().zzl(zzib.zzaY().getPackageName(), zzfx.zzD);
            }
            zzib.zzaV().zzk().zzb("[sgtm] Scheduling batch upload with minimum latency in millis", Long.valueOf(j));
            zzib2.zzx().zzh(j);
        }
    }
}
