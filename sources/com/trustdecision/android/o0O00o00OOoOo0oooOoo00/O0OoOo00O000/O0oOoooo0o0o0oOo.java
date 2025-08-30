package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import org.apache.commons.lang3.CharEncoding;

public class O0oOoooo0o0o0oOo {
    public static final String O00OO0oOOooooO00000Oo = o0Oo0OO00O0O000ooOO0("5f7d78646f747f382c67656d766872687473321e7c6b62636972696e", 114);
    public static final String O0OoOo00O000 = o0Oo0OO00O0O000ooOO0("5d2b25646e2f272f2c2e6c68282d313a212a6d6e2d397a79323038233d273d21266748223c312a", 39);
    public static final String O0o0o0O0OOOooOo0OOoOOO = o0Oo0OO00O0O000ooOO0("5d7876373d7c747c7f7d3f3b7b7e626972793e2a76696d6b79756375293d60613c2a61636b706e746e727534086370716f6c606263706b7e7262", 116);
    public static final String O0oOO0ooO = o0Oo0OO00O0O000ooOO0("5f1c19050e151e594d06040c170913091512537c11131505131f1b0d1c1c051f14060602", 19);
    public static final String OO0000O0Ooo0OO000oo = o0Oo0OO00O0O000ooOO0("5f56534f445f5413074c4e465d4359435f5819305b4852524c4b4141", 89);
    public static final String OoOOooOoooOoo = o0Oo0OO00O0O000ooOO0("5d555b1a1656534f445f5413074c4e465d4359435f5819305b48524f5e445e4c54595058424748595a", 89);
    public static final String o00ooooooO00OO0O00 = o0Oo0OO00O0O000ooOO0("5f53564a415a511602494b4358465c465a5d1c335e5c5a4a5c504d574d5f44414548505b49494d", 92);
    public static final String o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("5f7a7f636873783f2b60626a716f756f7374351a7775736375796c7a727e6f6676797760687374", 117);
    public static final String o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("5f53564a415a511602494b4358465c465a5d1c335e5c5a4a5c504050524f5d4a464f5f505e49415a5d", 92);
    public static final String oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0("5f27223e352e2562763d3f372c3228322e29684f2f32393f342339", 40);

    public static boolean o0O00o00OOoOo0oooOoo00(int i) {
        return Build.VERSION.SDK_INT >= i;
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
            byte b = (byte) i;
            byte b2 = (byte) (bArr[0] ^ 62);
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

    public static boolean o0O00o00OOoOo0oooOoo00(Context context, String... strArr) {
        if (r0 == 0) {
            return false;
        }
        int i = 0;
        for (String checkPermission : strArr) {
            if (context.checkPermission(checkPermission, Process.myPid(), Process.myUid()) != 0) {
                return false;
            }
            i++;
        }
        return i == r0;
    }

    public static boolean o0Oo0OO00O0O000ooOO0(int i) {
        return Build.VERSION.SDK_INT < i;
    }

    public static boolean o0Oo0OO00O0O000ooOO0(Context context) {
        return o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0("5f7d78646f747f382c67656d766872687473320e657677697d6a757379687e75676763", 114));
    }

    public static boolean o0Oo0OO00O0O000ooOO0(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    public static boolean o0Oo0OO00O0O000ooOO0(Context context, String... strArr) {
        if (r0 == 0) {
            return false;
        }
        boolean z = false;
        for (String checkPermission : strArr) {
            if (context.checkPermission(checkPermission, Process.myPid(), Process.myUid()) == 0) {
                z = true;
            }
        }
        return z;
    }
}
