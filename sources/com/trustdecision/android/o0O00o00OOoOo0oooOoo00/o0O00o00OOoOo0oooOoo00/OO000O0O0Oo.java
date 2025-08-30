package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import android.content.Context;
import android.text.TextUtils;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.Oo0O0Oo0OO0OOOoOO0O0;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0oOO0oO00OoO0;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo;
import com.trustdecision.android.shell.common.HelperJNI;
import com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0;
import java.io.File;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.commons.lang3.CharEncoding;

public class OO000O0O0Oo {
    private static String o0O00o00OOoOo0oooOoo00;
    private static int o0Oo0OO00O0O000ooOO0;

    public static class o0Oo0OO00O0O000ooOO0 implements Runnable {
        private Context o0O00o00OOoOo0oooOoo00;
        private String o0Oo0OO00O0O000ooOO0;

        public o0Oo0OO00O0O000ooOO0(Context context, String str) {
            this.o0Oo0OO00O0O000ooOO0 = str;
            this.o0O00o00OOoOo0oooOoo00 = context;
        }

        public void run() {
            try {
                OO000O0O0Oo.O00OO0oOOooooO00000Oo(this.o0O00o00OOoOo0oooOoo00, OO000O0O0Oo.o0O00o00OOoOo0oooOoo00(1, this.o0Oo0OO00O0O000ooOO0));
                OO000O0O0Oo.O0oOO0ooO(this.o0O00o00OOoOo0oooOoo00, OO000O0O0Oo.o0O00o00OOoOo0oooOoo00(2, this.o0Oo0OO00O0O000ooOO0));
                if (com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().Oo0OO00oooO0Ooo000ooOo) {
                    OO000O0O0Oo.o00ooooooO00OO0O00(this.o0O00o00OOoOo0oooOoo00, OO000O0O0Oo.o0O00o00OOoOo0oooOoo00(3, this.o0Oo0OO00O0O000ooOO0));
                }
            } catch (Exception unused) {
            }
        }
    }

