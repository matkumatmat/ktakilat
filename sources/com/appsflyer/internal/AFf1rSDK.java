package com.appsflyer.internal;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.text.StringsKt;
import org.json.JSONObject;

public class AFf1rSDK extends AFe1dSDK<String> {
    private static final AFe1mSDK[] AFInAppEventType = {AFe1mSDK.DLSDK, AFe1mSDK.ONELINK, AFe1mSDK.REGISTER};
    private final AFf1dSDK AFKeystoreWrapper;
    private final AFc1iSDK AFLogger;
    public final AFh1rSDK component2;
    protected final AFc1qSDK copy;
    @NonNull
    private final AFc1pSDK copydefault;
    private final AFe1zSDK equals;
    private final AFf1oSDK hashCode;
    protected final AFg1qSDK toString;

    public AFf1rSDK(@NonNull AFh1rSDK aFh1rSDK, @NonNull AFc1dSDK aFc1dSDK) {
        this(aFh1rSDK, aFc1dSDK, (String) null);
    }

    @NonNull
    public static Map<String, Object> component1(AFh1rSDK aFh1rSDK) {
        Map<String, Object> map = (Map) aFh1rSDK.AFAdRevenueData.get("meta");
        if (map != null) {
            return map;
        }
        HashMap hashMap = new HashMap();
        aFh1rSDK.AFAdRevenueData.put("meta", hashMap);
        return hashMap;
    }

    @CallSuper
    public void AFAdRevenueData(AFh1rSDK aFh1rSDK) {
        AFe1wSDK aFe1wSDK;
        boolean z = true;
        try {
            getCurrencyIso4217Code(aFh1rSDK);
            getRevenue(aFh1rSDK);
            getMediationNetwork(aFh1rSDK);
            getMonetizationNetwork(aFh1rSDK);
            component3(aFh1rSDK);
        } catch (Throwable th) {
            AFLogger.INSTANCE.e(AFg1cSDK.QUEUE, "Error while preparing to send event", th, true, true, false);
            return;
        }
        if (aFh1rSDK.getRevenue()) {
            aFh1rSDK.getMediationNetwork(this.component3.AFAdRevenueData(aFh1rSDK.AFAdRevenueData));
            aFh1rSDK.getMediationNetwork(this.component3.getMonetizationNetwork(aFh1rSDK.AFAdRevenueData));
            if (this.copydefault.getMonetizationNetwork("com.appsflyer.security.enable", false)) {
                AFf1gSDK.getCurrencyIso4217Code(new Object[]{aFh1rSDK}, -211782083, 211782085, (int) System.currentTimeMillis());
            }
        }
        if (aFh1rSDK.component2()) {
            aFh1rSDK.getMediationNetwork(this.component3.getCurrencyIso4217Code());
        }
        Set<AFe1mSDK> set = this.getCurrencyIso4217Code;
        if (!set.contains(AFe1mSDK.LAUNCH)) {
            if (!set.contains(AFe1mSDK.CONVERSION)) {
                z = false;
            }
        }
        if (areAllFieldsValid() && z) {
            aFh1rSDK.AFAdRevenueData(this.copy.AFAdRevenueData("appsFlyerCount", 0));
        }
        if (aFh1rSDK.areAllFieldsValid()) {
            Map<String, Object> component1 = component1(aFh1rSDK);
            AFe1zSDK aFe1zSDK = this.equals;
            String mediationNetwork = aFe1zSDK.getMediationNetwork();
            String currencyIso4217Code = aFe1zSDK.getCurrencyIso4217Code();
            if (AFe1zSDK.AFAdRevenueData()) {
                aFe1wSDK = AFe1wSDK.DEFAULT;
            } else {
                aFe1wSDK = AFe1wSDK.API;
            }
            AFe1xSDK aFe1xSDK = new AFe1xSDK(mediationNetwork, currencyIso4217Code, aFe1wSDK);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", aFe1xSDK.getMediationNetwork);
            AFe1wSDK aFe1wSDK2 = aFe1xSDK.AFAdRevenueData;
            if (aFe1wSDK2 != AFe1wSDK.DEFAULT) {
                jSONObject.put(FirebaseAnalytics.Param.METHOD, aFe1wSDK2.getCurrencyIso4217Code);
            }
            String str = aFe1xSDK.getRevenue;
            if (str != null) {
                if (!StringsKt.t(str)) {
                    jSONObject.put("prefix", aFe1xSDK.getRevenue);
                }
            }
            component1.put("host", jSONObject);
        }
        if (this.copydefault.getMonetizationNetwork("AF_PREINSTALL_DISABLED", false)) {
            component1(aFh1rSDK).put("preinstall_disabled", Boolean.TRUE);
        }
        this.AFKeystoreWrapper.AFAdRevenueData(aFh1rSDK.AFAdRevenueData, aFh1rSDK.getCurrencyIso4217Code());
    }

