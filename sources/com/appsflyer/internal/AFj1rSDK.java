package com.appsflyer.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.appsflyer.AFLogger;

public final class AFj1rSDK extends AFj1qSDK {
    final ProviderInfo getMediationNetwork;
    private final AFc1dSDK getMonetizationNetwork;

    public AFj1rSDK(ProviderInfo providerInfo, Runnable runnable, AFc1dSDK aFc1dSDK) {
        super("af_referrer", providerInfo.authority, runnable);
        this.getMonetizationNetwork = aFc1dSDK;
        this.getMediationNetwork = providerInfo;
    }

    @VisibleForTesting
    @Nullable
    public static ContentProviderClient B_(Context context, Uri uri) {
        try {
            return context.getContentResolver().acquireUnstableContentProviderClient(uri);
        } catch (SecurityException e) {
            AFLogger.INSTANCE.e(AFg1cSDK.PREINSTALL, "Failed to acquire unstable content providerClient due to SecurityException", e, false, true, false);
            return null;
        } catch (Throwable th) {
            AFLogger.INSTANCE.e(AFg1cSDK.PREINSTALL, "Failed to acquire unstable content providerClient due to unexpected throwable", th, false, true, false);
            return null;
        }
    }

    public final void getRevenue(final Context context) {
        this.getMonetizationNetwork.getMonetizationNetwork().execute(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x007a, code lost:
                if (android.os.Build.VERSION.SDK_INT < 24) goto L_0x0080;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x007c, code lost:
                r0.release();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0080, code lost:
                r0.release();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x0094, code lost:
                if (android.os.Build.VERSION.SDK_INT < 24) goto L_0x0080;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a5, code lost:
                if (android.os.Build.VERSION.SDK_INT < 24) goto L_0x0080;
             */
            /* JADX WARNING: Removed duplicated region for block: B:38:0x00b9  */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x0100  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r15 = this;
                    com.appsflyer.internal.AFj1rSDK r0 = com.appsflyer.internal.AFj1rSDK.this
                    long r1 = java.lang.System.currentTimeMillis()
                    r0.component1 = r1
                    com.appsflyer.internal.AFj1qSDK$AFa1ySDK r1 = com.appsflyer.internal.AFj1qSDK.AFa1ySDK.STARTED
                    r0.component4 = r1
                    com.appsflyer.internal.AFj1qSDK$5 r1 = new com.appsflyer.internal.AFj1qSDK$5
                    r1.<init>()
                    r0.addObserver(r1)
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r1 = "content://"
                    r0.<init>(r1)
                    com.appsflyer.internal.AFj1rSDK r1 = com.appsflyer.internal.AFj1rSDK.this
                    android.content.pm.ProviderInfo r1 = r1.getMediationNetwork
                    java.lang.String r1 = r1.authority
                    r0.append(r1)
                    java.lang.String r1 = "/transaction_id"
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    android.net.Uri r2 = android.net.Uri.parse(r0)
                    android.content.Context r0 = r2
                    android.content.ContentProviderClient r0 = com.appsflyer.internal.AFj1rSDK.B_(r0, r2)
                    if (r0 == 0) goto L_0x00b4
                    r7 = 24
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ DeadObjectException -> 0x0069, RemoteException -> 0x0066, all -> 0x0063 }
                    java.lang.String r3 = "app_id="
                    r1.<init>(r3)     // Catch:{ DeadObjectException -> 0x0069, RemoteException -> 0x0066, all -> 0x0063 }
                    android.content.Context r3 = r2     // Catch:{ DeadObjectException -> 0x0069, RemoteException -> 0x0066, all -> 0x0063 }
                    java.lang.String r3 = r3.getPackageName()     // Catch:{ DeadObjectException -> 0x0069, RemoteException -> 0x0066, all -> 0x0063 }
                    r1.append(r3)     // Catch:{ DeadObjectException -> 0x0069, RemoteException -> 0x0066, all -> 0x0063 }
                    java.lang.String r4 = r1.toString()     // Catch:{ DeadObjectException -> 0x0069, RemoteException -> 0x0066, all -> 0x0063 }
                    r5 = 0
                    r6 = 0
                    r3 = 0
                    r1 = r0
                    android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ DeadObjectException -> 0x0069, RemoteException -> 0x0066, all -> 0x0063 }
                    int r2 = android.os.Build.VERSION.SDK_INT
                    if (r2 < r7) goto L_0x005f
                    r0.release()
                    goto L_0x00b5
                L_0x005f:
                    r0.release()
                    goto L_0x00b5
                L_0x0063:
                    r1 = move-exception
                    r11 = r1
                    goto L_0x006c
                L_0x0066:
                    r1 = move-exception
                    r11 = r1
                    goto L_0x0086
                L_0x0069:
                    r1 = move-exception
                    r11 = r1
                    goto L_0x0097
                L_0x006c:
                    com.appsflyer.AFLogger r8 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x0084 }
                    com.appsflyer.internal.AFg1cSDK r9 = com.appsflyer.internal.AFg1cSDK.PREINSTALL     // Catch:{ all -> 0x0084 }
                    java.lang.String r10 = "Error to get data from providerClient "
                    r13 = 1
                    r14 = 0
                    r12 = 0
                    r8.e(r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0084 }
                    int r1 = android.os.Build.VERSION.SDK_INT
                    if (r1 < r7) goto L_0x0080
                L_0x007c:
                    r0.release()
                    goto L_0x00b4
                L_0x0080:
                    r0.release()
                    goto L_0x00b4
                L_0x0084:
                    r1 = move-exception
                    goto L_0x00a8
                L_0x0086:
                    com.appsflyer.AFLogger r8 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x0084 }
                    com.appsflyer.internal.AFg1cSDK r9 = com.appsflyer.internal.AFg1cSDK.PREINSTALL     // Catch:{ all -> 0x0084 }
                    java.lang.String r10 = "Failed to query unstable content providerClient"
                    r13 = 1
                    r14 = 0
                    r12 = 0
                    r8.e(r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0084 }
                    int r1 = android.os.Build.VERSION.SDK_INT
                    if (r1 < r7) goto L_0x0080
                    goto L_0x007c
                L_0x0097:
                    com.appsflyer.AFLogger r8 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x0084 }
                    com.appsflyer.internal.AFg1cSDK r9 = com.appsflyer.internal.AFg1cSDK.PREINSTALL     // Catch:{ all -> 0x0084 }
                    java.lang.String r10 = "Failed to acquire unstable content providerClient"
                    r13 = 1
                    r14 = 0
                    r12 = 0
                    r8.e(r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0084 }
                    int r1 = android.os.Build.VERSION.SDK_INT
                    if (r1 < r7) goto L_0x0080
                    goto L_0x007c
                L_0x00a8:
                    int r2 = android.os.Build.VERSION.SDK_INT
                    if (r2 < r7) goto L_0x00b0
                    r0.release()
                    goto L_0x00b3
                L_0x00b0:
                    r0.release()
                L_0x00b3:
                    throw r1
                L_0x00b4:
                    r1 = 0
                L_0x00b5:
                    java.lang.String r0 = "response"
                    if (r1 == 0) goto L_0x0100
                    java.lang.String r2 = "transaction_id"
                    int r2 = r1.getColumnIndex(r2)
                    r3 = -1
                    if (r2 != r3) goto L_0x00d5
                    com.appsflyer.AFLogger r2 = com.appsflyer.AFLogger.INSTANCE
                    com.appsflyer.internal.AFg1cSDK r3 = com.appsflyer.internal.AFg1cSDK.PREINSTALL
                    java.lang.String r4 = "Wrong column name"
                    r2.w(r3, r4)
                    com.appsflyer.internal.AFj1rSDK r2 = com.appsflyer.internal.AFj1rSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r2 = r2.AFAdRevenueData
                    java.lang.String r3 = "FEATURE_NOT_SUPPORTED"
                    r2.put(r0, r3)
                    goto L_0x00fc
                L_0x00d5:
                    com.appsflyer.internal.AFj1rSDK r3 = com.appsflyer.internal.AFj1rSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFAdRevenueData
                    java.lang.String r4 = "OK"
                    r3.put(r0, r4)
                    boolean r0 = r1.moveToFirst()
                    if (r0 == 0) goto L_0x00fc
                    java.lang.String r0 = r1.getString(r2)
                    r1.close()
                    if (r0 == 0) goto L_0x00fc
                    boolean r2 = r0.isEmpty()
                    if (r2 != 0) goto L_0x00fc
                    com.appsflyer.internal.AFj1rSDK r2 = com.appsflyer.internal.AFj1rSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r2 = r2.AFAdRevenueData
                    java.lang.String r3 = "referrer"
                    r2.put(r3, r0)
                L_0x00fc:
                    r1.close()
                    goto L_0x0112
                L_0x0100:
                    com.appsflyer.AFLogger r1 = com.appsflyer.AFLogger.INSTANCE
                    com.appsflyer.internal.AFg1cSDK r2 = com.appsflyer.internal.AFg1cSDK.PREINSTALL
                    java.lang.String r3 = "ContentProvider query failed, got null Cursor"
                    r1.w(r2, r3)
                    com.appsflyer.internal.AFj1rSDK r1 = com.appsflyer.internal.AFj1rSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r1 = r1.AFAdRevenueData
                    java.lang.String r2 = "SERVICE_UNAVAILABLE"
                    r1.put(r0, r2)
                L_0x0112:
                    com.appsflyer.internal.AFj1rSDK r0 = com.appsflyer.internal.AFj1rSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r1 = r0.AFAdRevenueData
                    android.content.Context r2 = r2
                    android.content.pm.ProviderInfo r0 = r0.getMediationNetwork
                    java.lang.String r0 = r0.packageName
                    long r2 = com.appsflyer.internal.AFj1iSDK.AFAdRevenueData(r2, r0)
                    java.lang.Long r0 = java.lang.Long.valueOf(r2)
                    java.lang.String r2 = "api_ver"
                    r1.put(r2, r0)
                    com.appsflyer.internal.AFj1rSDK r0 = com.appsflyer.internal.AFj1rSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r1 = r0.AFAdRevenueData
                    android.content.Context r2 = r2
                    android.content.pm.ProviderInfo r0 = r0.getMediationNetwork
                    java.lang.String r0 = r0.packageName
                    java.lang.String r0 = com.appsflyer.internal.AFj1iSDK.getMediationNetwork(r2, r0)
                    java.lang.String r2 = "api_ver_name"
                    r1.put(r2, r0)
                    com.appsflyer.internal.AFj1rSDK r0 = com.appsflyer.internal.AFj1rSDK.this
                    r0.getMediationNetwork()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFj1rSDK.AnonymousClass5.run():void");
            }
        });
    }
}
