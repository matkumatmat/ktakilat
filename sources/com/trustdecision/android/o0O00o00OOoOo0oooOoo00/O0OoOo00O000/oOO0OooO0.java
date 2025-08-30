package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import org.apache.commons.lang3.CharEncoding;

public class oOO0OooO0 {
    private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 8);
            byte b2 = (byte) (bArr[0] ^ 83);
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

    public static String o0Oo0OO00O0O000ooOO0(Method method) {
        StringBuilder sb = new StringBuilder();
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        sb.append(method.getDeclaringClass().getName());
        sb.append(o0Oo0OO00O0O000ooOO0("7d", 60));
        sb.append(method.getName());
        sb.append(o0Oo0OO00O0O000ooOO0("7b", 36));
        for (Type obj : genericParameterTypes) {
            sb.append(obj.toString());
            sb.append(o0Oo0OO00O0O000ooOO0("7f", 80));
        }
        if (genericParameterTypes.length > 0 && sb.toString().length() >= 1) {
            sb.delete(sb.length() - 1, sb.length());
        }
        sb.append(o0Oo0OO00O0O000ooOO0("7a", 92));
        return sb.toString();
    }
}
