package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {
    public static final int l = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    public static final Object m = new Object();
    public final AtomicLong c;
    public final int d;
    public long e;
    public final int f;
    public AtomicReferenceArray g;
    public final int i;
    public AtomicReferenceArray j;
    public final AtomicLong k = new AtomicLong();

    public SpscLinkedArrayQueue(int i2) {
        AtomicLong atomicLong = new AtomicLong();
        this.c = atomicLong;
        int numberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(Math.max(8, i2) - 1));
        int i3 = numberOfLeadingZeros - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(numberOfLeadingZeros + 1);
        this.g = atomicReferenceArray;
        this.f = i3;
        this.d = Math.min(numberOfLeadingZeros / 4, l);
        this.j = atomicReferenceArray;
        this.i = i3;
        this.e = (long) (numberOfLeadingZeros - 2);
        atomicLong.lazySet(0);
    }

    public final boolean a(Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray = this.g;
        AtomicLong atomicLong = this.c;
        long j2 = atomicLong.get();
        long j3 = 2 + j2;
        int i2 = this.f;
        if (atomicReferenceArray.get(((int) j3) & i2) == null) {
            int i3 = ((int) j2) & i2;
            atomicReferenceArray.lazySet(i3 + 1, obj2);
            atomicReferenceArray.lazySet(i3, obj);
            atomicLong.lazySet(j3);
        } else {
            AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
            this.g = atomicReferenceArray2;
            int i4 = ((int) j2) & i2;
            atomicReferenceArray2.lazySet(i4 + 1, obj2);
            atomicReferenceArray2.lazySet(i4, obj);
            atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
            atomicReferenceArray.lazySet(i4, m);
            atomicLong.lazySet(j3);
        }
        return true;
    }

    public final Object b() {
        AtomicReferenceArray atomicReferenceArray = this.j;
        int i2 = (int) this.k.get();
        int i3 = this.i;
        int i4 = i2 & i3;
        Object obj = atomicReferenceArray.get(i4);
        if (obj != m) {
            return obj;
        }
        int i5 = i3 + 1;
        AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(i5);
        atomicReferenceArray.lazySet(i5, (Object) null);
        this.j = atomicReferenceArray2;
        return atomicReferenceArray2.get(i4);
    }

    public final void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final boolean isEmpty() {
        if (this.c.get() == this.k.get()) {
            return true;
        }
        return false;
    }

    public final boolean offer(Object obj) {
        if (obj != null) {
            AtomicReferenceArray atomicReferenceArray = this.g;
            AtomicLong atomicLong = this.c;
            long j2 = atomicLong.get();
            int i2 = this.f;
            int i3 = ((int) j2) & i2;
            if (j2 < this.e) {
                atomicReferenceArray.lazySet(i3, obj);
                atomicLong.lazySet(j2 + 1);
                return true;
            }
            long j3 = ((long) this.d) + j2;
            if (atomicReferenceArray.get(((int) j3) & i2) == null) {
                this.e = j3 - 1;
                atomicReferenceArray.lazySet(i3, obj);
                atomicLong.lazySet(j2 + 1);
                return true;
            }
            long j4 = j2 + 1;
            if (atomicReferenceArray.get(((int) j4) & i2) == null) {
                atomicReferenceArray.lazySet(i3, obj);
                atomicLong.lazySet(j4);
                return true;
            }
            AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
            this.g = atomicReferenceArray2;
            this.e = (j2 + ((long) i2)) - 1;
            atomicReferenceArray2.lazySet(i3, obj);
            atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
            atomicReferenceArray.lazySet(i3, m);
            atomicLong.lazySet(j4);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public final Object poll() {
        boolean z;
        AtomicReferenceArray atomicReferenceArray = this.j;
        AtomicLong atomicLong = this.k;
        long j2 = atomicLong.get();
        int i2 = this.i;
        int i3 = ((int) j2) & i2;
        Object obj = atomicReferenceArray.get(i3);
        if (obj == m) {
            z = true;
        } else {
            z = false;
        }
        if (obj != null && !z) {
            atomicReferenceArray.lazySet(i3, (Object) null);
            atomicLong.lazySet(j2 + 1);
            return obj;
        } else if (!z) {
            return null;
        } else {
            int i4 = i2 + 1;
            AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(i4);
            atomicReferenceArray.lazySet(i4, (Object) null);
            this.j = atomicReferenceArray2;
            Object obj2 = atomicReferenceArray2.get(i3);
            if (obj2 != null) {
                atomicReferenceArray2.lazySet(i3, (Object) null);
                atomicLong.lazySet(j2 + 1);
            }
            return obj2;
        }
    }
}
