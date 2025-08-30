package coil3.decode;

import java.io.InputStream;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/decode/ExifInterfaceInputStream;", "Ljava/io/InputStream;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ExifInterfaceInputStream extends InputStream {
    public final InputStream c;
    public int d = 1073741824;

    public ExifInterfaceInputStream(InputStream inputStream) {
        this.c = inputStream;
    }

    public final int available() {
        return this.d;
    }

    public final void close() {
        this.c.close();
    }

    public final int read() {
        int read = this.c.read();
        if (read == -1) {
            this.d = 0;
        }
        return read;
    }

    public final long skip(long j) {
        return this.c.skip(j);
    }

    public final int read(byte[] bArr) {
        int read = this.c.read(bArr);
        if (read == -1) {
            this.d = 0;
        }
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        int read = this.c.read(bArr, i, i2);
        if (read == -1) {
            this.d = 0;
        }
        return read;
    }
}
