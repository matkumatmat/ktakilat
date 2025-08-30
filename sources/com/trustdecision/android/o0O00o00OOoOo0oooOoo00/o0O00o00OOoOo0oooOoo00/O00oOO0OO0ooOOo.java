package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import android.content.Context;
import android.location.LocationManager;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o;

final class O00oOO0OO0ooOOo implements oO00o0OooO0OO0o0000o {
    private Context o0O00o00OOoOo0oooOoo00;
    private final LocationManager o0Oo0OO00O0O000ooOO0;

    private O00oOO0OO0ooOOo(Context context, LocationManager locationManager) {
        this.o0O00o00OOoOo0oooOoo00 = context;
        this.o0Oo0OO00O0O000ooOO0 = locationManager;
    }

    public static O00oOO0OO0ooOOo o0Oo0OO00O0O000ooOO0(Context context, LocationManager locationManager) {
        return new O00oOO0OO0ooOOo(context, locationManager);
    }

    /* renamed from: o0O00o00OOoOo0oooOoo00 */
    public Integer o0Oo0OO00O0O000ooOO0() {
        return Integer.valueOf(oOO0OooO0.o0O00o00OOoOo0oooOoo00(this.o0O00o00OOoOo0oooOoo00, this.o0Oo0OO00O0O000ooOO0));
    }
}
