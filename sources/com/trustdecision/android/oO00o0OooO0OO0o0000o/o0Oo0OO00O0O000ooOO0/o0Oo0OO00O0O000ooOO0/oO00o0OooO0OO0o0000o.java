package com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;

import android.app.KeyguardManager;
import android.content.Context;
import androidx.annotation.Nullable;
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o00ooooooO00OO0O00;
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.commons.lang3.CharEncoding;

public class oO00o0OooO0OO0o0000o extends o0Oo0OO00O0O000ooOO0 {
    private final KeyguardManager oO00o0OooO0OO0o0000o;

    public oO00o0OooO0OO0o0000o(Context context, o00ooooooO00OO0O00 o00ooooooo00oo0o00) {
        super(context, o00ooooooo00oo0o00);
        this.oO00o0OooO0OO0o0000o = (KeyguardManager) context.getSystemService(o0Oo0OO00O0O000ooOO0("296d7f7d71777075", 49));
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
            byte b = (byte) (i ^ 82);
            byte b2 = (byte) (bArr[0] ^ 66);
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

    public String OO0000O0Ooo0OO000oo() {
        return o0Oo0OO00O0O000ooOO0("012905191301", 87);
    }

    public boolean OoOOooOoooOoo() {
        KeyguardManager keyguardManager = this.oO00o0OooO0OO0o0000o;
        if (keyguardManager == null) {
            return false;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod(o0Oo0OO00O0O000ooOO0("2b0e343211140b09120515", 70), (Class[]) null).invoke(this.oO00o0OooO0OO0o0000o, (Object[]) null);
            if (invoke == null) {
                return false;
            }
            return ((Boolean) invoke).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Nullable
    public String o00ooooooO00OO0O00() {
        KeyguardManager keyguardManager = this.oO00o0OooO0OO0o0000o;
        if (keyguardManager != null) {
            try {
                Object invoke = keyguardManager.getClass().getDeclaredMethod(o0Oo0OO00O0O000ooOO0("2d0912110c03252a0c09", 86), (Class[]) null).invoke(this.oO00o0OooO0OO0o0000o, (Object[]) null);
                if (invoke == null) {
                    return null;
                }
                return invoke.toString();
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public void o0Oo0OO00O0O000ooOO0(ThreadPoolExecutor threadPoolExecutor) {
        this.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(this);
    }
}
