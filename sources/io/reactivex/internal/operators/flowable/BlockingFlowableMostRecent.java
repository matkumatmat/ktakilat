package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subscribers.DefaultSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class BlockingFlowableMostRecent<T> implements Iterable<T> {

    public static final class MostRecentSubscriber<T> extends DefaultSubscriber<T> {
        public volatile Object d;

        public final class Iterator implements java.util.Iterator<T> {
            public Object c;

            public final boolean hasNext() {
                throw null;
            }

            public final Object next() {
                try {
                    if (this.c == null) {
                        throw null;
                    } else if (NotificationLite.isComplete(this.c)) {
                        throw new NoSuchElementException();
                    } else if (!NotificationLite.isError(this.c)) {
                        return NotificationLite.getValue(this.c);
                    } else {
                        throw ExceptionHelper.c(NotificationLite.getError(this.c));
                    }
                } finally {
                    this.c = null;
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

    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.internal.operators.flowable.BlockingFlowableMostRecent$MostRecentSubscriber, java.lang.Object] */
    public final Iterator iterator() {
        new Object().d = NotificationLite.next(null);
        throw null;
    }
}
