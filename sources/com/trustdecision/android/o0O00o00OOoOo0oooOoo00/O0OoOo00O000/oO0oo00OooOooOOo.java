package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.lang3.CharEncoding;

public class oO0oo00OooOooOOo {
    public static String o0O00o00OOoOo0oooOoo00(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0();
        StringBuilder v = ba.v(str);
        v.append(o0Oo0OO00O0O000ooOO0("49", 105));
        v.append(oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(o0ooOoo0Oo00oOOO.o0Oo0OO00O0O000ooOO0()));
        String o0O00o00OOoOo0oooOoo00 = O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(context, v.toString(), str2);
        if (o0O00o00OOoOo0oooOoo00 == null || o0O00o00OOoOo0oooOoo00.equals(str2)) {
            return str2;
        }
        Charset charset = StandardCharsets.UTF_8;
        byte[] o0O00o00OOoOo0oooOoo002 = o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00(Base64.decode(o0O00o00OOoOo0oooOoo00.getBytes(charset), 11), o0Oo0OO00O0O000ooOO0, o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00());
        if (o0O00o00OOoOo0oooOoo002 == null) {
            return str2;
        }
        return new String(o0O00o00OOoOo0oooOoo002, charset);
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
            byte b = (byte) (i ^ 12);
            byte b2 = (byte) (bArr[0] ^ 100);
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

    public static void o0Oo0OO00O0O000ooOO0(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0();
            StringBuilder v = ba.v(str);
            v.append(o0Oo0OO00O0O000ooOO0("49", 120));
            v.append(oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(o0ooOoo0Oo00oOOO.o0Oo0OO00O0O000ooOO0()));
            String sb = v.toString();
            byte[] o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(str2.getBytes(StandardCharsets.UTF_8), o0Oo0OO00O0O000ooOO0, o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00());
            if (o0Oo0OO00O0O000ooOO02 != null) {
                O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, sb, Base64.encodeToString(o0Oo0OO00O0O000ooOO02, 11));
            }
        }
    }
}
