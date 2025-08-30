package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzil;
import com.google.android.gms.internal.measurement.zzin;
import com.google.android.gms.internal.measurement.zzis;
import java.util.Collections;
import java.util.HashMap;

public final class zzot extends zzok {
    public zzot(zzpf zzpf) {
        super(zzpf);
    }

    private final String zzd(String str) {
        String zzc = this.zzg.zzh().zzc(str);
        if (TextUtils.isEmpty(zzc)) {
            return (String) zzfx.zzq.zzb((Object) null);
        }
        Uri parse = Uri.parse((String) zzfx.zzq.zzb((Object) null));
        Uri.Builder buildUpon = parse.buildUpon();
        String authority = parse.getAuthority();
        StringBuilder sb = new StringBuilder(String.valueOf(zzc).length() + 1 + String.valueOf(authority).length());
        sb.append(zzc);
        sb.append(".");
        sb.append(authority);
        buildUpon.authority(sb.toString());
        return buildUpon.build().toString();
    }

    private static final boolean zzf(String str) {
        String str2 = (String) zzfx.zzs.zzb((Object) null);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        for (String trim : str2.split(",")) {
            if (str.equalsIgnoreCase(trim.trim())) {
                return true;
            }
        }
        return false;
    }

    public final zzos zza(String str) {
        zzh zzu;
        zzpf zzpf = this.zzg;
        zzh zzu2 = zzpf.zzj().zzu(str);
        zzos zzos = null;
        if (zzu2 == null || !zzu2.zzai()) {
            return new zzos(zzd(str), Collections.emptyMap(), zzlr.GOOGLE_ANALYTICS, (zzis) null);
        }
        zzil zzb = zzis.zzb();
        zzb.zzb(2);
        zzb.zza((zzin) Preconditions.checkNotNull(zzin.zzb(zzu2.zzaL())));
        String zzd = zzu2.zzd();
        zzgl zzb2 = zzpf.zzh().zzb(str);
        if (zzb2 == null || (zzu = zzpf.zzj().zzu(str)) == null || ((!zzb2.zzp() || zzb2.zzq().zzc() != 100) && !this.zzu.zzk().zzaa(str, zzu.zzay()) && (TextUtils.isEmpty(zzd) || Math.abs(zzd.hashCode() % 100) >= zzb2.zzq().zzc()))) {
            zzb.zzc(3);
            return new zzos(zzd(str), Collections.emptyMap(), zzlr.GOOGLE_ANALYTICS, (zzis) zzb.zzbc());
        }
        String zzc = zzu2.zzc();
        zzb.zzb(2);
        zzgl zzb3 = zzpf.zzh().zzb(zzu2.zzc());
        if (zzb3 == null || !zzb3.zzp()) {
            this.zzu.zzaV().zzk().zzb("[sgtm] Missing sgtm_setting in remote config. appId", zzc);
            zzb.zzc(4);
        } else {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(zzu2.zzay())) {
                hashMap.put("x-gtm-server-preview", zzu2.zzay());
            }
            String zzd2 = zzb3.zzq().zzd();
            zzin zzb4 = zzin.zzb(zzu2.zzaL());
            if (zzb4 != null && zzb4 != zzin.CLIENT_UPLOAD_ELIGIBLE) {
                zzb.zza(zzb4);
            } else if (zzf(zzu2.zzc())) {
                zzb.zza(zzin.PINNED_TO_SERVICE_UPLOAD);
            } else if (TextUtils.isEmpty(zzd2)) {
                zzb.zza(zzin.MISSING_SGTM_SERVER_URL);
            } else {
                this.zzu.zzaV().zzk().zzb("[sgtm] Eligible for client side upload. appId", zzc);
                zzb.zzb(3);
                zzb.zza(zzin.CLIENT_UPLOAD_ELIGIBLE);
                zzos = new zzos(zzd2, hashMap, zzlr.SGTM_CLIENT, (zzis) zzb.zzbc());
            }
            zzb3.zzq().zza();
            zzb3.zzq().zzb();
            zzib zzib = this.zzu;
            zzib.zzaU();
            if (!TextUtils.isEmpty(zzd2)) {
                zzib.zzaV().zzk().zzb("[sgtm] Eligible for local service direct upload. appId", zzc);
                zzb.zzb(5);
                zzb.zzc(2);
                zzos = new zzos(zzd2, hashMap, zzlr.SGTM, (zzis) zzb.zzbc());
            } else {
                zzb.zzc(6);
                zzib.zzaV().zzk().zzb("[sgtm] Local service, missing sgtm_server_url", zzu2.zzc());
            }
        }
        if (zzos != null) {
            return zzos;
        }
        return new zzos(zzd(str), Collections.emptyMap(), zzlr.GOOGLE_ANALYTICS, (zzis) zzb.zzbc());
    }

    @WorkerThread
    public final boolean zzc(String str, zzin zzin) {
        zzgl zzb;
        zzg();
        if (zzin != zzin.CLIENT_UPLOAD_ELIGIBLE || zzf(str) || (zzb = this.zzg.zzh().zzb(str)) == null || !zzb.zzp() || zzb.zzq().zzd().isEmpty()) {
            return false;
        }
        return true;
    }
}
