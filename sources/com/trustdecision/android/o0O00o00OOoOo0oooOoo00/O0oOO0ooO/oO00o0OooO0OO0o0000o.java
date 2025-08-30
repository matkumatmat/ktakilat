package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO;

import android.content.Context;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.google.common.base.Ascii;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
import org.apache.commons.lang3.CharEncoding;

public class oO00o0OooO0OO0o0000o extends o0Oo0OO00O0O000ooOO0 {
    public static final String O0oOO0ooO = o0Oo0OO00O0O000ooOO0("7a5856170e525352534455525e4e4e5255141b5b5e424952591e1657585641495255141d0a541c1c0a54421c541c42421c0a421c1c7a4c5f", 110);

    public oO00o0OooO0OO0o0000o(Class cls) {
        super(cls);
        this.o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("6a647c3532707f71666e7572", 73);
        this.o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("7a5957160f535253524554535f4f4f5354151a5a5f434853581f1756595740485354151c0b551d1d0b55431d551d43431d0b431d1d7b4d5e", 111);
    }

    public String o0O00o00OOoOo0oooOoo00(WifiInfo wifiInfo) {
        return (String) o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("773e", 89), wifiInfo);
    }

    public String o0Oo0OO00O0O000ooOO0(Context context, LocationManager locationManager) {
        return (String) o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("7706", 98), context, locationManager, Boolean.valueOf(o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().o00ooooooO00OO0O00), 53);
    }

    public String o0Oo0OO00O0O000ooOO0(WifiInfo wifiInfo) {
        return (String) o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("7703", 101), wifiInfo);
    }

    public String o0Oo0OO00O0O000ooOO0(WifiManager wifiManager) {
        return (String) o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("7759", 57), wifiManager);
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
            byte b = (byte) (i ^ 58);
            byte b2 = (byte) (bArr[0] ^ Ascii.EM);
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
