package com.appsflyer.internal;

import androidx.annotation.Nullable;
import java.util.HashMap;

public class AFa1nSDK extends HashMap<Integer, String> {
    private static AFa1nSDK getMonetizationNetwork;
    private final Object getRevenue = new Object();

    private AFa1nSDK() {
    }

    public static synchronized AFa1nSDK afErrorLog() {
        AFa1nSDK aFa1nSDK;
        synchronized (AFa1nSDK.class) {
            try {
                if (getMonetizationNetwork == null) {
                    getMonetizationNetwork = new AFa1nSDK();
                }
                aFa1nSDK = getMonetizationNetwork;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return aFa1nSDK;
    }

    @Nullable
    public String put(Integer num, String str) {
        String str2;
        synchronized (this.getRevenue) {
            str2 = (String) super.put(num, str);
        }
        return str2;
    }

    public boolean remove(@Nullable Object obj, @Nullable Object obj2) {
        boolean remove;
        synchronized (this.getRevenue) {
            remove = super.remove(obj, obj2);
        }
        return remove;
    }

    public String remove(@Nullable Object obj) {
        String str;
        synchronized (this.getRevenue) {
            str = (String) super.remove(obj);
        }
        return str;
    }
}
