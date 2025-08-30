package com.ktakilat.cbase.utils;

import android.app.ActivityManager;
import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.ktakilat.cbase.datacollect.PCollectorManager;
import com.ktakilat.cbase.ui.BaseApplication;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

public class DeviceUtils {
    public static String a(Context context) {
        try {
            String id = AdvertisingIdClient.getAdvertisingIdInfo(context).getId();
            String str = PCollectorManager.f469a;
            PCollectorManager.i = id;
            return id;
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:9|12|13|14|15) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:5|6|(1:8)|10|11|16|17|(2:19|21)(1:23)) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return "";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0026 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0033 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0034 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e A[Catch:{ FileNotFoundException | Exception -> 0x0055 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b() {
        /*
            java.lang.String r0 = ""
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{  }
            java.lang.String r2 = "/proc/version"
            r1.<init>(r2)     // Catch:{  }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{  }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{  }
            r3.<init>(r1)     // Catch:{  }
            r4 = 8192(0x2000, float:1.14794E-41)
            r2.<init>(r3, r4)     // Catch:{  }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{  }
            r3.<init>()     // Catch:{  }
        L_0x001a:
            java.lang.String r4 = r2.readLine()     // Catch:{ IOException -> 0x0026, all -> 0x0024 }
            if (r4 == 0) goto L_0x0026
            r3.append(r4)     // Catch:{ IOException -> 0x0026, all -> 0x0024 }
            goto L_0x001a
        L_0x0024:
            r3 = move-exception
            goto L_0x002d
        L_0x0026:
            r2.close()     // Catch:{ IOException -> 0x0034 }
            r1.close()     // Catch:{ IOException -> 0x0034 }
            goto L_0x0034
        L_0x002d:
            r2.close()     // Catch:{ IOException -> 0x0033 }
            r1.close()     // Catch:{ IOException -> 0x0033 }
        L_0x0033:
            throw r3     // Catch:{  }
        L_0x0034:
            java.lang.String r1 = r3.toString()     // Catch:{ FileNotFoundException | Exception -> 0x0055 }
            boolean r1 = r0.equals(r1)     // Catch:{ FileNotFoundException | Exception -> 0x0055 }
            if (r1 != 0) goto L_0x0055
            java.lang.String r1 = "version "
            int r1 = r3.indexOf(r1)     // Catch:{ FileNotFoundException | Exception -> 0x0055 }
            int r1 = r1 + 8
            java.lang.String r1 = r3.substring(r1)     // Catch:{ FileNotFoundException | Exception -> 0x0055 }
            java.lang.String r2 = " "
            int r2 = r1.indexOf(r2)     // Catch:{ FileNotFoundException | Exception -> 0x0055 }
            r3 = 0
            java.lang.String r0 = r1.substring(r3, r2)     // Catch:{ FileNotFoundException | Exception -> 0x0055 }
        L_0x0055:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.cbase.utils.DeviceUtils.b():java.lang.String");
    }

    public static String c() {
        try {
            Process exec = Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address");
            Process exec2 = Runtime.getRuntime().exec("cat /sys/class/net/eth0/address");
            String readLine = new LineNumberReader(new InputStreamReader(exec.getInputStream())).readLine();
            if (readLine != null) {
                if (readLine.contains(":") && readLine.length() == 17) {
                    return readLine;
                }
            }
            readLine = new LineNumberReader(new InputStreamReader(exec2.getInputStream())).readLine();
            if (readLine == null || !readLine.contains(":") || readLine.length() != 17) {
                return "";
            }
            return readLine;
        } catch (IOException unused) {
        }
    }

    public static String d(BaseApplication baseApplication) {
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) baseApplication.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return ((memoryInfo.availMem / 1024) / 1024) + "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String e() {
        long j = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String str = bufferedReader.readLine().split(":")[1];
            j = Long.parseLong(str.substring(0, str.length() - 2).trim());
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ba.p(new StringBuilder(), j * 1024, "");
    }

    public static boolean f() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return false;
            }
            Iterator<T> it = Collections.list(networkInterfaces).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (networkInterface.isUp() && networkInterface.getInterfaceAddresses().size() != 0) {
                    if ("tun0".equals(networkInterface.getName()) || "ppp0".equals(networkInterface.getName())) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
