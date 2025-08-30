package com.trustdecision.android.o0O00o00OOoOo0oooOoo00;

import com.trustdecision.android.shell.inter.TDDeviceInfoCallback;
import org.apache.commons.lang3.CharEncoding;

class O00OO0oOOooooO00000Oo implements Runnable {
    final /* synthetic */ o0Oo0OO00O0O000ooOO0 o0O00o00OOoOo0oooOoo00;
    final /* synthetic */ TDDeviceInfoCallback o0Oo0OO00O0O000ooOO0;

    public O00OO0oOOooooO00000Oo(o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0, TDDeviceInfoCallback tDDeviceInfoCallback) {
        this.o0O00o00OOoOo0oooOoo00 = o0oo0oo00o0o000oooo0;
        this.o0Oo0OO00O0O000ooOO0 = tDDeviceInfoCallback;
    }

    private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 76);
            byte b2 = (byte) (bArr[0] ^ 88);
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

    /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|(2:4|5)|6|7|8|9|10|11|12|27|(4:31|(1:33)(1:35)|34|43)(2:30|42)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x005c */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x015e A[Catch:{ JSONException -> 0x009d, all -> 0x0099 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0186 A[Catch:{ JSONException -> 0x009d, all -> 0x0099 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x01bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r18 = this;
            r1 = r18
            r0 = 2
            r2 = 1
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00()
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 r3 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.lang.String r5 = "395d4c776250"
            r6 = 0
            java.lang.String r5 = o0Oo0OO00O0O000ooOO0(r5, r6)
            java.lang.String r7 = r3.ooOoOooO
            r4.put(r5, r7)
            java.lang.String r5 = "2e010513081413"
            r7 = 94
            java.lang.String r5 = o0Oo0OO00O0O000ooOO0(r5, r7)
            java.lang.String r7 = "6d4b4f4f4c"
            r8 = 28
            java.lang.String r7 = o0Oo0OO00O0O000ooOO0(r7, r8)
            r4.put(r5, r7)
            java.lang.String r5 = "28585a4f53425e"
            r7 = 5
            java.lang.String r5 = o0Oo0OO00O0O000ooOO0(r5, r7)
            java.lang.String r7 = r3.O0oOO0ooO
            r4.put(r5, r7)
            java.lang.String r5 = ""
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0 r7 = r1.o0O00o00OOoOo0oooOoo00     // Catch:{ all -> 0x01aa }
            com.trustdecision.android.shell.TDOption r8 = r7.O0oOO0ooO     // Catch:{ all -> 0x01aa }
            r7.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.shell.TDOption) r8)     // Catch:{ all -> 0x01aa }
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0 r7 = r1.o0O00o00OOoOo0oooOoo00     // Catch:{ all -> 0x01aa }
            java.util.concurrent.CountDownLatch r7 = r7.o0oOO0oO00OoO0     // Catch:{ all -> 0x01aa }
            if (r7 == 0) goto L_0x005c
            int r7 = r3.oO00o0OooO0OO0o0000o     // Catch:{ all -> 0x005c }
            int r7 = r7 * 3
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0 r8 = r1.o0O00o00OOoOo0oooOoo00     // Catch:{ all -> 0x005c }
            java.util.concurrent.CountDownLatch r8 = r8.o0oOO0oO00OoO0     // Catch:{ all -> 0x005c }
            long r9 = (long) r7     // Catch:{ all -> 0x005c }
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x005c }
            r8.await(r9, r7)     // Catch:{ all -> 0x005c }
        L_0x005c:
            android.content.Context r7 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()     // Catch:{ all -> 0x01aa }
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r7 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0.o0Oo0OO00O0O000ooOO0((android.content.Context) r7, (com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0) r3)     // Catch:{ all -> 0x01aa }
            java.lang.String r3 = r3.oO0OOO00     // Catch:{ all -> 0x01aa }
            byte[] r7 = r7.o0Oo0OO00O0O000ooOO0((boolean) r6)     // Catch:{ all -> 0x01aa }
            java.lang.String r3 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(r3, r4, r7, r0)     // Catch:{ all -> 0x01aa }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x0099 }
            r4.<init>(r3)     // Catch:{ all -> 0x0099 }
            java.lang.String r7 = "3b41464c"
            java.lang.String r7 = o0Oo0OO00O0O000ooOO0(r7, r2)     // Catch:{ all -> 0x0099 }
            java.lang.String r7 = r4.optString(r7, r5)     // Catch:{ all -> 0x0099 }
            java.lang.String r8 = "350e1006140004"
            r9 = 74
            java.lang.String r8 = o0Oo0OO00O0O000ooOO0(r8, r9)     // Catch:{ all -> 0x0099 }
            r9 = 0
            java.lang.String r8 = r4.optString(r8, r9)     // Catch:{ all -> 0x0099 }
            r10 = 38
            java.lang.String r11 = "2a7574647b7a"
            r12 = 46
            java.lang.String r11 = o0Oo0OO00O0O000ooOO0(r11, r12)     // Catch:{ JSONException -> 0x009d }
            org.json.JSONObject r9 = r4.getJSONObject(r11)     // Catch:{ JSONException -> 0x009d }
            goto L_0x00f1
        L_0x0099:
            r0 = move-exception
            r5 = r3
            goto L_0x01ab
        L_0x009d:
            java.lang.String r11 = "2a6c6d7d6263"
            r12 = 55
            java.lang.String r11 = o0Oo0OO00O0O000ooOO0(r11, r12)     // Catch:{ all -> 0x0099 }
            java.lang.String r11 = r4.optString(r11, r5)     // Catch:{ all -> 0x0099 }
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0099 }
            if (r12 != 0) goto L_0x00f1
            java.lang.String r9 = "2a7d7e6e7a7c6d5747"
            java.lang.String r9 = o0Oo0OO00O0O000ooOO0(r9, r10)     // Catch:{ all -> 0x0099 }
            java.lang.String r9 = r4.optString(r9, r5)     // Catch:{ all -> 0x0099 }
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x0099 }
            r0[r6] = r11     // Catch:{ all -> 0x0099 }
            r0[r2] = r9     // Catch:{ all -> 0x0099 }
            r9 = 75
            java.lang.Object r0 = com.trustdecision.android.shell.common.HelperJNI.o0Oo0OO00O0O000ooOO0((int) r9, (java.lang.Object) r0)     // Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x00d3
            boolean r9 = r0 instanceof java.lang.String     // Catch:{ all -> 0x0099 }
            if (r9 == 0) goto L_0x00d3
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ all -> 0x0099 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0099 }
            r9.<init>(r0)     // Catch:{ all -> 0x0099 }
            goto L_0x00f1
        L_0x00d3:
            java.lang.String r0 = "0d6658585c454413184a5d404001532f6a4b5b44450914470e14585d545f5b501f"
            r4 = 17
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0(r0, r4)     // Catch:{ all -> 0x0099 }
            com.trustdecision.android.shell.inter.TDDeviceInfoCallback r7 = r1.o0Oo0OO00O0O000ooOO0     // Catch:{ all -> 0x0099 }
            java.lang.String r8 = ""
            java.lang.String r9 = ""
            java.lang.String r10 = ""
            com.trustdecision.android.shell.common.TDDeviceAPIStatus r12 = new com.trustdecision.android.shell.common.TDDeviceAPIStatus     // Catch:{ all -> 0x0099 }
            r4 = 1100(0x44c, float:1.541E-42)
            r12.<init>(r4, r0)     // Catch:{ all -> 0x0099 }
            java.lang.String r13 = ""
            r11 = 0
            r7.onResult(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x0099 }
            return
        L_0x00f1:
            java.lang.String r0 = "683232"
            r11 = 126(0x7e, float:1.77E-43)
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0(r0, r11)     // Catch:{ all -> 0x0099 }
            boolean r0 = r0.equals(r7)     // Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x0150
            if (r9 == 0) goto L_0x0150
            java.lang.String r0 = "3e15252d091f04181f"
            r7 = 82
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0(r0, r7)     // Catch:{ all -> 0x0099 }
            java.lang.String r12 = r9.optString(r0, r5)     // Catch:{ all -> 0x0099 }
            java.lang.String r0 = "2c203f35301c16"
            r7 = 119(0x77, float:1.67E-43)
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0(r0, r7)     // Catch:{ all -> 0x0099 }
            java.lang.String r13 = r9.optString(r0, r5)     // Catch:{ all -> 0x0099 }
            java.lang.String r0 = "39656b6b7d7e68706c5047"
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0(r0, r10)     // Catch:{ all -> 0x0099 }
            java.lang.String r14 = r9.optString(r0, r5)     // Catch:{ all -> 0x0099 }
            java.lang.String r0 = "3c495b57424e7f735250707844555f"
            r7 = 4
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0(r0, r7)     // Catch:{ all -> 0x0099 }
            int r15 = r9.optInt(r0, r6)     // Catch:{ all -> 0x0099 }
            java.lang.String r0 = "2b0c1e17131b2c2d0c1c0302"
            r7 = 86
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0(r0, r7)     // Catch:{ all -> 0x0099 }
            java.lang.String r17 = r4.optString(r0, r5)     // Catch:{ all -> 0x0099 }
            com.trustdecision.android.shell.inter.TDDeviceInfoCallback r11 = r1.o0Oo0OO00O0O000ooOO0     // Catch:{ all -> 0x0099 }
            com.trustdecision.android.shell.common.TDDeviceAPIStatus r0 = new com.trustdecision.android.shell.common.TDDeviceAPIStatus     // Catch:{ all -> 0x0099 }
            java.lang.String r4 = "0b4d7d6b6d7d6b"
            r5 = 39
            java.lang.String r4 = o0Oo0OO00O0O000ooOO0(r4, r5)     // Catch:{ all -> 0x0099 }
            r0.<init>(r6, r4)     // Catch:{ all -> 0x0099 }
            r16 = r0
            r11.onResult(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0099 }
            goto L_0x01dc
        L_0x0150:
            java.lang.String r0 = "6e585e"
            r4 = 18
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0(r0, r4)     // Catch:{ all -> 0x0099 }
            boolean r0 = r0.equals(r7)     // Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x0186
            java.util.Locale r0 = java.util.Locale.US     // Catch:{ all -> 0x0099 }
            java.lang.String r4 = "0c60554146494c050a4342425b1c484310"
            r5 = 10
            java.lang.String r4 = o0Oo0OO00O0O000ooOO0(r4, r5)     // Catch:{ all -> 0x0099 }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ all -> 0x0099 }
            r5[r6] = r8     // Catch:{ all -> 0x0099 }
            java.lang.String r0 = java.lang.String.format(r0, r4, r5)     // Catch:{ all -> 0x0099 }
            com.trustdecision.android.shell.inter.TDDeviceInfoCallback r7 = r1.o0Oo0OO00O0O000ooOO0     // Catch:{ all -> 0x0099 }
            java.lang.String r8 = ""
            java.lang.String r9 = ""
            java.lang.String r10 = ""
            com.trustdecision.android.shell.common.TDDeviceAPIStatus r12 = new com.trustdecision.android.shell.common.TDDeviceAPIStatus     // Catch:{ all -> 0x0099 }
            r4 = 1004(0x3ec, float:1.407E-42)
            r12.<init>(r4, r0)     // Catch:{ all -> 0x0099 }
            java.lang.String r13 = ""
        L_0x0181:
            r11 = 0
            r7.onResult(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x0099 }
            goto L_0x01dc
        L_0x0186:
            java.util.Locale r0 = java.util.Locale.US     // Catch:{ all -> 0x0099 }
            java.lang.String r4 = "19424a3a1644534e4e0f5d5605"
            r5 = 31
            java.lang.String r4 = o0Oo0OO00O0O000ooOO0(r4, r5)     // Catch:{ all -> 0x0099 }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ all -> 0x0099 }
            r5[r6] = r8     // Catch:{ all -> 0x0099 }
            java.lang.String r0 = java.lang.String.format(r0, r4, r5)     // Catch:{ all -> 0x0099 }
            com.trustdecision.android.shell.inter.TDDeviceInfoCallback r7 = r1.o0Oo0OO00O0O000ooOO0     // Catch:{ all -> 0x0099 }
            java.lang.String r8 = ""
            java.lang.String r9 = ""
            java.lang.String r10 = ""
            com.trustdecision.android.shell.common.TDDeviceAPIStatus r12 = new com.trustdecision.android.shell.common.TDDeviceAPIStatus     // Catch:{ all -> 0x0099 }
            r4 = 1003(0x3eb, float:1.406E-42)
            r12.<init>(r4, r0)     // Catch:{ all -> 0x0099 }
            java.lang.String r13 = ""
            goto L_0x0181
        L_0x01aa:
            r0 = move-exception
        L_0x01ab:
            java.util.Locale r3 = java.util.Locale.US
            java.lang.String r4 = "161b2133282d297b7527302d2d6c3e3566"
            r7 = 124(0x7c, float:1.74E-43)
            java.lang.String r4 = o0Oo0OO00O0O000ooOO0(r4, r7)
            boolean r7 = android.text.TextUtils.isEmpty(r5)
            if (r7 == 0) goto L_0x01bf
            java.lang.String r5 = r0.toString()
        L_0x01bf:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r0[r6] = r5
            java.lang.String r0 = java.lang.String.format(r3, r4, r0)
            com.trustdecision.android.shell.inter.TDDeviceInfoCallback r2 = r1.o0Oo0OO00O0O000ooOO0
            com.trustdecision.android.shell.common.TDDeviceAPIStatus r7 = new com.trustdecision.android.shell.common.TDDeviceAPIStatus
            r3 = 1002(0x3ea, float:1.404E-42)
            r7.<init>(r3, r0)
            java.lang.String r8 = ""
            java.lang.String r3 = ""
            java.lang.String r4 = ""
            java.lang.String r5 = ""
            r6 = 0
            r2.onResult(r3, r4, r5, r6, r7, r8)
        L_0x01dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.run():void");
    }
}
