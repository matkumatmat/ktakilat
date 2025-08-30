package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import org.apache.commons.lang3.CharEncoding;

public class O00OO0oOOooooO00000Oo extends o0Oo0OO00O0O000ooOO0 {
    public static final String O0oOO0ooO = o0Oo0OO00O0O000ooOO0("095856170e525352534455525e4e4e5255141b5b5e424952591e0a45565c5e52565d514e5353091d0a541c1c0a54421c541c42421c0a421c1c7a5b48", 103);

    public O00OO0oOOooooO00000Oo(Class cls) {
        super(cls);
        this.o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("191f074e55190a00020e0a010d120f", 59);
        this.o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("092927667f232223223524232f3f3f2324656a2a2f333823286f7b34272d2f23272c203f2222786c7b256d6d7b25336d256d33336d7b336d6d0b2a39", 22);
    }

    public String o0O00o00OOoOo0oooOoo00() {
        return (String) o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("0448", 39), new Object[0]);
    }

    public PackageInfo o0Oo0OO00O0O000ooOO0(PackageManager packageManager, String str) {
        return (PackageInfo) o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("0435", 91), new Class[]{PackageManager.class, String.class}, packageManager, str);
    }

    public String o0Oo0OO00O0O000ooOO0(Context context) {
        return (String) o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("0418", 117), new Class[]{Context.class}, context);
    }

    public String o0Oo0OO00O0O000ooOO0(Context context, ActivityManager activityManager) {
        return (String) o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("0460", 12), new Class[]{Context.class, ActivityManager.class}, context, activityManager);
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
            byte b = (byte) (i ^ 51);
            byte b2 = (byte) (bArr[0] ^ 106);
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
