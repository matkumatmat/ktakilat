package com.trustdecision.android.shell.o0Oo0OO00O0O000ooOO0;

import android.content.Context;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.Oo0O0Oo0OO0OOOoOO0O0;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo;
import org.apache.commons.lang3.CharEncoding;

public class o0O00o00OOoOo0oooOoo00 {
    public static String o0O00o00OOoOo0oooOoo00(Context context) {
        if (context == null) {
            return null;
        }
        return oO00o0OooO0OO0o0000o(context);
    }

    public static String o0Oo0OO00O0O000ooOO0(Context context) {
        if (context == null) {
            return null;
        }
        Oo0O0Oo0OO0OOOoOO0O0.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0("52303b3c2c2024222c2c2d", 90));
        return o0O00o00OOoOo0oooOoo00(context, Oo0O0Oo0OO0OOOoOO0O0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("722c757233393037266578317522", 70)));
    }

    private static String oO00o0OooO0OO0o0000o(Context context) {
        if (context == null) {
            return null;
        }
        Oo0O0Oo0OO0OOOoOO0O0.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0("52767d7a6a6662646a6a6b", 28));
        return o0O00o00OOoOo0oooOoo00(context, Oo0O0Oo0OO0OOOoOO0O0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("522d2621313d393f313130", 71)));
    }

    private static String o0O00o00OOoOo0oooOoo00(Context context, String str) {
        String o0O00o00OOoOo0oooOoo00 = O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(context, str, "");
        if ("".equals(o0O00o00OOoOo0oooOoo00)) {
            return null;
        }
        return o0O00o00OOoOo0oooOoo00;
    }

    public static String o0Oo0OO00O0O000ooOO0(Context context, String str) {
        return o0O00o00OOoOo0oooOoo00(context, str);
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
            byte b = (byte) (i ^ 122);
            byte b2 = (byte) (bArr[0] ^ 6);
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
