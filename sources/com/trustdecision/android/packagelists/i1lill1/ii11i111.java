package com.trustdecision.android.packagelists.i1lill1;

import android.content.Context;
import android.content.pm.PermissionInfo;
import android.os.Process;
import org.apache.commons.lang3.CharEncoding;

public class ii11i111 {
    public static final String ii11i111 = ii11i111("5f252b6a6626233f342f2463773c3e362d3329332f2869402b38223f2e342e3c24292028323738292a", 118);

    private static boolean i1lill1(Context context) {
        try {
            PermissionInfo permissionInfo = context.getPackageManager().getPermissionInfo(ii11i111("5f2d23626e2e2b373c272c6b7f34363e253b213b2720614823302a37263c26342c2128203a3f302122", 126), 0);
            return permissionInfo != null && ii11i111("5d16130f041f14", 70).equals(permissionInfo.packageName) && (permissionInfo.protectionLevel & 15) == 1;
        } catch (Exception unused) {
        }
    }

    private static String ii11i111(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 95);
            byte b2 = (byte) (bArr[0] ^ 60);
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

    public static boolean ii11i111(Context context) {
        return !i1lill1(context) || ii11i111(context, ii11i111("5f4846070b4b4e525942490e1a51535b405e445e4245042d46554f524359435149444d455f5a554447", 27));
    }

    public static boolean ii11i111(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }
}
