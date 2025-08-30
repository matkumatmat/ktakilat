package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;

final class zzor {
    public static final /* synthetic */ int zza = 0;

    static {
        if (zzoo.zza() && zzoo.zzb()) {
            int i = zzku.zza;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zza(byte[] r6, int r7, int r8) {
        /*
        L_0x0000:
            if (r7 >= r8) goto L_0x0009
            byte r0 = r6[r7]
            if (r0 < 0) goto L_0x0009
            int r7 = r7 + 1
            goto L_0x0000
        L_0x0009:
            if (r7 < r8) goto L_0x000d
            goto L_0x007a
        L_0x000d:
            if (r7 >= r8) goto L_0x007a
            int r0 = r7 + 1
            byte r1 = r6[r7]
            if (r1 >= 0) goto L_0x0078
            r2 = -32
            r3 = -65
            if (r1 >= r2) goto L_0x0029
            if (r0 < r8) goto L_0x001e
            goto L_0x0057
        L_0x001e:
            r2 = -62
            if (r1 < r2) goto L_0x0076
            int r7 = r7 + 2
            byte r0 = r6[r0]
            if (r0 <= r3) goto L_0x000d
            goto L_0x0076
        L_0x0029:
            r4 = -16
            if (r1 >= r4) goto L_0x004f
            int r4 = r8 + -1
            if (r0 < r4) goto L_0x0036
            int r1 = zzd(r6, r0, r8)
            goto L_0x0057
        L_0x0036:
            int r4 = r7 + 2
            byte r0 = r6[r0]
            if (r0 > r3) goto L_0x0076
            r5 = -96
            if (r1 != r2) goto L_0x0042
            if (r0 < r5) goto L_0x0076
        L_0x0042:
            r2 = -19
            if (r1 != r2) goto L_0x0048
            if (r0 >= r5) goto L_0x0076
        L_0x0048:
            int r7 = r7 + 3
            byte r0 = r6[r4]
            if (r0 <= r3) goto L_0x000d
            goto L_0x0076
        L_0x004f:
            int r2 = r8 + -2
            if (r0 < r2) goto L_0x005a
            int r1 = zzd(r6, r0, r8)
        L_0x0057:
            if (r1 == 0) goto L_0x007a
            goto L_0x0076
        L_0x005a:
            int r2 = r7 + 2
            byte r0 = r6[r0]
            if (r0 > r3) goto L_0x0076
            int r1 = r1 << 28
            int r0 = r0 + 112
            int r0 = r0 + r1
            int r0 = r0 >> 30
            if (r0 != 0) goto L_0x0076
            int r0 = r7 + 3
            byte r1 = r6[r2]
            if (r1 > r3) goto L_0x0076
            int r7 = r7 + 4
            byte r0 = r6[r0]
            if (r0 > r3) goto L_0x0076
            goto L_0x000d
        L_0x0076:
            r6 = 0
            return r6
        L_0x0078:
            r7 = r0
            goto L_0x000d
        L_0x007a:
            r6 = 1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzor.zza(byte[], int, int):boolean");
    }

    public static int zzb(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && str.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = str.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = str.length();
                while (i2 < length2) {
                    char charAt2 = str.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(str, i2) >= 65536) {
                                i2++;
                            } else {
                                throw new zzoq(i2, length2);
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        long j = ((long) i3) + 4294967296L;
        StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 34);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzc(java.lang.String r8, byte[] r9, int r10, int r11) {
        /*
            int r0 = r8.length()
            r1 = 0
        L_0x0005:
            int r2 = r10 + r11
            r3 = 128(0x80, float:1.794E-43)
            if (r1 >= r0) goto L_0x001b
            int r4 = r1 + r10
            if (r4 >= r2) goto L_0x001b
            char r5 = r8.charAt(r1)
            if (r5 >= r3) goto L_0x001b
            byte r2 = (byte) r5
            r9[r4] = r2
            int r1 = r1 + 1
            goto L_0x0005
        L_0x001b:
            if (r1 != r0) goto L_0x0020
            int r10 = r10 + r0
            goto L_0x0114
        L_0x0020:
            int r10 = r10 + r1
        L_0x0021:
            if (r1 >= r0) goto L_0x0114
            char r11 = r8.charAt(r1)
            if (r11 >= r3) goto L_0x0033
            if (r10 >= r2) goto L_0x0033
            int r4 = r10 + 1
            byte r11 = (byte) r11
            r9[r10] = r11
            r10 = r4
            goto L_0x00b9
        L_0x0033:
            r4 = 2048(0x800, float:2.87E-42)
            if (r11 >= r4) goto L_0x004e
            int r4 = r2 + -2
            if (r10 > r4) goto L_0x004e
            int r4 = r10 + 1
            int r5 = r10 + 2
            int r6 = r11 >>> 6
            r6 = r6 | 960(0x3c0, float:1.345E-42)
            byte r6 = (byte) r6
            r9[r10] = r6
            r10 = r11 & 63
            r10 = r10 | r3
            byte r10 = (byte) r10
            r9[r4] = r10
            r10 = r5
            goto L_0x00b9
        L_0x004e:
            r4 = 57343(0xdfff, float:8.0355E-41)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r11 < r5) goto L_0x0058
            if (r11 <= r4) goto L_0x0079
        L_0x0058:
            int r6 = r2 + -3
            if (r10 > r6) goto L_0x0079
            int r4 = r10 + 1
            int r5 = r10 + 2
            int r6 = r10 + 3
            int r7 = r11 >>> 12
            r7 = r7 | 480(0x1e0, float:6.73E-43)
            byte r7 = (byte) r7
            r9[r10] = r7
            int r10 = r11 >>> 6
            r10 = r10 & 63
            r10 = r10 | r3
            byte r10 = (byte) r10
            r9[r4] = r10
            r10 = r11 & 63
            r10 = r10 | r3
            byte r10 = (byte) r10
            r9[r5] = r10
            r10 = r6
            goto L_0x00b9
        L_0x0079:
            int r6 = r2 + -4
            if (r10 > r6) goto L_0x00c6
            int r4 = r1 + 1
            int r5 = r8.length()
            if (r4 == r5) goto L_0x00be
            char r1 = r8.charAt(r4)
            boolean r5 = java.lang.Character.isSurrogatePair(r11, r1)
            if (r5 == 0) goto L_0x00bd
            int r5 = r10 + 1
            int r6 = r10 + 2
            int r7 = r10 + 3
            int r11 = java.lang.Character.toCodePoint(r11, r1)
            int r1 = r11 >>> 18
            r1 = r1 | 240(0xf0, float:3.36E-43)
            byte r1 = (byte) r1
            r9[r10] = r1
            int r1 = r11 >>> 12
            r1 = r1 & 63
            r1 = r1 | r3
            byte r1 = (byte) r1
            r9[r5] = r1
            int r1 = r11 >>> 6
            r1 = r1 & 63
            r1 = r1 | r3
            byte r1 = (byte) r1
            r9[r6] = r1
            int r10 = r10 + 4
            r11 = r11 & 63
            r11 = r11 | r3
            byte r11 = (byte) r11
            r9[r7] = r11
            r1 = r4
        L_0x00b9:
            int r1 = r1 + 1
            goto L_0x0021
        L_0x00bd:
            r1 = r4
        L_0x00be:
            com.google.android.gms.internal.measurement.zzoq r8 = new com.google.android.gms.internal.measurement.zzoq
            int r1 = r1 + -1
            r8.<init>(r1, r0)
            throw r8
        L_0x00c6:
            if (r11 < r5) goto L_0x00e2
            if (r11 > r4) goto L_0x00e2
            int r9 = r1 + 1
            int r2 = r8.length()
            if (r9 == r2) goto L_0x00dc
            char r8 = r8.charAt(r9)
            boolean r8 = java.lang.Character.isSurrogatePair(r11, r8)
            if (r8 != 0) goto L_0x00e2
        L_0x00dc:
            com.google.android.gms.internal.measurement.zzoq r8 = new com.google.android.gms.internal.measurement.zzoq
            r8.<init>(r1, r0)
            throw r8
        L_0x00e2:
            java.lang.ArrayIndexOutOfBoundsException r8 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.String r9 = java.lang.String.valueOf(r11)
            int r9 = r9.length()
            java.lang.String r0 = java.lang.String.valueOf(r10)
            int r9 = r9 + 25
            int r0 = r0.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r9 = r9 + r0
            r1.<init>(r9)
            java.lang.String r9 = "Failed writing "
            r1.append(r9)
            r1.append(r11)
            java.lang.String r9 = " at index "
            r1.append(r9)
            r1.append(r10)
            java.lang.String r9 = r1.toString()
            r8.<init>(r9)
            throw r8
        L_0x0114:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzor.zzc(java.lang.String, byte[], int, int):int");
    }

    public static /* synthetic */ int zzd(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        byte b = bArr[i - 1];
        if (i3 != 0) {
            if (i3 == 1) {
                byte b2 = bArr[i];
                if (b > -12 || b2 > -65) {
                    return -1;
                }
                return (b2 << 8) ^ b;
            } else if (i3 == 2) {
                byte b3 = bArr[i];
                byte b4 = bArr[i + 1];
                if (b > -12 || b3 > -65 || b4 > -65) {
                    return -1;
                }
                return (b4 << Ascii.DLE) ^ ((b3 << 8) ^ b);
            } else {
                throw new AssertionError();
            }
        } else if (b <= -12) {
            return b;
        } else {
            return -1;
        }
    }
}
