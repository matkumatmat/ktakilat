package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.SingleSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import java.util.concurrent.Callable;

@Experimental
final class ScalarXMapZHelper {
    public static boolean a(Object obj, Function function, CompletableObserver completableObserver) {
        CompletableSource completableSource;
        if (!(obj instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) obj).call();
            if (call != null) {
                Object apply = function.apply(call);
                ObjectHelper.b(apply, "The mapper returned a null CompletableSource");
                completableSource = (CompletableSource) apply;
            } else {
                completableSource = null;
            }
            if (completableSource == null) {
                EmptyDisposable.complete(completableObserver);
            } else {
                completableSource.b(completableObserver);
            }
            return true;
        } catch (Throwable th) {
            Exceptions.a(th);
            EmptyDisposable.error(th, completableObserver);
            return true;
        }
    }

    public static boolean b(Object obj, Function function, Observer observer) {
        MaybeSource maybeSource;
        if (!(obj instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) obj).call();
            if (call != null) {
                Object apply = function.apply(call);
                ObjectHelper.b(apply, "The mapper returned a null MaybeSource");
                maybeSource = (MaybeSource) apply;
            } else {
                maybeSource = null;
            }
            if (maybeSource == null) {
                EmptyDisposable.complete((Observer<?>) observer);
            } else {
                maybeSource.b(MaybeToObservable.c(observer));
            }
            return true;
        } catch (Throwable th) {
            Exceptions.a(th);
            EmptyDisposable.error(th, (Observer<?>) observer);
            return true;
        }
    }

    public static boolean c(Object obj, Function function, Observer observer) {
        SingleSource singleSource;
        if (!(obj instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) obj).call();
            if (call != null) {
                Object apply = function.apply(call);
                ObjectHelper.b(apply, "The mapper returned a null SingleSource");
                singleSource = (SingleSource) apply;
            } else {
                singleSource = null;
            }
            if (singleSource == null) {
                EmptyDisposable.complete((Observer<?>) observer);
            } else {
                singleSource.b(SingleToObservable.c(observer));
            }
            return true;
        } catch (Throwable th) {
            Exceptions.a(th);
            EmptyDisposable.error(th, (Observer<?>) observer);
            return true;
        }
    }
}
