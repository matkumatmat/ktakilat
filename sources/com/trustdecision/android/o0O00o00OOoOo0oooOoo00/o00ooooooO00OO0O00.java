package com.trustdecision.android.o0O00o00OOoOo0oooOoo00;

import android.content.Context;
import com.trustdecision.android.shell.inter.FMCallback;
import org.apache.commons.lang3.CharEncoding;

class o00ooooooO00OO0O00 implements Runnable {
    final /* synthetic */ Context o0O00o00OOoOo0oooOoo00;
    final /* synthetic */ FMCallback o0Oo0OO00O0O000ooOO0;
    final /* synthetic */ o0Oo0OO00O0O000ooOO0 oO00o0OooO0OO0o0000o;

    public o00ooooooO00OO0O00(o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0, FMCallback fMCallback, Context context) {
        this.oO00o0OooO0OO0o0000o = o0oo0oo00o0o000oooo0;
        this.o0Oo0OO00O0O000ooOO0 = fMCallback;
        this.o0O00o00OOoOo0oooOoo00 = context;
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
            byte b = (byte) (i ^ 65);
            byte b2 = (byte) (bArr[0] ^ 99);
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

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0033, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r3 = this;
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0 r0 = r3.oO00o0OooO0OO0o0000o
            r1 = 1
            r0.o0Oo0OO00O0O000ooOO0((boolean) r1)
            com.trustdecision.android.shell.inter.FMCallback r0 = r3.o0Oo0OO00O0O000ooOO0
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.shell.inter.FMCallback) r0)
            boolean r0 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o
            if (r0 == 0) goto L_0x003c
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0 r0 = r3.oO00o0OooO0OO0o0000o
            boolean r0 = r0.O0OoOo00O000
            if (r0 == 0) goto L_0x003c
            android.content.Context r0 = r3.o0O00o00OOoOo0oooOoo00
            if (r0 == 0) goto L_0x003c
            boolean r0 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo
            if (r0 == 0) goto L_0x0029
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0 r0 = r3.oO00o0OooO0OO0o0000o
            android.content.Context r1 = r3.o0O00o00OOoOo0oooOoo00
            com.trustdecision.android.shell.inter.FMCallback r2 = r3.o0Oo0OO00O0O000ooOO0
            r0.oO00o0OooO0OO0o0000o((android.content.Context) r1, (com.trustdecision.android.shell.inter.FMCallback) r2)
            goto L_0x004b
        L_0x0029:
            android.content.Context r0 = r3.o0O00o00OOoOo0oooOoo00
            java.lang.String r0 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O00OO0oOOooooO00000Oo.o00ooooooO00OO0O00(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0036
            goto L_0x0044
        L_0x0036:
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0 r1 = r3.oO00o0OooO0OO0o0000o
            r1.o0Oo0OO00O0O000ooOO0((java.lang.String) r0)
            goto L_0x004b
        L_0x003c:
            android.content.Context r0 = r3.o0O00o00OOoOo0oooOoo00
            boolean r0 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0ooOoo0Oo00oOOO.o0Oo0OO00O0O000ooOO0(r0)
            if (r0 != 0) goto L_0x004c
        L_0x0044:
            android.content.Context r0 = r3.o0O00o00OOoOo0oooOoo00
            java.lang.String r0 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0((android.content.Context) r0)
            goto L_0x0036
        L_0x004b:
            return
        L_0x004c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "30574f2b0e415b140947475d5d484d45535f41084c105c4944525605125743435712145b0f145c4d0509475a51425553555d46410e044b4c5658484b5a55555d464100"
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0(r2, r1)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o00ooooooO00OO0O00.run():void");
    }
}
