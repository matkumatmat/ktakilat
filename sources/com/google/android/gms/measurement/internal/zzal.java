package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.perf.util.Constants;
import java.lang.reflect.InvocationTargetException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class zzal extends zzjd {
    private Boolean zza;
    private String zzb;
    private zzak zzc = zzaj.zza;
    private Boolean zzd;

    public zzal(zzib zzib) {
        super(zzib);
    }

    public static final long zzF() {
        return ((Long) zzfx.zzd.zzb((Object) null)).longValue();
    }

    public static final int zzG() {
        return Math.max(0, ((Integer) zzfx.zzi.zzb((Object) null)).intValue());
    }

    public static final long zzH() {
        return (long) ((Integer) zzfx.zzk.zzb((Object) null)).intValue();
    }

    public static final long zzI() {
        return ((Long) zzfx.zzR.zzb((Object) null)).longValue();
    }

    public static final long zzJ() {
        return ((Long) zzfx.zzM.zzb((Object) null)).longValue();
    }

    private final String zzK(String str, String str2) {
        try {
            Class<String> cls = String.class;
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{cls, cls}).invoke((Object) null, new Object[]{str, ""});
            Preconditions.checkNotNull(str3);
            return str3;
        } catch (ClassNotFoundException e) {
            this.zzu.zzaV().zzb().zzb("Could not find SystemProperties class", e);
            return "";
        } catch (NoSuchMethodException e2) {
            this.zzu.zzaV().zzb().zzb("Could not find SystemProperties.get() method", e2);
            return "";
        } catch (IllegalAccessException e3) {
            this.zzu.zzaV().zzb().zzb("Could not access SystemProperties.get()", e3);
            return "";
        } catch (InvocationTargetException e4) {
            this.zzu.zzaV().zzb().zzb("SystemProperties.get() threw an exception", e4);
            return "";
        }
    }

    public final String zzA() {
        return zzK("debug.firebase.analytics.app", "");
    }

    public final String zzB() {
        return zzK("debug.deferred.deeplink", "");
    }

    public final boolean zzC(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.zzc.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzD(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.zzc.zza(str, "measurement.event_sampling_enabled"));
    }

    @WorkerThread
    public final boolean zzE() {
        if (this.zza == null) {
            Boolean zzr = zzr("app_measurement_lite");
            this.zza = zzr;
            if (zzr == null) {
                this.zza = Boolean.FALSE;
            }
        }
        if (this.zza.booleanValue() || !this.zzu.zzp()) {
            return true;
        }
        return false;
    }

    public final void zza(zzak zzak) {
        this.zzc = zzak;
    }

    public final String zzb() {
        this.zzu.zzaU();
        return "FA";
    }

    public final int zzc() {
        if (this.zzu.zzk().zzag(201500000, true)) {
            return 100;
        }
        return 25;
    }

    public final int zzd(@Size(min = 1) String str) {
        return zzn(str, zzfx.zzX, 25, 100);
    }

    public final int zze(String str, boolean z) {
        if (z) {
            return zzn(str, zzfx.zzah, 100, 500);
        }
        return 500;
    }

    public final int zzf(String str, boolean z) {
        return Math.max(zze(str, z), 256);
    }

    public final int zzh(@Size(min = 1) String str) {
        return zzn(str, zzfx.zzW, 500, Constants.MAX_URL_LENGTH);
    }

    public final long zzi() {
        this.zzu.zzaU();
        return 130000;
    }

    @EnsuresNonNull({"this.isMainProcess"})
    public final boolean zzj() {
        if (this.zzd == null) {
            synchronized (this) {
                try {
                    if (this.zzd == null) {
                        zzib zzib = this.zzu;
                        ApplicationInfo applicationInfo = zzib.zzaY().getApplicationInfo();
                        String myProcessName = ProcessUtils.getMyProcessName();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            boolean z = false;
                            if (str != null && str.equals(myProcessName)) {
                                z = true;
                            }
                            this.zzd = Boolean.valueOf(z);
                        }
                        if (this.zzd == null) {
                            this.zzd = Boolean.TRUE;
                            zzib.zzaV().zzb().zza("My process not in the list of running processes");
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.zzd.booleanValue();
    }

    @WorkerThread
    public final String zzk(String str, zzfw zzfw) {
        if (TextUtils.isEmpty(str)) {
            return (String) zzfw.zzb((Object) null);
        }
        return (String) zzfw.zzb(this.zzc.zza(str, zzfw.zza()));
    }

    @WorkerThread
    public final long zzl(String str, zzfw zzfw) {
        if (TextUtils.isEmpty(str)) {
            return ((Long) zzfw.zzb((Object) null)).longValue();
        }
        String zza2 = this.zzc.zza(str, zzfw.zza());
        if (TextUtils.isEmpty(zza2)) {
            return ((Long) zzfw.zzb((Object) null)).longValue();
        }
        try {
            return ((Long) zzfw.zzb(Long.valueOf(Long.parseLong(zza2)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) zzfw.zzb((Object) null)).longValue();
        }
    }

    @WorkerThread
    public final int zzm(String str, zzfw zzfw) {
        if (TextUtils.isEmpty(str)) {
            return ((Integer) zzfw.zzb((Object) null)).intValue();
        }
        String zza2 = this.zzc.zza(str, zzfw.zza());
        if (TextUtils.isEmpty(zza2)) {
            return ((Integer) zzfw.zzb((Object) null)).intValue();
        }
        try {
            return ((Integer) zzfw.zzb(Integer.valueOf(Integer.parseInt(zza2)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) zzfw.zzb((Object) null)).intValue();
        }
    }

    @WorkerThread
    public final int zzn(String str, zzfw zzfw, int i, int i2) {
        return Math.max(Math.min(zzm(str, zzfw), i2), i);
    }

    @WorkerThread
    public final double zzo(String str, zzfw zzfw) {
        if (TextUtils.isEmpty(str)) {
            return ((Double) zzfw.zzb((Object) null)).doubleValue();
        }
        String zza2 = this.zzc.zza(str, zzfw.zza());
        if (TextUtils.isEmpty(zza2)) {
            return ((Double) zzfw.zzb((Object) null)).doubleValue();
        }
        try {
            return ((Double) zzfw.zzb(Double.valueOf(Double.parseDouble(zza2)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) zzfw.zzb((Object) null)).doubleValue();
        }
    }

    @WorkerThread
    public final boolean zzp(String str, zzfw zzfw) {
        if (TextUtils.isEmpty(str)) {
            return ((Boolean) zzfw.zzb((Object) null)).booleanValue();
        }
        String zza2 = this.zzc.zza(str, zzfw.zza());
        if (TextUtils.isEmpty(zza2)) {
            return ((Boolean) zzfw.zzb((Object) null)).booleanValue();
        }
        return ((Boolean) zzfw.zzb(Boolean.valueOf(AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(zza2)))).booleanValue();
    }

    @VisibleForTesting
    public final Bundle zzq() {
        try {
            zzib zzib = this.zzu;
            if (zzib.zzaY().getPackageManager() == null) {
                zzib.zzaV().zzb().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(zzib.zzaY()).getApplicationInfo(zzib.zzaY().getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            zzib.zzaV().zzb().zza("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            this.zzu.zzaV().zzb().zzb("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    public final Boolean zzr(@Size(min = 1) String str) {
        Preconditions.checkNotEmpty(str);
        Bundle zzq = zzq();
        if (zzq == null) {
            e.w(this.zzu, "Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!zzq.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(zzq.getBoolean(str));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026 A[SYNTHETIC, Splitter:B:8:0x0026] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zzs(@androidx.annotation.Size(min = 1) java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r4 = "analytics.safelisted_events"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r0 = r3.zzq()
            r1 = 0
            if (r0 != 0) goto L_0x0015
            com.google.android.gms.measurement.internal.zzib r4 = r3.zzu
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            defpackage.e.w(r4, r0)
        L_0x0013:
            r4 = r1
            goto L_0x0024
        L_0x0015:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L_0x001c
            goto L_0x0013
        L_0x001c:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x0024:
            if (r4 == 0) goto L_0x0050
            com.google.android.gms.measurement.internal.zzib r0 = r3.zzu     // Catch:{ NotFoundException -> 0x0040 }
            android.content.Context r0 = r0.zzaY()     // Catch:{ NotFoundException -> 0x0040 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ NotFoundException -> 0x0040 }
            int r4 = r4.intValue()     // Catch:{ NotFoundException -> 0x0040 }
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch:{ NotFoundException -> 0x0040 }
            if (r4 != 0) goto L_0x003b
            return r1
        L_0x003b:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ NotFoundException -> 0x0040 }
            return r4
        L_0x0040:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzib r0 = r3.zzu
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzb()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.zzb(r2, r4)
        L_0x0050:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzs(java.lang.String):java.util.List");
    }

    public final boolean zzt() {
        this.zzu.zzaU();
        Boolean zzr = zzr("firebase_analytics_collection_deactivated");
        if (zzr == null || !zzr.booleanValue()) {
            return false;
        }
        return true;
    }

    public final boolean zzu() {
        Boolean zzr = zzr("google_analytics_adid_collection_enabled");
        if (zzr == null || zzr.booleanValue()) {
            return true;
        }
        return false;
    }

    public final boolean zzv() {
        Boolean zzr = zzr("google_analytics_automatic_screen_reporting_enabled");
        if (zzr == null || zzr.booleanValue()) {
            return true;
        }
        return false;
    }

    public final zzjh zzw(String str, boolean z) {
        Object obj;
        Preconditions.checkNotEmpty(str);
        zzib zzib = this.zzu;
        Bundle zzq = zzq();
        if (zzq == null) {
            e.w(zzib, "Failed to load metadata: Metadata bundle is null");
            obj = null;
        } else {
            obj = zzq.get(str);
        }
        if (obj == null) {
            return zzjh.UNINITIALIZED;
        }
        if (Boolean.TRUE.equals(obj)) {
            return zzjh.GRANTED;
        }
        if (Boolean.FALSE.equals(obj)) {
            return zzjh.DENIED;
        }
        if (z && "eu_consent_policy".equals(obj)) {
            return zzjh.POLICY;
        }
        zzib.zzaV().zze().zzb("Invalid manifest metadata for", str);
        return zzjh.UNINITIALIZED;
    }

    public final boolean zzx() {
        Boolean zzr = zzr("google_analytics_sgtm_upload_enabled");
        if (zzr == null) {
            return false;
        }
        return zzr.booleanValue();
    }

    public final void zzy(String str) {
        this.zzb = str;
    }

    public final String zzz() {
        return this.zzb;
    }
}
