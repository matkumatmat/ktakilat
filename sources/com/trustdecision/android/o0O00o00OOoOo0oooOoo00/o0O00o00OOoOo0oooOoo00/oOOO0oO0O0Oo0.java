package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0oOoooo0o0o0oOo;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o00ooooooO00OO0O00;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0oOO0oO00OoO0;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.O00OO0oOOooooO00000Oo;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
import com.trustdecision.android.shell.common.HelperJNI;
import java.io.File;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang3.CharEncoding;

public class oOOO0oO0O0Oo0 {
    private static final Map o0Oo0OO00O0O000ooOO0 = new HashMap();

    public static int O00OO0oOOooooO00000Oo() {
        String o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0("6e0235363c2b0c1a31272928616e2139", 14);
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        return (o0Oo0OO00O0O000ooOO0(systemClassLoader, o0Oo0OO00O0O000ooOO02) == 1 || o0Oo0OO00O0O000ooOO0(systemClassLoader.getParent(), o0Oo0OO00O0O000ooOO02) == 1) ? 1 : 0;
    }

    public static int O0oOO0ooO() {
        int i;
        int i2 = 0;
        try {
            Class.forName(o0Oo0OO00O0O000ooOO0("52256f783929307c6b2b2e323922296e722c3b3832256e520c3b38322502143f292726", 0));
            return 524288;
        } catch (Throwable unused) {
            i++;
        }
        if (i2 > 0) {
        }
        return i2;
    }

    public static String OO0000O0Ooo0OO000oo() {
        StringBuilder sb = new StringBuilder();
        File file = new File(o0Oo0OO00O0O000ooOO0("194412121f09105a511119021f44", 60));
        String o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0("18257f6d", 91);
        String[] list = file.list();
        if (list == null) {
            return sb.toString();
        }
        for (String str : list) {
            if (str != null && str.endsWith(o0Oo0OO00O0O000ooOO02)) {
                if (sb.length() > 0) {
                    sb.append(o0Oo0OO00O0O000ooOO0("1a", 57));
                }
                sb.append(str.substring(0, str.length() - 4));
            }
        }
        return (String) HelperJNI.o0Oo0OO00O0O000ooOO0(74, (Object) new Object[]{sb.toString().getBytes(), Boolean.TRUE});
    }

    public static String OoOOooOoooOoo() {
        try {
            String[] split = ((String) HelperJNI.o0Oo0OO00O0O000ooOO0(22, (Object) null)).split(o0Oo0OO00O0O000ooOO0("1a", 57));
            if (split.length == 1) {
                return split[0];
            }
            if (split.length < 2) {
                return "";
            }
            if (split[0].equals(split[1])) {
                return split[0];
            }
            return split[0] + o0Oo0OO00O0O000ooOO0("1a", 41) + split[1];
        } catch (Exception unused) {
            return "";
        }
    }

