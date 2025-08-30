package com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;

import com.google.common.base.Ascii;
import org.apache.commons.lang3.CharEncoding;

public class o0Oo0OO00O0O000ooOO0 {
    private static volatile o0Oo0OO00O0O000ooOO0 O00O00oo0ooO0;
    private static volatile int O0oOoO0OOOoO0ooO00;
    private static final Object OO000Ooo0O0ooO0o0 = new Object();
    private static volatile o0Oo0OO00O0O000ooOO0 OO0oo0ooOO00OOO;
    private static final Object ooooO0O00OOoOO00oooO = new Object();
    public String O00OO0oOOooooO00000Oo = o0O00o00OOoOo0oooOoo00.O0o00o0;
    public String O0OOO0O0OO0oO0oOoO000 = "";
    public int O0OoOo00O000 = Integer.MAX_VALUE;
    public String O0o0o0O0OOOooOo0OOoOOO = o0O00o00OOoOo0oooOoo00.O0OOo000OO0o0000O00oO0;
    public boolean O0o0o0O0ooOooOoo = true;
    public String O0oOO0ooO = o0O00o00OOoOo0oooOoo00.ooOoOO00;
    public boolean O0oOoo0oOo = false;
    public boolean O0oOoooo0o0o0oOo = false;
    public boolean O0oo0OOOOoO = true;
    public boolean O0oo0o00oooo = false;
    public boolean OO0000O0Ooo0OO000oo = true;
    public String OO000O0O0Oo = null;
    public String OOOOO0o0ooo00oOo0 = "";
    public boolean OOo0o00oOO00o00o = true;
    public String OOoOo00oo0Ooo0o0o0o000 = "";
    public boolean Oo0O0Oo0OO0OOOoOO0O0 = false;
    public boolean Oo0OO00oooO0Ooo000ooOo = true;
    public boolean Oo0o000OO = true;
    public boolean Oo0oOo00ooOo0OOO0oO0 = true;
    public boolean OoOOooOoooOoo = false;
    public boolean o00ooooooO00OO0O00 = true;
    public String o0O00o00OOoOo0oooOoo00 = o0O00o00OOoOo0oooOoo00.Oo0oOO0ooO0o0;
    public String o0Oo0O0o0ooOOo0oO0 = o0O00o00OOoOo0oooOoo00.o0OoooOooOooo0Oo;
    public String o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("6a7b697b", 91);
    public boolean o0oOO0oO00OoO0 = true;
    public int o0ooO0o000Oo0Oo0O0 = 15000;
    public boolean o0ooOoo0Oo00oOOO = true;
    public int oO00o0OooO0OO0o0000o = 1000;
    public String oO0OOO00 = "";
    public boolean oO0o0oOoOO0OO = false;
    public String oO0oOOOOoo = o0O00o00OOoOo0oooOoo00.oOOO0oO0O0Oo0;
    public String oO0oo00OooOooOOo = "";
    public boolean oO0ooo00oooo0oOO0oO = true;
    public boolean oOO0Oo000oOO00oo0o0 = true;
    public String oOO0OooO0 = "";
    public boolean oOOO00oO00o0oOoOo = true;
    public String ooOo0oO0O000o0O0O00oo = "";
    public String ooOoOooO = o0O00o00OOoOo0oooOoo00.oOOo0O0OooOO;
    public int ooooOO0OO0O0OOoo = 0;

    public static o0Oo0OO00O0O000ooOO0 O00OO0oOOooooO00000Oo() {
        if (OO0oo0ooOO00OOO == null) {
            synchronized (OO000Ooo0O0ooO0o0) {
                try {
                    if (OO0oo0ooOO00OOO == null) {
                        OO0oo0ooOO00OOO = new o0Oo0OO00O0O000ooOO0();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (O00O00oo0ooO0 == null) {
            synchronized (ooooO0O00OOoOO00oooO) {
                try {
                    if (O00O00oo0ooO0 == null) {
                        O00O00oo0ooO0 = new o0Oo0OO00O0O000ooOO0();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return O0oOoO0OOOoO0ooO00 == 1 ? O00O00oo0ooO0 : OO0oo0ooOO00OOO;
    }

    public static void o0O00o00OOoOo0oooOoo00() {
        O0oOoO0OOOoO0ooO00 = 1;
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
            byte b = (byte) (i ^ 50);
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

    public static int oO00o0OooO0OO0o0000o() {
        return O0oOoO0OOOoO0ooO00;
    }

    public static void o0Oo0OO00O0O000ooOO0() {
        O0oOoO0OOOoO0ooO00 = 0;
    }
}
