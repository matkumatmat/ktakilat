package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO;

import android.net.wifi.WifiInfo;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
import org.apache.commons.lang3.CharEncoding;

public class OoOOooOoooOoo extends o0Oo0OO00O0O000ooOO0 {
    public static final String O0oOO0ooO = o0Oo0OO00O0O000ooOO0("010806475e020302031405020e1e1e0205444b0b0e121902094e5d1a0b0b04030c0d454d5a044c4c5a04124c044c12124c5a124c4c2a0c15", 31);

    public OoOOooOoooOoo(Class cls) {
        super(cls);
        this.o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("11160e475b1f0e0e01060908", 26);
        this.o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("017e703128747574756273747868687473323d7d78646f747f382b6c7d7d72757a7b333b2c723a3a2c72643a723a64643a2c643a3a5c7a63", 105);
    }

    public String o0Oo0OO00O0O000ooOO0(WifiInfo wifiInfo, String str) {
        return (String) o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("0c74", 49), wifiInfo, str, Boolean.valueOf(o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().o00ooooooO00OO0O00));
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
            byte b = (byte) (i ^ 27);
            byte b2 = (byte) (bArr[0] ^ 98);
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
