package com.google.android.gms.measurement.internal;

import android.net.Uri;
import java.util.Objects;

final class zzkw implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ Uri zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzkx zze;

    public zzkw(zzkx zzkx, boolean z, Uri uri, String str, String str2) {
        this.zza = z;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
        Objects.requireNonNull(zzkx);
        this.zze = zzkx;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0098 A[SYNTHETIC, Splitter:B:38:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e9 A[Catch:{ RuntimeException -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ea A[Catch:{ RuntimeException -> 0x00cd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r0 = "gclid="
            com.google.android.gms.measurement.internal.zzkx r2 = r1.zze
            com.google.android.gms.measurement.internal.zzli r3 = r2.zza
            r3.zzg()
            java.lang.String r4 = r1.zzd
            android.net.Uri r5 = r1.zzb
            com.google.android.gms.measurement.internal.zzib r6 = r3.zzu     // Catch:{ RuntimeException -> 0x00d2 }
            com.google.android.gms.measurement.internal.zzpo r7 = r6.zzk()     // Catch:{ RuntimeException -> 0x00d2 }
            java.lang.String r8 = "https://google.com/search?"
            boolean r9 = android.text.TextUtils.isEmpty(r4)     // Catch:{ RuntimeException -> 0x00d2 }
            java.lang.String r10 = "_cis"
            java.lang.String r11 = "Activity created with data 'referrer' without required params"
            java.lang.String r12 = "utm_medium"
            java.lang.String r13 = "utm_source"
            java.lang.String r14 = "utm_campaign"
            java.lang.String r15 = "gclid"
            if (r9 == 0) goto L_0x002b
        L_0x0029:
            r7 = 0
            goto L_0x0090
        L_0x002b:
            boolean r9 = r4.contains(r15)     // Catch:{ RuntimeException -> 0x00d2 }
            if (r9 != 0) goto L_0x007d
            java.lang.String r9 = "gbraid"
            boolean r9 = r4.contains(r9)     // Catch:{ RuntimeException -> 0x0079 }
            if (r9 != 0) goto L_0x007d
            boolean r9 = r4.contains(r14)     // Catch:{ RuntimeException -> 0x0079 }
            if (r9 != 0) goto L_0x007d
            boolean r9 = r4.contains(r13)     // Catch:{ RuntimeException -> 0x0079 }
            if (r9 != 0) goto L_0x007d
            boolean r9 = r4.contains(r12)     // Catch:{ RuntimeException -> 0x0079 }
            if (r9 != 0) goto L_0x007d
            java.lang.String r9 = "utm_id"
            boolean r9 = r4.contains(r9)     // Catch:{ RuntimeException -> 0x0079 }
            if (r9 != 0) goto L_0x007d
            java.lang.String r9 = "dclid"
            boolean r9 = r4.contains(r9)     // Catch:{ RuntimeException -> 0x0079 }
            if (r9 != 0) goto L_0x007d
            java.lang.String r9 = "srsltid"
            boolean r9 = r4.contains(r9)     // Catch:{ RuntimeException -> 0x0079 }
            if (r9 != 0) goto L_0x007d
            java.lang.String r9 = "sfmc_id"
            boolean r9 = r4.contains(r9)     // Catch:{ RuntimeException -> 0x0079 }
            if (r9 != 0) goto L_0x007d
            com.google.android.gms.measurement.internal.zzib r7 = r7.zzu     // Catch:{ RuntimeException -> 0x0079 }
            com.google.android.gms.measurement.internal.zzgt r7 = r7.zzaV()     // Catch:{ RuntimeException -> 0x0079 }
            com.google.android.gms.measurement.internal.zzgr r7 = r7.zzj()     // Catch:{ RuntimeException -> 0x0079 }
            r7.zza(r11)     // Catch:{ RuntimeException -> 0x0079 }
            goto L_0x0029
        L_0x0079:
            r0 = move-exception
            r1 = r2
            goto L_0x0165
        L_0x007d:
            java.lang.String r8 = r8.concat(r4)     // Catch:{ RuntimeException -> 0x00d2 }
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch:{ RuntimeException -> 0x00d2 }
            android.os.Bundle r7 = r7.zzi(r8)     // Catch:{ RuntimeException -> 0x00d2 }
            if (r7 == 0) goto L_0x0090
            java.lang.String r8 = "referrer"
            r7.putString(r10, r8)     // Catch:{ RuntimeException -> 0x0079 }
        L_0x0090:
            java.lang.String r8 = r1.zzc
            boolean r9 = r1.zza
            java.lang.String r1 = "_cmp"
            if (r9 == 0) goto L_0x00e1
            com.google.android.gms.measurement.internal.zzpo r9 = r6.zzk()     // Catch:{ RuntimeException -> 0x00d2 }
            android.os.Bundle r5 = r9.zzi(r5)     // Catch:{ RuntimeException -> 0x00d2 }
            if (r5 == 0) goto L_0x00e1
            java.lang.String r9 = "intent"
            r5.putString(r10, r9)     // Catch:{ RuntimeException -> 0x00d2 }
            boolean r9 = r5.containsKey(r15)     // Catch:{ RuntimeException -> 0x00d2 }
            if (r9 != 0) goto L_0x00d6
            if (r7 == 0) goto L_0x00d6
            boolean r9 = r7.containsKey(r15)     // Catch:{ RuntimeException -> 0x00d2 }
            if (r9 == 0) goto L_0x00d6
            java.lang.String r9 = "_cer"
            java.lang.String r10 = r7.getString(r15)     // Catch:{ RuntimeException -> 0x00d2 }
            r16 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x00cd }
            r2.<init>(r0)     // Catch:{ RuntimeException -> 0x00cd }
            r2.append(r10)     // Catch:{ RuntimeException -> 0x00cd }
            java.lang.String r0 = r2.toString()     // Catch:{ RuntimeException -> 0x00cd }
            r5.putString(r9, r0)     // Catch:{ RuntimeException -> 0x00cd }
            goto L_0x00d8
        L_0x00cd:
            r0 = move-exception
        L_0x00ce:
            r1 = r16
            goto L_0x0165
        L_0x00d2:
            r0 = move-exception
            r16 = r2
            goto L_0x00ce
        L_0x00d6:
            r16 = r2
        L_0x00d8:
            r3.zzF(r8, r1, r5)     // Catch:{ RuntimeException -> 0x00cd }
            com.google.android.gms.measurement.internal.zzx r0 = r3.zzb     // Catch:{ RuntimeException -> 0x00cd }
            r0.zzb(r8, r5)     // Catch:{ RuntimeException -> 0x00cd }
            goto L_0x00e3
        L_0x00e1:
            r16 = r2
        L_0x00e3:
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ RuntimeException -> 0x00cd }
            if (r0 == 0) goto L_0x00ea
            goto L_0x0158
        L_0x00ea:
            com.google.android.gms.measurement.internal.zzgt r0 = r6.zzaV()     // Catch:{ RuntimeException -> 0x00cd }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzj()     // Catch:{ RuntimeException -> 0x00cd }
            java.lang.String r2 = "Activity created with referrer"
            r0.zzb(r2, r4)     // Catch:{ RuntimeException -> 0x00cd }
            com.google.android.gms.measurement.internal.zzal r0 = r6.zzc()     // Catch:{ RuntimeException -> 0x00cd }
            com.google.android.gms.measurement.internal.zzfw r2 = com.google.android.gms.measurement.internal.zzfx.zzaG     // Catch:{ RuntimeException -> 0x00cd }
            r5 = 0
            boolean r0 = r0.zzp(r5, r2)     // Catch:{ RuntimeException -> 0x00cd }
            r2 = 1
            java.lang.String r5 = "_ldl"
            java.lang.String r9 = "auto"
            if (r0 == 0) goto L_0x0127
            if (r7 == 0) goto L_0x0115
            r3.zzF(r8, r1, r7)     // Catch:{ RuntimeException -> 0x00cd }
            com.google.android.gms.measurement.internal.zzx r0 = r3.zzb     // Catch:{ RuntimeException -> 0x00cd }
            r0.zzb(r8, r7)     // Catch:{ RuntimeException -> 0x00cd }
        L_0x0113:
            r0 = 0
            goto L_0x0123
        L_0x0115:
            com.google.android.gms.measurement.internal.zzgt r0 = r6.zzaV()     // Catch:{ RuntimeException -> 0x00cd }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzj()     // Catch:{ RuntimeException -> 0x00cd }
            java.lang.String r1 = "Referrer does not contain valid parameters"
            r0.zzb(r1, r4)     // Catch:{ RuntimeException -> 0x00cd }
            goto L_0x0113
        L_0x0123:
            r3.zzK(r9, r5, r0, r2)     // Catch:{ RuntimeException -> 0x00cd }
            return
        L_0x0127:
            boolean r0 = r4.contains(r15)     // Catch:{ RuntimeException -> 0x00cd }
            if (r0 == 0) goto L_0x0159
            boolean r0 = r4.contains(r14)     // Catch:{ RuntimeException -> 0x00cd }
            if (r0 != 0) goto L_0x014f
            boolean r0 = r4.contains(r13)     // Catch:{ RuntimeException -> 0x00cd }
            if (r0 != 0) goto L_0x014f
            boolean r0 = r4.contains(r12)     // Catch:{ RuntimeException -> 0x00cd }
            if (r0 != 0) goto L_0x014f
            java.lang.String r0 = "utm_term"
            boolean r0 = r4.contains(r0)     // Catch:{ RuntimeException -> 0x00cd }
            if (r0 != 0) goto L_0x014f
            java.lang.String r0 = "utm_content"
            boolean r0 = r4.contains(r0)     // Catch:{ RuntimeException -> 0x00cd }
            if (r0 == 0) goto L_0x0159
        L_0x014f:
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ RuntimeException -> 0x00cd }
            if (r0 != 0) goto L_0x0158
            r3.zzK(r9, r5, r4, r2)     // Catch:{ RuntimeException -> 0x00cd }
        L_0x0158:
            return
        L_0x0159:
            com.google.android.gms.measurement.internal.zzgt r0 = r6.zzaV()     // Catch:{ RuntimeException -> 0x00cd }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzj()     // Catch:{ RuntimeException -> 0x00cd }
            r0.zza(r11)     // Catch:{ RuntimeException -> 0x00cd }
            return
        L_0x0165:
            com.google.android.gms.measurement.internal.zzli r1 = r1.zza
            com.google.android.gms.measurement.internal.zzib r1 = r1.zzu
            com.google.android.gms.measurement.internal.zzgt r1 = r1.zzaV()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzb()
            java.lang.String r2 = "Throwable caught in handleReferrerForOnActivityCreated"
            r1.zzb(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkw.run():void");
    }
}
