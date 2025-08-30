package com.appsflyer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.appsflyer.internal.AFa1tSDK;

public class MultipleInstallBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String str;
        if (intent != null) {
            try {
                str = intent.getStringExtra("referrer");
            } catch (Throwable th) {
                AFLogger.afErrorLog("error in BroadcastReceiver ", th);
                str = null;
            }
            if (str == null || AFa1tSDK.c_(context).getString("referrer", (String) null) == null) {
                AFLogger.afInfoLog("MultipleInstallBroadcastReceiver called");
                ((AFa1tSDK) AFa1tSDK.getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis())).b_(context, intent);
                for (ResolveInfo next : context.getPackageManager().queryBroadcastReceivers(new Intent("com.android.vending.INSTALL_REFERRER"), 0)) {
                    String action = intent.getAction();
                    if (next.activityInfo.packageName.equals(context.getPackageName()) && "com.android.vending.INSTALL_REFERRER".equals(action) && !getClass().getName().equals(next.activityInfo.name)) {
                        StringBuilder sb = new StringBuilder("trigger onReceive: class: ");
                        sb.append(next.activityInfo.name);
                        AFLogger.afInfoLog(sb.toString());
                        try {
                            ((BroadcastReceiver) Class.forName(next.activityInfo.name).newInstance()).onReceive(context, intent);
                        } catch (Throwable th2) {
                            StringBuilder sb2 = new StringBuilder("error in BroadcastReceiver ");
                            sb2.append(next.activityInfo.name);
                            AFLogger.afErrorLog(sb2.toString(), th2);
                        }
                    }
                }
                return;
            }
            ((AFa1tSDK) AFa1tSDK.getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis())).getMediationNetwork(context, str);
        }
    }
}
