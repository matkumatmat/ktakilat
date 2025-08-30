package com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.OoOOooOoooOoo;
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o00ooooooO00OO0O00;
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.commons.lang3.CharEncoding;

public class o0Oo0O0o0ooOOo0oO0 extends o0Oo0OO00O0O000ooOO0 {
    private Object O00OO0oOOooooO00000Oo;
    private Class oO00o0OooO0OO0o0000o;

    public o0Oo0O0o0ooOOo0oO0(Context context, o00ooooooO00OO0O00 o00ooooooo00oo0o00) {
        super(context, o00ooooooo00oo0o00);
        O00OO0oOOooooO00000Oo();
    }

    @SuppressLint({"PrivateApi"})
    private void O00OO0oOOooooO00000Oo() {
        try {
            Class<?> cls = Class.forName(o0Oo0OO00O0O000ooOO0("3b202e6f6323263a312a21666b21666b2831306e4b01180e313533212d3b17083130", 112));
            this.oO00o0OooO0OO0o0000o = cls;
            this.O00OO0oOOooooO00000Oo = cls.newInstance();
        } catch (Throwable unused) {
        }
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
            byte b = (byte) (i ^ 92);
            byte b2 = (byte) (bArr[0] ^ 88);
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

    private String oO00o0OooO0OO0o0000o() {
        String o0Oo0OO00O0O000ooOO0 = OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("2a732f2d6a727229357229367d796f74686f2e2e616266", 50));
        String o0Oo0OO00O0O000ooOO02 = OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("2a722e2c6b737328377c786e75696e2f2263646e5544726b67", 51));
        String o0Oo0OO00O0O000ooOO03 = OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("2a3b6765223a3a617d3a617e3531273c2027666b2a2d27", 122));
        if (TextUtils.isEmpty(o0Oo0OO00O0O000ooOO03) && TextUtils.isEmpty(o0Oo0OO00O0O000ooOO02) && TextUtils.isEmpty(o0Oo0OO00O0O000ooOO0)) {
            return null;
        }
        String o0Oo0OO00O0O000ooOO04 = OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("2a6b373a616a737e3c2e6561776c70773631717b67617e7e7d6c637b", 42));
        StringBuilder v = ba.v(o0Oo0OO00O0O000ooOO03);
        v.append(o0Oo0OO00O0O000ooOO0("24", 90));
        v.append(o0Oo0OO00O0O000ooOO04);
        v.append(o0Oo0OO00O0O000ooOO0("24", 89));
        v.append(o0Oo0OO00O0O000ooOO0);
        return ba.r(v, o0Oo0OO00O0O000ooOO0("24", 54), o0Oo0OO00O0O000ooOO02);
    }

    public String OO0000O0Ooo0OO000oo() {
        return o0Oo0OO00O0O000ooOO0("004c55535f59", 1);
    }

    public boolean OoOOooOoooOoo() {
        return (this.oO00o0OooO0OO0o0000o == null && this.O00OO0oOOooooO00000Oo == null) ? false : true;
    }

    public String o00ooooooO00OO0O00() {
        if (this.O00OO0oOOooooO00000Oo == null) {
            return null;
        }
        try {
            return (String) this.oO00o0OooO0OO0o0000o.getDeclaredMethod(o0Oo0OO00O0O000ooOO0("3f7f6c46737570", 33), new Class[]{Context.class}).invoke(this.O00OO0oOOooooO00000Oo, new Object[]{this.o0Oo0OO00O0O000ooOO0});
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public String o0O00o00OOoOo0oooOoo00() {
        return oO00o0OooO0OO0o0000o();
    }

    public void o0Oo0OO00O0O000ooOO0(ThreadPoolExecutor threadPoolExecutor) {
        this.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(this);
    }
}
