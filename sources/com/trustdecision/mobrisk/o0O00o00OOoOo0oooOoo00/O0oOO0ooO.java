package com.trustdecision.mobrisk.o0O00o00OOoOo0oooOoo00;

import com.trustdecision.mobrisk.TDDeviceAPIStatus;
import com.trustdecision.mobrisk.TDDeviceInfoCallback;
import com.trustdecision.mobrisk.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00;
import com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o;
import java.lang.reflect.Proxy;
import org.apache.commons.lang3.CharEncoding;
import org.json.JSONObject;

public class O0oOO0ooO {
    private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 51);
            byte b2 = (byte) (bArr[0] ^ 99);
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

    private static JSONObject o0Oo0OO00O0O000ooOO0(Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(o0Oo0OO00O0O000ooOO0("114b584e405d", 111), th.getLocalizedMessage());
            jSONObject.put(o0Oo0OO00O0O000ooOO0("1757534f", 105), th.getClass().getName());
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i];
                if (stackTraceElement.getClassName().contains(o0Oo0OO00O0O000ooOO0("00151b5a431f1e1f1e09181f1303031f18595a1b1409020301", 42))) {
                    jSONObject.put(o0Oo0OO00O0O000ooOO0("104052454f", 116), stackTraceElement.toString());
                    break;
                }
                i++;
            }
            return jSONObject;
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static void o0Oo0OO00O0O000ooOO0(TDDeviceInfoCallback tDDeviceInfoCallback) {
        Object obj;
        try {
            Class<?> cls = Class.forName(o0Oo0OO00O0O000ooOO0("00373978613d3c3d3c2b3a3d3121213d3a7b7434312d263d3671662036323b795330371d393021", 8));
            Class<?> cls2 = Class.forName(o0Oo0OO00O0O000ooOO0("002826677e222322233425222e3e3e2225646b2b2e323922296e793f292d246663233e3533785e342405373b2e2208032c2d080629242a27262c", 23));
            if (tDDeviceInfoCallback != null) {
                obj = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls2}, new o0O00o00OOoOo0oooOoo00(tDDeviceInfoCallback));
            } else {
                obj = null;
            }
            oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((Class) cls, (Object) null, o0Oo0OO00O0O000ooOO0("041d0e2f3e0c00151933381716", 44), new Class[]{cls2}, new Object[]{obj});
        } catch (Throwable th) {
            oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(th);
            if (tDDeviceInfoCallback != null) {
                com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0("0432210011232f3a361c173839652a", 3) + String.valueOf(o0Oo0OO00O0O000ooOO0(th)));
                tDDeviceInfoCallback.onResult((String) null, (String) null, (String) null, 0, (TDDeviceAPIStatus) null, (String) null);
            }
        }
    }
}
