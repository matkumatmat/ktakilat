package org.greenrobot.eventbus;

import android.os.Looper;
import com.ktakilat.cbase.ui.BaseActivity;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import org.greenrobot.eventbus.MainThreadSupport;
import org.greenrobot.eventbus.SubscriberMethodFinder;
import org.greenrobot.eventbus.meta.SubscriberInfo;

public class EventBus {
    public static volatile EventBus q;
    public static final EventBusBuilder r;
    public static final HashMap s = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f826a;
    public final HashMap b;
    public final ConcurrentHashMap c;
    public final ThreadLocal d = new ThreadLocal();
    public final MainThreadSupport.AndroidHandlerMainThreadSupport e;
    public final Poster f;
    public final BackgroundPoster g;
    public final AsyncPoster h;
    public final SubscriberMethodFinder i;
    public final ExecutorService j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final Logger p;

    /* renamed from: org.greenrobot.eventbus.EventBus$1  reason: invalid class name */
    public class AnonymousClass1 extends ThreadLocal<PostingThreadState> {
        public final Object initialValue() {
            return new PostingThreadState();
        }
    }

    /* renamed from: org.greenrobot.eventbus.EventBus$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f827a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.greenrobot.eventbus.ThreadMode[] r0 = org.greenrobot.eventbus.ThreadMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f827a = r0
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.POSTING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f827a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.MAIN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f827a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.MAIN_ORDERED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f827a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.BACKGROUND     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f827a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.ASYNC     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.EventBus.AnonymousClass2.<clinit>():void");
        }
    }

    public interface PostCallback {
    }

    public static final class PostingThreadState {

        /* renamed from: a  reason: collision with root package name */
        public final ArrayList f828a = new ArrayList();
        public boolean b;
        public boolean c;
        public Object d;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [org.greenrobot.eventbus.EventBusBuilder, java.lang.Object] */
    static {
        ? obj = new Object();
        obj.f829a = EventBusBuilder.b;
        r = obj;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: org.greenrobot.eventbus.Logger} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: org.greenrobot.eventbus.Logger} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: org.greenrobot.eventbus.Logger} */
    /* JADX WARNING: type inference failed for: r1v4, types: [java.lang.Object, org.greenrobot.eventbus.SubscriberMethodFinder] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0041 A[SYNTHETIC, Splitter:B:11:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public EventBus() {
        /*
            r4 = this;
            org.greenrobot.eventbus.EventBusBuilder r0 = r
            r4.<init>()
            org.greenrobot.eventbus.EventBus$1 r1 = new org.greenrobot.eventbus.EventBus$1
            r1.<init>()
            r4.d = r1
            r0.getClass()
            boolean r1 = org.greenrobot.eventbus.Logger.AndroidLogger.f830a
            r2 = 0
            if (r1 == 0) goto L_0x0023
            android.os.Looper r3 = android.os.Looper.getMainLooper()     // Catch:{ RuntimeException -> 0x0019 }
            goto L_0x001b
        L_0x0019:
            r3 = r2
        L_0x001b:
            if (r3 == 0) goto L_0x0023
            org.greenrobot.eventbus.Logger$AndroidLogger r3 = new org.greenrobot.eventbus.Logger$AndroidLogger
            r3.<init>()
            goto L_0x0028
        L_0x0023:
            org.greenrobot.eventbus.Logger$SystemOutLogger r3 = new org.greenrobot.eventbus.Logger$SystemOutLogger
            r3.<init>()
        L_0x0028:
            r4.p = r3
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r4.f826a = r3
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r4.b = r3
            java.util.concurrent.ConcurrentHashMap r3 = new java.util.concurrent.ConcurrentHashMap
            r3.<init>()
            r4.c = r3
            if (r1 == 0) goto L_0x0051
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch:{ RuntimeException -> 0x0046 }
            goto L_0x0048
        L_0x0046:
            r1 = r2
        L_0x0048:
            if (r1 != 0) goto L_0x004b
            goto L_0x0051
        L_0x004b:
            org.greenrobot.eventbus.MainThreadSupport$AndroidHandlerMainThreadSupport r3 = new org.greenrobot.eventbus.MainThreadSupport$AndroidHandlerMainThreadSupport
            r3.<init>(r1)
            goto L_0x0052
        L_0x0051:
            r3 = r2
        L_0x0052:
            r4.e = r3
            if (r3 == 0) goto L_0x005d
            org.greenrobot.eventbus.HandlerPoster r2 = new org.greenrobot.eventbus.HandlerPoster
            android.os.Looper r1 = r3.f831a
            r2.<init>(r4, r1)
        L_0x005d:
            r4.f = r2
            org.greenrobot.eventbus.BackgroundPoster r1 = new org.greenrobot.eventbus.BackgroundPoster
            r1.<init>(r4)
            r4.g = r1
            org.greenrobot.eventbus.AsyncPoster r1 = new org.greenrobot.eventbus.AsyncPoster
            r1.<init>(r4)
            r4.h = r1
            org.greenrobot.eventbus.SubscriberMethodFinder r1 = new org.greenrobot.eventbus.SubscriberMethodFinder
            r1.<init>()
            r4.i = r1
            r1 = 1
            r4.k = r1
            r4.l = r1
            r4.m = r1
            r4.n = r1
            r4.o = r1
            java.util.concurrent.ExecutorService r0 = r0.f829a
            r4.j = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.EventBus.<init>():void");
    }

    public static void a(ArrayList arrayList, Class[] clsArr) {
        for (Class cls : clsArr) {
            if (!arrayList.contains(cls)) {
                arrayList.add(cls);
                a(arrayList, cls.getInterfaces());
            }
        }
    }

    public static EventBus b() {
        if (q == null) {
            synchronized (EventBus.class) {
                try {
                    if (q == null) {
                        q = new EventBus();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return q;
    }

    public final void c(PendingPost pendingPost) {
        Object obj = pendingPost.f833a;
        Subscription subscription = pendingPost.b;
        pendingPost.f833a = null;
        pendingPost.b = null;
        pendingPost.c = null;
        ArrayList arrayList = PendingPost.d;
        synchronized (arrayList) {
            if (arrayList.size() < 10000) {
                arrayList.add(pendingPost);
            }
        }
        if (subscription.c) {
            d(subscription, obj);
        }
    }

    public final void d(Subscription subscription, Object obj) {
        try {
            subscription.b.f836a.invoke(subscription.f839a, new Object[]{obj});
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            boolean z = obj instanceof SubscriberExceptionEvent;
            boolean z2 = this.k;
            Logger logger = this.p;
            if (!z) {
                if (z2) {
                    Level level = Level.SEVERE;
                    logger.b(level, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + subscription.f839a.getClass(), cause);
                }
                if (this.m) {
                    e(new SubscriberExceptionEvent(cause, obj, subscription.f839a));
                }
            } else if (z2) {
                Level level2 = Level.SEVERE;
                logger.b(level2, "SubscriberExceptionEvent subscriber " + subscription.f839a.getClass() + " threw an exception", cause);
                SubscriberExceptionEvent subscriberExceptionEvent = (SubscriberExceptionEvent) obj;
                logger.b(level2, "Initial event " + subscriberExceptionEvent.b + " caused exception in " + subscriberExceptionEvent.c, subscriberExceptionEvent.f835a);
            }
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException("Unexpected exception", e3);
        }
    }

    public final void e(Object obj) {
        boolean z;
        PostingThreadState postingThreadState = (PostingThreadState) this.d.get();
        ArrayList arrayList = postingThreadState.f828a;
        arrayList.add(obj);
        if (!postingThreadState.b) {
            MainThreadSupport.AndroidHandlerMainThreadSupport androidHandlerMainThreadSupport = this.e;
            if (androidHandlerMainThreadSupport == null || androidHandlerMainThreadSupport.f831a == Looper.myLooper()) {
                z = true;
            } else {
                z = false;
            }
            postingThreadState.c = z;
            postingThreadState.b = true;
            while (!arrayList.isEmpty()) {
                try {
                    f(arrayList.remove(0), postingThreadState);
                } finally {
                    postingThreadState.b = false;
                    postingThreadState.c = false;
                }
            }
        }
    }

    public final void f(Object obj, PostingThreadState postingThreadState) {
        boolean z;
        ArrayList arrayList;
        Class<?> cls = obj.getClass();
        if (this.o) {
            HashMap hashMap = s;
            synchronized (hashMap) {
                try {
                    List list = (List) hashMap.get(cls);
                    arrayList = list;
                    if (list == null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                            arrayList2.add(cls2);
                            a(arrayList2, cls2.getInterfaces());
                        }
                        s.put(cls, arrayList2);
                        arrayList = arrayList2;
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            int size = arrayList.size();
            z = false;
            for (int i2 = 0; i2 < size; i2++) {
                z |= g(obj, postingThreadState, (Class) arrayList.get(i2));
            }
        } else {
            z = g(obj, postingThreadState, cls);
        }
        if (!z) {
            if (this.l) {
                Logger logger = this.p;
                Level level = Level.FINE;
                logger.a(level, "No subscribers registered for event " + cls);
            }
            if (this.n && cls != NoSubscriberEvent.class && cls != SubscriberExceptionEvent.class) {
                e(new NoSubscriberEvent(obj));
            }
        }
    }

    public final boolean g(Object obj, PostingThreadState postingThreadState, Class cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = (CopyOnWriteArrayList) this.f826a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            postingThreadState.d = obj;
            h((Subscription) it.next(), obj, postingThreadState.c);
        }
        return true;
    }

    public final void h(Subscription subscription, Object obj, boolean z) {
        int i2 = AnonymousClass2.f827a[subscription.b.b.ordinal()];
        if (i2 != 1) {
            Poster poster = this.f;
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            this.h.a(subscription, obj);
                            return;
                        }
                        throw new IllegalStateException("Unknown thread mode: " + subscription.b.b);
                    } else if (z) {
                        this.g.a(subscription, obj);
                    } else {
                        d(subscription, obj);
                    }
                } else if (poster != null) {
                    poster.a(subscription, obj);
                } else {
                    d(subscription, obj);
                }
            } else if (z) {
                d(subscription, obj);
            } else {
                poster.a(subscription, obj);
            }
        } else {
            d(subscription, obj);
        }
    }

    public final void i(BaseActivity baseActivity) {
        Method[] methodArr;
        Subscribe subscribe;
        boolean z;
        Class<?> cls = baseActivity.getClass();
        SubscriberMethodFinder subscriberMethodFinder = this.i;
        subscriberMethodFinder.getClass();
        ConcurrentHashMap concurrentHashMap = SubscriberMethodFinder.f837a;
        List<SubscriberMethod> list = (List) concurrentHashMap.get(cls);
        if (list == null) {
            SubscriberMethodFinder.FindState b2 = SubscriberMethodFinder.b();
            b2.e = cls;
            b2.f = false;
            SubscriberInfo subscriberInfo = null;
            b2.g = null;
            while (b2.e != null) {
                b2.g = subscriberInfo;
                subscriberMethodFinder.getClass();
                int i2 = 1;
                try {
                    methodArr = b2.e.getDeclaredMethods();
                } catch (Throwable unused) {
                    methodArr = b2.e.getMethods();
                    b2.f = true;
                }
                int length = methodArr.length;
                int i3 = 0;
                while (i3 < length) {
                    Method method = methodArr[i3];
                    int modifiers = method.getModifiers();
                    if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                        Class[] parameterTypes = method.getParameterTypes();
                        if (parameterTypes.length == i2 && (subscribe = (Subscribe) method.getAnnotation(Subscribe.class)) != null) {
                            Class cls2 = parameterTypes[0];
                            HashMap hashMap = b2.b;
                            Object put = hashMap.put(cls2, method);
                            if (put == null) {
                                z = true;
                            } else {
                                if (put instanceof Method) {
                                    if (b2.a((Method) put, cls2)) {
                                        hashMap.put(cls2, b2);
                                    } else {
                                        throw new IllegalStateException();
                                    }
                                }
                                z = b2.a(method, cls2);
                            }
                            if (z) {
                                ThreadMode threadMode = subscribe.threadMode();
                                ArrayList arrayList = b2.f838a;
                                int priority = subscribe.priority();
                                boolean sticky = subscribe.sticky();
                                SubscriberMethod subscriberMethod = r11;
                                Class cls3 = cls2;
                                ThreadMode threadMode2 = threadMode;
                                SubscriberMethod subscriberMethod2 = new SubscriberMethod(method, cls3, threadMode2, priority, sticky);
                                arrayList.add(subscriberMethod);
                            }
                        }
                    }
                    i3++;
                    i2 = 1;
                }
                if (b2.f) {
                    b2.e = null;
                } else {
                    Class superclass = b2.e.getSuperclass();
                    b2.e = superclass;
                    String name = superclass.getName();
                    if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                        b2.e = null;
                    }
                }
                subscriberInfo = null;
            }
            list = SubscriberMethodFinder.a(b2);
            if (!list.isEmpty()) {
                concurrentHashMap.put(cls, list);
            } else {
                throw new EventBusException("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
            }
        }
        synchronized (this) {
            try {
                for (SubscriberMethod j2 : list) {
                    j(baseActivity, j2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j(BaseActivity baseActivity, SubscriberMethod subscriberMethod) {
        Object value;
        boolean z;
        Class cls = subscriberMethod.c;
        Subscription subscription = new Subscription(baseActivity, subscriberMethod);
        HashMap hashMap = this.f826a;
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) hashMap.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            hashMap.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(subscription)) {
            throw new EventBusException("Subscriber " + baseActivity.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 > size) {
                break;
            } else if (i2 == size || subscriberMethod.d > ((Subscription) copyOnWriteArrayList.get(i2)).b.d) {
                copyOnWriteArrayList.add(i2, subscription);
            } else {
                i2++;
            }
        }
        copyOnWriteArrayList.add(i2, subscription);
        HashMap hashMap2 = this.b;
        List list = (List) hashMap2.get(baseActivity);
        if (list == null) {
            list = new ArrayList();
            hashMap2.put(baseActivity, list);
        }
        list.add(cls);
        if (subscriberMethod.e) {
            ConcurrentHashMap concurrentHashMap = this.c;
            MainThreadSupport.AndroidHandlerMainThreadSupport androidHandlerMainThreadSupport = this.e;
            boolean z3 = true;
            if (this.o) {
                for (Map.Entry entry : concurrentHashMap.entrySet()) {
                    if (cls.isAssignableFrom((Class) entry.getKey()) && (value = entry.getValue()) != null) {
                        if (androidHandlerMainThreadSupport == null || androidHandlerMainThreadSupport.f831a == Looper.myLooper()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        h(subscription, value, z);
                    }
                }
                return;
            }
            Object obj = concurrentHashMap.get(cls);
            if (obj != null) {
                if (androidHandlerMainThreadSupport != null) {
                    if (androidHandlerMainThreadSupport.f831a == Looper.myLooper()) {
                        z2 = true;
                    }
                    z3 = z2;
                }
                h(subscription, obj, z3);
            }
        }
    }

    public final synchronized void k(Object obj) {
        try {
            List<Class> list = (List) this.b.get(obj);
            if (list != null) {
                for (Class cls : list) {
                    List list2 = (List) this.f826a.get(cls);
                    if (list2 != null) {
                        int size = list2.size();
                        int i2 = 0;
                        while (i2 < size) {
                            Subscription subscription = (Subscription) list2.get(i2);
                            if (subscription.f839a == obj) {
                                subscription.c = false;
                                list2.remove(i2);
                                i2--;
                                size--;
                            }
                            i2++;
                        }
                    }
                }
                this.b.remove(obj);
            } else {
                this.p.a(Level.WARNING, "Subscriber to unregister was not registered before: " + obj.getClass());
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final String toString() {
        return "EventBus[indexCount=0, eventInheritance=" + this.o + "]";
    }
}
