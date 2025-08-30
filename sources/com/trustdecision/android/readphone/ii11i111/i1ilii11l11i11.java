package com.trustdecision.android.readphone.ii11i111;

import android.content.Context;
import android.os.Build;
import android.telephony.SubscriptionManager;

public class i1ilii11l11i11 {
    public static String ii11i111(Context context) {
        return String.valueOf(Build.VERSION.SDK_INT >= 22 ? SubscriptionManager.from(context).getActiveSubscriptionInfoCount() : 0);
    }

    public static void ii11i111() {
        ii11i111.ii11i111();
    }
}
