package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DefaultObserver;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class BlockingObservableMostRecent<T> implements Iterable<T> {
    public final Observable c;
    public final Object d;

    public static final class MostRecentObserver<T> extends DefaultObserver<T> {
        public volatile Object d;

        public final class Iterator implements java.util.Iterator<T> {
            public Object c;

            public Iterator() {
            }

            public final boolean hasNext() {
                Object obj = MostRecentObserver.this.d;
                this.c = obj;
                return !NotificationLite.isComplete(obj);
            }

            public final Object next() {
                try {
                    if (this.c == null) {
                        this.c = MostRecentObserver.this.d;
                    }
                    if (NotificationLite.isComplete(this.c)) {
                        throw new NoSuchElementException();
                    } else if (!NotificationLite.isError(this.c)) {
                        Object value = NotificationLite.getValue(this.c);
                        this.c = null;
                        return value;
                    } else {
                        throw ExceptionHelper.c(NotificationLite.getError(this.c));
                    }
                } catch (Throwable th) {
                    this.c = null;
                    throw th;
                }
            }

            public final void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        public final void onComplete() {
            this.d = NotificationLite.complete();
        }

        public final void onError(Throwable th) {
            this.d = NotificationLite.error(th);
        }

        public final void onNext(Object obj) {
            this.d = NotificationLite.next(obj);
        }
    }

    public BlockingObservableMostRecent(Observable observable, Object obj) {
        this.c = observable;
        this.d = obj;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.Observer, java.lang.Object, io.reactivex.internal.operators.observable.BlockingObservableMostRecent$MostRecentObserver] */
    public final Iterator iterator() {
        Object obj = this.d;
        ? obj2 = new Object();
        obj2.d = NotificationLite.next(obj);
        this.c.subscribe(obj2);
        return new MostRecentObserver.Iterator();
    }
}
