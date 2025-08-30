package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0oOO0oO00OoO0;
import com.trustdecision.android.shell.inter.InvokeHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import org.apache.commons.lang3.CharEncoding;

class oO0o0oOoOO0OO implements InvokeHandler {
    final /* synthetic */ String[] o0Oo0OO00O0O000ooOO0;

    public oO0o0oOoOO0OO(String[] strArr) {
        this.o0Oo0OO00O0O000ooOO0 = strArr;
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
            byte b = (byte) (i ^ 113);
            byte b2 = (byte) (bArr[0] ^ 44);
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

    /* renamed from: o0Oo0OO00O0O000ooOO0 */
    public Map invoke() {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, this.o0Oo0OO00O0O000ooOO0);
        return o0oOO0oO00OoO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("03075a455414144b5d445f5051", 41), arrayList, o0Oo0OO00O0O000ooOO0("16", 72));
    }
}
