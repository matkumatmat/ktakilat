package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

public final class OperatorElementAt<T> implements Observable.Operator<T, T> {
    final T defaultValue;
    final boolean hasDefault;
    final int index;

    public static class InnerProducer extends AtomicBoolean implements Producer {
        private static final long serialVersionUID = 1;
        final Producer actual;

        public InnerProducer(Producer producer) {
            this.actual = producer;
        }

        public void request(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            } else if (i > 0 && compareAndSet(false, true)) {
                this.actual.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }
    }

    public OperatorElementAt(int i) {
        this(i, (Object) null, false);
    }

    public OperatorElementAt(int i, T t) {
        this(i, t, true);
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        AnonymousClass1 r0 = new Subscriber<T>() {
            private int currentIndex;

            public void onCompleted() {
                int i = this.currentIndex;
                OperatorElementAt operatorElementAt = OperatorElementAt.this;
                if (i > operatorElementAt.index) {
                    return;
                }
                if (operatorElementAt.hasDefault) {
                    subscriber.onNext(operatorElementAt.defaultValue);
                    subscriber.onCompleted();
                    return;
                }
                subscriber.onError(new IndexOutOfBoundsException(ba.q(new StringBuilder(), " is out of bounds", OperatorElementAt.this.index)));
            }

            public void onError(Throwable th) {
                subscriber.onError(th);
            }

            public void onNext(T t) {
                int i = this.currentIndex;
                this.currentIndex = i + 1;
                if (i == OperatorElementAt.this.index) {
                    subscriber.onNext(t);
                    subscriber.onCompleted();
                    unsubscribe();
                }
            }

            public void setProducer(Producer producer) {
                subscriber.setProducer(new InnerProducer(producer));
            }
        };
        subscriber.add(r0);
        return r0;
    }

    private OperatorElementAt(int i, T t, boolean z) {
        if (i >= 0) {
            this.index = i;
            this.defaultValue = t;
            this.hasDefault = z;
            return;
        }
        throw new IndexOutOfBoundsException(i + " is out of bounds");
    }
}
