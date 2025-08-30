package com.trustdecision.liveness.cw.api.i11iliil1li1;

import android.content.Context;
import android.util.Base64;

public class illill1ll1 {
    public static void il111liilil(Context context) {
        Class<Context> cls = Context.class;
        try {
            Class<?> cls2 = Class.forName(illill1ll1("145e230438053106201d60526f5879457f4835152e18271865706e7c487e4364", 118));
            Class<?> cls3 = Class.forName(illill1ll1("141d234738463145205e60116f1b79067f0b35562e5b275b651c620673112f792477067a067405760d", 53));
            cls2.getDeclaredMethod(illill1ll1("180a443957324d", 46), new Class[]{cls, cls3}).invoke((Object) null, new Object[]{context, null});
        } catch (Throwable unused) {
        }
    }

    public static String illill1ll1(Context context) {
        Class<Context> cls = Context.class;
        try {
            return (String) Class.forName(illill1ll1("DRlMBigvCAoCDFwmLwscGAsWaTIHCxsOXAEMLgkSDAY=")).getDeclaredMethod(illill1ll1("ARknBCIvGw=="), new Class[]{cls}).invoke((Object) null, new Object[]{context});
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String illill1ll1(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 37);
            byte b2 = (byte) (bArr[0] ^ 119);
            bArr[0] = b2;
            int i4 = 1;
            while (i4 < length) {
                byte b3 = bArr[i4];
                bArr[i4] = (byte) ((b2 ^ b3) ^ b);
                i4++;
                b2 = b3;
            }
            return new String(bArr, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String illill1ll1(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            int length = decode.length;
            byte[] bytes = "nwbrGAo".getBytes();
            int length2 = bytes.length;
            for (int i = 0; i < length; i++) {
                decode[i] = (byte) (decode[i] ^ bytes[i % length2]);
            }
            return new String(decode, "utf-8");
        } catch (Exception unused) {
            return null;
        }
    }
}
