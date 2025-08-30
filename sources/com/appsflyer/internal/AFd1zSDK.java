package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.FirebasePerformance;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u0005*\u00020\u0005H'¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\f\u001a\u00020\u000b*\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\f\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\f¢\u0006\u0006\n\u0004\b\u0011\u0010\u0015R\u0014\u0010\f\u001a\u00020\u00178'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R$\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\f¢\u0006\u0006\n\u0004\b\f\u0010\u0019R\u001a\u0010\u000f\u001a\u00020\u000b8\u0017XD¢\u0006\f\n\u0004\b\u0016\u0010\u001b\u001a\u0004\b\u001a\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u00058'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u001d"}, d2 = {"Lcom/appsflyer/internal/AFd1zSDK;", "", "", "p0", "", "", "p1", "", "p2", "<init>", "([BLjava/util/Map;I)V", "", "getMonetizationNetwork", "()Z", "Ljava/net/HttpURLConnection;", "AFAdRevenueData", "(Ljava/net/HttpURLConnection;)Ljava/lang/String;", "getCurrencyIso4217Code", "(Ljava/lang/String;)Ljava/lang/String;", "", "(Ljava/net/HttpURLConnection;J)Z", "[B", "getRevenue", "Lcom/appsflyer/internal/AFd1gSDK;", "()Lcom/appsflyer/internal/AFd1gSDK;", "Ljava/util/Map;", "getMediationNetwork", "Z", "I", "()Ljava/lang/String;", "component1"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMonitorHttpRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MonitorHttpRequest.kt\ncom/appsflyer/internal/components/monitorsdk/MonitorHttpRequest\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n215#2,2:135\n215#2,2:138\n1#3:137\n*S KotlinDebug\n*F\n+ 1 MonitorHttpRequest.kt\ncom/appsflyer/internal/components/monitorsdk/MonitorHttpRequest\n*L\n58#1:135,2\n104#1:138,2\n*E\n"})
public abstract class AFd1zSDK {
    public int AFAdRevenueData;
    @NotNull
    public byte[] getCurrencyIso4217Code;
    @Nullable
    public Map<String, String> getMonetizationNetwork;
    private final boolean getRevenue = true;

    public AFd1zSDK(@NotNull byte[] bArr, @Nullable Map<String, String> map, int i) {
        Intrinsics.checkNotNullParameter(bArr, "");
        this.getCurrencyIso4217Code = bArr;
        this.getMonetizationNetwork = map;
        this.AFAdRevenueData = i;
    }

