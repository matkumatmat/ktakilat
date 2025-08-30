package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OO0000O0Ooo0OO000oo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0Oo0O0o0ooOOo0oO0;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.CharEncoding;

public class o0Oo0OO00O0O000ooOO0 extends BroadcastReceiver {
    private static boolean oO00o0OooO0OO0o0000o = false;
    private int o0O00o00OOoOo0oooOoo00 = -1;
    private List o0Oo0OO00O0O000ooOO0 = new ArrayList();

    public interface o0O00o00OOoOo0oooOoo00 {
        void o0O00o00OOoOo0oooOoo00();

        void o0Oo0OO00O0O000ooOO0();

        void oO00o0OooO0OO0o0000o();
    }

    /* renamed from: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OO0000O0Ooo0OO000oo.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0  reason: collision with other inner class name */
    public static class C0016o0Oo0OO00O0O000ooOO0 {
        /* access modifiers changed from: private */
        public static final o0Oo0OO00O0O000ooOO0 o0Oo0OO00O0O000ooOO0 = new o0Oo0OO00O0O000ooOO0();
    }

    public static void o0O00o00OOoOo0oooOoo00(Context context) {
        if (oO00o0OooO0OO0o0000o) {
            context.unregisterReceiver(C0016o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0);
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
            byte b = (byte) (i ^ 106);
            byte b2 = (byte) (bArr[0] ^ 40);
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

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                if (o0Oo0OO00O0O000ooOO0("49181d010a111a5d571c064d5a1b1617577a1b16171c11000a08080a1a110b1c1e181e15", 125).equals(intent.getAction())) {
                    o0Oo0OO00O0O000ooOO0(context, o0Oo0O0o0ooOOo0oO0.o0Oo0OO00O0O000ooOO0(context));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void o0Oo0OO00O0O000ooOO0(Context context) {
        Intent registerReceiver = context.registerReceiver(C0016o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0, new IntentFilter(o0Oo0OO00O0O000ooOO0("4973766a617a71363c776d2631707d7c3c11707d7c777a6b61636361717a60777573757e", 22)), o0Oo0OO00O0O000ooOO0("4b404e0f12595b5348564c564a4d0c005c5142494b4e5e4b16165c", 38), (Handler) null);
        if (registerReceiver != null) {
            C0016o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.onReceive(context, registerReceiver);
        }
        oO00o0OooO0OO0o0000o = true;
    }

    private void o0Oo0OO00O0O000ooOO0(Context context, int i) {
        if (this.o0O00o00OOoOo0oooOoo00 != i) {
            if (o0Oo0O0o0ooOOo0oO0.o0O00o00OOoOo0oooOoo00(context)) {
                for (o0O00o00OOoOo0oooOoo00 o0o00o00ooooo0oooooo00 : this.o0Oo0OO00O0O000ooOO0) {
                    if (o0o00o00ooooo0oooooo00 != null) {
                        o0o00o00ooooo0oooooo00.o0O00o00OOoOo0oooOoo00();
                    }
                }
                if (this.o0O00o00OOoOo0oooOoo00 == 0) {
                    for (o0O00o00OOoOo0oooOoo00 o0o00o00ooooo0oooooo002 : this.o0Oo0OO00O0O000ooOO0) {
                        if (o0o00o00ooooo0oooooo002 != null) {
                            o0o00o00ooooo0oooooo002.oO00o0OooO0OO0o0000o();
                        }
                    }
                }
            } else {
                for (o0O00o00OOoOo0oooOoo00 o0o00o00ooooo0oooooo003 : this.o0Oo0OO00O0O000ooOO0) {
                    if (o0o00o00ooooo0oooooo003 != null) {
                        o0o00o00ooooo0oooooo003.o0Oo0OO00O0O000ooOO0();
                    }
                }
            }
            this.o0O00o00OOoOo0oooOoo00 = i;
        }
    }

    public static void o0Oo0OO00O0O000ooOO0(o0O00o00OOoOo0oooOoo00 o0o00o00ooooo0oooooo00) {
        if (o0o00o00ooooo0oooooo00 != null && !C0016o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.contains(o0o00o00ooooo0oooooo00)) {
            C0016o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.add(o0o00o00ooooo0oooooo00);
        }
    }
}
