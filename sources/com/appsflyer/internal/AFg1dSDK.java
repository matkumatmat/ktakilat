package com.appsflyer.internal;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import com.appsflyer.internal.AFg1eSDK;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AFg1dSDK {
    private static final Double getMediationNetwork = Double.valueOf(-0.0d);
    public static final Object getMonetizationNetwork = new Object() {
        public final boolean equals(Object obj) {
            return obj == this || obj == null;
        }

        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return "null";
        }
    };
    private final LinkedHashMap<String, Object> getRevenue;

    public AFg1dSDK() {
        this.getRevenue = new LinkedHashMap<>();
    }

    public static Object getCurrencyIso4217Code(Object obj) {
        if (obj == null) {
            return getMonetizationNetwork;
        }
        if (((Class) AFa1kSDK.getCurrencyIso4217Code(Color.red(0) + 321, (char) (2133 - View.MeasureSpec.getMode(0)), 36 - TextUtils.indexOf("", "", 0))).isInstance(obj) || (obj instanceof AFg1dSDK)) {
            return obj;
        }
        try {
            if (obj instanceof JSONArray) {
                Object[] objArr = {obj.toString()};
                Map map = AFa1kSDK.i;
                Object obj2 = map.get(-22273894);
                if (obj2 == null) {
                    obj2 = ((Class) AFa1kSDK.getCurrencyIso4217Code(TextUtils.indexOf("", '0', 0, 0) + 322, (char) (2133 - View.MeasureSpec.makeMeasureSpec(0, 0)), (ViewConfiguration.getTapTimeout() >> 16) + 36)).getDeclaredConstructor(new Class[]{String.class});
                    map.put(-22273894, obj2);
                }
                return ((Constructor) obj2).newInstance(objArr);
            }
            if (obj instanceof JSONObject) {
                return new AFg1dSDK(obj.toString());
            }
            if (obj.equals(getMonetizationNetwork)) {
                return obj;
            }
            try {
                if (obj instanceof Collection) {
                    Object[] objArr2 = {(Collection) obj};
                    Map map2 = AFa1kSDK.i;
                    Object obj3 = map2.get(1460610771);
                    if (obj3 == null) {
                        obj3 = ((Class) AFa1kSDK.getCurrencyIso4217Code(321 - View.MeasureSpec.getSize(0), (char) (2133 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), (ViewConfiguration.getFadingEdgeLength() >> 16) + 36)).getDeclaredConstructor(new Class[]{Collection.class});
                        map2.put(1460610771, obj3);
                    }
                    return ((Constructor) obj3).newInstance(objArr2);
                } else if (obj.getClass().isArray()) {
                    Object[] objArr3 = {obj};
                    Map map3 = AFa1kSDK.i;
                    Object obj4 = map3.get(-1726787512);
                    if (obj4 == null) {
                        obj4 = ((Class) AFa1kSDK.getCurrencyIso4217Code(320 - TextUtils.indexOf("", '0', 0, 0), (char) (2133 - Color.alpha(0)), Color.green(0) + 36)).getDeclaredConstructor(new Class[]{Object.class});
                        map3.put(-1726787512, obj4);
                    }
                    return ((Constructor) obj4).newInstance(objArr3);
                } else if (obj instanceof Map) {
                    return new AFg1dSDK((Map) obj);
                } else {
                    if ((obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof String)) {
                        return obj;
                    }
                    if (obj.getClass().getPackage().getName().startsWith("java.")) {
                        return obj.toString();
                    }
                    return null;
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (AFg1mSDK unused2) {
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 != null) {
                throw cause2;
            }
            throw th2;
        }
    }

    public static String getMediationNetwork(Number number) throws AFg1mSDK {
        if (number != null) {
            double doubleValue = number.doubleValue();
            try {
                Object[] objArr = {Double.valueOf(doubleValue)};
                Map map = AFa1kSDK.i;
                Object obj = map.get(1011674371);
                if (obj == null) {
                    obj = ((Class) AFa1kSDK.getCurrencyIso4217Code(TextUtils.indexOf("", '0', 0, 0) + 285, (char) View.MeasureSpec.getMode(0), Color.rgb(0, 0, 0) + 16777253)).getDeclaredMethod("getMonetizationNetwork", new Class[]{Double.TYPE});
                    map.put(1011674371, obj);
                }
                ((Double) ((Method) obj).invoke((Object) null, objArr)).getClass();
                if (number.equals(getMediationNetwork)) {
                    return "-0";
                }
                long longValue = number.longValue();
                if (doubleValue == ((double) longValue)) {
                    return Long.toString(longValue);
                }
                return number.toString();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } else {
            throw new AFg1mSDK("Number must be non-null");
        }
    }

    public final void AFAdRevenueData(AFg1eSDK aFg1eSDK) throws AFg1mSDK {
        aFg1eSDK.getCurrencyIso4217Code(AFg1eSDK.AFa1uSDK.EMPTY_OBJECT, "{");
        for (Map.Entry next : this.getRevenue.entrySet()) {
            String str = (String) next.getKey();
            if (str != null) {
                aFg1eSDK.getMonetizationNetwork();
                aFg1eSDK.getCurrencyIso4217Code(str);
                aFg1eSDK.getRevenue(next.getValue());
            } else {
                throw new AFg1mSDK("Names must be non-null");
            }
        }
        aFg1eSDK.AFAdRevenueData(AFg1eSDK.AFa1uSDK.EMPTY_OBJECT, AFg1eSDK.AFa1uSDK.NONEMPTY_OBJECT, "}");
    }

    public final String toString() {
        try {
            AFg1eSDK aFg1eSDK = new AFg1eSDK();
            AFAdRevenueData(aFg1eSDK);
            return aFg1eSDK.toString();
        } catch (AFg1mSDK unused) {
            return null;
        }
    }

    public AFg1dSDK(Map map) {
        this();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str != null) {
                this.getRevenue.put(str, getCurrencyIso4217Code(entry.getValue()));
            } else {
                throw new NullPointerException("key == null");
            }
        }
    }

    private AFg1dSDK(Object obj) throws AFg1mSDK {
        try {
            Map map = AFa1kSDK.i;
            Object obj2 = map.get(-865524410);
            if (obj2 == null) {
                obj2 = ((Class) AFa1kSDK.getCurrencyIso4217Code(357 - View.MeasureSpec.getSize(0), (char) (View.MeasureSpec.getMode(0) + 6866), 38 - (SystemClock.uptimeMillis() > 0 ? 1 : (SystemClock.uptimeMillis() == 0 ? 0 : -1)))).getDeclaredMethod("getRevenue", (Class[]) null);
                map.put(-865524410, obj2);
            }
            Object invoke = ((Method) obj2).invoke(obj, (Object[]) null);
            if (invoke instanceof AFg1dSDK) {
                this.getRevenue = ((AFg1dSDK) invoke).getRevenue;
                return;
            }
            Object[] objArr = new Object[2];
            objArr[1] = "AFJsonObject";
            objArr[0] = invoke;
            Object obj3 = map.get(464586448);
            if (obj3 == null) {
                obj3 = ((Class) AFa1kSDK.getCurrencyIso4217Code((ViewConfiguration.getFadingEdgeLength() >> 16) + 284, (char) View.resolveSize(0, 0), 37 - (ViewConfiguration.getJumpTapTimeout() >> 16))).getDeclaredMethod("getRevenue", new Class[]{Object.class, String.class});
                map.put(464586448, obj3);
            }
            throw ((Throwable) ((Method) obj3).invoke((Object) null, objArr));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private AFg1dSDK(java.lang.String r8) throws com.appsflyer.internal.AFg1mSDK {
        /*
            r7 = this;
            r0 = 1
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ all -> 0x004e }
            r2[r1] = r8     // Catch:{ all -> 0x004e }
            java.util.Map r8 = com.appsflyer.internal.AFa1kSDK.i     // Catch:{ all -> 0x004e }
            r3 = 1502086856(0x598806c8, float:4.7860066E15)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x004e }
            java.lang.Object r4 = r8.get(r4)     // Catch:{ all -> 0x004e }
            if (r4 == 0) goto L_0x0016
            goto L_0x0044
        L_0x0016:
            int r4 = android.view.ViewConfiguration.getTapTimeout()     // Catch:{ all -> 0x004e }
            int r4 = r4 >> 16
            int r4 = 357 - r4
            java.lang.String r5 = ""
            int r5 = android.os.Process.getGidForName(r5)     // Catch:{ all -> 0x004e }
            int r5 = 6865 - r5
            char r5 = (char) r5     // Catch:{ all -> 0x004e }
            int r6 = android.graphics.Color.red(r1)     // Catch:{ all -> 0x004e }
            int r6 = r6 + 37
            java.lang.Object r4 = com.appsflyer.internal.AFa1kSDK.getCurrencyIso4217Code(r4, r5, r6)     // Catch:{ all -> 0x004e }
            java.lang.Class r4 = (java.lang.Class) r4     // Catch:{ all -> 0x004e }
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ all -> 0x004e }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r0[r1] = r5     // Catch:{ all -> 0x004e }
            java.lang.reflect.Constructor r4 = r4.getDeclaredConstructor(r0)     // Catch:{ all -> 0x004e }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x004e }
            r8.put(r0, r4)     // Catch:{ all -> 0x004e }
        L_0x0044:
            java.lang.reflect.Constructor r4 = (java.lang.reflect.Constructor) r4     // Catch:{ all -> 0x004e }
            java.lang.Object r8 = r4.newInstance(r2)     // Catch:{ all -> 0x004e }
            r7.<init>((java.lang.Object) r8)
            return
        L_0x004e:
            r8 = move-exception
            java.lang.Throwable r0 = r8.getCause()
            if (r0 == 0) goto L_0x0056
            throw r0
        L_0x0056:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1dSDK.<init>(java.lang.String):void");
    }

    public final AFg1dSDK getCurrencyIso4217Code(String str, Object obj) throws AFg1mSDK {
        if (obj == null) {
            this.getRevenue.remove(str);
            return this;
        }
        if (obj instanceof Number) {
            try {
                Object[] objArr = {Double.valueOf(((Number) obj).doubleValue())};
                Map map = AFa1kSDK.i;
                Object obj2 = map.get(1011674371);
                if (obj2 == null) {
                    obj2 = ((Class) AFa1kSDK.getCurrencyIso4217Code(284 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getLongPressTimeout() >> 16), 37 - TextUtils.getTrimmedLength(""))).getMethod("getMonetizationNetwork", new Class[]{Double.TYPE});
                    map.put(1011674371, obj2);
                }
                ((Double) ((Method) obj2).invoke((Object) null, objArr)).getClass();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        LinkedHashMap<String, Object> linkedHashMap = this.getRevenue;
        if (str != null) {
            linkedHashMap.put(str, obj);
            return this;
        }
        throw new AFg1mSDK("Names must be non-null");
    }
}
