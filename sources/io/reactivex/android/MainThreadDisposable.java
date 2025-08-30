package io.reactivex.android;

import android.os.Looper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class MainThreadDisposable implements Disposable {
    public final AtomicBoolean c = new AtomicBoolean();

    public abstract void a();

    public final void dispose() {
        if (!this.c.compareAndSet(false, true)) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            AndroidSchedulers.a().c(new Runnable() {
                public final void run() {
                    MainThreadDisposable.this.a();
                    throw null;
                }
            });
        } else {
            a();
            throw null;
        }
    }

    public final boolean isDisposed() {
        return this.c.get();
    }
}
