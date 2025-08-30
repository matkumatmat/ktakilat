package com.appsflyer;

import androidx.annotation.NonNull;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.share.LinkGenerator;
import java.util.Map;

public class AppsFlyer2dXConversionCallback implements AppsFlyerConversionListener, DeepLinkListener, LinkGenerator.ResponseListener {
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003b A[Catch:{ JSONException -> 0x002b }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0042 A[Catch:{ JSONException -> 0x002b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void AFAdRevenueData(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x002b }
            r0.<init>()     // Catch:{ JSONException -> 0x002b }
            java.lang.String r1 = "status"
            java.lang.String r2 = "failure"
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x002b }
            java.lang.String r1 = "data"
            r0.put(r1, r8)     // Catch:{ JSONException -> 0x002b }
            int r8 = r7.hashCode()     // Catch:{ JSONException -> 0x002b }
            r1 = -1390007222(0xffffffffad262c4a, float:-9.445842E-12)
            r2 = 1
            if (r8 == r1) goto L_0x002e
            r1 = 1050716216(0x3ea0a838, float:0.3137834)
            if (r8 == r1) goto L_0x0021
            goto L_0x0038
        L_0x0021:
            java.lang.String r8 = "onInstallConversionFailure"
            boolean r7 = r7.equals(r8)     // Catch:{ JSONException -> 0x002b }
            if (r7 == 0) goto L_0x0038
            r7 = 0
            goto L_0x0039
        L_0x002b:
            r7 = move-exception
            r3 = r7
            goto L_0x0046
        L_0x002e:
            java.lang.String r8 = "onAttributionFailure"
            boolean r7 = r7.equals(r8)     // Catch:{ JSONException -> 0x002b }
            if (r7 == 0) goto L_0x0038
            r7 = 1
            goto L_0x0039
        L_0x0038:
            r7 = -1
        L_0x0039:
            if (r7 == 0) goto L_0x0042
            if (r7 == r2) goto L_0x003e
            goto L_0x0041
        L_0x003e:
            r6.onAttributionFailureNative(r0)     // Catch:{ JSONException -> 0x002b }
        L_0x0041:
            return
        L_0x0042:
            r6.onInstallConversionFailureNative(r0)     // Catch:{ JSONException -> 0x002b }
            return
        L_0x0046:
            com.appsflyer.AFLogger r0 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r1 = com.appsflyer.internal.AFg1cSDK.OTHER
            r4 = 0
            r5 = 0
            java.lang.String r2 = "2dx error"
            r0.e(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyer2dXConversionCallback.AFAdRevenueData(java.lang.String, java.lang.String):void");
    }

    public void onAppOpenAttribution(Map<String, String> map) {
        onAppOpenAttributionNative(map);
    }

    public native void onAppOpenAttributionNative(Object obj);

    public void onAttributionFailure(String str) {
        AFAdRevenueData("onInstallConversionFailure", str);
    }

    public native void onAttributionFailureNative(Object obj);

    public void onConversionDataFail(String str) {
        AFAdRevenueData("onAttributionFailure", str);
    }

    public void onConversionDataSuccess(Map<String, Object> map) {
        onInstallConversionDataLoadedNative(map);
    }

    public void onDeepLinking(@NonNull DeepLinkResult deepLinkResult) {
        onDeepLinkingNative(deepLinkResult);
    }

    public native void onDeepLinkingNative(@NonNull DeepLinkResult deepLinkResult);

    public native void onInstallConversionDataLoadedNative(Object obj);

    public native void onInstallConversionFailureNative(Object obj);

    public void onResponse(String str) {
        onResponseNative(str);
    }

    public void onResponseError(String str) {
        onResponseErrorNative(str);
    }

    public native void onResponseErrorNative(String str);

    public native void onResponseNative(String str);
}
