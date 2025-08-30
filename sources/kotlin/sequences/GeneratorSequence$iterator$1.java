package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010(\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"kotlin/sequences/GeneratorSequence$iterator$1", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GeneratorSequence$iterator$1 implements Iterator<Object>, KMappedMarker {
    public Object c;
    public int d = -2;
    public final /* synthetic */ GeneratorSequence e;

    public GeneratorSequence$iterator$1(GeneratorSequence generatorSequence) {
        this.e = generatorSequence;
    }

    public final void a() {
        Object obj;
        int i;
        int i2 = this.d;
        GeneratorSequence generatorSequence = this.e;
        if (i2 == -2) {
            obj = generatorSequence.f739a.invoke();
        } else {
            Function1 function1 = generatorSequence.b;
            Object obj2 = this.c;
            Intrinsics.c(obj2);
            obj = function1.invoke(obj2);
        }
        this.c = obj;
        if (obj == null) {
            i = 0;
        } else {
            i = 1;
        }
        this.d = i;
    }

    public final boolean hasNext() {
        if (this.d < 0) {
            a();
        }
        if (this.d == 1) {
            return true;
        }
        return false;
    }

    public final Object next() {
        if (this.d < 0) {
            a();
        }
        if (this.d != 0) {
            Object obj = this.c;
            Intrinsics.d(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.d = -1;
            return obj;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
