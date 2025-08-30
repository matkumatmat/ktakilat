package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o;

final class OoOoo0OoOOooo0OOOOo implements oO00o0OooO0OO0o0000o {
    private final TelephonyManager o0O00o00OOoOo0oooOoo00;
    private final Context o0Oo0OO00O0O000ooOO0;

    private OoOoo0OoOOooo0OOOOo(Context context, TelephonyManager telephonyManager) {
        this.o0Oo0OO00O0O000ooOO0 = context;
        this.o0O00o00OOoOo0oooOoo00 = telephonyManager;
    }

    public static OoOoo0OoOOooo0OOOOo o0Oo0OO00O0O000ooOO0(Context context, TelephonyManager telephonyManager) {
        return new OoOoo0OoOOooo0OOOOo(context, telephonyManager);
    }

    public Object o0Oo0OO00O0O000ooOO0() {
        return oOO0OooO0.o0Oo0OO00O0O000ooOO0(this.o0Oo0OO00O0O000ooOO0, this.o0O00o00OOoOo0oooOoo00);
    }
}
