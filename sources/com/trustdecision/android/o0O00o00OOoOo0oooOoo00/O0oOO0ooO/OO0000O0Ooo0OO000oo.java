package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO;

import android.hardware.SensorManager;
import java.util.List;
import org.apache.commons.lang3.CharEncoding;

public class OO0000O0Ooo0OO000oo extends o0Oo0OO00O0O000ooOO0 {
    public static final String O0oOO0ooO = o0Oo0OO00O0O000ooOO0("46030d4c55090809081f0e09051515090e4f40000519120902455219041213125346510f4747510f19470f4719194751194747210312", 19);

    public OO0000O0Ooo0OO000oo(Class cls) {
        super(cls);
        this.o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("564d551c044c51474647", 70);
        this.o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("46515f1e075b5a5b5a4d5c5b5747475b5c1d1252574b405b5017004b564041400114035d1515035d4b155d154b4b15034b1515735140", 65);
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
            byte b = (byte) (i ^ 28);
            byte b2 = (byte) (bArr[0] ^ 37);
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

    public String O00OO0oOOooooO00000Oo() {
        String str = (String) o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4b7f", 57), new Object[0]);
        return str == null ? o0Oo0OO00O0O000ooOO0("7e33", 41) : str;
    }

    public String O0oOO0ooO() {
        String str = (String) o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4b65", 34), new Object[0]);
        return str == null ? o0Oo0OO00O0O000ooOO0("7e4f", 85) : str;
    }

    public String o00ooooooO00OO0O00() {
        String str = (String) o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4b03", 71), new Object[0]);
        return str == null ? o0Oo0OO00O0O000ooOO0("7e29", 51) : str;
    }

    public String o0O00o00OOoOo0oooOoo00() {
        String str = (String) o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4b4a", 10), new Object[0]);
        return str == null ? o0Oo0OO00O0O000ooOO0("7e4f", 85) : str;
    }

    public String oO00o0OooO0OO0o0000o() {
        String str = (String) o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4b22", 99), new Object[0]);
        return str == null ? o0Oo0OO00O0O000ooOO0("7e38", 34) : str;
    }

    public void o0O00o00OOoOo0oooOoo00(SensorManager sensorManager) {
        o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4b05", 70), sensorManager);
    }

    public void o0Oo0OO00O0O000ooOO0(SensorManager sensorManager) {
        o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4b0b", 73), sensorManager);
    }

    public List oO00o0OooO0OO0o0000o(SensorManager sensorManager) {
        return (List) o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4b11", 84), sensorManager);
    }
}
