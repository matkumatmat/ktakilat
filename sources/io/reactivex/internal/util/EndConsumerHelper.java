package io.reactivex.internal.util;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class EndConsumerHelper {
    public static void a(Class cls) {
        String name = cls.getName();
        RxJavaPlugins.b(new ProtocolViolationException(e.o("It is not allowed to subscribe with a(n) ", name, " multiple times. Please create a fresh instance of ", name, " and subscribe that to the target source instead.")));
    }

    public static void b(AtomicReference atomicReference, Disposable disposable, Class cls) {
        ObjectHelper.b(disposable, "next is null");
        while (!atomicReference.compareAndSet((Object) null, disposable)) {
            if (atomicReference.get() != null) {
                disposable.dispose();
                if (atomicReference.get() != DisposableHelper.DISPOSED) {
                    a(cls);
                    return;
                }
                return;
            }
        }
    }

    public static boolean c(AtomicReference atomicReference, Subscription subscription, Class cls) {
        ObjectHelper.b(subscription, "next is null");
        while (!atomicReference.compareAndSet((Object) null, subscription)) {
            if (atomicReference.get() != null) {
                subscription.cancel();
                if (atomicReference.get() == SubscriptionHelper.CANCELLED) {
                    return false;
                }
                a(cls);
                return false;
            }
        }
        return true;
    }
}
