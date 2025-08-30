package com.trustdecision.android.packagelists.ii11i111;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import okio.Utf8;
import org.apache.commons.lang3.CharEncoding;

public class ii11i111 {
    private static final String[] i1lill1 = {ii11i111("5c0d03424e0e0b171c070c4b", 55), ii11i111("5c5e50111b5a525a595b19", 100), ii11i111("5c2c22637f24342d2f2c222063", 22), ii11i111("581d151d1e1c5e5a1a1f030813185f", 35), ii11i111("5c3c3273762d2426223c77", 6), ii11i111("5c161859591e06065d", 44), ii11i111("5c2628697c3b2224282e6d", 28), ii11i111("5c4947061d5a5a5c04", 115), ii11i111("5c636d2c2e706f702e", 89), ii11i111("5c101e5f410e10021a071555", 42), ii11i111("5c737d3c226979323070756962797235", 73), ii11i111("5c323c7d7c37353f27277f", 8), ii11i111("5c525c1d0952475d5f5717", 104), ii11i111("5c202e6f65222a2d272c67", 26), ii11i111("5c4e4001004b53401a", 116), ii11i111("5c57591814565e4b57401b", 109), ii11i111("5c68662733687f657839", 82), ii11i111("5c707e3f21607d6b", 74), ii11i111("5c28266762383369", 18), ii11i111("5c222c6d7a203f65", 24), ii11i111("5c191756561d1908144e", 35), ii11i111("5c1719585817081f08121b59", 45), ii11i111("5c494706074e470e", 115), ii11i111("5c6967262f6e657c", 83), ii11i111("5c5d531210505a444d48570c", 103), ii11i111("5c414f0e0e45415e4216", 123), ii11i111("5c303e7f7a3d262a37212a77", 10), ii11i111("5c626c2d31766c7035", 88), ii11i111("5c27296872352c22383a2d206d", 29), ii11i111("5c6a642525647d7d7b7b656b29", 80), ii11i111("5c6d20207b776b682f", 86), ii11i111("5c4d43021b564e", 119), ii11i111("5c717f3e237f666e6236", 75), ii11i111("5c2d23627c3f2d32273c3b332e", 23), ii11i111("5c545a1b0c57441f", 110), ii11i111("5c0c0243491517000b011d130f09024b", 54), ii11i111("5c5957161e46465e4c475c5517", 99), ii11i111("5c7b7534286f75692c", 65), ii11i111("5c656b2a217d7e69616122", 95), ii11i111("5c343a7b772a3e3e65", 14), ii11i111("5c0c02435c170405060d1657", 54), ii11i111("5c7d73323c7a787e787e76707838", 71), ii11i111("5c36387977363a212b347f", 12), ii11i111("5c232d6c60232b21276e", 25), ii11i111("5c2e2061612a232f2a37332c67", 20)};
    private static StringBuilder ii11i111;
    private static final String[] ili11l1lll111i1 = {ii11i111("113c7f7f71", 71)};
    private static final HashMap li1lilil11i = new HashMap();
    private static final String[] llilllii1ili1111ll11 = {ii11i111("7c7f59585168615f5d47415c13", 98)};
    private static final ReentrantLock llliilil1ill1lii = new ReentrantLock();

    public static void i1lill1() {
    }

    public static PackageInfo ii11i111(PackageManager packageManager, String str) {
        PackageInfo packageInfo = null;
        try {
            ReentrantLock reentrantLock = llliilil1ill1lii;
            if (!reentrantLock.tryLock(50, TimeUnit.MILLISECONDS)) {
                reentrantLock.unlock();
                return null;
            } else if (TextUtils.isEmpty(str)) {
                reentrantLock.unlock();
                return null;
            } else {
                PackageInfo packageInfo2 = (PackageInfo) li1lilil11i.get(str);
                if (packageInfo2 != null) {
                    packageInfo = packageInfo2;
                }
                reentrantLock.unlock();
                return packageInfo;
            }
        } catch (Throwable unused) {
            llliilil1ill1lii.unlock();
        }
    }

