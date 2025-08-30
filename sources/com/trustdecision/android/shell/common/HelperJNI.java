package com.trustdecision.android.shell.common;

import com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0;
import org.apache.commons.lang3.CharEncoding;
import org.json.JSONObject;

public class HelperJNI {
    public static native Object n0(int i, Object obj);

    public static Object o0Oo0OO00O0O000ooOO0(int i, Object obj) {
        JSONObject o0Oo0OO00O0O000ooOO0;
        try {
            return n0(i, obj);
        } catch (Throwable th) {
            o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(th);
            o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.O0OoOo00O000, o0Oo0OO00O0O000ooOO0);
            return null;
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
            byte b = (byte) (i ^ 18);
            byte b2 = (byte) (bArr[0] ^ 54);
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
}
