package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdf;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public final class zzma extends zzg {
    @VisibleForTesting
    protected zzlt zza;
    private volatile zzlt zzb;
    private volatile zzlt zzc;
    private final Map zzd = new ConcurrentHashMap();
    @GuardedBy("activityLock")
    private zzdf zze;
    @GuardedBy("activityLock")
    private volatile boolean zzf;
    private volatile zzlt zzg;
    private zzlt zzh;
    @GuardedBy("activityLock")
    private boolean zzi;
    private final Object zzj = new Object();

    public zzma(zzib zzib) {
        super(zzib);
    }

    @WorkerThread
    private final void zzA(zzlt zzlt, boolean z, long j) {
        boolean z2;
        zzib zzib = this.zzu;
        zzib.zzw().zzc(zzib.zzaZ().elapsedRealtime());
        if (zzlt == null || !zzlt.zzd) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (zzib.zzh().zzb.zzd(z2, z, j) && zzlt != null) {
            zzlt.zzd = false;
        }
    }

    @MainThread
    private final zzlt zzB(@NonNull zzdf zzdf) {
        Preconditions.checkNotNull(zzdf);
        Integer valueOf = Integer.valueOf(zzdf.zza);
        Map map = this.zzd;
        zzlt zzlt = (zzlt) map.get(valueOf);
        if (zzlt == null) {
            zzlt zzlt2 = new zzlt((String) null, zzi(zzdf.zzb, "Activity"), this.zzu.zzk().zzd());
            map.put(valueOf, zzlt2);
            zzlt = zzlt2;
        }
        if (this.zzg != null) {
            return this.zzg;
        }
        return zzlt;
    }

    @MainThread
    private final void zzy(String str, zzlt zzlt, boolean z) {
        zzlt zzlt2;
        zzlt zzlt3;
        String str2;
        String str3 = str;
        zzlt zzlt4 = zzlt;
        if (this.zzb == null) {
            zzlt2 = this.zzc;
        } else {
            zzlt2 = this.zzb;
        }
        zzlt zzlt5 = zzlt2;
        if (zzlt4.zzb == null) {
            if (str3 != null) {
                str2 = zzi(str3, "Activity");
            } else {
                str2 = null;
            }
            zzlt3 = new zzlt(zzlt4.zza, str2, zzlt4.zzc, zzlt4.zze, zzlt4.zzf);
        } else {
            zzlt3 = zzlt4;
        }
        this.zzc = this.zzb;
        this.zzb = zzlt3;
        zzib zzib = this.zzu;
        zzib.zzaW().zzj(new zzlv(this, zzlt3, zzlt5, zzib.zzaZ().elapsedRealtime(), z));
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d1  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzz(com.google.android.gms.measurement.internal.zzlt r16, com.google.android.gms.measurement.internal.zzlt r17, long r18, boolean r20, android.os.Bundle r21) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r18
            r5 = r21
            r15.zzg()
            r6 = 0
            r7 = 1
            if (r2 == 0) goto L_0x002c
            long r8 = r1.zzc
            long r10 = r2.zzc
            int r12 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r12 != 0) goto L_0x002c
            java.lang.String r8 = r2.zzb
            java.lang.String r9 = r1.zzb
            boolean r8 = java.util.Objects.equals(r8, r9)
            if (r8 == 0) goto L_0x002c
            java.lang.String r8 = r2.zza
            java.lang.String r9 = r1.zza
            boolean r8 = java.util.Objects.equals(r8, r9)
            if (r8 != 0) goto L_0x002e
        L_0x002c:
            r8 = 1
            goto L_0x002f
        L_0x002e:
            r8 = 0
        L_0x002f:
            if (r20 == 0) goto L_0x0036
            com.google.android.gms.measurement.internal.zzlt r9 = r0.zza
            if (r9 == 0) goto L_0x0036
            r6 = 1
        L_0x0036:
            if (r8 == 0) goto L_0x00c4
            if (r5 == 0) goto L_0x0041
            android.os.Bundle r8 = new android.os.Bundle
            r8.<init>(r5)
        L_0x003f:
            r14 = r8
            goto L_0x0047
        L_0x0041:
            android.os.Bundle r8 = new android.os.Bundle
            r8.<init>()
            goto L_0x003f
        L_0x0047:
            com.google.android.gms.measurement.internal.zzpo.zzav(r1, r14, r7)
            if (r2 == 0) goto L_0x0065
            java.lang.String r5 = r2.zza
            if (r5 == 0) goto L_0x0055
            java.lang.String r8 = "_pn"
            r14.putString(r8, r5)
        L_0x0055:
            java.lang.String r5 = r2.zzb
            if (r5 == 0) goto L_0x005e
            java.lang.String r8 = "_pc"
            r14.putString(r8, r5)
        L_0x005e:
            long r8 = r2.zzc
            java.lang.String r2 = "_pi"
            r14.putLong(r2, r8)
        L_0x0065:
            r8 = 0
            if (r6 == 0) goto L_0x0084
            com.google.android.gms.measurement.internal.zzib r2 = r0.zzu
            com.google.android.gms.measurement.internal.zzob r2 = r2.zzh()
            com.google.android.gms.measurement.internal.zznz r2 = r2.zzb
            long r10 = r2.zzb
            long r10 = r3 - r10
            r2.zzb = r3
            int r2 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r2 <= 0) goto L_0x0084
            com.google.android.gms.measurement.internal.zzib r2 = r0.zzu
            com.google.android.gms.measurement.internal.zzpo r2 = r2.zzk()
            r2.zzak(r14, r10)
        L_0x0084:
            com.google.android.gms.measurement.internal.zzib r2 = r0.zzu
            com.google.android.gms.measurement.internal.zzal r5 = r2.zzc()
            boolean r5 = r5.zzv()
            if (r5 != 0) goto L_0x0097
            java.lang.String r5 = "_mst"
            r10 = 1
            r14.putLong(r5, r10)
        L_0x0097:
            boolean r5 = r1.zze
            if (r7 == r5) goto L_0x009e
            java.lang.String r10 = "auto"
            goto L_0x00a0
        L_0x009e:
            java.lang.String r10 = "app"
        L_0x00a0:
            com.google.android.gms.common.util.Clock r2 = r2.zzaZ()
            long r11 = r2.currentTimeMillis()
            if (r5 == 0) goto L_0x00b5
            r20 = r11
            long r11 = r1.zzf
            int r2 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x00b3
            goto L_0x00b7
        L_0x00b3:
            r12 = r11
            goto L_0x00b9
        L_0x00b5:
            r20 = r11
        L_0x00b7:
            r12 = r20
        L_0x00b9:
            com.google.android.gms.measurement.internal.zzib r2 = r0.zzu
            java.lang.String r11 = "_vs"
            com.google.android.gms.measurement.internal.zzli r9 = r2.zzj()
            r9.zzG(r10, r11, r12, r14)
        L_0x00c4:
            if (r6 == 0) goto L_0x00cb
            com.google.android.gms.measurement.internal.zzlt r2 = r0.zza
            r15.zzA(r2, r7, r3)
        L_0x00cb:
            r0.zza = r1
            boolean r2 = r1.zze
            if (r2 == 0) goto L_0x00d3
            r0.zzh = r1
        L_0x00d3:
            com.google.android.gms.measurement.internal.zzib r2 = r0.zzu
            com.google.android.gms.measurement.internal.zznk r2 = r2.zzt()
            r2.zzG(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzma.zzz(com.google.android.gms.measurement.internal.zzlt, com.google.android.gms.measurement.internal.zzlt, long, boolean, android.os.Bundle):void");
    }

    public final boolean zze() {
        return false;
    }

    @WorkerThread
    public final zzlt zzh(boolean z) {
        zzb();
        zzg();
        if (!z) {
            return this.zza;
        }
        zzlt zzlt = this.zza;
        if (zzlt != null) {
            return zzlt;
        }
        return this.zzh;
    }

    @VisibleForTesting
    public final String zzi(String str, String str2) {
        String str3;
        if (str == null) {
            return "Activity";
        }
        String[] split = str.split("\\.");
        int length = split.length;
        if (length > 0) {
            str3 = split[length - 1];
        } else {
            str3 = "";
        }
        zzib zzib = this.zzu;
        if (str3.length() > zzib.zzc().zze((String) null, false)) {
            return str3.substring(0, zzib.zzc().zze((String) null, false));
        }
        return str3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ca, code lost:
        r0 = r12.zzu;
        r1 = r0.zzaV().zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d4, code lost:
        if (r3 != null) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d6, code lost:
        r2 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d9, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00da, code lost:
        if (r4 != null) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00dc, code lost:
        r5 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00df, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e0, code lost:
        r1.zzc("Logging screen view with name, class", r2, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e7, code lost:
        if (r12.zzb != null) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e9, code lost:
        r1 = r12.zzc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ec, code lost:
        r1 = r12.zzb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ee, code lost:
        r2 = new com.google.android.gms.measurement.internal.zzlt(r3, r4, r0.zzk().zzd(), true, r14);
        r12.zzb = r2;
        r12.zzc = r1;
        r12.zzg = r2;
        r0.zzaW().zzj(new com.google.android.gms.measurement.internal.zzlu(r12, r13, r2, r1, r0.zzaZ().elapsedRealtime()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x011e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzj(android.os.Bundle r13, long r14) {
        /*
            r12 = this;
            java.lang.Object r0 = r12.zzj
            monitor-enter(r0)
            boolean r1 = r12.zzi     // Catch:{ all -> 0x0018 }
            if (r1 != 0) goto L_0x001b
            com.google.android.gms.measurement.internal.zzib r13 = r12.zzu     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzgt r13 = r13.zzaV()     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzgr r13 = r13.zzh()     // Catch:{ all -> 0x0018 }
            java.lang.String r14 = "Cannot log screen view event when the app is in the background."
            r13.zza(r14)     // Catch:{ all -> 0x0018 }
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return
        L_0x0018:
            r13 = move-exception
            goto L_0x011f
        L_0x001b:
            java.lang.String r1 = "screen_name"
            java.lang.String r3 = r13.getString(r1)     // Catch:{ all -> 0x0018 }
            r1 = 0
            r2 = 0
            if (r3 == 0) goto L_0x0054
            int r4 = r3.length()     // Catch:{ all -> 0x0018 }
            if (r4 <= 0) goto L_0x003b
            int r4 = r3.length()     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzib r5 = r12.zzu     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzal r5 = r5.zzc()     // Catch:{ all -> 0x0018 }
            int r5 = r5.zze(r1, r2)     // Catch:{ all -> 0x0018 }
            if (r4 <= r5) goto L_0x0054
        L_0x003b:
            com.google.android.gms.measurement.internal.zzib r13 = r12.zzu     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzgt r13 = r13.zzaV()     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzgr r13 = r13.zzh()     // Catch:{ all -> 0x0018 }
            java.lang.String r14 = "Invalid screen name length for screen view. Length"
            int r15 = r3.length()     // Catch:{ all -> 0x0018 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x0018 }
            r13.zzb(r14, r15)     // Catch:{ all -> 0x0018 }
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return
        L_0x0054:
            java.lang.String r4 = "screen_class"
            java.lang.String r4 = r13.getString(r4)     // Catch:{ all -> 0x0018 }
            if (r4 == 0) goto L_0x008b
            int r5 = r4.length()     // Catch:{ all -> 0x0018 }
            if (r5 <= 0) goto L_0x0072
            int r5 = r4.length()     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzib r6 = r12.zzu     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzal r6 = r6.zzc()     // Catch:{ all -> 0x0018 }
            int r1 = r6.zze(r1, r2)     // Catch:{ all -> 0x0018 }
            if (r5 <= r1) goto L_0x008b
        L_0x0072:
            com.google.android.gms.measurement.internal.zzib r13 = r12.zzu     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzgt r13 = r13.zzaV()     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzgr r13 = r13.zzh()     // Catch:{ all -> 0x0018 }
            java.lang.String r14 = "Invalid screen class length for screen view. Length"
            int r15 = r4.length()     // Catch:{ all -> 0x0018 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x0018 }
            r13.zzb(r14, r15)     // Catch:{ all -> 0x0018 }
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return
        L_0x008b:
            if (r4 != 0) goto L_0x009e
            com.google.android.gms.internal.measurement.zzdf r1 = r12.zze     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x009b
            java.lang.String r1 = r1.zzb     // Catch:{ all -> 0x0018 }
            java.lang.String r4 = "Activity"
            java.lang.String r1 = r12.zzi(r1, r4)     // Catch:{ all -> 0x0018 }
        L_0x0099:
            r4 = r1
            goto L_0x009e
        L_0x009b:
            java.lang.String r1 = "Activity"
            goto L_0x0099
        L_0x009e:
            com.google.android.gms.measurement.internal.zzlt r1 = r12.zzb     // Catch:{ all -> 0x0018 }
            boolean r5 = r12.zzf     // Catch:{ all -> 0x0018 }
            if (r5 == 0) goto L_0x00c9
            if (r1 == 0) goto L_0x00c9
            r12.zzf = r2     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = r1.zzb     // Catch:{ all -> 0x0018 }
            boolean r2 = java.util.Objects.equals(r2, r4)     // Catch:{ all -> 0x0018 }
            java.lang.String r1 = r1.zza     // Catch:{ all -> 0x0018 }
            boolean r1 = java.util.Objects.equals(r1, r3)     // Catch:{ all -> 0x0018 }
            if (r2 == 0) goto L_0x00c9
            if (r1 == 0) goto L_0x00c9
            com.google.android.gms.measurement.internal.zzib r13 = r12.zzu     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzgt r13 = r13.zzaV()     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzgr r13 = r13.zzh()     // Catch:{ all -> 0x0018 }
            java.lang.String r14 = "Ignoring call to log screen view event with duplicate parameters."
            r13.zza(r14)     // Catch:{ all -> 0x0018 }
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return
        L_0x00c9:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzib r0 = r12.zzu
            com.google.android.gms.measurement.internal.zzgt r1 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzk()
            if (r3 != 0) goto L_0x00d9
            java.lang.String r2 = "null"
            goto L_0x00da
        L_0x00d9:
            r2 = r3
        L_0x00da:
            if (r4 != 0) goto L_0x00df
            java.lang.String r5 = "null"
            goto L_0x00e0
        L_0x00df:
            r5 = r4
        L_0x00e0:
            java.lang.String r6 = "Logging screen view with name, class"
            r1.zzc(r6, r2, r5)
            com.google.android.gms.measurement.internal.zzlt r1 = r12.zzb
            if (r1 != 0) goto L_0x00ec
            com.google.android.gms.measurement.internal.zzlt r1 = r12.zzc
            goto L_0x00ee
        L_0x00ec:
            com.google.android.gms.measurement.internal.zzlt r1 = r12.zzb
        L_0x00ee:
            com.google.android.gms.measurement.internal.zzlt r10 = new com.google.android.gms.measurement.internal.zzlt
            com.google.android.gms.measurement.internal.zzpo r2 = r0.zzk()
            long r5 = r2.zzd()
            r7 = 1
            r2 = r10
            r8 = r14
            r2.<init>(r3, r4, r5, r7, r8)
            r12.zzb = r10
            r12.zzc = r1
            r12.zzg = r10
            com.google.android.gms.common.util.Clock r14 = r0.zzaZ()
            long r14 = r14.elapsedRealtime()
            com.google.android.gms.measurement.internal.zzhy r0 = r0.zzaW()
            com.google.android.gms.measurement.internal.zzlu r2 = new com.google.android.gms.measurement.internal.zzlu
            r5 = r2
            r6 = r12
            r7 = r13
            r8 = r10
            r9 = r1
            r10 = r14
            r5.<init>(r6, r7, r8, r9, r10)
            r0.zzj(r2)
            return
        L_0x011f:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzma.zzj(android.os.Bundle, long):void");
    }

    @Deprecated
    public final void zzk(@NonNull zzdf zzdf, @Size(max = 36, min = 1) String str, @Size(max = 36, min = 1) String str2) {
        String str3;
        zzib zzib = this.zzu;
        if (!zzib.zzc().zzv()) {
            zzib.zzaV().zzh().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        zzlt zzlt = this.zzb;
        if (zzlt == null) {
            zzib.zzaV().zzh().zza("setCurrentScreen cannot be called while no activity active");
            return;
        }
        Map map = this.zzd;
        Integer valueOf = Integer.valueOf(zzdf.zza);
        if (map.get(valueOf) == null) {
            zzib.zzaV().zzh().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = zzi(zzdf.zzb, "Activity");
        }
        String str4 = zzlt.zzb;
        String str5 = zzlt.zza;
        boolean equals = Objects.equals(str4, str2);
        boolean equals2 = Objects.equals(str5, str);
        if (equals && equals2) {
            zzib.zzaV().zzh().zza("setCurrentScreen cannot be called with the same class and name");
        } else if (str != null && (str.length() <= 0 || str.length() > zzib.zzc().zze((String) null, false))) {
            zzib.zzaV().zzh().zzb("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
        } else if (str2 == null || (str2.length() > 0 && str2.length() <= zzib.zzc().zze((String) null, false))) {
            zzgr zzk = zzib.zzaV().zzk();
            if (str == null) {
                str3 = "null";
            } else {
                str3 = str;
            }
            zzk.zzc("Setting current screen to name, class", str3, str2);
            zzlt zzlt2 = new zzlt(str, str2, zzib.zzk().zzd());
            map.put(valueOf, zzlt2);
            zzy(zzdf.zzb, zzlt2, true);
        } else {
            zzib.zzaV().zzh().zzb("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
        }
    }

    public final zzlt zzl() {
        return this.zzb;
    }

    @MainThread
    public final void zzm(zzdf zzdf, Bundle bundle) {
        Bundle bundle2;
        if (this.zzu.zzc().zzv() && bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.zzd.put(Integer.valueOf(zzdf.zza), new zzlt(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    @androidx.annotation.MainThread
    public final void zzn(com.google.android.gms.internal.measurement.zzdf r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.zzj
            monitor-enter(r0)
            r1 = 1
            r4.zzi = r1     // Catch:{ all -> 0x0031 }
            com.google.android.gms.internal.measurement.zzdf r1 = r4.zze     // Catch:{ all -> 0x0031 }
            boolean r1 = java.util.Objects.equals(r5, r1)     // Catch:{ all -> 0x0031 }
            r2 = 0
            if (r1 != 0) goto L_0x0036
            monitor-enter(r0)     // Catch:{ all -> 0x0031 }
            r4.zze = r5     // Catch:{ all -> 0x0033 }
            r4.zzf = r2     // Catch:{ all -> 0x0033 }
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            com.google.android.gms.measurement.internal.zzib r1 = r4.zzu     // Catch:{ all -> 0x0031 }
            com.google.android.gms.measurement.internal.zzal r3 = r1.zzc()     // Catch:{ all -> 0x0031 }
            boolean r3 = r3.zzv()     // Catch:{ all -> 0x0031 }
            if (r3 == 0) goto L_0x0036
            r3 = 0
            r4.zzg = r3     // Catch:{ all -> 0x0031 }
            com.google.android.gms.measurement.internal.zzhy r1 = r1.zzaW()     // Catch:{ all -> 0x0031 }
            com.google.android.gms.measurement.internal.zzlz r3 = new com.google.android.gms.measurement.internal.zzlz     // Catch:{ all -> 0x0031 }
            r3.<init>(r4)     // Catch:{ all -> 0x0031 }
            r1.zzj(r3)     // Catch:{ all -> 0x0031 }
            goto L_0x0036
        L_0x0031:
            r5 = move-exception
            goto L_0x007a
        L_0x0033:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            throw r5     // Catch:{ all -> 0x0031 }
        L_0x0036:
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            com.google.android.gms.measurement.internal.zzib r0 = r4.zzu
            com.google.android.gms.measurement.internal.zzal r1 = r0.zzc()
            boolean r1 = r1.zzv()
            if (r1 != 0) goto L_0x0054
            com.google.android.gms.measurement.internal.zzlt r5 = r4.zzg
            r4.zzb = r5
            com.google.android.gms.measurement.internal.zzhy r5 = r0.zzaW()
            com.google.android.gms.measurement.internal.zzlw r0 = new com.google.android.gms.measurement.internal.zzlw
            r0.<init>(r4)
            r5.zzj(r0)
            return
        L_0x0054:
            com.google.android.gms.measurement.internal.zzlt r0 = r4.zzB(r5)
            java.lang.String r5 = r5.zzb
            r4.zzy(r5, r0, r2)
            com.google.android.gms.measurement.internal.zzib r5 = r4.zzu
            com.google.android.gms.measurement.internal.zzd r5 = r5.zzw()
            com.google.android.gms.measurement.internal.zzib r0 = r5.zzu
            com.google.android.gms.common.util.Clock r1 = r0.zzaZ()
            long r1 = r1.elapsedRealtime()
            com.google.android.gms.measurement.internal.zzhy r0 = r0.zzaW()
            com.google.android.gms.measurement.internal.zzc r3 = new com.google.android.gms.measurement.internal.zzc
            r3.<init>(r5, r1)
            r0.zzj(r3)
            return
        L_0x007a:
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzma.zzn(com.google.android.gms.internal.measurement.zzdf):void");
    }

    @MainThread
    public final void zzp(zzdf zzdf) {
        synchronized (this.zzj) {
            this.zzi = false;
            this.zzf = true;
        }
        zzib zzib = this.zzu;
        long elapsedRealtime = zzib.zzaZ().elapsedRealtime();
        if (!zzib.zzc().zzv()) {
            this.zzb = null;
            zzib.zzaW().zzj(new zzlx(this, elapsedRealtime));
            return;
        }
        zzlt zzB = zzB(zzdf);
        this.zzc = this.zzb;
        this.zzb = null;
        zzib.zzaW().zzj(new zzly(this, zzB, elapsedRealtime));
    }

    @MainThread
    public final void zzq(zzdf zzdf, Bundle bundle) {
        zzlt zzlt;
        if (this.zzu.zzc().zzv() && bundle != null && (zzlt = (zzlt) this.zzd.get(Integer.valueOf(zzdf.zza))) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", zzlt.zzc);
            bundle2.putString("name", zzlt.zza);
            bundle2.putString("referrer_name", zzlt.zzb);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    @MainThread
    public final void zzs(zzdf zzdf) {
        synchronized (this.zzj) {
            try {
                if (Objects.equals(this.zze, zzdf)) {
                    this.zze = null;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (this.zzu.zzc().zzv()) {
            this.zzd.remove(Integer.valueOf(zzdf.zza));
        }
    }

    public final /* synthetic */ void zzt(Bundle bundle, zzlt zzlt, zzlt zzlt2, long j) {
        bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
        bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        zzz(zzlt, zzlt2, j, true, this.zzu.zzk().zzF((String) null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, (List) null, false));
    }

    public final /* synthetic */ void zzu(zzlt zzlt, zzlt zzlt2, long j, boolean z, Bundle bundle) {
        zzz(zzlt, zzlt2, j, z, (Bundle) null);
    }

    public final /* synthetic */ void zzv(zzlt zzlt, boolean z, long j) {
        zzA(zzlt, false, j);
    }

    public final /* synthetic */ zzlt zzw() {
        return this.zzh;
    }

    public final /* synthetic */ void zzx(zzlt zzlt) {
        this.zzh = null;
    }
}
