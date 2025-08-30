package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0;
import com.trustdecision.android.shell.TDOption;
import java.util.concurrent.CountDownLatch;
import org.apache.commons.lang3.CharEncoding;

class oO0oo00OooOooOOo implements Runnable {
    final /* synthetic */ String O00OO0oOOooooO00000Oo;
    final /* synthetic */ CountDownLatch O0oOO0ooO;
    final /* synthetic */ oOO0OooO0 OO0000O0Ooo0OO000oo;
    final /* synthetic */ CountDownLatch o00ooooooO00OO0O00;
    final /* synthetic */ TDOption o0O00o00OOoOo0oooOoo00;
    final /* synthetic */ o0Oo0OO00O0O000ooOO0 o0Oo0OO00O0O000ooOO0;
    final /* synthetic */ String oO00o0OooO0OO0o0000o;

    public oO0oo00OooOooOOo(oOO0OooO0 ooo0oooo0, o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0, TDOption tDOption, String str, String str2, CountDownLatch countDownLatch, CountDownLatch countDownLatch2) {
        this.OO0000O0Ooo0OO000oo = ooo0oooo0;
        this.o0Oo0OO00O0O000ooOO0 = o0oo0oo00o0o000oooo0;
        this.o0O00o00OOoOo0oooOoo00 = tDOption;
        this.oO00o0OooO0OO0o0000o = str;
        this.O00OO0oOOooooO00000Oo = str2;
        this.O0oOO0ooO = countDownLatch;
        this.o00ooooooO00OO0O00 = countDownLatch2;
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
            byte b = (byte) (i ^ 89);
            byte b2 = (byte) (bArr[0] ^ 7);
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

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r8 = this;
            r0 = 2
            r1 = 0
            r2 = 1
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r3 = r8.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 r3 = r3.O0oOO0ooO
            boolean r3 = r3.O0oo0OOOOoO
            if (r3 == 0) goto L_0x0018
            com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0 r3 = r8.o0Oo0OO00O0O000ooOO0
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r8.OO0000O0Ooo0OO000oo
            android.content.Context r4 = r4.OO0000O0Ooo0OO000oo
            r3.o0Oo0OO00O0O000ooOO0((android.content.Context) r4)
        L_0x0018:
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r3 = r8.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 r3 = r3.O0oOO0ooO
            java.lang.String r3 = r3.OOoOo00oo0Ooo0o0o0o000
            java.lang.Object[] r4 = new java.lang.Object[r2]
            r4[r1] = r3
            r3 = 59
            com.trustdecision.android.shell.common.HelperJNI.o0Oo0OO00O0O000ooOO0((int) r3, (java.lang.Object) r4)
            java.lang.String r3 = "3253575754"
            r4 = 17
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0(r3, r4)
            java.lang.Object[] r4 = new java.lang.Object[r2]
            r4[r1] = r3
            r3 = 60
            com.trustdecision.android.shell.common.HelperJNI.o0Oo0OO00O0O000ooOO0((int) r3, (java.lang.Object) r4)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r3 = r8.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r3 = r3.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o r4 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0OOo000OO0o0000O00oO0.o0O00o00OOoOo0oooOoo00()
            r3.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r4)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r3 = r8.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r3 = r3.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r8.OO0000O0Ooo0OO000oo
            android.content.Context r4 = r4.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0oOoO0OOOoO0ooO00 r4 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0oOoO0OOOoO0ooO00.o0Oo0OO00O0O000ooOO0(r4)
            r3.OO000Ooo0O0ooO0o0(r4)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r3 = r8.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r3 = r3.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r8.OO0000O0Ooo0OO000oo
            android.content.Context r4 = r4.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo r4 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0(r4)
            r3.O0OOO0O0OO0oO0oOoO000(r4)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r3 = r8.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r3 = r3.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r8.OO0000O0Ooo0OO000oo
            android.content.Context r4 = r4.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0oOoooo0o0o0oOo r4 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0oOoooo0o0o0oOo.o0Oo0OO00O0O000ooOO0(r4)
            r3.O00OO0oOOooooO00000Oo(r4)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r3 = r8.OO0000O0Ooo0OO000oo
            android.content.Context r3 = r3.OO0000O0Ooo0OO000oo
            com.trustdecision.android.shell.TDOption r4 = r8.o0O00o00OOoOo0oooOoo00
            int r4 = r4.getMask()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = r8.oO00o0OooO0OO0o0000o
            java.lang.String r6 = r8.O00OO0oOOooooO00000Oo
            java.lang.Object[] r7 = new java.lang.Object[r0]
            r7[r1] = r5
            r7[r2] = r6
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r1] = r3
            r5[r2] = r4
            r5[r0] = r7
            r0 = 50
            com.trustdecision.android.shell.common.HelperJNI.o0Oo0OO00O0O000ooOO0((int) r0, (java.lang.Object) r5)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r0 = r8.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r0 = r0.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r3 = r8.OO0000O0Ooo0OO000oo
            android.content.Context r3 = r3.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0ooOoo0Oo00oOOO r3 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0ooOoo0Oo00oOOO.o0Oo0OO00O0O000ooOO0(r3)
            r0.O0oOO0ooO(r3)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r0 = r8.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r0 = r0.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oo0OooOO0Ooo0O0 r3 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oo0OooOO0Ooo0O0.o0O00o00OOoOo0oooOoo00()
            r0.O0oOoo0oOo(r3)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r0 = r8.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r0 = r0.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r3 = r8.OO0000O0Ooo0OO000oo
            android.hardware.SensorManager r3 = r3.o0oOO0oO00OoO0
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r8.OO0000O0Ooo0OO000oo
            android.view.WindowManager r4 = r4.oO0oOOOOoo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O00000oo r3 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O00000oo.o0Oo0OO00O0O000ooOO0(r3, r4)
            r0.ooOo0oO0O000o0O0O00oo(r3)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r0 = r8.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r0 = r0.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OOo0OoOoO0Oo0OO r3 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OOo0OoOoO0Oo0OO.o0O00o00OOoOo0oooOoo00()
            r0.O0o0o0O0ooOooOoo(r3)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r0 = r8.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r0 = r0.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r3 = r8.OO0000O0Ooo0OO000oo
            android.content.Context r3 = r3.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r8.OO0000O0Ooo0OO000oo
            android.app.ActivityManager r4 = r4.O0o0o0O0OOOooOo0OOoOOO
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.OoO0oOO0ooOOOOooOO0 r3 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.OoO0oOO0ooOOOOooOO0.o0Oo0OO00O0O000ooOO0(r3, r4)
            r0.OOOOO0o0ooo00oOo0(r3)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r0 = r8.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r0 = r0.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r3 = r8.OO0000O0Ooo0OO000oo
            android.content.Context r3 = r3.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0o0o0O0ooOooOoo r3 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0o0o0O0ooOooOoo.o0Oo0OO00O0O000ooOO0(r3)
            r0.O0oo0o00oooo(r3)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r0 = r8.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r0 = r0.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r3 = r8.OO0000O0Ooo0OO000oo
            android.content.Context r3 = r3.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0oO0OOO0oooo0o0OoOO r3 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0oO0OOO0oooo0o0OoOO.o0Oo0OO00O0O000ooOO0(r3)
            r0.Oo0OO00oooO0Ooo000ooOo(r3)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r0 = r8.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r0 = r0.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0oOO0O0o0OO0o00 r3 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0oOO0O0o0OO0o00.o0O00o00OOoOo0oooOoo00()
            r0.ooooOO0OO0O0OOoo(r3)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r0 = r8.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 r0 = r0.O0oOO0ooO
            java.lang.String r0 = r0.O0OOO0O0OO0oO0oOoO000
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r1] = r0
            r0 = 65
            com.trustdecision.android.shell.common.HelperJNI.o0Oo0OO00O0O000ooOO0((int) r0, (java.lang.Object) r2)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r0 = r8.OO0000O0Ooo0OO000oo
            r0.o0Oo0OO00O0O000ooOO0()
            java.util.concurrent.CountDownLatch r0 = r8.O0oOO0ooO
            if (r0 == 0) goto L_0x0157
            r0.countDown()
        L_0x0157:
            java.util.concurrent.CountDownLatch r0 = r8.o00ooooooO00OO0O00
            if (r0 == 0) goto L_0x015e
            r0.countDown()
        L_0x015e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oO0oo00OooOooOOo.run():void");
    }
}
