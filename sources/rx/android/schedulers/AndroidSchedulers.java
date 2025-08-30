package rx.android.schedulers;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.annotations.Experimental;

public final class AndroidSchedulers {
    private static final AtomicReference<AndroidSchedulers> INSTANCE = new AtomicReference<>();
    private final Scheduler mainThreadScheduler;

    private AndroidSchedulers() {
        Scheduler mainThreadScheduler2 = RxAndroidPlugins.getInstance().getSchedulersHook().getMainThreadScheduler();
        if (mainThreadScheduler2 != null) {
            this.mainThreadScheduler = mainThreadScheduler2;
        } else {
            this.mainThreadScheduler = new LooperScheduler(Looper.getMainLooper());
        }
    }

    public static Scheduler from(Looper looper) {
        if (looper != null) {
            return new LooperScheduler(looper);
        }
        throw new NullPointerException("looper == null");
    }

    private static AndroidSchedulers getInstance() {
        while (true) {
            AtomicReference<AndroidSchedulers> atomicReference = INSTANCE;
            AndroidSchedulers androidSchedulers = atomicReference.get();
            if (androidSchedulers != null) {
                return androidSchedulers;
            }
            AndroidSchedulers androidSchedulers2 = new AndroidSchedulers();
            while (true) {
                if (atomicReference.compareAndSet((Object) null, androidSchedulers2)) {
                    return androidSchedulers2;
                }
                if (atomicReference.get() != null) {
                }
            }
        }
    }

    public static Scheduler mainThread() {
        return getInstance().mainThreadScheduler;
    }

    @Experimental
    public static void reset() {
        INSTANCE.set((Object) null);
    }
}
