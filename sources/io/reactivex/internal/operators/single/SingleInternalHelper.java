package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;

public final class SingleInternalHelper {

    public enum NoSuchElementCallable implements Callable<NoSuchElementException> {
        ;

        public final Object call() {
            return new NoSuchElementException();
        }
    }

    public enum ToFlowable implements Function<SingleSource, Publisher> {
        ;

        public final Object apply(Object obj) {
            return new SingleToFlowable((SingleSource) obj);
        }
    }

    public static final class ToFlowableIterable<T> implements Iterable<Flowable<T>> {
        public final Iterator iterator() {
            throw null;
        }
    }

    public static final class ToFlowableIterator<T> implements Iterator<Flowable<T>> {
        public final boolean hasNext() {
            throw null;
        }

        public final Object next() {
            throw null;
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public enum ToObservable implements Function<SingleSource, Observable> {
        ;

        public final Object apply(Object obj) {
            return new SingleToObservable((SingleSource) obj);
        }
    }
}
