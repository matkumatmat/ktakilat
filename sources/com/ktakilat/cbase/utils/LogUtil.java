package com.ktakilat.cbase.utils;

import com.ktakilat.cbase.ui.LogActivity;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class LogUtil {
    public static void a(Throwable th) {
        th.printStackTrace();
        th.getMessage();
        ArrayList arrayList = LogActivity.k;
    }

    public static String b(Throwable th) {
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }
}
