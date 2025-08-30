package com.appsflyer.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import com.appsflyer.AFLogger;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class AFj1uSDK extends AFi1dSDK {
    @NotNull
    private final ExecutorService getMediationNetwork;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AFj1uSDK(@NotNull ExecutorService executorService, @NotNull AFc1pSDK aFc1pSDK, @NotNull Runnable runnable) {
        super("preload", "samsung", aFc1pSDK, runnable);
        Intrinsics.checkNotNullParameter(executorService, "");
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(runnable, "");
        this.getMediationNetwork = executorService;
    }

    private final boolean AFAdRevenueData(Context context) {
        if (!getRevenue()) {
            AFg1gSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.SAMSUNG_PRELOAD_REFERRER, "Referrer collection disallowed by counter.", false, 4, (Object) null);
            return false;
        } else if (getCurrencyIso4217Code(context)) {
            return true;
        } else {
            AFg1gSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.SAMSUNG_PRELOAD_REFERRER, "Referrer collection disallowed by missing content provider.", false, 4, (Object) null);
            return false;
        }
    }

    private static boolean C_(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("RESULT");
        if (columnIndex != -1) {
            return Boolean.parseBoolean(cursor.getString(columnIndex));
        }
        AFg1gSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.SAMSUNG_PRELOAD_REFERRER, "No such column", false, 4, (Object) null);
        return false;
    }

    private static boolean getCurrencyIso4217Code(Context context) {
        if (context.getPackageManager().resolveContentProvider("com.samsung.android.mapsagent.providers.apptracking", 0) != null) {
            return true;
        }
        return false;
    }

    public final void getMonetizationNetwork() {
    }

    @SuppressLint({"NewApi"})
    public final void getRevenue(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        if (AFAdRevenueData(context)) {
            this.getMediationNetwork.execute(new h(2, this, context));
        }
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v3, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x010e, code lost:
        if (r4 != null) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0110, code lost:
        r4.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0114, code lost:
        if (r4 != null) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0116, code lost:
        r4.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012f, code lost:
        if (r4 != null) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0132, code lost:
        if (r4 != null) goto L_0x0116;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0147 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x014e A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0154  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void getMonetizationNetwork(com.appsflyer.internal.AFj1uSDK r12, android.content.Context r13) {
        /*
            java.lang.String r0 = "com.samsung.android.mapsagent"
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r1)
            long r2 = java.lang.System.currentTimeMillis()
            r12.component1 = r2
            com.appsflyer.internal.AFj1qSDK$AFa1ySDK r2 = com.appsflyer.internal.AFj1qSDK.AFa1ySDK.STARTED
            r12.component4 = r2
            com.appsflyer.internal.AFj1qSDK$5 r2 = new com.appsflyer.internal.AFj1qSDK$5
            r2.<init>()
            r12.addObserver(r2)
            r2 = 24
            r3 = 0
            java.lang.String r4 = "content://com.samsung.android.mapsagent.providers.apptracking/info"
            android.net.Uri r6 = android.net.Uri.parse(r4)     // Catch:{ all -> 0x0135 }
            android.content.ContentResolver r4 = r13.getContentResolver()     // Catch:{ all -> 0x0135 }
            android.content.ContentProviderClient r4 = r4.acquireUnstableContentProviderClient(r6)     // Catch:{ all -> 0x0135 }
            if (r4 == 0) goto L_0x0046
            java.lang.String r8 = r13.getPackageName()     // Catch:{ all -> 0x0041 }
            java.lang.String r5 = "appsflyer001"
            java.lang.String[] r9 = new java.lang.String[]{r5}     // Catch:{ all -> 0x0041 }
            r10 = 0
            r7 = 0
            r5 = r4
            android.database.Cursor r5 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0041 }
            goto L_0x0047
        L_0x0041:
            r13 = move-exception
            r7 = r13
            r13 = r4
            goto L_0x0138
        L_0x0046:
            r5 = r3
        L_0x0047:
            if (r5 == 0) goto L_0x011a
            boolean r6 = r5.moveToFirst()     // Catch:{ all -> 0x0077 }
            if (r6 != 0) goto L_0x0051
            goto L_0x011a
        L_0x0051:
            boolean r6 = C_(r5)     // Catch:{ all -> 0x0077 }
            if (r6 == 0) goto L_0x00fb
            java.lang.String r6 = "INSTALLED_TIME_TEXT"
            java.lang.String r6 = com.appsflyer.internal.AFj1kSDK.P_(r5, r6)     // Catch:{ all -> 0x0077 }
            if (r6 == 0) goto L_0x007d
            java.lang.String r7 = "yy:MM:dd:hh:mm"
            java.util.Date r6 = com.appsflyer.internal.AFj1mSDK.getCurrencyIso4217Code(r6, r7)     // Catch:{ all -> 0x0077 }
            if (r6 == 0) goto L_0x007d
            long r6 = r6.getTime()     // Catch:{ all -> 0x0077 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0077 }
            long r6 = r3.toSeconds(r6)     // Catch:{ all -> 0x0077 }
            java.lang.Long r3 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0077 }
            goto L_0x007d
        L_0x0077:
            r13 = move-exception
            r7 = r13
            r13 = r4
            r3 = r5
            goto L_0x0138
        L_0x007d:
            if (r3 == 0) goto L_0x0091
            long r6 = r3.longValue()     // Catch:{ all -> 0x0077 }
            java.util.Map<java.lang.String, java.lang.Object> r3 = r12.AFAdRevenueData     // Catch:{ all -> 0x0077 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)     // Catch:{ all -> 0x0077 }
            java.lang.String r8 = "install_begin_ts"
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0077 }
            r3.put(r8, r6)     // Catch:{ all -> 0x0077 }
        L_0x0091:
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap     // Catch:{ all -> 0x0077 }
            r3.<init>()     // Catch:{ all -> 0x0077 }
            java.lang.String r6 = "MAPS_ID"
            java.lang.String r6 = com.appsflyer.internal.AFj1kSDK.P_(r5, r6)     // Catch:{ all -> 0x0077 }
            if (r6 == 0) goto L_0x00a3
            java.lang.String r7 = "maps_id"
            r3.put(r7, r6)     // Catch:{ all -> 0x0077 }
        L_0x00a3:
            java.lang.String r6 = "DEVICE_NAME"
            java.lang.String r6 = com.appsflyer.internal.AFj1kSDK.P_(r5, r6)     // Catch:{ all -> 0x0077 }
            if (r6 == 0) goto L_0x00b0
            java.lang.String r7 = "device_model"
            r3.put(r7, r6)     // Catch:{ all -> 0x0077 }
        L_0x00b0:
            java.lang.String r6 = "COUNTRY"
            java.lang.String r6 = com.appsflyer.internal.AFj1kSDK.P_(r5, r6)     // Catch:{ all -> 0x0077 }
            if (r6 == 0) goto L_0x00bd
            java.lang.String r7 = "country"
            r3.put(r7, r6)     // Catch:{ all -> 0x0077 }
        L_0x00bd:
            java.lang.String r6 = "CAMPAIGN_ID"
            java.lang.String r6 = com.appsflyer.internal.AFj1kSDK.P_(r5, r6)     // Catch:{ all -> 0x0077 }
            if (r6 == 0) goto L_0x00ca
            java.lang.String r7 = "campaign_id"
            r3.put(r7, r6)     // Catch:{ all -> 0x0077 }
        L_0x00ca:
            boolean r6 = r3.isEmpty()     // Catch:{ all -> 0x0077 }
            if (r6 != 0) goto L_0x00da
            java.util.Map<java.lang.String, java.lang.Object> r6 = r12.AFAdRevenueData     // Catch:{ all -> 0x0077 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)     // Catch:{ all -> 0x0077 }
            java.lang.String r7 = "samsung_custom"
            r6.put(r7, r3)     // Catch:{ all -> 0x0077 }
        L_0x00da:
            java.util.Map<java.lang.String, java.lang.Object> r3 = r12.AFAdRevenueData     // Catch:{ all -> 0x0077 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)     // Catch:{ all -> 0x0077 }
            java.lang.String r6 = "api_ver"
            long r7 = com.appsflyer.internal.AFj1iSDK.AFAdRevenueData(r13, r0)     // Catch:{ all -> 0x0077 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0077 }
            r3.put(r6, r7)     // Catch:{ all -> 0x0077 }
            java.util.Map<java.lang.String, java.lang.Object> r3 = r12.AFAdRevenueData     // Catch:{ all -> 0x0077 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)     // Catch:{ all -> 0x0077 }
            java.lang.String r1 = "api_ver_name"
            java.lang.String r13 = com.appsflyer.internal.AFj1iSDK.getMediationNetwork(r13, r0)     // Catch:{ all -> 0x0077 }
            r3.put(r1, r13)     // Catch:{ all -> 0x0077 }
            goto L_0x0107
        L_0x00fb:
            com.appsflyer.AFLogger r6 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x0077 }
            com.appsflyer.internal.AFg1cSDK r7 = com.appsflyer.internal.AFg1cSDK.SAMSUNG_PRELOAD_REFERRER     // Catch:{ all -> 0x0077 }
            java.lang.String r8 = "App was not installed via Samsung MAPS."
            r10 = 4
            r11 = 0
            r9 = 0
            com.appsflyer.internal.AFg1gSDK.i$default(r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0077 }
        L_0x0107:
            r5.close()
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 < r2) goto L_0x0114
            if (r4 == 0) goto L_0x0159
        L_0x0110:
            r4.release()
            goto L_0x0159
        L_0x0114:
            if (r4 == 0) goto L_0x0159
        L_0x0116:
            r4.release()
            goto L_0x0159
        L_0x011a:
            com.appsflyer.AFLogger r6 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x0077 }
            com.appsflyer.internal.AFg1cSDK r7 = com.appsflyer.internal.AFg1cSDK.SAMSUNG_PRELOAD_REFERRER     // Catch:{ all -> 0x0077 }
            java.lang.String r8 = "Content provider returned no data"
            r10 = 4
            r11 = 0
            r9 = 0
            com.appsflyer.internal.AFg1gSDK.d$default(r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0077 }
            if (r5 == 0) goto L_0x012b
            r5.close()
        L_0x012b:
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 < r2) goto L_0x0132
            if (r4 == 0) goto L_0x0159
            goto L_0x0110
        L_0x0132:
            if (r4 == 0) goto L_0x0159
            goto L_0x0116
        L_0x0135:
            r13 = move-exception
            r7 = r13
            r13 = r3
        L_0x0138:
            com.appsflyer.AFLogger r4 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x015d }
            com.appsflyer.internal.AFg1cSDK r5 = com.appsflyer.internal.AFg1cSDK.SAMSUNG_PRELOAD_REFERRER     // Catch:{ all -> 0x015d }
            java.lang.String r6 = "Error while collecting referrer data"
            r10 = 1
            r11 = 1
            r8 = 0
            r9 = 0
            r4.e(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x015d }
            if (r3 == 0) goto L_0x014a
            r3.close()
        L_0x014a:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r2) goto L_0x0154
            if (r13 == 0) goto L_0x0159
            r13.release()
            goto L_0x0159
        L_0x0154:
            if (r13 == 0) goto L_0x0159
            r13.release()
        L_0x0159:
            r12.getMediationNetwork()
            return
        L_0x015d:
            r12 = move-exception
            if (r3 == 0) goto L_0x0163
            r3.close()
        L_0x0163:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r2) goto L_0x016d
            if (r13 == 0) goto L_0x0172
            r13.release()
            goto L_0x0172
        L_0x016d:
            if (r13 == 0) goto L_0x0172
            r13.release()
        L_0x0172:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFj1uSDK.getMonetizationNetwork(com.appsflyer.internal.AFj1uSDK, android.content.Context):void");
    }
}
