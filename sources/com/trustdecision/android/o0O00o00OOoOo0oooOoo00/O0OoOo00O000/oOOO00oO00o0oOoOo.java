package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000;

import android.content.Context;
import androidx.annotation.NonNull;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
import com.trustdecision.android.shell.common.HelperJNI;
import java.io.File;
import org.apache.commons.lang3.CharEncoding;

public class oOOO00oO00o0oOoOo {
    private static final String o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("76451c1c551c1b57575e58", 75);

    public static boolean o0O00o00OOoOo0oooOoo00(Context context) {
        return o0oOO0oO00OoO0.o0O00o00OOoOo0oooOoo00(oO00o0OooO0OO0o0000o(context));
    }

    @NonNull
    private static String o0Oo0OO00O0O000ooOO0(String str) {
        o0Oo0OO00O0O000ooOO0 O00OO0oOOooooO00000Oo = o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo();
        return ba.r(ba.v(str), o0Oo0OO00O0O000ooOO0("2f", 65), oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00(O00OO0oOOooooO00000Oo.oO0OOO00 + o0Oo0OO00O0O000ooOO0("2f", 86) + O00OO0oOOooooO00000Oo.O0oOO0ooO));
    }

    private static File oO00o0OooO0OO0o0000o(Context context) {
        return new File(context.getFilesDir().getAbsolutePath(), o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("761e47470e47400c0c0503", 16)));
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
            byte b = (byte) (i ^ 30);
            byte b2 = (byte) (bArr[0] ^ 2);
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
        synchronized (oOO0OooO0.o0O00o00OOoOo0oooOoo00) {
            HelperJNI.o0Oo0OO00O0O000ooOO0(80, (Object) new Object[0]);
        }
    }

    public static boolean o0Oo0OO00O0O000ooOO0(Context context) {
        return oO00o0OooO0OO0o0000o(context).exists();
    }
}
