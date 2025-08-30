package com.trustdecision.android.shell.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o00ooooooO00OO0O00;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0ooOoo0Oo00oOOO;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.lang3.CharEncoding;

public class o0O00o00OOoOo0oooOoo00 {
    private static boolean o0O00o00OOoOo0oooOoo00 = false;
    private static boolean o0Oo0OO00O0O000ooOO0 = false;

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0086 A[SYNTHETIC, Splitter:B:30:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008c A[SYNTHETIC, Splitter:B:35:0x008c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int O00OO0oOOooooO00000Oo(android.content.Context r8) {
        /*
            if (r8 != 0) goto L_0x0004
            r8 = -1
            return r8
        L_0x0004:
            java.lang.String r8 = r8.getPackageCodePath()
            java.lang.String r0 = "4e37397f7c212d69302b697c6b7c71373924343534352233212d3834796f2e"
            r1 = 93
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r1)
            java.lang.String r1 = "4e222c6a6934382f23242c637c66716964222c3121202120372634382d216c7a3b"
            r2 = 72
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0((java.lang.String) r1, (int) r2)
            java.lang.String r2 = "4e797731326f6374787f773a3f79617a7b7a7b6c7d6f63767a372160"
            r3 = 19
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r2, (int) r3)
            java.lang.String r3 = "4e1a1452485f11065c1a1409191819180f1e0c001519544203"
            r4 = 112(0x70, float:1.57E-43)
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0((java.lang.String) r3, (int) r4)
            java.lang.String r4 = "4e4947011b0c4225254e570f49475a4a4b4a4b5c4d5f53464a071150"
            r5 = 35
            java.lang.String r4 = o0Oo0OO00O0O000ooOO0((java.lang.String) r4, (int) r5)
            java.lang.String[] r0 = new java.lang.String[]{r0, r1, r2, r3, r4}
            r1 = 0
            r2 = 0
            java.util.zip.ZipFile r3 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x0082, all -> 0x0080 }
            r3.<init>(r8)     // Catch:{ IOException -> 0x0082, all -> 0x0080 }
            java.util.Enumeration r8 = r3.entries()     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
            r2 = 0
        L_0x0040:
            boolean r4 = r8.hasMoreElements()     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
            if (r4 == 0) goto L_0x007c
            java.lang.Object r4 = r8.nextElement()     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
            java.util.zip.ZipEntry r4 = (java.util.zip.ZipEntry) r4     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
            java.lang.String r5 = r4.getName()     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
            java.lang.String r6 = "0c3f3e"
            r7 = 80
            java.lang.String r6 = o0Oo0OO00O0O000ooOO0((java.lang.String) r6, (int) r7)     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
            boolean r5 = r5.contains(r6)     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
            if (r5 == 0) goto L_0x005f
            goto L_0x0040
        L_0x005f:
            r5 = 0
        L_0x0060:
            r6 = 5
            if (r5 >= r6) goto L_0x0040
            java.lang.String r6 = r4.getName()     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
            r7 = r0[r5]     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
            boolean r6 = r6.equals(r7)     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
            if (r6 == 0) goto L_0x0073
            r4 = 1
            int r4 = r4 << r5
            int r2 = r2 + r4
            goto L_0x0040
        L_0x0073:
            int r5 = r5 + 1
            goto L_0x0060
        L_0x0076:
            r8 = move-exception
            r2 = r3
            goto L_0x0084
        L_0x0079:
            r2 = r3
            goto L_0x008a
        L_0x007c:
            r3.close()     // Catch:{ IOException -> 0x007f }
        L_0x007f:
            return r2
        L_0x0080:
            r8 = move-exception
            goto L_0x0084
        L_0x0082:
            goto L_0x008a
        L_0x0084:
            if (r2 == 0) goto L_0x0089
            r2.close()     // Catch:{ IOException -> 0x0089 }
        L_0x0089:
            throw r8
        L_0x008a:
            if (r2 == 0) goto L_0x008f
            r2.close()     // Catch:{ IOException -> 0x008f }
        L_0x008f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.shell.common.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo(android.content.Context):int");
    }

    private static void O0oOO0ooO(Context context) {
        if (context != null) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new File(applicationInfo.nativeLibraryDir));
            arrayList.add(new File(applicationInfo.dataDir));
            for (int i = 0; i < arrayList.size(); i++) {
                o0Oo0OO00O0O000ooOO0((File) arrayList.get(i), i);
            }
        }
    }

    private static String OO0000O0Ooo0OO000oo(Context context) {
        try {
            String str = context.getApplicationInfo().nativeLibraryDir;
            return str.substring(str.lastIndexOf(o0Oo0OO00O0O000ooOO0("0d", 112)) + 1, str.length());
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    private static String OoOOooOoooOoo(Context context) {
        try {
            return o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0("432e2b373c272c1a172c", 78));
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    private static String o00ooooooO00OO0O00(Context context) {
        String str;
        try {
            str = System.getProperty(o0Oo0OO00O0O000ooOO0("4d3f7e6c303228", 76));
        } catch (Exception e) {
            e.printStackTrace();
            str = "" + o0Oo0OO00O0O000ooOO0("471c1a0714051c0700", 110);
        }
        try {
            o0Oo0OO00O0O000ooOO0("41", 3);
            Object invoke = ClassLoader.class.getDeclaredMethod(o0Oo0OO00O0O000ooOO0("447c74795b567863606078", 28), new Class[]{String.class}).invoke(context.getClassLoader(), new Object[]{o0Oo0OO00O0O000ooOO0("41", 43)});
            if (invoke == null) {
                return o0Oo0OO00O0O000ooOO0("47485b6a72585a43", 44);
            }
            return str + o0Oo0OO00O0O000ooOO0("01", 107) + invoke.toString();
        } catch (Exception e2) {
            StringBuilder v = ba.v(str);
            v.append(e2.getMessage());
            return v.toString();
        }
    }

    public static String o0O00o00OOoOo0oooOoo00(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(o0Oo0OO00O0O000ooOO0("76505b5e51405e4f4c48", 47));
        } catch (Exception unused) {
            return null;
        }
    }

    private static String o0Oo0OO00O0O000ooOO0() {
        return o0Oo0OO00O0O000ooOO0("12", 65);
    }

    public static String oO00o0OooO0OO0o0000o(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(((PackageInfo) o00ooooooO00OO0O00.O00OO0oOOooooO00000Oo(o00ooooooO00OO0O00.O0oOO0ooO[1], new oO00o0OooO0OO0o0000o(context, context.getPackageName()))).signatures[0].toByteArray()).substring(0, 32);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static String o0Oo0OO00O0O000ooOO0(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(o0Oo0OO00O0O000ooOO0("720e0c19051408120313141e", 112));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String o0Oo0OO00O0O000ooOO0(Context context, long j) {
        int i = Build.VERSION.SDK_INT;
        String arrays = Arrays.toString(Build.SUPPORTED_ABIS);
        O0oOO0ooO(context);
        return o0Oo0OO00O0O000ooOO0(Build.BRAND + o0Oo0OO00O0O000ooOO0("7c36", 89) + Build.MODEL + o0Oo0OO00O0O000ooOO0("7c1f", 112) + i + o0Oo0OO00O0O000ooOO0("7c22", 77) + oO00o0OooO0OO0o0000o(context) + o0Oo0OO00O0O000ooOO0("7c40", 47) + arrays + o0Oo0OO00O0O000ooOO0("7c50", 63) + com.trustdecision.android.shell.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00(context) + o0Oo0OO00O0O000ooOO0("7c65", 10) + com.trustdecision.android.shell.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(context) + o0Oo0OO00O0O000ooOO0("7c49", 38) + Build.FINGERPRINT + o0Oo0OO00O0O000ooOO0("7c20", 79) + o0ooOoo0Oo00oOOO.o0Oo0OO00O0O000ooOO0(context) + o0Oo0OO00O0O000ooOO0("7c7c", 19) + o0Oo0OO00O0O000ooOO0 + o0Oo0OO00O0O000ooOO0("7c69", 6) + o0O00o00OOoOo0oooOoo00 + o0Oo0OO00O0O000ooOO0("7c2b", 68) + O00OO0oOOooooO00000Oo(context) + o0Oo0OO00O0O000ooOO0("7c02", 109) + o0Oo0OO00O0O000ooOO0() + o0Oo0OO00O0O000ooOO0("7c24", 75) + o00ooooooO00OO0O00(context) + o0Oo0OO00O0O000ooOO0("7c52", 61) + OO0000O0Ooo0OO000oo(context) + o0Oo0OO00O0O000ooOO0("7c4f4f4f", 32) + "" + o0Oo0OO00O0O000ooOO0("7c09", 102) + "" + o0Oo0OO00O0O000ooOO0("7c00", 111) + OoOOooOoooOoo(context) + o0Oo0OO00O0O000ooOO0("7c70", 31) + "", j);
    }

    private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 111);
            byte b2 = (byte) (bArr[0] ^ 34);
            bArr[0] = b2;
            for (int i4 = 1; i4 < length; i4++) {
                b2 = (byte) ((b2 ^ bArr[i4]) ^ b);
                bArr[i4] = b2;
            }
            return new String(bArr, CharEncoding.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String o0Oo0OO00O0O000ooOO0(String str, long j) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) ((int) (((long) charArray[i]) ^ j));
        }
        return new String(charArray);
    }

    private static void o0Oo0OO00O0O000ooOO0(File file, int i) {
        File[] listFiles;
        if (file != null) {
            if (file.isFile()) {
                if (!o0Oo0OO00O0O000ooOO0("4e616f72626362637465777b6e622f3978", 11).equals(file.getName())) {
                    return;
                }
                if (i == 0) {
                    o0Oo0OO00O0O000ooOO0 = true;
                } else if (i == 1) {
                    o0O00o00OOoOo0oooOoo00 = true;
                }
            } else if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File o0Oo0OO00O0O000ooOO02 : listFiles) {
                    o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO02, i);
                }
            }
        }
    }
}
