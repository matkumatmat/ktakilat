package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzko;
import com.google.android.gms.internal.measurement.zzkp;
import com.google.android.gms.internal.measurement.zzql;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import org.apache.commons.lang3.time.DateUtils;

public final class zzli extends zzg {
    @VisibleForTesting
    protected zzkx zza;
    final zzx zzb;
    @VisibleForTesting
    protected boolean zzc = true;
    private zzjo zzd;
    private final Set zze = new CopyOnWriteArraySet();
    private boolean zzf;
    private final AtomicReference zzg = new AtomicReference();
    private final Object zzh = new Object();
    private boolean zzi = false;
    private int zzj = 1;
    private zzay zzk;
    private zzay zzl;
    private PriorityQueue zzm;
    private boolean zzn;
    @GuardedBy("consentLock")
    private zzjk zzo = zzjk.zza;
    private final AtomicLong zzp = new AtomicLong(0);
    private long zzq = -1;
    private zzay zzr;
    private SharedPreferences.OnSharedPreferenceChangeListener zzs;
    private zzay zzt;
    private final zzpn zzv = new zzkm(this);

    public zzli(zzib zzib) {
        super(zzib);
        this.zzb = new zzx(zzib);
    }

    private final zzlq zzaq(zzol zzol) {
        try {
            URL url = new URI(zzol.zzc).toURL();
            AtomicReference atomicReference = new AtomicReference();
            String zzl2 = this.zzu.zzv().zzl();
            zzib zzib = this.zzu;
            zzgr zzk2 = zzib.zzaV().zzk();
            Long valueOf = Long.valueOf(zzol.zza);
            zzk2.zzd("[sgtm] Uploading data from app. row_id, url, uncompressed size", valueOf, zzol.zzc, Integer.valueOf(zzol.zzb.length));
            if (!TextUtils.isEmpty(zzol.zzg)) {
                zzib.zzaV().zzk().zzc("[sgtm] Uploading data from app. row_id", valueOf, zzol.zzg);
            }
            HashMap hashMap = new HashMap();
            Bundle bundle = zzol.zzd;
            for (String next : bundle.keySet()) {
                String string = bundle.getString(next);
                if (!TextUtils.isEmpty(string)) {
                    hashMap.put(next, string);
                }
            }
            zzln zzn2 = zzib.zzn();
            byte[] bArr = zzol.zzb;
            zzky zzky = new zzky(this, atomicReference, zzol);
            zzn2.zzw();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(bArr);
            Preconditions.checkNotNull(zzky);
            zzn2.zzu.zzaW().zzm(new zzlm(zzn2, zzl2, url, bArr, hashMap, zzky));
            try {
                zzib zzib2 = zzib.zzk().zzu;
                long currentTimeMillis = zzib2.zzaZ().currentTimeMillis();
                long j = DateUtils.MILLIS_PER_MINUTE;
                long j2 = currentTimeMillis + DateUtils.MILLIS_PER_MINUTE;
                synchronized (atomicReference) {
                    while (atomicReference.get() == null && j > 0) {
                        atomicReference.wait(j);
                        j = j2 - zzib2.zzaZ().currentTimeMillis();
                    }
                }
            } catch (InterruptedException unused) {
                e.C(this.zzu, "[sgtm] Interrupted waiting for uploading batch");
            } catch (Throwable th) {
                throw th;
            }
            if (atomicReference.get() == null) {
                return zzlq.UNKNOWN;
            }
            return (zzlq) atomicReference.get();
        } catch (MalformedURLException | URISyntaxException e) {
            this.zzu.zzaV().zzb().zzd("[sgtm] Bad upload url for row_id", zzol.zzc, Long.valueOf(zzol.zza), e);
            return zzlq.FAILURE;
        }
    }