    @Nullable
    public final AppsFlyerRequestListener component3() {
        return this.component2.getCurrencyIso4217Code;
    }

    public boolean copydefault() {
        return true;
    }

    public void getCurrencyIso4217Code(AFh1rSDK aFh1rSDK) {
        this.toString.getMediationNetwork(aFh1rSDK);
    }

    public void getMediationNetwork(AFh1rSDK aFh1rSDK) {
        this.toString.getMonetizationNetwork(aFh1rSDK);
    }

    public void getMonetizationNetwork(AFh1rSDK aFh1rSDK) {
        this.toString.getRevenue(aFh1rSDK);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0099 A[Catch:{ all -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009a A[Catch:{ all -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d3 A[SYNTHETIC, Splitter:B:44:0x00d3] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e5 A[Catch:{ NullPointerException -> 0x00e2, Exception -> 0x00dd, all -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f5 A[Catch:{ NullPointerException -> 0x00fc, Exception -> 0x00f8, all -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00fe A[Catch:{ NullPointerException -> 0x00fc, Exception -> 0x00f8, all -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0163  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appsflyer.internal.AFd1nSDK<java.lang.String> getRevenue(@androidx.annotation.NonNull java.lang.String r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = 1
            r3 = 0
            java.lang.String r4 = "Unexpected error"
            java.lang.String r5 = "JSON toString of eventParams map returns null"
            java.lang.String r6 = "*Non-printing character*"
            java.lang.String r7 = "\\p{C}"
            java.lang.String r8 = ""
            com.appsflyer.internal.AFh1rSDK r0 = r1.component2
            r1.AFAdRevenueData(r0)
            com.appsflyer.internal.AFh1rSDK r0 = r1.component2
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.AFAdRevenueData
            java.lang.String r9 = "meta"
            boolean r0 = r0.containsKey(r9)
            if (r0 == 0) goto L_0x003b
            com.appsflyer.internal.AFf1oSDK r0 = r1.hashCode     // Catch:{ NullPointerException -> 0x002c }
            com.appsflyer.internal.AFf1lSDK r0 = r0.getMediationNetwork     // Catch:{ NullPointerException -> 0x002c }
            com.appsflyer.internal.AFi1wSDK r0 = r0.getCurrencyIso4217Code     // Catch:{ NullPointerException -> 0x002c }
            com.appsflyer.internal.AFh1cSDK r0 = r0.getMonetizationNetwork     // Catch:{ NullPointerException -> 0x002c }
            com.appsflyer.internal.AFh1bSDK r0 = r0.getCurrencyIso4217Code     // Catch:{ NullPointerException -> 0x002c }
            double r10 = r0.getMonetizationNetwork     // Catch:{ NullPointerException -> 0x002c }
            goto L_0x002e
        L_0x002c:
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
        L_0x002e:
            boolean r0 = com.appsflyer.internal.AFh1rSDK.getCurrencyIso4217Code((double) r10)
            if (r0 == 0) goto L_0x003b
            com.appsflyer.internal.AFh1rSDK r0 = r1.component2
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.AFAdRevenueData
            r0.remove(r9)
        L_0x003b:
            com.appsflyer.internal.AFd1oSDK r0 = r1.component4
            com.appsflyer.internal.AFh1rSDK r9 = r1.component2
            com.appsflyer.internal.AFc1iSDK r10 = r1.AFLogger
            r11 = r22
            com.appsflyer.internal.AFd1nSDK r9 = r0.getCurrencyIso4217Code((com.appsflyer.internal.AFh1rSDK) r9, (java.lang.String) r11, (com.appsflyer.internal.AFc1iSDK) r10)
            com.appsflyer.internal.AFh1rSDK r0 = r1.component2
            java.util.Map<java.lang.String, java.lang.Object> r10 = r0.AFAdRevenueData
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ NullPointerException -> 0x0071, all -> 0x006e }
            r12.<init>(r10)     // Catch:{ NullPointerException -> 0x0071, all -> 0x006e }
            java.lang.String r13 = r12.toString()     // Catch:{ NullPointerException -> 0x006b, all -> 0x0068 }
            if (r13 == 0) goto L_0x0062
            java.lang.String r0 = r13.replaceAll(r7, r6)     // Catch:{ NullPointerException -> 0x0060, all -> 0x005e }
            r3 = r0
        L_0x005b:
            r2 = 0
            goto L_0x0122
        L_0x005e:
            r0 = move-exception
            goto L_0x0074
        L_0x0060:
            r0 = move-exception
            goto L_0x007d
        L_0x0062:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ NullPointerException -> 0x0060, all -> 0x005e }
            r0.<init>(r5)     // Catch:{ NullPointerException -> 0x0060, all -> 0x005e }
            throw r0     // Catch:{ NullPointerException -> 0x0060, all -> 0x005e }
        L_0x0068:
            r0 = move-exception
        L_0x0069:
            r13 = 0
            goto L_0x0074
        L_0x006b:
            r0 = move-exception
        L_0x006c:
            r13 = 0
            goto L_0x007d
        L_0x006e:
            r0 = move-exception
            r12 = 0
            goto L_0x0069
        L_0x0071:
            r0 = move-exception
            r12 = 0
            goto L_0x006c
        L_0x0074:
            com.appsflyer.AFLogger r2 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r3 = com.appsflyer.internal.AFg1cSDK.GENERAL
            r2.e(r3, r4, r0)
            r3 = r8
            goto L_0x005b
        L_0x007d:
            com.appsflyer.AFLogger r14 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r15 = com.appsflyer.internal.AFg1cSDK.GENERAL
            java.lang.String r11 = "JSONObject return null String object. Trying to create AFJsonObject."
            r14.e(r15, r11, r0)
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x00ed }
            r0[r3] = r10     // Catch:{ all -> 0x00ed }
            java.util.Map r10 = com.appsflyer.internal.AFa1kSDK.i     // Catch:{ all -> 0x00ed }
            r11 = -1183302619(0xffffffffb9783c25, float:-2.3673529E-4)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x00ed }
            java.lang.Object r14 = r10.get(r14)     // Catch:{ all -> 0x00ed }
            if (r14 == 0) goto L_0x009a
            goto L_0x00c7
        L_0x009a:
            int r14 = android.view.Gravity.getAbsoluteGravity(r3, r3)     // Catch:{ all -> 0x00ed }
            int r14 = r14 + 196
            int r15 = android.graphics.Color.green(r3)     // Catch:{ all -> 0x00ed }
            char r15 = (char) r15     // Catch:{ all -> 0x00ed }
            int r16 = android.view.MotionEvent.axisFromString(r8)     // Catch:{ all -> 0x00ed }
            int r11 = 36 - r16
            java.lang.Object r11 = com.appsflyer.internal.AFa1kSDK.getCurrencyIso4217Code(r14, r15, r11)     // Catch:{ all -> 0x00ed }
            java.lang.Class r11 = (java.lang.Class) r11     // Catch:{ all -> 0x00ed }
            java.lang.String r14 = "getCurrencyIso4217Code"
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ all -> 0x00ed }
            java.lang.Class<java.util.Map> r15 = java.util.Map.class
            r2[r3] = r15     // Catch:{ all -> 0x00ed }
            java.lang.reflect.Method r14 = r11.getMethod(r14, r2)     // Catch:{ all -> 0x00ed }
            r2 = -1183302619(0xffffffffb9783c25, float:-2.3673529E-4)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00ed }
            r10.put(r2, r14)     // Catch:{ all -> 0x00ed }
        L_0x00c7:
            java.lang.reflect.Method r14 = (java.lang.reflect.Method) r14     // Catch:{ all -> 0x00ed }
            r2 = 0
            java.lang.Object r0 = r14.invoke(r2, r0)     // Catch:{ all -> 0x00eb }
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00eb }
            if (r3 == 0) goto L_0x00e5
            java.lang.String r0 = r3.replaceAll(r7, r6)     // Catch:{ NullPointerException -> 0x00e2, Exception -> 0x00dd, all -> 0x00da }
            r13 = r3
            r3 = r0
            goto L_0x0122
        L_0x00da:
            r0 = move-exception
            r13 = r3
            goto L_0x00ff
        L_0x00dd:
            r0 = move-exception
            r17 = r0
            r13 = r3
            goto L_0x0108
        L_0x00e2:
            r0 = move-exception
            r13 = r3
            goto L_0x0118
        L_0x00e5:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ NullPointerException -> 0x00e2, Exception -> 0x00dd, all -> 0x00da }
            r0.<init>(r5)     // Catch:{ NullPointerException -> 0x00e2, Exception -> 0x00dd, all -> 0x00da }
            throw r0     // Catch:{ NullPointerException -> 0x00e2, Exception -> 0x00dd, all -> 0x00da }
        L_0x00eb:
            r0 = move-exception
            goto L_0x00ef
        L_0x00ed:
            r0 = move-exception
            r2 = 0
        L_0x00ef:
            java.lang.Throwable r3 = r0.getCause()     // Catch:{ NullPointerException -> 0x00fc, Exception -> 0x00f8, all -> 0x00f6 }
            if (r3 == 0) goto L_0x00fe
            throw r3     // Catch:{ NullPointerException -> 0x00fc, Exception -> 0x00f8, all -> 0x00f6 }
        L_0x00f6:
            r0 = move-exception
            goto L_0x00ff
        L_0x00f8:
            r0 = move-exception
            r17 = r0
            goto L_0x0108
        L_0x00fc:
            r0 = move-exception
            goto L_0x0118
        L_0x00fe:
            throw r0     // Catch:{ NullPointerException -> 0x00fc, Exception -> 0x00f8, all -> 0x00f6 }
        L_0x00ff:
            com.appsflyer.AFLogger r3 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r5 = com.appsflyer.internal.AFg1cSDK.GENERAL
            r3.e(r5, r4, r0)
        L_0x0106:
            r3 = r8
            goto L_0x0122
        L_0x0108:
            com.appsflyer.AFLogger r14 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r15 = com.appsflyer.internal.AFg1cSDK.GENERAL
            r19 = 0
            r20 = 1
            java.lang.String r16 = "AFFinalizer: reflection init failed."
            r18 = 0
            r14.e(r15, r16, r17, r18, r19, r20)
            goto L_0x0106
        L_0x0118:
            com.appsflyer.AFLogger r3 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r4 = com.appsflyer.internal.AFg1cSDK.GENERAL
            java.lang.String r5 = "AFJsonObject return null String object."
            r3.e(r4, r5, r0)
            goto L_0x0106
        L_0x0122:
            if (r13 != 0) goto L_0x0125
            goto L_0x0126
        L_0x0125:
            r8 = r13
        L_0x0126:
            boolean r0 = r3.equals(r8)
            if (r0 != 0) goto L_0x0147
            com.appsflyer.AFLogger r0 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r4 = com.appsflyer.internal.AFg1cSDK.GENERAL
            java.lang.String r5 = "Payload contains non-printing characters"
            r0.w(r4, r5)
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x013c }
            r0.<init>(r3)     // Catch:{ JSONException -> 0x013c }
            r12 = r0
            goto L_0x0148
        L_0x013c:
            r0 = move-exception
            com.appsflyer.AFLogger r4 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r5 = com.appsflyer.internal.AFg1cSDK.GENERAL
            java.lang.String r6 = "Couldn't parse the payload to a json object"
            r4.e(r5, r6, r0)
            goto L_0x0148
        L_0x0147:
            r3 = r8
        L_0x0148:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r4 = ": preparing data: "
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.appsflyer.internal.AFh1ySDK.getCurrencyIso4217Code(r0, r12)
            if (r9 == 0) goto L_0x0163
            com.appsflyer.internal.AFd1cSDK r0 = r9.getRevenue
            java.lang.String r11 = r0.getMonetizationNetwork
            goto L_0x0164
        L_0x0163:
            r11 = r2
        L_0x0164:
            com.appsflyer.internal.AFd1pSDK r0 = r1.areAllFieldsValid
            r0.getCurrencyIso4217Code(r11, r3)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1rSDK.getRevenue(java.lang.String):com.appsflyer.internal.AFd1nSDK");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AFf1rSDK(@NonNull AFh1rSDK aFh1rSDK, @NonNull AFc1dSDK aFc1dSDK, String str) {
        super(aFh1rSDK.getCurrencyIso4217Code(), new AFe1mSDK[]{AFe1mSDK.RC_CDN, AFe1mSDK.FETCH_ADVERTISING_ID}, aFc1dSDK, str);
        int i = 0;
        this.component2 = aFh1rSDK;
        this.equals = aFc1dSDK.AFKeystoreWrapper();
        this.copy = aFc1dSDK.component2();
        this.hashCode = aFc1dSDK.component1();
        this.AFLogger = aFc1dSDK.AFInAppEventType();
        this.copydefault = aFc1dSDK.getRevenue();
        this.toString = aFc1dSDK.component3();
        this.AFKeystoreWrapper = aFc1dSDK.afErrorLog();
        AFe1mSDK[] aFe1mSDKArr = AFInAppEventType;
        int length = aFe1mSDKArr.length;
        while (i < length) {
            if (this.getMonetizationNetwork != aFe1mSDKArr[i]) {
                i++;
            } else {
                return;
            }
        }
        int i2 = this.component2.component2;
        AFe1mSDK aFe1mSDK = this.getMonetizationNetwork;
        if (i2 <= 0) {
            AFe1mSDK aFe1mSDK2 = AFe1mSDK.CONVERSION;
            if (aFe1mSDK != aFe1mSDK2) {
                this.getCurrencyIso4217Code.add(aFe1mSDK2);
                return;
            }
            return;
        }
        this.AFAdRevenueData.add(AFe1mSDK.CONVERSION);
    }

    public void component3(AFh1rSDK aFh1rSDK) {
        this.toString.AFAdRevenueData(aFh1rSDK);
    }

    public void getRevenue(AFh1rSDK aFh1rSDK) {
        this.toString.getRevenue(aFh1rSDK.AFAdRevenueData);
    }
}
