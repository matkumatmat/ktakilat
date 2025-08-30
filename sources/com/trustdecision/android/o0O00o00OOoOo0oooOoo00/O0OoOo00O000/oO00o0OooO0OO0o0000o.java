package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000;

import android.content.pm.PackageManager;
import com.google.common.base.Ascii;
import org.apache.commons.lang3.CharEncoding;

public class oO00o0OooO0OO0o0000o {
    private static final String O00OO0oOOooooO00000Oo = o0Oo0OO00O0O000ooOO0("7a020c4d420d06031f55431f13161d1e1f1809544d0c03050b0702090607", 6);
    private static final String O0oOO0ooO = o0Oo0OO00O0O000ooOO0("7a69672629666d68743e267c72282a746579666d6b62", 109);
    private static final String[] o00ooooooO00OO0O00 = {o0Oo0OO00O0O000ooOO0("7a262869662922273b7169333d677d203c3d39", 34), o0Oo0OO00O0O000ooOO0("7a030d4c430c07021e544c161842401e0f130c0701084f551e1908", 7), o0Oo0OO00O0O000ooOO0("7a121c5d521d16130f455d0709535e150c362c1c1f1b100249440f0819", 22), o0Oo0OO00O0O000ooOO0("7a68662728676c69753f2975797c77747572633e2766696f616d68636c6d", 108), o0Oo0OO00O0O000ooOO0("7a515f1e115e55504c061e444a10124c5d415e55535a", 85)};
    private static final String o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("7a222c6d622d26233f756d373963613f2e322d2620296e743f3829", 38);
    private static final String o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("7a646a2b246b606579332b717f253f627e7f7b", 96);
    private static final String oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0("7a060849460902071b5149131d474a01182238080b0f04165d501b1c0d", 2);

    private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 8);
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

    public static boolean o0Oo0OO00O0O000ooOO0(PackageManager packageManager) {
        int i = 0;
        for (String o0Oo0OO00O0O000ooOO02 : o00ooooooO00OO0O00) {
            if (Oo0o000OO.o0Oo0OO00O0O000ooOO0(packageManager, o0Oo0OO00O0O000ooOO02) != null) {
                i++;
            }
        }
        return i >= 3;
    }
}
