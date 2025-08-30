package com.trustdecision.mobrisk.o0O00o00OOoOo0oooOoo00;

import org.apache.commons.lang3.CharEncoding;

public class o0O00o00OOoOo0oooOoo00 {
    private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 92);
            byte b2 = (byte) (bArr[0] ^ 84);
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

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void o0Oo0OO00O0O000ooOO0(java.lang.String r9) {
        /*
            r0 = 1
            r1 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r9)
            if (r2 == 0) goto L_0x0009
            return
        L_0x0009:
            java.lang.String r2 = "073b"
            r3 = 115(0x73, float:1.61E-43)
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0(r2, r3)
            boolean r2 = r9.equals(r2)
            r4 = 0
            if (r2 == 0) goto L_0x0021
            java.lang.String r2 = "3c283430377d213468207e7f226a7b252d29247e743f25"
            r5 = 104(0x68, float:1.46E-43)
        L_0x001c:
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0(r2, r5)
            goto L_0x006e
        L_0x0021:
            java.lang.String r2 = "0108"
            r5 = 82
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0(r2, r5)
            boolean r2 = r9.equals(r2)
            if (r2 == 0) goto L_0x0034
            java.lang.String r2 = "3c687470773d61742e722a3f622a3b656d69643e347f65"
            r5 = 40
            goto L_0x001c
        L_0x0034:
            java.lang.String r2 = "1d101712"
            r5 = 65
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0(r2, r5)
            boolean r2 = r9.equals(r2)
            if (r2 == 0) goto L_0x0047
            java.lang.String r2 = "3c514d494e04584d0b4004065b13025c54505d070d465c"
            r5 = 17
            goto L_0x001c
        L_0x0047:
            java.lang.String r2 = "120f08"
            r5 = 71
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0(r2, r5)
            boolean r2 = r9.equals(r2)
            if (r2 == 0) goto L_0x005a
            java.lang.String r2 = "3c6c7074733965703b71383b662e3f61696d603a307b61"
            r5 = 44
            goto L_0x001c
        L_0x005a:
            java.lang.String r2 = "170f"
            r5 = 94
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0(r2, r5)
            boolean r2 = r9.equals(r2)
            if (r2 == 0) goto L_0x006d
            java.lang.String r2 = "3c7f6367602a76632e74716876343978626a60727823236872"
            r5 = 63
            goto L_0x001c
        L_0x006d:
            r2 = r4
        L_0x006e:
            if (r2 != 0) goto L_0x008b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "1a006e67283b3a2b65622d3b3a3b272a623b"
            r2 = 125(0x7d, float:1.75E-43)
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0(r1, r2)
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00(r9)
            return
        L_0x008b:
            java.lang.String r9 = "37232d6c75292829283f2e29253535292e6f602025393229226563383d243a7843183d243a"
            java.lang.String r9 = o0Oo0OO00O0O000ooOO0(r9, r3)     // Catch:{ all -> 0x00d8 }
            java.lang.String r3 = "27797e58596968746d4a487368"
            r5 = 51
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0(r3, r5)     // Catch:{ all -> 0x00d8 }
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ all -> 0x00d8 }
            r5[r1] = r2     // Catch:{ all -> 0x00d8 }
            com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((java.lang.String) r9, (java.lang.Object) r4, (java.lang.String) r3, (java.lang.Object[]) r5)     // Catch:{ all -> 0x00d8 }
            java.lang.String r9 = "37474908114d4c4d4c5b4a4d4151514d4a0b0444415d564d4601075c59405e1c277c59405e"
            r2 = 23
            java.lang.String r9 = o0Oo0OO00O0O000ooOO0(r9, r2)     // Catch:{ all -> 0x00d8 }
            java.lang.String r2 = "3d232339071a3938020b31393b37"
            r3 = 120(0x78, float:1.68E-43)
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0(r2, r3)     // Catch:{ all -> 0x00d8 }
            android.content.Context r3 = com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()     // Catch:{ all -> 0x00d8 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x00d8 }
            java.lang.String r6 = "6161656566"
            r7 = 38
            java.lang.String r6 = o0Oo0OO00O0O000ooOO0(r6, r7)     // Catch:{ all -> 0x00d8 }
            android.content.Context r7 = com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()     // Catch:{ all -> 0x00d8 }
            java.lang.String r7 = com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(r7)     // Catch:{ all -> 0x00d8 }
            r8 = 4
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x00d8 }
            r8[r1] = r3     // Catch:{ all -> 0x00d8 }
            r8[r0] = r5     // Catch:{ all -> 0x00d8 }
            r0 = 2
            r8[r0] = r6     // Catch:{ all -> 0x00d8 }
            r0 = 3
            r8[r0] = r7     // Catch:{ all -> 0x00d8 }
            com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((java.lang.String) r9, (java.lang.Object) r4, (java.lang.String) r2, (java.lang.Object[]) r8)     // Catch:{ all -> 0x00d8 }
        L_0x00d8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.mobrisk.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(java.lang.String):void");
    }
}
