package com.trustdecision.android.wifiinfo.ii11i111;

import org.apache.commons.lang3.CharEncoding;

public class ii11i111 {
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String ii11i111(android.net.wifi.WifiInfo r0, java.lang.String r1, boolean r2) {
        /*
            if (r2 == 0) goto L_0x001c
            r2 = 23
            boolean r2 = com.trustdecision.android.wifiinfo.i1lill1.ii11i111.ii11i111((int) r2)
            if (r2 == 0) goto L_0x0011
            if (r0 == 0) goto L_0x001c
            java.lang.String r0 = r0.getMacAddress()
            goto L_0x001e
        L_0x0011:
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L_0x001c
            java.lang.String r0 = com.trustdecision.android.wifiinfo.i1lill1.ii11i111.ii11i111((java.lang.String) r1)
            goto L_0x001e
        L_0x001c:
            java.lang.String r0 = ""
        L_0x001e:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0042
            java.lang.String r0 = "5e653333657536342b396578322862612234366726773c392f2e2f39"
            r1 = 35
            java.lang.String r0 = ii11i111(r0, r1)
            java.lang.String r1 = "5e4d1b1b4d5d1e1c03114d501a004a5b000d490e5f141107060711"
            r2 = 11
            java.lang.String r1 = ii11i111(r1, r2)
            java.lang.String r0 = com.trustdecision.android.wifiinfo.i1lill1.ii11i111.i1lill1(r0)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x0042
            java.lang.String r0 = com.trustdecision.android.wifiinfo.i1lill1.ii11i111.i1lill1(r1)
        L_0x0042:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x004c
            java.lang.String r0 = com.trustdecision.android.wifiinfo.i1lill1.ii11i111.ii11i111()
        L_0x004c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.wifiinfo.ii11i111.ii11i111.ii11i111(android.net.wifi.WifiInfo, java.lang.String, boolean):java.lang.String");
    }

    private static String ii11i111(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 26);
            byte b2 = (byte) (bArr[0] ^ 113);
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
}
