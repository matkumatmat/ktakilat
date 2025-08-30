package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

@SuppressAnimalSniffer
abstract class SpmcArrayQueueProducerField<E> extends SpmcArrayQueueL1Pad<E> {
    protected static final long P_INDEX_OFFSET = UnsafeAccess.addressOf(SpmcArrayQueueProducerField.class, "producerIndex");
    private volatile long producerIndex;

    public SpmcArrayQueueProducerField(int i) {
        super(i);
    }

    public final long lvProducerIndex() {
        return this.producerIndex;
    }

    public final void soTail(long j) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, j);
    }
}
