package com.trustdecision.android.bugly.l1ill1li1i;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;

public class l1l11i111l {
    private static volatile l1l11i111l liii1l1lll1;
    private SharedPreferences l1l11i111l;
    private SharedPreferences.Editor llli1l111ilii1i;

    private l1l11i111l() {
    }

    private String l1ill1li1i() {
        String l1l11i111l2 = llli1l111ilii1i.l1l11i111l(UUID.randomUUID().toString());
        liii1l1lll1(l1l11i111l2);
        return l1l11i111l2;
    }

    public static l1l11i111l liii1l1lll1() {
        l1l11i111l l1l11i111l2 = liii1l1lll1;
        if (l1l11i111l2 == null) {
            synchronized (l1l11i111l.class) {
                try {
                    l1l11i111l2 = liii1l1lll1;
                    if (l1l11i111l2 == null) {
                        l1l11i111l2 = new l1l11i111l();
                        liii1l1lll1 = l1l11i111l2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return l1l11i111l2;
    }

    private String llli1l111ilii1i() {
        return this.l1l11i111l.getString("td_core_plugin_id", "");
    }

    public String l1l11i111l() {
        if (TextUtils.isEmpty(llli1l111ilii1i())) {
            return l1ill1li1i();
        }
        return llli1l111ilii1i();
    }

    public void liii1l1lll1(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("fm_shared", 0);
        this.l1l11i111l = sharedPreferences;
        this.llli1l111ilii1i = sharedPreferences.edit();
    }

    private void liii1l1lll1(String str) {
        this.llli1l111ilii1i.putString("td_core_plugin_id", str);
        this.llli1l111ilii1i.apply();
    }
}
