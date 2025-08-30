package com.ktakilat.cbase.checkvalue;

import android.text.TextUtils;
import com.ktakilat.cbase.utils.JsonUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CheckValueManager {

    /* renamed from: a  reason: collision with root package name */
    public static final ExecutorService f466a = Executors.newCachedThreadPool();
    public static CheckValueCall b = null;

    public interface CheckValueCall {
        void a(String str);
    }

    public static void a(Object obj) {
        final Object c = JsonUtil.c(JsonUtil.a(obj), obj.getClass());
        f466a.submit(new Runnable() {
            public final void run() {
                String b = CheckValueManager.b(c);
                if (!TextUtils.isEmpty(b)) {
                    synchronized (CheckValueManager.class) {
                        CheckValueCall checkValueCall = CheckValueManager.b;
                        if (checkValueCall != null) {
                            checkValueCall.a(b);
                        }
                    }
                }
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0112, code lost:
        if (((java.lang.Number) r8).doubleValue() >= r9.leftNum()) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x014d, code lost:
        if (((java.lang.Number) r8).doubleValue() < r9.rightNum()) goto L_0x014f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01d5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0061 A[Catch:{ Exception -> 0x0036 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e9 A[Catch:{ Exception -> 0x0036 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x012e A[Catch:{ Exception -> 0x0036 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0140 A[Catch:{ Exception -> 0x0036 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0178 A[Catch:{ Exception -> 0x0036 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.lang.Object r17) {
        /*
            r0 = r17
            if (r0 == 0) goto L_0x01dc
            java.lang.Class r1 = r17.getClass()     // Catch:{ Exception -> 0x0036 }
            java.lang.reflect.Field[] r2 = r1.getDeclaredFields()     // Catch:{ Exception -> 0x0036 }
            int r3 = r2.length     // Catch:{ Exception -> 0x0036 }
            r4 = 0
            r5 = 0
        L_0x000f:
            if (r5 >= r3) goto L_0x01dc
            r6 = r2[r5]     // Catch:{ Exception -> 0x0036 }
            r7 = 1
            r6.setAccessible(r7)     // Catch:{ Exception -> 0x0036 }
            java.lang.Object r8 = r6.get(r0)     // Catch:{ Exception -> 0x0036 }
            java.lang.Class<com.ktakilat.cbase.checkvalue.NotNull> r9 = com.ktakilat.cbase.checkvalue.NotNull.class
            boolean r9 = r6.isAnnotationPresent(r9)     // Catch:{ Exception -> 0x0036 }
            java.lang.Class<com.ktakilat.cbase.checkvalue.NotEmpty> r10 = com.ktakilat.cbase.checkvalue.NotEmpty.class
            java.lang.Class<com.ktakilat.cbase.checkvalue.NumInterval> r11 = com.ktakilat.cbase.checkvalue.NumInterval.class
            java.lang.String r12 = "."
            if (r9 != 0) goto L_0x0039
            boolean r9 = r6.isAnnotationPresent(r10)     // Catch:{ Exception -> 0x0036 }
            if (r9 != 0) goto L_0x0039
            boolean r9 = r6.isAnnotationPresent(r11)     // Catch:{ Exception -> 0x0036 }
            if (r9 == 0) goto L_0x005b
            goto L_0x0039
        L_0x0036:
            r0 = move-exception
            goto L_0x01d9
        L_0x0039:
            if (r8 != 0) goto L_0x005b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0036 }
            r0.<init>()     // Catch:{ Exception -> 0x0036 }
            java.lang.String r1 = r1.getName()     // Catch:{ Exception -> 0x0036 }
            r0.append(r1)     // Catch:{ Exception -> 0x0036 }
            r0.append(r12)     // Catch:{ Exception -> 0x0036 }
            java.lang.String r1 = r6.getName()     // Catch:{ Exception -> 0x0036 }
            r0.append(r1)     // Catch:{ Exception -> 0x0036 }
            java.lang.String r1 = " NotNull"
            r0.append(r1)     // Catch:{ Exception -> 0x0036 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0036 }
            return r0
        L_0x005b:
            boolean r9 = r6.isAnnotationPresent(r10)     // Catch:{ Exception -> 0x0036 }
            if (r9 == 0) goto L_0x00e3
            boolean r9 = r8 instanceof java.lang.String     // Catch:{ Exception -> 0x0036 }
            java.lang.String r10 = " NotEmpty"
            if (r9 == 0) goto L_0x008d
            java.lang.String r9 = ""
            boolean r9 = r9.equals(r8)     // Catch:{ Exception -> 0x0036 }
            if (r9 == 0) goto L_0x00e3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0036 }
            r0.<init>()     // Catch:{ Exception -> 0x0036 }
            java.lang.String r1 = r1.getName()     // Catch:{ Exception -> 0x0036 }
            r0.append(r1)     // Catch:{ Exception -> 0x0036 }
            r0.append(r12)     // Catch:{ Exception -> 0x0036 }
            java.lang.String r1 = r6.getName()     // Catch:{ Exception -> 0x0036 }
            r0.append(r1)     // Catch:{ Exception -> 0x0036 }
            r0.append(r10)     // Catch:{ Exception -> 0x0036 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0036 }
            return r0
        L_0x008d:
            boolean r9 = r8 instanceof java.util.Collection     // Catch:{ Exception -> 0x0036 }
            if (r9 == 0) goto L_0x00b8
            r9 = r8
            java.util.Collection r9 = (java.util.Collection) r9     // Catch:{ Exception -> 0x0036 }
            boolean r9 = r9.isEmpty()     // Catch:{ Exception -> 0x0036 }
            if (r9 == 0) goto L_0x00e3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0036 }
            r0.<init>()     // Catch:{ Exception -> 0x0036 }
            java.lang.String r1 = r1.getName()     // Catch:{ Exception -> 0x0036 }
            r0.append(r1)     // Catch:{ Exception -> 0x0036 }
            r0.append(r12)     // Catch:{ Exception -> 0x0036 }
            java.lang.String r1 = r6.getName()     // Catch:{ Exception -> 0x0036 }
            r0.append(r1)     // Catch:{ Exception -> 0x0036 }
            r0.append(r10)     // Catch:{ Exception -> 0x0036 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0036 }
            return r0
        L_0x00b8:
            boolean r9 = r8 instanceof java.util.Map     // Catch:{ Exception -> 0x0036 }
            if (r9 == 0) goto L_0x00e3
            r9 = r8
            java.util.Map r9 = (java.util.Map) r9     // Catch:{ Exception -> 0x0036 }
            boolean r9 = r9.isEmpty()     // Catch:{ Exception -> 0x0036 }
            if (r9 == 0) goto L_0x00e3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0036 }
            r0.<init>()     // Catch:{ Exception -> 0x0036 }
            java.lang.String r1 = r1.getName()     // Catch:{ Exception -> 0x0036 }
            r0.append(r1)     // Catch:{ Exception -> 0x0036 }
            r0.append(r12)     // Catch:{ Exception -> 0x0036 }
            java.lang.String r1 = r6.getName()     // Catch:{ Exception -> 0x0036 }
            r0.append(r1)     // Catch:{ Exception -> 0x0036 }
            r0.append(r10)     // Catch:{ Exception -> 0x0036 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0036 }
            return r0
        L_0x00e3:
            boolean r9 = r6.isAnnotationPresent(r11)     // Catch:{ Exception -> 0x0036 }
            if (r9 == 0) goto L_0x0176
            java.lang.annotation.Annotation r9 = r6.getAnnotation(r11)     // Catch:{ Exception -> 0x0036 }
            com.ktakilat.cbase.checkvalue.NumInterval r9 = (com.ktakilat.cbase.checkvalue.NumInterval) r9     // Catch:{ Exception -> 0x0036 }
            boolean r10 = r8 instanceof java.lang.Long     // Catch:{ Exception -> 0x0036 }
            if (r10 != 0) goto L_0x00ff
            boolean r10 = r8 instanceof java.lang.Integer     // Catch:{ Exception -> 0x0036 }
            if (r10 != 0) goto L_0x00ff
            boolean r10 = r8 instanceof java.lang.Float     // Catch:{ Exception -> 0x0036 }
            if (r10 != 0) goto L_0x00ff
            boolean r10 = r8 instanceof java.lang.Double     // Catch:{ Exception -> 0x0036 }
            if (r10 == 0) goto L_0x0176
        L_0x00ff:
            boolean r10 = r9.leftIn()     // Catch:{ Exception -> 0x0036 }
            if (r10 == 0) goto L_0x0118
            r10 = r8
            java.lang.Number r10 = (java.lang.Number) r10     // Catch:{ Exception -> 0x0036 }
            double r10 = r10.doubleValue()     // Catch:{ Exception -> 0x0036 }
            double r13 = r9.leftNum()     // Catch:{ Exception -> 0x0036 }
            int r15 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r15 < 0) goto L_0x0116
        L_0x0114:
            r10 = 1
            goto L_0x0128
        L_0x0116:
            r10 = 0
            goto L_0x0128
        L_0x0118:
            r10 = r8
            java.lang.Number r10 = (java.lang.Number) r10     // Catch:{ Exception -> 0x0036 }
            double r10 = r10.doubleValue()     // Catch:{ Exception -> 0x0036 }
            double r13 = r9.leftNum()     // Catch:{ Exception -> 0x0036 }
            int r15 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r15 <= 0) goto L_0x0116
            goto L_0x0114
        L_0x0128:
            boolean r11 = r9.rightIn()     // Catch:{ Exception -> 0x0036 }
            if (r11 == 0) goto L_0x0140
            r11 = r8
            java.lang.Number r11 = (java.lang.Number) r11     // Catch:{ Exception -> 0x0036 }
            double r13 = r11.doubleValue()     // Catch:{ Exception -> 0x0036 }
            double r15 = r9.rightNum()     // Catch:{ Exception -> 0x0036 }
            int r9 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r9 > 0) goto L_0x013e
            goto L_0x014f
        L_0x013e:
            r7 = 0
            goto L_0x014f
        L_0x0140:
            r11 = r8
            java.lang.Number r11 = (java.lang.Number) r11     // Catch:{ Exception -> 0x0036 }
            double r13 = r11.doubleValue()     // Catch:{ Exception -> 0x0036 }
            double r15 = r9.rightNum()     // Catch:{ Exception -> 0x0036 }
            int r9 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r9 >= 0) goto L_0x013e
        L_0x014f:
            if (r10 == 0) goto L_0x0153
            if (r7 != 0) goto L_0x0176
        L_0x0153:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0036 }
            r0.<init>()     // Catch:{ Exception -> 0x0036 }
            java.lang.String r1 = r1.getName()     // Catch:{ Exception -> 0x0036 }
            r0.append(r1)     // Catch:{ Exception -> 0x0036 }
            r0.append(r12)     // Catch:{ Exception -> 0x0036 }
            java.lang.String r1 = r6.getName()     // Catch:{ Exception -> 0x0036 }
            r0.append(r1)     // Catch:{ Exception -> 0x0036 }
            java.lang.String r1 = " NumInterval="
            r0.append(r1)     // Catch:{ Exception -> 0x0036 }
            r0.append(r8)     // Catch:{ Exception -> 0x0036 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0036 }
            return r0
        L_0x0176:
            if (r8 == 0) goto L_0x01d5
            boolean r7 = r8 instanceof java.util.Collection     // Catch:{ Exception -> 0x0036 }
            if (r7 == 0) goto L_0x0197
            java.util.Collection r8 = (java.util.Collection) r8     // Catch:{ Exception -> 0x0036 }
            java.util.Iterator r6 = r8.iterator()     // Catch:{ Exception -> 0x0036 }
        L_0x0182:
            boolean r7 = r6.hasNext()     // Catch:{ Exception -> 0x0036 }
            if (r7 == 0) goto L_0x01d5
            java.lang.Object r7 = r6.next()     // Catch:{ Exception -> 0x0036 }
            java.lang.String r7 = b(r7)     // Catch:{ Exception -> 0x0036 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0036 }
            if (r8 != 0) goto L_0x0182
            return r7
        L_0x0197:
            java.lang.Class r6 = r6.getType()     // Catch:{ Exception -> 0x0036 }
            java.lang.String r6 = r6.getName()     // Catch:{ Exception -> 0x0036 }
            java.lang.String r7 = "com.ktakilat.loan.http"
            boolean r6 = r6.startsWith(r7)     // Catch:{ Exception -> 0x0036 }
            if (r6 == 0) goto L_0x01b2
            java.lang.String r6 = b(r8)     // Catch:{ Exception -> 0x0036 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0036 }
            if (r7 != 0) goto L_0x01d5
            return r6
        L_0x01b2:
            boolean r6 = r8 instanceof java.util.Map     // Catch:{ Exception -> 0x0036 }
            if (r6 == 0) goto L_0x01d5
            java.util.Map r8 = (java.util.Map) r8     // Catch:{ Exception -> 0x0036 }
            java.util.Collection r6 = r8.values()     // Catch:{ Exception -> 0x0036 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x0036 }
        L_0x01c0:
            boolean r7 = r6.hasNext()     // Catch:{ Exception -> 0x0036 }
            if (r7 == 0) goto L_0x01d5
            java.lang.Object r7 = r6.next()     // Catch:{ Exception -> 0x0036 }
            java.lang.String r7 = b(r7)     // Catch:{ Exception -> 0x0036 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0036 }
            if (r8 != 0) goto L_0x01c0
            return r7
        L_0x01d5:
            int r5 = r5 + 1
            goto L_0x000f
        L_0x01d9:
            com.ktakilat.cbase.utils.LogUtil.a(r0)
        L_0x01dc:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.cbase.checkvalue.CheckValueManager.b(java.lang.Object):java.lang.String");
    }
}
