package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000;

import java.util.HashMap;
import org.apache.commons.lang3.CharEncoding;

class ooooOO0OO0O0OOoo extends HashMap {
    public ooooOO0OO0O0OOoo() {
        put(0, o0Oo0OO00O0O000ooOO0("285842584a525f4c504e5d5755595d49534d534d47", 40));
        put(1, o0Oo0OO00O0O000ooOO0("265c484759475953", 60));
        put(3, o0Oo0OO00O0O000ooOO0("200e03001b0b18020414110301140e110f111b", 116));
        put(4, o0Oo0OO00O0O000ooOO0("2025333e3022243329202a33352e29393a243a30", 95));
        put(5, o0Oo0OO00O0O000ooOO0("33766a71767678697a646369697d637d6369", 6));
        put(6, o0Oo0OO00O0O000ooOO0("334655544a5e4956505a4b435d4349", 38));
        put(8, o0Oo0OO00O0O000ooOO0("37191d1105150c160c1d0c17050500081f1b1018061812", 125));
        put(9, o0Oo0OO00O0O000ooOO0("32213c2a2b2a3a253b252f", 64));
        put(11, o0Oo0OO00O0O000ooOO0("34584844455f565c4543585f4f455b4b4b404c524c46", 41));
        put(12, o0Oo0OO00O0O000ooOO0("362637372e2a343a242a342a20", 79));
        put(13, o0Oo0OO00O0O000ooOO0("2765717d6a7667747360657f7b6d766a6d7d7e607e74", 27));
        put(14, o0Oo0OO00O0O000ooOO0("263e363e3d3f2c283e3b2d243a242e", 65));
        put(15, o0Oo0OO00O0O000ooOO0("2e565055434a544a40", 47));
        put(16, o0Oo0OO00O0O000ooOO0("326874727c696d757962747d637d77", 24));
        put(17, o0Oo0OO00O0O000ooOO0("23505d46564b50464f514f45", 42));
        put(18, o0Oo0OO00O0O000ooOO0("29061a1e151518070d1b1c08160802", 109));
        put(19, o0Oo0OO00O0O000ooOO0("201a1f030813180e03180e0719070d", 98));
        put(20, o0Oo0OO00O0O000ooOO0("25777e73776c7a736d7379", 22));
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
            byte b2 = (byte) (bArr[0] ^ 97);
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
