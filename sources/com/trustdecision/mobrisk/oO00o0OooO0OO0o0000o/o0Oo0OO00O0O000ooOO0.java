package com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o;

import android.content.Context;

public class o0Oo0OO00O0O000ooOO0 {
    private static Context o0Oo0OO00O0O000ooOO0;

    public static synchronized Context o0Oo0OO00O0O000ooOO0() {
        Context context;
        synchronized (o0Oo0OO00O0O000ooOO0.class) {
            context = o0Oo0OO00O0O000ooOO0;
        }
        return context;
    }

    public static synchronized void o0Oo0OO00O0O000ooOO0(Context context) {
        synchronized (o0Oo0OO00O0O000ooOO0.class) {
            if (context != null) {
                if (o0Oo0OO00O0O000ooOO0 == null) {
                    o0Oo0OO00O0O000ooOO0 = context.getApplicationContext();
                }
            }
        }
    }
}
