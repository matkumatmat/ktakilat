package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Call;
import retrofit2.Response;

final class CallExecuteObservable<T> extends Observable<Response<T>> {
    private final Call<T> originalCall;

    public static final class CallDisposable implements Disposable {
        private final Call<?> call;
        private volatile boolean disposed;

        public CallDisposable(Call<?> call2) {
            this.call = call2;
        }

        public void dispose() {
            this.disposed = true;
            this.call.cancel();
        }

        public boolean isDisposed() {
            return this.disposed;
        }
    }

    public CallExecuteObservable(Call<T> call) {
        this.originalCall = call;
    }

    public void subscribeActual(Observer<? super Response<T>> observer) {
        boolean z;
        Call<T> clone = this.originalCall.clone();
        CallDisposable callDisposable = new CallDisposable(clone);
        observer.onSubscribe(callDisposable);
        if (!callDisposable.isDisposed()) {
            try {
                Response<T> execute = clone.execute();
                if (!callDisposable.isDisposed()) {
                    observer.onNext(execute);
                }
                if (!callDisposable.isDisposed()) {
                    try {
                        observer.onComplete();
                    } catch (Throwable th) {
                        th = th;
                        z = true;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                z = false;
                Exceptions.a(th);
                if (z) {
                    RxJavaPlugins.b(th);
                } else if (!callDisposable.isDisposed()) {
                    try {
                        observer.onError(th);
                    } catch (Throwable th3) {
                        Exceptions.a(th3);
                        RxJavaPlugins.b(new CompositeException(th, th3));
                    }
                }
            }
        }
    }
}
