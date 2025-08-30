package com.ktakilat.cbase.utils;

import android.view.View;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FastClickUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentHashMap f476a = new ConcurrentHashMap();

    public static boolean a(View view) {
        if (view == null) {
            return false;
        }
        String view2 = view.toString();
        ConcurrentHashMap concurrentHashMap = f476a;
        try {
            Iterator it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                if (System.currentTimeMillis() - ((Long) ((Map.Entry) it.next()).getValue()).longValue() > 500) {
                    it.remove();
                }
            }
        } catch (Exception unused) {
            concurrentHashMap.clear();
        }
        if (concurrentHashMap.containsKey(view2)) {
            if (((Long) concurrentHashMap.get(view2)) != null) {
                return false;
            }
            concurrentHashMap.remove(view2);
        }
        concurrentHashMap.put(view2, Long.valueOf(System.currentTimeMillis()));
        return true;
    }
}
