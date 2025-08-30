package com.trustdecision.mobrisk.o0Oo0OO00O0O000ooOO0;

import com.trustdecision.mobrisk.TDDeviceAPIStatus;
import com.trustdecision.mobrisk.TDDeviceInfoCallback;
import com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.apache.commons.lang3.CharEncoding;

public class o0O00o00OOoOo0oooOoo00 implements InvocationHandler {
    private Class o0O00o00OOoOo0oooOoo00;
    private TDDeviceInfoCallback o0Oo0OO00O0O000ooOO0;

    public o0O00o00OOoOo0oooOoo00(TDDeviceInfoCallback tDDeviceInfoCallback) {
        this.o0Oo0OO00O0O000ooOO0 = tDDeviceInfoCallback;
        try {
            this.o0O00o00OOoOo0oooOoo00 = Class.forName(o0Oo0OO00O0O000ooOO0("6a6f612039656465647362656979796562232c6c69757e656e293e786e6a63212e6f616361622319736342707c696547727a794476766265", 84));
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
            byte b = (byte) (i ^ 55);
            byte b2 = (byte) (bArr[0] ^ 9);
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
        if (method.getName().equals(o0Oo0OO00O0O000ooOO0("7d47607b5a475b55", 107))) {
            return obj.getClass().toString();
        }
        if (method.getName().equals(o0Oo0OO00O0O000ooOO0("612239300007202a", 28))) {
            return Integer.valueOf(obj.getClass().hashCode());
        }
        boolean z = true;
        if (method.getName().equals(o0Oo0OO00O0O000ooOO0("6c5545554c5e", 118))) {
            if (objArr == null || obj != objArr[0]) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        if (method.getName().equals(o0Oo0OO00O0O000ooOO0("6668555e7f6f7071", 94)) && objArr.length == 6 && this.o0Oo0OO00O0O000ooOO0 != null) {
            String str = objArr[0];
            String str2 = objArr[1];
            String str3 = objArr[2];
            int intValue = objArr[3].intValue();
            Object obj2 = objArr[4];
            Object o0Oo0OO00O0O000ooOO02 = oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(this.o0O00o00OOoOo0oooOoo00, obj2, o0Oo0OO00O0O000ooOO0("6e1f0c2a31161c", 42), new Object[0]);
            Object o0Oo0OO00O0O000ooOO03 = oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(this.o0O00o00OOoOo0oooOoo00, obj2, o0Oo0OO00O0O000ooOO0("6e1a0921300e180a1e1a", 47), new Object[0]);
            this.o0Oo0OO00O0O000ooOO0.onResult(str, str2, str3, intValue, (o0Oo0OO00O0O000ooOO02 == null || o0Oo0OO00O0O000ooOO03 == null) ? null : new TDDeviceAPIStatus(((Integer) o0Oo0OO00O0O000ooOO02).intValue(), (String) o0Oo0OO00O0O000ooOO03), objArr[5]);
        }
        return null;
    }
}
