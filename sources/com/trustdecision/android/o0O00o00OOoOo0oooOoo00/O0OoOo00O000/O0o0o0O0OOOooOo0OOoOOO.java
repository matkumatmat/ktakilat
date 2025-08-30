package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.trustdecision.android.shell.common.HelperJNI;
import java.io.File;
import java.util.Locale;
import org.apache.commons.lang3.CharEncoding;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class O0o0o0O0OOOooOo0OOoOOO {
    private static final O0o0o0O0OOOooOo0OOoOOO o0O00o00OOoOo0oooOoo00 = new O0o0o0O0OOOooOo0OOoOOO();
    private Context o0Oo0OO00O0O000ooOO0;

    private O0o0o0O0OOOooOo0OOoOOO() {
    }

    private static String O00OO0oOOooooO00000Oo() {
        String str = new String(o0oOO0oO00OoO0.o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0("37336e716020307a656625206879717669", 72)));
        if (str.length() == 0) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(o0Oo0OO00O0O000ooOO0("6d2938", 17));
        int lastIndexOf2 = str.lastIndexOf(o0Oo0OO00O0O000ooOO0("37014753", 122));
        if (lastIndexOf < 0) {
            return null;
        }
        if (lastIndexOf2 <= 0) {
            lastIndexOf2 = str.length();
        }
        try {
            String replaceAll = str.substring(lastIndexOf + 4, lastIndexOf2).replaceAll(o0Oo0OO00O0O000ooOO0("12", 0), "");
            if (!o0Oo0OO00O0O000ooOO0(replaceAll)) {
                return null;
            }
            int intValue = Integer.valueOf(replaceAll).intValue();
            return String.format(Locale.US, o0Oo0OO00O0O000ooOO0("6d290352282d", 72), new Object[]{Integer.valueOf(intValue - 10000)});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0075 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0076 A[SYNTHETIC, Splitter:B:26:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a6 A[SYNTHETIC, Splitter:B:44:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00fb A[Catch:{ Exception -> 0x0109 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject o0O00o00OOoOo0oooOoo00() {
        /*
            r6 = this;
            r0 = 0
            java.lang.String r1 = "79393c202b303b7c6d372b33744b0c313f3d3f272d37"
            r2 = 18
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0(r1, r2)     // Catch:{ all -> 0x001c }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x001c }
            java.lang.String r2 = "7f5340"
            r3 = 117(0x75, float:1.64E-43)
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0(r2, r3)     // Catch:{ all -> 0x001a }
            java.lang.reflect.Method r2 = r1.getDeclaredMethod(r2, r0)     // Catch:{ all -> 0x001a }
            goto L_0x001f
        L_0x001a:
            goto L_0x001e
        L_0x001c:
            r1 = r0
        L_0x001e:
            r2 = r0
        L_0x001f:
            if (r1 == 0) goto L_0x010a
            if (r2 != 0) goto L_0x0025
            goto L_0x010a
        L_0x0025:
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            r4 = 1
            if (r1 < r3) goto L_0x0051
            java.lang.String r1 = "7961647873686324217f6e30014c7973717173635a426161686c79"
            r3 = 74
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0(r1, r3)     // Catch:{ all -> 0x004c }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x004c }
            java.lang.String r3 = "517953666c6e6e6c7c455d7e7e777366504b76787a78606a70"
            r5 = 85
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0(r3, r5)     // Catch:{ all -> 0x004c }
            java.lang.reflect.Field r3 = r1.getDeclaredField(r3)     // Catch:{ all -> 0x004c }
            r3.setAccessible(r4)     // Catch:{ all -> 0x004c }
            java.lang.Object r1 = r3.get(r1)     // Catch:{ all -> 0x004c }
            goto L_0x0073
        L_0x004c:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0072
        L_0x0051:
            java.lang.String r1 = "79090c101b000b4c491706586924111b19191b0b322a09090004113a29131b1915"
            r3 = 34
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0(r1, r3)     // Catch:{ Exception -> 0x0071 }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x0071 }
            java.lang.String r3 = "7f37351713000d0c"
            r5 = 48
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0(r3, r5)     // Catch:{ Exception -> 0x0071 }
            java.lang.reflect.Field r3 = r1.getDeclaredField(r3)     // Catch:{ Exception -> 0x0071 }
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x0071 }
            java.lang.Object r1 = r3.get(r1)     // Catch:{ Exception -> 0x0071 }
            goto L_0x0073
        L_0x0071:
        L_0x0072:
            r1 = r0
        L_0x0073:
            if (r1 != 0) goto L_0x0076
            return r0
        L_0x0076:
            java.lang.Object r1 = r2.invoke(r1, r0)     // Catch:{ Exception -> 0x007b }
            goto L_0x007d
        L_0x007b:
            r1 = r0
        L_0x007d:
            if (r1 == 0) goto L_0x0084
            java.lang.Class r2 = r1.getClass()
            goto L_0x0085
        L_0x0084:
            r2 = r0
        L_0x0085:
            if (r2 == 0) goto L_0x0099
            java.lang.String r3 = "794b68725e53584e"
            r4 = 125(0x7d, float:1.75E-43)
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0(r3, r4)     // Catch:{ all -> 0x0098 }
            java.lang.reflect.Method r3 = r2.getDeclaredMethod(r3, r0)     // Catch:{ all -> 0x0098 }
            java.lang.Object r3 = r3.invoke(r1, r0)     // Catch:{ all -> 0x0098 }
            goto L_0x009a
        L_0x0098:
        L_0x0099:
            r3 = r0
        L_0x009a:
            if (r3 == 0) goto L_0x00a1
            java.lang.Class r3 = r3.getClass()
            goto L_0x00a2
        L_0x00a1:
            r3 = r0
        L_0x00a2:
            boolean r4 = r1 instanceof java.lang.reflect.Proxy
            if (r4 == 0) goto L_0x00ae
            java.lang.reflect.InvocationHandler r1 = java.lang.reflect.Proxy.getInvocationHandler(r1)     // Catch:{ all -> 0x00ae }
            java.lang.Class r0 = r1.getClass()     // Catch:{ all -> 0x00ae }
        L_0x00ae:
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            if (r2 == 0) goto L_0x00d6
            java.lang.String r4 = "7945405c574c4700055b4a142d42685d57555557477e6645454c485d1c3d6d4b5d0c3e68575d4b"
            r5 = 110(0x6e, float:1.54E-43)
            java.lang.String r4 = o0Oo0OO00O0O000ooOO0(r4, r5)     // Catch:{ Exception -> 0x0109 }
            java.lang.String r5 = r2.getName()     // Catch:{ Exception -> 0x0109 }
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0109 }
            if (r4 != 0) goto L_0x00d6
            java.lang.String r4 = "6b273a3436342c263c"
            r5 = 25
            java.lang.String r4 = o0Oo0OO00O0O000ooOO0(r4, r5)     // Catch:{ Exception -> 0x0109 }
            java.lang.String r2 = r2.getName()     // Catch:{ Exception -> 0x0109 }
            r1.put(r4, r2)     // Catch:{ Exception -> 0x0109 }
        L_0x00d6:
            if (r3 == 0) goto L_0x00f9
            java.lang.String r2 = "79696c707b606b2c277a3b0a4d616c677144447b7167"
            r4 = 66
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0(r2, r4)     // Catch:{ Exception -> 0x0109 }
            java.lang.String r4 = r3.getName()     // Catch:{ Exception -> 0x0109 }
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x0109 }
            if (r2 != 0) goto L_0x00f9
            java.lang.String r2 = "7a7478757e68"
            r4 = 91
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0(r2, r4)     // Catch:{ Exception -> 0x0109 }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x0109 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x0109 }
        L_0x00f9:
            if (r0 == 0) goto L_0x0109
            java.lang.String r2 = "702d2b2e2c2d33"
            r3 = 0
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0(r2, r3)     // Catch:{ Exception -> 0x0109 }
            java.lang.String r0 = r0.getName()     // Catch:{ Exception -> 0x0109 }
            r1.put(r2, r0)     // Catch:{ Exception -> 0x0109 }
        L_0x0109:
            return r1
        L_0x010a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0o0o0O0OOOooOo0OOoOOO.o0O00o00OOoOo0oooOoo00():org.json.JSONObject");
    }

    public static O0o0o0O0OOOooOo0OOoOOO o0Oo0OO00O0O000ooOO0() {
        return o0O00o00OOoOo0oooOoo00;
    }

    private static JSONObject oO00o0OooO0OO0o0000o() {
        String[] split;
        JSONObject jSONObject = new JSONObject();
        String O00OO0oOOooooO00000Oo = O00OO0oOOooooO00000Oo();
        if (!(O00OO0oOOooooO00000Oo == null || O00OO0oOOooooO00000Oo.length() == 0)) {
            String str = (String) HelperJNI.o0Oo0OO00O0O000ooOO0(34, (Object) new Object[]{0});
            if (!TextUtils.isEmpty(str) && (split = str.split(o0Oo0OO00O0O000ooOO0("12", 110))) != null && split.length > 0) {
                int i = 0;
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (split[i2].contains(O00OO0oOOooooO00000Oo)) {
                        int lastIndexOf = split[i2].lastIndexOf(o0Oo0OO00O0O000ooOO0("38", 12));
                        String str2 = split[i2];
                        File file = new File(String.format(Locale.US, o0Oo0OO00O0O000ooOO0("376d233333686d233333682c70", 2), new Object[]{str2.substring(lastIndexOf <= 0 ? 0 : lastIndexOf + 1, str2.length())}));
                        if (file.exists()) {
                            try {
                                jSONObject.put(o0Oo0OO00O0O000ooOO0("7e4b415c5553", 96), O00OO0oOOooooO00000Oo);
                                jSONObject.put(o0Oo0OO00O0O000ooOO0("7b01070c023436074e", 46) + i2, file.getAbsolutePath());
                                jSONObject.put(o0Oo0OO00O0O000ooOO0("7b383e353b0d0f3e77", 23) + i2 + o0Oo0OO00O0O000ooOO0("387d34363a74", 21), split[i2]);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            i++;
                        }
                    }
                }
                if (i > 1) {
                    return jSONObject;
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0156 A[SYNTHETIC, Splitter:B:51:0x0156] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x015f A[Catch:{ Exception -> 0x016d }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0170 A[SYNTHETIC, Splitter:B:61:0x0170] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0179 A[Catch:{ Exception -> 0x0187 }] */
    @androidx.annotation.RequiresApi(api = 26)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject o0O00o00OOoOo0oooOoo00(java.lang.String r12) {
        /*
            r11 = this;
            r0 = 0
            r1 = 1
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.lang.String r3 = ""
            r4 = 0
            java.lang.String r5 = "6c486373494e5f"
            r6 = 124(0x7c, float:1.74E-43)
            java.lang.String r5 = o0Oo0OO00O0O000ooOO0(r5, r6)     // Catch:{ Exception -> 0x013c }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013c }
            r6.<init>()     // Catch:{ Exception -> 0x013c }
            r6.append(r12)     // Catch:{ Exception -> 0x013c }
            java.lang.String r12 = java.io.File.separator     // Catch:{ Exception -> 0x013c }
            r6.append(r12)     // Catch:{ Exception -> 0x013c }
            r6.append(r5)     // Catch:{ Exception -> 0x013c }
            java.lang.String r3 = r6.toString()     // Catch:{ Exception -> 0x013c }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x013c }
            r6.<init>(r3)     // Catch:{ Exception -> 0x013c }
            java.io.FileDescriptor r7 = r6.getFD()     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.lang.Class r8 = r7.getClass()     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.lang.String r9 = "7c514640414b49544b4d"
            r10 = 116(0x74, float:1.63E-43)
            java.lang.String r9 = o0Oo0OO00O0O000ooOO0(r9, r10)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.lang.reflect.Field r8 = r8.getDeclaredField(r9)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            r8.setAccessible(r1)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.lang.Object r7 = r8.get(r7)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            r7.getClass()     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.util.Locale r8 = java.util.Locale.US     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.lang.String r9 = "374e130c1d5d4d07181b5858135a1b50"
            r10 = 53
            java.lang.String r9 = o0Oo0OO00O0O000ooOO0(r9, r10)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.lang.Object[] r10 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            r10[r0] = r7     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.lang.String r7 = java.lang.String.format(r8, r9, r10)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.nio.file.Path r0 = java.nio.file.Paths.get(r7, r0)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.nio.file.Path r0 = java.nio.file.Files.readSymbolicLink(r0)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            int r7 = r0.lastIndexOf(r12)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.lang.String r7 = r0.substring(r7)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            r8.<init>()     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            r8.append(r12)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            r8.append(r5)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            if (r7 != 0) goto L_0x00e0
            java.lang.String r4 = "7e57"
            r7 = 113(0x71, float:1.58E-43)
            java.lang.String r4 = o0Oo0OO00O0O000ooOO0(r4, r7)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            r7.<init>()     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.lang.String r8 = "5e7c791b0b6900"
            r9 = 80
            java.lang.String r8 = o0Oo0OO00O0O000ooOO0(r8, r9)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            r7.append(r8)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            r7.append(r12)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            r7.append(r5)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.lang.String r5 = "38295b274f"
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0(r5, r1)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            r7.append(r1)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            int r12 = r0.lastIndexOf(r12)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.lang.String r12 = r0.substring(r12)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            r7.append(r12)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.lang.String r12 = r7.toString()     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            r2.put(r4, r12)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            r6.close()     // Catch:{ Exception -> 0x00d8 }
            boolean r12 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x00d8 }
            if (r12 != 0) goto L_0x00d8
            java.io.File r12 = new java.io.File     // Catch:{ Exception -> 0x00d8 }
            r12.<init>(r3)     // Catch:{ Exception -> 0x00d8 }
            boolean r0 = r12.exists()     // Catch:{ Exception -> 0x00d8 }
            if (r0 == 0) goto L_0x00d8
            r12.delete()     // Catch:{ Exception -> 0x00d8 }
        L_0x00d8:
            return r2
        L_0x00d9:
            r12 = move-exception
            r4 = r6
            goto L_0x016e
        L_0x00dd:
            r12 = move-exception
            r4 = r6
            goto L_0x013d
        L_0x00e0:
            java.lang.String r12 = "3640"
            r1 = 100
            java.lang.String r12 = o0Oo0OO00O0O000ooOO0(r12, r1)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.lang.String r12 = r0.replace(r5, r12)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            r0.<init>(r12)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            boolean r12 = r0.canRead()     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            if (r12 == 0) goto L_0x0122
            java.lang.String r12 = "7e3e"
            r0 = 24
            java.lang.String r12 = o0Oo0OO00O0O000ooOO0(r12, r0)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            java.lang.String r0 = "5e2b2e38"
            r1 = 13
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0(r0, r1)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            r2.put(r12, r0)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
            r6.close()     // Catch:{ Exception -> 0x0121 }
            boolean r12 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0121 }
            if (r12 != 0) goto L_0x0121
            java.io.File r12 = new java.io.File     // Catch:{ Exception -> 0x0121 }
            r12.<init>(r3)     // Catch:{ Exception -> 0x0121 }
            boolean r0 = r12.exists()     // Catch:{ Exception -> 0x0121 }
            if (r0 == 0) goto L_0x0121
            r12.delete()     // Catch:{ Exception -> 0x0121 }
        L_0x0121:
            return r2
        L_0x0122:
            r6.close()     // Catch:{ Exception -> 0x0139 }
            boolean r12 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0139 }
            if (r12 != 0) goto L_0x0139
            java.io.File r12 = new java.io.File     // Catch:{ Exception -> 0x0139 }
            r12.<init>(r3)     // Catch:{ Exception -> 0x0139 }
            boolean r0 = r12.exists()     // Catch:{ Exception -> 0x0139 }
            if (r0 == 0) goto L_0x0139
            r12.delete()     // Catch:{ Exception -> 0x0139 }
        L_0x0139:
            return r4
        L_0x013a:
            r12 = move-exception
            goto L_0x016e
        L_0x013c:
            r12 = move-exception
        L_0x013d:
            r12.printStackTrace()     // Catch:{ all -> 0x013a }
            java.lang.String r0 = "7e566f6e"
            r1 = 112(0x70, float:1.57E-43)
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0(r0, r1)     // Catch:{ JSONException -> 0x0150 }
            java.lang.String r12 = r12.getMessage()     // Catch:{ JSONException -> 0x0150 }
            r2.put(r0, r12)     // Catch:{ JSONException -> 0x0150 }
            goto L_0x0154
        L_0x0150:
            r12 = move-exception
            r12.printStackTrace()     // Catch:{ all -> 0x013a }
        L_0x0154:
            if (r4 == 0) goto L_0x0159
            r4.close()     // Catch:{ Exception -> 0x016d }
        L_0x0159:
            boolean r12 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x016d }
            if (r12 != 0) goto L_0x016d
            java.io.File r12 = new java.io.File     // Catch:{ Exception -> 0x016d }
            r12.<init>(r3)     // Catch:{ Exception -> 0x016d }
            boolean r0 = r12.exists()     // Catch:{ Exception -> 0x016d }
            if (r0 == 0) goto L_0x016d
            r12.delete()     // Catch:{ Exception -> 0x016d }
        L_0x016d:
            return r2
        L_0x016e:
            if (r4 == 0) goto L_0x0173
            r4.close()     // Catch:{ Exception -> 0x0187 }
        L_0x0173:
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0187 }
            if (r0 != 0) goto L_0x0187
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0187 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x0187 }
            boolean r1 = r0.exists()     // Catch:{ Exception -> 0x0187 }
            if (r1 == 0) goto L_0x0187
            r0.delete()     // Catch:{ Exception -> 0x0187 }
        L_0x0187:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0o0o0O0OOOooOo0OOoOOO.o0O00o00OOoOo0oooOoo00(java.lang.String):org.json.JSONObject");
    }

    public String o0Oo0OO00O0O000ooOO0(Context context) {
        this.o0Oo0OO00O0O000ooOO0 = context.getApplicationContext();
        try {
            JSONObject oO00o0OooO0OO0o0000o = oO00o0OooO0OO0o0000o();
            String str = (String) HelperJNI.o0Oo0OO00O0O000ooOO0(25, (Object) new Object[]{1});
            JSONObject jSONObject = new JSONObject();
            JSONObject o0O00o00OOoOo0oooOoo002 = o0O00o00OOoOo0oooOoo00();
            JSONObject o0O00o00OOoOo0oooOoo003 = Build.VERSION.SDK_INT >= 26 ? o0O00o00OOoOo0oooOoo00(this.o0Oo0OO00O0O000ooOO0.getApplicationInfo().dataDir) : null;
            jSONObject.put(o0Oo0OO00O0O000ooOO0("7b23252e200719320c022073", 12), str);
            if (oO00o0OooO0OO0o0000o == null && str == null && o0O00o00OOoOo0oooOoo002 == null && o0O00o00OOoOo0oooOoo003 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            if (!(oO00o0OooO0OO0o0000o == null || oO00o0OooO0OO0o0000o.length() == 0)) {
                jSONArray.put(oO00o0OooO0OO0o0000o);
            }
            if (!(str == null || str.length() == 0)) {
                jSONArray.put(jSONObject);
            }
            if (!(o0O00o00OOoOo0oooOoo002 == null || o0O00o00OOoOo0oooOoo002.length() == 0)) {
                jSONArray.put(o0O00o00OOoOo0oooOoo002);
            }
            if (!(o0O00o00OOoOo0oooOoo003 == null || o0O00o00OOoOo0oooOoo003.length() == 0)) {
                jSONArray.put(o0O00o00OOoOo0oooOoo003);
            }
            if (jSONArray.length() == 0) {
                return null;
            }
            return jSONArray.toString();
        } catch (Exception unused) {
            return null;
        }
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
            byte b2 = (byte) (bArr[0] ^ Ascii.CAN);
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

    private static boolean o0Oo0OO00O0O000ooOO0(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
