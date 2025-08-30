package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import android.net.wifi.WifiManager;
import com.trustdecision.android.shell.inter.InvokeHandler;

class OOoOo00oo0Ooo0o0o0o000 implements InvokeHandler {
    final /* synthetic */ WifiManager o0Oo0OO00O0O000ooOO0;

    public OOoOo00oo0Ooo0o0o0o000(WifiManager wifiManager) {
        this.o0Oo0OO00O0O000ooOO0 = wifiManager;
    }

    /* renamed from: o0Oo0OO00O0O000ooOO0 */
    public Boolean invoke() {
        return Boolean.valueOf(this.o0Oo0OO00O0O000ooOO0.isWifiEnabled());
    }
}
