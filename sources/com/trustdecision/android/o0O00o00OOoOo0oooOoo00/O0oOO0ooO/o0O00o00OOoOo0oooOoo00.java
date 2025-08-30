package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO;

import android.content.Context;
import com.google.common.base.Ascii;
import org.apache.commons.lang3.CharEncoding;

public class o0O00o00OOoOo0oooOoo00 extends o0Oo0OO00O0O000ooOO0 {
    public static final String O0oOO0ooO = o0Oo0OO00O0O000ooOO0("7c0b05445d010001001706010d1d1d01064748080d111a010a4d4b10150c12506b30150c12", 0);

    public o0O00o00OOoOo0oooOoo00(Class cls) {
        super(cls);
        this.o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("6c485019064f59484d544a", 88);
        this.o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("7c2a24657c202120213627202c3c3c20276669292c303b202b6c6a31342d33714a11342d33", 33);
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
            byte b = (byte) (i ^ 7);
            byte b2 = (byte) (bArr[0] ^ Ascii.US);
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

    public void o0Oo0OO00O0O000ooOO0(Context context, int i, String str, String str2) {
        o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("761d1d07392407063c350f070509", 29), context, Integer.valueOf(i), str, str2);
    }

    public void o0Oo0OO00O0O000ooOO0(String str) {
        o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("6c090e28291918041d3a380318", 24), str);
    }
}
