package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o00O0O0o00o;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOOO0oO0O0Oo0;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
import com.trustdecision.android.shell.common.HelperJNI;
import com.trustdecision.android.shell.inter.InvokeHandler;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.CharEncoding;

public class o00ooooooO00OO0O00 {
    public static final String[] O00OO0oOOooooO00000Oo;
    private static final HashSet O0OoOo00O000 = new HashSet();
    public static final String[] O0oOO0ooO;
    public static final String[] OO0000O0Ooo0OO000oo;
    private static boolean OoOOooOoooOoo;
    public static final String[] o00ooooooO00OO0O00;
    public static final String[] o0O00o00OOoOo0oooOoo00;
    public static final String[] o0Oo0OO00O0O000ooOO0;
    public static final String[] oO00o0OooO0OO0o0000o;

    static {
        String[] strArr = {o0Oo0OO00O0O000ooOO0("3b7d6e48537e7f74796862797e58587776", 5), o0Oo0OO00O0O000ooOO0("3b677455496e765c426d6c", 31), o0Oo0OO00O0O000ooOO0("3507392312123136121e13141c", 103), o0Oo0OO00O0O000ooOO0("3b021127001a0d", 122)};
        o0Oo0OO00O0O000ooOO0 = strArr;
        String[] strArr2 = {o0Oo0OO00O0O000ooOO0("3b7f6c59457a7c765b51676667", 7), o0Oo0OO00O0O000ooOO0("3b7e6d5b5a6b6d6c6d67777b6b4751", 6), o0Oo0OO00O0O000ooOO0("3b1a0928390b07121e3435", 98), o0Oo0OO00O0O000ooOO0("3b5546756e515d517f7b5f52756c4f585040", 45), o0Oo0OO00O0O000ooOO0("3b697a51407a6873767243477170716d605b5177", 17), o0Oo0OO00O0O000ooOO0("3b22311a0b3123383d39041f353733353b3d1c0f2c28", 90), o0Oo0OO00O0O000ooOO0("3b34270c1d27352e2b2f1209232125232d2b", 76), o0Oo0OO00O0O000ooOO0("3b7566504d735548626064626c6a4b587b7f", 13), o0Oo0OO00O0O000ooOO0("3b5340756956505a607c5844", 43), o0Oo0OO00O0O000ooOO0("3b796a41506a786366624456726e", 1), o0Oo0OO00O0O000ooOO0("3b617254456a6343406f61767e6562", 25), o0Oo0OO00O0O000ooOO0("3b495a7e664b646d424b6e6c4342", 49), o0Oo0OO00O0O000ooOO0("3b5241776a546e66474b585d726b485f5747", 42)};
        o0O00o00OOoOo0oooOoo00 = strArr2;
        String[] strArr3 = {o0Oo0OO00O0O000ooOO0("3b425166675b404747497375525858", 58)};
        oO00o0OooO0OO0o0000o = strArr3;
        String[] strArr4 = {o0Oo0OO00O0O000ooOO0("3b70634750656f6d61595963716a6f6b50557a7b", 8)};
        O00OO0oOOooooO00000Oo = strArr4;
        String[] strArr5 = {o0Oo0OO00O0O000ooOO0("3b57447164575d5f535779725d5c", 47), o0Oo0OO00O0O000ooOO0("3b697a4f5a6963616d69474c636257516562645e4d6c7b7d", 17)};
        O0oOO0ooO = strArr5;
        String[] strArr6 = {o0Oo0OO00O0O000ooOO0("3f3d2b32292627", 84), o0Oo0OO00O0O000ooOO0("1e0c3b32333922393e0b072733263335", 88)};
        o00ooooooO00OO0O00 = strArr6;
        String[] strArr7 = {o0Oo0OO00O0O000ooOO0("312a24201c1b2b242a3d352e29", 82), o0Oo0OO00O0O000ooOO0("3d14172c2b1a1e121f1810", 107), o0Oo0OO00O0O000ooOO0("2f757472656e5458757e6b6a797f6e7365", 31), o0Oo0OO00O0O000ooOO0("3d111408031813252813", 100), o0Oo0OO00O0O000ooOO0("384042465558596a77465f44406a7349505d464a", 59)};
        OO0000O0Ooo0OO000oo = strArr7;
        o0Oo0OO00O0O000ooOO0(strArr);
        o0Oo0OO00O0O000ooOO0(strArr2);
        o0Oo0OO00O0O000ooOO0(strArr3);
        o0Oo0OO00O0O000ooOO0(strArr4);
        o0Oo0OO00O0O000ooOO0(strArr5);
        o0Oo0OO00O0O000ooOO0(strArr6);
        o0Oo0OO00O0O000ooOO0(strArr7);
    }

    public static Object O00OO0oOOooooO00000Oo(String str, InvokeHandler invokeHandler) {
        return o0Oo0OO00O0O000ooOO0(O0oOO0ooO, str, invokeHandler);
    }

    public static Object O0oOO0ooO(String str, InvokeHandler invokeHandler) {
        return o0Oo0OO00O0O000ooOO0(o00ooooooO00OO0O00, str, invokeHandler);
    }

    public static Object o0O00o00OOoOo0oooOoo00(String str, InvokeHandler invokeHandler) {
        return o0Oo0OO00O0O000ooOO0(o0O00o00OOoOo0oooOoo00, str, invokeHandler);
    }

    public static Object o0Oo0OO00O0O000ooOO0(String str) {
        Object o0Oo0OO00O0O000ooOO02;
        if (!TextUtils.isEmpty(str) && (o0Oo0OO00O0O000ooOO02 = HelperJNI.o0Oo0OO00O0O000ooOO0(49, (Object) new Object[]{str})) != null) {
            return o0Oo0OO00O0O000ooOO02;
        }
        return null;
    }

