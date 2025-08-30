package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o;

final class Oooo00O0o0Oo0 implements oO00o0OooO0OO0o0000o {
    private WifiManager o0O00o00OOoOo0oooOoo00;
    private Context o0Oo0OO00O0O000ooOO0;
    private ConnectivityManager oO00o0OooO0OO0o0000o;

    private Oooo00O0o0Oo0(Context context, ConnectivityManager connectivityManager, WifiManager wifiManager) {
        this.o0Oo0OO00O0O000ooOO0 = context;
        this.oO00o0OooO0OO0o0000o = connectivityManager;
        this.o0O00o00OOoOo0oooOoo00 = wifiManager;
    }

    public static Oooo00O0o0Oo0 o0Oo0OO00O0O000ooOO0(Context context, ConnectivityManager connectivityManager, WifiManager wifiManager) {
        return new Oooo00O0o0Oo0(context, connectivityManager, wifiManager);
    }

    public Object o0Oo0OO00O0O000ooOO0() {
        return oOO0OooO0.o0Oo0OO00O0O000ooOO0(this.o0Oo0OO00O0O000ooOO0, this.oO00o0OooO0OO0o0000o, this.o0O00o00OOoOo0oooOoo00);
    }
}
