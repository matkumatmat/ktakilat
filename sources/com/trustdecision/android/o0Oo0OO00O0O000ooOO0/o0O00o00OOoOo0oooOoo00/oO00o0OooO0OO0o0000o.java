package com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00;

import android.util.Log;
import org.apache.commons.lang3.CharEncoding;

public class oO00o0OooO0OO0o0000o {
    private static final String O00OO0oOOooooO00000Oo = o0Oo0OO00O0O000ooOO0("0a737876687474", 54);
    public static boolean o0O00o00OOoOo0oooOoo00 = false;
    public static boolean o0Oo0OO00O0O000ooOO0 = false;
    public static boolean oO00o0OooO0OO0o0000o = false;

    public static void o0O00o00OOoOo0oooOoo00(String str) {
        o0Oo0OO00O0O000ooOO0("0a0a010f110d0d", 79);
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
            byte b = (byte) (i ^ 85);
            byte b2 = (byte) (bArr[0] ^ 94);
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

    public static void o0Oo0OO00O0O000ooOO0() {
        o0Oo0OO00O0O000ooOO0 = true;
        o0O00o00OOoOo0oooOoo00 = true;
        oO00o0OooO0OO0o0000o = true;
    }

    public static void o0Oo0OO00O0O000ooOO0(String str) {
        Log.e(o0Oo0OO00O0O000ooOO0("0a18131d031f1f", 93), str);
    }
}