    private static synchronized String O00OO0oOOooooO00000Oo(Context context) {
        String o0Oo0OO00O0O000ooOO02;
        synchronized (OO000O0O0Oo.class) {
            o0Oo0OO00O0O000ooOO02 = o0oOO0oO00OoO0.o0Oo0OO00O0O000ooOO0(new File(context.getFilesDir().getAbsolutePath(), Oo0O0Oo0OO0OOOoOO0O0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("1452184116", 118))));
        }
        return o0Oo0OO00O0O000ooOO02;
    }

    /* access modifiers changed from: private */
    public static String O0oOO0ooO(Context context) {
        Object o0Oo0OO00O0O000ooOO02;
        ReentrantLock reentrantLock = new ReentrantLock();
        try {
            if (reentrantLock.tryLock(500, TimeUnit.MILLISECONDS) && (o0Oo0OO00O0O000ooOO02 = HelperJNI.o0Oo0OO00O0O000ooOO0(70, (Object) null)) != null) {
                String str = (String) o0Oo0OO00O0O000ooOO02;
                reentrantLock.unlock();
                return str;
            }
        } catch (Throwable unused) {
        }
        reentrantLock.unlock();
        return null;
    }

    /* access modifiers changed from: private */
    public static void o00ooooooO00OO0O00(Context context, String str) {
        ReentrantLock reentrantLock = new ReentrantLock();
        try {
            if (reentrantLock.tryLock(500, TimeUnit.MILLISECONDS)) {
                HelperJNI.o0Oo0OO00O0O000ooOO0(69, (Object) new Object[]{str});
            }
        } catch (Throwable unused) {
        }
        reentrantLock.unlock();
    }

    public static String o0O00o00OOoOo0oooOoo00() {
        return o0O00o00OOoOo0oooOoo00;
    }

    public static int o0Oo0OO00O0O000ooOO0() {
        return o0Oo0OO00O0O000ooOO0;
    }

    private static String oO00o0OooO0OO0o0000o() {
        return (String) HelperJNI.o0Oo0OO00O0O000ooOO0(2, (Object) new Object[]{UUID.randomUUID().toString()});
    }

    /* access modifiers changed from: private */
    public static void O00OO0oOOooooO00000Oo(Context context, String str) {
        O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, Oo0O0Oo0OO0OOOoOO0O0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4e5c050243494047561508410552", 50)), str);
    }

    /* access modifiers changed from: private */
    public static synchronized void O0oOO0ooO(Context context, String str) {
        synchronized (OO000O0O0Oo.class) {
            o0oOO0oO00OoO0.o0Oo0OO00O0O000ooOO0(new File(context.getFilesDir().getAbsolutePath(), Oo0O0Oo0OO0OOOoOO0O0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("14672d7423", 67))), str);
        }
    }

    /* access modifiers changed from: private */
    public static String o0O00o00OOoOo0oooOoo00(int i, String str) {
        if (str == null) {
            return null;
        }
        String str2 = (String) HelperJNI.o0Oo0OO00O0O000ooOO0(3, (Object) new Object[]{Integer.valueOf(i)});
        if (str2 == null) {
            return null;
        }
        try {
            return new String(com.trustdecision.android.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(str.getBytes(o0Oo0OO00O0O000ooOO0("4f62712876", 29)), str2.getBytes(o0Oo0OO00O0O000ooOO0("4f1b08510f", 100))), o0Oo0OO00O0O000ooOO0("4f7a69306e", 5));
        } catch (Exception unused) {
            return null;
        }
    }

    private static String oO00o0OooO0OO0o0000o(int i, String str) {
        String str2 = (String) HelperJNI.o0Oo0OO00O0O000ooOO0(3, (Object) new Object[]{Integer.valueOf(i)});
        if (str2 == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(com.trustdecision.android.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00(str.getBytes(o0Oo0OO00O0O000ooOO0("4f495a035d", 54)), str2.getBytes(o0Oo0OO00O0O000ooOO0("4f72613866", 13))), o0Oo0OO00O0O000ooOO0("4f17045d03", 104));
        } catch (Throwable th) {
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.Oo0O0Oo0OO0OOOoOO0O0, th.getMessage());
            o0Oo0OO00O0O000ooOO0 = (16 << i) | o0Oo0OO00O0O000ooOO0;
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String o0Oo0OO00O0O000ooOO0(android.content.Context r17) {
        /*
            r0 = r17
            r1 = 0
            o0Oo0OO00O0O000ooOO0 = r1
            r2 = 4
            java.lang.String[] r3 = new java.lang.String[r2]
            java.io.File r4 = new java.io.File
            java.io.File r5 = r17.getFilesDir()
            java.lang.String r5 = r5.getAbsolutePath()
            java.lang.String r6 = "143b71287f"
            r7 = 31
            java.lang.String r6 = o0Oo0OO00O0O000ooOO0((java.lang.String) r6, (int) r7)
            r4.<init>(r5, r6)
            java.lang.String r4 = r4.getAbsolutePath()
            java.lang.String r5 = "4e7f2621606a636475362b622671"
            r6 = 17
            java.lang.String r5 = o0Oo0OO00O0O000ooOO0((java.lang.String) r5, (int) r6)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.Oo0O0Oo0OO0OOOoOO0O0.o0Oo0OO00O0O000ooOO0(r0, r4, r5)
            java.lang.String r4 = "4e41181f5e545d5a4b08155c184f"
            r5 = 47
            java.lang.String r4 = o0Oo0OO00O0O000ooOO0((java.lang.String) r4, (int) r5)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.Oo0O0Oo0OO0OOOoOO0O0.o0Oo0OO00O0O000ooOO0((android.content.Context) r0, (java.lang.String) r4)
            java.lang.String r4 = ""
            r3[r1] = r4
            java.lang.String r4 = oO00o0OooO0OO0o0000o(r17)
            r5 = 1
            r3[r5] = r4
            java.lang.String r4 = O00OO0oOOooooO00000Oo(r17)
            r6 = 2
            r3[r6] = r4
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 r4 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo()
            boolean r4 = r4.Oo0OO00oooO0Ooo000ooOo
            r7 = 3
            r8 = 0
            if (r4 == 0) goto L_0x0080
            java.util.concurrent.ThreadPoolExecutor r4 = new java.util.concurrent.ThreadPoolExecutor
            java.util.concurrent.TimeUnit r14 = java.util.concurrent.TimeUnit.SECONDS
            java.util.concurrent.LinkedBlockingDeque r15 = new java.util.concurrent.LinkedBlockingDeque
            r15.<init>()
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o$o0O00o00OOoOo0oooOoo00 r16 = new com.trustdecision.android.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o$o0O00o00OOoOo0oooOoo00
            r16.<init>()
            r11 = 1
            r12 = 0
            r9 = r4
            r10 = r11
            r9.<init>(r10, r11, r12, r14, r15, r16)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0O0o0ooOOo0oO0 r9 = new com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.o0Oo0O0o0ooOOo0oO0
            r9.<init>(r3, r0)
            java.util.concurrent.Future r9 = r4.submit(r9)
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x007c }
            r11 = 300(0x12c, double:1.48E-321)
            r9.get(r11, r10)     // Catch:{ all -> 0x007c }
            r9.isDone()     // Catch:{ all -> 0x007c }
        L_0x007c:
            r4.shutdown()
            goto L_0x0082
        L_0x0080:
            r3[r7] = r8
        L_0x0082:
            r4 = 1
        L_0x0083:
            if (r4 >= r2) goto L_0x0099
            r9 = r3[r4]
            if (r9 == 0) goto L_0x008f
            int r9 = r9.length()
            if (r9 != 0) goto L_0x0096
        L_0x008f:
            int r9 = o0Oo0OO00O0O000ooOO0
            int r10 = r5 << r4
            r9 = r9 | r10
            o0Oo0OO00O0O000ooOO0 = r9
        L_0x0096:
            int r4 = r4 + 1
            goto L_0x0083
        L_0x0099:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r9 = r3[r5]
            java.lang.String r9 = oO00o0OooO0OO0o0000o((int) r5, (java.lang.String) r9)
            r10 = r3[r6]
            java.lang.String r10 = oO00o0OooO0OO0o0000o((int) r6, (java.lang.String) r10)
            java.lang.String[] r9 = new java.lang.String[]{r8, r9, r10, r8}
            boolean r10 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0oo0o00oooo.o0Oo0OO00O0O000ooOO0((java.lang.String[]) r9)
            java.lang.String r11 = "19"
            if (r10 == 0) goto L_0x00dd
            java.lang.String r2 = oO00o0OooO0OO0o0000o()
            java.lang.Thread r5 = new java.lang.Thread
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.OO000O0O0Oo$o0Oo0OO00O0O000ooOO0 r6 = new com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.OO000O0O0Oo$o0Oo0OO00O0O000ooOO0
            r6.<init>(r0, r2)
            r5.<init>(r6)
            java.lang.String r0 = "4e303130312637303c2c2c303769"
            r6 = 72
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r6)
            r5.setName(r0)
            r5.start()
            r0 = 114(0x72, float:1.6E-43)
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r11, (int) r0)
        L_0x00d8:
            r4.append(r0)
            goto L_0x018a
        L_0x00dd:
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            r12 = 0
        L_0x00e3:
            if (r12 >= r2) goto L_0x011d
            r13 = r9[r12]
            boolean r14 = android.text.TextUtils.isEmpty(r13)
            if (r14 != 0) goto L_0x011a
            java.lang.String r14 = "5444465f"
            r15 = 33
            java.lang.String r14 = o0Oo0OO00O0O000ooOO0((java.lang.String) r14, (int) r15)
            boolean r14 = r14.equals(r13)
            if (r14 == 0) goto L_0x00fc
            goto L_0x011a
        L_0x00fc:
            boolean r14 = r10.containsKey(r13)
            if (r14 == 0) goto L_0x0115
            java.lang.Object r14 = r10.get(r13)
            java.lang.Integer r14 = (java.lang.Integer) r14
            int r14 = r14.intValue()
            int r14 = r14 + r5
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
        L_0x0111:
            r10.put(r13, r14)
            goto L_0x011a
        L_0x0115:
            java.lang.Integer r14 = java.lang.Integer.valueOf(r5)
            goto L_0x0111
        L_0x011a:
            int r12 = r12 + 1
            goto L_0x00e3
        L_0x011d:
            java.util.TreeMap r2 = new java.util.TreeMap
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.Oo0o000OO r12 = new com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.Oo0o000OO
            r12.<init>(r10)
            r2.<init>(r12)
            r2.putAll(r10)
            java.lang.Object r2 = r2.firstKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Thread r10 = new java.lang.Thread
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.OO000O0O0Oo$o0Oo0OO00O0O000ooOO0 r12 = new com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.OO000O0O0Oo$o0Oo0OO00O0O000ooOO0
            r12.<init>(r0, r2)
            r10.<init>(r12)
            java.lang.String r0 = "4e282928293e2f28243434282f71"
            r12 = 80
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r12)
            r10.setName(r0)
            r10.start()
            r0 = r9[r5]
            if (r0 == 0) goto L_0x0158
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0158
            int r0 = o0Oo0OO00O0O000ooOO0
            r0 = r0 | 512(0x200, float:7.175E-43)
            o0Oo0OO00O0O000ooOO0 = r0
        L_0x0158:
            r0 = r9[r6]
            if (r0 == 0) goto L_0x0168
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0168
            int r0 = o0Oo0OO00O0O000ooOO0
            r0 = r0 | 1024(0x400, float:1.435E-42)
            o0Oo0OO00O0O000ooOO0 = r0
        L_0x0168:
            r0 = r9[r5]
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0175
            r0 = r9[r5]
            r4.append(r0)
        L_0x0175:
            r0 = 36
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r11, (int) r0)
            r4.append(r0)
            r0 = r9[r6]
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x018a
            r0 = r9[r6]
            goto L_0x00d8
        L_0x018a:
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 r0 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo()
            boolean r0 = r0.Oo0OO00oooO0Ooo000ooOo
            if (r0 == 0) goto L_0x0198
            r0 = r3[r7]
            java.lang.String r8 = oO00o0OooO0OO0o0000o((int) r7, (java.lang.String) r0)
        L_0x0198:
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 != 0) goto L_0x01b6
            r0 = 24
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r11, (int) r0)
            r4.append(r0)
            java.lang.String r0 = "495c4b7d"
            r1 = 56
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r1)
            r4.append(r0)
            r4.append(r8)
            goto L_0x01cd
        L_0x01b6:
            java.lang.String r0 = r4.toString()
            r3 = 95
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0((java.lang.String) r11, (int) r3)
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x01cd
            int r0 = r4.length()
            r4.delete(r1, r0)
        L_0x01cd:
            java.lang.String r0 = r4.toString()
            o0O00o00OOoOo0oooOoo00 = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.OO000O0O0Oo.o0Oo0OO00O0O000ooOO0(android.content.Context):java.lang.String");
    }

    private static String oO00o0OooO0OO0o0000o(Context context) {
        String o0O00o00OOoOo0oooOoo002 = O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(context, Oo0O0Oo0OO0OOOoOO0O0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4e461f1859535a5d4c0f125b1f48", 40)), "");
        if ("".equals(o0O00o00OOoOo0oooOoo002)) {
            return null;
        }
        return o0O00o00OOoOo0oooOoo002;
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
            byte b = (byte) (i ^ 126);
            byte b2 = (byte) (bArr[0] ^ 58);
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
