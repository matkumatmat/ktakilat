package com.baidu.idl.main.facesdk.statistic;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeviceInfoUtil {
    private static final FileFilter CPU_FILTER = new FileFilter() {
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (name.charAt(i) < '0' || name.charAt(i) > '9') {
                    return false;
                }
            }
            return true;
        }
    };
    private static final String CurPath = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq";

    public static Integer getCPUBit() {
        String str;
        try {
            str = getFieldFromCpuinfo("Processor");
        } catch (IOException e) {
            e.printStackTrace();
            str = null;
        }
        if (str == null) {
            return 0;
        }
        if (str.contains("aarch64")) {
            return 64;
        }
        return 32;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0056 A[SYNTHETIC, Splitter:B:33:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0060 A[SYNTHETIC, Splitter:B:38:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x006e A[SYNTHETIC, Splitter:B:45:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0078 A[SYNTHETIC, Splitter:B:50:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x007f A[SYNTHETIC, Splitter:B:54:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0089 A[SYNTHETIC, Splitter:B:59:0x0089] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:30:0x0051=Splitter:B:30:0x0051, B:42:0x0069=Splitter:B:42:0x0069} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getDeviceBasicFrequency() {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x004c, IOException -> 0x0047, all -> 0x0042 }
            java.lang.String r2 = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x004c, IOException -> 0x0047, all -> 0x0042 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x003d, IOException -> 0x0038, all -> 0x0033 }
            r2.<init>(r1)     // Catch:{ FileNotFoundException -> 0x003d, IOException -> 0x0038, all -> 0x0033 }
            java.lang.String r0 = r2.readLine()     // Catch:{ FileNotFoundException -> 0x0031, IOException -> 0x002f }
            java.lang.String r0 = r0.trim()     // Catch:{ FileNotFoundException -> 0x0031, IOException -> 0x002f }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ FileNotFoundException -> 0x0031, IOException -> 0x002f }
            r1.close()     // Catch:{ IOException -> 0x001d }
            goto L_0x0021
        L_0x001d:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0021:
            r2.close()     // Catch:{ IOException -> 0x0026 }
            goto L_0x007c
        L_0x0026:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x007c
        L_0x002c:
            r0 = move-exception
            goto L_0x007d
        L_0x002f:
            r0 = move-exception
            goto L_0x0051
        L_0x0031:
            r0 = move-exception
            goto L_0x0069
        L_0x0033:
            r2 = move-exception
            r3 = r2
            r2 = r0
            r0 = r3
            goto L_0x007d
        L_0x0038:
            r2 = move-exception
            r3 = r2
            r2 = r0
            r0 = r3
            goto L_0x0051
        L_0x003d:
            r2 = move-exception
            r3 = r2
            r2 = r0
            r0 = r3
            goto L_0x0069
        L_0x0042:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
            goto L_0x007d
        L_0x0047:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
            goto L_0x0051
        L_0x004c:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
            goto L_0x0069
        L_0x0051:
            r0.printStackTrace()     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x005e
            r1.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x005e:
            if (r2 == 0) goto L_0x007b
            r2.close()     // Catch:{ IOException -> 0x0064 }
            goto L_0x007b
        L_0x0064:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x007b
        L_0x0069:
            r0.printStackTrace()     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x0076
            r1.close()     // Catch:{ IOException -> 0x0072 }
            goto L_0x0076
        L_0x0072:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0076:
            if (r2 == 0) goto L_0x007b
            r2.close()     // Catch:{ IOException -> 0x0064 }
        L_0x007b:
            r0 = 0
        L_0x007c:
            return r0
        L_0x007d:
            if (r1 == 0) goto L_0x0087
            r1.close()     // Catch:{ IOException -> 0x0083 }
            goto L_0x0087
        L_0x0083:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0087:
            if (r2 == 0) goto L_0x0091
            r2.close()     // Catch:{ IOException -> 0x008d }
            goto L_0x0091
        L_0x008d:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0091:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.main.facesdk.statistic.DeviceInfoUtil.getDeviceBasicFrequency():int");
    }

    public static String getDeviceBoard() {
        return Build.BOARD;
    }

    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    public static String getDeviceDevice() {
        return Build.DEVICE;
    }

    public static String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getDeviceProcessor() {
        try {
            String[] split = new BufferedReader(new FileReader("/proc/cpuinfo")).readLine().split(":\\s+", 2);
            for (int i = 0; i < split.length; i++) {
            }
            return split[1];
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getDeviceProduct() {
        return Build.PRODUCT;
    }

    public static int getDeviceSDK() {
        return Build.VERSION.SDK_INT;
    }

    public static String getDeviceSerial() {
        return Build.SERIAL;
    }

    public static String getFieldFromCpuinfo(String str) throws IOException {
        Matcher matcher;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
        Pattern compile = Pattern.compile(str + "\\s*:\\s*(.*)");
        do {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    matcher = compile.matcher(readLine);
                } else {
                    bufferedReader.close();
                    return null;
                }
            } finally {
                bufferedReader.close();
            }
        } while (!matcher.matches());
        return matcher.group(1);
    }

    public static int getNumberOfCPUCores() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
        } catch (NullPointerException | SecurityException unused) {
            return 0;
        }
    }

    public static long getRamInfo(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    public static String getStorageInfo(Context context, int i) {
        String storagePath = getStoragePath(context, i);
        if (!isSDCardMount() || storagePath == null || storagePath.toString().equals("")) {
            return "无外置SD卡";
        }
        StatFs statFs = new StatFs(new File(storagePath).getPath());
        long blockCountLong = statFs.getBlockCountLong();
        long blockSizeLong = statFs.getBlockSizeLong();
        long j = blockCountLong * blockSizeLong;
        long availableBlocksLong = statFs.getAvailableBlocksLong() * blockSizeLong;
        return "可用/总共：" + Long.toString(availableBlocksLong) + RemoteSettings.FORWARD_SLASH_STRING + Long.toString(j);
    }

    public static String getStoragePath(Context context, int i) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            String[] strArr = (String[]) storageManager.getClass().getMethod("getVolumePaths", (Class[]) null).invoke(storageManager, (Object[]) null);
            if (i == 0) {
                return strArr[i];
            }
            if (i != 1) {
                return null;
            }
            if (strArr.length > 1) {
                return strArr[i];
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static boolean isSDCardMount() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
