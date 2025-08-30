package com.trustdecision.android.wifiinfo.i1lill1;

import android.annotation.TargetApi;
import android.os.Build;
import com.google.common.primitives.UnsignedBytes;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import org.apache.commons.lang3.CharEncoding;

public class ii11i111 {
    /* JADX WARNING: Can't wrap try/catch for region: R(5:36|(0)|42|43|44) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:23|24|25|26|27|28) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:38|37|(0)|49|50|51) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0064 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x006b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x0079 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0082 */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0076 A[SYNTHETIC, Splitter:B:40:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x007f A[SYNTHETIC, Splitter:B:47:0x007f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String i1lill1(java.lang.String r7) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream
            r7.<init>()
            boolean r1 = r0.exists()
            r2 = 0
            if (r1 == 0) goto L_0x0085
            boolean r1 = r0.canRead()
            if (r1 == 0) goto L_0x0085
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x002f, all -> 0x002c }
        L_0x0020:
            int r3 = r1.read(r0)     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            r4 = -1
            if (r3 == r4) goto L_0x0031
            r4 = 0
            r7.write(r0, r4, r3)     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            goto L_0x0020
        L_0x002c:
            r0 = move-exception
            r2 = r1
            goto L_0x0074
        L_0x002f:
            goto L_0x007d
        L_0x0031:
            byte[] r0 = r7.toByteArray()     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            java.lang.String r3 = ""
            if (r0 == 0) goto L_0x0068
            int r4 = r0.length     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            if (r4 != 0) goto L_0x003d
            goto L_0x0068
        L_0x003d:
            java.lang.String r4 = new java.lang.String     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            java.lang.String r5 = "0934277e20"
            r6 = 111(0x6f, float:1.56E-43)
            java.lang.String r5 = ii11i111(r5, r6)     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            r4.<init>(r0, r5)     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            java.lang.String r0 = "205d"
            r5 = 53
            java.lang.String r0 = ii11i111(r0, r5)     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            java.lang.String r0 = r4.replaceAll(r0, r3)     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            java.lang.String r4 = "5c"
            r5 = 5
            java.lang.String r4 = ii11i111(r4, r5)     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            java.lang.String r0 = r0.replaceAll(r4, r3)     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            r1.close()     // Catch:{ IOException -> 0x0064 }
        L_0x0064:
            r7.close()     // Catch:{ IOException -> 0x0067 }
        L_0x0067:
            return r0
        L_0x0068:
            r1.close()     // Catch:{ IOException -> 0x006b }
        L_0x006b:
            r7.close()     // Catch:{ IOException -> 0x006e }
        L_0x006e:
            return r3
        L_0x006f:
            r0 = move-exception
            goto L_0x0074
        L_0x0071:
            r1 = r2
            goto L_0x007d
        L_0x0074:
            if (r2 == 0) goto L_0x0079
            r2.close()     // Catch:{ IOException -> 0x0079 }
        L_0x0079:
            r7.close()     // Catch:{ IOException -> 0x007c }
        L_0x007c:
            throw r0
        L_0x007d:
            if (r1 == 0) goto L_0x0082
            r1.close()     // Catch:{ IOException -> 0x0082 }
        L_0x0082:
            r7.close()     // Catch:{ IOException -> 0x0085 }
        L_0x0085:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.wifiinfo.i1lill1.ii11i111.i1lill1(java.lang.String):java.lang.String");
    }

    @TargetApi(23)
    public static String ii11i111() {
        if (Build.VERSION.SDK_INT > 23) {
            try {
                Iterator<T> it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                while (it.hasNext()) {
                    NetworkInterface networkInterface = (NetworkInterface) it.next();
                    if (networkInterface.getName().equalsIgnoreCase(ii11i111("0b52444617", 19))) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        if (hardwareAddress == null) {
                            return "";
                        }
                        StringBuilder sb = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i = 0; i < length; i++) {
                            sb.append(String.format(ii11i111("5975620a02", 58), new Object[]{Byte.valueOf(hardwareAddress[i])}));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString().toLowerCase();
                    }
                }
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String ii11i111(String str) {
        try {
            NetworkInterface byInetAddress = NetworkInterface.getByInetAddress(InetAddress.getByName(str));
            return byInetAddress != null ? ii11i111(byInetAddress.getHardwareAddress()) : "";
        } catch (Exception unused) {
            return "";
        }
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
            byte b = (byte) (i ^ 90);
            byte b2 = (byte) (bArr[0] ^ 124);
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

    public static String ii11i111(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & UnsignedBytes.MAX_VALUE);
            if (hexString.length() == 1) {
                stringBuffer.append(ii11i111("4c", 26));
            }
            stringBuffer.append(hexString);
            stringBuffer.append(ii11i111("46", 2));
        }
        return String.valueOf(stringBuffer.substring(0, stringBuffer.length() - 1));
    }

    public static boolean ii11i111(int i) {
        return Build.VERSION.SDK_INT < i;
    }
}
