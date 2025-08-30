package io.reactivex.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.VolatileSizeArrayList;
import io.reactivex.observers.BaseTestConsumer;
import java.util.concurrent.CountDownLatch;

public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> implements Disposable {
    public final CountDownLatch c = new CountDownLatch(1);
    public final VolatileSizeArrayList d = new VolatileSizeArrayList();
    public final VolatileSizeArrayList e = new VolatileSizeArrayList();
    public boolean f;

    public enum TestWaitStrategy implements Runnable {
        ;

        public abstract void run();
    }
}
