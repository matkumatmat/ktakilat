package com.trustdecision.mobrisk.o0Oo0OO00O0O000ooOO0;

import com.google.common.base.Ascii;
import com.trustdecision.mobrisk.TDRiskCaptchaCallback;
import com.trustdecision.mobrisk.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.apache.commons.lang3.CharEncoding;

public class O00OO0oOOooooO00000Oo implements InvocationHandler {
    TDRiskCaptchaCallback o0Oo0OO00O0O000ooOO0;

    public O00OO0oOOooooO00000Oo(TDRiskCaptchaCallback tDRiskCaptchaCallback) {
        this.o0Oo0OO00O0O000ooOO0 = tDRiskCaptchaCallback;
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
            byte b = (byte) (i ^ 109);
            byte b2 = (byte) (bArr[0] ^ Ascii.ESC);
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

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (method.getName().equals(o0Oo0OO00O0O000ooOO0("6f16312a0b160a04", 96))) {
            return obj.getClass().toString();
        }
        if (method.getName().equals(o0Oo0OO00O0O000ooOO0("73312a2313143339", 85))) {
            return Integer.valueOf(obj.getClass().hashCode());
        }
        boolean z = true;
        if (method.getName().equals(o0Oo0OO00O0O000ooOO0("7e7c6c7c6577", 5))) {
            if (objArr == null || obj != objArr[0]) {
                z = false;
            }
            return Boolean.valueOf(z);
        } else if (this.o0Oo0OO00O0O000ooOO0 == null) {
            return null;
        } else {
            if (method.getName().equals(o0Oo0OO00O0O000ooOO0("7438050e3d3c24", 84))) {
                this.o0Oo0OO00O0O000ooOO0.onReady();
                return null;
            }
            if (method.getName().equals(o0Oo0OO00O0O000ooOO0("74665a417167617167", 10)) && objArr.length == 1) {
                this.o0Oo0OO00O0O000ooOO0.onSuccess(String.valueOf(objArr[0]));
            } else if (!method.getName().equals(o0Oo0OO00O0O000ooOO0("745c757a5558545c", 48)) || objArr.length != 2) {
                return null;
            } else {
                this.o0Oo0OO00O0O000ooOO0.onFailed(objArr[0].intValue(), String.valueOf(objArr[1]));
            }
            oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0 = false;
            return null;
        }
    }
}
