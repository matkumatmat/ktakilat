package com.trustdecision.mobrisk.o0Oo0OO00O0O000ooOO0;

import com.trustdecision.mobrisk.TDRiskLivenessCallback;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.apache.commons.lang3.CharEncoding;

public class O0oOO0ooO implements InvocationHandler {
    TDRiskLivenessCallback o0Oo0OO00O0O000ooOO0;

    public O0oOO0ooO(TDRiskLivenessCallback tDRiskLivenessCallback) {
        this.o0Oo0OO00O0O000ooOO0 = tDRiskLivenessCallback;
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
            byte b = (byte) (i ^ 15);
            byte b2 = (byte) (bArr[0] ^ 87);
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
        if (method.getName().equals(o0Oo0OO00O0O000ooOO0("2321061d3c213d33", 53))) {
            return obj.getClass().toString();
        }
        if (method.getName().equals(o0Oo0OO00O0O000ooOO0("3f475c556562454f", 65))) {
            return Integer.valueOf(obj.getClass().hashCode());
        }
        boolean z = true;
        if (method.getName().equals(o0Oo0OO00O0O000ooOO0("327f6f7f6674", 100))) {
            if (objArr == null || obj != objArr[0]) {
                z = false;
            }
            return Boolean.valueOf(z);
        } else if (this.o0Oo0OO00O0O000ooOO0 == null) {
            return null;
        } else {
            if (method.getName().equals(o0Oo0OO00O0O000ooOO0("38665a417167617167", 104)) && objArr.length == 1) {
                this.o0Oo0OO00O0O000ooOO0.onSuccess(String.valueOf(objArr[0]));
                return null;
            } else if (!method.getName().equals(o0Oo0OO00O0O000ooOO0("383b110d3a2727", 53)) || objArr.length != 3) {
                return null;
            } else {
                this.o0Oo0OO00O0O000ooOO0.onError(String.valueOf(objArr[0]), String.valueOf(objArr[1]), String.valueOf(objArr[2]));
                return null;
            }
        }
    }
}
