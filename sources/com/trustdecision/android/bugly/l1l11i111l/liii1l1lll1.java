package com.trustdecision.android.bugly.l1l11i111l;

import android.content.Context;
import com.trustdecision.android.bugly.l1ill1li1i.l1ill1li1i;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.lang3.StringUtils;

public class liii1l1lll1 {
    public static File liii1l1lll1(Context context, String str) throws IOException {
        String liii1l1lll1 = liii1l1lll1(context);
        long currentTimeMillis = System.currentTimeMillis();
        String replace = str.replace(".", "");
        StringBuilder v = ba.v(liii1l1lll1);
        v.append(File.separator);
        v.append("crash_");
        v.append(replace);
        v.append("_");
        File file = new File(ba.p(v, currentTimeMillis, ".dat"));
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    /* access modifiers changed from: private */
    public static long llli1l111ilii1i(String str) {
        try {
            return Long.parseLong(str.replaceAll("[^\\d]", ""));
        } catch (Exception unused) {
            return 0;
        }
    }

    public static void l1l11i111l(Context context, String str) {
        try {
            ArrayList<File> liii1l1lll1 = liii1l1lll1(liii1l1lll1(context), str);
            if (liii1l1lll1.size() >= 10) {
                Collections.sort(liii1l1lll1, new l1l11i111l());
                for (File delete : liii1l1lll1.subList(9, liii1l1lll1.size())) {
                    delete.delete();
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void l1l11i111l(Context context) {
        File file = new File(liii1l1lll1(context));
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static String l1l11i111l(File file) {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream2);
            } catch (Throwable unused) {
                inputStreamReader = null;
                bufferedReader = null;
                fileInputStream = fileInputStream2;
                l1ill1li1i.liii1l1lll1(fileInputStream);
                l1ill1li1i.liii1l1lll1(inputStreamReader);
                l1ill1li1i.liii1l1lll1(bufferedReader);
                return sb.toString();
            }
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                do {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append(StringUtils.LF);
                    } catch (Throwable unused2) {
                        fileInputStream = fileInputStream2;
                        l1ill1li1i.liii1l1lll1(fileInputStream);
                        l1ill1li1i.liii1l1lll1(inputStreamReader);
                        l1ill1li1i.liii1l1lll1(bufferedReader);
                        return sb.toString();
                    }
                } while (sb.length() <= 61440);
                l1ill1li1i.liii1l1lll1(fileInputStream2);
            } catch (Throwable unused3) {
                bufferedReader = null;
                fileInputStream = fileInputStream2;
                l1ill1li1i.liii1l1lll1(fileInputStream);
                l1ill1li1i.liii1l1lll1(inputStreamReader);
                l1ill1li1i.liii1l1lll1(bufferedReader);
                return sb.toString();
            }
        } catch (Throwable unused4) {
            inputStreamReader = null;
            bufferedReader = null;
            l1ill1li1i.liii1l1lll1(fileInputStream);
            l1ill1li1i.liii1l1lll1(inputStreamReader);
            l1ill1li1i.liii1l1lll1(bufferedReader);
            return sb.toString();
        }
        l1ill1li1i.liii1l1lll1(inputStreamReader);
        l1ill1li1i.liii1l1lll1(bufferedReader);
        return sb.toString();
    }

    public static String liii1l1lll1(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getCacheDir().getAbsolutePath());
        return ba.r(sb, File.separator, "TDCrash");
    }

    public static ArrayList<File> liii1l1lll1(String str, String str2) {
        File[] listFiles;
        ArrayList<File> arrayList = new ArrayList<>();
        File file = new File(str);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                boolean startsWith = file2.getName().startsWith("crash_" + str2.replace(".", ""));
                if (file2.isFile() && startsWith) {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }

    public static boolean liii1l1lll1(String str) {
        return str.endsWith(".cinfo");
    }

    public static String liii1l1lll1(File file) {
        BufferedInputStream bufferedInputStream;
        StringBuilder sb = new StringBuilder();
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream2);
            } catch (Throwable unused) {
                bufferedInputStream = null;
                fileInputStream = fileInputStream2;
                l1ill1li1i.liii1l1lll1(fileInputStream);
                l1ill1li1i.liii1l1lll1(bufferedInputStream);
                return sb.toString();
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read));
                }
                l1ill1li1i.liii1l1lll1(fileInputStream2);
            } catch (Throwable unused2) {
                fileInputStream = fileInputStream2;
                l1ill1li1i.liii1l1lll1(fileInputStream);
                l1ill1li1i.liii1l1lll1(bufferedInputStream);
                return sb.toString();
            }
        } catch (Throwable unused3) {
            bufferedInputStream = null;
            l1ill1li1i.liii1l1lll1(fileInputStream);
            l1ill1li1i.liii1l1lll1(bufferedInputStream);
            return sb.toString();
        }
        l1ill1li1i.liii1l1lll1(bufferedInputStream);
        return sb.toString();
    }
}
