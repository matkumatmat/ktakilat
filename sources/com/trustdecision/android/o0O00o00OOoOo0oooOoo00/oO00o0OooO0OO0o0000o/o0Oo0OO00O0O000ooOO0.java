package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.base.Ascii;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.CharUtils;

public class o0Oo0OO00O0O000ooOO0 {
    private static final char[] O00OO0oOOooooO00000Oo = {12, '-', 7, '!', ':', 19, 4, '>', 27, '2', 14, '\'', 8, '7', 23, '<'};
    private static final char[] O0oOO0ooO = {3, '/', 21, '8', 9, '\"', '=', 18, '*', 25, '2', CharUtils.CR, '%', 6, ';', 28};
    private static final String o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("6963702977", 20);
    private static final String o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("5d6d7f", 31);
    private static final char[] oO00o0OooO0OO0o0000o = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};

    @NonNull
    public static String o0O00o00OOoOo0oooOoo00() {
        int length = O0oOO0ooO.length;
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = oO00o0OooO0OO0o0000o[O0oOO0ooO[i]];
        }
        return new String(cArr);
    }

    @NonNull
    public static String o0Oo0OO00O0O000ooOO0() {
        int length = O00OO0oOOooooO00000Oo.length;
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = oO00o0OooO0OO0o0000o[O00OO0oOOooooO00000Oo[i]];
        }
        return new String(cArr);
    }

    @Nullable
    public static byte[] o0O00o00OOoOo0oooOoo00(byte[] bArr, String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), o0Oo0OO00O0O000ooOO0("5d4654", 52));
            Cipher instance = Cipher.getInstance(o0Oo0OO00O0O000ooOO0("5d716309197474190a6e7d65131044707578727c", 3));
            instance.init(2, secretKeySpec, new IvParameterSpec(str2.getBytes()));
            return instance.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
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
            byte b = (byte) (i ^ 118);
            byte b2 = (byte) (bArr[0] ^ Ascii.FS);
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

    public static byte[] o0O00o00OOoOo0oooOoo00(byte[] bArr, byte[] bArr2) throws Exception {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, o0Oo0OO00O0O000ooOO0("5d6b79", 25));
        Cipher instance = Cipher.getInstance(o0Oo0OO00O0O000ooOO0("5d180a60761a1d716307140c7a792d191c111b15", 106));
        instance.init(2, secretKeySpec);
        return instance.doFinal(oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o(new String(bArr, o0Oo0OO00O0O000ooOO0("695d4e1749", 42))));
    }

    public static String o0Oo0OO00O0O000ooOO0(String str, String str2) throws Exception {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        byte[] decode = Base64.decode(str, 0);
        byte[] bytes = str2.getBytes(o0Oo0OO00O0O000ooOO0("696e7d247a", 25));
        if (decode == null || bytes == null) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, o0Oo0OO00O0O000ooOO0("5d4351", 49));
        Cipher instance = Cipher.getInstance(o0Oo0OO00O0O000ooOO0("5d2f3d57412d2a465430233b4d4e1a2e2b262c22", 93));
        instance.init(2, secretKeySpec);
        return new String(instance.doFinal(decode), o0Oo0OO00O0O000ooOO0("69293a633d", 94));
    }

    @Nullable
    public static byte[] o0Oo0OO00O0O000ooOO0(byte[] bArr, String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), o0Oo0OO00O0O000ooOO0("5d1f0d", 109));
            Cipher instance = Cipher.getInstance(o0Oo0OO00O0O000ooOO0("5d37254f5f32325f4c283b2355560236333e343a", 69));
            instance.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
            return instance.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] o0Oo0OO00O0O000ooOO0(byte[] bArr, byte[] bArr2) {
        if (!(bArr == null || bArr2 == null)) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, o0Oo0OO00O0O000ooOO0("5d6775", 21));
                Cipher instance = Cipher.getInstance(o0Oo0OO00O0O000ooOO0("5d6072180e6265091b7f6c74020155616469636d", 18));
                instance.init(1, secretKeySpec);
                return oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00(instance.doFinal(bArr)).getBytes(o0Oo0OO00O0O000ooOO0("6967742d73", 16));
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
