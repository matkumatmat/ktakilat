package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Subscriber;
import rx.functions.Func1;
import rx.internal.util.UtilityFunctions;

public final class BackpressureUtils {
    static final long COMPLETED_MASK = Long.MIN_VALUE;
    static final long REQUESTED_MASK = Long.MAX_VALUE;

    private BackpressureUtils() {
        throw new IllegalStateException("No instances!");
    }

    public static long addCap(long j, long j2) {
        long j3 = j + j2;
        if (j3 < 0) {
            return Long.MAX_VALUE;
        }
        return j3;
    }

    public static long getAndAddRequest(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j2, addCap(j2, j)));
        return j2;
    }

    public static long multiplyCap(long j, long j2) {
        long j3 = j * j2;
        if (((j | j2) >>> 31) == 0 || j2 == 0 || j3 / j2 == j) {
            return j3;
        }
        return Long.MAX_VALUE;
    }

    public static <T> void postCompleteDone(AtomicLong atomicLong, Queue<T> queue, Subscriber<? super T> subscriber) {
        postCompleteDone(atomicLong, queue, subscriber, UtilityFunctions.identity());
    }

    public static <T, R> void postCompleteDrain(AtomicLong atomicLong, Queue<T> queue, Subscriber<? super R> subscriber, Func1<? super T, ? extends R> func1) {
        long j = atomicLong.get();
        if (j == Long.MAX_VALUE) {
            while (!subscriber.isUnsubscribed()) {
                T poll = queue.poll();
                if (poll == null) {
                    subscriber.onCompleted();
                    return;
                }
                subscriber.onNext(func1.call(poll));
            }
            return;
        }
        do {
            long j2 = Long.MIN_VALUE;
            while (true) {
                int i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i == 0) {
                    if (i == 0) {
                        if (!subscriber.isUnsubscribed()) {
                            if (queue.isEmpty()) {
                                subscriber.onCompleted();
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    j = atomicLong.get();
                    if (j == j2) {
                        j = atomicLong.addAndGet(-(j2 & Long.MAX_VALUE));
                    }
                } else if (!subscriber.isUnsubscribed()) {
                    T poll2 = queue.poll();
                    if (poll2 == null) {
                        subscriber.onCompleted();
                        return;
                    } else {
                        subscriber.onNext(func1.call(poll2));
                        j2++;
                    }
                } else {
                    return;
                }
            }
        } while (j != COMPLETED_MASK);
    }

    public static <T> boolean postCompleteRequest(AtomicLong atomicLong, long j, Queue<T> queue, Subscriber<? super T> subscriber) {
        return postCompleteRequest(atomicLong, j, queue, subscriber, UtilityFunctions.identity());
    }

    public static long produced(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j2 = atomicLong.get();
            if (j2 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j3 = j2 - j;
            if (j3 < 0) {
                throw new IllegalStateException(e.j(j3, "More produced than requested: "));
            }
        } while (!atomicLong.compareAndSet(j2, j3));
        return j3;
    }

    public static boolean validate(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException(e.j(j, "n >= 0 required but it was "));
        } else if (i != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static <T, R> void postCompleteDone(AtomicLong atomicLong, Queue<T> queue, Subscriber<? super R> subscriber, Func1<? super T, ? extends R> func1) {
        long j;
        do {
            j = atomicLong.get();
            if ((j & COMPLETED_MASK) != 0) {
                return;
            }
        } while (!atomicLong.compareAndSet(j, COMPLETED_MASK | j));
        if (j != 0) {
            postCompleteDrain(atomicLong, queue, subscriber, func1);
        }
    }

    public static <T, R> boolean postCompleteRequest(AtomicLong atomicLong, long j, Queue<T> queue, Subscriber<? super R> subscriber, Func1<? super T, ? extends R> func1) {
        long j2;
        long j3;
        AtomicLong atomicLong2 = atomicLong;
        long j4 = j;
        int i = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException(e.j(j4, "n >= 0 required but it was "));
        } else if (i == 0) {
            return (atomicLong.get() & COMPLETED_MASK) == 0;
        } else {
            while (true) {
                j2 = atomicLong.get();
                j3 = j2 & COMPLETED_MASK;
                if (atomicLong2.compareAndSet(j2, addCap(Long.MAX_VALUE & j2, j4) | j3)) {
                    break;
                }
                Queue<T> queue2 = queue;
                Subscriber<? super R> subscriber2 = subscriber;
                Func1<? super T, ? extends R> func12 = func1;
            }
            if (j2 == COMPLETED_MASK) {
                postCompleteDrain(atomicLong2, queue, subscriber, func1);
                return false;
            } else if (j3 == 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}
