package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo;

import android.os.Build;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.oO00o0OooO0OO0o0000o;
import java.io.File;
import org.apache.commons.lang3.CharEncoding;

final class OO0000O0Ooo0OO000oo implements oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00 {
    private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 52);
            byte b2 = (byte) (bArr[0] ^ 51);
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

    public String O00OO0oOOooooO00000Oo(String str) {
        return str.substring(3, str.length() - 3);
    }

    public void o0O00o00OOoOo0oooOoo00(String str) {
        if (new File(str).exists()) {
            System.load(str);
            return;
        }
        throw new UnsatisfiedLinkError(o0Oo0OO00O0O000ooOO0("7f48662f2b62686428236c763928707c776a6a", 89));
    }

    public String oO00o0OooO0OO0o0000o(String str) {
        return (!str.startsWith(o0Oo0OO00O0O000ooOO0("5f5d53", 108)) || !str.endsWith(o0Oo0OO00O0O000ooOO0("1d0f4e", 102))) ? System.mapLibraryName(str) : str;
    }

    public void o0Oo0OO00O0O000ooOO0(String str) {
        System.loadLibrary(str);
    }

    public String[] o0Oo0OO00O0O000ooOO0() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            return strArr;
        }
        String str = Build.CPU_ABI2;
        return !OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0(str) ? new String[]{Build.CPU_ABI, str} : new String[]{Build.CPU_ABI};
    }
}
