package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class Schedulers {

    /* renamed from: a  reason: collision with root package name */
    public static final Scheduler f684a = RxJavaPlugins.a(new Object());
    public static final Scheduler b = RxJavaPlugins.a(new Object());
    public static final Scheduler c = RxJavaPlugins.a(new Object());
    public static final TrampolineScheduler d = TrampolineScheduler.d;
    public static final Scheduler e = RxJavaPlugins.a(new Object());

    public static final class ComputationHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final ComputationScheduler f685a = new ComputationScheduler();
    }

    public static final class ComputationTask implements Callable<Scheduler> {
        public final Object call() {
            return ComputationHolder.f685a;
        }
    }

    public static final class IOTask implements Callable<Scheduler> {
        public final Object call() {
            return IoHolder.f686a;
        }
    }

    public static final class IoHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final IoScheduler f686a = new IoScheduler();
    }

    public static final class NewThreadHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final NewThreadScheduler f687a = new NewThreadScheduler();
    }

    public static final class NewThreadTask implements Callable<Scheduler> {
        public final Object call() {
            return NewThreadHolder.f687a;
        }
    }

    public static final class SingleHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final SingleScheduler f688a = new SingleScheduler();
    }

    public static final class SingleTask implements Callable<Scheduler> {
        public final Object call() {
            return SingleHolder.f688a;
        }
    }
}
