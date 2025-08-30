package com.trustdecision.android.location.uvuuuuvuuvvuvvvvvuuvuv;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.List;
import org.apache.commons.lang3.CharEncoding;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class uvuuuuvuuvvuvvvvvuuvuv {
    private static uvvvvvvvuuuv uuvvuuuvuuvu;
    private static HandlerThread uuvvuuuvuuvv = null;
    public static final String uvuuuuvuuvvuvvvvvuuvuv = uvuuuuvuuvvuvvvvvuuvuv("3d7b7e626972793e2a61636b706e746e7275341b76747262747868787a6775626e6777787661697275", 104);
    private static Handler uvuvuuuuvuuuuu = null;
    private static C0014uvuuuuvuuvvuvvvvvuuvuv uvuvuvuuuvvuvvuuuvv;
    public static final String uvvvvvvvuuuv = uvuuuuvuuvvuvvvvvuuvuv("3d5d58444f545f180c47454d564852485453123d50525444525e4b5d55594841515e50474f5453", 78);

    /* renamed from: com.trustdecision.android.location.uvuuuuvuuvvuvvvvvuuvuv.uvuuuuvuuvvuvvvvvuuvuv$uvuuuuvuuvvuvvvvvuuvuv  reason: collision with other inner class name */
    public static final class C0014uvuuuuvuuvvuvvvvvuuvuv implements LocationListener {
        private final LocationManager uvuuuuvuuvvuvvvvvuuvuv;

        private C0014uvuuuuvuuvvuvvvvvuuvuv(LocationManager locationManager) {
            this.uvuuuuvuuvvuvvvvvuuvuv = locationManager;
        }

        public void onFlushComplete(int i) {
        }

        public void onLocationChanged(Location location) {
            uvuuuuvuuvvuvvvvvuuvuv.uvvvvvvvuuuv(this.uvuuuuvuuvvuvvvvvuuvuv);
            uvuuuuvuuvvuvvvvvuuvuv.uvvvvvvvuuuv();
        }

        public void onProviderDisabled(String str) {
            uvuuuuvuuvvuvvvvvuuvuv.uvvvvvvvuuuv(this.uvuuuuvuuvvuvvvvvuuvuv);
            uvuuuuvuuvvuvvvvvuuvuv.uvvvvvvvuuuv();
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        public /* synthetic */ C0014uvuuuuvuuvvuvvvvvuuvuv(LocationManager locationManager, uvvvvvvvuuuv uvvvvvvvuuuv) {
            this(locationManager);
        }
    }

    public static final class uvvvvvvvuuuv implements LocationListener {
        private final LocationManager uvuuuuvuuvvuvvvvvuuvuv;

        private uvvvvvvvuuuv(LocationManager locationManager) {
            this.uvuuuuvuuvvuvvvvvuuvuv = locationManager;
        }

        public void onFlushComplete(int i) {
        }

        public void onLocationChanged(Location location) {
            uvuuuuvuuvvuvvvvvuuvuv.uvvvvvvvuuuv(this.uvuuuuvuuvvuvvvvvuuvuv);
            uvuuuuvuuvvuvvvvvuuvuv.uvvvvvvvuuuv();
        }

        public void onProviderDisabled(String str) {
            uvuuuuvuuvvuvvvvvuuvuv.uvvvvvvvuuuv(this.uvuuuuvuuvvuvvvvvuuvuv);
            uvuuuuvuuvvuvvvvvuuvuv.uvvvvvvvuuuv();
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        public /* synthetic */ uvvvvvvvuuuv(LocationManager locationManager, uvvvvvvvuuuv uvvvvvvvuuuv) {
            this(locationManager);
        }
    }

    public static int uvuuuuvuuvvuvvvvvuuvuv(Context context, LocationManager locationManager, boolean z) {
        if (!z) {
            return -1;
        }
        boolean uvuuuuvuuvvuvvvvvuuvuv2 = com.trustdecision.android.location.uvvvvvvvuuuv.uvuuuuvuuvvuvvvvvuuvuv.uvuuuuvuuvvuvvvvvuuvuv(context, uvuuuuvuuvvuvvvvvuuvuv("3d6f6a767d666d2a3e75777f647a607a6661200f62606676606c7c6c6e7361767a73636c62757d6661", 124), uvuuuuvuuvvuvvvvvuuvuv("3d35302c273c3770642f2d253e203a203c3b7a55383a3c2c3a3623353d3120293936382f273c3b", 38));
        int i = 0;
        boolean isProviderEnabled = locationManager.isProviderEnabled(uvuuuuvuuvvuvvvvvuuvuv("3b0b1f", 0));
        boolean isProviderEnabled2 = locationManager.isProviderEnabled(uvuuuuvuuvvuvvvvvuuvuv("32150f1d060307", 2));
        if (isProviderEnabled || isProviderEnabled2) {
            i = 1;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23) {
            return i | 2;
        }
        if (uvuuuuvuuvvuvvvvvuuvuv2) {
            i |= 2;
        }
        return (i2 <= 28 || !com.trustdecision.android.location.uvvvvvvvuuuv.uvuuuuvuuvvuvvvvvuuvuv.uvuuuuvuuvvuvvvvvuuvuv(context, uvuuuuvuuvvuvvvvvuuvuv("3d53564a415a511602494b4358465c465a5d1c335e5c5a4a5c50415f5e54504941464756474f5f505e49415a5d", 64))) ? i : i | 4;
    }

    /* access modifiers changed from: private */
    public static void uvuvuvuuuvvuvvuuuvv(LocationManager locationManager, Context context) {
        if (locationManager != null && locationManager.getProviders(true) != null) {
            try {
                if (locationManager.isProviderEnabled(uvuuuuvuuvvuvvvvvuuvuv("3b4c58", 71))) {
                    if (uvuvuvuuuvvuvvuuuvv == null) {
                        uvuvuvuuuvvuvvuuuvv = new C0014uvuuuuvuuvvuvvvvvuuvuv(locationManager, (uvvvvvvvuuuv) null);
                    }
                    locationManager.requestLocationUpdates(uvuuuuvuuvvuvvvvvuuvuv("3b0216", 9), 0, 1.0f, uvuvuvuuuvvuvvuuuvv);
                }
            } catch (Throwable unused) {
            }
            try {
                if (locationManager.isProviderEnabled(uvuuuuvuuvvuvvvvvuuvuv("327862706b6e6a", 111))) {
                    if (uuvvuuuvuuvu == null) {
                        uuvvuuuvuuvu = new uvvvvvvvuuuv(locationManager, (uvvvvvvvuuuv) null);
                    }
                    locationManager.requestLocationUpdates(uvuuuuvuuvvuvvvvvuuvuv("323a2032292c28", 45), 0, 1.0f, uuvvuuuvuuvu);
                }
            } catch (Throwable unused2) {
            }
        }
    }

    public static String uvvvvvvvuuuv(WifiInfo wifiInfo) {
        return wifiInfo != null ? wifiInfo.getBSSID() : "";
    }

    public static String uvuuuuvuuvvuvvvvvuuvuv(Context context, LocationManager locationManager, boolean z, int i) {
        if (z && (com.trustdecision.android.location.uvvvvvvvuuuv.uvuuuuvuuvvuvvvvvuuvuv.uvuuuuvuuvvuvvvvvuuvuv(context, uvuuuuvuuvvuvvvvvuuvuv("3d07021e150e0542561d1f170c1208120e0948670a080e1e080411070f03121b0b040a1d150e09", 20)) || com.trustdecision.android.location.uvvvvvvvuuuv.uvuuuuvuuvvuvvvvvuuvuv.uvuuuuvuuvvuvvvvvuuvuv(context, uvuuuuvuuvvuvvvvvuuvuv("3d54514d465d5611054e4c445f415b415d5a1b34595b5d4d5b57475755485a4d41485857594e465d5a", 71)))) {
            JSONObject jSONObject = new JSONObject();
            if (locationManager.getProviders(true) == null) {
                return "";
            }
            String[] strArr = {uvuuuuvuuvvuvvvvvuuvuv("3b7f6b", 116), uvuuuuvuuvvuvvvvvuuvuv("3242584a515450", 85)};
            String str = null;
            int i2 = 0;
            Location location = null;
            while (true) {
                if (i2 >= 2) {
                    break;
                }
                String str2 = strArr[i2];
                try {
                    location = locationManager.getLastKnownLocation(str2);
                    if (location != null) {
                        str = str2;
                        break;
                    }
                    i2++;
                } catch (Throwable unused) {
                }
            }
            if (location == null) {
                uvvvvvvvuuuv(locationManager, context);
                return "";
            }
            boolean uvuuuuvuuvvuvvvvvuuvuv2 = uvuuuuvuuvvuvvvvvuuvuv(location, str, i);
            if (uvuuuuvuuvvuvvvvvuuvuv2) {
                uvvvvvvvuuuv(locationManager, context);
            }
            try {
                jSONObject.put(uvuuuuvuuvvuvvvvvuuvuv("2834302c", 37), location.getProvider());
                jSONObject.put(uvuuuuvuuvvuvvvvvuuvuv("30677f", 118), location.getLatitude());
                jSONObject.put(uvuuuuvuuvvuvvvvvuuvuv("30686a62", 119), location.getLongitude());
                jSONObject.put(uvuuuuvuuvvuvvvvvuuvuv("3d1012", 14), (double) location.getAccuracy());
                if (uvuuuuvuuvvuvvvvvuuvuv2) {
                    jSONObject.put(uvuuuuvuuvvuvvvvvuuvuv("3157595d", 73), 1);
                }
                return jSONObject.toString();
            } catch (JSONException unused2) {
            }
        }
        return "";
    }

    /* access modifiers changed from: private */
    public static void uvvvvvvvuuuv() {
        synchronized (uvuuuuvuuvvuvvvvvuuvuv.class) {
            try {
                if (uuvvuuuvuuvv != null) {
                    uvuvuuuuvuuuuu.removeCallbacksAndMessages((Object) null);
                    uuvvuuuvuuvv.quit();
                    uuvvuuuvuuvv = null;
                    uvuvuuuuvuuuuu = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String uvuuuuvuuvvuvvvvvuuvuv(WifiInfo wifiInfo) {
        return wifiInfo != null ? wifiInfo.getSSID() : "";
    }

    /* access modifiers changed from: private */
    public static void uvvvvvvvuuuv(LocationManager locationManager) {
        if (locationManager != null) {
            uvvvvvvvuuuv uvvvvvvvuuuv2 = uuvvuuuvuuvu;
            if (uvvvvvvvuuuv2 != null) {
                locationManager.removeUpdates(uvvvvvvvuuuv2);
                uuvvuuuvuuvu = null;
            }
            C0014uvuuuuvuuvvuvvvvvuuvuv uvuuuuvuuvvuvvvvvuuvuv2 = uvuvuvuuuvvuvvuuuvv;
            if (uvuuuuvuuvvuvvvvvuuvuv2 != null) {
                locationManager.removeUpdates(uvuuuuvuuvvuvvvvvuuvuv2);
                uvuvuvuuuvvuvvuuuvv = null;
            }
        }
    }

    public static String uvuuuuvuuvvuvvvvvuuvuv(WifiManager wifiManager) {
        int size;
        try {
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults == null || (size = scanResults.size()) <= 0) {
                return null;
            }
            if (size > 10) {
                size = 10;
            }
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < size; i++) {
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(scanResults.get(i).BSSID);
                jSONArray2.put(scanResults.get(i).SSID);
                jSONArray2.put(scanResults.get(i).level);
                jSONArray.put(jSONArray2);
            }
            return jSONArray.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private static synchronized void uvvvvvvvuuuv(LocationManager locationManager, Context context) {
        synchronized (uvuuuuvuuvvuvvvvvuuvuv.class) {
            try {
                if (uuvvuuuvuuvv == null) {
                    HandlerThread handlerThread = new HandlerThread(uvuuuuvuuvvuvvvvvuuvuv("28607a72786a604a4863", 103));
                    uuvvuuuvuuvv = handlerThread;
                    handlerThread.start();
                    uvuvuuuuvuuuuu = new Handler(uuvvuuuvuuvv.getLooper());
                }
                uvuvuuuuvuuuuu.post(new uvvvvvvvuuuv(locationManager, context));
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    private static String uvuuuuvuuvvuvvvvvuuvuv(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 28);
            byte b2 = (byte) (bArr[0] ^ 92);
            bArr[0] = b2;
            for (int i4 = 1; i4 < length; i4++) {
                b2 = (byte) ((b2 ^ bArr[i4]) ^ b);
                bArr[i4] = b2;
            }
            return new String(bArr, CharEncoding.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean uvuuuuvuuvvuvvvvvuuvuv(android.location.Location r7, java.lang.String r8, int r9) {
        /*
            r0 = 1
            r1 = 2
            r2 = 0
            java.lang.String r3 = "3f747a3b227e7f7e7f68797e7262627e79383777726e657e753225637571783a35747a787a79381e5571646d6f407c7f"
            r4 = 100
            java.lang.String r3 = uvuuuuvuuvvuvvvvvuuvuv((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x003a }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x003a }
            java.lang.String r4 = "3205"
            r5 = 71
            java.lang.String r4 = uvuuuuvuuvvuvvvvvuuvuv((java.lang.String) r4, (int) r5)     // Catch:{ all -> 0x003a }
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ all -> 0x003a }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ all -> 0x003a }
            r5[r2] = r6     // Catch:{ all -> 0x003a }
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            r5[r0] = r6     // Catch:{ all -> 0x003a }
            java.lang.reflect.Method r4 = r3.getDeclaredMethod(r4, r5)     // Catch:{ all -> 0x003a }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x003a }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x003a }
            r5[r2] = r7     // Catch:{ all -> 0x003a }
            r5[r0] = r8     // Catch:{ all -> 0x003a }
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ all -> 0x003a }
            r7[r2] = r9     // Catch:{ all -> 0x003a }
            r7[r0] = r5     // Catch:{ all -> 0x003a }
            java.lang.Object r7 = r4.invoke(r3, r7)     // Catch:{ all -> 0x003a }
            goto L_0x003b
        L_0x003a:
            r7 = 0
        L_0x003b:
            if (r7 == 0) goto L_0x0043
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x0043:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.location.uvuuuuvuuvvuvvvvvuuvuv.uvuuuuvuuvvuvvvvvuuvuv.uvuuuuvuuvvuvvvvvuuvuv(android.location.Location, java.lang.String, int):boolean");
    }
}
