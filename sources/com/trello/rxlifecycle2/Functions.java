package com.trello.rxlifecycle2;

import io.reactivex.Completable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.operators.completable.CompletableError;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CancellationException;

final class Functions {

    /* renamed from: com.trello.rxlifecycle2.Functions$1  reason: invalid class name */
    public static class AnonymousClass1 implements Function<Throwable, Boolean> {
        public final Object apply(Object obj) {
            Throwable th = (Throwable) obj;
            if (th instanceof OutsideLifecycleException) {
                return Boolean.TRUE;
            }
            throw ExceptionHelper.c(th);
        }
    }

    /* renamed from: com.trello.rxlifecycle2.Functions$2  reason: invalid class name */
    public static class AnonymousClass2 implements Predicate<Boolean> {
        public final boolean test(Object obj) {
            return ((Boolean) obj).booleanValue();
        }
    }

    /* renamed from: com.trello.rxlifecycle2.Functions$3  reason: invalid class name */
    public static class AnonymousClass3 implements Function<Object, Completable> {
        public final Object apply(Object obj) {
            return new CompletableError(new CancellationException());
        }
    }
}
