package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.regex.Pattern;
import okio.Utf8;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.time.DateUtils;

public class OO000O0O0Oo {
    private static final String O00OO0oOOooooO00000Oo = o0Oo0OO00O0O000ooOO0("4b144d470901", 7);
    private static final String O0oOO0ooO = o0Oo0OO00O0O000ooOO0("4b6d34256c6a", 126);
    private static final String o00ooooooO00OO0O00 = o0Oo0OO00O0O000ooOO0("4b154c4e1603", 6);
    private static final String o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("4b1e4740405511", 13);
    private static final String o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("4b346d6a6a6f2326333f39", 39);
    private static final String oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0("4b346d6a6a7f3b20", 39);

    @Nullable
    public static int[] O00OO0oOOooooO00000Oo(Context context) {
        String o0O00o00OOoOo0oooOoo002 = O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(context, o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4b530a004e46", 64)), "");
        if (!o0O00o00OOoOo0oooOoo00(o0O00o00OOoOo0oooOoo002)) {
            return null;
        }
        String[] split = o0O00o00OOoOo0oooOoo002.split(o0Oo0OO00O0O000ooOO0("6320", 3));
        int length = split.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = Integer.parseInt(split[i]);
        }
        return iArr;
    }

    public static long O0oOO0ooO(Context context) {
        return O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(context, o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4b164f48485d1902", 5)), (long) DateUtils.MILLIS_PER_DAY);
    }

    public static boolean OO0000O0Ooo0OO000oo(Context context) {
        return o0Oo0OO00O0O000ooOO0((float) o00ooooooO00OO0O00(context));
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int o00ooooooO00OO0O00(android.content.Context r8) {
        /*
            java.lang.String r0 = "4b045d5a5a5f1316030f09"
            r1 = 23
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r1)
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0)
            java.lang.String r1 = ""
            java.lang.String r0 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00((android.content.Context) r8, (java.lang.String) r0, (java.lang.String) r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 == 0) goto L_0x001a
            return r2
        L_0x001a:
            java.lang.String r1 = "1b41"
            r3 = 66
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0((java.lang.String) r1, (int) r3)
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L_0x005d
            java.lang.String r1 = "1b30"
            r3 = 51
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0((java.lang.String) r1, (int) r3)
            int r1 = r0.indexOf(r1)
            int r3 = r1 + 2
            java.lang.String r3 = r0.substring(r3)
            java.lang.String r0 = r0.substring(r2, r1)
            r1 = 16
            long r0 = java.lang.Long.parseLong(r0, r1)     // Catch:{ Exception -> 0x004b }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x0049 }
            goto L_0x004e
        L_0x0049:
            goto L_0x004d
        L_0x004b:
            r0 = 0
        L_0x004d:
            r3 = 0
        L_0x004e:
            long r4 = java.lang.System.currentTimeMillis()
            long r6 = O0oOO0ooO(r8)
            long r4 = r4 - r0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x005c
            return r2
        L_0x005c:
            return r3
        L_0x005d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.OO000O0O0Oo.o00ooooooO00OO0O00(android.content.Context):int");
    }

    public static int o0O00o00OOoOo0oooOoo00(Context context) {
        return O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(context, o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4b1049581117", 3)), -1);
    }

    public static int o0Oo0OO00O0O000ooOO0(Context context) {
        return O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(context, o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4b045d5f0712", 23)), 1);
    }

    public static boolean oO00o0OooO0OO0o0000o(Context context) {
        o0Oo0OO00O0O000ooOO0 O00OO0oOOooooO00000Oo2 = o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo();
        int o0O00o00OOoOo0oooOoo002 = o0O00o00OOoOo0oooOoo00(context);
        return o0O00o00OOoOo0oooOoo002 == -1 ? O00OO0oOOooooO00000Oo2.O0oOoooo0o0o0oOo : (o0O00o00OOoOo0oooOoo002 == 1 || o0O00o00OOoOo0oooOoo002 == 0) ? o0O00o00OOoOo0oooOoo002 == 1 : O00OO0oOOooooO00000Oo2.O0oOoooo0o0o0oOo;
    }

    public static void o0O00o00OOoOo0oooOoo00(Context context, int i) {
        O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4b431a0b4244", 80)), i);
    }

    @NonNull
    private static String o0Oo0OO00O0O000ooOO0(String str) {
        o0Oo0OO00O0O000ooOO0 O00OO0oOOooooO00000Oo2 = o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo();
        return ba.r(ba.v(str), o0Oo0OO00O0O000ooOO0("12", 19), oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00(O00OO0oOOooooO00000Oo2.oO0OOO00 + o0Oo0OO00O0O000ooOO0("12", 43) + O00OO0oOOooooO00000Oo2.O0oOO0ooO));
    }

    public static void o0O00o00OOoOo0oooOoo00(Context context, long j) {
        O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4b60393e3e2b6f", 115)), j * DateUtils.MILLIS_PER_HOUR);
    }

    private static boolean o0O00o00OOoOo0oooOoo00(String str) {
        return Pattern.matches(o0Oo0OO00O0O000ooOO0("612725691e2671045227691e5e", 82), str);
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
            byte b = (byte) (i ^ 3);
            byte b2 = (byte) (bArr[0] ^ Utf8.REPLACEMENT_BYTE);
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

    public static void o0Oo0OO00O0O000ooOO0(Context context, int i) {
        O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4b31686a3227", 34)), i);
    }

    public static void o0Oo0OO00O0O000ooOO0(Context context, long j) {
        O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4b366f68687d3922", 37)), j * DateUtils.MILLIS_PER_MINUTE);
    }

    public static void o0Oo0OO00O0O000ooOO0(Context context, long j, int i) {
        O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4b50090e0e0b4742575b5d", 67)), String.format(Locale.US, o0Oo0OO00O0O000ooOO0("1a7574232262", 32), new Object[]{Long.toHexString(j), Integer.valueOf(i)}));
    }

    public static void o0Oo0OO00O0O000ooOO0(Context context, String str) {
        String o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4b5e070d434b", 77));
        if (TextUtils.isEmpty(str)) {
            str = "";
        } else if (!o0O00o00OOoOo0oooOoo00(str)) {
            return;
        }
        O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO02, str);
    }

    private static boolean o0Oo0OO00O0O000ooOO0(float f) {
        return ((float) new SecureRandom().nextInt(100)) < f;
    }
}
