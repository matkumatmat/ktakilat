package com.ktakilat.cbase.utils.location;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.text.TextUtils;
import com.google.android.gms.maps.model.LatLng;
import com.ktakilat.cbase.ui.LogActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

public class LocationUtils {
    public static String a(Context context, LatLng latLng) {
        int lastIndexOf;
        StringBuilder sb = new StringBuilder();
        try {
            List<Address> fromLocation = new Geocoder(context, Locale.getDefault()).getFromLocation(latLng.latitude, latLng.longitude, 1);
            if (fromLocation.size() < 1) {
                return "";
            }
            for (int i = 0; i <= fromLocation.get(0).getMaxAddressLineIndex(); i++) {
                sb.append(fromLocation.get(0).getAddressLine(i));
                sb.append(", ");
            }
            String trim = sb.toString().trim();
            if (TextUtils.isEmpty(trim) || (lastIndexOf = trim.lastIndexOf(StringUtils.SPACE)) <= 0) {
                return trim;
            }
            return trim.substring(0, lastIndexOf);
        } catch (IOException e) {
            e.toString();
            ArrayList arrayList = LogActivity.k;
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x009d, code lost:
        if (r7 == false) goto L_0x00a6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.HashMap b(android.content.Context r12) {
        /*
            r0 = 0
            java.lang.String r1 = "location"
            java.lang.Object r12 = r12.getSystemService(r1)     // Catch:{ Exception -> 0x000a }
            android.location.LocationManager r12 = (android.location.LocationManager) r12     // Catch:{ Exception -> 0x000a }
            goto L_0x000c
        L_0x000a:
            r12 = r0
        L_0x000c:
            if (r12 != 0) goto L_0x0014
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            return r12
        L_0x0014:
            r1 = 1
            java.util.List r2 = r12.getProviders(r1)
            java.util.Iterator r2 = r2.iterator()
        L_0x001d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00a9
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            android.location.Location r3 = r12.getLastKnownLocation(r3)     // Catch:{ Exception -> 0x0096 }
            if (r3 == 0) goto L_0x001d
            if (r0 != 0) goto L_0x0033
            goto L_0x00a6
        L_0x0033:
            long r4 = r3.getTime()     // Catch:{ Exception -> 0x0096 }
            long r6 = r0.getTime()     // Catch:{ Exception -> 0x0096 }
            long r4 = r4 - r6
            r6 = 120000(0x1d4c0, double:5.9288E-319)
            r8 = 0
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 <= 0) goto L_0x0046
            r6 = 1
            goto L_0x0047
        L_0x0046:
            r6 = 0
        L_0x0047:
            r9 = -120000(0xfffffffffffe2b40, double:NaN)
            int r7 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r7 >= 0) goto L_0x0050
            r7 = 1
            goto L_0x0051
        L_0x0050:
            r7 = 0
        L_0x0051:
            r9 = 0
            int r11 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r11 <= 0) goto L_0x0059
            r4 = 1
            goto L_0x005a
        L_0x0059:
            r4 = 0
        L_0x005a:
            if (r6 == 0) goto L_0x005d
            goto L_0x00a6
        L_0x005d:
            if (r7 == 0) goto L_0x0060
            goto L_0x001d
        L_0x0060:
            float r5 = r3.getAccuracy()     // Catch:{ Exception -> 0x0096 }
            float r6 = r0.getAccuracy()     // Catch:{ Exception -> 0x0096 }
            float r5 = r5 - r6
            int r5 = (int) r5     // Catch:{ Exception -> 0x0096 }
            float r5 = (float) r5     // Catch:{ Exception -> 0x0096 }
            r6 = 0
            int r7 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r7 <= 0) goto L_0x0072
            r7 = 1
            goto L_0x0073
        L_0x0072:
            r7 = 0
        L_0x0073:
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 >= 0) goto L_0x0079
            r6 = 1
            goto L_0x007a
        L_0x0079:
            r6 = 0
        L_0x007a:
            r9 = 1128792064(0x43480000, float:200.0)
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x0082
            r5 = 1
            goto L_0x0083
        L_0x0082:
            r5 = 0
        L_0x0083:
            java.lang.String r9 = r3.getProvider()     // Catch:{ Exception -> 0x0096 }
            if (r9 == 0) goto L_0x0098
            java.lang.String r8 = r3.getProvider()     // Catch:{ Exception -> 0x0096 }
            java.lang.String r9 = r0.getProvider()     // Catch:{ Exception -> 0x0096 }
            boolean r8 = r8.equals(r9)     // Catch:{ Exception -> 0x0096 }
            goto L_0x0098
        L_0x0096:
            goto L_0x001d
        L_0x0098:
            if (r6 == 0) goto L_0x009b
            goto L_0x00a6
        L_0x009b:
            if (r4 == 0) goto L_0x00a0
            if (r7 != 0) goto L_0x00a0
            goto L_0x00a6
        L_0x00a0:
            if (r4 == 0) goto L_0x001d
            if (r5 != 0) goto L_0x001d
            if (r8 == 0) goto L_0x001d
        L_0x00a6:
            r0 = r3
            goto L_0x001d
        L_0x00a9:
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ Exception -> 0x00cb }
            r12.<init>()     // Catch:{ Exception -> 0x00cb }
            if (r0 == 0) goto L_0x00ca
            double r1 = r0.getLatitude()     // Catch:{ Exception -> 0x00cb }
            java.lang.Double r1 = java.lang.Double.valueOf(r1)     // Catch:{ Exception -> 0x00cb }
            java.lang.String r2 = "lat"
            r12.put(r2, r1)     // Catch:{ Exception -> 0x00cb }
            double r0 = r0.getLongitude()     // Catch:{ Exception -> 0x00cb }
            java.lang.Double r0 = java.lang.Double.valueOf(r0)     // Catch:{ Exception -> 0x00cb }
            java.lang.String r1 = "lon"
            r12.put(r1, r0)     // Catch:{ Exception -> 0x00cb }
        L_0x00ca:
            return r12
        L_0x00cb:
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.cbase.utils.location.LocationUtils.b(android.content.Context):java.util.HashMap");
    }
}