    @WorkerThread
    private final void zzar(Boolean bool, boolean z) {
        zzg();
        zzb();
        zzib zzib = this.zzu;
        zzib.zzaV().zzj().zzb("Setting app measurement enabled (FE)", bool);
        zzib.zzd().zzh(bool);
        if (z) {
            zzhg zzd2 = zzib.zzd();
            zzib zzib2 = zzd2.zzu;
            zzd2.zzg();
            SharedPreferences.Editor edit = zzd2.zzd().edit();
            if (bool != null) {
                edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                edit.remove("measurement_enabled_from_api");
            }
            edit.apply();
        }
        if (this.zzu.zzE() || (bool != null && !bool.booleanValue())) {
            zzak();
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: zzas */
    public final void zzak() {
        long j;
        zzg();
        zzib zzib = this.zzu;
        String zza2 = zzib.zzd().zzh.zza();
        if (zza2 != null) {
            if ("unset".equals(zza2)) {
                zzN("app", "_npa", (Object) null, zzib.zzaZ().currentTimeMillis());
            } else {
                if (true != "true".equals(zza2)) {
                    j = 0;
                } else {
                    j = 1;
                }
                zzN("app", "_npa", Long.valueOf(j), zzib.zzaZ().currentTimeMillis());
            }
        }
        if (!this.zzu.zzB() || !this.zzc) {
            zzib.zzaV().zzj().zza("Updating Scion state (FE)");
            this.zzu.zzt().zzi();
            return;
        }
        zzib.zzaV().zzj().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzU();
        this.zzu.zzh().zza.zza();
        zzib.zzaW().zzj(new zzjy(this));
    }

    @WorkerThread
    public final void zzA(zzjk zzjk) {
        boolean z;
        Boolean bool;
        zzg();
        if ((!zzjk.zzo(zzjj.ANALYTICS_STORAGE) || !zzjk.zzo(zzjj.AD_STORAGE)) && !this.zzu.zzt().zzO()) {
            z = false;
        } else {
            z = true;
        }
        zzib zzib = this.zzu;
        if (z != zzib.zzE()) {
            zzib.zzD(z);
            zzhg zzd2 = this.zzu.zzd();
            zzib zzib2 = zzd2.zzu;
            zzd2.zzg();
            if (zzd2.zzd().contains("measurement_enabled_from_api")) {
                bool = Boolean.valueOf(zzd2.zzd().getBoolean("measurement_enabled_from_api", true));
            } else {
                bool = null;
            }
            if (!z || bool == null || bool.booleanValue()) {
                zzar(Boolean.valueOf(z), false);
            }
        }
    }

    public final void zzB(String str, String str2, Bundle bundle) {
        zzC(str, str2, bundle, true, true, this.zzu.zzaZ().currentTimeMillis());
    }

    public final void zzC(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        Bundle bundle2;
        boolean z3;
        String str3;
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = bundle;
        }
        String str4 = str2;
        if (Objects.equals(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
            this.zzu.zzs().zzj(bundle2, j);
            return;
        }
        long j2 = j;
        if (!z2 || this.zzd == null || zzpo.zzZ(str2)) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (str == null) {
            str3 = "app";
        } else {
            str3 = str;
        }
        zzJ(str3, str2, j, bundle2, z2, z3, z, (String) null);
    }

    @WorkerThread
    public final void zzD() {
        zzib zzib;
        zzfw zzfw;
        String str;
        zzoc zzoc;
        zzoc zzoc2;
        zzli zzli;
        int i;
        boolean z;
        boolean z2;
        zzkp zzkp;
        zzg();
        zzib zzib2 = this.zzu;
        zzib2.zzaV().zzj().zza("Handle tcf update.");
        SharedPreferences zze2 = zzib2.zzd().zze();
        HashMap hashMap = new HashMap();
        zzfw zzfw2 = zzfx.zzaZ;
        if (((Boolean) zzfw2.zzb((Object) null)).booleanValue()) {
            int i2 = zzoe.zzb;
            zzko zzko = zzko.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
            zzod zzod = zzod.CONSENT;
            Objects.requireNonNull(zzko);
            Objects.requireNonNull(zzod);
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(zzko, zzod);
            zzko zzko2 = zzko.IAB_TCF_PURPOSE_SELECT_BASIC_ADS;
            zzod zzod2 = zzod.FLEXIBLE_LEGITIMATE_INTEREST;
            Objects.requireNonNull(zzko2);
            Objects.requireNonNull(zzod2);
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry2 = new AbstractMap.SimpleImmutableEntry(zzko2, zzod2);
            zzko zzko3 = zzko.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE;
            Objects.requireNonNull(zzko3);
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry3 = new AbstractMap.SimpleImmutableEntry(zzko3, zzod);
            zzko zzko4 = zzko.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS;
            zzfw = zzfw2;
            Objects.requireNonNull(zzko4);
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry4 = new AbstractMap.SimpleImmutableEntry(zzko4, zzod);
            zzko zzko5 = zzko.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE;
            Objects.requireNonNull(zzko5);
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry5 = new AbstractMap.SimpleImmutableEntry(zzko5, zzod2);
            zzko zzko6 = zzko.IAB_TCF_PURPOSE_APPLY_MARKET_RESEARCH_TO_GENERATE_AUDIENCE_INSIGHTS;
            zzib = zzib2;
            Objects.requireNonNull(zzko6);
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry6 = new AbstractMap.SimpleImmutableEntry(zzko6, zzod2);
            zzko zzko7 = zzko.IAB_TCF_PURPOSE_DEVELOP_AND_IMPROVE_PRODUCTS;
            String str2 = "";
            Objects.requireNonNull(zzko7);
            ImmutableMap ofEntries = ImmutableMap.ofEntries(simpleImmutableEntry, simpleImmutableEntry2, simpleImmutableEntry3, simpleImmutableEntry4, simpleImmutableEntry5, simpleImmutableEntry6, new AbstractMap.SimpleImmutableEntry(zzko7, zzod2));
            ImmutableSet of = ImmutableSet.of("CH");
            char[] cArr = new char[5];
            boolean contains = zze2.contains("IABTCF_TCString");
            int zzb2 = zzoe.zzb(zze2, "IABTCF_CmpSdkID");
            int zzb3 = zzoe.zzb(zze2, "IABTCF_PolicyVersion");
            int zzb4 = zzoe.zzb(zze2, "IABTCF_gdprApplies");
            int zzb5 = zzoe.zzb(zze2, "IABTCF_PurposeOneTreatment");
            int zzb6 = zzoe.zzb(zze2, "IABTCF_EnableAdvertiserConsentMode");
            String zza2 = zzoe.zza(zze2, "IABTCF_PublisherCC");
            ImmutableMap.Builder builder = ImmutableMap.builder();
            UnmodifiableIterator it = ofEntries.keySet().iterator();
            while (it.hasNext()) {
                zzko zzko8 = (zzko) it.next();
                int zza3 = zzko8.zza();
                StringBuilder sb = new StringBuilder(String.valueOf(zza3).length() + 28);
                sb.append("IABTCF_PublisherRestrictions");
                sb.append(zza3);
                String zza4 = zzoe.zza(zze2, sb.toString());
                if (TextUtils.isEmpty(zza4) || zza4.length() < 755) {
                    zzkp = zzkp.PURPOSE_RESTRICTION_UNDEFINED;
                } else {
                    int digit = Character.digit(zza4.charAt(754), 10);
                    if (digit < 0 || digit > zzkp.values().length || digit == 0) {
                        zzkp = zzkp.PURPOSE_RESTRICTION_NOT_ALLOWED;
                    } else if (digit == 1) {
                        zzkp = zzkp.PURPOSE_RESTRICTION_REQUIRE_CONSENT;
                    } else if (digit != 2) {
                        zzkp = zzkp.PURPOSE_RESTRICTION_UNDEFINED;
                    } else {
                        zzkp = zzkp.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST;
                    }
                }
                builder.put(zzko8, zzkp);
            }
            ImmutableMap buildOrThrow = builder.buildOrThrow();
            String zza5 = zzoe.zza(zze2, "IABTCF_PurposeConsents");
            String zza6 = zzoe.zza(zze2, "IABTCF_VendorConsents");
            if (TextUtils.isEmpty(zza6) || zza6.length() < 755 || zza6.charAt(754) != '1') {
                z = false;
            } else {
                z = true;
            }
            String zza7 = zzoe.zza(zze2, "IABTCF_PurposeLegitimateInterests");
            String zza8 = zzoe.zza(zze2, "IABTCF_VendorLegitimateInterests");
            if (TextUtils.isEmpty(zza8) || zza8.length() < 755 || zza8.charAt(754) != '1') {
                z2 = false;
            } else {
                z2 = true;
            }
            cArr[0] = '2';
            zzoc = new zzoc(zzoe.zzd(ofEntries, buildOrThrow, of, cArr, zzb2, zzb6, zzb4, zzb3, zzb5, zza2, zza5, zza7, z, z2, contains));
            str = str2;
        } else {
            zzib = zzib2;
            zzfw = zzfw2;
            String zza9 = zzoe.zza(zze2, "IABTCF_VendorConsents");
            str = "";
            if (!str.equals(zza9) && zza9.length() > 754) {
                hashMap.put("GoogleConsent", String.valueOf(zza9.charAt(754)));
            }
            int zzb7 = zzoe.zzb(zze2, "IABTCF_gdprApplies");
            if (zzb7 != -1) {
                hashMap.put("gdprApplies", String.valueOf(zzb7));
            }
            int zzb8 = zzoe.zzb(zze2, "IABTCF_EnableAdvertiserConsentMode");
            if (zzb8 != -1) {
                hashMap.put("EnableAdvertiserConsentMode", String.valueOf(zzb8));
            }
            int zzb9 = zzoe.zzb(zze2, "IABTCF_PolicyVersion");
            if (zzb9 != -1) {
                hashMap.put("PolicyVersion", String.valueOf(zzb9));
            }
            String zza10 = zzoe.zza(zze2, "IABTCF_PurposeConsents");
            if (!str.equals(zza10)) {
                hashMap.put("PurposeConsents", zza10);
            }
            int zzb10 = zzoe.zzb(zze2, "IABTCF_CmpSdkID");
            if (zzb10 != -1) {
                hashMap.put("CmpSdkID", String.valueOf(zzb10));
            }
            zzoc = new zzoc(hashMap);
        }
        zzib.zzaV().zzk().zzb("Tcf preferences read", zzoc);
        if (zzib.zzc().zzp((String) null, zzfw)) {
            zzhg zzd2 = zzib.zzd();
            zzd2.zzg();
            String string = zzd2.zzd().getString("stored_tcf_param", str);
            HashMap hashMap2 = new HashMap();
            if (TextUtils.isEmpty(string)) {
                zzoc2 = new zzoc(hashMap2);
            } else {
                String[] split = string.split(";");
                int length = split.length;
                int i3 = 0;
                while (i3 < length) {
                    String[] split2 = split[i3].split("=");
                    if (split2.length < 2 || !zzoe.zza.contains(split2[0])) {
                        i = 1;
                    } else {
                        i = 1;
                        hashMap2.put(split2[0], split2[1]);
                    }
                    i3 += i;
                }
                zzoc2 = new zzoc(hashMap2);
            }
            if (zzib.zzd().zzm(zzoc)) {
                Bundle zzb11 = zzoc.zzb();
                zzib.zzaV().zzk().zzb("Consent generated from Tcf", zzb11);
                if (zzb11 != Bundle.EMPTY) {
                    zzli = this;
                    zzli.zzp(zzb11, -30, zzib.zzaZ().currentTimeMillis());
                } else {
                    zzli = this;
                }
                Bundle bundle = new Bundle();
                bundle.putString("_tcfm", zzoc.zzd(zzoc2));
                bundle.putString("_tcfd2", zzoc.zzc());
                bundle.putString("_tcfd", zzoc.zze());
                zzli.zzF("auto", "_tcf", bundle);
                return;
            }
            return;
        }
        if (zzib.zzd().zzm(zzoc)) {
            Bundle zzb12 = zzoc.zzb();
            zzib.zzaV().zzk().zzb("Consent generated from Tcf", zzb12);
            if (zzb12 != Bundle.EMPTY) {
                zzp(zzb12, -30, zzib.zzaZ().currentTimeMillis());
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_tcfd", zzoc.zze());
            zzF("auto", "_tcf", bundle2);
        }
    }

    @WorkerThread
    public final void zzE() {
        zzg();
        zzib zzib = this.zzu;
        zzib.zzaV().zzj().zza("Register tcfPrefChangeListener.");
        if (this.zzs == null) {
            this.zzt = new zzka(this, this.zzu);
            this.zzs = new zzld(this);
        }
        zzib.zzd().zze().registerOnSharedPreferenceChangeListener(this.zzs);
    }

    @WorkerThread
    public final void zzF(String str, String str2, Bundle bundle) {
        zzg();
        zzG(str, str2, this.zzu.zzaZ().currentTimeMillis(), bundle);
    }

    @WorkerThread
    public final void zzG(String str, String str2, long j, Bundle bundle) {
        boolean z;
        zzg();
        if (this.zzd == null || zzpo.zzZ(str2)) {
            z = true;
        } else {
            z = false;
        }
        zzH(str, str2, j, bundle, true, z, true, (String) null);
    }

    /* JADX WARNING: type inference failed for: r6v6, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r6v8, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x012c  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzH(java.lang.String r26, java.lang.String r27, long r28, android.os.Bundle r30, boolean r31, boolean r32, boolean r33, java.lang.String r34) {
        /*
            r25 = this;
            r7 = r25
            r8 = r26
            r9 = r27
            r10 = r28
            r12 = r30
            r13 = 0
            r14 = 1
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r26)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r30)
            r25.zzg()
            r25.zzb()
            com.google.android.gms.measurement.internal.zzib r0 = r7.zzu
            boolean r1 = r0.zzB()
            if (r1 == 0) goto L_0x04b5
            com.google.android.gms.measurement.internal.zzib r1 = r7.zzu
            com.google.android.gms.measurement.internal.zzgh r1 = r1.zzv()
            java.util.List r1 = r1.zzp()
            if (r1 == 0) goto L_0x0043
            boolean r1 = r1.contains(r9)
            if (r1 == 0) goto L_0x0033
            goto L_0x0043
        L_0x0033:
            com.google.android.gms.measurement.internal.zzib r0 = r7.zzu
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzj()
            java.lang.String r1 = "Dropping non-safelisted event. event name, origin"
            r0.zzc(r1, r9, r8)
            return
        L_0x0043:
            boolean r1 = r7.zzf
            r15 = 0
            if (r1 != 0) goto L_0x009f
            r7.zzf = r14
            boolean r0 = r0.zzp()     // Catch:{ ClassNotFoundException -> 0x0090 }
            java.lang.String r1 = "com.google.android.gms.tagmanager.TagManagerService"
            if (r0 != 0) goto L_0x0061
            com.google.android.gms.measurement.internal.zzib r0 = r7.zzu     // Catch:{ ClassNotFoundException -> 0x0090 }
            android.content.Context r0 = r0.zzaY()     // Catch:{ ClassNotFoundException -> 0x0090 }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0090 }
            java.lang.Class r0 = java.lang.Class.forName(r1, r14, r0)     // Catch:{ ClassNotFoundException -> 0x0090 }
            goto L_0x0065
        L_0x0061:
            java.lang.Class r0 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0090 }
        L_0x0065:
            java.lang.String r1 = "initialize"
            java.lang.Class[] r2 = new java.lang.Class[r14]     // Catch:{ Exception -> 0x007f }
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r2[r13] = r3     // Catch:{ Exception -> 0x007f }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ Exception -> 0x007f }
            com.google.android.gms.measurement.internal.zzib r1 = r7.zzu     // Catch:{ Exception -> 0x007f }
            android.content.Context r1 = r1.zzaY()     // Catch:{ Exception -> 0x007f }
            java.lang.Object[] r2 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x007f }
            r2[r13] = r1     // Catch:{ Exception -> 0x007f }
            r0.invoke(r15, r2)     // Catch:{ Exception -> 0x007f }
            goto L_0x009f
        L_0x007f:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzib r1 = r7.zzu     // Catch:{ ClassNotFoundException -> 0x0090 }
            com.google.android.gms.measurement.internal.zzgt r1 = r1.zzaV()     // Catch:{ ClassNotFoundException -> 0x0090 }
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zze()     // Catch:{ ClassNotFoundException -> 0x0090 }
            java.lang.String r2 = "Failed to invoke Tag Manager's initialize() method"
            r1.zzb(r2, r0)     // Catch:{ ClassNotFoundException -> 0x0090 }
            goto L_0x009f
        L_0x0090:
            com.google.android.gms.measurement.internal.zzib r0 = r7.zzu
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzi()
            java.lang.String r1 = "Tag Manager is not found and thus will not be used"
            r0.zza(r1)
        L_0x009f:
            com.google.android.gms.measurement.internal.zzib r0 = r7.zzu
            com.google.android.gms.measurement.internal.zzal r1 = r0.zzc()
            com.google.android.gms.measurement.internal.zzfw r2 = com.google.android.gms.measurement.internal.zzfx.zzbg
            boolean r1 = r1.zzp(r15, r2)
            if (r1 != 0) goto L_0x00d5
            java.lang.String r1 = "_cmp"
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x00d5
            java.lang.String r1 = "gclid"
            boolean r2 = r12.containsKey(r1)
            if (r2 == 0) goto L_0x00d5
            r0.zzaU()
            java.lang.String r4 = r12.getString(r1)
            com.google.android.gms.common.util.Clock r1 = r0.zzaZ()
            long r5 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_lgclid"
            r1 = r25
            r1.zzN(r2, r3, r4, r5)
        L_0x00d5:
            r0.zzaU()
            if (r31 == 0) goto L_0x00f1
            boolean r1 = com.google.android.gms.measurement.internal.zzpo.zzaf(r27)
            if (r1 == 0) goto L_0x00f1
            com.google.android.gms.measurement.internal.zzpo r1 = r0.zzk()
            com.google.android.gms.measurement.internal.zzhg r2 = r0.zzd()
            com.google.android.gms.measurement.internal.zzhc r2 = r2.zzt
            android.os.Bundle r2 = r2.zza()
            r1.zzI(r12, r2)
        L_0x00f1:
            r1 = 40
            if (r33 != 0) goto L_0x016d
            r0.zzaU()
            java.lang.String r2 = "_iap"
            boolean r2 = r2.equals(r9)
            if (r2 != 0) goto L_0x016d
            com.google.android.gms.measurement.internal.zzib r2 = r7.zzu
            com.google.android.gms.measurement.internal.zzpo r3 = r2.zzk()
            java.lang.String r4 = "event"
            boolean r5 = r3.zzj(r4, r9)
            if (r5 != 0) goto L_0x0110
        L_0x010e:
            r6 = 2
            goto L_0x012a
        L_0x0110:
            java.lang.String[] r5 = com.google.android.gms.measurement.internal.zzjl.zza
            java.lang.String[] r6 = com.google.android.gms.measurement.internal.zzjl.zzb
            boolean r5 = r3.zzl(r4, r5, r6, r9)
            if (r5 != 0) goto L_0x011d
            r6 = 13
            goto L_0x012a
        L_0x011d:
            com.google.android.gms.measurement.internal.zzib r5 = r3.zzu
            r5.zzc()
            boolean r3 = r3.zzm(r4, r1, r9)
            if (r3 != 0) goto L_0x0129
            goto L_0x010e
        L_0x0129:
            r6 = 0
        L_0x012a:
            if (r6 == 0) goto L_0x016d
            com.google.android.gms.measurement.internal.zzgt r3 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzd()
            com.google.android.gms.measurement.internal.zzgm r0 = r0.zzl()
            java.lang.String r0 = r0.zza(r9)
            java.lang.String r4 = "Invalid public event name. Event will not be logged (FE)"
            r3.zzb(r4, r0)
            com.google.android.gms.measurement.internal.zzpo r0 = r2.zzk()
            r2.zzc()
            java.lang.String r0 = r0.zzC(r9, r1, r14)
            if (r9 == 0) goto L_0x0152
            int r13 = r27.length()
        L_0x0152:
            com.google.android.gms.measurement.internal.zzpo r1 = r2.zzk()
            com.google.android.gms.measurement.internal.zzpn r2 = r7.zzv
            r3 = 0
            java.lang.String r4 = "_ev"
            r26 = r1
            r27 = r2
            r28 = r3
            r29 = r6
            r30 = r4
            r31 = r0
            r32 = r13
            r26.zzN(r27, r28, r29, r30, r31, r32)
            return
        L_0x016d:
            r0.zzaU()
            com.google.android.gms.measurement.internal.zzib r6 = r7.zzu
            com.google.android.gms.measurement.internal.zzma r2 = r6.zzs()
            com.google.android.gms.measurement.internal.zzlt r2 = r2.zzh(r13)
            java.lang.String r3 = "_sc"
            if (r2 == 0) goto L_0x0186
            boolean r4 = r12.containsKey(r3)
            if (r4 != 0) goto L_0x0186
            r2.zzd = r14
        L_0x0186:
            if (r31 == 0) goto L_0x018c
            if (r33 != 0) goto L_0x018c
            r4 = 1
            goto L_0x018d
        L_0x018c:
            r4 = 0
        L_0x018d:
            com.google.android.gms.measurement.internal.zzpo.zzav(r2, r12, r4)
            java.lang.String r2 = "am"
            boolean r2 = r2.equals(r8)
            boolean r4 = com.google.android.gms.measurement.internal.zzpo.zzZ(r27)
            if (r31 == 0) goto L_0x01d7
            com.google.android.gms.measurement.internal.zzjo r5 = r7.zzd
            if (r5 == 0) goto L_0x01d7
            if (r4 != 0) goto L_0x01d7
            if (r2 == 0) goto L_0x01a7
            r16 = 1
            goto L_0x01d9
        L_0x01a7:
            com.google.android.gms.measurement.internal.zzgt r1 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzj()
            com.google.android.gms.measurement.internal.zzgm r2 = r0.zzl()
            java.lang.String r2 = r2.zza(r9)
            com.google.android.gms.measurement.internal.zzgm r0 = r0.zzl()
            java.lang.String r0 = r0.zze(r12)
            java.lang.String r3 = "Passing event to registered event handler (FE)"
            r1.zzc(r3, r2, r0)
            com.google.android.gms.measurement.internal.zzjo r0 = r7.zzd
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            com.google.android.gms.measurement.internal.zzjo r1 = r7.zzd
            r2 = r26
            r3 = r27
            r4 = r30
            r5 = r28
            r1.interceptEvent(r2, r3, r4, r5)
            return
        L_0x01d7:
            r16 = r2
        L_0x01d9:
            com.google.android.gms.measurement.internal.zzib r5 = r7.zzu
            boolean r2 = r5.zzH()
            if (r2 != 0) goto L_0x01e3
            goto L_0x04b4
        L_0x01e3:
            com.google.android.gms.measurement.internal.zzpo r2 = r0.zzk()
            int r2 = r2.zzn(r9)
            if (r2 == 0) goto L_0x022d
            com.google.android.gms.measurement.internal.zzgt r3 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzd()
            com.google.android.gms.measurement.internal.zzgm r4 = r0.zzl()
            java.lang.String r4 = r4.zza(r9)
            java.lang.String r6 = "Invalid event name. Event will not be logged (FE)"
            r3.zzb(r6, r4)
            com.google.android.gms.measurement.internal.zzpo r3 = r0.zzk()
            r0.zzc()
            java.lang.String r0 = r3.zzC(r9, r1, r14)
            if (r9 == 0) goto L_0x0213
            int r13 = r27.length()
        L_0x0213:
            com.google.android.gms.measurement.internal.zzpo r1 = r5.zzk()
            com.google.android.gms.measurement.internal.zzpn r3 = r7.zzv
            java.lang.String r4 = "_ev"
            r26 = r1
            r27 = r3
            r28 = r34
            r29 = r2
            r30 = r4
            r31 = r0
            r32 = r13
            r26.zzN(r27, r28, r29, r30, r31, r32)
            return
        L_0x022d:
            java.lang.String r1 = "_sn"
            java.lang.String r2 = "_si"
            java.lang.String r4 = "_o"
            java.lang.String[] r1 = new java.lang.String[]{r4, r1, r3, r2}
            java.util.List r17 = com.google.android.gms.common.util.CollectionUtils.listOf((T[]) r1)
            com.google.android.gms.measurement.internal.zzpo r1 = r0.zzk()
            r2 = r34
            r3 = r27
            r18 = r4
            r4 = r30
            r12 = r5
            r5 = r17
            r17 = r6
            r6 = r33
            android.os.Bundle r5 = r1.zzF(r2, r3, r4, r5, r6)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            r0.zzaU()
            com.google.android.gms.measurement.internal.zzma r1 = r17.zzs()
            com.google.android.gms.measurement.internal.zzlt r1 = r1.zzh(r13)
            java.lang.String r6 = "_ae"
            if (r1 == 0) goto L_0x028f
            boolean r1 = r6.equals(r9)
            if (r1 == 0) goto L_0x028f
            com.google.android.gms.measurement.internal.zzob r1 = r17.zzh()
            com.google.android.gms.measurement.internal.zznz r1 = r1.zzb
            com.google.android.gms.measurement.internal.zzob r2 = r1.zzc
            com.google.android.gms.measurement.internal.zzib r2 = r2.zzu
            com.google.android.gms.common.util.Clock r2 = r2.zzaZ()
            long r13 = r2.elapsedRealtime()
            long r3 = r1.zzb
            long r2 = r13 - r3
            r1.zzb = r13
            r13 = 0
            int r1 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r1 <= 0) goto L_0x028f
            com.google.android.gms.measurement.internal.zzpo r1 = r0.zzk()
            r1.zzak(r5, r2)
        L_0x028f:
            java.lang.String r1 = "auto"
            boolean r1 = r1.equals(r8)
            java.lang.String r2 = "_ffr"
            if (r1 != 0) goto L_0x02e1
            java.lang.String r1 = "_ssr"
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x02e1
            com.google.android.gms.measurement.internal.zzpo r1 = r0.zzk()
            java.lang.String r2 = r5.getString(r2)
            boolean r3 = com.google.android.gms.common.util.Strings.isEmptyOrWhitespace(r2)
            if (r3 == 0) goto L_0x02b1
            r2 = r15
            goto L_0x02b7
        L_0x02b1:
            if (r2 == 0) goto L_0x02b7
            java.lang.String r2 = r2.trim()
        L_0x02b7:
            com.google.android.gms.measurement.internal.zzib r1 = r1.zzu
            com.google.android.gms.measurement.internal.zzhg r3 = r1.zzd()
            com.google.android.gms.measurement.internal.zzhf r3 = r3.zzq
            java.lang.String r3 = r3.zza()
            boolean r3 = java.util.Objects.equals(r2, r3)
            if (r3 != 0) goto L_0x02d3
            com.google.android.gms.measurement.internal.zzhg r1 = r1.zzd()
            com.google.android.gms.measurement.internal.zzhf r1 = r1.zzq
            r1.zzb(r2)
            goto L_0x0300
        L_0x02d3:
            com.google.android.gms.measurement.internal.zzgt r0 = r1.zzaV()
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzj()
            java.lang.String r1 = "Not logging duplicate session_start_with_rollout event"
            r0.zza(r1)
            return
        L_0x02e1:
            boolean r1 = r6.equals(r9)
            if (r1 == 0) goto L_0x0300
            com.google.android.gms.measurement.internal.zzpo r1 = r0.zzk()
            com.google.android.gms.measurement.internal.zzib r1 = r1.zzu
            com.google.android.gms.measurement.internal.zzhg r1 = r1.zzd()
            com.google.android.gms.measurement.internal.zzhf r1 = r1.zzq
            java.lang.String r1 = r1.zza()
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x0300
            r5.putString(r2, r1)
        L_0x0300:
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            r13.add(r5)
            com.google.android.gms.measurement.internal.zzal r1 = r0.zzc()
            com.google.android.gms.measurement.internal.zzfw r2 = com.google.android.gms.measurement.internal.zzfx.zzaU
            boolean r1 = r1.zzp(r15, r2)
            if (r1 == 0) goto L_0x031d
            com.google.android.gms.measurement.internal.zzob r1 = r17.zzh()
            boolean r1 = r1.zzi()
            goto L_0x0327
        L_0x031d:
            com.google.android.gms.measurement.internal.zzhg r1 = r0.zzd()
            com.google.android.gms.measurement.internal.zzhb r1 = r1.zzn
            boolean r1 = r1.zza()
        L_0x0327:
            com.google.android.gms.measurement.internal.zzhg r2 = r0.zzd()
            com.google.android.gms.measurement.internal.zzhd r2 = r2.zzk
            long r2 = r2.zza()
            r19 = 0
            int r4 = (r2 > r19 ? 1 : (r2 == r19 ? 0 : -1))
            if (r4 <= 0) goto L_0x0396
            com.google.android.gms.measurement.internal.zzhg r2 = r0.zzd()
            boolean r2 = r2.zzp(r10)
            if (r2 == 0) goto L_0x0396
            if (r1 == 0) goto L_0x0396
            com.google.android.gms.measurement.internal.zzgt r1 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzk()
            java.lang.String r2 = "Current session is expired, remove the session number, ID, and engagement time"
            r1.zza(r2)
            com.google.android.gms.common.util.Clock r1 = r0.zzaZ()
            long r21 = r1.currentTimeMillis()
            java.lang.String r3 = "_sid"
            r4 = 0
            java.lang.String r2 = "auto"
            r1 = r25
            r14 = r19
            r23 = r5
            r24 = r6
            r5 = r21
            r1.zzN(r2, r3, r4, r5)
            com.google.android.gms.common.util.Clock r1 = r0.zzaZ()
            long r5 = r1.currentTimeMillis()
            java.lang.String r3 = "_sno"
            java.lang.String r2 = "auto"
            r1 = r25
            r1.zzN(r2, r3, r4, r5)
            com.google.android.gms.common.util.Clock r1 = r0.zzaZ()
            long r5 = r1.currentTimeMillis()
            java.lang.String r3 = "_se"
            java.lang.String r2 = "auto"
            r1 = r25
            r1.zzN(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzhg r1 = r0.zzd()
            com.google.android.gms.measurement.internal.zzhd r1 = r1.zzl
            r1.zzb(r14)
            goto L_0x039c
        L_0x0396:
            r23 = r5
            r24 = r6
            r14 = r19
        L_0x039c:
            java.lang.String r1 = "extend_session"
            r2 = r23
            long r3 = r2.getLong(r1, r14)
            r5 = 1
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x03c1
            com.google.android.gms.measurement.internal.zzgt r1 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzk()
            java.lang.String r3 = "EXTEND_SESSION param attached: initiate a new session or extend the current active session"
            r1.zza(r3)
            com.google.android.gms.measurement.internal.zzob r1 = r12.zzh()
            com.google.android.gms.measurement.internal.zzoa r1 = r1.zza
            r3 = 1
            r1.zzb(r10, r3)
        L_0x03c1:
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.Set r3 = r2.keySet()
            r1.<init>(r3)
            java.util.Collections.sort(r1)
            int r3 = r1.size()
            r4 = 0
        L_0x03d2:
            if (r4 >= r3) goto L_0x041e
            java.lang.Object r5 = r1.get(r4)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x041b
            r0.zzk()
            java.lang.Object r6 = r2.get(r5)
            boolean r12 = r6 instanceof android.os.Bundle
            if (r12 == 0) goto L_0x03f0
            r12 = 1
            android.os.Bundle[] r14 = new android.os.Bundle[r12]
            android.os.Bundle r6 = (android.os.Bundle) r6
            r12 = 0
            r14[r12] = r6
            goto L_0x0416
        L_0x03f0:
            boolean r12 = r6 instanceof android.os.Parcelable[]
            if (r12 == 0) goto L_0x0401
            android.os.Parcelable[] r6 = (android.os.Parcelable[]) r6
            int r12 = r6.length
            java.lang.Class<android.os.Bundle[]> r14 = android.os.Bundle[].class
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r12, r14)
            r14 = r6
            android.os.Bundle[] r14 = (android.os.Bundle[]) r14
            goto L_0x0416
        L_0x0401:
            boolean r12 = r6 instanceof java.util.ArrayList
            if (r12 == 0) goto L_0x0415
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            int r12 = r6.size()
            android.os.Bundle[] r12 = new android.os.Bundle[r12]
            java.lang.Object[] r6 = r6.toArray(r12)
            r14 = r6
            android.os.Bundle[] r14 = (android.os.Bundle[]) r14
            goto L_0x0416
        L_0x0415:
            r14 = 0
        L_0x0416:
            if (r14 == 0) goto L_0x041b
            r2.putParcelableArray(r5, r14)
        L_0x041b:
            r5 = 1
            int r4 = r4 + r5
            goto L_0x03d2
        L_0x041e:
            r12 = 0
        L_0x041f:
            int r1 = r13.size()
            if (r12 >= r1) goto L_0x048c
            java.lang.Object r1 = r13.get(r12)
            android.os.Bundle r1 = (android.os.Bundle) r1
            if (r12 == 0) goto L_0x0432
            java.lang.String r2 = "_ep"
        L_0x042f:
            r14 = r18
            goto L_0x0434
        L_0x0432:
            r2 = r9
            goto L_0x042f
        L_0x0434:
            r1.putString(r14, r8)
            if (r32 == 0) goto L_0x0444
            com.google.android.gms.measurement.internal.zzpo r3 = r0.zzk()
            r15 = 0
            android.os.Bundle r1 = r3.zzab(r1, r15)
        L_0x0442:
            r5 = r1
            goto L_0x0446
        L_0x0444:
            r15 = 0
            goto L_0x0442
        L_0x0446:
            com.google.android.gms.measurement.internal.zzbg r6 = new com.google.android.gms.measurement.internal.zzbg
            com.google.android.gms.measurement.internal.zzbe r3 = new com.google.android.gms.measurement.internal.zzbe
            r3.<init>(r5)
            r1 = r6
            r4 = r26
            r15 = r5
            r8 = r6
            r5 = r28
            r1.<init>(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zznk r1 = r17.zzt()
            r5 = r34
            r1.zzn(r8, r5)
            if (r16 != 0) goto L_0x0485
            java.util.Set r1 = r7.zze
            java.util.Iterator r8 = r1.iterator()
        L_0x0468:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0485
            java.lang.Object r1 = r8.next()
            com.google.android.gms.measurement.internal.zzjp r1 = (com.google.android.gms.measurement.internal.zzjp) r1
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>(r15)
            r2 = r26
            r3 = r27
            r5 = r28
            r1.onEvent(r2, r3, r4, r5)
            r5 = r34
            goto L_0x0468
        L_0x0485:
            r1 = 1
            int r12 = r12 + r1
            r8 = r26
            r18 = r14
            goto L_0x041f
        L_0x048c:
            r0.zzaU()
            com.google.android.gms.measurement.internal.zzma r1 = r17.zzs()
            r2 = 0
            com.google.android.gms.measurement.internal.zzlt r1 = r1.zzh(r2)
            if (r1 == 0) goto L_0x04b4
            r1 = r24
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x04b4
            com.google.android.gms.measurement.internal.zzob r1 = r17.zzh()
            com.google.android.gms.common.util.Clock r0 = r0.zzaZ()
            long r2 = r0.elapsedRealtime()
            com.google.android.gms.measurement.internal.zznz r0 = r1.zzb
            r1 = 1
            r0.zzd(r1, r1, r2)
        L_0x04b4:
            return
        L_0x04b5:
            com.google.android.gms.measurement.internal.zzib r0 = r7.zzu
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzj()
            java.lang.String r1 = "Event not sent since app measurement is disabled"
            r0.zza(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzli.zzH(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void zzI(String str, String str2, Bundle bundle, String str3) {
        zzib.zzL();
        zzJ("auto", str2, this.zzu.zzaZ().currentTimeMillis(), bundle, false, true, true, str3);
    }

    public final void zzJ(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2 = new Bundle(bundle);
        for (String next : bundle2.keySet()) {
            Object obj = bundle2.get(next);
            if (obj instanceof Bundle) {
                bundle2.putBundle(next, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelable);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        this.zzu.zzaW().zzj(new zzkb(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    public final void zzK(String str, String str2, Object obj, boolean z) {
        zzL("auto", "_ldl", obj, true, this.zzu.zzaZ().currentTimeMillis());
    }

    public final void zzL(String str, String str2, Object obj, boolean z, long j) {
        int i;
        String str3;
        int i2;
        int i3;
        String str4 = str2;
        Object obj2 = obj;
        if (z) {
            i = this.zzu.zzk().zzp(str4);
        } else {
            zzpo zzk2 = this.zzu.zzk();
            if (zzk2.zzj("user property", str4)) {
                if (!zzk2.zzl("user property", zzjn.zza, (String[]) null, str4)) {
                    i = 15;
                } else {
                    zzk2.zzu.zzc();
                    if (zzk2.zzm("user property", 24, str4)) {
                        i = 0;
                    }
                }
            }
            i = 6;
        }
        if (i != 0) {
            zzib zzib = this.zzu;
            zzpo zzk3 = zzib.zzk();
            zzib.zzc();
            String zzC = zzk3.zzC(str4, 24, true);
            if (str4 != null) {
                i3 = str2.length();
            } else {
                i3 = 0;
            }
            zzib zzib2 = this.zzu;
            zzib2.zzk().zzN(this.zzv, (String) null, i, "_ev", zzC, i3);
            return;
        }
        if (str == null) {
            str3 = "app";
        } else {
            str3 = str;
        }
        if (obj2 != null) {
            zzib zzib3 = this.zzu;
            int zzK = zzib3.zzk().zzK(str4, obj2);
            if (zzK != 0) {
                zzpo zzk4 = zzib3.zzk();
                zzib3.zzc();
                String zzC2 = zzk4.zzC(str4, 24, true);
                if ((obj2 instanceof String) || (obj2 instanceof CharSequence)) {
                    i2 = obj.toString().length();
                } else {
                    i2 = 0;
                }
                zzib zzib4 = this.zzu;
                zzib4.zzk().zzN(this.zzv, (String) null, zzK, "_ev", zzC2, i2);
                return;
            }
            Object zzL = zzib3.zzk().zzL(str4, obj2);
            if (zzL != null) {
                zzM(str3, str2, j, zzL);
                return;
            }
            return;
        }
        zzM(str3, str2, j, (Object) null);
    }

    public final void zzM(String str, String str2, long j, Object obj) {
        this.zzu.zzaW().zzj(new zzkc(this, str, str2, obj, j));
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzN(java.lang.String r10, java.lang.String r11, java.lang.Object r12, long r13) {
        /*
            r9 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)
            r9.zzg()
            r9.zzb()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x0074
            boolean r0 = r12 instanceof java.lang.String
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x0053
            r0 = r12
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0053
            java.util.Locale r11 = java.util.Locale.ENGLISH
            java.lang.String r11 = r0.toLowerCase(r11)
            r12 = 1
            java.lang.String r0 = "false"
            boolean r11 = r0.equals(r11)
            r2 = 1
            if (r12 == r11) goto L_0x0037
            r11 = 0
            goto L_0x0038
        L_0x0037:
            r11 = r2
        L_0x0038:
            com.google.android.gms.measurement.internal.zzib r4 = r9.zzu
            java.lang.Long r12 = java.lang.Long.valueOf(r11)
            com.google.android.gms.measurement.internal.zzhg r11 = r4.zzd()
            com.google.android.gms.measurement.internal.zzhf r11 = r11.zzh
            long r4 = r12.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x004e
            java.lang.String r0 = "true"
        L_0x004e:
            r11.zzb(r0)
        L_0x0051:
            r11 = r1
            goto L_0x0063
        L_0x0053:
            if (r12 != 0) goto L_0x0063
            com.google.android.gms.measurement.internal.zzib r11 = r9.zzu
            com.google.android.gms.measurement.internal.zzhg r11 = r11.zzd()
            com.google.android.gms.measurement.internal.zzhf r11 = r11.zzh
            java.lang.String r0 = "unset"
            r11.zzb(r0)
            goto L_0x0051
        L_0x0063:
            com.google.android.gms.measurement.internal.zzib r0 = r9.zzu
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzk()
            java.lang.String r1 = "Setting user property(FE)"
            java.lang.String r2 = "non_personalized_ads(_npa)"
            r0.zzc(r1, r2, r12)
        L_0x0074:
            r4 = r11
            r7 = r12
            com.google.android.gms.measurement.internal.zzib r11 = r9.zzu
            boolean r12 = r11.zzB()
            if (r12 != 0) goto L_0x008e
            com.google.android.gms.measurement.internal.zzib r10 = r9.zzu
            com.google.android.gms.measurement.internal.zzgt r10 = r10.zzaV()
            com.google.android.gms.measurement.internal.zzgr r10 = r10.zzk()
            java.lang.String r11 = "User property not set since app measurement is disabled"
            r10.zza(r11)
            return
        L_0x008e:
            boolean r11 = r11.zzH()
            if (r11 != 0) goto L_0x0095
            return
        L_0x0095:
            com.google.android.gms.measurement.internal.zzib r11 = r9.zzu
            com.google.android.gms.measurement.internal.zzpk r12 = new com.google.android.gms.measurement.internal.zzpk
            r3 = r12
            r5 = r13
            r8 = r10
            r3.<init>(r4, r5, r7, r8)
            com.google.android.gms.measurement.internal.zznk r10 = r11.zzt()
            r10.zzA(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzli.zzN(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final List zzO(boolean z) {
        zzb();
        zzib zzib = this.zzu;
        zzib.zzaV().zzk().zza("Getting user properties (FE)");
        if (!zzib.zzaW().zze()) {
            zzib.zzaU();
            if (zzae.zza()) {
                zzib.zzaV().zzb().zza("Cannot get all user properties from main thread");
                return Collections.emptyList();
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzaW().zzk(atomicReference, 5000, "get user properties", new zzke(this, atomicReference, z));
            List list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            zzib.zzaV().zzb().zzb("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyList();
        }
        zzib.zzaV().zzb().zza("Cannot get all user properties from analytics worker thread");
        return Collections.emptyList();
    }

    public final Map zzP(String str, String str2, boolean z) {
        zzib zzib = this.zzu;
        if (zzib.zzaW().zze()) {
            zzib.zzaV().zzb().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        zzib.zzaU();
        if (zzae.zza()) {
            zzib.zzaV().zzb().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzaW().zzk(atomicReference, 5000, "get user properties", new zzkk(this, atomicReference, (String) null, str, str2, z));
        List<zzpk> list = (List) atomicReference.get();
        if (list == null) {
            zzib.zzaV().zzb().zzb("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzpk zzpk : list) {
            Object zza2 = zzpk.zza();
            if (zza2 != null) {
                arrayMap.put(zzpk.zzb, zza2);
            }
        }
        return arrayMap;
    }

    public final String zzQ() {
        return (String) this.zzg.get();
    }

    public final void zzR(String str) {
        this.zzg.set(str);
    }

    @WorkerThread
    public final void zzS() {
        zzg();
        zzib zzib = this.zzu;
        if (!zzib.zzd().zzo.zza()) {
            long zza2 = zzib.zzd().zzp.zza();
            zzib.zzd().zzp.zzb(1 + zza2);
            zzib.zzc();
            if (zza2 >= 5) {
                zzib.zzaV().zze().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                zzib.zzd().zzo.zzb(true);
                return;
            }
            if (this.zzr == null) {
                this.zzr = new zzkf(this, this.zzu);
            }
            this.zzr.zzb(0);
            return;
        }
        zzib.zzaV().zzj().zza("Deferred Deep Link already retrieved. Not fetching again.");
    }

    public final void zzT(long j) {
        this.zzg.set((Object) null);
        this.zzu.zzaW().zzj(new zzkg(this, j));
    }

    @WorkerThread
    public final void zzU() {
        zzg();
        zzb();
        if (this.zzu.zzH()) {
            zzib zzib = this.zzu;
            zzal zzc2 = zzib.zzc();
            zzc2.zzu.zzaU();
            Boolean zzr2 = zzc2.zzr("google_analytics_deferred_deep_link_enabled");
            if (zzr2 != null && zzr2.booleanValue()) {
                zzib.zzaV().zzj().zza("Deferred Deep Link feature enabled.");
                zzib.zzaW().zzj(new zzlg(this));
            }
            this.zzu.zzt().zzE();
            this.zzc = false;
            zzhg zzd2 = zzib.zzd();
            zzd2.zzg();
            String string = zzd2.zzd().getString("previous_os_version", (String) null);
            zzd2.zzu.zzu().zzw();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor edit = zzd2.zzd().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (!TextUtils.isEmpty(string)) {
                zzib.zzu().zzw();
                if (!string.equals(str)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", string);
                    zzF("auto", "_ou", bundle);
                }
            }
        }
    }

    @WorkerThread
    public final void zzV(zzjo zzjo) {
        zzjo zzjo2;
        boolean z;
        zzg();
        zzb();
        if (!(zzjo == null || zzjo == (zzjo2 = this.zzd))) {
            if (zzjo2 == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "EventInterceptor already set.");
        }
        this.zzd = zzjo;
    }

    public final void zzW(zzjp zzjp) {
        zzb();
        Preconditions.checkNotNull(zzjp);
        if (!this.zze.add(zzjp)) {
            e.C(this.zzu, "OnEventListener already registered");
        }
    }

    public final void zzX(zzjp zzjp) {
        zzb();
        Preconditions.checkNotNull(zzjp);
        if (!this.zze.remove(zzjp)) {
            e.C(this.zzu, "OnEventListener had not been registered");
        }
    }

    public final int zzY(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzu.zzc();
        return 25;
    }

    public final void zzZ(Bundle bundle) {
        zzaa(bundle, this.zzu.zzaZ().currentTimeMillis());
    }

    public final void zzaa(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            e.C(this.zzu, "Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        Class<String> cls = String.class;
        zzjg.zzb(bundle2, "app_id", cls, (Object) null);
        zzjg.zzb(bundle2, "origin", cls, (Object) null);
        zzjg.zzb(bundle2, "name", cls, (Object) null);
        zzjg.zzb(bundle2, "value", Object.class, (Object) null);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, cls, (Object) null);
        Class<Long> cls2 = Long.class;
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, cls2, 0L);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, cls, (Object) null);
        Class<Bundle> cls3 = Bundle.class;
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, cls3, (Object) null);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, cls, (Object) null);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, cls3, (Object) null);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, cls2, 0L);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, cls, (Object) null);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, cls3, (Object) null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        zzib zzib = this.zzu;
        if (zzib.zzk().zzp(string) != 0) {
            zzib.zzaV().zzb().zzb("Invalid conditional user property name", zzib.zzl().zzc(string));
        } else if (zzib.zzk().zzK(string, obj) == 0) {
            Object zzL = zzib.zzk().zzL(string, obj);
            if (zzL == null) {
                zzib.zzaV().zzb().zzc("Unable to normalize conditional user property value", zzib.zzl().zzc(string), obj);
                return;
            }
            zzjg.zza(bundle2, zzL);
            long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME))) {
                zzib.zzc();
                if (j2 > 15552000000L || j2 < 1) {
                    zzib.zzaV().zzb().zzc("Invalid conditional user property timeout", zzib.zzl().zzc(string), Long.valueOf(j2));
                    return;
                }
            }
            long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
            zzib.zzc();
            if (j3 > 15552000000L || j3 < 1) {
                zzib.zzaV().zzb().zzc("Invalid conditional user property time to live", zzib.zzl().zzc(string), Long.valueOf(j3));
            } else {
                zzib.zzaW().zzj(new zzkh(this, bundle2));
            }
        } else {
            zzib.zzaV().zzb().zzc("Invalid conditional user property value", zzib.zzl().zzc(string), obj);
        }
    }

    public final void zzab(String str, String str2, Bundle bundle) {
        zzib zzib = this.zzu;
        long currentTimeMillis = zzib.zzaZ().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzib.zzaW().zzj(new zzki(this, bundle2));
    }

    public final ArrayList zzac(String str, String str2) {
        zzib zzib = this.zzu;
        if (zzib.zzaW().zze()) {
            zzib.zzaV().zzb().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        zzib.zzaU();
        if (zzae.zza()) {
            zzib.zzaV().zzb().zza("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzaW().zzk(atomicReference, 5000, "get conditional user properties", new zzkj(this, atomicReference, (String) null, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return zzpo.zzas(list);
        }
        zzib.zzaV().zzb().zzb("Timed out waiting for get conditional user properties", (Object) null);
        return new ArrayList();
    }

    public final String zzad() {
        zzlt zzl2 = this.zzu.zzs().zzl();
        if (zzl2 != null) {
            return zzl2.zza;
        }
        return null;
    }

    public final String zzae() {
        zzlt zzl2 = this.zzu.zzs().zzl();
        if (zzl2 != null) {
            return zzl2.zzb;
        }
        return null;
    }

    public final /* synthetic */ void zzaf(SharedPreferences sharedPreferences, String str) {
        zzib zzib = this.zzu;
        if (!zzib.zzc().zzp((String) null, zzfx.zzaZ)) {
            if (Objects.equals(str, "IABTCF_TCString")) {
                zzib.zzaV().zzk().zza("IABTCF_TCString change picked up in listener.");
                ((zzay) Preconditions.checkNotNull(this.zzt)).zzb(500);
            }
        } else if (Objects.equals(str, "IABTCF_TCString") || Objects.equals(str, "IABTCF_gdprApplies") || Objects.equals(str, "IABTCF_EnableAdvertiserConsentMode")) {
            zzib.zzaV().zzk().zza("IABTCF_TCString change picked up in listener.");
            ((zzay) Preconditions.checkNotNull(this.zzt)).zzb(500);
        }
    }

    public final /* synthetic */ void zzag(Bundle bundle) {
        Bundle bundle2;
        int i;
        if (bundle.isEmpty()) {
            bundle2 = bundle;
        } else {
            zzib zzib = this.zzu;
            bundle2 = new Bundle(zzib.zzd().zzt.zza());
            Iterator<String> it = bundle.keySet().iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                Object obj = bundle.get(next);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    if (zzib.zzk().zzt(obj)) {
                        zzib.zzk().zzN(this.zzv, (String) null, 27, (String) null, (String) null, 0);
                    }
                    zzib.zzaV().zzh().zzc("Invalid default event parameter type. Name, value", next, obj);
                } else if (zzpo.zzZ(next)) {
                    zzib.zzaV().zzh().zzb("Invalid default event parameter name. Name", next);
                } else if (obj == null) {
                    bundle2.remove(next);
                } else if (zzib.zzk().zzu("param", next, zzib.zzc().zze((String) null, false), obj)) {
                    zzib.zzk().zzM(bundle2, next, obj);
                }
            }
            zzib.zzk();
            int zzc2 = zzib.zzc().zzc();
            if (bundle2.size() > zzc2) {
                Iterator it2 = new TreeSet(bundle2.keySet()).iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    i++;
                    if (i > zzc2) {
                        bundle2.remove(str);
                    }
                }
                zzib.zzk().zzN(this.zzv, (String) null, 26, (String) null, (String) null, 0);
                zzib.zzaV().zzh().zza("Too many default event parameters set. Discarding beyond event parameter limit");
            }
        }
        zzib zzib2 = this.zzu;
        zzib2.zzd().zzt.zzb(bundle2);
        if (!bundle.isEmpty() || zzib2.zzc().zzp((String) null, zzfx.zzaW)) {
            this.zzu.zzt().zzH(bundle2);
        }
    }

