package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000;

import android.content.Context;
import android.system.Os;
import androidx.annotation.Nullable;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0;
import com.trustdecision.android.shell.common.HelperJNI;

public class o0ooOoo0Oo00oOOO {
    @Nullable
    public static String o0Oo0OO00O0O000ooOO0() {
        Object o0Oo0OO00O0O000ooOO0 = HelperJNI.o0Oo0OO00O0O000ooOO0(66, (Object) null);
        int intValue = o0Oo0OO00O0O000ooOO0 != null ? ((Integer) o0Oo0OO00O0O000ooOO0).intValue() : Os.getuid();
        if (intValue == -1) {
            return null;
        }
        return String.valueOf(intValue);
    }

    public static boolean o0Oo0OO00O0O000ooOO0(Context context) {
        if (context == null || context.getApplicationInfo() == null) {
            context = o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00();
        }
        return (context == null || context.getApplicationInfo() == null || (context.getApplicationInfo().flags & 2) == 0) ? false : true;
    }
}
