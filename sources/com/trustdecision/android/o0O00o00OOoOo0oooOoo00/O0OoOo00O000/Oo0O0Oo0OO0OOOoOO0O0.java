package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000;

import android.content.Context;
import android.text.TextUtils;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
import java.io.File;
import org.apache.commons.lang3.CharEncoding;

public class Oo0O0Oo0OO0OOOoOO0O0 {
    private static final String O00OO0oOOooooO00000Oo = o0Oo0OO00O0O000ooOO0("5c2e2f1103112f29031f0e383a", 1);
    private static final String O0oOO0ooO = o0Oo0OO00O0O000ooOO0("5c77754b5a48767d5a4b576176", 88);
    private static final String OO0000O0Ooo0OO000oo = o0Oo0OO00O0O000ooOO0("5c383a04150739321504182e2c", 23);
    private static final String OoOOooOoooOoo = o0Oo0OO00O0O000ooOO0("5c353709180a34321804152321", 26);
    private static final String o00ooooooO00OO0O00 = o0Oo0OO00O0O000ooOO0("5c545668796b55537965744255", 123);
    private static final String o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("5c3f3e0012003e38120e1f293e", 16);
    private static final String o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("5c5b5a6476645a5176677b4d5a", 116);
    private static final String oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0("5c2726180a18262d0a1b073133", 8);

    public static String o0O00o00OOoOo0oooOoo00(String str) {
        o0Oo0OO00O0O000ooOO0 O00OO0oOOooooO00000Oo2 = o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo();
        StringBuilder v = ba.v(str);
        v.append(o0Oo0OO00O0O000ooOO0("03", 55));
        v.append(oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00(O00OO0oOOooooO00000Oo2.oO0OOO00 + o0Oo0OO00O0O000ooOO0("03", 69) + O00OO0oOOooooO00000Oo2.O0oOO0ooO));
        return v.toString();
    }

