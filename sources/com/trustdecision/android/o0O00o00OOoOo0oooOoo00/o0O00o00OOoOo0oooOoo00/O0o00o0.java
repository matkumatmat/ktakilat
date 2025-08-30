package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OO0000O0Ooo0OO000oo.o0Oo0OO00O0O000ooOO0;

public class O0o00o0 implements Application.ActivityLifecycleCallbacks {
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        if (activity != null) {
            try {
                o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00(activity.getApplicationContext());
            } catch (Exception unused) {
            }
        }
    }

    public void onActivityResumed(Activity activity) {
        if (activity != null) {
            o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(activity.getApplicationContext());
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
