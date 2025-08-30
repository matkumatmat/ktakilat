package kotlin.io.encoding;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/io/encoding/DecodeInputStream;", "Ljava/io/InputStream;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@ExperimentalEncodingApi
final class DecodeInputStream extends InputStream {
    public final void close() {
    }

    public final int read() {
        read((byte[]) null, 0, 1);
        throw null;
    }

    public final int read(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "destination");
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            StringBuilder r = e.r(i, "offset: ", i2, ", length: ", ", buffer size: ");
            r.append(bArr.length);
            throw new IndexOutOfBoundsException(r.toString());
        }
        throw new IOException("The input stream is closed.");
    }
}
