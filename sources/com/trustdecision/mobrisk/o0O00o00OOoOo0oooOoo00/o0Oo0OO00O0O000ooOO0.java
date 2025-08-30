package com.trustdecision.mobrisk.o0O00o00OOoOo0oooOoo00;

import android.content.Context;
import com.trustdecision.mobrisk.TDAPISignResult;
import com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o;
import org.apache.commons.lang3.CharEncoding;

public class o0Oo0OO00O0O000ooOO0 {
    private static final String O00OO0oOOooooO00000Oo = o0Oo0OO00O0O000ooOO0("403d33726b373637362130373b2b2b3730717e3e3b272c373c7b7e20282b2b3f38714b213420282b0b3f38", 126);
    private static String o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("4518171a161e57135c1d101f1e044b5c1d121f535e0e060505111651521d140e0616", 80);
    private static int o0Oo0OO00O0O000ooOO0 = 4002;
    private static final String oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0("40404e0f164a4b4a4b5c4d4a4656564a4d0c0343465a514a4106035d55565642450c365c495d5556764245707b5a4a5554", 3);

    private static TDAPISignResult o0Oo0OO00O0O000ooOO0() {
        return new TDAPISignResult("", o0Oo0OO00O0O000ooOO0, o0O00o00OOoOo0oooOoo00);
    }

    public static TDAPISignResult o0Oo0OO00O0O000ooOO0(Context context, String str) {
        Object o0Oo0OO00O0O000ooOO02 = oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("40636d2c35696869687f6e69657575696e2f2060657972696225207e76757561662f157f6a7e7675556166", 32), (Object) null, o0Oo0OO00O0O000ooOO0("500a1e19", 95), new Class[]{Context.class, String.class}, new Object[]{context, str});
        return o0Oo0OO00O0O000ooOO02 != null ? o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO02) : o0Oo0OO00O0O000ooOO0();
    }

    private static TDAPISignResult o0Oo0OO00O0O000ooOO0(Object obj) {
        int i = 0;
        Object o0Oo0OO00O0O000ooOO02 = oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("40717f3e277b7a7b7a6d7c7b7767677b7c3d3272776b607b7037326c64676773743d076d786c6467477374414a6b7b6465", 50), obj, o0Oo0OO00O0O000ooOO0("50697d7a7c66727464", 60), new Object[0]);
        Object o0Oo0OO00O0O000ooOO03 = oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("406967263f636263627564636f7f7f6364252a6a6f737863682f2a747c7f7f6b6c251f7560747c7f5f6b6c595273637c7d", 42), obj, o0Oo0OO00O0O000ooOO0("402a2d27", 105), new Object[0]);
        Object o0Oo0OO00O0O000ooOO04 = oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("407e703128747574756273747868687473323d7d78646f747f383d636b68687c7b32086277636b68487c7b4e4564746b6a", 61), obj, o0Oo0OO00O0O000ooOO0("4e4c5244564246", 11), new Object[0]);
        String str = (String) o0Oo0OO00O0O000ooOO02;
        if (o0Oo0OO00O0O000ooOO03 == null) {
            i = o0Oo0OO00O0O000ooOO0;
        }
        return new TDAPISignResult(str, i, (String) o0Oo0OO00O0O000ooOO04);
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
            byte b = (byte) (i ^ 79);
            byte b2 = (byte) (bArr[0] ^ 35);
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
}
