package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;

public final class zzw extends BroadcastReceiver {
    private final zzib zza;

    public zzw(zzib zzib) {
        this.zza = zzib;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0065  */
    @androidx.annotation.MainThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReceive(android.content.Context r3, android.content.Intent r4) {
        /*
            r2 = this;
            if (r4 != 0) goto L_0x000a
            com.google.android.gms.measurement.internal.zzib r3 = r2.zza
            java.lang.String r4 = "App receiver called with null intent"
            defpackage.e.C(r3, r4)
            return
        L_0x000a:
            java.lang.String r3 = r4.getAction()
            if (r3 != 0) goto L_0x0018
            com.google.android.gms.measurement.internal.zzib r3 = r2.zza
            java.lang.String r4 = "App receiver called with null action"
            defpackage.e.C(r3, r4)
            return
        L_0x0018:
            int r4 = r3.hashCode()
            r0 = -1928239649(0xffffffff8d1165df, float:-4.4804198E-31)
            r1 = 1
            if (r4 == r0) goto L_0x0032
            r0 = 1279883384(0x4c497878, float:5.2814304E7)
            if (r4 == r0) goto L_0x0028
            goto L_0x003c
        L_0x0028:
            java.lang.String r4 = "com.google.android.gms.measurement.BATCHES_AVAILABLE"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x003c
            r3 = 1
            goto L_0x003d
        L_0x0032:
            java.lang.String r4 = "com.google.android.gms.measurement.TRIGGERS_AVAILABLE"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x003c
            r3 = 0
            goto L_0x003d
        L_0x003c:
            r3 = -1
        L_0x003d:
            if (r3 == 0) goto L_0x0065
            if (r3 == r1) goto L_0x0049
            com.google.android.gms.measurement.internal.zzib r3 = r2.zza
            java.lang.String r4 = "App receiver called with unknown action"
            defpackage.e.C(r3, r4)
            return
        L_0x0049:
            com.google.android.gms.measurement.internal.zzib r3 = r2.zza
            com.google.android.gms.measurement.internal.zzgt r4 = r3.zzaV()
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zzk()
            java.lang.String r0 = "[sgtm] App Receiver notified batches are available"
            r4.zza(r0)
            com.google.android.gms.measurement.internal.zzhy r3 = r3.zzaW()
            com.google.android.gms.measurement.internal.zzt r4 = new com.google.android.gms.measurement.internal.zzt
            r4.<init>(r2)
            r3.zzj(r4)
            return
        L_0x0065:
            com.google.android.gms.measurement.internal.zzib r3 = r2.zza
            com.google.android.gms.internal.measurement.zzql.zza()
            com.google.android.gms.measurement.internal.zzal r4 = r3.zzc()
            r0 = 0
            com.google.android.gms.measurement.internal.zzfw r1 = com.google.android.gms.measurement.internal.zzfx.zzaQ
            boolean r4 = r4.zzp(r0, r1)
            if (r4 != 0) goto L_0x0078
            return
        L_0x0078:
            com.google.android.gms.measurement.internal.zzgt r4 = r3.zzaV()
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zzk()
            java.lang.String r0 = "App receiver notified triggers are available"
            r4.zza(r0)
            com.google.android.gms.measurement.internal.zzhy r4 = r3.zzaW()
            com.google.android.gms.measurement.internal.zzu r0 = new com.google.android.gms.measurement.internal.zzu
            r0.<init>(r3)
            r4.zzj(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzw.onReceive(android.content.Context, android.content.Intent):void");
    }

    public final /* synthetic */ void zza() {
        this.zza.zzx().zzh(((Long) zzfx.zzC.zzb((Object) null)).longValue());
    }
}
