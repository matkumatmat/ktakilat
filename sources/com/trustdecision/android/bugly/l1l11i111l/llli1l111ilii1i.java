package com.trustdecision.android.bugly.l1l11i111l;

import android.content.Context;
import android.text.TextUtils;
import com.trustdecision.android.bugly.liii1l1lll1;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class llli1l111ilii1i {
    private void l1ill1li1i(Throwable th) {
        Context liii1l1lll1 = liii1l1lll1.liii1l1lll1();
        liii1l1lll1.l1l11i111l(liii1l1lll1);
        try {
            liii1l1lll1.l1l11i111l(liii1l1lll1, com.trustdecision.android.bugly.liii1l1lll1.liii1l1lll1.llli1l111ilii1i());
            liii1l1lll1(th, liii1l1lll1.liii1l1lll1(liii1l1lll1, com.trustdecision.android.bugly.liii1l1lll1.liii1l1lll1.llli1l111ilii1i()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean l1l11i111l(Throwable th) {
        if (liii1l1lll1() || llli1l111ilii1i(th)) {
            return true;
        }
        return false;
    }

    private boolean llli1l111ilii1i(Throwable th) {
        String message = th.getMessage();
        String llli1l111ilii1i = com.trustdecision.android.bugly.liii1l1lll1.liii1l1lll1.llli1l111ilii1i();
        if (!TextUtils.isEmpty(message) && message.contains(llli1l111ilii1i)) {
            return true;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (stackTraceElement != null && stackTraceElement.toString().contains(llli1l111ilii1i)) {
                return true;
            }
        }
        return false;
    }

    public void liii1l1lll1(Throwable th) {
        if (l1l11i111l(th)) {
            l1ill1li1i(th);
        }
    }

    private boolean liii1l1lll1() {
        return com.trustdecision.android.bugly.liii1l1lll1.liii1l1lll1.l1l11i111l();
    }

    private void liii1l1lll1(Throwable th, File file) throws IOException {
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        th.printStackTrace(printWriter);
        printWriter.flush();
        printWriter.close();
    }
}