    public static String o0Oo0OO00O0O000ooOO0(String str) {
        String o0Oo0OO00O0O000ooOO02 = o0ooOoo0Oo00oOOO.o0Oo0OO00O0O000ooOO0();
        if (o0Oo0OO00O0O000ooOO0("5e79687a", 106).equals(o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().o0Oo0OO00O0O000ooOO0)) {
            StringBuilder v = ba.v(str);
            v.append(o0Oo0OO00O0O000ooOO0("5e0a1b09", 25));
            str = v.toString();
        }
        if (o0Oo0OO00O0O000ooOO02 == null) {
            return str;
        }
        StringBuilder v2 = ba.v(str);
        v2.append(o0Oo0OO00O0O000ooOO0("03", 27));
        v2.append(oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO02));
        return v2.toString();
    }

    public static String oO00o0OooO0OO0o0000o(String str) {
        o0Oo0OO00O0O000ooOO0 O00OO0oOOooooO00000Oo2 = o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo();
        StringBuilder v = ba.v(str);
        v.append(o0Oo0OO00O0O000ooOO0("03", 37));
        v.append(oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00(O00OO0oOOooooO00000Oo2.oO0OOO00 + o0Oo0OO00O0O000ooOO0("03", 70) + O00OO0oOOooooO00000Oo2.O0oOO0ooO + o0Oo0OO00O0O000ooOO0("03", 82) + o0ooOoo0Oo00oOOO.o0Oo0OO00O0O000ooOO0()));
        return v.toString();
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
            byte b = (byte) (i ^ 2);
            byte b2 = (byte) (bArr[0] ^ 46);
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

    public static void o0Oo0OO00O0O000ooOO0(Context context) {
        String o0O00o00OOoOo0oooOoo002 = o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0("5a1c45551101", 14));
        String oO00o0OooO0OO0o0000o2 = oO00o0OooO0OO0o0000o(o0Oo0OO00O0O000ooOO0("5a5900105444", 75));
        if (!o0O00o00OOoOo0oooOoo002.equals(oO00o0OooO0OO0o0000o2)) {
            String o0O00o00OOoOo0oooOoo003 = O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(context, o0O00o00OOoOo0oooOoo002, "");
            String o0O00o00OOoOo0oooOoo004 = O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(context, oO00o0OooO0OO0o0000o2, "");
            if (!TextUtils.isEmpty(o0O00o00OOoOo0oooOoo003)) {
                if (TextUtils.isEmpty(o0O00o00OOoOo0oooOoo004)) {
                    O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, oO00o0OooO0OO0o0000o2, o0O00o00OOoOo0oooOoo003);
                }
                O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, o0O00o00OOoOo0oooOoo002);
            }
        }
    }

    public static void o0Oo0OO00O0O000ooOO0(Context context, String str) {
        String o0Oo0OO00O0O000ooOO02;
        String str2;
        int i;
        if (o0Oo0OO00O0O000ooOO0("5d627062", 114).equals(o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().o0Oo0OO00O0O000ooOO0)) {
            o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0("5c13122c3e2c12193e2f330512", 60);
            str2 = "5c00013f2d3f01072d31201601";
            i = 47;
        } else {
            o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0("5c3f3d0312003e3512031f293e", 16);
            str2 = "5c7c7e4051437d7b514d5c6a7d";
            i = 83;
        }
        String o0Oo0OO00O0O000ooOO03 = o0Oo0OO00O0O000ooOO0(str2, i);
        String o0Oo0OO00O0O000ooOO04 = O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0("484079675042585c4a", 73), str, "");
        if (TextUtils.isEmpty(o0Oo0OO00O0O000ooOO04)) {
            String o0Oo0OO00O0O000ooOO05 = o0ooOoo0Oo00oOOO.o0Oo0OO00O0O000ooOO0();
            if (o0Oo0OO00O0O000ooOO05 != null) {
                StringBuilder v = ba.v(str);
                v.append(o0Oo0OO00O0O000ooOO0("03", 100));
                v.append(oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO05));
                o0Oo0OO00O0O000ooOO04 = O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0("48566f7146544e4a5c", 95), v.toString(), "");
            }
            if (TextUtils.isEmpty(o0Oo0OO00O0O000ooOO04)) {
                return;
            }
        }
        if (o0Oo0OO00O0O000ooOO0("7a0b0007171b1f19171716", 25).equals(str)) {
            if (o0Oo0OO00O0O000ooOO0("1f", 88).equals(O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(context, o0Oo0OO00O0O000ooOO02, ""))) {
                return;
            }
        }
        if (o0Oo0OO00O0O000ooOO0("5a653c3b7a70797e6f2c31783c6b", 119).equals(str)) {
            if (o0Oo0OO00O0O000ooOO0("1f", 108).equals(O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(context, o0Oo0OO00O0O000ooOO03, ""))) {
                return;
            }
        }
        String o0Oo0OO00O0O000ooOO06 = o0Oo0OO00O0O000ooOO0(str);
        if (!str.equals(o0Oo0OO00O0O000ooOO06) && TextUtils.isEmpty(O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(context, o0Oo0OO00O0O000ooOO06, ""))) {
            O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO06, o0Oo0OO00O0O000ooOO04);
            if (o0Oo0OO00O0O000ooOO0("7a08030414181c1a141415", 26).equals(str)) {
                O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO02, o0Oo0OO00O0O000ooOO0("1f", 38));
            }
            if (o0Oo0OO00O0O000ooOO0("5a683136777d747362213c753166", 122).equals(str)) {
                O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO03, o0Oo0OO00O0O000ooOO0("1f", 110));
            }
        }
    }

    public static void o0Oo0OO00O0O000ooOO0(Context context, String str, String str2) {
        String o0Oo0OO00O0O000ooOO02;
        String str3;
        int i;
        String o0Oo0OO00O0O000ooOO03;
        File file = new File(str);
        if (o0Oo0OO00O0O000ooOO0("5d0d1f0d", 29).equals(o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().o0Oo0OO00O0O000ooOO0)) {
            o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0("5c33320c1e0c32391e0f132527", 28);
            str3 = "5c6e6f5143516f69435f4e787a";
            i = 65;
        } else {
            o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0("5c555769786a545f7869754341", 122);
            str3 = "5c282a140517292f0519083e3c";
            i = 7;
        }
        String o0Oo0OO00O0O000ooOO04 = o0Oo0OO00O0O000ooOO0(str3, i);
        if (!file.exists() && (o0Oo0OO00O0O000ooOO03 = o0ooOoo0Oo00oOOO.o0Oo0OO00O0O000ooOO0()) != null) {
            StringBuilder v = ba.v(str);
            v.append(o0Oo0OO00O0O000ooOO0("03", 94));
            v.append(oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO03));
            file = new File(v.toString());
            if (!file.exists()) {
                return;
            }
        }
        String o0Oo0OO00O0O000ooOO05 = o0Oo0OO00O0O000ooOO0(file.getName());
        if (!file.getName().equals(o0Oo0OO00O0O000ooOO05)) {
            if (o0Oo0OO00O0O000ooOO0("7a040f0818141016181819", 22).equals(str2)) {
                if (o0Oo0OO00O0O000ooOO0("1f", 45).equals(O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(context, o0Oo0OO00O0O000ooOO02, ""))) {
                    return;
                }
            }
            if (o0Oo0OO00O0O000ooOO0("5a570e0948424b4c5d1e034a0e59", 69).equals(str2)) {
                if (o0Oo0OO00O0O000ooOO0("1f", 119).equals(O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(context, o0Oo0OO00O0O000ooOO04, ""))) {
                    return;
                }
            }
            File file2 = new File(file.getParent(), o0Oo0OO00O0O000ooOO05);
            if (file.exists() && !file2.exists() && o0oOO0oO00OoO0.o0Oo0OO00O0O000ooOO0(file, file2)) {
                if (o0Oo0OO00O0O000ooOO0("7a767d7a6a6662646a6a6b", 100).equals(str2)) {
                    O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO02, o0Oo0OO00O0O000ooOO0("1f", 23));
                }
                if (o0Oo0OO00O0O000ooOO0("5a4d141352585156470419501443", 95).equals(str2)) {
                    O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO04, o0Oo0OO00O0O000ooOO0("1f", 50));
                }
            }
        }
    }
}
