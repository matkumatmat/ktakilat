package com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o;

import android.util.Log;
import com.google.common.base.Ascii;
import org.apache.commons.lang3.CharEncoding;

public class o0O00o00OOoOo0oooOoo00 {
    private static final String o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("4b7e757c4c635e557476", 8);
    public static boolean o0Oo0OO00O0O000ooOO0 = false;

    public static void o0O00o00OOoOo0oooOoo00(String str) {
        if (o0Oo0OO00O0O000ooOO0) {
            Log.w(o0Oo0OO00O0O000ooOO0("4b414a43735c616a4b49", 55), str);
        }
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
            byte b = (byte) (i ^ 102);
            byte b2 = (byte) (bArr[0] ^ Ascii.US);
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

    public static void oO00o0OooO0OO0o0000o(String str) {
        o0Oo0OO00O0O000ooOO0("4b48434a7a5568634240", 62);
    }

    public static void o0Oo0OO00O0O000ooOO0(String str) {
        if (o0Oo0OO00O0O000ooOO0) {
            o0Oo0OO00O0O000ooOO0("4b4c474e7e516c674644", 58);
        }
    }
}
