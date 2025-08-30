package com.appsflyer.internal;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class AFg1eSDK {
    private final String getCurrencyIso4217Code = null;
    private final List<AFa1uSDK> getMonetizationNetwork = new ArrayList();
    private StringBuilder getRevenue = new StringBuilder();

    public enum AFa1uSDK {
        EMPTY_ARRAY,
        NONEMPTY_ARRAY,
        EMPTY_OBJECT,
        DANGLING_KEY,
        NONEMPTY_OBJECT,
        NULL
    }

    private void getMediationNetwork() throws AFg1mSDK {
        if (!this.getMonetizationNetwork.isEmpty()) {
            AFa1uSDK AFAdRevenueData = AFAdRevenueData();
            if (AFAdRevenueData == AFa1uSDK.EMPTY_ARRAY) {
                AFa1uSDK aFa1uSDK = AFa1uSDK.NONEMPTY_ARRAY;
                List<AFa1uSDK> list = this.getMonetizationNetwork;
                list.set(list.size() - 1, aFa1uSDK);
            } else if (AFAdRevenueData == AFa1uSDK.NONEMPTY_ARRAY) {
                this.getRevenue.append(',');
            } else if (AFAdRevenueData == AFa1uSDK.DANGLING_KEY) {
                this.getRevenue.append(":");
                AFa1uSDK aFa1uSDK2 = AFa1uSDK.NONEMPTY_OBJECT;
                List<AFa1uSDK> list2 = this.getMonetizationNetwork;
                list2.set(list2.size() - 1, aFa1uSDK2);
            } else if (AFAdRevenueData != AFa1uSDK.NULL) {
                throw new AFg1mSDK("Nesting problem");
            }
        }
    }

    public final AFg1eSDK AFAdRevenueData(AFa1uSDK aFa1uSDK, AFa1uSDK aFa1uSDK2, String str) throws AFg1mSDK {
        AFa1uSDK AFAdRevenueData = AFAdRevenueData();
        if (AFAdRevenueData == aFa1uSDK2 || AFAdRevenueData == aFa1uSDK) {
            List<AFa1uSDK> list = this.getMonetizationNetwork;
            list.remove(list.size() - 1);
            this.getRevenue.append(str);
            return this;
        }
        throw new AFg1mSDK("Nesting problem");
    }

    public final AFg1eSDK getCurrencyIso4217Code(AFa1uSDK aFa1uSDK, String str) throws AFg1mSDK {
        if (!this.getMonetizationNetwork.isEmpty() || this.getRevenue.length() <= 0) {
            getMediationNetwork();
            this.getMonetizationNetwork.add(aFa1uSDK);
            this.getRevenue.append(str);
            return this;
        }
        throw new AFg1mSDK("Nesting problem: multiple top-level roots");
    }

    public final void getMonetizationNetwork() throws AFg1mSDK {
        AFa1uSDK AFAdRevenueData = AFAdRevenueData();
        if (AFAdRevenueData == AFa1uSDK.NONEMPTY_OBJECT) {
            this.getRevenue.append(',');
        } else if (AFAdRevenueData != AFa1uSDK.EMPTY_OBJECT) {
            throw new AFg1mSDK("Nesting problem");
        }
        AFa1uSDK aFa1uSDK = AFa1uSDK.DANGLING_KEY;
        List<AFa1uSDK> list = this.getMonetizationNetwork;
        list.set(list.size() - 1, aFa1uSDK);
    }

    public final AFg1eSDK getRevenue(Object obj) throws AFg1mSDK {
        if (this.getMonetizationNetwork.isEmpty()) {
            throw new AFg1mSDK("Nesting problem");
        } else if (((Class) AFa1kSDK.getCurrencyIso4217Code(321 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (2133 - Drawable.resolveOpacity(0, 0)), 37 - (SystemClock.uptimeMillis() > 0 ? 1 : (SystemClock.uptimeMillis() == 0 ? 0 : -1)))).isInstance(obj)) {
            try {
                Object[] objArr = {this};
                Map map = AFa1kSDK.i;
                Object obj2 = map.get(704691833);
                if (obj2 == null) {
                    obj2 = ((Class) AFa1kSDK.getCurrencyIso4217Code((SystemClock.uptimeMillis() > 0 ? 1 : (SystemClock.uptimeMillis() == 0 ? 0 : -1)) + 320, (char) (2133 - KeyEvent.keyCodeFromString("")), TextUtils.indexOf("", '0') + 37)).getDeclaredMethod("getMonetizationNetwork", new Class[]{AFg1eSDK.class});
                    map.put(704691833, obj2);
                }
                ((Method) obj2).invoke(obj, objArr);
                return this;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } else if (obj instanceof AFg1dSDK) {
            ((AFg1dSDK) obj).AFAdRevenueData(this);
            return this;
        } else {
            getMediationNetwork();
            if (obj == null || (obj instanceof Boolean) || obj == AFg1dSDK.getMonetizationNetwork) {
                this.getRevenue.append(obj);
            } else if (obj instanceof Number) {
                this.getRevenue.append(AFg1dSDK.getMediationNetwork((Number) obj));
            } else {
                getCurrencyIso4217Code(obj.toString());
            }
            return this;
        }
    }

    public final String toString() {
        if (this.getRevenue.length() == 0) {
            return null;
        }
        return this.getRevenue.toString();
    }

    private AFa1uSDK AFAdRevenueData() throws AFg1mSDK {
        if (!this.getMonetizationNetwork.isEmpty()) {
            return (AFa1uSDK) e.f(this.getMonetizationNetwork, 1);
        }
        throw new AFg1mSDK("Nesting problem");
    }

    public final void getCurrencyIso4217Code(String str) {
        this.getRevenue.append("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 12) {
                this.getRevenue.append("\\f");
            } else if (charAt != 13) {
                if (charAt != '\"' && charAt != '/' && charAt != '\\') {
                    switch (charAt) {
                        case 8:
                            this.getRevenue.append("\\b");
                            break;
                        case 9:
                            this.getRevenue.append("\\t");
                            break;
                        case 10:
                            this.getRevenue.append("\\n");
                            break;
                        default:
                            if (charAt > 31) {
                                this.getRevenue.append(charAt);
                                break;
                            } else {
                                this.getRevenue.append(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                                break;
                            }
                    }
                } else {
                    StringBuilder sb = this.getRevenue;
                    sb.append('\\');
                    sb.append(charAt);
                }
            } else {
                this.getRevenue.append("\\r");
            }
        }
        this.getRevenue.append("\"");
    }
}
