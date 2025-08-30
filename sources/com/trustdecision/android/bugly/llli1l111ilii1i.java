package com.trustdecision.android.bugly;

import android.content.Context;
import com.trustdecision.android.bugly.l1l11i111l.liii1l1lll1;
import java.io.File;
import java.util.Iterator;

public class llli1l111ilii1i {
    public static String liii1l1lll1 = "https://bugly.tongdun.net";

    public static void liii1l1lll1(Context context, String str) {
        Iterator<File> it = liii1l1lll1.liii1l1lll1(liii1l1lll1.liii1l1lll1(context), str).iterator();
        while (it.hasNext()) {
            new Thread(new l1ill1li1i(it.next(), liii1l1lll1())).start();
        }
    }

    private static String liii1l1lll1() {
        return ba.r(new StringBuilder(), liii1l1lll1, "/bugly/errorupload/v1");
    }
}
