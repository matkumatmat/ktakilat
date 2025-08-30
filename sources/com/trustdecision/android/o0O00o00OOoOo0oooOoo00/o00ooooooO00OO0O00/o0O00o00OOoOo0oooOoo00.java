package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o00ooooooO00OO0O00;

import android.text.TextUtils;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.OO0oo0ooOO00OOO;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.CharEncoding;

class o0O00o00OOoOo0oooOoo00 implements o0Oo0OO00O0O000ooOO0.C0021o0Oo0OO00O0O000ooOO0 {
    private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 40);
            byte b2 = (byte) (bArr[0] ^ 87);
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

    public void o0Oo0OO00O0O000ooOO0(Map map) {
        if (map != null) {
            try {
                List list = (List) map.get(o0Oo0OO00O0O000ooOO0("043e19516624080c0a04", 32));
                if (list != null && list.size() > 0) {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        String str = (String) list.get(i);
                        if (str.contains(o0Oo0OO00O0O000ooOO0("0f4d5c4034", 101))) {
                            String[] split = str.split(o0Oo0OO00O0O000ooOO0("6c", 75));
                            int length = split.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= length) {
                                    break;
                                }
                                String str2 = split[i2];
                                if (str2.startsWith(o0Oo0OO00O0O000ooOO0("0f6f7e62", 71))) {
                                    String substring = str2.substring(5, str2.length());
                                    if (!TextUtils.isEmpty(substring)) {
                                        OO0oo0ooOO00OOO.o0Oo0OO00O0O000ooOO0().o0Oo0OO00O0O000ooOO0(substring);
                                        break;
                                    }
                                }
                                i2++;
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
