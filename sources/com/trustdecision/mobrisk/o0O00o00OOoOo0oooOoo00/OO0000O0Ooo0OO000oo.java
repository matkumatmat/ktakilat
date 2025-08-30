package com.trustdecision.mobrisk.o0O00o00OOoOo0oooOoo00;

import com.trustdecision.mobrisk.TDRiskOption;
import com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00;
import com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0;
import com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o;
import org.apache.commons.lang3.CharEncoding;

public class OO0000O0Ooo0OO000oo {
    private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 43);
            byte b2 = (byte) (bArr[0] ^ 78);
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
        try {
            oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("2d424c0d14484948495e4f48445454484f0e05484f4f03347e6f684f4f", 101), (Object) null, o0Oo0OO00O0O000ooOO0("3b746d727f74", 90), new Object[0]);
        } catch (Throwable th) {
            o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0("1e3f00101a584818011e1318430758580000", 54) + th.toString());
        }
    }

    public static void o0Oo0OO00O0O000ooOO0(TDRiskOption tDRiskOption) {
        try {
            Class<?> cls = Class.forName(o0Oo0OO00O0O000ooOO0("2d7c72332a767776776071767a6a6a7671303b7671713d0a4051567171", 91));
            oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) null, o0Oo0OO00O0O000ooOO0("2727071a3a200f2b", 22), Boolean.FALSE);
            oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) null, o0Oo0OO00O0O000ooOO0("271d1d07", 49), o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(), tDRiskOption.getPartnerCode(), tDRiskOption.getCountry());
        } catch (Throwable th) {
            o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0("1e4f70606a28246a6a70237728287070", 70) + th.toString());
        }
    }
}
