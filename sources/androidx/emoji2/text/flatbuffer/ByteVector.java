package androidx.emoji2.text.flatbuffer;

import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;

public final class ByteVector extends BaseVector {
    public ByteVector __assign(int i, ByteBuffer byteBuffer) {
        __reset(i, 1, byteBuffer);
        return this;
    }

    public byte get(int i) {
        return this.bb.get(__element(i));
    }

    public int getAsUnsigned(int i) {
        return get(i) & UnsignedBytes.MAX_VALUE;
    }
}
