package org.greenrobot.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.meta.SubscriberInfo;

class SubscriberMethodFinder {

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentHashMap f837a = new ConcurrentHashMap();
    public static final FindState[] b = new FindState[4];

    public static class FindState {

        /* renamed from: a  reason: collision with root package name */
        public final ArrayList f838a = new ArrayList();
        public final HashMap b = new HashMap();
        public final HashMap c = new HashMap();
        public final StringBuilder d = new StringBuilder(128);
        public Class e;
        public boolean f;
        public SubscriberInfo g;

        public final boolean a(Method method, Class cls) {
            StringBuilder sb = this.d;
            sb.setLength(0);
            sb.append(method.getName());
            sb.append('>');
            sb.append(cls.getName());
            String sb2 = sb.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            HashMap hashMap = this.c;
            Class cls2 = (Class) hashMap.put(sb2, declaringClass);
            if (cls2 == null || cls2.isAssignableFrom(declaringClass)) {
                return true;
            }
            hashMap.put(sb2, cls2);
            return false;
        }
    }

    public static ArrayList a(FindState findState) {
        ArrayList arrayList = new ArrayList(findState.f838a);
        findState.f838a.clear();
        findState.b.clear();
        findState.c.clear();
        int i = 0;
        findState.d.setLength(0);
        findState.e = null;
        findState.f = false;
        findState.g = null;
        synchronized (b) {
            while (true) {
                if (i >= 4) {
                    break;
                }
                try {
                    FindState[] findStateArr = b;
                    if (findStateArr[i] == null) {
                        findStateArr[i] = findState;
                        break;
                    }
                    i++;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return arrayList;
    }

    public static FindState b() {
        synchronized (b) {
            int i = 0;
            while (i < 4) {
                try {
                    FindState[] findStateArr = b;
                    FindState findState = findStateArr[i];
                    if (findState != null) {
                        findStateArr[i] = null;
                        return findState;
                    }
                    i++;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            return new FindState();
        }
    }
}
