package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.O0oOO0ooO;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
import com.trustdecision.android.shell.common.HelperJNI;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Locale;
import org.apache.commons.lang3.CharEncoding;
import org.json.JSONObject;

public class O00OO0oOOooooO00000Oo {
    private static final Object O00OO0oOOooooO00000Oo = new Object();
    private static O0oOO0ooO O0oOO0ooO = null;
    private static int OO0000O0Ooo0OO000oo = 0;
    private static final HashSet o00ooooooO00OO0O00 = new HashSet();
    public static final String o0O00o00OOoOo0oooOoo00 = o0O00o00OOoOo0oooOoo00("1c441d1b541b0f56", 71);
    public static final String o0Oo0OO00O0O000ooOO0 = o0O00o00OOoOo0oooOoo00("1c3e2e2c", 61);
    private static final Object oO00o0OooO0OO0o0000o = new Object();

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean O00OO0oOOooooO00000Oo(android.content.Context r7) {
        /*
            java.lang.Object r0 = O00OO0oOOooooO00000Oo
            monitor-enter(r0)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.O0oOO0ooO r1 = o0O00o00OOoOo0oooOoo00((android.content.Context) r7)     // Catch:{ all -> 0x000c }
            r2 = 0
            if (r1 != 0) goto L_0x000e
            monitor-exit(r0)     // Catch:{ all -> 0x000c }
            return r2
        L_0x000c:
            r7 = move-exception
            goto L_0x0022
        L_0x000e:
            long r3 = r1.o0O00o00OOoOo0oooOoo00()     // Catch:{ all -> 0x000c }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x000c }
            long r5 = r5 - r3
            long r3 = OO0000O0Ooo0OO000oo(r7)     // Catch:{ all -> 0x000c }
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 > 0) goto L_0x0020
            r2 = 1
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x000c }
            return r2
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x000c }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O00OO0oOOooooO00000Oo.O00OO0oOOooooO00000Oo(android.content.Context):boolean");
    }

    public static void O0oOO0ooO(Context context) {
        synchronized (O00OO0oOOooooO00000Oo) {
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, oO00o0OooO0OO0o0000o());
        }
    }

    private static long OO0000O0Ooo0OO000oo(Context context) {
        return com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(context, o0O00o00OOoOo0oooOoo00(o0O00o00OOoOo0oooOoo00("1c267f7936796d34", 37)), 259200000);
    }

    @Nullable
    public static String o00ooooooO00OO0O00(Context context) {
        if (context == null) {
            return null;
        }
        String o0O00o00OOoOo0oooOoo002 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(context, o0O00o00OOoOo0oooOoo00(o0O00o00OOoOo0oooOoo00("1c6a3339767a", 105)), (String) null);
        if (!TextUtils.isEmpty(o0O00o00OOoOo0oooOoo002) && o0O00o00OOoOo0oooOoo002.contains(o0O00o00OOoOo0oooOoo00("4c6e", 125))) {
            int indexOf = o0O00o00OOoOo0oooOoo002.indexOf(o0O00o00OOoOo0oooOoo00("4c74", 103));
            String o0O00o00OOoOo0oooOoo003 = O0oo0o00oooo.o0O00o00OOoOo0oooOoo00(o0O00o00OOoOo0oooOoo002.substring(indexOf + 2));
            if (System.currentTimeMillis() - Long.parseLong(o0O00o00OOoOo0oooOoo002.substring(0, indexOf), 16) <= 259200000) {
                return o0O00o00OOoOo0oooOoo003;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0056, code lost:
        return null;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.O0oOO0ooO o0O00o00OOoOo0oooOoo00(android.content.Context r5) {
        /*
            java.lang.Object r0 = O00OO0oOOooooO00000Oo
            monitor-enter(r0)
            boolean r1 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.OO000O0O0Oo.oO00o0OooO0OO0o0000o(r5)     // Catch:{ all -> 0x000c }
            r2 = 0
            if (r1 == 0) goto L_0x000e
            monitor-exit(r0)     // Catch:{ all -> 0x000c }
            return r2
        L_0x000c:
            r5 = move-exception
            goto L_0x0057
        L_0x000e:
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.Oo0O0Oo0OO0OOOoOO0O0.o0Oo0OO00O0O000ooOO0((android.content.Context) r5)     // Catch:{ all -> 0x000c }
            java.lang.String r1 = oO00o0OooO0OO0o0000o()     // Catch:{ all -> 0x000c }
            java.lang.String r5 = com.trustdecision.android.shell.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0((android.content.Context) r5, (java.lang.String) r1)     // Catch:{ all -> 0x000c }
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x000c }
            if (r1 != 0) goto L_0x0055
            java.lang.String r1 = "4c27"
            r3 = 52
            java.lang.String r1 = o0O00o00OOoOo0oooOoo00(r1, r3)     // Catch:{ all -> 0x000c }
            boolean r1 = r5.contains(r1)     // Catch:{ all -> 0x000c }
            if (r1 == 0) goto L_0x0055
            java.lang.String r1 = "4c3f"
            r2 = 44
            java.lang.String r1 = o0O00o00OOoOo0oooOoo00(r1, r2)     // Catch:{ all -> 0x000c }
            int r1 = r5.indexOf(r1)     // Catch:{ all -> 0x000c }
            int r2 = r1 + 2
            java.lang.String r2 = r5.substring(r2)     // Catch:{ all -> 0x000c }
            java.lang.String r2 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0oo0o00oooo.o0O00o00OOoOo0oooOoo00(r2)     // Catch:{ all -> 0x000c }
            r3 = 0
            java.lang.String r5 = r5.substring(r3, r1)     // Catch:{ all -> 0x000c }
            r1 = 16
            long r3 = java.lang.Long.parseLong(r5, r1)     // Catch:{ all -> 0x000c }
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.O0oOO0ooO r5 = new com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.O0oOO0ooO     // Catch:{ all -> 0x000c }
            r5.<init>(r2, r3)     // Catch:{ all -> 0x000c }
            monitor-exit(r0)     // Catch:{ all -> 0x000c }
            return r5
        L_0x0055:
            monitor-exit(r0)     // Catch:{ all -> 0x000c }
            return r2
        L_0x0057:
            monitor-exit(r0)     // Catch:{ all -> 0x000c }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(android.content.Context):com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.O0oOO0ooO");
    }

    @Nullable
    public static O0oOO0ooO o0Oo0OO00O0O000ooOO0() {
        O0oOO0ooO o0oOO0ooO;
        synchronized (oO00o0OooO0OO0o0000o) {
            o0oOO0ooO = O0oOO0ooO;
        }
        return o0oOO0ooO;
    }

    public static String oO00o0OooO0OO0o0000o() {
        return o0ooOoo0Oo00oOOO.o0Oo0OO00O0O000ooOO0() != null ? Oo0O0Oo0OO0OOOoOO0O0.oO00o0OooO0OO0o0000o(o0O00o00OOoOo0oooOoo00("1c732a3a7e6e", 112)) : Oo0O0Oo0OO0OOOoOO0O0.o0O00o00OOoOo0oooOoo00(o0O00o00OOoOo0oooOoo00("1c0c55450111", 15));
    }

    @NonNull
    public static String o0O00o00OOoOo0oooOoo00(String str) {
        o0Oo0OO00O0O000ooOO0 O00OO0oOOooooO00000Oo2 = o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo();
        StringBuilder v = ba.v(str);
        v.append(o0O00o00OOoOo0oooOoo00("45", 124));
        v.append(oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00(O00OO0oOOooooO00000Oo2.oO0OOO00 + o0O00o00OOoOo0oooOoo00("45", 7) + O00OO0oOOooooO00000Oo2.O0oOO0ooO));
        return v.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x007a A[Catch:{ all -> 0x000b }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007b A[Catch:{ all -> 0x000b }] */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String o0Oo0OO00O0O000ooOO0(android.content.Context r8) {
        /*
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 r0 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo()
            if (r8 != 0) goto L_0x000e
            android.content.Context r8 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00()     // Catch:{ all -> 0x000b }
            goto L_0x000e
        L_0x000b:
            r8 = move-exception
            goto L_0x00bc
        L_0x000e:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x000b }
            r1.<init>()     // Catch:{ all -> 0x000b }
            java.lang.String r2 = com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00()     // Catch:{ all -> 0x000b }
            java.lang.String r3 = com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o()     // Catch:{ all -> 0x000b }
            java.lang.String r4 = "0d"
            r5 = 99
            java.lang.String r4 = o0O00o00OOoOo0oooOoo00(r4, r5)     // Catch:{ all -> 0x000b }
            r1.put(r4, r2)     // Catch:{ all -> 0x000b }
            java.lang.String r2 = "05454f"
            r4 = 72
            java.lang.String r2 = o0O00o00OOoOo0oooOoo00(r2, r4)     // Catch:{ all -> 0x000b }
            r1.put(r2, r3)     // Catch:{ all -> 0x000b }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x000b }
            java.lang.String r4 = "0b21"
            r5 = 37
            java.lang.String r4 = o0O00o00OOoOo0oooOoo00(r4, r5)     // Catch:{ all -> 0x000b }
            r1.put(r4, r2)     // Catch:{ all -> 0x000b }
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.O0oOO0ooO r4 = o0O00o00OOoOo0oooOoo00((android.content.Context) r8)     // Catch:{ all -> 0x000b }
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x0063
            java.lang.String r6 = r4.o0Oo0OO00O0O000ooOO0()     // Catch:{ all -> 0x000b }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x000b }
            if (r6 == 0) goto L_0x0053
            goto L_0x0063
        L_0x0053:
            java.lang.String r6 = "0c53"
            r7 = 80
            java.lang.String r6 = o0O00o00OOoOo0oooOoo00(r6, r7)     // Catch:{ all -> 0x000b }
            java.lang.String r4 = r4.o0Oo0OO00O0O000ooOO0()     // Catch:{ all -> 0x000b }
            r1.put(r6, r4)     // Catch:{ all -> 0x000b }
            goto L_0x006e
        L_0x0063:
            java.lang.String r4 = "0c2a"
            r6 = 41
            java.lang.String r4 = o0O00o00OOoOo0oooOoo00(r4, r6)     // Catch:{ all -> 0x000b }
            r1.put(r4, r5)     // Catch:{ all -> 0x000b }
        L_0x006e:
            java.lang.String r4 = "18"
            r6 = 23
            java.lang.String r4 = o0O00o00OOoOo0oooOoo00(r4, r6)     // Catch:{ all -> 0x000b }
            java.lang.String r7 = r0.O0oOO0ooO     // Catch:{ all -> 0x000b }
            if (r7 != 0) goto L_0x007b
            goto L_0x007c
        L_0x007b:
            r5 = r7
        L_0x007c:
            r1.put(r4, r5)     // Catch:{ all -> 0x000b }
            java.lang.String r4 = "070b"
            r5 = 4
            java.lang.String r4 = o0O00o00OOoOo0oooOoo00(r4, r5)     // Catch:{ all -> 0x000b }
            r5 = 1
            r1.put(r4, r5)     // Catch:{ all -> 0x000b }
            java.lang.String r4 = "1e"
            java.lang.String r4 = o0O00o00OOoOo0oooOoo00(r4, r6)     // Catch:{ all -> 0x000b }
            java.lang.String r5 = "5d54505053"
            r6 = 92
            java.lang.String r5 = o0O00o00OOoOo0oooOoo00(r5, r6)     // Catch:{ all -> 0x000b }
            r1.put(r4, r5)     // Catch:{ all -> 0x000b }
            int r0 = r0.O0OoOo00O000     // Catch:{ all -> 0x000b }
            java.lang.String r0 = com.trustdecision.android.shell.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0((org.json.JSONObject) r1, (int) r0)     // Catch:{ all -> 0x000b }
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x000b }
            byte[] r0 = r0.getBytes(r1)     // Catch:{ all -> 0x000b }
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((byte[]) r0)     // Catch:{ all -> 0x000b }
            java.lang.String r8 = com.trustdecision.android.shell.common.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0((android.content.Context) r8, (long) r2)     // Catch:{ all -> 0x000b }
            byte[] r8 = r8.getBytes(r1)     // Catch:{ all -> 0x000b }
            java.lang.String r8 = o0Oo0OO00O0O000ooOO0((byte[]) r8)     // Catch:{ all -> 0x000b }
            java.lang.String r8 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (java.lang.String) r8)     // Catch:{ all -> 0x000b }
            return r8
        L_0x00bc:
            org.json.JSONObject r8 = com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0((java.lang.Throwable) r8)
            java.lang.String r8 = r8.toString()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean oO00o0OooO0OO0o0000o(android.content.Context r9) {
        /*
            java.lang.Object r0 = oO00o0OooO0OO0o0000o
            monitor-enter(r0)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.O0oOO0ooO r1 = O0oOO0ooO     // Catch:{ all -> 0x0029 }
            r2 = 0
            if (r1 == 0) goto L_0x002d
            java.lang.String r1 = r1.o0Oo0OO00O0O000ooOO0()     // Catch:{ all -> 0x0029 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0029 }
            if (r1 == 0) goto L_0x0013
            goto L_0x002d
        L_0x0013:
            long r3 = OO0000O0Ooo0OO000oo(r9)     // Catch:{ all -> 0x0029 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0029 }
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.O0oOO0ooO r9 = O0oOO0ooO     // Catch:{ all -> 0x0029 }
            long r7 = r9.o0O00o00OOoOo0oooOoo00()     // Catch:{ all -> 0x0029 }
            long r5 = r5 - r7
            int r9 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r9 > 0) goto L_0x002b
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            r9 = 1
            return r9
        L_0x0029:
            r9 = move-exception
            goto L_0x002f
        L_0x002b:
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            return r2
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            return r2
        L_0x002f:
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O00OO0oOOooooO00000Oo.oO00o0OooO0OO0o0000o(android.content.Context):boolean");
    }

    @NonNull
    public static String o0Oo0OO00O0O000ooOO0(String str) {
        o0Oo0OO00O0O000ooOO0 O00OO0oOOooooO00000Oo2 = o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(o0O00o00OOoOo0oooOoo00("0708", 7), 1);
            jSONObject.put(o0O00o00OOoOo0oooOoo00("1e", 91), o0O00o00OOoOo0oooOoo00("5d2a2e2e2d", 34));
            String o0O00o00OOoOo0oooOoo002 = o0O00o00OOoOo0oooOoo00("18", 125);
            String str2 = O00OO0oOOooooO00000Oo2.O0oOO0ooO;
            String str3 = "";
            if (str2 == null) {
                str2 = str3;
            }
            jSONObject.put(o0O00o00OOoOo0oooOoo002, str2);
            String o0O00o00OOoOo0oooOoo003 = com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00();
            String oO00o0OooO0OO0o0000o2 = com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o();
            if (!TextUtils.isEmpty(o0O00o00OOoOo0oooOoo003) && !o0O00o00OOoOo0oooOoo00("3320", 53).equals(o0O00o00OOoOo0oooOoo003)) {
                jSONObject.put(o0O00o00OOoOo0oooOoo00("0d", 123), o0O00o00OOoOo0oooOoo003);
            }
            if (!TextUtils.isEmpty(oO00o0OooO0OO0o0000o2)) {
                jSONObject.put(o0O00o00OOoOo0oooOoo00("054a40", 71), oO00o0OooO0OO0o0000o2);
            }
            String str4 = O00OO0oOOooooO00000Oo2.ooOoOooO;
            if (str4 != null) {
                str3 = str4;
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put(o0O00o00OOoOo0oooOoo00("0961", 120), str3);
            }
            jSONObject.put(o0O00o00OOoOo0oooOoo00("1b63", 119), System.currentTimeMillis());
            return o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0(com.trustdecision.android.shell.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(jSONObject, O00OO0oOOooooO00000Oo2.O0OoOo00O000).getBytes(StandardCharsets.UTF_8)), str);
        } catch (Throwable th) {
            return com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(th).toString();
        }
    }

    public static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashSet hashSet = o00ooooooO00OO0O00;
        if (hashSet.size() >= 1000) {
            hashSet.clear();
            OO0000O0Ooo0OO000oo = 0;
        }
        Object o0Oo0OO00O0O000ooOO02 = HelperJNI.o0Oo0OO00O0O000ooOO0(47, (Object) new Object[]{str, Integer.valueOf(i)});
        if (o0Oo0OO00O0O000ooOO02 != null) {
            String str2 = (String) o0Oo0OO00O0O000ooOO02;
            if (hashSet.add(str2)) {
                return str2;
            }
            int i2 = OO0000O0Ooo0OO000oo;
            if (i2 >= 20) {
                OO0000O0Ooo0OO000oo = 0;
                return str2;
            }
            OO0000O0Ooo0OO000oo = i2 + 1;
        }
        return o0Oo0OO00O0O000ooOO0(str, i);
    }

    private static String o0Oo0OO00O0O000ooOO0(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(o0O00o00OOoOo0oooOoo00("1c637371", 96));
        sb.append(str);
        return ba.r(sb, o0O00o00OOoOo0oooOoo00("46", 53), str2);
    }

    private static String o0O00o00OOoOo0oooOoo00(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 19);
            byte b2 = (byte) (bArr[0] ^ 104);
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

    public static void o0O00o00OOoOo0oooOoo00() {
        synchronized (oO00o0OooO0OO0o0000o) {
            O0oOO0ooO = null;
        }
    }

    public static void o0O00o00OOoOo0oooOoo00(Context context, String str, long j) {
        if (context != null) {
            String o0O00o00OOoOo0oooOoo002 = o0O00o00OOoOo0oooOoo00(o0O00o00OOoOo0oooOoo00("1c752c266965", 118));
            String hexString = Long.toHexString(j);
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, o0O00o00OOoOo0oooOoo002, String.format(Locale.US, o0O00o00OOoOo0oooOoo00("4d29287f7e29", 108), new Object[]{hexString, O0oo0o00oooo.o0O00o00OOoOo0oooOoo00(str)}));
        }
    }

    private static String o0Oo0OO00O0O000ooOO0(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public static void o0Oo0OO00O0O000ooOO0(Context context, long j) {
        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, o0O00o00OOoOo0oooOoo00(o0O00o00OOoOo0oooOoo00("1c10494f004f5b02", 19)), j * 1000);
    }

    public static void o0Oo0OO00O0O000ooOO0(Context context, String str, long j) {
        synchronized (O00OO0oOOooooO00000Oo) {
            String o0O00o00OOoOo0oooOoo002 = O0oo0o00oooo.o0O00o00OOoOo0oooOoo00(str);
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context, oO00o0OooO0OO0o0000o(), String.format(Locale.US, o0O00o00OOoOo0oooOoo00("4d5f5e09085f", 26), new Object[]{Long.toHexString(j - 600000), o0O00o00OOoOo0oooOoo002}));
        }
    }

    public static void o0Oo0OO00O0O000ooOO0(String str, long j, boolean z) {
        synchronized (oO00o0OooO0OO0o0000o) {
            O0oOO0ooO = new O0oOO0ooO(str, j - (z ? 600000 : 0));
        }
    }
}
