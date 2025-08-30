package com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00;

import android.content.Context;
import android.text.TextUtils;
import org.apache.commons.lang3.CharEncoding;

public class O00OO0oOOooooO00000Oo {
    public static final String o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("3d536a7443514b4f59637749584a", 30);
    public static final String o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("3d09302e190b111503", 68);
    private static String oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0("3d5168764153494d5b", 28);

    public static int o0O00o00OOoOo0oooOoo00(Context context, String str, int i) {
        return context.getSharedPreferences(oO00o0OooO0OO0o0000o, 0).getInt(str, i);
    }

    public static String o0Oo0OO00O0O000ooOO0(Context context, String str, String str2, String str3) {
        return context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    public static long o0O00o00OOoOo0oooOoo00(Context context, String str, long j) {
        return context.getSharedPreferences(oO00o0OooO0OO0o0000o, 0).getLong(str, j);
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
            byte b = (byte) (i ^ 70);
            byte b2 = (byte) (bArr[0] ^ 91);
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

    public static String o0O00o00OOoOo0oooOoo00(Context context, String str, String str2) {
        return context.getSharedPreferences(oO00o0OooO0OO0o0000o, 0).getString(str, str2);
    }

    public static void o0Oo0OO00O0O000ooOO0(Context context, String str) {
        context.getSharedPreferences(oO00o0OooO0OO0o0000o, 0).edit().remove(str).apply();
    }

    public static void o0Oo0OO00O0O000ooOO0(Context context, String str, int i) {
        context.getSharedPreferences(oO00o0OooO0OO0o0000o, 0).edit().putInt(str, i).apply();
    }

    public static void o0Oo0OO00O0O000ooOO0(Context context, String str, long j) {
        context.getSharedPreferences(oO00o0OooO0OO0o0000o, 0).edit().putLong(str, j).apply();
    }

    public static void o0Oo0OO00O0O000ooOO0(Context context, String str, String str2) {
        context.getSharedPreferences(oO00o0OooO0OO0o0000o, 0).edit().putString(str, str2).apply();
    }

    public static void o0Oo0OO00O0O000ooOO0(String str) {
        if (!TextUtils.isEmpty(str)) {
            oO00o0OooO0OO0o0000o = str;
        }
    }
}
