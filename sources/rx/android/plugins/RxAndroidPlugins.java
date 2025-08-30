package rx.android.plugins;

import java.util.concurrent.atomic.AtomicReference;
import rx.annotations.Experimental;

public final class RxAndroidPlugins {
    private static final RxAndroidPlugins INSTANCE = new RxAndroidPlugins();
    private final AtomicReference<RxAndroidSchedulersHook> schedulersHook = new AtomicReference<>();

    public static RxAndroidPlugins getInstance() {
        return INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000e A[LOOP:0: B:3:0x000e->B:6:0x001a, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public rx.android.plugins.RxAndroidSchedulersHook getSchedulersHook() {
        /*
            r3 = this;
            java.util.concurrent.atomic.AtomicReference<rx.android.plugins.RxAndroidSchedulersHook> r0 = r3.schedulersHook
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L_0x001c
            java.util.concurrent.atomic.AtomicReference<rx.android.plugins.RxAndroidSchedulersHook> r0 = r3.schedulersHook
            rx.android.plugins.RxAndroidSchedulersHook r1 = rx.android.plugins.RxAndroidSchedulersHook.getDefaultInstance()
        L_0x000e:
            r2 = 0
            boolean r2 = r0.compareAndSet(r2, r1)
            if (r2 == 0) goto L_0x0016
            goto L_0x001c
        L_0x0016:
            java.lang.Object r2 = r0.get()
            if (r2 == 0) goto L_0x000e
        L_0x001c:
            java.util.concurrent.atomic.AtomicReference<rx.android.plugins.RxAndroidSchedulersHook> r0 = r3.schedulersHook
            java.lang.Object r0 = r0.get()
            rx.android.plugins.RxAndroidSchedulersHook r0 = (rx.android.plugins.RxAndroidSchedulersHook) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.android.plugins.RxAndroidPlugins.getSchedulersHook():rx.android.plugins.RxAndroidSchedulersHook");
    }

    public void registerSchedulersHook(RxAndroidSchedulersHook rxAndroidSchedulersHook) {
        AtomicReference<RxAndroidSchedulersHook> atomicReference = this.schedulersHook;
        while (!atomicReference.compareAndSet((Object) null, rxAndroidSchedulersHook)) {
            if (atomicReference.get() != null) {
                throw new IllegalStateException("Another strategy was already registered: " + this.schedulersHook.get());
            }
        }
    }

    @Experimental
    public void reset() {
        this.schedulersHook.set((Object) null);
    }
}
