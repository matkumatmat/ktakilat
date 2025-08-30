package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import org.apache.commons.lang3.CharEncoding;

public class o0ooO0o000Oo0Oo0O0 {
    private static final String O00OO0oOOooooO00000Oo = o0Oo0OO00O0O000ooOO0("462214171a121c17024707090f66", 57);
    private static final String O0oOO0ooO = o0Oo0OO00O0O000ooOO0("463701020f07090217521572", 44);
    private static final String o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("46552a3a20474041", 109);
    private static final String o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("77696726397264676a626c6772392768717e686e6872", 73);
    private static final String oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0("663224272a222c2732", 9);

    private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 44);
            byte b2 = (byte) (bArr[0] ^ Ascii.DC4);
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

    public static boolean o0Oo0OO00O0O000ooOO0(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str) && (str.contains(o0Oo0OO00O0O000ooOO0("463600030e0608031653131d1b72", 45)) || str.contains(o0Oo0OO00O0O000ooOO0("46093f3c3139373c296c2b4c", 18)))) {
            return true;
        }
        String str2 = Build.BRAND;
        if (str2 != null && str2.length() > 30) {
            str2 = str2.substring(0, 30);
        }
        if (o0Oo0OO00O0O000ooOO0("663e282b262e202b3e", 5).equals(str2)) {
            return true;
        }
        if (o0Oo0OO00O0O000ooOO0("4606796973141312", 62).equals(Build.MODEL)) {
            return true;
        }
        String o0Oo0OO00O0O000ooOO02 = Oo0o000OO.o0Oo0OO00O0O000ooOO0(context, (ActivityManager) context.getSystemService(o0Oo0OO00O0O000ooOO0("7511040e0c0c0e1e", 63)));
        return !TextUtils.isEmpty(o0Oo0OO00O0O000ooOO02) && o0Oo0OO00O0O000ooOO02.contains(o0Oo0OO00O0O000ooOO0("77484607185345464b434d4653180649505f494f4953", 104));
    }
}
