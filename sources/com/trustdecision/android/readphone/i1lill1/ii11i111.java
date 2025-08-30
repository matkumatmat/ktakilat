package com.trustdecision.android.readphone.i1lill1;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import org.apache.commons.lang3.CharEncoding;

public class ii11i111 {
    public static final String i1lill1 = ii11i111("1d1c19050e151e594d06040c170913091512537c11131505131f0a1c14180900101f11060e1512", 18);
    public static final String ii11i111 = ii11i111("1d2c29353e252e697d36343c273923392522634c21232535232f3f2f2d3022353930202f21363e2522", 34);

    private static String ii11i111(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 1);
            byte b2 = (byte) (bArr[0] ^ 124);
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

    public static boolean ii11i111(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    public static boolean ii11i111(Context context) {
        return ii11i111(context, ii11i111("1d03061a110a014652191b1308160c160a0d4c701b08091703140b0d0716000b19191d", 13));
    }

    public static boolean ii11i111(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }
}
