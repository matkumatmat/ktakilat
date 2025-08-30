package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import android.content.Context;
import android.net.ConnectivityManager;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o;

final class o0oOO0oO00OoO0 implements oO00o0OooO0OO0o0000o {
    private final ConnectivityManager o0O00o00OOoOo0oooOoo00;
    private final Context o0Oo0OO00O0O000ooOO0;

    private o0oOO0oO00OoO0(Context context, ConnectivityManager connectivityManager) {
        this.o0Oo0OO00O0O000ooOO0 = context;
        this.o0O00o00OOoOo0oooOoo00 = connectivityManager;
    }

    public static o0oOO0oO00OoO0 o0Oo0OO00O0O000ooOO0(Context context, ConnectivityManager connectivityManager) {
        return new o0oOO0oO00OoO0(context, connectivityManager);
    }

    public Object o0Oo0OO00O0O000ooOO0() {
        return oOO0OooO0.o0Oo0OO00O0O000ooOO0(this.o0Oo0OO00O0O000ooOO0, this.o0O00o00OOoOo0oooOoo00);
    }
}
