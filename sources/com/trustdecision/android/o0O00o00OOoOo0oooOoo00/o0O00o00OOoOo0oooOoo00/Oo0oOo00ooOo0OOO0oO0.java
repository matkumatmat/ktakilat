package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import android.telephony.TelephonyManager;
import com.trustdecision.android.shell.inter.InvokeHandler;

class Oo0oOo00ooOo0OOO0oO0 implements InvokeHandler {
    final /* synthetic */ TelephonyManager o0Oo0OO00O0O000ooOO0;

    public Oo0oOo00ooOo0OOO0oO0(TelephonyManager telephonyManager) {
        this.o0Oo0OO00O0O000ooOO0 = telephonyManager;
    }

    /* renamed from: o0Oo0OO00O0O000ooOO0 */
    public Integer invoke() {
        return Integer.valueOf(this.o0Oo0OO00O0O000ooOO0.getPhoneCount());
    }
}
