package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0;
import com.trustdecision.android.shell.TDOption;
import java.util.concurrent.CountDownLatch;
import org.apache.commons.lang3.CharEncoding;

class ooooOO0OO0O0OOoo implements Runnable {
    final /* synthetic */ o0Oo0OO00O0O000ooOO0 O00OO0oOOooooO00000Oo;
    final /* synthetic */ CountDownLatch O0oOO0ooO;
    final /* synthetic */ oOO0OooO0 o00ooooooO00OO0O00;
    final /* synthetic */ String o0O00o00OOoOo0oooOoo00;
    final /* synthetic */ TDOption o0Oo0OO00O0O000ooOO0;
    final /* synthetic */ String oO00o0OooO0OO0o0000o;

    public ooooOO0OO0O0OOoo(oOO0OooO0 ooo0oooo0, TDOption tDOption, String str, String str2, o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0, CountDownLatch countDownLatch) {
        this.o00ooooooO00OO0O00 = ooo0oooo0;
        this.o0Oo0OO00O0O000ooOO0 = tDOption;
        this.o0O00o00OOoOo0oooOoo00 = str;
        this.oO00o0OooO0OO0o0000o = str2;
        this.O00OO0oOOooooO00000Oo = o0oo0oo00o0o000oooo0;
        this.O0oOO0ooO = countDownLatch;
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
            byte b = (byte) (i ^ 19);
            byte b2 = (byte) (bArr[0] ^ 19);
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

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r9 = this;
            r0 = 1
            r1 = 0
            r2 = 2
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 r3 = new com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0
            r3.<init>()
            java.lang.String r4 = "670a0b0a0b1c0d0a0616160a0d3d200b0a1f191d0e122a3b17"
            r5 = 31
            java.lang.String r4 = o0Oo0OO00O0O000ooOO0(r4, r5)
            r3.o0Oo0OO00O0O000ooOO0((java.lang.String) r4)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r9.o00ooooooO00OO0O00
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 r4 = r4.O0oOO0ooO
            boolean r4 = r4.o0oOO0oO00OoO0
            if (r4 == 0) goto L_0x0036
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r9.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r4 = r4.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r5 = r9.o00ooooooO00OO0O00
            android.content.Context r5 = r5.OO0000O0Ooo0OO000oo
            r6 = 121(0x79, float:1.7E-43)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.OOOOoOOo0o0Ooo00O r5 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.OOOOoOOo0o0Ooo00O.o0Oo0OO00O0O000ooOO0(r5, r6)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o r5 = r3.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r5)
            r4.OO000O0O0Oo(r5)
        L_0x0036:
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r9.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r4 = r4.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r5 = r9.o00ooooooO00OO0O00
            android.content.Context r5 = r5.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r6 = r9.o00ooooooO00OO0O00
            android.net.wifi.WifiManager r6 = r6.O0OoOo00O000
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0ooO0o000Oo0Oo0O0 r5 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0ooO0o000Oo0Oo0O0.o0Oo0OO00O0O000ooOO0(r5, r6)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o r5 = r3.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r5)
            r4.O0oOoO0OOOoO0ooO00(r5)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r9.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r4 = r4.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r5 = r9.o00ooooooO00OO0O00
            android.content.Context r5 = r5.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O00o0OOOo0o0OOOO0Ooo r5 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O00o0OOOo0o0OOOO0Ooo.o0Oo0OO00O0O000ooOO0(r5)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o r5 = r3.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r5)
            r4.Oo0O0Oo0OO0OOOoOO0O0(r5)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r9.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r4 = r4.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0ooo00O0oo0O0 r5 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0ooo00O0oo0O0.oO00o0OooO0OO0o0000o()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o r5 = r3.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r5)
            r4.O00oOO0OO0ooOOo(r5)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r9.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r4 = r4.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.ooo00o00O00o0o0oO00oo0 r5 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.ooo00o00O00o0o0oO00oo0.o0O00o00OOoOo0oooOoo00()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o r5 = r3.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r5)
            r4.O00O00oo0ooO0(r5)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r9.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r4 = r4.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r5 = r9.o00ooooooO00OO0O00
            android.content.Context r5 = r5.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0OoOo00O000 r5 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0Oo0OO00O0O000ooOO0(r5)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o r5 = r3.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r5)
            r4.oO0o0oOOO0oo(r5)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r9.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r4 = r4.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r5 = r9.o00ooooooO00OO0O00
            android.content.Context r5 = r5.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0O0oOo00O0O r5 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0O0oOo00O0O.o0Oo0OO00O0O000ooOO0(r5)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o r5 = r3.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r5)
            r4.OoooO00OOoOoo0(r5)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r9.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r4 = r4.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O00O00oo00OOO0OOo0o r5 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O00O00oo00OOO0OOo0o.o0O00o00OOoOo0oooOoo00()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o r5 = r3.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r5)
            r4.o0oOO00OOOO(r5)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r9.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r4 = r4.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r5 = r9.o00ooooooO00OO0O00
            android.content.Context r5 = r5.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r6 = r9.o00ooooooO00OO0O00
            android.location.LocationManager r6 = r6.O0o0o0O0ooOooOoo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.Oo0oOO0ooO0o0 r5 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.Oo0oOO0ooO0o0.o0Oo0OO00O0O000ooOO0(r5, r6)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o r5 = r3.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r5)
            r4.O0oo0OOOOoO(r5)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r9.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r4 = r4.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.Ooo0ooOO r5 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.Ooo0ooOO.o0O00o00OOoOo0oooOoo00()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o r5 = r3.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r5)
            r4.Oo0O0O0o00oOooo(r5)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r9.o00ooooooO00OO0O00
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 r4 = r4.O0oOO0ooO
            boolean r4 = r4.O0o0o0O0ooOooOoo
            if (r4 == 0) goto L_0x0158
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r9.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r4 = r4.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00 r5 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o r5 = r3.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r5)
            r4.OO0oo0ooOO00OOO(r5)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r9.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r4 = r4.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.ooo0O000oOoOOo0 r5 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.ooo0O000oOoOOo0.o0O00o00OOoOo0oooOoo00()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o r5 = r3.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r5)
            r4.Oo0oOo00ooOo0OOO0oO0(r5)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r9.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r4 = r4.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0OoOO0ooo0O0oO00OO r5 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0OoOO0ooo0O0oO00OO.o0O00o00OOoOo0oooOoo00()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o r5 = r3.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r5)
            r4.O0oOO0O0o0OO0o00(r5)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r9.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r4 = r4.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0Oo0OOo0OO0O r5 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0Oo0OOo0OO0O.o0O00o00OOoOo0oooOoo00()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o r5 = r3.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r5)
            r4.oO0OOoOo0oo0OoO0O000Oo(r5)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r9.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r4 = r4.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.OoOOO0OOO0o0Oo r5 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.OoOOO0OOO0o0Oo.o0O00o00OOoOo0oooOoo00()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o r5 = r3.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r5)
            r4.Oooo00O0o0Oo0(r5)
        L_0x0158:
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r9.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r4 = r4.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r5 = r9.o00ooooooO00OO0O00
            android.content.Context r5 = r5.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oO0ooo00oooo0oOO0oO r5 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oO0ooo00oooo0oOO0oO.o0Oo0OO00O0O000ooOO0(r5)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o r5 = r3.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r5)
            r4.o00O000OoOooOO0o0o0oOO(r5)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r9.o00ooooooO00OO0O00
            android.content.Context r4 = r4.OO0000O0Ooo0OO000oo
            com.trustdecision.android.shell.TDOption r5 = r9.o0Oo0OO00O0O000ooOO0
            int r5 = r5.getMask()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = r9.o0O00o00OOoOo0oooOoo00
            java.lang.String r7 = r9.oO00o0OooO0OO0o0000o
            java.lang.Object[] r8 = new java.lang.Object[r2]
            r8[r1] = r6
            r8[r0] = r7
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r1] = r4
            r6[r0] = r5
            r6[r2] = r8
            r0 = 37
            com.trustdecision.android.shell.common.HelperJNI.o0Oo0OO00O0O000ooOO0((int) r0, (java.lang.Object) r6)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r0 = r9.o00ooooooO00OO0O00
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 r0 = r0.O0oOO0ooO
            boolean r0 = r0.O0oo0OOOOoO
            if (r0 == 0) goto L_0x01b4
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r0 = r9.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r0 = r0.o00ooooooO00OO0O00
            com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0 r1 = r9.O00OO0oOOooooO00000Oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O00O0oOOOo0oO r1 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O00O0oOOOo0oO.o0Oo0OO00O0O000ooOO0(r1)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o r1 = r3.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r1)
            r0.O0OOo000OO0o0000O00oO0(r1)
        L_0x01b4:
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r0 = r9.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 r0 = r0.o00ooooooO00OO0O00
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r1 = r9.o00ooooooO00OO0O00
            android.content.Context r1 = r1.OO0000O0Ooo0OO000oo
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oO0OOoOo0oo0OoO0O000Oo r1 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oO0OOoOo0oo0OoO0O000Oo.o0Oo0OO00O0O000ooOO0(r1)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o r1 = r3.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r1)
            r0.ooooO0O00OOoOO00oooO(r1)
            r3.o0O00o00OOoOo0oooOoo00()
            java.util.concurrent.CountDownLatch r0 = r9.O0oOO0ooO
            if (r0 == 0) goto L_0x01d5
            r0.countDown()
        L_0x01d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.ooooOO0OO0O0OOoo.run():void");
    }
}
