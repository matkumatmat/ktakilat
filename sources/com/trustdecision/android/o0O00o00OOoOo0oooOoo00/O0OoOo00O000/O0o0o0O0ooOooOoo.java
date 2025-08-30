package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000;

import android.os.Build;
import org.apache.commons.lang3.CharEncoding;

public class O0o0o0O0ooOooOoo {
    private static final String o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("5107060a023032010d141f1a120316", 55);

    private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 57);
            byte b2 = (byte) (bArr[0] ^ 57);
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

    public static boolean o0Oo0OO00O0O000ooOO0() {
        return o0Oo0OO00O0O000ooOO0("510e0f030b393b08041d16131b0a1f", 62).equals(Build.PRODUCT) || o0Oo0OO00O0O000ooOO0("5140414d457775464a53585d554451", 112).equals(Build.DEVICE);
    }
}
