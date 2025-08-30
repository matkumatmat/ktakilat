package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

public final class AFa1ySDK implements Runnable {
    private final String AFAdRevenueData;
    private final String areAllFieldsValid;
    private final Map<String, String> component1;
    private final String component3;
    final String getCurrencyIso4217Code;
    final String getMediationNetwork;
    private final WeakReference<Context> getMonetizationNetwork;
    final String getRevenue;

    public AFa1ySDK(Context context, String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map) {
        this.getMonetizationNetwork = new WeakReference<>(context);
        this.AFAdRevenueData = str;
        this.component3 = str2;
        this.getMediationNetwork = str4;
        this.getCurrencyIso4217Code = str5;
        this.getRevenue = str6;
        this.component1 = map;
        this.areAllFieldsValid = str3;
    }

    public static void getMediationNetwork(boolean z, String str, String str2, String str3, String str4) {
        if (AFa1tSDK.AFAdRevenueData != null) {
            StringBuilder u = e.u("Validate callback parameters: ", str, StringUtils.SPACE, str2, StringUtils.SPACE);
            u.append(str3);
            AFLogger.afDebugLog(u.toString());
            if (z) {
                AFLogger.afDebugLog("Validate in app purchase success: ".concat(String.valueOf(str4)));
                AFa1tSDK.AFAdRevenueData.onValidateInApp();
                return;
            }
            AFLogger.afDebugLog("Validate in app purchase failed: ".concat(String.valueOf(str4)));
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = AFa1tSDK.AFAdRevenueData;
            if (str4 == null) {
                str4 = "Failed validating";
            }
            appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure(str4);
        }
    }

