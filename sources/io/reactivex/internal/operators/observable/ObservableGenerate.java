package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableGenerate<T, S> extends Observable<T> {
    public final Callable c;
    public final BiFunction d;
    public final Consumer e;

    public static final class GeneratorDisposable<T, S> implements Emitter<T>, Disposable {
        public final Observer c;
        public final BiFunction d;
        public final Consumer e;
        public Object f;
        public volatile boolean g;
        public boolean i;

        public GeneratorDisposable(Observer observer, BiFunction biFunction, Consumer consumer, Object obj) {
            this.c = observer;
            this.d = biFunction;
            this.e = consumer;
            this.f = obj;
        }

        public final void b(Object obj) {
            try {
                this.e.accept(obj);
            } catch (Throwable th) {
                Exceptions.a(th);
                RxJavaPlugins.b(th);
            }
        }

        public final void dispose() {
            this.g = true;
        }

        public final boolean isDisposed() {
            return this.g;
        }

        public final void onError(Throwable th) {
            if (this.i) {
                RxJavaPlugins.b(th);
                return;
            }
            this.i = true;
            this.c.onError(th);
        }
    }

    public ObservableGenerate(Callable callable, BiFunction biFunction, Consumer consumer) {
        this.c = callable;
        this.d = biFunction;
        this.e = consumer;
    }

    public final void subscribeActual(Observer observer) {
        try {
            Object call = this.c.call();
            BiFunction biFunction = this.d;
            GeneratorDisposable generatorDisposable = new GeneratorDisposable(observer, biFunction, this.e, call);
            observer.onSubscribe(generatorDisposable);
            Object obj = generatorDisposable.f;
            if (generatorDisposable.g) {
                generatorDisposable.f = null;
                generatorDisposable.b(obj);
                return;
            }
            while (!generatorDisposable.g) {
                try {
                    obj = biFunction.apply(obj, generatorDisposable);
                    if (generatorDisposable.i) {
                        generatorDisposable.g = true;
                        generatorDisposable.f = null;
                        generatorDisposable.b(obj);
                        return;
                    }
                } catch (Throwable th) {
                    Exceptions.a(th);
                    generatorDisposable.f = null;
                    generatorDisposable.g = true;
                    generatorDisposable.onError(th);
                    generatorDisposable.b(obj);
                    return;
                }
            }
            generatorDisposable.f = null;
            generatorDisposable.b(obj);
        } catch (Throwable th2) {
            Exceptions.a(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
