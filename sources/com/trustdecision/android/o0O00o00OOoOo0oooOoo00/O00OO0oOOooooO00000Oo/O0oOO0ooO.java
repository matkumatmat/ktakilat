package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo;

import androidx.annotation.NonNull;
import org.apache.commons.lang3.CharEncoding;

public class O0oOO0ooO {
    private long o0O00o00OOoOo0oooOoo00;
    private String o0Oo0OO00O0O000ooOO0;

    public O0oOO0ooO(String str, long j) {
        this.o0Oo0OO00O0O000ooOO0 = str;
        this.o0O00o00OOoOo0oooOoo00 = j;
    }

    public long o0O00o00OOoOo0oooOoo00() {
        return this.o0O00o00OOoOo0oooOoo00;
    }

    public String o0Oo0OO00O0O000ooOO0() {
        return this.o0Oo0OO00O0O000ooOO0;
    }

    @NonNull
    public String toString() {
        return this.o0O00o00OOoOo0oooOoo00 + o0Oo0OO00O0O000ooOO0("142e", 69) + this.o0Oo0OO00O0O000ooOO0;
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
            byte b = (byte) (i ^ 107);
            byte b2 = (byte) (bArr[0] ^ 48);
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
