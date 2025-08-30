package com.trello.rxlifecycle2;

import io.reactivex.CompletableTransformer;
import io.reactivex.FlowableTransformer;
import io.reactivex.MaybeTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.SingleTransformer;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class LifecycleTransformer<T> implements ObservableTransformer<T, T>, FlowableTransformer<T, T>, SingleTransformer<T, T>, MaybeTransformer<T, T>, CompletableTransformer {

    /* renamed from: a  reason: collision with root package name */
    public final Observable f644a;

    public LifecycleTransformer(Observable observable) {
        if (observable != null) {
            this.f644a = observable;
            return;
        }
        throw new NullPointerException("observable == null");
    }

    public final ObservableSource a(Observable observable) {
        return observable.takeUntil(this.f644a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || LifecycleTransformer.class != obj.getClass()) {
            return false;
        }
        return this.f644a.equals(((LifecycleTransformer) obj).f644a);
    }

    public final int hashCode() {
        return this.f644a.hashCode();
    }

    public final String toString() {
        return "LifecycleTransformer{observable=" + this.f644a + '}';
    }
}
