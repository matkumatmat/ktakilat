package com.trustdecision.android.readphone.ii11i111;

import android.telephony.TelephonyManager;
import com.trustdecision.android.readphone.ii11i111.ii11i111;

class lillillliill1ill1i implements ii11i111.C0024ii11i111 {
    final /* synthetic */ TelephonyManager ii11i111;

    public lillillliill1ill1i(TelephonyManager telephonyManager) {
        this.ii11i111 = telephonyManager;
    }

    public Object ii11i111() {
        int i;
        try {
            i = this.ii11i111.getNetworkType();
        } catch (Throwable unused) {
            i = 0;
        }
        return Integer.valueOf(i);
    }
}
