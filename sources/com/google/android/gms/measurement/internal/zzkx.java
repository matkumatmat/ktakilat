package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzdf;
import java.util.Objects;

@VisibleForTesting
@MainThread
final class zzkx implements Application.ActivityLifecycleCallbacks, zzkv {
    final /* synthetic */ zzli zza;

    public zzkx(zzli zzli) {
        Objects.requireNonNull(zzli);
        this.zza = zzli;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(zzdf.zza(activity), bundle);
    }

    public final void onActivityDestroyed(Activity activity) {
        zzb(zzdf.zza(activity));
    }

    @MainThread
    public final void onActivityPaused(Activity activity) {
        zzc(zzdf.zza(activity));
    }

    @MainThread
    public final void onActivityResumed(Activity activity) {
        zzd(zzdf.zza(activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zze(zzdf.zza(activity), bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044 A[Catch:{ RuntimeException -> 0x0027, all -> 0x0024 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007c A[Catch:{ RuntimeException -> 0x0027, all -> 0x0024 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007f A[Catch:{ RuntimeException -> 0x0027, all -> 0x0024 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.measurement.zzdf r9, android.os.Bundle r10) {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.zzli r0 = r8.zza     // Catch:{ RuntimeException -> 0x0027 }
            com.google.android.gms.measurement.internal.zzib r1 = r0.zzu     // Catch:{ RuntimeException -> 0x0027 }
            com.google.android.gms.measurement.internal.zzgt r2 = r1.zzaV()     // Catch:{ RuntimeException -> 0x0027 }
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzk()     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.String r3 = "onActivityCreated"
            r2.zza(r3)     // Catch:{ RuntimeException -> 0x0027 }
            android.content.Intent r2 = r9.zzc     // Catch:{ RuntimeException -> 0x0027 }
            if (r2 == 0) goto L_0x0090
            android.net.Uri r3 = r2.getData()     // Catch:{ RuntimeException -> 0x0027 }
            if (r3 == 0) goto L_0x002a
            boolean r4 = r3.isHierarchical()     // Catch:{ RuntimeException -> 0x0027 }
            if (r4 != 0) goto L_0x0022
            goto L_0x002a
        L_0x0022:
            r4 = r3
            goto L_0x0042
        L_0x0024:
            r0 = move-exception
            goto L_0x00b0
        L_0x0027:
            r0 = move-exception
            goto L_0x009a
        L_0x002a:
            android.os.Bundle r3 = r2.getExtras()     // Catch:{ RuntimeException -> 0x0027 }
            r4 = 0
            if (r3 == 0) goto L_0x0042
            java.lang.String r5 = "com.android.vending.referral_url"
            java.lang.String r3 = r3.getString(r5)     // Catch:{ RuntimeException -> 0x0027 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ RuntimeException -> 0x0027 }
            if (r5 != 0) goto L_0x0042
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ RuntimeException -> 0x0027 }
            goto L_0x0022
        L_0x0042:
            if (r4 == 0) goto L_0x0090
            boolean r3 = r4.isHierarchical()     // Catch:{ RuntimeException -> 0x0027 }
            if (r3 != 0) goto L_0x004b
            goto L_0x0090
        L_0x004b:
            r1.zzk()     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.String r0 = "android.intent.extra.REFERRER_NAME"
            java.lang.String r0 = r2.getStringExtra(r0)     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.String r2 = "android-app://com.google.android.googlequicksearchbox/https/www.google.com"
            boolean r2 = r2.equals(r0)     // Catch:{ RuntimeException -> 0x0027 }
            if (r2 != 0) goto L_0x0071
            java.lang.String r2 = "https://www.google.com"
            boolean r2 = r2.equals(r0)     // Catch:{ RuntimeException -> 0x0027 }
            if (r2 != 0) goto L_0x0071
            java.lang.String r2 = "android-app://com.google.appcrawler"
            boolean r0 = r2.equals(r0)     // Catch:{ RuntimeException -> 0x0027 }
            if (r0 == 0) goto L_0x006d
            goto L_0x0071
        L_0x006d:
            java.lang.String r0 = "auto"
        L_0x006f:
            r5 = r0
            goto L_0x0074
        L_0x0071:
            java.lang.String r0 = "gs"
            goto L_0x006f
        L_0x0074:
            java.lang.String r0 = "referrer"
            java.lang.String r6 = r4.getQueryParameter(r0)     // Catch:{ RuntimeException -> 0x0027 }
            if (r10 != 0) goto L_0x007f
            r0 = 1
            r3 = 1
            goto L_0x0081
        L_0x007f:
            r0 = 0
            r3 = 0
        L_0x0081:
            com.google.android.gms.measurement.internal.zzhy r0 = r1.zzaW()     // Catch:{ RuntimeException -> 0x0027 }
            com.google.android.gms.measurement.internal.zzkw r7 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ RuntimeException -> 0x0027 }
            r1 = r7
            r2 = r8
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ RuntimeException -> 0x0027 }
            r0.zzj(r7)     // Catch:{ RuntimeException -> 0x0027 }
            goto L_0x00ab
        L_0x0090:
            com.google.android.gms.measurement.internal.zzib r0 = r0.zzu
        L_0x0092:
            com.google.android.gms.measurement.internal.zzma r0 = r0.zzs()
            r0.zzm(r9, r10)
            return
        L_0x009a:
            com.google.android.gms.measurement.internal.zzli r1 = r8.zza     // Catch:{ all -> 0x0024 }
            com.google.android.gms.measurement.internal.zzib r1 = r1.zzu     // Catch:{ all -> 0x0024 }
            com.google.android.gms.measurement.internal.zzgt r1 = r1.zzaV()     // Catch:{ all -> 0x0024 }
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzb()     // Catch:{ all -> 0x0024 }
            java.lang.String r2 = "Throwable caught in onActivityCreated"
            r1.zzb(r2, r0)     // Catch:{ all -> 0x0024 }
        L_0x00ab:
            com.google.android.gms.measurement.internal.zzli r0 = r8.zza
            com.google.android.gms.measurement.internal.zzib r0 = r0.zzu
            goto L_0x0092
        L_0x00b0:
            com.google.android.gms.measurement.internal.zzli r1 = r8.zza
            com.google.android.gms.measurement.internal.zzib r1 = r1.zzu
            com.google.android.gms.measurement.internal.zzma r1 = r1.zzs()
            r1.zzm(r9, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkx.zza(com.google.android.gms.internal.measurement.zzdf, android.os.Bundle):void");
    }

    public final void zzb(zzdf zzdf) {
        this.zza.zzu.zzs().zzs(zzdf);
    }

    @MainThread
    public final void zzc(zzdf zzdf) {
        zzib zzib = this.zza.zzu;
        zzib.zzs().zzp(zzdf);
        zzob zzh = zzib.zzh();
        zzib zzib2 = zzh.zzu;
        zzib2.zzaW().zzj(new zznu(zzh, zzib2.zzaZ().elapsedRealtime()));
    }

    @MainThread
    public final void zzd(zzdf zzdf) {
        zzib zzib = this.zza.zzu;
        zzob zzh = zzib.zzh();
        zzib zzib2 = zzh.zzu;
        zzib2.zzaW().zzj(new zznt(zzh, zzib2.zzaZ().elapsedRealtime()));
        zzib.zzs().zzn(zzdf);
    }

    public final void zze(zzdf zzdf, Bundle bundle) {
        this.zza.zzu.zzs().zzq(zzdf, bundle);
    }
}
