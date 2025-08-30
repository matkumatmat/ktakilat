package coil3.fetch;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import okio.Buffer;
import okio.Source;
import okio.Timeout;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"coil3/fetch/ByteBufferFetcherKt$asSource$1", "Lokio/Source;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ByteBufferFetcherKt$asSource$1 implements Source {
    public final ByteBuffer c;
    public final int d;

    public ByteBufferFetcherKt$asSource$1(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        this.c = slice;
        this.d = slice.capacity();
    }

    public final void close() {
    }

    public final long read(Buffer buffer, long j) {
        ByteBuffer byteBuffer = this.c;
        int position = byteBuffer.position();
        int i = this.d;
        if (position == i) {
            return -1;
        }
        int position2 = (int) (((long) byteBuffer.position()) + j);
        if (position2 <= i) {
            i = position2;
        }
        byteBuffer.limit(i);
        return (long) buffer.write(byteBuffer);
    }

    public final Timeout timeout() {
        return Timeout.NONE;
    }
}
