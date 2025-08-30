package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o;

final class O0oOoOO implements oO00o0OooO0OO0o0000o {
    private final TelephonyManager O00OO0oOOooooO00000Oo;
    private final WifiManager o0O00o00OOoOo0oooOoo00;
    private final Context o0Oo0OO00O0O000ooOO0;
    private final ConnectivityManager oO00o0OooO0OO0o0000o;

    private O0oOoOO(Context context, WifiManager wifiManager, ConnectivityManager connectivityManager, TelephonyManager telephonyManager) {
        this.o0Oo0OO00O0O000ooOO0 = context;
        this.o0O00o00OOoOo0oooOoo00 = wifiManager;
        this.oO00o0OooO0OO0o0000o = connectivityManager;
        this.O00OO0oOOooooO00000Oo = telephonyManager;
    }

    public static O0oOoOO o0Oo0OO00O0O000ooOO0(Context context, WifiManager wifiManager, ConnectivityManager connectivityManager, TelephonyManager telephonyManager) {
        return new O0oOoOO(context, wifiManager, connectivityManager, telephonyManager);
    }

    public Object o0Oo0OO00O0O000ooOO0() {
        return oOO0OooO0.o0Oo0OO00O0O000ooOO0(this.o0Oo0OO00O0O000ooOO0, this.o0O00o00OOoOo0oooOoo00, this.oO00o0OooO0OO0o0000o, this.O00OO0oOOooooO00000Oo);
    }
}