    private static String AFAdRevenueData(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream;
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (Throwable th) {
            AFLogger aFLogger = AFLogger.INSTANCE;
            AFg1cSDK aFg1cSDK = AFg1cSDK.HTTP_CLIENT;
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            AFg1gSDK.e$default(aFLogger, aFg1cSDK, message, th, false, false, false, false, 96, (Object) null);
            inputStream = httpURLConnection.getErrorStream();
        }
        if (inputStream == null) {
            return "";
        }
        Intrinsics.checkNotNullExpressionValue(inputStream, "");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8), 8192);
        String p = CollectionsKt.p(TextStreamsKt.a(bufferedReader), (CharSequence) null, (String) null, (String) null, (Function1) null, 63);
        bufferedReader.close();
        if (p == null) {
            return "";
        }
        return p;
    }

    @NotNull
    @JvmName(name = "getCurrencyIso4217Code")
    public abstract String getCurrencyIso4217Code();

    @NotNull
    public abstract String getCurrencyIso4217Code(@NotNull String str);

    @JvmName(name = "getMediationNetwork")
    public boolean getMediationNetwork() {
        return this.getRevenue;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005a A[Catch:{ all -> 0x005f }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0061 A[Catch:{ all -> 0x005f }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0080 A[Catch:{ all -> 0x005f }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0084 A[Catch:{ all -> 0x005f }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0089 A[DONT_GENERATE] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean getMonetizationNetwork() {
        /*
            r8 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "HTTP: ["
            java.lang.String r2 = "error: "
            long r3 = java.lang.System.currentTimeMillis()
            r5 = 0
            java.lang.String r6 = r8.getCurrencyIso4217Code()     // Catch:{ all -> 0x0031 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)     // Catch:{ all -> 0x0031 }
            java.net.URL r7 = new java.net.URL     // Catch:{ all -> 0x0031 }
            r7.<init>(r6)     // Catch:{ all -> 0x0031 }
            java.net.URLConnection r6 = r7.openConnection()     // Catch:{ all -> 0x0031 }
            java.lang.Object r6 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r6)     // Catch:{ all -> 0x0031 }
            java.net.URLConnection r6 = (java.net.URLConnection) r6     // Catch:{ all -> 0x0031 }
            kotlin.jvm.internal.Intrinsics.d(r6, r0)     // Catch:{ all -> 0x0031 }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ all -> 0x0031 }
            boolean r0 = r8.getMonetizationNetwork(r6, r3)     // Catch:{ all -> 0x002e }
            r6.disconnect()
            goto L_0x008d
        L_0x002e:
            r0 = move-exception
            r5 = r6
            goto L_0x0032
        L_0x0031:
            r0 = move-exception
        L_0x0032:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x005f }
            long r6 = r6 - r3
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x005f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x005f }
            r4.<init>(r2)     // Catch:{ all -> 0x005f }
            r4.append(r0)     // Catch:{ all -> 0x005f }
            java.lang.String r0 = "\n\ttook "
            r4.append(r0)     // Catch:{ all -> 0x005f }
            r4.append(r6)     // Catch:{ all -> 0x005f }
            java.lang.String r0 = "ms\n\t"
            r4.append(r0)     // Catch:{ all -> 0x005f }
            r4.append(r3)     // Catch:{ all -> 0x005f }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x005f }
            r2 = 0
            if (r5 == 0) goto L_0x0061
            int r3 = r5.hashCode()     // Catch:{ all -> 0x005f }
            goto L_0x0062
        L_0x005f:
            r0 = move-exception
            goto L_0x008e
        L_0x0061:
            r3 = 0
        L_0x0062:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x005f }
            r4.<init>(r1)     // Catch:{ all -> 0x005f }
            r4.append(r3)     // Catch:{ all -> 0x005f }
            java.lang.String r1 = "] "
            r4.append(r1)     // Catch:{ all -> 0x005f }
            r4.append(r0)     // Catch:{ all -> 0x005f }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x005f }
            java.lang.String r0 = r8.getCurrencyIso4217Code(r0)     // Catch:{ all -> 0x005f }
            boolean r1 = r8.getMediationNetwork()     // Catch:{ all -> 0x005f }
            if (r1 == 0) goto L_0x0084
            com.appsflyer.AFLogger.afRDLog(r0)     // Catch:{ all -> 0x005f }
            goto L_0x0087
        L_0x0084:
            com.appsflyer.AFLogger.afVerboseLog(r0)     // Catch:{ all -> 0x005f }
        L_0x0087:
            if (r5 == 0) goto L_0x008c
            r5.disconnect()
        L_0x008c:
            r0 = 0
        L_0x008d:
            return r0
        L_0x008e:
            if (r5 == 0) goto L_0x0093
            r5.disconnect()
        L_0x0093:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1zSDK.getMonetizationNetwork():boolean");
    }

    @NotNull
    @JvmName(name = "getRevenue")
    public abstract AFd1gSDK getRevenue();

    private final boolean getMonetizationNetwork(HttpURLConnection httpURLConnection, long j) {
        httpURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.POST);
        StringBuilder sb = new StringBuilder(httpURLConnection.getRequestMethod() + ":" + httpURLConnection.getURL());
        sb.append("\n length: ");
        sb.append(new String(this.getCurrencyIso4217Code, Charsets.UTF_8).length());
        Map<String, String> map = this.getMonetizationNetwork;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                sb.append("\n ");
                sb.append((String) next.getKey());
                sb.append(": ");
                sb.append((String) next.getValue());
            }
        }
        String currencyIso4217Code = getCurrencyIso4217Code("HTTP: [" + httpURLConnection.hashCode() + "] " + sb);
        if (getMediationNetwork()) {
            AFLogger.afRDLog(currencyIso4217Code);
        } else {
            AFLogger.afVerboseLog(currencyIso4217Code);
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setReadTimeout(this.AFAdRevenueData);
        httpURLConnection.setConnectTimeout(this.AFAdRevenueData);
        httpURLConnection.addRequestProperty(HttpHeaders.CONTENT_TYPE, getRevenue().getRevenue);
        Map<String, String> map2 = this.getMonetizationNetwork;
        if (map2 != null) {
            for (Map.Entry next2 : map2.entrySet()) {
                httpURLConnection.addRequestProperty((String) next2.getKey(), (String) next2.getValue());
            }
        }
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_LENGTH, String.valueOf(this.getCurrencyIso4217Code.length));
        OutputStream outputStream = httpURLConnection.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(outputStream, "");
        BufferedOutputStream bufferedOutputStream = outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, 8192);
        bufferedOutputStream.write(this.getCurrencyIso4217Code);
        bufferedOutputStream.close();
        String AFAdRevenueData2 = AFAdRevenueData(httpURLConnection);
        long currentTimeMillis = System.currentTimeMillis() - j;
        String str = "response code:" + httpURLConnection.getResponseCode() + StringUtils.SPACE + httpURLConnection.getResponseMessage() + "\n\tbody:" + AFAdRevenueData2 + "\n\ttook " + currentTimeMillis + "ms";
        String currencyIso4217Code2 = getCurrencyIso4217Code("HTTP: [" + httpURLConnection.hashCode() + "] " + str);
        if (getMediationNetwork()) {
            AFLogger.afRDLog(currencyIso4217Code2);
        } else {
            AFLogger.afVerboseLog(currencyIso4217Code2);
        }
        return AFd1tSDK.getRevenue(httpURLConnection);
    }
}
