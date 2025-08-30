package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO;

import java.lang.reflect.Method;
import org.apache.commons.lang3.CharEncoding;

public abstract class o0Oo0OO00O0O000ooOO0 implements o00ooooooO00OO0O00 {
    protected Method[] O00OO0oOOooooO00000Oo;
    protected String o0O00o00OOoOo0oooOoo00;
    protected String o0Oo0OO00O0O000ooOO0;
    protected Class oO00o0OooO0OO0o0000o;

    public o0Oo0OO00O0O000ooOO0(Class cls) {
        if (cls != null) {
            this.oO00o0OooO0OO0o0000o = cls;
            this.O00OO0oOOooooO00000Oo = cls.getDeclaredMethods();
            return;
        }
        throw new NullPointerException(o0Oo0OO00O0O000ooOO0("217160283e7a62262b6a6f6f686c4b42607f6d3e2e6f626d6c76392f6a282376746d", 26));
    }

    public Object o0Oo0OO00O0O000ooOO0(String str, Class[] clsArr, Object... objArr) {
        try {
            Method declaredMethod = this.oO00o0OooO0OO0o0000o.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(this.oO00o0OooO0OO0o0000o, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public Object o0Oo0OO00O0O000ooOO0(String str, Object... objArr) {
        try {
            Method o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0(str);
            o0Oo0OO00O0O000ooOO02.setAccessible(true);
            return o0Oo0OO00O0O000ooOO02.invoke(this.oO00o0OooO0OO0o0000o, objArr);
        } catch (Throwable unused) {
            return null;
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
            byte b = (byte) (i ^ 119);
            byte b2 = (byte) (bArr[0] ^ 85);
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

    private Method o0Oo0OO00O0O000ooOO0(String str) {
        if (this.O00OO0oOOooooO00000Oo == null) {
            this.O00OO0oOOooooO00000Oo = this.oO00o0OooO0OO0o0000o.getDeclaredMethods();
        }
        for (Method method : this.O00OO0oOOooooO00000Oo) {
            if (method.getName().equals(str)) {
                return method;
            }
        }
        return null;
    }

    public void o0Oo0OO00O0O000ooOO0() {
        o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("3b336d6c", 27), new Object[0]);
    }
}
