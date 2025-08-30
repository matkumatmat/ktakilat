package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzbq;
import com.google.firebase.messaging.Constants;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

final class zzhh implements Runnable {
    final /* synthetic */ zzbq zza;
    final /* synthetic */ ServiceConnection zzb;
    final /* synthetic */ zzhi zzc;

    public zzhh(zzhi zzhi, zzbq zzbq, ServiceConnection serviceConnection) {
        this.zza = zzbq;
        this.zzb = serviceConnection;
        Objects.requireNonNull(zzhi);
        this.zzc = zzhi;
    }

    public final void run() {
        Bundle bundle;
        zzhi zzhi = this.zzc;
        zzhj zzhj = zzhi.zza;
        zzib zzib = zzhj.zza;
        zzib.zzaW().zzg();
        Bundle bundle2 = new Bundle();
        String zza2 = zzhi.zza();
        bundle2.putString("package_name", zza2);
        try {
            bundle = this.zza.zze(bundle2);
            if (bundle == null) {
                zzib.zzaV().zzb().zza("Install Referrer Service returned a null response");
                bundle = null;
            }
        } catch (Exception e) {
            zzhj.zza.zzaV().zzb().zzb("Exception occurred while retrieving the Install Referrer", e.getMessage());
        }
        zzib zzib2 = zzhj.zza;
        zzib2.zzaW().zzg();
        zzib.zzL();
        if (bundle != null) {
            long j = bundle.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j == 0) {
                e.C(zzib2, "Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundle.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    e.w(zzib2, "No referrer defined in Install Referrer response");
                } else {
                    zzib2.zzaV().zzk().zzb("InstallReferrer API result", string);
                    Bundle zzi = zzib2.zzk().zzi(Uri.parse("?".concat(string)));
                    if (zzi == null) {
                        e.w(zzib2, "No campaign params defined in Install Referrer result");
                    } else {
                        List asList = Arrays.asList(((String) zzfx.zzbh.zzb((Object) null)).split(","));
                        Iterator<String> it = zzi.keySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            } else if (asList.contains(it.next())) {
                                long j2 = bundle.getLong("referrer_click_timestamp_server_seconds", 0) * 1000;
                                if (j2 > 0) {
                                    zzi.putLong("click_timestamp", j2);
                                }
                            }
                        }
                        if (j == zzib2.zzd().zzd.zza()) {
                            zzib2.zzaV().zzk().zza("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if (zzib2.zzB()) {
                            zzib2.zzd().zzd.zzb(j);
                            zzib2.zzaV().zzk().zzb("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            zzi.putString("_cis", "referrer API v2");
                            zzib2.zzj().zzI("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zzi, zza2);
                        }
                    }
                }
            }
        }
        ConnectionTracker.getInstance().unbindService(zzib2.zzaY(), this.zzb);
    }
}
