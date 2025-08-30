package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.common.base.Ascii;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo;
import com.trustdecision.android.shell.FMAgent;
import com.trustdecision.android.shell.common.HelperJNI;
import com.trustdecision.android.shell.common.O0oOO0ooO;
import com.trustdecision.android.shell.common.o00ooooooO00OO0O00;
import com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0;
import java.util.Locale;
import org.apache.commons.lang3.CharEncoding;

public class o0O00o00OOoOo0oooOoo00 {
    private static volatile o0O00o00OOoOo0oooOoo00 o0O00o00OOoOo0oooOoo00;
    private volatile o0Oo0OO00O0O000ooOO0 o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
    private final Object oO00o0OooO0OO0o0000o = new Object();

    public enum o0Oo0OO00O0O000ooOO0 {
        o0Oo0OO00O0O000ooOO0,
        o0O00o00OOoOo0oooOoo00,
        oO00o0OooO0OO0o0000o,
        O00OO0oOOooooO00000Oo,
        O0oOO0ooO,
        o00ooooooO00OO0O00,
        OO0000O0Ooo0OO000oo,
        OoOOooOoooOoo;

        private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
            try {
                int length = str.length() / 2;
                char[] charArray = str.toCharArray();
                byte[] bArr = new byte[length];
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = i2 * 2;
                    bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
                }
                byte b = (byte) (i ^ 36);
                byte b2 = (byte) (bArr[0] ^ 60);
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

    private o0O00o00OOoOo0oooOoo00() {
    }

    private boolean OO0000O0Ooo0OO000oo(Context context) {
        String oO00o0OooO0OO0o0000o2 = oO00o0OooO0OO0o0000o(context);
        if (TextUtils.isEmpty(oO00o0OooO0OO0o0000o2) || !oO00o0OooO0OO0o0000o2.contains(o0Oo0OO00O0O000ooOO0("302d", 67))) {
            return true;
        }
        return System.currentTimeMillis() - O0oOO0ooO(context) > 7200000;
    }