    public static String ii11i111() {
        StringBuilder sb = ii11i111;
        if (sb == null) {
            return "";
        }
        String sb2 = sb.toString();
        if (sb2.length() <= 0 || !sb2.contains(ii11i111("13", 11))) {
            return sb2;
        }
        return (sb2.endsWith(ii11i111("13", 79)) || sb2.endsWith(ii11i111("05", 95)) || sb2.endsWith(ii11i111("15", 93))) ? sb2.substring(0, sb2.lastIndexOf(ii11i111("13", 12))) : sb2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0079 A[Catch:{ all -> 0x01c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0085 A[SYNTHETIC, Splitter:B:28:0x0085] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String ii11i111(android.content.Context r15) {
        /*
            java.util.concurrent.locks.ReentrantLock r0 = llliilil1ill1lii
            r0.lock()
            boolean r1 = com.trustdecision.android.packagelists.i1lill1.ii11i111.ii11i111(r15)     // Catch:{ all -> 0x01c0 }
            r2 = 0
            if (r1 != 0) goto L_0x0010
            r0.unlock()
            return r2
        L_0x0010:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c0 }
            r0.<init>()     // Catch:{ all -> 0x01c0 }
            ii11i111 = r0     // Catch:{ all -> 0x01c0 }
            java.lang.String r0 = "12"
            r1 = 71
            java.lang.String r0 = ii11i111((java.lang.String) r0, (int) r1)     // Catch:{ all -> 0x01c0 }
            android.content.pm.PackageManager r15 = r15.getPackageManager()     // Catch:{ all -> 0x01c0 }
            r1 = 0
            java.util.List r3 = r15.getInstalledPackages(r1)     // Catch:{ all -> 0x01c0 }
            r4 = 107(0x6b, float:1.5E-43)
            if (r3 == 0) goto L_0x005d
            int r5 = r3.size()     // Catch:{ all -> 0x01c0 }
            if (r5 != 0) goto L_0x0033
            goto L_0x005d
        L_0x0033:
            java.util.HashMap r15 = li1lilil11i     // Catch:{ all -> 0x01c0 }
            int r5 = r15.size()     // Catch:{ all -> 0x01c0 }
            if (r5 <= 0) goto L_0x003e
            r15.clear()     // Catch:{ all -> 0x01c0 }
        L_0x003e:
            r15 = 0
        L_0x003f:
            int r5 = r3.size()     // Catch:{ all -> 0x01c0 }
            if (r15 >= r5) goto L_0x0077
            java.lang.Object r5 = r3.get(r15)     // Catch:{ all -> 0x01c0 }
            android.content.pm.PackageInfo r5 = (android.content.pm.PackageInfo) r5     // Catch:{ all -> 0x01c0 }
            java.lang.String r6 = r5.packageName     // Catch:{ all -> 0x01c0 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x01c0 }
            if (r6 != 0) goto L_0x005a
            java.util.HashMap r6 = li1lilil11i     // Catch:{ all -> 0x01c0 }
            java.lang.String r7 = r5.packageName     // Catch:{ all -> 0x01c0 }
            r6.put(r7, r5)     // Catch:{ all -> 0x01c0 }
        L_0x005a:
            int r15 = r15 + 1
            goto L_0x003f
        L_0x005d:
            android.content.Intent r3 = new android.content.Intent     // Catch:{ all -> 0x01c0 }
            java.lang.String r5 = "5e1e1b070c171c5b56160b001a0b4b5e13060c171051721d1916"
            r6 = 39
            java.lang.String r5 = ii11i111((java.lang.String) r5, (int) r6)     // Catch:{ all -> 0x01c0 }
            r3.<init>(r5)     // Catch:{ all -> 0x01c0 }
            java.lang.String r5 = "5e52574b405b50171a5a474c564707105f484c5f5540560a3f5049465056504a"
            java.lang.String r5 = ii11i111((java.lang.String) r5, (int) r4)     // Catch:{ all -> 0x01c0 }
            r3.addCategory(r5)     // Catch:{ all -> 0x01c0 }
            java.util.List r3 = r15.queryIntentActivities(r3, r1)     // Catch:{ all -> 0x01c0 }
        L_0x0077:
            if (r3 != 0) goto L_0x0085
            java.lang.StringBuilder r15 = ii11i111     // Catch:{ all -> 0x01c0 }
            java.lang.String r15 = r15.toString()     // Catch:{ all -> 0x01c0 }
            java.util.concurrent.locks.ReentrantLock r0 = llliilil1ill1lii
            r0.unlock()
            return r15
        L_0x0085:
            java.util.Iterator r15 = r3.iterator()     // Catch:{ all -> 0x01c0 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x01c0 }
            r3.<init>()     // Catch:{ all -> 0x01c0 }
            r5 = r2
            r6 = 0
        L_0x0090:
            boolean r7 = r15.hasNext()     // Catch:{ all -> 0x01c0 }
            java.lang.String r8 = "13"
            if (r7 == 0) goto L_0x0166
            java.lang.Object r7 = r15.next()     // Catch:{ all -> 0x01c0 }
            boolean r9 = r7 instanceof android.content.pm.ResolveInfo     // Catch:{ all -> 0x01c0 }
            if (r9 == 0) goto L_0x00af
            r5 = r7
            android.content.pm.ResolveInfo r5 = (android.content.pm.ResolveInfo) r5     // Catch:{ all -> 0x01c0 }
            android.content.pm.ActivityInfo r5 = r5.activityInfo     // Catch:{ all -> 0x01c0 }
            android.content.pm.ApplicationInfo r5 = r5.applicationInfo     // Catch:{ all -> 0x01c0 }
            r9 = r7
            android.content.pm.ResolveInfo r9 = (android.content.pm.ResolveInfo) r9     // Catch:{ all -> 0x01c0 }
            android.content.pm.ActivityInfo r9 = r9.activityInfo     // Catch:{ all -> 0x01c0 }
            java.lang.String r9 = r9.packageName     // Catch:{ all -> 0x01c0 }
            goto L_0x00b1
        L_0x00af:
            r9 = r5
            r5 = r2
        L_0x00b1:
            boolean r10 = r7 instanceof android.content.pm.PackageInfo     // Catch:{ all -> 0x01c0 }
            if (r10 == 0) goto L_0x00bc
            android.content.pm.PackageInfo r7 = (android.content.pm.PackageInfo) r7     // Catch:{ all -> 0x01c0 }
            android.content.pm.ApplicationInfo r5 = r7.applicationInfo     // Catch:{ all -> 0x01c0 }
            java.lang.String r7 = r5.packageName     // Catch:{ all -> 0x01c0 }
            goto L_0x00bd
        L_0x00bc:
            r7 = r9
        L_0x00bd:
            if (r5 != 0) goto L_0x00c1
            goto L_0x0135
        L_0x00c1:
            int r9 = r5.flags     // Catch:{ all -> 0x01c0 }
            r10 = 1
            r9 = r9 & r10
            if (r9 <= 0) goto L_0x011b
            java.lang.String[] r9 = i1lill1     // Catch:{ all -> 0x01c0 }
            int r11 = r9.length     // Catch:{ all -> 0x01c0 }
            r12 = 0
        L_0x00cb:
            if (r12 >= r11) goto L_0x00f6
            r13 = r9[r12]     // Catch:{ all -> 0x01c0 }
            boolean r14 = r7.startsWith(r13)     // Catch:{ all -> 0x01c0 }
            if (r14 == 0) goto L_0x00f3
            java.lang.Object r9 = r3.get(r13)     // Catch:{ all -> 0x01c0 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x01c0 }
            if (r9 != 0) goto L_0x00e7
            java.lang.String r9 = "0e"
            java.lang.String r9 = ii11i111((java.lang.String) r9, (int) r4)     // Catch:{ all -> 0x01c0 }
        L_0x00e3:
            r3.put(r13, r9)     // Catch:{ all -> 0x01c0 }
            goto L_0x00f1
        L_0x00e7:
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ all -> 0x01c0 }
            int r9 = r9 + r10
            java.lang.String r9 = java.lang.Integer.toString(r9)     // Catch:{ all -> 0x01c0 }
            goto L_0x00e3
        L_0x00f1:
            r9 = 1
            goto L_0x00f7
        L_0x00f3:
            int r12 = r12 + 1
            goto L_0x00cb
        L_0x00f6:
            r9 = 0
        L_0x00f7:
            java.lang.String[] r11 = ili11l1lll111i1     // Catch:{ all -> 0x01c0 }
            int r12 = r11.length     // Catch:{ all -> 0x01c0 }
            r13 = 0
        L_0x00fb:
            if (r13 >= r12) goto L_0x010a
            r14 = r11[r13]     // Catch:{ all -> 0x01c0 }
            boolean r14 = r7.endsWith(r14)     // Catch:{ all -> 0x01c0 }
            if (r14 == 0) goto L_0x0107
            r9 = 1
            goto L_0x010a
        L_0x0107:
            int r13 = r13 + 1
            goto L_0x00fb
        L_0x010a:
            if (r9 != 0) goto L_0x0135
            java.lang.String r9 = "5e4a4f53584348"
            r11 = 115(0x73, float:1.61E-43)
            java.lang.String r9 = ii11i111((java.lang.String) r9, (int) r11)     // Catch:{ all -> 0x01c0 }
            boolean r9 = r9.equals(r7)     // Catch:{ all -> 0x01c0 }
            if (r9 == 0) goto L_0x011b
            goto L_0x0135
        L_0x011b:
            int r5 = r5.flags     // Catch:{ all -> 0x01c0 }
            r5 = r5 & r10
            if (r5 > 0) goto L_0x0135
            java.lang.String[] r5 = llilllii1ili1111ll11     // Catch:{ all -> 0x01c0 }
            int r9 = r5.length     // Catch:{ all -> 0x01c0 }
            r11 = 0
        L_0x0124:
            if (r11 >= r9) goto L_0x0132
            r12 = r5[r11]     // Catch:{ all -> 0x01c0 }
            boolean r12 = r7.startsWith(r12)     // Catch:{ all -> 0x01c0 }
            if (r12 == 0) goto L_0x012f
            goto L_0x0133
        L_0x012f:
            int r11 = r11 + 1
            goto L_0x0124
        L_0x0132:
            r10 = 0
        L_0x0133:
            if (r10 == 0) goto L_0x0138
        L_0x0135:
            r5 = r7
            goto L_0x0090
        L_0x0138:
            int r6 = r6 + 1
            r5 = 100
            if (r6 <= r5) goto L_0x013f
            goto L_0x0166
        L_0x013f:
            java.lang.StringBuilder r5 = ii11i111     // Catch:{ all -> 0x01c0 }
            int r5 = r5.length()     // Catch:{ all -> 0x01c0 }
            if (r5 <= 0) goto L_0x0152
            java.lang.StringBuilder r5 = ii11i111     // Catch:{ all -> 0x01c0 }
            r9 = 94
            java.lang.String r8 = ii11i111((java.lang.String) r8, (int) r9)     // Catch:{ all -> 0x01c0 }
            r5.append(r8)     // Catch:{ all -> 0x01c0 }
        L_0x0152:
            java.lang.StringBuilder r5 = ii11i111     // Catch:{ all -> 0x01c0 }
            r5.append(r7)     // Catch:{ all -> 0x01c0 }
            java.lang.String r8 = "05"
            r9 = 101(0x65, float:1.42E-43)
            java.lang.String r8 = ii11i111((java.lang.String) r8, (int) r9)     // Catch:{ all -> 0x01c0 }
            r5.append(r8)     // Catch:{ all -> 0x01c0 }
            r5.append(r0)     // Catch:{ all -> 0x01c0 }
            goto L_0x0135
        L_0x0166:
            java.util.Set r15 = r3.keySet()     // Catch:{ all -> 0x01c0 }
            java.util.Iterator r15 = r15.iterator()     // Catch:{ all -> 0x01c0 }
        L_0x016e:
            boolean r0 = r15.hasNext()     // Catch:{ all -> 0x01c0 }
            if (r0 == 0) goto L_0x01b4
            java.lang.Object r0 = r15.next()     // Catch:{ all -> 0x01c0 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x01c0 }
            java.lang.Object r1 = r3.get(r0)     // Catch:{ all -> 0x01c0 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x01c0 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x01c0 }
            r2 = 5
            if (r1 <= r2) goto L_0x016e
            java.lang.StringBuilder r1 = ii11i111     // Catch:{ all -> 0x01c0 }
            int r1 = r1.length()     // Catch:{ all -> 0x01c0 }
            if (r1 <= 0) goto L_0x019a
            java.lang.StringBuilder r1 = ii11i111     // Catch:{ all -> 0x01c0 }
            r2 = 49
            java.lang.String r2 = ii11i111((java.lang.String) r8, (int) r2)     // Catch:{ all -> 0x01c0 }
            r1.append(r2)     // Catch:{ all -> 0x01c0 }
        L_0x019a:
            java.lang.StringBuilder r1 = ii11i111     // Catch:{ all -> 0x01c0 }
            r1.append(r0)     // Catch:{ all -> 0x01c0 }
            java.lang.String r2 = "15"
            r4 = 122(0x7a, float:1.71E-43)
            java.lang.String r2 = ii11i111((java.lang.String) r2, (int) r4)     // Catch:{ all -> 0x01c0 }
            r1.append(r2)     // Catch:{ all -> 0x01c0 }
            java.lang.Object r0 = r3.get(r0)     // Catch:{ all -> 0x01c0 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x01c0 }
            r1.append(r0)     // Catch:{ all -> 0x01c0 }
            goto L_0x016e
        L_0x01b4:
            java.lang.StringBuilder r15 = ii11i111     // Catch:{ all -> 0x01c0 }
            java.lang.String r15 = r15.toString()     // Catch:{ all -> 0x01c0 }
            java.util.concurrent.locks.ReentrantLock r0 = llliilil1ill1lii
            r0.unlock()
            return r15
        L_0x01c0:
            java.util.concurrent.locks.ReentrantLock r15 = llliilil1ill1lii
            r15.unlock()
            java.lang.StringBuilder r15 = ii11i111
            java.lang.String r15 = r15.toString()
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.packagelists.ii11i111.ii11i111.ii11i111(android.content.Context):java.lang.String");
    }

    public static String ii11i111(Context context, ActivityManager activityManager) {
        if (context == null || activityManager == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(Integer.MAX_VALUE);
        if (runningTasks == null || runningTasks.size() == 0) {
            return sb.toString();
        }
        for (ActivityManager.RunningTaskInfo d : runningTasks) {
            String packageName = d.baseActivity.getPackageName();
            if (sb.length() > 0) {
                sb.append(ii11i111("13", 63));
            }
            sb.append(packageName);
        }
        return sb.toString();
    }

    private static String ii11i111(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 54);
            byte b2 = (byte) (bArr[0] ^ Utf8.REPLACEMENT_BYTE);
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
}
