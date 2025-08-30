package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.trustdecision.android.shell.inter.InvokeHandler;

class OOo0o00oOO00o00o implements InvokeHandler {
    final /* synthetic */ WifiManager o0Oo0OO00O0O000ooOO0;

    public OOo0o00oOO00o00o(WifiManager wifiManager) {
        this.o0Oo0OO00O0O000ooOO0 = wifiManager;
    }

    /* renamed from: o0Oo0OO00O0O000ooOO0 */
    public WifiInfo invoke() {
        return this.o0Oo0OO00O0O000ooOO0.getConnectionInfo();
    }
}
