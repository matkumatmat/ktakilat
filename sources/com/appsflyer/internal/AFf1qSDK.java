package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.components.network.http.exceptions.HttpException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

public final class AFf1qSDK extends AFe1sSDK<AFf1nSDK> {
    @Nullable
    public final AFf1mSDK areAllFieldsValid;
    @Nullable
    public AFf1nSDK component1 = null;
    private final AFf1pSDK component2;
    public AFi1vSDK component3;
    private final AFc1pSDK component4;
    private final AFf1gSDK copy;
    private final AFf1lSDK copydefault;
    private final String equals;
    private final AFf1iSDK hashCode;
    private final AFd1oSDK toString;

    public AFf1qSDK(@NonNull AFf1pSDK aFf1pSDK, @NonNull AFc1pSDK aFc1pSDK, @NonNull AFf1gSDK aFf1gSDK, @NonNull AFf1lSDK aFf1lSDK, @NonNull AFd1oSDK aFd1oSDK, @NonNull AFf1iSDK aFf1iSDK, @NonNull String str, @Nullable AFf1mSDK aFf1mSDK) {
        super(AFe1mSDK.RC_CDN, new AFe1mSDK[0], "UpdateRemoteConfiguration");
        this.component2 = aFf1pSDK;
        this.component4 = aFc1pSDK;
        this.copy = aFf1gSDK;
        this.copydefault = aFf1lSDK;
        this.toString = aFd1oSDK;
        this.hashCode = aFf1iSDK;
        this.equals = str;
        this.areAllFieldsValid = aFf1mSDK;
    }

