package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableOperator;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableLift<R, T> extends AbstractObservableWithUpstream<T, R> {
    public final ObservableOperator d;

    public ObservableLift(Observable observable, ObservableOperator observableOperator) {
        super(observable);
        this.d = observableOperator;
    }

    public final void subscribeActual(Observer observer) {
        ObservableOperator observableOperator = this.d;
        try {
            Observer apply = observableOperator.apply();
            ObjectHelper.b(apply, "Operator " + observableOperator + " returned a null Observer");
            this.c.subscribe(apply);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.a(th);
            RxJavaPlugins.b(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
