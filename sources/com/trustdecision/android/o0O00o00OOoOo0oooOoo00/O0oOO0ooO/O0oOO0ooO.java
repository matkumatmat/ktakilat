package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.CharEncoding;

public class O0oOO0ooO extends o0Oo0OO00O0O000ooOO0 {
    public static final String O0oOO0ooO = o0Oo0OO00O0O000ooOO0("636d63223b676667667160676b7b7b6760212e6e6b777c676c2b3d766564757966606a2a283f6129293f61772961297777293f7729294f6c63", 16);

    public O0oOO0ooO(Class cls) {
        super(cls);
        this.o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("731e064f561e0d0c1d110e0802", 120);
        this.o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("637876372e727372736475727e6e6e7275343b7b7e626972793e28637071606c73757f3f3d2a743c3c2a74623c743c62623c2a623c3c5a7976", 5);
    }

    public HashMap o0O00o00OOoOo0oooOoo00() {
        return null;
    }

    public String o0Oo0OO00O0O000ooOO0(Context context) {
        return (String) o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("6e4a", 100), context);
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
            byte b = (byte) (i ^ 113);
            byte b2 = (byte) bArr[0];
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

    public Map o0Oo0OO00O0O000ooOO0(Context context, TelephonyManager telephonyManager) {
        return (Map) o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("6e6e", 65), context, o0O00o00OOoOo0oooOoo00(), telephonyManager);
    }
}
