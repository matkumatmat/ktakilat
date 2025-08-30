package com.appsflyer.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.widget.ExpandableListView;
import androidx.annotation.VisibleForTesting;
import com.appsflyer.AFLogger;
import com.appsflyer.AdRevenueScheme;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFg1uSDK;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class AFg1oSDK implements AFg1qSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    private static boolean AFInAppEventParameterName = true;
    private static boolean AFInAppEventType = true;
    private static int AFKeystoreWrapper = -771284948;
    private static int d = 1;
    private static char[] registerClient = {8582, 8581, 8594, 8595, 8592, 8312, 8589, 8593, 8606, 8579, 8580, 8288, 8577, 8578, 8576};
    private static int w;
    @NotNull
    private final AFj1lSDK AFAdRevenueData;
    @NotNull
    private final Lazy AFLogger = LazyKt.b(AnonymousClass1.AFAdRevenueData);
    @NotNull
    private final AFh1vSDK areAllFieldsValid;
    @NotNull
    private final AFi1tSDK component1;
    @NotNull
    private final AFg1vSDK component2;
    @NotNull
    private final AFc1pSDK component3;
    @NotNull
    private final AFc1qSDK component4;
    @NotNull
    private final AFc1kSDK copy;
    @NotNull
    private final Lazy copydefault = LazyKt.b(AnonymousClass4.getMediationNetwork);
    @NotNull
    private final AFf1gSDK equals;
    @NotNull
    private final String getCurrencyIso4217Code;
    @NotNull
    private final AFg1uSDK getMediationNetwork;
    @NotNull
    private final Context getMonetizationNetwork;
    @NotNull
    private final AFi1lSDK getRevenue;
    @NotNull
    private final AFg1xSDK hashCode;
    @NotNull
    private final AFc1iSDK toString;

    public AFg1oSDK(@NotNull String str, @NotNull Context context, @NotNull AFi1lSDK aFi1lSDK, @NotNull AFg1uSDK aFg1uSDK, @NotNull AFj1lSDK aFj1lSDK, @NotNull AFg1vSDK aFg1vSDK, @NotNull AFh1vSDK aFh1vSDK, @NotNull AFc1qSDK aFc1qSDK, @NotNull AFc1pSDK aFc1pSDK, @NotNull AFi1tSDK aFi1tSDK, @NotNull AFf1gSDK aFf1gSDK, @NotNull AFc1iSDK aFc1iSDK, @NotNull AFg1xSDK aFg1xSDK, @NotNull AFc1kSDK aFc1kSDK) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(aFi1lSDK, "");
        Intrinsics.checkNotNullParameter(aFg1uSDK, "");
        Intrinsics.checkNotNullParameter(aFj1lSDK, "");
        Intrinsics.checkNotNullParameter(aFg1vSDK, "");
        Intrinsics.checkNotNullParameter(aFh1vSDK, "");
        Intrinsics.checkNotNullParameter(aFc1qSDK, "");
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(aFi1tSDK, "");
        Intrinsics.checkNotNullParameter(aFf1gSDK, "");
        Intrinsics.checkNotNullParameter(aFc1iSDK, "");
        Intrinsics.checkNotNullParameter(aFg1xSDK, "");
        Intrinsics.checkNotNullParameter(aFc1kSDK, "");
        this.getCurrencyIso4217Code = str;
        this.getMonetizationNetwork = context;
        this.getRevenue = aFi1lSDK;
        this.getMediationNetwork = aFg1uSDK;
        this.AFAdRevenueData = aFj1lSDK;
        this.component2 = aFg1vSDK;
        this.areAllFieldsValid = aFh1vSDK;
        this.component4 = aFc1qSDK;
        this.component3 = aFc1pSDK;
        this.component1 = aFi1tSDK;
        this.equals = aFf1gSDK;
        this.toString = aFc1iSDK;
        this.hashCode = aFg1xSDK;
        this.copy = aFc1kSDK;
    }

    private static /* synthetic */ Object AFAdRevenueData(Object[] objArr) {
        boolean z;
        AFg1oSDK aFg1oSDK = objArr[0];
        AFh1rSDK aFh1rSDK = objArr[1];
        Intrinsics.checkNotNullParameter(aFh1rSDK, "");
        if (!aFg1oSDK.component3.component4()) {
            Map<String, Object> revenue = AFa1tSDK.getRevenue(aFh1rSDK.AFAdRevenueData);
            Intrinsics.checkNotNullExpressionValue(revenue, "");
            revenue.put("ad_ids_disabled", Boolean.TRUE);
        } else {
            AFh1oSDK aFh1oSDK = aFg1oSDK.component3.getCurrencyIso4217Code.component3;
            if (aFh1oSDK == null) {
                return null;
            }
            String str = aFh1oSDK.areAllFieldsValid;
            if (str != null) {
                d = (w + 109) % 128;
                if (str.length() != 0) {
                    aFh1rSDK.getMediationNetwork("gaidError", aFh1oSDK.areAllFieldsValid);
                    w = (d + 31) % 128;
                }
            }
            String str2 = aFh1oSDK.AFAdRevenueData;
            if (!(str2 == null || aFh1oSDK.getMonetizationNetwork == null)) {
                aFh1rSDK.getMediationNetwork("advertiserId", str2);
                aFh1rSDK.getMediationNetwork("advertiserIdEnabled", String.valueOf(aFh1oSDK.getMonetizationNetwork));
                aFh1rSDK.getMediationNetwork("isGaidWithGps", String.valueOf(aFh1oSDK.getMediationNetwork));
            }
        }
        AFh1oSDK aFh1oSDK2 = aFg1oSDK.component3.getCurrencyIso4217Code.component3;
        if (aFh1oSDK2 != null) {
            int i = d + 23;
            w = i % 128;
            if (i % 2 == 0) {
                z = Intrinsics.a(aFh1oSDK2.component2, Boolean.TRUE);
            } else {
                Intrinsics.a(aFh1oSDK2.component2, Boolean.TRUE);
                throw null;
            }
        } else {
            z = false;
        }
        aFh1rSDK.getMediationNetwork("GAID_retry", String.valueOf(z));
        if (CollectionsKt.t(AFe1mSDK.CONVERSION, AFe1mSDK.LAUNCH).contains(aFh1rSDK.getCurrencyIso4217Code())) {
            d = (w + 97) % 128;
            AFd1hSDK aFd1hSDK = aFg1oSDK.copy.component4;
            if (aFd1hSDK != null) {
                Map<String, Object> revenue2 = AFa1tSDK.getRevenue(aFh1rSDK.AFAdRevenueData);
                Intrinsics.checkNotNullExpressionValue(revenue2, "");
                revenue2.put("fetchAdIdLatency", Long.valueOf(aFd1hSDK.getRevenue));
                return null;
            }
        }
        int i2 = w + 35;
        d = i2 % 128;
        if (i2 % 2 != 0) {
            return null;
        }
        throw null;
    }

    @SuppressLint({"HardwareIds"})
    private final String AFInAppEventParameterName() {
        String str;
        int i = w + 67;
        d = i % 128;
        if (i % 2 != 0) {
            str = this.component4.AFAdRevenueData("androidIdCached", (String) null);
            try {
                String string = Settings.Secure.getString(this.getMonetizationNetwork.getContentResolver(), "android_id");
                if (string != null) {
                    return string;
                }
            } catch (Exception e) {
                AFLogger.afErrorLog(e.getMessage(), e);
            }
        } else {
            str = this.component4.AFAdRevenueData("androidIdCached", (String) null);
            Settings.Secure.getString(this.getMonetizationNetwork.getContentResolver(), "android_id");
            throw null;
        }
        if (str == null) {
            return null;
        }
        d = (w + 73) % 128;
        AFLogger.afDebugLog("use cached AndroidId: ".concat(str));
        int i2 = d + 125;
        w = i2 % 128;
        if (i2 % 2 != 0) {
            int i3 = 82 / 0;
        }
        return str;
    }

    private static void AFInAppEventType(@NotNull Map<String, Object> map) {
        int i = d + 109;
        w = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(map, "");
            String currencyIso4217Code = AFa1zSDK.getCurrencyIso4217Code();
            String revenue = AFa1zSDK.getRevenue();
            if (currencyIso4217Code != null && revenue != null && Integer.parseInt(revenue) > 0) {
                int i2 = w + 27;
                d = i2 % 128;
                if (i2 % 2 != 0) {
                    map.put("reinstallCounter", revenue);
                    map.put("originalAppsflyerId", currencyIso4217Code);
                    return;
                }
                map.put("reinstallCounter", revenue);
                map.put("originalAppsflyerId", currencyIso4217Code);
                throw null;
            }
            return;
        }
        Intrinsics.checkNotNullParameter(map, "");
        AFa1zSDK.getCurrencyIso4217Code();
        AFa1zSDK.getRevenue();
        throw null;
    }

    private void AFKeystoreWrapper(@NotNull Map<String, Object> map) {
        int i = w + 111;
        d = i % 128;
        if (i % 2 != 0) {
            Intrinsics.checkNotNullParameter(map, "");
            String string = ((AppsFlyerProperties) getMediationNetwork(new Object[]{this}, 2080605438, -2080605426, System.identityHashCode(this))).getString(AppsFlyerProperties.EXTENSION);
            if (string != null) {
                w = (d + 125) % 128;
                if (string.length() != 0) {
                    map.put(AppsFlyerProperties.EXTENSION, string);
                    return;
                }
                return;
            }
            return;
        }
        Intrinsics.checkNotNullParameter(map, "");
        ((AppsFlyerProperties) getMediationNetwork(new Object[]{this}, 2080605438, -2080605426, System.identityHashCode(this))).getString(AppsFlyerProperties.EXTENSION);
        throw null;
    }

    private void AFLogger(@NotNull Map<String, Object> map) {
        getMediationNetwork(new Object[]{this, map}, -140518465, 140518471, System.identityHashCode(this));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.lang.String r10, int[] r11, java.lang.String r12, int r13, java.lang.Object[] r14) {
        /*
            if (r12 == 0) goto L_0x000e
            int r0 = $10
            int r0 = r0 + 17
            int r0 = r0 % 128
            $11 = r0
            char[] r12 = r12.toCharArray()
        L_0x000e:
            char[] r12 = (char[]) r12
            if (r10 == 0) goto L_0x0018
            java.lang.String r0 = "ISO-8859-1"
            byte[] r10 = r10.getBytes(r0)
        L_0x0018:
            byte[] r10 = (byte[]) r10
            com.appsflyer.internal.AFk1nSDK r0 = new com.appsflyer.internal.AFk1nSDK
            r0.<init>()
            char[] r1 = registerClient
            r2 = -5879130172463570806(0xae692241d207208a, double:-4.0430553008327965E-85)
            r4 = 0
            if (r1 == 0) goto L_0x0043
            int r5 = $10
            int r5 = r5 + 113
            int r5 = r5 % 128
            $11 = r5
            int r5 = r1.length
            char[] r6 = new char[r5]
            r7 = 0
        L_0x0035:
            if (r7 >= r5) goto L_0x0042
            char r8 = r1[r7]
            long r8 = (long) r8
            long r8 = r8 ^ r2
            int r9 = (int) r8
            char r8 = (char) r9
            r6[r7] = r8
            int r7 = r7 + 1
            goto L_0x0035
        L_0x0042:
            r1 = r6
        L_0x0043:
            int r5 = AFKeystoreWrapper
            long r5 = (long) r5
            long r2 = r2 ^ r5
            int r3 = (int) r2
            boolean r2 = AFInAppEventType
            if (r2 == 0) goto L_0x0072
            int r11 = r10.length
            r0.getMonetizationNetwork = r11
            char[] r11 = new char[r11]
            r0.AFAdRevenueData = r4
        L_0x0053:
            int r12 = r0.AFAdRevenueData
            int r2 = r0.getMonetizationNetwork
            if (r12 >= r2) goto L_0x006a
            int r2 = r2 + -1
            int r2 = r2 - r12
            byte r2 = r10[r2]
            int r2 = r2 + r13
            char r2 = r1[r2]
            int r2 = r2 - r3
            char r2 = (char) r2
            r11[r12] = r2
            int r12 = r12 + 1
            r0.AFAdRevenueData = r12
            goto L_0x0053
        L_0x006a:
            java.lang.String r10 = new java.lang.String
            r10.<init>(r11)
            r14[r4] = r10
            return
        L_0x0072:
            boolean r10 = AFInAppEventParameterName
            if (r10 == 0) goto L_0x00be
            int r10 = $11
            int r10 = r10 + 81
            int r10 = r10 % 128
            $10 = r10
            int r10 = r12.length
            r0.getMonetizationNetwork = r10
            char[] r10 = new char[r10]
            r0.AFAdRevenueData = r4
        L_0x0085:
            int r11 = r0.AFAdRevenueData
            int r2 = r0.getMonetizationNetwork
            if (r11 >= r2) goto L_0x00b6
            int r5 = $10
            int r5 = r5 + 13
            int r6 = r5 % 128
            $11 = r6
            int r5 = r5 % 2
            if (r5 != 0) goto L_0x00a7
            int r2 = r2 * r11
            char r2 = r12[r2]
            int r2 = r2 - r13
            char r2 = r1[r2]
            int r2 = r2 / r3
            char r2 = (char) r2
            r10[r11] = r2
            int r11 = r11 % 0
        L_0x00a4:
            r0.AFAdRevenueData = r11
            goto L_0x0085
        L_0x00a7:
            int r2 = r2 + -1
            int r2 = r2 - r11
            char r2 = r12[r2]
            int r2 = r2 - r13
            char r2 = r1[r2]
            int r2 = r2 - r3
            char r2 = (char) r2
            r10[r11] = r2
            int r11 = r11 + 1
            goto L_0x00a4
        L_0x00b6:
            java.lang.String r11 = new java.lang.String
            r11.<init>(r10)
            r14[r4] = r11
            return
        L_0x00be:
            int r10 = r11.length
            r0.getMonetizationNetwork = r10
            char[] r10 = new char[r10]
            r0.AFAdRevenueData = r4
        L_0x00c5:
            int r12 = r0.AFAdRevenueData
            int r2 = r0.getMonetizationNetwork
            if (r12 >= r2) goto L_0x00dc
            int r2 = r2 + -1
            int r2 = r2 - r12
            r2 = r11[r2]
            int r2 = r2 - r13
            char r2 = r1[r2]
            int r2 = r2 - r3
            char r2 = (char) r2
            r10[r12] = r2
            int r12 = r12 + 1
            r0.AFAdRevenueData = r12
            goto L_0x00c5
        L_0x00dc:
            java.lang.String r11 = new java.lang.String
            r11.<init>(r10)
            r14[r4] = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1oSDK.a(java.lang.String, int[], java.lang.String, int, java.lang.Object[]):void");
    }

    private void afDebugLog(@NotNull Map<String, Object> map) {
        String str;
        int i = w + 111;
        d = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(map, "");
            if (!((AppsFlyerProperties) getMediationNetwork(new Object[]{this}, 2080605438, -2080605426, System.identityHashCode(this))).getBoolean(AppsFlyerProperties.COLLECT_FACEBOOK_ATTR_ID, true)) {
                return;
            }
        } else {
            Intrinsics.checkNotNullParameter(map, "");
            if (!((AppsFlyerProperties) getMediationNetwork(new Object[]{this}, 2080605438, -2080605426, System.identityHashCode(this))).getBoolean(AppsFlyerProperties.COLLECT_FACEBOOK_ATTR_ID, true)) {
                return;
            }
        }
        try {
            this.getMonetizationNetwork.getPackageManager().getApplicationInfo("com.facebook.katana", 0);
            str = this.component3.getCurrencyIso4217Code(this.getMonetizationNetwork);
        } catch (Throwable unused) {
            str = null;
        }
        if (str != null) {
            int i2 = d + 113;
            w = i2 % 128;
            if (i2 % 2 == 0) {
                map.put("fb", str);
            } else {
                map.put("fb", str);
                throw null;
            }
        }
    }

    private void afErrorLog(@NotNull Map<String, Object> map) {
        int i = d + 89;
        w = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(map, "");
            if (this.copy.AFAdRevenueData()) {
                map.put("app_set_id", MapsKt.d(new Pair("app_set_id_disabled", Boolean.TRUE)));
                if (this.copy.toString != null) {
                    AFg1gSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.APP_SET_ID, "App Set Id was collected, but will not be included in the payload.To prevent collection entirely, call disableAppSetId() before initializing the SDK.", false, 4, (Object) null);
                    int i2 = d + 109;
                    w = i2 % 128;
                    if (i2 % 2 != 0) {
                        throw null;
                    }
                    return;
                }
                AFg1gSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.APP_SET_ID, "App Set ID collection is disabled. Skipping inclusion in the event payload.", false, 4, (Object) null);
                return;
            }
            AFb1gSDK aFb1gSDK = this.copy.toString;
            if (aFb1gSDK != null) {
                w = (d + 89) % 128;
                map.put("app_set_id", MapsKt.e(new Pair("scope", Integer.valueOf(aFb1gSDK.AFAdRevenueData)), new Pair("id", aFb1gSDK.getMonetizationNetwork)));
                return;
            }
            return;
        }
        Intrinsics.checkNotNullParameter(map, "");
        this.copy.AFAdRevenueData();
        throw null;
    }

    private void afInfoLog(@NotNull Map<String, Object> map) {
        d = (w + 11) % 128;
        Intrinsics.checkNotNullParameter(map, "");
        if (this.component4.getMediationNetwork("is_stop_tracking_used")) {
            map.put("istu", String.valueOf(this.component4.getMediationNetwork("is_stop_tracking_used", false)));
        }
        d = (w + 87) % 128;
    }

    @VisibleForTesting
    private void areAllFieldsValid(@NotNull Map<String, Object> map) {
        w = (d + 59) % 128;
        Intrinsics.checkNotNullParameter(map, "");
        AFf1gSDK.getRevenue(map, this.component3);
        int i = d + 85;
        w = i % 128;
        if (i % 2 != 0) {
            throw null;
        }
    }

    private static long component1() {
        w = (d + 11) % 128;
        long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        int i = w + 67;
        d = i % 128;
        if (i % 2 != 0) {
            return currentTimeMillis;
        }
        throw null;
    }

    @Nullable
    private String component2() {
        int i = d + 119;
        w = i % 128;
        if (i % 2 == 0) {
            String string = ((AppsFlyerProperties) getMediationNetwork(new Object[]{this}, 2080605438, -2080605426, System.identityHashCode(this))).getString(AppsFlyerProperties.AF_STORE_FROM_API);
            if (string == null) {
                string = AFAdRevenueData("AF_STORE");
            }
            int i2 = d + 11;
            w = i2 % 128;
            if (i2 % 2 == 0) {
                return string;
            }
            throw null;
        }
        ((AppsFlyerProperties) getMediationNetwork(new Object[]{this}, 2080605438, -2080605426, System.identityHashCode(this))).getString(AppsFlyerProperties.AF_STORE_FROM_API);
        throw null;
    }

    @NotNull
    private static String component3() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
        long blockSizeLong = statFs.getBlockSizeLong();
        double pow = Math.pow(2.0d, 20.0d);
        String str = ((long) (((double) (statFs.getAvailableBlocksLong() * blockSizeLong)) / pow)) + RemoteSettings.FORWARD_SLASH_STRING + ((long) (((double) (statFs.getBlockCountLong() * blockSizeLong)) / pow));
        w = (d + 67) % 128;
        return str;
    }

    @Nullable
    private String component4() throws CertificateException, NoSuchAlgorithmException, PackageManager.NameNotFoundException {
        w = (d + 65) % 128;
        String N_ = AFj1iSDK.N_(this.getMonetizationNetwork.getApplicationContext().getPackageManager(), this.getMonetizationNetwork.getApplicationContext().getPackageName());
        int i = w + 19;
        d = i % 128;
        if (i % 2 != 0) {
            return N_;
        }
        throw null;
    }

    @Nullable
    private String copy() {
        w = (d + 21) % 128;
        String string = ((AppsFlyerProperties) getMediationNetwork(new Object[]{this}, 2080605438, -2080605426, System.identityHashCode(this))).getString("preInstallName");
        if (string != null) {
            int i = w + 77;
            d = i % 128;
            if (i % 2 != 0) {
                return string;
            }
            throw null;
        }
        if (this.component4.getMediationNetwork("preInstallName")) {
            d = (w + 91) % 128;
            string = this.component4.AFAdRevenueData("preInstallName", (String) null);
        } else {
            if (copydefault()) {
                string = (String) getMediationNetwork(new Object[]{this}, -1713193940, 1713193943, System.identityHashCode(this));
                if (string == null) {
                    int i2 = w + 119;
                    d = i2 % 128;
                    if (i2 % 2 != 0) {
                        string = AFAdRevenueData("AF_PRE_INSTALL_NAME");
                    } else {
                        AFAdRevenueData("AF_PRE_INSTALL_NAME");
                        throw null;
                    }
                }
            }
            if (string != null) {
                this.component4.getMediationNetwork("preInstallName", string);
            }
        }
        if (string != null) {
            ((AppsFlyerProperties) getMediationNetwork(new Object[]{this}, 2080605438, -2080605426, System.identityHashCode(this))).set("preInstallName", string);
        }
        return string;
    }

    private boolean copydefault() {
        int i = w + 93;
        d = i % 128;
        if (i % 2 != 0 ? this.component3.getMonetizationNetwork.AFAdRevenueData("appsFlyerCount", 0) > 1 : this.component3.getMonetizationNetwork.AFAdRevenueData("appsFlyerCount", 1) > 1) {
            return false;
        }
        d = (w + 91) % 128;
        return true;
    }

    private void d(@NotNull Map<String, Object> map) {
        d = (w + 13) % 128;
        Intrinsics.checkNotNullParameter(map, "");
        String revenue = AFb1iSDK.getRevenue(this.component3.getMonetizationNetwork);
        if (revenue != null) {
            int i = d + 13;
            w = i % 128;
            if (i % 2 != 0) {
                map.put("uid", revenue);
                boolean mediationNetwork = this.component3.getMonetizationNetwork.getMediationNetwork("CUSTOM_INSTALL_ID_APPLIED", true);
                Intrinsics.checkNotNullExpressionValue(Boolean.valueOf(mediationNetwork), "");
                if (!mediationNetwork) {
                    return;
                }
            } else {
                map.put("uid", revenue);
                boolean mediationNetwork2 = this.component3.getMonetizationNetwork.getMediationNetwork("CUSTOM_INSTALL_ID_APPLIED", false);
                Intrinsics.checkNotNullExpressionValue(Boolean.valueOf(mediationNetwork2), "");
                if (!mediationNetwork2) {
                    return;
                }
            }
            int i2 = w + 117;
            d = i2 % 128;
            if (i2 % 2 != 0) {
                map.put("custom_install_id", Boolean.TRUE);
            } else {
                map.put("custom_install_id", Boolean.TRUE);
                throw null;
            }
        }
    }

    private void e(@NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        boolean monetizationNetwork = AFg1ySDK.getMonetizationNetwork(this.getMonetizationNetwork);
        AFLogger.afDebugLog("didConfigureTokenRefreshService=" + monetizationNetwork);
        if (!monetizationNetwork) {
            d = (w + 55) % 128;
            map.put("tokenRefreshConfigured", Boolean.FALSE);
            w = (d + 125) % 128;
        }
        map.put("registeredUninstall", Boolean.valueOf(AFg1ySDK.getMonetizationNetwork(this.component4)));
    }

    private boolean equals() {
        d = (w + 89) % 128;
        boolean parseBoolean = Boolean.parseBoolean(this.component4.AFAdRevenueData("sentSuccessfully", (String) null));
        int i = d + 49;
        w = i % 128;
        if (i % 2 == 0) {
            return parseBoolean;
        }
        throw null;
    }

    private void force(@NotNull Map<String, Object> map) {
        d = (w + 113) % 128;
        Intrinsics.checkNotNullParameter(map, "");
        String mediationNetwork = this.equals.getMediationNetwork();
        if (mediationNetwork != null) {
            int i = w + 109;
            d = i % 128;
            if (i % 2 == 0) {
                mediationNetwork.length();
                throw null;
            } else if (mediationNetwork.length() != 0) {
                int i2 = d + 41;
                w = i2 % 128;
                if (i2 % 2 == 0) {
                    map.put("appsflyerKey", mediationNetwork);
                } else {
                    map.put("appsflyerKey", mediationNetwork);
                    throw null;
                }
            }
        }
    }

    private static /* synthetic */ Object getCurrencyIso4217Code(Object[] objArr) {
        String[] strArr;
        AFg1oSDK aFg1oSDK = objArr[0];
        Map map = objArr[1];
        int i = d + 51;
        w = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(map, "");
            String string = ((AppsFlyerProperties) getMediationNetwork(new Object[]{aFg1oSDK}, 2080605438, -2080605426, System.identityHashCode(aFg1oSDK))).getString("appid");
            if (string != null) {
                w = (d + 31) % 128;
                map.put("appid", string);
            }
            String string2 = ((AppsFlyerProperties) getMediationNetwork(new Object[]{aFg1oSDK}, 2080605438, -2080605426, System.identityHashCode(aFg1oSDK))).getString(AppsFlyerProperties.CURRENCY_CODE);
            if (string2 != null) {
                if (string2.length() != 3) {
                    StringBuilder sb = new StringBuilder("WARNING: currency code should be 3 characters!!! '");
                    sb.append(string2);
                    sb.append("' is not a legal value.");
                    String obj = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(obj, "");
                    AFLogger.afWarnLog(obj);
                }
                map.put(FirebaseAnalytics.Param.CURRENCY, string2);
            }
            String string3 = ((AppsFlyerProperties) getMediationNetwork(new Object[]{aFg1oSDK}, 2080605438, -2080605426, System.identityHashCode(aFg1oSDK))).getString(AppsFlyerProperties.IS_UPDATE);
            if (string3 != null) {
                map.put("isUpdate", string3);
            }
            String string4 = ((AppsFlyerProperties) getMediationNetwork(new Object[]{aFg1oSDK}, 2080605438, -2080605426, System.identityHashCode(aFg1oSDK))).getString(AppsFlyerProperties.ADDITIONAL_CUSTOM_DATA);
            if (string4 != null) {
                int i2 = w + 5;
                d = i2 % 128;
                if (i2 % 2 != 0) {
                    map.put("customData", string4);
                } else {
                    map.put("customData", string4);
                    throw null;
                }
            }
            String string5 = ((AppsFlyerProperties) getMediationNetwork(new Object[]{aFg1oSDK}, 2080605438, -2080605426, System.identityHashCode(aFg1oSDK))).getString(AppsFlyerProperties.APP_USER_ID);
            if (string5 != null) {
                int i3 = w + 69;
                d = i3 % 128;
                if (i3 % 2 != 0) {
                    map.put("appUserId", string5);
                } else {
                    map.put("appUserId", string5);
                    throw null;
                }
            }
            String string6 = ((AppsFlyerProperties) getMediationNetwork(new Object[]{aFg1oSDK}, 2080605438, -2080605426, System.identityHashCode(aFg1oSDK))).getString(AppsFlyerProperties.USER_EMAILS);
            if (string6 != null) {
                map.put("user_emails", string6);
            }
            AFb1uSDK aFb1uSDK = aFg1oSDK.copy.getRevenue;
            if (!(aFb1uSDK == null || (strArr = aFb1uSDK.getMediationNetwork) == null)) {
                w = (d + 107) % 128;
                map.put("sharing_filter", strArr);
            }
            return null;
        }
        Intrinsics.checkNotNullParameter(map, "");
        ((AppsFlyerProperties) getMediationNetwork(new Object[]{aFg1oSDK}, 2080605438, -2080605426, System.identityHashCode(aFg1oSDK))).getString("appid");
        throw null;
    }

    public static /* synthetic */ Object getMediationNetwork(Object[] objArr, int i, int i2, int i3) {
        Object obj;
        int i4 = ~i3;
        int i5 = ((i2 | i3) * 521) + (((~(i4 | i2)) | i) * -1042) + (i2 * -520) + (i * 522);
        int i6 = ~i;
        int i7 = ~((~i2) | i6);
        switch ((((~(i | i4 | i2)) | (~(i3 | i6)) | i7) * 521) + i5) {
            case 1:
                File file = objArr[0];
                int i8 = d;
                w = (i8 + 43) % 128;
                if (file != null) {
                    w = (i8 + 95) % 128;
                    if (file.exists()) {
                        obj = Boolean.FALSE;
                        break;
                    }
                }
                obj = Boolean.TRUE;
                break;
            case 2:
                PackageManager packageManager = objArr[0];
                String str = objArr[1];
                d = (w + 91) % 128;
                if (Build.VERSION.SDK_INT < 33) {
                    obj = packageManager.getPackageInfo(str, 0);
                    Intrinsics.checkNotNullExpressionValue(obj, "");
                    break;
                } else {
                    obj = packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(0));
                    Intrinsics.checkNotNullExpressionValue(obj, "");
                    w = (d + 21) % 128;
                    break;
                }
            case 3:
                AFg1oSDK aFg1oSDK = objArr[0];
                File currencyIso4217Code = getCurrencyIso4217Code(getMediationNetwork("ro.appsflyer.preinstall.path"));
                if (getMediationNetwork(currencyIso4217Code)) {
                    currencyIso4217Code = getCurrencyIso4217Code(aFg1oSDK.AFAdRevenueData("AF_PRE_INSTALL_PATH"));
                }
                if (getMediationNetwork(currencyIso4217Code)) {
                    d = (w + 1) % 128;
                    currencyIso4217Code = getCurrencyIso4217Code("/data/local/tmp/pre_install.appsflyer");
                    d = (w + 79) % 128;
                }
                if (getMediationNetwork(currencyIso4217Code)) {
                    currencyIso4217Code = getCurrencyIso4217Code("/etc/pre_install.appsflyer");
                }
                if (getMediationNetwork(currencyIso4217Code)) {
                    return null;
                }
                String packageName = aFg1oSDK.getMonetizationNetwork.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "");
                String str2 = (String) getMediationNetwork(new Object[]{currencyIso4217Code, packageName}, -2094417185, 2094417192, (int) System.currentTimeMillis());
                d = (w + 89) % 128;
                return str2;
            case 4:
                return AFAdRevenueData(objArr);
            case 5:
                return getCurrencyIso4217Code(objArr);
            case 6:
                return getMonetizationNetwork(objArr);
            case 7:
                return getRevenue(objArr);
            case 8:
                Map map = objArr[1];
                w = (d + 115) % 128;
                Intrinsics.checkNotNullParameter(map, "");
                AFb1mSDK k_ = AFb1jSDK.k_(objArr[0].getMonetizationNetwork.getContentResolver());
                if (k_ == null) {
                    return null;
                }
                w = (d + 15) % 128;
                map.put("amazon_aid", k_.getMonetizationNetwork);
                map.put("amazon_aid_limit", String.valueOf(k_.getMediationNetwork));
                return null;
            case 9:
                return component1(objArr);
            case 10:
                AFg1oSDK aFg1oSDK2 = objArr[0];
                d = (w + 13) % 128;
                long currentTimeMillis = System.currentTimeMillis();
                w = (d + 7) % 128;
                return Long.valueOf(currentTimeMillis);
            case 11:
                return areAllFieldsValid(objArr);
            case 12:
                w = (d + 59) % 128;
                AppsFlyerProperties appsFlyerProperties = (AppsFlyerProperties) objArr[0].copydefault.getValue();
                d = (w + 23) % 128;
                return appsFlyerProperties;
            default:
                return getMediationNetwork(objArr);
        }
        return obj;
    }

    private final SimpleDateFormat getMonetizationNetwork() {
        d = (w + 93) % 128;
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) this.AFLogger.getValue();
        int i = d + 91;
        w = i % 128;
        if (i % 2 == 0) {
            return simpleDateFormat;
        }
        throw null;
    }

    private final void hashCode(Map<String, Object> map) {
        int i = d + 49;
        w = i % 128;
        if (i % 2 != 0) {
            int i2 = 74 / 0;
            if (!AFg1kSDK.getMediationNetwork(this.getMonetizationNetwork)) {
                return;
            }
        } else if (!AFg1kSDK.getMediationNetwork(this.getMonetizationNetwork)) {
            return;
        }
        map.put("inst_app", Boolean.TRUE);
        w = (d + 85) % 128;
    }

    private void i(@NotNull Map<String, Object> map) {
        getMediationNetwork(new Object[]{this, map}, -1753918152, 1753918160, System.identityHashCode(this));
    }

    private void registerClient(@NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        long j = this.areAllFieldsValid.toString;
        if (j != 0) {
            int i = w + 97;
            d = i % 128;
            if (i % 2 != 0) {
                map.put("prev_session_dur", Long.valueOf(j));
            } else {
                map.put("prev_session_dur", Long.valueOf(j));
                throw null;
            }
        }
        w = (d + 105) % 128;
    }

    private static PackageInfo s_(PackageManager packageManager, String str) {
        return (PackageInfo) getMediationNetwork(new Object[]{packageManager, str}, 1014234820, -1014234818, (int) System.currentTimeMillis());
    }

    private final void toString(Map<String, Object> map) {
        d = (w + 33) % 128;
        if (!((AppsFlyerProperties) getMediationNetwork(new Object[]{this}, 2080605438, -2080605426, System.identityHashCode(this))).isOtherSdkStringDisabled()) {
            d = (w + 69) % 128;
            map.put("batteryLevel", String.valueOf(this.getMediationNetwork.getRevenue(this.getMonetizationNetwork).getRevenue));
            w = (d + 103) % 128;
        }
    }

    private void unregisterClient(@NotNull Map<String, Object> map) {
        int i = d + 27;
        w = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(map, "");
            map.put("af_preinstalled", String.valueOf(AFc1pSDK.AFAdRevenueData(this.getMonetizationNetwork)));
            return;
        }
        Intrinsics.checkNotNullParameter(map, "");
        map.put("af_preinstalled", String.valueOf(AFc1pSDK.AFAdRevenueData(this.getMonetizationNetwork)));
        throw null;
    }

    private static void w(@NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        try {
            map.put("lang", Locale.getDefault().getDisplayLanguage());
            d = (w + 103) % 128;
        } catch (Exception e) {
            AFLogger.afErrorLog("Exception while collecting display language name. ", e);
        }
        try {
            map.put("lang_code", Locale.getDefault().getLanguage());
            w = (d + 119) % 128;
        } catch (Exception e2) {
            AFLogger.afErrorLog("Exception while collecting display language code. ", e2);
        }
        try {
            map.put(AdRevenueScheme.COUNTRY, Locale.getDefault().getCountry());
            d = (w + 103) % 128;
        } catch (Exception e3) {
            AFLogger.afErrorLog("Exception while collecting country name. ", e3);
        }
    }

    public final void getRevenue(@NotNull AFh1rSDK aFh1rSDK) {
        w = (d + 35) % 128;
        Intrinsics.checkNotNullParameter(aFh1rSDK, "");
        Map<String, Object> map = aFh1rSDK.AFAdRevenueData;
        Intrinsics.checkNotNullExpressionValue(map, "");
        getCurrencyIso4217Code(map, aFh1rSDK.getMediationNetwork());
        component2(map);
        w(map);
        getMediationNetwork(new Object[]{this, map}, -1412383531, 1412383531, System.identityHashCode(this));
        getCurrencyIso4217Code(map, this.copy.AFAdRevenueData);
        getMediationNetwork(new Object[]{this, map}, -1753918152, 1753918160, System.identityHashCode(this));
        map.put("cell", MapsKt.e(new Pair("mcc", Integer.valueOf(this.getMonetizationNetwork.getResources().getConfiguration().mcc)), new Pair("mnc", Integer.valueOf(this.getMonetizationNetwork.getResources().getConfiguration().mnc))));
        map.put("sig", component4());
        map.put("last_boot_time", Long.valueOf(component1()));
        map.put("disk", component3());
        int i = w + 25;
        d = i % 128;
        if (i % 2 == 0) {
            throw null;
        }
    }

    private void component1(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        AFh1vSDK aFh1vSDK = this.areAllFieldsValid;
        HashMap hashMap = new HashMap(aFh1vSDK.getRevenue);
        aFh1vSDK.getRevenue.clear();
        this.areAllFieldsValid.getCurrencyIso4217Code.getMonetizationNetwork("gcd");
        Intrinsics.checkNotNullExpressionValue(hashMap, "");
        if (!hashMap.isEmpty()) {
            w = (d + 71) % 128;
            Map<String, Object> revenue = AFa1tSDK.getRevenue((Map<String, Object>) map);
            Intrinsics.checkNotNullExpressionValue(revenue, "");
            revenue.put("gcd", hashMap);
            return;
        }
        d = (w + 113) % 128;
    }

    private final void component4(Map<String, Object> map) {
        AFg1uSDK.AFa1uSDK revenue = this.getMediationNetwork.getRevenue(this.getMonetizationNetwork);
        float f = revenue.getRevenue;
        String str = revenue.getMediationNetwork;
        map.put("btl", String.valueOf(f));
        if (str != null) {
            w = (d + 67) % 128;
            map.put("btch", str);
            w = (d + 109) % 128;
        }
    }

    private void equals(@NotNull Map<String, Object> map) {
        int i = w + 101;
        d = i % 128;
        if (i % 2 != 0) {
            Intrinsics.checkNotNullParameter(map, "");
            map.put("is_pc", Boolean.valueOf(this.getMonetizationNetwork.getApplicationContext().getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE")));
            int i2 = w + 99;
            d = i2 % 128;
            if (i2 % 2 == 0) {
                throw null;
            }
            return;
        }
        Intrinsics.checkNotNullParameter(map, "");
        map.put("is_pc", Boolean.valueOf(this.getMonetizationNetwork.getApplicationContext().getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE")));
        throw null;
    }

    public final void getMonetizationNetwork(@NotNull AFh1rSDK aFh1rSDK) {
        w = (d + 53) % 128;
        Intrinsics.checkNotNullParameter(aFh1rSDK, "");
        Map<String, Object> map = aFh1rSDK.AFAdRevenueData;
        if (aFh1rSDK.getMediationNetwork()) {
            String str = aFh1rSDK.component3;
            AFc1kSDK aFc1kSDK = this.copy;
            getMonetizationNetwork(aFh1rSDK, str, aFc1kSDK.getMediationNetwork, aFc1kSDK.getMonetizationNetwork);
            w = (d + 107) % 128;
        } else if (!(aFh1rSDK instanceof AFh1hSDK)) {
            int i = d + 7;
            w = i % 128;
            if (i % 2 != 0) {
                Intrinsics.checkNotNullExpressionValue(map, "");
                String str2 = aFh1rSDK.areAllFieldsValid;
                Intrinsics.checkNotNullExpressionValue(str2, "");
                getMediationNetwork(map, str2);
                int i2 = 48 / 0;
            } else {
                Intrinsics.checkNotNullExpressionValue(map, "");
                String str3 = aFh1rSDK.areAllFieldsValid;
                Intrinsics.checkNotNullExpressionValue(str3, "");
                getMediationNetwork(map, str3);
            }
        }
        if (CollectionsKt.t(AFe1mSDK.CONVERSION, AFe1mSDK.LAUNCH, AFe1mSDK.INAPP).contains(aFh1rSDK.getCurrencyIso4217Code())) {
            d = (w + 103) % 128;
            Intrinsics.checkNotNullExpressionValue(map, "");
            equals(map);
        }
        if (aFh1rSDK.getRevenue()) {
            d = (w + 15) % 128;
            Intrinsics.checkNotNullExpressionValue(map, "");
            areAllFieldsValid(map);
        }
        Intrinsics.checkNotNullExpressionValue(map, "");
        force(map);
        AFInAppEventType(map);
        getMediationNetwork(new Object[]{this, map}, -140518465, 140518471, System.identityHashCode(this));
        AFKeystoreWrapper(map);
        d(map);
        getMediationNetwork(map, aFh1rSDK.getMediationNetwork());
        e(map);
        afInfoLog(map);
        getRevenue(map, aFh1rSDK);
        map.put("af_events_api", AppEventsConstants.EVENT_PARAM_VALUE_YES);
    }

    @Nullable
    private String areAllFieldsValid() {
        String str = null;
        if (!(!this.component4.getMediationNetwork("INSTALL_STORE"))) {
            return this.component4.AFAdRevenueData("INSTALL_STORE", (String) null);
        }
        if (copydefault()) {
            int i = d + 123;
            w = i % 128;
            if (i % 2 == 0) {
                str = component2();
            } else {
                component2();
                throw null;
            }
        } else {
            d = (w + 67) % 128;
        }
        this.component4.getMediationNetwork("INSTALL_STORE", str);
        return str;
    }

    private static void component2(@NotNull Map<String, Object> map) {
        d = (w + 37) % 128;
        Intrinsics.checkNotNullParameter(map, "");
        Object[] objArr = new Object[1];
        a("", (int[]) null, (String) null, 127 - ExpandableListView.getPackedPositionType(0), objArr);
        map.put(((String) objArr[0]).intern(), Build.BRAND);
        map.put(ConstantHelper.LOG_DE, Build.DEVICE);
        map.put("product", Build.PRODUCT);
        map.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, String.valueOf(Build.VERSION.SDK_INT));
        map.put("model", Build.MODEL);
        map.put("deviceType", Build.TYPE);
        int i = w + 95;
        d = i % 128;
        if (i % 2 == 0) {
            throw null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: android.app.UiModeManager} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: android.app.UiModeManager} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: android.app.UiModeManager} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void copydefault(java.util.Map<java.lang.String, java.lang.Object> r4) {
        /*
            r3 = this;
            int r0 = d
            int r0 = r0 + 33
            int r0 = r0 % 128
            w = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            r2 = 0
            if (r0 < r1) goto L_0x002e
            int r0 = w
            int r0 = r0 + 97
            int r1 = r0 % 128
            d = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0025
            android.content.Context r0 = r3.getMonetizationNetwork
            java.lang.Object r0 = r0.getSystemService(android.app.UiModeManager.class)
            r2 = r0
            android.app.UiModeManager r2 = (android.app.UiModeManager) r2
            goto L_0x005a
        L_0x0025:
            android.content.Context r4 = r3.getMonetizationNetwork
            java.lang.Object r4 = r4.getSystemService(android.app.UiModeManager.class)
            android.app.UiModeManager r4 = (android.app.UiModeManager) r4
            throw r2
        L_0x002e:
            android.content.Context r0 = r3.getMonetizationNetwork
            java.lang.String r1 = "uimode"
            java.lang.Object r0 = r0.getSystemService(r1)
            boolean r1 = r0 instanceof android.app.UiModeManager
            if (r1 == 0) goto L_0x0052
            int r1 = w
            int r1 = r1 + 43
            int r2 = r1 % 128
            d = r2
            int r1 = r1 % 2
            if (r1 != 0) goto L_0x004e
            r2 = r0
            android.app.UiModeManager r2 = (android.app.UiModeManager) r2
            r0 = 55
            int r0 = r0 / 0
            goto L_0x005a
        L_0x004e:
            r2 = r0
            android.app.UiModeManager r2 = (android.app.UiModeManager) r2
            goto L_0x005a
        L_0x0052:
            int r0 = d
            int r0 = r0 + 69
            int r0 = r0 % 128
            w = r0
        L_0x005a:
            if (r2 == 0) goto L_0x006a
            int r0 = r2.getCurrentModeType()
            r1 = 4
            if (r0 != r1) goto L_0x006a
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.String r1 = "tv"
            r4.put(r1, r0)
        L_0x006a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1oSDK.copydefault(java.util.Map):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0044, code lost:
        if (r2 != null) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x006e, code lost:
        if (r2 != null) goto L_0x0070;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void component3(@org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.Object> r9) {
        /*
            r8 = this;
            r0 = 1
            r1 = 0
            int r2 = w
            int r2 = r2 + 63
            int r3 = r2 % 128
            d = r3
            int r2 = r2 % 2
            java.lang.String r3 = "onelinkVersion"
            java.lang.String r4 = "oneLinkSlug"
            r5 = -2080605426(0xffffffff83fc7b0e, float:-1.4839481E-36)
            r6 = 2080605438(0x7c0384fe, float:2.7315532E36)
            java.lang.String r7 = ""
            if (r2 != 0) goto L_0x0047
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r7)
            java.lang.Object[] r2 = new java.lang.Object[r0]
            r2[r1] = r8
            int r7 = java.lang.System.identityHashCode(r8)
            java.lang.Object r2 = getMediationNetwork(r2, r6, r5, r7)
            com.appsflyer.AppsFlyerProperties r2 = (com.appsflyer.AppsFlyerProperties) r2
            java.lang.String r2 = r2.getString(r4)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r8
            int r4 = java.lang.System.identityHashCode(r8)
            java.lang.Object r0 = getMediationNetwork(r0, r6, r5, r4)
            com.appsflyer.AppsFlyerProperties r0 = (com.appsflyer.AppsFlyerProperties) r0
            java.lang.String r0 = r0.getString(r3)
            r3 = 69
            int r3 = r3 / r1
            if (r2 == 0) goto L_0x007d
            goto L_0x0070
        L_0x0047:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r7)
            java.lang.Object[] r2 = new java.lang.Object[r0]
            r2[r1] = r8
            int r7 = java.lang.System.identityHashCode(r8)
            java.lang.Object r2 = getMediationNetwork(r2, r6, r5, r7)
            com.appsflyer.AppsFlyerProperties r2 = (com.appsflyer.AppsFlyerProperties) r2
            java.lang.String r2 = r2.getString(r4)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r8
            int r1 = java.lang.System.identityHashCode(r8)
            java.lang.Object r0 = getMediationNetwork(r0, r6, r5, r1)
            com.appsflyer.AppsFlyerProperties r0 = (com.appsflyer.AppsFlyerProperties) r0
            java.lang.String r0 = r0.getString(r3)
            if (r2 == 0) goto L_0x007d
        L_0x0070:
            int r1 = w
            int r1 = r1 + 121
            int r1 = r1 % 128
            d = r1
            java.lang.String r1 = "onelink_id"
            r9.put(r1, r2)
        L_0x007d:
            if (r0 == 0) goto L_0x0084
            java.lang.String r1 = "onelink_ver"
            r9.put(r1, r0)
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1oSDK.component3(java.util.Map):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x003e, code lost:
        if (((com.appsflyer.AppsFlyerProperties) getMediationNetwork(new java.lang.Object[]{r7}, 2080605438, -2080605426, java.lang.System.identityHashCode(r7))).getBoolean(com.appsflyer.AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false) != false) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0053, code lost:
        if (((com.appsflyer.AppsFlyerProperties) getMediationNetwork(new java.lang.Object[]{r7}, 2080605438, -2080605426, java.lang.System.identityHashCode(r7))).getBoolean(com.appsflyer.AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false) != false) goto L_0x0073;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean AFKeystoreWrapper() {
        /*
            r7 = this;
            r0 = 0
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r2[r0] = r7
            int r3 = java.lang.System.identityHashCode(r7)
            r4 = 2080605438(0x7c0384fe, float:2.7315532E36)
            r5 = -2080605426(0xffffffff83fc7b0e, float:-1.4839481E-36)
            java.lang.Object r2 = getMediationNetwork(r2, r4, r5, r3)
            com.appsflyer.AppsFlyerProperties r2 = (com.appsflyer.AppsFlyerProperties) r2
            java.lang.String r3 = "collectAndroidIdForceByUser"
            boolean r2 = r2.getBoolean(r3, r0)
            if (r2 != 0) goto L_0x0073
            int r2 = w
            int r2 = r2 + 23
            int r3 = r2 % 128
            d = r3
            int r2 = r2 % 2
            java.lang.String r3 = "collectIMEIForceByUser"
            if (r2 != 0) goto L_0x0041
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r2[r0] = r7
            int r6 = java.lang.System.identityHashCode(r7)
            java.lang.Object r2 = getMediationNetwork(r2, r4, r5, r6)
            com.appsflyer.AppsFlyerProperties r2 = (com.appsflyer.AppsFlyerProperties) r2
            boolean r2 = r2.getBoolean(r3, r0)
            if (r2 == 0) goto L_0x0056
            goto L_0x0073
        L_0x0041:
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r2[r0] = r7
            int r6 = java.lang.System.identityHashCode(r7)
            java.lang.Object r2 = getMediationNetwork(r2, r4, r5, r6)
            com.appsflyer.AppsFlyerProperties r2 = (com.appsflyer.AppsFlyerProperties) r2
            boolean r2 = r2.getBoolean(r3, r0)
            if (r2 == 0) goto L_0x0056
            goto L_0x0073
        L_0x0056:
            java.lang.Object[] r2 = new java.lang.Object[r0]
            long r3 = java.lang.System.currentTimeMillis()
            int r4 = (int) r3
            r3 = -631580017(0xffffffffda5ada8f, float:-1.54004632E16)
            r5 = 631580017(0x25a52571, float:2.8648309E-16)
            java.lang.Object r2 = com.appsflyer.internal.AFa1tSDK.getMonetizationNetwork(r2, r3, r5, r4)
            com.appsflyer.internal.AFa1tSDK r2 = (com.appsflyer.internal.AFa1tSDK) r2
            android.content.Context r2 = r7.getMonetizationNetwork
            boolean r2 = com.appsflyer.internal.AFa1tSDK.getCurrencyIso4217Code((android.content.Context) r2)
            if (r2 != 0) goto L_0x0072
            goto L_0x007b
        L_0x0072:
            return r0
        L_0x0073:
            int r0 = d
            int r0 = r0 + 115
            int r0 = r0 % 128
            w = r0
        L_0x007b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1oSDK.AFKeystoreWrapper():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
        if (r0 != false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003c, code lost:
        if (r4 != null) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void AFInAppEventParameterName(@org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.Object> r10) {
        /*
            r9 = this;
            r0 = 1
            r1 = 0
            r2 = 2
            java.lang.String r3 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r3)
            com.appsflyer.internal.AFc1pSDK r4 = r9.component3
            java.lang.String r4 = r4.component2()
            com.appsflyer.internal.AFc1qSDK r5 = r9.component4
            java.lang.Object[] r6 = new java.lang.Object[r2]
            r6[r1] = r5
            r6[r0] = r4
            long r7 = java.lang.System.currentTimeMillis()
            int r5 = (int) r7
            r7 = 381318279(0x16ba7487, float:3.012346E-25)
            r8 = -381318268(0xffffffffe9458b84, float:-1.4926077E25)
            java.lang.Object r5 = getMediationNetwork(r6, r7, r8, r5)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x0031
            boolean r6 = r5.equals(r4)
            if (r6 != 0) goto L_0x0031
            r6 = 1
            goto L_0x0032
        L_0x0031:
            r6 = 0
        L_0x0032:
            if (r5 != 0) goto L_0x003f
            int r5 = w
            int r5 = r5 + 67
            int r5 = r5 % 128
            d = r5
            if (r4 == 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r0 = 0
        L_0x0040:
            if (r6 != 0) goto L_0x004c
            int r1 = w
            int r1 = r1 + 9
            int r1 = r1 % 128
            d = r1
            if (r0 == 0) goto L_0x0051
        L_0x004c:
            java.lang.String r0 = "af_latestchannel"
            r10.put(r0, r4)
        L_0x0051:
            java.lang.String r0 = r9.areAllFieldsValid()
            if (r0 == 0) goto L_0x0089
            int r1 = w
            int r1 = r1 + 101
            int r4 = r1 % 128
            d = r4
            int r1 = r1 % r2
            java.lang.String r2 = "af_installstore"
            if (r1 == 0) goto L_0x0076
            java.util.Locale r1 = java.util.Locale.getDefault()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            java.lang.String r0 = r0.toLowerCase(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            r10.put(r2, r0)
            goto L_0x0089
        L_0x0076:
            java.util.Locale r1 = java.util.Locale.getDefault()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            java.lang.String r0 = r0.toLowerCase(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            r10.put(r2, r0)
            r10 = 0
            throw r10
        L_0x0089:
            java.lang.String r0 = r9.copy()
            if (r0 == 0) goto L_0x00a2
            java.util.Locale r1 = java.util.Locale.getDefault()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            java.lang.String r0 = r0.toLowerCase(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            java.lang.String r1 = "af_preinstall_name"
            r10.put(r1, r0)
        L_0x00a2:
            java.lang.String r0 = r9.component2()
            if (r0 == 0) goto L_0x00bb
            java.util.Locale r1 = java.util.Locale.getDefault()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            java.lang.String r0 = r0.toLowerCase(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            java.lang.String r1 = "af_currentstore"
            r10.put(r1, r0)
        L_0x00bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1oSDK.AFInAppEventParameterName(java.util.Map):void");
    }

    private static /* synthetic */ Object areAllFieldsValid(Object[] objArr) {
        AFc1qSDK aFc1qSDK = objArr[0];
        String str = objArr[1];
        w = (d + 1) % 128;
        String AFAdRevenueData2 = aFc1qSDK.AFAdRevenueData("CACHED_CHANNEL", (String) null);
        if (AFAdRevenueData2 != null) {
            int i = d + 27;
            w = i % 128;
            if (i % 2 == 0) {
                return AFAdRevenueData2;
            }
            throw null;
        }
        aFc1qSDK.getMediationNetwork("CACHED_CHANNEL", str);
        d = (w + 19) % 128;
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002a, code lost:
        if (r8.length() == 0) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0031, code lost:
        if (r8.length() == 0) goto L_0x003f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static /* synthetic */ java.lang.Object component1(java.lang.Object[] r8) {
        /*
            r0 = 0
            r1 = r8[r0]
            com.appsflyer.internal.AFg1oSDK r1 = (com.appsflyer.internal.AFg1oSDK) r1
            r2 = 1
            r3 = r8[r2]
            java.util.Map r3 = (java.util.Map) r3
            r4 = 2
            r8 = r8[r4]
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r5 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r5)
            java.lang.String r5 = "referrer"
            if (r8 == 0) goto L_0x003f
            int r6 = w
            int r6 = r6 + 53
            int r7 = r6 % 128
            d = r7
            int r6 = r6 % r4
            if (r6 != 0) goto L_0x002d
            int r6 = r8.length()
            r7 = 87
            int r7 = r7 / r0
            if (r6 != 0) goto L_0x0034
            goto L_0x003f
        L_0x002d:
            int r6 = r8.length()
            if (r6 != 0) goto L_0x0034
            goto L_0x003f
        L_0x0034:
            r3.put(r5, r8)
            int r8 = w
            int r8 = r8 + 103
            int r8 = r8 % 128
            d = r8
        L_0x003f:
            com.appsflyer.internal.AFc1qSDK r8 = r1.component4
            java.lang.String r6 = "extraReferrers"
            r7 = 0
            java.lang.String r8 = r8.AFAdRevenueData((java.lang.String) r6, (java.lang.String) r7)
            if (r8 == 0) goto L_0x004d
            r3.put(r6, r8)
        L_0x004d:
            java.lang.Object[] r8 = new java.lang.Object[r2]
            r8[r0] = r1
            int r0 = java.lang.System.identityHashCode(r1)
            r2 = 2080605438(0x7c0384fe, float:2.7315532E36)
            r6 = -2080605426(0xffffffff83fc7b0e, float:-1.4839481E-36)
            java.lang.Object r8 = getMediationNetwork(r8, r2, r6, r0)
            com.appsflyer.AppsFlyerProperties r8 = (com.appsflyer.AppsFlyerProperties) r8
            com.appsflyer.internal.AFc1qSDK r0 = r1.component4
            java.lang.String r8 = r8.getReferrer(r0)
            if (r8 == 0) goto L_0x0081
            int r0 = r8.length()
            if (r0 != 0) goto L_0x0070
            goto L_0x0081
        L_0x0070:
            java.lang.Object r0 = r3.get(r5)
            if (r0 != 0) goto L_0x0081
            int r0 = w
            int r0 = r0 + 33
            int r0 = r0 % 128
            d = r0
            r3.put(r5, r8)
        L_0x0081:
            int r8 = d
            int r8 = r8 + 15
            int r0 = r8 % 128
            w = r0
            int r8 = r8 % r4
            if (r8 != 0) goto L_0x008d
            return r7
        L_0x008d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1oSDK.component1(java.lang.Object[]):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0026, code lost:
        if (r0 > 1) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x003f, code lost:
        if (r0 > 0) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0051, code lost:
        r0 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void copy(@org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.Object> r9) {
        /*
            r8 = this;
            int r0 = d
            int r0 = r0 + 97
            int r1 = r0 % 128
            w = r1
            int r0 = r0 % 2
            java.lang.String r1 = ""
            java.lang.String r2 = "AppsFlyerTimePassedSincePrevLaunch"
            if (r0 == 0) goto L_0x0029
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            com.appsflyer.internal.AFc1qSDK r0 = r8.component4
            r3 = 1
            long r0 = r0.getCurrencyIso4217Code((java.lang.String) r2, (long) r3)
            long r5 = java.lang.System.currentTimeMillis()
            com.appsflyer.internal.AFc1qSDK r7 = r8.component4
            r7.getMonetizationNetwork(r2, r5)
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x0051
            goto L_0x0041
        L_0x0029:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            com.appsflyer.internal.AFc1qSDK r0 = r8.component4
            r3 = 0
            long r0 = r0.getCurrencyIso4217Code((java.lang.String) r2, (long) r3)
            long r5 = java.lang.System.currentTimeMillis()
            com.appsflyer.internal.AFc1qSDK r7 = r8.component4
            r7.getMonetizationNetwork(r2, r5)
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x0051
        L_0x0041:
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r5 = r5 - r0
            long r0 = r2.toSeconds(r5)
            int r2 = d
            int r2 = r2 + 81
            int r2 = r2 % 128
            w = r2
            goto L_0x0053
        L_0x0051:
            r0 = -1
        L_0x0053:
            java.lang.String r2 = "timepassedsincelastlaunch"
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r9.put(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1oSDK.copy(java.util.Map):void");
    }

    private final String AFInAppEventType() {
        return (String) getMediationNetwork(new Object[]{this}, -1713193940, 1713193943, System.identityHashCode(this));
    }

    public final void getRevenue(@NotNull Map<String, Object> map, int i, int i2) {
        Intrinsics.checkNotNullParameter(map, "");
        map.put("counter", String.valueOf(i));
        map.put("iaecounter", String.valueOf(i2));
        boolean z = false;
        if (!equals()) {
            int i3 = d + 19;
            w = i3 % 128;
            if (i3 % 2 == 0) {
                z = true;
            }
        }
        map.put("isFirstCall", String.valueOf(z));
        w = (d + 107) % 128;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0061 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051 A[SYNTHETIC, Splitter:B:19:0x0051] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:26:0x0061=Splitter:B:26:0x0061, B:16:0x0048=Splitter:B:16:0x0048} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static /* synthetic */ java.lang.Object getRevenue(java.lang.Object[] r7) {
        /*
            java.lang.String r0 = "PreInstall file wasn't found: "
            r1 = 0
            r1 = r7[r1]
            java.io.File r1 = (java.io.File) r1
            r2 = 1
            r7 = r7[r2]
            java.lang.String r7 = (java.lang.String) r7
            r2 = 0
            if (r1 != 0) goto L_0x0018
            int r7 = w
            int r7 = r7 + 43
            int r7 = r7 % 128
            d = r7
            return r2
        L_0x0018:
            java.util.Properties r3 = new java.util.Properties     // Catch:{ FileNotFoundException -> 0x0060, all -> 0x0046 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0060, all -> 0x0046 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x0060, all -> 0x0046 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0060, all -> 0x0046 }
            r5.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0060, all -> 0x0046 }
            java.nio.charset.Charset r6 = java.nio.charset.Charset.defaultCharset()     // Catch:{ FileNotFoundException -> 0x0060, all -> 0x0046 }
            r4.<init>(r5, r6)     // Catch:{ FileNotFoundException -> 0x0060, all -> 0x0046 }
            r3.load(r4)     // Catch:{ FileNotFoundException -> 0x0061, all -> 0x0044 }
            java.lang.String r5 = "Found PreInstall property!"
            com.appsflyer.AFLogger.afInfoLog(r5)     // Catch:{ FileNotFoundException -> 0x0061, all -> 0x0044 }
            java.lang.String r7 = r3.getProperty(r7)     // Catch:{ FileNotFoundException -> 0x0061, all -> 0x0044 }
            r4.close()     // Catch:{ all -> 0x003b }
            goto L_0x0043
        L_0x003b:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r1, r0)
        L_0x0043:
            return r7
        L_0x0044:
            r7 = move-exception
            goto L_0x0048
        L_0x0046:
            r7 = move-exception
            r4 = r2
        L_0x0048:
            java.lang.String r0 = r7.getMessage()     // Catch:{ all -> 0x005e }
            com.appsflyer.AFLogger.afErrorLog(r0, r7)     // Catch:{ all -> 0x005e }
            if (r4 == 0) goto L_0x0081
            r4.close()     // Catch:{ all -> 0x0055 }
            goto L_0x0081
        L_0x0055:
            r7 = move-exception
            java.lang.String r0 = r7.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r7)
            goto L_0x0081
        L_0x005e:
            r7 = move-exception
            goto L_0x0082
        L_0x0060:
            r4 = r2
        L_0x0061:
            java.lang.String r7 = r1.getAbsolutePath()     // Catch:{ all -> 0x005e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x005e }
            r1.<init>(r0)     // Catch:{ all -> 0x005e }
            r1.append(r7)     // Catch:{ all -> 0x005e }
            java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x005e }
            com.appsflyer.AFLogger.afDebugLog(r7)     // Catch:{ all -> 0x005e }
            if (r4 == 0) goto L_0x0081
            r4.close()     // Catch:{ all -> 0x0055 }
            int r7 = w
            int r7 = r7 + 31
            int r7 = r7 % 128
            d = r7
        L_0x0081:
            return r2
        L_0x0082:
            if (r4 == 0) goto L_0x0098
            r4.close()     // Catch:{ all -> 0x0090 }
            int r0 = d
            int r0 = r0 + 91
            int r0 = r0 % 128
            w = r0
            goto L_0x0098
        L_0x0090:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r1, r0)
        L_0x0098:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1oSDK.getRevenue(java.lang.Object[]):java.lang.Object");
    }

    @Nullable
    public final Long getCurrencyIso4217Code() {
        int i = w + 43;
        int i2 = i % 128;
        d = i2;
        if (i % 2 != 0) {
            Context context = this.toString.getMonetizationNetwork;
            if (context == null) {
                return null;
            }
            int i3 = i2 + 49;
            w = i3 % 128;
            if (i3 % 2 == 0) {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    String packageName = context.getPackageName();
                    Intrinsics.checkNotNullExpressionValue(packageName, "");
                    PackageInfo packageInfo = (PackageInfo) getMediationNetwork(new Object[]{packageManager, packageName}, 1014234820, -1014234818, (int) System.currentTimeMillis());
                    if (packageInfo != null) {
                        Long valueOf = Long.valueOf(packageInfo.firstInstallTime);
                        d = (w + 47) % 128;
                        return valueOf;
                    }
                }
                int i4 = d + 51;
                w = i4 % 128;
                if (i4 % 2 != 0) {
                    int i5 = 27 / 0;
                }
                return null;
            }
            context.getPackageManager();
            throw null;
        }
        Context context2 = this.toString.getMonetizationNetwork;
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0049, code lost:
        if (r1.versionCode > r10.component4.AFAdRevenueData("versionCode", 0)) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void getMonetizationNetwork(java.util.Map<java.lang.String, java.lang.Object> r11) {
        /*
            r10 = this;
            java.lang.String r0 = ""
            int r1 = w
            int r1 = r1 + 41
            int r2 = r1 % 128
            d = r2
            int r1 = r1 % 2
            java.lang.String r2 = "versionCode"
            r3 = 0
            r4 = 1
            if (r1 != 0) goto L_0x0031
            android.content.Context r1 = r10.getMonetizationNetwork     // Catch:{ all -> 0x002e }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ all -> 0x002e }
            android.content.Context r5 = r10.getMonetizationNetwork     // Catch:{ all -> 0x002e }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ all -> 0x002e }
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r5, r4)     // Catch:{ all -> 0x002e }
            com.appsflyer.internal.AFc1qSDK r5 = r10.component4     // Catch:{ all -> 0x002e }
            int r5 = r5.AFAdRevenueData((java.lang.String) r2, (int) r4)     // Catch:{ all -> 0x002e }
            int r6 = r1.versionCode     // Catch:{ all -> 0x002e }
            if (r6 <= r5) goto L_0x0052
            goto L_0x004b
        L_0x002e:
            r11 = move-exception
            goto L_0x00db
        L_0x0031:
            android.content.Context r1 = r10.getMonetizationNetwork     // Catch:{ all -> 0x002e }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ all -> 0x002e }
            android.content.Context r5 = r10.getMonetizationNetwork     // Catch:{ all -> 0x002e }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ all -> 0x002e }
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r5, r3)     // Catch:{ all -> 0x002e }
            com.appsflyer.internal.AFc1qSDK r5 = r10.component4     // Catch:{ all -> 0x002e }
            int r5 = r5.AFAdRevenueData((java.lang.String) r2, (int) r3)     // Catch:{ all -> 0x002e }
            int r6 = r1.versionCode     // Catch:{ all -> 0x002e }
            if (r6 <= r5) goto L_0x0052
        L_0x004b:
            com.appsflyer.internal.AFc1qSDK r5 = r10.component4     // Catch:{ all -> 0x002e }
            int r6 = r1.versionCode     // Catch:{ all -> 0x002e }
            r5.getMediationNetwork((java.lang.String) r2, (int) r6)     // Catch:{ all -> 0x002e }
        L_0x0052:
            java.lang.String r2 = "app_version_code"
            int r5 = r1.versionCode     // Catch:{ all -> 0x002e }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x002e }
            r11.put(r2, r5)     // Catch:{ all -> 0x002e }
            java.lang.String r2 = "app_version_name"
            com.appsflyer.internal.AFc1pSDK r5 = r10.component3     // Catch:{ all -> 0x002e }
            com.appsflyer.internal.AFc1iSDK r5 = r5.getRevenue     // Catch:{ all -> 0x002e }
            android.content.Context r5 = r5.getMonetizationNetwork     // Catch:{ all -> 0x002e }
            java.lang.String r6 = r5.getPackageName()     // Catch:{ all -> 0x002e }
            java.lang.String r5 = com.appsflyer.internal.AFj1iSDK.getMediationNetwork(r5, r6)     // Catch:{ all -> 0x002e }
            r11.put(r2, r5)     // Catch:{ all -> 0x002e }
            java.lang.String r2 = "targetSDKver"
            com.appsflyer.internal.AFc1pSDK r5 = r10.component3     // Catch:{ all -> 0x002e }
            com.appsflyer.internal.AFc1iSDK r5 = r5.getRevenue     // Catch:{ all -> 0x002e }
            android.content.Context r5 = r5.getMonetizationNetwork     // Catch:{ all -> 0x002e }
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo()     // Catch:{ all -> 0x002e }
            int r5 = r5.targetSdkVersion     // Catch:{ all -> 0x002e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x002e }
            r11.put(r2, r5)     // Catch:{ all -> 0x002e }
            long r5 = r1.firstInstallTime     // Catch:{ all -> 0x002e }
            long r1 = r1.lastUpdateTime     // Catch:{ all -> 0x002e }
            java.lang.String r7 = "date1"
            java.text.SimpleDateFormat r8 = r10.getMonetizationNetwork()     // Catch:{ all -> 0x002e }
            java.util.Date r9 = new java.util.Date     // Catch:{ all -> 0x002e }
            r9.<init>(r5)     // Catch:{ all -> 0x002e }
            java.lang.String r5 = r8.format(r9)     // Catch:{ all -> 0x002e }
            r11.put(r7, r5)     // Catch:{ all -> 0x002e }
            java.lang.String r5 = "date2"
            java.text.SimpleDateFormat r6 = r10.getMonetizationNetwork()     // Catch:{ all -> 0x002e }
            java.util.Date r7 = new java.util.Date     // Catch:{ all -> 0x002e }
            r7.<init>(r1)     // Catch:{ all -> 0x002e }
            java.lang.String r1 = r6.format(r7)     // Catch:{ all -> 0x002e }
            r11.put(r5, r1)     // Catch:{ all -> 0x002e }
            java.lang.String r1 = ""
            int r2 = android.text.TextUtils.getTrimmedLength(r0)     // Catch:{ all -> 0x002e }
            int r2 = 127 - r2
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x002e }
            r6 = 0
            a(r1, r6, r6, r2, r5)     // Catch:{ all -> 0x002e }
            r1 = r5[r3]     // Catch:{ all -> 0x002e }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x002e }
            java.lang.String r1 = r1.intern()     // Catch:{ all -> 0x002e }
            java.text.SimpleDateFormat r2 = r10.getMonetizationNetwork()     // Catch:{ all -> 0x002e }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)     // Catch:{ all -> 0x002e }
            java.lang.String r0 = r10.getMediationNetwork((java.text.SimpleDateFormat) r2)     // Catch:{ all -> 0x002e }
            r11.put(r1, r0)     // Catch:{ all -> 0x002e }
            int r11 = d
            int r11 = r11 + 47
            int r11 = r11 % 128
            w = r11
            return
        L_0x00db:
            java.lang.String r0 = "Exception while collecting app version data "
            com.appsflyer.AFLogger.afErrorLog(r0, r11, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1oSDK.getMonetizationNetwork(java.util.Map):void");
    }

    private final String AFAdRevenueData(String str) {
        int i = d + 5;
        w = i % 128;
        if (i % 2 == 0) {
            return this.component3.getCurrencyIso4217Code(str);
        }
        int i2 = 38 / 0;
        return this.component3.getCurrencyIso4217Code(str);
    }

    public final void AFAdRevenueData(@NotNull Map<String, Object> map) {
        getMediationNetwork(new Object[]{this, map}, -1412383531, 1412383531, System.identityHashCode(this));
    }

    public final void getMediationNetwork(@NotNull AFh1rSDK aFh1rSDK) {
        d = (w + 11) % 128;
        Intrinsics.checkNotNullParameter(aFh1rSDK, "");
        Map<String, Object> map = aFh1rSDK.AFAdRevenueData;
        Intrinsics.checkNotNullExpressionValue(map, "");
        getMediationNetwork(map);
        Map<String, Object> map2 = aFh1rSDK.AFAdRevenueData;
        Intrinsics.checkNotNullExpressionValue(map2, "");
        getMonetizationNetwork(map2);
        Map<String, Object> map3 = aFh1rSDK.AFAdRevenueData;
        Intrinsics.checkNotNullExpressionValue(map3, "");
        AFInAppEventParameterName(map3);
        Map<String, Object> map4 = aFh1rSDK.AFAdRevenueData;
        Intrinsics.checkNotNullExpressionValue(map4, "");
        unregisterClient(map4);
        Map<String, Object> map5 = aFh1rSDK.AFAdRevenueData;
        Intrinsics.checkNotNullExpressionValue(map5, "");
        afDebugLog(map5);
        if (getMediationNetwork().contains(aFh1rSDK.getCurrencyIso4217Code())) {
            d = (w + 125) % 128;
            Map<String, Object> map6 = aFh1rSDK.AFAdRevenueData;
            Intrinsics.checkNotNullExpressionValue(map6, "");
            afErrorLog(map6);
            d = (w + 17) % 128;
        }
    }

    public final long AFAdRevenueData() {
        return ((Long) getMediationNetwork(new Object[]{this}, 1094427935, -1094427925, System.identityHashCode(this))).longValue();
    }

    public final void AFAdRevenueData(@NotNull AFh1rSDK aFh1rSDK) {
        getMediationNetwork(new Object[]{this, aFh1rSDK}, 840096269, -840096265, System.identityHashCode(this));
    }

    private void getCurrencyIso4217Code(@NotNull Map<String, Object> map, boolean z) {
        Intrinsics.checkNotNullParameter(map, "");
        HashMap hashMap = new HashMap();
        hashMap.put("cpu_abi", getMediationNetwork("ro.product.cpu.abi"));
        hashMap.put("cpu_abi2", getMediationNetwork("ro.product.cpu.abi2"));
        hashMap.put("arch", getMediationNetwork("os.arch"));
        hashMap.put("build_display_id", getMediationNetwork("ro.build.display.id"));
        if (z) {
            w = (d + 13) % 128;
            component4(hashMap);
            if (this.component3.getMonetizationNetwork.AFAdRevenueData("appsFlyerCount", 0) <= 2) {
                hashMap.putAll(this.AFAdRevenueData.AFAdRevenueData());
            }
        }
        hashMap.put("dim", this.component2.AFAdRevenueData(this.getMonetizationNetwork));
        map.put("deviceData", hashMap);
        d = (w + 1) % 128;
    }

    private static void getRevenue(@NotNull Map<String, Object> map, @NotNull AFh1rSDK aFh1rSDK) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(aFh1rSDK, "");
        String str = aFh1rSDK.areAllFieldsValid;
        if (str != null) {
            map.put("eventName", str);
            Map map2 = aFh1rSDK.getMonetizationNetwork;
            if (map2 == null) {
                map2 = new HashMap();
            }
            map.put("eventValue", new JSONObject(map2).toString());
        }
    }

    private void getRevenue(@NotNull Map<String, Object> map, @Nullable String str) {
        getMediationNetwork(new Object[]{this, map, str}, 1763970144, -1763970135, System.identityHashCode(this));
    }

    public final void getRevenue(@NotNull Map<String, Object> map) {
        getMediationNetwork(new Object[]{this, map}, -1435534785, 1435534790, System.identityHashCode(this));
    }

    private final AppsFlyerProperties getRevenue() {
        return (AppsFlyerProperties) getMediationNetwork(new Object[]{this}, 2080605438, -2080605426, System.identityHashCode(this));
    }

    private static List<AFe1mSDK> getMediationNetwork() {
        w = (d + 109) % 128;
        List<AFe1mSDK> t = CollectionsKt.t(AFe1mSDK.CONVERSION, AFe1mSDK.LAUNCH, AFe1mSDK.INAPP, AFe1mSDK.MANUAL_PURCHASE_VALIDATION, AFe1mSDK.ARS_VALIDATE, AFe1mSDK.PURCHASE_VALIDATE, AFe1mSDK.ADREVENUE);
        int i = w + 75;
        d = i % 128;
        if (i % 2 != 0) {
            return t;
        }
        throw null;
    }

    public final void getCurrencyIso4217Code(@NotNull Map<String, Object> map) {
        Object obj;
        int i = w + 115;
        d = i % 128;
        if (i % 2 != 0) {
            Intrinsics.checkNotNullParameter(map, "");
            String str = this.copy.getCurrencyIso4217Code;
            if (str != null) {
                d = (w + 39) % 128;
                if (map.get("af_deeplink") != null) {
                    int i2 = w + 97;
                    d = i2 % 128;
                    if (i2 % 2 != 0) {
                        AFLogger.afDebugLog("Skip 'af' payload as deeplink was found by path");
                    } else {
                        AFLogger.afDebugLog("Skip 'af' payload as deeplink was found by path");
                        throw null;
                    }
                } else {
                    try {
                        Result.Companion companion = Result.Companion;
                        JSONObject jSONObject = new JSONObject(str);
                        jSONObject.put("isPush", "true");
                        map.put("af_deeplink", jSONObject.toString());
                        obj = Result.m16constructorimpl(Unit.f696a);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.m16constructorimpl(ResultKt.a(th));
                    }
                    Throwable r6 = Result.m19exceptionOrNullimpl(obj);
                    if (r6 != null) {
                        AFg1gSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.GENERAL, "Exception while trying to create JSONObject from pushPayload", r6, false, false, false, false, 120, (Object) null);
                    } else {
                        w = (d + 119) % 128;
                    }
                    Result.m15boximpl(obj);
                }
            }
            this.copy.getCurrencyIso4217Code = null;
            return;
        }
        Intrinsics.checkNotNullParameter(map, "");
        String str2 = this.copy.getCurrencyIso4217Code;
        throw null;
    }

    private final void getMediationNetwork(Map<String, Object> map) {
        try {
            long j = this.getMonetizationNetwork.getPackageManager().getPackageInfo(this.getMonetizationNetwork.getPackageName(), 0).firstInstallTime;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            map.put("installDate", simpleDateFormat.format(new Date(j)));
            int i = d + 111;
            w = i % 128;
            if (i % 2 != 0) {
                int i2 = 79 / 0;
            }
        } catch (Exception e) {
            AFLogger.afErrorLog("Exception while collecting install date. ", e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x002d, code lost:
        if (r7.length() == 0) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getMonetizationNetwork(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r2[r0] = r6
            int r3 = java.lang.System.identityHashCode(r6)
            r4 = 2080605438(0x7c0384fe, float:2.7315532E36)
            r5 = -2080605426(0xffffffff83fc7b0e, float:-1.4839481E-36)
            java.lang.Object r2 = getMediationNetwork(r2, r4, r5, r3)
            com.appsflyer.AppsFlyerProperties r2 = (com.appsflyer.AppsFlyerProperties) r2
            java.lang.String r3 = "collectAndroidId"
            boolean r0 = r2.getBoolean(r3, r0)
            if (r0 == r1) goto L_0x001f
            goto L_0x0030
        L_0x001f:
            if (r7 == 0) goto L_0x0033
            int r0 = w
            int r0 = r0 + 119
            int r0 = r0 % 128
            d = r0
            int r0 = r7.length()
            if (r0 != 0) goto L_0x0030
            goto L_0x0033
        L_0x0030:
            if (r7 == 0) goto L_0x004e
            goto L_0x004f
        L_0x0033:
            boolean r7 = r6.AFKeystoreWrapper()
            if (r7 == 0) goto L_0x004e
            int r7 = d
            int r7 = r7 + 35
            int r7 = r7 % 128
            w = r7
            java.lang.String r7 = r6.AFInAppEventParameterName()
            int r0 = d
            int r0 = r0 + 81
            int r0 = r0 % 128
            w = r0
            goto L_0x004f
        L_0x004e:
            r7 = 0
        L_0x004f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1oSDK.getMonetizationNetwork(java.lang.String):java.lang.String");
    }

    private void getMediationNetwork(@NotNull Map<String, Object> map, boolean z) {
        d = (w + 29) % 128;
        Intrinsics.checkNotNullParameter(map, "");
        map.put("platformextension", this.getCurrencyIso4217Code);
        if (z) {
            w = (d + 83) % 128;
            map.put("platform_extension_v2", this.getRevenue.getMediationNetwork());
        }
        d = (w + 5) % 128;
    }

    private void getMonetizationNetwork(@NotNull AFh1rSDK aFh1rSDK, @Nullable String str, @Nullable String str2, @Nullable AFb1qSDK aFb1qSDK) {
        w = (d + 121) % 128;
        Intrinsics.checkNotNullParameter(aFh1rSDK, "");
        Map<String, Object> map = aFh1rSDK.AFAdRevenueData;
        if (aFh1rSDK.getCurrencyIso4217Code() == AFe1mSDK.CONVERSION) {
            int i = d + 107;
            w = i % 128;
            if (i % 2 != 0) {
                Intrinsics.checkNotNullExpressionValue(map, "");
                toString(map);
                copydefault(map);
                hashCode(map);
                AFa1zSDK.AFAdRevenueData(this.toString, this.component3);
                int i2 = 38 / 0;
            } else {
                Intrinsics.checkNotNullExpressionValue(map, "");
                toString(map);
                copydefault(map);
                hashCode(map);
                AFa1zSDK.AFAdRevenueData(this.toString, this.component3);
            }
        }
        Intrinsics.checkNotNullExpressionValue(map, "");
        copy(map);
        component3(map);
        component1((Map<String, ? extends Object>) map);
        getMonetizationNetwork(map, str2);
        getMediationNetwork(new Object[]{this, map, str}, 1763970144, -1763970135, System.identityHashCode(this));
        registerClient(map);
        if (aFb1qSDK != null) {
            aFb1qSDK.getRevenue(map);
        }
    }

    private static /* synthetic */ Object getMediationNetwork(Object[] objArr) {
        AFg1oSDK aFg1oSDK = objArr[0];
        Map map = objArr[1];
        Intrinsics.checkNotNullParameter(map, "");
        AFi1pSDK aFi1pSDK = aFg1oSDK.component1.getMediationNetwork;
        AFi1rSDK mediationNetwork = aFi1pSDK != null ? aFi1pSDK.getMediationNetwork() : null;
        if (mediationNetwork != null) {
            map.put("network", mediationNetwork.getCurrencyIso4217Code);
            map.put("ivc", Boolean.valueOf(mediationNetwork.getMediationNetwork()));
            if (!((AppsFlyerProperties) getMediationNetwork(new Object[]{aFg1oSDK}, 2080605438, -2080605426, System.identityHashCode(aFg1oSDK))).getBoolean(AppsFlyerProperties.DISABLE_NETWORK_DATA, false)) {
                int i = (w + 109) % 128;
                d = i;
                String str = mediationNetwork.AFAdRevenueData;
                if (str != null) {
                    int i2 = i + 115;
                    w = i2 % 128;
                    if (i2 % 2 != 0) {
                        map.put("operator", str);
                        int i3 = 74 / 0;
                    } else {
                        map.put("operator", str);
                    }
                }
                String str2 = mediationNetwork.getRevenue;
                if (str2 != null) {
                    int i4 = w + 105;
                    d = i4 % 128;
                    if (i4 % 2 != 0) {
                        map.put("carrier", str2);
                        return null;
                    }
                    map.put("carrier", str2);
                    throw null;
                }
            }
        }
        return null;
    }

    private void getCurrencyIso4217Code(@NotNull Map<String, Object> map, @Nullable String str) {
        boolean z = false;
        Intrinsics.checkNotNullParameter(map, "");
        if (((AppsFlyerProperties) getMediationNetwork(new Object[]{this}, 2080605438, -2080605426, System.identityHashCode(this))).getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            int i = d + 89;
            w = i % 128;
            if (i % 2 != 0) {
                map.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
                int i2 = 33 / 0;
                return;
            }
            map.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
            return;
        }
        AFf1gSDK aFf1gSDK = this.equals;
        String str2 = (String) AFf1gSDK.getCurrencyIso4217Code(new Object[]{aFf1gSDK, this.component4}, -1198101809, 1198101809, System.identityHashCode(aFf1gSDK));
        if (str2 == null || str2.length() == 0) {
            z = true;
        }
        if (!z) {
            map.put("imei", str2);
        }
        String monetizationNetwork = getMonetizationNetwork(str);
        if (monetizationNetwork != null) {
            this.component4.getMediationNetwork("androidIdCached", monetizationNetwork);
            map.put("android_id", monetizationNetwork);
        } else {
            AFLogger.afInfoLog("Android ID was not collected.");
            d = (w + 39) % 128;
        }
        AFb1mSDK mediationNetwork = AFb1jSDK.getMediationNetwork(this.getMonetizationNetwork);
        if (mediationNetwork != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Boolean bool = mediationNetwork.AFAdRevenueData;
            Intrinsics.checkNotNullExpressionValue(bool, "");
            linkedHashMap.put("isManual", bool);
            String str3 = mediationNetwork.getMonetizationNetwork;
            Intrinsics.checkNotNullExpressionValue(str3, "");
            linkedHashMap.put("val", str3);
            Boolean bool2 = mediationNetwork.getMediationNetwork;
            if (bool2 != null) {
                linkedHashMap.put("isLat", bool2);
            }
            map.put("oaid", linkedHashMap);
        }
    }

    private void getMediationNetwork(@NotNull Map<String, Object> map, @NotNull String str) {
        int i = d + 7;
        w = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(map, "");
            Intrinsics.checkNotNullParameter(str, "");
            try {
                String AFAdRevenueData2 = this.component4.AFAdRevenueData("prev_event_name", (String) null);
                if (AFAdRevenueData2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("prev_event_timestamp", this.component4.getCurrencyIso4217Code("prev_event_timestamp", -1));
                    jSONObject.put("prev_event_name", AFAdRevenueData2);
                    map.put("prev_event", jSONObject);
                    w = (d + 27) % 128;
                }
                this.component4.getMediationNetwork("prev_event_name", str);
                this.component4.getMonetizationNetwork("prev_event_timestamp", System.currentTimeMillis());
            } catch (Exception e) {
                AFLogger.afErrorLog("Error while processing previous event.", e);
            }
        } else {
            Intrinsics.checkNotNullParameter(map, "");
            Intrinsics.checkNotNullParameter(str, "");
            this.component4.AFAdRevenueData("prev_event_name", (String) null);
            throw null;
        }
    }

    private static void getMonetizationNetwork(@NotNull Map<String, Object> map, @Nullable String str) {
        int i = d + 117;
        w = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(map, "");
            if (str != null) {
                d = (w + 99) % 128;
                map.put(PlaceFields.PHONE, str);
            }
            w = (d + 15) % 128;
            return;
        }
        Intrinsics.checkNotNullParameter(map, "");
        throw null;
    }

    private static /* synthetic */ Object getMonetizationNetwork(Object[] objArr) {
        AFg1oSDK aFg1oSDK = objArr[0];
        Map map = objArr[1];
        int i = d + 65;
        w = i % 128;
        if (i % 2 != 0) {
            Intrinsics.checkNotNullParameter(map, "");
            map.putAll(aFg1oSDK.hashCode.getCurrencyIso4217Code());
            int i2 = 13 / 0;
        } else {
            Intrinsics.checkNotNullParameter(map, "");
            map.putAll(aFg1oSDK.hashCode.getCurrencyIso4217Code());
        }
        d = (w + 87) % 128;
        return null;
    }

    private static File getCurrencyIso4217Code(String str) {
        int i = (w + 97) % 128;
        d = i;
        if (str != null) {
            int i2 = i + 105;
            w = i2 % 128;
            if (i2 % 2 == 0) {
                try {
                    if (StringsKt.Q(str).toString().length() > 0) {
                        d = (w + 107) % 128;
                        return new File(StringsKt.Q(str).toString());
                    }
                } catch (Throwable th) {
                    AFLogger.afErrorLog(th.getMessage(), th);
                }
            } else {
                StringsKt.Q(str).toString().getClass();
                throw null;
            }
        }
        return null;
    }

    private static String getMonetizationNetwork(AFc1qSDK aFc1qSDK, String str) {
        return (String) getMediationNetwork(new Object[]{aFc1qSDK, str}, 381318279, -381318268, (int) System.currentTimeMillis());
    }

    @NotNull
    private String getMediationNetwork(@NotNull SimpleDateFormat simpleDateFormat) {
        int i = d + 113;
        w = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(simpleDateFormat, "");
            String AFAdRevenueData2 = this.component4.AFAdRevenueData("appsFlyerFirstInstall", (String) null);
            if (AFAdRevenueData2 == null) {
                if (copydefault()) {
                    AFLogger.afDebugLog("AppsFlyer: first launch detected");
                    AFAdRevenueData2 = simpleDateFormat.format(new Date());
                } else {
                    w = (d + 11) % 128;
                    AFAdRevenueData2 = "";
                }
                this.component4.getMediationNetwork("appsFlyerFirstInstall", AFAdRevenueData2);
            }
            AFg1gSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.GENERAL, e.B("AppsFlyer: first launch date: ", AFAdRevenueData2), false, 4, (Object) null);
            Intrinsics.checkNotNullExpressionValue(AFAdRevenueData2, "");
            return AFAdRevenueData2;
        }
        Intrinsics.checkNotNullParameter(simpleDateFormat, "");
        this.component4.AFAdRevenueData("appsFlyerFirstInstall", (String) null);
        throw null;
    }

    public final void getCurrencyIso4217Code(@NotNull AFh1rSDK aFh1rSDK) {
        Intrinsics.checkNotNullParameter(aFh1rSDK, "");
        Map<String, Object> map = aFh1rSDK.AFAdRevenueData;
        Intrinsics.checkNotNullExpressionValue(map, "");
        map.put("open_referrer", aFh1rSDK.getMediationNetwork);
        String str = aFh1rSDK.component4;
        if (str != null) {
            int i = w + 43;
            d = i % 128;
            if (i % 2 == 0) {
                StringsKt.t(str);
                throw null;
            } else if (!StringsKt.t(str)) {
                int i2 = w + 119;
                d = i2 % 128;
                if (i2 % 2 == 0) {
                    map.put("af_web_referrer", aFh1rSDK.component4);
                    int i3 = 26 / 0;
                    return;
                }
                map.put("af_web_referrer", aFh1rSDK.component4);
            }
        }
    }

    @VisibleForTesting
    @Nullable
    @SuppressLint({"PrivateApi"})
    private static String getMediationNetwork(@Nullable String str) {
        w = (d + 91) % 128;
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
            Intrinsics.d(invoke, "");
            String str2 = (String) invoke;
            w = (d + 43) % 128;
            return str2;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return null;
        }
    }

    private static String getMediationNetwork(File file, String str) {
        return (String) getMediationNetwork(new Object[]{file, str}, -2094417185, 2094417192, (int) System.currentTimeMillis());
    }

    private static boolean getMediationNetwork(File file) {
        return ((Boolean) getMediationNetwork(new Object[]{file}, 1334456290, -1334456289, (int) System.currentTimeMillis())).booleanValue();
    }
}
