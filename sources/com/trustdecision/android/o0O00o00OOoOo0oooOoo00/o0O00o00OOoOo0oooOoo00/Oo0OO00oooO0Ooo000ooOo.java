package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.trustdecision.android.shell.inter.InvokeHandler;

class Oo0OO00oooO0Ooo000ooOo implements InvokeHandler {
    final /* synthetic */ ConnectivityManager o0Oo0OO00O0O000ooOO0;

    public Oo0OO00oooO0Ooo000ooOo(ConnectivityManager connectivityManager) {
        this.o0Oo0OO00O0O000ooOO0 = connectivityManager;
    }

    /* renamed from: o0Oo0OO00O0O000ooOO0 */
    public NetworkInfo invoke() {
        return this.o0Oo0OO00O0O000ooOO0.getActiveNetworkInfo();
    }
}