    private static AFf1rSDK getRevenue(Context context, @NonNull AFh1hSDK aFh1hSDK) {
        ((AFa1tSDK) AFa1tSDK.getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis())).getMediationNetwork(context);
        AFc1dSDK AFAdRevenueData2 = ((AFa1tSDK) AFa1tSDK.getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis())).AFAdRevenueData();
        aFh1hSDK.AFAdRevenueData(AFAdRevenueData2.getRevenue().getMonetizationNetwork.AFAdRevenueData("appsFlyerCount", 0));
        AFf1rSDK aFf1rSDK = new AFf1rSDK(aFh1hSDK, AFAdRevenueData2);
        AFe1lSDK copydefault = AFAdRevenueData2.copydefault();
        copydefault.getRevenue.execute(new Runnable(aFf1rSDK) {
            private /* synthetic */ AFe1sSDK getMonetizationNetwork;

            {
                this.getMonetizationNetwork = r2;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d3, code lost:
                if (r1 == false) goto L_0x0178;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d5, code lost:
                r6.getRevenue.component3.add(r6.getMonetizationNetwork.getMonetizationNetwork);
                r0 = com.appsflyer.AFLogger.INSTANCE;
                r1 = com.appsflyer.internal.AFg1cSDK.QUEUE;
                r2 = new java.lang.StringBuilder("new task added: ");
                r2.append(r6.getMonetizationNetwork);
                r0.d(r1, r2.toString());
                r0 = r6.getRevenue.AFAdRevenueData.iterator();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:34:0x0103, code lost:
                if (r0.hasNext() == false) goto L_0x010c;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:35:0x0105, code lost:
                r1 = r0.next();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:36:0x010c, code lost:
                r0 = r6.getRevenue;
                r0.getMediationNetwork.submit(new com.appsflyer.internal.AFe1lSDK.AnonymousClass4(r0));
                r0 = r6.getRevenue;
                r1 = r0.component2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:37:0x011c, code lost:
                monitor-enter(r1);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
                r2 = (r0.component2.size() + r0.component4.size()) - 40;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:40:0x012c, code lost:
                if (r2 <= 0) goto L_0x0174;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:41:0x012e, code lost:
                r3 = r0.component4.isEmpty();
                r4 = r0.component2.isEmpty();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:42:0x013a, code lost:
                if (r4 != false) goto L_0x0162;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:43:0x013c, code lost:
                if (r3 != false) goto L_0x0162;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:45:0x0152, code lost:
                if (r0.component2.first().getCurrencyIso4217Code(r0.component4.first()) <= 0) goto L_0x015c;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:46:0x0154, code lost:
                r0.getMediationNetwork(r0.component2);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:47:0x015a, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:49:0x015c, code lost:
                r0.getMediationNetwork(r0.component4);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:50:0x0162, code lost:
                if (r4 != false) goto L_0x016a;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:51:0x0164, code lost:
                r0.getMediationNetwork(r0.component2);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:52:0x016a, code lost:
                if (r3 != false) goto L_0x0171;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:53:0x016c, code lost:
                r0.getMediationNetwork(r0.component4);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:54:0x0171, code lost:
                r2 = r2 - 1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:55:0x0174, code lost:
                monitor-exit(r1);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:56:0x0175, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:58:0x0177, code lost:
                throw r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:59:0x0178, code lost:
                r0 = com.appsflyer.AFLogger.INSTANCE;
                r1 = com.appsflyer.internal.AFg1cSDK.QUEUE;
                r2 = new java.lang.StringBuilder("QUEUE: tried to add already pending task: ");
                r2.append(r6.getMonetizationNetwork);
                r0.w(r1, r2.toString());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:60:0x018f, code lost:
                return;
             */
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
                    int r3 = r3.getCurrencyIso4217Code((com.appsflyer.internal.AFe1sSDK<?>) r4)     // Catch:{ all -> 0x015a }
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
        return aFf1rSDK;
    }

    public final void run() {
        AFb1mSDK aFb1mSDK;
        String str = this.AFAdRevenueData;
        if (str != null && str.length() != 0 && !AppsFlyerLib.getInstance().isStopped()) {
            try {
                Context context = this.getMonetizationNetwork.get();
                if (context != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("public-key", this.component3);
                    hashMap.put("sig-data", this.getMediationNetwork);
                    hashMap.put("signature", this.areAllFieldsValid);
                    HashMap hashMap2 = new HashMap(hashMap);
                    Map<String, String> map = this.component1;
                    String AFAdRevenueData2 = ((AFa1tSDK) AFa1tSDK.getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis())).AFAdRevenueData().component2().AFAdRevenueData("referrer", "");
                    AFi1zSDK aFi1zSDK = new AFi1zSDK();
                    aFi1zSDK.component3 = AFAdRevenueData2;
                    AFa1tSDK aFa1tSDK = (AFa1tSDK) AFa1tSDK.getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis());
                    Map<String, Object> mediationNetwork = aFa1tSDK.getMediationNetwork((AFh1rSDK) aFi1zSDK);
                    mediationNetwork.put(FirebaseAnalytics.Param.PRICE, this.getCurrencyIso4217Code);
                    mediationNetwork.put(FirebaseAnalytics.Param.CURRENCY, this.getRevenue);
                    mediationNetwork.put("receipt_data", hashMap2);
                    if (map != null) {
                        mediationNetwork.put("extra_prms", map);
                    }
                    mediationNetwork.putAll(aFa1tSDK.AFAdRevenueData().registerClient().getCurrencyIso4217Code());
                    aFi1zSDK.getMediationNetwork(mediationNetwork);
                    getRevenue(context, aFi1zSDK);
                    hashMap.put("dev_key", this.AFAdRevenueData);
                    hashMap.put("app_id", context.getPackageName());
                    hashMap.put("uid", AppsFlyerLib.getInstance().getAppsFlyerUID(context));
                    AFh1oSDK aFh1oSDK = ((AFa1tSDK) AFa1tSDK.getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis())).AFAdRevenueData().getRevenue().getCurrencyIso4217Code.component3;
                    String str2 = null;
                    if (aFh1oSDK != null) {
                        aFb1mSDK = new AFb1mSDK(aFh1oSDK.AFAdRevenueData, aFh1oSDK.getRevenue);
                    } else {
                        aFb1mSDK = null;
                    }
                    if (aFb1mSDK != null) {
                        str2 = aFb1mSDK.getMonetizationNetwork;
                    }
                    if (str2 != null) {
                        hashMap.put("advertiserId", str2);
                    }
                    AFh1gSDK aFh1gSDK = (AFh1gSDK) new AFh1gSDK().getMediationNetwork(hashMap);
                    final AFf1rSDK revenue = getRevenue(context, aFh1gSDK);
                    aFh1gSDK.getCurrencyIso4217Code = new AppsFlyerRequestListener() {
                        public final void onError(int i, @NonNull String str) {
                            AFd1aSDK<Result> aFd1aSDK;
                            if (i == 50 && (aFd1aSDK = revenue.component1) != null) {
                                str = aFd1aSDK.toString();
                            }
                            AFa1ySDK aFa1ySDK = AFa1ySDK.this;
                            AFa1ySDK.getMediationNetwork(false, aFa1ySDK.getMediationNetwork, aFa1ySDK.getCurrencyIso4217Code, aFa1ySDK.getRevenue, str);
                        }

                        public final void onSuccess() {
                            try {
                                JSONObject jSONObject = new JSONObject((String) revenue.component1.getBody());
                                AFLogger.afInfoLog("Validate response ok: ".concat(String.valueOf(jSONObject)));
                                boolean optBoolean = jSONObject.optBoolean("result");
                                AFa1ySDK aFa1ySDK = AFa1ySDK.this;
                                AFa1ySDK.getMediationNetwork(optBoolean, aFa1ySDK.getMediationNetwork, aFa1ySDK.getCurrencyIso4217Code, aFa1ySDK.getRevenue, jSONObject.toString());
                            } catch (Exception e) {
                                AFLogger.afErrorLog("Failed Validate request: ".concat(String.valueOf(e)), e);
                                AFa1ySDK aFa1ySDK2 = AFa1ySDK.this;
                                AFa1ySDK.getMediationNetwork(false, aFa1ySDK2.getMediationNetwork, aFa1ySDK2.getCurrencyIso4217Code, aFa1ySDK2.getRevenue, e.getMessage());
                            }
                        }
                    };
                }
            } catch (Throwable th) {
                if (AFa1tSDK.AFAdRevenueData != null) {
                    AFLogger.afErrorLog("Failed Validate request + ex", th);
                    getMediationNetwork(false, this.getMediationNetwork, this.getCurrencyIso4217Code, this.getRevenue, th.getMessage());
                }
                AFLogger.afErrorLog(th.getMessage(), th);
            }
        }
    }
}
