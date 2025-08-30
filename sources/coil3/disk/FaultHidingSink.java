package coil3.disk;

import java.io.IOException;
import kotlin.Metadata;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/disk/FaultHidingSink;", "Lokio/Sink;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FaultHidingSink implements Sink {
    public final Sink c;
    public final a d;
    public boolean e;

    public FaultHidingSink(Sink sink, a aVar) {
        this.c = sink;
        this.d = aVar;
    }

    public final void close() {
        try {
            this.c.close();
        } catch (IOException e2) {
            this.e = true;
            this.d.invoke(e2);
        }
    }

    public final void flush() {
        try {
            this.c.flush();
        } catch (IOException e2) {
            this.e = true;
            this.d.invoke(e2);
        }
    }

    public final Timeout timeout() {
        return this.c.timeout();
    }

    public final void write(Buffer buffer, long j) {
        if (this.e) {
            buffer.skip(j);
            return;
        }
        try {
            this.c.write(buffer, j);
        } catch (IOException e2) {
            this.e = true;
            this.d.invoke(e2);
        }
    }
}
