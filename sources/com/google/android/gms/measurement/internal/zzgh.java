package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

public final class zzgh extends zzg {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private final long zzg;
    private final long zzh;
    private List zzi;
    private String zzj;
    private int zzk;
    private String zzl;
    private String zzm;
    private long zzn = 0;
    private String zzo = null;

    public zzgh(zzib zzib, long j, long j2) {
        super(zzib);
        this.zzg = j;
        this.zzh = j2;
    }

    public final boolean zze() {
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0181 A[Catch:{ IllegalStateException -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0182 A[Catch:{ IllegalStateException -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0187 A[Catch:{ IllegalStateException -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0202  */
    @androidx.annotation.WorkerThread
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf() {
        /*
            r11 = this;
            com.google.android.gms.measurement.internal.zzib r0 = r11.zzu
            com.google.android.gms.measurement.internal.zzgt r1 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzk()
            long r2 = r11.zzh
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            long r3 = r11.zzg
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "sdkVersion bundled with app, dynamiteVersion"
            r1.zzc(r4, r2, r3)
            android.content.Context r1 = r0.zzaY()
            java.lang.String r1 = r1.getPackageName()
            android.content.Context r2 = r0.zzaY()
            android.content.pm.PackageManager r2 = r2.getPackageManager()
            r3 = 0
            java.lang.String r4 = ""
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            java.lang.String r6 = "Unknown"
            java.lang.String r7 = "unknown"
            if (r2 != 0) goto L_0x004a
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzb()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgt.zzl(r1)
            java.lang.String r9 = "PackageManager is null, app identity information might be inaccurate. appId"
            r0.zzb(r9, r8)
        L_0x0047:
            r8 = r6
            goto L_0x00b1
        L_0x004a:
            java.lang.String r7 = r2.getInstallerPackageName(r1)     // Catch:{ IllegalArgumentException -> 0x004f }
            goto L_0x0062
        L_0x004f:
            com.google.android.gms.measurement.internal.zzib r0 = r11.zzu
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzb()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgt.zzl(r1)
            java.lang.String r9 = "Error retrieving app installer package name. appId"
            r0.zzb(r9, r8)
        L_0x0062:
            if (r7 != 0) goto L_0x0068
            java.lang.String r0 = "manual_install"
            r7 = r0
            goto L_0x0071
        L_0x0068:
            java.lang.String r0 = "com.android.vending"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x0071
            r7 = r4
        L_0x0071:
            com.google.android.gms.measurement.internal.zzib r0 = r11.zzu     // Catch:{ NameNotFoundException -> 0x009b }
            android.content.Context r0 = r0.zzaY()     // Catch:{ NameNotFoundException -> 0x009b }
            java.lang.String r0 = r0.getPackageName()     // Catch:{ NameNotFoundException -> 0x009b }
            android.content.pm.PackageInfo r0 = r2.getPackageInfo(r0, r3)     // Catch:{ NameNotFoundException -> 0x009b }
            if (r0 == 0) goto L_0x0047
            android.content.pm.ApplicationInfo r8 = r0.applicationInfo     // Catch:{ NameNotFoundException -> 0x009b }
            java.lang.CharSequence r8 = r2.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x009b }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ NameNotFoundException -> 0x009b }
            if (r9 != 0) goto L_0x0092
            java.lang.String r8 = r8.toString()     // Catch:{ NameNotFoundException -> 0x009b }
            goto L_0x0093
        L_0x0092:
            r8 = r6
        L_0x0093:
            java.lang.String r6 = r0.versionName     // Catch:{ NameNotFoundException -> 0x0098 }
            int r5 = r0.versionCode     // Catch:{ NameNotFoundException -> 0x0098 }
            goto L_0x00b1
        L_0x0098:
            r0 = r6
            r6 = r8
            goto L_0x009c
        L_0x009b:
            r0 = r6
        L_0x009c:
            com.google.android.gms.measurement.internal.zzib r8 = r11.zzu
            com.google.android.gms.measurement.internal.zzgt r8 = r8.zzaV()
            com.google.android.gms.measurement.internal.zzgr r8 = r8.zzb()
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzgt.zzl(r1)
            java.lang.String r10 = "Error retrieving package info. appId, appName"
            r8.zzc(r10, r9, r6)
            r8 = r6
            r6 = r0
        L_0x00b1:
            r11.zza = r1
            r11.zzd = r7
            r11.zzb = r6
            r11.zzc = r5
            r11.zze = r8
            r5 = 0
            r11.zzf = r5
            com.google.android.gms.measurement.internal.zzib r0 = r11.zzu
            int r5 = r0.zzC()
            if (r5 == 0) goto L_0x0157
            r6 = 1
            if (r5 == r6) goto L_0x0147
            r6 = 3
            if (r5 == r6) goto L_0x0137
            r6 = 4
            if (r5 == r6) goto L_0x0127
            r6 = 6
            if (r5 == r6) goto L_0x0117
            r6 = 7
            if (r5 == r6) goto L_0x0107
            r6 = 8
            if (r5 == r6) goto L_0x00f7
            com.google.android.gms.measurement.internal.zzib r6 = r11.zzu
            com.google.android.gms.measurement.internal.zzgt r7 = r6.zzaV()
            com.google.android.gms.measurement.internal.zzgr r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled"
            r7.zza(r8)
            com.google.android.gms.measurement.internal.zzgt r6 = r6.zzaV()
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zzc()
            java.lang.String r7 = "Invalid scion state in identity"
            r6.zza(r7)
            goto L_0x0166
        L_0x00f7:
            com.google.android.gms.measurement.internal.zzib r6 = r11.zzu
            com.google.android.gms.measurement.internal.zzgt r6 = r6.zzaV()
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zzi()
            java.lang.String r7 = "App measurement disabled due to denied storage consent"
            r6.zza(r7)
            goto L_0x0166
        L_0x0107:
            com.google.android.gms.measurement.internal.zzib r6 = r11.zzu
            com.google.android.gms.measurement.internal.zzgt r6 = r6.zzaV()
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zzi()
            java.lang.String r7 = "App measurement disabled via the global data collection setting"
            r6.zza(r7)
            goto L_0x0166
        L_0x0117:
            com.google.android.gms.measurement.internal.zzib r6 = r11.zzu
            com.google.android.gms.measurement.internal.zzgt r6 = r6.zzaV()
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zzh()
            java.lang.String r7 = "App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics"
            r6.zza(r7)
            goto L_0x0166
        L_0x0127:
            com.google.android.gms.measurement.internal.zzib r6 = r11.zzu
            com.google.android.gms.measurement.internal.zzgt r6 = r6.zzaV()
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zzi()
            java.lang.String r7 = "App measurement disabled via the manifest"
            r6.zza(r7)
            goto L_0x0166
        L_0x0137:
            com.google.android.gms.measurement.internal.zzib r6 = r11.zzu
            com.google.android.gms.measurement.internal.zzgt r6 = r6.zzaV()
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zzi()
            java.lang.String r7 = "App measurement disabled by setAnalyticsCollectionEnabled(false)"
            r6.zza(r7)
            goto L_0x0166
        L_0x0147:
            com.google.android.gms.measurement.internal.zzib r6 = r11.zzu
            com.google.android.gms.measurement.internal.zzgt r6 = r6.zzaV()
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zzi()
            java.lang.String r7 = "App measurement deactivated via the manifest"
            r6.zza(r7)
            goto L_0x0166
        L_0x0157:
            com.google.android.gms.measurement.internal.zzib r6 = r11.zzu
            com.google.android.gms.measurement.internal.zzgt r6 = r6.zzaV()
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zzk()
            java.lang.String r7 = "App measurement collection enabled"
            r6.zza(r7)
        L_0x0166:
            r11.zzl = r4
            com.google.android.gms.measurement.internal.zzib r6 = r11.zzu
            r6.zzaU()
            android.content.Context r7 = r6.zzaY()     // Catch:{ IllegalStateException -> 0x0199 }
            java.lang.String r0 = r0.zzq()     // Catch:{ IllegalStateException -> 0x0199 }
            java.lang.String r8 = "google_app_id"
            java.lang.String r0 = com.google.android.gms.measurement.internal.zzls.zza(r7, r8, r0)     // Catch:{ IllegalStateException -> 0x0199 }
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch:{ IllegalStateException -> 0x0199 }
            if (r7 == 0) goto L_0x0182
            goto L_0x0183
        L_0x0182:
            r4 = r0
        L_0x0183:
            r11.zzl = r4     // Catch:{ IllegalStateException -> 0x0199 }
            if (r5 != 0) goto L_0x01ad
            com.google.android.gms.measurement.internal.zzgt r0 = r6.zzaV()     // Catch:{ IllegalStateException -> 0x0199 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzk()     // Catch:{ IllegalStateException -> 0x0199 }
            java.lang.String r4 = "App measurement enabled for app package, google app id"
            java.lang.String r5 = r11.zza     // Catch:{ IllegalStateException -> 0x0199 }
            java.lang.String r6 = r11.zzl     // Catch:{ IllegalStateException -> 0x0199 }
            r0.zzc(r4, r5, r6)     // Catch:{ IllegalStateException -> 0x0199 }
            goto L_0x01ad
        L_0x0199:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzib r4 = r11.zzu
            com.google.android.gms.measurement.internal.zzgt r4 = r4.zzaV()
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zzb()
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzgt.zzl(r1)
            java.lang.String r5 = "Fetching Google App Id failed with exception. appId"
            r4.zzc(r5, r1, r0)
        L_0x01ad:
            r0 = 0
            r11.zzi = r0
            com.google.android.gms.measurement.internal.zzib r0 = r11.zzu
            r0.zzaU()
            com.google.android.gms.measurement.internal.zzal r1 = r0.zzc()
            java.lang.String r4 = "analytics.safelisted_events"
            java.util.List r1 = r1.zzs(r4)
            if (r1 != 0) goto L_0x01c2
            goto L_0x01f3
        L_0x01c2:
            boolean r4 = r1.isEmpty()
            if (r4 == 0) goto L_0x01d6
            com.google.android.gms.measurement.internal.zzgt r1 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzh()
            java.lang.String r4 = "Safelisted event list is empty. Ignoring"
            r1.zza(r4)
            goto L_0x01f5
        L_0x01d6:
            java.util.Iterator r4 = r1.iterator()
        L_0x01da:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01f3
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            com.google.android.gms.measurement.internal.zzpo r6 = r0.zzk()
            java.lang.String r7 = "safelisted event"
            boolean r5 = r6.zzk(r7, r5)
            if (r5 != 0) goto L_0x01da
            goto L_0x01f5
        L_0x01f3:
            r11.zzi = r1
        L_0x01f5:
            if (r2 == 0) goto L_0x0202
            android.content.Context r0 = r0.zzaY()
            boolean r0 = com.google.android.gms.common.wrappers.InstantApps.isInstantApp(r0)
            r11.zzk = r0
            return
        L_0x0202:
            r11.zzk = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgh.zzf():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x024f A[SYNTHETIC, Splitter:B:77:0x024f] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02af  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02be  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02c9  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzr zzh(java.lang.String r51) {
        /*
            r50 = this;
            r1 = r50
            r2 = 1
            r50.zzg()
            com.google.android.gms.measurement.internal.zzr r43 = new com.google.android.gms.measurement.internal.zzr
            java.lang.String r4 = r50.zzj()
            java.lang.String r5 = r50.zzk()
            r50.zzb()
            java.lang.String r6 = r1.zzb
            r50.zzb()
            int r0 = r1.zzc
            long r7 = (long) r0
            r50.zzb()
            java.lang.String r0 = r1.zzd
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            java.lang.String r9 = r1.zzd
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu
            com.google.android.gms.measurement.internal.zzal r3 = r0.zzc()
            r3.zzi()
            r50.zzb()
            r50.zzg()
            long r10 = r1.zzf
            r3 = 0
            r12 = 0
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 != 0) goto L_0x00c6
            com.google.android.gms.measurement.internal.zzib r10 = r1.zzu
            com.google.android.gms.measurement.internal.zzpo r10 = r10.zzk()
            android.content.Context r11 = r0.zzaY()
            android.content.Context r0 = r0.zzaY()
            java.lang.String r0 = r0.getPackageName()
            r10.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r0)
            android.content.pm.PackageManager r14 = r11.getPackageManager()
            java.security.MessageDigest r15 = com.google.android.gms.measurement.internal.zzpo.zzO()
            r16 = -1
            if (r15 != 0) goto L_0x006e
            com.google.android.gms.measurement.internal.zzib r0 = r10.zzu
            java.lang.String r10 = "Could not get MD5 instance"
            defpackage.e.w(r0, r10)
        L_0x006b:
            r10 = r16
            goto L_0x00c4
        L_0x006e:
            if (r14 == 0) goto L_0x00c2
            boolean r0 = r10.zzad(r11, r0)     // Catch:{ NameNotFoundException -> 0x00a0 }
            if (r0 != 0) goto L_0x00b0
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r11)     // Catch:{ NameNotFoundException -> 0x00a0 }
            com.google.android.gms.measurement.internal.zzib r11 = r10.zzu     // Catch:{ NameNotFoundException -> 0x00a0 }
            android.content.Context r14 = r11.zzaY()     // Catch:{ NameNotFoundException -> 0x00a0 }
            java.lang.String r14 = r14.getPackageName()     // Catch:{ NameNotFoundException -> 0x00a0 }
            r12 = 64
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r14, r12)     // Catch:{ NameNotFoundException -> 0x00a0 }
            android.content.pm.Signature[] r0 = r0.signatures     // Catch:{ NameNotFoundException -> 0x00a0 }
            if (r0 == 0) goto L_0x00a2
            int r12 = r0.length     // Catch:{ NameNotFoundException -> 0x00a0 }
            if (r12 <= 0) goto L_0x00a2
            r0 = r0[r3]     // Catch:{ NameNotFoundException -> 0x00a0 }
            byte[] r0 = r0.toByteArray()     // Catch:{ NameNotFoundException -> 0x00a0 }
            byte[] r0 = r15.digest(r0)     // Catch:{ NameNotFoundException -> 0x00a0 }
            long r16 = com.google.android.gms.measurement.internal.zzpo.zzP(r0)     // Catch:{ NameNotFoundException -> 0x00a0 }
            goto L_0x006b
        L_0x00a0:
            r0 = move-exception
            goto L_0x00b3
        L_0x00a2:
            com.google.android.gms.measurement.internal.zzgt r0 = r11.zzaV()     // Catch:{ NameNotFoundException -> 0x00a0 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zze()     // Catch:{ NameNotFoundException -> 0x00a0 }
            java.lang.String r11 = "Could not get signatures"
            r0.zza(r11)     // Catch:{ NameNotFoundException -> 0x00a0 }
            goto L_0x006b
        L_0x00b0:
            r16 = 0
            goto L_0x006b
        L_0x00b3:
            com.google.android.gms.measurement.internal.zzib r10 = r10.zzu
            com.google.android.gms.measurement.internal.zzgt r10 = r10.zzaV()
            com.google.android.gms.measurement.internal.zzgr r10 = r10.zzb()
            java.lang.String r11 = "Package name not found"
            r10.zzb(r11, r0)
        L_0x00c2:
            r10 = 0
        L_0x00c4:
            r1.zzf = r10
        L_0x00c6:
            r12 = r10
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu
            boolean r15 = r0.zzB()
            com.google.android.gms.measurement.internal.zzhg r10 = r0.zzd()
            boolean r10 = r10.zzm
            r16 = r10 ^ 1
            r50.zzg()
            boolean r10 = r0.zzB()
            r11 = 0
            if (r10 != 0) goto L_0x00e2
        L_0x00df:
            r0 = r11
            goto L_0x0161
        L_0x00e2:
            com.google.android.gms.internal.measurement.zzrg.zza()
            com.google.android.gms.measurement.internal.zzal r10 = r0.zzc()
            com.google.android.gms.measurement.internal.zzfw r14 = com.google.android.gms.measurement.internal.zzfx.zzaH
            boolean r10 = r10.zzp(r11, r14)
            if (r10 == 0) goto L_0x0101
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzk()
            java.lang.String r10 = "Disabled IID for tests."
            r0.zza(r10)
            goto L_0x00df
        L_0x0101:
            android.content.Context r0 = r0.zzaY()     // Catch:{ ClassNotFoundException -> 0x015f }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x015f }
            java.lang.String r10 = "com.google.firebase.analytics.FirebaseAnalytics"
            java.lang.Class r0 = r0.loadClass(r10)     // Catch:{ ClassNotFoundException -> 0x015f }
            if (r0 != 0) goto L_0x0112
            goto L_0x00df
        L_0x0112:
            java.lang.String r10 = "getInstance"
            java.lang.Class[] r14 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x014f }
            java.lang.Class<android.content.Context> r17 = android.content.Context.class
            r14[r3] = r17     // Catch:{ Exception -> 0x014f }
            java.lang.reflect.Method r10 = r0.getDeclaredMethod(r10, r14)     // Catch:{ Exception -> 0x014f }
            com.google.android.gms.measurement.internal.zzib r14 = r1.zzu     // Catch:{ Exception -> 0x014f }
            android.content.Context r14 = r14.zzaY()     // Catch:{ Exception -> 0x014f }
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x014f }
            r11[r3] = r14     // Catch:{ Exception -> 0x014f }
            r14 = 0
            java.lang.Object r10 = r10.invoke(r14, r11)     // Catch:{ Exception -> 0x014f }
            if (r10 != 0) goto L_0x0131
            r0 = r14
            goto L_0x0161
        L_0x0131:
            java.lang.String r11 = "getFirebaseInstanceId"
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r11, r14)     // Catch:{ Exception -> 0x013e }
            java.lang.Object r0 = r0.invoke(r10, r14)     // Catch:{ Exception -> 0x013e }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x013e }
            goto L_0x0161
        L_0x013e:
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzh()
            java.lang.String r10 = "Failed to retrieve Firebase Instance Id"
            r0.zza(r10)
        L_0x014d:
            r0 = 0
            goto L_0x0161
        L_0x014f:
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzf()
            java.lang.String r10 = "Failed to obtain Firebase Analytics instance"
            r0.zza(r10)
            goto L_0x014d
        L_0x015f:
            goto L_0x014d
        L_0x0161:
            com.google.android.gms.measurement.internal.zzib r10 = r1.zzu
            com.google.android.gms.measurement.internal.zzhg r11 = r10.zzd()
            com.google.android.gms.measurement.internal.zzhd r11 = r11.zzc
            long r2 = r11.zza()
            r18 = 0
            int r11 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r11 != 0) goto L_0x0178
            long r2 = r10.zza
        L_0x0175:
            r21 = r2
            goto L_0x017f
        L_0x0178:
            long r10 = r10.zza
            long r2 = java.lang.Math.min(r10, r2)
            goto L_0x0175
        L_0x017f:
            r50.zzb()
            int r2 = r1.zzk
            com.google.android.gms.measurement.internal.zzib r3 = r1.zzu
            com.google.android.gms.measurement.internal.zzal r10 = r3.zzc()
            boolean r23 = r10.zzu()
            com.google.android.gms.measurement.internal.zzhg r10 = r3.zzd()
            r10.zzg()
            android.content.SharedPreferences r10 = r10.zzd()
            java.lang.String r11 = "deferred_analytics_collection"
            r14 = 0
            boolean r25 = r10.getBoolean(r11, r14)
            com.google.android.gms.measurement.internal.zzal r10 = r3.zzc()
            java.lang.String r11 = "google_analytics_default_allow_ad_personalization_signals"
            r14 = 1
            com.google.android.gms.measurement.internal.zzjh r10 = r10.zzw(r11, r14)
            com.google.android.gms.measurement.internal.zzjh r14 = com.google.android.gms.measurement.internal.zzjh.GRANTED
            if (r10 == r14) goto L_0x01b3
            r26 = r15
            r10 = 1
            goto L_0x01b6
        L_0x01b3:
            r26 = r15
            r10 = 0
        L_0x01b6:
            long r14 = r1.zzg
            java.lang.Boolean r27 = java.lang.Boolean.valueOf(r10)
            java.util.List r10 = r1.zzi
            com.google.android.gms.measurement.internal.zzhg r28 = r3.zzd()
            com.google.android.gms.measurement.internal.zzjk r28 = r28.zzl()
            java.lang.String r28 = r28.zzl()
            r29 = r10
            java.lang.String r10 = r1.zzj
            if (r10 != 0) goto L_0x01da
            com.google.android.gms.measurement.internal.zzpo r10 = r3.zzk()
            java.lang.String r10 = r10.zzaw()
            r1.zzj = r10
        L_0x01da:
            java.lang.String r10 = r1.zzj
            com.google.android.gms.measurement.internal.zzhg r30 = r3.zzd()
            r31 = r10
            com.google.android.gms.measurement.internal.zzjk r10 = r30.zzl()
            r32 = r14
            com.google.android.gms.measurement.internal.zzjj r14 = com.google.android.gms.measurement.internal.zzjj.ANALYTICS_STORAGE
            boolean r10 = r10.zzo(r14)
            if (r10 != 0) goto L_0x01f7
            r34 = r12
            r18 = 0
            r30 = 0
            goto L_0x022f
        L_0x01f7:
            r50.zzg()
            long r14 = r1.zzn
            r18 = 0
            int r10 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r10 != 0) goto L_0x0205
            r34 = r12
            goto L_0x0224
        L_0x0205:
            com.google.android.gms.common.util.Clock r10 = r3.zzaZ()
            long r14 = r10.currentTimeMillis()
            r34 = r12
            long r12 = r1.zzn
            long r14 = r14 - r12
            java.lang.String r10 = r1.zzm
            if (r10 == 0) goto L_0x0224
            r12 = 86400000(0x5265c00, double:4.2687272E-316)
            int r10 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x0224
            java.lang.String r10 = r1.zzo
            if (r10 != 0) goto L_0x0224
            r50.zzi()
        L_0x0224:
            java.lang.String r10 = r1.zzm
            if (r10 != 0) goto L_0x022b
            r50.zzi()
        L_0x022b:
            java.lang.String r10 = r1.zzm
            r30 = r10
        L_0x022f:
            com.google.android.gms.measurement.internal.zzal r10 = r3.zzc()
            boolean r36 = r10.zzx()
            com.google.android.gms.measurement.internal.zzpo r3 = r3.zzk()
            java.lang.String r10 = r50.zzj()
            com.google.android.gms.measurement.internal.zzib r12 = r3.zzu
            android.content.Context r13 = r12.zzaY()
            android.content.pm.PackageManager r13 = r13.getPackageManager()
            if (r13 != 0) goto L_0x024f
            r44 = r18
            r14 = 0
            goto L_0x027a
        L_0x024f:
            android.content.Context r12 = r12.zzaY()     // Catch:{ NameNotFoundException -> 0x0263 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r12 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r12)     // Catch:{ NameNotFoundException -> 0x0263 }
            r14 = 0
            android.content.pm.ApplicationInfo r12 = r12.getApplicationInfo(r10, r14)     // Catch:{ NameNotFoundException -> 0x0264 }
            if (r12 == 0) goto L_0x0261
            int r3 = r12.targetSdkVersion     // Catch:{ NameNotFoundException -> 0x0264 }
            goto L_0x0277
        L_0x0261:
            r3 = 0
            goto L_0x0277
        L_0x0263:
            r14 = 0
        L_0x0264:
            com.google.android.gms.measurement.internal.zzib r3 = r3.zzu
            r3.zzaU()
            com.google.android.gms.measurement.internal.zzgt r3 = r3.zzaV()
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzi()
            java.lang.String r12 = "PackageManager failed to find running app: app_id"
            r3.zzb(r12, r10)
            goto L_0x0261
        L_0x0277:
            long r12 = (long) r3
            r44 = r12
        L_0x027a:
            com.google.android.gms.measurement.internal.zzib r3 = r1.zzu
            com.google.android.gms.measurement.internal.zzhg r10 = r3.zzd()
            com.google.android.gms.measurement.internal.zzjk r10 = r10.zzl()
            int r37 = r10.zzb()
            com.google.android.gms.measurement.internal.zzhg r10 = r3.zzd()
            com.google.android.gms.measurement.internal.zzaz r10 = r10.zzj()
            java.lang.String r46 = r10.zze()
            com.google.android.gms.internal.measurement.zzql.zza()
            com.google.android.gms.measurement.internal.zzal r10 = r3.zzc()
            com.google.android.gms.measurement.internal.zzfw r12 = com.google.android.gms.measurement.internal.zzfx.zzaQ
            r13 = 0
            boolean r10 = r10.zzp(r13, r12)
            if (r10 == 0) goto L_0x02af
            com.google.android.gms.measurement.internal.zzpo r10 = r3.zzk()
            int r10 = r10.zzU()
            r47 = r10
            goto L_0x02b1
        L_0x02af:
            r47 = 0
        L_0x02b1:
            com.google.android.gms.internal.measurement.zzql.zza()
            com.google.android.gms.measurement.internal.zzal r10 = r3.zzc()
            boolean r10 = r10.zzp(r13, r12)
            if (r10 == 0) goto L_0x02c9
            com.google.android.gms.measurement.internal.zzpo r10 = r3.zzk()
            long r12 = r10.zzV()
            r48 = r12
            goto L_0x02cb
        L_0x02c9:
            r48 = r18
        L_0x02cb:
            com.google.android.gms.measurement.internal.zzal r10 = r3.zzc()
            java.lang.String r38 = r10.zzz()
            com.google.android.gms.measurement.internal.zzal r3 = r3.zzc()
            r10 = 1
            com.google.android.gms.measurement.internal.zzjh r3 = r3.zzw(r11, r10)
            com.google.android.gms.measurement.internal.zze r10 = new com.google.android.gms.measurement.internal.zze
            r10.<init>(r3)
            java.lang.String r39 = r10.zzb()
            com.google.android.gms.measurement.internal.zzib r3 = r1.zzu
            long r10 = r3.zza
            r40 = r10
            com.google.android.gms.measurement.internal.zzlp r3 = r3.zzx()
            com.google.android.gms.internal.measurement.zzin r3 = r3.zzj()
            int r42 = r3.zza()
            r10 = 130000(0x1fbd0, double:6.42285E-319)
            r3 = r43
            r12 = r34
            r14 = r51
            r15 = r26
            r17 = r0
            r18 = r21
            r20 = r2
            r21 = r23
            r22 = r25
            r23 = r27
            r24 = r32
            r26 = r29
            r27 = r28
            r28 = r31
            r29 = r30
            r30 = r36
            r31 = r44
            r33 = r37
            r34 = r46
            r35 = r47
            r36 = r48
            r3.<init>((java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (long) r7, (java.lang.String) r9, (long) r10, (long) r12, (java.lang.String) r14, (boolean) r15, (boolean) r16, (java.lang.String) r17, (long) r18, (int) r20, (boolean) r21, (boolean) r22, (java.lang.Boolean) r23, (long) r24, (java.util.List) r26, (java.lang.String) r27, (java.lang.String) r28, (java.lang.String) r29, (boolean) r30, (long) r31, (int) r33, (java.lang.String) r34, (int) r35, (long) r36, (java.lang.String) r38, (java.lang.String) r39, (long) r40, (int) r42)
            return r43
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgh.zzh(java.lang.String):com.google.android.gms.measurement.internal.zzr");
    }

    @WorkerThread
    public final void zzi() {
        String str;
        String str2;
        zzg();
        zzib zzib = this.zzu;
        if (!zzib.zzd().zzl().zzo(zzjj.ANALYTICS_STORAGE)) {
            zzib.zzaV().zzj().zza("Analytics Storage consent is not granted");
            str = null;
        } else {
            byte[] bArr = new byte[16];
            zzib.zzk().zzf().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
        }
        zzgr zzj2 = zzib.zzaV().zzj();
        if (str == null) {
            str2 = "null";
        } else {
            str2 = "not null";
        }
        zzj2.zza("Resetting session stitching token to ".concat(str2));
        this.zzm = str;
        this.zzn = zzib.zzaZ().currentTimeMillis();
    }

    @WorkerThread
    public final String zzj() {
        zzb();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    @WorkerThread
    public final String zzk() {
        zzg();
        zzb();
        Preconditions.checkNotNull(this.zzl);
        return this.zzl;
    }

    @WorkerThread
    public final String zzl() {
        zzb();
        Preconditions.checkNotNull(this.zze);
        return this.zze;
    }

    @WorkerThread
    public final int zzm() {
        zzb();
        return this.zzc;
    }

    public final long zzn() {
        return this.zzh;
    }

    @WorkerThread
    public final int zzo() {
        zzb();
        return this.zzk;
    }

    @WorkerThread
    public final List zzp() {
        return this.zzi;
    }

    public final boolean zzq(String str) {
        String str2 = this.zzo;
        boolean z = false;
        if (str2 != null && !str2.equals(str)) {
            z = true;
        }
        this.zzo = str;
        return z;
    }
}
