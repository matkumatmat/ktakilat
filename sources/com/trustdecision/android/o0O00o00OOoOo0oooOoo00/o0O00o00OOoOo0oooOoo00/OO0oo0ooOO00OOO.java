package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.Oo0O0Oo0OO0OOOoOO0O0;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0oOO0oO00OoO0;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo;
import java.io.File;
import org.apache.commons.lang3.CharEncoding;

public class OO0oo0ooOO00OOO {
    private static final OO0oo0ooOO00OOO O0oOO0ooO = new OO0oo0ooOO00OOO();
    private static final String o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("46646f6e696579", 42);
    private static final String o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("4639323525292d2b252524", 119);
    private static final String oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0("3c743e2926", 112);
    /* access modifiers changed from: private */
    public String O00OO0oOOooooO00000Oo = null;

    private OO0oo0ooOO00OOO() {
    }

    private static String O00OO0oOOooooO00000Oo(Context context) {
        return o0oOO0oO00OoO0.o0Oo0OO00O0O000ooOO0(new File(context.getFilesDir().getAbsolutePath(), Oo0O0Oo0OO0OOOoOO0O0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("3c2b617679", 47))));
    }

    public static OO0oo0ooOO00OOO o0Oo0OO00O0O000ooOO0() {
        return O0oOO0ooO;
    }

    private static String oO00o0OooO0OO0o0000o(Context context) {
        String o0O00o00OOoOo0oooOoo002 = O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(context, Oo0O0Oo0OO0OOOoOO0O0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4618131404080c0a040405", 86)), "");
        if (TextUtils.isEmpty(o0O00o00OOoOo0oooOoo002)) {
            return null;
        }
        return o0O00o00OOoOo0oooOoo002;
    }

    public void o0O00o00OOoOo0oooOoo00(Context context) {
        if (!TextUtils.isEmpty(this.O00OO0oOOooooO00000Oo)) {
            Thread thread = new Thread(new O00O00oo0ooO0(this, context));
            thread.setName(o0Oo0OO00O0O000ooOO0("661e1f1e1f08191e1202021e1944", 70));
            thread.start();
        }
    }

    /* access modifiers changed from: private */
    public static void O00OO0oOOooooO00000Oo(Context context, String str) {
        o0oOO0oO00OoO0.o0Oo0OO00O0O000ooOO0(new File(context.getFilesDir().getAbsolutePath(), Oo0O0Oo0OO0OOOoOO0O0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("3c410b1c13", 69))), str);
    }

    /* access modifiers changed from: private */
    public static void oO00o0OooO0OO0o0000o(Context context, String str) {
        O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, Oo0O0Oo0OO0OOOoOO0O0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4679727565696d6b656564", 55)), str);
    }

    public String o0Oo0OO00O0O000ooOO0(Context context) {
        if (context == null) {
            return null;
        }
        Oo0O0Oo0OO0OOOoOO0O0.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0("4659525545494d4b454544", 23));
        if (TextUtils.isEmpty(this.O00OO0oOOooooO00000Oo)) {
            this.O00OO0oOOooooO00000Oo = oO00o0OooO0OO0o0000o(context);
        }
        Oo0O0Oo0OO0OOOoOO0O0.o0Oo0OO00O0O000ooOO0(context, new File(context.getFilesDir().getAbsolutePath(), o0Oo0OO00O0O000ooOO0("3c216b7c73", 37)).getAbsolutePath(), o0Oo0OO00O0O000ooOO0("46656e6979757177797978", 43));
        if (TextUtils.isEmpty(this.O00OO0oOOooooO00000Oo)) {
            this.O00OO0oOOooooO00000Oo = O00OO0oOOooooO00000Oo(context);
        }
        return this.O00OO0oOOooooO00000Oo;
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
            byte b = (byte) (i ^ 94);
            byte b2 = (byte) (bArr[0] ^ Ascii.DC2);
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

    public void o0Oo0OO00O0O000ooOO0(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.O00OO0oOOooooO00000Oo = str;
        }
    }
}
