package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000;

import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0;
import com.trustdecision.android.shell.common.HelperJNI;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.apache.commons.lang3.CharEncoding;

public class O0oOO0ooO {
    private static final List O00OO0oOOooooO00000Oo = Arrays.asList(new Integer[]{126, 213, 121, 88, 72, 73, 70, 66, 145, 33, 207, 58, 123, 57, 25, 98, 87, 107, 128, 106, 132, 108, 64, 212, 47, 74, 127, 93, 22, 24, 220, 221});
    public static final String o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("2b565f554c4a5156", 123);
    public static final String o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("2c4c425d5c495151", 108);
    private static final List oO00o0OooO0OO0o0000o = Arrays.asList(new Integer[]{214, 10, 11, 12, 13, 67, 27, 69, 79, 90, 86, 91, 101, 102, 103, 206, 49, 36, 80, 50, 39, 199, 26, 92});

    private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 44);
            byte b2 = (byte) (bArr[0] ^ 79);
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

    public static void o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0, String str) throws IllegalAccessException {
        List list;
        String str2 = str;
        HashSet hashSet = new HashSet();
        boolean z = true;
        if (com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().ooooOO0OO0O0OOoo == 1) {
            hashSet.addAll(oO00o0OooO0OO0o0000o);
            list = O00OO0oOOooooO00000Oo;
        } else {
            list = oO00o0OooO0OO0o0000o;
        }
        hashSet.addAll(list);
        HelperJNI.o0Oo0OO00O0O000ooOO0(35, (Object) new Object[]{str2});
        boolean equals = o0Oo0OO00O0O000ooOO0("2b6b626871776c6b", 70).equals(str2);
        Field[] declaredFields = o0oo0oo00o0o000oooo0.getClass().getDeclaredFields();
        int length = declaredFields.length;
        Object obj = null;
        int i = 0;
        long j = 0;
        long j2 = 0;
        while (i < length) {
            Field field = declaredFields[i];
            Class cls = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.class;
            if (field.isAnnotationPresent(cls)) {
                field.setAccessible(z);
                com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo02 = (com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0) field.getAnnotation(cls);
                int o0Oo0OO00O0O000ooOO02 = o0oo0oo00o0o000oooo02 != null ? o0oo0oo00o0o000oooo02.o0Oo0OO00O0O000ooOO0() : 0;
                if (o0Oo0OO00O0O000ooOO02 >= 0) {
                    o0Oo0OO00O0O000ooOO0.C0015o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo03 = (o0Oo0OO00O0O000ooOO0.C0015o0Oo0OO00O0O000ooOO0) field.get(o0oo0oo00o0o000oooo0);
                    if (o0oo0oo00o0o000oooo03 != null) {
                        o0Oo0OO00O0O000ooOO0.C0015o0Oo0OO00O0O000ooOO0 o0Oo0OO00O0O000ooOO03 = o0Oo0OO00O0O000ooOO0.C0015o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0oo0oo00o0o000oooo03);
                        if (o0Oo0OO00O0O000ooOO02 == 51) {
                            Object obj2 = o0Oo0OO00O0O000ooOO03.o0Oo0OO00O0O000ooOO0;
                            if (obj2 instanceof Long) {
                                j2 = ((Long) obj2).longValue();
                                obj = o0Oo0OO00O0O000ooOO03.o0Oo0OO00O0O000ooOO0;
                            }
                        }
                        if (o0Oo0OO00O0O000ooOO02 == 42) {
                            Object obj3 = o0Oo0OO00O0O000ooOO03.o0Oo0OO00O0O000ooOO0;
                            if (obj3 instanceof Long) {
                                j = ((Long) obj3).longValue();
                            }
                        }
                        Object obj4 = o0Oo0OO00O0O000ooOO03.o0Oo0OO00O0O000ooOO0;
                        if (obj4 != null && !"".equals(obj4) && !o0Oo0OO00O0O000ooOO0("1419", 51).equals(o0Oo0OO00O0O000ooOO03.o0Oo0OO00O0O000ooOO0) && !o0Oo0OO00O0O000ooOO0("343c", 22).equals(o0Oo0OO00O0O000ooOO03.o0Oo0OO00O0O000ooOO0) && o0Oo0OO00O0O000ooOO03.O00OO0oOOooooO00000Oo) {
                            if (!equals) {
                                HelperJNI.o0Oo0OO00O0O000ooOO0(36, (Object) new Object[]{Integer.valueOf(o0Oo0OO00O0O000ooOO02), o0Oo0OO00O0O000ooOO03.o0Oo0OO00O0O000ooOO0});
                            } else if (!hashSet.contains(Integer.valueOf(o0Oo0OO00O0O000ooOO02))) {
                                HelperJNI.o0Oo0OO00O0O000ooOO0(36, (Object) new Object[]{Integer.valueOf(o0Oo0OO00O0O000ooOO02), o0Oo0OO00O0O000ooOO03.o0Oo0OO00O0O000ooOO0});
                            }
                        }
                    }
                    i++;
                    z = true;
                }
            }
            o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo04 = o0oo0oo00o0o000oooo0;
            i++;
            z = true;
        }
        if (!(j == 0 || obj == null)) {
            HelperJNI.o0Oo0OO00O0O000ooOO0(36, (Object) new Object[]{51, Long.valueOf(j2 ^ j)});
        }
        HelperJNI.o0Oo0OO00O0O000ooOO0(83, (Object) new Object[]{Boolean.valueOf(o0Oo0OO00O0O000ooOO0("2b373e342d2b3037", 26).equals(str2))});
    }
}
