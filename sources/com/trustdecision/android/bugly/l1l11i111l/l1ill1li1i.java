package com.trustdecision.android.bugly.l1l11i111l;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class l1ill1li1i {
    public static boolean liii1l1lll1(File file) {
        if (liii1l1lll1(file, "backtrace:", "#\\d+\\spc\\s+(.*(trustdevice\\.so|tongdun\\.so))")) {
            return true;
        }
        return liii1l1lll1(file, "java stacktrace:", "com\\.trustdecision|cn.tongdun");
    }

    private static boolean liii1l1lll1(File file, String str, String str2) {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        FileInputStream fileInputStream = null;
        boolean z = false;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream2);
            } catch (Throwable unused) {
                inputStreamReader = null;
                bufferedReader = null;
                fileInputStream = fileInputStream2;
                com.trustdecision.android.bugly.l1ill1li1i.l1ill1li1i.liii1l1lll1(fileInputStream);
                com.trustdecision.android.bugly.l1ill1li1i.l1ill1li1i.liii1l1lll1(inputStreamReader);
                com.trustdecision.android.bugly.l1ill1li1i.l1ill1li1i.liii1l1lll1(bufferedReader);
                return z;
            }
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                boolean z2 = false;
                int i = 0;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (!z && readLine.contains(str)) {
                            z = true;
                        }
                        if (z) {
                            try {
                                z2 = Pattern.compile(str2).matcher(readLine).find();
                            } catch (Throwable unused2) {
                            }
                            i++;
                            if (z2 || i > 10) {
                                break;
                            }
                        }
                    } catch (Throwable unused3) {
                        z = z2;
                        fileInputStream = fileInputStream2;
                        com.trustdecision.android.bugly.l1ill1li1i.l1ill1li1i.liii1l1lll1(fileInputStream);
                        com.trustdecision.android.bugly.l1ill1li1i.l1ill1li1i.liii1l1lll1(inputStreamReader);
                        com.trustdecision.android.bugly.l1ill1li1i.l1ill1li1i.liii1l1lll1(bufferedReader);
                        return z;
                    }
                }
                com.trustdecision.android.bugly.l1ill1li1i.l1ill1li1i.liii1l1lll1(fileInputStream2);
                com.trustdecision.android.bugly.l1ill1li1i.l1ill1li1i.liii1l1lll1(inputStreamReader);
                com.trustdecision.android.bugly.l1ill1li1i.l1ill1li1i.liii1l1lll1(bufferedReader);
                return z2;
            } catch (Throwable unused4) {
                bufferedReader = null;
                fileInputStream = fileInputStream2;
                com.trustdecision.android.bugly.l1ill1li1i.l1ill1li1i.liii1l1lll1(fileInputStream);
                com.trustdecision.android.bugly.l1ill1li1i.l1ill1li1i.liii1l1lll1(inputStreamReader);
                com.trustdecision.android.bugly.l1ill1li1i.l1ill1li1i.liii1l1lll1(bufferedReader);
                return z;
            }
        } catch (Throwable unused5) {
            inputStreamReader = null;
            bufferedReader = null;
            com.trustdecision.android.bugly.l1ill1li1i.l1ill1li1i.liii1l1lll1(fileInputStream);
            com.trustdecision.android.bugly.l1ill1li1i.l1ill1li1i.liii1l1lll1(inputStreamReader);
            com.trustdecision.android.bugly.l1ill1li1i.l1ill1li1i.liii1l1lll1(bufferedReader);
            return z;
        }
    }
}
