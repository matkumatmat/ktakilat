package com.appsflyer.internal;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.DateUtils;

public final class AFe1aSDK extends AFe1sSDK<Map<String, Object>> {
    private static final int areAllFieldsValid = ((int) TimeUnit.SECONDS.toMillis(2));
    private final AFa1oSDK component1;
    private final AFa1jSDK component2;
    private Map<String, Object> component3;
    private final Uri component4;
    private final List<String> hashCode;

    public AFe1aSDK(AFa1oSDK aFa1oSDK, @NonNull AFa1jSDK aFa1jSDK, @NonNull Uri uri, @NonNull List<String> list) {
        super(AFe1mSDK.RESOLVE_ESP, new AFe1mSDK[]{AFe1mSDK.RC_CDN}, "ResolveEsp");
        this.component1 = aFa1oSDK;
        this.component2 = aFa1jSDK;
        this.component4 = uri;
        this.hashCode = list;
    }

    private static Map<String, Object> r_(Uri uri) {
        HashMap hashMap = new HashMap();
        try {
            StringBuilder sb = new StringBuilder("ESP deeplink resolving is started: ");
            sb.append(uri.toString());
            AFLogger.afDebugLog(sb.toString());
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(uri.toString()).openConnection()));
            httpURLConnection.setInstanceFollowRedirects(false);
            int i = areAllFieldsValid;
            httpURLConnection.setReadTimeout(i);
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.setRequestProperty("User-agent", "Dalvik/2.1.0 (Linux; U; Android 6.0.1; Nexus 5 Build/M4B30Z)");
            httpURLConnection.setRequestProperty("af-esp", "6.17.0");
            int responseCode = httpURLConnection.getResponseCode();
            hashMap.put("status", Integer.valueOf(responseCode));
            if (300 <= responseCode && responseCode <= 305) {
                hashMap.put("res", httpURLConnection.getHeaderField(HttpHeaders.LOCATION));
            }
            httpURLConnection.disconnect();
            AFLogger.afDebugLog("ESP deeplink resolving is finished");
        } catch (Throwable th) {
            hashMap.put("error", th.getLocalizedMessage());
            AFLogger.afErrorLog(th.getMessage(), th);
        }
        return hashMap;
    }

    @NonNull
    public final AFe1rSDK getCurrencyIso4217Code() throws Exception {
        String str;
        int i;
        Uri uri;
        String str2;
        Integer num;
        String str3;
        Integer num2 = null;
        if (!getMediationNetwork(this.component4.toString())) {
            this.component1.i_(this.component2, this.component4, (Uri) null);
            return AFe1rSDK.SUCCESS;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String obj = this.component4.toString();
        ArrayList arrayList = new ArrayList();
        String str4 = null;
        int i2 = 0;
        while (true) {
            if (i2 >= 5) {
                break;
            }
            Map<String, Object> r_ = r_(Uri.parse(obj));
            str2 = (String) r_.get("res");
            num = (Integer) r_.get("status");
            str3 = (String) r_.get("error");
            if (str2 == null || !getMediationNetwork(str2)) {
                Integer num3 = num;
                str4 = str3;
                obj = str2;
                num2 = num3;
            } else {
                if (i2 < 4) {
                    arrayList.add(str2);
                }
                i2++;
                Integer num4 = num;
                str4 = str3;
                obj = str2;
                num2 = num4;
            }
        }
        Integer num32 = num;
        str4 = str3;
        obj = str2;
        num2 = num32;
        HashMap hashMap = new HashMap();
        if (obj != null) {
            str = obj;
        } else {
            str = "";
        }
        hashMap.put("res", str);
        if (num2 != null) {
            i = num2.intValue();
        } else {
            i = -1;
        }
        hashMap.put("status", Integer.valueOf(i));
        if (str4 != null) {
            hashMap.put("error", str4);
        }
        if (!arrayList.isEmpty()) {
            hashMap.put("redirects", arrayList);
        }
        hashMap.put("latency", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        synchronized (this.component2) {
            this.component2.getCurrencyIso4217Code("af_deeplink_r", hashMap);
            this.component2.getCurrencyIso4217Code("af_deeplink", this.component4.toString());
        }
        AFa1oSDK aFa1oSDK = this.component1;
        AFa1jSDK aFa1jSDK = this.component2;
        if (obj != null) {
            uri = Uri.parse(obj);
        } else {
            uri = this.component4;
        }
        aFa1oSDK.i_(aFa1jSDK, uri, this.component4);
        this.component3 = hashMap;
        return AFe1rSDK.SUCCESS;
    }

    public final boolean getMediationNetwork() {
        return false;
    }

    public final long getMonetizationNetwork() {
        return DateUtils.MILLIS_PER_MINUTE;
    }

    private boolean getMediationNetwork(String str) {
        if (str.contains("af_tranid=")) {
            return false;
        }
        StringBuilder t = e.t("Validate if link ", str, " belongs to ESP domains: ");
        t.append(this.hashCode);
        AFLogger.afRDLog(t.toString());
        try {
            return this.hashCode.contains(new URL(str).getHost());
        } catch (MalformedURLException e) {
            AFLogger.afErrorLogForExcManagerOnly("MalformedURLException ESP link", e);
            return false;
        }
    }
}
