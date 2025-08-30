package com.trustdecision.mobrisk.o0Oo0OO00O0O000ooOO0;

import com.trustdecision.mobrisk.TDErrorCodeCallback;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.apache.commons.lang3.CharEncoding;

public class o0Oo0OO00O0O000ooOO0 implements InvocationHandler {
    TDErrorCodeCallback o0Oo0OO00O0O000ooOO0;

    public o0Oo0OO00O0O000ooOO0(TDErrorCodeCallback tDErrorCodeCallback) {
        this.o0Oo0OO00O0O000ooOO0 = tDErrorCodeCallback;
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
            byte b = (byte) (i ^ 96);
            byte b2 = (byte) (bArr[0] ^ 71);
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
        TDErrorCodeCallback tDErrorCodeCallback;
        if (method.getName().equals(o0Oo0OO00O0O000ooOO0("3336110a2b362a24", 77))) {
            return obj.getClass().toString();
        }
        if (method.getName().equals(o0Oo0OO00O0O000ooOO0("2f1b0009393e1913", 114))) {
            return Integer.valueOf(obj.getClass().hashCode());
        }
        boolean z = true;
        if (method.getName().equals(o0Oo0OO00O0O000ooOO0("22514151485a", 37))) {
            if (objArr == null || obj != objArr[0]) {
                z = false;
            }
            return Boolean.valueOf(z);
        } else if (!method.getName().equals(o0Oo0OO00O0O000ooOO0("280f323918081716", 110)) || objArr.length != 2 || (tDErrorCodeCallback = this.o0Oo0OO00O0O000ooOO0) == null) {
            return null;
        } else {
            tDErrorCodeCallback.onResult(objArr[0].intValue(), String.valueOf(objArr[1]));
            return null;
        }
    }
}
