package io.reactivex.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.Scheduler;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;

public final class AndroidSchedulers {

    /* renamed from: a  reason: collision with root package name */
    public static final Scheduler f658a;

    /* renamed from: io.reactivex.android.schedulers.AndroidSchedulers$1  reason: invalid class name */
    public static class AnonymousClass1 implements Callable<Scheduler> {
        public final Object call() {
            return MainHolder.f659a;
        }
    }

    public static final class MainHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final Scheduler f659a = new HandlerScheduler(new Handler(Looper.getMainLooper()));
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.android.schedulers.AndroidSchedulers$1, java.lang.Object] */
    static {
        try {
            Scheduler scheduler = (Scheduler) new Object().call();
            if (scheduler != null) {
                f658a = scheduler;
                return;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw ExceptionHelper.c(th);
        }
    }

    public static Scheduler a() {
        Scheduler scheduler = f658a;
        if (scheduler != null) {
            return scheduler;
        }
        throw new NullPointerException("scheduler == null");
    }
}
