package com.trustdecision.android.o0O00o00OOoOo0oooOoo00;

import java.util.HashMap;
import org.apache.commons.lang3.CharEncoding;

class o0O00o00OOoOo0oooOoo00 extends HashMap {
    final /* synthetic */ o0Oo0OO00O0O000ooOO0 o0Oo0OO00O0O000ooOO0;

    public o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0) {
        this.o0Oo0OO00O0O000ooOO0 = o0oo0oo00o0o000oooo0;
        put(o0Oo0OO00O0O000ooOO0("583b2723246e32276e31797d3c262e24363c67672c36", 61), o0Oo0OO00O0O000ooOO0("58302c282f65392c613b3e27397b76372d252f3d376c6c273d", 54));
        put(o0Oo0OO00O0O000ooOO0("583f2327206a36236f2e6068357d6c323a3e3369632832", 57), o0Oo0OO00O0O000ooOO0("58594541460c50450852574e50121f5e444c46545e05054e54", 95));
        put(o0Oo0OO00O0O000ooOO0("58564a4e49035f4a035c4e5b5c4d1010514b43495b510a0a415b", 80), o0Oo0OO00O0O000ooOO0("587c6064632975602d77726b75373a7b616963717b20206b71", 122));
        put(o0Oo0OO00O0O000ooOO0("58302c282f65392c70382d3a7276372d252f3d376c6c273d", 54), o0Oo0OO00O0O000ooOO0("583c2024236935207c346a6b367e6f31393d306a602b31", 58));
        put(o0Oo0OO00O0O000ooOO0("584b5753541e42570b431d1c410918464e4a471d175c46", 77), o0Oo0OO00O0O000ooOO0("582c3034337925306c247a7b266e7f21292d207a703b21", 42));
        put(o0Oo0OO00O0O000ooOO0("585f4347400a5643194556551d1958424a40525803034852", 89), o0Oo0OO00O0O000ooOO0("58293531367c20356f336b7e236b7a242c28257f753e24", 47));
        put(o0Oo0OO00O0O000ooOO0("586c7074733965702a762e3b662e3f61696d603a307b61", 106), o0Oo0OO00O0O000ooOO0("580f1317105a061349154d58054d5c020a0e0359531802", 9));
        put(o0Oo0OO00O0O000ooOO0("584c50545319455019444357460e0a4b515953414b10105b41", 74), o0Oo0OO00O0O000ooOO0("587e6266612b776229632a29743c2d737b7f7228226973", 120));
        put(o0Oo0OO00O0O000ooOO0("586d7175723864713a70393a672f3e60686c613b317a60", 107), o0Oo0OO00O0O000ooOO0("58011d191e54081d561c55560b43520c04000d575d160c", 7));
        put(o0Oo0OO00O0O000ooOO0("58514d494e04584d0b404f5b1317564c444e5c560d0d465c", 87), o0Oo0OO00O0O000ooOO0("584a5652551f4356105b1f1d400819474f4b461c165d47", 76));
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
            byte b = (byte) (i ^ 26);
            byte b2 = (byte) (bArr[0] ^ 48);
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
