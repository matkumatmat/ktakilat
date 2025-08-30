package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"kotlin/collections/RingBuffer$iterator$1", "Lkotlin/collections/AbstractIterator;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSlidingWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer$iterator$1\n+ 2 SlidingWindow.kt\nkotlin/collections/RingBuffer\n*L\n1#1,206:1\n204#2:207\n*S KotlinDebug\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer$iterator$1\n*L\n121#1:207\n*E\n"})
public final class RingBuffer$iterator$1 extends AbstractIterator<Object> {
    public int e;
    public int f = 0;
    public final /* synthetic */ RingBuffer g;

    public RingBuffer$iterator$1(RingBuffer ringBuffer) {
        this.g = ringBuffer;
        this.e = ringBuffer.size();
    }

    public final void a() {
        if (this.e == 0) {
            this.c = 2;
        } else {
            this.g.getClass();
            throw null;
        }
    }
}