    public static int o00ooooooO00OO0O00() {
        Integer num = (Integer) HelperJNI.o0Oo0OO00O0O000ooOO0(31, (Object) new Object[]{2333});
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static int o0O00o00OOoOo0oooOoo00() {
        try {
            throw new Exception(o0Oo0OO00O0O000ooOO0("525343435445061a555256", 118));
        } catch (Exception e) {
            int i = 0;
            int i2 = 0;
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (o0Oo0OO00O0O000ooOO0("523a706726362f637434312d263d36716d3324272d3a714d1324272d3a1d0b20363839", 31).equals(stackTraceElement.getClassName()) && o0Oo0OO00O0O000ooOO0("5b4b4f40", 99).equals(stackTraceElement.getMethodName())) {
                    i |= 2;
                }
                if (o0Oo0OO00O0O000ooOO0("5218524504140d415616130f041f14534f1106050f18536f3106050f183f2902141a1b", 61).equals(stackTraceElement.getClassName()) && o0Oo0OO00O0O000ooOO0("5e3f393c3e3f1b11363238371f1e272a313d", 18).equals(stackTraceElement.getMethodName())) {
                    i |= 4;
                }
                if (o0Oo0OO00O0O000ooOO0("555c52131f5f5a464d565d1a17574a41474c5f5d12114c0d24734e584b417c77574d", 116).equals(stackTraceElement.getClassName()) && (i2 = i2 + 1) == 2) {
                    i |= 512;
                }
                if (o0Oo0OO00O0O000ooOO0("554a44051b5452415d44031b40515741405553570d25583150", 98).equals(stackTraceElement.getClassName()) && o0Oo0OO00O0O000ooOO0("5f362928353f30", 21).equals(stackTraceElement.getMethodName())) {
                    i |= 1024;
                }
            }
            return i;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x005d, code lost:
        r8 = (java.lang.String) r2.invoke(java.lang.reflect.Array.get(r8, 0), (java.lang.Object[]) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int o0Oo0OO00O0O000ooOO0(java.lang.ClassLoader r8, java.lang.String r9) {
        /*
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof dalvik.system.BaseDexClassLoader
            if (r1 != 0) goto L_0x0009
            return r0
        L_0x0009:
            java.lang.String r1 = "524c4453564b0c1443434e58410a23685461785c556d6c534e"
            r2 = 109(0x6d, float:1.53E-43)
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0((java.lang.String) r1, (int) r2)     // Catch:{ all -> 0x0070 }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x0070 }
            java.lang.String r2 = "52333b2c2934736b3c3c31273e755c172b1e07232a12132c3166571f3f3e3e3d2c"
            r3 = 18
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r2, (int) r3)     // Catch:{ all -> 0x0070 }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x0070 }
            java.lang.String r3 = "4276514a6b766a64"
            r4 = 73
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x0070 }
            r4 = 0
            java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{ all -> 0x0070 }
            java.lang.String r3 = "52061a3a2e0e0f0f0c1d00"
            r5 = 35
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0((java.lang.String) r3, (int) r5)     // Catch:{ all -> 0x0070 }
            java.lang.reflect.Field r1 = r1.getDeclaredField(r3)     // Catch:{ all -> 0x0070 }
            r3 = 1
            r1.setAccessible(r3)     // Catch:{ all -> 0x0070 }
            java.lang.Class<dalvik.system.BaseDexClassLoader> r5 = dalvik.system.BaseDexClassLoader.class
            java.lang.String r6 = "466c68615958677a"
            r7 = 89
            java.lang.String r6 = o0Oo0OO00O0O000ooOO0((java.lang.String) r6, (int) r7)     // Catch:{ all -> 0x0070 }
            java.lang.reflect.Field r5 = r5.getDeclaredField(r6)     // Catch:{ all -> 0x0070 }
            r5.setAccessible(r3)     // Catch:{ all -> 0x0070 }
            java.lang.Object r8 = r5.get(r8)     // Catch:{ all -> 0x0070 }
            java.lang.Object r8 = r1.get(r8)     // Catch:{ all -> 0x0070 }
            int r1 = java.lang.reflect.Array.getLength(r8)     // Catch:{ all -> 0x0070 }
            if (r1 <= 0) goto L_0x0070
            java.lang.Object r8 = java.lang.reflect.Array.get(r8, r0)     // Catch:{ all -> 0x0070 }
            java.lang.Object r8 = r2.invoke(r8, r4)     // Catch:{ all -> 0x0070 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0070 }
            if (r8 == 0) goto L_0x0070
            boolean r8 = r8.contains(r9)     // Catch:{ all -> 0x0070 }
            if (r8 == 0) goto L_0x0070
            return r3
        L_0x0070:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOOO0oO0O0Oo0.o0Oo0OO00O0O000ooOO0(java.lang.ClassLoader, java.lang.String):int");
    }

    public static int oO00o0OooO0OO0o0000o() {
        int i = 0;
        try {
            HashSet hashSet = new HashSet();
            Iterator it = o0oOO0oO00OoO0.o0Oo0OO00O0O000ooOO0().iterator();
            if (it == null) {
                return 0;
            }
            o0Oo0OO00O0O000ooOO0("181f5e", 102);
            o0Oo0OO00O0O000ooOO0("18266971", 70);
            o0Oo0OO00O0O000ooOO0("4e5047444e595e4843555b5a", 124);
            o0Oo0OO00O0O000ooOO0("5a0c02130116151f0832371a0f535415", 45);
            o0Oo0OO00O0O000ooOO0("55757b3a246b6d7e627b3c247f6e687e7f6a6c68", 93);
            o0Oo0OO00O0O000ooOO0("42302d2f2e24131729232b3f3d", 1);
            o0Oo0OO00O0O000ooOO0("16", 38);
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!TextUtils.isEmpty(str)) {
                    if (str.endsWith(o0Oo0OO00O0O000ooOO0("181253", 107)) || str.endsWith(o0Oo0OO00O0O000ooOO0("186f2038", 15))) {
                        hashSet.add(str.substring(str.lastIndexOf(o0Oo0OO00O0O000ooOO0("16", 109)) + 1));
                    }
                }
            }
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                String str2 = (String) it2.next();
                String lowerCase = str2.toLowerCase();
                if (lowerCase.contains(o0Oo0OO00O0O000ooOO0("4e667172786f687e75636d6c", 74)) || lowerCase.contains(o0Oo0OO00O0O000ooOO0("5a3a3425372023293e04012c39656223", 27))) {
                    i |= 8;
                }
                if (str2.contains(o0Oo0OO00O0O000ooOO0("55616f2e307f796a766f28306b7a7c6a6b7e787c", 73))) {
                    i |= 2048;
                }
                if (str2.contains(o0Oo0OO00O0O000ooOO0("42485557565c6b6f515b534745", 121))) {
                    i |= 32;
                }
            }
            return i;
        } catch (Exception unused) {
        }
    }

    public static int o0O00o00OOoOo0oooOoo00(Context context) {
        o0Oo0OO00O0O000ooOO0("52367c6b2a3a236f78383d212a313a7d613f282b21367d70302a30223a373e20", 19);
        o0Oo0OO00O0O000ooOO0("55535d1c024d4b58445d1a0259484e58594c4a4e", 123);
        PackageManager packageManager = context.getPackageManager();
        int i = 0;
        try {
            O00OO0oOOooooO00000Oo o00OO0oOOooooO00000Oo = (O00OO0oOOooooO00000Oo) o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("555d53120b575657564150575b4b4b5750111e5e5b474c575c1b0f4053595b575358544b56560c180f5119190f51471951194747190f4719197f5e4d", 117));
            if (o00OO0oOOooooO00000Oo == null) {
                return 0;
            }
            PackageInfo o0Oo0OO00O0O000ooOO02 = o00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(packageManager, o0Oo0OO00O0O000ooOO0("52054f581909105c4b0b0e121902094e520c1b1812054e430319031109040d13", 32));
            if (o0Oo0OO00O0O000ooOO02 != null && o0Oo0OO00O0O000ooOO0("527f352263736a26317174686378733428766162687f34397963796b737e7769", 90).equals(o0Oo0OO00O0O000ooOO02.packageName)) {
                i = 1;
            }
            PackageInfo o0Oo0OO00O0O000ooOO03 = o00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(packageManager, o0Oo0OO00O0O000ooOO0("55747a3b256a6c7f637a3d257e6f697f7e6b6d69", 92));
            return (o0Oo0OO00O0O000ooOO03 == null || !o0Oo0OO00O0O000ooOO0("55252b6a743b3d2e322b6c742f3e382e2f3a3c38", 13).equals(o0Oo0OO00O0O000ooOO03.packageName)) ? i : i | 256;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String o0Oo0OO00O0O000ooOO0(Context context) {
        SigningInfo h;
        Signature[] p;
        String packageName = context.getPackageName();
        try {
            Signature[] signatureArr = ((PackageInfo) o00ooooooO00OO0O00.O00OO0oOOooooO00000Oo(o00ooooooO00OO0O00.O0oOO0ooO[1], new oOOo0O0OooOO(context, packageName))).signatures;
            if (!(Build.VERSION.SDK_INT < 28 || (h = context.getPackageManager().getPackageInfo(packageName, 134217728).signingInfo) == null || (p = h.getApkContentsSigners()) == null)) {
                String str = (String) HelperJNI.o0Oo0OO00O0O000ooOO0(73, (Object) new Object[]{p[0].toByteArray()});
                if (!TextUtils.isEmpty(str)) {
                    HelperJNI.o0Oo0OO00O0O000ooOO0(72, (Object) new Object[]{str});
                }
            }
            return (String) HelperJNI.o0Oo0OO00O0O000ooOO0(73, (Object) new Object[]{signatureArr[0].toByteArray()});
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String oO00o0OooO0OO0o0000o(Context context) {
        try {
            String packageName = context.getPackageName();
            String str = ((PackageInfo) o00ooooooO00OO0O00.O00OO0oOOooooO00000Oo(o00ooooooO00OO0O00.O0oOO0ooO[0], new Oo0O00OooOO00(context, packageName))).versionName;
            return packageName + o0Oo0OO00O0O000ooOO0("1c3a", 18) + str;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String o0Oo0OO00O0O000ooOO0(Context context, ConnectivityManager connectivityManager, WifiManager wifiManager) {
        return "";
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
            byte b = (byte) (i ^ 36);
            byte b2 = (byte) (bArr[0] ^ 54);
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

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.util.ArrayList o0Oo0OO00O0O000ooOO0(java.lang.Class r9, boolean r10) {
        /*
            r0 = 2
            r1 = 1
            r2 = 0
            java.lang.Class<com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOOO0oO0O0Oo0> r3 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOOO0oO0O0Oo0.class
            monitor-enter(r3)
            r4 = 0
            java.lang.String r5 = "524b4354514c0b134444495f460d3655476f49595c"
            r6 = 106(0x6a, float:1.49E-43)
            java.lang.String r5 = o0Oo0OO00O0O000ooOO0((java.lang.String) r5, (int) r6)     // Catch:{ all -> 0x0053 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x0053 }
            java.lang.String r6 = "513c2f031923392b3133382802171b11332c3e2828"
            r7 = 26
            java.lang.String r6 = o0Oo0OO00O0O000ooOO0((java.lang.String) r6, (int) r7)     // Catch:{ all -> 0x0053 }
            java.lang.Class[] r7 = new java.lang.Class[r0]     // Catch:{ all -> 0x0053 }
            java.lang.Class<java.lang.Class[]> r8 = java.lang.Class[].class
            r7[r2] = r8     // Catch:{ all -> 0x0053 }
            java.lang.Class r8 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0053 }
            r7[r1] = r8     // Catch:{ all -> 0x0053 }
            java.lang.reflect.Method r5 = r5.getDeclaredMethod(r6, r7)     // Catch:{ all -> 0x0053 }
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ all -> 0x0053 }
            r6[r2] = r9     // Catch:{ all -> 0x0053 }
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r10)     // Catch:{ all -> 0x0053 }
            java.lang.Object[] r10 = new java.lang.Object[r0]     // Catch:{ all -> 0x0053 }
            r10[r2] = r6     // Catch:{ all -> 0x0053 }
            r10[r1] = r9     // Catch:{ all -> 0x0053 }
            java.lang.Object r9 = r5.invoke(r4, r10)     // Catch:{ all -> 0x0053 }
            java.lang.Object[][] r9 = (java.lang.Object[][]) r9     // Catch:{ all -> 0x0053 }
            if (r9 == 0) goto L_0x0053
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x0053 }
            r10.<init>()     // Catch:{ all -> 0x0053 }
            int r0 = r9.length     // Catch:{ all -> 0x0052 }
        L_0x0045:
            if (r2 >= r0) goto L_0x0052
            r4 = r9[r2]     // Catch:{ all -> 0x0052 }
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ all -> 0x0052 }
            r10.addAll(r4)     // Catch:{ all -> 0x0052 }
            int r2 = r2 + r1
            goto L_0x0045
        L_0x0052:
            r4 = r10
        L_0x0053:
            monitor-exit(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOOO0oO0O0Oo0.o0Oo0OO00O0O000ooOO0(java.lang.Class, boolean):java.util.ArrayList");
    }

    public static Map o0Oo0OO00O0O000ooOO0(Context context, String str) {
        if (!o0Oo0OO00O0O000ooOO0("575b56", 114).equals(str)) {
            return o0Oo0OO00O0O000ooOO0;
        }
        Map map = o0Oo0OO00O0O000ooOO0;
        if (map.containsKey(str) || !O0oOoooo0o0o0oOo.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0("57393c202b303b7c68232129322c362c30377651312c27212a3d27", 18))) {
            return map;
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (T name : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                arrayList.add(name.getName());
            }
            String obj = arrayList.toString();
            o0Oo0OO00O0O000ooOO0.put(o0Oo0OO00O0O000ooOO0("572f22", 6), obj.substring(1, obj.length() - 1));
        } catch (SocketException unused) {
        }
        return o0Oo0OO00O0O000ooOO0;
    }

    public static void o0Oo0OO00O0O000ooOO0() {
        o0Oo0OO00O0O000ooOO0.clear();
    }
}
