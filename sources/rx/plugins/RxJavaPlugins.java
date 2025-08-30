package rx.plugins;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

public class RxJavaPlugins {
    static final RxJavaErrorHandler DEFAULT_ERROR_HANDLER = new RxJavaErrorHandler() {
    };
    private static final RxJavaPlugins INSTANCE = new RxJavaPlugins();
    private final AtomicReference<RxJavaCompletableExecutionHook> completableExecutionHook = new AtomicReference<>();
    private final AtomicReference<RxJavaErrorHandler> errorHandler = new AtomicReference<>();
    private final AtomicReference<RxJavaObservableExecutionHook> observableExecutionHook = new AtomicReference<>();
    private final AtomicReference<RxJavaSchedulersHook> schedulersHook = new AtomicReference<>();
    private final AtomicReference<RxJavaSingleExecutionHook> singleExecutionHook = new AtomicReference<>();

    @Deprecated
    public static RxJavaPlugins getInstance() {
        return INSTANCE;
    }

    public static Object getPluginImplementationViaProperty(Class<?> cls, Properties properties) {
        Properties properties2 = (Properties) properties.clone();
        String simpleName = cls.getSimpleName();
        String property = properties2.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            try {
                Iterator it = properties2.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    String obj = entry.getKey().toString();
                    if (obj.startsWith("rxjava.plugin.") && obj.endsWith(".class") && simpleName.equals(entry.getValue().toString())) {
                        String str = "rxjava.plugin." + obj.substring(0, obj.length() - 6).substring(14) + ".impl";
                        property = properties2.getProperty(str);
                        if (property == null) {
                            throw new IllegalStateException("Implementing class declaration for " + simpleName + " missing: " + str);
                        }
                    }
                }
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
        if (property == null) {
            return null;
        }
        try {
            return Class.forName(property).asSubclass(cls).newInstance();
        } catch (ClassCastException e2) {
            throw new IllegalStateException(simpleName + " implementation is not an instance of " + simpleName + ": " + property, e2);
        } catch (ClassNotFoundException e3) {
            throw new IllegalStateException(e.m(simpleName, " implementation class not found: ", property), e3);
        } catch (InstantiationException e4) {
            throw new IllegalStateException(e.m(simpleName, " implementation not able to be instantiated: ", property), e4);
        } catch (IllegalAccessException e5) {
            throw new IllegalStateException(e.m(simpleName, " implementation not able to be accessed: ", property), e5);
        }
    }

