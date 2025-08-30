package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.firebase.messaging.Constants;
import org.apache.commons.lang3.time.DateUtils;

public final class zzx {
    private final zzib zza;

    public zzx(zzib zzib) {
        this.zza = zzib;
    }

    @WorkerThread
    public final void zza() {
        String str;
        zzib zzib = this.zza;
        zzib.zzaW().zzg();
        if (zze()) {
            if (zzd()) {
                zzib.zzd().zzr.zzb((String) null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1);
                zzib.zzj().zzF("auto", "_cmpx", bundle);
            } else {
                String zza2 = zzib.zzd().zzr.zza();
                if (TextUtils.isEmpty(zza2)) {
                    zzib.zzaV().zzc().zza("Cache still valid but referrer not found");
                } else {
                    long zza3 = zzib.zzd().zzs.zza() / DateUtils.MILLIS_PER_HOUR;
                    Uri parse = Uri.parse(zza2);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String next : parse.getQueryParameterNames()) {
                        bundle2.putString(next, parse.getQueryParameter(next));
                    }
                    ((Bundle) pair.second).putLong("_cc", (zza3 - 1) * DateUtils.MILLIS_PER_HOUR);
                    Object obj = pair.first;
                    if (obj == null) {
                        str = "app";
                    } else {
                        str = (String) obj;
                    }
                    zzib.zzj().zzF(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, (Bundle) pair.second);
                }
                zzib.zzd().zzr.zzb((String) null);
            }
            zzib.zzd().zzs.zzb(0);
        }
    }

    @WorkerThread
    public final void zzb(String str, Bundle bundle) {
        String str2;
        zzib zzib = this.zza;
        zzib.zzaW().zzg();
        if (!zzib.zzB()) {
            if (bundle.isEmpty()) {
                str2 = null;
            } else {
                if (true == str.isEmpty()) {
                    str = "auto";
                }
                Uri.Builder builder = new Uri.Builder();
                builder.path(str);
                for (String next : bundle.keySet()) {
                    builder.appendQueryParameter(next, bundle.getString(next));
                }
                str2 = builder.build().toString();
            }
            if (!TextUtils.isEmpty(str2)) {
                zzib.zzd().zzr.zzb(str2);
                zzib.zzd().zzs.zzb(zzib.zzaZ().currentTimeMillis());
            }
        }
    }

    public final void zzc() {
        if (zze() && zzd()) {
            this.zza.zzd().zzr.zzb((String) null);
        }
    }

    public final boolean zzd() {
        if (!zze()) {
            return false;
        }
        zzib zzib = this.zza;
        if (zzib.zzaZ().currentTimeMillis() - zzib.zzd().zzs.zza() > zzib.zzc().zzl((String) null, zzfx.zzaj)) {
            return true;
        }
        return false;
    }

    public final boolean zze() {
        if (this.zza.zzd().zzs.zza() > 0) {
            return true;
        }
        return false;
    }
}
