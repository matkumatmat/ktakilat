package com.ktakilat.cbase.utils;

import android.os.Build;
import android.telephony.TelephonyManager;
import com.facebook.internal.ServerProtocol;
import com.facebook.places.model.PlaceFields;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.ktakilat.cbase.ui.BaseApplication;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

public class EnvUtils {
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0077, code lost:
        if (r2 == null) goto L_0x007a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList a(java.util.ArrayList r6) {
        /*
            java.lang.String r0 = "/system/bin/sh"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            java.lang.Process r2 = r3.exec(r0)     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
        L_0x002b:
            boolean r4 = r6.hasNext()     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            if (r4 == 0) goto L_0x0054
            java.lang.Object r4 = r6.next()     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            r5.<init>()     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            r5.append(r4)     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            java.lang.String r4 = " 2>&1\n"
            r5.append(r4)     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            byte[] r4 = r4.getBytes()     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            r0.write(r4)     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            goto L_0x002b
        L_0x0050:
            r6 = move-exception
            goto L_0x0071
        L_0x0052:
            goto L_0x0077
        L_0x0054:
            java.lang.String r6 = "exit\n"
            byte[] r6 = r6.getBytes()     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            r0.write(r6)     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            r0.flush()     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
        L_0x0060:
            java.lang.String r6 = r3.readLine()     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            if (r6 == 0) goto L_0x006a
            r1.add(r6)     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
            goto L_0x0060
        L_0x006a:
            r2.waitFor()     // Catch:{ Exception -> 0x0052, all -> 0x0050 }
        L_0x006d:
            r2.destroy()
            goto L_0x007a
        L_0x0071:
            if (r2 == 0) goto L_0x0076
            r2.destroy()
        L_0x0076:
            throw r6
        L_0x0077:
            if (r2 == 0) goto L_0x007a
            goto L_0x006d
        L_0x007a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.cbase.utils.EnvUtils.a(java.util.ArrayList):java.util.ArrayList");
    }

    public static boolean b() {
        try {
            String str = System.getenv("PATH");
            ArrayList arrayList = new ArrayList();
            String[] split = str.split(":");
            for (int i = 0; i < split.length; i++) {
                arrayList.add("ls -l " + split[i] + "/su");
                String str2 = split[i];
            }
            ArrayList a2 = a(arrayList);
            String str3 = StringUtils.SPACE;
            for (int i2 = 0; i2 < a2.size(); i2++) {
                str3 = str3 + ((String) a2.get(i2));
                String str4 = (String) a2.get(i2);
            }
            if (str3.contains("-rwsr-sr-x") || str3.contains("-rwsr-xr-x")) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001a, code lost:
        if ("google_sdk".equals(r3) == false) goto L_0x001e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0049 A[SYNTHETIC, Splitter:B:13:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0076 A[SYNTHETIC, Splitter:B:30:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0092 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(com.ktakilat.cbase.ui.BaseApplication r6) {
        /*
            r0 = 0
            r1 = 1
            java.lang.String r2 = "phone"
            java.lang.Object r2 = r6.getSystemService(r2)     // Catch:{ Exception -> 0x001e }
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2     // Catch:{ Exception -> 0x001e }
            java.lang.String r2 = "sdk"
            java.lang.String r3 = android.os.Build.MODEL     // Catch:{ Exception -> 0x001e }
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x001e }
            if (r2 != 0) goto L_0x0092
            java.lang.String r2 = "google_sdk"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x001e }
            if (r2 == 0) goto L_0x001e
            goto L_0x0092
        L_0x001e:
            java.lang.String r2 = "android.os.SystemProperties"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r3 = "get"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0045 }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r0] = r5     // Catch:{ Exception -> 0x0045 }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r3, r4)     // Catch:{ Exception -> 0x0045 }
            r2.setAccessible(r1)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r3 = "1"
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0045 }
            java.lang.String r5 = "ro.kernel.qemu"
            r4[r0] = r5     // Catch:{ Exception -> 0x0045 }
            r5 = 0
            java.lang.Object r2 = r2.invoke(r5, r4)     // Catch:{ Exception -> 0x0045 }
            boolean r2 = r3.equals(r2)     // Catch:{ Exception -> 0x0045 }
            goto L_0x0047
        L_0x0045:
            r2 = 0
        L_0x0047:
            if (r2 != 0) goto L_0x0092
            boolean r2 = d()     // Catch:{ Exception -> 0x0091 }
            if (r2 != 0) goto L_0x0092
            boolean r6 = e(r6)     // Catch:{ Exception -> 0x0091 }
            if (r6 != 0) goto L_0x0092
            java.lang.String r6 = "/system/lib/libc_malloc_debug_qemu.so"
            java.lang.String r2 = "/sys/qemu_trace"
            java.lang.String[] r6 = new java.lang.String[]{r6, r2}     // Catch:{ Exception -> 0x0072 }
            r2 = 0
        L_0x005e:
            r3 = 2
            if (r2 >= r3) goto L_0x0073
            r3 = r6[r2]     // Catch:{ Exception -> 0x0072 }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0072 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0072 }
            boolean r3 = r4.exists()     // Catch:{ Exception -> 0x0072 }
            if (r3 == 0) goto L_0x0070
            r6 = 1
            goto L_0x0074
        L_0x0070:
            int r2 = r2 + r1
            goto L_0x005e
        L_0x0072:
        L_0x0073:
            r6 = 0
        L_0x0074:
            if (r6 != 0) goto L_0x0092
            java.lang.String r6 = android.os.Build.CPU_ABI     // Catch:{ Exception -> 0x0089 }
            java.lang.String r2 = "x86"
            boolean r2 = r6.contains(r2)     // Catch:{ Exception -> 0x0089 }
            if (r2 != 0) goto L_0x008b
            java.lang.String r2 = "i386"
            boolean r6 = r6.contains(r2)     // Catch:{ Exception -> 0x0089 }
            if (r6 == 0) goto L_0x008d
            goto L_0x008b
        L_0x0089:
            goto L_0x008d
        L_0x008b:
            r6 = 1
            goto L_0x008e
        L_0x008d:
            r6 = 0
        L_0x008e:
            if (r6 == 0) goto L_0x0093
            goto L_0x0092
        L_0x0091:
            return r0
        L_0x0092:
            r0 = 1
        L_0x0093:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.cbase.utils.EnvUtils.c(com.ktakilat.cbase.ui.BaseApplication):boolean");
    }

    public static boolean d() {
        String str = Build.BOARD;
        String str2 = Build.BOOTLOADER;
        String str3 = Build.BRAND;
        String str4 = Build.DEVICE;
        String str5 = Build.HARDWARE;
        String str6 = Build.MODEL;
        String str7 = Build.PRODUCT;
        if ((!"unknown".equals(str) || !"unknown".equals(str2) || !MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE.equals(str3) || !MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE.equals(str4) || !ServerProtocol.DIALOG_PARAM_SDK_VERSION.equals(str6) || !ServerProtocol.DIALOG_PARAM_SDK_VERSION.equals(str7) || !"goldfish".equals(str5)) && !"nox".equalsIgnoreCase(str) && !"nox".equalsIgnoreCase(str7) && !"nox".equalsIgnoreCase(str4)) {
            return false;
        }
        return true;
    }

    public static boolean e(BaseApplication baseApplication) {
        try {
            String line1Number = ((TelephonyManager) baseApplication.getSystemService(PlaceFields.PHONE)).getLine1Number();
            String[] strArr = {"15555215554", "15555215556", "15555215558", "15555215560", "15555215562", "15555215564", "15555215566", "15555215568", "15555215570", "15555215572", "15555215574", "15555215576", "15555215578", "15555215580", "15555215582", "15555215584"};
            for (int i = 0; i < 16; i++) {
                if (strArr[i].equalsIgnoreCase(line1Number)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean f(String str) {
        Process process = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            Process exec = runtime.exec("ls -l " + str);
            String readLine = new BufferedReader(new InputStreamReader(exec.getInputStream())).readLine();
            if (readLine != null) {
                if (readLine.length() >= 4) {
                    char charAt = readLine.charAt(3);
                    if (charAt == 's' || charAt == 'x') {
                        exec.destroy();
                        return true;
                    }
                    exec.destroy();
                    return false;
                }
            }
            exec.destroy();
            return false;
        } catch (Exception unused) {
            if (process != null) {
                process.destroy();
            }
            return true;
        } catch (Throwable th) {
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
    }
}
