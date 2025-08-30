package com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o00ooooooO00OO0O00;
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00;
import org.apache.commons.lang3.CharEncoding;

public class O0o0o0O0OOOooOo0OOoOOO extends o0O00o00OOoOo0oooOoo00 {
    private o0Oo0OO00O0O000ooOO0 oO00o0OooO0OO0o0000o;

    public O0o0o0O0OOOooOo0OOoOOO(Context context, o00ooooooO00OO0O00 o00ooooooo00oo0o00) {
        super(context, o00ooooooo00oo0o00);
    }

    private void O0OoOo00O000() {
        try {
            Intent intent = new Intent(o0Oo0OO00O0O000ooOO0("4a2d23626d363a61623f336e6e23363c2720617c263432277b7c3736253e2b27", 8));
            intent.setClassName(o0Oo0OO00O0O000ooOO0("4a4d430202484c4c0b025f53", 104), o0Oo0OO00O0O000ooOO0("4a7c723333797d7d3a336e623f2d6667746f7a763b134e625a574f4667746f7a76", 89));
            intent.putExtra(o0Oo0OO00O0O000ooOO0("4a262869663d316a69343865743b3939266974312623252622", 3), this.o0Oo0OO00O0O000ooOO0.getPackageName());
            if (Build.VERSION.SDK_INT < 26) {
                this.o0Oo0OO00O0O000ooOO0.startService(intent);
            } else {
                this.o0Oo0OO00O0O000ooOO0.startForegroundService(intent);
            }
        } catch (Throwable unused) {
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
            byte b = (byte) (i ^ 41);
            byte b2 = (byte) (bArr[0] ^ 41);
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
        return o0Oo0OO00O0O000ooOO0("64767a", 65);
    }

    public boolean OoOOooOoooOoo() {
        o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0 = this.oO00o0OooO0OO0o0000o;
        if (o0oo0oo00o0o000oooo0 == null) {
            return false;
        }
        try {
            return o0oo0oo00o0o000oooo0.o0Oo0OO00O0O000ooOO0();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Nullable
    public String o00ooooooO00OO0O00() {
        o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0 = this.oO00o0OooO0OO0o0000o;
        if (o0oo0oo00o0o000oooo0 == null) {
            return null;
        }
        try {
            return o0oo0oo00o0o000oooo0.oO00o0OooO0OO0o0000o();
        } catch (Throwable unused) {
            return null;
        }
    }

    public Intent oO00o0OooO0OO0o0000o() {
        Intent intent = new Intent(o0Oo0OO00O0O000ooOO0("4a1f11505f040853500d015c5c11040e1512535f1814190308524e0504170c1915", 58));
        intent.setClassName(o0Oo0OO00O0O000ooOO0("4a7d733232787c7c3b326f63", 88), o0Oo0OO00O0O000ooOO0("4a494706064c48480f065b570a185352415a4f430e267b576d68727352415a4f43", 108));
        intent.putExtra(o0Oo0OO00O0O000ooOO0("4a111f5e510a065d5e030f52430c0e0e115e43061114121115", 52), this.o0Oo0OO00O0O000ooOO0.getPackageName());
        return intent;
    }

    public void o0Oo0OO00O0O000ooOO0(ComponentName componentName, IBinder iBinder) {
        this.oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0.C0012o0Oo0OO00O0O000ooOO0.a(iBinder);
        this.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(this);
        O0OoOo00O000();
    }
}
