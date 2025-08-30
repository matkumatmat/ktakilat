package com.google.android.gms.measurement.internal;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.util.Objects;

final class zzgq implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ Object zzd;
    final /* synthetic */ Object zze;
    final /* synthetic */ zzgt zzf;

    public zzgq(zzgt zzgt, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
        Objects.requireNonNull(zzgt);
        this.zzf = zzgt;
    }

    public final void run() {
        zzgt zzgt = this.zzf;
        zzhg zzd2 = zzgt.zzu.zzd();
        if (zzd2.zzv()) {
            if (zzgt.zzr() == 0) {
                zzib zzib = zzgt.zzu;
                if (zzib.zzc().zzj()) {
                    zzib.zzaU();
                    zzgt.zzs('C');
                } else {
                    zzib.zzaU();
                    zzgt.zzs('c');
                }
            }
            if (zzgt.zzt() < 0) {
                zzgt.zzu.zzc().zzi();
                zzgt.zzu(130000);
            }
            int i = this.zza;
            char zzr = zzgt.zzr();
            long zzt = zzgt.zzt();
            String str = this.zzb;
            Object obj = this.zzc;
            Object obj2 = this.zzd;
            Object obj3 = this.zze;
            char charAt = "01VDIWEA?".charAt(i);
            String zzo = zzgt.zzo(true, str, obj, obj2, obj3);
            int length = String.valueOf(charAt).length();
            StringBuilder sb = new StringBuilder(length + 1 + String.valueOf(zzr).length() + String.valueOf(zzt).length() + 1 + zzo.length());
            sb.append(ExifInterface.GPS_MEASUREMENT_2D);
            sb.append(charAt);
            sb.append(zzr);
            sb.append(zzt);
            sb.append(":");
            sb.append(zzo);
            String sb2 = sb.toString();
            if (sb2.length() > 1024) {
                sb2 = str.substring(0, 1024);
            }
            zzhe zzhe = zzd2.zzb;
            if (zzhe != null) {
                zzhe.zza(sb2, 1);
                return;
            }
            return;
        }
        Log.println(6, zzgt.zzn(), "Persisted config not initialized. Not logging error/warn");
    }
}