    private void AFAdRevenueData(String str, long j, AFi1ySDK aFi1ySDK, @Nullable String str2, @Nullable AFd1aSDK<AFi1wSDK> aFd1aSDK) {
        AFi1wSDK aFi1wSDK;
        String str3;
        if (aFd1aSDK != null) {
            aFi1wSDK = aFd1aSDK.getBody();
        } else {
            aFi1wSDK = null;
        }
        if (str2 != null) {
            str3 = str2;
        } else {
            str3 = null;
        }
        getRevenue(str, j, aFd1aSDK, aFi1wSDK, aFi1ySDK, str3, (Throwable) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0060 A[SYNTHETIC, Splitter:B:12:0x0060] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.appsflyer.internal.AFf1nSDK component1() throws java.lang.InterruptedException, java.io.InterruptedIOException {
        /*
            r19 = this;
            r10 = r19
            r0 = 2
            java.lang.String r1 = " seconds"
            long r8 = java.lang.System.currentTimeMillis()
            java.lang.String r2 = r10.equals
            com.appsflyer.internal.AFf1gSDK r3 = r10.copy
            java.lang.String r3 = r3.getMediationNetwork()
            java.lang.String r4 = "Dev key is not set, SDK is not started."
            if (r3 == 0) goto L_0x004a
            java.lang.String r5 = r3.trim()
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0020
            goto L_0x004a
        L_0x0020:
            if (r2 != 0) goto L_0x002d
            com.appsflyer.AFLogger r2 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r3 = com.appsflyer.internal.AFg1cSDK.REMOTE_CONTROL
            java.lang.String r5 = "Can't create CDN token, domain or version is not provided."
            r2.w(r3, r5)
        L_0x002b:
            r12 = 0
            goto L_0x0052
        L_0x002d:
            com.appsflyer.internal.AFc1pSDK r5 = r10.component4
            com.appsflyer.internal.AFc1iSDK r5 = r5.getRevenue
            android.content.Context r5 = r5.getMonetizationNetwork
            java.lang.String r5 = r5.getPackageName()
            java.lang.String r6 = "appsflyersdk.com"
            java.lang.String[] r2 = new java.lang.String[]{r6, r2, r5}
            java.lang.String r5 = "⁣"
            java.lang.String r2 = android.text.TextUtils.join(r5, r2)
            java.lang.String r2 = com.appsflyer.internal.AFj1cSDK.getRevenue(r2, r3)
            r12 = r2
            goto L_0x0052
        L_0x004a:
            com.appsflyer.AFLogger r2 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r3 = com.appsflyer.internal.AFg1cSDK.REMOTE_CONTROL
            r2.w(r3, r4)
            goto L_0x002b
        L_0x0052:
            if (r12 != 0) goto L_0x0060
            com.appsflyer.AFLogger r0 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r1 = com.appsflyer.internal.AFg1cSDK.REMOTE_CONTROL
            java.lang.String r2 = "can't create CDN token, skipping fetch config"
            r0.v(r1, r2)
            com.appsflyer.internal.AFf1nSDK r0 = com.appsflyer.internal.AFf1nSDK.FAILURE
            return r0
        L_0x0060:
            com.appsflyer.internal.AFf1iSDK r2 = r10.hashCode     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            boolean r2 = r2.getMediationNetwork()     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            if (r2 == 0) goto L_0x01a8
            com.appsflyer.AFLogger r13 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            com.appsflyer.internal.AFg1cSDK r14 = com.appsflyer.internal.AFg1cSDK.REMOTE_CONTROL     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            java.lang.String r2 = "Cached config is expired, updating..."
            r13.i(r14, r2)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            com.appsflyer.internal.AFf1iSDK r2 = r10.hashCode     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            boolean r2 = r2.getMonetizationNetwork()     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            com.appsflyer.internal.AFf1iSDK r3 = r10.hashCode     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            boolean r3 = r3.getRevenue()     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            com.appsflyer.internal.AFd1oSDK r5 = r10.toString     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r6 = 1500(0x5dc, float:2.102E-42)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r15 = 5
            java.lang.Object[] r15 = new java.lang.Object[r15]     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r16 = 0
            r15[r16] = r5     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r5 = 1
            r15[r5] = r2     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r15[r0] = r3     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r2 = 3
            r15[r2] = r12     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r2 = 4
            r15[r2] = r7     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r2 = 662152322(0x2777a482, float:3.4367316E-15)
            r3 = -662152320(0xffffffffd8885b80, float:-1.19941257E15)
            java.lang.Object r2 = com.appsflyer.internal.AFd1oSDK.getCurrencyIso4217Code(r15, r2, r3, r6)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            com.appsflyer.internal.AFd1nSDK r2 = (com.appsflyer.internal.AFd1nSDK) r2     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            com.appsflyer.internal.AFd1aSDK r15 = r2.getMediationNetwork()     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            boolean r2 = r15.isSuccessful()     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            if (r2 == 0) goto L_0x0183
            java.lang.Object r2 = r15.getBody()     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            com.appsflyer.internal.AFi1wSDK r2 = (com.appsflyer.internal.AFi1wSDK) r2     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            java.lang.String r3 = "x-amz-meta-af-auth-v1"
            java.lang.String r3 = r15.getCurrencyIso4217Code(r3)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            java.lang.String r5 = "CF-Cache-Status"
            java.lang.String r6 = r15.getCurrencyIso4217Code(r5)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            com.appsflyer.internal.AFf1gSDK r5 = r10.copy     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            java.lang.String r5 = r5.getMediationNetwork()     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            if (r5 == 0) goto L_0x017d
            java.lang.String r7 = r5.trim()     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            int r7 = r7.length()     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            if (r7 != 0) goto L_0x00dc
            goto L_0x017d
        L_0x00dc:
            com.appsflyer.internal.AFf1pSDK r4 = r10.component2     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            com.appsflyer.internal.AFi1uSDK r3 = r4.getRevenue(r2, r3, r12, r5)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            boolean r4 = r3.getRevenue()     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            if (r4 == 0) goto L_0x0164
            com.appsflyer.internal.AFf1iSDK r4 = r10.hashCode     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            long r4 = r4.AFAdRevenueData()     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            java.lang.String r11 = "using max-age fallback: "
            r7.<init>(r11)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r7.append(r4)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r7.append(r1)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r13.v(r14, r7)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r11 = r1
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            com.appsflyer.internal.AFf1lSDK r7 = r10.copydefault     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            java.lang.String r10 = r2.getCurrencyIso4217Code     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r18 = r15
            java.nio.charset.Charset r15 = java.nio.charset.Charset.defaultCharset()     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            byte[] r10 = r10.getBytes(r15)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r15 = 2
            java.lang.String r10 = android.util.Base64.encodeToString(r10, r15)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            com.appsflyer.internal.AFc1qSDK r15 = r7.getMonetizationNetwork     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r17 = r6
            java.lang.String r6 = "af_remote_config"
            r15.getMediationNetwork((java.lang.String) r6, (java.lang.String) r10)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            com.appsflyer.internal.AFi1wSDK r6 = r7.getCurrencyIso4217Code     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r7.AFAdRevenueData = r6     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            com.appsflyer.internal.AFc1qSDK r6 = r7.getMonetizationNetwork     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            java.lang.String r10 = "af_rc_timestamp"
            r6.getMonetizationNetwork(r10, r0)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            com.appsflyer.internal.AFc1qSDK r6 = r7.getMonetizationNetwork     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            java.lang.String r10 = "af_rc_max_age"
            r6.getMonetizationNetwork(r10, r4)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r7.getCurrencyIso4217Code = r2     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r7.getMediationNetwork = r0     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r7.getRevenue = r4     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            java.lang.String r1 = "Config successfully updated, timeToLive: "
            r0.<init>(r1)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r0.append(r4)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r0.append(r11)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r13.d(r14, r0)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            com.appsflyer.internal.AFi1ySDK r5 = r3.AFAdRevenueData     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r1 = r19
            r2 = r12
            r3 = r8
            r6 = r17
            r7 = r18
            r1.AFAdRevenueData(r2, r3, r5, r6, r7)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            com.appsflyer.internal.AFf1nSDK r0 = com.appsflyer.internal.AFf1nSDK.SUCCESS     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            return r0
        L_0x015f:
            r0 = move-exception
            goto L_0x01b4
        L_0x0161:
            r0 = move-exception
            goto L_0x01f0
        L_0x0164:
            r17 = r6
            r18 = r15
            com.appsflyer.internal.AFi1ySDK r5 = r3.AFAdRevenueData     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r1 = r19
            r2 = r12
            r3 = r8
            r6 = r17
            r7 = r18
            r1.AFAdRevenueData(r2, r3, r5, r6, r7)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            java.lang.String r0 = "fetched config is not valid (MITM?) refuse to use it."
            r13.w(r14, r0)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            com.appsflyer.internal.AFf1nSDK r0 = com.appsflyer.internal.AFf1nSDK.FAILURE     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            return r0
        L_0x017d:
            r13.w(r14, r4)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            com.appsflyer.internal.AFf1nSDK r0 = com.appsflyer.internal.AFf1nSDK.FAILURE     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            return r0
        L_0x0183:
            r18 = r15
            r5 = 0
            r6 = 0
            r1 = r19
            r2 = r12
            r3 = r8
            r7 = r18
            r1.AFAdRevenueData(r2, r3, r5, r6, r7)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            java.lang.String r1 = "failed to fetch remote config from CDN with status code: "
            r0.<init>(r1)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            int r1 = r18.getStatusCode()     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r0.append(r1)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            r13.w(r14, r0)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            com.appsflyer.internal.AFf1nSDK r0 = com.appsflyer.internal.AFf1nSDK.FAILURE     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            return r0
        L_0x01a8:
            com.appsflyer.AFLogger r0 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            com.appsflyer.internal.AFg1cSDK r1 = com.appsflyer.internal.AFg1cSDK.REMOTE_CONTROL     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            java.lang.String r2 = "active config is valid, skipping fetch"
            r0.d(r1, r2)     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            com.appsflyer.internal.AFf1nSDK r0 = com.appsflyer.internal.AFf1nSDK.USE_CACHED     // Catch:{ IOException -> 0x0161, all -> 0x015f }
            return r0
        L_0x01b4:
            com.appsflyer.AFLogger r1 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r2 = com.appsflyer.internal.AFg1cSDK.REMOTE_CONTROL
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "failed to update remote config: "
            r3.<init>(r4)
            java.lang.String r4 = r0.getMessage()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r6 = 0
            r7 = 0
            r5 = 1
            r4 = r0
            r1.e(r2, r3, r4, r5, r6, r7)
            r7 = 0
            r10 = 0
            r5 = 0
            r6 = 0
            r1 = r19
            r2 = r12
            r3 = r8
            r8 = r10
            r9 = r0
            r1.getRevenue(r2, r3, r5, r6, r7, r8, r9)
            java.lang.Throwable r1 = r0.getCause()
            boolean r1 = r1 instanceof java.lang.InterruptedException
            if (r1 != 0) goto L_0x01e9
            com.appsflyer.internal.AFf1nSDK r0 = com.appsflyer.internal.AFf1nSDK.FAILURE
            return r0
        L_0x01e9:
            java.lang.Throwable r0 = r0.getCause()
            java.lang.InterruptedException r0 = (java.lang.InterruptedException) r0
            throw r0
        L_0x01f0:
            com.appsflyer.AFLogger r1 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r2 = com.appsflyer.internal.AFg1cSDK.REMOTE_CONTROL
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "failed to fetch remote config: "
            r3.<init>(r4)
            java.lang.String r4 = r0.getMessage()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r6 = 0
            r7 = 0
            r5 = 1
            r4 = r0
            r1.e(r2, r3, r4, r5, r6, r7)
            boolean r1 = r0 instanceof com.appsflyer.internal.components.network.http.exceptions.ParsingException
            if (r1 == 0) goto L_0x021a
            r1 = r0
            com.appsflyer.internal.components.network.http.exceptions.ParsingException r1 = (com.appsflyer.internal.components.network.http.exceptions.ParsingException) r1
            com.appsflyer.internal.AFd1aSDK r1 = r1.getRawResponse()
            r5 = r1
            goto L_0x021b
        L_0x021a:
            r5 = 0
        L_0x021b:
            r7 = 0
            r10 = 0
            r6 = 0
            r1 = r19
            r2 = r12
            r3 = r8
            r8 = r10
            r9 = r0
            r1.getRevenue(r2, r3, r5, r6, r7, r8, r9)
            java.lang.Throwable r1 = r0.getCause()
            boolean r1 = r1 instanceof java.io.InterruptedIOException
            if (r1 != 0) goto L_0x0232
            com.appsflyer.internal.AFf1nSDK r0 = com.appsflyer.internal.AFf1nSDK.FAILURE
            return r0
        L_0x0232:
            java.lang.Throwable r0 = r0.getCause()
            java.io.InterruptedIOException r0 = (java.io.InterruptedIOException) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1qSDK.component1():com.appsflyer.internal.AFf1nSDK");
    }

    private void getRevenue(String str, long j, @Nullable AFd1aSDK<?> aFd1aSDK, AFi1wSDK aFi1wSDK, AFi1ySDK aFi1ySDK, @Nullable String str2, @Nullable Throwable th) {
        int i;
        long j2;
        Throwable th2;
        long j3;
        String str3;
        AFd1aSDK<?> aFd1aSDK2 = aFd1aSDK;
        AFi1wSDK aFi1wSDK2 = aFi1wSDK;
        Throwable th3 = th;
        if (aFd1aSDK2 != null) {
            j2 = aFd1aSDK2.getRevenue.getRevenue;
            i = aFd1aSDK.getStatusCode();
        } else {
            j2 = 0;
            i = 0;
        }
        if (th3 instanceof HttpException) {
            th2 = th.getCause();
            j3 = ((HttpException) th3).getMetrics().getRevenue;
        } else {
            th2 = th3;
            j3 = j2;
        }
        if (aFi1wSDK2 != null) {
            str3 = aFi1wSDK2.getRevenue;
        } else {
            str3 = null;
        }
        this.component3 = new AFi1vSDK(str3, str, j3, System.currentTimeMillis() - j, i, aFi1ySDK, str2, th2);
    }

    @NonNull
    public final AFe1rSDK getCurrencyIso4217Code() throws Exception {
        try {
            AFf1nSDK component12 = component1();
            this.component1 = component12;
            if (component12 == AFf1nSDK.FAILURE) {
                return AFe1rSDK.FAILURE;
            }
            return AFe1rSDK.SUCCESS;
        } catch (SocketTimeoutException unused) {
            this.component1 = AFf1nSDK.FAILURE;
            return AFe1rSDK.TIMEOUT;
        } catch (InterruptedIOException | InterruptedException e) {
            AFLogger.INSTANCE.e(AFg1cSDK.REMOTE_CONTROL, "RC update config failed", e, false, false, false);
            this.component1 = AFf1nSDK.FAILURE;
            return AFe1rSDK.TIMEOUT;
        }
    }

    public final boolean getMediationNetwork() {
        return false;
    }

    public final long getMonetizationNetwork() {
        return 1500;
    }
}
