package kotlin.io;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"kotlin/io/LinesSequence$iterator$1", "", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinesSequence$iterator$1 implements Iterator<String>, KMappedMarker {
    public String c;
    public boolean d;
    public final /* synthetic */ LinesSequence e;

    public LinesSequence$iterator$1(LinesSequence linesSequence) {
        this.e = linesSequence;
    }

    public final boolean hasNext() {
        if (this.c == null && !this.d) {
            String readLine = this.e.f712a.readLine();
            this.c = readLine;
            if (readLine == null) {
                this.d = true;
            }
        }
        if (this.c != null) {
            return true;
        }
        return false;
    }

    public final Object next() {
        if (hasNext()) {
            String str = this.c;
            this.c = null;
            Intrinsics.c(str);
            return str;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
