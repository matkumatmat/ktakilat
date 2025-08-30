package com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.CharEncoding;

public abstract class o0Oo0OO00O0O000ooOO0 implements O0oOO0ooO {
    private static final String oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0("67425b59564f", 58);
    private List O00OO0oOOooooO00000Oo = new ArrayList();
    protected o00ooooooO00OO0O00 o0O00o00OOoOo0oooOoo00;
    protected Context o0Oo0OO00O0O000ooOO0;

    public o0Oo0OO00O0O000ooOO0(Context context, o00ooooooO00OO0O00 o00ooooooo00oo0o00) {
        this.o0Oo0OO00O0O000ooOO0 = context;
        this.o0O00o00OOoOo0oooOoo00 = o00ooooooo00oo0o00;
    }

    @Nullable
    public String o0O00o00OOoOo0oooOoo00() {
        return null;
    }

    @Nullable
    public String o0Oo0OO00O0O000ooOO0() {
        StringBuilder sb = new StringBuilder();
        for (String append : this.O00OO0oOOooooO00000Oo) {
            sb.append(append);
            sb.append(10);
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            return null;
        }
        return sb2;
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
            byte b = (byte) (i ^ 102);
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

    public void o0Oo0OO00O0O000ooOO0(Exception exc) {
        List list = this.O00OO0oOOooooO00000Oo;
        list.add(o0Oo0OO00O0O000ooOO0("757355485b4a53484f1a54", 40) + exc);
    }

    public void o0Oo0OO00O0O000ooOO0(String str) {
        this.O00OO0oOOooooO00000Oo.add(str);
    }
}
