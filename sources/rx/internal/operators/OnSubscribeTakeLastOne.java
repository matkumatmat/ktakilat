package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

public final class OnSubscribeTakeLastOne<T> implements Observable.OnSubscribe<T> {
    final Observable<T> source;

    public static final class TakeLastOneSubscriber<T> extends DeferredScalarSubscriber<T, T> {
        static final Object EMPTY = new Object();

        public TakeLastOneSubscriber(Subscriber<? super T> subscriber) {
            super(subscriber);
            this.value = EMPTY;
        }

        public void onCompleted() {
            R r = this.value;
            if (r == EMPTY) {
                complete();
            } else {
                complete(r);
            }
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [R, T] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r1) {
            /*
                r0 = this;
                r0.value = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OnSubscribeTakeLastOne.TakeLastOneSubscriber.onNext(java.lang.Object):void");
        }
    }

    public OnSubscribeTakeLastOne(Observable<T> observable) {
        this.source = observable;
    }

    public void call(Subscriber<? super T> subscriber) {
        new TakeLastOneSubscriber(subscriber).subscribeTo(this.source);
    }
}
