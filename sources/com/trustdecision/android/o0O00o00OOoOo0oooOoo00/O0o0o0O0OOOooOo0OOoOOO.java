package com.trustdecision.android.o0O00o00OOoOo0oooOoo00;

import com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0;
import org.apache.commons.lang3.CharEncoding;

class O0o0o0O0OOOooOo0OOoOOO implements Runnable {
    final /* synthetic */ o0Oo0OO00O0O000ooOO0 o0Oo0OO00O0O000ooOO0;

    public O0o0o0O0OOOooOo0OOoOOO(o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0) {
        this.o0Oo0OO00O0O000ooOO0 = o0oo0oo00o0o000oooo0;
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
            byte b = (byte) (i ^ 45);
            byte b2 = (byte) (bArr[0] ^ 67);
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

    public void run() {
        try {
            this.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo();
        } catch (Exception e) {
            this.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("253e313c3038", 20);
            o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o, e.toString());
        }
    }
}