    public static Object oO00o0OooO0OO0o0000o(String str, InvokeHandler invokeHandler) {
        return o0Oo0OO00O0O000ooOO0(O00OO0oOOooooO00000Oo, str, invokeHandler);
    }

    public static Object o0Oo0OO00O0O000ooOO0(String str, InvokeHandler invokeHandler) {
        return o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0, str, invokeHandler);
    }

    public static Object o0Oo0OO00O0O000ooOO0(String[] strArr, String str, InvokeHandler invokeHandler) {
        Object o0Oo0OO00O0O000ooOO02;
        if (!o0Oo0OO00O0O000ooOO0(strArr, str)) {
            return null;
        }
        Class<InvokeHandler> cls = InvokeHandler.class;
        Method[] methods = cls.getMethods();
        if (methods.length <= 0 || TextUtils.isEmpty(str) || invokeHandler == null || (o0Oo0OO00O0O000ooOO02 = HelperJNI.o0Oo0OO00O0O000ooOO0(43, (Object) new Object[]{str, invokeHandler, cls, methods[0].getName()})) == null) {
            return null;
        }
        return o0Oo0OO00O0O000ooOO02;
    }

    public static synchronized String o0Oo0OO00O0O000ooOO0(Context context, String str) {
        synchronized (o00ooooooO00OO0O00.class) {
            if (OoOOooOoooOoo) {
                String str2 = (String) o0Oo0OO00O0O000ooOO0(str);
                return str2;
            }
            HashSet hashSet = new HashSet();
            hashSet.add(Settings.Secure.CONTENT_URI);
            hashSet.add(Settings.System.CONTENT_URI);
            hashSet.add(Settings.Global.CONTENT_URI);
            Iterator it = hashSet.iterator();
            HashSet hashSet2 = new HashSet();
            while (it.hasNext()) {
                Uri uri = (Uri) it.next();
                ContentResolver contentResolver = context.getContentResolver();
                int i = 0;
                while (true) {
                    String[] strArr = OO0000O0Ooo0OO000oo;
                    if (i >= strArr.length) {
                        break;
                    }
                    Cursor cursor = null;
                    try {
                        String str3 = strArr[i];
                        if (o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().Oo0oOo00ooOo0OOO0oO0 || !o0Oo0OO00O0O000ooOO0("3d57524e455e55636e55", 34).equals(str3)) {
                            if (!hashSet2.contains(str3)) {
                                String[] strArr2 = {str3};
                                cursor = contentResolver.query(uri, new String[]{o0Oo0OO00O0O000ooOO0("32363531", 67), o0Oo0OO00O0O000ooOO0("2a011b0f06", 108)}, o0Oo0OO00O0O000ooOO0("3223202469313133", 86), strArr2, (String) null);
                                if (cursor != null) {
                                    while (cursor.moveToNext()) {
                                        String string = cursor.getString(cursor.getColumnIndex(o0Oo0OO00O0O000ooOO0("32606367", 21)));
                                        String string2 = cursor.getString(cursor.getColumnIndex(o0Oo0OO00O0O000ooOO0("2a746e7a73", 25)));
                                        if (!TextUtils.isEmpty(string2)) {
                                            hashSet2.add(string);
                                            o0Oo0OO00O0O000ooOO0(string, (Object) string2);
                                        }
                                    }
                                }
                                if (cursor == null) {
                                }
                                try {
                                    cursor.close();
                                } catch (Throwable unused) {
                                }
                            }
                            i++;
                        } else {
                            i++;
                        }
                    } catch (Throwable unused2) {
                        if (0 == 0) {
                        }
                    }
                }
                OoOOooOoooOoo = true;
            }
            String str4 = (String) o0Oo0OO00O0O000ooOO0(str);
            return str4;
        }
    }

    public static String o0Oo0OO00O0O000ooOO0(Context context, String str, String str2) {
        String o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0(context, str);
        return o0Oo0OO00O0O000ooOO02 == null ? str2 : o0Oo0OO00O0O000ooOO02;
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
            byte b = (byte) (i ^ 122);
            byte b2 = (byte) (bArr[0] ^ 92);
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

    public static void o0Oo0OO00O0O000ooOO0() {
        HelperJNI.o0Oo0OO00O0O000ooOO0(44, (Object) null);
        OoOOooOoooOoo = false;
        oOOO0oO0O0Oo0.o0Oo0OO00O0O000ooOO0();
        List<com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o00ooooooO00OO0O00> o0Oo0OO00O0O000ooOO02 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0();
        if (o0Oo0OO00O0O000ooOO02 != null) {
            for (com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o00ooooooO00OO0O00 o0Oo0OO00O0O000ooOO03 : o0Oo0OO00O0O000ooOO02) {
                o0Oo0OO00O0O000ooOO03.o0Oo0OO00O0O000ooOO0();
            }
        }
        o00O0O0o00o.o0Oo0OO00O0O000ooOO0();
    }

    private static void o0Oo0OO00O0O000ooOO0(String[] strArr) {
        for (String add : strArr) {
            O0OoOo00O000.add(add);
        }
    }

    public static boolean o0Oo0OO00O0O000ooOO0(String str, Object obj) {
        Object o0Oo0OO00O0O000ooOO02;
        if (TextUtils.isEmpty(str) || obj == null || (o0Oo0OO00O0O000ooOO02 = HelperJNI.o0Oo0OO00O0O000ooOO0(48, (Object) new Object[]{str, obj})) == null) {
            return false;
        }
        return ((Boolean) o0Oo0OO00O0O000ooOO02).booleanValue();
    }

    private static boolean o0Oo0OO00O0O000ooOO0(String[] strArr, String str) {
        for (String equals : strArr) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
