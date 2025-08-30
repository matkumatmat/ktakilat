package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.app.BroadcastOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzdd;
import com.google.android.gms.internal.measurement.zzkl;
import com.google.firebase.messaging.Constants;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzib implements zzjf {
    private static volatile zzib zzb;
    private volatile Boolean zzA;
    private volatile boolean zzB;
    private int zzC;
    private int zzD;
    private final AtomicInteger zzE = new AtomicInteger(0);
    @VisibleForTesting
    final long zza;
    private final Context zzc;
    private final boolean zzd;
    private final zzae zze;
    private final zzal zzf;
    private final zzhg zzg;
    private final zzgt zzh;
    private final zzhy zzi;
    private final zzob zzj;
    private final zzpo zzk;
    private final zzgm zzl;
    private final Clock zzm;
    private final zzma zzn;
    private final zzli zzo;
    private final zzd zzp;
    private final zzln zzq;
    private final String zzr;
    private zzgk zzs;
    private zznk zzt;
    private zzba zzu;
    private zzgh zzv;
    private zzlp zzw;
    private boolean zzx = false;
    private Boolean zzy;
    private long zzz;

    public zzib(zzjr zzjr) {
        long j;
        boolean z = false;
        Preconditions.checkNotNull(zzjr);
        Context context = zzjr.zza;
        zzae zzae = new zzae(context);
        this.zze = zzae;
        zzfr.zza = zzae;
        this.zzc = context;
        this.zzd = zzjr.zze;
        this.zzA = zzjr.zzb;
        this.zzr = zzjr.zzg;
        this.zzB = true;
        zzkl.zzb(context);
        Clock instance = DefaultClock.getInstance();
        this.zzm = instance;
        Long l = zzjr.zzf;
        if (l != null) {
            j = l.longValue();
        } else {
            j = instance.currentTimeMillis();
        }
        this.zza = j;
        this.zzf = new zzal(this);
        zzhg zzhg = new zzhg(this);
        zzhg.zzx();
        this.zzg = zzhg;
        zzgt zzgt = new zzgt(this);
        zzgt.zzx();
        this.zzh = zzgt;
        zzpo zzpo = new zzpo(this);
        zzpo.zzx();
        this.zzk = zzpo;
        this.zzl = new zzgm(new zzjq(zzjr, this));
        this.zzp = new zzd(this);
        zzma zzma = new zzma(this);
        zzma.zzc();
        this.zzn = zzma;
        zzli zzli = new zzli(this);
        zzli.zzc();
        this.zzo = zzli;
        zzob zzob = new zzob(this);
        zzob.zzc();
        this.zzj = zzob;
        zzln zzln = new zzln(this);
        zzln.zzx();
        this.zzq = zzln;
        zzhy zzhy = new zzhy(this);
        zzhy.zzx();
        this.zzi = zzhy;
        zzdd zzdd = zzjr.zzd;
        z = (zzdd == null || zzdd.zzb == 0) ? true : z;
        if (context.getApplicationContext() instanceof Application) {
            zzO(zzli);
            if (zzli.zzu.zzc.getApplicationContext() instanceof Application) {
                Application application = (Application) zzli.zzu.zzc.getApplicationContext();
                if (zzli.zza == null) {
                    zzli.zza = new zzkx(zzli);
                }
                if (z) {
                    application.unregisterActivityLifecycleCallbacks(zzli.zza);
                    application.registerActivityLifecycleCallbacks(zzli.zza);
                    zzgt zzgt2 = zzli.zzu.zzh;
                    zzP(zzgt2);
                    zzgt2.zzk().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzP(zzgt);
            zzgt.zze().zza("Application context is not an Application");
        }
        zzhy.zzj(new zzhz(this, zzjr));
    }

    public static final void zzL() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private static final void zzM(zzf zzf2) {
        if (zzf2 == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void zzN(zzjd zzjd) {
        if (zzjd == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void zzO(zzg zzg2) {
        if (zzg2 == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzg2.zza()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzg2.getClass())));
        }
    }

    private static final void zzP(zzje zzje) {
        if (zzje == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzje.zzv()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzje.getClass())));
        }
    }

    public static zzib zzy(Context context, zzdd zzdd, Long l) {
        Bundle bundle;
        if (zzdd != null) {
            Bundle bundle2 = zzdd.zzd;
            boolean z = zzdd.zzc;
            zzdd = new zzdd(zzdd.zza, zzdd.zzb, z, bundle2, (String) null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzib.class) {
                try {
                    if (zzb == null) {
                        zzb = new zzib(new zzjr(context, zzdd, l));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (!(zzdd == null || (bundle = zzdd.zzd) == null || !bundle.containsKey("dataCollectionDefaultEnabled"))) {
            Preconditions.checkNotNull(zzb);
            zzb.zzA = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzb);
        return zzb;
    }

    @WorkerThread
    public final boolean zzA() {
        if (this.zzA == null || !this.zzA.booleanValue()) {
            return false;
        }
        return true;
    }

    @WorkerThread
    public final boolean zzB() {
        if (zzC() == 0) {
            return true;
        }
        return false;
    }

    @WorkerThread
    public final int zzC() {
        zzhy zzhy = this.zzi;
        zzP(zzhy);
        zzhy.zzg();
        zzal zzal = this.zzf;
        if (zzal.zzt()) {
            return 1;
        }
        zzP(zzhy);
        zzhy.zzg();
        if (!this.zzB) {
            return 8;
        }
        zzhg zzhg = this.zzg;
        zzN(zzhg);
        Boolean zzi2 = zzhg.zzi();
        if (zzi2 == null) {
            zzae zzae = zzal.zzu.zze;
            Boolean zzr2 = zzal.zzr("firebase_analytics_collection_enabled");
            if (zzr2 != null) {
                if (zzr2.booleanValue()) {
                    return 0;
                }
                return 4;
            } else if (this.zzA == null || this.zzA.booleanValue()) {
                return 0;
            } else {
                return 7;
            }
        } else if (zzi2.booleanValue()) {
            return 0;
        } else {
            return 3;
        }
    }

    @WorkerThread
    public final void zzD(boolean z) {
        zzhy zzhy = this.zzi;
        zzP(zzhy);
        zzhy.zzg();
        this.zzB = z;
    }

    @WorkerThread
    public final boolean zzE() {
        zzhy zzhy = this.zzi;
        zzP(zzhy);
        zzhy.zzg();
        return this.zzB;
    }

    public final void zzF() {
        this.zzC++;
    }

    public final void zzG() {
        this.zzE.incrementAndGet();
    }

    @WorkerThread
    public final boolean zzH() {
        if (this.zzx) {
            zzhy zzhy = this.zzi;
            zzP(zzhy);
            zzhy.zzg();
            Boolean bool = this.zzy;
            if (bool == null || this.zzz == 0 || (!bool.booleanValue() && Math.abs(this.zzm.elapsedRealtime() - this.zzz) > 1000)) {
                this.zzz = this.zzm.elapsedRealtime();
                zzpo zzpo = this.zzk;
                zzN(zzpo);
                boolean z = false;
                if (zzpo.zzY("android.permission.INTERNET")) {
                    zzN(zzpo);
                    if (zzpo.zzY("android.permission.ACCESS_NETWORK_STATE")) {
                        Context context = this.zzc;
                        if (Wrappers.packageManager(context).isCallerInstantApp() || this.zzf.zzE() || (zzpo.zzau(context) && zzpo.zzQ(context, false))) {
                            z = true;
                        }
                    }
                }
                Boolean valueOf = Boolean.valueOf(z);
                this.zzy = valueOf;
                if (valueOf.booleanValue()) {
                    zzN(zzpo);
                    this.zzy = Boolean.valueOf(zzpo.zzA(zzv().zzk()));
                }
            }
            return this.zzy.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0088, code lost:
        if (r4.zzah() >= 234200) goto L_0x008a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0195  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzI() {
        /*
            r11 = this;
            com.google.android.gms.measurement.internal.zzhy r0 = r11.zzi
            zzP(r0)
            r0.zzg()
            com.google.android.gms.measurement.internal.zzln r0 = r11.zzq
            zzP(r0)
            zzP(r0)
            com.google.android.gms.measurement.internal.zzgh r1 = r11.zzv()
            java.lang.String r1 = r1.zzj()
            com.google.android.gms.measurement.internal.zzal r2 = r11.zzf
            boolean r2 = r2.zzu()
            r10 = 0
            if (r2 == 0) goto L_0x01b3
            com.google.android.gms.measurement.internal.zzhg r2 = r11.zzg
            zzN(r2)
            android.util.Pair r2 = r2.zzb(r1)
            java.lang.Object r3 = r2.second
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 != 0) goto L_0x01a4
            java.lang.Object r3 = r2.first
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x0040
            goto L_0x01a4
        L_0x0040:
            zzP(r0)
            r0.zzw()
            com.google.android.gms.measurement.internal.zzib r0 = r0.zzu
            android.content.Context r0 = r0.zzc
            java.lang.String r3 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r3)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            r3 = 0
            if (r0 == 0) goto L_0x005b
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch:{ SecurityException -> 0x005a }
            goto L_0x005c
        L_0x005a:
        L_0x005b:
            r0 = r3
        L_0x005c:
            if (r0 == 0) goto L_0x0195
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L_0x0195
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.google.android.gms.measurement.internal.zznk r4 = r11.zzt()
            r4.zzg()
            r4.zzb()
            boolean r5 = r4.zzK()
            if (r5 != 0) goto L_0x007a
            goto L_0x008a
        L_0x007a:
            com.google.android.gms.measurement.internal.zzib r4 = r4.zzu
            com.google.android.gms.measurement.internal.zzpo r4 = r4.zzk
            zzN(r4)
            int r4 = r4.zzah()
            r5 = 234200(0x392d8, float:3.28184E-40)
            if (r4 < r5) goto L_0x013b
        L_0x008a:
            com.google.android.gms.measurement.internal.zzli r4 = r11.zzo
            zzO(r4)
            com.google.android.gms.measurement.internal.zzib r5 = r4.zzu
            r4.zzg()
            com.google.android.gms.measurement.internal.zznk r4 = r5.zzt()
            com.google.android.gms.measurement.internal.zzao r4 = r4.zzz()
            if (r4 == 0) goto L_0x00a0
            android.os.Bundle r3 = r4.zza
        L_0x00a0:
            r4 = 1
            if (r3 != 0) goto L_0x00db
            int r0 = r11.zzD
            int r1 = r0 + 1
            r11.zzD = r1
            r1 = 10
            if (r0 >= r1) goto L_0x00ae
            r10 = 1
        L_0x00ae:
            com.google.android.gms.measurement.internal.zzgt r2 = r11.zzh
            zzP(r2)
            if (r0 >= r1) goto L_0x00b8
            java.lang.String r0 = "Retrying."
            goto L_0x00ba
        L_0x00b8:
            java.lang.String r0 = "Skipping."
        L_0x00ba:
            com.google.android.gms.measurement.internal.zzgr r1 = r2.zzj()
            int r2 = r0.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r2 = r2 + 60
            r3.<init>(r2)
            java.lang.String r2 = "Failed to retrieve DMA consent from the service, "
            java.lang.String r4 = " retryCount"
            java.lang.String r0 = defpackage.e.q(r3, r2, r0, r4)
            int r2 = r11.zzD
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.zzb(r0, r2)
            return r10
        L_0x00db:
            r5 = 100
            com.google.android.gms.measurement.internal.zzjk r6 = com.google.android.gms.measurement.internal.zzjk.zze(r3, r5)
            java.lang.String r7 = "&gcs="
            r0.append(r7)
            java.lang.String r6 = r6.zzk()
            r0.append(r6)
            com.google.android.gms.measurement.internal.zzaz r5 = com.google.android.gms.measurement.internal.zzaz.zzh(r3, r5)
            java.lang.String r6 = "&dma="
            r0.append(r6)
            java.lang.Boolean r6 = r5.zzj()
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            boolean r6 = java.util.Objects.equals(r6, r7)
            r6 = r6 ^ r4
            r0.append(r6)
            java.lang.String r6 = r5.zzk()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x011a
            java.lang.String r6 = "&dma_cps="
            r0.append(r6)
            java.lang.String r5 = r5.zzk()
            r0.append(r5)
        L_0x011a:
            java.lang.Boolean r3 = com.google.android.gms.measurement.internal.zzaz.zzi(r3)
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            boolean r3 = java.util.Objects.equals(r3, r5)
            r3 = r3 ^ r4
            java.lang.String r4 = "&npa="
            r0.append(r4)
            r0.append(r3)
            com.google.android.gms.measurement.internal.zzgt r3 = r11.zzh
            zzP(r3)
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzk()
            java.lang.String r4 = "Consent query parameters to Bow"
            r3.zzb(r4, r0)
        L_0x013b:
            com.google.android.gms.measurement.internal.zzpo r3 = r11.zzk
            zzN(r3)
            com.google.android.gms.measurement.internal.zzgh r4 = r11.zzv()
            com.google.android.gms.measurement.internal.zzib r4 = r4.zzu
            com.google.android.gms.measurement.internal.zzal r4 = r4.zzf
            r4.zzi()
            java.lang.Object r2 = r2.first
            r6 = r2
            java.lang.String r6 = (java.lang.String) r6
            com.google.android.gms.measurement.internal.zzhg r2 = r11.zzg
            zzN(r2)
            com.google.android.gms.measurement.internal.zzhd r2 = r2.zzp
            long r4 = r2.zza()
            r7 = -1
            long r7 = r7 + r4
            java.lang.String r9 = r0.toString()
            r4 = 130000(0x1fbd0, double:6.42285E-319)
            r2 = r3
            r3 = r4
            r5 = r1
            java.net.URL r5 = r2.zzat(r3, r5, r6, r7, r9)
            if (r5 == 0) goto L_0x0194
            com.google.android.gms.measurement.internal.zzln r3 = r11.zzq
            zzP(r3)
            com.google.android.gms.measurement.internal.zzia r8 = new com.google.android.gms.measurement.internal.zzia
            r8.<init>(r11)
            r3.zzw()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)
            com.google.android.gms.measurement.internal.zzib r0 = r3.zzu
            com.google.android.gms.measurement.internal.zzhy r0 = r0.zzi
            zzP(r0)
            com.google.android.gms.measurement.internal.zzlm r9 = new com.google.android.gms.measurement.internal.zzlm
            r6 = 0
            r7 = 0
            r2 = r9
            r4 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r0.zzm(r9)
        L_0x0194:
            return r10
        L_0x0195:
            com.google.android.gms.measurement.internal.zzgt r0 = r11.zzh
            zzP(r0)
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zze()
            java.lang.String r1 = "Network is not available for Deferred Deep Link request. Skipping"
            r0.zza(r1)
            return r10
        L_0x01a4:
            com.google.android.gms.measurement.internal.zzgt r0 = r11.zzh
            zzP(r0)
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzk()
            java.lang.String r1 = "ADID unavailable to retrieve Deferred Deep Link. Skipping"
            r0.zza(r1)
            return r10
        L_0x01b3:
            com.google.android.gms.measurement.internal.zzgt r0 = r11.zzh
            zzP(r0)
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzk()
            java.lang.String r1 = "ADID collection is disabled from Manifest. Skipping"
            r0.zza(r1)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzib.zzI():boolean");
    }

    public final /* synthetic */ void zzJ(String str, int i, Throwable th, byte[] bArr, Map map) {
        int i2;
        int i3 = i;
        Throwable th2 = th;
        byte[] bArr2 = bArr;
        if (i3 == 200 || i3 == 204) {
            i2 = i3;
        } else {
            i2 = 304;
            if (i3 != 304) {
                i2 = i3;
                zzgt zzgt = this.zzh;
                zzP(zzgt);
                zzgt.zze().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th2);
            }
        }
        if (th2 == null) {
            zzhg zzhg = this.zzg;
            zzN(zzhg);
            zzhg.zzo.zzb(true);
            if (bArr2 == null || bArr2.length == 0) {
                zzgt zzgt2 = this.zzh;
                zzP(zzgt2);
                zzgt2.zzj().zza("Deferred Deep Link response empty.");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr2));
                String optString = jSONObject.optString("deeplink", "");
                if (TextUtils.isEmpty(optString)) {
                    zzgt zzgt3 = this.zzh;
                    zzP(zzgt3);
                    zzgt3.zzj().zza("Deferred Deep Link is empty.");
                    return;
                }
                String optString2 = jSONObject.optString("gclid", "");
                String optString3 = jSONObject.optString("gbraid", "");
                String optString4 = jSONObject.optString("gad_source", "");
                double optDouble = jSONObject.optDouble("timestamp", 0.0d);
                Bundle bundle = new Bundle();
                zzpo zzpo = this.zzk;
                zzN(zzpo);
                zzib zzib = zzpo.zzu;
                if (!TextUtils.isEmpty(optString)) {
                    Context context = zzib.zzc;
                    String str2 = "timestamp";
                    double d = optDouble;
                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0);
                    if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                        if (!TextUtils.isEmpty(optString3)) {
                            bundle.putString("gbraid", optString3);
                        }
                        if (!TextUtils.isEmpty(optString4)) {
                            bundle.putString("gad_source", optString4);
                        }
                        bundle.putString("gclid", optString2);
                        bundle.putString("_cis", "ddp");
                        this.zzo.zzF("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle);
                        zzN(zzpo);
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                SharedPreferences.Editor edit = context.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                                edit.putString("deeplink", optString);
                                edit.putLong(str2, Double.doubleToRawLongBits(d));
                                if (edit.commit()) {
                                    Intent intent = new Intent("android.google.analytics.action.DEEPLINK_ACTION");
                                    Context context2 = zzpo.zzu.zzc;
                                    if (Build.VERSION.SDK_INT < 34) {
                                        context2.sendBroadcast(intent);
                                        return;
                                    } else {
                                        context2.sendBroadcast(intent, (String) null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } catch (RuntimeException e) {
                                zzgt zzgt4 = zzpo.zzu.zzh;
                                zzP(zzgt4);
                                zzgt4.zzb().zzb("Failed to persist Deferred Deep Link. exception", e);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                zzgt zzgt5 = this.zzh;
                zzP(zzgt5);
                zzgt5.zze().zzd("Deferred Deep Link validation failed. gclid, gbraid, deep link", optString2, optString3, optString);
                return;
            } catch (JSONException e2) {
                zzgt zzgt6 = this.zzh;
                zzP(zzgt6);
                zzgt6.zzb().zzb("Failed to parse the Deferred Deep Link response. exception", e2);
                return;
            }
        }
        zzgt zzgt7 = this.zzh;
        zzP(zzgt7);
        zzgt7.zze().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th2);
    }

    public final /* synthetic */ void zzK(zzjr zzjr) {
        long j;
        zzhy zzhy = this.zzi;
        zzP(zzhy);
        zzhy.zzg();
        zzal zzal = this.zzf;
        zzal.zzb();
        zzba zzba = new zzba(this);
        zzba.zzx();
        this.zzu = zzba;
        zzdd zzdd = zzjr.zzd;
        if (zzdd == null) {
            j = 0;
        } else {
            j = zzdd.zza;
        }
        zzgh zzgh = new zzgh(this, zzjr.zzc, j);
        zzgh.zzc();
        this.zzv = zzgh;
        zzgk zzgk = new zzgk(this);
        zzgk.zzc();
        this.zzs = zzgk;
        zznk zznk = new zznk(this);
        zznk.zzc();
        this.zzt = zznk;
        zzpo zzpo = this.zzk;
        zzpo.zzy();
        this.zzg.zzy();
        this.zzv.zzd();
        zzlp zzlp = new zzlp(this);
        zzlp.zzc();
        this.zzw = zzlp;
        zzlp.zzd();
        zzgt zzgt = this.zzh;
        zzP(zzgt);
        zzgr zzi2 = zzgt.zzi();
        zzal.zzi();
        zzi2.zzb("App measurement initialized, version", 130000L);
        zzP(zzgt);
        zzgt.zzi().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzj2 = zzgh.zzj();
        zzN(zzpo);
        if (zzpo.zzaa(zzj2, zzal.zzz())) {
            zzP(zzgt);
            zzgt.zzi().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
        } else {
            zzP(zzgt);
            zzgt.zzi().zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(zzj2)));
        }
        zzP(zzgt);
        zzgt.zzj().zza("Debug-level message logging enabled");
        int i = this.zzC;
        AtomicInteger atomicInteger = this.zzE;
        if (i != atomicInteger.get()) {
            zzP(zzgt);
            zzgt.zzb().zzc("Not all components initialized", Integer.valueOf(this.zzC), Integer.valueOf(atomicInteger.get()));
        }
        this.zzx = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0030, code lost:
        if (r1.zzS() == false) goto L_0x0032;
     */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x03b6  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0254  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.measurement.zzdd r14) {
        /*
            r13 = this;
            com.google.android.gms.measurement.internal.zzhy r0 = r13.zzi
            zzP(r0)
            r0.zzg()
            com.google.android.gms.measurement.internal.zzlp r0 = r13.zzx()
            com.google.android.gms.internal.measurement.zzin r0 = r0.zzj()
            com.google.android.gms.internal.measurement.zzin r1 = com.google.android.gms.internal.measurement.zzin.CLIENT_UPLOAD_ELIGIBLE
            com.google.android.gms.internal.measurement.zzql.zza()
            com.google.android.gms.measurement.internal.zzfw r2 = com.google.android.gms.measurement.internal.zzfx.zzaQ
            com.google.android.gms.measurement.internal.zzal r3 = r13.zzf
            r4 = 0
            boolean r2 = r3.zzp(r4, r2)
            r5 = 0
            r6 = 1
            if (r0 != r1) goto L_0x0024
            r0 = 1
            goto L_0x0025
        L_0x0024:
            r0 = 0
        L_0x0025:
            if (r2 == 0) goto L_0x0032
            com.google.android.gms.measurement.internal.zzpo r1 = r13.zzk
            zzN(r1)
            boolean r1 = r1.zzS()
            if (r1 != 0) goto L_0x0035
        L_0x0032:
            if (r0 == 0) goto L_0x007e
            r0 = 1
        L_0x0035:
            com.google.android.gms.measurement.internal.zzpo r1 = r13.zzk
            zzN(r1)
            r1.zzg()
            android.content.IntentFilter r2 = new android.content.IntentFilter
            r2.<init>()
            java.lang.String r7 = "com.google.android.gms.measurement.TRIGGERS_AVAILABLE"
            r2.addAction(r7)
            java.lang.String r7 = "com.google.android.gms.measurement.BATCHES_AVAILABLE"
            r2.addAction(r7)
            com.google.android.gms.measurement.internal.zzw r7 = new com.google.android.gms.measurement.internal.zzw
            com.google.android.gms.measurement.internal.zzib r8 = r1.zzu
            r7.<init>(r8)
            com.google.android.gms.measurement.internal.zzib r1 = r1.zzu
            android.content.Context r8 = r1.zzc
            r9 = 2
            androidx.core.content.ContextCompat.registerReceiver(r8, r7, r2, r9)
            com.google.android.gms.measurement.internal.zzgt r1 = r1.zzh
            zzP(r1)
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzj()
            java.lang.String r2 = "Registered app receiver"
            r1.zza(r2)
            if (r0 == 0) goto L_0x007e
            com.google.android.gms.measurement.internal.zzlp r0 = r13.zzx()
            com.google.android.gms.measurement.internal.zzfw r1 = com.google.android.gms.measurement.internal.zzfx.zzB
            java.lang.Object r1 = r1.zzb(r4)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            r0.zzh(r1)
        L_0x007e:
            com.google.android.gms.measurement.internal.zzhg r0 = r13.zzg
            zzN(r0)
            com.google.android.gms.measurement.internal.zzjk r1 = r0.zzl()
            int r2 = r1.zzb()
            java.lang.String r7 = "google_analytics_default_allow_ad_storage"
            com.google.android.gms.measurement.internal.zzjh r7 = r3.zzw(r7, r5)
            java.lang.String r8 = "google_analytics_default_allow_analytics_storage"
            com.google.android.gms.measurement.internal.zzjh r8 = r3.zzw(r8, r5)
            com.google.android.gms.measurement.internal.zzjh r9 = com.google.android.gms.measurement.internal.zzjh.UNINITIALIZED
            r10 = 30
            r11 = -10
            if (r7 != r9) goto L_0x00a1
            if (r8 == r9) goto L_0x00af
        L_0x00a1:
            zzN(r0)
            boolean r12 = r0.zzk(r11)
            if (r12 == 0) goto L_0x00af
            com.google.android.gms.measurement.internal.zzjk r2 = com.google.android.gms.measurement.internal.zzjk.zza(r7, r8, r11)
            goto L_0x00da
        L_0x00af:
            com.google.android.gms.measurement.internal.zzgh r7 = r13.zzv()
            java.lang.String r7 = r7.zzk()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x00ca
            if (r2 == 0) goto L_0x00cc
            if (r2 == r10) goto L_0x00cc
            r7 = 10
            if (r2 == r7) goto L_0x00cc
            r7 = 40
            if (r2 != r7) goto L_0x00ca
            goto L_0x00cc
        L_0x00ca:
            r2 = r4
            goto L_0x00da
        L_0x00cc:
            com.google.android.gms.measurement.internal.zzli r2 = r13.zzo
            zzO(r2)
            com.google.android.gms.measurement.internal.zzjk r7 = new com.google.android.gms.measurement.internal.zzjk
            r7.<init>(r4, r4, r11)
            r2.zzs(r7, r5)
            goto L_0x00ca
        L_0x00da:
            if (r2 == 0) goto L_0x00e5
            com.google.android.gms.measurement.internal.zzli r1 = r13.zzo
            zzO(r1)
            r1.zzs(r2, r6)
            r1 = r2
        L_0x00e5:
            com.google.android.gms.measurement.internal.zzli r2 = r13.zzo
            zzO(r2)
            r2.zzA(r1)
            zzN(r0)
            com.google.android.gms.measurement.internal.zzaz r1 = r0.zzj()
            int r1 = r1.zzb()
            java.lang.String r7 = "google_analytics_default_allow_ad_personalization_signals"
            com.google.android.gms.measurement.internal.zzjh r7 = r3.zzw(r7, r6)
            if (r7 == r9) goto L_0x010e
            com.google.android.gms.measurement.internal.zzgt r8 = r13.zzh
            zzP(r8)
            com.google.android.gms.measurement.internal.zzgr r8 = r8.zzk()
            java.lang.String r12 = "Default ad personalization consent from Manifest"
            r8.zzb(r12, r7)
        L_0x010e:
            java.lang.String r7 = "google_analytics_default_allow_ad_user_data"
            com.google.android.gms.measurement.internal.zzjh r7 = r3.zzw(r7, r6)
            if (r7 == r9) goto L_0x0127
            boolean r8 = com.google.android.gms.measurement.internal.zzjk.zzu(r11, r1)
            if (r8 == 0) goto L_0x0127
            zzO(r2)
            com.google.android.gms.measurement.internal.zzaz r14 = com.google.android.gms.measurement.internal.zzaz.zza(r7, r11)
            r2.zzq(r14, r6)
            goto L_0x016f
        L_0x0127:
            com.google.android.gms.measurement.internal.zzgh r7 = r13.zzv()
            java.lang.String r7 = r7.zzk()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0145
            if (r1 == 0) goto L_0x0139
            if (r1 != r10) goto L_0x0145
        L_0x0139:
            zzO(r2)
            com.google.android.gms.measurement.internal.zzaz r14 = new com.google.android.gms.measurement.internal.zzaz
            r14.<init>((java.lang.Boolean) r4, (int) r11, (java.lang.Boolean) r4, (java.lang.String) r4)
            r2.zzq(r14, r6)
            goto L_0x016f
        L_0x0145:
            com.google.android.gms.measurement.internal.zzgh r7 = r13.zzv()
            java.lang.String r7 = r7.zzk()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x016f
            if (r14 == 0) goto L_0x016f
            android.os.Bundle r14 = r14.zzd
            if (r14 == 0) goto L_0x016f
            boolean r1 = com.google.android.gms.measurement.internal.zzjk.zzu(r10, r1)
            if (r1 == 0) goto L_0x016f
            com.google.android.gms.measurement.internal.zzaz r14 = com.google.android.gms.measurement.internal.zzaz.zzh(r14, r10)
            boolean r1 = r14.zzd()
            if (r1 == 0) goto L_0x016f
            zzO(r2)
            r2.zzq(r14, r6)
        L_0x016f:
            java.lang.String r14 = "google_analytics_tcf_data_enabled"
            java.lang.Boolean r14 = r3.zzr(r14)
            if (r14 == 0) goto L_0x017d
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x0197
        L_0x017d:
            com.google.android.gms.measurement.internal.zzgt r14 = r13.zzh
            zzP(r14)
            com.google.android.gms.measurement.internal.zzgr r14 = r14.zzj()
            java.lang.String r1 = "TCF client enabled."
            r14.zza(r1)
            zzO(r2)
            r2.zzE()
            zzO(r2)
            r2.zzD()
        L_0x0197:
            zzN(r0)
            com.google.android.gms.measurement.internal.zzhd r14 = r0.zzc
            long r7 = r14.zza()
            r9 = 0
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 != 0) goto L_0x01c0
            com.google.android.gms.measurement.internal.zzgt r1 = r13.zzh
            zzP(r1)
            long r7 = r13.zza
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzk()
            java.lang.Long r3 = java.lang.Long.valueOf(r7)
            java.lang.String r9 = "Persisting first open"
            r1.zzb(r9, r3)
            zzN(r0)
            r14.zzb(r7)
        L_0x01c0:
            zzO(r2)
            com.google.android.gms.measurement.internal.zzx r1 = r2.zzb
            r1.zzc()
            boolean r1 = r13.zzH()
            if (r1 != 0) goto L_0x0254
            boolean r14 = r13.zzB()
            if (r14 == 0) goto L_0x03a9
            com.google.android.gms.measurement.internal.zzpo r14 = r13.zzk
            zzN(r14)
            java.lang.String r0 = "android.permission.INTERNET"
            boolean r0 = r14.zzY(r0)
            if (r0 != 0) goto L_0x01ef
            com.google.android.gms.measurement.internal.zzgt r0 = r13.zzh
            zzP(r0)
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzb()
            java.lang.String r1 = "App is missing INTERNET permission"
            r0.zza(r1)
        L_0x01ef:
            zzN(r14)
            java.lang.String r0 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r14 = r14.zzY(r0)
            if (r14 != 0) goto L_0x0208
            com.google.android.gms.measurement.internal.zzgt r14 = r13.zzh
            zzP(r14)
            com.google.android.gms.measurement.internal.zzgr r14 = r14.zzb()
            java.lang.String r0 = "App is missing ACCESS_NETWORK_STATE permission"
            r14.zza(r0)
        L_0x0208:
            android.content.Context r14 = r13.zzc
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r14)
            boolean r0 = r0.isCallerInstantApp()
            if (r0 != 0) goto L_0x0244
            com.google.android.gms.measurement.internal.zzal r0 = r13.zzf
            boolean r0 = r0.zzE()
            if (r0 != 0) goto L_0x0244
            boolean r0 = com.google.android.gms.measurement.internal.zzpo.zzau(r14)
            if (r0 != 0) goto L_0x0230
            com.google.android.gms.measurement.internal.zzgt r0 = r13.zzh
            zzP(r0)
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzb()
            java.lang.String r1 = "AppMeasurementReceiver not registered/enabled"
            r0.zza(r1)
        L_0x0230:
            boolean r14 = com.google.android.gms.measurement.internal.zzpo.zzQ(r14, r5)
            if (r14 != 0) goto L_0x0244
            com.google.android.gms.measurement.internal.zzgt r14 = r13.zzh
            zzP(r14)
            com.google.android.gms.measurement.internal.zzgr r14 = r14.zzb()
            java.lang.String r0 = "AppMeasurementService not registered/enabled"
            r14.zza(r0)
        L_0x0244:
            com.google.android.gms.measurement.internal.zzgt r14 = r13.zzh
            zzP(r14)
            com.google.android.gms.measurement.internal.zzgr r14 = r14.zzb()
            java.lang.String r0 = "Uploading is not possible. App measurement disabled"
            r14.zza(r0)
            goto L_0x03a9
        L_0x0254:
            com.google.android.gms.measurement.internal.zzgh r1 = r13.zzv()
            java.lang.String r1 = r1.zzk()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x02ed
            com.google.android.gms.measurement.internal.zzpo r1 = r13.zzk
            zzN(r1)
            com.google.android.gms.measurement.internal.zzgh r3 = r13.zzv()
            java.lang.String r3 = r3.zzk()
            zzN(r0)
            r0.zzg()
            android.content.SharedPreferences r5 = r0.zzd()
            java.lang.String r7 = "gmp_app_id"
            java.lang.String r5 = r5.getString(r7, r4)
            boolean r1 = r1.zzB(r3, r5)
            if (r1 == 0) goto L_0x02d1
            com.google.android.gms.measurement.internal.zzgt r1 = r13.zzh
            zzP(r1)
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzi()
            java.lang.String r3 = "Rechecking which service to use due to a GMP App Id change"
            r1.zza(r3)
            zzN(r0)
            r0.zzg()
            java.lang.Boolean r1 = r0.zzi()
            android.content.SharedPreferences r3 = r0.zzd()
            android.content.SharedPreferences$Editor r3 = r3.edit()
            r3.clear()
            r3.apply()
            if (r1 == 0) goto L_0x02b0
            r0.zzh(r1)
        L_0x02b0:
            com.google.android.gms.measurement.internal.zzgk r1 = r13.zzm()
            r1.zzh()
            com.google.android.gms.measurement.internal.zznk r1 = r13.zzt
            r1.zzM()
            com.google.android.gms.measurement.internal.zznk r1 = r13.zzt
            r1.zzI()
            zzN(r0)
            long r8 = r13.zza
            r14.zzb(r8)
            zzN(r0)
            com.google.android.gms.measurement.internal.zzhf r14 = r0.zze
            r14.zzb(r4)
        L_0x02d1:
            zzN(r0)
            com.google.android.gms.measurement.internal.zzgh r14 = r13.zzv()
            java.lang.String r14 = r14.zzk()
            r0.zzg()
            android.content.SharedPreferences r1 = r0.zzd()
            android.content.SharedPreferences$Editor r1 = r1.edit()
            r1.putString(r7, r14)
            r1.apply()
        L_0x02ed:
            zzN(r0)
            com.google.android.gms.measurement.internal.zzjk r14 = r0.zzl()
            com.google.android.gms.measurement.internal.zzjj r1 = com.google.android.gms.measurement.internal.zzjj.ANALYTICS_STORAGE
            boolean r14 = r14.zzo(r1)
            if (r14 != 0) goto L_0x0304
            zzN(r0)
            com.google.android.gms.measurement.internal.zzhf r14 = r0.zze
            r14.zzb(r4)
        L_0x0304:
            zzO(r2)
            zzN(r0)
            com.google.android.gms.measurement.internal.zzhf r14 = r0.zze
            java.lang.String r14 = r14.zza()
            r2.zzR(r14)
            com.google.android.gms.measurement.internal.zzpo r14 = r13.zzk
            zzN(r14)
            com.google.android.gms.measurement.internal.zzib r14 = r14.zzu     // Catch:{ ClassNotFoundException -> 0x0326 }
            android.content.Context r14 = r14.zzc     // Catch:{ ClassNotFoundException -> 0x0326 }
            java.lang.ClassLoader r14 = r14.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0326 }
            java.lang.String r0 = "com.google.firebase.remoteconfig.FirebaseRemoteConfig"
            r14.loadClass(r0)     // Catch:{ ClassNotFoundException -> 0x0326 }
            goto L_0x034c
        L_0x0326:
            com.google.android.gms.measurement.internal.zzhg r14 = r13.zzg
            zzN(r14)
            com.google.android.gms.measurement.internal.zzhf r0 = r14.zzq
            java.lang.String r1 = r0.zza()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x034c
            com.google.android.gms.measurement.internal.zzgt r1 = r13.zzh
            zzP(r1)
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zze()
            java.lang.String r2 = "Remote config removed with active feature rollouts"
            r1.zza(r2)
            zzN(r14)
            r0.zzb(r4)
        L_0x034c:
            com.google.android.gms.measurement.internal.zzgh r14 = r13.zzv()
            java.lang.String r14 = r14.zzk()
            boolean r14 = android.text.TextUtils.isEmpty(r14)
            if (r14 != 0) goto L_0x03a9
            boolean r14 = r13.zzB()
            com.google.android.gms.measurement.internal.zzhg r0 = r13.zzg
            zzN(r0)
            boolean r1 = r0.zzo()
            if (r1 != 0) goto L_0x0379
            com.google.android.gms.measurement.internal.zzal r1 = r13.zzf
            boolean r1 = r1.zzt()
            if (r1 != 0) goto L_0x0379
            zzN(r0)
            r1 = r14 ^ 1
            r0.zzn(r1)
        L_0x0379:
            if (r14 == 0) goto L_0x0383
            com.google.android.gms.measurement.internal.zzli r14 = r13.zzo
            zzO(r14)
            r14.zzU()
        L_0x0383:
            com.google.android.gms.measurement.internal.zzob r14 = r13.zzj
            zzO(r14)
            com.google.android.gms.measurement.internal.zzoa r14 = r14.zza
            r14.zza()
            com.google.android.gms.measurement.internal.zznk r14 = r13.zzt()
            java.util.concurrent.atomic.AtomicReference r1 = new java.util.concurrent.atomic.AtomicReference
            r1.<init>()
            r14.zzC(r1)
            com.google.android.gms.measurement.internal.zznk r14 = r13.zzt()
            zzN(r0)
            com.google.android.gms.measurement.internal.zzhc r0 = r0.zzt
            android.os.Bundle r0 = r0.zza()
            r14.zzH(r0)
        L_0x03a9:
            com.google.android.gms.internal.measurement.zzql.zza()
            com.google.android.gms.measurement.internal.zzal r14 = r13.zzf
            com.google.android.gms.measurement.internal.zzfw r0 = com.google.android.gms.measurement.internal.zzfx.zzaQ
            boolean r14 = r14.zzp(r4, r0)
            if (r14 == 0) goto L_0x040a
            com.google.android.gms.measurement.internal.zzpo r14 = r13.zzk
            zzN(r14)
            boolean r14 = r14.zzS()
            if (r14 == 0) goto L_0x040a
            com.google.android.gms.measurement.internal.zzfw r14 = com.google.android.gms.measurement.internal.zzfx.zzax
            java.lang.Object r14 = r14.zzb(r4)
            java.lang.Integer r14 = (java.lang.Integer) r14
            int r14 = r14.intValue()
            long r0 = (long) r14
            java.util.Random r14 = new java.util.Random
            r14.<init>()
            r2 = 5000(0x1388, float:7.006E-42)
            int r14 = r14.nextInt(r2)
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r2
            long r2 = (long) r14
            com.google.android.gms.common.util.Clock r14 = r13.zzm
            long r0 = r0 + r2
            long r2 = r14.elapsedRealtime()
            long r0 = r0 - r2
            r2 = 500(0x1f4, double:2.47E-321)
            long r0 = java.lang.Math.max(r2, r0)
            int r14 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r14 <= 0) goto L_0x0402
            com.google.android.gms.measurement.internal.zzgt r14 = r13.zzh
            zzP(r14)
            com.google.android.gms.measurement.internal.zzgr r14 = r14.zzk()
            java.lang.Long r2 = java.lang.Long.valueOf(r0)
            java.lang.String r3 = "Waiting to fetch trigger URIs until some time after boot. Delay in millis"
            r14.zzb(r3, r2)
        L_0x0402:
            com.google.android.gms.measurement.internal.zzli r14 = r13.zzo
            zzO(r14)
            r14.zzu(r0)
        L_0x040a:
            com.google.android.gms.measurement.internal.zzhg r14 = r13.zzg
            zzN(r14)
            com.google.android.gms.measurement.internal.zzhb r14 = r14.zzj
            r14.zzb(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzib.zza(com.google.android.gms.internal.measurement.zzdd):void");
    }

    @Pure
    public final zzae zzaU() {
        return this.zze;
    }

    @Pure
    public final zzgt zzaV() {
        zzgt zzgt = this.zzh;
        zzP(zzgt);
        return zzgt;
    }

    @Pure
    public final zzhy zzaW() {
        zzhy zzhy = this.zzi;
        zzP(zzhy);
        return zzhy;
    }

    @Pure
    public final Context zzaY() {
        return this.zzc;
    }

    @Pure
    public final Clock zzaZ() {
        return this.zzm;
    }

    @Pure
    public final zzal zzc() {
        return this.zzf;
    }

    @Pure
    public final zzhg zzd() {
        zzhg zzhg = this.zzg;
        zzN(zzhg);
        return zzhg;
    }

    public final zzgt zzf() {
        zzgt zzgt = this.zzh;
        if (zzgt == null || !zzgt.zzv()) {
            return null;
        }
        return zzgt;
    }

    @Pure
    public final zzob zzh() {
        zzob zzob = this.zzj;
        zzO(zzob);
        return zzob;
    }

    @SideEffectFree
    public final zzhy zzi() {
        return this.zzi;
    }

    @Pure
    public final zzli zzj() {
        zzli zzli = this.zzo;
        zzO(zzli);
        return zzli;
    }

    @Pure
    public final zzpo zzk() {
        zzpo zzpo = this.zzk;
        zzN(zzpo);
        return zzpo;
    }

    @Pure
    public final zzgm zzl() {
        return this.zzl;
    }

    @Pure
    public final zzgk zzm() {
        zzO(this.zzs);
        return this.zzs;
    }

    @Pure
    public final zzln zzn() {
        zzln zzln = this.zzq;
        zzP(zzln);
        return zzln;
    }

    @Pure
    public final boolean zzp() {
        return this.zzd;
    }

    @Pure
    public final String zzq() {
        return this.zzr;
    }

    @Pure
    public final zzma zzs() {
        zzma zzma = this.zzn;
        zzO(zzma);
        return zzma;
    }

    @Pure
    public final zznk zzt() {
        zzO(this.zzt);
        return this.zzt;
    }

    @Pure
    public final zzba zzu() {
        zzP(this.zzu);
        return this.zzu;
    }

    @Pure
    public final zzgh zzv() {
        zzO(this.zzv);
        return this.zzv;
    }

    @Pure
    public final zzd zzw() {
        zzd zzd2 = this.zzp;
        zzM(zzd2);
        return zzd2;
    }

    @Pure
    public final zzlp zzx() {
        zzM(this.zzw);
        return this.zzw;
    }

    @WorkerThread
    public final void zzz(boolean z) {
        this.zzA = Boolean.valueOf(z);
    }
}
