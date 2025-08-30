package io.reactivex.internal.queue;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements SimplePlainQueue<E> {
    public static final Integer i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;
    public final int c = (length() - 1);
    public final AtomicLong d = new AtomicLong();
    public long e;
    public final AtomicLong f = new AtomicLong();
    public final int g;

    public SpscArrayQueue(int i2) {
        super(1 << (32 - Integer.numberOfLeadingZeros(i2 - 1)));
        this.g = Math.min(i2 / 4, i.intValue());
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public boolean isEmpty() {
        if (this.d.get() == this.f.get()) {
            return true;
        }
        return false;
    }

    public boolean offer(E e2) {
        if (e2 != null) {
            AtomicLong atomicLong = this.d;
            long j = atomicLong.get();
            int i2 = this.c;
            int i3 = ((int) j) & i2;
            if (j >= this.e) {
                long j2 = ((long) this.g) + j;
                if (get(i2 & ((int) j2)) == null) {
                    this.e = j2;
                } else if (get(i3) != null) {
                    return false;
                }
            }
            lazySet(i3, e2);
            atomicLong.lazySet(j + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Nullable
    public E poll() {
        AtomicLong atomicLong = this.f;
        long j = atomicLong.get();
        int i2 = ((int) j) & this.c;
        E e2 = get(i2);
        if (e2 == null) {
            return null;
        }
        atomicLong.lazySet(j + 1);
        lazySet(i2, (Object) null);
        return e2;
    }

    public boolean offer(E e2, E e3) {
        return offer(e2) && offer(e3);
    }
}
