package com.google.android.gms.measurement.internal;

import com.baidu.idl.face.platform.FaceEnvironment;
import java.util.HashMap;
import java.util.concurrent.Callable;

final /* synthetic */ class zzhq implements Callable {
    private final /* synthetic */ zzhs zza;
    private final /* synthetic */ String zzb;

    public /* synthetic */ zzhq(zzhs zzhs, String str) {
        this.zza = zzhs;
        this.zzb = str;
    }

    public final /* synthetic */ Object call() {
        zzhs zzhs = this.zza;
        zzav zzj = zzhs.zzg.zzj();
        String str = this.zzb;
        zzh zzu = zzj.zzu(str);
        HashMap hashMap = new HashMap();
        hashMap.put("platform", FaceEnvironment.OS);
        hashMap.put("package_name", str);
        zzhs.zzu.zzc().zzi();
        hashMap.put("gmp_version", 130000L);
        if (zzu != null) {
            String zzr = zzu.zzr();
            if (zzr != null) {
                hashMap.put("app_version", zzr);
            }
            hashMap.put("app_version_int", Long.valueOf(zzu.zzt()));
            hashMap.put("dynamite_version", Long.valueOf(zzu.zzB()));
        }
        return hashMap;
    }
}
