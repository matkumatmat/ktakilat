package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.deeplink.DeepLink;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.internal.AFf1ySDK;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

public final class AFa1oSDK {
    public Intent AFAdRevenueData;
    public final AFc1dSDK areAllFieldsValid;
    @NonNull
    public final List<String> component2 = new ArrayList();
    public long component3;
    @Nullable
    public String[] component4;
    public String getCurrencyIso4217Code;
    @NonNull
    public List<List<String>> getMediationNetwork = new ArrayList();
    @Nullable
    public DeepLinkListener getMonetizationNetwork;
    public Map<String, String> getRevenue;

    public AFa1oSDK(@NonNull AFc1dSDK aFc1dSDK) {
        this.areAllFieldsValid = aFc1dSDK;
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0075 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean g_(android.content.Intent r10, com.appsflyer.internal.AFa1jSDK r11) {
        /*
            r9 = this;
            java.lang.String r0 = "android.intent.action.VIEW"
            r1 = 0
            if (r10 == 0) goto L_0x0014
            java.lang.String r2 = r10.getAction()
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0014
            android.net.Uri r2 = r10.getData()
            goto L_0x0015
        L_0x0014:
            r2 = r1
        L_0x0015:
            android.content.Intent r3 = r9.AFAdRevenueData
            if (r3 == 0) goto L_0x0028
            java.lang.String r4 = r3.getAction()
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0028
            android.net.Uri r0 = r3.getData()
            goto L_0x0029
        L_0x0028:
            r0 = r1
        L_0x0029:
            if (r10 != 0) goto L_0x0032
            java.lang.String r3 = "Could not extract deeplink from null intent"
            com.appsflyer.AFLogger.afDebugLog(r3)
            goto L_0x00a9
        L_0x0032:
            android.os.Bundle r3 = r10.getExtras()
            java.util.List<java.util.List<java.lang.String>> r4 = r9.getMediationNetwork
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x00a9
            if (r3 != 0) goto L_0x0041
            goto L_0x00a9
        L_0x0041:
            java.util.List<java.util.List<java.lang.String>> r4 = r9.getMediationNetwork
            java.util.Iterator r4 = r4.iterator()
        L_0x0047:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00a9
            java.lang.Object r5 = r4.next()
            java.util.List r5 = (java.util.List) r5
            if (r5 != 0) goto L_0x0057
        L_0x0055:
            r6 = r1
            goto L_0x0073
        L_0x0057:
            java.util.Iterator r6 = r5.iterator()
            boolean r7 = r6.hasNext()
            if (r7 != 0) goto L_0x0062
            goto L_0x0055
        L_0x0062:
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r7 = r3.getString(r7)
            if (r7 != 0) goto L_0x006f
            goto L_0x0055
        L_0x006f:
            android.net.Uri r6 = r9.h_(r7, r6)
        L_0x0073:
            if (r6 == 0) goto L_0x0047
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Found deeplink in push payload at "
            r1.<init>(r3)
            java.lang.String r3 = r5.toString()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.appsflyer.AFLogger.afDebugLog(r1)
            java.util.List<java.util.List<java.lang.String>> r1 = r9.getMediationNetwork
            java.lang.String r3 = "payloadKey"
            java.lang.String r4 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            java.util.Map<java.lang.String, java.lang.Object> r5 = r11.getMediationNetwork
            java.util.Map r5 = com.appsflyer.internal.AFa1tSDK.getRevenue((java.util.Map<java.lang.String, java.lang.Object>) r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
            r5.put(r3, r1)
            com.appsflyer.internal.AFa1gSDK r1 = r11.getMonetizationNetwork
            if (r1 == 0) goto L_0x00a8
            java.util.Map<java.lang.String, java.lang.Object> r3 = r11.getMediationNetwork
            r1.getMediationNetwork(r3)
        L_0x00a8:
            r1 = r6
        L_0x00a9:
            java.lang.String r3 = " w/af_consumed"
            r4 = 1
            r5 = 0
            java.lang.String r6 = "af_consumed"
            if (r2 == 0) goto L_0x00e0
            com.appsflyer.internal.AFj1jSDK r0 = new com.appsflyer.internal.AFj1jSDK
            r0.<init>(r10)
            boolean r10 = r0.getMonetizationNetwork(r6)
            if (r10 != 0) goto L_0x00c7
            long r7 = java.lang.System.currentTimeMillis()
            r0.I_(r6, r7)
            r9.f_(r11, r2)
            return r4
        L_0x00c7:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "skipping re-use of previously consumed deep link: "
            r10.<init>(r11)
            java.lang.String r11 = r2.toString()
            r10.append(r11)
            r10.append(r3)
            java.lang.String r10 = r10.toString()
            com.appsflyer.AFLogger.afInfoLog(r10)
            return r5
        L_0x00e0:
            if (r0 == 0) goto L_0x0113
            com.appsflyer.internal.AFj1jSDK r10 = new com.appsflyer.internal.AFj1jSDK
            android.content.Intent r1 = r9.AFAdRevenueData
            r10.<init>(r1)
            boolean r1 = r10.getMonetizationNetwork(r6)
            if (r1 != 0) goto L_0x00fa
            long r1 = java.lang.System.currentTimeMillis()
            r10.I_(r6, r1)
            r9.f_(r11, r0)
            return r4
        L_0x00fa:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "skipping re-use of previously consumed trampoline deep link: "
            r10.<init>(r11)
            java.lang.String r11 = r0.toString()
            r10.append(r11)
            r10.append(r3)
            java.lang.String r10 = r10.toString()
            com.appsflyer.AFLogger.afInfoLog(r10)
            return r5
        L_0x0113:
            if (r1 == 0) goto L_0x0144
            com.appsflyer.internal.AFj1jSDK r0 = new com.appsflyer.internal.AFj1jSDK
            r0.<init>(r10)
            boolean r10 = r0.getMonetizationNetwork(r6)
            if (r10 != 0) goto L_0x012b
            long r2 = java.lang.System.currentTimeMillis()
            r0.I_(r6, r2)
            r9.f_(r11, r1)
            return r4
        L_0x012b:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "skipping re-use of previously consumed deep link from push: "
            r10.<init>(r11)
            java.lang.String r11 = r1.toString()
            r10.append(r11)
            r10.append(r3)
            java.lang.String r10 = r10.toString()
            com.appsflyer.AFLogger.afInfoLog(r10)
            return r5
        L_0x0144:
            java.lang.String r10 = "No deep link detected"
            com.appsflyer.AFLogger.afDebugLog(r10)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1oSDK.g_(android.content.Intent, com.appsflyer.internal.AFa1jSDK):boolean");
    }

    private static void getCurrencyIso4217Code(String str) {
        AppsFlyerConversionListener appsFlyerConversionListener = ((AFa1tSDK) AFa1tSDK.getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis())).getCurrencyIso4217Code;
        if (appsFlyerConversionListener != null) {
            try {
                AFLogger.afDebugLog("Calling onAppOpenAttributionFailure with: ".concat(String.valueOf(str)));
                appsFlyerConversionListener.onAttributionFailure(str);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
        }
    }

    @Nullable
    private Uri h_(Object obj, Iterator<String> it) {
        while (obj != JSONObject.NULL) {
            if (!it.hasNext()) {
                Uri parse = Uri.parse(obj.toString());
                if (parse == null || parse.getScheme() == null || parse.getHost() == null) {
                    return null;
                }
                return parse;
            }
            try {
                obj = new JSONObject(obj.toString()).get(it.next());
            } catch (JSONException e) {
                AFLogger.afErrorLogForExcManagerOnly("recursiveSearch error", e);
                return null;
            }
        }
        return null;
    }

    public final void AFAdRevenueData(String str, DeepLinkResult.Error error) {
        if (this.getMonetizationNetwork != null) {
            AFLogger.INSTANCE.d(AFg1cSDK.DDL, "Error occurred: ".concat(String.valueOf(str)));
            getRevenue(new DeepLinkResult((DeepLink) null, error));
            return;
        }
        getCurrencyIso4217Code(str);
    }

    public final void e_(AFa1jSDK aFa1jSDK, Intent intent, Context context) {
        AFc1eSDK aFc1eSDK = (AFc1eSDK) this.areAllFieldsValid;
        if (context != null) {
            aFc1eSDK.AFAdRevenueData.getMonetizationNetwork = context.getApplicationContext();
        }
        if (!g_(intent, aFa1jSDK) && this.getMonetizationNetwork != null && this.areAllFieldsValid.getRevenue().getMonetizationNetwork.AFAdRevenueData("appsFlyerCount", 0) == 0 && !this.areAllFieldsValid.component2().getMediationNetwork("ddl_sent", false)) {
            AFa1pSDK aFa1pSDK = new AFa1pSDK();
            AFe1lSDK copydefault = this.areAllFieldsValid.copydefault();
            copydefault.getRevenue.execute(new Runnable(new AFf1xSDK(aFa1pSDK, this.areAllFieldsValid)) {
                private /* synthetic */ AFe1sSDK getMonetizationNetwork;

                {
                    this.getMonetizationNetwork = r2;
                }

                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                        r6 = this;
                        com.appsflyer.internal.AFe1lSDK r0 = com.appsflyer.internal.AFe1lSDK.this
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r0 = r0.component2
                        monitor-enter(r0)
                        com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                        java.util.Set<com.appsflyer.internal.AFe1sSDK<?>> r1 = r1.component1     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x002a }
                        if (r1 == 0) goto L_0x002d
                        com.appsflyer.AFLogger r1 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFg1cSDK r2 = com.appsflyer.internal.AFg1cSDK.QUEUE     // Catch:{ all -> 0x002a }
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
                        java.lang.String r4 = "tried to add already running task: "
                        r3.<init>(r4)     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r4 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        r3.append(r4)     // Catch:{ all -> 0x002a }
                        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x002a }
                        r1.d(r2, r3)     // Catch:{ all -> 0x002a }
                        monitor-exit(r0)     // Catch:{ all -> 0x002a }
                        return
                    L_0x002a:
                        r1 = move-exception
                        goto L_0x01a9
                    L_0x002d:
                        com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r1 = r1.component2     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x002a }
                        if (r1 != 0) goto L_0x0190
                        com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r1 = r1.component4     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x002a }
                        if (r1 == 0) goto L_0x0047
                        goto L_0x0190
                    L_0x0047:
                        com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        java.util.Set<com.appsflyer.internal.AFe1mSDK> r3 = r2.AFAdRevenueData     // Catch:{ all -> 0x002a }
                        java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x002a }
                    L_0x0051:
                        boolean r4 = r3.hasNext()     // Catch:{ all -> 0x002a }
                        if (r4 == 0) goto L_0x006b
                        java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1mSDK r4 = (com.appsflyer.internal.AFe1mSDK) r4     // Catch:{ all -> 0x002a }
                        java.util.Set<com.appsflyer.internal.AFe1mSDK> r5 = r1.component3     // Catch:{ all -> 0x002a }
                        boolean r5 = r5.contains(r4)     // Catch:{ all -> 0x002a }
                        if (r5 == 0) goto L_0x0051
                        java.util.Set<com.appsflyer.internal.AFe1mSDK> r5 = r2.getCurrencyIso4217Code     // Catch:{ all -> 0x002a }
                        r5.add(r4)     // Catch:{ all -> 0x002a }
                        goto L_0x0051
                    L_0x006b:
                        com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        boolean r1 = r1.AFAdRevenueData(r2)     // Catch:{ all -> 0x002a }
                        if (r1 == 0) goto L_0x0080
                        com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r1 = r1.component2     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        boolean r1 = r1.add(r2)     // Catch:{ all -> 0x002a }
                        goto L_0x00a8
                    L_0x0080:
                        com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r1 = r1.component4     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        boolean r1 = r1.add(r2)     // Catch:{ all -> 0x002a }
                        if (r1 == 0) goto L_0x00a8
                        com.appsflyer.AFLogger r2 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFg1cSDK r3 = com.appsflyer.internal.AFg1cSDK.QUEUE     // Catch:{ all -> 0x002a }
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
                        java.lang.String r5 = "new task was blocked: "
                        r4.<init>(r5)     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r5 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        r4.append(r5)     // Catch:{ all -> 0x002a }
                        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x002a }
                        r2.d(r3, r4)     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        r2.AFAdRevenueData()     // Catch:{ all -> 0x002a }
                    L_0x00a8:
                        if (r1 == 0) goto L_0x00bb
                        com.appsflyer.internal.AFe1lSDK r2 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r2.component2     // Catch:{ all -> 0x002a }
                        java.util.List<com.appsflyer.internal.AFe1sSDK<?>> r2 = r2.areAllFieldsValid     // Catch:{ all -> 0x002a }
                        r3.addAll(r2)     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1lSDK r2 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                        java.util.List<com.appsflyer.internal.AFe1sSDK<?>> r2 = r2.areAllFieldsValid     // Catch:{ all -> 0x002a }
                        r2.clear()     // Catch:{ all -> 0x002a }
                        goto L_0x00d2
                    L_0x00bb:
                        com.appsflyer.AFLogger r2 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFg1cSDK r3 = com.appsflyer.internal.AFg1cSDK.QUEUE     // Catch:{ all -> 0x002a }
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
                        java.lang.String r5 = "task not added, it's already in the queue: "
                        r4.<init>(r5)     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r5 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        r4.append(r5)     // Catch:{ all -> 0x002a }
                        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x002a }
                        r2.d(r3, r4)     // Catch:{ all -> 0x002a }
                    L_0x00d2:
                        monitor-exit(r0)     // Catch:{ all -> 0x002a }
                        if (r1 == 0) goto L_0x0178
                        com.appsflyer.internal.AFe1lSDK r0 = com.appsflyer.internal.AFe1lSDK.this
                        java.util.Set<com.appsflyer.internal.AFe1mSDK> r0 = r0.component3
                        com.appsflyer.internal.AFe1sSDK r1 = r6.getMonetizationNetwork
                        com.appsflyer.internal.AFe1mSDK r1 = r1.getMonetizationNetwork
                        r0.add(r1)
                        com.appsflyer.AFLogger r0 = com.appsflyer.AFLogger.INSTANCE
                        com.appsflyer.internal.AFg1cSDK r1 = com.appsflyer.internal.AFg1cSDK.QUEUE
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        java.lang.String r3 = "new task added: "
                        r2.<init>(r3)
                        com.appsflyer.internal.AFe1sSDK r3 = r6.getMonetizationNetwork
                        r2.append(r3)
                        java.lang.String r2 = r2.toString()
                        r0.d(r1, r2)
                        com.appsflyer.internal.AFe1lSDK r0 = com.appsflyer.internal.AFe1lSDK.this
                        java.util.List<com.appsflyer.internal.AFe1qSDK> r0 = r0.AFAdRevenueData
                        java.util.Iterator r0 = r0.iterator()
                    L_0x00ff:
                        boolean r1 = r0.hasNext()
                        if (r1 == 0) goto L_0x010c
                        java.lang.Object r1 = r0.next()
                        com.appsflyer.internal.AFe1qSDK r1 = (com.appsflyer.internal.AFe1qSDK) r1
                        goto L_0x00ff
                    L_0x010c:
                        com.appsflyer.internal.AFe1lSDK r0 = com.appsflyer.internal.AFe1lSDK.this
                        java.util.concurrent.ExecutorService r1 = r0.getMediationNetwork
                        com.appsflyer.internal.AFe1lSDK$4 r2 = new com.appsflyer.internal.AFe1lSDK$4
                        r2.<init>()
                        r1.submit(r2)
                        com.appsflyer.internal.AFe1lSDK r0 = com.appsflyer.internal.AFe1lSDK.this
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r1 = r0.component2
                        monitor-enter(r1)
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r2 = r0.component2     // Catch:{ all -> 0x015a }
                        int r2 = r2.size()     // Catch:{ all -> 0x015a }
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component4     // Catch:{ all -> 0x015a }
                        int r3 = r3.size()     // Catch:{ all -> 0x015a }
                        int r2 = r2 + r3
                        int r2 = r2 + -40
                    L_0x012c:
                        if (r2 <= 0) goto L_0x0174
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component4     // Catch:{ all -> 0x015a }
                        boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x015a }
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r4 = r0.component2     // Catch:{ all -> 0x015a }
                        boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x015a }
                        if (r4 != 0) goto L_0x0162
                        if (r3 != 0) goto L_0x0162
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component2     // Catch:{ all -> 0x015a }
                        java.lang.Object r3 = r3.first()     // Catch:{ all -> 0x015a }
                        com.appsflyer.internal.AFe1sSDK r3 = (com.appsflyer.internal.AFe1sSDK) r3     // Catch:{ all -> 0x015a }
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r4 = r0.component4     // Catch:{ all -> 0x015a }
                        java.lang.Object r4 = r4.first()     // Catch:{ all -> 0x015a }
                        com.appsflyer.internal.AFe1sSDK r4 = (com.appsflyer.internal.AFe1sSDK) r4     // Catch:{ all -> 0x015a }
                        int r3 = r3.compareTo((com.appsflyer.internal.AFe1sSDK<?>) r4)     // Catch:{ all -> 0x015a }
                        if (r3 <= 0) goto L_0x015c
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component2     // Catch:{ all -> 0x015a }
                        r0.getMediationNetwork(r3)     // Catch:{ all -> 0x015a }
                        goto L_0x0171
                    L_0x015a:
                        r0 = move-exception
                        goto L_0x0176
                    L_0x015c:
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component4     // Catch:{ all -> 0x015a }
                        r0.getMediationNetwork(r3)     // Catch:{ all -> 0x015a }
                        goto L_0x0171
                    L_0x0162:
                        if (r4 != 0) goto L_0x016a
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component2     // Catch:{ all -> 0x015a }
                        r0.getMediationNetwork(r3)     // Catch:{ all -> 0x015a }
                        goto L_0x0171
                    L_0x016a:
                        if (r3 != 0) goto L_0x0171
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component4     // Catch:{ all -> 0x015a }
                        r0.getMediationNetwork(r3)     // Catch:{ all -> 0x015a }
                    L_0x0171:
                        int r2 = r2 + -1
                        goto L_0x012c
                    L_0x0174:
                        monitor-exit(r1)     // Catch:{ all -> 0x015a }
                        return
                    L_0x0176:
                        monitor-exit(r1)
                        throw r0
                    L_0x0178:
                        com.appsflyer.AFLogger r0 = com.appsflyer.AFLogger.INSTANCE
                        com.appsflyer.internal.AFg1cSDK r1 = com.appsflyer.internal.AFg1cSDK.QUEUE
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        java.lang.String r3 = "QUEUE: tried to add already pending task: "
                        r2.<init>(r3)
                        com.appsflyer.internal.AFe1sSDK r3 = r6.getMonetizationNetwork
                        r2.append(r3)
                        java.lang.String r2 = r2.toString()
                        r0.w(r1, r2)
                        return
                    L_0x0190:
                        com.appsflyer.AFLogger r1 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFg1cSDK r2 = com.appsflyer.internal.AFg1cSDK.QUEUE     // Catch:{ all -> 0x002a }
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
                        java.lang.String r4 = "tried to add already scheduled task: "
                        r3.<init>(r4)     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r4 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        r3.append(r4)     // Catch:{ all -> 0x002a }
                        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x002a }
                        r1.d(r2, r3)     // Catch:{ all -> 0x002a }
                        monitor-exit(r0)     // Catch:{ all -> 0x002a }
                        return
                    L_0x01a9:
                        monitor-exit(r0)
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1lSDK.AnonymousClass5.run():void");
                }
            });
        }
        this.areAllFieldsValid.component2().getCurrencyIso4217Code("ddl_sent", true);
    }

    public final void f_(AFa1jSDK aFa1jSDK, Uri uri) {
        AFe1aSDK aFe1aSDK = new AFe1aSDK(this, aFa1jSDK, uri, this.component2);
        AFe1lSDK copydefault = this.areAllFieldsValid.copydefault();
        copydefault.getRevenue.execute(new Runnable(aFe1aSDK) {
            private /* synthetic */ AFe1sSDK getMonetizationNetwork;

            {
                this.getMonetizationNetwork = r2;
            }

            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r6 = this;
                    com.appsflyer.internal.AFe1lSDK r0 = com.appsflyer.internal.AFe1lSDK.this
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r0 = r0.component2
                    monitor-enter(r0)
                    com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                    java.util.Set<com.appsflyer.internal.AFe1sSDK<?>> r1 = r1.component1     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x002a }
                    if (r1 == 0) goto L_0x002d
                    com.appsflyer.AFLogger r1 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFg1cSDK r2 = com.appsflyer.internal.AFg1cSDK.QUEUE     // Catch:{ all -> 0x002a }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
                    java.lang.String r4 = "tried to add already running task: "
                    r3.<init>(r4)     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r4 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    r3.append(r4)     // Catch:{ all -> 0x002a }
                    java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x002a }
                    r1.d(r2, r3)     // Catch:{ all -> 0x002a }
                    monitor-exit(r0)     // Catch:{ all -> 0x002a }
                    return
                L_0x002a:
                    r1 = move-exception
                    goto L_0x01a9
                L_0x002d:
                    com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r1 = r1.component2     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x002a }
                    if (r1 != 0) goto L_0x0190
                    com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r1 = r1.component4     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x002a }
                    if (r1 == 0) goto L_0x0047
                    goto L_0x0190
                L_0x0047:
                    com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    java.util.Set<com.appsflyer.internal.AFe1mSDK> r3 = r2.AFAdRevenueData     // Catch:{ all -> 0x002a }
                    java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x002a }
                L_0x0051:
                    boolean r4 = r3.hasNext()     // Catch:{ all -> 0x002a }
                    if (r4 == 0) goto L_0x006b
                    java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1mSDK r4 = (com.appsflyer.internal.AFe1mSDK) r4     // Catch:{ all -> 0x002a }
                    java.util.Set<com.appsflyer.internal.AFe1mSDK> r5 = r1.component3     // Catch:{ all -> 0x002a }
                    boolean r5 = r5.contains(r4)     // Catch:{ all -> 0x002a }
                    if (r5 == 0) goto L_0x0051
                    java.util.Set<com.appsflyer.internal.AFe1mSDK> r5 = r2.getCurrencyIso4217Code     // Catch:{ all -> 0x002a }
                    r5.add(r4)     // Catch:{ all -> 0x002a }
                    goto L_0x0051
                L_0x006b:
                    com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    boolean r1 = r1.AFAdRevenueData(r2)     // Catch:{ all -> 0x002a }
                    if (r1 == 0) goto L_0x0080
                    com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r1 = r1.component2     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    boolean r1 = r1.add(r2)     // Catch:{ all -> 0x002a }
                    goto L_0x00a8
                L_0x0080:
                    com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r1 = r1.component4     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    boolean r1 = r1.add(r2)     // Catch:{ all -> 0x002a }
                    if (r1 == 0) goto L_0x00a8
                    com.appsflyer.AFLogger r2 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFg1cSDK r3 = com.appsflyer.internal.AFg1cSDK.QUEUE     // Catch:{ all -> 0x002a }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
                    java.lang.String r5 = "new task was blocked: "
                    r4.<init>(r5)     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r5 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    r4.append(r5)     // Catch:{ all -> 0x002a }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x002a }
                    r2.d(r3, r4)     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    r2.AFAdRevenueData()     // Catch:{ all -> 0x002a }
                L_0x00a8:
                    if (r1 == 0) goto L_0x00bb
                    com.appsflyer.internal.AFe1lSDK r2 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r2.component2     // Catch:{ all -> 0x002a }
                    java.util.List<com.appsflyer.internal.AFe1sSDK<?>> r2 = r2.areAllFieldsValid     // Catch:{ all -> 0x002a }
                    r3.addAll(r2)     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1lSDK r2 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                    java.util.List<com.appsflyer.internal.AFe1sSDK<?>> r2 = r2.areAllFieldsValid     // Catch:{ all -> 0x002a }
                    r2.clear()     // Catch:{ all -> 0x002a }
                    goto L_0x00d2
                L_0x00bb:
                    com.appsflyer.AFLogger r2 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFg1cSDK r3 = com.appsflyer.internal.AFg1cSDK.QUEUE     // Catch:{ all -> 0x002a }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
                    java.lang.String r5 = "task not added, it's already in the queue: "
                    r4.<init>(r5)     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r5 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    r4.append(r5)     // Catch:{ all -> 0x002a }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x002a }
                    r2.d(r3, r4)     // Catch:{ all -> 0x002a }
                L_0x00d2:
                    monitor-exit(r0)     // Catch:{ all -> 0x002a }
                    if (r1 == 0) goto L_0x0178
                    com.appsflyer.internal.AFe1lSDK r0 = com.appsflyer.internal.AFe1lSDK.this
                    java.util.Set<com.appsflyer.internal.AFe1mSDK> r0 = r0.component3
                    com.appsflyer.internal.AFe1sSDK r1 = r6.getMonetizationNetwork
                    com.appsflyer.internal.AFe1mSDK r1 = r1.getMonetizationNetwork
                    r0.add(r1)
                    com.appsflyer.AFLogger r0 = com.appsflyer.AFLogger.INSTANCE
                    com.appsflyer.internal.AFg1cSDK r1 = com.appsflyer.internal.AFg1cSDK.QUEUE
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    java.lang.String r3 = "new task added: "
                    r2.<init>(r3)
                    com.appsflyer.internal.AFe1sSDK r3 = r6.getMonetizationNetwork
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    r0.d(r1, r2)
                    com.appsflyer.internal.AFe1lSDK r0 = com.appsflyer.internal.AFe1lSDK.this
                    java.util.List<com.appsflyer.internal.AFe1qSDK> r0 = r0.AFAdRevenueData
                    java.util.Iterator r0 = r0.iterator()
                L_0x00ff:
                    boolean r1 = r0.hasNext()
                    if (r1 == 0) goto L_0x010c
                    java.lang.Object r1 = r0.next()
                    com.appsflyer.internal.AFe1qSDK r1 = (com.appsflyer.internal.AFe1qSDK) r1
                    goto L_0x00ff
                L_0x010c:
                    com.appsflyer.internal.AFe1lSDK r0 = com.appsflyer.internal.AFe1lSDK.this
                    java.util.concurrent.ExecutorService r1 = r0.getMediationNetwork
                    com.appsflyer.internal.AFe1lSDK$4 r2 = new com.appsflyer.internal.AFe1lSDK$4
                    r2.<init>()
                    r1.submit(r2)
                    com.appsflyer.internal.AFe1lSDK r0 = com.appsflyer.internal.AFe1lSDK.this
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r1 = r0.component2
                    monitor-enter(r1)
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r2 = r0.component2     // Catch:{ all -> 0x015a }
                    int r2 = r2.size()     // Catch:{ all -> 0x015a }
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component4     // Catch:{ all -> 0x015a }
                    int r3 = r3.size()     // Catch:{ all -> 0x015a }
                    int r2 = r2 + r3
                    int r2 = r2 + -40
                L_0x012c:
                    if (r2 <= 0) goto L_0x0174
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component4     // Catch:{ all -> 0x015a }
                    boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x015a }
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r4 = r0.component2     // Catch:{ all -> 0x015a }
                    boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x015a }
                    if (r4 != 0) goto L_0x0162
                    if (r3 != 0) goto L_0x0162
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component2     // Catch:{ all -> 0x015a }
                    java.lang.Object r3 = r3.first()     // Catch:{ all -> 0x015a }
                    com.appsflyer.internal.AFe1sSDK r3 = (com.appsflyer.internal.AFe1sSDK) r3     // Catch:{ all -> 0x015a }
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r4 = r0.component4     // Catch:{ all -> 0x015a }
                    java.lang.Object r4 = r4.first()     // Catch:{ all -> 0x015a }
                    com.appsflyer.internal.AFe1sSDK r4 = (com.appsflyer.internal.AFe1sSDK) r4     // Catch:{ all -> 0x015a }
                    int r3 = r3.compareTo((com.appsflyer.internal.AFe1sSDK<?>) r4)     // Catch:{ all -> 0x015a }
                    if (r3 <= 0) goto L_0x015c
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component2     // Catch:{ all -> 0x015a }
                    r0.getMediationNetwork(r3)     // Catch:{ all -> 0x015a }
                    goto L_0x0171
                L_0x015a:
                    r0 = move-exception
                    goto L_0x0176
                L_0x015c:
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component4     // Catch:{ all -> 0x015a }
                    r0.getMediationNetwork(r3)     // Catch:{ all -> 0x015a }
                    goto L_0x0171
                L_0x0162:
                    if (r4 != 0) goto L_0x016a
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component2     // Catch:{ all -> 0x015a }
                    r0.getMediationNetwork(r3)     // Catch:{ all -> 0x015a }
                    goto L_0x0171
                L_0x016a:
                    if (r3 != 0) goto L_0x0171
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component4     // Catch:{ all -> 0x015a }
                    r0.getMediationNetwork(r3)     // Catch:{ all -> 0x015a }
                L_0x0171:
                    int r2 = r2 + -1
                    goto L_0x012c
                L_0x0174:
                    monitor-exit(r1)     // Catch:{ all -> 0x015a }
                    return
                L_0x0176:
                    monitor-exit(r1)
                    throw r0
                L_0x0178:
                    com.appsflyer.AFLogger r0 = com.appsflyer.AFLogger.INSTANCE
                    com.appsflyer.internal.AFg1cSDK r1 = com.appsflyer.internal.AFg1cSDK.QUEUE
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    java.lang.String r3 = "QUEUE: tried to add already pending task: "
                    r2.<init>(r3)
                    com.appsflyer.internal.AFe1sSDK r3 = r6.getMonetizationNetwork
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    r0.w(r1, r2)
                    return
                L_0x0190:
                    com.appsflyer.AFLogger r1 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFg1cSDK r2 = com.appsflyer.internal.AFg1cSDK.QUEUE     // Catch:{ all -> 0x002a }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
                    java.lang.String r4 = "tried to add already scheduled task: "
                    r3.<init>(r4)     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r4 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    r3.append(r4)     // Catch:{ all -> 0x002a }
                    java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x002a }
                    r1.d(r2, r3)     // Catch:{ all -> 0x002a }
                    monitor-exit(r0)     // Catch:{ all -> 0x002a }
                    return
                L_0x01a9:
                    monitor-exit(r0)
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1lSDK.AnonymousClass5.run():void");
            }
        });
        this.AFAdRevenueData = null;
    }

    public final void getMediationNetwork(Map<String, String> map) {
        DeepLinkResult deepLinkResult;
        if (this.getMonetizationNetwork != null) {
            try {
                DeepLink revenue = DeepLink.getRevenue(map);
                revenue.getCurrencyIso4217Code.put("is_deferred", false);
                deepLinkResult = new DeepLinkResult(revenue, (DeepLinkResult.Error) null);
            } catch (JSONException e) {
                AFLogger.INSTANCE.e(AFg1cSDK.DDL, "Error occurred", e, true);
                deepLinkResult = new DeepLinkResult((DeepLink) null, DeepLinkResult.Error.UNEXPECTED);
            } catch (Throwable th) {
                getRevenue(new DeepLinkResult((DeepLink) null, (DeepLinkResult.Error) null));
                throw th;
            }
            getRevenue(deepLinkResult);
            return;
        }
        AppsFlyerConversionListener appsFlyerConversionListener = ((AFa1tSDK) AFa1tSDK.getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis())).getCurrencyIso4217Code;
        if (appsFlyerConversionListener != null) {
            try {
                StringBuilder sb = new StringBuilder("Calling onAppOpenAttribution with:\n");
                sb.append(map.toString());
                AFLogger.afDebugLog(sb.toString());
                appsFlyerConversionListener.onAppOpenAttribution(map);
            } catch (Throwable th2) {
                AFLogger.afErrorLog(th2.getLocalizedMessage(), th2);
            }
        }
    }

    public final void getRevenue(DeepLinkResult deepLinkResult) {
        if (this.getMonetizationNetwork != null) {
            AFLogger aFLogger = AFLogger.INSTANCE;
            AFg1cSDK aFg1cSDK = AFg1cSDK.DDL;
            StringBuilder sb = new StringBuilder("Calling onDeepLinking with:\n");
            sb.append(deepLinkResult.toString());
            aFLogger.d(aFg1cSDK, sb.toString());
            try {
                this.getMonetizationNetwork.onDeepLinking(deepLinkResult);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
        } else {
            AFLogger.INSTANCE.d(AFg1cSDK.DDL, "skipping, no callback registered");
        }
    }

    public final void i_(AFa1jSDK aFa1jSDK, Uri uri, @Nullable Uri uri2) {
        String str;
        if (!aFa1jSDK.getCurrencyIso4217Code("af_deeplink")) {
            String obj = uri.toString();
            if (obj == null) {
                obj = null;
            } else if (obj.matches("fb\\d*?://authorize.*") && obj.contains("access_token")) {
                int indexOf = obj.indexOf(63);
                if (indexOf == -1) {
                    str = "";
                } else {
                    str = obj.substring(indexOf);
                }
                if (str.length() != 0) {
                    ArrayList arrayList = new ArrayList();
                    if (str.contains("&")) {
                        arrayList = new ArrayList(Arrays.asList(str.split("&")));
                    } else {
                        arrayList.add(str);
                    }
                    StringBuilder sb = new StringBuilder();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        if (str2.contains("access_token")) {
                            it.remove();
                        } else {
                            if (sb.length() != 0) {
                                sb.append("&");
                            } else if (!str2.startsWith("?")) {
                                sb.append("?");
                            }
                            sb.append(str2);
                        }
                    }
                    obj = obj.replace(str, sb.toString());
                }
            }
            String str3 = this.getCurrencyIso4217Code;
            if (!(str3 == null || this.getRevenue == null || !obj.contains(str3))) {
                Uri.Builder buildUpon = Uri.parse(obj).buildUpon();
                Uri.Builder buildUpon2 = Uri.EMPTY.buildUpon();
                for (Map.Entry next : this.getRevenue.entrySet()) {
                    buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
                    buildUpon2.appendQueryParameter((String) next.getKey(), (String) next.getValue());
                }
                obj = buildUpon.build().toString();
                String encodedQuery = buildUpon2.build().getEncodedQuery();
                Intrinsics.checkNotNullParameter("appended_query_params", "");
                aFa1jSDK.getMediationNetwork.put("appended_query_params", encodedQuery);
                AFa1gSDK aFa1gSDK = aFa1jSDK.getMonetizationNetwork;
                if (aFa1gSDK != null) {
                    aFa1gSDK.getMediationNetwork(aFa1jSDK.getMediationNetwork);
                }
            }
            Intrinsics.checkNotNullParameter("af_deeplink", "");
            aFa1jSDK.getMediationNetwork.put("af_deeplink", obj);
            AFa1gSDK aFa1gSDK2 = aFa1jSDK.getMonetizationNetwork;
            if (aFa1gSDK2 != null) {
                aFa1gSDK2.getMediationNetwork(aFa1jSDK.getMediationNetwork);
            }
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("link", uri.toString());
        if (uri2 != null) {
            hashMap.put("original_link", uri2.toString());
        }
        AFj1iSDK.M_(this.areAllFieldsValid.AFInAppEventType().getMonetizationNetwork, hashMap, uri);
        AFf1ySDK aFf1ySDK = new AFf1ySDK(this.areAllFieldsValid, UUID.randomUUID(), uri);
        if (aFf1ySDK.copy()) {
            Boolean bool = Boolean.TRUE;
            Intrinsics.checkNotNullParameter("isBrandedDomain", "");
            aFa1jSDK.getMediationNetwork.put("isBrandedDomain", bool);
            AFa1gSDK aFa1gSDK3 = aFa1jSDK.getMonetizationNetwork;
            if (aFa1gSDK3 != null) {
                aFa1gSDK3.getMediationNetwork(aFa1jSDK.getMediationNetwork);
            }
        }
        if (aFf1ySDK.equals()) {
            aFf1ySDK.component2 = new AFf1ySDK.AFa1ySDK() {
                public final void getRevenue(String str) {
                    AFa1oSDK.this.AFAdRevenueData(str, DeepLinkResult.Error.NETWORK);
                }

                public final void getRevenue(Map<String, String> map) {
                    for (String next : map.keySet()) {
                        hashMap.put(next, map.get(next));
                    }
                    AFa1oSDK.this.getMediationNetwork(hashMap);
                }
            };
            AFe1lSDK copydefault = this.areAllFieldsValid.copydefault();
            copydefault.getRevenue.execute(new Runnable(aFf1ySDK) {
                private /* synthetic */ AFe1sSDK getMonetizationNetwork;

                {
                    this.getMonetizationNetwork = r2;
                }

                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                        r6 = this;
                        com.appsflyer.internal.AFe1lSDK r0 = com.appsflyer.internal.AFe1lSDK.this
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r0 = r0.component2
                        monitor-enter(r0)
                        com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                        java.util.Set<com.appsflyer.internal.AFe1sSDK<?>> r1 = r1.component1     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x002a }
                        if (r1 == 0) goto L_0x002d
                        com.appsflyer.AFLogger r1 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFg1cSDK r2 = com.appsflyer.internal.AFg1cSDK.QUEUE     // Catch:{ all -> 0x002a }
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
                        java.lang.String r4 = "tried to add already running task: "
                        r3.<init>(r4)     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r4 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        r3.append(r4)     // Catch:{ all -> 0x002a }
                        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x002a }
                        r1.d(r2, r3)     // Catch:{ all -> 0x002a }
                        monitor-exit(r0)     // Catch:{ all -> 0x002a }
                        return
                    L_0x002a:
                        r1 = move-exception
                        goto L_0x01a9
                    L_0x002d:
                        com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r1 = r1.component2     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x002a }
                        if (r1 != 0) goto L_0x0190
                        com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r1 = r1.component4     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x002a }
                        if (r1 == 0) goto L_0x0047
                        goto L_0x0190
                    L_0x0047:
                        com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        java.util.Set<com.appsflyer.internal.AFe1mSDK> r3 = r2.AFAdRevenueData     // Catch:{ all -> 0x002a }
                        java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x002a }
                    L_0x0051:
                        boolean r4 = r3.hasNext()     // Catch:{ all -> 0x002a }
                        if (r4 == 0) goto L_0x006b
                        java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1mSDK r4 = (com.appsflyer.internal.AFe1mSDK) r4     // Catch:{ all -> 0x002a }
                        java.util.Set<com.appsflyer.internal.AFe1mSDK> r5 = r1.component3     // Catch:{ all -> 0x002a }
                        boolean r5 = r5.contains(r4)     // Catch:{ all -> 0x002a }
                        if (r5 == 0) goto L_0x0051
                        java.util.Set<com.appsflyer.internal.AFe1mSDK> r5 = r2.getCurrencyIso4217Code     // Catch:{ all -> 0x002a }
                        r5.add(r4)     // Catch:{ all -> 0x002a }
                        goto L_0x0051
                    L_0x006b:
                        com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        boolean r1 = r1.AFAdRevenueData(r2)     // Catch:{ all -> 0x002a }
                        if (r1 == 0) goto L_0x0080
                        com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r1 = r1.component2     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        boolean r1 = r1.add(r2)     // Catch:{ all -> 0x002a }
                        goto L_0x00a8
                    L_0x0080:
                        com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r1 = r1.component4     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        boolean r1 = r1.add(r2)     // Catch:{ all -> 0x002a }
                        if (r1 == 0) goto L_0x00a8
                        com.appsflyer.AFLogger r2 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFg1cSDK r3 = com.appsflyer.internal.AFg1cSDK.QUEUE     // Catch:{ all -> 0x002a }
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
                        java.lang.String r5 = "new task was blocked: "
                        r4.<init>(r5)     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r5 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        r4.append(r5)     // Catch:{ all -> 0x002a }
                        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x002a }
                        r2.d(r3, r4)     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        r2.AFAdRevenueData()     // Catch:{ all -> 0x002a }
                    L_0x00a8:
                        if (r1 == 0) goto L_0x00bb
                        com.appsflyer.internal.AFe1lSDK r2 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r2.component2     // Catch:{ all -> 0x002a }
                        java.util.List<com.appsflyer.internal.AFe1sSDK<?>> r2 = r2.areAllFieldsValid     // Catch:{ all -> 0x002a }
                        r3.addAll(r2)     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1lSDK r2 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                        java.util.List<com.appsflyer.internal.AFe1sSDK<?>> r2 = r2.areAllFieldsValid     // Catch:{ all -> 0x002a }
                        r2.clear()     // Catch:{ all -> 0x002a }
                        goto L_0x00d2
                    L_0x00bb:
                        com.appsflyer.AFLogger r2 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFg1cSDK r3 = com.appsflyer.internal.AFg1cSDK.QUEUE     // Catch:{ all -> 0x002a }
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
                        java.lang.String r5 = "task not added, it's already in the queue: "
                        r4.<init>(r5)     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r5 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        r4.append(r5)     // Catch:{ all -> 0x002a }
                        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x002a }
                        r2.d(r3, r4)     // Catch:{ all -> 0x002a }
                    L_0x00d2:
                        monitor-exit(r0)     // Catch:{ all -> 0x002a }
                        if (r1 == 0) goto L_0x0178
                        com.appsflyer.internal.AFe1lSDK r0 = com.appsflyer.internal.AFe1lSDK.this
                        java.util.Set<com.appsflyer.internal.AFe1mSDK> r0 = r0.component3
                        com.appsflyer.internal.AFe1sSDK r1 = r6.getMonetizationNetwork
                        com.appsflyer.internal.AFe1mSDK r1 = r1.getMonetizationNetwork
                        r0.add(r1)
                        com.appsflyer.AFLogger r0 = com.appsflyer.AFLogger.INSTANCE
                        com.appsflyer.internal.AFg1cSDK r1 = com.appsflyer.internal.AFg1cSDK.QUEUE
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        java.lang.String r3 = "new task added: "
                        r2.<init>(r3)
                        com.appsflyer.internal.AFe1sSDK r3 = r6.getMonetizationNetwork
                        r2.append(r3)
                        java.lang.String r2 = r2.toString()
                        r0.d(r1, r2)
                        com.appsflyer.internal.AFe1lSDK r0 = com.appsflyer.internal.AFe1lSDK.this
                        java.util.List<com.appsflyer.internal.AFe1qSDK> r0 = r0.AFAdRevenueData
                        java.util.Iterator r0 = r0.iterator()
                    L_0x00ff:
                        boolean r1 = r0.hasNext()
                        if (r1 == 0) goto L_0x010c
                        java.lang.Object r1 = r0.next()
                        com.appsflyer.internal.AFe1qSDK r1 = (com.appsflyer.internal.AFe1qSDK) r1
                        goto L_0x00ff
                    L_0x010c:
                        com.appsflyer.internal.AFe1lSDK r0 = com.appsflyer.internal.AFe1lSDK.this
                        java.util.concurrent.ExecutorService r1 = r0.getMediationNetwork
                        com.appsflyer.internal.AFe1lSDK$4 r2 = new com.appsflyer.internal.AFe1lSDK$4
                        r2.<init>()
                        r1.submit(r2)
                        com.appsflyer.internal.AFe1lSDK r0 = com.appsflyer.internal.AFe1lSDK.this
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r1 = r0.component2
                        monitor-enter(r1)
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r2 = r0.component2     // Catch:{ all -> 0x015a }
                        int r2 = r2.size()     // Catch:{ all -> 0x015a }
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component4     // Catch:{ all -> 0x015a }
                        int r3 = r3.size()     // Catch:{ all -> 0x015a }
                        int r2 = r2 + r3
                        int r2 = r2 + -40
                    L_0x012c:
                        if (r2 <= 0) goto L_0x0174
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component4     // Catch:{ all -> 0x015a }
                        boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x015a }
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r4 = r0.component2     // Catch:{ all -> 0x015a }
                        boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x015a }
                        if (r4 != 0) goto L_0x0162
                        if (r3 != 0) goto L_0x0162
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component2     // Catch:{ all -> 0x015a }
                        java.lang.Object r3 = r3.first()     // Catch:{ all -> 0x015a }
                        com.appsflyer.internal.AFe1sSDK r3 = (com.appsflyer.internal.AFe1sSDK) r3     // Catch:{ all -> 0x015a }
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r4 = r0.component4     // Catch:{ all -> 0x015a }
                        java.lang.Object r4 = r4.first()     // Catch:{ all -> 0x015a }
                        com.appsflyer.internal.AFe1sSDK r4 = (com.appsflyer.internal.AFe1sSDK) r4     // Catch:{ all -> 0x015a }
                        int r3 = r3.compareTo((com.appsflyer.internal.AFe1sSDK<?>) r4)     // Catch:{ all -> 0x015a }
                        if (r3 <= 0) goto L_0x015c
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component2     // Catch:{ all -> 0x015a }
                        r0.getMediationNetwork(r3)     // Catch:{ all -> 0x015a }
                        goto L_0x0171
                    L_0x015a:
                        r0 = move-exception
                        goto L_0x0176
                    L_0x015c:
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component4     // Catch:{ all -> 0x015a }
                        r0.getMediationNetwork(r3)     // Catch:{ all -> 0x015a }
                        goto L_0x0171
                    L_0x0162:
                        if (r4 != 0) goto L_0x016a
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component2     // Catch:{ all -> 0x015a }
                        r0.getMediationNetwork(r3)     // Catch:{ all -> 0x015a }
                        goto L_0x0171
                    L_0x016a:
                        if (r3 != 0) goto L_0x0171
                        java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component4     // Catch:{ all -> 0x015a }
                        r0.getMediationNetwork(r3)     // Catch:{ all -> 0x015a }
                    L_0x0171:
                        int r2 = r2 + -1
                        goto L_0x012c
                    L_0x0174:
                        monitor-exit(r1)     // Catch:{ all -> 0x015a }
                        return
                    L_0x0176:
                        monitor-exit(r1)
                        throw r0
                    L_0x0178:
                        com.appsflyer.AFLogger r0 = com.appsflyer.AFLogger.INSTANCE
                        com.appsflyer.internal.AFg1cSDK r1 = com.appsflyer.internal.AFg1cSDK.QUEUE
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        java.lang.String r3 = "QUEUE: tried to add already pending task: "
                        r2.<init>(r3)
                        com.appsflyer.internal.AFe1sSDK r3 = r6.getMonetizationNetwork
                        r2.append(r3)
                        java.lang.String r2 = r2.toString()
                        r0.w(r1, r2)
                        return
                    L_0x0190:
                        com.appsflyer.AFLogger r1 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFg1cSDK r2 = com.appsflyer.internal.AFg1cSDK.QUEUE     // Catch:{ all -> 0x002a }
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
                        java.lang.String r4 = "tried to add already scheduled task: "
                        r3.<init>(r4)     // Catch:{ all -> 0x002a }
                        com.appsflyer.internal.AFe1sSDK r4 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                        r3.append(r4)     // Catch:{ all -> 0x002a }
                        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x002a }
                        r1.d(r2, r3)     // Catch:{ all -> 0x002a }
                        monitor-exit(r0)     // Catch:{ all -> 0x002a }
                        return
                    L_0x01a9:
                        monitor-exit(r0)
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1lSDK.AnonymousClass5.run():void");
                }
            });
            return;
        }
        this.areAllFieldsValid.d().getMediationNetwork(hashMap);
    }
}
