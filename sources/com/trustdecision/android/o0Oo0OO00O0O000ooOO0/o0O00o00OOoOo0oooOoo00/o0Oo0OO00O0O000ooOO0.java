package com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00;

import android.app.Application;
import android.content.Context;
import org.apache.commons.lang3.CharEncoding;

public class o0Oo0OO00O0O000ooOO0 {
    private static Context o0Oo0OO00O0O000ooOO0;

    public static synchronized Context o0O00o00OOoOo0oooOoo00() {
        synchronized (o0Oo0OO00O0O000ooOO0.class) {
            try {
                Class<?> cls = Class.forName(o0Oo0OO00O0O000ooOO0("493e3b272c373c7b7e20316f5e13262c2e2e2c3c1c0d2b263534", 42));
                Object invoke = cls.getMethod(o0Oo0OO00O0O000ooOO0("4f0c1f3b3f0e120b040c1b13080f", 21), (Class[]) null).invoke(cls.getMethod(o0Oo0OO00O0O000ooOO0("4b011017001c0d2235000a08080a1a3a2b0d001312", 12), (Class[]) null).invoke((Object) null, (Object[]) null), (Object[]) null);
                if (invoke != null) {
                    Context applicationContext = ((Application) invoke).getApplicationContext();
                    return applicationContext;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static synchronized Context o0Oo0OO00O0O000ooOO0() {
        Context context;
        synchronized (o0Oo0OO00O0O000ooOO0.class) {
            context = o0Oo0OO00O0O000ooOO0;
        }
        return context;
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
            byte b = (byte) (i ^ 27);
            byte b2 = (byte) (bArr[0] ^ 40);
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

    public static synchronized void o0Oo0OO00O0O000ooOO0(Context context) {
        synchronized (o0Oo0OO00O0O000ooOO0.class) {
            if (context != null) {
                if (o0Oo0OO00O0O000ooOO0 == null) {
                    o0Oo0OO00O0O000ooOO0 = context.getApplicationContext();
                }
            }
        }
    }
}
