package com.baidu.idl.face.platform.utils;

import com.google.common.primitives.UnsignedBytes;

public class ImageExif {
    private static final String TAG = "CameraExif";

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0062, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0063, code lost:
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0064, code lost:
        if (r9 <= 8) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0066, code lost:
        r2 = pack(r11, r1, 4, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006d, code lost:
        if (r2 == 1229531648) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0072, code lost:
        if (r2 == 1296891946) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0074, code lost:
        android.util.Log.e(TAG, "Invalid byte order");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0079, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007a, code lost:
        if (r2 != 1229531648) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x007d, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x007e, code lost:
        r2 = pack(r11, r1 + 4, 4, r5) + 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0087, code lost:
        if (r2 < 10) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0089, code lost:
        if (r2 <= r9) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008c, code lost:
        r1 = r1 + r2;
        r9 = r9 - r2;
        r2 = pack(r11, r1 - 2, 2, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0094, code lost:
        r3 = r2 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0096, code lost:
        if (r2 <= 0) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x009a, code lost:
        if (r9 < 12) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00a2, code lost:
        if (pack(r11, r1, 2, r5) != 274) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a4, code lost:
        r11 = pack(r11, r1 + 8, 2, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00aa, code lost:
        if (r11 == 3) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ad, code lost:
        if (r11 == 6) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00af, code lost:
        if (r11 == 8) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00b1, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00b2, code lost:
        return com.baidu.idl.face.platform.utils.BitmapUtils.ROTATE270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00b5, code lost:
        return 90;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00b8, code lost:
        return com.baidu.idl.face.platform.utils.BitmapUtils.ROTATE180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00bb, code lost:
        r1 = r1 + 12;
        r9 = r9 - 12;
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00c1, code lost:
        android.util.Log.e(TAG, "Invalid offset");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00c6, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getOrientation(byte[] r11) {
        /*
            r0 = 0
            if (r11 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
        L_0x0005:
            int r2 = r1 + 3
            int r3 = r11.length
            java.lang.String r4 = "CameraExif"
            r5 = 1
            r6 = 4
            r7 = 8
            r8 = 2
            if (r2 >= r3) goto L_0x0063
            int r2 = r1 + 1
            byte r3 = r11[r1]
            r9 = 255(0xff, float:3.57E-43)
            r3 = r3 & r9
            if (r3 != r9) goto L_0x0062
            byte r3 = r11[r2]
            r3 = r3 & r9
            if (r3 != r9) goto L_0x0021
        L_0x001f:
            r1 = r2
            goto L_0x0005
        L_0x0021:
            int r2 = r1 + 2
            r9 = 216(0xd8, float:3.03E-43)
            if (r3 == r9) goto L_0x001f
            if (r3 != r5) goto L_0x002a
            goto L_0x001f
        L_0x002a:
            r9 = 217(0xd9, float:3.04E-43)
            if (r3 == r9) goto L_0x0062
            r9 = 218(0xda, float:3.05E-43)
            if (r3 != r9) goto L_0x0033
            goto L_0x0062
        L_0x0033:
            int r9 = pack(r11, r2, r8, r0)
            if (r9 < r8) goto L_0x005c
            int r2 = r2 + r9
            int r10 = r11.length
            if (r2 <= r10) goto L_0x003e
            goto L_0x005c
        L_0x003e:
            r10 = 225(0xe1, float:3.15E-43)
            if (r3 != r10) goto L_0x001f
            if (r9 < r7) goto L_0x001f
            int r3 = r1 + 4
            int r3 = pack(r11, r3, r6, r0)
            r10 = 1165519206(0x45786966, float:3974.5874)
            if (r3 != r10) goto L_0x001f
            int r3 = r1 + 8
            int r3 = pack(r11, r3, r8, r0)
            if (r3 != 0) goto L_0x001f
            int r1 = r1 + 10
            int r9 = r9 + -8
            goto L_0x0064
        L_0x005c:
            java.lang.String r11 = "Invalid length"
            android.util.Log.e(r4, r11)
            return r0
        L_0x0062:
            r1 = r2
        L_0x0063:
            r9 = 0
        L_0x0064:
            if (r9 <= r7) goto L_0x00c6
            int r2 = pack(r11, r1, r6, r0)
            r3 = 1229531648(0x49492a00, float:823968.0)
            if (r2 == r3) goto L_0x007a
            r10 = 1296891946(0x4d4d002a, float:2.14958752E8)
            if (r2 == r10) goto L_0x007a
            java.lang.String r11 = "Invalid byte order"
            android.util.Log.e(r4, r11)
            return r0
        L_0x007a:
            if (r2 != r3) goto L_0x007d
            goto L_0x007e
        L_0x007d:
            r5 = 0
        L_0x007e:
            int r2 = r1 + 4
            int r2 = pack(r11, r2, r6, r5)
            int r2 = r2 + r8
            r3 = 10
            if (r2 < r3) goto L_0x00c1
            if (r2 <= r9) goto L_0x008c
            goto L_0x00c1
        L_0x008c:
            int r1 = r1 + r2
            int r9 = r9 - r2
            int r2 = r1 + -2
            int r2 = pack(r11, r2, r8, r5)
        L_0x0094:
            int r3 = r2 + -1
            if (r2 <= 0) goto L_0x00c6
            r2 = 12
            if (r9 < r2) goto L_0x00c6
            int r2 = pack(r11, r1, r8, r5)
            r4 = 274(0x112, float:3.84E-43)
            if (r2 != r4) goto L_0x00bb
            int r1 = r1 + r7
            int r11 = pack(r11, r1, r8, r5)
            r1 = 3
            if (r11 == r1) goto L_0x00b8
            r1 = 6
            if (r11 == r1) goto L_0x00b5
            if (r11 == r7) goto L_0x00b2
            return r0
        L_0x00b2:
            r11 = 270(0x10e, float:3.78E-43)
            return r11
        L_0x00b5:
            r11 = 90
            return r11
        L_0x00b8:
            r11 = 180(0xb4, float:2.52E-43)
            return r11
        L_0x00bb:
            int r1 = r1 + 12
            int r9 = r9 + -12
            r2 = r3
            goto L_0x0094
        L_0x00c1:
            java.lang.String r11 = "Invalid offset"
            android.util.Log.e(r4, r11)
        L_0x00c6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.face.platform.utils.ImageExif.getOrientation(byte[]):int");
    }

    private static int pack(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        if (z) {
            i += i2 - 1;
            i3 = -1;
        } else {
            i3 = 1;
        }
        byte b = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 <= 0) {
                return b;
            }
            if (i >= 0 && bArr != null && i < bArr.length) {
                b = (b << 8) | (bArr[i] & UnsignedBytes.MAX_VALUE);
            }
            i += i3;
            i2 = i4;
        }
    }
}
