package com.ktakilat.loan.device;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import com.appsflyer.AppsFlyerLib;
import com.ktakilat.cbase.http.phone.App;
import com.ktakilat.cbase.http.phone.AppCacheModel;
import com.ktakilat.cbase.ui.LogActivity;
import com.ktakilat.cbase.utils.JsonUtil;
import com.ktakilat.loan.R;
import com.ktakilat.loan.global.AppKv;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class DeviceUtil {
    public static ArrayList a(Context context) {
        int i;
        ArrayList arrayList = new ArrayList();
        try {
            for (PackageInfo next : context.getPackageManager().getInstalledPackages(0)) {
                try {
                    App app = new App();
                    app.appName = next.applicationInfo.loadLabel(context.getPackageManager()).toString();
                    app.packageName = next.packageName;
                    app.inTime = next.firstInstallTime;
                    app.upTime = next.lastUpdateTime;
                    app.versionName = next.versionName;
                    app.versionCode = String.valueOf(next.versionCode);
                    int i2 = next.applicationInfo.flags;
                    if ((i2 & 1) == 0) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    app.appType = i;
                    app.appFlags = i2;
                    arrayList.add(app);
                } catch (Exception e) {
                    e.toString();
                    ArrayList arrayList2 = LogActivity.k;
                }
            }
        } catch (Exception e2) {
            e2.toString();
            ArrayList arrayList3 = LogActivity.k;
        }
        AppCacheModel appCacheModel = new AppCacheModel();
        appCacheModel.setAppList(arrayList);
        appCacheModel.setDate(new SimpleDateFormat("yyyy--MM-dd").format(Calendar.getInstance().getTime()));
        AppKv.g().b("appListCache", JsonUtil.a(appCacheModel));
        return arrayList;
    }

    public static String b(Context context) {
        String string = AppKv.g().f465a.getString("androidIDv2", "");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            String string2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
            AppKv.g().b("androidIDv2", string2);
            AppsFlyerLib.getInstance().setAndroidIdData(string2);
            return string2;
        } catch (Exception e) {
            e.toString();
            ArrayList arrayList = LogActivity.k;
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0304, code lost:
        if (com.ktakilat.cbase.utils.EnvUtils.b() != false) goto L_0x0309;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0319, code lost:
        if ((r16.getApplicationInfo().flags & 2) != 0) goto L_0x031d;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:88:0x021b */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0254 A[Catch:{ Exception -> 0x0138 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0274 A[Catch:{ Exception -> 0x0279 }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x028e A[Catch:{ Exception -> 0x0138 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0293 A[Catch:{ Exception -> 0x0138 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x029e A[Catch:{ Exception -> 0x0138 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x02a3 A[Catch:{ Exception -> 0x0138 }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x02ae A[Catch:{ Exception -> 0x0138 }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02b3 A[Catch:{ Exception -> 0x0138 }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02be A[Catch:{ Exception -> 0x02c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02d7 A[Catch:{ Exception -> 0x02ef }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0300 A[SYNTHETIC, Splitter:B:157:0x0300] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x036c A[Catch:{ Exception -> 0x0138 }] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x02ef A[EDGE_INSN: B:203:0x02ef->B:150:0x02ef ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ef A[Catch:{ Exception -> 0x0100 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0116 A[SYNTHETIC, Splitter:B:49:0x0116] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01b4 A[Catch:{ Exception -> 0x01d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01b9 A[Catch:{ Exception -> 0x01d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01bf A[Catch:{ Exception -> 0x01d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0209 A[Catch:{ Exception -> 0x021b }, LOOP:0: B:84:0x0203->B:86:0x0209, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0225 A[Catch:{ Exception -> 0x0138 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x022a A[Catch:{ Exception -> 0x0138 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0235 A[Catch:{ Exception -> 0x0138 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x023a A[Catch:{ Exception -> 0x0138 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0246 A[Catch:{ Exception -> 0x0138 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(com.ktakilat.cbase.ui.BaseApplication r16, com.ktakilat.cbase.http.phone.DeviceExInfo r17) {
        /*
            r1 = r16
            r2 = r17
            r3 = 2
            r4 = 0
            r5 = 1
            java.lang.String r6 = "connectivity"
            java.lang.String r7 = "wifi"
            java.lang.String r8 = "phone"
            java.lang.String r9 = ""
            java.util.TimeZone r0 = java.util.TimeZone.getDefault()     // Catch:{ Exception -> 0x0138 }
            java.lang.String r10 = "GMT"
            r0.setID(r10)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = r0.getDisplayName(r4, r4)     // Catch:{ Exception -> 0x0138 }
            r2.timezone = r0     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = android.os.Build.MANUFACTURER     // Catch:{ Exception -> 0x0138 }
            r2.manufacturer = r0     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = android.os.Build.BRAND     // Catch:{ Exception -> 0x0138 }
            r2.brand = r0     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = android.os.Build.DEVICE     // Catch:{ Exception -> 0x0138 }
            r2.modelNo = r0     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = android.os.Build.VERSION.RELEASE     // Catch:{ Exception -> 0x0138 }
            r2.osVersion = r0     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = com.ktakilat.cbase.utils.DeviceUtils.b()     // Catch:{ Exception -> 0x0138 }
            r2.kernelVersion = r0     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = android.os.Build.FINGERPRINT     // Catch:{ Exception -> 0x0138 }
            r2.fingerPrint = r0     // Catch:{ Exception -> 0x0138 }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x004b }
            r10 = 22
            if (r0 < r10) goto L_0x0043
            java.lang.String r0 = com.ktakilat.cbase.utils.DeviceUtils.c()     // Catch:{ Exception -> 0x004b }
            goto L_0x0055
        L_0x0043:
            java.lang.Object r0 = r1.getSystemService(r7)     // Catch:{ Exception -> 0x004b }
            android.net.wifi.WifiManager r0 = (android.net.wifi.WifiManager) r0     // Catch:{ Exception -> 0x004b }
            if (r0 != 0) goto L_0x004d
        L_0x004b:
            r0 = r9
            goto L_0x0055
        L_0x004d:
            android.net.wifi.WifiInfo r0 = r0.getConnectionInfo()     // Catch:{ Exception -> 0x004b }
            java.lang.String r0 = r0.getMacAddress()     // Catch:{ Exception -> 0x004b }
        L_0x0055:
            r2.macAddress = r0     // Catch:{ Exception -> 0x0138 }
            boolean r0 = com.ktakilat.cbase.utils.DeviceUtils.f()     // Catch:{ Exception -> 0x0138 }
            r2.isProxy = r0     // Catch:{ Exception -> 0x0138 }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0067 }
            r10 = 26
            if (r0 < r10) goto L_0x0064
            goto L_0x006b
        L_0x0064:
            java.lang.String r0 = android.os.Build.SERIAL     // Catch:{ Exception -> 0x0067 }
            goto L_0x006c
        L_0x0067:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x0138 }
        L_0x006b:
            r0 = r9
        L_0x006c:
            r2.serialNo = r0     // Catch:{ Exception -> 0x0138 }
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x0138 }
            r2.upTime = r0     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = com.ktakilat.loan.global.AppKv.d()     // Catch:{ Exception -> 0x0138 }
            r2.gaid = r0     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = "android.os.SystemProperties"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x00a7 }
            java.lang.Object r10 = r0.newInstance()     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r11 = "get"
            java.lang.Class[] r12 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x00a7 }
            java.lang.Class<java.lang.String> r13 = java.lang.String.class
            r12[r4] = r13     // Catch:{ Exception -> 0x00a7 }
            r12[r5] = r13     // Catch:{ Exception -> 0x00a7 }
            java.lang.reflect.Method r0 = r0.getMethod(r11, r12)     // Catch:{ Exception -> 0x00a7 }
            java.lang.Object[] r11 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r12 = "gsm.version.baseband"
            r11[r4] = r12     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r12 = "no message"
            r11[r5] = r12     // Catch:{ Exception -> 0x00a7 }
            java.lang.Object r0 = r0.invoke(r10, r11)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x00a7 }
            goto L_0x00a8
        L_0x00a7:
            r0 = r9
        L_0x00a8:
            r2.basebandVersion = r0     // Catch:{ Exception -> 0x0138 }
            android.content.res.Resources r0 = r16.getResources()     // Catch:{ Exception -> 0x0138 }
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()     // Catch:{ Exception -> 0x0138 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0138 }
            r10.<init>()     // Catch:{ Exception -> 0x0138 }
            int r0 = r0.heightPixels     // Catch:{ Exception -> 0x0138 }
            r10.append(r0)     // Catch:{ Exception -> 0x0138 }
            r10.append(r9)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = r10.toString()     // Catch:{ Exception -> 0x0138 }
            r2.screenHeight = r0     // Catch:{ Exception -> 0x0138 }
            android.content.res.Resources r0 = r16.getResources()     // Catch:{ Exception -> 0x0138 }
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()     // Catch:{ Exception -> 0x0138 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0138 }
            r10.<init>()     // Catch:{ Exception -> 0x0138 }
            int r0 = r0.widthPixels     // Catch:{ Exception -> 0x0138 }
            r10.append(r0)     // Catch:{ Exception -> 0x0138 }
            r10.append(r9)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = r10.toString()     // Catch:{ Exception -> 0x0138 }
            r2.screenWidth = r0     // Catch:{ Exception -> 0x0138 }
            android.content.Context r0 = r16.getApplicationContext()     // Catch:{ Exception -> 0x0138 }
            r10 = 0
            java.lang.Object r11 = r0.getSystemService(r6)     // Catch:{ Exception -> 0x0100 }
            android.net.ConnectivityManager r11 = (android.net.ConnectivityManager) r11     // Catch:{ Exception -> 0x0100 }
            if (r11 != 0) goto L_0x00ef
        L_0x00ed:
            r0 = r10
            goto L_0x0114
        L_0x00ef:
            android.net.NetworkInfo r11 = r11.getNetworkInfo(r5)     // Catch:{ Exception -> 0x0100 }
            android.net.NetworkInfo$State r11 = r11.getState()     // Catch:{ Exception -> 0x0100 }
            android.net.NetworkInfo$State r12 = android.net.NetworkInfo.State.CONNECTED     // Catch:{ Exception -> 0x0100 }
            if (r11 == r12) goto L_0x0102
            android.net.NetworkInfo$State r12 = android.net.NetworkInfo.State.CONNECTING     // Catch:{ Exception -> 0x0100 }
            if (r11 != r12) goto L_0x00ed
            goto L_0x0102
        L_0x0100:
            goto L_0x00ed
        L_0x0102:
            java.lang.Object r0 = r0.getSystemService(r7)     // Catch:{ Exception -> 0x0100 }
            android.net.wifi.WifiManager r0 = (android.net.wifi.WifiManager) r0     // Catch:{ Exception -> 0x0100 }
            if (r0 == 0) goto L_0x00ed
            android.net.wifi.WifiInfo r7 = r0.getConnectionInfo()     // Catch:{ Exception -> 0x0100 }
            if (r7 == 0) goto L_0x00ed
            android.net.wifi.WifiInfo r0 = r0.getConnectionInfo()     // Catch:{ Exception -> 0x0100 }
        L_0x0114:
            if (r0 == 0) goto L_0x013b
            java.lang.String r7 = r0.getSSID()     // Catch:{ Exception -> 0x0138 }
            r2.wifiSSID = r7     // Catch:{ Exception -> 0x0138 }
            java.lang.String r7 = r0.getBSSID()     // Catch:{ Exception -> 0x0138 }
            r2.wifiBSSID = r7     // Catch:{ Exception -> 0x0138 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0138 }
            r7.<init>()     // Catch:{ Exception -> 0x0138 }
            int r0 = r0.getRssi()     // Catch:{ Exception -> 0x0138 }
            r7.append(r0)     // Catch:{ Exception -> 0x0138 }
            r7.append(r9)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x0138 }
            r2.wifiRSSI = r0     // Catch:{ Exception -> 0x0138 }
            goto L_0x013b
        L_0x0138:
            r0 = move-exception
            goto L_0x03a4
        L_0x013b:
            r11 = 1024(0x400, double:5.06E-321)
            java.io.File r0 = android.os.Environment.getDataDirectory()     // Catch:{ Exception -> 0x0169 }
            android.os.StatFs r7 = new android.os.StatFs     // Catch:{ Exception -> 0x0169 }
            java.lang.String r0 = r0.getPath()     // Catch:{ Exception -> 0x0169 }
            r7.<init>(r0)     // Catch:{ Exception -> 0x0169 }
            int r0 = r7.getBlockSize()     // Catch:{ Exception -> 0x0169 }
            long r13 = (long) r0     // Catch:{ Exception -> 0x0169 }
            int r0 = r7.getBlockCount()     // Catch:{ Exception -> 0x0169 }
            r15 = r6
            long r5 = (long) r0
            long r5 = r5 * r13
            long r5 = r5 / r11
            long r5 = r5 / r11
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x016a }
            r0.<init>()     // Catch:{ Exception -> 0x016a }
            r0.append(r5)     // Catch:{ Exception -> 0x016a }
            r0.append(r9)     // Catch:{ Exception -> 0x016a }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x016a }
            goto L_0x016b
        L_0x0169:
            r15 = r6
        L_0x016a:
            r0 = r9
        L_0x016b:
            r2.diskSpace = r0     // Catch:{ Exception -> 0x0138 }
            java.io.File r0 = android.os.Environment.getDataDirectory()     // Catch:{ Exception -> 0x0198 }
            android.os.StatFs r5 = new android.os.StatFs     // Catch:{ Exception -> 0x0198 }
            java.lang.String r0 = r0.getPath()     // Catch:{ Exception -> 0x0198 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x0198 }
            int r0 = r5.getBlockSize()     // Catch:{ Exception -> 0x0198 }
            long r13 = (long) r0     // Catch:{ Exception -> 0x0198 }
            int r0 = r5.getAvailableBlocks()     // Catch:{ Exception -> 0x0198 }
            long r5 = (long) r0     // Catch:{ Exception -> 0x0198 }
            long r5 = r5 * r13
            long r5 = r5 / r11
            long r5 = r5 / r11
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0198 }
            r0.<init>()     // Catch:{ Exception -> 0x0198 }
            r0.append(r5)     // Catch:{ Exception -> 0x0198 }
            r0.append(r9)     // Catch:{ Exception -> 0x0198 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0198 }
            goto L_0x0199
        L_0x0198:
            r0 = r9
        L_0x0199:
            r2.diskFreeSpace = r0     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = com.ktakilat.cbase.utils.DeviceUtils.e()     // Catch:{ Exception -> 0x0138 }
            r2.totalMemory = r0     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = com.ktakilat.cbase.utils.DeviceUtils.d(r16)     // Catch:{ Exception -> 0x0138 }
            r2.freeMemory = r0     // Catch:{ Exception -> 0x0138 }
            android.content.IntentFilter r0 = new android.content.IntentFilter     // Catch:{ Exception -> 0x01d5 }
            java.lang.String r5 = "android.intent.action.BATTERY_CHANGED"
            r0.<init>(r5)     // Catch:{ Exception -> 0x01d5 }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x01d5 }
            r6 = 33
            if (r5 < r6) goto L_0x01b9
            android.content.Intent r0 = r1.registerReceiver((android.content.BroadcastReceiver) null, r0, 1)     // Catch:{ Exception -> 0x01d5 }
            goto L_0x01bd
        L_0x01b9:
            android.content.Intent r0 = r1.registerReceiver(r10, r0)     // Catch:{ Exception -> 0x01d5 }
        L_0x01bd:
            if (r0 == 0) goto L_0x01d5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d5 }
            r5.<init>()     // Catch:{ Exception -> 0x01d5 }
            java.lang.String r6 = "level"
            int r0 = r0.getIntExtra(r6, r4)     // Catch:{ Exception -> 0x01d5 }
            r5.append(r0)     // Catch:{ Exception -> 0x01d5 }
            r5.append(r9)     // Catch:{ Exception -> 0x01d5 }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x01d5 }
            goto L_0x01d6
        L_0x01d5:
            r0 = r9
        L_0x01d6:
            r2.battery = r0     // Catch:{ Exception -> 0x0138 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0138 }
            r0.<init>()     // Catch:{ Exception -> 0x0138 }
            int r5 = android.hardware.Camera.getNumberOfCameras()     // Catch:{ Exception -> 0x0138 }
            r0.append(r5)     // Catch:{ Exception -> 0x0138 }
            r0.append(r9)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0138 }
            r2.cameraNum = r0     // Catch:{ Exception -> 0x0138 }
            r5 = -1
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x021b }
            r0.<init>()     // Catch:{ Exception -> 0x021b }
            java.lang.String r6 = "sensor"
            java.lang.Object r6 = r1.getSystemService(r6)     // Catch:{ Exception -> 0x021b }
            android.hardware.SensorManager r6 = (android.hardware.SensorManager) r6     // Catch:{ Exception -> 0x021b }
            java.util.List r6 = r6.getSensorList(r5)     // Catch:{ Exception -> 0x021b }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x021b }
        L_0x0203:
            boolean r11 = r6.hasNext()     // Catch:{ Exception -> 0x021b }
            if (r11 == 0) goto L_0x0217
            java.lang.Object r11 = r6.next()     // Catch:{ Exception -> 0x021b }
            android.hardware.Sensor r11 = (android.hardware.Sensor) r11     // Catch:{ Exception -> 0x021b }
            java.lang.String r11 = r11.getName()     // Catch:{ Exception -> 0x021b }
            r0.put(r11)     // Catch:{ Exception -> 0x021b }
            goto L_0x0203
        L_0x0217:
            java.lang.String r10 = r0.toString()     // Catch:{ Exception -> 0x021b }
        L_0x021b:
            r2.sensor = r10     // Catch:{ Exception -> 0x0138 }
            java.lang.Object r0 = r1.getSystemService(r8)     // Catch:{ Exception -> 0x0138 }
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch:{ Exception -> 0x0138 }
            if (r0 == 0) goto L_0x022a
            java.lang.String r0 = r0.getNetworkOperator()     // Catch:{ Exception -> 0x0138 }
            goto L_0x022b
        L_0x022a:
            r0 = r9
        L_0x022b:
            r2.networkOperator = r0     // Catch:{ Exception -> 0x0138 }
            java.lang.Object r0 = r1.getSystemService(r8)     // Catch:{ Exception -> 0x0138 }
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch:{ Exception -> 0x0138 }
            if (r0 == 0) goto L_0x023a
            java.lang.String r0 = r0.getNetworkCountryIso()     // Catch:{ Exception -> 0x0138 }
            goto L_0x023b
        L_0x023a:
            r0 = r9
        L_0x023b:
            r2.networkCountryIso = r0     // Catch:{ Exception -> 0x0138 }
            r6 = r15
            java.lang.Object r0 = r1.getSystemService(r6)     // Catch:{ Exception -> 0x0138 }
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch:{ Exception -> 0x0138 }
            if (r0 != 0) goto L_0x0248
        L_0x0246:
            r0 = r9
            goto L_0x0265
        L_0x0248:
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch:{ Exception -> 0x0138 }
            if (r0 == 0) goto L_0x0246
            boolean r6 = r0.isConnected()     // Catch:{ Exception -> 0x0138 }
            if (r6 == 0) goto L_0x0246
            int r0 = r0.getType()     // Catch:{ Exception -> 0x0138 }
            if (r0 == 0) goto L_0x0263
            r6 = 1
            if (r0 == r6) goto L_0x0260
            java.lang.String r0 = "OTHER"
            goto L_0x0265
        L_0x0260:
            java.lang.String r0 = "WIFI"
            goto L_0x0265
        L_0x0263:
            java.lang.String r0 = "MOBILE"
        L_0x0265:
            r2.networkType = r0     // Catch:{ Exception -> 0x0138 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0138 }
            r0.<init>()     // Catch:{ Exception -> 0x0138 }
            java.lang.Object r6 = r1.getSystemService(r8)     // Catch:{ Exception -> 0x0279 }
            android.telephony.TelephonyManager r6 = (android.telephony.TelephonyManager) r6     // Catch:{ Exception -> 0x0279 }
            if (r6 == 0) goto L_0x0279
            boolean r6 = r6.isNetworkRoaming()     // Catch:{ Exception -> 0x0279 }
            goto L_0x027a
        L_0x0279:
            r6 = 0
        L_0x027a:
            r0.append(r6)     // Catch:{ Exception -> 0x0138 }
            r0.append(r9)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0138 }
            r2.isNetworkingRoaming = r0     // Catch:{ Exception -> 0x0138 }
            java.lang.Object r0 = r1.getSystemService(r8)     // Catch:{ Exception -> 0x0138 }
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch:{ Exception -> 0x0138 }
            if (r0 == 0) goto L_0x0293
            java.lang.String r0 = r0.getSimCountryIso()     // Catch:{ Exception -> 0x0138 }
            goto L_0x0294
        L_0x0293:
            r0 = r9
        L_0x0294:
            r2.simCountryIso = r0     // Catch:{ Exception -> 0x0138 }
            java.lang.Object r0 = r1.getSystemService(r8)     // Catch:{ Exception -> 0x0138 }
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch:{ Exception -> 0x0138 }
            if (r0 == 0) goto L_0x02a3
            java.lang.String r0 = r0.getSimOperator()     // Catch:{ Exception -> 0x0138 }
            goto L_0x02a4
        L_0x02a3:
            r0 = r9
        L_0x02a4:
            r2.simOperator = r0     // Catch:{ Exception -> 0x0138 }
            java.lang.Object r0 = r1.getSystemService(r8)     // Catch:{ Exception -> 0x0138 }
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch:{ Exception -> 0x0138 }
            if (r0 == 0) goto L_0x02b3
            java.lang.String r0 = r0.getSimOperatorName()     // Catch:{ Exception -> 0x0138 }
            goto L_0x02b4
        L_0x02b3:
            r0 = r9
        L_0x02b4:
            r2.simOperatorName = r0     // Catch:{ Exception -> 0x0138 }
            java.lang.Object r0 = r1.getSystemService(r8)     // Catch:{ Exception -> 0x02c3 }
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch:{ Exception -> 0x02c3 }
            if (r0 == 0) goto L_0x02c3
            java.lang.String r0 = r0.getSubscriberId()     // Catch:{ Exception -> 0x02c3 }
            goto L_0x02c4
        L_0x02c3:
            r0 = r9
        L_0x02c4:
            r2.imsi = r0     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = com.ktakilat.cbase.utils.TelephonyUtils.e(r16)     // Catch:{ Exception -> 0x0138 }
            r2.appSign = r0     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = "/system/bin/su"
            java.lang.String r6 = "/system/xbin/su"
            java.lang.String[] r0 = new java.lang.String[]{r0, r6}     // Catch:{ Exception -> 0x02ef }
            r6 = 0
        L_0x02d5:
            if (r6 >= r3) goto L_0x02ef
            r8 = r0[r6]     // Catch:{ Exception -> 0x02ef }
            java.io.File r10 = new java.io.File     // Catch:{ Exception -> 0x02ef }
            r10.<init>(r8)     // Catch:{ Exception -> 0x02ef }
            boolean r10 = r10.exists()     // Catch:{ Exception -> 0x02ef }
            if (r10 == 0) goto L_0x02ec
            boolean r8 = com.ktakilat.cbase.utils.EnvUtils.f(r8)     // Catch:{ Exception -> 0x02ef }
            if (r8 == 0) goto L_0x02ec
            r7 = 1
            goto L_0x0309
        L_0x02ec:
            r7 = 1
            int r6 = r6 + r7
            goto L_0x02d5
        L_0x02ef:
            r7 = 1
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x02fc }
            java.lang.String r6 = "/system/app/Superuser.apk"
            r0.<init>(r6)     // Catch:{ Exception -> 0x02fc }
            boolean r0 = r0.exists()     // Catch:{ Exception -> 0x02fc }
            goto L_0x02fe
        L_0x02fc:
            r0 = 0
        L_0x02fe:
            if (r0 != 0) goto L_0x0309
            boolean r0 = com.ktakilat.cbase.utils.EnvUtils.b()     // Catch:{ Exception -> 0x0307 }
            if (r0 == 0) goto L_0x0307
            goto L_0x0309
        L_0x0307:
            r6 = 0
            goto L_0x030a
        L_0x0309:
            r6 = 1
        L_0x030a:
            r2.isRoot = r6     // Catch:{ Exception -> 0x0138 }
            boolean r0 = com.ktakilat.cbase.utils.EnvUtils.c(r16)     // Catch:{ Exception -> 0x0138 }
            r2.isSimulator = r0     // Catch:{ Exception -> 0x0138 }
            android.content.pm.ApplicationInfo r0 = r16.getApplicationInfo()     // Catch:{ Exception -> 0x031c }
            int r0 = r0.flags     // Catch:{ Exception -> 0x031c }
            r0 = r0 & r3
            if (r0 == 0) goto L_0x031c
            goto L_0x031d
        L_0x031c:
            r7 = 0
        L_0x031d:
            r2.isDebug = r7     // Catch:{ Exception -> 0x0138 }
            java.util.Locale r0 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = r0.getISO3Language()     // Catch:{ Exception -> 0x0138 }
            r2.localIso3Language = r0     // Catch:{ Exception -> 0x0138 }
            java.util.Locale r0 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = r0.getDisplayLanguage()     // Catch:{ Exception -> 0x0138 }
            r2.localDisplayLanguage = r0     // Catch:{ Exception -> 0x0138 }
            java.util.Locale r0 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = r0.getISO3Country()     // Catch:{ Exception -> 0x0138 }
            r2.localIso3Country = r0     // Catch:{ Exception -> 0x0138 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0347 }
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0347 }
            long r6 = r6 - r10
            goto L_0x034d
        L_0x0347:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x0138 }
            r6 = 0
        L_0x034d:
            r2.lastBootTime = r6     // Catch:{ Exception -> 0x0138 }
            android.content.res.Resources r0 = r16.getResources()     // Catch:{ Exception -> 0x035a }
            android.content.res.Configuration r0 = r0.getConfiguration()     // Catch:{ Exception -> 0x035a }
            int r5 = r0.keyboard     // Catch:{ Exception -> 0x035a }
            goto L_0x035e
        L_0x035a:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x0138 }
        L_0x035e:
            r2.keyboard = r5     // Catch:{ Exception -> 0x0138 }
            int r0 = com.ktakilat.cbase.utils.TelephonyUtils.f(r16)     // Catch:{ Exception -> 0x0138 }
            r2.dbm = r0     // Catch:{ Exception -> 0x0138 }
            com.ktakilat.cbase.http.phone.BatteryStatusInfo r0 = com.ktakilat.cbase.utils.TelephonyUtils.c(r16)     // Catch:{ Exception -> 0x0138 }
            if (r0 == 0) goto L_0x037c
            boolean r3 = r0.isCharging     // Catch:{ Exception -> 0x0138 }
            r2.isCharging = r3     // Catch:{ Exception -> 0x0138 }
            boolean r3 = r0.isUsbCharge     // Catch:{ Exception -> 0x0138 }
            r2.isUsbCharge = r3     // Catch:{ Exception -> 0x0138 }
            boolean r3 = r0.isAcCharge     // Catch:{ Exception -> 0x0138 }
            r2.isAcCharge = r3     // Catch:{ Exception -> 0x0138 }
            int r0 = r0.batteryTemperature     // Catch:{ Exception -> 0x0138 }
            r2.batteryTemp = r0     // Catch:{ Exception -> 0x0138 }
        L_0x037c:
            android.content.ContentResolver r0 = r16.getContentResolver()     // Catch:{ SettingNotFoundException -> 0x0387 }
            java.lang.String r3 = "screen_brightness"
            int r4 = android.provider.Settings.System.getInt(r0, r3)     // Catch:{ SettingNotFoundException -> 0x0387 }
            goto L_0x038b
        L_0x0387:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x0138 }
        L_0x038b:
            r2.brightness = r4     // Catch:{ Exception -> 0x0138 }
            java.lang.String r0 = com.ktakilat.cbase.utils.TelephonyUtils.d()     // Catch:{ Exception -> 0x0138 }
            r2.blueMac = r0     // Catch:{ Exception -> 0x0138 }
            boolean r0 = com.ktakilat.cbase.utils.TelephonyUtils.g(r16)     // Catch:{ Exception -> 0x0138 }
            r2.allowMockLocation = r0     // Catch:{ Exception -> 0x0138 }
            java.lang.String r9 = android.os.Build.CPU_ABI     // Catch:{ Exception -> 0x039c }
            goto L_0x03a1
        L_0x039c:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()     // Catch:{ Exception -> 0x0138 }
        L_0x03a1:
            r2.cpuHardware = r9     // Catch:{ Exception -> 0x0138 }
            goto L_0x03ab
        L_0x03a4:
            com.google.firebase.crashlytics.FirebaseCrashlytics r1 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            r1.recordException(r0)
        L_0x03ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.device.DeviceUtil.c(com.ktakilat.cbase.ui.BaseApplication, com.ktakilat.cbase.http.phone.DeviceExInfo):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0036 A[Catch:{ Exception -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String d(android.content.Context r2) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "wifi"
            java.lang.Object r2 = r2.getSystemService(r1)     // Catch:{ Exception -> 0x0025 }
            android.net.wifi.WifiManager r2 = (android.net.wifi.WifiManager) r2     // Catch:{ Exception -> 0x0025 }
            if (r2 == 0) goto L_0x002b
            android.net.wifi.WifiInfo r1 = r2.getConnectionInfo()     // Catch:{ Exception -> 0x0025 }
            if (r1 == 0) goto L_0x002b
            android.net.wifi.WifiInfo r1 = r2.getConnectionInfo()     // Catch:{ Exception -> 0x0025 }
            java.lang.String r1 = r1.getMacAddress()     // Catch:{ Exception -> 0x0025 }
            if (r1 == 0) goto L_0x002b
            android.net.wifi.WifiInfo r2 = r2.getConnectionInfo()     // Catch:{ Exception -> 0x0025 }
            java.lang.String r2 = r2.getMacAddress()     // Catch:{ Exception -> 0x0025 }
            goto L_0x002c
        L_0x0025:
            r2 = move-exception
            r2.toString()     // Catch:{ Exception -> 0x003b }
            java.util.ArrayList r2 = com.ktakilat.cbase.ui.LogActivity.k     // Catch:{ Exception -> 0x003b }
        L_0x002b:
            r2 = r0
        L_0x002c:
            if (r2 == 0) goto L_0x003d
            java.lang.String r1 = "02:00:00:00:00:00"
            boolean r1 = android.text.TextUtils.equals(r2, r1)     // Catch:{ Exception -> 0x003b }
            if (r1 == 0) goto L_0x003d
            java.lang.String r2 = h()     // Catch:{ Exception -> 0x003b }
            goto L_0x003d
        L_0x003b:
            r2 = move-exception
            goto L_0x003e
        L_0x003d:
            return r2
        L_0x003e:
            r2.toString()
            java.util.ArrayList r2 = com.ktakilat.cbase.ui.LogActivity.k
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.device.DeviceUtil.d(android.content.Context):java.lang.String");
    }

    public static long e() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                String file = Environment.getExternalStorageDirectory().toString();
                try {
                    StatFs statFs = new StatFs(file);
                    statFs.restat(file);
                    return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
                } catch (Exception e) {
                    e.toString();
                    ArrayList arrayList = LogActivity.k;
                    return -1;
                }
            }
        } catch (Exception e2) {
            e2.toString();
            ArrayList arrayList2 = LogActivity.k;
        }
        return -1;
    }

    public static String f(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return (String) packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager);
        } catch (Exception unused) {
            return context.getResources().getString(R.string.application_name);
        }
    }

    public static long g() {
        long j = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String str = bufferedReader.readLine().split(":")[1];
            j = Long.valueOf(str.substring(0, str.length() - 2).trim()).longValue();
            bufferedReader.close();
        } catch (IOException e) {
            e.toString();
            ArrayList arrayList = LogActivity.k;
        }
        return j * 1024;
    }

    public static String h() {
        try {
            for (T t : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (t.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = t.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02x:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "02:00:00:00:00:00";
        } catch (Exception e) {
            e.toString();
            ArrayList arrayList = LogActivity.k;
            return "02:00:00:00:00:00";
        }
    }
}