    public static Properties getSystemPropertiesSafe() {
        try {
            return System.getProperties();
        } catch (SecurityException unused) {
            return new Properties();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e A[LOOP:1: B:10:0x002e->B:13:0x0039, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x001c A[LOOP:0: B:5:0x001c->B:8:0x0027, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public rx.plugins.RxJavaCompletableExecutionHook getCompletableExecutionHook() {
        /*
            r4 = this;
            java.util.concurrent.atomic.AtomicReference<rx.plugins.RxJavaCompletableExecutionHook> r0 = r4.completableExecutionHook
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L_0x003b
            java.lang.Class<rx.plugins.RxJavaCompletableExecutionHook> r0 = rx.plugins.RxJavaCompletableExecutionHook.class
            java.util.Properties r1 = getSystemPropertiesSafe()
            java.lang.Object r0 = getPluginImplementationViaProperty(r0, r1)
            r1 = 0
            if (r0 != 0) goto L_0x002a
            java.util.concurrent.atomic.AtomicReference<rx.plugins.RxJavaCompletableExecutionHook> r2 = r4.completableExecutionHook
            rx.plugins.RxJavaPlugins$2 r3 = new rx.plugins.RxJavaPlugins$2
            r3.<init>()
        L_0x001c:
            boolean r0 = r2.compareAndSet(r1, r3)
            if (r0 == 0) goto L_0x0023
            goto L_0x003b
        L_0x0023:
            java.lang.Object r0 = r2.get()
            if (r0 == 0) goto L_0x001c
            goto L_0x003b
        L_0x002a:
            java.util.concurrent.atomic.AtomicReference<rx.plugins.RxJavaCompletableExecutionHook> r2 = r4.completableExecutionHook
            rx.plugins.RxJavaCompletableExecutionHook r0 = (rx.plugins.RxJavaCompletableExecutionHook) r0
        L_0x002e:
            boolean r3 = r2.compareAndSet(r1, r0)
            if (r3 == 0) goto L_0x0035
            goto L_0x003b
        L_0x0035:
            java.lang.Object r3 = r2.get()
            if (r3 == 0) goto L_0x002e
        L_0x003b:
            java.util.concurrent.atomic.AtomicReference<rx.plugins.RxJavaCompletableExecutionHook> r0 = r4.completableExecutionHook
            java.lang.Object r0 = r0.get()
            rx.plugins.RxJavaCompletableExecutionHook r0 = (rx.plugins.RxJavaCompletableExecutionHook) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.plugins.RxJavaPlugins.getCompletableExecutionHook():rx.plugins.RxJavaCompletableExecutionHook");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b A[LOOP:1: B:10:0x002b->B:13:0x0036, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0019 A[LOOP:0: B:5:0x0019->B:8:0x0024, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public rx.plugins.RxJavaErrorHandler getErrorHandler() {
        /*
            r4 = this;
            java.util.concurrent.atomic.AtomicReference<rx.plugins.RxJavaErrorHandler> r0 = r4.errorHandler
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L_0x0038
            java.lang.Class<rx.plugins.RxJavaErrorHandler> r0 = rx.plugins.RxJavaErrorHandler.class
            java.util.Properties r1 = getSystemPropertiesSafe()
            java.lang.Object r0 = getPluginImplementationViaProperty(r0, r1)
            r1 = 0
            if (r0 != 0) goto L_0x0027
            java.util.concurrent.atomic.AtomicReference<rx.plugins.RxJavaErrorHandler> r2 = r4.errorHandler
            rx.plugins.RxJavaErrorHandler r3 = DEFAULT_ERROR_HANDLER
        L_0x0019:
            boolean r0 = r2.compareAndSet(r1, r3)
            if (r0 == 0) goto L_0x0020
            goto L_0x0038
        L_0x0020:
            java.lang.Object r0 = r2.get()
            if (r0 == 0) goto L_0x0019
            goto L_0x0038
        L_0x0027:
            java.util.concurrent.atomic.AtomicReference<rx.plugins.RxJavaErrorHandler> r2 = r4.errorHandler
            rx.plugins.RxJavaErrorHandler r0 = (rx.plugins.RxJavaErrorHandler) r0
        L_0x002b:
            boolean r3 = r2.compareAndSet(r1, r0)
            if (r3 == 0) goto L_0x0032
            goto L_0x0038
        L_0x0032:
            java.lang.Object r3 = r2.get()
            if (r3 == 0) goto L_0x002b
        L_0x0038:
            java.util.concurrent.atomic.AtomicReference<rx.plugins.RxJavaErrorHandler> r0 = r4.errorHandler
            java.lang.Object r0 = r0.get()
            rx.plugins.RxJavaErrorHandler r0 = (rx.plugins.RxJavaErrorHandler) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.plugins.RxJavaPlugins.getErrorHandler():rx.plugins.RxJavaErrorHandler");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d A[LOOP:1: B:10:0x002d->B:13:0x0038, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x001b A[LOOP:0: B:5:0x001b->B:8:0x0026, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public rx.plugins.RxJavaObservableExecutionHook getObservableExecutionHook() {
        /*
            r4 = this;
            java.util.concurrent.atomic.AtomicReference<rx.plugins.RxJavaObservableExecutionHook> r0 = r4.observableExecutionHook
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L_0x003a
            java.lang.Class<rx.plugins.RxJavaObservableExecutionHook> r0 = rx.plugins.RxJavaObservableExecutionHook.class
            java.util.Properties r1 = getSystemPropertiesSafe()
            java.lang.Object r0 = getPluginImplementationViaProperty(r0, r1)
            r1 = 0
            if (r0 != 0) goto L_0x0029
            java.util.concurrent.atomic.AtomicReference<rx.plugins.RxJavaObservableExecutionHook> r2 = r4.observableExecutionHook
            rx.plugins.RxJavaObservableExecutionHook r3 = rx.plugins.RxJavaObservableExecutionHookDefault.getInstance()
        L_0x001b:
            boolean r0 = r2.compareAndSet(r1, r3)
            if (r0 == 0) goto L_0x0022
            goto L_0x003a
        L_0x0022:
            java.lang.Object r0 = r2.get()
            if (r0 == 0) goto L_0x001b
            goto L_0x003a
        L_0x0029:
            java.util.concurrent.atomic.AtomicReference<rx.plugins.RxJavaObservableExecutionHook> r2 = r4.observableExecutionHook
            rx.plugins.RxJavaObservableExecutionHook r0 = (rx.plugins.RxJavaObservableExecutionHook) r0
        L_0x002d:
            boolean r3 = r2.compareAndSet(r1, r0)
            if (r3 == 0) goto L_0x0034
            goto L_0x003a
        L_0x0034:
            java.lang.Object r3 = r2.get()
            if (r3 == 0) goto L_0x002d
        L_0x003a:
            java.util.concurrent.atomic.AtomicReference<rx.plugins.RxJavaObservableExecutionHook> r0 = r4.observableExecutionHook
            java.lang.Object r0 = r0.get()
            rx.plugins.RxJavaObservableExecutionHook r0 = (rx.plugins.RxJavaObservableExecutionHook) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.plugins.RxJavaPlugins.getObservableExecutionHook():rx.plugins.RxJavaObservableExecutionHook");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d A[LOOP:1: B:10:0x002d->B:13:0x0038, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x001b A[LOOP:0: B:5:0x001b->B:8:0x0026, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public rx.plugins.RxJavaSchedulersHook getSchedulersHook() {
        /*
            r4 = this;
            java.util.concurrent.atomic.AtomicReference<rx.plugins.RxJavaSchedulersHook> r0 = r4.schedulersHook
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L_0x003a
            java.lang.Class<rx.plugins.RxJavaSchedulersHook> r0 = rx.plugins.RxJavaSchedulersHook.class
            java.util.Properties r1 = getSystemPropertiesSafe()
            java.lang.Object r0 = getPluginImplementationViaProperty(r0, r1)
            r1 = 0
            if (r0 != 0) goto L_0x0029
            java.util.concurrent.atomic.AtomicReference<rx.plugins.RxJavaSchedulersHook> r2 = r4.schedulersHook
            rx.plugins.RxJavaSchedulersHook r3 = rx.plugins.RxJavaSchedulersHook.getDefaultInstance()
        L_0x001b:
            boolean r0 = r2.compareAndSet(r1, r3)
            if (r0 == 0) goto L_0x0022
            goto L_0x003a
        L_0x0022:
            java.lang.Object r0 = r2.get()
            if (r0 == 0) goto L_0x001b
            goto L_0x003a
        L_0x0029:
            java.util.concurrent.atomic.AtomicReference<rx.plugins.RxJavaSchedulersHook> r2 = r4.schedulersHook
            rx.plugins.RxJavaSchedulersHook r0 = (rx.plugins.RxJavaSchedulersHook) r0
        L_0x002d:
            boolean r3 = r2.compareAndSet(r1, r0)
            if (r3 == 0) goto L_0x0034
            goto L_0x003a
        L_0x0034:
            java.lang.Object r3 = r2.get()
            if (r3 == 0) goto L_0x002d
        L_0x003a:
            java.util.concurrent.atomic.AtomicReference<rx.plugins.RxJavaSchedulersHook> r0 = r4.schedulersHook
            java.lang.Object r0 = r0.get()
            rx.plugins.RxJavaSchedulersHook r0 = (rx.plugins.RxJavaSchedulersHook) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.plugins.RxJavaPlugins.getSchedulersHook():rx.plugins.RxJavaSchedulersHook");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d A[LOOP:1: B:10:0x002d->B:13:0x0038, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x001b A[LOOP:0: B:5:0x001b->B:8:0x0026, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public rx.plugins.RxJavaSingleExecutionHook getSingleExecutionHook() {
        /*
            r4 = this;
            java.util.concurrent.atomic.AtomicReference<rx.plugins.RxJavaSingleExecutionHook> r0 = r4.singleExecutionHook
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L_0x003a
            java.lang.Class<rx.plugins.RxJavaSingleExecutionHook> r0 = rx.plugins.RxJavaSingleExecutionHook.class
            java.util.Properties r1 = getSystemPropertiesSafe()
            java.lang.Object r0 = getPluginImplementationViaProperty(r0, r1)
            r1 = 0
            if (r0 != 0) goto L_0x0029
            java.util.concurrent.atomic.AtomicReference<rx.plugins.RxJavaSingleExecutionHook> r2 = r4.singleExecutionHook
            rx.plugins.RxJavaSingleExecutionHook r3 = rx.plugins.RxJavaSingleExecutionHookDefault.getInstance()
        L_0x001b:
            boolean r0 = r2.compareAndSet(r1, r3)
            if (r0 == 0) goto L_0x0022
            goto L_0x003a
        L_0x0022:
            java.lang.Object r0 = r2.get()
            if (r0 == 0) goto L_0x001b
            goto L_0x003a
        L_0x0029:
            java.util.concurrent.atomic.AtomicReference<rx.plugins.RxJavaSingleExecutionHook> r2 = r4.singleExecutionHook
            rx.plugins.RxJavaSingleExecutionHook r0 = (rx.plugins.RxJavaSingleExecutionHook) r0
        L_0x002d:
            boolean r3 = r2.compareAndSet(r1, r0)
            if (r3 == 0) goto L_0x0034
            goto L_0x003a
        L_0x0034:
            java.lang.Object r3 = r2.get()
            if (r3 == 0) goto L_0x002d
        L_0x003a:
            java.util.concurrent.atomic.AtomicReference<rx.plugins.RxJavaSingleExecutionHook> r0 = r4.singleExecutionHook
            java.lang.Object r0 = r0.get()
            rx.plugins.RxJavaSingleExecutionHook r0 = (rx.plugins.RxJavaSingleExecutionHook) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.plugins.RxJavaPlugins.getSingleExecutionHook():rx.plugins.RxJavaSingleExecutionHook");
    }

    public void registerCompletableExecutionHook(RxJavaCompletableExecutionHook rxJavaCompletableExecutionHook) {
        AtomicReference<RxJavaCompletableExecutionHook> atomicReference = this.completableExecutionHook;
        while (!atomicReference.compareAndSet((Object) null, rxJavaCompletableExecutionHook)) {
            if (atomicReference.get() != null) {
                throw new IllegalStateException("Another strategy was already registered: " + this.singleExecutionHook.get());
            }
        }
    }

    public void registerErrorHandler(RxJavaErrorHandler rxJavaErrorHandler) {
        AtomicReference<RxJavaErrorHandler> atomicReference = this.errorHandler;
        while (!atomicReference.compareAndSet((Object) null, rxJavaErrorHandler)) {
            if (atomicReference.get() != null) {
                throw new IllegalStateException("Another strategy was already registered: " + this.errorHandler.get());
            }
        }
    }

    public void registerObservableExecutionHook(RxJavaObservableExecutionHook rxJavaObservableExecutionHook) {
        AtomicReference<RxJavaObservableExecutionHook> atomicReference = this.observableExecutionHook;
        while (!atomicReference.compareAndSet((Object) null, rxJavaObservableExecutionHook)) {
            if (atomicReference.get() != null) {
                throw new IllegalStateException("Another strategy was already registered: " + this.observableExecutionHook.get());
            }
        }
    }

    public void registerSchedulersHook(RxJavaSchedulersHook rxJavaSchedulersHook) {
        AtomicReference<RxJavaSchedulersHook> atomicReference = this.schedulersHook;
        while (!atomicReference.compareAndSet((Object) null, rxJavaSchedulersHook)) {
            if (atomicReference.get() != null) {
                throw new IllegalStateException("Another strategy was already registered: " + this.schedulersHook.get());
            }
        }
    }

    public void registerSingleExecutionHook(RxJavaSingleExecutionHook rxJavaSingleExecutionHook) {
        AtomicReference<RxJavaSingleExecutionHook> atomicReference = this.singleExecutionHook;
        while (!atomicReference.compareAndSet((Object) null, rxJavaSingleExecutionHook)) {
            if (atomicReference.get() != null) {
                throw new IllegalStateException("Another strategy was already registered: " + this.singleExecutionHook.get());
            }
        }
    }

    public void reset() {
        RxJavaPlugins rxJavaPlugins = INSTANCE;
        rxJavaPlugins.errorHandler.set((Object) null);
        rxJavaPlugins.observableExecutionHook.set((Object) null);
        rxJavaPlugins.singleExecutionHook.set((Object) null);
        rxJavaPlugins.completableExecutionHook.set((Object) null);
        rxJavaPlugins.schedulersHook.set((Object) null);
    }
}
