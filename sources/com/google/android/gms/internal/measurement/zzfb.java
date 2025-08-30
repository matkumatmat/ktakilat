package com.google.android.gms.internal.measurement;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzht;
import com.google.android.gms.measurement.internal.zzjo;
import com.google.android.gms.measurement.internal.zzls;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zzfb {
    private static volatile zzfb zzc;
    protected final Clock zza = DefaultClock.getInstance();
    protected final ExecutorService zzb;
    private final String zzd = "FA";
    private final AppMeasurementSdk zze;
    @GuardedBy("listenerList")
    private final List zzf;
    private int zzg;
    private boolean zzh;
    private final String zzi;
    private volatile zzcr zzj;

    public zzfb(Context context, Bundle bundle) {
        zzcm.zza();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzed(this));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zzb = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.zze = new AppMeasurementSdk(this);
        this.zzf = new ArrayList();
        try {
            if (zzls.zza(context, "google_app_id", zzht.zza(context)) != null) {
                try {
                    Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, zzfb.class.getClassLoader());
                } catch (ClassNotFoundException unused) {
                    this.zzi = null;
                    this.zzh = true;
                    Log.w(this.zzd, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Add Google Analytics for Firebase to resume data collection.");
                    return;
                }
            }
        } catch (IllegalStateException unused2) {
        }
        this.zzi = "fa";
        zzM(new zzdr(this, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzd, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzfa(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzS */
    public final void zzM(zzeq zzeq) {
        this.zzb.execute(zzeq);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzT */
    public final void zzN(Exception exc, boolean z, boolean z2) {
        this.zzh |= z;
        if (z) {
            Log.w(this.zzd, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zzD(5, "Error with data collection. Data lost.", exc, (Object) null, (Object) null);
        }
        Log.w(this.zzd, "Error with data collection. Data lost.", exc);
    }

    private final void zzU(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zzM(new zzep(this, l, str, str2, bundle, z, z2));
    }

    public static zzfb zza(Context context, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzc == null) {
            synchronized (zzfb.class) {
                try {
                    if (zzc == null) {
                        zzc = new zzfb(context, bundle);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return zzc;
    }

    public final String zzA() {
        zzco zzco = new zzco();
        zzM(new zzdz(this, zzco));
        return zzco.zzc(500);
    }

    public final String zzB() {
        zzco zzco = new zzco();
        zzM(new zzea(this, zzco));
        return zzco.zzc(500);
    }

    public final Map zzC(String str, String str2, boolean z) {
        zzco zzco = new zzco();
        zzM(new zzeb(this, str, str2, z, zzco));
        Bundle zze2 = zzco.zze(5000);
        if (zze2 == null || zze2.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(zze2.size());
        for (String next : zze2.keySet()) {
            Object obj = zze2.get(next);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(next, obj);
            }
        }
        return hashMap;
    }

    public final void zzD(int i, String str, Object obj, Object obj2, Object obj3) {
        zzM(new zzec(this, false, 5, str, obj, (Object) null, (Object) null));
    }

    public final Bundle zzE(Bundle bundle, boolean z) {
        zzco zzco = new zzco();
        zzM(new zzee(this, bundle, zzco));
        if (z) {
            return zzco.zze(5000);
        }
        return null;
    }

    public final int zzF(String str) {
        zzco zzco = new zzco();
        zzM(new zzef(this, str, zzco));
        Integer num = (Integer) zzco.zzf(zzco.zze(10000), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    @WorkerThread
    public final String zzG() {
        zzco zzco = new zzco();
        zzM(new zzeg(this, zzco));
        return zzco.zzc(120000);
    }

    @WorkerThread
    public final Long zzH() {
        zzco zzco = new zzco();
        zzM(new zzeh(this, zzco));
        return zzco.zzd(120000);
    }

    public final String zzI() {
        return this.zzi;
    }

    public final Object zzJ(int i) {
        zzco zzco = new zzco();
        zzM(new zzei(this, zzco, i));
        return zzco.zzf(zzco.zze(FaceEnvironment.TIME_DETECT_MODULE), Object.class);
    }

    public final void zzK(boolean z) {
        zzM(new zzej(this, z));
    }

    public final void zzL(Bundle bundle) {
        zzM(new zzek(this, bundle));
    }

    public final /* synthetic */ String zzO() {
        return this.zzd;
    }

    public final /* synthetic */ boolean zzP() {
        return this.zzh;
    }

    public final /* synthetic */ zzcr zzQ() {
        return this.zzj;
    }

    public final /* synthetic */ void zzR(zzcr zzcr) {
        this.zzj = zzcr;
    }

    public final AppMeasurementSdk zzb() {
        return this.zze;
    }

    public final zzcr zzc(Context context, boolean z) {
        DynamiteModule.VersionPolicy versionPolicy;
        if (z) {
            try {
                versionPolicy = DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION;
            } catch (DynamiteModule.LoadingException e) {
                zzN(e, true, false);
                return null;
            }
        } else {
            versionPolicy = DynamiteModule.PREFER_LOCAL;
        }
        return zzcq.asInterface(DynamiteModule.load(context, versionPolicy, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
    }

    public final void zzd(zzjo zzjo) {
        zzer zzer = new zzer(zzjo);
        if (this.zzj != null) {
            try {
                this.zzj.setEventInterceptor(zzer);
                return;
            } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                Log.w(this.zzd, "Failed to set event interceptor on calling thread. Trying again on the dynamite thread.");
            }
        }
        zzM(new zzel(this, zzer));
    }

    public final void zze(Intent intent) {
        zzM(new zzem(this, intent));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r3.zzj == null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r3.zzj.registerOnMeasurementEventListener(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
        android.util.Log.w(r3.zzd, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0048, code lost:
        zzS(new com.google.android.gms.internal.measurement.zzen(r3, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0050, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf(com.google.android.gms.measurement.internal.zzjp r4) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            java.util.List r0 = r3.zzf
            monitor-enter(r0)
            r1 = 0
        L_0x0007:
            int r2 = r0.size()     // Catch:{ all -> 0x0024 }
            if (r1 >= r2) goto L_0x0029
            java.lang.Object r2 = r0.get(r1)     // Catch:{ all -> 0x0024 }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x0024 }
            java.lang.Object r2 = r2.first     // Catch:{ all -> 0x0024 }
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x0024 }
            if (r2 == 0) goto L_0x0026
            java.lang.String r4 = r3.zzd     // Catch:{ all -> 0x0024 }
            java.lang.String r1 = "OnEventListener already registered."
            android.util.Log.w(r4, r1)     // Catch:{ all -> 0x0024 }
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            return
        L_0x0024:
            r4 = move-exception
            goto L_0x0051
        L_0x0026:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x0029:
            com.google.android.gms.internal.measurement.zzes r1 = new com.google.android.gms.internal.measurement.zzes     // Catch:{ all -> 0x0024 }
            r1.<init>(r4)     // Catch:{ all -> 0x0024 }
            android.util.Pair r2 = new android.util.Pair     // Catch:{ all -> 0x0024 }
            r2.<init>(r4, r1)     // Catch:{ all -> 0x0024 }
            r0.add(r2)     // Catch:{ all -> 0x0024 }
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            com.google.android.gms.internal.measurement.zzcr r4 = r3.zzj
            if (r4 == 0) goto L_0x0048
            com.google.android.gms.internal.measurement.zzcr r4 = r3.zzj     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0041 }
            r4.registerOnMeasurementEventListener(r1)     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0041 }
            return
        L_0x0041:
            java.lang.String r4 = r3.zzd
            java.lang.String r0 = "Failed to register event listener on calling thread. Trying again on the dynamite thread."
            android.util.Log.w(r4, r0)
        L_0x0048:
            com.google.android.gms.internal.measurement.zzen r4 = new com.google.android.gms.internal.measurement.zzen
            r4.<init>(r3, r1)
            r3.zzM(r4)
            return
        L_0x0051:
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfb.zzf(com.google.android.gms.measurement.internal.zzjp):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003d, code lost:
        if (r3.zzj == null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r3.zzj.unregisterOnMeasurementEventListener(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0045, code lost:
        android.util.Log.w(r3.zzd, "Failed to unregister event listener on calling thread. Trying again on the dynamite thread.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004c, code lost:
        zzS(new com.google.android.gms.internal.measurement.zzeo(r3, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0054, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(com.google.android.gms.measurement.internal.zzjp r4) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            java.util.List r0 = r3.zzf
            monitor-enter(r0)
            r1 = 0
        L_0x0007:
            int r2 = r0.size()     // Catch:{ all -> 0x0022 }
            if (r1 >= r2) goto L_0x0027
            java.lang.Object r2 = r0.get(r1)     // Catch:{ all -> 0x0022 }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x0022 }
            java.lang.Object r2 = r2.first     // Catch:{ all -> 0x0022 }
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x0022 }
            if (r2 == 0) goto L_0x0024
            java.lang.Object r4 = r0.get(r1)     // Catch:{ all -> 0x0022 }
            android.util.Pair r4 = (android.util.Pair) r4     // Catch:{ all -> 0x0022 }
            goto L_0x0028
        L_0x0022:
            r4 = move-exception
            goto L_0x0055
        L_0x0024:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x0027:
            r4 = 0
        L_0x0028:
            if (r4 != 0) goto L_0x0033
            java.lang.String r4 = r3.zzd     // Catch:{ all -> 0x0022 }
            java.lang.String r1 = "OnEventListener had not been registered."
            android.util.Log.w(r4, r1)     // Catch:{ all -> 0x0022 }
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            return
        L_0x0033:
            r0.remove(r4)     // Catch:{ all -> 0x0022 }
            java.lang.Object r4 = r4.second     // Catch:{ all -> 0x0022 }
            com.google.android.gms.internal.measurement.zzes r4 = (com.google.android.gms.internal.measurement.zzes) r4     // Catch:{ all -> 0x0022 }
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            com.google.android.gms.internal.measurement.zzcr r0 = r3.zzj
            if (r0 == 0) goto L_0x004c
            com.google.android.gms.internal.measurement.zzcr r0 = r3.zzj     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0045 }
            r0.unregisterOnMeasurementEventListener(r4)     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0045 }
            return
        L_0x0045:
            java.lang.String r0 = r3.zzd
            java.lang.String r1 = "Failed to unregister event listener on calling thread. Trying again on the dynamite thread."
            android.util.Log.w(r0, r1)
        L_0x004c:
            com.google.android.gms.internal.measurement.zzeo r0 = new com.google.android.gms.internal.measurement.zzeo
            r0.<init>(r3, r4)
            r3.zzM(r0)
            return
        L_0x0055:
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfb.zzg(com.google.android.gms.measurement.internal.zzjp):void");
    }

    public final void zzh(@NonNull String str, Bundle bundle) {
        zzU((String) null, str, bundle, false, true, (Long) null);
    }

    public final void zzi(String str, String str2, Bundle bundle) {
        zzU(str, str2, bundle, true, true, (Long) null);
    }

    public final void zzj(String str, String str2, Bundle bundle, long j) {
        zzU(str, str2, bundle, true, false, Long.valueOf(j));
    }

    public final void zzk(String str, String str2, Object obj, boolean z) {
        zzM(new zzdh(this, str, str2, obj, z));
    }

    public final void zzl(Bundle bundle) {
        zzM(new zzdi(this, bundle));
    }

    public final void zzm(String str, String str2, Bundle bundle) {
        zzM(new zzdj(this, str, str2, bundle));
    }

    public final List zzn(String str, String str2) {
        zzco zzco = new zzco();
        zzM(new zzdk(this, str, str2, zzco));
        List list = (List) zzco.zzf(zzco.zze(5000), List.class);
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    public final void zzo(String str) {
        zzM(new zzdl(this, str));
    }

    public final void zzp(zzdf zzdf, String str, String str2) {
        zzM(new zzdm(this, zzdf, str, str2));
    }

    public final void zzq(Boolean bool) {
        zzM(new zzdn(this, bool));
    }

    public final void zzr(Bundle bundle) {
        zzM(new zzdo(this, bundle));
    }

    public final void zzs() {
        zzM(new zzdp(this));
    }

    public final void zzt(long j) {
        zzM(new zzdq(this, j));
    }

    public final void zzu(String str) {
        zzM(new zzds(this, str));
    }

    public final void zzv(String str) {
        zzM(new zzdt(this, str));
    }

    public final void zzw(Runnable runnable) {
        zzM(new zzdv(this, runnable));
    }

    public final String zzx() {
        zzco zzco = new zzco();
        zzM(new zzdw(this, zzco));
        return zzco.zzc(500);
    }

    public final String zzy() {
        zzco zzco = new zzco();
        zzM(new zzdx(this, zzco));
        return zzco.zzc(50);
    }

    public final long zzz() {
        zzco zzco = new zzco();
        zzM(new zzdy(this, zzco));
        Long zzd2 = zzco.zzd(500);
        if (zzd2 != null) {
            return zzd2.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
        int i = this.zzg + 1;
        this.zzg = i;
        return nextLong + ((long) i);
    }
}
