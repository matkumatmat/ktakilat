package kotlin.io.encoding;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/io/encoding/EncodeOutputStream;", "Ljava/io/OutputStream;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@ExperimentalEncodingApi
final class EncodeOutputStream extends OutputStream {
    public final void close() {
    }

    public final void flush() {
        throw new IOException("The output stream is closed.");
    }

    public final void write(int i) {
        throw new IOException("The output stream is closed.");
    }

    public final void write(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "source");
        throw new IOException("The output stream is closed.");
    }
}
