package com.trustdecision.liveness.cw.api.illill1ll1;

import android.util.Base64;

public class illill1ll1 {
    public static final String i11iliil1li1 = illill1ll1("IQchFk5CYBQuXiwFWV9/VXpCZVRDQCsCP10+HxdAIQg/EnsVAg5hBCUGJhIRH2EPM14hAwcZdV95S20=");
    public static final String i1i1l1lii = illill1ll1("5b0c350c36", 122);
    public static String i1l1i1llllil1i1lii = illill1ll1("413a3c2d272228282a3d373b367a726868242f79353a3025232e28382864757363757a6d21346539363c3c3a3727217f3929", 16);
    public static final String i1lill1ii = illill1ll1("f0NlVkU=");
    public static final String ii1lilli = illill1ll1("eEJmU0Q=");
    public static String iill11l11 = illill1ll1("41533c44274b28412a54375236137201684d345a3b1e781b67086c037a03264a3257334d225a22473f1a665e6b0d6e07680c751a2d027b", 121);
    public static final String iill11lliiil1l1i11l11 = illill1ll1("IQchFgdXYEg6BzQSHQ47AjoHexIbAygDPB17CBEZYBMsACFJGAQ5AiFGIxMRQiYJLRYtSBwZIgtqXCYSFR87MywAIQ==");
    public static final String il111liilil;
    public static String il11iii11l11i1 = illill1ll1("41373c20272f28252a3037363677726568292f74353730282323283528697372777c7c3d2579282a2d202b2b363d6e2538", 29);
    public static String ilii1liii11i1iii1l1;
    public static final String illill1ll1 = illill1ll1("IQchFgdXYEggF3gFBggrDj1dNBYdGStJJxYh");
    public static final String l1li11i1ll = illill1ll1("f0NlVkc=");
    public static final String l1lliiiil1lll1lil1i1 = illill1ll1("5801360133", 116);
    public static final String li1i1l1l1iiii1iiii1l1 = illill1ll1("584b364b32", 62);
    public static final String li1li1ii1ii11ii = illill1ll1("5c01350734", 112);
    public static final String lilli1ii1i = illill1ll1("f0NlVkY=");
    public static final String lillllil1i1 = illill1ll1("5c16290d34", 121);
    public static final String ll11li11l11il1lillll = illill1ll1("5c70357636", 1);
    public static final String ll1i11ii1liilll1ii = illill1ll1("5f72327232", 3);
    public static final String ll1lllii11l1iii1l1 = illill1ll1("5c2d322d32", 92);

    static {
        String illill1ll12 = illill1ll1("061b681f6b567e562242680c791b7816654c2a5d3340230a630172", 116);
        il111liilil = illill1ll12;
        ilii1liii11i1iii1l1 = illill1ll12;
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
            byte b = (byte) (i ^ 115);
            byte b2 = (byte) (bArr[0] ^ 110);
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
            byte[] bytes = "IsUftmOg".getBytes();
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
