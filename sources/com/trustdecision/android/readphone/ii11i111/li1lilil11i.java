package com.trustdecision.android.readphone.ii11i111;

import android.telephony.TelephonyManager;
import com.trustdecision.android.readphone.ii11i111.ii11i111;

class li1lilil11i implements ii11i111.C0024ii11i111 {
    final /* synthetic */ TelephonyManager ii11i111;

    public li1lilil11i(TelephonyManager telephonyManager) {
        this.ii11i111 = telephonyManager;
    }

    /* renamed from: i1lill1 */
    public Integer ii11i111() {
        int i;
        try {
            i = this.ii11i111.getNetworkType();
        } catch (Throwable unused) {
            i = 0;
        }
        return Integer.valueOf(i);
    }
}