    public final /* synthetic */ void zzah(int i) {
        if (this.zzk == null) {
            this.zzk = new zzjw(this, this.zzu);
        }
        this.zzk.zzb(((long) i) * 1000);
    }

    public final /* synthetic */ void zzai(Boolean bool, boolean z) {
        zzar(bool, true);
    }

    public final /* synthetic */ void zzaj(zzjk zzjk, long j, boolean z, boolean z2) {
        zzg();
        zzb();
        zzib zzib = this.zzu;
        zzjk zzl2 = zzib.zzd().zzl();
        if (j > this.zzq || !zzjk.zzu(zzl2.zzb(), zzjk.zzb())) {
            zzhg zzd2 = zzib.zzd();
            zzib zzib2 = zzd2.zzu;
            zzd2.zzg();
            int zzb2 = zzjk.zzb();
            if (zzd2.zzk(zzb2)) {
                zzib zzib3 = this.zzu;
                SharedPreferences.Editor edit = zzd2.zzd().edit();
                edit.putString("consent_settings", zzjk.zzl());
                edit.putInt("consent_source", zzb2);
                edit.apply();
                zzib.zzaV().zzk().zzb("Setting storage consent(FE)", zzjk);
                this.zzq = j;
                if (zzib3.zzt().zzP()) {
                    zzib3.zzt().zzk(z);
                } else {
                    zzib3.zzt().zzj(z);
                }
                if (z2) {
                    zzib3.zzt().zzC(new AtomicReference());
                    return;
                }
                return;
            }
            zzib.zzaV().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzjk.zzb()));
            return;
        }
        zzib.zzaV().zzi().zzb("Dropped out-of-date consent setting, proposed settings", zzjk);
    }

    public final /* synthetic */ void zzal(boolean z) {
        this.zzi = false;
    }

    public final /* synthetic */ int zzam() {
        return this.zzj;
    }

    public final /* synthetic */ void zzan(int i) {
        this.zzj = i;
    }

    public final /* synthetic */ zzay zzao() {
        return this.zzr;
    }

    public final /* synthetic */ int zzap(Throwable th) {
        String message = th.getMessage();
        this.zzn = false;
        int i = 2;
        if (message != null) {
            if ((th instanceof IllegalStateException) || message.contains("garbage collected") || th.getClass().getSimpleName().equals("ServiceUnavailableException")) {
                i = 1;
                if (message.contains("Background")) {
                    this.zzn = true;
                    return 1;
                }
            } else if (!(th instanceof SecurityException) || message.endsWith("READ_DEVICE_CONFIG")) {
                return i;
            } else {
                return 3;
            }
        }
        return i;
    }

    public final boolean zze() {
        return false;
    }

    public final void zzh() {
        zzib zzib = this.zzu;
        if ((zzib.zzaY().getApplicationContext() instanceof Application) && this.zza != null) {
            ((Application) zzib.zzaY().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    public final Boolean zzi() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.zzu.zzaW().zzk(atomicReference, FaceEnvironment.TIME_DETECT_MODULE, "boolean test flag value", new zzkd(this, atomicReference));
    }

    public final String zzj() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.zzu.zzaW().zzk(atomicReference, FaceEnvironment.TIME_DETECT_MODULE, "String test flag value", new zzkn(this, atomicReference));
    }

    public final Long zzk() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.zzu.zzaW().zzk(atomicReference, FaceEnvironment.TIME_DETECT_MODULE, "long test flag value", new zzko(this, atomicReference));
    }

    public final Integer zzl() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.zzu.zzaW().zzk(atomicReference, FaceEnvironment.TIME_DETECT_MODULE, "int test flag value", new zzkp(this, atomicReference));
    }

    public final Double zzm() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.zzu.zzaW().zzk(atomicReference, FaceEnvironment.TIME_DETECT_MODULE, "double test flag value", new zzkq(this, atomicReference));
    }

    public final void zzn(Boolean bool) {
        zzb();
        this.zzu.zzaW().zzj(new zzkr(this, bool));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzp(android.os.Bundle r9, int r10, long r11) {
        /*
            r8 = this;
            r8.zzb()
            com.google.android.gms.measurement.internal.zzjk r0 = com.google.android.gms.measurement.internal.zzjk.zza
            com.google.android.gms.measurement.internal.zzji r0 = com.google.android.gms.measurement.internal.zzji.STORAGE
            com.google.android.gms.measurement.internal.zzjj[] r0 = r0.zzb()
            int r1 = r0.length
            r2 = 0
        L_0x000d:
            r3 = 0
            if (r2 >= r1) goto L_0x003c
            r4 = r0[r2]
            java.lang.String r4 = r4.zze
            boolean r5 = r9.containsKey(r4)
            if (r5 == 0) goto L_0x0039
            java.lang.String r4 = r9.getString(r4)
            if (r4 == 0) goto L_0x0039
            java.lang.String r5 = "granted"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x002b
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            goto L_0x0035
        L_0x002b:
            java.lang.String r5 = "denied"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x0035
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
        L_0x0035:
            if (r3 != 0) goto L_0x0039
            r3 = r4
            goto L_0x003c
        L_0x0039:
            int r2 = r2 + 1
            goto L_0x000d
        L_0x003c:
            if (r3 == 0) goto L_0x005a
            com.google.android.gms.measurement.internal.zzib r0 = r8.zzu
            com.google.android.gms.measurement.internal.zzgt r1 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzh()
            java.lang.String r2 = "Ignoring invalid consent setting"
            r1.zzb(r2, r3)
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzh()
            java.lang.String r1 = "Valid consent values are 'granted', 'denied'"
            r0.zza(r1)
        L_0x005a:
            com.google.android.gms.measurement.internal.zzib r0 = r8.zzu
            com.google.android.gms.measurement.internal.zzhy r0 = r0.zzaW()
            boolean r0 = r0.zze()
            com.google.android.gms.measurement.internal.zzjk r1 = com.google.android.gms.measurement.internal.zzjk.zze(r9, r10)
            boolean r2 = r1.zzc()
            if (r2 == 0) goto L_0x0071
            r8.zzs(r1, r0)
        L_0x0071:
            com.google.android.gms.measurement.internal.zzaz r1 = com.google.android.gms.measurement.internal.zzaz.zzh(r9, r10)
            boolean r2 = r1.zzd()
            if (r2 == 0) goto L_0x007e
            r8.zzq(r1, r0)
        L_0x007e:
            java.lang.Boolean r9 = com.google.android.gms.measurement.internal.zzaz.zzi(r9)
            if (r9 == 0) goto L_0x00a9
            r1 = -30
            if (r10 != r1) goto L_0x008c
            java.lang.String r10 = "tcf"
        L_0x008a:
            r2 = r10
            goto L_0x008f
        L_0x008c:
            java.lang.String r10 = "app"
            goto L_0x008a
        L_0x008f:
            if (r0 == 0) goto L_0x009d
            java.lang.String r4 = r9.toString()
            java.lang.String r3 = "allow_personalized_ads"
            r1 = r8
            r5 = r11
            r1.zzN(r2, r3, r4, r5)
            return
        L_0x009d:
            java.lang.String r4 = r9.toString()
            java.lang.String r3 = "allow_personalized_ads"
            r5 = 0
            r1 = r8
            r6 = r11
            r1.zzL(r2, r3, r4, r5, r6)
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzli.zzp(android.os.Bundle, int, long):void");
    }

    public final void zzq(zzaz zzaz, boolean z) {
        zzks zzks = new zzks(this, zzaz);
        if (z) {
            zzg();
            zzks.run();
            return;
        }
        this.zzu.zzaW().zzj(zzks);
    }

    public final void zzs(zzjk zzjk, boolean z) {
        boolean z2;
        boolean z3;
        zzjk zzjk2;
        boolean z4;
        zzjh zzjh;
        zzb();
        int zzb2 = zzjk.zzb();
        if (zzb2 != -10 && zzjk.zzp() == (zzjh = zzjh.UNINITIALIZED) && zzjk.zzq() == zzjh) {
            this.zzu.zzaV().zzh().zza("Ignoring empty consent settings");
            return;
        }
        synchronized (this.zzh) {
            try {
                z2 = false;
                if (zzjk.zzu(zzb2, this.zzo.zzb())) {
                    z4 = zzjk.zzr(this.zzo);
                    zzjj zzjj = zzjj.ANALYTICS_STORAGE;
                    if (zzjk.zzo(zzjj) && !this.zzo.zzo(zzjj)) {
                        z2 = true;
                    }
                    zzjk zzt2 = zzjk.zzt(this.zzo);
                    this.zzo = zzt2;
                    zzjk2 = zzt2;
                    z3 = z2;
                    z2 = true;
                } else {
                    zzjk2 = zzjk;
                    z4 = false;
                    z3 = false;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (!z2) {
            this.zzu.zzaV().zzi().zzb("Ignoring lower-priority consent settings, proposed settings", zzjk2);
            return;
        }
        long andIncrement = this.zzp.getAndIncrement();
        if (z4) {
            this.zzg.set((Object) null);
            zzkt zzkt = new zzkt(this, zzjk2, andIncrement, z3);
            if (z) {
                zzg();
                zzkt.run();
                return;
            }
            this.zzu.zzaW().zzl(zzkt);
            return;
        }
        zzku zzku = new zzku(this, zzjk2, andIncrement, z3);
        if (z) {
            zzg();
            zzku.run();
        } else if (zzb2 == 30 || zzb2 == -10) {
            this.zzu.zzaW().zzl(zzku);
        } else {
            this.zzu.zzaW().zzj(zzku);
        }
    }

    public final void zzt(Runnable runnable) {
        zzb();
        zzib zzib = this.zzu;
        if (zzib.zzaW().zze()) {
            e.w(zzib, "Cannot retrieve and upload batches from analytics worker thread");
        } else if (!zzib.zzaW().zzf()) {
            zzib.zzaU();
            if (!zzae.zza()) {
                zzib.zzaV().zzk().zza("[sgtm] Started client-side batch upload work.");
                boolean z = false;
                int i = 0;
                int i2 = 0;
                while (!z) {
                    zzib.zzaV().zzk().zza("[sgtm] Getting upload batches from service (FE)");
                    AtomicReference atomicReference = new AtomicReference();
                    zzib.zzaW().zzk(atomicReference, 10000, "[sgtm] Getting upload batches", new zzlh(this, atomicReference));
                    zzop zzop = (zzop) atomicReference.get();
                    if (zzop == null) {
                        break;
                    }
                    List list = zzop.zza;
                    if (!list.isEmpty()) {
                        zzib.zzaV().zzk().zzb("[sgtm] Retrieved upload batches. count", Integer.valueOf(list.size()));
                        i += list.size();
                        Iterator it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = false;
                                break;
                            }
                            zzlq zzaq = zzaq((zzol) it.next());
                            if (zzaq == zzlq.SUCCESS) {
                                i2++;
                            } else if (zzaq == zzlq.BACKOFF) {
                                z = true;
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                }
                zzib.zzaV().zzk().zzc("[sgtm] Completed client-side batch upload work. total, success", Integer.valueOf(i), Integer.valueOf(i2));
                runnable.run();
                return;
            }
            e.w(zzib, "Cannot retrieve and upload batches from main thread");
        } else {
            e.w(zzib, "Cannot retrieve and upload batches from analytics network thread");
        }
    }

    @WorkerThread
    public final void zzu(long j) {
        zzg();
        if (this.zzl == null) {
            this.zzl = new zzjt(this, this.zzu);
        }
        this.zzl.zzb(j);
    }

    @WorkerThread
    public final void zzv() {
        zzg();
        zzay zzay = this.zzl;
        if (zzay != null) {
            zzay.zzd();
        }
    }

    public final void zzw() {
        zzql.zza();
        zzib zzib = this.zzu;
        if (!zzib.zzc().zzp((String) null, zzfx.zzaQ)) {
            return;
        }
        if (!zzib.zzaW().zze()) {
            zzib.zzaU();
            if (!zzae.zza()) {
                zzb();
                zzib.zzaV().zzk().zza("Getting trigger URIs (FE)");
                AtomicReference atomicReference = new AtomicReference();
                zzib.zzaW().zzk(atomicReference, 10000, "get trigger URIs", new zzkz(this, atomicReference));
                List list = (List) atomicReference.get();
                if (list == null) {
                    zzib.zzaV().zzd().zza("Timed out waiting for get trigger URIs");
                } else {
                    zzib.zzaW().zzj(new zzla(this, list));
                }
            } else {
                e.w(zzib, "Cannot get trigger URIs from main thread");
            }
        } else {
            e.w(zzib, "Cannot get trigger URIs from analytics worker thread");
        }
    }

    public final boolean zzx() {
        return this.zzn;
    }

    @TargetApi(30)
    public final PriorityQueue zzy() {
        if (this.zzm == null) {
            this.zzm = tg.d(Comparator.comparing(zzlb.zza, zzlc.zza));
        }
        return this.zzm;
    }

    @WorkerThread
    @TargetApi(30)
    public final void zzz() {
        zzog zzog;
        zzg();
        this.zzn = false;
        if (!zzy().isEmpty() && !this.zzi && (zzog = (zzog) zzy().poll()) != null) {
            zzib zzib = this.zzu;
            MeasurementManagerFutures zzT = zzib.zzk().zzT();
            if (zzT != null) {
                this.zzi = true;
                zzgr zzk2 = zzib.zzaV().zzk();
                String str = zzog.zza;
                zzk2.zzb("Registering trigger URI", str);
                ListenableFuture<Unit> registerTriggerAsync = zzT.registerTriggerAsync(Uri.parse(str));
                if (registerTriggerAsync == null) {
                    this.zzi = false;
                    zzy().add(zzog);
                    return;
                }
                Futures.addCallback(registerTriggerAsync, new zzjv(this, zzog), new zzju(this));
            }
        }
    }
}
