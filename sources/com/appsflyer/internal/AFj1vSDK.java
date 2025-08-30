package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;

public final class AFj1vSDK extends AFi1dSDK {
    private final AFc1dSDK getCurrencyIso4217Code;
    private final AFi1eSDK getMediationNetwork;

    public AFj1vSDK(Runnable runnable, AFc1dSDK aFc1dSDK, AFi1eSDK aFi1eSDK) {
        super("store", "huawei", aFc1dSDK.getRevenue(), runnable);
        this.getCurrencyIso4217Code = aFc1dSDK;
        this.getMediationNetwork = aFi1eSDK;
    }

    private boolean AFAdRevenueData(Context context) {
        if (!getRevenue()) {
            AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, "Huawei referrer collection disallowed by counter.");
            return false;
        } else if (!this.getMediationNetwork.getRevenue(context)) {
            AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, "Huawei referrer collection disallowed by missing content provider.");
            return false;
        } else if (this.getMediationNetwork.AFAdRevenueData(context)) {
            return true;
        } else {
            AFLogger.INSTANCE.d(AFg1cSDK.REFERRER, "Huawei referrer collection disallowed by invalid content provider.");
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00dd, code lost:
        if (r2 != null) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00df, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0102, code lost:
        if (r2 == null) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0105, code lost:
        getMediationNetwork();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0108, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void getCurrencyIso4217Code(android.content.Context r10) {
        /*
            r9 = this;
            java.lang.String r0 = "FEATURE_NOT_SUPPORTED"
            java.lang.String r1 = "response"
            long r2 = java.lang.System.currentTimeMillis()
            r9.component1 = r2
            com.appsflyer.internal.AFj1qSDK$AFa1ySDK r2 = com.appsflyer.internal.AFj1qSDK.AFa1ySDK.STARTED
            r9.component4 = r2
            com.appsflyer.internal.AFj1qSDK$5 r2 = new com.appsflyer.internal.AFj1qSDK$5
            r2.<init>()
            r9.addObserver(r2)
            android.content.pm.PackageManager r2 = r10.getPackageManager()
            java.lang.String r3 = "com.huawei.appmarket.commondata"
            r4 = 128(0x80, float:1.794E-43)
            android.content.pm.ProviderInfo r2 = r2.resolveContentProvider(r3, r4)
            java.lang.String r2 = r2.packageName
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.AFAdRevenueData
            long r4 = com.appsflyer.internal.AFj1iSDK.AFAdRevenueData(r10, r2)
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.String r5 = "api_ver"
            r3.put(r5, r4)
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.AFAdRevenueData
            java.lang.String r4 = "api_ver_name"
            java.lang.String r2 = com.appsflyer.internal.AFj1iSDK.getMediationNetwork(r10, r2)
            r3.put(r4, r2)
            r2 = 0
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ all -> 0x00bb }
            java.lang.String r4 = "content://com.huawei.appmarket.commondata/item/5"
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ all -> 0x00bb }
            java.lang.String r10 = r10.getPackageName()     // Catch:{ all -> 0x00bb }
            java.lang.String[] r7 = new java.lang.String[]{r10}     // Catch:{ all -> 0x00bb }
            r8 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00bb }
            if (r2 == 0) goto L_0x00d6
            boolean r10 = r2.moveToFirst()     // Catch:{ all -> 0x00bb }
            if (r10 == 0) goto L_0x00d0
            java.util.Map<java.lang.String, java.lang.Object> r10 = r9.AFAdRevenueData     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = "OK"
            r10.put(r1, r3)     // Catch:{ all -> 0x00bb }
            java.util.Map<java.lang.String, java.lang.Object> r10 = r9.AFAdRevenueData     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = "referrer"
            r4 = 0
            java.lang.String r4 = r2.getString(r4)     // Catch:{ all -> 0x00bb }
            r10.put(r3, r4)     // Catch:{ all -> 0x00bb }
            java.util.Map<java.lang.String, java.lang.Object> r10 = r9.AFAdRevenueData     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = "click_ts"
            r4 = 1
            long r4 = r2.getLong(r4)     // Catch:{ all -> 0x00bb }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x00bb }
            r10.put(r3, r4)     // Catch:{ all -> 0x00bb }
            java.util.Map<java.lang.String, java.lang.Object> r10 = r9.AFAdRevenueData     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = "install_end_ts"
            r4 = 2
            long r4 = r2.getLong(r4)     // Catch:{ all -> 0x00bb }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x00bb }
            r10.put(r3, r4)     // Catch:{ all -> 0x00bb }
            int r10 = r2.getColumnCount()     // Catch:{ all -> 0x00bb }
            r3 = 3
            if (r10 <= r3) goto L_0x00dd
            java.util.Map<java.lang.String, java.lang.Object> r10 = r9.AFAdRevenueData     // Catch:{ all -> 0x00bb }
            java.lang.String r4 = "install_begin_ts"
            long r5 = r2.getLong(r3)     // Catch:{ all -> 0x00bb }
            java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x00bb }
            r10.put(r4, r3)     // Catch:{ all -> 0x00bb }
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ all -> 0x00bb }
            r10.<init>()     // Catch:{ all -> 0x00bb }
            r3 = 4
            java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x00bb }
            if (r3 == 0) goto L_0x00be
            java.lang.String r4 = "track_id"
            r10.put(r4, r3)     // Catch:{ all -> 0x00bb }
            goto L_0x00be
        L_0x00bb:
            r10 = move-exception
            r6 = r10
            goto L_0x00e3
        L_0x00be:
            java.lang.String r3 = "referrer_ex"
            r4 = 5
            java.lang.String r4 = r2.getString(r4)     // Catch:{ all -> 0x00bb }
            r10.put(r3, r4)     // Catch:{ all -> 0x00bb }
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.AFAdRevenueData     // Catch:{ all -> 0x00bb }
            java.lang.String r4 = "huawei_custom"
            r3.put(r4, r10)     // Catch:{ all -> 0x00bb }
            goto L_0x00dd
        L_0x00d0:
            java.util.Map<java.lang.String, java.lang.Object> r10 = r9.AFAdRevenueData     // Catch:{ all -> 0x00bb }
            r10.put(r1, r0)     // Catch:{ all -> 0x00bb }
            goto L_0x00dd
        L_0x00d6:
            java.util.Map<java.lang.String, java.lang.Object> r10 = r9.AFAdRevenueData     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = "SERVICE_UNAVAILABLE"
            r10.put(r1, r3)     // Catch:{ all -> 0x00bb }
        L_0x00dd:
            if (r2 == 0) goto L_0x0105
        L_0x00df:
            r2.close()
            goto L_0x0105
        L_0x00e3:
            java.util.Map<java.lang.String, java.lang.Object> r10 = r9.AFAdRevenueData     // Catch:{ all -> 0x00f8 }
            r10.put(r1, r0)     // Catch:{ all -> 0x00f8 }
            com.appsflyer.AFLogger r3 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x00f8 }
            com.appsflyer.internal.AFg1cSDK r4 = com.appsflyer.internal.AFg1cSDK.REFERRER     // Catch:{ all -> 0x00f8 }
            java.lang.String r10 = r6.getMessage()     // Catch:{ all -> 0x00f8 }
            if (r10 == 0) goto L_0x00fa
            java.lang.String r10 = r6.getMessage()     // Catch:{ all -> 0x00f8 }
        L_0x00f6:
            r5 = r10
            goto L_0x00fd
        L_0x00f8:
            r10 = move-exception
            goto L_0x0109
        L_0x00fa:
            java.lang.String r10 = ""
            goto L_0x00f6
        L_0x00fd:
            r7 = 0
            r8 = 1
            r3.e(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00f8 }
            if (r2 == 0) goto L_0x0105
            goto L_0x00df
        L_0x0105:
            r9.getMediationNetwork()
            return
        L_0x0109:
            if (r2 == 0) goto L_0x010e
            r2.close()
        L_0x010e:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFj1vSDK.getCurrencyIso4217Code(android.content.Context):void");
    }

    public final void getRevenue(Context context) {
        if (AFAdRevenueData(context)) {
            this.getCurrencyIso4217Code.getMonetizationNetwork().execute(new h(3, this, context));
        }
    }
}
