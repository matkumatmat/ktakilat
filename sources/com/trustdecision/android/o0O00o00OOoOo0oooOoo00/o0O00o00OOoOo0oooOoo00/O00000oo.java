package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import android.hardware.SensorManager;
import android.view.WindowManager;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o;

final class O00000oo implements oO00o0OooO0OO0o0000o {
    private final WindowManager o0O00o00OOoOo0oooOoo00;
    private final SensorManager o0Oo0OO00O0O000ooOO0;

    private O00000oo(SensorManager sensorManager, WindowManager windowManager) {
        this.o0Oo0OO00O0O000ooOO0 = sensorManager;
        this.o0O00o00OOoOo0oooOoo00 = windowManager;
    }

    public static O00000oo o0Oo0OO00O0O000ooOO0(SensorManager sensorManager, WindowManager windowManager) {
        return new O00000oo(sensorManager, windowManager);
    }

    public Object o0Oo0OO00O0O000ooOO0() {
        return oOO0OooO0.o0Oo0OO00O0O000ooOO0(this.o0Oo0OO00O0O000ooOO0, this.o0O00o00OOoOo0oooOoo00);
    }
}