    public static o0O00o00OOoOo0oooOoo00 o0Oo0OO00O0O000ooOO0() {
        if (o0O00o00OOoOo0oooOoo00 == null) {
            synchronized (o0O00o00OOoOo0oooOoo00.class) {
                try {
                    if (o0O00o00OOoOo0oooOoo00 == null) {
                        o0O00o00OOoOo0oooOoo00 = new o0O00o00OOoOo0oooOoo00();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return o0O00o00OOoOo0oooOoo00;
    }

    public String O00OO0oOOooooO00000Oo(Context context) {
        String oO00o0OooO0OO0o0000o2 = oO00o0OooO0OO0o0000o(context);
        return (TextUtils.isEmpty(oO00o0OooO0OO0o0000o2) || !oO00o0OooO0OO0o0000o2.contains(o0Oo0OO00O0O000ooOO0("305b", 53))) ? "" : oO00o0OooO0OO0o0000o2.substring(0, oO00o0OooO0OO0o0000o2.indexOf(o0Oo0OO00O0O000ooOO0("304d", 35)));
    }

    public long O0oOO0ooO(Context context) {
        String oO00o0OooO0OO0o0000o2 = oO00o0OooO0OO0o0000o(context);
        if (TextUtils.isEmpty(oO00o0OooO0OO0o0000o2) || !oO00o0OooO0OO0o0000o2.contains(o0Oo0OO00O0O000ooOO0("3052", 60))) {
            return 0;
        }
        try {
            return Long.parseLong(oO00o0OooO0OO0o0000o2.substring(oO00o0OooO0OO0o0000o2.indexOf(o0Oo0OO00O0O000ooOO0("3012", 124)) + 2));
        } catch (Throwable unused) {
            return 0;
        }
    }

    public void o00ooooooO00OO0O00(Context context) {
        o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o oo00o0oooo0oo0o0000o;
        o0Oo0OO00O0O000ooOO0.C0025o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0;
        if (this.o0Oo0OO00O0O000ooOO0.equals(o0Oo0OO00O0O000ooOO0.O0oOO0ooO)) {
            oo00o0oooo0oo0o0000o = o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.O0oo0o00oooo;
            o0oo0oo00o0o000oooo0 = o0Oo0OO00O0O000ooOO0.C0025o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
        } else if (this.o0Oo0OO00O0O000ooOO0.equals(o0Oo0OO00O0O000ooOO0.OO0000O0Ooo0OO000oo)) {
            oo00o0oooo0oo0o0000o = o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.O0oOoo0oOo;
            o0oo0oo00o0o000oooo0 = o0Oo0OO00O0O000ooOO0.C0025o0Oo0OO00O0O000ooOO0.OoOOooOoooOoo;
        } else if (this.o0Oo0OO00O0O000ooOO0.equals(o0Oo0OO00O0O000ooOO0.o00ooooooO00OO0O00)) {
            oo00o0oooo0oo0o0000o = o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.OOOOO0o0ooo00oOo0;
            o0oo0oo00o0o000oooo0 = o0Oo0OO00O0O000ooOO0.C0025o0Oo0OO00O0O000ooOO0.O0oOO0ooO;
        } else if (this.o0Oo0OO00O0O000ooOO0.equals(o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo)) {
            o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o oo00o0oooo0oo0o0000o2 = o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.ooooOO0OO0O0OOoo;
            o0Oo0OO00O0O000ooOO0.C0025o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo02 = o0Oo0OO00O0O000ooOO0.C0025o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo;
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(oo00o0oooo0oo0o0000o2, o0oo0oo00o0o000oooo02.o0Oo0OO00O0O000ooOO0());
            if (context != null && o0ooOoo0Oo00oOOO.o0Oo0OO00O0O000ooOO0(context)) {
                throw new IllegalArgumentException(o0oo0oo00o0o000oooo02.o0Oo0OO00O0O000ooOO0());
            }
            return;
        } else if (this.o0Oo0OO00O0O000ooOO0.equals(o0Oo0OO00O0O000ooOO0.OoOOooOoooOoo)) {
            o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o oo00o0oooo0oo0o0000o3 = o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.O0oo0OOOOoO;
            o0Oo0OO00O0O000ooOO0.C0025o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo03 = o0Oo0OO00O0O000ooOO0.C0025o0Oo0OO00O0O000ooOO0.OO0000O0Ooo0OO000oo;
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(oo00o0oooo0oo0o0000o3, o0oo0oo00o0o000oooo03.o0Oo0OO00O0O000ooOO0());
            if (context != null && o0ooOoo0Oo00oOOO.o0Oo0OO00O0O000ooOO0(context)) {
                throw new IllegalArgumentException(o0oo0oo00o0o000oooo03.o0Oo0OO00O0O000ooOO0());
            }
            return;
        } else if (this.o0Oo0OO00O0O000ooOO0.equals(o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o)) {
            oo00o0oooo0oo0o0000o = o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.ooOoOooO;
            o0oo0oo00o0o000oooo0 = o0Oo0OO00O0O000ooOO0.C0025o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o;
        } else {
            oo00o0oooo0oo0o0000o = o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.ooOoOooO;
            o0oo0oo00o0o000oooo0 = o0Oo0OO00O0O000ooOO0.C0025o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00;
        }
        com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(oo00o0oooo0oo0o0000o, o0oo0oo00o0o000oooo0.o0Oo0OO00O0O000ooOO0());
    }

    @NonNull
    public o0Oo0OO00O0O000ooOO0 o0O00o00OOoOo0oooOoo00(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o;
        }
        synchronized (this.oO00o0OooO0OO0o0000o) {
            try {
                Object o0Oo0OO00O0O000ooOO02 = HelperJNI.o0Oo0OO00O0O000ooOO0(58, (Object) new Object[]{str});
                if (o0Oo0OO00O0O000ooOO02 == null) {
                    o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0 = o0Oo0OO00O0O000ooOO0.OoOOooOoooOoo;
                    return o0oo0oo00o0o000oooo0;
                } else if (!((Boolean) o0Oo0OO00O0O000ooOO02).booleanValue()) {
                    o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo02 = o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo;
                    return o0oo0oo00o0o000oooo02;
                } else {
                    String O00OO0oOOooooO00000Oo = O00OO0oOOooooO00000Oo(context);
                    if (TextUtils.isEmpty(O00OO0oOOooooO00000Oo) || !O00OO0oOOooooO00000Oo.equals(str) || OO0000O0Ooo0OO000oo(context)) {
                        o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo03 = o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
                        return o0oo0oo00o0o000oooo03;
                    }
                    o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo04 = o0Oo0OO00O0O000ooOO0.O0oOO0ooO;
                    return o0oo0oo00o0o000oooo04;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String oO00o0OooO0OO0o0000o(Context context) {
        return O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(context, o0Oo0OO00O0O000ooOO0("604d14114c46", 51), "");
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
            byte b = (byte) (i ^ 110);
            byte b2 = (byte) (bArr[0] ^ Ascii.DC4);
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

    public void o0O00o00OOoOo0oooOoo00(Context context) {
        O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0("60722b2e7379", 12), "");
    }

    public void oO00o0OooO0OO0o0000o() {
        this.o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
    }

    public boolean o0O00o00OOoOo0oooOoo00() {
        boolean z;
        synchronized (this.oO00o0OooO0OO0o0000o) {
            z = !this.o0Oo0OO00O0O000ooOO0.equals(o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0);
        }
        return z;
    }

    public void o0Oo0OO00O0O000ooOO0(Context context) {
        String valueOf = String.valueOf(System.currentTimeMillis());
        O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0("60540d08555f", 42), String.format(Locale.US, o0Oo0OO00O0O000ooOO0("312322757423", 27), new Object[]{com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().ooOoOooO, valueOf}));
    }

    public void o0Oo0OO00O0O000ooOO0(Context context, String str) {
        o00ooooooO00OO0O00 o0O00o00OOoOo0oooOoo002;
        o00ooooooO00OO0O00 o0O00o00OOoOo0oooOoo003;
        o00ooooooO00OO0O00 o0O00o00OOoOo0oooOoo004;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.oO00o0OooO0OO0o0000o) {
                try {
                    Object o0Oo0OO00O0O000ooOO02 = HelperJNI.o0Oo0OO00O0O000ooOO0(58, (Object) new Object[]{str});
                    if (o0Oo0OO00O0O000ooOO02 != null) {
                        if (!((Boolean) o0Oo0OO00O0O000ooOO02).booleanValue() && o0ooOoo0Oo00oOOO.o0Oo0OO00O0O000ooOO0(context)) {
                            if (!(FMAgent.mFMGetBlackBoxCodeCallback == null || (o0O00o00OOoOo0oooOoo003 = new O0oOO0ooO().o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0.C0025o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0())) == null)) {
                                FMAgent.mFMGetBlackBoxCodeCallback.onResult(o0O00o00OOoOo0oooOoo003.o0Oo0OO00O0O000ooOO0, o0O00o00OOoOo0oooOoo003.o0O00o00OOoOo0oooOoo00);
                            }
                            throw new IllegalArgumentException(o0Oo0OO00O0O000ooOO0.C0025o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0());
                        }
                    } else if (o0ooOoo0Oo00oOOO.o0Oo0OO00O0O000ooOO0(context)) {
                        if (!(FMAgent.mFMGetBlackBoxCodeCallback == null || (o0O00o00OOoOo0oooOoo002 = new O0oOO0ooO().o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0.C0025o0Oo0OO00O0O000ooOO0.OO0000O0Ooo0OO000oo.o0Oo0OO00O0O000ooOO0())) == null)) {
                            FMAgent.mFMGetBlackBoxCodeCallback.onResult(o0O00o00OOoOo0oooOoo002.o0Oo0OO00O0O000ooOO0, o0O00o00OOoOo0oooOoo002.o0O00o00OOoOo0oooOoo00);
                        }
                        throw new IllegalArgumentException(o0Oo0OO00O0O000ooOO0.C0025o0Oo0OO00O0O000ooOO0.OO0000O0Ooo0OO000oo.o0Oo0OO00O0O000ooOO0());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (o0ooOoo0Oo00oOOO.o0Oo0OO00O0O000ooOO0(context)) {
            if (!(FMAgent.mFMGetBlackBoxCodeCallback == null || (o0O00o00OOoOo0oooOoo004 = new O0oOO0ooO().o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0.C0025o0Oo0OO00O0O000ooOO0.o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0())) == null)) {
                FMAgent.mFMGetBlackBoxCodeCallback.onResult(o0O00o00OOoOo0oooOoo004.o0Oo0OO00O0O000ooOO0, o0O00o00OOoOo0oooOoo004.o0O00o00OOoOo0oooOoo00);
            }
            throw new IllegalArgumentException(o0Oo0OO00O0O000ooOO0.C0025o0Oo0OO00O0O000ooOO0.o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0());
        }
    }

    public void o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0) {
        synchronized (this.oO00o0OooO0OO0o0000o) {
            this.o0Oo0OO00O0O000ooOO0 = o0oo0oo00o0o000oooo0;
        }
    }
}
