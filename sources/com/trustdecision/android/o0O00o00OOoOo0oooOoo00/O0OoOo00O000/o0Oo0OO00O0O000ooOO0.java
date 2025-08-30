package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000;

import android.content.pm.PackageManager;
import android.text.TextUtils;
import org.apache.commons.lang3.CharEncoding;

public class o0Oo0OO00O0O000ooOO0 {
    private static final String o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("67292871782d3c21272c3f3d", 88);
    private static final String o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("69343a7b77353d333b3b3b777b21207a7b312c667d342a2c2b2e", 80);

    private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 104);
            byte b2 = (byte) (bArr[0] ^ 10);
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

    public static boolean o0Oo0OO00O0O000ooOO0(PackageManager packageManager, String str) {
        if (Oo0o000OO.o0Oo0OO00O0O000ooOO0(packageManager, o0Oo0OO00O0O000ooOO0("695d53121e5c545a5252521e124849131258450f145d43454247", 57)) == null) {
            return !TextUtils.isEmpty(str) && str.contains(o0Oo0OO00O0O000ooOO0("6715144d4411001d1b100301", 100));
        }
        return true;
    }
}
