package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.common.primitives.UnsignedBytes;
import java.security.MessageDigest;
import org.apache.commons.lang3.CharEncoding;

public class oO00o0OooO0OO0o0000o {
    public static String o0O00o00OOoOo0oooOoo00(String str) {
        try {
            return o0Oo0OO00O0O000ooOO0(str.getBytes(o0Oo0OO00O0O000ooOO0("5650433a44", 57)));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String o0Oo0OO00O0O000ooOO0(String str) {
        String o0O00o00OOoOo0oooOoo00 = o0O00o00OOoOo0oooOoo00(str);
        return TextUtils.isEmpty(o0O00o00OOoOo0oooOoo00) ? o0O00o00OOoOo0oooOoo00 : o0O00o00OOoOo0oooOoo00.substring(0, 32);
    }

    public static byte[] oO00o0OooO0OO0o0000o(String str) {
        byte[] bArr = null;
        if (str != null) {
            if (str.length() < 1) {
                return null;
            }
            bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < str.length() / 2; i++) {
                int i2 = i * 2;
                int i3 = i2 + 1;
                bArr[i] = (byte) ((Integer.parseInt(str.substring(i2, i3), 16) * 16) + Integer.parseInt(str.substring(i3, i2 + 2), 16));
            }
        }
        return bArr;
    }

    public static String o0O00o00OOoOo0oooOoo00(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & UnsignedBytes.MAX_VALUE);
            if (hexString.length() == 1) {
                hexString = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(hexString);
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
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
            byte b = (byte) (i ^ 104);
            byte b2 = (byte) (bArr[0] ^ 3);
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

    public static String o0Oo0OO00O0O000ooOO0(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(o0Oo0OO00O0O000ooOO0("50584a2f5c4440", 43));
            instance.update(bArr);
            return o0O00o00OOoOo0oooOoo00(instance.digest());
        } catch (Exception unused) {
            return "";
        }
    }
}
