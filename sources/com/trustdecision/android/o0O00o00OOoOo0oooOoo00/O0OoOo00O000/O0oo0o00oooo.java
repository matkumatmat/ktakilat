package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.lang3.CharEncoding;

public class O0oo0o00oooo {
    private static final Pattern o0O00o00OOoOo0oooOoo00 = Pattern.compile(o0Oo0OO00O0O000ooOO0("0d7418056c691f1a6a234c6b691f1b6b033a1a25691f1e6e60613a59613a4f0376700418056c691f1a6a234c6b691f1b6b033a1a25691f1e6e60613a59613a4f02504a4c5b", 17));
    private static final Map o0Oo0OO00O0O000ooOO0 = new ooooOO0OO0O0OOoo();

    public static String o0O00o00OOoOo0oooOoo00(String str) {
        return TextUtils.isEmpty(str) ? str : new StringBuilder(str).reverse().toString();
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
            byte b = (byte) (i ^ 19);
            byte b2 = (byte) (bArr[0] ^ 83);
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

    public static List o0Oo0OO00O0O000ooOO0(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (!(str == null || str.length() == 0)) {
            if (str2 == null || str2.length() == 0) {
                arrayList.add(str);
            } else if (str.equals(str2)) {
                return arrayList;
            } else {
                while (true) {
                    int indexOf = str.indexOf(str2);
                    if (indexOf == -1) {
                        break;
                    }
                    if (indexOf != 0) {
                        if (indexOf >= 1) {
                            arrayList.add(str.substring(0, indexOf));
                        }
                    }
                    str = str.substring(str2.length() + indexOf);
                }
                if (!o0Oo0OO00O0O000ooOO0(str)) {
                    arrayList.add(str);
                }
                return arrayList;
            }
        }
        return arrayList;
    }

    public static boolean o0Oo0OO00O0O000ooOO0(String str) {
        return str == null || "".equals(str.trim()) || str.length() == 0;
    }

    public static boolean o0Oo0OO00O0O000ooOO0(String... strArr) {
        if (strArr == null) {
            return true;
        }
        for (String str : strArr) {
            if (str != null && !"".equals(str) && str.length() > 0) {
                return false;
            }
        }
        return true;
    }
}
