package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import android.content.Context;
import android.net.wifi.WifiManager;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o;

final class o0ooO0o000Oo0Oo0O0 implements oO00o0OooO0OO0o0000o {
    private final Context o0O00o00OOoOo0oooOoo00;
    private final WifiManager o0Oo0OO00O0O000ooOO0;

    private o0ooO0o000Oo0Oo0O0(Context context, WifiManager wifiManager) {
        this.o0Oo0OO00O0O000ooOO0 = wifiManager;
        this.o0O00o00OOoOo0oooOoo00 = context;
    }

    public static o0ooO0o000Oo0Oo0O0 o0Oo0OO00O0O000ooOO0(Context context, WifiManager wifiManager) {
        return new o0ooO0o000Oo0Oo0O0(context, wifiManager);
    }

    public Object o0Oo0OO00O0O000ooOO0() {
        return oOO0OooO0.oO00o0OooO0OO0o0000o(this.o0O00o00OOoOo0oooOoo00, this.o0Oo0OO00O0O000ooOO0);
    }
}
