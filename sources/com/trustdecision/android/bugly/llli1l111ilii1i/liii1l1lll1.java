package com.trustdecision.android.bugly.llli1l111ilii1i;

import android.os.Build;
import android.text.TextUtils;
import android.util.StringBuilderPrinter;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.trustdecision.android.bugly.l1ill1li1i.l1ill1li1i;
import com.trustdecision.android.bugly.l1ill1li1i.l1l11i111l;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class liii1l1lll1 {
    private static int l1ill1li1i = 3;
    private static int l1l11i111l = 200;
    private static String liii1l1lll1 = "POST";
    private static int llli1l111ilii1i = 2;

    public static boolean l1l11i111l(String str, String str2) {
        try {
            return liii1l1lll1(str, (Map<String, String>) liii1l1lll1(str2, llli1l111ilii1i));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean liii1l1lll1(String str, String str2) {
        try {
            return liii1l1lll1(str, (Map<String, String>) liii1l1lll1(str2, l1ill1li1i));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static HashMap<String, String> liii1l1lll1(String str, int i) throws UnsupportedEncodingException {
        HashMap<String, String> hashMap = new HashMap<>(15);
        hashMap.put("sdkName", com.trustdecision.android.bugly.liii1l1lll1.liii1l1lll1.llli1l111ilii1i());
        hashMap.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, com.trustdecision.android.bugly.liii1l1lll1.liii1l1lll1.l1ill1li1i());
        hashMap.put("appName", com.trustdecision.android.bugly.liii1l1lll1.liii1l1lll1.i11llii11ilillll1i1());
        hashMap.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, com.trustdecision.android.bugly.liii1l1lll1.liii1l1lll1.i1111ii1111iliii());
        hashMap.put("platform", ExifInterface.GPS_MEASUREMENT_2D);
        String str2 = Build.BRAND;
        hashMap.put("brand", str2);
        String str3 = Build.MODEL;
        hashMap.put("model", str3);
        hashMap.put("releaseVersion", String.valueOf(Build.VERSION.SDK_INT));
        String iillii1ili1lll1 = com.trustdecision.android.bugly.liii1l1lll1.liii1l1lll1.iillii1ili1lll1();
        hashMap.put("cpuHardware", iillii1ili1lll1);
        String l1l11i111l2 = l1l11i111l.liii1l1lll1().l1l11i111l();
        hashMap.put("buglyId", l1l11i111l2);
        hashMap.put("productType", String.valueOf(com.trustdecision.android.bugly.liii1l1lll1.liii1l1lll1.liii1l1lll1()));
        hashMap.put("traceType", String.valueOf(i));
        hashMap.put("occurTime", String.valueOf(System.currentTimeMillis()));
        hashMap.put("networkType", FacebookRequestErrorClassification.KEY_OTHER);
        Locale locale = Locale.US;
        String str4 = "root (" + com.trustdecision.android.bugly.liii1l1lll1.liii1l1lll1.llli111iiilli11ll1i1i() + ")";
        String str5 = "debuggable (" + com.trustdecision.android.bugly.liii1l1lll1.liii1l1lll1.i1l1ill11() + ")";
        StringBuilder sb = new StringBuilder();
        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(sb);
        stringBuilderPrinter.println(l1l11i111l2 + ", other");
        stringBuilderPrinter.println(str2 + ", " + str3 + ", " + Build.VERSION.RELEASE + ", " + iillii1ili1lll1 + ", " + str4 + ", " + str5);
        stringBuilderPrinter.println(str);
        hashMap.put("errorMsg", new String(com.trustdecision.android.bugly.l1ill1li1i.liii1l1lll1.liii1l1lll1(sb.toString().getBytes()), "utf-8"));
        return hashMap;
    }

    private static boolean liii1l1lll1(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            String str2 = (String) next.getValue();
            if (!TextUtils.isEmpty(str2)) {
                try {
                    str2 = URLEncoder.encode(str2, "utf-8");
                } catch (Throwable unused) {
                }
                sb.append((String) next.getKey());
                sb.append("=");
                sb.append(str2);
                sb.append("&");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        try {
            return liii1l1lll1(new URL(str), liii1l1lll1, sb.toString().getBytes("utf-8"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static boolean liii1l1lll1(URL url, String str, byte[] bArr) {
        OutputStream outputStream = null;
        boolean z = false;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod(str);
            outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
            if (httpURLConnection.getResponseCode() == l1l11i111l) {
                z = true;
            }
            httpURLConnection.disconnect();
        } catch (Throwable unused) {
        }
        l1ill1li1i.liii1l1lll1(outputStream);
        return z;
    }
}
