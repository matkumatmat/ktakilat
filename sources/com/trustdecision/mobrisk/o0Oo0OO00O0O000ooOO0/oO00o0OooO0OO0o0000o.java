package com.trustdecision.mobrisk.o0Oo0OO00O0O000ooOO0;

import com.trustdecision.mobrisk.TDRiskCallback;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.apache.commons.lang3.CharEncoding;

public class oO00o0OooO0OO0o0000o implements InvocationHandler {
    TDRiskCallback o0Oo0OO00O0O000ooOO0;

    public oO00o0OooO0OO0o0000o(TDRiskCallback tDRiskCallback) {
        this.o0Oo0OO00O0O000ooOO0 = tDRiskCallback;
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
            byte b = (byte) (i ^ 82);
            byte b2 = (byte) (bArr[0] ^ 110);
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
        TDRiskCallback tDRiskCallback;
        if (method.getName().equals(o0Oo0OO00O0O000ooOO0("1a45627958455957", 12))) {
            return obj.getClass().toString();
        }
        if (method.getName().equals(o0Oo0OO00O0O000ooOO0("066c777e4e496e64", 55))) {
            return Integer.valueOf(obj.getClass().hashCode());
        }
        boolean z = true;
        if (method.getName().equals(o0Oo0OO00O0O000ooOO0("0b0313031a08", 69))) {
            if (objArr == null || obj != objArr[0]) {
                z = false;
            }
            return Boolean.valueOf(z);
        } else if (!method.getName().equals(o0Oo0OO00O0O000ooOO0("01624850706879", 49)) || objArr.length != 1 || (tDRiskCallback = this.o0Oo0OO00O0O000ooOO0) == null) {
            return null;
        } else {
            tDRiskCallback.onEvent(String.valueOf(objArr[0]));
            return null;
        }
    }
}
